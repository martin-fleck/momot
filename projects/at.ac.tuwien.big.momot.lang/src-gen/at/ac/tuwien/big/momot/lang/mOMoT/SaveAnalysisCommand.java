/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Save Analysis Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveAnalysisCommand()
 * @model
 * @generated
 */
public interface SaveAnalysisCommand extends EObject
{
  /**
   * Returns the value of the '<em><b>File</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' containment reference.
   * @see #setFile(XExpression)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getSaveAnalysisCommand_File()
   * @model containment="true"
   * @generated
   */
  XExpression getFile();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand#getFile <em>File</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' containment reference.
   * @see #getFile()
   * @generated
   */
  void setFile(XExpression value);

} // SaveAnalysisCommand
