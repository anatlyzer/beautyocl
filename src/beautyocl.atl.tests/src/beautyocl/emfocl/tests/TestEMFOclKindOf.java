package beautyocl.emfocl.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.ActionsPackage;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.api.emfocl.BeautyOCLUtils;
import beautyocl.api.emfocl.EMFOCLSimplification;
import beautyocl.api.emfocl.UglyEMFOclExpression;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.typwrapper.TypwrapperPackage;

public class TestEMFOclKindOf extends EMFOclTester {
	
	@Test
	public void test() {
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyOCLUtils.SIMP_BOOLEANS);
		rep.add(BeautyOCLUtils.SIMP_INTEGERS);

		UglyEMFOclExpression exp = loadExpression();
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		beauty.applyAll(exp);
		
		exp.getResource().getContents().forEach(o -> {
			System.out.println(o);
		});
	}
	
	private UglyEMFOclExpression loadExpression() {
		AnalysisLoader.setStandaloneMode();
		
		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		Helper helper = ocl.createOCLHelper();

		ResourceSet rs = new ResourceSetImpl();
		//org.eclipse.ocl.ecore.OCL.initialize(rs);
		org.eclipse.ocl.ecore.OCL.initialize(null);
		Resource mm = rs.getResource(URI.createFileURI("metamodels/PNML_simplified.ecore"), true);
		
		EClassifier c = ((EPackage) mm.getContents().get(0)).getEClassifier("PNMLDocument");
		if ( c == null ) throw new IllegalStateException();
		helper.setContext(c);
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Arc.allInstances()->forAll(v | if ( v.oclIsKindOf(Arc) ) then ");
		stringBuilder.append(" v.source.oclIsKindOf(Place) and v.target.oclIsKindOf(Transition) ");
		stringBuilder.append(" else ");
		stringBuilder.append("    false ");
		stringBuilder.append(" endif or if ( v.oclIsKindOf(Arc) ) then ");
		stringBuilder.append("    v.target.oclIsKindOf(Place) and v.source.oclIsKindOf(Transition) ");
		stringBuilder.append(" else ");
		stringBuilder.append("   false ");
		stringBuilder.append(" endif)");
//		StringBuilder stringBuilder = new StringBuilder();
//		//stringBuilder.append("Arc.allInstances()->size() > 0");
//		stringBuilder.append("self <> null");
		try {
			Constraint inv = helper.createInvariant(stringBuilder.toString());
			//helper.createQuery(stringBuilder.toString());
			return new UglyEMFOclExpression((OCLExpression) inv.getSpecification().getBodyExpression());
			// return new UglyEMFOclExpression(inv);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


}
