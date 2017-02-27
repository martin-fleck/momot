/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Def Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.DefExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getDefExpression()
 * @model
 * @generated
 */
public interface DefExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' attribute.
   * @see #setExpression(String)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getDefExpression_Expression()
   * @model
   * @generated
   */
  String getExpression();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.DefExpression#getExpression <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' attribute.
   * @see #getExpression()
   * @generated
   */
  void setExpression(String value);

} // DefExpression
