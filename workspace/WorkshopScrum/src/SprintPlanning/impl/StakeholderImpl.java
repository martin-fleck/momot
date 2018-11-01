/**
 */
package SprintPlanning.impl;

import SprintPlanning.SprintPlanningPackage;
import SprintPlanning.Stakeholder;
import SprintPlanning.WorkItem;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SprintPlanning.impl.StakeholderImpl#getWorkitem <em>Workitem</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StakeholderImpl extends MinimalEObjectImpl.Container implements Stakeholder {
	/**
	 * The cached value of the '{@link #getWorkitem() <em>Workitem</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkitem()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> workitem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SprintPlanningPackage.Literals.STAKEHOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getWorkitem() {
		if (workitem == null) {
			workitem = new EObjectWithInverseResolvingEList<WorkItem>(WorkItem.class, this, SprintPlanningPackage.STAKEHOLDER__WORKITEM, SprintPlanningPackage.WORK_ITEM__STAKEHOLDER);
		}
		return workitem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SprintPlanningPackage.STAKEHOLDER__WORKITEM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWorkitem()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SprintPlanningPackage.STAKEHOLDER__WORKITEM:
				return ((InternalEList<?>)getWorkitem()).basicRemove(otherEnd, msgs);
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
			case SprintPlanningPackage.STAKEHOLDER__WORKITEM:
				return getWorkitem();
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
			case SprintPlanningPackage.STAKEHOLDER__WORKITEM:
				getWorkitem().clear();
				getWorkitem().addAll((Collection<? extends WorkItem>)newValue);
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
			case SprintPlanningPackage.STAKEHOLDER__WORKITEM:
				getWorkitem().clear();
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
			case SprintPlanningPackage.STAKEHOLDER__WORKITEM:
				return workitem != null && !workitem.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StakeholderImpl
