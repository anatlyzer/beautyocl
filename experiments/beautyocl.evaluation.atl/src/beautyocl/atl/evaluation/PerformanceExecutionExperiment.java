package beautyocl.atl.evaluation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FileSystemElement;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import anatlyzer.atl.analyser.batch.PossibleInvariantViolationNode;
import anatlyzer.atl.analyser.batch.TargetInvariantAnalysis_SourceBased;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.AnalyserUtils.CannotLoadMetamodel;
import anatlyzer.atl.util.AnalyserUtils.PreconditionParseError;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.experiments.extensions.IExperiment;
import beautyocl.actions.ExecutionInfo;
import beautyocl.atl.anatlyzer.simplifier.BeautyOCLAnatlyzer;
import beautyocl.atl.evaluation.export.ExportToExcel;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEProblem;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BETransformation;

public class PerformanceExecutionExperiment extends AbstractSimplifyExperiment implements IExperiment {

	protected static final String ORIGINAL_RESOURCE = "ORIGINAL_RESOURCE";
	
	
	@Override
	public void printResult(PrintStream out) {
		// TODO Auto-generated method stub
		
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
 	
	@Override
	protected void perform(IResource resource) {
		perform(resource, new NullProgressMonitor());
	}

 	
	@Override
	public void perform(IResource resource, IProgressMonitor monitor) {
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

		BETransformation found = null;
		for (BETransformation t : expData.getTransformations()) {
			if ( resource.getName().equals(t.getName()) ) {
				System.out.println("Do it " + t.getName());
				
				found = t;
				break;
			}
		}
		
		if ( found == null )
			return;
		

		try {
			AnalyserData data = executeAnalyser(resource);
			
			List<BEQuickfix> qfxs = found.getProblems().stream().flatMap(p -> p.getQuickfixes().stream()).collect(Collectors.toList());
			for (BEQuickfix qfx : qfxs) {
				String exp = sanitize(qfx.getOriginalExpression());
				String fin = sanitize(qfx.getFinalExpression());
			
			
				System.out.println(exp);
				System.out.println("--");
				System.out.println(fin);
				System.out.println();
			}
		
		} catch (IOException | CoreException | CannotLoadMetamodel | PreconditionParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
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
	}
	
	@Override
	public void saveData(IFile expFile) {	
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

}
