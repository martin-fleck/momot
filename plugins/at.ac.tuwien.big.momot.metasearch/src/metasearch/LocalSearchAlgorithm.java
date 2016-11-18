/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Search Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.LocalSearchAlgorithm#getNeighborhood <em>Neighborhood</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getLocalSearchAlgorithm()
 * @model abstract="true"
 * @generated
 */
public interface LocalSearchAlgorithm extends Algorithm {
	/**
	 * Returns the value of the '<em><b>Neighborhood</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neighborhood</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neighborhood</em>' reference.
	 * @see #setNeighborhood(Neighborhood)
	 * @see metasearch.MetasearchPackage#getLocalSearchAlgorithm_Neighborhood()
	 * @model required="true"
	 * @generated
	 */
	Neighborhood getNeighborhood();

	/**
	 * Sets the value of the '{@link metasearch.LocalSearchAlgorithm#getNeighborhood <em>Neighborhood</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Neighborhood</em>' reference.
	 * @see #getNeighborhood()
	 * @generated
	 */
	void setNeighborhood(Neighborhood value);

} // LocalSearchAlgorithm
