/**
 */
package beautyocl.atl.typwrapper;

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
 * @see beautyocl.atl.typwrapper.TypwrapperFactory
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
	String eNS_URI = "http://beautyocl/atl/typing_wrapper";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "typing_wrapper";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypwrapperPackage eINSTANCE = beautyocl.atl.typwrapper.impl.TypwrapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link beautyocl.atl.typwrapper.impl.TypWrapperImpl <em>Typ Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see beautyocl.atl.typwrapper.impl.TypWrapperImpl
	 * @see beautyocl.atl.typwrapper.impl.TypwrapperPackageImpl#getTypWrapper()
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
	 * The operation id for the '<em>Access Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER___ACCESS_TYPE__PROPERTYCALLEXP = 2;

	/**
	 * The operation id for the '<em>Type Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER___TYPE_OF__OCLEXPRESSION = 3;

	/**
	 * The number of operations of the '<em>Typ Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYP_WRAPPER_OPERATION_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link beautyocl.atl.typwrapper.TypWrapper <em>Typ Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typ Wrapper</em>'.
	 * @see beautyocl.atl.typwrapper.TypWrapper
	 * @generated
	 */
	EClass getTypWrapper();

	/**
	 * Returns the meta object for the '{@link beautyocl.atl.typwrapper.TypWrapper#isSameType(anatlyzer.atlext.OCL.OclExpression, anatlyzer.atlext.OCL.OclExpression) <em>Is Same Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Same Type</em>' operation.
	 * @see beautyocl.atl.typwrapper.TypWrapper#isSameType(anatlyzer.atlext.OCL.OclExpression, anatlyzer.atlext.OCL.OclExpression)
	 * @generated
	 */
	EOperation getTypWrapper__IsSameType__OclExpression_OclExpression();

	/**
	 * Returns the meta object for the '{@link beautyocl.atl.typwrapper.TypWrapper#isSuperType(anatlyzer.atlext.OCL.OclExpression, anatlyzer.atlext.OCL.OclExpression) <em>Is Super Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Super Type</em>' operation.
	 * @see beautyocl.atl.typwrapper.TypWrapper#isSuperType(anatlyzer.atlext.OCL.OclExpression, anatlyzer.atlext.OCL.OclExpression)
	 * @generated
	 */
	EOperation getTypWrapper__IsSuperType__OclExpression_OclExpression();

	/**
	 * Returns the meta object for the '{@link beautyocl.atl.typwrapper.TypWrapper#accessType(anatlyzer.atlext.OCL.PropertyCallExp) <em>Access Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Access Type</em>' operation.
	 * @see beautyocl.atl.typwrapper.TypWrapper#accessType(anatlyzer.atlext.OCL.PropertyCallExp)
	 * @generated
	 */
	EOperation getTypWrapper__AccessType__PropertyCallExp();

	/**
	 * Returns the meta object for the '{@link beautyocl.atl.typwrapper.TypWrapper#typeOf(anatlyzer.atlext.OCL.OclExpression) <em>Type Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Type Of</em>' operation.
	 * @see beautyocl.atl.typwrapper.TypWrapper#typeOf(anatlyzer.atlext.OCL.OclExpression)
	 * @generated
	 */
	EOperation getTypWrapper__TypeOf__OclExpression();

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
		 * The meta object literal for the '{@link beautyocl.atl.typwrapper.impl.TypWrapperImpl <em>Typ Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see beautyocl.atl.typwrapper.impl.TypWrapperImpl
		 * @see beautyocl.atl.typwrapper.impl.TypwrapperPackageImpl#getTypWrapper()
		 * @generated
		 */
		EClass TYP_WRAPPER = eINSTANCE.getTypWrapper();

		/**
		 * The meta object literal for the '<em><b>Is Same Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___IS_SAME_TYPE__OCLEXPRESSION_OCLEXPRESSION = eINSTANCE.getTypWrapper__IsSameType__OclExpression_OclExpression();

		/**
		 * The meta object literal for the '<em><b>Is Super Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION = eINSTANCE.getTypWrapper__IsSuperType__OclExpression_OclExpression();

		/**
		 * The meta object literal for the '<em><b>Access Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___ACCESS_TYPE__PROPERTYCALLEXP = eINSTANCE.getTypWrapper__AccessType__PropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Type Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYP_WRAPPER___TYPE_OF__OCLEXPRESSION = eINSTANCE.getTypWrapper__TypeOf__OclExpression();

	}

} //TypwrapperPackage
