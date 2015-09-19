/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getPropertys <em>Propertys</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getEntitys <em>Entitys</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getGeneralizations <em>Generalizations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RefactoringModelImpl extends MinimalEObjectImpl.Container implements RefactoringModel {
	/**
	 * The cached value of the '{@link #getPropertys() <em>Propertys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertys()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> propertys;

	/**
	 * The cached value of the '{@link #getEntitys() <em>Entitys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitys()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> entitys;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> types;

	/**
	 * The cached value of the '{@link #getGeneralizations() <em>Generalizations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralizations()
	 * @generated
	 * @ordered
	 */
	protected EList<Generalization> generalizations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefactoringModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringPackage.Literals.REFACTORING_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getPropertys() {
		if (propertys == null) {
			propertys = new EObjectContainmentEList<Property>(Property.class, this, RefactoringPackage.REFACTORING_MODEL__PROPERTYS);
		}
		return propertys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entity> getEntitys() {
		if (entitys == null) {
			entitys = new EObjectContainmentEList<Entity>(Entity.class, this, RefactoringPackage.REFACTORING_MODEL__ENTITYS);
		}
		return entitys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<Type>(Type.class, this, RefactoringPackage.REFACTORING_MODEL__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Generalization> getGeneralizations() {
		if (generalizations == null) {
			generalizations = new EObjectContainmentEList<Generalization>(Generalization.class, this, RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS);
		}
		return generalizations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RefactoringPackage.REFACTORING_MODEL__PROPERTYS:
				return ((InternalEList<?>)getPropertys()).basicRemove(otherEnd, msgs);
			case RefactoringPackage.REFACTORING_MODEL__ENTITYS:
				return ((InternalEList<?>)getEntitys()).basicRemove(otherEnd, msgs);
			case RefactoringPackage.REFACTORING_MODEL__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
				return ((InternalEList<?>)getGeneralizations()).basicRemove(otherEnd, msgs);
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
			case RefactoringPackage.REFACTORING_MODEL__PROPERTYS:
				return getPropertys();
			case RefactoringPackage.REFACTORING_MODEL__ENTITYS:
				return getEntitys();
			case RefactoringPackage.REFACTORING_MODEL__TYPES:
				return getTypes();
			case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
				return getGeneralizations();
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
			case RefactoringPackage.REFACTORING_MODEL__PROPERTYS:
				getPropertys().clear();
				getPropertys().addAll((Collection<? extends Property>)newValue);
				return;
			case RefactoringPackage.REFACTORING_MODEL__ENTITYS:
				getEntitys().clear();
				getEntitys().addAll((Collection<? extends Entity>)newValue);
				return;
			case RefactoringPackage.REFACTORING_MODEL__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
				getGeneralizations().clear();
				getGeneralizations().addAll((Collection<? extends Generalization>)newValue);
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
			case RefactoringPackage.REFACTORING_MODEL__PROPERTYS:
				getPropertys().clear();
				return;
			case RefactoringPackage.REFACTORING_MODEL__ENTITYS:
				getEntitys().clear();
				return;
			case RefactoringPackage.REFACTORING_MODEL__TYPES:
				getTypes().clear();
				return;
			case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
				getGeneralizations().clear();
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
			case RefactoringPackage.REFACTORING_MODEL__PROPERTYS:
				return propertys != null && !propertys.isEmpty();
			case RefactoringPackage.REFACTORING_MODEL__ENTITYS:
				return entitys != null && !entitys.isEmpty();
			case RefactoringPackage.REFACTORING_MODEL__TYPES:
				return types != null && !types.isEmpty();
			case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
				return generalizations != null && !generalizations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RefactoringModelImpl
