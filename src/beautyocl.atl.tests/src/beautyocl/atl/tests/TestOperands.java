package beautyocl.atl.tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.api.utils.BeautyATLUtils;

public class TestOperands extends Tester {
	
	@Test
	public void testEqualitySequence() throws LoadException {	
		String trafo = "files/operands/equality_sequence.atl";
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_EQUALITY_SEQUENCE);
		
		UglyAnATLyzerExpression exp = loadExpression(trafo);
		
		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
			
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

}
