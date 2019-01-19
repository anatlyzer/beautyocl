package beautyocl.atl.evaluation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.internal.resources.WorkspaceRoot;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FileSystemElement;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import anatlyzer.atl.analyser.batch.PossibleInvariantViolationNode;
import anatlyzer.atl.analyser.batch.PreconditionAnalysis;
import anatlyzer.atl.analyser.batch.PreconditionAnalysis.PreconditionIssue;
import anatlyzer.atl.analyser.batch.TargetInvariantAnalysis_SourceBased;
import anatlyzer.atl.editor.builder.AnalyserExecutor;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.errors.ProblemStatus;
import anatlyzer.atl.index.AnalysisIndex;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atl.util.AnalyserUtils.CannotLoadMetamodel;
import anatlyzer.atl.util.AnalyserUtils.PreconditionParseError;
import anatlyzer.atl.witness.IFinderStatsCollector;
import anatlyzer.atl.witness.IWitnessFinder;
import anatlyzer.atl.witness.WitnessUtil;
import anatlyzer.atlext.ATL.Helper;
import anatlyzer.atlext.ATL.ModuleElement;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.experiments.extensions.IExperiment;
import anatlyzer.ui.configuration.TransformationConfiguration;
import anatlyzer.ui.util.AtlEngineUtils;
import beautyocl.actions.ExecutionInfo;
import beautyocl.atl.anatlyzer.simplifier.BeautyOCLAnatlyzer;
import beautyocl.atl.evaluation.export.ExportToExcel;
import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEPerformanceData;
import beautyocl.atl.evaluation.raw.BEPerformanceExecution;
import beautyocl.atl.evaluation.raw.BEProblem;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BETransformation;

public class PerformanceExecutionExperiment extends AbstractFunctionalFeaturesExperiment implements IExperiment {

	protected static final String ORIGINAL_RESOURCE = "ORIGINAL_RESOURCE";
	
	
	@Override
	public void printResult(PrintStream out) {
		
	}

	@Override
	public boolean canExportToExcel() {
		return true;
	}
	
	private BEPerformanceData expPerformanceData = new BEPerformanceData();
	
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
				
				String exp = simplificable.getOriginalExpression();
				String fin = simplificable.getFinalExpression();
				
				if ( simplificable instanceof BEQuickfix ) {
					name = ((BEQuickfix) simplificable).getName();
					if ( ! name.toLowerCase().contains("precondition") ) {
						continue;
					}				
					kind = "quickfix";
				} else if ( simplificable instanceof BEInvariant ) {
					name = ((BEInvariant) simplificable).getName();
					kind = "invariant";
					
					exp = "-- @precondition\nhelper def: aPrecondition : Boolean = " + "not" + "(" + exp + ");";
					fin = "-- @precondition\nhelper def: aPrecondition : Boolean = " + "not" + "(" + fin + ");";
			
					List<Helper> preconditions = ATLUtils.getPreconditionHelpers(data.getATLModel());
					String previousPre = preconditions.stream().map(ATLSerializer::serialize).collect(Collectors.joining("\n"));
					
					exp = exp + "\n" + previousPre;
					fin = fin + "\n" + previousPre;
				}
				
				
				String trafo1 = (header.trim() + "\n" + exp).trim() + "\n";
				String trafo2 = (header.trim() + "\n" + fin).trim() + "\n";
				
				
				
				AnalyserData newTrafo1 = analyse("original", trafo1, resource);
				AnalyserData newTrafo2 = analyse("simplified", trafo2, resource);
				if ( newTrafo1 == null || newTrafo2 == null )
					continue;
				
				List<PreconditionIssue> preconditions1 = new PreconditionAnalysis(newTrafo1.getAnalyser()).perform();
				List<PreconditionIssue> preconditions2 = new PreconditionAnalysis(newTrafo2.getAnalyser()).perform();

				if ( preconditions1.size() != 1 ) {
					printMessage("Expected one precondition in " + name + "[" + resource.getName() + "] but found " + preconditions1.size());
					continue;
				}
				
				if ( preconditions2.size() != 1 ) {
					printMessage("Expected one precondition in " + name + "[" + resource.getName() + "] but found " + preconditions2.size());
					continue;
				}
				
				PreconditionIssue pre1 = preconditions1.get(0);
				PreconditionIssue pre2 = preconditions2.get(0);
				
				IFinderStatsCollector collector1 = new IFinderStatsCollector.DefaultFinderStatsCollector();
				IFinderStatsCollector collector2 = new IFinderStatsCollector.DefaultFinderStatsCollector();
				
				try {
					doModelFinding(resource, data, pre1, collector1);
					doModelFinding(resource, data, pre2, collector2);
				} catch ( Exception e ) {
					e.printStackTrace();
					printMessage(resource.getName());
					printMessage(e.getMessage());
				}
				
				
				
				System.out.println(exp);
				System.out.println("--");
				System.out.println(fin);
				System.out.println();
				
				printMessage(resource.getName() + "\n" );
				printMessage("Original: " + collector1.getSolvingTimeSeconds() + "\n");
				printMessage("Simplified: " + collector2.getSolvingTimeSeconds() + "\n");
				printMessage("\n");
				
				BEPerformanceExecution exec = new BEPerformanceExecution();
				exec.setKind(kind);
				exec.setExpId(simplificable.getExpId());
				exec.setOriginalExp(simplificable.getOriginalExpression());
				exec.setOriginalNumNodes(simplificable.getOriginalNumNodes());
				exec.setOriginalTimeNano(collector1.getSolvingTimeNanos());
				
				exec.setSimplifiedExp(simplificable.getOriginalExpression());
				exec.setSimplifiedNumNodes(simplificable.getOriginalNumNodes());
				exec.setSimplifiedTimeNano(collector2.getSolvingTimeNanos());
				
				expPerformanceData.addExecution(exec);
			}
		
		} catch (IOException | CoreException | CannotLoadMetamodel | PreconditionParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	@Override
	public void saveData(IFile expFile) {	
		String fname = createDataFileName(expFile, "performance-data", "data");
        
		// http://www.ibm.com/developerworks/library/x-simplexobjs/
		// http://simple.sourceforge.net/download/stream/doc/examples/examples.php
		Serializer serializer = new Persister();
        File result = new File(fname);
        try {
			serializer.write(expPerformanceData, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exportToExcel(String fileName) throws IOException {

	}

	
}
