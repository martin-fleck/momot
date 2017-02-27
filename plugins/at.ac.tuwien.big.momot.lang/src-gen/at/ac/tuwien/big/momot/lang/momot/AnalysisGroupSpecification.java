/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Group Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getAlgorithms <em>Algorithms</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisGroupSpecification()
 * @model
 * @generated
 */
public interface AnalysisGroupSpecification extends EObject
{
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
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisGroupSpecification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Algorithms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithms</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithms</em>' containment reference.
   * @see #setAlgorithms(AlgorithmReferences)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisGroupSpecification_Algorithms()
   * @model containment="true"
   * @generated
   */
  AlgorithmReferences getAlgorithms();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification#getAlgorithms <em>Algorithms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithms</em>' containment reference.
   * @see #getAlgorithms()
   * @generated
   */
  void setAlgorithms(AlgorithmReferences value);

} // AnalysisGroupSpecification
