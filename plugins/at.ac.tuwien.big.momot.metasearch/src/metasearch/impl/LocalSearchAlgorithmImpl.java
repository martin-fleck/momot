/**
 */
package metasearch.impl;

import metasearch.LocalSearchAlgorithm;
import metasearch.MetasearchPackage;
import metasearch.Neighborhood;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Search Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.LocalSearchAlgorithmImpl#getNeighborhood <em>Neighborhood</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LocalSearchAlgorithmImpl extends AlgorithmImpl implements LocalSearchAlgorithm {
	/**
	 * The cached value of the '{@link #getNeighborhood() <em>Neighborhood</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeighborhood()
	 * @generated
	 * @ordered
	 */
	protected Neighborhood neighborhood;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalSearchAlgorithmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.LOCAL_SEARCH_ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Neighborhood getNeighborhood() {
		if (neighborhood != null && neighborhood.eIsProxy()) {
			InternalEObject oldNeighborhood = (InternalEObject)neighborhood;
			neighborhood = (Neighborhood)eResolveProxy(oldNeighborhood);
			if (neighborhood != oldNeighborhood) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD, oldNeighborhood, neighborhood));
			}
		}
		return neighborhood;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Neighborhood basicGetNeighborhood() {
		return neighborhood;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeighborhood(Neighborhood newNeighborhood) {
		Neighborhood oldNeighborhood = neighborhood;
		neighborhood = newNeighborhood;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD, oldNeighborhood, neighborhood));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD:
				if (resolve) return getNeighborhood();
				return basicGetNeighborhood();
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
			case MetasearchPackage.LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD:
				setNeighborhood((Neighborhood)newValue);
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
			case MetasearchPackage.LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD:
				setNeighborhood((Neighborhood)null);
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
			case MetasearchPackage.LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD:
				return neighborhood != null;
		}
		return super.eIsSet(featureID);
	}

} //LocalSearchAlgorithmImpl
