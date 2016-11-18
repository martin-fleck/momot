/**
 */
package metasearch.impl;

import metasearch.GeneticAlgorithm;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Genetic Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.GeneticAlgorithmImpl#getPopulationSize <em>Population Size</em>}</li>
 *   <li>{@link metasearch.impl.GeneticAlgorithmImpl#getMutateDelete <em>Mutate Delete</em>}</li>
 *   <li>{@link metasearch.impl.GeneticAlgorithmImpl#getMutateModifyRule <em>Mutate Modify Rule</em>}</li>
 *   <li>{@link metasearch.impl.GeneticAlgorithmImpl#getMutateReplaceRule <em>Mutate Replace Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GeneticAlgorithmImpl extends AlgorithmImpl implements GeneticAlgorithm {
	/**
	 * The default value of the '{@link #getPopulationSize() <em>Population Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationSize()
	 * @generated
	 * @ordered
	 */
	protected static final int POPULATION_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPopulationSize() <em>Population Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationSize()
	 * @generated
	 * @ordered
	 */
	protected int populationSize = POPULATION_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMutateDelete() <em>Mutate Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutateDelete()
	 * @generated
	 * @ordered
	 */
	protected static final double MUTATE_DELETE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMutateDelete() <em>Mutate Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutateDelete()
	 * @generated
	 * @ordered
	 */
	protected double mutateDelete = MUTATE_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMutateModifyRule() <em>Mutate Modify Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutateModifyRule()
	 * @generated
	 * @ordered
	 */
	protected static final double MUTATE_MODIFY_RULE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMutateModifyRule() <em>Mutate Modify Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutateModifyRule()
	 * @generated
	 * @ordered
	 */
	protected double mutateModifyRule = MUTATE_MODIFY_RULE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMutateReplaceRule() <em>Mutate Replace Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutateReplaceRule()
	 * @generated
	 * @ordered
	 */
	protected static final double MUTATE_REPLACE_RULE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMutateReplaceRule() <em>Mutate Replace Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutateReplaceRule()
	 * @generated
	 * @ordered
	 */
	protected double mutateReplaceRule = MUTATE_REPLACE_RULE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneticAlgorithmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.GENETIC_ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPopulationSize() {
		return populationSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationSize(int newPopulationSize) {
		int oldPopulationSize = populationSize;
		populationSize = newPopulationSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.GENETIC_ALGORITHM__POPULATION_SIZE, oldPopulationSize, populationSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMutateDelete() {
		return mutateDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutateDelete(double newMutateDelete) {
		double oldMutateDelete = mutateDelete;
		mutateDelete = newMutateDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.GENETIC_ALGORITHM__MUTATE_DELETE, oldMutateDelete, mutateDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMutateModifyRule() {
		return mutateModifyRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutateModifyRule(double newMutateModifyRule) {
		double oldMutateModifyRule = mutateModifyRule;
		mutateModifyRule = newMutateModifyRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.GENETIC_ALGORITHM__MUTATE_MODIFY_RULE, oldMutateModifyRule, mutateModifyRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMutateReplaceRule() {
		return mutateReplaceRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutateReplaceRule(double newMutateReplaceRule) {
		double oldMutateReplaceRule = mutateReplaceRule;
		mutateReplaceRule = newMutateReplaceRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.GENETIC_ALGORITHM__MUTATE_REPLACE_RULE, oldMutateReplaceRule, mutateReplaceRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.GENETIC_ALGORITHM__POPULATION_SIZE:
				return getPopulationSize();
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_DELETE:
				return getMutateDelete();
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_MODIFY_RULE:
				return getMutateModifyRule();
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_REPLACE_RULE:
				return getMutateReplaceRule();
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
			case MetasearchPackage.GENETIC_ALGORITHM__POPULATION_SIZE:
				setPopulationSize((Integer)newValue);
				return;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_DELETE:
				setMutateDelete((Double)newValue);
				return;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_MODIFY_RULE:
				setMutateModifyRule((Double)newValue);
				return;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_REPLACE_RULE:
				setMutateReplaceRule((Double)newValue);
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
			case MetasearchPackage.GENETIC_ALGORITHM__POPULATION_SIZE:
				setPopulationSize(POPULATION_SIZE_EDEFAULT);
				return;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_DELETE:
				setMutateDelete(MUTATE_DELETE_EDEFAULT);
				return;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_MODIFY_RULE:
				setMutateModifyRule(MUTATE_MODIFY_RULE_EDEFAULT);
				return;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_REPLACE_RULE:
				setMutateReplaceRule(MUTATE_REPLACE_RULE_EDEFAULT);
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
			case MetasearchPackage.GENETIC_ALGORITHM__POPULATION_SIZE:
				return populationSize != POPULATION_SIZE_EDEFAULT;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_DELETE:
				return mutateDelete != MUTATE_DELETE_EDEFAULT;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_MODIFY_RULE:
				return mutateModifyRule != MUTATE_MODIFY_RULE_EDEFAULT;
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_REPLACE_RULE:
				return mutateReplaceRule != MUTATE_REPLACE_RULE_EDEFAULT;
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
		result.append(" (populationSize: ");
		result.append(populationSize);
		result.append(", mutateDelete: ");
		result.append(mutateDelete);
		result.append(", mutateModifyRule: ");
		result.append(mutateModifyRule);
		result.append(", mutateReplaceRule: ");
		result.append(mutateReplaceRule);
		result.append(')');
		return result.toString();
	}

} //GeneticAlgorithmImpl
