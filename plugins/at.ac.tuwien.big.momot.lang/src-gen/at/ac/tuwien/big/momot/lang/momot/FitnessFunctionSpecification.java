/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fitness Function Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPreprocess <em>Preprocess</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getObjectives <em>Objectives</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPostprocess <em>Postprocess</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getSolutionRepairer <em>Solution Repairer</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessFunctionSpecification()
 * @model
 * @generated
 */
public interface FitnessFunctionSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Constructor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constructor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constructor</em>' containment reference.
   * @see #setConstructor(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessFunctionSpecification_Constructor()
   * @model containment="true"
   * @generated
   */
  XExpression getConstructor();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getConstructor <em>Constructor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constructor</em>' containment reference.
   * @see #getConstructor()
   * @generated
   */
  void setConstructor(XExpression value);

  /**
   * Returns the value of the '<em><b>Preprocess</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Preprocess</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preprocess</em>' containment reference.
   * @see #setPreprocess(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessFunctionSpecification_Preprocess()
   * @model containment="true"
   * @generated
   */
  XExpression getPreprocess();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPreprocess <em>Preprocess</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Preprocess</em>' containment reference.
   * @see #getPreprocess()
   * @generated
   */
  void setPreprocess(XExpression value);

  /**
   * Returns the value of the '<em><b>Objectives</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Objectives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Objectives</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessFunctionSpecification_Objectives()
   * @model containment="true"
   * @generated
   */
  EList<FitnessDimensionSpecification> getObjectives();

  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessFunctionSpecification_Constraints()
   * @model containment="true"
   * @generated
   */
  EList<FitnessDimensionSpecification> getConstraints();

  /**
   * Returns the value of the '<em><b>Postprocess</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postprocess</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postprocess</em>' containment reference.
   * @see #setPostprocess(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessFunctionSpecification_Postprocess()
   * @model containment="true"
   * @generated
   */
  XExpression getPostprocess();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getPostprocess <em>Postprocess</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postprocess</em>' containment reference.
   * @see #getPostprocess()
   * @generated
   */
  void setPostprocess(XExpression value);

  /**
   * Returns the value of the '<em><b>Solution Repairer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Solution Repairer</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Repairer</em>' containment reference.
   * @see #setSolutionRepairer(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessFunctionSpecification_SolutionRepairer()
   * @model containment="true"
   * @generated
   */
  XExpression getSolutionRepairer();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification#getSolutionRepairer <em>Solution Repairer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution Repairer</em>' containment reference.
   * @see #getSolutionRepairer()
   * @generated
   */
  void setSolutionRepairer(XExpression value);

} // FitnessFunctionSpecification
