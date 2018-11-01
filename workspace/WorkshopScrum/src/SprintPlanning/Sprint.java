/**
 */
package SprintPlanning;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sprint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SprintPlanning.Sprint#getCommittedItem <em>Committed Item</em>}</li>
 *   <li>{@link SprintPlanning.Sprint#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see SprintPlanning.SprintPlanningPackage#getSprint()
 * @model
 * @generated
 */
public interface Sprint extends EObject {
	/**
	 * Returns the value of the '<em><b>Committed Item</b></em>' reference list.
	 * The list contents are of type {@link SprintPlanning.WorkItem}.
	 * It is bidirectional and its opposite is '{@link SprintPlanning.WorkItem#getIsPlannedFor <em>Is Planned For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Committed Item</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Committed Item</em>' reference list.
	 * @see SprintPlanning.SprintPlanningPackage#getSprint_CommittedItem()
	 * @see SprintPlanning.WorkItem#getIsPlannedFor
	 * @model opposite="isPlannedFor" required="true"
	 * @generated
	 */
	EList<WorkItem> getCommittedItem();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see SprintPlanning.SprintPlanningPackage#getSprint_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link SprintPlanning.Sprint#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

} // Sprint
