/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage
 * @generated
 */
public interface MomotFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MomotFactory eINSTANCE = at.ac.tuwien.big.momot.lang.momot.impl.MomotFactoryImpl.init();

  /**
   * Returns a new object of class '<em>MO Mo TSearch</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MO Mo TSearch</em>'.
   * @generated
   */
  MOMoTSearch createMOMoTSearch();

  /**
   * Returns a new object of class '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Declaration</em>'.
   * @generated
   */
  VariableDeclaration createVariableDeclaration();

  /**
   * Returns a new object of class '<em>Module Orchestration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Orchestration</em>'.
   * @generated
   */
  ModuleOrchestration createModuleOrchestration();

  /**
   * Returns a new object of class '<em>Parmeter Value Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parmeter Value Specification</em>'.
   * @generated
   */
  ParmeterValueSpecification createParmeterValueSpecification();

  /**
   * Returns a new object of class '<em>Search Orchestration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Search Orchestration</em>'.
   * @generated
   */
  SearchOrchestration createSearchOrchestration();

  /**
   * Returns a new object of class '<em>Input Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Model</em>'.
   * @generated
   */
  InputModel createInputModel();

  /**
   * Returns a new object of class '<em>Equality Helper</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Helper</em>'.
   * @generated
   */
  EqualityHelper createEqualityHelper();

  /**
   * Returns a new object of class '<em>Algorithm List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Algorithm List</em>'.
   * @generated
   */
  AlgorithmList createAlgorithmList();

  /**
   * Returns a new object of class '<em>Fitness Function Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fitness Function Specification</em>'.
   * @generated
   */
  FitnessFunctionSpecification createFitnessFunctionSpecification();

  /**
   * Returns a new object of class '<em>Fitness Dimension Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fitness Dimension Specification</em>'.
   * @generated
   */
  FitnessDimensionSpecification createFitnessDimensionSpecification();

  /**
   * Returns a new object of class '<em>Fitness Dimension Constructor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fitness Dimension Constructor</em>'.
   * @generated
   */
  FitnessDimensionConstructor createFitnessDimensionConstructor();

  /**
   * Returns a new object of class '<em>Fitness Dimension XBase</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fitness Dimension XBase</em>'.
   * @generated
   */
  FitnessDimensionXBase createFitnessDimensionXBase();

  /**
   * Returns a new object of class '<em>Fitness Dimension OCL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fitness Dimension OCL</em>'.
   * @generated
   */
  FitnessDimensionOCL createFitnessDimensionOCL();

  /**
   * Returns a new object of class '<em>Def Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Expression</em>'.
   * @generated
   */
  DefExpression createDefExpression();

  /**
   * Returns a new object of class '<em>Algorithm Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Algorithm Specification</em>'.
   * @generated
   */
  AlgorithmSpecification createAlgorithmSpecification();

  /**
   * Returns a new object of class '<em>Experiment Orchestration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Experiment Orchestration</em>'.
   * @generated
   */
  ExperimentOrchestration createExperimentOrchestration();

  /**
   * Returns a new object of class '<em>Collector Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collector Array</em>'.
   * @generated
   */
  CollectorArray createCollectorArray();

  /**
   * Returns a new object of class '<em>Analysis Orchestration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Analysis Orchestration</em>'.
   * @generated
   */
  AnalysisOrchestration createAnalysisOrchestration();

  /**
   * Returns a new object of class '<em>Analysis Group List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Analysis Group List</em>'.
   * @generated
   */
  AnalysisGroupList createAnalysisGroupList();

  /**
   * Returns a new object of class '<em>Indicator Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indicator Array</em>'.
   * @generated
   */
  IndicatorArray createIndicatorArray();

  /**
   * Returns a new object of class '<em>Show Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Show Array</em>'.
   * @generated
   */
  ShowArray createShowArray();

  /**
   * Returns a new object of class '<em>Analysis Group Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Analysis Group Specification</em>'.
   * @generated
   */
  AnalysisGroupSpecification createAnalysisGroupSpecification();

  /**
   * Returns a new object of class '<em>Algorithm References</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Algorithm References</em>'.
   * @generated
   */
  AlgorithmReferences createAlgorithmReferences();

  /**
   * Returns a new object of class '<em>Analysis Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Analysis Command</em>'.
   * @generated
   */
  AnalysisCommand createAnalysisCommand();

  /**
   * Returns a new object of class '<em>Print Analysis Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Print Analysis Command</em>'.
   * @generated
   */
  PrintAnalysisCommand createPrintAnalysisCommand();

  /**
   * Returns a new object of class '<em>Save Analysis Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Save Analysis Command</em>'.
   * @generated
   */
  SaveAnalysisCommand createSaveAnalysisCommand();

  /**
   * Returns a new object of class '<em>Boxplot Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boxplot Command</em>'.
   * @generated
   */
  BoxplotCommand createBoxplotCommand();

  /**
   * Returns a new object of class '<em>Result Management</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Management</em>'.
   * @generated
   */
  ResultManagement createResultManagement();

  /**
   * Returns a new object of class '<em>Result Management Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Management Command</em>'.
   * @generated
   */
  ResultManagementCommand createResultManagementCommand();

  /**
   * Returns a new object of class '<em>Objectives Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Objectives Command</em>'.
   * @generated
   */
  ObjectivesCommand createObjectivesCommand();

  /**
   * Returns a new object of class '<em>Solutions Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Solutions Command</em>'.
   * @generated
   */
  SolutionsCommand createSolutionsCommand();

  /**
   * Returns a new object of class '<em>Models Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Models Command</em>'.
   * @generated
   */
  ModelsCommand createModelsCommand();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MomotPackage getMomotPackage();

} //MomotFactory
