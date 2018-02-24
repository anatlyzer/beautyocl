/**
 */
package beautyocl.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see beautyocl.actions.ActionsFactory
 * @model kind="package"
 * @generated
 */
public interface ActionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://beautyocl/actions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "actions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsPackage eINSTANCE = beautyocl.actions.impl.ActionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link beautyocl.actions.impl.InPlaceActionImpl <em>In Place Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see beautyocl.actions.impl.InPlaceActionImpl
	 * @see beautyocl.actions.impl.ActionsPackageImpl#getInPlaceAction()
	 * @generated
	 */
	int IN_PLACE_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PLACE_ACTION__TRANSFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PLACE_ACTION__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>In Place Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PLACE_ACTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>In Place Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PLACE_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link beautyocl.actions.impl.ReplaceImpl <em>Replace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see beautyocl.actions.impl.ReplaceImpl
	 * @see beautyocl.actions.impl.ActionsPackageImpl#getReplace()
	 * @generated
	 */
	int REPLACE = 1;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__TRANSFORMATION = IN_PLACE_ACTION__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__SOURCE = IN_PLACE_ACTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__TARGET = IN_PLACE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_FEATURE_COUNT = IN_PLACE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Replace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_OPERATION_COUNT = IN_PLACE_ACTION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link beautyocl.actions.impl.DeleteMoveChildrenImpl <em>Delete Move Children</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see beautyocl.actions.impl.DeleteMoveChildrenImpl
	 * @see beautyocl.actions.impl.ActionsPackageImpl#getDeleteMoveChildren()
	 * @generated
	 */
	int DELETE_MOVE_CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE_CHILDREN__TRANSFORMATION = IN_PLACE_ACTION__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE_CHILDREN__SOURCE = IN_PLACE_ACTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE_CHILDREN__CHILDREN = IN_PLACE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Move Children</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE_CHILDREN_FEATURE_COUNT = IN_PLACE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete Move Children</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE_CHILDREN_OPERATION_COUNT = IN_PLACE_ACTION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link beautyocl.actions.InPlaceAction <em>In Place Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Place Action</em>'.
	 * @see beautyocl.actions.InPlaceAction
	 * @generated
	 */
	EClass getInPlaceAction();

	/**
	 * Returns the meta object for the attribute '{@link beautyocl.actions.InPlaceAction#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transformation</em>'.
	 * @see beautyocl.actions.InPlaceAction#getTransformation()
	 * @see #getInPlaceAction()
	 * @generated
	 */
	EAttribute getInPlaceAction_Transformation();

	/**
	 * Returns the meta object for the reference '{@link beautyocl.actions.InPlaceAction#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see beautyocl.actions.InPlaceAction#getSource()
	 * @see #getInPlaceAction()
	 * @generated
	 */
	EReference getInPlaceAction_Source();

	/**
	 * Returns the meta object for class '{@link beautyocl.actions.Replace <em>Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace</em>'.
	 * @see beautyocl.actions.Replace
	 * @generated
	 */
	EClass getReplace();

	/**
	 * Returns the meta object for the reference '{@link beautyocl.actions.Replace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see beautyocl.actions.Replace#getTarget()
	 * @see #getReplace()
	 * @generated
	 */
	EReference getReplace_Target();

	/**
	 * Returns the meta object for class '{@link beautyocl.actions.DeleteMoveChildren <em>Delete Move Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Move Children</em>'.
	 * @see beautyocl.actions.DeleteMoveChildren
	 * @generated
	 */
	EClass getDeleteMoveChildren();

	/**
	 * Returns the meta object for the reference '{@link beautyocl.actions.DeleteMoveChildren#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Children</em>'.
	 * @see beautyocl.actions.DeleteMoveChildren#getChildren()
	 * @see #getDeleteMoveChildren()
	 * @generated
	 */
	EReference getDeleteMoveChildren_Children();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionsFactory getActionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link beautyocl.actions.impl.InPlaceActionImpl <em>In Place Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see beautyocl.actions.impl.InPlaceActionImpl
		 * @see beautyocl.actions.impl.ActionsPackageImpl#getInPlaceAction()
		 * @generated
		 */
		EClass IN_PLACE_ACTION = eINSTANCE.getInPlaceAction();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PLACE_ACTION__TRANSFORMATION = eINSTANCE.getInPlaceAction_Transformation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PLACE_ACTION__SOURCE = eINSTANCE.getInPlaceAction_Source();

		/**
		 * The meta object literal for the '{@link beautyocl.actions.impl.ReplaceImpl <em>Replace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see beautyocl.actions.impl.ReplaceImpl
		 * @see beautyocl.actions.impl.ActionsPackageImpl#getReplace()
		 * @generated
		 */
		EClass REPLACE = eINSTANCE.getReplace();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACE__TARGET = eINSTANCE.getReplace_Target();

		/**
		 * The meta object literal for the '{@link beautyocl.actions.impl.DeleteMoveChildrenImpl <em>Delete Move Children</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see beautyocl.actions.impl.DeleteMoveChildrenImpl
		 * @see beautyocl.actions.impl.ActionsPackageImpl#getDeleteMoveChildren()
		 * @generated
		 */
		EClass DELETE_MOVE_CHILDREN = eINSTANCE.getDeleteMoveChildren();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_MOVE_CHILDREN__CHILDREN = eINSTANCE.getDeleteMoveChildren_Children();

	}

} //ActionsPackage
