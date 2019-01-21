package beautyocl.atl.evaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atlext.ATL.Helper;
import anatlyzer.atlext.ATL.ModuleElement;
import anatlyzer.atlext.ATL.Rule;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.MatchPhase.Match;
import beautyocl.atl.anatlyzer.simplifier.BeautyOCLAnatlyzer;
import beautyocl.atl.evaluation.export.ExportToExcel;
import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEModuleElement;
import beautyocl.atl.evaluation.raw.BETransformation;

public class SimplifyZooExperiment extends AbstractSimplifyExperiment {

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
	
	public SimplifyZooExperiment() {
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
			
				
			//BEProblem expProblem = new BEProblem(p);

			List<ModuleElement> elements = data.getATLModel().allObjectsOf(ModuleElement.class);
			for (ModuleElement moduleElement : elements) {
						
				BEModuleElement me = new BEModuleElement();
				me.setKind(moduleElement.eClass().getName());
				me.setTransformationName(resource.getName());
				if ( moduleElement instanceof Rule ) { 
					me.setName(((Rule) moduleElement).getName());
				} else if ( moduleElement instanceof Helper ) {
					me.setName(ATLUtils.getHelperName((Helper) moduleElement));
				} else {
					me.setName("<unknown>");
				}
				
				
				me.setOriginalExpression(ATLSerializer.serialize(moduleElement));
				me.setOriginalNumNodes(countNodes(moduleElement));
				
				BeautyOCLAnatlyzer simplifier = new BeautyOCLAnatlyzer();
				//System.out.println("Before:\n" + ATLSerializer.serialize(targetExpression)+"\n");
				ExecutionInfo result = simplifier.simplify(data.getAnalyser(), moduleElement, new ExperimentTracer(me) {
					@Override
					public boolean onError(Match m, Throwable t) {
						writer.append("SIMPLIFICATION ERROR: \n" + resource.getName() + "  " + me.getName() );
						return true;
					}
				});
				System.out.println("After:\n" + ATLSerializer.serialize(result.getResult())+"\n");
				
				
				me.setFinalExpression(ATLSerializer.serialize(result.getResult()));
				me.setSimplifiedNumNodes(countNodes(result.getResult()));
	
				trafo.addModuleElement(me);
		
			
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
			

	
	protected List<String> messages = new ArrayList<String>();

	private void printMessage(String msg) {
		System.out.println(msg);
		messages.add(msg);
	}
	
	@Override
	public void saveData(IFile expFile) {	
        String fname = createDataFileName(expFile, "zoo-data", "data");
        
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
