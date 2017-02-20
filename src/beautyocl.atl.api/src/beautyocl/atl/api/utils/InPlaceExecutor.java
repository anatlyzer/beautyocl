package beautyocl.atl.api.utils;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.OCL.OCLPackage;
import beautyocl.atl.api.UglyExpression;

public class InPlaceExecutor {

	public void apply(InputStream asmFile, UglyExpression exp) throws ATLCoreException, IOException {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		// ResourceSet rs = new ResourceSetImpl();

		Model aModel = EmftvmFactory.eINSTANCE.createModel();
		aModel.setResource(exp.getResource());

		Metamodel mm = EmftvmFactory.eINSTANCE.createMetamodel();
		mm.setResource(OCLPackage.eINSTANCE.eResource());
		
		env.registerMetaModel("ATL", mm);
		env.registerInOutModel("IN", aModel);
		
		ModuleResolver mr = new ModuleResolver() {			
			@Override
			public Module resolveModule(String name) throws ModuleNotFoundException {
				Resource r = new EMFTVMResourceImpl();
				try {
					r.load(asmFile, null);
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
				//Resource r = rs.getResource(URI.createFileURI(b), true);
				return (Module) r.getContents().get(0);
			}
		};
		TimingData td = new TimingData();
		env.loadModule(mr, "inplace");

		
		System.out.println("Pre");
		System.out.println( ATLSerializer.serialize(aModel.getResource().getContents().get(0)) );

		
		td.finishLoading();
		env.run(td);
		td.finish();
		
		
		
		System.out.println("Post");
		System.out.println( ATLSerializer.serialize(aModel.getResource().getContents().get(0)) );

		
	}

	
	

	
	
}
