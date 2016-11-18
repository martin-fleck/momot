/**
 */
package metasearch.impl;

import metasearch.ChangingNeighborhood;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Changing Neighborhood</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.ChangingNeighborhoodImpl#getDeleteProbability <em>Delete Probability</em>}</li>
 *   <li>{@link metasearch.impl.ChangingNeighborhoodImpl#getAtEndProbability <em>At End Probability</em>}</li>
 *   <li>{@link metasearch.impl.ChangingNeighborhoodImpl#getModifyRuleProbability <em>Modify Rule Probability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChangingNeighborhoodImpl extends NeighborhoodImpl implements ChangingNeighborhood {
	/**
	 * The default value of the '{@link #getDeleteProbability() <em>Delete Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeleteProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double DELETE_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDeleteProbability() <em>Delete Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeleteProbability()
	 * @generated
	 * @ordered
	 */
	protected double deleteProbability = DELETE_PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAtEndProbability() <em>At End Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtEndProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double AT_END_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAtEndProbability() <em>At End Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtEndProbability()
	 * @generated
	 * @ordered
	 */
	protected double atEndProbability = AT_END_PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getModifyRuleProbability() <em>Modify Rule Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifyRuleProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double MODIFY_RULE_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getModifyRuleProbability() <em>Modify Rule Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifyRuleProbability()
	 * @generated
	 * @ordered
	 */
	protected double modifyRuleProbability = MODIFY_RULE_PROBABILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangingNeighborhoodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.CHANGING_NEIGHBORHOOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDeleteProbability() {
		return deleteProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeleteProbability(double newDeleteProbability) {
		double oldDeleteProbability = deleteProbability;
		deleteProbability = newDeleteProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY, oldDeleteProbability, deleteProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAtEndProbability() {
		return atEndProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtEndProbability(double newAtEndProbability) {
		double oldAtEndProbability = atEndProbability;
		atEndProbability = newAtEndProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY, oldAtEndProbability, atEndProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getModifyRuleProbability() {
		return modifyRuleProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifyRuleProbability(double newModifyRuleProbability) {
		double oldModifyRuleProbability = modifyRuleProbability;
		modifyRuleProbability = newModifyRuleProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY, oldModifyRuleProbability, modifyRuleProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY:
				return getDeleteProbability();
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY:
				return getAtEndProbability();
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY:
				return getModifyRuleProbability();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY:
				setDeleteProbability((Double)newValue);
				return;
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY:
				setAtEndProbability((Double)newValue);
				return;
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY:
				setModifyRuleProbability((Double)newValue);
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
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY:
				setDeleteProbability(DELETE_PROBABILITY_EDEFAULT);
				return;
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY:
				setAtEndProbability(AT_END_PROBABILITY_EDEFAULT);
				return;
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY:
				setModifyRuleProbability(MODIFY_RULE_PROBABILITY_EDEFAULT);
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
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY:
				return deleteProbability != DELETE_PROBABILITY_EDEFAULT;
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY:
				return atEndProbability != AT_END_PROBABILITY_EDEFAULT;
			case MetasearchPackage.CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY:
				return modifyRuleProbability != MODIFY_RULE_PROBABILITY_EDEFAULT;
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
		result.append(" (deleteProbability: ");
		result.append(deleteProbability);
		result.append(", atEndProbability: ");
		result.append(atEndProbability);
		result.append(", modifyRuleProbability: ");
		result.append(modifyRuleProbability);
		result.append(')');
		return result.toString();
	}

} //ChangingNeighborhoodImpl
