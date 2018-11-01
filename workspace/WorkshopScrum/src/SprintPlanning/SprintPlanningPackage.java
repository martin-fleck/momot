/**
 */
package SprintPlanning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see SprintPlanning.SprintPlanningFactory
 * @model kind="package"
 * @generated
 */
public interface SprintPlanningPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SprintPlanning";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.kcl.ac.uk/mdeoptimiser/sprint-planning";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "planning";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SprintPlanningPackage eINSTANCE = SprintPlanning.impl.SprintPlanningPackageImpl.init();

	/**
	 * The meta object id for the '{@link SprintPlanning.impl.StakeholderImpl <em>Stakeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SprintPlanning.impl.StakeholderImpl
	 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getStakeholder()
	 * @generated
	 */
	int STAKEHOLDER = 0;

	/**
	 * The feature id for the '<em><b>Workitem</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__WORKITEM = 0;

	/**
	 * The number of structural features of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SprintPlanning.impl.BacklogImpl <em>Backlog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SprintPlanning.impl.BacklogImpl
	 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getBacklog()
	 * @generated
	 */
	int BACKLOG = 1;

	/**
	 * The feature id for the '<em><b>Workitems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG__WORKITEMS = 0;

	/**
	 * The number of structural features of the '<em>Backlog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Backlog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SprintPlanning.impl.WorkItemImpl <em>Work Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SprintPlanning.impl.WorkItemImpl
	 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getWorkItem()
	 * @generated
	 */
	int WORK_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Is Planned For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__IS_PLANNED_FOR = 0;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__IMPORTANCE = 1;

	/**
	 * The feature id for the '<em><b>Effort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__EFFORT = 2;

	/**
	 * The feature id for the '<em><b>Stakeholder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__STAKEHOLDER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__ID = 4;

	/**
	 * The number of structural features of the '<em>Work Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Work Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SprintPlanning.impl.SprintImpl <em>Sprint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SprintPlanning.impl.SprintImpl
	 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getSprint()
	 * @generated
	 */
	int SPRINT = 3;

	/**
	 * The feature id for the '<em><b>Committed Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__COMMITTED_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__ID = 1;

	/**
	 * The number of structural features of the '<em>Sprint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Sprint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SprintPlanning.impl.PlanImpl <em>Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SprintPlanning.impl.PlanImpl
	 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getPlan()
	 * @generated
	 */
	int PLAN = 4;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN__STAKEHOLDERS = 0;

	/**
	 * The feature id for the '<em><b>Backlog</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN__BACKLOG = 1;

	/**
	 * The feature id for the '<em><b>Sprints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN__SPRINTS = 2;

	/**
	 * The number of structural features of the '<em>Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link SprintPlanning.Stakeholder <em>Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stakeholder</em>'.
	 * @see SprintPlanning.Stakeholder
	 * @generated
	 */
	EClass getStakeholder();

	/**
	 * Returns the meta object for the reference list '{@link SprintPlanning.Stakeholder#getWorkitem <em>Workitem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Workitem</em>'.
	 * @see SprintPlanning.Stakeholder#getWorkitem()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Workitem();

	/**
	 * Returns the meta object for class '{@link SprintPlanning.Backlog <em>Backlog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Backlog</em>'.
	 * @see SprintPlanning.Backlog
	 * @generated
	 */
	EClass getBacklog();

	/**
	 * Returns the meta object for the containment reference list '{@link SprintPlanning.Backlog#getWorkitems <em>Workitems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Workitems</em>'.
	 * @see SprintPlanning.Backlog#getWorkitems()
	 * @see #getBacklog()
	 * @generated
	 */
	EReference getBacklog_Workitems();

	/**
	 * Returns the meta object for class '{@link SprintPlanning.WorkItem <em>Work Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Item</em>'.
	 * @see SprintPlanning.WorkItem
	 * @generated
	 */
	EClass getWorkItem();

	/**
	 * Returns the meta object for the reference '{@link SprintPlanning.WorkItem#getIsPlannedFor <em>Is Planned For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Is Planned For</em>'.
	 * @see SprintPlanning.WorkItem#getIsPlannedFor()
	 * @see #getWorkItem()
	 * @generated
	 */
	EReference getWorkItem_IsPlannedFor();

	/**
	 * Returns the meta object for the attribute '{@link SprintPlanning.WorkItem#getImportance <em>Importance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Importance</em>'.
	 * @see SprintPlanning.WorkItem#getImportance()
	 * @see #getWorkItem()
	 * @generated
	 */
	EAttribute getWorkItem_Importance();

	/**
	 * Returns the meta object for the attribute '{@link SprintPlanning.WorkItem#getEffort <em>Effort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effort</em>'.
	 * @see SprintPlanning.WorkItem#getEffort()
	 * @see #getWorkItem()
	 * @generated
	 */
	EAttribute getWorkItem_Effort();

	/**
	 * Returns the meta object for the reference '{@link SprintPlanning.WorkItem#getStakeholder <em>Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stakeholder</em>'.
	 * @see SprintPlanning.WorkItem#getStakeholder()
	 * @see #getWorkItem()
	 * @generated
	 */
	EReference getWorkItem_Stakeholder();

	/**
	 * Returns the meta object for the attribute '{@link SprintPlanning.WorkItem#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see SprintPlanning.WorkItem#getId()
	 * @see #getWorkItem()
	 * @generated
	 */
	EAttribute getWorkItem_Id();

	/**
	 * Returns the meta object for class '{@link SprintPlanning.Sprint <em>Sprint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sprint</em>'.
	 * @see SprintPlanning.Sprint
	 * @generated
	 */
	EClass getSprint();

	/**
	 * Returns the meta object for the reference list '{@link SprintPlanning.Sprint#getCommittedItem <em>Committed Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Committed Item</em>'.
	 * @see SprintPlanning.Sprint#getCommittedItem()
	 * @see #getSprint()
	 * @generated
	 */
	EReference getSprint_CommittedItem();

	/**
	 * Returns the meta object for the attribute '{@link SprintPlanning.Sprint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see SprintPlanning.Sprint#getId()
	 * @see #getSprint()
	 * @generated
	 */
	EAttribute getSprint_Id();

	/**
	 * Returns the meta object for class '{@link SprintPlanning.Plan <em>Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plan</em>'.
	 * @see SprintPlanning.Plan
	 * @generated
	 */
	EClass getPlan();

	/**
	 * Returns the meta object for the containment reference list '{@link SprintPlanning.Plan#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stakeholders</em>'.
	 * @see SprintPlanning.Plan#getStakeholders()
	 * @see #getPlan()
	 * @generated
	 */
	EReference getPlan_Stakeholders();

	/**
	 * Returns the meta object for the containment reference '{@link SprintPlanning.Plan#getBacklog <em>Backlog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Backlog</em>'.
	 * @see SprintPlanning.Plan#getBacklog()
	 * @see #getPlan()
	 * @generated
	 */
	EReference getPlan_Backlog();

	/**
	 * Returns the meta object for the containment reference list '{@link SprintPlanning.Plan#getSprints <em>Sprints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sprints</em>'.
	 * @see SprintPlanning.Plan#getSprints()
	 * @see #getPlan()
	 * @generated
	 */
	EReference getPlan_Sprints();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SprintPlanningFactory getSprintPlanningFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link SprintPlanning.impl.StakeholderImpl <em>Stakeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SprintPlanning.impl.StakeholderImpl
		 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getStakeholder()
		 * @generated
		 */
		EClass STAKEHOLDER = eINSTANCE.getStakeholder();

		/**
		 * The meta object literal for the '<em><b>Workitem</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__WORKITEM = eINSTANCE.getStakeholder_Workitem();

		/**
		 * The meta object literal for the '{@link SprintPlanning.impl.BacklogImpl <em>Backlog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SprintPlanning.impl.BacklogImpl
		 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getBacklog()
		 * @generated
		 */
		EClass BACKLOG = eINSTANCE.getBacklog();

		/**
		 * The meta object literal for the '<em><b>Workitems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKLOG__WORKITEMS = eINSTANCE.getBacklog_Workitems();

		/**
		 * The meta object literal for the '{@link SprintPlanning.impl.WorkItemImpl <em>Work Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SprintPlanning.impl.WorkItemImpl
		 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getWorkItem()
		 * @generated
		 */
		EClass WORK_ITEM = eINSTANCE.getWorkItem();

		/**
		 * The meta object literal for the '<em><b>Is Planned For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_ITEM__IS_PLANNED_FOR = eINSTANCE.getWorkItem_IsPlannedFor();

		/**
		 * The meta object literal for the '<em><b>Importance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_ITEM__IMPORTANCE = eINSTANCE.getWorkItem_Importance();

		/**
		 * The meta object literal for the '<em><b>Effort</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_ITEM__EFFORT = eINSTANCE.getWorkItem_Effort();

		/**
		 * The meta object literal for the '<em><b>Stakeholder</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_ITEM__STAKEHOLDER = eINSTANCE.getWorkItem_Stakeholder();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_ITEM__ID = eINSTANCE.getWorkItem_Id();

		/**
		 * The meta object literal for the '{@link SprintPlanning.impl.SprintImpl <em>Sprint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SprintPlanning.impl.SprintImpl
		 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getSprint()
		 * @generated
		 */
		EClass SPRINT = eINSTANCE.getSprint();

		/**
		 * The meta object literal for the '<em><b>Committed Item</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRINT__COMMITTED_ITEM = eINSTANCE.getSprint_CommittedItem();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRINT__ID = eINSTANCE.getSprint_Id();

		/**
		 * The meta object literal for the '{@link SprintPlanning.impl.PlanImpl <em>Plan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SprintPlanning.impl.PlanImpl
		 * @see SprintPlanning.impl.SprintPlanningPackageImpl#getPlan()
		 * @generated
		 */
		EClass PLAN = eINSTANCE.getPlan();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAN__STAKEHOLDERS = eINSTANCE.getPlan_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Backlog</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAN__BACKLOG = eINSTANCE.getPlan_Backlog();

		/**
		 * The meta object literal for the '<em><b>Sprints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAN__SPRINTS = eINSTANCE.getPlan_Sprints();

	}

} //SprintPlanningPackage
