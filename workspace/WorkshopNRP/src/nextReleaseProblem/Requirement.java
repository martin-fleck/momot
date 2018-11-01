/**
 */
package nextReleaseProblem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.Requirement#getName <em>Name</em>}</li>
 *   <li>{@link nextReleaseProblem.Requirement#getValuations <em>Valuations</em>}</li>
 *   <li>{@link nextReleaseProblem.Requirement#getRealisations <em>Realisations</em>}</li>
 *   <li>{@link nextReleaseProblem.Requirement#getCombines <em>Combines</em>}</li>
 * </ul>
 *
 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.Requirement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Valuations</b></em>' containment reference list.
	 * The list contents are of type {@link nextReleaseProblem.Valuation}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.Valuation#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valuations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valuations</em>' containment reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirement_Valuations()
	 * @see nextReleaseProblem.Valuation#getRequirement
	 * @model opposite="requirement" containment="true" required="true"
	 * @generated
	 */
	EList<Valuation> getValuations();

	/**
	 * Returns the value of the '<em><b>Realisations</b></em>' containment reference list.
	 * The list contents are of type {@link nextReleaseProblem.RequirementRealisation}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.RequirementRealisation#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realisations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realisations</em>' containment reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirement_Realisations()
	 * @see nextReleaseProblem.RequirementRealisation#getRequirement
	 * @model opposite="requirement" containment="true"
	 * @generated
	 */
	EList<RequirementRealisation> getRealisations();

	/**
	 * Returns the value of the '<em><b>Combines</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.Valuation}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.Valuation#getContributesTo <em>Contributes To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combines</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirement_Combines()
	 * @see nextReleaseProblem.Valuation#getContributesTo
	 * @model opposite="contributesTo"
	 * @generated
	 */
	EList<Valuation> getCombines();

} // Requirement
