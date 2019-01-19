/**
 */
package beautyocl.atl.typwrapper.impl;

import anatlyzer.atl.types.TypesPackage;
import anatlyzer.atlext.ATL.ATLPackage;

import anatlyzer.atlext.OCL.OCLPackage;

import anatlyzer.atlext.PrimitiveTypes.PrimitiveTypesPackage;

import beautyocl.atl.typwrapper.TypWrapper;
import beautyocl.atl.typwrapper.TypwrapperFactory;
import beautyocl.atl.typwrapper.TypwrapperPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
	 * @see beautyocl.atl.typwrapper.TypwrapperPackage#eNS_URI
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

		// Initialize simple dependencies
		ATLPackage.eINSTANCE.eClass();
		OCLPackage.eINSTANCE.eClass();
		PrimitiveTypesPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

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
	public EOperation getTypWrapper__IsSameType__OclExpression_OclExpression() {
		return typWrapperEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypWrapper__IsSuperType__OclExpression_OclExpression() {
		return typWrapperEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypWrapper__IsNonNull__OclExpression() {
		return typWrapperEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypWrapper__AccessType__PropertyCallExp() {
		return typWrapperEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypWrapper__ModelName__VariableDeclaration() {
		return typWrapperEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypWrapper__TypeOf__OclExpression() {
		return typWrapperEClass.getEOperations().get(5);
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
		createEOperation(typWrapperEClass, TYP_WRAPPER___IS_SAME_TYPE__OCLEXPRESSION_OCLEXPRESSION);
		createEOperation(typWrapperEClass, TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION);
		createEOperation(typWrapperEClass, TYP_WRAPPER___IS_NON_NULL__OCLEXPRESSION);
		createEOperation(typWrapperEClass, TYP_WRAPPER___ACCESS_TYPE__PROPERTYCALLEXP);
		createEOperation(typWrapperEClass, TYP_WRAPPER___MODEL_NAME__VARIABLEDECLARATION);
		createEOperation(typWrapperEClass, TYP_WRAPPER___TYPE_OF__OCLEXPRESSION);
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

		// Obtain other dependent packages
		OCLPackage theOCLPackage = (OCLPackage)EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(typWrapperEClass, TypWrapper.class, "TypWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getTypWrapper__IsSameType__OclExpression_OclExpression(), ecorePackage.getEBoolean(), "isSameType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e1", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e2", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypWrapper__IsSuperType__OclExpression_OclExpression(), ecorePackage.getEBoolean(), "isSuperType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e1_subtype", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e2_supertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypWrapper__IsNonNull__OclExpression(), ecorePackage.getEBoolean(), "isNonNull", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypWrapper__AccessType__PropertyCallExp(), ecorePackage.getEClass(), "accessType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getPropertyCallExp(), "exp", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypWrapper__ModelName__VariableDeclaration(), ecorePackage.getEString(), "modelName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getVariableDeclaration(), "vd", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypWrapper__TypeOf__OclExpression(), ecorePackage.getEClassifier(), "typeOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TypwrapperPackageImpl
