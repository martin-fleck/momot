/**
 */
package metasearch.impl;

import metasearch.MetasearchPackage;
import metasearch.TabuSupportingLocalSearch;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tabu Supporting Local Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.TabuSupportingLocalSearchImpl#getTabuSize <em>Tabu Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TabuSupportingLocalSearchImpl extends LocalSearchAlgorithmImpl implements TabuSupportingLocalSearch {
	/**
	 * The default value of the '{@link #getTabuSize() <em>Tabu Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTabuSize()
	 * @generated
	 * @ordered
	 */
	protected static final int TABU_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTabuSize() <em>Tabu Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTabuSize()
	 * @generated
	 * @ordered
	 */
	protected int tabuSize = TABU_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TabuSupportingLocalSearchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.TABU_SUPPORTING_LOCAL_SEARCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTabuSize() {
		return tabuSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTabuSize(int newTabuSize) {
		int oldTabuSize = tabuSize;
		tabuSize = newTabuSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE, oldTabuSize, tabuSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE:
				return getTabuSize();
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
			case MetasearchPackage.TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE:
				setTabuSize((Integer)newValue);
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
			case MetasearchPackage.TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE:
				setTabuSize(TABU_SIZE_EDEFAULT);
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
			case MetasearchPackage.TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE:
				return tabuSize != TABU_SIZE_EDEFAULT;
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
		result.append(" (tabuSize: ");
		result.append(tabuSize);
		result.append(')');
		return result.toString();
	}

} //TabuSupportingLocalSearchImpl
