package beautyocl.atl.evaluation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import anatlyzer.atl.analyser.batch.PossibleInvariantViolationNode;
import anatlyzer.atl.analyser.batch.TargetInvariantAnalysis_SourceBased;
import anatlyzer.atl.analyser.batch.PreconditionAnalysis.PreconditionIssue;
import anatlyzer.atl.editor.builder.AnalyserExecutor;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.editor.witness.EclipseUseWitnessFinder;
import anatlyzer.atl.errors.ProblemStatus;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.witness.IFinderStatsCollector;
import anatlyzer.atl.witness.IWitnessFinder;
import anatlyzer.atl.witness.WitnessUtil;
import anatlyzer.atlext.ATL.ModuleElement;
import anatlyzer.ui.configuration.TransformationConfiguration;
import anatlyzer.ui.util.AtlEngineUtils;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEPerformanceData;

public abstract class AbstractFunctionalFeaturesExperiment extends AbstractSimplifyExperiment {

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

 	protected void loadExpDataIfNeeded() {
		if ( expData == null ) {
			
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
	}

	@Override
	protected void perform(IResource resource) {
		perform(resource, new NullProgressMonitor());
	}

	protected AnalyserData analyse(String kind, String trafo1, IResource r) {
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

	protected void doModelFinding(IResource resource, AnalyserData data, PreconditionIssue pre1,
			IFinderStatsCollector collector1) {
		
		// AnalysisIndex.getInstance().getConfiguration(resource)
		TransformationConfiguration conf = TransformationConfiguration.getDefault();
		conf.setTimeOut(getTimeOut());		
		
		int confMaxScope = getMaxScope();
		IWitnessFinder wf = new EclipseUseWitnessFinder() {
			@Override
			protected int getMaxScope() {
				return confMaxScope;
			}
		};
		WitnessUtil.configureFinder(conf, wf);

		wf.setStatsCollector(collector1);
		wf.checkDiscardCause(false);
		wf.setMaxScope(confMaxScope);
		ProblemStatus result = wf.find(pre1, data);
		pre1.setAnalysisResult(result, wf.getFoundWitnessModel());
	}

	public int getMaxScope() {
		return Integer.parseInt(((String) this.options.getOrDefault("maxScope", "5")));		
	}
	
	protected String sanitize(String expr) {
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

	protected void printMessage(String msg) {
		System.out.println(msg);
		messages.add(msg);
		showMessage(msg);
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
