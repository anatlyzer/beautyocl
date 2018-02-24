/**
 */
package beautyocl.actions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Place Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link beautyocl.actions.InPlaceAction#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link beautyocl.actions.InPlaceAction#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see beautyocl.actions.ActionsPackage#getInPlaceAction()
 * @model abstract="true"
 * @generated
 */
public interface InPlaceAction extends EObject {

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' attribute.
	 * @see #setTransformation(String)
	 * @see beautyocl.actions.ActionsPackage#getInPlaceAction_Transformation()
	 * @model
	 * @generated
	 */
	String getTransformation();

	/**
	 * Sets the value of the '{@link beautyocl.actions.InPlaceAction#getTransformation <em>Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' attribute.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EObject)
	 * @see beautyocl.actions.ActionsPackage#getInPlaceAction_Source()
	 * @model required="true"
	 * @generated
	 */
	EObject getSource();

	/**
	 * Sets the value of the '{@link beautyocl.actions.InPlaceAction#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EObject value);
} // InPlaceAction
