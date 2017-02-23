/**
 */
package beautyocl.atl.typwrapper.impl;

import beautyocl.atl.typwrapper.*;

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
public class TypwrapperFactoryImpl extends EFactoryImpl implements TypwrapperFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypwrapperFactory init() {
		try {
			TypwrapperFactory theTypwrapperFactory = (TypwrapperFactory)EPackage.Registry.INSTANCE.getEFactory(TypwrapperPackage.eNS_URI);
			if (theTypwrapperFactory != null) {
				return theTypwrapperFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypwrapperFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypwrapperFactoryImpl() {
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
			case TypwrapperPackage.TYP_WRAPPER: return createTypWrapper();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypWrapper createTypWrapper() {
		TypWrapperImpl typWrapper = new TypWrapperImpl();
		return typWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypwrapperPackage getTypwrapperPackage() {
		return (TypwrapperPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TypwrapperPackage getPackage() {
		return TypwrapperPackage.eINSTANCE;
	}

} //TypwrapperFactoryImpl
