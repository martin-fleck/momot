/**
 */
package SprintPlanning.impl;

import SprintPlanning.Backlog;
import SprintPlanning.Plan;
import SprintPlanning.Sprint;
import SprintPlanning.SprintPlanningPackage;
import SprintPlanning.Stakeholder;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SprintPlanning.impl.PlanImpl#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link SprintPlanning.impl.PlanImpl#getBacklog <em>Backlog</em>}</li>
 *   <li>{@link SprintPlanning.impl.PlanImpl#getSprints <em>Sprints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlanImpl extends MinimalEObjectImpl.Container implements Plan {
	/**
	 * The cached value of the '{@link #getStakeholders() <em>Stakeholders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeholders;

	/**
	 * The cached value of the '{@link #getBacklog() <em>Backlog</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBacklog()
	 * @generated
	 * @ordered
	 */
	protected Backlog backlog;

	/**
	 * The cached value of the '{@link #getSprints() <em>Sprints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSprints()
	 * @generated
	 * @ordered
	 */
	protected EList<Sprint> sprints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SprintPlanningPackage.Literals.PLAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectContainmentEList<Stakeholder>(Stakeholder.class, this, SprintPlanningPackage.PLAN__STAKEHOLDERS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backlog getBacklog() {
		return backlog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBacklog(Backlog newBacklog, NotificationChain msgs) {
		Backlog oldBacklog = backlog;
		backlog = newBacklog;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SprintPlanningPackage.PLAN__BACKLOG, oldBacklog, newBacklog);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBacklog(Backlog newBacklog) {
		if (newBacklog != backlog) {
			NotificationChain msgs = null;
			if (backlog != null)
				msgs = ((InternalEObject)backlog).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SprintPlanningPackage.PLAN__BACKLOG, null, msgs);
			if (newBacklog != null)
				msgs = ((InternalEObject)newBacklog).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SprintPlanningPackage.PLAN__BACKLOG, null, msgs);
			msgs = basicSetBacklog(newBacklog, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SprintPlanningPackage.PLAN__BACKLOG, newBacklog, newBacklog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sprint> getSprints() {
		if (sprints == null) {
			sprints = new EObjectContainmentEList<Sprint>(Sprint.class, this, SprintPlanningPackage.PLAN__SPRINTS);
		}
		return sprints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SprintPlanningPackage.PLAN__STAKEHOLDERS:
				return ((InternalEList<?>)getStakeholders()).basicRemove(otherEnd, msgs);
			case SprintPlanningPackage.PLAN__BACKLOG:
				return basicSetBacklog(null, msgs);
			case SprintPlanningPackage.PLAN__SPRINTS:
				return ((InternalEList<?>)getSprints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SprintPlanningPackage.PLAN__STAKEHOLDERS:
				return getStakeholders();
			case SprintPlanningPackage.PLAN__BACKLOG:
				return getBacklog();
			case SprintPlanningPackage.PLAN__SPRINTS:
				return getSprints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SprintPlanningPackage.PLAN__STAKEHOLDERS:
				getStakeholders().clear();
				getStakeholders().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case SprintPlanningPackage.PLAN__BACKLOG:
				setBacklog((Backlog)newValue);
				return;
			case SprintPlanningPackage.PLAN__SPRINTS:
				getSprints().clear();
				getSprints().addAll((Collection<? extends Sprint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SprintPlanningPackage.PLAN__STAKEHOLDERS:
				getStakeholders().clear();
				return;
			case SprintPlanningPackage.PLAN__BACKLOG:
				setBacklog((Backlog)null);
				return;
			case SprintPlanningPackage.PLAN__SPRINTS:
				getSprints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SprintPlanningPackage.PLAN__STAKEHOLDERS:
				return stakeholders != null && !stakeholders.isEmpty();
			case SprintPlanningPackage.PLAN__BACKLOG:
				return backlog != null;
			case SprintPlanningPackage.PLAN__SPRINTS:
				return sprints != null && !sprints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlanImpl
