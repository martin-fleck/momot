/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.util;

import at.ac.tuwien.big.momot.lang.mOMoT.*;

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
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage
 * @generated
 */
public class MOMoTSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MOMoTPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOMoTSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MOMoTPackage.eINSTANCE;
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
      case MOMoTPackage.MO_MO_TSEARCH:
      {
        MOMoTSearch moMoTSearch = (MOMoTSearch)theEObject;
        T result = caseMOMoTSearch(moMoTSearch);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.VARIABLE_DECLARATION:
      {
        VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
        T result = caseVariableDeclaration(variableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.TRANSFORMATION_ORCHESTRATION:
      {
        TransformationOrchestration transformationOrchestration = (TransformationOrchestration)theEObject;
        T result = caseTransformationOrchestration(transformationOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION:
      {
        ParmeterValueSpecification parmeterValueSpecification = (ParmeterValueSpecification)theEObject;
        T result = caseParmeterValueSpecification(parmeterValueSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.SEARCH_ORCHESTRATION:
      {
        SearchOrchestration searchOrchestration = (SearchOrchestration)theEObject;
        T result = caseSearchOrchestration(searchOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.EQUALITY_HELPER:
      {
        EqualityHelper equalityHelper = (EqualityHelper)theEObject;
        T result = caseEqualityHelper(equalityHelper);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.ALGORITHM_LIST:
      {
        AlgorithmList algorithmList = (AlgorithmList)theEObject;
        T result = caseAlgorithmList(algorithmList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.FITNESS_FUNCTION_SPECIFICATION:
      {
        FitnessFunctionSpecification fitnessFunctionSpecification = (FitnessFunctionSpecification)theEObject;
        T result = caseFitnessFunctionSpecification(fitnessFunctionSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.FITNESS_DIMENSION_SPECIFICATION:
      {
        FitnessDimensionSpecification fitnessDimensionSpecification = (FitnessDimensionSpecification)theEObject;
        T result = caseFitnessDimensionSpecification(fitnessDimensionSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.FITNESS_DIMENSION_CONSTRUCTOR:
      {
        FitnessDimensionConstructor fitnessDimensionConstructor = (FitnessDimensionConstructor)theEObject;
        T result = caseFitnessDimensionConstructor(fitnessDimensionConstructor);
        if (result == null) result = caseFitnessDimensionSpecification(fitnessDimensionConstructor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.FITNESS_DIMENSION_XBASE:
      {
        FitnessDimensionXBase fitnessDimensionXBase = (FitnessDimensionXBase)theEObject;
        T result = caseFitnessDimensionXBase(fitnessDimensionXBase);
        if (result == null) result = caseFitnessDimensionSpecification(fitnessDimensionXBase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.FITNESS_DIMENSION_OCL:
      {
        FitnessDimensionOCL fitnessDimensionOCL = (FitnessDimensionOCL)theEObject;
        T result = caseFitnessDimensionOCL(fitnessDimensionOCL);
        if (result == null) result = caseFitnessDimensionSpecification(fitnessDimensionOCL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.DEF_EXPRESSION:
      {
        DefExpression defExpression = (DefExpression)theEObject;
        T result = caseDefExpression(defExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.ALGORITHM_SPECIFICATION:
      {
        AlgorithmSpecification algorithmSpecification = (AlgorithmSpecification)theEObject;
        T result = caseAlgorithmSpecification(algorithmSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.EXPERIMENT_ORCHESTRATION:
      {
        ExperimentOrchestration experimentOrchestration = (ExperimentOrchestration)theEObject;
        T result = caseExperimentOrchestration(experimentOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.COLLECTOR_ARRAY:
      {
        CollectorArray collectorArray = (CollectorArray)theEObject;
        T result = caseCollectorArray(collectorArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.ANALYSIS_ORCHESTRATION:
      {
        AnalysisOrchestration analysisOrchestration = (AnalysisOrchestration)theEObject;
        T result = caseAnalysisOrchestration(analysisOrchestration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.ANALYSIS_GROUP_LIST:
      {
        AnalysisGroupList analysisGroupList = (AnalysisGroupList)theEObject;
        T result = caseAnalysisGroupList(analysisGroupList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.INDICATOR_ARRAY:
      {
        IndicatorArray indicatorArray = (IndicatorArray)theEObject;
        T result = caseIndicatorArray(indicatorArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.SHOW_ARRAY:
      {
        ShowArray showArray = (ShowArray)theEObject;
        T result = caseShowArray(showArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.ANALYSIS_GROUP_SPECIFICATION:
      {
        AnalysisGroupSpecification analysisGroupSpecification = (AnalysisGroupSpecification)theEObject;
        T result = caseAnalysisGroupSpecification(analysisGroupSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.ALGORITHM_REFERENCES:
      {
        AlgorithmReferences algorithmReferences = (AlgorithmReferences)theEObject;
        T result = caseAlgorithmReferences(algorithmReferences);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.RESULT_MANAGEMENT:
      {
        ResultManagement resultManagement = (ResultManagement)theEObject;
        T result = caseResultManagement(resultManagement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.SAVE_ANALYSIS_COMMAND:
      {
        SaveAnalysisCommand saveAnalysisCommand = (SaveAnalysisCommand)theEObject;
        T result = caseSaveAnalysisCommand(saveAnalysisCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND:
      {
        SaveObjectivesCommand saveObjectivesCommand = (SaveObjectivesCommand)theEObject;
        T result = caseSaveObjectivesCommand(saveObjectivesCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.SAVE_SOLUTIONS_COMMAND:
      {
        SaveSolutionsCommand saveSolutionsCommand = (SaveSolutionsCommand)theEObject;
        T result = caseSaveSolutionsCommand(saveSolutionsCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.PRINT_OBJECTIVES_COMMAND:
      {
        PrintObjectivesCommand printObjectivesCommand = (PrintObjectivesCommand)theEObject;
        T result = casePrintObjectivesCommand(printObjectivesCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MOMoTPackage.PRINT_SOLUTIONS_COMMAND:
      {
        PrintSolutionsCommand printSolutionsCommand = (PrintSolutionsCommand)theEObject;
        T result = casePrintSolutionsCommand(printSolutionsCommand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search</em>'.
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
   * Returns the result of interpreting the object as an instance of '<em>Transformation Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationOrchestration(TransformationOrchestration object)
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
   * Returns the result of interpreting the object as an instance of '<em>Save Objectives Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Save Objectives Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSaveObjectivesCommand(SaveObjectivesCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Save Solutions Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Save Solutions Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSaveSolutionsCommand(SaveSolutionsCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Print Objectives Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Print Objectives Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrintObjectivesCommand(PrintObjectivesCommand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Print Solutions Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Print Solutions Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrintSolutionsCommand(PrintSolutionsCommand object)
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

} //MOMoTSwitch
