package beautyocl.atl.api;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import anatlyzer.atl.model.ATLModel;
import beautyocl.api.common.UglyExpression;

/**
 * This is a wrapper for OCL expressions represented with the
 * AnATLyzer AST.
 * 
 * @author jesus
 */
public class UglyAnATLyzerExpression implements UglyExpression {

	private ATLModel model;
	private EObject obj;

	public UglyAnATLyzerExpression(ATLModel model, EObject obj) {
		this.model = model;
		this.obj = obj;
	}
	
	@Override
	public Resource getResource() {
		if ( obj != null ) {
			return obj.eResource();			
		}
		return model.getResource();
	}
	
	public EObject getScope() {
		return obj;
	}

	@Override
	public EObject getRoot() {
		return obj;
	}

	@Override
	public void setRoot(EObject root) {
		if ( root == null ) throw new IllegalArgumentException();
		this.obj = root;
	}

	@Override
	public Resource getEcoreTypesResource() {
		return new ResourceImpl(); 
		// TODO: Should gather the types somehow...
	}
	
}
