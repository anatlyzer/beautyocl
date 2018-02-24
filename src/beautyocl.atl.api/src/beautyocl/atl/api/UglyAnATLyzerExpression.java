package beautyocl.atl.api;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

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

}
