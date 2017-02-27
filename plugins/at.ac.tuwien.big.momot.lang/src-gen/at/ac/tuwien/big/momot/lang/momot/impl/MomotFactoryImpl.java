/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MomotFactoryImpl extends EFactoryImpl implements MomotFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MomotFactory init()
  {
    try
    {
      MomotFactory theMomotFactory = (MomotFactory)EPackage.Registry.INSTANCE.getEFactory(MomotPackage.eNS_URI);
      if (theMomotFactory != null)
      {
        return theMomotFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MomotFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MomotFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MomotPackage.MO_MO_TSEARCH: return createMOMoTSearch();
      case MomotPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
      case MomotPackage.MODULE_ORCHESTRATION: return createModuleOrchestration();
      case MomotPackage.PARMETER_VALUE_SPECIFICATION: return createParmeterValueSpecification();
      case MomotPackage.SEARCH_ORCHESTRATION: return createSearchOrchestration();
      case MomotPackage.INPUT_MODEL: return createInputModel();
      case MomotPackage.EQUALITY_HELPER: return createEqualityHelper();
      case MomotPackage.ALGORITHM_LIST: return createAlgorithmList();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION: return createFitnessFunctionSpecification();
      case MomotPackage.FITNESS_DIMENSION_SPECIFICATION: return createFitnessDimensionSpecification();
      case MomotPackage.FITNESS_DIMENSION_CONSTRUCTOR: return createFitnessDimensionConstructor();
      case MomotPackage.FITNESS_DIMENSION_XBASE: return createFitnessDimensionXBase();
      case MomotPackage.FITNESS_DIMENSION_OCL: return createFitnessDimensionOCL();
      case MomotPackage.DEF_EXPRESSION: return createDefExpression();
      case MomotPackage.ALGORITHM_SPECIFICATION: return createAlgorithmSpecification();
      case MomotPackage.EXPERIMENT_ORCHESTRATION: return createExperimentOrchestration();
      case MomotPackage.COLLECTOR_ARRAY: return createCollectorArray();
      case MomotPackage.ANALYSIS_ORCHESTRATION: return createAnalysisOrchestration();
      case MomotPackage.ANALYSIS_GROUP_LIST: return createAnalysisGroupList();
      case MomotPackage.INDICATOR_ARRAY: return createIndicatorArray();
      case MomotPackage.SHOW_ARRAY: return createShowArray();
      case MomotPackage.ANALYSIS_GROUP_SPECIFICATION: return createAnalysisGroupSpecification();
      case MomotPackage.ALGORITHM_REFERENCES: return createAlgorithmReferences();
      case MomotPackage.ANALYSIS_COMMAND: return createAnalysisCommand();
      case MomotPackage.PRINT_ANALYSIS_COMMAND: return createPrintAnalysisCommand();
      case MomotPackage.SAVE_ANALYSIS_COMMAND: return createSaveAnalysisCommand();
      case MomotPackage.BOXPLOT_COMMAND: return createBoxplotCommand();
      case MomotPackage.RESULT_MANAGEMENT: return createResultManagement();
      case MomotPackage.RESULT_MANAGEMENT_COMMAND: return createResultManagementCommand();
      case MomotPackage.OBJECTIVES_COMMAND: return createObjectivesCommand();
      case MomotPackage.SOLUTIONS_COMMAND: return createSolutionsCommand();
      case MomotPackage.MODELS_COMMAND: return createModelsCommand();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MomotPackage.FITNESS_DIMENSION_TYPE:
        return createFitnessDimensionTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MomotPackage.FITNESS_DIMENSION_TYPE:
        return convertFitnessDimensionTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOMoTSearch createMOMoTSearch()
  {
    MOMoTSearchImpl moMoTSearch = new MOMoTSearchImpl();
    return moMoTSearch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclaration createVariableDeclaration()
  {
    VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
    return variableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleOrchestration createModuleOrchestration()
  {
    ModuleOrchestrationImpl moduleOrchestration = new ModuleOrchestrationImpl();
    return moduleOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParmeterValueSpecification createParmeterValueSpecification()
  {
    ParmeterValueSpecificationImpl parmeterValueSpecification = new ParmeterValueSpecificationImpl();
    return parmeterValueSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SearchOrchestration createSearchOrchestration()
  {
    SearchOrchestrationImpl searchOrchestration = new SearchOrchestrationImpl();
    return searchOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputModel createInputModel()
  {
    InputModelImpl inputModel = new InputModelImpl();
    return inputModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityHelper createEqualityHelper()
  {
    EqualityHelperImpl equalityHelper = new EqualityHelperImpl();
    return equalityHelper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlgorithmList createAlgorithmList()
  {
    AlgorithmListImpl algorithmList = new AlgorithmListImpl();
    return algorithmList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FitnessFunctionSpecification createFitnessFunctionSpecification()
  {
    FitnessFunctionSpecificationImpl fitnessFunctionSpecification = new FitnessFunctionSpecificationImpl();
    return fitnessFunctionSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FitnessDimensionSpecification createFitnessDimensionSpecification()
  {
    FitnessDimensionSpecificationImpl fitnessDimensionSpecification = new FitnessDimensionSpecificationImpl();
    return fitnessDimensionSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FitnessDimensionConstructor createFitnessDimensionConstructor()
  {
    FitnessDimensionConstructorImpl fitnessDimensionConstructor = new FitnessDimensionConstructorImpl();
    return fitnessDimensionConstructor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FitnessDimensionXBase createFitnessDimensionXBase()
  {
    FitnessDimensionXBaseImpl fitnessDimensionXBase = new FitnessDimensionXBaseImpl();
    return fitnessDimensionXBase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FitnessDimensionOCL createFitnessDimensionOCL()
  {
    FitnessDimensionOCLImpl fitnessDimensionOCL = new FitnessDimensionOCLImpl();
    return fitnessDimensionOCL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefExpression createDefExpression()
  {
    DefExpressionImpl defExpression = new DefExpressionImpl();
    return defExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlgorithmSpecification createAlgorithmSpecification()
  {
    AlgorithmSpecificationImpl algorithmSpecification = new AlgorithmSpecificationImpl();
    return algorithmSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExperimentOrchestration createExperimentOrchestration()
  {
    ExperimentOrchestrationImpl experimentOrchestration = new ExperimentOrchestrationImpl();
    return experimentOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectorArray createCollectorArray()
  {
    CollectorArrayImpl collectorArray = new CollectorArrayImpl();
    return collectorArray;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisOrchestration createAnalysisOrchestration()
  {
    AnalysisOrchestrationImpl analysisOrchestration = new AnalysisOrchestrationImpl();
    return analysisOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisGroupList createAnalysisGroupList()
  {
    AnalysisGroupListImpl analysisGroupList = new AnalysisGroupListImpl();
    return analysisGroupList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndicatorArray createIndicatorArray()
  {
    IndicatorArrayImpl indicatorArray = new IndicatorArrayImpl();
    return indicatorArray;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShowArray createShowArray()
  {
    ShowArrayImpl showArray = new ShowArrayImpl();
    return showArray;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisGroupSpecification createAnalysisGroupSpecification()
  {
    AnalysisGroupSpecificationImpl analysisGroupSpecification = new AnalysisGroupSpecificationImpl();
    return analysisGroupSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlgorithmReferences createAlgorithmReferences()
  {
    AlgorithmReferencesImpl algorithmReferences = new AlgorithmReferencesImpl();
    return algorithmReferences;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisCommand createAnalysisCommand()
  {
    AnalysisCommandImpl analysisCommand = new AnalysisCommandImpl();
    return analysisCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrintAnalysisCommand createPrintAnalysisCommand()
  {
    PrintAnalysisCommandImpl printAnalysisCommand = new PrintAnalysisCommandImpl();
    return printAnalysisCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SaveAnalysisCommand createSaveAnalysisCommand()
  {
    SaveAnalysisCommandImpl saveAnalysisCommand = new SaveAnalysisCommandImpl();
    return saveAnalysisCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoxplotCommand createBoxplotCommand()
  {
    BoxplotCommandImpl boxplotCommand = new BoxplotCommandImpl();
    return boxplotCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultManagement createResultManagement()
  {
    ResultManagementImpl resultManagement = new ResultManagementImpl();
    return resultManagement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultManagementCommand createResultManagementCommand()
  {
    ResultManagementCommandImpl resultManagementCommand = new ResultManagementCommandImpl();
    return resultManagementCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectivesCommand createObjectivesCommand()
  {
    ObjectivesCommandImpl objectivesCommand = new ObjectivesCommandImpl();
    return objectivesCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SolutionsCommand createSolutionsCommand()
  {
    SolutionsCommandImpl solutionsCommand = new SolutionsCommandImpl();
    return solutionsCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelsCommand createModelsCommand()
  {
    ModelsCommandImpl modelsCommand = new ModelsCommandImpl();
    return modelsCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FitnessDimensionType createFitnessDimensionTypeFromString(EDataType eDataType, String initialValue)
  {
    FitnessDimensionType result = FitnessDimensionType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFitnessDimensionTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MomotPackage getMomotPackage()
  {
    return (MomotPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MomotPackage getPackage()
  {
    return MomotPackage.eINSTANCE;
  }

} //MomotFactoryImpl
