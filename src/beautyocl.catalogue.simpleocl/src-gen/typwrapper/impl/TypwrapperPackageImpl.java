/**
 */
package typwrapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import typwrapper.TypWrapper;
import typwrapper.TypwrapperFactory;
import typwrapper.TypwrapperPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypwrapperPackageImpl extends EPackageImpl implements TypwrapperPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typWrapperEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see typwrapper.TypwrapperPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypwrapperPackageImpl() {
		super(eNS_URI, TypwrapperFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TypwrapperPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypwrapperPackage init() {
		if (isInited) return (TypwrapperPackage)EPackage.Registry.INSTANCE.getEPackage(TypwrapperPackage.eNS_URI);

		// Obtain or create and register package
		TypwrapperPackageImpl theTypwrapperPackage = (TypwrapperPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypwrapperPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypwrapperPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTypwrapperPackage.createPackageContents();

		// Initialize created meta-data
		theTypwrapperPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypwrapperPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypwrapperPackage.eNS_URI, theTypwrapperPackage);
		return theTypwrapperPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypWrapper() {
		return typWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypWrapper__IsSameType__EObject_EObject() {
		return typWrapperEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypWrapper__IsSuperType__EObject_EObject() {
		return typWrapperEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypwrapperFactory getTypwrapperFactory() {
		return (TypwrapperFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		typWrapperEClass = createEClass(TYP_WRAPPER);
		createEOperation(typWrapperEClass, TYP_WRAPPER___IS_SAME_TYPE__EOBJECT_EOBJECT);
		createEOperation(typWrapperEClass, TYP_WRAPPER___IS_SUPER_TYPE__EOBJECT_EOBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(typWrapperEClass, TypWrapper.class, "TypWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getTypWrapper__IsSameType__EObject_EObject(), ecorePackage.getEBoolean(), "isSameType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "e1", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "e2", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypWrapper__IsSuperType__EObject_EObject(), ecorePackage.getEBoolean(), "isSuperType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "e1_subtype", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "e2_supertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TypwrapperPackageImpl
