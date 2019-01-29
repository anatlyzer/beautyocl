package beautyocl.atl.evaluation;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import anatlyzer.atl.analyser.batch.PreconditionAnalysis;
import anatlyzer.atl.analyser.batch.PreconditionAnalysis.PreconditionIssue;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.errors.ProblemStatus;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atl.util.AnalyserUtils.CannotLoadMetamodel;
import anatlyzer.atl.util.AnalyserUtils.PreconditionParseError;
import anatlyzer.atl.witness.IFinderStatsCollector;
import anatlyzer.experiments.extensions.IExperiment;
import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BECorrectnessData;
import beautyocl.atl.evaluation.raw.BECorrectnessExecution;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BETransformation;

public class EquivalenceByModelFinderExperiment extends AbstractFunctionalFeaturesExperiment implements IExperiment {

	
	@Override
	public void printResult(PrintStream out) {
		
	}

	@Override
	public boolean canExportToExcel() {
		return true;
	}
	
	private BECorrectnessData expCorrectnessData = new BECorrectnessData();

	@Override
	public void perform(IResource resource, IProgressMonitor monitor) {
		loadExpDataIfNeeded();

		BETransformation found = null;
		for (BETransformation t : expData.getTransformations()) {
			if ( resource.getName().equals(t.getName()) ) {
				System.out.println("Do it " + t.getName());
				
				found = t;
				break;
			}
		}
		
		if ( found == null ) {
			printMessage("Not found in loaded data: " + resource.getFullPath());
			return;
		}

		try {
			AnalyserData data = executeAnalyser(resource);
			
			String header = ModuleSerializer.serialize(data.getATLModel().getRoot());
			
			List<BEQuickfix> qfxs = found.getProblems().stream().flatMap(p -> p.getQuickfixes().stream()).collect(Collectors.toList());
			found.getInvariants();
			
			ArrayList<AbstractSimplificable> all = new ArrayList<AbstractSimplificable>();
			all.addAll(qfxs);
			all.addAll(found.getInvariants());
			for (AbstractSimplificable simplificable : all) {
				String name = "<no-name>";
				String kind = null;
				
//				if ( simplificable.getExpId() != 11 )
//					continue;

				String exp = simplificable.getOriginalExpression();
				String fin = simplificable.getFinalExpression();
				
				String additionalHelpers = "";
				if ( simplificable instanceof BEQuickfix ) {
					name = ((BEQuickfix) simplificable).getName();
					
					String bestEffortOri = simplificable.getBestEffortVerifiableOriginalExpression();
					String bestEffortFin = simplificable.getBestEffortVerifiableFinalExpression();
					
					if ( name.toLowerCase().contains("precondition") ) {
						// It is a precondition, we are fine like this
						Pattern pattern = Pattern.compile("helper.*Boolean.?=(.+);", Pattern.DOTALL);
						Matcher matcher = pattern.matcher(exp);
						if (! matcher.find()) {
							printMessage("Can't find match for " + exp);
						}
						
						String bodyOriginal   = matcher.group(1);
						
						matcher.reset(fin);
						if (! matcher.find()) {
							printMessage("Can't find match for " + fin);
						}
						String bodySimplified = matcher.group(1);

						exp = bodyOriginal;
						fin = bodySimplified;
					} else if (bestEffortOri != null && bestEffortFin != null) {
						additionalHelpers = simplificable.getAdditionalHelpers();
						if ( additionalHelpers == null )
							additionalHelpers = "";
						exp = bestEffortOri;
						fin = bestEffortFin;
					} else {
						continue;
					}
					
					kind = "quickfix";
				} else if ( simplificable instanceof BEInvariant ) {
					name = ((BEInvariant) simplificable).getName();
					kind = "invariant";
					
					// exp and fin are expressions already
				}
				
				
				
				//Pattern pattern = Pattern.compile("helper.*=(.+);", Pattern.MULTILINE | Pattern.DOTALL);
				
								
				String evaluate = "-- @precondition\nhelper def: aPrecondition : Boolean = " 
						+ "let original : Boolean = (" + exp + ") in \n" 
						+ "let simplified : Boolean = (" + fin + ") in \n " 						
						+ "not ((original implies simplified) and (simplified implies original));" + "\n" + additionalHelpers;
				
				String trafo = (header.trim() + "\n" + evaluate).trim() + "\n";

				AnalyserData newTrafo = analyse("original", trafo, resource);
				if ( newTrafo == null ) {
					printMessage(evaluate);
					continue;
				}
				
				List<PreconditionIssue> preconditions1 = new PreconditionAnalysis(newTrafo.getAnalyser()).perform();

				if ( preconditions1.size() != 1 ) {
					printMessage("Expected one precondition in " + name + "[" + resource.getName() + "] but found " + preconditions1.size());
					continue;
				}
				
				PreconditionIssue pre1 = preconditions1.get(0);
				
				IFinderStatsCollector collector1 = new IFinderStatsCollector.DefaultFinderStatsCollector();
				
				try {
					doModelFinding(resource, newTrafo, pre1, collector1);
				} catch ( Exception e ) {
					e.printStackTrace();
					printMessage(resource.getName());
					printMessage(e.getMessage());
				}
				
				
				
//				System.out.println(exp);
//				System.out.println("--");
//				System.out.println(fin);
//				System.out.println();
				
				printMessage(resource.getName() + "\n" );
				printMessage("Original: " + collector1.getSolvingTimeSeconds() + "\n");
				printMessage("\n");
				
				BECorrectnessExecution exec = new BECorrectnessExecution();
				exec.setName(name);
				exec.setKind(kind);
				exec.setExpId(simplificable.getExpId());
				exec.setOriginalExp(simplificable.getOriginalExpression());
				exec.setSimplifiedExp(simplificable.getOriginalExpression());
				
				exec.setKind("model-finding");
				if ( AnalyserUtils.isConfirmed(pre1.getAnalysisResult()) ) {
					exec.setStatus("invalid"); // optimisation is wrong
				} else if ( AnalyserUtils.isDiscarded(pre1.getAnalysisResult()) ) {
					exec.setStatus("correct"); 
				} else {
					if ( pre1.getAnalysisResult() == ProblemStatus.USE_TIME_OUT ) {
						exec.setStatus("timeout"); 
					} else {
						exec.setStatus("validation-failure"); 
					}
				}
				
				exec.setSolvingTimeNanos(collector1.getSolvingTimeNanos());
				
				printMessage("Result: " + exec.getStatus());
				expCorrectnessData.addExecution(exec);
			}
		
		} catch (IOException | CoreException | CannotLoadMetamodel | PreconditionParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	@Override
	public void saveData(IFile expFile) {	
		String fname = createDataFileName(expFile, "correctness-data", "data");
        
		// http://www.ibm.com/developerworks/library/x-simplexobjs/
		// http://simple.sourceforge.net/download/stream/doc/examples/examples.php
		Serializer serializer = new Persister();
        File result = new File(fname);
        try {
			serializer.write(expCorrectnessData, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void exportToExcel(String fileName) throws IOException {
		
	}

	
}
