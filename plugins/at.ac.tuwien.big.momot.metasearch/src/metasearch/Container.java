/**
 */
package metasearch;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.Container#getUsedAlgorithm <em>Used Algorithm</em>}</li>
 *   <li>{@link metasearch.Container#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link metasearch.Container#getNeighborhood <em>Neighborhood</em>}</li>
 *   <li>{@link metasearch.Container#getSolutioninitializer <em>Solutioninitializer</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Used Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Algorithm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Algorithm</em>' reference.
	 * @see #setUsedAlgorithm(Algorithm)
	 * @see metasearch.MetasearchPackage#getContainer_UsedAlgorithm()
	 * @model required="true"
	 * @generated
	 */
	Algorithm getUsedAlgorithm();

	/**
	 * Sets the value of the '{@link metasearch.Container#getUsedAlgorithm <em>Used Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Algorithm</em>' reference.
	 * @see #getUsedAlgorithm()
	 * @generated
	 */
	void setUsedAlgorithm(Algorithm value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' containment reference list.
	 * The list contents are of type {@link metasearch.Algorithm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' containment reference list.
	 * @see metasearch.MetasearchPackage#getContainer_Algorithm()
	 * @model containment="true"
	 * @generated
	 */
	EList<Algorithm> getAlgorithm();

	/**
	 * Returns the value of the '<em><b>Neighborhood</b></em>' containment reference list.
	 * The list contents are of type {@link metasearch.Neighborhood}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neighborhood</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neighborhood</em>' containment reference list.
	 * @see metasearch.MetasearchPackage#getContainer_Neighborhood()
	 * @model containment="true"
	 * @generated
	 */
	EList<Neighborhood> getNeighborhood();

	/**
	 * Returns the value of the '<em><b>Solutioninitializer</b></em>' containment reference list.
	 * The list contents are of type {@link metasearch.SolutionInitializer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutioninitializer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutioninitializer</em>' containment reference list.
	 * @see metasearch.MetasearchPackage#getContainer_Solutioninitializer()
	 * @model containment="true"
	 * @generated
	 */
	EList<SolutionInitializer> getSolutioninitializer();

} // Container
