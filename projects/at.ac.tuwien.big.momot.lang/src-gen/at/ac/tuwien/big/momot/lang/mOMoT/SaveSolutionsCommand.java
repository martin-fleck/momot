/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Save Solutions Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getDirectory <em>Directory</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveSolutionsCommand()
 * @model
 * @generated
 */
public interface SaveSolutionsCommand extends EObject
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
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveSolutionsCommand_Algorithms()
   * @model containment="true"
   * @generated
   */
  AlgorithmReferences getAlgorithms();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getAlgorithms <em>Algorithms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithms</em>' containment reference.
   * @see #getAlgorithms()
   * @generated
   */
  void setAlgorithms(AlgorithmReferences value);

  /**
   * Returns the value of the '<em><b>Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Directory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directory</em>' attribute.
   * @see #setDirectory(String)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveSolutionsCommand_Directory()
   * @model
   * @generated
   */
  String getDirectory();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand#getDirectory <em>Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directory</em>' attribute.
   * @see #getDirectory()
   * @generated
   */
  void setDirectory(String value);

} // SaveSolutionsCommand
