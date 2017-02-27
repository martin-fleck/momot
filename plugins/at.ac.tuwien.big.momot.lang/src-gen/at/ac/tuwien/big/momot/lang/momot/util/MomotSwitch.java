/**
 */
package at.ac.tuwien.big.momot.lang.momot.util;

import at.ac.tuwien.big.momot.lang.momot.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage
 * @generated
 */
public class MomotSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MomotPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MomotSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MomotPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MomotPackage.MO_MO_TSEARCH:
      {
        MOMoTSearch moMoTSearch = (MOMoTSearch)theEObject;
        T result = caseMOMoTSearch(moMoTSearch);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.VARIABLE_DECLARATION:
      {
        VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
        T result = caseVariableDeclaration(variableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.MODULE_ORCHESTRATION:
      {
        ModuleOrchestration moduleOrchestration = (ModuleOrchestration)theEObject;
        T result = caseModuleOrchestration(moduleOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.PARMETER_VALUE_SPECIFICATION:
      {
        ParmeterValueSpecification parmeterValueSpecification = (ParmeterValueSpecification)theEObject;
        T result = caseParmeterValueSpecification(parmeterValueSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.SEARCH_ORCHESTRATION:
      {
        SearchOrchestration searchOrchestration = (SearchOrchestration)theEObject;
        T result = caseSearchOrchestration(searchOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.INPUT_MODEL:
      {
        InputModel inputModel = (InputModel)theEObject;
        T result = caseInputModel(inputModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.EQUALITY_HELPER:
      {
        EqualityHelper equalityHelper = (EqualityHelper)theEObject;
        T result = caseEqualityHelper(equalityHelper);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.ALGORITHM_LIST:
      {
        AlgorithmList algorithmList = (AlgorithmList)theEObject;
        T result = caseAlgorithmList(algorithmList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION:
      {
        FitnessFunctionSpecification fitnessFunctionSpecification = (FitnessFunctionSpecification)theEObject;
        T result = caseFitnessFunctionSpecification(fitnessFunctionSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.FITNESS_DIMENSION_SPECIFICATION:
      {
        FitnessDimensionSpecification fitnessDimensionSpecification = (FitnessDimensionSpecification)theEObject;
        T result = caseFitnessDimensionSpecification(fitnessDimensionSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.FITNESS_DIMENSION_CONSTRUCTOR:
      {
        FitnessDimensionConstructor fitnessDimensionConstructor = (FitnessDimensionConstructor)theEObject;
        T result = caseFitnessDimensionConstructor(fitnessDimensionConstructor);
        if (result == null) result = caseFitnessDimensionSpecification(fitnessDimensionConstructor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.FITNESS_DIMENSION_XBASE:
      {
        FitnessDimensionXBase fitnessDimensionXBase = (FitnessDimensionXBase)theEObject;
        T result = caseFitnessDimensionXBase(fitnessDimensionXBase);
        if (result == null) result = caseFitnessDimensionSpecification(fitnessDimensionXBase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.FITNESS_DIMENSION_OCL:
      {
        FitnessDimensionOCL fitnessDimensionOCL = (FitnessDimensionOCL)theEObject;
        T result = caseFitnessDimensionOCL(fitnessDimensionOCL);
        if (result == null) result = caseFitnessDimensionSpecification(fitnessDimensionOCL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.DEF_EXPRESSION:
      {
        DefExpression defExpression = (DefExpression)theEObject;
        T result = caseDefExpression(defExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.ALGORITHM_SPECIFICATION:
      {
        AlgorithmSpecification algorithmSpecification = (AlgorithmSpecification)theEObject;
        T result = caseAlgorithmSpecification(algorithmSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.EXPERIMENT_ORCHESTRATION:
      {
        ExperimentOrchestration experimentOrchestration = (ExperimentOrchestration)theEObject;
        T result = caseExperimentOrchestration(experimentOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.COLLECTOR_ARRAY:
      {
        CollectorArray collectorArray = (CollectorArray)theEObject;
        T result = caseCollectorArray(collectorArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.ANALYSIS_ORCHESTRATION:
      {
        AnalysisOrchestration analysisOrchestration = (AnalysisOrchestration)theEObject;
        T result = caseAnalysisOrchestration(analysisOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.ANALYSIS_GROUP_LIST:
      {
        AnalysisGroupList analysisGroupList = (AnalysisGroupList)theEObject;
        T result = caseAnalysisGroupList(analysisGroupList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.INDICATOR_ARRAY:
      {
        IndicatorArray indicatorArray = (IndicatorArray)theEObject;
        T result = caseIndicatorArray(indicatorArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.SHOW_ARRAY:
      {
        ShowArray showArray = (ShowArray)theEObject;
        T result = caseShowArray(showArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.ANALYSIS_GROUP_SPECIFICATION:
      {
        AnalysisGroupSpecification analysisGroupSpecification = (AnalysisGroupSpecification)theEObject;
        T result = caseAnalysisGroupSpecification(analysisGroupSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.ALGORITHM_REFERENCES:
      {
        AlgorithmReferences algorithmReferences = (AlgorithmReferences)theEObject;
        T result = caseAlgorithmReferences(algorithmReferences);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.ANALYSIS_COMMAND:
      {
        AnalysisCommand analysisCommand = (AnalysisCommand)theEObject;
        T result = caseAnalysisCommand(analysisCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.PRINT_ANALYSIS_COMMAND:
      {
        PrintAnalysisCommand printAnalysisCommand = (PrintAnalysisCommand)theEObject;
        T result = casePrintAnalysisCommand(printAnalysisCommand);
        if (result == null) result = caseAnalysisCommand(printAnalysisCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.SAVE_ANALYSIS_COMMAND:
      {
        SaveAnalysisCommand saveAnalysisCommand = (SaveAnalysisCommand)theEObject;
        T result = caseSaveAnalysisCommand(saveAnalysisCommand);
        if (result == null) result = caseAnalysisCommand(saveAnalysisCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.BOXPLOT_COMMAND:
      {
        BoxplotCommand boxplotCommand = (BoxplotCommand)theEObject;
        T result = caseBoxplotCommand(boxplotCommand);
        if (result == null) result = caseAnalysisCommand(boxplotCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.RESULT_MANAGEMENT:
      {
        ResultManagement resultManagement = (ResultManagement)theEObject;
        T result = caseResultManagement(resultManagement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.RESULT_MANAGEMENT_COMMAND:
      {
        ResultManagementCommand resultManagementCommand = (ResultManagementCommand)theEObject;
        T result = caseResultManagementCommand(resultManagementCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.OBJECTIVES_COMMAND:
      {
        ObjectivesCommand objectivesCommand = (ObjectivesCommand)theEObject;
        T result = caseObjectivesCommand(objectivesCommand);
        if (result == null) result = caseResultManagementCommand(objectivesCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.SOLUTIONS_COMMAND:
      {
        SolutionsCommand solutionsCommand = (SolutionsCommand)theEObject;
        T result = caseSolutionsCommand(solutionsCommand);
        if (result == null) result = caseResultManagementCommand(solutionsCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MomotPackage.MODELS_COMMAND:
      {
        ModelsCommand modelsCommand = (ModelsCommand)theEObject;
        T result = caseModelsCommand(modelsCommand);
        if (result == null) result = caseResultManagementCommand(modelsCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MO Mo TSearch</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MO Mo TSearch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMOMoTSearch(MOMoTSearch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDeclaration(VariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleOrchestration(ModuleOrchestration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parmeter Value Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parmeter Value Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParmeterValueSpecification(ParmeterValueSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchOrchestration(SearchOrchestration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputModel(InputModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Helper</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Helper</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityHelper(EqualityHelper object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Algorithm List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Algorithm List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlgorithmList(AlgorithmList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fitness Function Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fitness Function Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFitnessFunctionSpecification(FitnessFunctionSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fitness Dimension Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fitness Dimension Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFitnessDimensionSpecification(FitnessDimensionSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fitness Dimension Constructor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fitness Dimension Constructor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFitnessDimensionConstructor(FitnessDimensionConstructor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fitness Dimension XBase</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fitness Dimension XBase</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFitnessDimensionXBase(FitnessDimensionXBase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fitness Dimension OCL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fitness Dimension OCL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFitnessDimensionOCL(FitnessDimensionOCL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Def Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Def Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefExpression(DefExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Algorithm Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Algorithm Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlgorithmSpecification(AlgorithmSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Experiment Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Experiment Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExperimentOrchestration(ExperimentOrchestration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collector Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collector Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectorArray(CollectorArray object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Analysis Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analysis Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnalysisOrchestration(AnalysisOrchestration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Analysis Group List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analysis Group List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnalysisGroupList(AnalysisGroupList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indicator Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indicator Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndicatorArray(IndicatorArray object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Show Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Show Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShowArray(ShowArray object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Analysis Group Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analysis Group Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnalysisGroupSpecification(AnalysisGroupSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Algorithm References</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Algorithm References</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlgorithmReferences(AlgorithmReferences object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Analysis Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analysis Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnalysisCommand(AnalysisCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Print Analysis Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Print Analysis Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrintAnalysisCommand(PrintAnalysisCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Save Analysis Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Save Analysis Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSaveAnalysisCommand(SaveAnalysisCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boxplot Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boxplot Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoxplotCommand(BoxplotCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Management</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Management</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultManagement(ResultManagement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Management Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Management Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultManagementCommand(ResultManagementCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Objectives Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Objectives Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectivesCommand(ObjectivesCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Solutions Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Solutions Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSolutionsCommand(SolutionsCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Models Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Models Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelsCommand(ModelsCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MomotSwitch
