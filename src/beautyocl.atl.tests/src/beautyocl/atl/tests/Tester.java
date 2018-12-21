package beautyocl.atl.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import beautyocl.actions.ActionsPackage;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.typwrapper.TypwrapperPackage;

public abstract class Tester {
	static {
		standalone();
	}
	
	public static void standalone() {
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, ActionsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TypwrapperPackage.eNS_URI, TypwrapperPackage.eINSTANCE);
	}
	
	protected UglyAnATLyzerExpression loadExpression(String trafo) throws LoadException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, new String[] { "ABCD", "WXYZ"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		return exp;
	}
	

	protected UglyAnATLyzerExpression loadExpressionPNML(String trafo) throws LoadException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/PNML_simplified.ecore", "metamodels/PetriNet.ecore"}, new String[] { "PNML", "PetriNet"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		return exp;
	}
	

	protected UglyAnATLyzerExpression loadExpressionHSM2FSM(String trafo) throws LoadException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/HSM.ecore", "metamodels/FSM.ecore"}, new String[] { "HSM", "FSM"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		return exp;
	}
}
