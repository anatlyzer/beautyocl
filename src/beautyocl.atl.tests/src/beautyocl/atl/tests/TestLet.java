package beautyocl.atl.tests;

import static org.junit.Assert.assertNotEquals;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.Test;

import anatlyzer.atl.analyser.AnalysisResult;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.actions.MatchPhase.Match;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;
import beautyocl.atl.api.utils.BeautyATLUtils;
import beautyocl.atl.api.UglyAnATLyzerExpression;

public class TestLet extends Tester {

	@Test
	public void testLet() throws ATLCoreException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_REMOVE_LET);
		
		UglyAnATLyzerExpression exp = loadExpressionHSM2FSM("files/let/let_hsm2fsm.atl");

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, new TestExecutionTracer());
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}
}
