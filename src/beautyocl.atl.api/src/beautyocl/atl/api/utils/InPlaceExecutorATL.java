package beautyocl.atl.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.ActionsEngine;
import beautyocl.actions.InPlaceAction;
import beautyocl.atl.api.UglyExpression;

public class InPlaceExecutorATL {

	public void apply(InputStream asmFile, UglyExpression exp) throws ATLCoreException, IOException {
		EMFModelFactory factory = new EMFModelFactory();
		EMFInjector injector = new EMFInjector();

		IReferenceModel loadedMetamodel = factory.newReferenceModel();		
		// injector.inject(loadedMetamodel, FileUtils.getFileURL("ATLmodified.ecore").openStream(), null);
		injector.inject(loadedMetamodel, "http://anatlyzer/atl/ext/OCL");
		
		IReferenceModel typWrapperMetamodel = factory.newReferenceModel();
		injector.inject(typWrapperMetamodel, "http://beautyocl/atl/typing_wrapper");
		
		IReferenceModel actionsMetamodel = factory.newReferenceModel();		
		injector.inject(actionsMetamodel, "http://beautyocl/actions");

		
		EMFModel loadedModel = (EMFModel) factory.newModel(loadedMetamodel);
		injector.inject(loadedModel, exp.getResource());
	
		// Create the typing model in-line
		EMFModel typWrapperModel = (EMFModel) factory.newModel(typWrapperMetamodel);
		typWrapperModel.newElement(typWrapperMetamodel.getMetaElementByName("TypWrapper"));
		typWrapperModel.commitToResource();
		
		EMFModel newModel = (EMFModel) factory.newModel(actionsMetamodel);
		
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = new HashMap<String, Object>();
		
		launcherOptions.put("allowInterModelReferences", true); 
		launcher.initialize(launcherOptions);

		launcher.addInModel(loadedModel, "IN", "ATL");
		launcher.addInModel(typWrapperModel, "IN2", "WRAP");
		launcher.addOutModel(newModel, "OUT", "ACT");
		
		
		System.out.println("Pre");
		System.out.println( ATLSerializer.serialize(loadedModel.getResource().getContents().get(0)) );

		launcher.launch("run", null, launcherOptions, asmFile);

		Resource r = newModel.getResource();
		if ( r == null ) {
			// No actions, thus nothing matched
			System.out.println("Nothing applied!");
		} else {
			List<InPlaceAction> actions = new ArrayList<>();
			newModel.getResource().getAllContents().forEachRemaining(o -> {
				if ( o instanceof InPlaceAction ) {
					actions.add((InPlaceAction) o);
				} else {
					throw new IllegalStateException("No action! " + o);
				}
			});
			
			new ActionsEngine().apply(exp.getResource(), actions);
			
		}

		System.out.println("Post");
		System.out.println( ATLSerializer.serialize(loadedModel.getResource().getContents().get(0)) );

	}

	
	

	
	
}
