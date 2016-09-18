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
import at.ac.tuwien.big.momot.examples.tse.modularization.Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl#getBindingTypes <em>Binding Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl#getInPattElTypes <em>In Patt El Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl#getBindingNavigations <em>Binding Navigations</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl#getRuleDependencies <em>Rule Dependencies</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl#getInheritsFrom <em>Inherits From</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.impl.RuleImpl#getHelperDependencies <em>Helper Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends ModuleElementImpl implements Rule {
	/**
	 * The cached value of the '{@link #getBindingTypes() <em>Binding Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> bindingTypes;

	/**
	 * The cached value of the '{@link #getInPattElTypes() <em>In Patt El Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInPattElTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> inPattElTypes;

	/**
	 * The cached value of the '{@link #getBindingNavigations() <em>Binding Navigations</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingNavigations()
	 * @generated
	 * @ordered
	 */
	protected EList<String> bindingNavigations;

	/**
	 * The cached value of the '{@link #getRuleDependencies() <em>Rule Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> ruleDependencies;

	/**
	 * The cached value of the '{@link #getInheritsFrom() <em>Inherits From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritsFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> inheritsFrom;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModularizationPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBindingTypes() {
		if (bindingTypes == null) {
			bindingTypes = new EDataTypeUniqueEList<String>(String.class, this, ModularizationPackage.RULE__BINDING_TYPES);
		}
		return bindingTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getInPattElTypes() {
		if (inPattElTypes == null) {
			inPattElTypes = new EDataTypeUniqueEList<String>(String.class, this, ModularizationPackage.RULE__IN_PATT_EL_TYPES);
		}
		return inPattElTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBindingNavigations() {
		if (bindingNavigations == null) {
			bindingNavigations = new EDataTypeUniqueEList<String>(String.class, this, ModularizationPackage.RULE__BINDING_NAVIGATIONS);
		}
		return bindingNavigations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRuleDependencies() {
		if (ruleDependencies == null) {
			ruleDependencies = new EObjectResolvingEList<Rule>(Rule.class, this, ModularizationPackage.RULE__RULE_DEPENDENCIES);
		}
		return ruleDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getInheritsFrom() {
		if (inheritsFrom == null) {
			inheritsFrom = new EObjectResolvingEList<Rule>(Rule.class, this, ModularizationPackage.RULE__INHERITS_FROM);
		}
		return inheritsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Helper> getHelperDependencies() {
		if (helperDependencies == null) {
			helperDependencies = new EObjectResolvingEList<Helper>(Helper.class, this, ModularizationPackage.RULE__HELPER_DEPENDENCIES);
		}
		return helperDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModularizationPackage.RULE__BINDING_TYPES:
				return getBindingTypes();
			case ModularizationPackage.RULE__IN_PATT_EL_TYPES:
				return getInPattElTypes();
			case ModularizationPackage.RULE__BINDING_NAVIGATIONS:
				return getBindingNavigations();
			case ModularizationPackage.RULE__RULE_DEPENDENCIES:
				return getRuleDependencies();
			case ModularizationPackage.RULE__INHERITS_FROM:
				return getInheritsFrom();
			case ModularizationPackage.RULE__HELPER_DEPENDENCIES:
				return getHelperDependencies();
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
			case ModularizationPackage.RULE__BINDING_TYPES:
				getBindingTypes().clear();
				getBindingTypes().addAll((Collection<? extends String>)newValue);
				return;
			case ModularizationPackage.RULE__IN_PATT_EL_TYPES:
				getInPattElTypes().clear();
				getInPattElTypes().addAll((Collection<? extends String>)newValue);
				return;
			case ModularizationPackage.RULE__BINDING_NAVIGATIONS:
				getBindingNavigations().clear();
				getBindingNavigations().addAll((Collection<? extends String>)newValue);
				return;
			case ModularizationPackage.RULE__RULE_DEPENDENCIES:
				getRuleDependencies().clear();
				getRuleDependencies().addAll((Collection<? extends Rule>)newValue);
				return;
			case ModularizationPackage.RULE__INHERITS_FROM:
				getInheritsFrom().clear();
				getInheritsFrom().addAll((Collection<? extends Rule>)newValue);
				return;
			case ModularizationPackage.RULE__HELPER_DEPENDENCIES:
				getHelperDependencies().clear();
				getHelperDependencies().addAll((Collection<? extends Helper>)newValue);
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
			case ModularizationPackage.RULE__BINDING_TYPES:
				getBindingTypes().clear();
				return;
			case ModularizationPackage.RULE__IN_PATT_EL_TYPES:
				getInPattElTypes().clear();
				return;
			case ModularizationPackage.RULE__BINDING_NAVIGATIONS:
				getBindingNavigations().clear();
				return;
			case ModularizationPackage.RULE__RULE_DEPENDENCIES:
				getRuleDependencies().clear();
				return;
			case ModularizationPackage.RULE__INHERITS_FROM:
				getInheritsFrom().clear();
				return;
			case ModularizationPackage.RULE__HELPER_DEPENDENCIES:
				getHelperDependencies().clear();
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
			case ModularizationPackage.RULE__BINDING_TYPES:
				return bindingTypes != null && !bindingTypes.isEmpty();
			case ModularizationPackage.RULE__IN_PATT_EL_TYPES:
				return inPattElTypes != null && !inPattElTypes.isEmpty();
			case ModularizationPackage.RULE__BINDING_NAVIGATIONS:
				return bindingNavigations != null && !bindingNavigations.isEmpty();
			case ModularizationPackage.RULE__RULE_DEPENDENCIES:
				return ruleDependencies != null && !ruleDependencies.isEmpty();
			case ModularizationPackage.RULE__INHERITS_FROM:
				return inheritsFrom != null && !inheritsFrom.isEmpty();
			case ModularizationPackage.RULE__HELPER_DEPENDENCIES:
				return helperDependencies != null && !helperDependencies.isEmpty();
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
		return "Rule '" + getName() + "'";
//		StringBuffer result = new StringBuffer(super.toString());
//		result.append(" (bindingTypes: ");
//		result.append(bindingTypes);
//		result.append(", inPattElTypes: ");
//		result.append(inPattElTypes);
//		result.append(", bindingNavigations: ");
//		result.append(bindingNavigations);
//		result.append(')');
//		return result.toString();
	}

} //RuleImpl
