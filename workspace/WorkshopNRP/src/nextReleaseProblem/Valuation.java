/**
 */
package nextReleaseProblem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Valuation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.Valuation#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link nextReleaseProblem.Valuation#getValue <em>Value</em>}</li>
 *   <li>{@link nextReleaseProblem.Valuation#getAssignedBy <em>Assigned By</em>}</li>
 *   <li>{@link nextReleaseProblem.Valuation#getContributesTo <em>Contributes To</em>}</li>
 *   <li>{@link nextReleaseProblem.Valuation#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see nextReleaseProblem.NextReleaseProblemPackage#getValuation()
 * @model
 * @generated
 */
public interface Valuation extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.Requirement#getValuations <em>Valuations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' container reference.
	 * @see #setRequirement(Requirement)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getValuation_Requirement()
	 * @see nextReleaseProblem.Requirement#getValuations
	 * @model opposite="valuations" required="true" transient="false"
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.Valuation#getRequirement <em>Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' container reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getValuation_Value()
	 * @model
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.Valuation#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * Returns the value of the '<em><b>Assigned By</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.Customer}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.Customer#getAssigns <em>Assigns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned By</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getValuation_AssignedBy()
	 * @see nextReleaseProblem.Customer#getAssigns
	 * @model opposite="assigns" required="true"
	 * @generated
	 */
	EList<Customer> getAssignedBy();

	/**
	 * Returns the value of the '<em><b>Contributes To</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.Requirement}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.Requirement#getCombines <em>Combines</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributes To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributes To</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getValuation_ContributesTo()
	 * @see nextReleaseProblem.Requirement#getCombines
	 * @model opposite="combines"
	 * @generated
	 */
	EList<Requirement> getContributesTo();

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
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getValuation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.Valuation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Valuation
