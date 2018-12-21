package beautyocl.atl.tests;

import static org.junit.Assert.assertNotEquals;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.Test;

import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.ActionsPackage;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.api.utils.BeautyATLUtils;
import beautyocl.atl.typwrapper.TypwrapperPackage;

public class TestKindOf extends Tester {
	
	public TransformationRepository configureRepoSimpleKindOf()  {
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_KIND_OF_TRUE);
		return rep;
	}

	public TransformationRepository configureRepoFullKindOf()  {
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_KIND_OF_FULL);
		return rep;
	}

	@Test
	public void testKindOf() throws LoadException {	
		String trafo = "files/kindof/if_kind_of.atl";
		TransformationRepository rep = configureRepoSimpleKindOf();
		
		UglyAnATLyzerExpression exp = loadExpression(trafo);
		
		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
			
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

	@Test
	public void testKindOf_Inheritance() throws LoadException {	
		String trafo = "files/kindof/if_kind_of_inheritance.atl";
		TransformationRepository rep = configureRepoSimpleKindOf();
		
		UglyAnATLyzerExpression exp = loadExpression(trafo);
		
		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
			
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

	@Test
	public void testKindOf_PNML2PetriNet() throws LoadException {	
		String trafo = "files/kindof/if_kind_of_pnml2petrinet.atl";
		TransformationRepository rep = configureRepoSimpleKindOf();
		
		UglyAnATLyzerExpression exp = loadExpressionPNML(trafo);

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

	@Test
	public void testKindOf_Full_PNML2PetriNet() throws LoadException {	
		String trafo = "files/kindof/if_kind_of_full_pnml2petrinet.atl";
		TransformationRepository rep = configureRepoFullKindOf();
		
		UglyAnATLyzerExpression exp = loadExpressionPNML(trafo);

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
				
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

}
