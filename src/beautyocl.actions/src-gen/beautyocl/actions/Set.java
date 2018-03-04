/**
 */
package beautyocl.actions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link beautyocl.actions.Set#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link beautyocl.actions.Set#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see beautyocl.actions.ActionsPackage#getSet()
 * @model
 * @generated
 */
public interface Set extends InPlaceAction {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see beautyocl.actions.ActionsPackage#getSet_PropertyName()
	 * @model required="true"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link beautyocl.actions.Set#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EObject)
	 * @see beautyocl.actions.ActionsPackage#getSet_Value()
	 * @model required="true"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link beautyocl.actions.Set#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

} // Set
