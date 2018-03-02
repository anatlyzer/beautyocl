/**
 */
package beautyocl.atl.comparisonwrapper;

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
 * @see beautyocl.atl.comparisonwrapper.ComparisonwrapperFactory
 * @model kind="package"
 * @generated
 */
public interface ComparisonwrapperPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "comparisonwrapper";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://beautyocl/atl/comparison_wrapper";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "comparison_wrapper";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComparisonwrapperPackage eINSTANCE = beautyocl.atl.comparisonwrapper.impl.ComparisonwrapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link beautyocl.atl.comparisonwrapper.impl.ComparisonWrapperImpl <em>Comparison Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see beautyocl.atl.comparisonwrapper.impl.ComparisonWrapperImpl
	 * @see beautyocl.atl.comparisonwrapper.impl.ComparisonwrapperPackageImpl#getComparisonWrapper()
	 * @generated
	 */
	int COMPARISON_WRAPPER = 0;

	/**
	 * The number of structural features of the '<em>Comparison Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_WRAPPER_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Is Same Expr</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_WRAPPER___IS_SAME_EXPR__OCLEXPRESSION_OCLEXPRESSION = 0;

	/**
	 * The number of operations of the '<em>Comparison Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_WRAPPER_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link beautyocl.atl.comparisonwrapper.ComparisonWrapper <em>Comparison Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison Wrapper</em>'.
	 * @see beautyocl.atl.comparisonwrapper.ComparisonWrapper
	 * @generated
	 */
	EClass getComparisonWrapper();

	/**
	 * Returns the meta object for the '{@link beautyocl.atl.comparisonwrapper.ComparisonWrapper#isSameExpr(anatlyzer.atlext.OCL.OclExpression, anatlyzer.atlext.OCL.OclExpression) <em>Is Same Expr</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Same Expr</em>' operation.
	 * @see beautyocl.atl.comparisonwrapper.ComparisonWrapper#isSameExpr(anatlyzer.atlext.OCL.OclExpression, anatlyzer.atlext.OCL.OclExpression)
	 * @generated
	 */
	EOperation getComparisonWrapper__IsSameExpr__OclExpression_OclExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComparisonwrapperFactory getComparisonwrapperFactory();

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
		 * The meta object literal for the '{@link beautyocl.atl.comparisonwrapper.impl.ComparisonWrapperImpl <em>Comparison Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see beautyocl.atl.comparisonwrapper.impl.ComparisonWrapperImpl
		 * @see beautyocl.atl.comparisonwrapper.impl.ComparisonwrapperPackageImpl#getComparisonWrapper()
		 * @generated
		 */
		EClass COMPARISON_WRAPPER = eINSTANCE.getComparisonWrapper();

		/**
		 * The meta object literal for the '<em><b>Is Same Expr</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPARISON_WRAPPER___IS_SAME_EXPR__OCLEXPRESSION_OCLEXPRESSION = eINSTANCE.getComparisonWrapper__IsSameExpr__OclExpression_OclExpression();

	}

} //ComparisonwrapperPackage
