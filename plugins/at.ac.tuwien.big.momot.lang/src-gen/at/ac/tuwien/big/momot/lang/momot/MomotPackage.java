/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.lang.momot.MomotFactory
 * @model kind="package"
 * @generated
 */
public interface MomotPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "momot";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.big.tuwien.ac.at/momot/lang/MOMoT";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "momot";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MomotPackage eINSTANCE = at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl.init();

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl <em>MO Mo TSearch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getMOMoTSearch()
   * @generated
   */
  int MO_MO_TSEARCH = 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__IMPORT_SECTION = 1;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__VARIABLES = 2;

  /**
   * The feature id for the '<em><b>Initialization</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__INITIALIZATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__NAME = 4;

  /**
   * The feature id for the '<em><b>Search Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__SEARCH_ORCHESTRATION = 5;

  /**
   * The feature id for the '<em><b>Experiment Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION = 6;

  /**
   * The feature id for the '<em><b>Analysis Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION = 7;

  /**
   * The feature id for the '<em><b>Result Management</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__RESULT_MANAGEMENT = 8;

  /**
   * The feature id for the '<em><b>Finalization</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH__FINALIZATION = 9;

  /**
   * The number of structural features of the '<em>MO Mo TSearch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.VariableDeclarationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getVariableDeclaration()
   * @generated
   */
  int VARIABLE_DECLARATION = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__INIT = 2;

  /**
   * The number of structural features of the '<em>Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl <em>Module Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getModuleOrchestration()
   * @generated
   */
  int MODULE_ORCHESTRATION = 2;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ORCHESTRATION__MODULES = 0;

  /**
   * The feature id for the '<em><b>Units To Remove</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ORCHESTRATION__UNITS_TO_REMOVE = 1;

  /**
   * The feature id for the '<em><b>Non Solution Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS = 2;

  /**
   * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ORCHESTRATION__PARAMETER_VALUES = 3;

  /**
   * The number of structural features of the '<em>Module Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ORCHESTRATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ParmeterValueSpecificationImpl <em>Parmeter Value Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ParmeterValueSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getParmeterValueSpecification()
   * @generated
   */
  int PARMETER_VALUE_SPECIFICATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARMETER_VALUE_SPECIFICATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARMETER_VALUE_SPECIFICATION__CALL = 1;

  /**
   * The number of structural features of the '<em>Parmeter Value Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARMETER_VALUE_SPECIFICATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl <em>Search Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getSearchOrchestration()
   * @generated
   */
  int SEARCH_ORCHESTRATION = 4;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION__MODEL = 0;

  /**
   * The feature id for the '<em><b>Solution Length</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION__SOLUTION_LENGTH = 1;

  /**
   * The feature id for the '<em><b>Module Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION = 2;

  /**
   * The feature id for the '<em><b>Fitness Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION__FITNESS_FUNCTION = 3;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION__ALGORITHMS = 4;

  /**
   * The feature id for the '<em><b>Equality Helper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION__EQUALITY_HELPER = 5;

  /**
   * The number of structural features of the '<em>Search Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.InputModelImpl <em>Input Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.InputModelImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getInputModel()
   * @generated
   */
  int INPUT_MODEL = 5;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_MODEL__PATH = 0;

  /**
   * The feature id for the '<em><b>Adaptation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_MODEL__ADAPTATION = 1;

  /**
   * The number of structural features of the '<em>Input Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.EqualityHelperImpl <em>Equality Helper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.EqualityHelperImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getEqualityHelper()
   * @generated
   */
  int EQUALITY_HELPER = 6;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_HELPER__CALL = 0;

  /**
   * The feature id for the '<em><b>Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_HELPER__METHOD = 1;

  /**
   * The number of structural features of the '<em>Equality Helper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_HELPER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmListImpl <em>Algorithm List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmListImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAlgorithmList()
   * @generated
   */
  int ALGORITHM_LIST = 7;

  /**
   * The feature id for the '<em><b>Specifications</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALGORITHM_LIST__SPECIFICATIONS = 0;

  /**
   * The number of structural features of the '<em>Algorithm List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALGORITHM_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl <em>Fitness Function Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessFunctionSpecification()
   * @generated
   */
  int FITNESS_FUNCTION_SPECIFICATION = 8;

  /**
   * The feature id for the '<em><b>Constructor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR = 0;

  /**
   * The feature id for the '<em><b>Preprocess</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_FUNCTION_SPECIFICATION__PREPROCESS = 1;

  /**
   * The feature id for the '<em><b>Objectives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES = 2;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS = 3;

  /**
   * The feature id for the '<em><b>Postprocess</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS = 4;

  /**
   * The feature id for the '<em><b>Solution Repairer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER = 5;

  /**
   * The number of structural features of the '<em>Fitness Function Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_FUNCTION_SPECIFICATION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionSpecificationImpl <em>Fitness Dimension Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionSpecification()
   * @generated
   */
  int FITNESS_DIMENSION_SPECIFICATION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_SPECIFICATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_SPECIFICATION__TYPE = 1;

  /**
   * The number of structural features of the '<em>Fitness Dimension Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionConstructorImpl <em>Fitness Dimension Constructor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionConstructorImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionConstructor()
   * @generated
   */
  int FITNESS_DIMENSION_CONSTRUCTOR = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_CONSTRUCTOR__NAME = FITNESS_DIMENSION_SPECIFICATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_CONSTRUCTOR__TYPE = FITNESS_DIMENSION_SPECIFICATION__TYPE;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_CONSTRUCTOR__CALL = FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fitness Dimension Constructor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_CONSTRUCTOR_FEATURE_COUNT = FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionXBaseImpl <em>Fitness Dimension XBase</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionXBaseImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionXBase()
   * @generated
   */
  int FITNESS_DIMENSION_XBASE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_XBASE__NAME = FITNESS_DIMENSION_SPECIFICATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_XBASE__TYPE = FITNESS_DIMENSION_SPECIFICATION__TYPE;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_XBASE__VALUE = FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fitness Dimension XBase</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_XBASE_FEATURE_COUNT = FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionOCLImpl <em>Fitness Dimension OCL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionOCLImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionOCL()
   * @generated
   */
  int FITNESS_DIMENSION_OCL = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_OCL__NAME = FITNESS_DIMENSION_SPECIFICATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_OCL__TYPE = FITNESS_DIMENSION_SPECIFICATION__TYPE;

  /**
   * The feature id for the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_OCL__QUERY = FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Def Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS = FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fitness Dimension OCL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FITNESS_DIMENSION_OCL_FEATURE_COUNT = FITNESS_DIMENSION_SPECIFICATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.DefExpressionImpl <em>Def Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.DefExpressionImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getDefExpression()
   * @generated
   */
  int DEF_EXPRESSION = 13;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_EXPRESSION__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Def Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmSpecificationImpl <em>Algorithm Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAlgorithmSpecification()
   * @generated
   */
  int ALGORITHM_SPECIFICATION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALGORITHM_SPECIFICATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALGORITHM_SPECIFICATION__CALL = 1;

  /**
   * The number of structural features of the '<em>Algorithm Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALGORITHM_SPECIFICATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl <em>Experiment Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getExperimentOrchestration()
   * @generated
   */
  int EXPERIMENT_ORCHESTRATION = 15;

  /**
   * The feature id for the '<em><b>Population Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION__POPULATION_SIZE = 0;

  /**
   * The feature id for the '<em><b>Max Evaluations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS = 1;

  /**
   * The feature id for the '<em><b>Nr Runs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION__NR_RUNS = 2;

  /**
   * The feature id for the '<em><b>Reference Set</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION__REFERENCE_SET = 3;

  /**
   * The feature id for the '<em><b>Progress Listeners</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS = 4;

  /**
   * The feature id for the '<em><b>Collectors</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION__COLLECTORS = 5;

  /**
   * The feature id for the '<em><b>Custom Collectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS = 6;

  /**
   * The number of structural features of the '<em>Experiment Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_ORCHESTRATION_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl <em>Collector Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getCollectorArray()
   * @generated
   */
  int COLLECTOR_ARRAY = 16;

  /**
   * The feature id for the '<em><b>Hypervolume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__HYPERVOLUME = 0;

  /**
   * The feature id for the '<em><b>Generational Distance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__GENERATIONAL_DISTANCE = 1;

  /**
   * The feature id for the '<em><b>Inverted Generational Distance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE = 2;

  /**
   * The feature id for the '<em><b>Spacing</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__SPACING = 3;

  /**
   * The feature id for the '<em><b>Additive Epsilon Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR = 4;

  /**
   * The feature id for the '<em><b>Contribution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__CONTRIBUTION = 5;

  /**
   * The feature id for the '<em><b>R1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__R1 = 6;

  /**
   * The feature id for the '<em><b>R2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__R2 = 7;

  /**
   * The feature id for the '<em><b>R3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__R3 = 8;

  /**
   * The feature id for the '<em><b>Adaptive Multimethod Variation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION = 9;

  /**
   * The feature id for the '<em><b>Adaptive Time Continuation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION = 10;

  /**
   * The feature id for the '<em><b>Approximation Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__APPROXIMATION_SET = 11;

  /**
   * The feature id for the '<em><b>Epsilon Progress</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__EPSILON_PROGRESS = 12;

  /**
   * The feature id for the '<em><b>Elapsed Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__ELAPSED_TIME = 13;

  /**
   * The feature id for the '<em><b>Population Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY__POPULATION_SIZE = 14;

  /**
   * The number of structural features of the '<em>Collector Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTOR_ARRAY_FEATURE_COUNT = 15;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl <em>Analysis Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisOrchestration()
   * @generated
   */
  int ANALYSIS_ORCHESTRATION = 17;

  /**
   * The feature id for the '<em><b>Indicators</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION__INDICATORS = 0;

  /**
   * The feature id for the '<em><b>Significance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION__SIGNIFICANCE = 1;

  /**
   * The feature id for the '<em><b>Show</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION__SHOW = 2;

  /**
   * The feature id for the '<em><b>Grouping</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION__GROUPING = 3;

  /**
   * The feature id for the '<em><b>Save Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION__SAVE_COMMAND = 4;

  /**
   * The feature id for the '<em><b>Boxplot Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND = 5;

  /**
   * The feature id for the '<em><b>Print Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION__PRINT_COMMAND = 6;

  /**
   * The number of structural features of the '<em>Analysis Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupListImpl <em>Analysis Group List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupListImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisGroupList()
   * @generated
   */
  int ANALYSIS_GROUP_LIST = 18;

  /**
   * The feature id for the '<em><b>Group</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_GROUP_LIST__GROUP = 0;

  /**
   * The number of structural features of the '<em>Analysis Group List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_GROUP_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl <em>Indicator Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getIndicatorArray()
   * @generated
   */
  int INDICATOR_ARRAY = 19;

  /**
   * The feature id for the '<em><b>Hypervolume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__HYPERVOLUME = 0;

  /**
   * The feature id for the '<em><b>Generational Distance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__GENERATIONAL_DISTANCE = 1;

  /**
   * The feature id for the '<em><b>Inverted Generational Distance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE = 2;

  /**
   * The feature id for the '<em><b>Spacing</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__SPACING = 3;

  /**
   * The feature id for the '<em><b>Additive Epsilon Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR = 4;

  /**
   * The feature id for the '<em><b>Contribution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__CONTRIBUTION = 5;

  /**
   * The feature id for the '<em><b>R1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__R1 = 6;

  /**
   * The feature id for the '<em><b>R2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__R2 = 7;

  /**
   * The feature id for the '<em><b>R3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__R3 = 8;

  /**
   * The feature id for the '<em><b>Maximum Pareto Front Error</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR = 9;

  /**
   * The number of structural features of the '<em>Indicator Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICATOR_ARRAY_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ShowArrayImpl <em>Show Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ShowArrayImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getShowArray()
   * @generated
   */
  int SHOW_ARRAY = 20;

  /**
   * The feature id for the '<em><b>Individual</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_ARRAY__INDIVIDUAL = 0;

  /**
   * The feature id for the '<em><b>Aggregate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_ARRAY__AGGREGATE = 1;

  /**
   * The feature id for the '<em><b>Statistical Significance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_ARRAY__STATISTICAL_SIGNIFICANCE = 2;

  /**
   * The number of structural features of the '<em>Show Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_ARRAY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupSpecificationImpl <em>Analysis Group Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisGroupSpecification()
   * @generated
   */
  int ANALYSIS_GROUP_SPECIFICATION = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_GROUP_SPECIFICATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_GROUP_SPECIFICATION__ALGORITHMS = 1;

  /**
   * The number of structural features of the '<em>Analysis Group Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_GROUP_SPECIFICATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmReferencesImpl <em>Algorithm References</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmReferencesImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAlgorithmReferences()
   * @generated
   */
  int ALGORITHM_REFERENCES = 22;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALGORITHM_REFERENCES__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Algorithm References</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALGORITHM_REFERENCES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisCommandImpl <em>Analysis Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisCommand()
   * @generated
   */
  int ANALYSIS_COMMAND = 23;

  /**
   * The number of structural features of the '<em>Analysis Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_COMMAND_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.PrintAnalysisCommandImpl <em>Print Analysis Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.PrintAnalysisCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getPrintAnalysisCommand()
   * @generated
   */
  int PRINT_ANALYSIS_COMMAND = 24;

  /**
   * The number of structural features of the '<em>Print Analysis Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_ANALYSIS_COMMAND_FEATURE_COUNT = ANALYSIS_COMMAND_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.SaveAnalysisCommandImpl <em>Save Analysis Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.SaveAnalysisCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getSaveAnalysisCommand()
   * @generated
   */
  int SAVE_ANALYSIS_COMMAND = 25;

  /**
   * The feature id for the '<em><b>File</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_ANALYSIS_COMMAND__FILE = ANALYSIS_COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Save Analysis Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_ANALYSIS_COMMAND_FEATURE_COUNT = ANALYSIS_COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.BoxplotCommandImpl <em>Boxplot Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.BoxplotCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getBoxplotCommand()
   * @generated
   */
  int BOXPLOT_COMMAND = 26;

  /**
   * The feature id for the '<em><b>Directory</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOXPLOT_COMMAND__DIRECTORY = ANALYSIS_COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boxplot Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOXPLOT_COMMAND_FEATURE_COUNT = ANALYSIS_COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementImpl <em>Result Management</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getResultManagement()
   * @generated
   */
  int RESULT_MANAGEMENT = 27;

  /**
   * The feature id for the '<em><b>Adapt Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__ADAPT_MODELS = 0;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__COMMANDS = 1;

  /**
   * The number of structural features of the '<em>Result Management</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl <em>Result Management Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getResultManagementCommand()
   * @generated
   */
  int RESULT_MANAGEMENT_COMMAND = 28;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT_COMMAND__ALGORITHMS = 0;

  /**
   * The feature id for the '<em><b>Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE = 1;

  /**
   * The feature id for the '<em><b>Max Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE = 2;

  /**
   * The feature id for the '<em><b>Print Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT = 3;

  /**
   * The number of structural features of the '<em>Result Management Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ObjectivesCommandImpl <em>Objectives Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ObjectivesCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getObjectivesCommand()
   * @generated
   */
  int OBJECTIVES_COMMAND = 29;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVES_COMMAND__ALGORITHMS = RESULT_MANAGEMENT_COMMAND__ALGORITHMS;

  /**
   * The feature id for the '<em><b>Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVES_COMMAND__NEIGHBORHOOD_SIZE = RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE;

  /**
   * The feature id for the '<em><b>Max Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVES_COMMAND__MAX_NEIGHBORHOOD_SIZE = RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE;

  /**
   * The feature id for the '<em><b>Print Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVES_COMMAND__PRINT_OUTPUT = RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVES_COMMAND__FILE = RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Objectives Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVES_COMMAND_FEATURE_COUNT = RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.SolutionsCommandImpl <em>Solutions Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.SolutionsCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getSolutionsCommand()
   * @generated
   */
  int SOLUTIONS_COMMAND = 30;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTIONS_COMMAND__ALGORITHMS = RESULT_MANAGEMENT_COMMAND__ALGORITHMS;

  /**
   * The feature id for the '<em><b>Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTIONS_COMMAND__NEIGHBORHOOD_SIZE = RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE;

  /**
   * The feature id for the '<em><b>Max Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTIONS_COMMAND__MAX_NEIGHBORHOOD_SIZE = RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE;

  /**
   * The feature id for the '<em><b>Print Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTIONS_COMMAND__PRINT_OUTPUT = RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTIONS_COMMAND__FILE = RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTIONS_COMMAND__DIRECTORY = RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Solutions Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTIONS_COMMAND_FEATURE_COUNT = RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ModelsCommandImpl <em>Models Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.impl.ModelsCommandImpl
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getModelsCommand()
   * @generated
   */
  int MODELS_COMMAND = 31;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELS_COMMAND__ALGORITHMS = RESULT_MANAGEMENT_COMMAND__ALGORITHMS;

  /**
   * The feature id for the '<em><b>Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELS_COMMAND__NEIGHBORHOOD_SIZE = RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE;

  /**
   * The feature id for the '<em><b>Max Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELS_COMMAND__MAX_NEIGHBORHOOD_SIZE = RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE;

  /**
   * The feature id for the '<em><b>Print Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELS_COMMAND__PRINT_OUTPUT = RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT;

  /**
   * The feature id for the '<em><b>Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELS_COMMAND__DIRECTORY = RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Models Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELS_COMMAND_FEATURE_COUNT = RESULT_MANAGEMENT_COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType <em>Fitness Dimension Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType
   * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionType()
   * @generated
   */
  int FITNESS_DIMENSION_TYPE = 32;


  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch <em>MO Mo TSearch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MO Mo TSearch</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch
   * @generated
   */
  EClass getMOMoTSearch();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getPackage()
   * @see #getMOMoTSearch()
   * @generated
   */
  EAttribute getMOMoTSearch_Package();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getImportSection()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_ImportSection();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getVariables()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_Variables();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getInitialization <em>Initialization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initialization</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getInitialization()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_Initialization();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getName()
   * @see #getMOMoTSearch()
   * @generated
   */
  EAttribute getMOMoTSearch_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getSearchOrchestration <em>Search Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Search Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getSearchOrchestration()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_SearchOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getExperimentOrchestration <em>Experiment Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Experiment Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getExperimentOrchestration()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_ExperimentOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getAnalysisOrchestration <em>Analysis Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Analysis Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getAnalysisOrchestration()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_AnalysisOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getResultManagement <em>Result Management</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result Management</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getResultManagement()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_ResultManagement();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getFinalization <em>Finalization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Finalization</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getFinalization()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_Finalization();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Declaration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.VariableDeclaration
   * @generated
   */
  EClass getVariableDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.VariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.VariableDeclaration#getType()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.VariableDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.VariableDeclaration#getName()
   * @see #getVariableDeclaration()
   * @generated
   */
  EAttribute getVariableDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.VariableDeclaration#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.VariableDeclaration#getInit()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Init();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration <em>Module Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration
   * @generated
   */
  EClass getModuleOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modules</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getModules()
   * @see #getModuleOrchestration()
   * @generated
   */
  EReference getModuleOrchestration_Modules();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getUnitsToRemove <em>Units To Remove</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Units To Remove</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getUnitsToRemove()
   * @see #getModuleOrchestration()
   * @generated
   */
  EReference getModuleOrchestration_UnitsToRemove();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getNonSolutionParameters <em>Non Solution Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Non Solution Parameters</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getNonSolutionParameters()
   * @see #getModuleOrchestration()
   * @generated
   */
  EReference getModuleOrchestration_NonSolutionParameters();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getParameterValues <em>Parameter Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getParameterValues()
   * @see #getModuleOrchestration()
   * @generated
   */
  EReference getModuleOrchestration_ParameterValues();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification <em>Parmeter Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parmeter Value Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification
   * @generated
   */
  EClass getParmeterValueSpecification();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getName()
   * @see #getParmeterValueSpecification()
   * @generated
   */
  EReference getParmeterValueSpecification_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getCall()
   * @see #getParmeterValueSpecification()
   * @generated
   */
  EReference getParmeterValueSpecification_Call();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration <em>Search Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Search Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration
   * @generated
   */
  EClass getSearchOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getModel()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_Model();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getSolutionLength <em>Solution Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Solution Length</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getSolutionLength()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_SolutionLength();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getModuleOrchestration <em>Module Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Module Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getModuleOrchestration()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_ModuleOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getFitnessFunction <em>Fitness Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fitness Function</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getFitnessFunction()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_FitnessFunction();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getAlgorithms()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_Algorithms();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getEqualityHelper <em>Equality Helper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Equality Helper</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration#getEqualityHelper()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_EqualityHelper();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.InputModel <em>Input Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Model</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.InputModel
   * @generated
   */
  EClass getInputModel();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.InputModel#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.InputModel#getPath()
   * @see #getInputModel()
   * @generated
   */
  EReference getInputModel_Path();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.InputModel#getAdaptation <em>Adaptation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Adaptation</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.InputModel#getAdaptation()
   * @see #getInputModel()
   * @generated
   */
  EReference getInputModel_Adaptation();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper <em>Equality Helper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Helper</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.EqualityHelper
   * @generated
   */
  EClass getEqualityHelper();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getCall()
   * @see #getEqualityHelper()
   * @generated
   */
  EReference getEqualityHelper_Call();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Method</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getMethod()
   * @see #getEqualityHelper()
   * @generated
   */
  EReference getEqualityHelper_Method();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmList <em>Algorithm List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Algorithm List</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmList
   * @generated
   */
  EClass getAlgorithmList();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmList#getSpecifications <em>Specifications</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Specifications</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmList#getSpecifications()
   * @see #getAlgorithmList()
   * @generated
   */
  EReference getAlgorithmList_Specifications();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification <em>Fitness Function Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Function Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification
   * @generated
   */
  EClass getFitnessFunctionSpecification();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getConstructor <em>Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constructor</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getConstructor()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Constructor();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPreprocess <em>Preprocess</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Preprocess</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPreprocess()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Preprocess();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getObjectives <em>Objectives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objectives</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getObjectives()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Objectives();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getConstraints()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Constraints();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPostprocess <em>Postprocess</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Postprocess</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPostprocess()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Postprocess();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getSolutionRepairer <em>Solution Repairer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Solution Repairer</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getSolutionRepairer()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_SolutionRepairer();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification <em>Fitness Dimension Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification
   * @generated
   */
  EClass getFitnessDimensionSpecification();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getName()
   * @see #getFitnessDimensionSpecification()
   * @generated
   */
  EAttribute getFitnessDimensionSpecification_Name();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getType()
   * @see #getFitnessDimensionSpecification()
   * @generated
   */
  EAttribute getFitnessDimensionSpecification_Type();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionConstructor <em>Fitness Dimension Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension Constructor</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionConstructor
   * @generated
   */
  EClass getFitnessDimensionConstructor();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionConstructor#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionConstructor#getCall()
   * @see #getFitnessDimensionConstructor()
   * @generated
   */
  EReference getFitnessDimensionConstructor_Call();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase <em>Fitness Dimension XBase</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension XBase</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase
   * @generated
   */
  EClass getFitnessDimensionXBase();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase#getValue()
   * @see #getFitnessDimensionXBase()
   * @generated
   */
  EReference getFitnessDimensionXBase_Value();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL <em>Fitness Dimension OCL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension OCL</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL
   * @generated
   */
  EClass getFitnessDimensionOCL();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Query</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL#getQuery()
   * @see #getFitnessDimensionOCL()
   * @generated
   */
  EReference getFitnessDimensionOCL_Query();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL#getDefExpressions <em>Def Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Def Expressions</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL#getDefExpressions()
   * @see #getFitnessDimensionOCL()
   * @generated
   */
  EReference getFitnessDimensionOCL_DefExpressions();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.DefExpression <em>Def Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Def Expression</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.DefExpression
   * @generated
   */
  EClass getDefExpression();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.DefExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.DefExpression#getExpression()
   * @see #getDefExpression()
   * @generated
   */
  EAttribute getDefExpression_Expression();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification <em>Algorithm Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Algorithm Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification
   * @generated
   */
  EClass getAlgorithmSpecification();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification#getName()
   * @see #getAlgorithmSpecification()
   * @generated
   */
  EAttribute getAlgorithmSpecification_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification#getCall()
   * @see #getAlgorithmSpecification()
   * @generated
   */
  EReference getAlgorithmSpecification_Call();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration <em>Experiment Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Experiment Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration
   * @generated
   */
  EClass getExperimentOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getPopulationSize <em>Population Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Population Size</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getPopulationSize()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_PopulationSize();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getMaxEvaluations <em>Max Evaluations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Max Evaluations</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getMaxEvaluations()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_MaxEvaluations();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getNrRuns <em>Nr Runs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nr Runs</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getNrRuns()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_NrRuns();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getReferenceSet <em>Reference Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference Set</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getReferenceSet()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_ReferenceSet();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getProgressListeners <em>Progress Listeners</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Progress Listeners</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getProgressListeners()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_ProgressListeners();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getCollectors <em>Collectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collectors</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getCollectors()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_Collectors();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getCustomCollectors <em>Custom Collectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Custom Collectors</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getCustomCollectors()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_CustomCollectors();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray <em>Collector Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collector Array</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray
   * @generated
   */
  EClass getCollectorArray();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isHypervolume <em>Hypervolume</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hypervolume</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isHypervolume()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_Hypervolume();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isGenerationalDistance <em>Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isGenerationalDistance()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_GenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isInvertedGenerationalDistance <em>Inverted Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inverted Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isInvertedGenerationalDistance()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_InvertedGenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isSpacing <em>Spacing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Spacing</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isSpacing()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_Spacing();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isAdditiveEpsilonIndicator <em>Additive Epsilon Indicator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Additive Epsilon Indicator</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isAdditiveEpsilonIndicator()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_AdditiveEpsilonIndicator();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isContribution <em>Contribution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Contribution</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isContribution()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_Contribution();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isR1 <em>R1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R1</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isR1()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_R1();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isR2 <em>R2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R2</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isR2()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_R2();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isR3 <em>R3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R3</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isR3()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_R3();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isAdaptiveMultimethodVariation <em>Adaptive Multimethod Variation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Adaptive Multimethod Variation</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isAdaptiveMultimethodVariation()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_AdaptiveMultimethodVariation();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isAdaptiveTimeContinuation <em>Adaptive Time Continuation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Adaptive Time Continuation</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isAdaptiveTimeContinuation()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_AdaptiveTimeContinuation();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isApproximationSet <em>Approximation Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Approximation Set</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isApproximationSet()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_ApproximationSet();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isEpsilonProgress <em>Epsilon Progress</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Epsilon Progress</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isEpsilonProgress()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_EpsilonProgress();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isElapsedTime <em>Elapsed Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Elapsed Time</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isElapsedTime()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_ElapsedTime();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray#isPopulationSize <em>Population Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Population Size</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray#isPopulationSize()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_PopulationSize();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration <em>Analysis Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration
   * @generated
   */
  EClass getAnalysisOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getIndicators <em>Indicators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indicators</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getIndicators()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Indicators();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSignificance <em>Significance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Significance</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSignificance()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Significance();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getShow <em>Show</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Show</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getShow()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Show();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getGrouping <em>Grouping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Grouping</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getGrouping()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Grouping();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSaveCommand <em>Save Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Save Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSaveCommand()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_SaveCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getBoxplotCommand <em>Boxplot Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Boxplot Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getBoxplotCommand()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_BoxplotCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getPrintCommand <em>Print Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Print Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getPrintCommand()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_PrintCommand();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList <em>Analysis Group List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Group List</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList
   * @generated
   */
  EClass getAnalysisGroupList();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Group</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList#getGroup()
   * @see #getAnalysisGroupList()
   * @generated
   */
  EReference getAnalysisGroupList_Group();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray <em>Indicator Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Indicator Array</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray
   * @generated
   */
  EClass getIndicatorArray();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isHypervolume <em>Hypervolume</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hypervolume</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isHypervolume()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_Hypervolume();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isGenerationalDistance <em>Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isGenerationalDistance()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_GenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isInvertedGenerationalDistance <em>Inverted Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inverted Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isInvertedGenerationalDistance()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_InvertedGenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isSpacing <em>Spacing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Spacing</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isSpacing()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_Spacing();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isAdditiveEpsilonIndicator <em>Additive Epsilon Indicator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Additive Epsilon Indicator</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isAdditiveEpsilonIndicator()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_AdditiveEpsilonIndicator();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isContribution <em>Contribution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Contribution</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isContribution()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_Contribution();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isR1 <em>R1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R1</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isR1()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_R1();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isR2 <em>R2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R2</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isR2()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_R2();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isR3 <em>R3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R3</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isR3()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_R3();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isMaximumParetoFrontError <em>Maximum Pareto Front Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Maximum Pareto Front Error</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray#isMaximumParetoFrontError()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_MaximumParetoFrontError();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray <em>Show Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Show Array</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ShowArray
   * @generated
   */
  EClass getShowArray();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isIndividual <em>Individual</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Individual</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ShowArray#isIndividual()
   * @see #getShowArray()
   * @generated
   */
  EAttribute getShowArray_Individual();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isAggregate <em>Aggregate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Aggregate</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ShowArray#isAggregate()
   * @see #getShowArray()
   * @generated
   */
  EAttribute getShowArray_Aggregate();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isStatisticalSignificance <em>Statistical Significance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Statistical Significance</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ShowArray#isStatisticalSignificance()
   * @see #getShowArray()
   * @generated
   */
  EAttribute getShowArray_StatisticalSignificance();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification <em>Analysis Group Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Group Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification
   * @generated
   */
  EClass getAnalysisGroupSpecification();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getName()
   * @see #getAnalysisGroupSpecification()
   * @generated
   */
  EAttribute getAnalysisGroupSpecification_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getAlgorithms()
   * @see #getAnalysisGroupSpecification()
   * @generated
   */
  EReference getAnalysisGroupSpecification_Algorithms();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences <em>Algorithm References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Algorithm References</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences
   * @generated
   */
  EClass getAlgorithmReferences();

  /**
   * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Elements</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences#getElements()
   * @see #getAlgorithmReferences()
   * @generated
   */
  EReference getAlgorithmReferences_Elements();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisCommand <em>Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisCommand
   * @generated
   */
  EClass getAnalysisCommand();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.PrintAnalysisCommand <em>Print Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Print Analysis Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.PrintAnalysisCommand
   * @generated
   */
  EClass getPrintAnalysisCommand();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand <em>Save Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Save Analysis Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand
   * @generated
   */
  EClass getSaveAnalysisCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>File</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand#getFile()
   * @see #getSaveAnalysisCommand()
   * @generated
   */
  EReference getSaveAnalysisCommand_File();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.BoxplotCommand <em>Boxplot Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boxplot Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.BoxplotCommand
   * @generated
   */
  EClass getBoxplotCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.BoxplotCommand#getDirectory <em>Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Directory</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.BoxplotCommand#getDirectory()
   * @see #getBoxplotCommand()
   * @generated
   */
  EReference getBoxplotCommand_Directory();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagement <em>Result Management</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Management</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagement
   * @generated
   */
  EClass getResultManagement();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagement#getAdaptModels <em>Adapt Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Adapt Models</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagement#getAdaptModels()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_AdaptModels();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagement#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagement#getCommands()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_Commands();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand <em>Result Management Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Management Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand
   * @generated
   */
  EClass getResultManagementCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getAlgorithms()
   * @see #getResultManagementCommand()
   * @generated
   */
  EReference getResultManagementCommand_Algorithms();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getNeighborhoodSize <em>Neighborhood Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Neighborhood Size</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getNeighborhoodSize()
   * @see #getResultManagementCommand()
   * @generated
   */
  EAttribute getResultManagementCommand_NeighborhoodSize();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isMaxNeighborhoodSize <em>Max Neighborhood Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Neighborhood Size</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isMaxNeighborhoodSize()
   * @see #getResultManagementCommand()
   * @generated
   */
  EAttribute getResultManagementCommand_MaxNeighborhoodSize();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isPrintOutput <em>Print Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Print Output</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isPrintOutput()
   * @see #getResultManagementCommand()
   * @generated
   */
  EAttribute getResultManagementCommand_PrintOutput();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ObjectivesCommand <em>Objectives Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Objectives Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ObjectivesCommand
   * @generated
   */
  EClass getObjectivesCommand();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ObjectivesCommand#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ObjectivesCommand#getFile()
   * @see #getObjectivesCommand()
   * @generated
   */
  EAttribute getObjectivesCommand_File();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand <em>Solutions Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Solutions Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SolutionsCommand
   * @generated
   */
  EClass getSolutionsCommand();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getFile()
   * @see #getSolutionsCommand()
   * @generated
   */
  EAttribute getSolutionsCommand_File();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getDirectory <em>Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Directory</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getDirectory()
   * @see #getSolutionsCommand()
   * @generated
   */
  EAttribute getSolutionsCommand_Directory();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.momot.ModelsCommand <em>Models Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Models Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ModelsCommand
   * @generated
   */
  EClass getModelsCommand();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.momot.ModelsCommand#getDirectory <em>Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Directory</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.ModelsCommand#getDirectory()
   * @see #getModelsCommand()
   * @generated
   */
  EAttribute getModelsCommand_Directory();

  /**
   * Returns the meta object for enum '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType <em>Fitness Dimension Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Fitness Dimension Type</em>'.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType
   * @generated
   */
  EEnum getFitnessDimensionType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MomotFactory getMomotFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl <em>MO Mo TSearch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getMOMoTSearch()
     * @generated
     */
    EClass MO_MO_TSEARCH = eINSTANCE.getMOMoTSearch();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MO_MO_TSEARCH__PACKAGE = eINSTANCE.getMOMoTSearch_Package();

    /**
     * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__IMPORT_SECTION = eINSTANCE.getMOMoTSearch_ImportSection();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__VARIABLES = eINSTANCE.getMOMoTSearch_Variables();

    /**
     * The meta object literal for the '<em><b>Initialization</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__INITIALIZATION = eINSTANCE.getMOMoTSearch_Initialization();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MO_MO_TSEARCH__NAME = eINSTANCE.getMOMoTSearch_Name();

    /**
     * The meta object literal for the '<em><b>Search Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__SEARCH_ORCHESTRATION = eINSTANCE.getMOMoTSearch_SearchOrchestration();

    /**
     * The meta object literal for the '<em><b>Experiment Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION = eINSTANCE.getMOMoTSearch_ExperimentOrchestration();

    /**
     * The meta object literal for the '<em><b>Analysis Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION = eINSTANCE.getMOMoTSearch_AnalysisOrchestration();

    /**
     * The meta object literal for the '<em><b>Result Management</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__RESULT_MANAGEMENT = eINSTANCE.getMOMoTSearch_ResultManagement();

    /**
     * The meta object literal for the '<em><b>Finalization</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MO_MO_TSEARCH__FINALIZATION = eINSTANCE.getMOMoTSearch_Finalization();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.VariableDeclarationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getVariableDeclaration()
     * @generated
     */
    EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__INIT = eINSTANCE.getVariableDeclaration_Init();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl <em>Module Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getModuleOrchestration()
     * @generated
     */
    EClass MODULE_ORCHESTRATION = eINSTANCE.getModuleOrchestration();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_ORCHESTRATION__MODULES = eINSTANCE.getModuleOrchestration_Modules();

    /**
     * The meta object literal for the '<em><b>Units To Remove</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_ORCHESTRATION__UNITS_TO_REMOVE = eINSTANCE.getModuleOrchestration_UnitsToRemove();

    /**
     * The meta object literal for the '<em><b>Non Solution Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS = eINSTANCE.getModuleOrchestration_NonSolutionParameters();

    /**
     * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_ORCHESTRATION__PARAMETER_VALUES = eINSTANCE.getModuleOrchestration_ParameterValues();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ParmeterValueSpecificationImpl <em>Parmeter Value Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ParmeterValueSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getParmeterValueSpecification()
     * @generated
     */
    EClass PARMETER_VALUE_SPECIFICATION = eINSTANCE.getParmeterValueSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARMETER_VALUE_SPECIFICATION__NAME = eINSTANCE.getParmeterValueSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARMETER_VALUE_SPECIFICATION__CALL = eINSTANCE.getParmeterValueSpecification_Call();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl <em>Search Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getSearchOrchestration()
     * @generated
     */
    EClass SEARCH_ORCHESTRATION = eINSTANCE.getSearchOrchestration();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEARCH_ORCHESTRATION__MODEL = eINSTANCE.getSearchOrchestration_Model();

    /**
     * The meta object literal for the '<em><b>Solution Length</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEARCH_ORCHESTRATION__SOLUTION_LENGTH = eINSTANCE.getSearchOrchestration_SolutionLength();

    /**
     * The meta object literal for the '<em><b>Module Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION = eINSTANCE.getSearchOrchestration_ModuleOrchestration();

    /**
     * The meta object literal for the '<em><b>Fitness Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEARCH_ORCHESTRATION__FITNESS_FUNCTION = eINSTANCE.getSearchOrchestration_FitnessFunction();

    /**
     * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEARCH_ORCHESTRATION__ALGORITHMS = eINSTANCE.getSearchOrchestration_Algorithms();

    /**
     * The meta object literal for the '<em><b>Equality Helper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEARCH_ORCHESTRATION__EQUALITY_HELPER = eINSTANCE.getSearchOrchestration_EqualityHelper();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.InputModelImpl <em>Input Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.InputModelImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getInputModel()
     * @generated
     */
    EClass INPUT_MODEL = eINSTANCE.getInputModel();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_MODEL__PATH = eINSTANCE.getInputModel_Path();

    /**
     * The meta object literal for the '<em><b>Adaptation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_MODEL__ADAPTATION = eINSTANCE.getInputModel_Adaptation();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.EqualityHelperImpl <em>Equality Helper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.EqualityHelperImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getEqualityHelper()
     * @generated
     */
    EClass EQUALITY_HELPER = eINSTANCE.getEqualityHelper();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_HELPER__CALL = eINSTANCE.getEqualityHelper_Call();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_HELPER__METHOD = eINSTANCE.getEqualityHelper_Method();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmListImpl <em>Algorithm List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmListImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAlgorithmList()
     * @generated
     */
    EClass ALGORITHM_LIST = eINSTANCE.getAlgorithmList();

    /**
     * The meta object literal for the '<em><b>Specifications</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALGORITHM_LIST__SPECIFICATIONS = eINSTANCE.getAlgorithmList_Specifications();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl <em>Fitness Function Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessFunctionSpecification()
     * @generated
     */
    EClass FITNESS_FUNCTION_SPECIFICATION = eINSTANCE.getFitnessFunctionSpecification();

    /**
     * The meta object literal for the '<em><b>Constructor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR = eINSTANCE.getFitnessFunctionSpecification_Constructor();

    /**
     * The meta object literal for the '<em><b>Preprocess</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_FUNCTION_SPECIFICATION__PREPROCESS = eINSTANCE.getFitnessFunctionSpecification_Preprocess();

    /**
     * The meta object literal for the '<em><b>Objectives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES = eINSTANCE.getFitnessFunctionSpecification_Objectives();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS = eINSTANCE.getFitnessFunctionSpecification_Constraints();

    /**
     * The meta object literal for the '<em><b>Postprocess</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS = eINSTANCE.getFitnessFunctionSpecification_Postprocess();

    /**
     * The meta object literal for the '<em><b>Solution Repairer</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER = eINSTANCE.getFitnessFunctionSpecification_SolutionRepairer();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionSpecificationImpl <em>Fitness Dimension Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionSpecification()
     * @generated
     */
    EClass FITNESS_DIMENSION_SPECIFICATION = eINSTANCE.getFitnessDimensionSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FITNESS_DIMENSION_SPECIFICATION__NAME = eINSTANCE.getFitnessDimensionSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FITNESS_DIMENSION_SPECIFICATION__TYPE = eINSTANCE.getFitnessDimensionSpecification_Type();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionConstructorImpl <em>Fitness Dimension Constructor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionConstructorImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionConstructor()
     * @generated
     */
    EClass FITNESS_DIMENSION_CONSTRUCTOR = eINSTANCE.getFitnessDimensionConstructor();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_DIMENSION_CONSTRUCTOR__CALL = eINSTANCE.getFitnessDimensionConstructor_Call();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionXBaseImpl <em>Fitness Dimension XBase</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionXBaseImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionXBase()
     * @generated
     */
    EClass FITNESS_DIMENSION_XBASE = eINSTANCE.getFitnessDimensionXBase();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_DIMENSION_XBASE__VALUE = eINSTANCE.getFitnessDimensionXBase_Value();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionOCLImpl <em>Fitness Dimension OCL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionOCLImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionOCL()
     * @generated
     */
    EClass FITNESS_DIMENSION_OCL = eINSTANCE.getFitnessDimensionOCL();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_DIMENSION_OCL__QUERY = eINSTANCE.getFitnessDimensionOCL_Query();

    /**
     * The meta object literal for the '<em><b>Def Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS = eINSTANCE.getFitnessDimensionOCL_DefExpressions();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.DefExpressionImpl <em>Def Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.DefExpressionImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getDefExpression()
     * @generated
     */
    EClass DEF_EXPRESSION = eINSTANCE.getDefExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEF_EXPRESSION__EXPRESSION = eINSTANCE.getDefExpression_Expression();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmSpecificationImpl <em>Algorithm Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAlgorithmSpecification()
     * @generated
     */
    EClass ALGORITHM_SPECIFICATION = eINSTANCE.getAlgorithmSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALGORITHM_SPECIFICATION__NAME = eINSTANCE.getAlgorithmSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALGORITHM_SPECIFICATION__CALL = eINSTANCE.getAlgorithmSpecification_Call();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl <em>Experiment Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getExperimentOrchestration()
     * @generated
     */
    EClass EXPERIMENT_ORCHESTRATION = eINSTANCE.getExperimentOrchestration();

    /**
     * The meta object literal for the '<em><b>Population Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_ORCHESTRATION__POPULATION_SIZE = eINSTANCE.getExperimentOrchestration_PopulationSize();

    /**
     * The meta object literal for the '<em><b>Max Evaluations</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS = eINSTANCE.getExperimentOrchestration_MaxEvaluations();

    /**
     * The meta object literal for the '<em><b>Nr Runs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_ORCHESTRATION__NR_RUNS = eINSTANCE.getExperimentOrchestration_NrRuns();

    /**
     * The meta object literal for the '<em><b>Reference Set</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_ORCHESTRATION__REFERENCE_SET = eINSTANCE.getExperimentOrchestration_ReferenceSet();

    /**
     * The meta object literal for the '<em><b>Progress Listeners</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS = eINSTANCE.getExperimentOrchestration_ProgressListeners();

    /**
     * The meta object literal for the '<em><b>Collectors</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_ORCHESTRATION__COLLECTORS = eINSTANCE.getExperimentOrchestration_Collectors();

    /**
     * The meta object literal for the '<em><b>Custom Collectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS = eINSTANCE.getExperimentOrchestration_CustomCollectors();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl <em>Collector Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getCollectorArray()
     * @generated
     */
    EClass COLLECTOR_ARRAY = eINSTANCE.getCollectorArray();

    /**
     * The meta object literal for the '<em><b>Hypervolume</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__HYPERVOLUME = eINSTANCE.getCollectorArray_Hypervolume();

    /**
     * The meta object literal for the '<em><b>Generational Distance</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__GENERATIONAL_DISTANCE = eINSTANCE.getCollectorArray_GenerationalDistance();

    /**
     * The meta object literal for the '<em><b>Inverted Generational Distance</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE = eINSTANCE.getCollectorArray_InvertedGenerationalDistance();

    /**
     * The meta object literal for the '<em><b>Spacing</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__SPACING = eINSTANCE.getCollectorArray_Spacing();

    /**
     * The meta object literal for the '<em><b>Additive Epsilon Indicator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR = eINSTANCE.getCollectorArray_AdditiveEpsilonIndicator();

    /**
     * The meta object literal for the '<em><b>Contribution</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__CONTRIBUTION = eINSTANCE.getCollectorArray_Contribution();

    /**
     * The meta object literal for the '<em><b>R1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__R1 = eINSTANCE.getCollectorArray_R1();

    /**
     * The meta object literal for the '<em><b>R2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__R2 = eINSTANCE.getCollectorArray_R2();

    /**
     * The meta object literal for the '<em><b>R3</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__R3 = eINSTANCE.getCollectorArray_R3();

    /**
     * The meta object literal for the '<em><b>Adaptive Multimethod Variation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION = eINSTANCE.getCollectorArray_AdaptiveMultimethodVariation();

    /**
     * The meta object literal for the '<em><b>Adaptive Time Continuation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION = eINSTANCE.getCollectorArray_AdaptiveTimeContinuation();

    /**
     * The meta object literal for the '<em><b>Approximation Set</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__APPROXIMATION_SET = eINSTANCE.getCollectorArray_ApproximationSet();

    /**
     * The meta object literal for the '<em><b>Epsilon Progress</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__EPSILON_PROGRESS = eINSTANCE.getCollectorArray_EpsilonProgress();

    /**
     * The meta object literal for the '<em><b>Elapsed Time</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__ELAPSED_TIME = eINSTANCE.getCollectorArray_ElapsedTime();

    /**
     * The meta object literal for the '<em><b>Population Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTOR_ARRAY__POPULATION_SIZE = eINSTANCE.getCollectorArray_PopulationSize();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl <em>Analysis Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisOrchestration()
     * @generated
     */
    EClass ANALYSIS_ORCHESTRATION = eINSTANCE.getAnalysisOrchestration();

    /**
     * The meta object literal for the '<em><b>Indicators</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_ORCHESTRATION__INDICATORS = eINSTANCE.getAnalysisOrchestration_Indicators();

    /**
     * The meta object literal for the '<em><b>Significance</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_ORCHESTRATION__SIGNIFICANCE = eINSTANCE.getAnalysisOrchestration_Significance();

    /**
     * The meta object literal for the '<em><b>Show</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_ORCHESTRATION__SHOW = eINSTANCE.getAnalysisOrchestration_Show();

    /**
     * The meta object literal for the '<em><b>Grouping</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_ORCHESTRATION__GROUPING = eINSTANCE.getAnalysisOrchestration_Grouping();

    /**
     * The meta object literal for the '<em><b>Save Command</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_ORCHESTRATION__SAVE_COMMAND = eINSTANCE.getAnalysisOrchestration_SaveCommand();

    /**
     * The meta object literal for the '<em><b>Boxplot Command</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND = eINSTANCE.getAnalysisOrchestration_BoxplotCommand();

    /**
     * The meta object literal for the '<em><b>Print Command</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_ORCHESTRATION__PRINT_COMMAND = eINSTANCE.getAnalysisOrchestration_PrintCommand();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupListImpl <em>Analysis Group List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupListImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisGroupList()
     * @generated
     */
    EClass ANALYSIS_GROUP_LIST = eINSTANCE.getAnalysisGroupList();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_GROUP_LIST__GROUP = eINSTANCE.getAnalysisGroupList_Group();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl <em>Indicator Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getIndicatorArray()
     * @generated
     */
    EClass INDICATOR_ARRAY = eINSTANCE.getIndicatorArray();

    /**
     * The meta object literal for the '<em><b>Hypervolume</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__HYPERVOLUME = eINSTANCE.getIndicatorArray_Hypervolume();

    /**
     * The meta object literal for the '<em><b>Generational Distance</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__GENERATIONAL_DISTANCE = eINSTANCE.getIndicatorArray_GenerationalDistance();

    /**
     * The meta object literal for the '<em><b>Inverted Generational Distance</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE = eINSTANCE.getIndicatorArray_InvertedGenerationalDistance();

    /**
     * The meta object literal for the '<em><b>Spacing</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__SPACING = eINSTANCE.getIndicatorArray_Spacing();

    /**
     * The meta object literal for the '<em><b>Additive Epsilon Indicator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR = eINSTANCE.getIndicatorArray_AdditiveEpsilonIndicator();

    /**
     * The meta object literal for the '<em><b>Contribution</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__CONTRIBUTION = eINSTANCE.getIndicatorArray_Contribution();

    /**
     * The meta object literal for the '<em><b>R1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__R1 = eINSTANCE.getIndicatorArray_R1();

    /**
     * The meta object literal for the '<em><b>R2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__R2 = eINSTANCE.getIndicatorArray_R2();

    /**
     * The meta object literal for the '<em><b>R3</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__R3 = eINSTANCE.getIndicatorArray_R3();

    /**
     * The meta object literal for the '<em><b>Maximum Pareto Front Error</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR = eINSTANCE.getIndicatorArray_MaximumParetoFrontError();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ShowArrayImpl <em>Show Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ShowArrayImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getShowArray()
     * @generated
     */
    EClass SHOW_ARRAY = eINSTANCE.getShowArray();

    /**
     * The meta object literal for the '<em><b>Individual</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHOW_ARRAY__INDIVIDUAL = eINSTANCE.getShowArray_Individual();

    /**
     * The meta object literal for the '<em><b>Aggregate</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHOW_ARRAY__AGGREGATE = eINSTANCE.getShowArray_Aggregate();

    /**
     * The meta object literal for the '<em><b>Statistical Significance</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHOW_ARRAY__STATISTICAL_SIGNIFICANCE = eINSTANCE.getShowArray_StatisticalSignificance();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupSpecificationImpl <em>Analysis Group Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisGroupSpecification()
     * @generated
     */
    EClass ANALYSIS_GROUP_SPECIFICATION = eINSTANCE.getAnalysisGroupSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANALYSIS_GROUP_SPECIFICATION__NAME = eINSTANCE.getAnalysisGroupSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS_GROUP_SPECIFICATION__ALGORITHMS = eINSTANCE.getAnalysisGroupSpecification_Algorithms();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmReferencesImpl <em>Algorithm References</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.AlgorithmReferencesImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAlgorithmReferences()
     * @generated
     */
    EClass ALGORITHM_REFERENCES = eINSTANCE.getAlgorithmReferences();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALGORITHM_REFERENCES__ELEMENTS = eINSTANCE.getAlgorithmReferences_Elements();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisCommandImpl <em>Analysis Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.AnalysisCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getAnalysisCommand()
     * @generated
     */
    EClass ANALYSIS_COMMAND = eINSTANCE.getAnalysisCommand();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.PrintAnalysisCommandImpl <em>Print Analysis Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.PrintAnalysisCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getPrintAnalysisCommand()
     * @generated
     */
    EClass PRINT_ANALYSIS_COMMAND = eINSTANCE.getPrintAnalysisCommand();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.SaveAnalysisCommandImpl <em>Save Analysis Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.SaveAnalysisCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getSaveAnalysisCommand()
     * @generated
     */
    EClass SAVE_ANALYSIS_COMMAND = eINSTANCE.getSaveAnalysisCommand();

    /**
     * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAVE_ANALYSIS_COMMAND__FILE = eINSTANCE.getSaveAnalysisCommand_File();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.BoxplotCommandImpl <em>Boxplot Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.BoxplotCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getBoxplotCommand()
     * @generated
     */
    EClass BOXPLOT_COMMAND = eINSTANCE.getBoxplotCommand();

    /**
     * The meta object literal for the '<em><b>Directory</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOXPLOT_COMMAND__DIRECTORY = eINSTANCE.getBoxplotCommand_Directory();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementImpl <em>Result Management</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getResultManagement()
     * @generated
     */
    EClass RESULT_MANAGEMENT = eINSTANCE.getResultManagement();

    /**
     * The meta object literal for the '<em><b>Adapt Models</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__ADAPT_MODELS = eINSTANCE.getResultManagement_AdaptModels();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__COMMANDS = eINSTANCE.getResultManagement_Commands();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl <em>Result Management Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getResultManagementCommand()
     * @generated
     */
    EClass RESULT_MANAGEMENT_COMMAND = eINSTANCE.getResultManagementCommand();

    /**
     * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT_COMMAND__ALGORITHMS = eINSTANCE.getResultManagementCommand_Algorithms();

    /**
     * The meta object literal for the '<em><b>Neighborhood Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE = eINSTANCE.getResultManagementCommand_NeighborhoodSize();

    /**
     * The meta object literal for the '<em><b>Max Neighborhood Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE = eINSTANCE.getResultManagementCommand_MaxNeighborhoodSize();

    /**
     * The meta object literal for the '<em><b>Print Output</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT = eINSTANCE.getResultManagementCommand_PrintOutput();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ObjectivesCommandImpl <em>Objectives Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ObjectivesCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getObjectivesCommand()
     * @generated
     */
    EClass OBJECTIVES_COMMAND = eINSTANCE.getObjectivesCommand();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECTIVES_COMMAND__FILE = eINSTANCE.getObjectivesCommand_File();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.SolutionsCommandImpl <em>Solutions Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.SolutionsCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getSolutionsCommand()
     * @generated
     */
    EClass SOLUTIONS_COMMAND = eINSTANCE.getSolutionsCommand();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOLUTIONS_COMMAND__FILE = eINSTANCE.getSolutionsCommand_File();

    /**
     * The meta object literal for the '<em><b>Directory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOLUTIONS_COMMAND__DIRECTORY = eINSTANCE.getSolutionsCommand_Directory();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.impl.ModelsCommandImpl <em>Models Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.impl.ModelsCommandImpl
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getModelsCommand()
     * @generated
     */
    EClass MODELS_COMMAND = eINSTANCE.getModelsCommand();

    /**
     * The meta object literal for the '<em><b>Directory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODELS_COMMAND__DIRECTORY = eINSTANCE.getModelsCommand_Directory();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType <em>Fitness Dimension Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType
     * @see at.ac.tuwien.big.momot.lang.momot.impl.MomotPackageImpl#getFitnessDimensionType()
     * @generated
     */
    EEnum FITNESS_DIMENSION_TYPE = eINSTANCE.getFitnessDimensionType();

  }

} //MomotPackage
