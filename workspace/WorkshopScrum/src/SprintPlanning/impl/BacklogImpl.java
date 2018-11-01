/**
 */
package SprintPlanning.impl;

import SprintPlanning.Backlog;
import SprintPlanning.SprintPlanningPackage;
import SprintPlanning.WorkItem;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Backlog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SprintPlanning.impl.BacklogImpl#getWorkitems <em>Workitems</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BacklogImpl extends MinimalEObjectImpl.Container implements Backlog {
	/**
	 * The cached value of the '{@link #getWorkitems() <em>Workitems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkitems()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> workitems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BacklogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SprintPlanningPackage.Literals.BACKLOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getWorkitems() {
		if (workitems == null) {
			workitems = new EObjectContainmentEList<WorkItem>(WorkItem.class, this, SprintPlanningPackage.BACKLOG__WORKITEMS);
		}
		return workitems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SprintPlanningPackage.BACKLOG__WORKITEMS:
				return ((InternalEList<?>)getWorkitems()).basicRemove(otherEnd, msgs);
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
			case SprintPlanningPackage.BACKLOG__WORKITEMS:
				return getWorkitems();
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
			case SprintPlanningPackage.BACKLOG__WORKITEMS:
				getWorkitems().clear();
				getWorkitems().addAll((Collection<? extends WorkItem>)newValue);
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
			case SprintPlanningPackage.BACKLOG__WORKITEMS:
				getWorkitems().clear();
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
			case SprintPlanningPackage.BACKLOG__WORKITEMS:
				return workitems != null && !workitems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BacklogImpl
