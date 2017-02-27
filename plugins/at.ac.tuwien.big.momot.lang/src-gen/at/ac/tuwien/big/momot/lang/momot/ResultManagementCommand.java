/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Management Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getNeighborhoodSize <em>Neighborhood Size</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isMaxNeighborhoodSize <em>Max Neighborhood Size</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isPrintOutput <em>Print Output</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagementCommand()
 * @model
 * @generated
 */
public interface ResultManagementCommand extends EObject
{
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
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagementCommand_Algorithms()
   * @model containment="true"
   * @generated
   */
  AlgorithmReferences getAlgorithms();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getAlgorithms <em>Algorithms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithms</em>' containment reference.
   * @see #getAlgorithms()
   * @generated
   */
  void setAlgorithms(AlgorithmReferences value);

  /**
   * Returns the value of the '<em><b>Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Neighborhood Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Neighborhood Size</em>' attribute.
   * @see #setNeighborhoodSize(int)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagementCommand_NeighborhoodSize()
   * @model
   * @generated
   */
  int getNeighborhoodSize();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#getNeighborhoodSize <em>Neighborhood Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Neighborhood Size</em>' attribute.
   * @see #getNeighborhoodSize()
   * @generated
   */
  void setNeighborhoodSize(int value);

  /**
   * Returns the value of the '<em><b>Max Neighborhood Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Neighborhood Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Neighborhood Size</em>' attribute.
   * @see #setMaxNeighborhoodSize(boolean)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagementCommand_MaxNeighborhoodSize()
   * @model
   * @generated
   */
  boolean isMaxNeighborhoodSize();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isMaxNeighborhoodSize <em>Max Neighborhood Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Neighborhood Size</em>' attribute.
   * @see #isMaxNeighborhoodSize()
   * @generated
   */
  void setMaxNeighborhoodSize(boolean value);

  /**
   * Returns the value of the '<em><b>Print Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Print Output</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Print Output</em>' attribute.
   * @see #setPrintOutput(boolean)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagementCommand_PrintOutput()
   * @model
   * @generated
   */
  boolean isPrintOutput();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand#isPrintOutput <em>Print Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Print Output</em>' attribute.
   * @see #isPrintOutput()
   * @generated
   */
  void setPrintOutput(boolean value);

} // ResultManagementCommand
