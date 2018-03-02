/**
 */
package beautyocl.atl.comparisonwrapper.impl;

import beautyocl.atl.comparisonwrapper.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComparisonwrapperFactoryImpl extends EFactoryImpl implements ComparisonwrapperFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComparisonwrapperFactory init() {
		try {
			ComparisonwrapperFactory theComparisonwrapperFactory = (ComparisonwrapperFactory)EPackage.Registry.INSTANCE.getEFactory(ComparisonwrapperPackage.eNS_URI);
			if (theComparisonwrapperFactory != null) {
				return theComparisonwrapperFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComparisonwrapperFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonwrapperFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComparisonwrapperPackage.COMPARISON_WRAPPER: return createComparisonWrapper();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonWrapper createComparisonWrapper() {
		ComparisonWrapperImpl comparisonWrapper = new ComparisonWrapperImpl();
		return comparisonWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonwrapperPackage getComparisonwrapperPackage() {
		return (ComparisonwrapperPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComparisonwrapperPackage getPackage() {
		return ComparisonwrapperPackage.eINSTANCE;
	}

} //ComparisonwrapperFactoryImpl
