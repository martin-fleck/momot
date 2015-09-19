/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Save Objectives Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveObjectivesCommand()
 * @model
 * @generated
 */
public interface SaveObjectivesCommand extends EObject
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
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveObjectivesCommand_Algorithms()
   * @model containment="true"
   * @generated
   */
  AlgorithmReferences getAlgorithms();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getAlgorithms <em>Algorithms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithms</em>' containment reference.
   * @see #getAlgorithms()
   * @generated
   */
  void setAlgorithms(AlgorithmReferences value);

  /**
   * Returns the value of the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' attribute.
   * @see #setFile(String)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveObjectivesCommand_File()
   * @model
   * @generated
   */
  String getFile();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(String value);

} // SaveObjectivesCommand
