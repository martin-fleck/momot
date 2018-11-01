/**
 */
package SprintPlanning.impl;

import SprintPlanning.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SprintPlanningFactoryImpl extends EFactoryImpl implements SprintPlanningFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SprintPlanningFactory init() {
		try {
			SprintPlanningFactory theSprintPlanningFactory = (SprintPlanningFactory)EPackage.Registry.INSTANCE.getEFactory(SprintPlanningPackage.eNS_URI);
			if (theSprintPlanningFactory != null) {
				return theSprintPlanningFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SprintPlanningFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SprintPlanningFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SprintPlanningPackage.STAKEHOLDER: return createStakeholder();
			case SprintPlanningPackage.BACKLOG: return createBacklog();
			case SprintPlanningPackage.WORK_ITEM: return createWorkItem();
			case SprintPlanningPackage.SPRINT: return createSprint();
			case SprintPlanningPackage.PLAN: return createPlan();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stakeholder createStakeholder() {
		StakeholderImpl stakeholder = new StakeholderImpl();
		return stakeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backlog createBacklog() {
		BacklogImpl backlog = new BacklogImpl();
		return backlog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkItem createWorkItem() {
		WorkItemImpl workItem = new WorkItemImpl();
		return workItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sprint createSprint() {
		SprintImpl sprint = new SprintImpl();
		return sprint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plan createPlan() {
		PlanImpl plan = new PlanImpl();
		return plan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SprintPlanningPackage getSprintPlanningPackage() {
		return (SprintPlanningPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SprintPlanningPackage getPackage() {
		return SprintPlanningPackage.eINSTANCE;
	}

} //SprintPlanningFactoryImpl
