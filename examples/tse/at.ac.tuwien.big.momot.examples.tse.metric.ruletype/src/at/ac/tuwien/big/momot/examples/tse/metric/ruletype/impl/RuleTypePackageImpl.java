/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypeFactory;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuleTypePackageImpl extends EPackageImpl implements RuleTypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mmNamesEClass = null;

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
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RuleTypePackageImpl() {
		super(eNS_URI, RuleTypeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RuleTypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RuleTypePackage init() {
		if (isInited) return (RuleTypePackage)EPackage.Registry.INSTANCE.getEPackage(RuleTypePackage.eNS_URI);

		// Obtain or create and register package
		RuleTypePackageImpl theRuleTypePackage = (RuleTypePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RuleTypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RuleTypePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theRuleTypePackage.createPackageContents();

		// Initialize created meta-data
		theRuleTypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRuleTypePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RuleTypePackage.eNS_URI, theRuleTypePackage);
		return theRuleTypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleType() {
		return ruleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_Name() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleType_Inherits() {
		return (EReference)ruleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_InFeatures() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_InTypes() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_OutTypes() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_OutFeaturesImperative() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_AllNavigationPaths() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_BindingFeatures() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_AllFootPrints() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_OutFeatures() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationType() {
		return transformationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationType_Rules() {
		return (EReference)transformationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationType_Name() {
		return (EAttribute)transformationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationType_Mms() {
		return (EReference)transformationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMMNames() {
		return mmNamesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMNames_InputMM() {
		return (EAttribute)mmNamesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMNames_OutputMM() {
		return (EAttribute)mmNamesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMMNames_Trafo() {
		return (EReference)mmNamesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleTypeFactory getRuleTypeFactory() {
		return (RuleTypeFactory)getEFactoryInstance();
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
		ruleTypeEClass = createEClass(RULE_TYPE);
		createEAttribute(ruleTypeEClass, RULE_TYPE__NAME);
		createEReference(ruleTypeEClass, RULE_TYPE__INHERITS);
		createEAttribute(ruleTypeEClass, RULE_TYPE__IN_FEATURES);
		createEAttribute(ruleTypeEClass, RULE_TYPE__IN_TYPES);
		createEAttribute(ruleTypeEClass, RULE_TYPE__OUT_TYPES);
		createEAttribute(ruleTypeEClass, RULE_TYPE__OUT_FEATURES_IMPERATIVE);
		createEAttribute(ruleTypeEClass, RULE_TYPE__ALL_NAVIGATION_PATHS);
		createEAttribute(ruleTypeEClass, RULE_TYPE__BINDING_FEATURES);
		createEAttribute(ruleTypeEClass, RULE_TYPE__ALL_FOOT_PRINTS);
		createEAttribute(ruleTypeEClass, RULE_TYPE__OUT_FEATURES);

		transformationTypeEClass = createEClass(TRANSFORMATION_TYPE);
		createEReference(transformationTypeEClass, TRANSFORMATION_TYPE__RULES);
		createEAttribute(transformationTypeEClass, TRANSFORMATION_TYPE__NAME);
		createEReference(transformationTypeEClass, TRANSFORMATION_TYPE__MMS);

		mmNamesEClass = createEClass(MM_NAMES);
		createEAttribute(mmNamesEClass, MM_NAMES__INPUT_MM);
		createEAttribute(mmNamesEClass, MM_NAMES__OUTPUT_MM);
		createEReference(mmNamesEClass, MM_NAMES__TRAFO);
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
		initEClass(ruleTypeEClass, RuleType.class, "RuleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleType_Name(), ecorePackage.getEString(), "name", null, 1, 1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleType_Inherits(), this.getRuleType(), null, "inherits", null, 0, 1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_InFeatures(), ecorePackage.getEString(), "inFeatures", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_InTypes(), ecorePackage.getEString(), "inTypes", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_OutTypes(), ecorePackage.getEString(), "outTypes", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_OutFeaturesImperative(), ecorePackage.getEString(), "outFeaturesImperative", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_AllNavigationPaths(), ecorePackage.getEString(), "allNavigationPaths", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_BindingFeatures(), ecorePackage.getEString(), "bindingFeatures", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_AllFootPrints(), ecorePackage.getEString(), "allFootPrints", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_OutFeatures(), ecorePackage.getEString(), "outFeatures", null, 0, -1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationTypeEClass, TransformationType.class, "TransformationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationType_Rules(), this.getRuleType(), null, "rules", null, 0, -1, TransformationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformationType_Name(), ecorePackage.getEString(), "name", null, 1, 1, TransformationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationType_Mms(), this.getMMNames(), this.getMMNames_Trafo(), "mms", null, 0, -1, TransformationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mmNamesEClass, MMNames.class, "MMNames", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMMNames_InputMM(), ecorePackage.getEString(), "inputMM", null, 1, 1, MMNames.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMMNames_OutputMM(), ecorePackage.getEString(), "outputMM", null, 1, 1, MMNames.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMMNames_Trafo(), this.getTransformationType(), this.getTransformationType_Mms(), "trafo", null, 1, 1, MMNames.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RuleTypePackageImpl
