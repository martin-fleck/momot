/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fitness Dimension OCL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL#getQuery <em>Query</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL#getDefExpressions <em>Def Expressions</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionOCL()
 * @model
 * @generated
 */
public interface FitnessDimensionOCL extends FitnessDimensionSpecification
{
  /**
   * Returns the value of the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query</em>' containment reference.
   * @see #setQuery(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionOCL_Query()
   * @model containment="true"
   * @generated
   */
  XExpression getQuery();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL#getQuery <em>Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query</em>' containment reference.
   * @see #getQuery()
   * @generated
   */
  void setQuery(XExpression value);

  /**
   * Returns the value of the '<em><b>Def Expressions</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.momot.DefExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Def Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Def Expressions</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionOCL_DefExpressions()
   * @model containment="true"
   * @generated
   */
  EList<DefExpression> getDefExpressions();

} // FitnessDimensionOCL
