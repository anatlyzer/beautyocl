/**
 */
package emfocl.typwrapper;

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
 * @see emfocl.typwrapper.TypwrapperFactory
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
	String eNS_URI = "http://beautyocl/atl/emfocl_typing_wrapper";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "emfocl_typing_wrapper";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypwrapperPackage eINSTANCE = emfocl.typwrapper.impl.TypwrapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link emfocl.typwrapper.impl.TypWrapperImpl <em>Typ Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see emfocl.typwrapper.impl.TypWrapperImpl
	 * @see emfocl.typwrapper.impl.TypwrapperPackageImpl#getTypWrapper()
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
	int TYP_WRAPPER___IS_SAME_TYPE__OCLEXPRESSION_OCLEXPRESSION = 0;

	/**
	 * The operation id for the '<em>Is Super Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION = 1;

	/**
	 * The number of operations of the '<em>Typ Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER_OPERATION_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link emfocl.typwrapper.TypWrapper <em>Typ Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typ Wrapper</em>'.
	 * @see emfocl.typwrapper.TypWrapper
	 * @generated
	 */
	EClass getTypWrapper();

	/**
	 * Returns the meta object for the '{@link emfocl.typwrapper.TypWrapper#isSameType(org.eclipse.ocl.ecore.OCLExpression, org.eclipse.ocl.ecore.OCLExpression) <em>Is Same Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Same Type</em>' operation.
	 * @see emfocl.typwrapper.TypWrapper#isSameType(org.eclipse.ocl.ecore.OCLExpression, org.eclipse.ocl.ecore.OCLExpression)
	 * @generated
	 */
	EOperation getTypWrapper__IsSameType__OCLExpression_OCLExpression();

	/**
	 * Returns the meta object for the '{@link emfocl.typwrapper.TypWrapper#isSuperType(org.eclipse.ocl.ecore.OCLExpression, org.eclipse.ocl.ecore.OCLExpression) <em>Is Super Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Super Type</em>' operation.
	 * @see emfocl.typwrapper.TypWrapper#isSuperType(org.eclipse.ocl.ecore.OCLExpression, org.eclipse.ocl.ecore.OCLExpression)
	 * @generated
	 */
	EOperation getTypWrapper__IsSuperType__OCLExpression_OCLExpression();

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
		 * The meta object literal for the '{@link emfocl.typwrapper.impl.TypWrapperImpl <em>Typ Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see emfocl.typwrapper.impl.TypWrapperImpl
		 * @see emfocl.typwrapper.impl.TypwrapperPackageImpl#getTypWrapper()
		 * @generated
		 */
		EClass TYP_WRAPPER = eINSTANCE.getTypWrapper();

		/**
		 * The meta object literal for the '<em><b>Is Same Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___IS_SAME_TYPE__OCLEXPRESSION_OCLEXPRESSION = eINSTANCE.getTypWrapper__IsSameType__OCLExpression_OCLExpression();

		/**
		 * The meta object literal for the '<em><b>Is Super Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION = eINSTANCE.getTypWrapper__IsSuperType__OCLExpression_OCLExpression();

	}

} //TypwrapperPackage
