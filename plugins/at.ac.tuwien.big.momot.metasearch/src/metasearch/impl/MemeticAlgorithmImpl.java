/**
 */
package metasearch.impl;

import metasearch.GeneticAlgorithm;
import metasearch.LocalSearchApplication;
import metasearch.MemeticAlgorithm;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memetic Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.MemeticAlgorithmImpl#getLocalsearchapplication <em>Localsearchapplication</em>}</li>
 *   <li>{@link metasearch.impl.MemeticAlgorithmImpl#getGlobalSearch <em>Global Search</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemeticAlgorithmImpl extends AlgorithmImpl implements MemeticAlgorithm {
	/**
	 * The cached value of the '{@link #getLocalsearchapplication() <em>Localsearchapplication</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalsearchapplication()
	 * @generated
	 * @ordered
	 */
	protected LocalSearchApplication localsearchapplication;

	/**
	 * The cached value of the '{@link #getGlobalSearch() <em>Global Search</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalSearch()
	 * @generated
	 * @ordered
	 */
	protected GeneticAlgorithm globalSearch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemeticAlgorithmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.MEMETIC_ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchApplication getLocalsearchapplication() {
		return localsearchapplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalsearchapplication(LocalSearchApplication newLocalsearchapplication, NotificationChain msgs) {
		LocalSearchApplication oldLocalsearchapplication = localsearchapplication;
		localsearchapplication = newLocalsearchapplication;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION, oldLocalsearchapplication, newLocalsearchapplication);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalsearchapplication(LocalSearchApplication newLocalsearchapplication) {
		if (newLocalsearchapplication != localsearchapplication) {
			NotificationChain msgs = null;
			if (localsearchapplication != null)
				msgs = ((InternalEObject)localsearchapplication).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION, null, msgs);
			if (newLocalsearchapplication != null)
				msgs = ((InternalEObject)newLocalsearchapplication).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION, null, msgs);
			msgs = basicSetLocalsearchapplication(newLocalsearchapplication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION, newLocalsearchapplication, newLocalsearchapplication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneticAlgorithm getGlobalSearch() {
		if (globalSearch != null && globalSearch.eIsProxy()) {
			InternalEObject oldGlobalSearch = (InternalEObject)globalSearch;
			globalSearch = (GeneticAlgorithm)eResolveProxy(oldGlobalSearch);
			if (globalSearch != oldGlobalSearch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.MEMETIC_ALGORITHM__GLOBAL_SEARCH, oldGlobalSearch, globalSearch));
			}
		}
		return globalSearch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneticAlgorithm basicGetGlobalSearch() {
		return globalSearch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalSearch(GeneticAlgorithm newGlobalSearch) {
		GeneticAlgorithm oldGlobalSearch = globalSearch;
		globalSearch = newGlobalSearch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.MEMETIC_ALGORITHM__GLOBAL_SEARCH, oldGlobalSearch, globalSearch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION:
				return basicSetLocalsearchapplication(null, msgs);
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
			case MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION:
				return getLocalsearchapplication();
			case MetasearchPackage.MEMETIC_ALGORITHM__GLOBAL_SEARCH:
				if (resolve) return getGlobalSearch();
				return basicGetGlobalSearch();
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
			case MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION:
				setLocalsearchapplication((LocalSearchApplication)newValue);
				return;
			case MetasearchPackage.MEMETIC_ALGORITHM__GLOBAL_SEARCH:
				setGlobalSearch((GeneticAlgorithm)newValue);
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
			case MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION:
				setLocalsearchapplication((LocalSearchApplication)null);
				return;
			case MetasearchPackage.MEMETIC_ALGORITHM__GLOBAL_SEARCH:
				setGlobalSearch((GeneticAlgorithm)null);
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
			case MetasearchPackage.MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION:
				return localsearchapplication != null;
			case MetasearchPackage.MEMETIC_ALGORITHM__GLOBAL_SEARCH:
				return globalSearch != null;
		}
		return super.eIsSet(featureID);
	}

} //MemeticAlgorithmImpl
