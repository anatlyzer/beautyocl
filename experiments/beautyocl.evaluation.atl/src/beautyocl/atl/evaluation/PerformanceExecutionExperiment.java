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

public class PerformanceExecutionExperiment extends AbstractSimplifyExperiment implements IExperiment {

	protected static final String ORIGINAL_RESOURCE = "ORIGINAL_RESOURCE";
	
	
	@Override
	public void printResult(PrintStream out) {
		
	}

	@Override
	public boolean canExportToExcel() {
		return true;
	}
	
	@Override
	public void openData(IFile expFile) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
			    Display.getDefault().getActiveShell(), 
			    new WorkbenchLabelProvider(), 
			    new WorkbenchContentProvider() {
		            @Override
					public Object[] getChildren(Object obj) {
		            	Object[] objs = super.getChildren(obj);
		            	List<Object> selected = new ArrayList<Object>();
		            	for (Object o : objs) {						
			            	if ( o instanceof IProject ) {
			            		IProject p = (IProject) o;
			            		try {
			            			ArrayList<IResource> resources = new ArrayList<IResource>();
									p.accept(resource -> {
										if ( resource.getLocation() != null && resource.getLocation().getFileExtension() != null && resource.getLocation().getFileExtension().equals("data") ) {
											resources.add(resource);
										}									
										return true;
									});
									
									if ( resources.isEmpty() ) {
										continue;
									} 
								} catch (CoreException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									continue;
								}
			            	}
			            	selected.add(o);
		            	}
		            	
		            	return selected.toArray();
		            }
		        });
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		dialog.setInput(root);
		if ( dialog.open() == Window.OK ) {
			IFile f = (IFile) dialog.getResult()[0];
			
			Serializer serializer = new Persister();
			File source = new File(f.getLocation().toOSString());

			try {
				BEData data = serializer.read(BEData.class, source);
				this.expData = data;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		};
	}

 	BEData expData = null;
	private BEPerformanceData expPerformanceData;
 	
	@Override
	protected void perform(IResource resource) {
		perform(resource, new NullProgressMonitor());
	}

 	
	@Override
	public void perform(IResource resource, IProgressMonitor monitor) {
		if ( expData == null ) {
			expPerformanceData = new BEPerformanceData();
			
			String path = (String) options.get("datafile");
			if ( path == null )
				throw new IllegalStateException("Please, use datafile option to set the datafile to analyse");
			
			Serializer serializer = new Persister();
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			
			File source = new File(file.getLocation().toOSString());
			try {
				BEData data = serializer.read(BEData.class, source);
				this.expData = data;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		}

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

				String exp = simplificable.getOriginalExpression();
				String fin = simplificable.getFinalExpression();
				
				if ( simplificable instanceof BEQuickfix ) {
					name = ((BEQuickfix) simplificable).getName();
					if ( ! name.toLowerCase().contains("precondition") ) {
						continue;
					}					
				} else if ( simplificable instanceof BEInvariant ) {
					name = ((BEInvariant) simplificable).getName();
				
					exp = "-- @precondition\nhelper def: aPrecondition : Boolean = " + exp + ";";
					fin = "-- @precondition\nhelper def: aPrecondition : Boolean = " + fin + ";";
			
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

	private AnalyserData analyse(String kind, String trafo1, IResource r) {
		try {
			ByteArrayInputStream stream = new ByteArrayInputStream(trafo1.getBytes());
			EMFModel atlEMFModel = AtlEngineUtils.loadATLFile(null, stream, true);
			if ( atlEMFModel.getResource().getErrors().size() > 0 ) {
				printMessage("Parse error " + r.getName() + "\n");
				printMessage(kind);
				printMessage("Syntax errors:" + "\n");
				for(Diagnostic d : atlEMFModel.getResource().getErrors()) {
					printMessage(" * " + d.getMessage() + ":" + d.getLine() + ":" + d.getColumn() + "\n");
				}
				printMessage(trafo1 + "\n");
				return null;
			}
			
			ATLModel atlModel = new ATLModel(atlEMFModel.getResource());
			
			return new AnalyserExecutor().exec(null, atlModel, false);
		} catch ( Exception e ) {
			e.printStackTrace();
			printMessage("Can't analyse generated code for resource " + r.getName() + "\n");
			printMessage(e.getMessage());
			printMessage(kind + "\n" );
			printMessage(trafo1 + "\n");
			return null;
		}
	
	}

	private void doModelFinding(IResource resource, AnalyserData data, PreconditionIssue pre1,
			IFinderStatsCollector collector1) {
		
		// AnalysisIndex.getInstance().getConfiguration(resource)
		TransformationConfiguration conf = TransformationConfiguration.getDefault();
		IWitnessFinder wf = WitnessUtil.getFirstWitnessFinder(conf);
		wf.setStatsCollector(collector1);
		wf.checkDiscardCause(false);
		ProblemStatus result = wf.find(pre1, data);
		pre1.setAnalysisResult(result, wf.getFoundWitnessModel());
	}

	
	private String sanitize(String expr) {
		expr = expr.trim();
		
		Pattern p = Pattern.compile("^from.*\\((.+)\\)$");
		Matcher m = p.matcher(expr);
		if ( m.matches() ) {
			String newExpr = m.group(0);
			return newExpr;
		}
		
		Pattern p2 = Pattern.compile("^helper.+Boolean.+=(.+);$");
		Matcher m2 = p2.matcher(expr);
		if ( m2.matches() ) {
			String newExpr = m.group(0);
			return newExpr;
		}
		
		
		return expr;
	}

	private boolean isInterestingPostcondition(PossibleInvariantViolationNode postcondition) {
		return true;
	}

	private List<PossibleInvariantViolationNode> advancePostconditions (AnalyserData data) {
		TargetInvariantAnalysis_SourceBased analysis = new TargetInvariantAnalysis_SourceBased(data.getATLModel(), data.getAnalyser());
		List<PossibleInvariantViolationNode> target_invariants = analysis.perform();
		return target_invariants;
	}

	
	protected List<String> messages = new ArrayList<String>();

	private void printMessage(String msg) {
		System.out.println(msg);
		messages.add(msg);
		showMessage(msg);
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
        
//        String fname = createDataFileName(expFile, "inv-data", "data");
//        
//		// http://www.ibm.com/developerworks/library/x-simplexobjs/
//		// http://simple.sourceforge.net/download/stream/doc/examples/examples.php
//		Serializer serializer = new Persister();
//        File result = new File(fname);
//        try {
//			serializer.write(expData, result);
//			FileWriter fw = new FileWriter(new File(fname + ".txt"));
//			fw.append(buffer.toString());
//			fw.close();
//        } catch (Exception e) {
//			e.printStackTrace();
//		}
	};

	@Override
	public void exportToExcel(String fileName) throws IOException {

	}

	public static class ModuleSerializer extends ATLSerializer {
		public static String serialize(EObject obj) {
			ModuleSerializer s = new ModuleSerializer();
			s.startVisiting(obj);
			return s.g(obj);
		}
		
		@Override
		protected String serializeModuleElement(ModuleElement r) {
			return "";
		}
	}
	
	
}
