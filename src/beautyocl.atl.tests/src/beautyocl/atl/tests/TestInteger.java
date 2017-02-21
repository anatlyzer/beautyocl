package beautyocl.atl.tests;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.junit.Test;

import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import beautyocl.atl.api.Beautyfier;
import beautyocl.atl.api.TransformationRepository;
import beautyocl.atl.api.UglyAnATLyzerExpression;

public class TestInteger {

	@Test
	public void test() throws ATLCoreException {
		TransformationRepository rep = new TransformationRepository();
		rep.addEMFTVM("beautyocl.simplifications.integer.atl");
	
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load("files/integer/integer_relational.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, new String[] { "ABCD", "WXYZ"} ); 

		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(loader.getAtlTransformation());
		
		Beautyfier beauty = new Beautyfier(rep);
		beauty.applyAll(exp);
	}

}
