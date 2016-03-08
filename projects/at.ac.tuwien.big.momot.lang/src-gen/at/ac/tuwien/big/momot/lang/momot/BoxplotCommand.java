/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boxplot Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.BoxplotCommand#getDirectory <em>Directory</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getBoxplotCommand()
 * @model
 * @generated
 */
public interface BoxplotCommand extends AnalysisCommand
{
  /**
   * Returns the value of the '<em><b>Directory</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Directory</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directory</em>' containment reference.
   * @see #setDirectory(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getBoxplotCommand_Directory()
   * @model containment="true"
   * @generated
   */
  XExpression getDirectory();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.BoxplotCommand#getDirectory <em>Directory</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directory</em>' containment reference.
   * @see #getDirectory()
   * @generated
   */
  void setDirectory(XExpression value);

} // BoxplotCommand
