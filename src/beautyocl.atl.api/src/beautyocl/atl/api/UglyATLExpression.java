package beautyocl.atl.api;

import org.eclipse.emf.ecore.resource.Resource;

import beautyocl.api.common.UglyExpression;

/**
 * This is a wrapper for OCL expressions represented with the
 * regular ATL AST.
 * 
 * @author jesus
 */
public class UglyATLExpression implements UglyExpression {

	@Override
	public Resource getResource() {
		throw new UnsupportedOperationException();
	}

}
