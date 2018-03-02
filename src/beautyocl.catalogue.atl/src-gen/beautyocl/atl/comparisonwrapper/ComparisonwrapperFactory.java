/**
 */
package beautyocl.atl.comparisonwrapper;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see beautyocl.atl.comparisonwrapper.ComparisonwrapperPackage
 * @generated
 */
public interface ComparisonwrapperFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComparisonwrapperFactory eINSTANCE = beautyocl.atl.comparisonwrapper.impl.ComparisonwrapperFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Comparison Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comparison Wrapper</em>'.
	 * @generated
	 */
	ComparisonWrapper createComparisonWrapper();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComparisonwrapperPackage getComparisonwrapperPackage();

} //ComparisonwrapperFactory
