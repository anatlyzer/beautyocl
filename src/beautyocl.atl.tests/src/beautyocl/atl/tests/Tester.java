package beautyocl.atl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atlext.ATL.LocatedElement;
import anatlyzer.atlext.ATL.Unit;
import beautyocl.actions.ActionsPackage;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
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
	

	protected UglyAnATLyzerExpression loadExpressionXHTML(String trafo) throws LoadException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/XHTML.ecore"}, new String[] { "XHTML"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		return exp;
	}
	
	protected UglyAnATLyzerExpression loadExpressionKM3(String trafo) throws LoadException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/KM3.ecore" }, new String[] { "KM3" }); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		return exp;
	}

	protected UglyAnATLyzerExpression loadExpressionXML(String trafo) throws LoadException {
		AnalysisLoader.setStandaloneMode();
		Resource r = AtlLoader.load(trafo);
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/XML.ecore" }, new String[] { "XML" }); 
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
	

	protected void doTest(TransformationRepository rep, File file) throws LoadException {
		doTest(rep, file, IExecutionTracer.NULL);
	}
	
	protected void doTest(TransformationRepository rep, File sourceFile, IExecutionTracer tracer) throws LoadException {
		
		UglyAnATLyzerExpression exp;
		// Use some conventions to know which metamodel to load
		if ( sourceFile.getName().toLowerCase().contains("pnml") ) {
			exp = loadExpressionPNML(sourceFile.getAbsolutePath());
		} else if ( sourceFile.getName().toLowerCase().contains("km3")) {
			exp = loadExpressionKM3(sourceFile.getAbsolutePath());
		} else if ( sourceFile.getName().toLowerCase().contains("xml")) {
			exp = loadExpressionXML(sourceFile.getAbsolutePath());
		} else if ( sourceFile.getName().toLowerCase().contains("xhtml")) {
			exp = loadExpressionXHTML(sourceFile.getAbsolutePath());
		} else {
			exp = loadExpression(sourceFile.getAbsolutePath());
		}
		
		Unit root = exp.getAnalysis().getATLModel().getRoot();
		
		List<String> values = ATLUtils.findCommaTags(root, "@test");
		
		Map<LocatedElement, String> expectedSimplifications = new HashMap<>();
		root.eAllContents().forEachRemaining(e -> {
			if ( e instanceof LocatedElement ) {
				List<String> tagged = ATLUtils.findTags((LocatedElement) e, "@simplifiesTo");
				if ( tagged.size() > 0 ) {
					if ( tagged.size() != 1 )
						throw new IllegalArgumentException("Only one @simplifiesTo per element");
					expectedSimplifications.put((LocatedElement) e, tagged.iterator().next());
				}
			}
		});
		
		
		
		
//		EObject e = ATLUtils.findElement(exp.getRoot(), s -> s instanceof IteratorExp).get();
//		System.out.println(AnalyserUtils.toTree((LocatedElement) e));

		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, tracer);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		

		System.out.println("Before: " + before);
		System.out.println("After: " + after);

		if ( values.contains("no-change") ) {
			assertEquals(before, after);	
		} else {			
			assertNotEquals(before, after);
		
			String afterNormalized = normalize(after);
			for (String str : expectedSimplifications.values()) {
				String expected = normalize(str);
				// Not totally precise, but I hope it is enough.
			
				boolean isOk = afterNormalized.contains(expected);
				if ( ! isOk ) {
					System.out.println(afterNormalized);
					System.out.println("--");
					System.out.println(expected);
					assertTrue("Not found " + str, isOk);
				}
			}
		}

	}

	private String normalize(String str) {
		return str.replaceAll("\\s+", "");
	}
}
