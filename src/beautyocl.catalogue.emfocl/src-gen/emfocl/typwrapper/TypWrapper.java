/**
 */
package emfocl.typwrapper;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typ Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see emfocl.typwrapper.TypwrapperPackage#getTypWrapper()
 * @model
 * @generated
 */
public interface TypWrapper extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isSameType(OCLExpression e1, OCLExpression e2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isSuperType(OCLExpression e1_subtype, OCLExpression e2_supertype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setOperation(OperationCallExp e, String name);

} // TypWrapper
