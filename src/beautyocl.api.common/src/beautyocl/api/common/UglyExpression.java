package beautyocl.api.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import beautyocl.actions.IExpressionHolder;

public interface UglyExpression extends IExpressionHolder {

	Resource getResource();
	
	EObject getScope();

}
