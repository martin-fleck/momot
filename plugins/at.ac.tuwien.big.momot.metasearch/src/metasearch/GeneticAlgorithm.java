/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Genetic Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.GeneticAlgorithm#getPopulationSize <em>Population Size</em>}</li>
 *   <li>{@link metasearch.GeneticAlgorithm#getMutateDelete <em>Mutate Delete</em>}</li>
 *   <li>{@link metasearch.GeneticAlgorithm#getMutateModifyRule <em>Mutate Modify Rule</em>}</li>
 *   <li>{@link metasearch.GeneticAlgorithm#getMutateReplaceRule <em>Mutate Replace Rule</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getGeneticAlgorithm()
 * @model abstract="true"
 * @generated
 */
public interface GeneticAlgorithm extends Algorithm {
	/**
	 * Returns the value of the '<em><b>Population Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population Size</em>' attribute.
	 * @see #setPopulationSize(int)
	 * @see metasearch.MetasearchPackage#getGeneticAlgorithm_PopulationSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getPopulationSize();

	/**
	 * Sets the value of the '{@link metasearch.GeneticAlgorithm#getPopulationSize <em>Population Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Size</em>' attribute.
	 * @see #getPopulationSize()
	 * @generated
	 */
	void setPopulationSize(int value);

	/**
	 * Returns the value of the '<em><b>Mutate Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutate Delete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutate Delete</em>' attribute.
	 * @see #setMutateDelete(double)
	 * @see metasearch.MetasearchPackage#getGeneticAlgorithm_MutateDelete()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getMutateDelete();

	/**
	 * Sets the value of the '{@link metasearch.GeneticAlgorithm#getMutateDelete <em>Mutate Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutate Delete</em>' attribute.
	 * @see #getMutateDelete()
	 * @generated
	 */
	void setMutateDelete(double value);

	/**
	 * Returns the value of the '<em><b>Mutate Modify Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutate Modify Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutate Modify Rule</em>' attribute.
	 * @see #setMutateModifyRule(double)
	 * @see metasearch.MetasearchPackage#getGeneticAlgorithm_MutateModifyRule()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getMutateModifyRule();

	/**
	 * Sets the value of the '{@link metasearch.GeneticAlgorithm#getMutateModifyRule <em>Mutate Modify Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutate Modify Rule</em>' attribute.
	 * @see #getMutateModifyRule()
	 * @generated
	 */
	void setMutateModifyRule(double value);

	/**
	 * Returns the value of the '<em><b>Mutate Replace Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutate Replace Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutate Replace Rule</em>' attribute.
	 * @see #setMutateReplaceRule(double)
	 * @see metasearch.MetasearchPackage#getGeneticAlgorithm_MutateReplaceRule()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getMutateReplaceRule();

	/**
	 * Sets the value of the '{@link metasearch.GeneticAlgorithm#getMutateReplaceRule <em>Mutate Replace Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutate Replace Rule</em>' attribute.
	 * @see #getMutateReplaceRule()
	 * @generated
	 */
	void setMutateReplaceRule(double value);

} // GeneticAlgorithm
