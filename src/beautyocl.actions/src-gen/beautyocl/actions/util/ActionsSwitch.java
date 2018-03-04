/**
 */
package beautyocl.actions.util;

import beautyocl.actions.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see beautyocl.actions.ActionsPackage
 * @generated
 */
public class ActionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ActionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ActionsPackage.IN_PLACE_ACTION: {
				InPlaceAction inPlaceAction = (InPlaceAction)theEObject;
				T result = caseInPlaceAction(inPlaceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionsPackage.REPLACE: {
				Replace replace = (Replace)theEObject;
				T result = caseReplace(replace);
				if (result == null) result = caseInPlaceAction(replace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionsPackage.DELETE_MOVE_CHILDREN: {
				DeleteMoveChildren deleteMoveChildren = (DeleteMoveChildren)theEObject;
				T result = caseDeleteMoveChildren(deleteMoveChildren);
				if (result == null) result = caseInPlaceAction(deleteMoveChildren);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionsPackage.CLONE: {
				Clone clone = (Clone)theEObject;
				T result = caseClone(clone);
				if (result == null) result = caseInPlaceAction(clone);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionsPackage.COMPOSITE_ACTION: {
				CompositeAction compositeAction = (CompositeAction)theEObject;
				T result = caseCompositeAction(compositeAction);
				if (result == null) result = caseInPlaceAction(compositeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionsPackage.SET_P: {
				SetP setP = (SetP)theEObject;
				T result = caseSetP(setP);
				if (result == null) result = caseInPlaceAction(setP);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Place Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Place Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInPlaceAction(InPlaceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplace(Replace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Move Children</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Move Children</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteMoveChildren(DeleteMoveChildren object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClone(Clone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeAction(CompositeAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set P</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set P</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetP(SetP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ActionsSwitch
