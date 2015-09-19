/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.impl;

import at.ac.tuwien.big.momot.lang.mOMoT.*;

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
public class MOMoTFactoryImpl extends EFactoryImpl implements MOMoTFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MOMoTFactory init()
  {
    try
    {
      MOMoTFactory theMOMoTFactory = (MOMoTFactory)EPackage.Registry.INSTANCE.getEFactory(MOMoTPackage.eNS_URI);
      if (theMOMoTFactory != null)
      {
        return theMOMoTFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MOMoTFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOMoTFactoryImpl()
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
      case MOMoTPackage.MO_MO_TSEARCH: return createMOMoTSearch();
      case MOMoTPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
      case MOMoTPackage.TRANSFORMATION_ORCHESTRATION: return createTransformationOrchestration();
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION: return createParmeterValueSpecification();
      case MOMoTPackage.SEARCH_ORCHESTRATION: return createSearchOrchestration();
      case MOMoTPackage.EQUALITY_HELPER: return createEqualityHelper();
      case MOMoTPackage.ALGORITHM_LIST: return createAlgorithmList();
      case MOMoTPackage.FITNESS_FUNCTION_SPECIFICATION: return createFitnessFunctionSpecification();
      case MOMoTPackage.FITNESS_DIMENSION_SPECIFICATION: return createFitnessDimensionSpecification();
      case MOMoTPackage.FITNESS_DIMENSION_CONSTRUCTOR: return createFitnessDimensionConstructor();
      case MOMoTPackage.FITNESS_DIMENSION_XBASE: return createFitnessDimensionXBase();
      case MOMoTPackage.FITNESS_DIMENSION_OCL: return createFitnessDimensionOCL();
      case MOMoTPackage.DEF_EXPRESSION: return createDefExpression();
      case MOMoTPackage.ALGORITHM_SPECIFICATION: return createAlgorithmSpecification();
      case MOMoTPackage.EXPERIMENT_ORCHESTRATION: return createExperimentOrchestration();
      case MOMoTPackage.COLLECTOR_ARRAY: return createCollectorArray();
      case MOMoTPackage.ANALYSIS_ORCHESTRATION: return createAnalysisOrchestration();
      case MOMoTPackage.ANALYSIS_GROUP_LIST: return createAnalysisGroupList();
      case MOMoTPackage.INDICATOR_ARRAY: return createIndicatorArray();
      case MOMoTPackage.SHOW_ARRAY: return createShowArray();
      case MOMoTPackage.ANALYSIS_GROUP_SPECIFICATION: return createAnalysisGroupSpecification();
      case MOMoTPackage.ALGORITHM_REFERENCES: return createAlgorithmReferences();
      case MOMoTPackage.RESULT_MANAGEMENT: return createResultManagement();
      case MOMoTPackage.SAVE_ANALYSIS_COMMAND: return createSaveAnalysisCommand();
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND: return createSaveObjectivesCommand();
      case MOMoTPackage.SAVE_SOLUTIONS_COMMAND: return createSaveSolutionsCommand();
      case MOMoTPackage.PRINT_OBJECTIVES_COMMAND: return createPrintObjectivesCommand();
      case MOMoTPackage.PRINT_SOLUTIONS_COMMAND: return createPrintSolutionsCommand();
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
      case MOMoTPackage.FITNESS_DIMENSION_TYPE:
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
      case MOMoTPackage.FITNESS_DIMENSION_TYPE:
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
  public TransformationOrchestration createTransformationOrchestration()
  {
    TransformationOrchestrationImpl transformationOrchestration = new TransformationOrchestrationImpl();
    return transformationOrchestration;
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
  public SaveObjectivesCommand createSaveObjectivesCommand()
  {
    SaveObjectivesCommandImpl saveObjectivesCommand = new SaveObjectivesCommandImpl();
    return saveObjectivesCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SaveSolutionsCommand createSaveSolutionsCommand()
  {
    SaveSolutionsCommandImpl saveSolutionsCommand = new SaveSolutionsCommandImpl();
    return saveSolutionsCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrintObjectivesCommand createPrintObjectivesCommand()
  {
    PrintObjectivesCommandImpl printObjectivesCommand = new PrintObjectivesCommandImpl();
    return printObjectivesCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrintSolutionsCommand createPrintSolutionsCommand()
  {
    PrintSolutionsCommandImpl printSolutionsCommand = new PrintSolutionsCommandImpl();
    return printSolutionsCommand;
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
  public MOMoTPackage getMOMoTPackage()
  {
    return (MOMoTPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MOMoTPackage getPackage()
  {
    return MOMoTPackage.eINSTANCE;
  }

} //MOMoTFactoryImpl
