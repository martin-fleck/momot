/**
 */
package SprintPlanning;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see SprintPlanning.SprintPlanningPackage
 * @generated
 */
public interface SprintPlanningFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SprintPlanningFactory eINSTANCE = SprintPlanning.impl.SprintPlanningFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Stakeholder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stakeholder</em>'.
	 * @generated
	 */
	Stakeholder createStakeholder();

	/**
	 * Returns a new object of class '<em>Backlog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Backlog</em>'.
	 * @generated
	 */
	Backlog createBacklog();

	/**
	 * Returns a new object of class '<em>Work Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Item</em>'.
	 * @generated
	 */
	WorkItem createWorkItem();

	/**
	 * Returns a new object of class '<em>Sprint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sprint</em>'.
	 * @generated
	 */
	Sprint createSprint();

	/**
	 * Returns a new object of class '<em>Plan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plan</em>'.
	 * @generated
	 */
	Plan createPlan();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SprintPlanningPackage getSprintPlanningPackage();

} //SprintPlanningFactory
