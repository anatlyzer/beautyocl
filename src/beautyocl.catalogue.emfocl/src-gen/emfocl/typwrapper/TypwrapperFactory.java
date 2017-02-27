/**
 */
package emfocl.typwrapper;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see emfocl.typwrapper.TypwrapperPackage
 * @generated
 */
public interface TypwrapperFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypwrapperFactory eINSTANCE = emfocl.typwrapper.impl.TypwrapperFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Typ Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typ Wrapper</em>'.
	 * @generated
	 */
	TypWrapper createTypWrapper();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypwrapperPackage getTypwrapperPackage();

} //TypwrapperFactory
