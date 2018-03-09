package beautyocl.api.emfocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import beautyocl.api.common.UglyExpression;

public class UglyEMFOclExpression implements UglyExpression {

	private OCLExpression constraint;
	private Resource metamodel;

	public UglyEMFOclExpression(OCLExpression oclExpression, Resource mm) {
		this.constraint = oclExpression;
		this.metamodel = mm;
	}
	
	@Override
	public Resource getResource() {
		return constraint.eResource();
	}

	@Override
	public EObject getRoot() {
		return this.constraint;
	}

	@Override
	public void setRoot(EObject tgt) {
		this.constraint = (OCLExpression) tgt;
	}

	@Override
	public EObject getScope() {
		return this.constraint;
	}

	@Override
	public Resource getEcoreTypesResource() {
		return metamodel;
	}

}
