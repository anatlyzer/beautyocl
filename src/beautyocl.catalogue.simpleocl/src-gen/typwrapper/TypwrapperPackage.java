/**
 */
package typwrapper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see typwrapper.TypwrapperFactory
 * @model kind="package"
 * @generated
 */
public interface TypwrapperPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "typwrapper";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://beautyocl/atl/simpleocl_typing_wrapper";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simpleocl_typing_wrapper";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypwrapperPackage eINSTANCE = typwrapper.impl.TypwrapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link typwrapper.impl.TypWrapperImpl <em>Typ Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see typwrapper.impl.TypWrapperImpl
	 * @see typwrapper.impl.TypwrapperPackageImpl#getTypWrapper()
	 * @generated
	 */
	int TYP_WRAPPER = 0;

	/**
	 * The number of structural features of the '<em>Typ Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Is Same Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER___IS_SAME_TYPE__EOBJECT_EOBJECT = 0;

	/**
	 * The operation id for the '<em>Is Super Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER___IS_SUPER_TYPE__EOBJECT_EOBJECT = 1;

	/**
	 * The number of operations of the '<em>Typ Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER_OPERATION_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link typwrapper.TypWrapper <em>Typ Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typ Wrapper</em>'.
	 * @see typwrapper.TypWrapper
	 * @generated
	 */
	EClass getTypWrapper();

	/**
	 * Returns the meta object for the '{@link typwrapper.TypWrapper#isSameType(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject) <em>Is Same Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Same Type</em>' operation.
	 * @see typwrapper.TypWrapper#isSameType(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getTypWrapper__IsSameType__EObject_EObject();

	/**
	 * Returns the meta object for the '{@link typwrapper.TypWrapper#isSuperType(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject) <em>Is Super Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Super Type</em>' operation.
	 * @see typwrapper.TypWrapper#isSuperType(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getTypWrapper__IsSuperType__EObject_EObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypwrapperFactory getTypwrapperFactory();

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
		 * The meta object literal for the '{@link typwrapper.impl.TypWrapperImpl <em>Typ Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see typwrapper.impl.TypWrapperImpl
		 * @see typwrapper.impl.TypwrapperPackageImpl#getTypWrapper()
		 * @generated
		 */
		EClass TYP_WRAPPER = eINSTANCE.getTypWrapper();

		/**
		 * The meta object literal for the '<em><b>Is Same Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___IS_SAME_TYPE__EOBJECT_EOBJECT = eINSTANCE.getTypWrapper__IsSameType__EObject_EObject();

		/**
		 * The meta object literal for the '<em><b>Is Super Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___IS_SUPER_TYPE__EOBJECT_EOBJECT = eINSTANCE.getTypWrapper__IsSuperType__EObject_EObject();

	}

} //TypwrapperPackage
