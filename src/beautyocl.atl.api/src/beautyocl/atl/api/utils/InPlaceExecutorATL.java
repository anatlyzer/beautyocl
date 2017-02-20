package beautyocl.atl.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import anatlyzer.atl.util.ATLSerializer;
import beautyocl.atl.api.UglyExpression;

public class InPlaceExecutorATL {

	public void apply(InputStream asmFile, UglyExpression exp) throws ATLCoreException, IOException {
		EMFModelFactory factory = new EMFModelFactory();
		EMFInjector injector = new EMFInjector();

		IReferenceModel loadedMetamodel = factory.newReferenceModel();		
		// injector.inject(loadedMetamodel, FileUtils.getFileURL("ATLmodified.ecore").openStream(), null);
		injector.inject(loadedMetamodel, "http://anatlyzer/atl/ext/OCL");
		
		EMFModel loadedModel = (EMFModel) factory.newModel(loadedMetamodel);
		injector.inject(loadedModel, exp.getResource());

		
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = new HashMap<String, Object>();
		
		launcherOptions.put("allowInterModelReferences", true); 
		launcher.initialize(launcherOptions);

		launcher.addInOutModel(loadedModel, "IN", "ATL");
		
		IReferenceModel refiningTraceMetamodel = factory.getBuiltInResource("RefiningTrace.ecore");
		launcher.addInModel(refiningTraceMetamodel, "RefiningTrace", "RefiningTrace");

		IModel refiningTraceModel = factory.newModel(refiningTraceMetamodel);
		launcher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace");

		
		System.out.println("Pre");
		System.out.println( ATLSerializer.serialize(loadedModel.getResource().getContents().get(0)) );

		launcher.launch("run", null, launcherOptions, asmFile);

		loadedModel.commitToResource();
		
		System.out.println("Post");
		System.out.println( ATLSerializer.serialize(loadedModel.getResource().getContents().get(0)) );

		
	}

	
	

	
	
}
