/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Changing Neighborhood</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.ChangingNeighborhood#getDeleteProbability <em>Delete Probability</em>}</li>
 *   <li>{@link metasearch.ChangingNeighborhood#getAtEndProbability <em>At End Probability</em>}</li>
 *   <li>{@link metasearch.ChangingNeighborhood#getModifyRuleProbability <em>Modify Rule Probability</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getChangingNeighborhood()
 * @model
 * @generated
 */
public interface ChangingNeighborhood extends Neighborhood {
	/**
	 * Returns the value of the '<em><b>Delete Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Probability</em>' attribute.
	 * @see #setDeleteProbability(double)
	 * @see metasearch.MetasearchPackage#getChangingNeighborhood_DeleteProbability()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getDeleteProbability();

	/**
	 * Sets the value of the '{@link metasearch.ChangingNeighborhood#getDeleteProbability <em>Delete Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete Probability</em>' attribute.
	 * @see #getDeleteProbability()
	 * @generated
	 */
	void setDeleteProbability(double value);

	/**
	 * Returns the value of the '<em><b>At End Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>At End Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At End Probability</em>' attribute.
	 * @see #setAtEndProbability(double)
	 * @see metasearch.MetasearchPackage#getChangingNeighborhood_AtEndProbability()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getAtEndProbability();

	/**
	 * Sets the value of the '{@link metasearch.ChangingNeighborhood#getAtEndProbability <em>At End Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At End Probability</em>' attribute.
	 * @see #getAtEndProbability()
	 * @generated
	 */
	void setAtEndProbability(double value);

	/**
	 * Returns the value of the '<em><b>Modify Rule Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modify Rule Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modify Rule Probability</em>' attribute.
	 * @see #setModifyRuleProbability(double)
	 * @see metasearch.MetasearchPackage#getChangingNeighborhood_ModifyRuleProbability()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getModifyRuleProbability();

	/**
	 * Sets the value of the '{@link metasearch.ChangingNeighborhood#getModifyRuleProbability <em>Modify Rule Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modify Rule Probability</em>' attribute.
	 * @see #getModifyRuleProbability()
	 * @generated
	 */
	void setModifyRuleProbability(double value);

} // ChangingNeighborhood
