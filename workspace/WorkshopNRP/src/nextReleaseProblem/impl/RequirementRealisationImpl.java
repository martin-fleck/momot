/**
 */
package nextReleaseProblem.impl;

import java.util.Collection;

import nextReleaseProblem.NextReleaseProblemPackage;
import nextReleaseProblem.Requirement;
import nextReleaseProblem.RequirementRealisation;
import nextReleaseProblem.SoftwareArtifact;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Realisation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.impl.RequirementRealisationImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.RequirementRealisationImpl#getPercentage <em>Percentage</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.RequirementRealisationImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.RequirementRealisationImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementRealisationImpl extends MinimalEObjectImpl.Container implements RequirementRealisation {
	/**
	 * The default value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double PERCENTAGE_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected double percentage = PERCENTAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<SoftwareArtifact> dependsOn;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementRealisationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NextReleaseProblemPackage.Literals.REQUIREMENT_REALISATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getRequirement() {
		if (eContainerFeatureID() != NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT) return null;
		return (Requirement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirement(Requirement newRequirement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRequirement, NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirement(Requirement newRequirement) {
		if (newRequirement != eInternalContainer() || (eContainerFeatureID() != NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT && newRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newRequirement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRequirement != null)
				msgs = ((InternalEObject)newRequirement).eInverseAdd(this, NextReleaseProblemPackage.REQUIREMENT__REALISATIONS, Requirement.class, msgs);
			msgs = basicSetRequirement(newRequirement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT, newRequirement, newRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPercentage() {
		return percentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentage(double newPercentage) {
		double oldPercentage = percentage;
		percentage = newPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NextReleaseProblemPackage.REQUIREMENT_REALISATION__PERCENTAGE, oldPercentage, percentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SoftwareArtifact> getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectWithInverseResolvingEList.ManyInverse<SoftwareArtifact>(SoftwareArtifact.class, this, NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON, NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO);
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NextReleaseProblemPackage.REQUIREMENT_REALISATION__NAME, oldName, name));
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
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRequirement((Requirement)otherEnd, msgs);
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependsOn()).basicAdd(otherEnd, msgs);
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
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT:
				return basicSetRequirement(null, msgs);
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON:
				return ((InternalEList<?>)getDependsOn()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT:
				return eInternalContainer().eInverseRemove(this, NextReleaseProblemPackage.REQUIREMENT__REALISATIONS, Requirement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT:
				return getRequirement();
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__PERCENTAGE:
				return getPercentage();
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON:
				return getDependsOn();
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__NAME:
				return getName();
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
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT:
				setRequirement((Requirement)newValue);
				return;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__PERCENTAGE:
				setPercentage((Double)newValue);
				return;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection<? extends SoftwareArtifact>)newValue);
				return;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__NAME:
				setName((String)newValue);
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
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT:
				setRequirement((Requirement)null);
				return;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__PERCENTAGE:
				setPercentage(PERCENTAGE_EDEFAULT);
				return;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON:
				getDependsOn().clear();
				return;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__NAME:
				setName(NAME_EDEFAULT);
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
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__REQUIREMENT:
				return getRequirement() != null;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__PERCENTAGE:
				return percentage != PERCENTAGE_EDEFAULT;
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
			case NextReleaseProblemPackage.REQUIREMENT_REALISATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (percentage: ");
		result.append(percentage);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RequirementRealisationImpl
