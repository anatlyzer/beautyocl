package beautyocl.atl.tests;

import static org.junit.Assert.assertNotEquals;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.Test;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;
import beautyocl.atl.api.utils.BeautyATLUtils;
import beautyocl.atl.api.UglyAnATLyzerExpression;

public class TestUnshortCircuit extends Tester {

	@Test
	public void test() throws LoadException {
		TransformationRepository rep = configureRepo();
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/unshort/unshort1.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/PNML_simplified.ecore", "metamodels/PetriNet.ecore"}, new String[] { "PNML", "PetriNet"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		
		String before = ATLSerializer.serialize(exp.getRoot());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		ExecutionInfo result = beauty.applyAll(exp);
		
		String after = ATLSerializer.serialize(exp.getRoot());
		
		assertNotEquals(before, after);
		
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
		
	}


	@Test
	public void test2() throws LoadException {
		TransformationRepository rep = configureRepo();
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/unshort/unshort2.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/PNML_simplified.ecore", "metamodels/PetriNet.ecore"}, new String[] { "PNML", "PetriNet"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		
		String before = ATLSerializer.serialize(exp.getRoot());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		ExecutionInfo result = beauty.applyAll(exp);
		
		String after = ATLSerializer.serialize(exp.getRoot());
		
		assertNotEquals(before, after);
		
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
		
	}


	private TransformationRepository configureRepo() {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(BeautyATLUtils.SIMP_UNSHORT_CIRCUIT);
		return rep;
	}
	

	@Test
	public void test3() throws LoadException {
		TransformationRepository rep = configureRepo();
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/unshort/unshort3.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/PNML_simplified.ecore", "metamodels/PetriNet.ecore"}, new String[] { "PNML", "PetriNet"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());

		String before = ATLSerializer.serialize(exp.getRoot());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		ExecutionInfo result = beauty.applyAll(exp);
		
		String after = ATLSerializer.serialize(exp.getRoot());
		
		assertNotEquals(before, after);
		
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
		
	}

	@Test
	public void test_unshort_or() throws LoadException {
		TransformationRepository rep = configureRepo();
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/unshort/unshort_or.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/PNML_simplified.ecore", "metamodels/PetriNet.ecore"}, new String[] { "PNML", "PetriNet"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		
		String before = ATLSerializer.serialize(exp.getRoot());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		ExecutionInfo result = beauty.applyAll(exp);
		
		String after = ATLSerializer.serialize(exp.getRoot());
		
		assertNotEquals(before, after);
		
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
		
	}

	@Test
	public void testKindOf_HSM2FSM_Failure() throws LoadException {	
		TransformationRepository rep = configureRepo();
		
		UglyAnATLyzerExpression exp = loadExpressionHSM2FSM("files/unshort/hsm2fsm_failure.atl");

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

	@Test
	public void testPNML_Unshort_Implies() throws LoadException {	
		TransformationRepository rep = configureRepo();
		
		UglyAnATLyzerExpression exp = loadExpressionPNML("files/unshort/unshort_pnml_implies.atl");

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}


	@Test
	public void test_Unshort_Failing() throws LoadException {	
		TransformationRepository rep = configureRepo();
		doTest(rep, new File("files/unshort/unshort_no_change.atl"));
	}
	
}
