package beautyocl.emfocl.tests;

import org.junit.Test;

import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.api.emfocl.BeautyOCLUtils;
import beautyocl.api.emfocl.UglyEMFOclExpression;

public class TestEMFOclKindOf extends EMFOclTester {
	
	@Test
	public void testKindOf() {
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyOCLUtils.SIMP_KIND_OF_TRUE);
		rep.add(BeautyOCLUtils.SIMP_KIND_OF_FULL);


//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append("Arc.allInstances()->forAll(v | if ( v.oclIsKindOf(Arc) ) then ");
//		stringBuilder.append(" v.source.oclIsKindOf(Place) and v.target.oclIsKindOf(Transition) ");
//		stringBuilder.append(" else ");
//		stringBuilder.append("    false ");
//		stringBuilder.append(" endif or if ( v.oclIsKindOf(Arc) ) then ");
//		stringBuilder.append("    v.target.oclIsKindOf(Place) and v.source.oclIsKindOf(Transition) ");
//		stringBuilder.append(" else ");
//		stringBuilder.append("   false ");
//		stringBuilder.append(" endif)");

		// NOT WORKING SIMP_KIND_OF_FULL!
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Arc.allInstances()->forAll(v | if ( v.oclIsKindOf(Arc) ) then ");
		stringBuilder.append(" v.oclIsKindOf(Place) or v.oclIsKindOf(Transition) ");
		stringBuilder.append(" else ");
		stringBuilder.append("    false ");
		stringBuilder.append(" endif or if ( v.oclIsKindOf(Arc) ) then ");
		stringBuilder.append("    v.target.oclIsKindOf(Place) and v.source.oclIsKindOf(Transition) ");
		stringBuilder.append(" else ");
		stringBuilder.append("   false ");
		stringBuilder.append(" endif)");
		
		UglyEMFOclExpression exp = loadPNMLExpression(stringBuilder.toString());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		beauty.applyAll(exp);
		
		exp.getResource().getContents().forEach(o -> {
			System.out.println(o);
		});
	}

}
