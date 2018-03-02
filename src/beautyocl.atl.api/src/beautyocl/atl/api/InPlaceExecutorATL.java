package beautyocl.atl.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import beautyocl.actions.InPlaceAction;
import beautyocl.actions.MatchPhase;
import beautyocl.api.common.UglyExpression;

public class InPlaceExecutorATL {

	public MatchPhase apply(String transformationName, InputStream asmFile, UglyExpression exp) throws ATLCoreException, IOException {
		EMFModelFactory factory = new EMFModelFactory();
		EMFInjector injector = new EMFInjector();

		IReferenceModel loadedMetamodel = factory.newReferenceModel();		
		// injector.inject(loadedMetamodel, FileUtils.getFileURL("ATLmodified.ecore").openStream(), null);
		injector.inject(loadedMetamodel, "http://anatlyzer/atl/ext/OCL");
		
		IReferenceModel typWrapperMetamodel = factory.newReferenceModel();
		injector.inject(typWrapperMetamodel, "http://beautyocl/atl/typing_wrapper");

		IReferenceModel comparisonWrapperMetamodel = factory.newReferenceModel();
		injector.inject(comparisonWrapperMetamodel, "http://beautyocl/atl/comparison_wrapper");

		IReferenceModel ecoreMetamodel = factory.newReferenceModel();
		injector.inject(ecoreMetamodel, "http://www.eclipse.org/emf/2002/Ecore");

		IReferenceModel actionsMetamodel = factory.newReferenceModel();		
		injector.inject(actionsMetamodel, "http://beautyocl/actions");

		
		EMFModel loadedModel = (EMFModel) factory.newModel(loadedMetamodel);
		injector.inject(loadedModel, exp.getResource());
	
		// Create the typing model in-line
		EMFModel typWrapperModel = (EMFModel) factory.newModel(typWrapperMetamodel);
		typWrapperModel.newElement(typWrapperMetamodel.getMetaElementByName("TypWrapper"));
		typWrapperModel.commitToResource();

		// Create the comparison model in-line
		EMFModel comparisonWrapperModel = (EMFModel) factory.newModel(comparisonWrapperMetamodel);
		comparisonWrapperModel.newElement(comparisonWrapperMetamodel.getMetaElementByName("ComparisonWrapper"));
		comparisonWrapperModel.commitToResource();

		EMFModel ecoreModel = (EMFModel) factory.newModel(ecoreMetamodel);
		injector.inject(ecoreModel, exp.getEcoreTypesResource());
				
		EMFModel newModel = (EMFModel) factory.newModel(actionsMetamodel);
		EMFModel newModelATL = (EMFModel) factory.newModel(loadedMetamodel);
		
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = new HashMap<String, Object>();
		
		launcherOptions.put("allowInterModelReferences", true); 
		launcher.initialize(launcherOptions);

		launcher.addInModel(loadedModel, "IN", "ATL");
		launcher.addInModel(typWrapperModel, "IN2", "WRAP");
		launcher.addInModel(comparisonWrapperModel, "IN3", "CWRAP");		
		launcher.addInModel(ecoreModel, "IN_ECORE", "ECORE");
		launcher.addOutModel(newModel, "OUT", "ACT");
		launcher.addOutModel(newModelATL, "OUT2", "ATL");
		
		
		//System.out.println("Pre");
		//System.out.println( ATLSerializer.serialize(loadedModel.getResource().getContents().get(0)) );
		System.out.println("Executing: " + transformationName);
		launcher.launch("run", null, launcherOptions, asmFile);

		Resource r = newModel.getResource();
		if ( r == null ) {
			// No actions, thus nothing matched
			System.out.println("Nothing applied! " + transformationName);
		} else {
			List<InPlaceAction> actions = new ArrayList<>();
			newModel.getResource().getAllContents().forEachRemaining(o -> {
				if ( o instanceof InPlaceAction ) {
					((InPlaceAction) o).setTransformation(transformationName);
					
					// It is not a subordinate action
					if ( o.eContainer() == null )
						actions.add((InPlaceAction) o);
				} else {
					throw new IllegalStateException("No action! " + o);
				}
			});

			return new MatchPhase(exp.getResource(), exp, actions);
			// new ActionsEngine().apply(exp.getResource(), exp.getScope(), newModelATL.getResource(), actions);
			
		}

		return new MatchPhase(exp.getResource(), exp, Collections.emptyList());
		//System.out.println("Post");
		//System.out.println( ATLSerializer.serialize(loadedModel.getResource().getContents().get(0)) );

	}

	
	

	
	
}
