/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fitness Dimension Constructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor#getCall <em>Call</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getFitnessDimensionConstructor()
 * @model
 * @generated
 */
public interface FitnessDimensionConstructor extends FitnessDimensionSpecification
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
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getFitnessDimensionConstructor_Call()
   * @model containment="true"
   * @generated
   */
  XExpression getCall();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(XExpression value);

} // FitnessDimensionConstructor
