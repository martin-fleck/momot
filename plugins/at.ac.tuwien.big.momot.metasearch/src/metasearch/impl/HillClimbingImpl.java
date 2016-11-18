/**
 */
package metasearch.impl;

import metasearch.HillClimbing;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hill Climbing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.HillClimbingImpl#getNeighborsize <em>Neighborsize</em>}</li>
 *   <li>{@link metasearch.impl.HillClimbingImpl#isNextImprovement <em>Next Improvement</em>}</li>
 *   <li>{@link metasearch.impl.HillClimbingImpl#getMaxNoImprovement <em>Max No Improvement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HillClimbingImpl extends TabuSupportingLocalSearchImpl implements HillClimbing {
	/**
	 * The default value of the '{@link #getNeighborsize() <em>Neighborsize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeighborsize()
	 * @generated
	 * @ordered
	 */
	protected static final int NEIGHBORSIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNeighborsize() <em>Neighborsize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeighborsize()
	 * @generated
	 * @ordered
	 */
	protected int neighborsize = NEIGHBORSIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isNextImprovement() <em>Next Improvement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNextImprovement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEXT_IMPROVEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNextImprovement() <em>Next Improvement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNextImprovement()
	 * @generated
	 * @ordered
	 */
	protected boolean nextImprovement = NEXT_IMPROVEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxNoImprovement() <em>Max No Improvement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNoImprovement()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_NO_IMPROVEMENT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxNoImprovement() <em>Max No Improvement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNoImprovement()
	 * @generated
	 * @ordered
	 */
	protected int maxNoImprovement = MAX_NO_IMPROVEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HillClimbingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.HILL_CLIMBING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNeighborsize() {
		return neighborsize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeighborsize(int newNeighborsize) {
		int oldNeighborsize = neighborsize;
		neighborsize = newNeighborsize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.HILL_CLIMBING__NEIGHBORSIZE, oldNeighborsize, neighborsize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNextImprovement() {
		return nextImprovement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextImprovement(boolean newNextImprovement) {
		boolean oldNextImprovement = nextImprovement;
		nextImprovement = newNextImprovement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.HILL_CLIMBING__NEXT_IMPROVEMENT, oldNextImprovement, nextImprovement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxNoImprovement() {
		return maxNoImprovement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxNoImprovement(int newMaxNoImprovement) {
		int oldMaxNoImprovement = maxNoImprovement;
		maxNoImprovement = newMaxNoImprovement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.HILL_CLIMBING__MAX_NO_IMPROVEMENT, oldMaxNoImprovement, maxNoImprovement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.HILL_CLIMBING__NEIGHBORSIZE:
				return getNeighborsize();
			case MetasearchPackage.HILL_CLIMBING__NEXT_IMPROVEMENT:
				return isNextImprovement();
			case MetasearchPackage.HILL_CLIMBING__MAX_NO_IMPROVEMENT:
				return getMaxNoImprovement();
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
			case MetasearchPackage.HILL_CLIMBING__NEIGHBORSIZE:
				setNeighborsize((Integer)newValue);
				return;
			case MetasearchPackage.HILL_CLIMBING__NEXT_IMPROVEMENT:
				setNextImprovement((Boolean)newValue);
				return;
			case MetasearchPackage.HILL_CLIMBING__MAX_NO_IMPROVEMENT:
				setMaxNoImprovement((Integer)newValue);
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
			case MetasearchPackage.HILL_CLIMBING__NEIGHBORSIZE:
				setNeighborsize(NEIGHBORSIZE_EDEFAULT);
				return;
			case MetasearchPackage.HILL_CLIMBING__NEXT_IMPROVEMENT:
				setNextImprovement(NEXT_IMPROVEMENT_EDEFAULT);
				return;
			case MetasearchPackage.HILL_CLIMBING__MAX_NO_IMPROVEMENT:
				setMaxNoImprovement(MAX_NO_IMPROVEMENT_EDEFAULT);
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
			case MetasearchPackage.HILL_CLIMBING__NEIGHBORSIZE:
				return neighborsize != NEIGHBORSIZE_EDEFAULT;
			case MetasearchPackage.HILL_CLIMBING__NEXT_IMPROVEMENT:
				return nextImprovement != NEXT_IMPROVEMENT_EDEFAULT;
			case MetasearchPackage.HILL_CLIMBING__MAX_NO_IMPROVEMENT:
				return maxNoImprovement != MAX_NO_IMPROVEMENT_EDEFAULT;
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
		result.append(" (neighborsize: ");
		result.append(neighborsize);
		result.append(", nextImprovement: ");
		result.append(nextImprovement);
		result.append(", maxNoImprovement: ");
		result.append(maxNoImprovement);
		result.append(')');
		return result.toString();
	}

} //HillClimbingImpl
