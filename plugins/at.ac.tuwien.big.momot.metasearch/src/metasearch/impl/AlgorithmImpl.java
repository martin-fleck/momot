/**
 */
package metasearch.impl;

import java.lang.reflect.InvocationTargetException;

import metasearch.Algorithm;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.AlgorithmImpl#getNrEvaluations <em>Nr Evaluations</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AlgorithmImpl extends MinimalEObjectImpl.Container implements Algorithm {
	/**
	 * The default value of the '{@link #getNrEvaluations() <em>Nr Evaluations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNrEvaluations()
	 * @generated
	 * @ordered
	 */
	protected static final int NR_EVALUATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNrEvaluations() <em>Nr Evaluations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNrEvaluations()
	 * @generated
	 * @ordered
	 */
	protected int nrEvaluations = NR_EVALUATIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlgorithmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNrEvaluations() {
		return nrEvaluations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNrEvaluations(int newNrEvaluations) {
		int oldNrEvaluations = nrEvaluations;
		nrEvaluations = newNrEvaluations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.ALGORITHM__NR_EVALUATIONS, oldNrEvaluations, nrEvaluations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createRegisteredAlgorithm() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.ALGORITHM__NR_EVALUATIONS:
				return getNrEvaluations();
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
			case MetasearchPackage.ALGORITHM__NR_EVALUATIONS:
				setNrEvaluations((Integer)newValue);
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
			case MetasearchPackage.ALGORITHM__NR_EVALUATIONS:
				setNrEvaluations(NR_EVALUATIONS_EDEFAULT);
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
			case MetasearchPackage.ALGORITHM__NR_EVALUATIONS:
				return nrEvaluations != NR_EVALUATIONS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetasearchPackage.ALGORITHM___CREATE_REGISTERED_ALGORITHM:
				return createRegisteredAlgorithm();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (nrEvaluations: ");
		result.append(nrEvaluations);
		result.append(')');
		return result.toString();
	}

} //AlgorithmImpl
