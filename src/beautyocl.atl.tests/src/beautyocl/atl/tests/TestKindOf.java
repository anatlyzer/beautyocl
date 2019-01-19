package beautyocl.atl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

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
		
		doTest(rep, new File(trafo));
	}

	@Test
	public void testKindOfTrue_PNML() throws LoadException {	
		String trafo = "files/kindof/kind_of_true_pnml2petrinet.atl";
		TransformationRepository rep = configureRepoSimpleKindOf();
		
		doTest(rep, new File(trafo));
	}
	
	@Test
	public void testKindOf_Inheritance() throws LoadException {	
		String trafo = "files/kindof/if_kind_of_inheritance.atl";
		TransformationRepository rep = configureRepoSimpleKindOf();
		
		doTest(rep, new File(trafo));	
	}

	@Test
	public void testKindOf_PNML2PetriNet() throws LoadException {	
		String trafo = "files/kindof/if_kind_of_pnml2petrinet.atl";
		TransformationRepository rep = configureRepoSimpleKindOf();
		
		doTest(rep, new File(trafo));
	}

	@Test
	public void testKindOf_True_KM3() throws LoadException {	
		String trafo = "files/kindof/kind_of_true_km3.atl";
		TransformationRepository rep = configureRepoSimpleKindOf();
		
		doTest(rep, new File(trafo));					
	}

	
	@Test
	public void testKindOf_Full_PNML2PetriNet() throws LoadException {	
		String trafo = "files/kindof/if_kind_of_full_pnml2petrinet.atl";
		TransformationRepository rep = configureRepoFullKindOf();
		
		doTest(rep, new File(trafo));
	}

	
	@Test
	public void testKindOf_Full_Multiple_Inheritance_XHTML() throws LoadException {	
		String trafo = "files/kindof/kind_of_full_multiple_inheritance_xhtml.atl";
		TransformationRepository rep = configureRepoFullKindOf();
		
		doTest(rep, new File(trafo));
	}

	@Test
	public void testKindOf_Full_NoChange() throws LoadException {	
		String trafo = "files/kindof/kind_of_full_no_change.atl";
		TransformationRepository rep = configureRepoFullKindOf();
		
		doTest(rep, new File(trafo));
	}

}
