/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Show Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isIndividual <em>Individual</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isAggregate <em>Aggregate</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isStatisticalSignificance <em>Statistical Significance</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getShowArray()
 * @model
 * @generated
 */
public interface ShowArray extends EObject
{
  /**
   * Returns the value of the '<em><b>Individual</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Individual</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Individual</em>' attribute.
   * @see #setIndividual(boolean)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getShowArray_Individual()
   * @model
   * @generated
   */
  boolean isIndividual();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isIndividual <em>Individual</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Individual</em>' attribute.
   * @see #isIndividual()
   * @generated
   */
  void setIndividual(boolean value);

  /**
   * Returns the value of the '<em><b>Aggregate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aggregate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aggregate</em>' attribute.
   * @see #setAggregate(boolean)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getShowArray_Aggregate()
   * @model
   * @generated
   */
  boolean isAggregate();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isAggregate <em>Aggregate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aggregate</em>' attribute.
   * @see #isAggregate()
   * @generated
   */
  void setAggregate(boolean value);

  /**
   * Returns the value of the '<em><b>Statistical Significance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statistical Significance</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statistical Significance</em>' attribute.
   * @see #setStatisticalSignificance(boolean)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getShowArray_StatisticalSignificance()
   * @model
   * @generated
   */
  boolean isStatisticalSignificance();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ShowArray#isStatisticalSignificance <em>Statistical Significance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statistical Significance</em>' attribute.
   * @see #isStatisticalSignificance()
   * @generated
   */
  void setStatisticalSignificance(boolean value);

} // ShowArray
