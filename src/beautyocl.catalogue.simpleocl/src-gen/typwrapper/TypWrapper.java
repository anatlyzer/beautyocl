/**
 */
package typwrapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typ Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see typwrapper.TypwrapperPackage#getTypWrapper()
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
	boolean isSameType(EObject e1, EObject e2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isSuperType(EObject e1_subtype, EObject e2_supertype);

} // TypWrapper
