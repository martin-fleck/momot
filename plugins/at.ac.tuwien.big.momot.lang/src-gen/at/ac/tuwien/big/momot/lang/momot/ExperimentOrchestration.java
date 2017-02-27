/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment Orchestration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getPopulationSize <em>Population Size</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getMaxEvaluations <em>Max Evaluations</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getNrRuns <em>Nr Runs</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getReferenceSet <em>Reference Set</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getProgressListeners <em>Progress Listeners</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getCollectors <em>Collectors</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getCustomCollectors <em>Custom Collectors</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration()
 * @model
 * @generated
 */
public interface ExperimentOrchestration extends EObject
{
  /**
   * Returns the value of the '<em><b>Population Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Population Size</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Population Size</em>' containment reference.
   * @see #setPopulationSize(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration_PopulationSize()
   * @model containment="true"
   * @generated
   */
  XExpression getPopulationSize();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getPopulationSize <em>Population Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Population Size</em>' containment reference.
   * @see #getPopulationSize()
   * @generated
   */
  void setPopulationSize(XExpression value);

  /**
   * Returns the value of the '<em><b>Max Evaluations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Evaluations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Evaluations</em>' containment reference.
   * @see #setMaxEvaluations(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration_MaxEvaluations()
   * @model containment="true"
   * @generated
   */
  XExpression getMaxEvaluations();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getMaxEvaluations <em>Max Evaluations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Evaluations</em>' containment reference.
   * @see #getMaxEvaluations()
   * @generated
   */
  void setMaxEvaluations(XExpression value);

  /**
   * Returns the value of the '<em><b>Nr Runs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nr Runs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nr Runs</em>' containment reference.
   * @see #setNrRuns(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration_NrRuns()
   * @model containment="true"
   * @generated
   */
  XExpression getNrRuns();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getNrRuns <em>Nr Runs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nr Runs</em>' containment reference.
   * @see #getNrRuns()
   * @generated
   */
  void setNrRuns(XExpression value);

  /**
   * Returns the value of the '<em><b>Reference Set</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Set</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Set</em>' containment reference.
   * @see #setReferenceSet(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration_ReferenceSet()
   * @model containment="true"
   * @generated
   */
  XExpression getReferenceSet();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getReferenceSet <em>Reference Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Set</em>' containment reference.
   * @see #getReferenceSet()
   * @generated
   */
  void setReferenceSet(XExpression value);

  /**
   * Returns the value of the '<em><b>Progress Listeners</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Progress Listeners</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Progress Listeners</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration_ProgressListeners()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getProgressListeners();

  /**
   * Returns the value of the '<em><b>Collectors</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Collectors</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Collectors</em>' containment reference.
   * @see #setCollectors(CollectorArray)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration_Collectors()
   * @model containment="true"
   * @generated
   */
  CollectorArray getCollectors();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration#getCollectors <em>Collectors</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collectors</em>' containment reference.
   * @see #getCollectors()
   * @generated
   */
  void setCollectors(CollectorArray value);

  /**
   * Returns the value of the '<em><b>Custom Collectors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Custom Collectors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Custom Collectors</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getExperimentOrchestration_CustomCollectors()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getCustomCollectors();

} // ExperimentOrchestration
