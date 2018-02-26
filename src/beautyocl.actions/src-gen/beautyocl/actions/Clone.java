/**
 */
package beautyocl.actions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clone</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link beautyocl.actions.Clone#getIgnoredProperties <em>Ignored Properties</em>}</li>
 *   <li>{@link beautyocl.actions.Clone#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see beautyocl.actions.ActionsPackage#getClone()
 * @model
 * @generated
 */
public interface Clone extends InPlaceAction {
	/**
	 * Returns the value of the '<em><b>Ignored Properties</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignored Properties</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignored Properties</em>' attribute list.
	 * @see beautyocl.actions.ActionsPackage#getClone_IgnoredProperties()
	 * @model
	 * @generated
	 */
	EList<String> getIgnoredProperties();

	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see beautyocl.actions.ActionsPackage#getClone_Values()
	 * @model
	 * @generated
	 */
	EList<EObject> getValues();

} // Clone
