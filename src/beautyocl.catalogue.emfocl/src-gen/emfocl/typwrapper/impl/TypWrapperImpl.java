/**
 */
package emfocl.typwrapper.impl;

import emfocl.typwrapper.TypWrapper;
import emfocl.typwrapper.TypwrapperPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.ecore.OCLExpression;

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
	 * @generated
	 */
	public boolean isSameType(OCLExpression e1, OCLExpression e2) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuperType(OCLExpression e1_subtype, OCLExpression e2_supertype) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
				return isSameType((OCLExpression)arguments.get(0), (OCLExpression)arguments.get(1));
			case TypwrapperPackage.TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION:
				return isSuperType((OCLExpression)arguments.get(0), (OCLExpression)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //TypWrapperImpl
