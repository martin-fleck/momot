/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

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
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTFactory
 * @model kind="package"
 * @generated
 */
public interface MOMoTPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mOMoT";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.ac.at/tuwien/big/momot/lang/MOMoT";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mOMoT";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MOMoTPackage eINSTANCE = at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl.init();

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTSearchImpl <em>Search</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTSearchImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getMOMoTSearch()
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
   * The number of structural features of the '<em>Search</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MO_MO_TSEARCH_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.VariableDeclarationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getVariableDeclaration()
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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.TransformationOrchestrationImpl <em>Transformation Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.TransformationOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getTransformationOrchestration()
   * @generated
   */
  int TRANSFORMATION_ORCHESTRATION = 2;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_ORCHESTRATION__MODULES = 0;

  /**
   * The feature id for the '<em><b>Units To Remove</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_ORCHESTRATION__UNITS_TO_REMOVE = 1;

  /**
   * The feature id for the '<em><b>Non Solution Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_ORCHESTRATION__NON_SOLUTION_PARAMETERS = 2;

  /**
   * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_ORCHESTRATION__PARAMETER_VALUES = 3;

  /**
   * The number of structural features of the '<em>Transformation Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_ORCHESTRATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ParmeterValueSpecificationImpl <em>Parmeter Value Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ParmeterValueSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getParmeterValueSpecification()
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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl <em>Search Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSearchOrchestration()
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
   * The feature id for the '<em><b>Transformation Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION = 2;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.EqualityHelperImpl <em>Equality Helper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.EqualityHelperImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getEqualityHelper()
   * @generated
   */
  int EQUALITY_HELPER = 5;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmListImpl <em>Algorithm List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmListImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAlgorithmList()
   * @generated
   */
  int ALGORITHM_LIST = 6;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessFunctionSpecificationImpl <em>Fitness Function Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessFunctionSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessFunctionSpecification()
   * @generated
   */
  int FITNESS_FUNCTION_SPECIFICATION = 7;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionSpecificationImpl <em>Fitness Dimension Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionSpecification()
   * @generated
   */
  int FITNESS_DIMENSION_SPECIFICATION = 8;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionConstructorImpl <em>Fitness Dimension Constructor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionConstructorImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionConstructor()
   * @generated
   */
  int FITNESS_DIMENSION_CONSTRUCTOR = 9;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionXBaseImpl <em>Fitness Dimension XBase</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionXBaseImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionXBase()
   * @generated
   */
  int FITNESS_DIMENSION_XBASE = 10;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionOCLImpl <em>Fitness Dimension OCL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionOCLImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionOCL()
   * @generated
   */
  int FITNESS_DIMENSION_OCL = 11;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.DefExpressionImpl <em>Def Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.DefExpressionImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getDefExpression()
   * @generated
   */
  int DEF_EXPRESSION = 12;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmSpecificationImpl <em>Algorithm Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAlgorithmSpecification()
   * @generated
   */
  int ALGORITHM_SPECIFICATION = 13;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ExperimentOrchestrationImpl <em>Experiment Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ExperimentOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getExperimentOrchestration()
   * @generated
   */
  int EXPERIMENT_ORCHESTRATION = 14;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.CollectorArrayImpl <em>Collector Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.CollectorArrayImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getCollectorArray()
   * @generated
   */
  int COLLECTOR_ARRAY = 15;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisOrchestrationImpl <em>Analysis Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisOrchestrationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAnalysisOrchestration()
   * @generated
   */
  int ANALYSIS_ORCHESTRATION = 16;

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
   * The number of structural features of the '<em>Analysis Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_ORCHESTRATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupListImpl <em>Analysis Group List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupListImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAnalysisGroupList()
   * @generated
   */
  int ANALYSIS_GROUP_LIST = 17;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.IndicatorArrayImpl <em>Indicator Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.IndicatorArrayImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getIndicatorArray()
   * @generated
   */
  int INDICATOR_ARRAY = 18;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ShowArrayImpl <em>Show Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ShowArrayImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getShowArray()
   * @generated
   */
  int SHOW_ARRAY = 19;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupSpecificationImpl <em>Analysis Group Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupSpecificationImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAnalysisGroupSpecification()
   * @generated
   */
  int ANALYSIS_GROUP_SPECIFICATION = 20;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmReferencesImpl <em>Algorithm References</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmReferencesImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAlgorithmReferences()
   * @generated
   */
  int ALGORITHM_REFERENCES = 21;

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
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl <em>Result Management</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getResultManagement()
   * @generated
   */
  int RESULT_MANAGEMENT = 22;

  /**
   * The feature id for the '<em><b>Save Analysis</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__SAVE_ANALYSIS = 0;

  /**
   * The feature id for the '<em><b>Save Objectives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__SAVE_OBJECTIVES = 1;

  /**
   * The feature id for the '<em><b>Save Solutions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__SAVE_SOLUTIONS = 2;

  /**
   * The feature id for the '<em><b>Print Objectives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__PRINT_OBJECTIVES = 3;

  /**
   * The feature id for the '<em><b>Print Solutions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__PRINT_SOLUTIONS = 4;

  /**
   * The feature id for the '<em><b>Do Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT__DO_COMMAND = 5;

  /**
   * The number of structural features of the '<em>Result Management</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_MANAGEMENT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveAnalysisCommandImpl <em>Save Analysis Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveAnalysisCommandImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSaveAnalysisCommand()
   * @generated
   */
  int SAVE_ANALYSIS_COMMAND = 23;

  /**
   * The feature id for the '<em><b>File</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_ANALYSIS_COMMAND__FILE = 0;

  /**
   * The number of structural features of the '<em>Save Analysis Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_ANALYSIS_COMMAND_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveObjectivesCommandImpl <em>Save Objectives Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveObjectivesCommandImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSaveObjectivesCommand()
   * @generated
   */
  int SAVE_OBJECTIVES_COMMAND = 24;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_OBJECTIVES_COMMAND__ALGORITHMS = 0;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_OBJECTIVES_COMMAND__FILE = 1;

  /**
   * The number of structural features of the '<em>Save Objectives Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_OBJECTIVES_COMMAND_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveSolutionsCommandImpl <em>Save Solutions Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveSolutionsCommandImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSaveSolutionsCommand()
   * @generated
   */
  int SAVE_SOLUTIONS_COMMAND = 25;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_SOLUTIONS_COMMAND__ALGORITHMS = 0;

  /**
   * The feature id for the '<em><b>Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_SOLUTIONS_COMMAND__DIRECTORY = 1;

  /**
   * The number of structural features of the '<em>Save Solutions Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_SOLUTIONS_COMMAND_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintObjectivesCommandImpl <em>Print Objectives Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintObjectivesCommandImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getPrintObjectivesCommand()
   * @generated
   */
  int PRINT_OBJECTIVES_COMMAND = 26;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_OBJECTIVES_COMMAND__ALGORITHMS = 0;

  /**
   * The number of structural features of the '<em>Print Objectives Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_OBJECTIVES_COMMAND_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintSolutionsCommandImpl <em>Print Solutions Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintSolutionsCommandImpl
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getPrintSolutionsCommand()
   * @generated
   */
  int PRINT_SOLUTIONS_COMMAND = 27;

  /**
   * The feature id for the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_SOLUTIONS_COMMAND__ALGORITHMS = 0;

  /**
   * The number of structural features of the '<em>Print Solutions Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_SOLUTIONS_COMMAND_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType <em>Fitness Dimension Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType
   * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionType()
   * @generated
   */
  int FITNESS_DIMENSION_TYPE = 28;


  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch <em>Search</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Search</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch
   * @generated
   */
  EClass getMOMoTSearch();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getPackage()
   * @see #getMOMoTSearch()
   * @generated
   */
  EAttribute getMOMoTSearch_Package();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getImportSection()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_ImportSection();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getVariables()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_Variables();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getInitialization <em>Initialization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initialization</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getInitialization()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_Initialization();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getName()
   * @see #getMOMoTSearch()
   * @generated
   */
  EAttribute getMOMoTSearch_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getSearchOrchestration <em>Search Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Search Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getSearchOrchestration()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_SearchOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getExperimentOrchestration <em>Experiment Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Experiment Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getExperimentOrchestration()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_ExperimentOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getAnalysisOrchestration <em>Analysis Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Analysis Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getAnalysisOrchestration()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_AnalysisOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getResultManagement <em>Result Management</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result Management</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch#getResultManagement()
   * @see #getMOMoTSearch()
   * @generated
   */
  EReference getMOMoTSearch_ResultManagement();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Declaration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration
   * @generated
   */
  EClass getVariableDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration#getType()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration#getName()
   * @see #getVariableDeclaration()
   * @generated
   */
  EAttribute getVariableDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration#getInit()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Init();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration <em>Transformation Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration
   * @generated
   */
  EClass getTransformationOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modules</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getModules()
   * @see #getTransformationOrchestration()
   * @generated
   */
  EReference getTransformationOrchestration_Modules();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getUnitsToRemove <em>Units To Remove</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Units To Remove</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getUnitsToRemove()
   * @see #getTransformationOrchestration()
   * @generated
   */
  EReference getTransformationOrchestration_UnitsToRemove();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getNonSolutionParameters <em>Non Solution Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Non Solution Parameters</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getNonSolutionParameters()
   * @see #getTransformationOrchestration()
   * @generated
   */
  EReference getTransformationOrchestration_NonSolutionParameters();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getParameterValues <em>Parameter Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration#getParameterValues()
   * @see #getTransformationOrchestration()
   * @generated
   */
  EReference getTransformationOrchestration_ParameterValues();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification <em>Parmeter Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parmeter Value Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification
   * @generated
   */
  EClass getParmeterValueSpecification();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification#getName()
   * @see #getParmeterValueSpecification()
   * @generated
   */
  EReference getParmeterValueSpecification_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification#getCall()
   * @see #getParmeterValueSpecification()
   * @generated
   */
  EReference getParmeterValueSpecification_Call();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration <em>Search Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Search Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration
   * @generated
   */
  EClass getSearchOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getModel()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_Model();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getSolutionLength <em>Solution Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Solution Length</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getSolutionLength()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_SolutionLength();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getTransformationOrchestration <em>Transformation Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Transformation Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getTransformationOrchestration()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_TransformationOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getFitnessFunction <em>Fitness Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fitness Function</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getFitnessFunction()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_FitnessFunction();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getAlgorithms()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_Algorithms();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getEqualityHelper <em>Equality Helper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Equality Helper</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getEqualityHelper()
   * @see #getSearchOrchestration()
   * @generated
   */
  EReference getSearchOrchestration_EqualityHelper();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper <em>Equality Helper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Helper</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper
   * @generated
   */
  EClass getEqualityHelper();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper#getCall()
   * @see #getEqualityHelper()
   * @generated
   */
  EReference getEqualityHelper_Call();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Method</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper#getMethod()
   * @see #getEqualityHelper()
   * @generated
   */
  EReference getEqualityHelper_Method();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList <em>Algorithm List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Algorithm List</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList
   * @generated
   */
  EClass getAlgorithmList();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList#getSpecifications <em>Specifications</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Specifications</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList#getSpecifications()
   * @see #getAlgorithmList()
   * @generated
   */
  EReference getAlgorithmList_Specifications();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification <em>Fitness Function Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Function Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification
   * @generated
   */
  EClass getFitnessFunctionSpecification();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getConstructor <em>Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constructor</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getConstructor()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Constructor();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getPreprocess <em>Preprocess</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Preprocess</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getPreprocess()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Preprocess();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getObjectives <em>Objectives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objectives</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getObjectives()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Objectives();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getConstraints()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Constraints();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getPostprocess <em>Postprocess</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Postprocess</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getPostprocess()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_Postprocess();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getSolutionRepairer <em>Solution Repairer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Solution Repairer</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification#getSolutionRepairer()
   * @see #getFitnessFunctionSpecification()
   * @generated
   */
  EReference getFitnessFunctionSpecification_SolutionRepairer();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification <em>Fitness Dimension Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification
   * @generated
   */
  EClass getFitnessDimensionSpecification();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification#getName()
   * @see #getFitnessDimensionSpecification()
   * @generated
   */
  EAttribute getFitnessDimensionSpecification_Name();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification#getType()
   * @see #getFitnessDimensionSpecification()
   * @generated
   */
  EAttribute getFitnessDimensionSpecification_Type();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor <em>Fitness Dimension Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension Constructor</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor
   * @generated
   */
  EClass getFitnessDimensionConstructor();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor#getCall()
   * @see #getFitnessDimensionConstructor()
   * @generated
   */
  EReference getFitnessDimensionConstructor_Call();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase <em>Fitness Dimension XBase</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension XBase</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase
   * @generated
   */
  EClass getFitnessDimensionXBase();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase#getValue()
   * @see #getFitnessDimensionXBase()
   * @generated
   */
  EReference getFitnessDimensionXBase_Value();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL <em>Fitness Dimension OCL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fitness Dimension OCL</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL
   * @generated
   */
  EClass getFitnessDimensionOCL();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Query</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL#getQuery()
   * @see #getFitnessDimensionOCL()
   * @generated
   */
  EReference getFitnessDimensionOCL_Query();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL#getDefExpressions <em>Def Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Def Expressions</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL#getDefExpressions()
   * @see #getFitnessDimensionOCL()
   * @generated
   */
  EReference getFitnessDimensionOCL_DefExpressions();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.DefExpression <em>Def Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Def Expression</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.DefExpression
   * @generated
   */
  EClass getDefExpression();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.DefExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.DefExpression#getExpression()
   * @see #getDefExpression()
   * @generated
   */
  EAttribute getDefExpression_Expression();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification <em>Algorithm Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Algorithm Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification
   * @generated
   */
  EClass getAlgorithmSpecification();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification#getName()
   * @see #getAlgorithmSpecification()
   * @generated
   */
  EAttribute getAlgorithmSpecification_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification#getCall()
   * @see #getAlgorithmSpecification()
   * @generated
   */
  EReference getAlgorithmSpecification_Call();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration <em>Experiment Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Experiment Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration
   * @generated
   */
  EClass getExperimentOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getPopulationSize <em>Population Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Population Size</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getPopulationSize()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_PopulationSize();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getMaxEvaluations <em>Max Evaluations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Max Evaluations</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getMaxEvaluations()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_MaxEvaluations();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getNrRuns <em>Nr Runs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nr Runs</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getNrRuns()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_NrRuns();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getReferenceSet <em>Reference Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference Set</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getReferenceSet()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_ReferenceSet();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getProgressListeners <em>Progress Listeners</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Progress Listeners</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getProgressListeners()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_ProgressListeners();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getCollectors <em>Collectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collectors</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getCollectors()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_Collectors();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getCustomCollectors <em>Custom Collectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Custom Collectors</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration#getCustomCollectors()
   * @see #getExperimentOrchestration()
   * @generated
   */
  EReference getExperimentOrchestration_CustomCollectors();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray <em>Collector Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collector Array</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray
   * @generated
   */
  EClass getCollectorArray();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isHypervolume <em>Hypervolume</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hypervolume</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isHypervolume()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_Hypervolume();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isGenerationalDistance <em>Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isGenerationalDistance()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_GenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isInvertedGenerationalDistance <em>Inverted Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inverted Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isInvertedGenerationalDistance()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_InvertedGenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isSpacing <em>Spacing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Spacing</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isSpacing()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_Spacing();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isAdditiveEpsilonIndicator <em>Additive Epsilon Indicator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Additive Epsilon Indicator</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isAdditiveEpsilonIndicator()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_AdditiveEpsilonIndicator();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isContribution <em>Contribution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Contribution</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isContribution()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_Contribution();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isR1 <em>R1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R1</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isR1()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_R1();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isR2 <em>R2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R2</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isR2()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_R2();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isR3 <em>R3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R3</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isR3()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_R3();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isAdaptiveMultimethodVariation <em>Adaptive Multimethod Variation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Adaptive Multimethod Variation</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isAdaptiveMultimethodVariation()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_AdaptiveMultimethodVariation();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isAdaptiveTimeContinuation <em>Adaptive Time Continuation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Adaptive Time Continuation</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isAdaptiveTimeContinuation()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_AdaptiveTimeContinuation();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isApproximationSet <em>Approximation Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Approximation Set</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isApproximationSet()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_ApproximationSet();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isEpsilonProgress <em>Epsilon Progress</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Epsilon Progress</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isEpsilonProgress()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_EpsilonProgress();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isElapsedTime <em>Elapsed Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Elapsed Time</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isElapsedTime()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_ElapsedTime();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isPopulationSize <em>Population Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Population Size</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray#isPopulationSize()
   * @see #getCollectorArray()
   * @generated
   */
  EAttribute getCollectorArray_PopulationSize();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration <em>Analysis Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Orchestration</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration
   * @generated
   */
  EClass getAnalysisOrchestration();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getIndicators <em>Indicators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indicators</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getIndicators()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Indicators();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getSignificance <em>Significance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Significance</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getSignificance()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Significance();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getShow <em>Show</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Show</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getShow()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Show();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getGrouping <em>Grouping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Grouping</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getGrouping()
   * @see #getAnalysisOrchestration()
   * @generated
   */
  EReference getAnalysisOrchestration_Grouping();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupList <em>Analysis Group List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Group List</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupList
   * @generated
   */
  EClass getAnalysisGroupList();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupList#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Group</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupList#getGroup()
   * @see #getAnalysisGroupList()
   * @generated
   */
  EReference getAnalysisGroupList_Group();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray <em>Indicator Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Indicator Array</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray
   * @generated
   */
  EClass getIndicatorArray();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isHypervolume <em>Hypervolume</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hypervolume</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isHypervolume()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_Hypervolume();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isGenerationalDistance <em>Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isGenerationalDistance()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_GenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isInvertedGenerationalDistance <em>Inverted Generational Distance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inverted Generational Distance</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isInvertedGenerationalDistance()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_InvertedGenerationalDistance();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isSpacing <em>Spacing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Spacing</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isSpacing()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_Spacing();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isAdditiveEpsilonIndicator <em>Additive Epsilon Indicator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Additive Epsilon Indicator</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isAdditiveEpsilonIndicator()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_AdditiveEpsilonIndicator();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isContribution <em>Contribution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Contribution</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isContribution()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_Contribution();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isR1 <em>R1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R1</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isR1()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_R1();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isR2 <em>R2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R2</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isR2()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_R2();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isR3 <em>R3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R3</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isR3()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_R3();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isMaximumParetoFrontError <em>Maximum Pareto Front Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Maximum Pareto Front Error</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray#isMaximumParetoFrontError()
   * @see #getIndicatorArray()
   * @generated
   */
  EAttribute getIndicatorArray_MaximumParetoFrontError();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ShowArray <em>Show Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Show Array</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ShowArray
   * @generated
   */
  EClass getShowArray();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.ShowArray#isIndividual <em>Individual</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Individual</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ShowArray#isIndividual()
   * @see #getShowArray()
   * @generated
   */
  EAttribute getShowArray_Individual();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.ShowArray#isAggregate <em>Aggregate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Aggregate</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ShowArray#isAggregate()
   * @see #getShowArray()
   * @generated
   */
  EAttribute getShowArray_Aggregate();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.ShowArray#isStatisticalSignificance <em>Statistical Significance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Statistical Significance</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ShowArray#isStatisticalSignificance()
   * @see #getShowArray()
   * @generated
   */
  EAttribute getShowArray_StatisticalSignificance();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification <em>Analysis Group Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Group Specification</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification
   * @generated
   */
  EClass getAnalysisGroupSpecification();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification#getName()
   * @see #getAnalysisGroupSpecification()
   * @generated
   */
  EAttribute getAnalysisGroupSpecification_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification#getAlgorithms()
   * @see #getAnalysisGroupSpecification()
   * @generated
   */
  EReference getAnalysisGroupSpecification_Algorithms();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences <em>Algorithm References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Algorithm References</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences
   * @generated
   */
  EClass getAlgorithmReferences();

  /**
   * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Elements</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences#getElements()
   * @see #getAlgorithmReferences()
   * @generated
   */
  EReference getAlgorithmReferences_Elements();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement <em>Result Management</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Management</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement
   * @generated
   */
  EClass getResultManagement();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveAnalysis <em>Save Analysis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Save Analysis</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveAnalysis()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_SaveAnalysis();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveObjectives <em>Save Objectives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Save Objectives</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveObjectives()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_SaveObjectives();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveSolutions <em>Save Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Save Solutions</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveSolutions()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_SaveSolutions();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getPrintObjectives <em>Print Objectives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Print Objectives</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getPrintObjectives()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_PrintObjectives();

  /**
   * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getPrintSolutions <em>Print Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Print Solutions</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getPrintSolutions()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_PrintSolutions();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getDoCommand <em>Do Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Do Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getDoCommand()
   * @see #getResultManagement()
   * @generated
   */
  EReference getResultManagement_DoCommand();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand <em>Save Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Save Analysis Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand
   * @generated
   */
  EClass getSaveAnalysisCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>File</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand#getFile()
   * @see #getSaveAnalysisCommand()
   * @generated
   */
  EReference getSaveAnalysisCommand_File();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand <em>Save Objectives Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Save Objectives Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand
   * @generated
   */
  EClass getSaveObjectivesCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getAlgorithms()
   * @see #getSaveObjectivesCommand()
   * @generated
   */
  EReference getSaveObjectivesCommand_Algorithms();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getFile()
   * @see #getSaveObjectivesCommand()
   * @generated
   */
  EAttribute getSaveObjectivesCommand_File();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand <em>Save Solutions Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Save Solutions Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand
   * @generated
   */
  EClass getSaveSolutionsCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getAlgorithms()
   * @see #getSaveSolutionsCommand()
   * @generated
   */
  EReference getSaveSolutionsCommand_Algorithms();

  /**
   * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getDirectory <em>Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Directory</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getDirectory()
   * @see #getSaveSolutionsCommand()
   * @generated
   */
  EAttribute getSaveSolutionsCommand_Directory();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand <em>Print Objectives Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Print Objectives Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand
   * @generated
   */
  EClass getPrintObjectivesCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand#getAlgorithms()
   * @see #getPrintObjectivesCommand()
   * @generated
   */
  EReference getPrintObjectivesCommand_Algorithms();

  /**
   * Returns the meta object for class '{@link at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand <em>Print Solutions Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Print Solutions Command</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand
   * @generated
   */
  EClass getPrintSolutionsCommand();

  /**
   * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand#getAlgorithms <em>Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Algorithms</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand#getAlgorithms()
   * @see #getPrintSolutionsCommand()
   * @generated
   */
  EReference getPrintSolutionsCommand_Algorithms();

  /**
   * Returns the meta object for enum '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType <em>Fitness Dimension Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Fitness Dimension Type</em>'.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType
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
  MOMoTFactory getMOMoTFactory();

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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTSearchImpl <em>Search</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTSearchImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getMOMoTSearch()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.VariableDeclarationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getVariableDeclaration()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.TransformationOrchestrationImpl <em>Transformation Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.TransformationOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getTransformationOrchestration()
     * @generated
     */
    EClass TRANSFORMATION_ORCHESTRATION = eINSTANCE.getTransformationOrchestration();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_ORCHESTRATION__MODULES = eINSTANCE.getTransformationOrchestration_Modules();

    /**
     * The meta object literal for the '<em><b>Units To Remove</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_ORCHESTRATION__UNITS_TO_REMOVE = eINSTANCE.getTransformationOrchestration_UnitsToRemove();

    /**
     * The meta object literal for the '<em><b>Non Solution Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_ORCHESTRATION__NON_SOLUTION_PARAMETERS = eINSTANCE.getTransformationOrchestration_NonSolutionParameters();

    /**
     * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_ORCHESTRATION__PARAMETER_VALUES = eINSTANCE.getTransformationOrchestration_ParameterValues();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ParmeterValueSpecificationImpl <em>Parmeter Value Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ParmeterValueSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getParmeterValueSpecification()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl <em>Search Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSearchOrchestration()
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
     * The meta object literal for the '<em><b>Transformation Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION = eINSTANCE.getSearchOrchestration_TransformationOrchestration();

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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.EqualityHelperImpl <em>Equality Helper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.EqualityHelperImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getEqualityHelper()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmListImpl <em>Algorithm List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmListImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAlgorithmList()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessFunctionSpecificationImpl <em>Fitness Function Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessFunctionSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessFunctionSpecification()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionSpecificationImpl <em>Fitness Dimension Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionSpecification()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionConstructorImpl <em>Fitness Dimension Constructor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionConstructorImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionConstructor()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionXBaseImpl <em>Fitness Dimension XBase</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionXBaseImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionXBase()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionOCLImpl <em>Fitness Dimension OCL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.FitnessDimensionOCLImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionOCL()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.DefExpressionImpl <em>Def Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.DefExpressionImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getDefExpression()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmSpecificationImpl <em>Algorithm Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAlgorithmSpecification()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ExperimentOrchestrationImpl <em>Experiment Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ExperimentOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getExperimentOrchestration()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.CollectorArrayImpl <em>Collector Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.CollectorArrayImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getCollectorArray()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisOrchestrationImpl <em>Analysis Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisOrchestrationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAnalysisOrchestration()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupListImpl <em>Analysis Group List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupListImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAnalysisGroupList()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.IndicatorArrayImpl <em>Indicator Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.IndicatorArrayImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getIndicatorArray()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ShowArrayImpl <em>Show Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ShowArrayImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getShowArray()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupSpecificationImpl <em>Analysis Group Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AnalysisGroupSpecificationImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAnalysisGroupSpecification()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmReferencesImpl <em>Algorithm References</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.AlgorithmReferencesImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getAlgorithmReferences()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl <em>Result Management</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getResultManagement()
     * @generated
     */
    EClass RESULT_MANAGEMENT = eINSTANCE.getResultManagement();

    /**
     * The meta object literal for the '<em><b>Save Analysis</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__SAVE_ANALYSIS = eINSTANCE.getResultManagement_SaveAnalysis();

    /**
     * The meta object literal for the '<em><b>Save Objectives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__SAVE_OBJECTIVES = eINSTANCE.getResultManagement_SaveObjectives();

    /**
     * The meta object literal for the '<em><b>Save Solutions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__SAVE_SOLUTIONS = eINSTANCE.getResultManagement_SaveSolutions();

    /**
     * The meta object literal for the '<em><b>Print Objectives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__PRINT_OBJECTIVES = eINSTANCE.getResultManagement_PrintObjectives();

    /**
     * The meta object literal for the '<em><b>Print Solutions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__PRINT_SOLUTIONS = eINSTANCE.getResultManagement_PrintSolutions();

    /**
     * The meta object literal for the '<em><b>Do Command</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_MANAGEMENT__DO_COMMAND = eINSTANCE.getResultManagement_DoCommand();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveAnalysisCommandImpl <em>Save Analysis Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveAnalysisCommandImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSaveAnalysisCommand()
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
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveObjectivesCommandImpl <em>Save Objectives Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveObjectivesCommandImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSaveObjectivesCommand()
     * @generated
     */
    EClass SAVE_OBJECTIVES_COMMAND = eINSTANCE.getSaveObjectivesCommand();

    /**
     * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAVE_OBJECTIVES_COMMAND__ALGORITHMS = eINSTANCE.getSaveObjectivesCommand_Algorithms();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAVE_OBJECTIVES_COMMAND__FILE = eINSTANCE.getSaveObjectivesCommand_File();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveSolutionsCommandImpl <em>Save Solutions Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveSolutionsCommandImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getSaveSolutionsCommand()
     * @generated
     */
    EClass SAVE_SOLUTIONS_COMMAND = eINSTANCE.getSaveSolutionsCommand();

    /**
     * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAVE_SOLUTIONS_COMMAND__ALGORITHMS = eINSTANCE.getSaveSolutionsCommand_Algorithms();

    /**
     * The meta object literal for the '<em><b>Directory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAVE_SOLUTIONS_COMMAND__DIRECTORY = eINSTANCE.getSaveSolutionsCommand_Directory();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintObjectivesCommandImpl <em>Print Objectives Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintObjectivesCommandImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getPrintObjectivesCommand()
     * @generated
     */
    EClass PRINT_OBJECTIVES_COMMAND = eINSTANCE.getPrintObjectivesCommand();

    /**
     * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRINT_OBJECTIVES_COMMAND__ALGORITHMS = eINSTANCE.getPrintObjectivesCommand_Algorithms();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintSolutionsCommandImpl <em>Print Solutions Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintSolutionsCommandImpl
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getPrintSolutionsCommand()
     * @generated
     */
    EClass PRINT_SOLUTIONS_COMMAND = eINSTANCE.getPrintSolutionsCommand();

    /**
     * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRINT_SOLUTIONS_COMMAND__ALGORITHMS = eINSTANCE.getPrintSolutionsCommand_Algorithms();

    /**
     * The meta object literal for the '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType <em>Fitness Dimension Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType
     * @see at.ac.tuwien.big.momot.lang.mOMoT.impl.MOMoTPackageImpl#getFitnessDimensionType()
     * @generated
     */
    EEnum FITNESS_DIMENSION_TYPE = eINSTANCE.getFitnessDimensionType();

  }

} //MOMoTPackage
