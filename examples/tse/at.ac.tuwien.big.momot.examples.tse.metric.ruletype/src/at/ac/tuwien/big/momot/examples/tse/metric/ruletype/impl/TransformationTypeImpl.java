/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.TransformationTypeImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.TransformationTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.TransformationTypeImpl#getMms <em>Mms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationTypeImpl extends MinimalEObjectImpl.Container implements TransformationType {
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleType> rules;

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
	 * The cached value of the '{@link #getMms() <em>Mms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMms()
	 * @generated
	 * @ordered
	 */
	protected EList<MMNames> mms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuleTypePackage.Literals.TRANSFORMATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RuleType> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<RuleType>(RuleType.class, this, RuleTypePackage.TRANSFORMATION_TYPE__RULES);
		}
		return rules;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RuleTypePackage.TRANSFORMATION_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MMNames> getMms() {
		if (mms == null) {
			mms = new EObjectContainmentWithInverseEList<MMNames>(MMNames.class, this, RuleTypePackage.TRANSFORMATION_TYPE__MMS, RuleTypePackage.MM_NAMES__TRAFO);
		}
		return mms;
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
			case RuleTypePackage.TRANSFORMATION_TYPE__MMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMms()).basicAdd(otherEnd, msgs);
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
			case RuleTypePackage.TRANSFORMATION_TYPE__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case RuleTypePackage.TRANSFORMATION_TYPE__MMS:
				return ((InternalEList<?>)getMms()).basicRemove(otherEnd, msgs);
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
			case RuleTypePackage.TRANSFORMATION_TYPE__RULES:
				return getRules();
			case RuleTypePackage.TRANSFORMATION_TYPE__NAME:
				return getName();
			case RuleTypePackage.TRANSFORMATION_TYPE__MMS:
				return getMms();
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
			case RuleTypePackage.TRANSFORMATION_TYPE__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends RuleType>)newValue);
				return;
			case RuleTypePackage.TRANSFORMATION_TYPE__NAME:
				setName((String)newValue);
				return;
			case RuleTypePackage.TRANSFORMATION_TYPE__MMS:
				getMms().clear();
				getMms().addAll((Collection<? extends MMNames>)newValue);
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
			case RuleTypePackage.TRANSFORMATION_TYPE__RULES:
				getRules().clear();
				return;
			case RuleTypePackage.TRANSFORMATION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RuleTypePackage.TRANSFORMATION_TYPE__MMS:
				getMms().clear();
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
			case RuleTypePackage.TRANSFORMATION_TYPE__RULES:
				return rules != null && !rules.isEmpty();
			case RuleTypePackage.TRANSFORMATION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RuleTypePackage.TRANSFORMATION_TYPE__MMS:
				return mms != null && !mms.isEmpty();
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

} //TransformationTypeImpl
