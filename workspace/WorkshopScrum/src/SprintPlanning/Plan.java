/**
 */
package SprintPlanning;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SprintPlanning.Plan#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link SprintPlanning.Plan#getBacklog <em>Backlog</em>}</li>
 *   <li>{@link SprintPlanning.Plan#getSprints <em>Sprints</em>}</li>
 * </ul>
 *
 * @see SprintPlanning.SprintPlanningPackage#getPlan()
 * @model
 * @generated
 */
public interface Plan extends EObject {
	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' containment reference list.
	 * The list contents are of type {@link SprintPlanning.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' containment reference list.
	 * @see SprintPlanning.SprintPlanningPackage#getPlan_Stakeholders()
	 * @model containment="true"
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

	/**
	 * Returns the value of the '<em><b>Backlog</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backlog</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backlog</em>' containment reference.
	 * @see #setBacklog(Backlog)
	 * @see SprintPlanning.SprintPlanningPackage#getPlan_Backlog()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Backlog getBacklog();

	/**
	 * Sets the value of the '{@link SprintPlanning.Plan#getBacklog <em>Backlog</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backlog</em>' containment reference.
	 * @see #getBacklog()
	 * @generated
	 */
	void setBacklog(Backlog value);

	/**
	 * Returns the value of the '<em><b>Sprints</b></em>' containment reference list.
	 * The list contents are of type {@link SprintPlanning.Sprint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sprints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sprints</em>' containment reference list.
	 * @see SprintPlanning.SprintPlanningPackage#getPlan_Sprints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sprint> getSprints();

} // Plan
