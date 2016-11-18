/**
 */
package metasearch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Search Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.LocalSearchApplication#getProbability <em>Probability</em>}</li>
 *   <li>{@link metasearch.LocalSearchApplication#getTournamentSize <em>Tournament Size</em>}</li>
 *   <li>{@link metasearch.LocalSearchApplication#getLocalsearchalgorithm <em>Localsearchalgorithm</em>}</li>
 *   <li>{@link metasearch.LocalSearchApplication#isLastSolution <em>Last Solution</em>}</li>
 *   <li>{@link metasearch.LocalSearchApplication#getStartAtEvalPerc <em>Start At Eval Perc</em>}</li>
 *   <li>{@link metasearch.LocalSearchApplication#getUsedGenerator <em>Used Generator</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getLocalSearchApplication()
 * @model
 * @generated
 */
public interface LocalSearchApplication extends EObject {
	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see metasearch.MetasearchPackage#getLocalSearchApplication_Probability()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link metasearch.LocalSearchApplication#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

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
	 * @see metasearch.MetasearchPackage#getLocalSearchApplication_TournamentSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getTournamentSize();

	/**
	 * Sets the value of the '{@link metasearch.LocalSearchApplication#getTournamentSize <em>Tournament Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tournament Size</em>' attribute.
	 * @see #getTournamentSize()
	 * @generated
	 */
	void setTournamentSize(int value);

	/**
	 * Returns the value of the '<em><b>Localsearchalgorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Localsearchalgorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Localsearchalgorithm</em>' reference.
	 * @see #setLocalsearchalgorithm(LocalSearchAlgorithm)
	 * @see metasearch.MetasearchPackage#getLocalSearchApplication_Localsearchalgorithm()
	 * @model required="true"
	 * @generated
	 */
	LocalSearchAlgorithm getLocalsearchalgorithm();

	/**
	 * Sets the value of the '{@link metasearch.LocalSearchApplication#getLocalsearchalgorithm <em>Localsearchalgorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Localsearchalgorithm</em>' reference.
	 * @see #getLocalsearchalgorithm()
	 * @generated
	 */
	void setLocalsearchalgorithm(LocalSearchAlgorithm value);

	/**
	 * Returns the value of the '<em><b>Last Solution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Solution</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Solution</em>' attribute.
	 * @see #setLastSolution(boolean)
	 * @see metasearch.MetasearchPackage#getLocalSearchApplication_LastSolution()
	 * @model required="true"
	 * @generated
	 */
	boolean isLastSolution();

	/**
	 * Sets the value of the '{@link metasearch.LocalSearchApplication#isLastSolution <em>Last Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Solution</em>' attribute.
	 * @see #isLastSolution()
	 * @generated
	 */
	void setLastSolution(boolean value);

	/**
	 * Returns the value of the '<em><b>Start At Eval Perc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start At Eval Perc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start At Eval Perc</em>' attribute.
	 * @see #setStartAtEvalPerc(double)
	 * @see metasearch.MetasearchPackage#getLocalSearchApplication_StartAtEvalPerc()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getStartAtEvalPerc();

	/**
	 * Sets the value of the '{@link metasearch.LocalSearchApplication#getStartAtEvalPerc <em>Start At Eval Perc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start At Eval Perc</em>' attribute.
	 * @see #getStartAtEvalPerc()
	 * @generated
	 */
	void setStartAtEvalPerc(double value);

	/**
	 * Returns the value of the '<em><b>Used Generator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Generator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Generator</em>' reference.
	 * @see #setUsedGenerator(FitnessComparatorGenerator)
	 * @see metasearch.MetasearchPackage#getLocalSearchApplication_UsedGenerator()
	 * @model required="true"
	 * @generated
	 */
	FitnessComparatorGenerator getUsedGenerator();

	/**
	 * Sets the value of the '{@link metasearch.LocalSearchApplication#getUsedGenerator <em>Used Generator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Generator</em>' reference.
	 * @see #getUsedGenerator()
	 * @generated
	 */
	void setUsedGenerator(FitnessComparatorGenerator value);

} // LocalSearchApplication
