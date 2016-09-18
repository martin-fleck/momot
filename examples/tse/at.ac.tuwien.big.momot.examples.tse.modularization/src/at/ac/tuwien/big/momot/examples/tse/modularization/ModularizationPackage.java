/**
 */
package at.ac.tuwien.big.momot.examples.tse.modularization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface ModularizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modularization";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.big.tuwien.ac.at/tosem/modularization";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modularization";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "at.ac.tuwien.big.momot.examples.tosem";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModularizationPackage eINSTANCE = at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.NamedElementImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleElementImpl <em>Module Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleElementImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getModuleElement()
	 * @generated
	 */
	int MODULE_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Module Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Module Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = MODULE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Binding Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__BINDING_TYPES = MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Patt El Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__IN_PATT_EL_TYPES = MODULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Binding Navigations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__BINDING_NAVIGATIONS = MODULE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rule Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__RULE_DEPENDENCIES = MODULE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__INHERITS_FROM = MODULE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Helper Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__HELPER_DEPENDENCIES = MODULE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = MODULE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.TransformationImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__MODULES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__RULES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Helpers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__HELPERS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.HelperImpl <em>Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.HelperImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getHelper()
	 * @generated
	 */
	int HELPER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__NAME = MODULE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Helper Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__HELPER_DEPENDENCIES = MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Helper Dep Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__HELPER_DEP_NAMES = MODULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER_OPERATION_COUNT = MODULE_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getBindingTypes <em>Binding Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Binding Types</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getBindingTypes()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_BindingTypes();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getInPattElTypes <em>In Patt El Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>In Patt El Types</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getInPattElTypes()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_InPattElTypes();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getBindingNavigations <em>Binding Navigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Binding Navigations</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getBindingNavigations()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_BindingNavigations();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getRuleDependencies <em>Rule Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rule Dependencies</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getRuleDependencies()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_RuleDependencies();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getInheritsFrom <em>Inherits From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherits From</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getInheritsFrom()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_InheritsFrom();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getHelperDependencies <em>Helper Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Helper Dependencies</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getHelperDependencies()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_HelperDependencies();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Transformation#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Transformation#getModules()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Modules();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Module#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Module#getRules()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Rules();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Module#getHelpers <em>Helpers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Helpers</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Module#getHelpers()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Helpers();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.modularization.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.tse.modularization.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.modularization.ModuleElement <em>Module Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Element</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModuleElement
	 * @generated
	 */
	EClass getModuleElement();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Helper <em>Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Helper</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Helper
	 * @generated
	 */
	EClass getHelper();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Helper#getHelperDependencies <em>Helper Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Helper Dependencies</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Helper#getHelperDependencies()
	 * @see #getHelper()
	 * @generated
	 */
	EReference getHelper_HelperDependencies();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.modularization.Helper#getHelperDepNames <em>Helper Dep Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Helper Dep Names</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.Helper#getHelperDepNames()
	 * @see #getHelper()
	 * @generated
	 */
	EAttribute getHelper_HelperDepNames();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModularizationFactory getModularizationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Binding Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__BINDING_TYPES = eINSTANCE.getRule_BindingTypes();

		/**
		 * The meta object literal for the '<em><b>In Patt El Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__IN_PATT_EL_TYPES = eINSTANCE.getRule_InPattElTypes();

		/**
		 * The meta object literal for the '<em><b>Binding Navigations</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__BINDING_NAVIGATIONS = eINSTANCE.getRule_BindingNavigations();

		/**
		 * The meta object literal for the '<em><b>Rule Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__RULE_DEPENDENCIES = eINSTANCE.getRule_RuleDependencies();

		/**
		 * The meta object literal for the '<em><b>Inherits From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__INHERITS_FROM = eINSTANCE.getRule_InheritsFrom();

		/**
		 * The meta object literal for the '<em><b>Helper Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__HELPER_DEPENDENCIES = eINSTANCE.getRule_HelperDependencies();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.TransformationImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__MODULES = eINSTANCE.getTransformation_Modules();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__RULES = eINSTANCE.getModule_Rules();

		/**
		 * The meta object literal for the '<em><b>Helpers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__HELPERS = eINSTANCE.getModule_Helpers();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.NamedElementImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleElementImpl <em>Module Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModuleElementImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getModuleElement()
		 * @generated
		 */
		EClass MODULE_ELEMENT = eINSTANCE.getModuleElement();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.HelperImpl <em>Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.HelperImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.modularization.impl.ModularizationPackageImpl#getHelper()
		 * @generated
		 */
		EClass HELPER = eINSTANCE.getHelper();

		/**
		 * The meta object literal for the '<em><b>Helper Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HELPER__HELPER_DEPENDENCIES = eINSTANCE.getHelper_HelperDependencies();

		/**
		 * The meta object literal for the '<em><b>Helper Dep Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HELPER__HELPER_DEP_NAMES = eINSTANCE.getHelper_HelperDepNames();

	}

} //ModularizationPackage
