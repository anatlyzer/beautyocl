/**
 */
package beautyocl.actions.impl;

import beautyocl.actions.ActionsPackage;
import beautyocl.actions.Clone;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clone</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link beautyocl.actions.impl.CloneImpl#getIgnoredProperties <em>Ignored Properties</em>}</li>
 *   <li>{@link beautyocl.actions.impl.CloneImpl#getValues <em>Values</em>}</li>
 *   <li>{@link beautyocl.actions.impl.CloneImpl#getReplaceReferenceTo <em>Replace Reference To</em>}</li>
 *   <li>{@link beautyocl.actions.impl.CloneImpl#getWithReplacement <em>With Replacement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CloneImpl extends InPlaceActionImpl implements Clone {
	/**
	 * The cached value of the '{@link #getIgnoredProperties() <em>Ignored Properties</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoredProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ignoredProperties;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> values;

	/**
	 * The cached value of the '{@link #getReplaceReferenceTo() <em>Replace Reference To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplaceReferenceTo()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> replaceReferenceTo;

	/**
	 * The cached value of the '{@link #getWithReplacement() <em>With Replacement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWithReplacement()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> withReplacement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.CLONE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIgnoredProperties() {
		if (ignoredProperties == null) {
			ignoredProperties = new EDataTypeUniqueEList<String>(String.class, this, ActionsPackage.CLONE__IGNORED_PROPERTIES);
		}
		return ignoredProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getValues() {
		if (values == null) {
			values = new EObjectResolvingEList<EObject>(EObject.class, this, ActionsPackage.CLONE__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getReplaceReferenceTo() {
		if (replaceReferenceTo == null) {
			replaceReferenceTo = new EObjectResolvingEList<EObject>(EObject.class, this, ActionsPackage.CLONE__REPLACE_REFERENCE_TO);
		}
		return replaceReferenceTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getWithReplacement() {
		if (withReplacement == null) {
			withReplacement = new EObjectResolvingEList<EObject>(EObject.class, this, ActionsPackage.CLONE__WITH_REPLACEMENT);
		}
		return withReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionsPackage.CLONE__IGNORED_PROPERTIES:
				return getIgnoredProperties();
			case ActionsPackage.CLONE__VALUES:
				return getValues();
			case ActionsPackage.CLONE__REPLACE_REFERENCE_TO:
				return getReplaceReferenceTo();
			case ActionsPackage.CLONE__WITH_REPLACEMENT:
				return getWithReplacement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionsPackage.CLONE__IGNORED_PROPERTIES:
				getIgnoredProperties().clear();
				getIgnoredProperties().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.CLONE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends EObject>)newValue);
				return;
			case ActionsPackage.CLONE__REPLACE_REFERENCE_TO:
				getReplaceReferenceTo().clear();
				getReplaceReferenceTo().addAll((Collection<? extends EObject>)newValue);
				return;
			case ActionsPackage.CLONE__WITH_REPLACEMENT:
				getWithReplacement().clear();
				getWithReplacement().addAll((Collection<? extends EObject>)newValue);
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
			case ActionsPackage.CLONE__IGNORED_PROPERTIES:
				getIgnoredProperties().clear();
				return;
			case ActionsPackage.CLONE__VALUES:
				getValues().clear();
				return;
			case ActionsPackage.CLONE__REPLACE_REFERENCE_TO:
				getReplaceReferenceTo().clear();
				return;
			case ActionsPackage.CLONE__WITH_REPLACEMENT:
				getWithReplacement().clear();
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
			case ActionsPackage.CLONE__IGNORED_PROPERTIES:
				return ignoredProperties != null && !ignoredProperties.isEmpty();
			case ActionsPackage.CLONE__VALUES:
				return values != null && !values.isEmpty();
			case ActionsPackage.CLONE__REPLACE_REFERENCE_TO:
				return replaceReferenceTo != null && !replaceReferenceTo.isEmpty();
			case ActionsPackage.CLONE__WITH_REPLACEMENT:
				return withReplacement != null && !withReplacement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ignoredProperties: ");
		result.append(ignoredProperties);
		result.append(')');
		return result.toString();
	}

} //CloneImpl
