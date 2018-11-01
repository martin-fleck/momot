/**
 */
package nextReleaseProblem.impl;

import java.util.Collection;

import nextReleaseProblem.Customer;
import nextReleaseProblem.NextReleaseProblemPackage;
import nextReleaseProblem.Valuation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.impl.CustomerImpl#getName <em>Name</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.CustomerImpl#getImportance <em>Importance</em>}</li>
 *   <li>{@link nextReleaseProblem.impl.CustomerImpl#getAssigns <em>Assigns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CustomerImpl extends MinimalEObjectImpl.Container implements Customer {
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
	 * The default value of the '{@link #getImportance() <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportance()
	 * @generated
	 * @ordered
	 */
	protected static final double IMPORTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getImportance() <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportance()
	 * @generated
	 * @ordered
	 */
	protected double importance = IMPORTANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssigns() <em>Assigns</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssigns()
	 * @generated
	 * @ordered
	 */
	protected EList<Valuation> assigns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NextReleaseProblemPackage.Literals.CUSTOMER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NextReleaseProblemPackage.CUSTOMER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getImportance() {
		return importance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportance(double newImportance) {
		double oldImportance = importance;
		importance = newImportance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NextReleaseProblemPackage.CUSTOMER__IMPORTANCE, oldImportance, importance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Valuation> getAssigns() {
		if (assigns == null) {
			assigns = new EObjectWithInverseResolvingEList.ManyInverse<Valuation>(Valuation.class, this, NextReleaseProblemPackage.CUSTOMER__ASSIGNS, NextReleaseProblemPackage.VALUATION__ASSIGNED_BY);
		}
		return assigns;
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
			case NextReleaseProblemPackage.CUSTOMER__ASSIGNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssigns()).basicAdd(otherEnd, msgs);
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
			case NextReleaseProblemPackage.CUSTOMER__ASSIGNS:
				return ((InternalEList<?>)getAssigns()).basicRemove(otherEnd, msgs);
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
			case NextReleaseProblemPackage.CUSTOMER__NAME:
				return getName();
			case NextReleaseProblemPackage.CUSTOMER__IMPORTANCE:
				return getImportance();
			case NextReleaseProblemPackage.CUSTOMER__ASSIGNS:
				return getAssigns();
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
			case NextReleaseProblemPackage.CUSTOMER__NAME:
				setName((String)newValue);
				return;
			case NextReleaseProblemPackage.CUSTOMER__IMPORTANCE:
				setImportance((Double)newValue);
				return;
			case NextReleaseProblemPackage.CUSTOMER__ASSIGNS:
				getAssigns().clear();
				getAssigns().addAll((Collection<? extends Valuation>)newValue);
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
			case NextReleaseProblemPackage.CUSTOMER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NextReleaseProblemPackage.CUSTOMER__IMPORTANCE:
				setImportance(IMPORTANCE_EDEFAULT);
				return;
			case NextReleaseProblemPackage.CUSTOMER__ASSIGNS:
				getAssigns().clear();
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
			case NextReleaseProblemPackage.CUSTOMER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NextReleaseProblemPackage.CUSTOMER__IMPORTANCE:
				return importance != IMPORTANCE_EDEFAULT;
			case NextReleaseProblemPackage.CUSTOMER__ASSIGNS:
				return assigns != null && !assigns.isEmpty();
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
		result.append(", importance: ");
		result.append(importance);
		result.append(')');
		return result.toString();
	}

} //CustomerImpl
