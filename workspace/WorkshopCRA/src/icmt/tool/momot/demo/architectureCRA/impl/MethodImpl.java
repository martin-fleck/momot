/**
 */
package icmt.tool.momot.demo.architectureCRA.impl;

import icmt.tool.momot.demo.architectureCRA.ArchitecturePackage;
import icmt.tool.momot.demo.architectureCRA.Attribute;
import icmt.tool.momot.demo.architectureCRA.Method;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.MethodImpl#getDataDependency <em>Data Dependency</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.MethodImpl#getFunctionalDependency <em>Functional Dependency</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodImpl extends FeatureImpl implements Method {
	/**
	 * The cached value of the '{@link #getDataDependency() <em>Data Dependency</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> dataDependency;

	/**
	 * The cached value of the '{@link #getFunctionalDependency() <em>Functional Dependency</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> functionalDependency;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getDataDependency() {
		if (dataDependency == null) {
			dataDependency = new EObjectResolvingEList<Attribute>(Attribute.class, this, ArchitecturePackage.METHOD__DATA_DEPENDENCY);
		}
		return dataDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Method> getFunctionalDependency() {
		if (functionalDependency == null) {
			functionalDependency = new EObjectResolvingEList<Method>(Method.class, this, ArchitecturePackage.METHOD__FUNCTIONAL_DEPENDENCY);
		}
		return functionalDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.METHOD__DATA_DEPENDENCY:
				return getDataDependency();
			case ArchitecturePackage.METHOD__FUNCTIONAL_DEPENDENCY:
				return getFunctionalDependency();
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
			case ArchitecturePackage.METHOD__DATA_DEPENDENCY:
				getDataDependency().clear();
				getDataDependency().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ArchitecturePackage.METHOD__FUNCTIONAL_DEPENDENCY:
				getFunctionalDependency().clear();
				getFunctionalDependency().addAll((Collection<? extends Method>)newValue);
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
			case ArchitecturePackage.METHOD__DATA_DEPENDENCY:
				getDataDependency().clear();
				return;
			case ArchitecturePackage.METHOD__FUNCTIONAL_DEPENDENCY:
				getFunctionalDependency().clear();
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
			case ArchitecturePackage.METHOD__DATA_DEPENDENCY:
				return dataDependency != null && !dataDependency.isEmpty();
			case ArchitecturePackage.METHOD__FUNCTIONAL_DEPENDENCY:
				return functionalDependency != null && !functionalDependency.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MethodImpl
