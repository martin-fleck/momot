/**
 */
package metasearch;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fitness Comparator Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.FitnessComparatorGenerator#getComparatorContainer <em>Comparator Container</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getFitnessComparatorGenerator()
 * @model abstract="true"
 * @generated
 */
public interface FitnessComparatorGenerator extends EObject {
	/**
	 * Returns the value of the '<em><b>Comparator Container</b></em>' containment reference list.
	 * The list contents are of type {@link metasearch.Container}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparator Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparator Container</em>' containment reference list.
	 * @see metasearch.MetasearchPackage#getFitnessComparatorGenerator_ComparatorContainer()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Container> getComparatorContainer();

} // FitnessComparatorGenerator
