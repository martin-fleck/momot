/**
 */
package metasearch.impl;

import java.util.Collection;

import metasearch.FitnessComparatorGenerator;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fitness Comparator Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.FitnessComparatorGeneratorImpl#getComparatorContainer <em>Comparator Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FitnessComparatorGeneratorImpl extends MinimalEObjectImpl.Container implements FitnessComparatorGenerator {
	/**
	 * The cached value of the '{@link #getComparatorContainer() <em>Comparator Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparatorContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<metasearch.Container> comparatorContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FitnessComparatorGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.FITNESS_COMPARATOR_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<metasearch.Container> getComparatorContainer() {
		if (comparatorContainer == null) {
			comparatorContainer = new EObjectContainmentEList<metasearch.Container>(metasearch.Container.class, this, MetasearchPackage.FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER);
		}
		return comparatorContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetasearchPackage.FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER:
				return ((InternalEList<?>)getComparatorContainer()).basicRemove(otherEnd, msgs);
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
			case MetasearchPackage.FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER:
				return getComparatorContainer();
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
			case MetasearchPackage.FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER:
				getComparatorContainer().clear();
				getComparatorContainer().addAll((Collection<? extends metasearch.Container>)newValue);
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
			case MetasearchPackage.FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER:
				getComparatorContainer().clear();
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
			case MetasearchPackage.FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER:
				return comparatorContainer != null && !comparatorContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FitnessComparatorGeneratorImpl
