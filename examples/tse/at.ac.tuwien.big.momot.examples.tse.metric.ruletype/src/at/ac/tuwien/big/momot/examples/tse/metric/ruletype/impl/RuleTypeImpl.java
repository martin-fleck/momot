/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getInherits <em>Inherits</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getInFeatures <em>In Features</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getInTypes <em>In Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getOutTypes <em>Out Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getOutFeaturesImperative <em>Out Features Imperative</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getAllNavigationPaths <em>All Navigation Paths</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getBindingFeatures <em>Binding Features</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getAllFootPrints <em>All Foot Prints</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeImpl#getOutFeatures <em>Out Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleTypeImpl extends MinimalEObjectImpl.Container implements RuleType {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInherits() <em>Inherits</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInherits()
	 * @generated
	 * @ordered
	 */
	protected RuleType inherits;

	/**
	 * The cached value of the '{@link #getInFeatures() <em>In Features</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<String> inFeatures;

	/**
	 * The cached value of the '{@link #getInTypes() <em>In Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> inTypes;

	/**
	 * The cached value of the '{@link #getOutTypes() <em>Out Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> outTypes;

	/**
	 * The cached value of the '{@link #getOutFeaturesImperative() <em>Out Features Imperative</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutFeaturesImperative()
	 * @generated
	 * @ordered
	 */
	protected EList<String> outFeaturesImperative;

	/**
	 * The cached value of the '{@link #getAllNavigationPaths() <em>All Navigation Paths</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllNavigationPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<String> allNavigationPaths;

	/**
	 * The cached value of the '{@link #getBindingFeatures() <em>Binding Features</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<String> bindingFeatures;

	/**
	 * The cached value of the '{@link #getAllFootPrints() <em>All Foot Prints</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllFootPrints()
	 * @generated
	 * @ordered
	 */
	protected EList<String> allFootPrints;

	/**
	 * The cached value of the '{@link #getOutFeatures() <em>Out Features</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<String> outFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuleTypePackage.Literals.RULE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleTypePackage.RULE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleType getInherits() {
		if (inherits != null && inherits.eIsProxy()) {
			InternalEObject oldInherits = (InternalEObject)inherits;
			inherits = (RuleType)eResolveProxy(oldInherits);
			if (inherits != oldInherits) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuleTypePackage.RULE_TYPE__INHERITS, oldInherits, inherits));
			}
		}
		return inherits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleType basicGetInherits() {
		return inherits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInherits(RuleType newInherits) {
		RuleType oldInherits = inherits;
		inherits = newInherits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleTypePackage.RULE_TYPE__INHERITS, oldInherits, inherits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getInFeatures() {
		if (inFeatures == null) {
			inFeatures = new EDataTypeEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__IN_FEATURES);
		}
		return inFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getInTypes() {
		if (inTypes == null) {
			inTypes = new EDataTypeUniqueEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__IN_TYPES);
		}
		return inTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOutTypes() {
		if (outTypes == null) {
			outTypes = new EDataTypeUniqueEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__OUT_TYPES);
		}
		return outTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOutFeaturesImperative() {
		if (outFeaturesImperative == null) {
			outFeaturesImperative = new EDataTypeEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__OUT_FEATURES_IMPERATIVE);
		}
		return outFeaturesImperative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAllNavigationPaths() {
		if (allNavigationPaths == null) {
			allNavigationPaths = new EDataTypeUniqueEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__ALL_NAVIGATION_PATHS);
		}
		return allNavigationPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBindingFeatures() {
		if (bindingFeatures == null) {
			bindingFeatures = new EDataTypeEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__BINDING_FEATURES);
		}
		return bindingFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAllFootPrints() {
		if (allFootPrints == null) {
			allFootPrints = new EDataTypeUniqueEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__ALL_FOOT_PRINTS);
		}
		return allFootPrints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOutFeatures() {
		if (outFeatures == null) {
			outFeatures = new EDataTypeEList<String>(String.class, this, RuleTypePackage.RULE_TYPE__OUT_FEATURES);
		}
		return outFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuleTypePackage.RULE_TYPE__NAME:
				return getName();
			case RuleTypePackage.RULE_TYPE__INHERITS:
				if (resolve) return getInherits();
				return basicGetInherits();
			case RuleTypePackage.RULE_TYPE__IN_FEATURES:
				return getInFeatures();
			case RuleTypePackage.RULE_TYPE__IN_TYPES:
				return getInTypes();
			case RuleTypePackage.RULE_TYPE__OUT_TYPES:
				return getOutTypes();
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES_IMPERATIVE:
				return getOutFeaturesImperative();
			case RuleTypePackage.RULE_TYPE__ALL_NAVIGATION_PATHS:
				return getAllNavigationPaths();
			case RuleTypePackage.RULE_TYPE__BINDING_FEATURES:
				return getBindingFeatures();
			case RuleTypePackage.RULE_TYPE__ALL_FOOT_PRINTS:
				return getAllFootPrints();
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES:
				return getOutFeatures();
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
			case RuleTypePackage.RULE_TYPE__NAME:
				setName((String)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__INHERITS:
				setInherits((RuleType)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__IN_FEATURES:
				getInFeatures().clear();
				getInFeatures().addAll((Collection<? extends String>)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__IN_TYPES:
				getInTypes().clear();
				getInTypes().addAll((Collection<? extends String>)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__OUT_TYPES:
				getOutTypes().clear();
				getOutTypes().addAll((Collection<? extends String>)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES_IMPERATIVE:
				getOutFeaturesImperative().clear();
				getOutFeaturesImperative().addAll((Collection<? extends String>)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__ALL_NAVIGATION_PATHS:
				getAllNavigationPaths().clear();
				getAllNavigationPaths().addAll((Collection<? extends String>)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__BINDING_FEATURES:
				getBindingFeatures().clear();
				getBindingFeatures().addAll((Collection<? extends String>)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__ALL_FOOT_PRINTS:
				getAllFootPrints().clear();
				getAllFootPrints().addAll((Collection<? extends String>)newValue);
				return;
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES:
				getOutFeatures().clear();
				getOutFeatures().addAll((Collection<? extends String>)newValue);
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
			case RuleTypePackage.RULE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RuleTypePackage.RULE_TYPE__INHERITS:
				setInherits((RuleType)null);
				return;
			case RuleTypePackage.RULE_TYPE__IN_FEATURES:
				getInFeatures().clear();
				return;
			case RuleTypePackage.RULE_TYPE__IN_TYPES:
				getInTypes().clear();
				return;
			case RuleTypePackage.RULE_TYPE__OUT_TYPES:
				getOutTypes().clear();
				return;
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES_IMPERATIVE:
				getOutFeaturesImperative().clear();
				return;
			case RuleTypePackage.RULE_TYPE__ALL_NAVIGATION_PATHS:
				getAllNavigationPaths().clear();
				return;
			case RuleTypePackage.RULE_TYPE__BINDING_FEATURES:
				getBindingFeatures().clear();
				return;
			case RuleTypePackage.RULE_TYPE__ALL_FOOT_PRINTS:
				getAllFootPrints().clear();
				return;
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES:
				getOutFeatures().clear();
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
			case RuleTypePackage.RULE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RuleTypePackage.RULE_TYPE__INHERITS:
				return inherits != null;
			case RuleTypePackage.RULE_TYPE__IN_FEATURES:
				return inFeatures != null && !inFeatures.isEmpty();
			case RuleTypePackage.RULE_TYPE__IN_TYPES:
				return inTypes != null && !inTypes.isEmpty();
			case RuleTypePackage.RULE_TYPE__OUT_TYPES:
				return outTypes != null && !outTypes.isEmpty();
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES_IMPERATIVE:
				return outFeaturesImperative != null && !outFeaturesImperative.isEmpty();
			case RuleTypePackage.RULE_TYPE__ALL_NAVIGATION_PATHS:
				return allNavigationPaths != null && !allNavigationPaths.isEmpty();
			case RuleTypePackage.RULE_TYPE__BINDING_FEATURES:
				return bindingFeatures != null && !bindingFeatures.isEmpty();
			case RuleTypePackage.RULE_TYPE__ALL_FOOT_PRINTS:
				return allFootPrints != null && !allFootPrints.isEmpty();
			case RuleTypePackage.RULE_TYPE__OUT_FEATURES:
				return outFeatures != null && !outFeatures.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", inFeatures: ");
		result.append(inFeatures);
		result.append(", inTypes: ");
		result.append(inTypes);
		result.append(", outTypes: ");
		result.append(outTypes);
		result.append(", outFeaturesImperative: ");
		result.append(outFeaturesImperative);
		result.append(", allNavigationPaths: ");
		result.append(allNavigationPaths);
		result.append(", bindingFeatures: ");
		result.append(bindingFeatures);
		result.append(", allFootPrints: ");
		result.append(allFootPrints);
		result.append(", outFeatures: ");
		result.append(outFeatures);
		result.append(')');
		return result.toString();
	}

} //RuleTypeImpl
