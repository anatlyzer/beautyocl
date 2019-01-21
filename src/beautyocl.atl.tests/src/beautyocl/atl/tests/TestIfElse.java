package beautyocl.atl.tests;

import static org.junit.Assert.assertNotEquals;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atlext.ATL.LocatedElement;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.actions.MatchPhase.Match;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.api.utils.BeautyATLUtils;

public class TestIfElse extends Tester {

	@Test
	public void test() throws LoadException {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(BeautyATLUtils.SIMP_IF_SAME_EXPR);
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/ifelse/if_else_same_expr.atl");
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

	@Test
	public void test2() throws LoadException {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(BeautyATLUtils.SIMP_IF_SAME_EXPR);
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/ifelse/if_else_same_expr2.atl");
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

	@Test
	public void test3() throws LoadException {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(BeautyATLUtils.SIMP_IF_SAME_EXPR);
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/ifelse/if_else_same_expr3.atl");
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
	
	@Test
	public void testIntroCall() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_IF_INTRO_CALL);

		doTest(rep, new File("files/ifelse/intro_call1.atl"));
	}

	@Test
	public void testIntroCall_HSM2FSM() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_IF_INTRO_CALL);
		
		UglyAnATLyzerExpression exp = loadExpressionHSM2FSM("files/ifelse/intro_call_hsm2fsm_failure.atl");

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, new IExecutionTracer() {

				@Override
				public void preApply(Match m, EObject original) {
					System.out.println(AnalyserUtils.toTree((LocatedElement) original));

					System.out.println("A: " + m.getAction().getSource());
					
					String exp = ATLSerializer.serialize(original);
					System.out.println("Before " + m.getTransformationName() + "\n" + exp);
				}

				@Override
				public void postApply(Match m, EObject transformed) {
					System.out.println(AnalyserUtils.toTree((LocatedElement) transformed));
					
					String exp = ATLSerializer.serialize(transformed);
					System.out.println("After " + m.getTransformationName() + "\n" + exp);					
				}

				@Override
				public boolean onError(Match m, Throwable t) {
					t.printStackTrace();
					// TODO Auto-generated method stub
					return false;
				}
				
			});
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

	@Test
	public void testIfFusion_HSM2FSM() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_IF_FUSION);
		
		UglyAnATLyzerExpression exp = loadExpressionHSM2FSM("files/ifelse/if_fusion_pnml2petrinet.atl");

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, new IExecutionTracer() {

				@Override
				public void preApply(Match m, EObject original) {
					System.out.println("A: " + m.getAction().getSource());
					
					String exp = ATLSerializer.serialize(original);
					System.out.println("Before " + m.getTransformationName() + "\n" + exp);
				}

				@Override
				public void postApply(Match m, EObject transformed) {
					String exp = ATLSerializer.serialize(transformed);
					System.out.println("After " + m.getTransformationName() + "\n" + exp);					
				}

				@Override
				public boolean onError(Match m, Throwable t) {
					t.printStackTrace();
					// TODO Auto-generated method stub
					return false;
				}
				
			});
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}
	
	@Test
	public void testPullUpConditional() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.PULL_UP_CONDITIONAL);
		
		UglyAnATLyzerExpression exp = loadExpression("files/ifelse/pull_up_conditional.atl");

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

	@Test
	public void testComplementary_expressions() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_IF_COMPLEMENTARY_CONDITIONS);

		doTest(rep, new File("files/ifelse/if_complementary_expressions.atl"));
	}
}
