/**
 */
package metasearch.impl;

import java.util.Collection;

import metasearch.Algorithm;
import metasearch.MetasearchPackage;
import metasearch.Neighborhood;
import metasearch.SolutionInitializer;

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
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.ContainerImpl#getUsedAlgorithm <em>Used Algorithm</em>}</li>
 *   <li>{@link metasearch.impl.ContainerImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link metasearch.impl.ContainerImpl#getNeighborhood <em>Neighborhood</em>}</li>
 *   <li>{@link metasearch.impl.ContainerImpl#getSolutioninitializer <em>Solutioninitializer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainerImpl extends MinimalEObjectImpl.Container implements metasearch.Container {
	/**
	 * The cached value of the '{@link #getUsedAlgorithm() <em>Used Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected Algorithm usedAlgorithm;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected EList<Algorithm> algorithm;

	/**
	 * The cached value of the '{@link #getNeighborhood() <em>Neighborhood</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeighborhood()
	 * @generated
	 * @ordered
	 */
	protected EList<Neighborhood> neighborhood;

	/**
	 * The cached value of the '{@link #getSolutioninitializer() <em>Solutioninitializer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutioninitializer()
	 * @generated
	 * @ordered
	 */
	protected EList<SolutionInitializer> solutioninitializer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Algorithm getUsedAlgorithm() {
		if (usedAlgorithm != null && usedAlgorithm.eIsProxy()) {
			InternalEObject oldUsedAlgorithm = (InternalEObject)usedAlgorithm;
			usedAlgorithm = (Algorithm)eResolveProxy(oldUsedAlgorithm);
			if (usedAlgorithm != oldUsedAlgorithm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.CONTAINER__USED_ALGORITHM, oldUsedAlgorithm, usedAlgorithm));
			}
		}
		return usedAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Algorithm basicGetUsedAlgorithm() {
		return usedAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedAlgorithm(Algorithm newUsedAlgorithm) {
		Algorithm oldUsedAlgorithm = usedAlgorithm;
		usedAlgorithm = newUsedAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.CONTAINER__USED_ALGORITHM, oldUsedAlgorithm, usedAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Algorithm> getAlgorithm() {
		if (algorithm == null) {
			algorithm = new EObjectContainmentEList<Algorithm>(Algorithm.class, this, MetasearchPackage.CONTAINER__ALGORITHM);
		}
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Neighborhood> getNeighborhood() {
		if (neighborhood == null) {
			neighborhood = new EObjectContainmentEList<Neighborhood>(Neighborhood.class, this, MetasearchPackage.CONTAINER__NEIGHBORHOOD);
		}
		return neighborhood;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SolutionInitializer> getSolutioninitializer() {
		if (solutioninitializer == null) {
			solutioninitializer = new EObjectContainmentEList<SolutionInitializer>(SolutionInitializer.class, this, MetasearchPackage.CONTAINER__SOLUTIONINITIALIZER);
		}
		return solutioninitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetasearchPackage.CONTAINER__ALGORITHM:
				return ((InternalEList<?>)getAlgorithm()).basicRemove(otherEnd, msgs);
			case MetasearchPackage.CONTAINER__NEIGHBORHOOD:
				return ((InternalEList<?>)getNeighborhood()).basicRemove(otherEnd, msgs);
			case MetasearchPackage.CONTAINER__SOLUTIONINITIALIZER:
				return ((InternalEList<?>)getSolutioninitializer()).basicRemove(otherEnd, msgs);
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
			case MetasearchPackage.CONTAINER__USED_ALGORITHM:
				if (resolve) return getUsedAlgorithm();
				return basicGetUsedAlgorithm();
			case MetasearchPackage.CONTAINER__ALGORITHM:
				return getAlgorithm();
			case MetasearchPackage.CONTAINER__NEIGHBORHOOD:
				return getNeighborhood();
			case MetasearchPackage.CONTAINER__SOLUTIONINITIALIZER:
				return getSolutioninitializer();
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
			case MetasearchPackage.CONTAINER__USED_ALGORITHM:
				setUsedAlgorithm((Algorithm)newValue);
				return;
			case MetasearchPackage.CONTAINER__ALGORITHM:
				getAlgorithm().clear();
				getAlgorithm().addAll((Collection<? extends Algorithm>)newValue);
				return;
			case MetasearchPackage.CONTAINER__NEIGHBORHOOD:
				getNeighborhood().clear();
				getNeighborhood().addAll((Collection<? extends Neighborhood>)newValue);
				return;
			case MetasearchPackage.CONTAINER__SOLUTIONINITIALIZER:
				getSolutioninitializer().clear();
				getSolutioninitializer().addAll((Collection<? extends SolutionInitializer>)newValue);
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
			case MetasearchPackage.CONTAINER__USED_ALGORITHM:
				setUsedAlgorithm((Algorithm)null);
				return;
			case MetasearchPackage.CONTAINER__ALGORITHM:
				getAlgorithm().clear();
				return;
			case MetasearchPackage.CONTAINER__NEIGHBORHOOD:
				getNeighborhood().clear();
				return;
			case MetasearchPackage.CONTAINER__SOLUTIONINITIALIZER:
				getSolutioninitializer().clear();
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
			case MetasearchPackage.CONTAINER__USED_ALGORITHM:
				return usedAlgorithm != null;
			case MetasearchPackage.CONTAINER__ALGORITHM:
				return algorithm != null && !algorithm.isEmpty();
			case MetasearchPackage.CONTAINER__NEIGHBORHOOD:
				return neighborhood != null && !neighborhood.isEmpty();
			case MetasearchPackage.CONTAINER__SOLUTIONINITIALIZER:
				return solutioninitializer != null && !solutioninitializer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ContainerImpl
