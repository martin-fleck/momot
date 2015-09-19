/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.util;

import at.ac.tuwien.big.momot.lang.mOMoT.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage
 * @generated
 */
public class MOMoTAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MOMoTPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOMoTAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = MOMoTPackage.eINSTANCE;
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
  protected MOMoTSwitch<Adapter> modelSwitch =
    new MOMoTSwitch<Adapter>()
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
      public Adapter caseTransformationOrchestration(TransformationOrchestration object)
      {
        return createTransformationOrchestrationAdapter();
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
      public Adapter caseResultManagement(ResultManagement object)
      {
        return createResultManagementAdapter();
      }
      @Override
      public Adapter caseSaveAnalysisCommand(SaveAnalysisCommand object)
      {
        return createSaveAnalysisCommandAdapter();
      }
      @Override
      public Adapter caseSaveObjectivesCommand(SaveObjectivesCommand object)
      {
        return createSaveObjectivesCommandAdapter();
      }
      @Override
      public Adapter caseSaveSolutionsCommand(SaveSolutionsCommand object)
      {
        return createSaveSolutionsCommandAdapter();
      }
      @Override
      public Adapter casePrintObjectivesCommand(PrintObjectivesCommand object)
      {
        return createPrintObjectivesCommandAdapter();
      }
      @Override
      public Adapter casePrintSolutionsCommand(PrintSolutionsCommand object)
      {
        return createPrintSolutionsCommandAdapter();
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
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch <em>Search</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch
   * @generated
   */
  public Adapter createMOMoTSearchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration
   * @generated
   */
  public Adapter createVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration <em>Transformation Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration
   * @generated
   */
  public Adapter createTransformationOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification <em>Parmeter Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification
   * @generated
   */
  public Adapter createParmeterValueSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration <em>Search Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration
   * @generated
   */
  public Adapter createSearchOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper <em>Equality Helper</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper
   * @generated
   */
  public Adapter createEqualityHelperAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList <em>Algorithm List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList
   * @generated
   */
  public Adapter createAlgorithmListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification <em>Fitness Function Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification
   * @generated
   */
  public Adapter createFitnessFunctionSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification <em>Fitness Dimension Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification
   * @generated
   */
  public Adapter createFitnessDimensionSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor <em>Fitness Dimension Constructor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor
   * @generated
   */
  public Adapter createFitnessDimensionConstructorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase <em>Fitness Dimension XBase</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase
   * @generated
   */
  public Adapter createFitnessDimensionXBaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL <em>Fitness Dimension OCL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL
   * @generated
   */
  public Adapter createFitnessDimensionOCLAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.DefExpression <em>Def Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.DefExpression
   * @generated
   */
  public Adapter createDefExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification <em>Algorithm Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification
   * @generated
   */
  public Adapter createAlgorithmSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration <em>Experiment Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration
   * @generated
   */
  public Adapter createExperimentOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray <em>Collector Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray
   * @generated
   */
  public Adapter createCollectorArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration <em>Analysis Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration
   * @generated
   */
  public Adapter createAnalysisOrchestrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupList <em>Analysis Group List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupList
   * @generated
   */
  public Adapter createAnalysisGroupListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray <em>Indicator Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray
   * @generated
   */
  public Adapter createIndicatorArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ShowArray <em>Show Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ShowArray
   * @generated
   */
  public Adapter createShowArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification <em>Analysis Group Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification
   * @generated
   */
  public Adapter createAnalysisGroupSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences <em>Algorithm References</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences
   * @generated
   */
  public Adapter createAlgorithmReferencesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement <em>Result Management</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement
   * @generated
   */
  public Adapter createResultManagementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand <em>Save Analysis Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand
   * @generated
   */
  public Adapter createSaveAnalysisCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand <em>Save Objectives Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand
   * @generated
   */
  public Adapter createSaveObjectivesCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand <em>Save Solutions Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand
   * @generated
   */
  public Adapter createSaveSolutionsCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand <em>Print Objectives Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand
   * @generated
   */
  public Adapter createPrintObjectivesCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand <em>Print Solutions Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand
   * @generated
   */
  public Adapter createPrintSolutionsCommandAdapter()
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

} //MOMoTAdapterFactory
