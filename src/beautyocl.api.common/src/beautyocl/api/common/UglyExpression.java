package beautyocl.api.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public interface UglyExpression {

	Resource getResource();
	
	EObject getScope();

}
