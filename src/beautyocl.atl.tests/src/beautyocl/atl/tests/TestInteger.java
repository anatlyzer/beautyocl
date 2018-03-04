package beautyocl.atl.tests;

import static org.junit.Assert.assertNotEquals;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.Test;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;
import beautyocl.atl.api.utils.BeautyATLUtils;
import beautyocl.atl.api.UglyAnATLyzerExpression;

public class TestInteger extends Tester {

	@Test
	public void test() throws ATLCoreException {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(BeautyATLUtils.SIMP_INTEGERS);
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/integer/integer_relational.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, new String[] { "ABCD", "WXYZ"} ); 
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

}
