/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tabu Supporting Local Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.TabuSupportingLocalSearch#getTabuSize <em>Tabu Size</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getTabuSupportingLocalSearch()
 * @model abstract="true"
 * @generated
 */
public interface TabuSupportingLocalSearch extends LocalSearchAlgorithm {
	/**
	 * Returns the value of the '<em><b>Tabu Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tabu Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tabu Size</em>' attribute.
	 * @see #setTabuSize(int)
	 * @see metasearch.MetasearchPackage#getTabuSupportingLocalSearch_TabuSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getTabuSize();

	/**
	 * Sets the value of the '{@link metasearch.TabuSupportingLocalSearch#getTabuSize <em>Tabu Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tabu Size</em>' attribute.
	 * @see #getTabuSize()
	 * @generated
	 */
	void setTabuSize(int value);

} // TabuSupportingLocalSearch
