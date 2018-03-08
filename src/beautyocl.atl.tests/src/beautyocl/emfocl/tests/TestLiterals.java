package beautyocl.emfocl.tests;

import org.junit.Test;

import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.api.emfocl.BeautyOCLUtils;
import beautyocl.api.emfocl.UglyEMFOclExpression;

public class TestLiterals extends EMFOclTester {
	
	@Test
	public void test() {
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyOCLUtils.SIMP_BOOLEANS);
		rep.add(BeautyOCLUtils.SIMP_INTEGERS);


		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(1 + 1 = 2) and (true and false)");
		
		UglyEMFOclExpression exp = loadPNMLExpression(stringBuilder.toString());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		beauty.applyAll(exp);
		
		exp.getResource().getContents().forEach(o -> {
			System.out.println(o);
		});
	}
	


}
