/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterating Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.IteratingAlgorithm#getSolutioninitializer <em>Solutioninitializer</em>}</li>
 *   <li>{@link metasearch.IteratingAlgorithm#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link metasearch.IteratingAlgorithm#getFitnesscomparatorgenerator <em>Fitnesscomparatorgenerator</em>}</li>
 *   <li>{@link metasearch.IteratingAlgorithm#getTournamentSize <em>Tournament Size</em>}</li>
 *   <li>{@link metasearch.IteratingAlgorithm#getTournamentRemain <em>Tournament Remain</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getIteratingAlgorithm()
 * @model
 * @generated
 */
public interface IteratingAlgorithm extends Algorithm {
	/**
	 * Returns the value of the '<em><b>Solutioninitializer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutioninitializer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutioninitializer</em>' reference.
	 * @see #setSolutioninitializer(SolutionInitializer)
	 * @see metasearch.MetasearchPackage#getIteratingAlgorithm_Solutioninitializer()
	 * @model required="true"
	 * @generated
	 */
	SolutionInitializer getSolutioninitializer();

	/**
	 * Sets the value of the '{@link metasearch.IteratingAlgorithm#getSolutioninitializer <em>Solutioninitializer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solutioninitializer</em>' reference.
	 * @see #getSolutioninitializer()
	 * @generated
	 */
	void setSolutioninitializer(SolutionInitializer value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' reference.
	 * @see #setAlgorithm(LocalSearchAlgorithm)
	 * @see metasearch.MetasearchPackage#getIteratingAlgorithm_Algorithm()
	 * @model required="true"
	 * @generated
	 */
	LocalSearchAlgorithm getAlgorithm();

	/**
	 * Sets the value of the '{@link metasearch.IteratingAlgorithm#getAlgorithm <em>Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(LocalSearchAlgorithm value);

	/**
	 * Returns the value of the '<em><b>Fitnesscomparatorgenerator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fitnesscomparatorgenerator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fitnesscomparatorgenerator</em>' reference.
	 * @see #setFitnesscomparatorgenerator(FitnessComparatorGenerator)
	 * @see metasearch.MetasearchPackage#getIteratingAlgorithm_Fitnesscomparatorgenerator()
	 * @model
	 * @generated
	 */
	FitnessComparatorGenerator getFitnesscomparatorgenerator();

	/**
	 * Sets the value of the '{@link metasearch.IteratingAlgorithm#getFitnesscomparatorgenerator <em>Fitnesscomparatorgenerator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fitnesscomparatorgenerator</em>' reference.
	 * @see #getFitnesscomparatorgenerator()
	 * @generated
	 */
	void setFitnesscomparatorgenerator(FitnessComparatorGenerator value);

	/**
	 * Returns the value of the '<em><b>Tournament Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tournament Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tournament Size</em>' attribute.
	 * @see #setTournamentSize(int)
	 * @see metasearch.MetasearchPackage#getIteratingAlgorithm_TournamentSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getTournamentSize();

	/**
	 * Sets the value of the '{@link metasearch.IteratingAlgorithm#getTournamentSize <em>Tournament Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tournament Size</em>' attribute.
	 * @see #getTournamentSize()
	 * @generated
	 */
	void setTournamentSize(int value);

	/**
	 * Returns the value of the '<em><b>Tournament Remain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tournament Remain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tournament Remain</em>' attribute.
	 * @see #setTournamentRemain(int)
	 * @see metasearch.MetasearchPackage#getIteratingAlgorithm_TournamentRemain()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getTournamentRemain();

	/**
	 * Sets the value of the '{@link metasearch.IteratingAlgorithm#getTournamentRemain <em>Tournament Remain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tournament Remain</em>' attribute.
	 * @see #getTournamentRemain()
	 * @generated
	 */
	void setTournamentRemain(int value);

} // IteratingAlgorithm
