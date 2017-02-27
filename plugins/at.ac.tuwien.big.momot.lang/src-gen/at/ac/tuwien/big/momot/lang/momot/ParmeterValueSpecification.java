/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parmeter Value Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getCall <em>Call</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getParmeterValueSpecification()
 * @model
 * @generated
 */
public interface ParmeterValueSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getParmeterValueSpecification_Name()
   * @model containment="true"
   * @generated
   */
  XExpression getName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(XExpression value);

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
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getParmeterValueSpecification_Call()
   * @model containment="true"
   * @generated
   */
  XExpression getCall();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(XExpression value);

} // ParmeterValueSpecification
