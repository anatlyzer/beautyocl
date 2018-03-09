package beautyocl.emfocl.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;

import anatlyzer.atl.tests.api.AnalysisLoader;
import beautyocl.actions.ActionsPackage;
import beautyocl.api.emfocl.UglyEMFOclExpression;
import beautyocl.atl.typwrapper.TypwrapperPackage;

public class EMFOclTester {
	static {
		standalone();
	}
	
	public static void standalone() {		
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, ActionsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TypwrapperPackage.eNS_URI, TypwrapperPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(emfocl.typwrapper.TypwrapperPackage.eNS_URI, emfocl.typwrapper.TypwrapperPackage.eINSTANCE);
		
	}
	

	protected UglyEMFOclExpression loadPNMLExpression(String query) {
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
		
//		StringBuilder stringBuilder = new StringBuilder();
//		//stringBuilder.append("Arc.allInstances()->size() > 0");
//		stringBuilder.append("self <> null");
		try {
			Constraint inv = helper.createInvariant(query);
			//helper.createQuery(stringBuilder.toString());
			return new UglyEMFOclExpression((OCLExpression) inv.getSpecification().getBodyExpression(), mm);
			// return new UglyEMFOclExpression(inv);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
