/**
 */
package beautyocl.atl.typwrapper;

import anatlyzer.atlext.OCL.OclExpression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typ Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see beautyocl.atl.typwrapper.TypwrapperPackage#getTypWrapper()
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
	boolean isSameType(OclExpression e1, OclExpression e2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isSuperType(OclExpression e1_subtype, OclExpression e2_supertype);

} // TypWrapper
