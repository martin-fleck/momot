/**
 */
package metasearch.impl;

import metasearch.DiscardingSolutionInitializer;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Discarding Solution Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.DiscardingSolutionInitializerImpl#getSolutionConsiderSize <em>Solution Consider Size</em>}</li>
 *   <li>{@link metasearch.impl.DiscardingSolutionInitializerImpl#getSolutionUseSize <em>Solution Use Size</em>}</li>
 *   <li>{@link metasearch.impl.DiscardingSolutionInitializerImpl#getSolutionsPerQueue <em>Solutions Per Queue</em>}</li>
 *   <li>{@link metasearch.impl.DiscardingSolutionInitializerImpl#getNumQueues <em>Num Queues</em>}</li>
 *   <li>{@link metasearch.impl.DiscardingSolutionInitializerImpl#getNumInitSolutions <em>Num Init Solutions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiscardingSolutionInitializerImpl extends SolutionInitializerImpl implements DiscardingSolutionInitializer {
	/**
	 * The default value of the '{@link #getSolutionConsiderSize() <em>Solution Consider Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionConsiderSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SOLUTION_CONSIDER_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSolutionConsiderSize() <em>Solution Consider Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionConsiderSize()
	 * @generated
	 * @ordered
	 */
	protected int solutionConsiderSize = SOLUTION_CONSIDER_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolutionUseSize() <em>Solution Use Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionUseSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SOLUTION_USE_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSolutionUseSize() <em>Solution Use Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionUseSize()
	 * @generated
	 * @ordered
	 */
	protected int solutionUseSize = SOLUTION_USE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolutionsPerQueue() <em>Solutions Per Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionsPerQueue()
	 * @generated
	 * @ordered
	 */
	protected static final int SOLUTIONS_PER_QUEUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSolutionsPerQueue() <em>Solutions Per Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionsPerQueue()
	 * @generated
	 * @ordered
	 */
	protected int solutionsPerQueue = SOLUTIONS_PER_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumQueues() <em>Num Queues</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumQueues()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_QUEUES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumQueues() <em>Num Queues</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumQueues()
	 * @generated
	 * @ordered
	 */
	protected int numQueues = NUM_QUEUES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumInitSolutions() <em>Num Init Solutions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumInitSolutions()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_INIT_SOLUTIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumInitSolutions() <em>Num Init Solutions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumInitSolutions()
	 * @generated
	 * @ordered
	 */
	protected int numInitSolutions = NUM_INIT_SOLUTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiscardingSolutionInitializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.DISCARDING_SOLUTION_INITIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSolutionConsiderSize() {
		return solutionConsiderSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolutionConsiderSize(int newSolutionConsiderSize) {
		int oldSolutionConsiderSize = solutionConsiderSize;
		solutionConsiderSize = newSolutionConsiderSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE, oldSolutionConsiderSize, solutionConsiderSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSolutionUseSize() {
		return solutionUseSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolutionUseSize(int newSolutionUseSize) {
		int oldSolutionUseSize = solutionUseSize;
		solutionUseSize = newSolutionUseSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE, oldSolutionUseSize, solutionUseSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSolutionsPerQueue() {
		return solutionsPerQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolutionsPerQueue(int newSolutionsPerQueue) {
		int oldSolutionsPerQueue = solutionsPerQueue;
		solutionsPerQueue = newSolutionsPerQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE, oldSolutionsPerQueue, solutionsPerQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumQueues() {
		return numQueues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumQueues(int newNumQueues) {
		int oldNumQueues = numQueues;
		numQueues = newNumQueues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES, oldNumQueues, numQueues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumInitSolutions() {
		return numInitSolutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumInitSolutions(int newNumInitSolutions) {
		int oldNumInitSolutions = numInitSolutions;
		numInitSolutions = newNumInitSolutions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS, oldNumInitSolutions, numInitSolutions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE:
				return getSolutionConsiderSize();
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE:
				return getSolutionUseSize();
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE:
				return getSolutionsPerQueue();
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES:
				return getNumQueues();
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS:
				return getNumInitSolutions();
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
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE:
				setSolutionConsiderSize((Integer)newValue);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE:
				setSolutionUseSize((Integer)newValue);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE:
				setSolutionsPerQueue((Integer)newValue);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES:
				setNumQueues((Integer)newValue);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS:
				setNumInitSolutions((Integer)newValue);
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
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE:
				setSolutionConsiderSize(SOLUTION_CONSIDER_SIZE_EDEFAULT);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE:
				setSolutionUseSize(SOLUTION_USE_SIZE_EDEFAULT);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE:
				setSolutionsPerQueue(SOLUTIONS_PER_QUEUE_EDEFAULT);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES:
				setNumQueues(NUM_QUEUES_EDEFAULT);
				return;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS:
				setNumInitSolutions(NUM_INIT_SOLUTIONS_EDEFAULT);
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
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE:
				return solutionConsiderSize != SOLUTION_CONSIDER_SIZE_EDEFAULT;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE:
				return solutionUseSize != SOLUTION_USE_SIZE_EDEFAULT;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE:
				return solutionsPerQueue != SOLUTIONS_PER_QUEUE_EDEFAULT;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES:
				return numQueues != NUM_QUEUES_EDEFAULT;
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS:
				return numInitSolutions != NUM_INIT_SOLUTIONS_EDEFAULT;
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
		result.append(" (solutionConsiderSize: ");
		result.append(solutionConsiderSize);
		result.append(", solutionUseSize: ");
		result.append(solutionUseSize);
		result.append(", solutionsPerQueue: ");
		result.append(solutionsPerQueue);
		result.append(", numQueues: ");
		result.append(numQueues);
		result.append(", numInitSolutions: ");
		result.append(numInitSolutions);
		result.append(')');
		return result.toString();
	}

} //DiscardingSolutionInitializerImpl
