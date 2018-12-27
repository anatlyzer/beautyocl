/**
 */
package beautyocl.actions.impl;

import beautyocl.actions.ActionsFactory;
import beautyocl.actions.ActionsPackage;
import beautyocl.actions.Clone;
import beautyocl.actions.CompositeAction;
import beautyocl.actions.DeleteMoveChildren;
import beautyocl.actions.InPlaceAction;
import beautyocl.actions.Replace;
import beautyocl.actions.SetP;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsPackageImpl extends EPackageImpl implements ActionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inPlaceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteMoveChildrenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setPEClass = null;

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
	 * @see beautyocl.actions.ActionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActionsPackageImpl() {
		super(eNS_URI, ActionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ActionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActionsPackage init() {
		if (isInited) return (ActionsPackage)EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);

		// Obtain or create and register package
		ActionsPackageImpl theActionsPackage = (ActionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActionsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theActionsPackage.createPackageContents();

		// Initialize created meta-data
		theActionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, theActionsPackage);
		return theActionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInPlaceAction() {
		return inPlaceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInPlaceAction_Transformation() {
		return (EAttribute)inPlaceActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInPlaceAction_Rule() {
		return (EAttribute)inPlaceActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInPlaceAction_Source() {
		return (EReference)inPlaceActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplace() {
		return replaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplace_Target() {
		return (EReference)replaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteMoveChildren() {
		return deleteMoveChildrenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteMoveChildren_Children() {
		return (EReference)deleteMoveChildrenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClone() {
		return cloneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClone_IgnoredProperties() {
		return (EAttribute)cloneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClone_Values() {
		return (EReference)cloneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClone_ReplaceReferenceTo() {
		return (EReference)cloneEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClone_WithReplacement() {
		return (EReference)cloneEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeAction() {
		return compositeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeAction_Actions() {
		return (EReference)compositeActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetP() {
		return setPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetP_PropertyName() {
		return (EAttribute)setPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetP_Value() {
		return (EReference)setPEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsFactory getActionsFactory() {
		return (ActionsFactory)getEFactoryInstance();
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
		inPlaceActionEClass = createEClass(IN_PLACE_ACTION);
		createEAttribute(inPlaceActionEClass, IN_PLACE_ACTION__TRANSFORMATION);
		createEAttribute(inPlaceActionEClass, IN_PLACE_ACTION__RULE);
		createEReference(inPlaceActionEClass, IN_PLACE_ACTION__SOURCE);

		replaceEClass = createEClass(REPLACE);
		createEReference(replaceEClass, REPLACE__TARGET);

		deleteMoveChildrenEClass = createEClass(DELETE_MOVE_CHILDREN);
		createEReference(deleteMoveChildrenEClass, DELETE_MOVE_CHILDREN__CHILDREN);

		cloneEClass = createEClass(CLONE);
		createEAttribute(cloneEClass, CLONE__IGNORED_PROPERTIES);
		createEReference(cloneEClass, CLONE__VALUES);
		createEReference(cloneEClass, CLONE__REPLACE_REFERENCE_TO);
		createEReference(cloneEClass, CLONE__WITH_REPLACEMENT);

		compositeActionEClass = createEClass(COMPOSITE_ACTION);
		createEReference(compositeActionEClass, COMPOSITE_ACTION__ACTIONS);

		setPEClass = createEClass(SET_P);
		createEAttribute(setPEClass, SET_P__PROPERTY_NAME);
		createEReference(setPEClass, SET_P__VALUE);
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
		replaceEClass.getESuperTypes().add(this.getInPlaceAction());
		deleteMoveChildrenEClass.getESuperTypes().add(this.getInPlaceAction());
		cloneEClass.getESuperTypes().add(this.getInPlaceAction());
		compositeActionEClass.getESuperTypes().add(this.getInPlaceAction());
		setPEClass.getESuperTypes().add(this.getInPlaceAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(inPlaceActionEClass, InPlaceAction.class, "InPlaceAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInPlaceAction_Transformation(), ecorePackage.getEString(), "transformation", null, 0, 1, InPlaceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInPlaceAction_Rule(), ecorePackage.getEString(), "rule", null, 0, 1, InPlaceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInPlaceAction_Source(), ecorePackage.getEObject(), null, "source", null, 1, 1, InPlaceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(replaceEClass, Replace.class, "Replace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplace_Target(), ecorePackage.getEObject(), null, "target", null, 1, 1, Replace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteMoveChildrenEClass, DeleteMoveChildren.class, "DeleteMoveChildren", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteMoveChildren_Children(), ecorePackage.getEObject(), null, "children", null, 1, 1, DeleteMoveChildren.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloneEClass, Clone.class, "Clone", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClone_IgnoredProperties(), ecorePackage.getEString(), "ignoredProperties", null, 0, -1, Clone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClone_Values(), ecorePackage.getEObject(), null, "values", null, 0, -1, Clone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClone_ReplaceReferenceTo(), ecorePackage.getEObject(), null, "replaceReferenceTo", null, 0, -1, Clone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClone_WithReplacement(), ecorePackage.getEObject(), null, "withReplacement", null, 0, -1, Clone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeActionEClass, CompositeAction.class, "CompositeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeAction_Actions(), this.getInPlaceAction(), null, "actions", null, 0, -1, CompositeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setPEClass, SetP.class, "SetP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetP_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, 1, SetP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetP_Value(), ecorePackage.getEObject(), null, "value", null, 0, -1, SetP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ActionsPackageImpl
