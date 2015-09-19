/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl;

import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage;
import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature;
import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.SoftwareModelImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.SoftwareModelImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SoftwareModelImpl extends NamedElementImpl implements SoftwareModel {
	private static final long serialVersionUID = 5535194219885102177L;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class> classes;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.SOFTWARE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class>(at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class.class, this, ArchitecturePackage.SOFTWARE_MODEL__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, ArchitecturePackage.SOFTWARE_MODEL__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.SOFTWARE_MODEL__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.SOFTWARE_MODEL__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case ArchitecturePackage.SOFTWARE_MODEL__CLASSES:
				return getClasses();
			case ArchitecturePackage.SOFTWARE_MODEL__FEATURES:
				return getFeatures();
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
			case ArchitecturePackage.SOFTWARE_MODEL__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class>)newValue);
				return;
			case ArchitecturePackage.SOFTWARE_MODEL__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case ArchitecturePackage.SOFTWARE_MODEL__CLASSES:
				getClasses().clear();
				return;
			case ArchitecturePackage.SOFTWARE_MODEL__FEATURES:
				getFeatures().clear();
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
			case ArchitecturePackage.SOFTWARE_MODEL__CLASSES:
				return classes != null && !classes.isEmpty();
			case ArchitecturePackage.SOFTWARE_MODEL__FEATURES:
				return features != null && !features.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SoftwareModelImpl
