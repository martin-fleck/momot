/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Management</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ResultManagement#getAdaptModels <em>Adapt Models</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ResultManagement#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagement()
 * @model
 * @generated
 */
public interface ResultManagement extends EObject
{
  /**
   * Returns the value of the '<em><b>Adapt Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adapt Models</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adapt Models</em>' containment reference.
   * @see #setAdaptModels(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagement_AdaptModels()
   * @model containment="true"
   * @generated
   */
  XExpression getAdaptModels();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ResultManagement#getAdaptModels <em>Adapt Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adapt Models</em>' containment reference.
   * @see #getAdaptModels()
   * @generated
   */
  void setAdaptModels(XExpression value);

  /**
   * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getResultManagement_Commands()
   * @model containment="true"
   * @generated
   */
  EList<ResultManagementCommand> getCommands();

} // ResultManagement
