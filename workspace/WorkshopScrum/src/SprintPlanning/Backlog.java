/**
 */
package SprintPlanning;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Backlog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SprintPlanning.Backlog#getWorkitems <em>Workitems</em>}</li>
 * </ul>
 *
 * @see SprintPlanning.SprintPlanningPackage#getBacklog()
 * @model
 * @generated
 */
public interface Backlog extends EObject {
	/**
	 * Returns the value of the '<em><b>Workitems</b></em>' containment reference list.
	 * The list contents are of type {@link SprintPlanning.WorkItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workitems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workitems</em>' containment reference list.
	 * @see SprintPlanning.SprintPlanningPackage#getBacklog_Workitems()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<WorkItem> getWorkitems();

} // Backlog
