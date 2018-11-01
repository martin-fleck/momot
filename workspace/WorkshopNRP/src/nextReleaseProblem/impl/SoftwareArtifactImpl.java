/**
 */
package nextReleaseProblem.impl;

import java.util.Collection;

import nextReleaseProblem.Cost;
import nextReleaseProblem.NextReleaseProblemPackage;
import nextReleaseProblem.RequirementRealisation;
import nextReleaseProblem.SoftwareArtifact;
import nextReleaseProblem.Solution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.impl.SoftwareArtifactImpl#getName <em>Name</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.SoftwareArtifactImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.SoftwareArtifactImpl#getCosts <em>Costs</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.SoftwareArtifactImpl#getContributesTo <em>Contributes To</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.SoftwareArtifactImpl#getSolutions <em>Solutions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SoftwareArtifactImpl extends MinimalEObjectImpl.Container implements SoftwareArtifact {
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
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<SoftwareArtifact> requires;

	/**
	 * The cached value of the '{@link #getCosts() <em>Costs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCosts()
	 * @generated
	 * @ordered
	 */
	protected EList<Cost> costs;

	/**
	 * The cached value of the '{@link #getContributesTo() <em>Contributes To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributesTo()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementRealisation> contributesTo;

	/**
	 * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutions()
	 * @generated
	 * @ordered
	 */
	protected EList<Solution> solutions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareArtifactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NextReleaseProblemPackage.Literals.SOFTWARE_ARTIFACT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NextReleaseProblemPackage.SOFTWARE_ARTIFACT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SoftwareArtifact> getRequires() {
		if (requires == null) {
			requires = new EObjectResolvingEList<SoftwareArtifact>(SoftwareArtifact.class, this, NextReleaseProblemPackage.SOFTWARE_ARTIFACT__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cost> getCosts() {
		if (costs == null) {
			costs = new EObjectContainmentEList<Cost>(Cost.class, this, NextReleaseProblemPackage.SOFTWARE_ARTIFACT__COSTS);
		}
		return costs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequirementRealisation> getContributesTo() {
		if (contributesTo == null) {
			contributesTo = new EObjectWithInverseResolvingEList.ManyInverse<RequirementRealisation>(RequirementRealisation.class, this, NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO, NextReleaseProblemPackage.REQUIREMENT_REALISATION__DEPENDS_ON);
		}
		return contributesTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Solution> getSolutions() {
		if (solutions == null) {
			solutions = new EObjectWithInverseResolvingEList.ManyInverse<Solution>(Solution.class, this, NextReleaseProblemPackage.SOFTWARE_ARTIFACT__SOLUTIONS, NextReleaseProblemPackage.SOLUTION__SELECTED_ARTIFACTS);
		}
		return solutions;
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
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContributesTo()).basicAdd(otherEnd, msgs);
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__SOLUTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutions()).basicAdd(otherEnd, msgs);
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
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__COSTS:
				return ((InternalEList<?>)getCosts()).basicRemove(otherEnd, msgs);
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO:
				return ((InternalEList<?>)getContributesTo()).basicRemove(otherEnd, msgs);
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__SOLUTIONS:
				return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
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
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__NAME:
				return getName();
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__REQUIRES:
				return getRequires();
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__COSTS:
				return getCosts();
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO:
				return getContributesTo();
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__SOLUTIONS:
				return getSolutions();
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
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__NAME:
				setName((String)newValue);
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__REQUIRES:
				getRequires().clear();
				getRequires().addAll((Collection<? extends SoftwareArtifact>)newValue);
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__COSTS:
				getCosts().clear();
				getCosts().addAll((Collection<? extends Cost>)newValue);
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO:
				getContributesTo().clear();
				getContributesTo().addAll((Collection<? extends RequirementRealisation>)newValue);
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__SOLUTIONS:
				getSolutions().clear();
				getSolutions().addAll((Collection<? extends Solution>)newValue);
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
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__REQUIRES:
				getRequires().clear();
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__COSTS:
				getCosts().clear();
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO:
				getContributesTo().clear();
				return;
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__SOLUTIONS:
				getSolutions().clear();
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
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__REQUIRES:
				return requires != null && !requires.isEmpty();
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__COSTS:
				return costs != null && !costs.isEmpty();
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__CONTRIBUTES_TO:
				return contributesTo != null && !contributesTo.isEmpty();
			case NextReleaseProblemPackage.SOFTWARE_ARTIFACT__SOLUTIONS:
				return solutions != null && !solutions.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SoftwareArtifactImpl
