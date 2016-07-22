/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.InputModel#getPath <em>Path</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.InputModel#getAdaptation <em>Adaptation</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getInputModel()
 * @model
 * @generated
 */
public interface InputModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getInputModel_Path()
   * @model containment="true"
   * @generated
   */
  XExpression getPath();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.InputModel#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
  void setPath(XExpression value);

  /**
   * Returns the value of the '<em><b>Adaptation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adaptation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adaptation</em>' containment reference.
   * @see #setAdaptation(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getInputModel_Adaptation()
   * @model containment="true"
   * @generated
   */
  XExpression getAdaptation();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.InputModel#getAdaptation <em>Adaptation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adaptation</em>' containment reference.
   * @see #getAdaptation()
   * @generated
   */
  void setAdaptation(XExpression value);

} // InputModel
