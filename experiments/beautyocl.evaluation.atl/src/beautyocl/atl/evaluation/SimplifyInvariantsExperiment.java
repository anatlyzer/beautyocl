package beautyocl.atl.evaluation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import anatlyzer.atl.analyser.batch.PossibleInvariantViolationNode;
import anatlyzer.atl.analyser.batch.TargetInvariantAnalysis_SourceBased;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.experiments.extensions.IExperiment;
import beautyocl.actions.ExecutionInfo;
import beautyocl.atl.anatlyzer.simplifier.BeautyOCLAnatlyzer;
import beautyocl.atl.evaluation.export.ExportToExcel;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BETransformation;

public class SimplifyInvariantsExperiment extends AbstractSimplifyExperiment implements IExperiment {

	protected static final String ORIGINAL_RESOURCE = "ORIGINAL_RESOURCE";
	
	
	@Override
	public void printResult(PrintStream out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canExportToExcel() {
		return true;
	}

 	List<AnalyserData> allData = new ArrayList<AnalyserData>();
 	BEData expData = new BEData();
 	StringBuilder buffer = new StringBuilder();
 	
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
			
			List<PossibleInvariantViolationNode> postconditions = advancePostconditions(data);
					
			for (PossibleInvariantViolationNode postcondition : postconditions) {
				if (monitor != null && monitor.isCanceled())
					return;

				if (!isInterestingPostcondition(postcondition)) {
					continue;
				}

				OclExpression targetExpression = postcondition.getPreconditionATL();
				
				BEInvariant expInv = new BEInvariant();
				expInv.setName(postcondition.getInvName());
				expInv.setOriginalExpression(ATLSerializer.serialize(targetExpression));
				expInv.setOriginalNumNodes(countNodes(targetExpression));
				
				XMIResourceImpl r = new XMIResourceImpl();
				if ( targetExpression.eResource() == null ) {
					r.getContents().add(targetExpression);
				}
				
				trafo.addInvariant(expInv);

				System.out.println("=== Processing: " + postcondition.getInvName());
				
				BeautyOCLAnatlyzer simplifier = new BeautyOCLAnatlyzer();
				
				String originalText = ATLSerializer.serialize(targetExpression);
				System.out.println("Before:\n" + originalText + "\n");
				
				ExecutionInfo result = simplifier.simplify(data.getAnalyser(), targetExpression, new ExperimentTracer(expInv));
				
				String simplifiedText = ATLSerializer.serialize(result.getResult());
				System.out.println("After:\n" + simplifiedText + "\n");
				
				expInv.setFinalExpression(ATLSerializer.serialize(result.getResult()));
				expInv.setSimplifiedNumNodes(countNodes(result.getResult()));
				
				buffer.append("\nOriginal: " + postcondition.getInvName() + "\n");
				buffer.append(originalText);

				buffer.append("\nSimplified: " + postcondition.getInvName() + "\n");
				buffer.append(simplifiedText);
				buffer.append("\n======\n\n");
								
				// TODO: Get information about the applied simplifications
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("Error " + resource.getName() + e.getMessage());
			// counting.addError(resource.getName(), e);
//			e.printStackTrace();
			// throw new RuntimeException(e);
		}
		
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
        String fname = createDataFileName(expFile, "inv-data", "data");
        
		// http://www.ibm.com/developerworks/library/x-simplexobjs/
		// http://simple.sourceforge.net/download/stream/doc/examples/examples.php
		Serializer serializer = new Persister();
        File result = new File(fname);
        try {
			serializer.write(expData, result);
			FileWriter fw = new FileWriter(new File(fname + ".txt"));
			fw.append(buffer.toString());
			fw.close();
        } catch (Exception e) {
			e.printStackTrace();
		}
	};

	@Override
	public void exportToExcel(String fileName) throws IOException {
		IFolder folder = experimentFile.getProject().getFolder("inv-data");
		new ExportToExcel(expData).exportToExcel(folder, experimentFile); 
	}

}
