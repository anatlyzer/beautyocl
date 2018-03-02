package beautyocl.atl.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.Test;

import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import beautyocl.actions.ActionsPackage;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.typwrapper.TypwrapperPackage;

public class TestKindOf extends Tester {
	
	public TransformationRepository configureRepo()  {
		TransformationRepository rep = new TransformationRepository();
		rep.add(new ATLTransformation("kindof", "beautyocl.simplifications.ifKindOf.atl", VM.STANDARD));
		return rep;
	}

	private UglyAnATLyzerExpression loadExpression(String trafo) throws ATLCoreException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, new String[] { "ABCD", "WXYZ"} ); 
		loader.analyse();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(loader.getAtlTransformation(), loader.getAtlTransformation().getRoot());
		return exp;
	}
	

	private UglyAnATLyzerExpression loadExpressionPNML(String trafo) throws ATLCoreException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/PNML_simplified.ecore", "metamodels/PetriNet.ecore"}, new String[] { "PNML", "PetriNet"} ); 
		loader.analyse();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(loader.getAtlTransformation(), loader.getAtlTransformation().getRoot());
		return exp;
	}

//	@Test
	public void testKindOf() throws ATLCoreException {	
		String trafo = "files/kindof/if_kind_of.atl";
		TransformationRepository rep = configureRepo();
		
		UglyAnATLyzerExpression exp = loadExpression(trafo);
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		beauty.applyAll(exp);
	}

	@Test
	public void testKindOf_PNML2PetriNet() throws ATLCoreException {	
		String trafo = "files/kindof/if_kind_of_pnml2petrinet.atl";
		TransformationRepository rep = configureRepo();
		
		UglyAnATLyzerExpression exp = loadExpressionPNML(trafo);
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		beauty.applyAll(exp);
	}

}
