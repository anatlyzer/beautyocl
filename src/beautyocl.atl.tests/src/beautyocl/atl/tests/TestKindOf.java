package beautyocl.atl.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.Test;

import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import beautyocl.actions.ActionsPackage;
import beautyocl.atl.api.Beautyfier;
import beautyocl.atl.api.TransformationRepository;
import beautyocl.atl.api.UglyAnATLyzerExpression;

public class TestKindOf {

	public void standalone() {
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, ActionsPackage.eINSTANCE);
	}
	
	@Test
	public void test() throws ATLCoreException {
		standalone();
		
		TransformationRepository rep = new TransformationRepository();
		rep.addStd("beautyocl.simplifications.ifKindOf.atl");
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/kindof/if_kind_of.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, new String[] { "ABCD", "WXYZ"} ); 
		loader.analyse();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(loader.getAtlTransformation());
		
		Beautyfier beauty = new Beautyfier(rep);
		beauty.applyAll(exp);
	}

}
