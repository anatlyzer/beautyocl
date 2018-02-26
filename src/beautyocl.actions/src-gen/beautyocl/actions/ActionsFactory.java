/**
 */
package beautyocl.actions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see beautyocl.actions.ActionsPackage
 * @generated
 */
public interface ActionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsFactory eINSTANCE = beautyocl.actions.impl.ActionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Replace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replace</em>'.
	 * @generated
	 */
	Replace createReplace();

	/**
	 * Returns a new object of class '<em>Delete Move Children</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Move Children</em>'.
	 * @generated
	 */
	DeleteMoveChildren createDeleteMoveChildren();

	/**
	 * Returns a new object of class '<em>Clone</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone</em>'.
	 * @generated
	 */
	Clone createClone();

	/**
	 * Returns a new object of class '<em>Composite Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Action</em>'.
	 * @generated
	 */
	CompositeAction createCompositeAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActionsPackage getActionsPackage();

} //ActionsFactory
