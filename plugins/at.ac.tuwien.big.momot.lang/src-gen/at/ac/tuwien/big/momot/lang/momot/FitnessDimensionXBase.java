/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fitness Dimension XBase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionXBase()
 * @model
 * @generated
 */
public interface FitnessDimensionXBase extends FitnessDimensionSpecification
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionXBase_Value()
   * @model containment="true"
   * @generated
   */
  XExpression getValue();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(XExpression value);

} // FitnessDimensionXBase
