/**
 */
package at.ac.tuwien.big.momot.lang.momot.util;

import at.ac.tuwien.big.momot.lang.momot.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage
 * @generated
 */
public class MomotAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MomotPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MomotAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = MomotPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MomotSwitch<Adapter> modelSwitch =
    new MomotSwitch<Adapter>()
    {
      @Override
      public Adapter caseMOMoTSearch(MOMoTSearch object)
      {
        return createMOMoTSearchAdapter();
      }
      @Override
      public Adapter caseVariableDeclaration(VariableDeclaration object)
      {
        return createVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseModuleOrchestration(ModuleOrchestration object)
      {
        return createModuleOrchestrationAdapter();
      }
      @Override
      public Adapter caseParmeterValueSpecification(ParmeterValueSpecification object)
      {
        return createParmeterValueSpecificationAdapter();
      }
      @Override
      public Adapter caseSearchOrchestration(SearchOrchestration object)
      {
        return createSearchOrchestrationAdapter();
      }
      @Override
      public Adapter caseInputModel(InputModel object)
      {
        return createInputModelAdapter();
      }
      @Override
      public Adapter caseEqualityHelper(EqualityHelper object)
      {
        return createEqualityHelperAdapter();
      }
      @Override
      public Adapter caseAlgorithmList(AlgorithmList object)
      {
        return createAlgorithmListAdapter();
      }
      @Override
      public Adapter caseFitnessFunctionSpecification(FitnessFunctionSpecification object)
      {
        return createFitnessFunctionSpecificationAdapter();
      }
      @Override
      public Adapter caseFitnessDimensionSpecification(FitnessDimensionSpecification object)
      {
        return createFitnessDimensionSpecificationAdapter();
      }
      @Override
      public Adapter caseFitnessDimensionConstructor(FitnessDimensionConstructor object)
      {
        return createFitnessDimensionConstructorAdapter();
      }
      @Override
      public Adapter caseFitnessDimensionXBase(FitnessDimensionXBase object)
      {
        return createFitnessDimensionXBaseAdapter();
      }
      @Override
      public Adapter caseFitnessDimensionOCL(FitnessDimensionOCL object)
      {
        return createFitnessDimensionOCLAdapter();
      }
      @Override
      public Adapter caseDefExpression(DefExpression object)
      {
        return createDefExpressionAdapter();
      }
      @Override
      public Adapter caseAlgorithmSpecification(AlgorithmSpecification object)
      {
        return createAlgorithmSpecificationAdapter();
      }
      @Override
      public Adapter caseExperimentOrchestration(ExperimentOrchestration object)
      {
        return createExperimentOrchestrationAdapter();
      }
      @Override
      public Adapter caseCollectorArray(CollectorArray object)
      {
        return createCollectorArrayAdapter();
      }
      @Override
      public Adapter caseAnalysisOrchestration(AnalysisOrchestration object)
      {
        return createAnalysisOrchestrationAdapter();
      }
      @Override
      public Adapter caseAnalysisGroupList(AnalysisGroupList object)
      {
        return createAnalysisGroupListAdapter();
      }
      @Override
      public Adapter caseIndicatorArray(IndicatorArray object)
      {
        return createIndicatorArrayAdapter();
      }
      @Override
      public Adapter caseShowArray(ShowArray object)
      {
        return createShowArrayAdapter();
      }
      @Override
      public Adapter caseAnalysisGroupSpecification(AnalysisGroupSpecification object)
      {
        return createAnalysisGroupSpecificationAdapter();
      }
      @Override
      public Adapter caseAlgorithmReferences(AlgorithmReferences object)
      {
        return createAlgorithmReferencesAdapter();
      }
      @Override
      public Adapter caseAnalysisCommand(AnalysisCommand object)
      {
        return createAnalysisCommandAdapter();
      }
      @Override
      public Adapter casePrintAnalysisCommand(PrintAnalysisCommand object)
      {
        return createPrintAnalysisCommandAdapter();
      }
      @Override
      public Adapter caseSaveAnalysisCommand(SaveAnalysisCommand object)
      {
        return createSaveAnalysisCommandAdapter();
      }
      @Override
      public Adapter caseBoxplotCommand(BoxplotCommand object)
      {
        return createBoxplotCommandAdapter();
      }
      @Override
      public Adapter caseResultManagement(ResultManagement object)
      {
        return createResultManagementAdapter();
      }
      @Override
      public Adapter caseResultManagementCommand(ResultManagementCommand object)
      {
        return createResultManagementCommandAdapter();
      }
      @Override
      public Adapter caseObjectivesCommand(ObjectivesCommand object)
      {
        return createObjectivesCommandAdapter();
      }
      @Override
      public Adapter caseSolutionsCommand(SolutionsCommand object)
      {
        return createSolutionsCommandAdapter();
      }
      @Override
      public Adapter caseModelsCommand(ModelsCommand object)
      {
        return createModelsCommandAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch <em>MO Mo TSearch</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.MOMoTSearch
   * @generated
   */
  public Adapter createMOMoTSearchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.VariableDeclaration
   * @generated
   */
  public Adapter createVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration <em>Module Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration
   * @generated
   */
  public Adapter createModuleOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification <em>Parmeter Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification
   * @generated
   */
  public Adapter createParmeterValueSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.SearchOrchestration <em>Search Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.SearchOrchestration
   * @generated
   */
  public Adapter createSearchOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.InputModel <em>Input Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.InputModel
   * @generated
   */
  public Adapter createInputModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper <em>Equality Helper</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.EqualityHelper
   * @generated
   */
  public Adapter createEqualityHelperAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmList <em>Algorithm List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmList
   * @generated
   */
  public Adapter createAlgorithmListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification <em>Fitness Function Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification
   * @generated
   */
  public Adapter createFitnessFunctionSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification <em>Fitness Dimension Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification
   * @generated
   */
  public Adapter createFitnessDimensionSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionConstructor <em>Fitness Dimension Constructor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionConstructor
   * @generated
   */
  public Adapter createFitnessDimensionConstructorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase <em>Fitness Dimension XBase</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase
   * @generated
   */
  public Adapter createFitnessDimensionXBaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL <em>Fitness Dimension OCL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL
   * @generated
   */
  public Adapter createFitnessDimensionOCLAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.DefExpression <em>Def Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.DefExpression
   * @generated
   */
  public Adapter createDefExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification <em>Algorithm Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification
   * @generated
   */
  public Adapter createAlgorithmSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration <em>Experiment Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration
   * @generated
   */
  public Adapter createExperimentOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.CollectorArray <em>Collector Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.CollectorArray
   * @generated
   */
  public Adapter createCollectorArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration <em>Analysis Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration
   * @generated
   */
  public Adapter createAnalysisOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList <em>Analysis Group List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList
   * @generated
   */
  public Adapter createAnalysisGroupListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.IndicatorArray <em>Indicator Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.IndicatorArray
   * @generated
   */
  public Adapter createIndicatorArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray <em>Show Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ShowArray
   * @generated
   */
  public Adapter createShowArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification <em>Analysis Group Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification
   * @generated
   */
  public Adapter createAnalysisGroupSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences <em>Algorithm References</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences
   * @generated
   */
  public Adapter createAlgorithmReferencesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisCommand <em>Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.AnalysisCommand
   * @generated
   */
  public Adapter createAnalysisCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.PrintAnalysisCommand <em>Print Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.PrintAnalysisCommand
   * @generated
   */
  public Adapter createPrintAnalysisCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand <em>Save Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand
   * @generated
   */
  public Adapter createSaveAnalysisCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.BoxplotCommand <em>Boxplot Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.BoxplotCommand
   * @generated
   */
  public Adapter createBoxplotCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagement <em>Result Management</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagement
   * @generated
   */
  public Adapter createResultManagementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand <em>Result Management Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand
   * @generated
   */
  public Adapter createResultManagementCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ObjectivesCommand <em>Objectives Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ObjectivesCommand
   * @generated
   */
  public Adapter createObjectivesCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand <em>Solutions Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.SolutionsCommand
   * @generated
   */
  public Adapter createSolutionsCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.momot.ModelsCommand <em>Models Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.momot.ModelsCommand
   * @generated
   */
  public Adapter createModelsCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //MomotAdapterFactory
