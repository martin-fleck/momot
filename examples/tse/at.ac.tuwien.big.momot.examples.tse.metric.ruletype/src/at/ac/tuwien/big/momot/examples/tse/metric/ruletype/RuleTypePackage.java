/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype;

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
 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypeFactory
 * @model kind="package"
 * @generated
 */
public interface RuleTypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ruletype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.big.tuwien.ac.at/tosem/ruletype";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ruletype";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "at.ac.tuwien.big.momot.examples.tse.metric.ruletype";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuleTypePackage eINSTANCE = at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypePackageImpl.init();

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl <em>Rule Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypePackageImpl#getRuleType()
	 * @generated
	 */
	int RULE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Inherits</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__INHERITS = 1;

	/**
	 * The feature id for the '<em><b>In Features</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__IN_FEATURES = 2;

	/**
	 * The feature id for the '<em><b>In Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__IN_TYPES = 3;

	/**
	 * The feature id for the '<em><b>Out Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__OUT_TYPES = 4;

	/**
	 * The feature id for the '<em><b>Out Features Imperative</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__OUT_FEATURES_IMPERATIVE = 5;

	/**
	 * The feature id for the '<em><b>All Navigation Paths</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__ALL_NAVIGATION_PATHS = 6;

	/**
	 * The feature id for the '<em><b>Binding Features</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__BINDING_FEATURES = 7;

	/**
	 * The feature id for the '<em><b>All Foot Prints</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__ALL_FOOT_PRINTS = 8;

	/**
	 * The feature id for the '<em><b>Out Features</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__OUT_FEATURES = 9;

	/**
	 * The number of structural features of the '<em>Rule Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Rule Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.TransformationTypeImpl <em>Transformation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.TransformationTypeImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypePackageImpl#getTransformationType()
	 * @generated
	 */
	int TRANSFORMATION_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_TYPE__RULES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Mms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_TYPE__MMS = 2;

	/**
	 * The number of structural features of the '<em>Transformation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Transformation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.MMNamesImpl <em>MM Names</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.MMNamesImpl
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypePackageImpl#getMMNames()
	 * @generated
	 */
	int MM_NAMES = 2;

	/**
	 * The feature id for the '<em><b>Input MM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_NAMES__INPUT_MM = 0;

	/**
	 * The feature id for the '<em><b>Output MM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_NAMES__OUTPUT_MM = 1;

	/**
	 * The feature id for the '<em><b>Trafo</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_NAMES__TRAFO = 2;

	/**
	 * The number of structural features of the '<em>MM Names</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_NAMES_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>MM Names</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_NAMES_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType <em>Rule Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Type</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType
	 * @generated
	 */
	EClass getRuleType();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getName()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Name();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInherits <em>Inherits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inherits</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInherits()
	 * @see #getRuleType()
	 * @generated
	 */
	EReference getRuleType_Inherits();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInFeatures <em>In Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>In Features</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInFeatures()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_InFeatures();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInTypes <em>In Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>In Types</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInTypes()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_InTypes();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutTypes <em>Out Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Out Types</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutTypes()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_OutTypes();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutFeaturesImperative <em>Out Features Imperative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Out Features Imperative</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutFeaturesImperative()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_OutFeaturesImperative();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getAllNavigationPaths <em>All Navigation Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>All Navigation Paths</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getAllNavigationPaths()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_AllNavigationPaths();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getBindingFeatures <em>Binding Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Binding Features</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getBindingFeatures()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_BindingFeatures();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getAllFootPrints <em>All Foot Prints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>All Foot Prints</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getAllFootPrints()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_AllFootPrints();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutFeatures <em>Out Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Out Features</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutFeatures()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_OutFeatures();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType <em>Transformation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Type</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType
	 * @generated
	 */
	EClass getTransformationType();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getRules()
	 * @see #getTransformationType()
	 * @generated
	 */
	EReference getTransformationType_Rules();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getName()
	 * @see #getTransformationType()
	 * @generated
	 */
	EAttribute getTransformationType_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getMms <em>Mms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mms</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getMms()
	 * @see #getTransformationType()
	 * @generated
	 */
	EReference getTransformationType_Mms();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames <em>MM Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MM Names</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames
	 * @generated
	 */
	EClass getMMNames();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getInputMM <em>Input MM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input MM</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getInputMM()
	 * @see #getMMNames()
	 * @generated
	 */
	EAttribute getMMNames_InputMM();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getOutputMM <em>Output MM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output MM</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getOutputMM()
	 * @see #getMMNames()
	 * @generated
	 */
	EAttribute getMMNames_OutputMM();

	/**
	 * Returns the meta object for the container reference '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getTrafo <em>Trafo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Trafo</em>'.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getTrafo()
	 * @see #getMMNames()
	 * @generated
	 */
	EReference getMMNames_Trafo();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuleTypeFactory getRuleTypeFactory();

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
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl <em>Rule Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypePackageImpl#getRuleType()
		 * @generated
		 */
		EClass RULE_TYPE = eINSTANCE.getRuleType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__NAME = eINSTANCE.getRuleType_Name();

		/**
		 * The meta object literal for the '<em><b>Inherits</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_TYPE__INHERITS = eINSTANCE.getRuleType_Inherits();

		/**
		 * The meta object literal for the '<em><b>In Features</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__IN_FEATURES = eINSTANCE.getRuleType_InFeatures();

		/**
		 * The meta object literal for the '<em><b>In Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__IN_TYPES = eINSTANCE.getRuleType_InTypes();

		/**
		 * The meta object literal for the '<em><b>Out Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__OUT_TYPES = eINSTANCE.getRuleType_OutTypes();

		/**
		 * The meta object literal for the '<em><b>Out Features Imperative</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__OUT_FEATURES_IMPERATIVE = eINSTANCE.getRuleType_OutFeaturesImperative();

		/**
		 * The meta object literal for the '<em><b>All Navigation Paths</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__ALL_NAVIGATION_PATHS = eINSTANCE.getRuleType_AllNavigationPaths();

		/**
		 * The meta object literal for the '<em><b>Binding Features</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__BINDING_FEATURES = eINSTANCE.getRuleType_BindingFeatures();

		/**
		 * The meta object literal for the '<em><b>All Foot Prints</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__ALL_FOOT_PRINTS = eINSTANCE.getRuleType_AllFootPrints();

		/**
		 * The meta object literal for the '<em><b>Out Features</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__OUT_FEATURES = eINSTANCE.getRuleType_OutFeatures();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.TransformationTypeImpl <em>Transformation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.TransformationTypeImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypePackageImpl#getTransformationType()
		 * @generated
		 */
		EClass TRANSFORMATION_TYPE = eINSTANCE.getTransformationType();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_TYPE__RULES = eINSTANCE.getTransformationType_Rules();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION_TYPE__NAME = eINSTANCE.getTransformationType_Name();

		/**
		 * The meta object literal for the '<em><b>Mms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_TYPE__MMS = eINSTANCE.getTransformationType_Mms();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.MMNamesImpl <em>MM Names</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.MMNamesImpl
		 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypePackageImpl#getMMNames()
		 * @generated
		 */
		EClass MM_NAMES = eINSTANCE.getMMNames();

		/**
		 * The meta object literal for the '<em><b>Input MM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_NAMES__INPUT_MM = eINSTANCE.getMMNames_InputMM();

		/**
		 * The meta object literal for the '<em><b>Output MM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_NAMES__OUTPUT_MM = eINSTANCE.getMMNames_OutputMM();

		/**
		 * The meta object literal for the '<em><b>Trafo</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MM_NAMES__TRAFO = eINSTANCE.getMMNames_Trafo();

	}

} //RuleTypePackage
