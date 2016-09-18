/**
 */
package at.ac.tuwien.big.momot.examples.tse.modularization.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import at.ac.tuwien.big.momot.examples.tse.modularization.Helper;
import at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.HelperImpl#getHelperDependencies <em>Helper Dependencies</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.HelperImpl#getHelperDepNames <em>Helper Dep Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HelperImpl extends ModuleElementImpl implements Helper {
	/**
	 * The cached value of the '{@link #getHelperDependencies() <em>Helper Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelperDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Helper> helperDependencies;

	/**
	 * The cached value of the '{@link #getHelperDepNames() <em>Helper Dep Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelperDepNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> helperDepNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModularizationPackage.Literals.HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Helper> getHelperDependencies() {
		if (helperDependencies == null) {
			helperDependencies = new EObjectResolvingEList<Helper>(Helper.class, this, ModularizationPackage.HELPER__HELPER_DEPENDENCIES);
		}
		return helperDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getHelperDepNames() {
		if (helperDepNames == null) {
			helperDepNames = new EDataTypeUniqueEList<String>(String.class, this, ModularizationPackage.HELPER__HELPER_DEP_NAMES);
		}
		return helperDepNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModularizationPackage.HELPER__HELPER_DEPENDENCIES:
				return getHelperDependencies();
			case ModularizationPackage.HELPER__HELPER_DEP_NAMES:
				return getHelperDepNames();
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
			case ModularizationPackage.HELPER__HELPER_DEPENDENCIES:
				getHelperDependencies().clear();
				getHelperDependencies().addAll((Collection<? extends Helper>)newValue);
				return;
			case ModularizationPackage.HELPER__HELPER_DEP_NAMES:
				getHelperDepNames().clear();
				getHelperDepNames().addAll((Collection<? extends String>)newValue);
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
			case ModularizationPackage.HELPER__HELPER_DEPENDENCIES:
				getHelperDependencies().clear();
				return;
			case ModularizationPackage.HELPER__HELPER_DEP_NAMES:
				getHelperDepNames().clear();
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
			case ModularizationPackage.HELPER__HELPER_DEPENDENCIES:
				return helperDependencies != null && !helperDependencies.isEmpty();
			case ModularizationPackage.HELPER__HELPER_DEP_NAMES:
				return helperDepNames != null && !helperDepNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		return "Helper '" + getName() + "'";
//		StringBuffer result = new StringBuffer(super.toString());
//		result.append(" (helperDepNames: ");
//		result.append(helperDepNames);
//		result.append(')');
//		return result.toString();
	}

} //HelperImpl
