/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memetic Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.MemeticAlgorithm#getLocalsearchapplication <em>Localsearchapplication</em>}</li>
 *   <li>{@link metasearch.MemeticAlgorithm#getGlobalSearch <em>Global Search</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getMemeticAlgorithm()
 * @model
 * @generated
 */
public interface MemeticAlgorithm extends Algorithm {
	/**
	 * Returns the value of the '<em><b>Localsearchapplication</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Localsearchapplication</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Localsearchapplication</em>' containment reference.
	 * @see #setLocalsearchapplication(LocalSearchApplication)
	 * @see metasearch.MetasearchPackage#getMemeticAlgorithm_Localsearchapplication()
	 * @model containment="true"
	 * @generated
	 */
	LocalSearchApplication getLocalsearchapplication();

	/**
	 * Sets the value of the '{@link metasearch.MemeticAlgorithm#getLocalsearchapplication <em>Localsearchapplication</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Localsearchapplication</em>' containment reference.
	 * @see #getLocalsearchapplication()
	 * @generated
	 */
	void setLocalsearchapplication(LocalSearchApplication value);

	/**
	 * Returns the value of the '<em><b>Global Search</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Search</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Search</em>' reference.
	 * @see #setGlobalSearch(GeneticAlgorithm)
	 * @see metasearch.MetasearchPackage#getMemeticAlgorithm_GlobalSearch()
	 * @model required="true"
	 * @generated
	 */
	GeneticAlgorithm getGlobalSearch();

	/**
	 * Sets the value of the '{@link metasearch.MemeticAlgorithm#getGlobalSearch <em>Global Search</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Search</em>' reference.
	 * @see #getGlobalSearch()
	 * @generated
	 */
	void setGlobalSearch(GeneticAlgorithm value);

} // MemeticAlgorithm
