/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hill Climbing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.HillClimbing#getNeighborsize <em>Neighborsize</em>}</li>
 *   <li>{@link metasearch.HillClimbing#isNextImprovement <em>Next Improvement</em>}</li>
 *   <li>{@link metasearch.HillClimbing#getMaxNoImprovement <em>Max No Improvement</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getHillClimbing()
 * @model
 * @generated
 */
public interface HillClimbing extends TabuSupportingLocalSearch {
	/**
	 * Returns the value of the '<em><b>Neighborsize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neighborsize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neighborsize</em>' attribute.
	 * @see #setNeighborsize(int)
	 * @see metasearch.MetasearchPackage#getHillClimbing_Neighborsize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNeighborsize();

	/**
	 * Sets the value of the '{@link metasearch.HillClimbing#getNeighborsize <em>Neighborsize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Neighborsize</em>' attribute.
	 * @see #getNeighborsize()
	 * @generated
	 */
	void setNeighborsize(int value);

	/**
	 * Returns the value of the '<em><b>Next Improvement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Improvement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Improvement</em>' attribute.
	 * @see #setNextImprovement(boolean)
	 * @see metasearch.MetasearchPackage#getHillClimbing_NextImprovement()
	 * @model required="true"
	 * @generated
	 */
	boolean isNextImprovement();

	/**
	 * Sets the value of the '{@link metasearch.HillClimbing#isNextImprovement <em>Next Improvement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Improvement</em>' attribute.
	 * @see #isNextImprovement()
	 * @generated
	 */
	void setNextImprovement(boolean value);

	/**
	 * Returns the value of the '<em><b>Max No Improvement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max No Improvement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max No Improvement</em>' attribute.
	 * @see #setMaxNoImprovement(int)
	 * @see metasearch.MetasearchPackage#getHillClimbing_MaxNoImprovement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getMaxNoImprovement();

	/**
	 * Sets the value of the '{@link metasearch.HillClimbing#getMaxNoImprovement <em>Max No Improvement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max No Improvement</em>' attribute.
	 * @see #getMaxNoImprovement()
	 * @generated
	 */
	void setMaxNoImprovement(int value);

} // HillClimbing
