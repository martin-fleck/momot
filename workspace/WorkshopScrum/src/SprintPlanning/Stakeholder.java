/**
 */
package SprintPlanning;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SprintPlanning.Stakeholder#getWorkitem <em>Workitem</em>}</li>
 * </ul>
 *
 * @see SprintPlanning.SprintPlanningPackage#getStakeholder()
 * @model
 * @generated
 */
public interface Stakeholder extends EObject {
	/**
	 * Returns the value of the '<em><b>Workitem</b></em>' reference list.
	 * The list contents are of type {@link SprintPlanning.WorkItem}.
	 * It is bidirectional and its opposite is '{@link SprintPlanning.WorkItem#getStakeholder <em>Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workitem</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workitem</em>' reference list.
	 * @see SprintPlanning.SprintPlanningPackage#getStakeholder_Workitem()
	 * @see SprintPlanning.WorkItem#getStakeholder
	 * @model opposite="stakeholder" required="true"
	 * @generated
	 */
	EList<WorkItem> getWorkitem();

} // Stakeholder
