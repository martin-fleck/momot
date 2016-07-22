/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fitness Dimension Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionSpecification()
 * @model
 * @generated
 */
public interface FitnessDimensionSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionSpecification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType
   * @see #setType(FitnessDimensionType)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionSpecification_Type()
   * @model
   * @generated
   */
  FitnessDimensionType getType();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType
   * @see #getType()
   * @generated
   */
  void setType(FitnessDimensionType value);

} // FitnessDimensionSpecification
