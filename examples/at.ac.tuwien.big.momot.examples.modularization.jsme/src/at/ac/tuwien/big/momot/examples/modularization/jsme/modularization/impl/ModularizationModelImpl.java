/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl.ModularizationModelImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl.ModularizationModelImpl#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModularizationModelImpl extends NamedElementImpl implements ModularizationModel {
	private static final long serialVersionUID = 1607103824925593623L;

	/**
	 * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModules()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> modules;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> classes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModularizationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModularizationPackage.Literals.MODULARIZATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getModules() {
		if (modules == null) {
			modules = new EObjectContainmentEList<Module>(Module.class, this, ModularizationPackage.MODULARIZATION_MODEL__MODULES);
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class>(at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class.class, this, ModularizationPackage.MODULARIZATION_MODEL__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModularizationPackage.MODULARIZATION_MODEL__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
			case ModularizationPackage.MODULARIZATION_MODEL__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
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
			case ModularizationPackage.MODULARIZATION_MODEL__MODULES:
				return getModules();
			case ModularizationPackage.MODULARIZATION_MODEL__CLASSES:
				return getClasses();
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
			case ModularizationPackage.MODULARIZATION_MODEL__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends Module>)newValue);
				return;
			case ModularizationPackage.MODULARIZATION_MODEL__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class>)newValue);
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
			case ModularizationPackage.MODULARIZATION_MODEL__MODULES:
				getModules().clear();
				return;
			case ModularizationPackage.MODULARIZATION_MODEL__CLASSES:
				getClasses().clear();
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
			case ModularizationPackage.MODULARIZATION_MODEL__MODULES:
				return modules != null && !modules.isEmpty();
			case ModularizationPackage.MODULARIZATION_MODEL__CLASSES:
				return classes != null && !classes.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nModularizationModel '" + getName() + "' {\n");
		for(Module module : getModules()) {
			sb.append("  Module '" + module.getName() + "':\n");
			for(Class clazz : module.getClasses()) {
				sb.append("    " + clazz.getName() + getDependencies(clazz) + "\n");
			}
		}
		sb.append("  Unassigned:\n");
		for(Class clazz : getClasses()) {
			if(clazz.getModule() == null)
				sb.append("    " + clazz.getName() + getDependencies(clazz) + "\n");
		}
		sb.append("}");
		return sb.toString();
	}
	
	protected String getDependencies(Class clazz) {
		StringBuilder sb = new StringBuilder();
		sb.append(" [ ");
		for(Class c : clazz.getDependsOn())
			sb.append(c.getName() + " ");
		sb.append("]");
		return sb.toString();
	}

} //ModularizationModelImpl
