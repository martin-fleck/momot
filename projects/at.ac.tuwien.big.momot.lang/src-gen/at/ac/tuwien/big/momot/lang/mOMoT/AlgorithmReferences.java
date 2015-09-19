/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithm References</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getAlgorithmReferences()
 * @model
 * @generated
 */
public interface AlgorithmReferences extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' reference list.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getAlgorithmReferences_Elements()
   * @model
   * @generated
   */
  EList<AlgorithmSpecification> getElements();

} // AlgorithmReferences
