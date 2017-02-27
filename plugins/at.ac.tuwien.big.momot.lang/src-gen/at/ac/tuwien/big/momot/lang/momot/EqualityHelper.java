/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equality Helper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getCall <em>Call</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getMethod <em>Method</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getEqualityHelper()
 * @model
 * @generated
 */
public interface EqualityHelper extends EObject
{
  /**
   * Returns the value of the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' containment reference.
   * @see #setCall(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getEqualityHelper_Call()
   * @model containment="true"
   * @generated
   */
  XExpression getCall();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(XExpression value);

  /**
   * Returns the value of the '<em><b>Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' containment reference.
   * @see #setMethod(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getEqualityHelper_Method()
   * @model containment="true"
   * @generated
   */
  XExpression getMethod();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.EqualityHelper#getMethod <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' containment reference.
   * @see #getMethod()
   * @generated
   */
  void setMethod(XExpression value);

} // EqualityHelper
