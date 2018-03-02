/**
 */
package beautyocl.atl.comparisonwrapper.impl;

import anatlyzer.atl.types.TypesPackage;

import anatlyzer.atlext.ATL.ATLPackage;

import anatlyzer.atlext.OCL.OCLPackage;

import anatlyzer.atlext.PrimitiveTypes.PrimitiveTypesPackage;

import beautyocl.atl.comparisonwrapper.ComparisonWrapper;
import beautyocl.atl.comparisonwrapper.ComparisonwrapperFactory;
import beautyocl.atl.comparisonwrapper.ComparisonwrapperPackage;

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
public class ComparisonwrapperPackageImpl extends EPackageImpl implements ComparisonwrapperPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comparisonWrapperEClass = null;

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
	 * @see beautyocl.atl.comparisonwrapper.ComparisonwrapperPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComparisonwrapperPackageImpl() {
		super(eNS_URI, ComparisonwrapperFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ComparisonwrapperPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComparisonwrapperPackage init() {
		if (isInited) return (ComparisonwrapperPackage)EPackage.Registry.INSTANCE.getEPackage(ComparisonwrapperPackage.eNS_URI);

		// Obtain or create and register package
		ComparisonwrapperPackageImpl theComparisonwrapperPackage = (ComparisonwrapperPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ComparisonwrapperPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ComparisonwrapperPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ATLPackage.eINSTANCE.eClass();
		OCLPackage.eINSTANCE.eClass();
		PrimitiveTypesPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theComparisonwrapperPackage.createPackageContents();

		// Initialize created meta-data
		theComparisonwrapperPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComparisonwrapperPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComparisonwrapperPackage.eNS_URI, theComparisonwrapperPackage);
		return theComparisonwrapperPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComparisonWrapper() {
		return comparisonWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComparisonWrapper__IsSameExpr__OclExpression_OclExpression() {
		return comparisonWrapperEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonwrapperFactory getComparisonwrapperFactory() {
		return (ComparisonwrapperFactory)getEFactoryInstance();
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
		comparisonWrapperEClass = createEClass(COMPARISON_WRAPPER);
		createEOperation(comparisonWrapperEClass, COMPARISON_WRAPPER___IS_SAME_EXPR__OCLEXPRESSION_OCLEXPRESSION);
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
		initEClass(comparisonWrapperEClass, ComparisonWrapper.class, "ComparisonWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getComparisonWrapper__IsSameExpr__OclExpression_OclExpression(), ecorePackage.getEBoolean(), "isSameExpr", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e1", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLPackage.getOclExpression(), "e2", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ComparisonwrapperPackageImpl
