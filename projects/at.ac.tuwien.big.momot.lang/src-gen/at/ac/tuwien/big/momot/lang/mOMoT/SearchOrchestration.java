/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Orchestration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getModel <em>Model</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getSolutionLength <em>Solution Length</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getTransformationOrchestration <em>Transformation Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getFitnessFunction <em>Fitness Function</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getEqualityHelper <em>Equality Helper</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSearchOrchestration()
 * @model
 * @generated
 */
public interface SearchOrchestration extends EObject
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' containment reference.
   * @see #setModel(XExpression)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSearchOrchestration_Model()
   * @model containment="true"
   * @generated
   */
  XExpression getModel();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getModel <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' containment reference.
   * @see #getModel()
   * @generated
   */
  void setModel(XExpression value);

  /**
   * Returns the value of the '<em><b>Solution Length</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Solution Length</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Length</em>' containment reference.
   * @see #setSolutionLength(XExpression)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSearchOrchestration_SolutionLength()
   * @model containment="true"
   * @generated
   */
  XExpression getSolutionLength();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getSolutionLength <em>Solution Length</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution Length</em>' containment reference.
   * @see #getSolutionLength()
   * @generated
   */
  void setSolutionLength(XExpression value);

  /**
   * Returns the value of the '<em><b>Transformation Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformation Orchestration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation Orchestration</em>' containment reference.
   * @see #setTransformationOrchestration(TransformationOrchestration)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSearchOrchestration_TransformationOrchestration()
   * @model containment="true"
   * @generated
   */
  TransformationOrchestration getTransformationOrchestration();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getTransformationOrchestration <em>Transformation Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transformation Orchestration</em>' containment reference.
   * @see #getTransformationOrchestration()
   * @generated
   */
  void setTransformationOrchestration(TransformationOrchestration value);

  /**
   * Returns the value of the '<em><b>Fitness Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fitness Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fitness Function</em>' containment reference.
   * @see #setFitnessFunction(FitnessFunctionSpecification)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSearchOrchestration_FitnessFunction()
   * @model containment="true"
   * @generated
   */
  FitnessFunctionSpecification getFitnessFunction();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getFitnessFunction <em>Fitness Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fitness Function</em>' containment reference.
   * @see #getFitnessFunction()
   * @generated
   */
  void setFitnessFunction(FitnessFunctionSpecification value);

  /**
   * Returns the value of the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithms</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithms</em>' containment reference.
   * @see #setAlgorithms(AlgorithmList)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSearchOrchestration_Algorithms()
   * @model containment="true"
   * @generated
   */
  AlgorithmList getAlgorithms();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getAlgorithms <em>Algorithms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithms</em>' containment reference.
   * @see #getAlgorithms()
   * @generated
   */
  void setAlgorithms(AlgorithmList value);

  /**
   * Returns the value of the '<em><b>Equality Helper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equality Helper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equality Helper</em>' containment reference.
   * @see #setEqualityHelper(EqualityHelper)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSearchOrchestration_EqualityHelper()
   * @model containment="true"
   * @generated
   */
  EqualityHelper getEqualityHelper();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration#getEqualityHelper <em>Equality Helper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Equality Helper</em>' containment reference.
   * @see #getEqualityHelper()
   * @generated
   */
  void setEqualityHelper(EqualityHelper value);

} // SearchOrchestration
