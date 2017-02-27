package beautyocl.api.emfocl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import beautyocl.api.common.UglyExpression;

public class UglyEMFOclExpression implements UglyExpression {

	private OCLExpression constraint;

	public UglyEMFOclExpression(OCLExpression oclExpression) {
		this.constraint = oclExpression;
	}
	
	@Override
	public Resource getResource() {
		return constraint.eResource();
	}

}
