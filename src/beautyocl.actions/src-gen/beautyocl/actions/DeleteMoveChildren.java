/**
 */
package beautyocl.actions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Move Children</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link beautyocl.actions.DeleteMoveChildren#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see beautyocl.actions.ActionsPackage#getDeleteMoveChildren()
 * @model
 * @generated
 */
public interface DeleteMoveChildren extends InPlaceAction {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference.
	 * @see #setChildren(EObject)
	 * @see beautyocl.actions.ActionsPackage#getDeleteMoveChildren_Children()
	 * @model required="true"
	 * @generated
	 */
	EObject getChildren();

	/**
	 * Sets the value of the '{@link beautyocl.actions.DeleteMoveChildren#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' reference.
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(EObject value);

} // DeleteMoveChildren
