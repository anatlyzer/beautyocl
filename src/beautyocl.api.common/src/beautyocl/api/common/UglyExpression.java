package beautyocl.api.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import beautyocl.actions.IExpressionHolder;

public interface UglyExpression extends IExpressionHolder {

	Resource getResource();
	
	EObject getScope();

	/**
	 * @return A resource with the ecore elements used to type the expression.
	 */
	Resource getEcoreTypesResource();
	
}
