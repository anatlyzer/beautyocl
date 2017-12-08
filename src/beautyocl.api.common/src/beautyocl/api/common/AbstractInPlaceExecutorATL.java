package beautyocl.api.common;

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

import beautyocl.actions.ActionsEngine;
import beautyocl.actions.InPlaceAction;
import beautyocl.api.common.UglyExpression;

public abstract class AbstractInPlaceExecutorATL {


	protected abstract ModelDef initOCLVariant(EMFModelFactory factory, EMFInjector injector) throws ATLCoreException;
	protected abstract ModelDef initTypingWrapper(EMFModelFactory factory, EMFInjector injector) throws ATLCoreException;
	
	public Resource apply(InputStream asmFile, UglyExpression exp) throws ATLCoreException, IOException {
		EMFModelFactory factory = new EMFModelFactory();
		EMFInjector injector = new EMFInjector();

//		IReferenceModel loadedMetamodel = factory.newReferenceModel();		
//		// injector.inject(loadedMetamodel, FileUtils.getFileURL("ATLmodified.ecore").openStream(), null);
//		injector.inject(loadedMetamodel, "http://anatlyzer/atl/ext/OCL");
		
		ModelDef ocl = initOCLVariant(factory, injector);
		ModelDef typ = initTypingWrapper(factory, injector);
		
//		IReferenceModel loadedMetamodel = ocl.metamodel;
//		IReferenceModel typWrapperMetamodel = typ.metamodel;
		
//		IReferenceModel typWrapperMetamodel = factory.newReferenceModel();
//		injector.inject(typWrapperMetamodel, "http://beautyocl/atl/typing_wrapper");
		
		IReferenceModel actionsMetamodel = factory.newReferenceModel();		
		injector.inject(actionsMetamodel, "http://beautyocl/actions");

		IModel loadedModel = ocl.model;
		IModel typWrapperModel = typ.model;
		
		
		EMFModel newModel = (EMFModel) factory.newModel(actionsMetamodel);
		
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = new HashMap<String, Object>();
		
		launcherOptions.put("allowInterModelReferences", true); 
		launcher.initialize(launcherOptions);

		launcher.addInModel(loadedModel, "IN", ocl.mmName);
		launcher.addInModel(typWrapperModel, "IN2", typ.mmName);
		launcher.addOutModel(newModel, "OUT", "ACT");
			
		// Execute!
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
			
			// 
			throw new UnsupportedOperationException();
			// new ActionsEngine().apply(exp.getResource(), actions);
			
		}

		return exp.getResource();
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
