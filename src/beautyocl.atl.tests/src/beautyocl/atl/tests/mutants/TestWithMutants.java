package beautyocl.atl.tests.mutants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.witness.IWitnessFinder;
import anatlyzer.testing.atl.common.AtlLauncher;
import anatlyzer.testing.atl.common.AtlTransformation;
import anatlyzer.testing.atl.launching.ATLExecutor;
import anatlyzer.testing.common.IComparator;
import anatlyzer.testing.common.IModel;
import anatlyzer.testing.common.IProgressMonitor;
import anatlyzer.testing.common.ITransformation.ModelSpec;
import anatlyzer.testing.common.ITransformationConfigurator;
import anatlyzer.testing.common.Metamodel;
import anatlyzer.testing.comparison.emfcompare.EMFCompareComparator;
import anatlyzer.testing.difftesting.DifferentialOptimisationTester;
import anatlyzer.testing.modelgen.FolderBasedModelRetriever;
import anatlyzer.testing.modelgen.FolderBasedStorageStrategy;
import anatlyzer.testing.modelgen.IModelGenerator;
import anatlyzer.testing.modelgen.ModelGenerationStrategy;
import anatlyzer.testing.modelgen.ModelGenerationStrategy.STRATEGY;
import anatlyzer.testing.modelgen.ModelGeneratorWitnessFinder;
import anatlyzer.testing.modelgen.UseModelValidatorModelGenerator;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.utils.BeautyATLUtils;
import beautyocl.atl.tests.AtlOptimiser;
import beautyocl.atl.tests.Tester;

public class TestWithMutants extends Tester {

	static {
		AnalysisLoader.setStandaloneMode();		
	}
	
	@Test
	public void test() throws LoadException {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(BeautyATLUtils.SIMP_IF_SAME_EXPR);
	
		/*
		Resource r = AtlLoader.load("files/ifelse/if_else_same_expr.atl");
		AnalysisLoader loader = AnalysisLoader.fromResource(r, new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, new String[] { "ABCD", "WXYZ"} ); 
		IAnalyserResult analysis = loader.analyse().getAnalyser();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, loader.getAtlTransformation().getRoot());
		
		String before = ATLSerializer.serialize(exp.getRoot());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		ExecutionInfo result = beauty.applyAll(exp);
		
		String after = ATLSerializer.serialize(exp.getRoot());
		
		assertNotEquals(before, after);
		
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
		*/
		
		String transformationFile = "files/ifelse/if_else_same_expr.atl";
		File mutantsFolder       = new File("test-cache/mutants/abcd");
		File optimizationsFolder = new File("test-cache/optimizations");
		
		AtlTransformation trafo = AtlTransformation.fromFile(transformationFile, 
				new String[] { "metamodels/ABCD.ecore", "metamodels/WXYZ.ecore"}, 
				new String[] { "ABCD", "WXYZ"});
		
		Metamodel sourceMetamodel = trafo.getSources().get(0).getMetamodel();
		STRATEGY strategy = ModelGenerationStrategy.STRATEGY.Lite;
		
		ITransformationConfigurator<AtlTransformation, AtlLauncher> configurator = new ITransformationConfigurator<AtlTransformation, AtlLauncher>() {
			@Override
			public AtlLauncher configure(AtlTransformation t, IModel input) {
				List<ATLExecutor.ModelData> models = new ArrayList<>();
				for (ModelSpec m : t.getSources()) {
					models.add( ATLExecutor.inModel("IN", input.getResource(), "ABCD", m.getMetamodel().getResource()) );			
				}
				
				for (ModelSpec m : t.getTargets()) {
					String path = "out.xmi"; // TODO: Figure out a sensible model name
					models.add( ATLExecutor.outModel(m.getModelName(), path, m.getMetamodelName(), m.getMetamodel().getResource()));
				}
				
				ATLExecutor executor = new ATLExecutor().withModels(models);
				
					//perform(transformationFile, models);
				
				// new ATLExecutor().perform(t., models)
				//ATLExecutor.inModel(modelName, modelPath, metamodelName, metamodelPath)
				// TODO Auto-generated method stub
				return new AtlLauncher(executor, t);
			}
		};
		
		IComparator comparator = new EMFCompareComparator();
		
		IWitnessFinder wf = new ModelGeneratorWitnessFinder();
		FolderBasedStorageStrategy storageStrategy = new FolderBasedStorageStrategy(mutantsFolder);
		IModelGenerator generator;
		if ( mutantsFolder.exists() ) {
			System.out.println("Reusing folder: " + mutantsFolder);
			generator = new FolderBasedModelRetriever(mutantsFolder, sourceMetamodel);
		} else {		
			generator = new UseModelValidatorModelGenerator(sourceMetamodel, 				
							UseModelValidatorModelGenerator.getStrategy(sourceMetamodel, strategy),
							storageStrategy, wf);
		}
		
		DifferentialOptimisationTester<AtlTransformation, AtlLauncher> tester = new DifferentialOptimisationTester<AtlTransformation, AtlLauncher>(trafo, 
				new AtlOptimiser(rep, optimizationsFolder), generator, configurator, comparator);
		
		tester.test(IProgressMonitor.NULL);
	}
	
}
