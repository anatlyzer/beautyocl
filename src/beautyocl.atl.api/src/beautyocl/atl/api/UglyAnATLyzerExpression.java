package beautyocl.atl.api;

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

	public UglyAnATLyzerExpression(ATLModel model) {
		this.model = model;
	}
	
	@Override
	public Resource getResource() {
		return model.getResource();
	}

}
