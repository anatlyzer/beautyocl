package beautyocl.api.simpleocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.simpleocl.OclExpression;

import beautyocl.api.common.UglyExpression;

public class UglySimpleOclExpression implements UglyExpression {

	private OclExpression constraint;

	public UglySimpleOclExpression(OclExpression oclExpression) {
		this.constraint = oclExpression;
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
		this.constraint = (OclExpression) tgt;
	}

	@Override
	public EObject getScope() {
		return this.constraint;
	}

	@Override
	public Resource getEcoreTypesResource() {
		throw new IllegalStateException();
	}

}
