package beautyocl.atl.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.compiler.AtlToEmftvmCompiler;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

public class ATLExecutor {
	
	/**
	 * The refining trace model.
	 */
	protected IModel refiningTraceModel;

	private String transformationFile;
	private String temporalAsmPath = null;
	
	private ArrayList<ModelData> modelData;

	private ILauncher launcher;
	
	private boolean useEMFTVM = true;
		
	public static class ModelData {
		public final String metamodelName;
		public final String metamodelPath;
		private String modelName;
		public final String modelPath;
		private IReferenceModel loadedMetamodel;
		private IModel loadedModel;
		private ModelKind kind;
		private String newModelPath;
		
		public ModelData(String modelName, String modelPath, String metamodelName, String metamodelPath, ModelKind kind) {
			this.metamodelName = metamodelName;
			this.metamodelPath = metamodelPath;
			this.modelName = modelName;
			this.modelPath = modelPath;    // This what it is read
			this.newModelPath = modelPath; // This is for serialization
			this.kind = kind;
			
		}

		public ModelData(String modelName, String modelPath, String metamodelName, String metamodelPath, ModelKind kind, String newModelPath) {
			this(modelName, modelPath, metamodelName, metamodelPath, kind);
			if ( kind != ModelKind.INOUT )
				throw new IllegalArgumentException();
			this.newModelPath = newModelPath;
		}
		
		public void load() throws ATLCoreException {
			ModelFactory factory = new EMFModelFactory();
			IInjector injector = new EMFInjector();
		 	loadedMetamodel = factory.newReferenceModel();
			injector.inject(loadedMetamodel, metamodelPath);
			this.loadedModel = factory.newModel(loadedMetamodel);
			if ( kind != ModelKind.OUT) 
				injector.inject(loadedModel, modelPath);
		}

		public void save() throws ATLCoreException {
			IExtractor extractor = new EMFExtractor();
			extractor.extract(this.loadedModel, this.newModelPath);
		}
	}
	
	public static enum ModelKind {
		IN,
		OUT,
		INOUT
	}
	
	public static ModelData inModel(String modelName,  String modelPath, String metamodelName, String metamodelPath) {
		return new ModelData(modelName, modelPath, metamodelName, metamodelPath, ModelKind.IN);
	}

	public static ModelData outModel(String modelName,  String modelPath, String metamodelName, String metamodelPath) {
		return new ModelData(modelName, modelPath, metamodelName, metamodelPath, ModelKind.OUT);
	}

	public static ModelData inOutModel(String modelName,  String modelPath, String metamodelName, String metamodelPath, String newModelPath) {
		return new ModelData(modelName, modelPath, metamodelName, metamodelPath, ModelKind.INOUT, newModelPath);
	}

	HashMap<String, Model> emftvmModels = new HashMap<String, Model>();
	//ArrayList<Model> outModelsEMFTVM;

	private ExecEnv execEnvEmftvm;
	private ATLExecutor execEMFTVM(String transformationFile, ModelData[] models) {
		// TODO Auto-generated method stub
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		ResourceSet rs = new ResourceSetImpl();
		
		this.execEnvEmftvm = env;
		
		// outModelsEMFTVM = new ArrayList<Model>();
		emftvmModels = new HashMap<String, Model>();
		for (ModelData modelData : models) {
			Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
			metaModel.setResource(rs.getResource(URI.createURI(modelData.metamodelPath), true));
			env.registerMetaModel(modelData.metamodelName, metaModel);

			for (EObject pkg : metaModel.allInstancesOf(EcorePackage.Literals.EPACKAGE)) {
				rs.getPackageRegistry().put(((EPackage) pkg).getNsURI(), pkg);
			}
			
			Model aModel = EmftvmFactory.eINSTANCE.createModel();
			Resource r = null;

//			if ( modelData.kind == ModelKind.OUT ) {
//				r = rs.createResource(URI.createURI(modelData.modelPath, true));
//			} else {
//				r = rs.getResource(URI.createURI(modelData.modelPath, true), true);
//			}
			
			// This is to make cross references work in standalone mode
			if ( modelData.kind == ModelKind.OUT ) {
				r = rs.createResource(URI.createFileURI(new File(modelData.modelPath).getAbsolutePath()));
			} else {
				r = rs.getResource(URI.createFileURI(new File(modelData.modelPath).getAbsolutePath()), true);
			}

			
			aModel.setResource(r);
			
			if ( modelData.kind == ModelKind.OUT ) {
				env.registerOutputModel(modelData.modelName, aModel);
			} else if ( modelData.kind == ModelKind.INOUT ){
				env.registerInOutModel(modelData.modelName, aModel);
			} else {
				env.registerInputModel(modelData.modelName, aModel);
			}
			
//			if ( modelData.kind == ModelKind.OUT || modelData.kind == ModelKind.INOUT ) {
//				outModelsEMFTVM.add(aModel);
//			}
			emftvmModels.put(modelData.modelName, aModel);
		}
		
		// Load and run module
		// ModuleResolver mr = new DefaultModuleResolver("platform:/plugin/my.plugin.id/transformations/", new ResourceSetImpl());
		ModuleResolver mr = new ModuleResolver() {			
			@Override
			public Module resolveModule(String name) throws ModuleNotFoundException {
				//ResourceSet rs = new ResourceSetImpl();		
				String bcode = transformationFile.replace(".atl", ".emftvm");
				Resource r = new EMFTVMResourceImpl();
				try {
					r.load(new FileInputStream(new File(bcode)), null);
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
				//Resource r = rs.getResource(URI.createFileURI(b), true);
				return (Module) r.getContents().get(0);
			}
		};
		TimingData td = new TimingData();
		env.loadModule(mr, transformationFile);
		
		td.finishLoading();
		env.run(td);
		td.finish();
		
		return this;
	}

	public ATLExecutor perform(String transformationFile, ModelData... models) throws ATLCoreException, IOException {
		modelData = new ArrayList<ATLExecutor.ModelData>();
		for (ModelData m : models) {
			modelData.add(m);
		}
		
		if ( useEMFTVM ) {
//			ResourceSet rs = new ResourceSetImpl();
//			Resource r = rs.getResource(URI.createPlatformPluginURI("org.eclipse.m2m.atl.emftvm.compiler/transformations/ATLWFR.emftvm", true), true);
//			System.out.println(r);
			
			compileToASMFile(transformationFile);
			return execEMFTVM(transformationFile, models);
		}
		
		this.launcher = null;
		this.transformationFile = transformationFile;
		this.modelData = new ArrayList<ModelData>();
		for (ModelData modelData : models) {
			modelData.load();
			this.modelData.add(modelData);
		}
		
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = new HashMap<String, Object>();
		
		launcherOptions.put("allowInterModelReferences", true); // TODO: Allow configuration
		launcher.initialize(launcherOptions);
		
		for (ModelData modelData : models) {
			switch ( modelData.kind ) {
			case IN:
				launcher.addInModel(modelData.loadedModel, modelData.modelName, modelData.metamodelName);
				break;
			case INOUT:
				launcher.addInOutModel(modelData.loadedModel, modelData.modelName, modelData.metamodelName);
				break;
			case OUT:
				launcher.addOutModel(modelData.loadedModel, modelData.modelName, modelData.metamodelName);
				break;
			}
		}

		String asmFile = compileToASMFile(transformationFile);
		
		launcher.launch("run", null, launcherOptions, new FileInputStream(asmFile));
		this.launcher = launcher;
		return this;
		// IReferenceModel refiningTraceMetamodel = factory.getBuiltInResource("RefiningTrace.ecore");
		// refiningTraceModel = factory.newModel(refiningTraceMetamodel);

	}
	
	public ATLExecutor save() throws ATLCoreException, IOException {
		if ( this.useEMFTVM ) {
			// Save models
			
			for (ModelData model : modelData) {
				if ( model.kind == ModelKind.INOUT) {
					Resource r = emftvmModels.get(model.modelName).getResource();
					r.save(new FileOutputStream(model.newModelPath), Collections.emptyMap());
				} else {
					emftvmModels.get(model.modelName).getResource().save(Collections.emptyMap());
				}
			}
			return this;
		}
				
		// Normal case
		for (ModelData md : modelData) {
			if ( md.kind == ModelKind.OUT || md.kind == ModelKind.INOUT ) {
				md.save();
			}
		}
		return this;
	}
	
	public Resource getModelResource(String name) {
		if ( useEMFTVM ) {
			if ( execEnvEmftvm == null )
				throw new IllegalStateException();
			
			return emftvmModels.get(name).getResource();
		}
			
		return getModel(name).getResource();
	}
	
	public EMFModel getModel(String name) {		
		if ( launcher == null )
			throw new IllegalStateException();
		return (EMFModel) launcher.getModel(name);
	}
	
	public ATLExecutor tempAsmPath(String path) {
		this.temporalAsmPath = path;
		return this;
	}
	
		
	private String compileToASMFile(String trafo) throws IOException {
		// compile transformation
		File trafoFile = new File(trafo);		
		String asmTransformation = trafo.replace(".atl", ".asm");
		if ( temporalAsmPath != null ) {
			asmTransformation = temporalAsmPath + File.separator + trafoFile.getName().replace(".atl", ".asm");
		}
		
		

		// AtlCompiler.getCompiler("atl2006").compile(in, outputFileName)
		//Atl2006Compiler compiler  = new Atl2006Compiler();
		//Atl2010InPlace compiler  = new Atl2010InPlace();
		AtlStandaloneCompiler compiler = null; 
		if ( useEMFTVM ) {
			// Some adjustments...
			compiler = new AtlToEmftvmCompiler();
			asmTransformation = asmTransformation.replace(".asm", ".emftvm");
		} else 
			compiler = new Atl2006Compiler();
		
		FileInputStream fis = new FileInputStream(trafoFile);
		CompileTimeError[] errors = compiler.compile(fis, asmTransformation);
		fis.close();
				
		boolean fatalErrors = false;
		for (CompileTimeError error : errors) fatalErrors = fatalErrors || !error.getSeverity().equals("warning");		
		if  (fatalErrors || !new File(asmTransformation).exists()) {
			System.out.println( fatalErrors? "---> [" + errors[0].getLocation() + "] " + errors[0].getDescription() : "---> no asm file could be generated");
			return null;
		}
			
		return asmTransformation;		
	}


}
