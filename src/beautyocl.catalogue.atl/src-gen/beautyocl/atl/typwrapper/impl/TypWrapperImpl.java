/**
 */
package beautyocl.atl.typwrapper.impl;

import anatlyzer.atl.model.TypeUtils;
import anatlyzer.atl.model.TypingModel;
import anatlyzer.atlext.OCL.OclExpression;

import beautyocl.atl.typwrapper.TypWrapper;
import beautyocl.atl.typwrapper.TypwrapperPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typ Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TypWrapperImpl extends MinimalEObjectImpl.Container implements TypWrapper {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypWrapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypwrapperPackage.Literals.TYP_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSameType(OclExpression e1, OclExpression e2) {
		return TypingModel.equalTypes(e1.getInferredType(), e2.getInferredType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSuperType(OclExpression e1_subtype, OclExpression e2_supertype) {
		return TypingModel.isCompatible(e1_subtype.getInferredType(), e2_supertype.getInferredType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TypwrapperPackage.TYP_WRAPPER___IS_SAME_TYPE__OCLEXPRESSION_OCLEXPRESSION:
				return isSameType((OclExpression)arguments.get(0), (OclExpression)arguments.get(1));
			case TypwrapperPackage.TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION:
				return isSuperType((OclExpression)arguments.get(0), (OclExpression)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //TypWrapperImpl
