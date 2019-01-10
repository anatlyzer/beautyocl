package beautyocl.atl.evaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import anatlyzer.atl.analyser.AnalysisResult;
import anatlyzer.atl.analyser.inc.IncrementalCopyBasedAnalyser;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.editor.quickfix.AbstractAtlQuickfix;
import anatlyzer.atl.editor.quickfix.AtlProblemQuickfix;
import anatlyzer.atl.editor.quickfix.GeneratePrecondition;
import anatlyzer.atl.editor.quickfix.SpeculativeQuickfixUtils;
import anatlyzer.atl.editor.witness.EclipseUseWitnessFinder;
import anatlyzer.atl.errors.Problem;
import anatlyzer.atl.errors.ProblemStatus;
import anatlyzer.atl.errors.atl_error.AccessToUndefinedValue;
import anatlyzer.atl.errors.atl_error.BindingPossiblyUnresolved;
import anatlyzer.atl.errors.atl_error.BindingWithResolvedByIncompatibleRule;
import anatlyzer.atl.errors.atl_error.BindingWithoutRule;
import anatlyzer.atl.quickfixast.InDocumentSerializer;
import anatlyzer.atl.quickfixast.QuickfixApplication.Action;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atl.witness.IWitnessFinder;
import anatlyzer.experiments.extensions.IExperiment;
import anatlyzer.experiments.typing.AbstractATLExperiment;
import anatlyzer.experiments.typing.QuickfixEvaluationAbstract;
import anatlyzer.experiments.typing.QuickfixEvaluationAbstract.AppliedQuickfixInfo;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.actions.MatchPhase.Match;
import beautyocl.atl.anatlyzer.simplifier.BeautyOCLAnatlyzer;
import beautyocl.atl.evaluation.export.ExportToExcel;
import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEProblem;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BESimplification;
import beautyocl.atl.evaluation.raw.BETransformation;

public class SimplifyQuickfixesExperiment extends AbstractSimplifyExperiment {

	protected static final String ORIGINAL_RESOURCE = "ORIGINAL_RESOURCE";
	
	@Override
	public void printResult(PrintStream out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canExportToExcel() {
		return true;
	}

	private PrintWriter writer;
	
	public SimplifyQuickfixesExperiment() {
		try {
			AbstractSimplificable.resetCounter();
			writer = new PrintWriter(new File("/tmp/qfx.log"));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		writer.close();
	}
	
 	List<AnalyserData> allData = new ArrayList<AnalyserData>();
 	BEData expData = new BEData();

	@Override
	protected void perform(IResource resource) {
		perform(resource, new NullProgressMonitor());
	}

	@Override
	public void perform(IResource resource, IProgressMonitor monitor) {
		AnalyserData data;
		try {
			data = executeAnalyser(resource);
			if ( data == null )
				return;
			
			allData.add(data);
			
			BETransformation trafo = new BETransformation();
			trafo.setName(resource.getName());
			trafo.setPath(resource.getFullPath().toOSString());
			expData.addTransformation(trafo);
			
			List<Problem> allProblems = selectProblems(data);
			for (Problem p : allProblems) {
				if ( monitor.isCanceled() ) {
					return;
				}
				
				BEProblem expProblem = new BEProblem(p);
				
				List<AtlProblemQuickfix> quickfixes = QuickfixEvaluationAbstract.getQuickfixes(p, data);
			
				
				for (AtlProblemQuickfix quickfix : quickfixes) {
					if ( monitor != null && monitor.isCanceled() )
						return;

					if ( ! (quickfix instanceof AbstractAtlQuickfix ) ) 
						continue;
					
					if ( ! isInterestingQuickfix(quickfix) ) {
						continue;
					}
					
					BEQuickfix expQfx = new BEQuickfix();
					System.out.println("Qfx id: " + expQfx.getExpId());
					expQfx.setName(quickfix.getClass().getSimpleName());
					try {
						expQfx.setDescription(quickfix.getDisplayString());
					} catch ( Exception e ) { 
						expQfx.setDescription(e.getMessage());
					}
					
					try {
						applyQuickfix(quickfix, resource, p, data, expQfx);
					} catch ( Exception e ) {
						writer.append("ERROR: \n" + "  " + resource.getFullPath().toOSString() + "\n   " + p + "\n   " + quickfix.getDisplayString());						
						e.printStackTrace(writer);
						printMessage("ERROR when applying qfx: " + quickfix.getClass().getSimpleName() + " . File: " + resource.getName() + e.getMessage());
						// TODO: Register the error in the raw experiment DOM
						continue;
					}

					expProblem.addQuickfix(expQfx);

				}
				
				if ( getOnlyRelevantTransformations() == false || expProblem.getQuickfixes().size() > 0 )
					trafo.addProblem(expProblem);

			}
			
		} catch (Exception e) {
			writer.append("ERROR: \n" + "  " + resource.getFullPath().toOSString());
			e.printStackTrace(writer);

			printMessage("Error " + resource.getName() + e.getMessage());
			// counting.addError(resource.getName(), e);
//			e.printStackTrace();
			// throw new RuntimeException(e);
		}
		
		writer.flush();
		
	}

	private boolean isInterestingQuickfix(AtlProblemQuickfix quickfix) {
		if ( quickfix.isMetamodelChanging() )
			return false;
		
		// Filtering operations typically generate interesting expressions
		if ( quickfix.getClass().getName().contains("Filter") )
			return true;
		
		if ( quickfix instanceof GeneratePrecondition ) {
			return true;
		}
		
		return false;
	}
	
	private boolean isInterestingProblem(Problem p) {
		if ( p instanceof BindingWithResolvedByIncompatibleRule )
			return true;

		if ( p instanceof BindingWithoutRule ) {
			return true;
		}
		
		if ( p instanceof BindingPossiblyUnresolved )
			return true;

		if ( p instanceof AccessToUndefinedValue )
			return true;

		return false;
	}


	protected AppliedQuickfixInfo applyQuickfix(AtlProblemQuickfix quickfix, IResource resource, Problem p, AnalyserData original, BEQuickfix expQfx) throws IOException, CoreException, Exception {
		quickfix.setData(ORIGINAL_RESOURCE, resource);
		
		// Run the incremental analyser
		AnalysisResult newResult = runSpeculativeAnalysis_noSolver(quickfix, p, original, expQfx);
		
		return null;
	}
	
	protected AnalysisResult runSpeculativeAnalysis_noSolver(
			AtlProblemQuickfix quickfix, Problem p, AnalyserData original, BEQuickfix expQfx) {
		IncrementalCopyBasedAnalyser inc = SpeculativeQuickfixUtils.createIncrementalAnalyser(original, p, quickfix, (inc_, qfa) -> {
			qfa.apply();
			List<Action> actions = qfa.getActions();
			Action a = actions.get(0);
			
			Action actualAction = InDocumentSerializer.getActualAction(a);
			EObject targetExpression = actualAction.getTgt();
			
			expQfx.setOriginalExpression(ATLSerializer.serialize(targetExpression));
			expQfx.setOriginalNumNodes(countNodes(targetExpression));
			
			BeautyOCLAnatlyzer simplifier = new BeautyOCLAnatlyzer();
			System.out.println("Before:\n" + ATLSerializer.serialize(targetExpression)+"\n");
			ExecutionInfo result = simplifier.simplify(original.getAnalyser(), targetExpression, new ExperimentTracer(expQfx) {
				@Override
				public boolean onError(Throwable t) {
					writer.append("SIMPLIFICATION ERROR: \n" + "  " + original.getATLModel().getMainFileLocation() + "\n   " + p + "\n   " + quickfix.getDisplayString());
					return true;
				}
			});
			System.out.println("After:\n" + ATLSerializer.serialize(result.getResult())+"\n");
			
			// TODO: Poner solo si se ha simplificado algo!
			expQfx.setFinalExpression(ATLSerializer.serialize(result.getResult()));
			expQfx.setSimplifiedNumNodes(countNodes(result.getResult()));
		});
		
		return null;
	}

	
	private List<Problem> selectProblems(AnalysisResult r) {
		List<Problem> originalProblems = r.getProblems();
		ArrayList<Problem> allProblems = new ArrayList<Problem>();
		for (Problem p : originalProblems) {
			if ( ! isInterestingProblem(p) ) {
				continue;
			}
			 
			if ( AnalyserUtils.isWitnessRequred(p) ) { 
				ProblemStatus result = createFinder().find(p, r);
				p.setStatus(result);
				
				if ( AnalyserUtils.isConfirmed(p)) {
					allProblems.add(p);
				}
			} else {
				allProblems.add(p);
			}			
		}
		return allProblems;
	}

	private IWitnessFinder createFinder() {
		return new EclipseUseWitnessFinder().			
				checkProblemsInPath(false).
				checkDiscardCause(false).
				setTimeOut(getTimeOut()).
				catchInternalErrors(true);
	}
	
	protected List<String> messages = new ArrayList<String>();

	private void printMessage(String msg) {
		System.out.println(msg);
		messages.add(msg);
	}
	
	@Override
	public void saveData(IFile expFile) {	
        String fname = createDataFileName(expFile, "qfx-data", "data");
        
		// http://www.ibm.com/developerworks/library/x-simplexobjs/
		// http://simple.sourceforge.net/download/stream/doc/examples/examples.php
		Serializer serializer = new Persister();
        File result = new File(fname);
        try {
			serializer.write(expData, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};


	@Override
	public void exportToExcel(String fileName) throws IOException {
		IFolder folder = experimentFile.getProject().getFolder("qfx-data");
		new ExportToExcel(expData).exportToExcel(folder, experimentFile); 
	}
	
	public boolean getOnlyRelevantTransformations() {
		return this.options.getOrDefault("only_trafos_with_qfxs", "true").equals("true");
	}
	

}
