/**
 */
package metasearch.impl;

import metasearch.MetasearchPackage;
import metasearch.SimulatedAnnealing;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulated Annealing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.SimulatedAnnealingImpl#getStartTemp <em>Start Temp</em>}</li>
 *   <li>{@link metasearch.impl.SimulatedAnnealingImpl#getTempIncrease <em>Temp Increase</em>}</li>
 *   <li>{@link metasearch.impl.SimulatedAnnealingImpl#getRestartNoCurrentImp <em>Restart No Current Imp</em>}</li>
 *   <li>{@link metasearch.impl.SimulatedAnnealingImpl#getRestartNoBestImp <em>Restart No Best Imp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulatedAnnealingImpl extends TabuSupportingLocalSearchImpl implements SimulatedAnnealing {
	/**
	 * The default value of the '{@link #getStartTemp() <em>Start Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTemp()
	 * @generated
	 * @ordered
	 */
	protected static final double START_TEMP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStartTemp() <em>Start Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTemp()
	 * @generated
	 * @ordered
	 */
	protected double startTemp = START_TEMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getTempIncrease() <em>Temp Increase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempIncrease()
	 * @generated
	 * @ordered
	 */
	protected static final double TEMP_INCREASE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTempIncrease() <em>Temp Increase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempIncrease()
	 * @generated
	 * @ordered
	 */
	protected double tempIncrease = TEMP_INCREASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRestartNoCurrentImp() <em>Restart No Current Imp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestartNoCurrentImp()
	 * @generated
	 * @ordered
	 */
	protected static final int RESTART_NO_CURRENT_IMP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRestartNoCurrentImp() <em>Restart No Current Imp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestartNoCurrentImp()
	 * @generated
	 * @ordered
	 */
	protected int restartNoCurrentImp = RESTART_NO_CURRENT_IMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getRestartNoBestImp() <em>Restart No Best Imp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestartNoBestImp()
	 * @generated
	 * @ordered
	 */
	protected static final int RESTART_NO_BEST_IMP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRestartNoBestImp() <em>Restart No Best Imp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestartNoBestImp()
	 * @generated
	 * @ordered
	 */
	protected int restartNoBestImp = RESTART_NO_BEST_IMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulatedAnnealingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.SIMULATED_ANNEALING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStartTemp() {
		return startTemp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTemp(double newStartTemp) {
		double oldStartTemp = startTemp;
		startTemp = newStartTemp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.SIMULATED_ANNEALING__START_TEMP, oldStartTemp, startTemp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTempIncrease() {
		return tempIncrease;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempIncrease(double newTempIncrease) {
		double oldTempIncrease = tempIncrease;
		tempIncrease = newTempIncrease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.SIMULATED_ANNEALING__TEMP_INCREASE, oldTempIncrease, tempIncrease));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRestartNoCurrentImp() {
		return restartNoCurrentImp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestartNoCurrentImp(int newRestartNoCurrentImp) {
		int oldRestartNoCurrentImp = restartNoCurrentImp;
		restartNoCurrentImp = newRestartNoCurrentImp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP, oldRestartNoCurrentImp, restartNoCurrentImp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRestartNoBestImp() {
		return restartNoBestImp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestartNoBestImp(int newRestartNoBestImp) {
		int oldRestartNoBestImp = restartNoBestImp;
		restartNoBestImp = newRestartNoBestImp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_BEST_IMP, oldRestartNoBestImp, restartNoBestImp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.SIMULATED_ANNEALING__START_TEMP:
				return getStartTemp();
			case MetasearchPackage.SIMULATED_ANNEALING__TEMP_INCREASE:
				return getTempIncrease();
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP:
				return getRestartNoCurrentImp();
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_BEST_IMP:
				return getRestartNoBestImp();
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
			case MetasearchPackage.SIMULATED_ANNEALING__START_TEMP:
				setStartTemp((Double)newValue);
				return;
			case MetasearchPackage.SIMULATED_ANNEALING__TEMP_INCREASE:
				setTempIncrease((Double)newValue);
				return;
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP:
				setRestartNoCurrentImp((Integer)newValue);
				return;
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_BEST_IMP:
				setRestartNoBestImp((Integer)newValue);
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
			case MetasearchPackage.SIMULATED_ANNEALING__START_TEMP:
				setStartTemp(START_TEMP_EDEFAULT);
				return;
			case MetasearchPackage.SIMULATED_ANNEALING__TEMP_INCREASE:
				setTempIncrease(TEMP_INCREASE_EDEFAULT);
				return;
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP:
				setRestartNoCurrentImp(RESTART_NO_CURRENT_IMP_EDEFAULT);
				return;
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_BEST_IMP:
				setRestartNoBestImp(RESTART_NO_BEST_IMP_EDEFAULT);
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
			case MetasearchPackage.SIMULATED_ANNEALING__START_TEMP:
				return startTemp != START_TEMP_EDEFAULT;
			case MetasearchPackage.SIMULATED_ANNEALING__TEMP_INCREASE:
				return tempIncrease != TEMP_INCREASE_EDEFAULT;
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP:
				return restartNoCurrentImp != RESTART_NO_CURRENT_IMP_EDEFAULT;
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_BEST_IMP:
				return restartNoBestImp != RESTART_NO_BEST_IMP_EDEFAULT;
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
		result.append(" (startTemp: ");
		result.append(startTemp);
		result.append(", tempIncrease: ");
		result.append(tempIncrease);
		result.append(", restartNoCurrentImp: ");
		result.append(restartNoCurrentImp);
		result.append(", restartNoBestImp: ");
		result.append(restartNoBestImp);
		result.append(')');
		return result.toString();
	}

} //SimulatedAnnealingImpl
