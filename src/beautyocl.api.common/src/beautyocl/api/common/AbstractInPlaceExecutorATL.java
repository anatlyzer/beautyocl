package beautyocl.api.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
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

import beautyocl.actions.ActionsEngine;
import beautyocl.actions.InPlaceAction;
import beautyocl.actions.MatchPhase;
import beautyocl.api.common.UglyExpression;

public abstract class AbstractInPlaceExecutorATL {


	protected abstract ModelDef initOCLVariant(EMFModelFactory factory, EMFInjector injector) throws ATLCoreException;
	protected abstract ModelDef initTypingWrapper(EMFModelFactory factory, EMFInjector injector) throws ATLCoreException;
	protected abstract ModelDef initComparisonWrapper(EMFModelFactory factory, EMFInjector injector) throws ATLCoreException;
	
	public MatchPhase apply(String transformationName, InputStream asmFile, UglyExpression exp) throws ATLCoreException, IOException {
		EMFModelFactory factory = new EMFModelFactory();
		EMFInjector injector = new EMFInjector();

//		IReferenceModel loadedMetamodel = factory.newReferenceModel();		
//		// injector.inject(loadedMetamodel, FileUtils.getFileURL("ATLmodified.ecore").openStream(), null);
//		injector.inject(loadedMetamodel, "http://anatlyzer/atl/ext/OCL");
		
		ModelDef ocl = initOCLVariant(factory, injector);
		ModelDef typ = initTypingWrapper(factory, injector);
		ModelDef comp = initComparisonWrapper(factory, injector);
		
//		IReferenceModel loadedMetamodel = ocl.metamodel;
//		IReferenceModel typWrapperMetamodel = typ.metamodel;
		
//		IReferenceModel typWrapperMetamodel = factory.newReferenceModel();
//		injector.inject(typWrapperMetamodel, "http://beautyocl/atl/typing_wrapper");
		
		IReferenceModel actionsMetamodel = factory.newReferenceModel();		
		injector.inject(actionsMetamodel, "http://beautyocl/actions");

		IReferenceModel ecoreMetamodel = factory.newReferenceModel();
		injector.inject(ecoreMetamodel, "http://www.eclipse.org/emf/2002/Ecore");
		
		EMFModel ecoreModel = (EMFModel) factory.newModel(ecoreMetamodel);
		injector.inject(ecoreModel, exp.getEcoreTypesResource());
		
		IModel loadedModel = ocl.model;
		IModel typWrapperModel = typ.model;
		IModel comparisonWrapperModel = comp.model;
		
		
		EMFModel newModel = (EMFModel) factory.newModel(actionsMetamodel);
		EMFModel newModelOCL = (EMFModel) factory.newModel(ocl.metamodel);
		
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = new HashMap<String, Object>();
		
		launcherOptions.put("allowInterModelReferences", true); 
		launcher.initialize(launcherOptions);

		launcher.addInModel(loadedModel, "IN", ocl.mmName);
		launcher.addInModel(typWrapperModel, "IN2", typ.mmName);
		launcher.addInModel(comparisonWrapperModel, "IN3", comp.mmName);			
		launcher.addInModel(ecoreModel, "IN_ECORE", "ECORE");
		launcher.addOutModel(newModelOCL, "OUT2", "EMF");
		launcher.addOutModel(newModel, "OUT", "ACT");
			
		
		// From ATLInPlaceExecutor
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

	}

	
	public static class ModelDef {
		private IReferenceModel metamodel;
		private IModel model;
		private String mmName;

		public ModelDef(IReferenceModel ref, IModel m, String mmName) {
			this.metamodel = ref;
			this.model = m;
			this.mmName = mmName;
		}
	}

	
	
}
