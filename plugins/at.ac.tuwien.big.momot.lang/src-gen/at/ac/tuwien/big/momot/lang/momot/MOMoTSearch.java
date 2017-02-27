/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MO Mo TSearch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getPackage <em>Package</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getVariables <em>Variables</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getInitialization <em>Initialization</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getSearchOrchestration <em>Search Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getExperimentOrchestration <em>Experiment Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getAnalysisOrchestration <em>Analysis Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getResultManagement <em>Result Management</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getFinalization <em>Finalization</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch()
 * @model
 * @generated
 */
public interface MOMoTSearch extends EObject
{
  /**
   * Returns the value of the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' attribute.
   * @see #setPackage(String)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_Package()
   * @model
   * @generated
   */
  String getPackage();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getPackage <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' attribute.
   * @see #getPackage()
   * @generated
   */
  void setPackage(String value);

  /**
   * Returns the value of the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Section</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Section</em>' containment reference.
   * @see #setImportSection(XImportSection)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_ImportSection()
   * @model containment="true"
   * @generated
   */
  XImportSection getImportSection();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getImportSection <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Section</em>' containment reference.
   * @see #getImportSection()
   * @generated
   */
  void setImportSection(XImportSection value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.momot.VariableDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_Variables()
   * @model containment="true"
   * @generated
   */
  EList<VariableDeclaration> getVariables();

  /**
   * Returns the value of the '<em><b>Initialization</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initialization</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initialization</em>' containment reference.
   * @see #setInitialization(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_Initialization()
   * @model containment="true"
   * @generated
   */
  XExpression getInitialization();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getInitialization <em>Initialization</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initialization</em>' containment reference.
   * @see #getInitialization()
   * @generated
   */
  void setInitialization(XExpression value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Search Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Search Orchestration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Search Orchestration</em>' containment reference.
   * @see #setSearchOrchestration(SearchOrchestration)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_SearchOrchestration()
   * @model containment="true"
   * @generated
   */
  SearchOrchestration getSearchOrchestration();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getSearchOrchestration <em>Search Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Search Orchestration</em>' containment reference.
   * @see #getSearchOrchestration()
   * @generated
   */
  void setSearchOrchestration(SearchOrchestration value);

  /**
   * Returns the value of the '<em><b>Experiment Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Experiment Orchestration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Experiment Orchestration</em>' containment reference.
   * @see #setExperimentOrchestration(ExperimentOrchestration)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_ExperimentOrchestration()
   * @model containment="true"
   * @generated
   */
  ExperimentOrchestration getExperimentOrchestration();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getExperimentOrchestration <em>Experiment Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Experiment Orchestration</em>' containment reference.
   * @see #getExperimentOrchestration()
   * @generated
   */
  void setExperimentOrchestration(ExperimentOrchestration value);

  /**
   * Returns the value of the '<em><b>Analysis Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Analysis Orchestration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Analysis Orchestration</em>' containment reference.
   * @see #setAnalysisOrchestration(AnalysisOrchestration)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_AnalysisOrchestration()
   * @model containment="true"
   * @generated
   */
  AnalysisOrchestration getAnalysisOrchestration();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getAnalysisOrchestration <em>Analysis Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Analysis Orchestration</em>' containment reference.
   * @see #getAnalysisOrchestration()
   * @generated
   */
  void setAnalysisOrchestration(AnalysisOrchestration value);

  /**
   * Returns the value of the '<em><b>Result Management</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Management</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Management</em>' containment reference.
   * @see #setResultManagement(ResultManagement)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_ResultManagement()
   * @model containment="true"
   * @generated
   */
  ResultManagement getResultManagement();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getResultManagement <em>Result Management</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Management</em>' containment reference.
   * @see #getResultManagement()
   * @generated
   */
  void setResultManagement(ResultManagement value);

  /**
   * Returns the value of the '<em><b>Finalization</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Finalization</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Finalization</em>' containment reference.
   * @see #setFinalization(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getMOMoTSearch_Finalization()
   * @model containment="true"
   * @generated
   */
  XExpression getFinalization();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.MOMoTSearch#getFinalization <em>Finalization</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Finalization</em>' containment reference.
   * @see #getFinalization()
   * @generated
   */
  void setFinalization(XExpression value);

} // MOMoTSearch
