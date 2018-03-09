package beautyocl.api.simpleocl;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;

import beautyocl.api.common.AbstractInPlaceExecutorATL;
import beautyocl.api.common.UglyExpression;

public class SimpleOCLInPlaceExecutor extends AbstractInPlaceExecutorATL {

	private UglyExpression exp;

	public SimpleOCLInPlaceExecutor(UglyExpression exp) {
		this.exp = exp;
	}

	@Override
	protected ModelDef initOCLVariant(EMFModelFactory factory, EMFInjector injector) throws ATLCoreException {
		IReferenceModel loadedMetamodel = factory.newReferenceModel();		
		injector.inject(loadedMetamodel, "http://eclipselabs.org/simpleocl/2013/SimpleOCL");
		
		EMFModel loadedModel = (EMFModel) factory.newModel(loadedMetamodel);
		injector.inject(loadedModel, exp.getResource());
		
		return new ModelDef(loadedMetamodel, loadedModel, "EMF");
	}

	@Override
	protected ModelDef initTypingWrapper(EMFModelFactory factory, EMFInjector injector) throws ATLCoreException {
		IReferenceModel typWrapperMetamodel = factory.newReferenceModel();
		injector.inject(typWrapperMetamodel, "http://beautyocl/atl/simpleocl_typing_wrapper");
		
		EMFModel typWrapperModel = (EMFModel) factory.newModel(typWrapperMetamodel);
		typWrapperModel.newElement(typWrapperMetamodel.getMetaElementByName("TypWrapper"));
		typWrapperModel.commitToResource();

		return new ModelDef(typWrapperMetamodel, typWrapperModel, "WRAP");
	}



}
