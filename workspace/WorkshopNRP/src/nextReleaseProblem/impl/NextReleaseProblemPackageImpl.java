/**
 */
package nextReleaseProblem.impl;

import nextReleaseProblem.Cost;
import nextReleaseProblem.CostType;
import nextReleaseProblem.Customer;
import nextReleaseProblem.NextReleaseProblemFactory;
import nextReleaseProblem.NextReleaseProblemPackage;
import nextReleaseProblem.Requirement;
import nextReleaseProblem.RequirementRealisation;
import nextReleaseProblem.SoftwareArtifact;
import nextReleaseProblem.Solution;
import nextReleaseProblem.Valuation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NextReleaseProblemPackageImpl extends EPackageImpl implements NextReleaseProblemPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nrpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass costEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareArtifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementRealisationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valuationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum costTypeEEnum = null;

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
	 * @see nextReleaseProblem.NextReleaseProblemPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NextReleaseProblemPackageImpl() {
		super(eNS_URI, NextReleaseProblemFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NextReleaseProblemPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NextReleaseProblemPackage init() {
		if (isInited) return (NextReleaseProblemPackage)EPackage.Registry.INSTANCE.getEPackage(NextReleaseProblemPackage.eNS_URI);

		// Obtain or create and register package
		NextReleaseProblemPackageImpl theNextReleaseProblemPackage = (NextReleaseProblemPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NextReleaseProblemPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NextReleaseProblemPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theNextReleaseProblemPackage.createPackageContents();

		// Initialize created meta-data
		theNextReleaseProblemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNextReleaseProblemPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NextReleaseProblemPackage.eNS_URI, theNextReleaseProblemPackage);
		return theNextReleaseProblemPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNRP() {
		return nrpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNRP_Name() {
		return (EAttribute)nrpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNRP_Customers() {
		return (EReference)nrpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNRP_AvailableArtifacts() {
		return (EReference)nrpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNRP_Requirements() {
		return (EReference)nrpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNRP_Solutions() {
		return (EReference)nrpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomer() {
		return customerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_Name() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_Importance() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomer_Assigns() {
		return (EReference)customerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCost() {
		return costEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCost_Type() {
		return (EAttribute)costEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCost_Amount() {
		return (EAttribute)costEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareArtifact() {
		return softwareArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareArtifact_Name() {
		return (EAttribute)softwareArtifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftwareArtifact_Requires() {
		return (EReference)softwareArtifactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftwareArtifact_Costs() {
		return (EReference)softwareArtifactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftwareArtifact_ContributesTo() {
		return (EReference)softwareArtifactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftwareArtifact_Solutions() {
		return (EReference)softwareArtifactEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Name() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_Valuations() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_Realisations() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_Combines() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirementRealisation() {
		return requirementRealisationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirementRealisation_Requirement() {
		return (EReference)requirementRealisationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirementRealisation_Percentage() {
		return (EAttribute)requirementRealisationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirementRealisation_DependsOn() {
		return (EReference)requirementRealisationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirementRealisation_Name() {
		return (EAttribute)requirementRealisationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolution() {
		return solutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolution_Name() {
		return (EAttribute)solutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolution_SelectedArtifacts() {
		return (EReference)solutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValuation() {
		return valuationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValuation_Requirement() {
		return (EReference)valuationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValuation_Value() {
		return (EAttribute)valuationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValuation_AssignedBy() {
		return (EReference)valuationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValuation_ContributesTo() {
		return (EReference)valuationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValuation_Name() {
		return (EAttribute)valuationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCostType() {
		return costTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NextReleaseProblemFactory getNextReleaseProblemFactory() {
		return (NextReleaseProblemFactory)getEFactoryInstance();
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
		nrpEClass = createEClass(NRP);
		createEAttribute(nrpEClass, NRP__NAME);
		createEReference(nrpEClass, NRP__CUSTOMERS);
		createEReference(nrpEClass, NRP__AVAILABLE_ARTIFACTS);
		createEReference(nrpEClass, NRP__REQUIREMENTS);
		createEReference(nrpEClass, NRP__SOLUTIONS);

		customerEClass = createEClass(CUSTOMER);
		createEAttribute(customerEClass, CUSTOMER__NAME);
		createEAttribute(customerEClass, CUSTOMER__IMPORTANCE);
		createEReference(customerEClass, CUSTOMER__ASSIGNS);

		costEClass = createEClass(COST);
		createEAttribute(costEClass, COST__TYPE);
		createEAttribute(costEClass, COST__AMOUNT);

		softwareArtifactEClass = createEClass(SOFTWARE_ARTIFACT);
		createEAttribute(softwareArtifactEClass, SOFTWARE_ARTIFACT__NAME);
		createEReference(softwareArtifactEClass, SOFTWARE_ARTIFACT__REQUIRES);
		createEReference(softwareArtifactEClass, SOFTWARE_ARTIFACT__COSTS);
		createEReference(softwareArtifactEClass, SOFTWARE_ARTIFACT__CONTRIBUTES_TO);
		createEReference(softwareArtifactEClass, SOFTWARE_ARTIFACT__SOLUTIONS);

		requirementEClass = createEClass(REQUIREMENT);
		createEAttribute(requirementEClass, REQUIREMENT__NAME);
		createEReference(requirementEClass, REQUIREMENT__VALUATIONS);
		createEReference(requirementEClass, REQUIREMENT__REALISATIONS);
		createEReference(requirementEClass, REQUIREMENT__COMBINES);

		requirementRealisationEClass = createEClass(REQUIREMENT_REALISATION);
		createEReference(requirementRealisationEClass, REQUIREMENT_REALISATION__REQUIREMENT);
		createEAttribute(requirementRealisationEClass, REQUIREMENT_REALISATION__PERCENTAGE);
		createEReference(requirementRealisationEClass, REQUIREMENT_REALISATION__DEPENDS_ON);
		createEAttribute(requirementRealisationEClass, REQUIREMENT_REALISATION__NAME);

		solutionEClass = createEClass(SOLUTION);
		createEAttribute(solutionEClass, SOLUTION__NAME);
		createEReference(solutionEClass, SOLUTION__SELECTED_ARTIFACTS);

		valuationEClass = createEClass(VALUATION);
		createEReference(valuationEClass, VALUATION__REQUIREMENT);
		createEAttribute(valuationEClass, VALUATION__VALUE);
		createEReference(valuationEClass, VALUATION__ASSIGNED_BY);
		createEReference(valuationEClass, VALUATION__CONTRIBUTES_TO);
		createEAttribute(valuationEClass, VALUATION__NAME);

		// Create enums
		costTypeEEnum = createEEnum(COST_TYPE);
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
		initEClass(nrpEClass, nextReleaseProblem.NRP.class, "NRP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNRP_Name(), ecorePackage.getEString(), "name", null, 0, 1, nextReleaseProblem.NRP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNRP_Customers(), this.getCustomer(), null, "customers", null, 1, -1, nextReleaseProblem.NRP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNRP_AvailableArtifacts(), this.getSoftwareArtifact(), null, "availableArtifacts", null, 1, -1, nextReleaseProblem.NRP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNRP_Requirements(), this.getRequirement(), null, "requirements", null, 1, -1, nextReleaseProblem.NRP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNRP_Solutions(), this.getSolution(), null, "solutions", null, 0, -1, nextReleaseProblem.NRP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerEClass, Customer.class, "Customer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_Importance(), ecorePackage.getEDouble(), "importance", null, 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomer_Assigns(), this.getValuation(), this.getValuation_AssignedBy(), "assigns", null, 1, -1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(costEClass, Cost.class, "Cost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCost_Type(), this.getCostType(), "type", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCost_Amount(), ecorePackage.getEDouble(), "amount", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(softwareArtifactEClass, SoftwareArtifact.class, "SoftwareArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSoftwareArtifact_Name(), ecorePackage.getEString(), "name", null, 0, 1, SoftwareArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSoftwareArtifact_Requires(), this.getSoftwareArtifact(), null, "requires", null, 0, -1, SoftwareArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSoftwareArtifact_Costs(), this.getCost(), null, "costs", null, 1, -1, SoftwareArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSoftwareArtifact_ContributesTo(), this.getRequirementRealisation(), this.getRequirementRealisation_DependsOn(), "contributesTo", null, 1, -1, SoftwareArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSoftwareArtifact_Solutions(), this.getSolution(), this.getSolution_SelectedArtifacts(), "solutions", null, 0, -1, SoftwareArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequirement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_Valuations(), this.getValuation(), this.getValuation_Requirement(), "valuations", null, 1, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_Realisations(), this.getRequirementRealisation(), this.getRequirementRealisation_Requirement(), "realisations", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_Combines(), this.getValuation(), this.getValuation_ContributesTo(), "combines", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementRealisationEClass, RequirementRealisation.class, "RequirementRealisation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirementRealisation_Requirement(), this.getRequirement(), this.getRequirement_Realisations(), "requirement", null, 1, 1, RequirementRealisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirementRealisation_Percentage(), ecorePackage.getEDouble(), "percentage", "1.0", 0, 1, RequirementRealisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirementRealisation_DependsOn(), this.getSoftwareArtifact(), this.getSoftwareArtifact_ContributesTo(), "dependsOn", null, 1, -1, RequirementRealisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirementRealisation_Name(), ecorePackage.getEString(), "name", null, 0, 1, RequirementRealisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSolution_Name(), ecorePackage.getEString(), "name", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolution_SelectedArtifacts(), this.getSoftwareArtifact(), this.getSoftwareArtifact_Solutions(), "selectedArtifacts", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valuationEClass, Valuation.class, "Valuation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValuation_Requirement(), this.getRequirement(), this.getRequirement_Valuations(), "requirement", null, 1, 1, Valuation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValuation_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, Valuation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuation_AssignedBy(), this.getCustomer(), this.getCustomer_Assigns(), "assignedBy", null, 1, -1, Valuation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuation_ContributesTo(), this.getRequirement(), this.getRequirement_Combines(), "contributesTo", null, 0, -1, Valuation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValuation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Valuation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(costTypeEEnum, CostType.class, "CostType");
		addEEnumLiteral(costTypeEEnum, CostType.MONEY);
		addEEnumLiteral(costTypeEEnum, CostType.TIME);
		addEEnumLiteral(costTypeEEnum, CostType.MANPOWER);
		addEEnumLiteral(costTypeEEnum, CostType.RESOURCES);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //NextReleaseProblemPackageImpl
