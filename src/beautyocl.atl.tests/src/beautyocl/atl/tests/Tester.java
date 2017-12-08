package beautyocl.atl.tests;

import org.eclipse.emf.ecore.EPackage;

import beautyocl.actions.ActionsPackage;
import beautyocl.atl.typwrapper.TypwrapperPackage;

public class Tester {
	static {
		standalone();
	}
	
	public static void standalone() {
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, ActionsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TypwrapperPackage.eNS_URI, TypwrapperPackage.eINSTANCE);
	}
}
