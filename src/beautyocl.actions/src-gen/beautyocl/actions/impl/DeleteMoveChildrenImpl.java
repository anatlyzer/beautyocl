/**
 */
package beautyocl.actions.impl;

import beautyocl.actions.ActionsPackage;
import beautyocl.actions.DeleteMoveChildren;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Move Children</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link beautyocl.actions.impl.DeleteMoveChildrenImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeleteMoveChildrenImpl extends InPlaceActionImpl implements DeleteMoveChildren {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EObject children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteMoveChildrenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.DELETE_MOVE_CHILDREN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getChildren() {
		if (children != null && children.eIsProxy()) {
			InternalEObject oldChildren = (InternalEObject)children;
			children = eResolveProxy(oldChildren);
			if (children != oldChildren) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.DELETE_MOVE_CHILDREN__CHILDREN, oldChildren, children));
			}
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetChildren() {
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildren(EObject newChildren) {
		EObject oldChildren = children;
		children = newChildren;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.DELETE_MOVE_CHILDREN__CHILDREN, oldChildren, children));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionsPackage.DELETE_MOVE_CHILDREN__CHILDREN:
				if (resolve) return getChildren();
				return basicGetChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionsPackage.DELETE_MOVE_CHILDREN__CHILDREN:
				setChildren((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ActionsPackage.DELETE_MOVE_CHILDREN__CHILDREN:
				setChildren((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActionsPackage.DELETE_MOVE_CHILDREN__CHILDREN:
				return children != null;
		}
		return super.eIsSet(featureID);
	}

} //DeleteMoveChildrenImpl
