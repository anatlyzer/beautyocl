package beautyocl.atl.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.Test;

import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;
import beautyocl.atl.api.UglyAnATLyzerExpression;

public class TestInteger {

	@Test
	public void test() throws ATLCoreException {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(new ATLTransformation("beautyocl.simplifications.integer.atl", VM.EMFTVM));
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/integer/integer_relational.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, new String[] { "ABCD", "WXYZ"} ); 

		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(loader.getAtlTransformation());
		
		Beautyfier beauty = new Beautyfier(rep);
		beauty.applyAll(exp);
	}

}
