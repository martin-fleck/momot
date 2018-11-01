/**
 */
package nextReleaseProblem.impl;

import java.util.Collection;

import nextReleaseProblem.Customer;
import nextReleaseProblem.NRP;
import nextReleaseProblem.NextReleaseProblemPackage;
import nextReleaseProblem.Requirement;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NRP</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.impl.NRPImpl#getName <em>Name</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.NRPImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.NRPImpl#getAvailableArtifacts <em>Available Artifacts</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.NRPImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.NRPImpl#getSolutions <em>Solutions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NRPImpl extends MinimalEObjectImpl.Container implements NRP {
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
	 * The cached value of the '{@link #getCustomers() <em>Customers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList<Customer> customers;

	/**
	 * The cached value of the '{@link #getAvailableArtifacts() <em>Available Artifacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<SoftwareArtifact> availableArtifacts;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> requirements;

	/**
	 * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' containment reference list.
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
	protected NRPImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NextReleaseProblemPackage.Literals.NRP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NextReleaseProblemPackage.NRP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Customer> getCustomers() {
		if (customers == null) {
			customers = new EObjectContainmentEList<Customer>(Customer.class, this, NextReleaseProblemPackage.NRP__CUSTOMERS);
		}
		return customers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SoftwareArtifact> getAvailableArtifacts() {
		if (availableArtifacts == null) {
			availableArtifacts = new EObjectContainmentEList<SoftwareArtifact>(SoftwareArtifact.class, this, NextReleaseProblemPackage.NRP__AVAILABLE_ARTIFACTS);
		}
		return availableArtifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList<Requirement>(Requirement.class, this, NextReleaseProblemPackage.NRP__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Solution> getSolutions() {
		if (solutions == null) {
			solutions = new EObjectContainmentEList<Solution>(Solution.class, this, NextReleaseProblemPackage.NRP__SOLUTIONS);
		}
		return solutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NextReleaseProblemPackage.NRP__CUSTOMERS:
				return ((InternalEList<?>)getCustomers()).basicRemove(otherEnd, msgs);
			case NextReleaseProblemPackage.NRP__AVAILABLE_ARTIFACTS:
				return ((InternalEList<?>)getAvailableArtifacts()).basicRemove(otherEnd, msgs);
			case NextReleaseProblemPackage.NRP__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case NextReleaseProblemPackage.NRP__SOLUTIONS:
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
			case NextReleaseProblemPackage.NRP__NAME:
				return getName();
			case NextReleaseProblemPackage.NRP__CUSTOMERS:
				return getCustomers();
			case NextReleaseProblemPackage.NRP__AVAILABLE_ARTIFACTS:
				return getAvailableArtifacts();
			case NextReleaseProblemPackage.NRP__REQUIREMENTS:
				return getRequirements();
			case NextReleaseProblemPackage.NRP__SOLUTIONS:
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
			case NextReleaseProblemPackage.NRP__NAME:
				setName((String)newValue);
				return;
			case NextReleaseProblemPackage.NRP__CUSTOMERS:
				getCustomers().clear();
				getCustomers().addAll((Collection<? extends Customer>)newValue);
				return;
			case NextReleaseProblemPackage.NRP__AVAILABLE_ARTIFACTS:
				getAvailableArtifacts().clear();
				getAvailableArtifacts().addAll((Collection<? extends SoftwareArtifact>)newValue);
				return;
			case NextReleaseProblemPackage.NRP__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case NextReleaseProblemPackage.NRP__SOLUTIONS:
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
			case NextReleaseProblemPackage.NRP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NextReleaseProblemPackage.NRP__CUSTOMERS:
				getCustomers().clear();
				return;
			case NextReleaseProblemPackage.NRP__AVAILABLE_ARTIFACTS:
				getAvailableArtifacts().clear();
				return;
			case NextReleaseProblemPackage.NRP__REQUIREMENTS:
				getRequirements().clear();
				return;
			case NextReleaseProblemPackage.NRP__SOLUTIONS:
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
			case NextReleaseProblemPackage.NRP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NextReleaseProblemPackage.NRP__CUSTOMERS:
				return customers != null && !customers.isEmpty();
			case NextReleaseProblemPackage.NRP__AVAILABLE_ARTIFACTS:
				return availableArtifacts != null && !availableArtifacts.isEmpty();
			case NextReleaseProblemPackage.NRP__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case NextReleaseProblemPackage.NRP__SOLUTIONS:
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

} //NRPImpl
