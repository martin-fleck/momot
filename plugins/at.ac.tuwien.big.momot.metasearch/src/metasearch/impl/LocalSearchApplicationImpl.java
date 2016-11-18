/**
 */
package metasearch.impl;

import metasearch.FitnessComparatorGenerator;
import metasearch.LocalSearchAlgorithm;
import metasearch.LocalSearchApplication;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Search Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.LocalSearchApplicationImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link metasearch.impl.LocalSearchApplicationImpl#getTournamentSize <em>Tournament Size</em>}</li>
 *   <li>{@link metasearch.impl.LocalSearchApplicationImpl#getLocalsearchalgorithm <em>Localsearchalgorithm</em>}</li>
 *   <li>{@link metasearch.impl.LocalSearchApplicationImpl#isLastSolution <em>Last Solution</em>}</li>
 *   <li>{@link metasearch.impl.LocalSearchApplicationImpl#getStartAtEvalPerc <em>Start At Eval Perc</em>}</li>
 *   <li>{@link metasearch.impl.LocalSearchApplicationImpl#getUsedGenerator <em>Used Generator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocalSearchApplicationImpl extends MinimalEObjectImpl.Container implements LocalSearchApplication {
	/**
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected double probability = PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTournamentSize() <em>Tournament Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTournamentSize()
	 * @generated
	 * @ordered
	 */
	protected static final int TOURNAMENT_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTournamentSize() <em>Tournament Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTournamentSize()
	 * @generated
	 * @ordered
	 */
	protected int tournamentSize = TOURNAMENT_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalsearchalgorithm() <em>Localsearchalgorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalsearchalgorithm()
	 * @generated
	 * @ordered
	 */
	protected LocalSearchAlgorithm localsearchalgorithm;

	/**
	 * The default value of the '{@link #isLastSolution() <em>Last Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLastSolution()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LAST_SOLUTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLastSolution() <em>Last Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLastSolution()
	 * @generated
	 * @ordered
	 */
	protected boolean lastSolution = LAST_SOLUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartAtEvalPerc() <em>Start At Eval Perc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartAtEvalPerc()
	 * @generated
	 * @ordered
	 */
	protected static final double START_AT_EVAL_PERC_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStartAtEvalPerc() <em>Start At Eval Perc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartAtEvalPerc()
	 * @generated
	 * @ordered
	 */
	protected double startAtEvalPerc = START_AT_EVAL_PERC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsedGenerator() <em>Used Generator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedGenerator()
	 * @generated
	 * @ordered
	 */
	protected FitnessComparatorGenerator usedGenerator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalSearchApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.LOCAL_SEARCH_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbability(double newProbability) {
		double oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.LOCAL_SEARCH_APPLICATION__PROBABILITY, oldProbability, probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTournamentSize() {
		return tournamentSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTournamentSize(int newTournamentSize) {
		int oldTournamentSize = tournamentSize;
		tournamentSize = newTournamentSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE, oldTournamentSize, tournamentSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchAlgorithm getLocalsearchalgorithm() {
		if (localsearchalgorithm != null && localsearchalgorithm.eIsProxy()) {
			InternalEObject oldLocalsearchalgorithm = (InternalEObject)localsearchalgorithm;
			localsearchalgorithm = (LocalSearchAlgorithm)eResolveProxy(oldLocalsearchalgorithm);
			if (localsearchalgorithm != oldLocalsearchalgorithm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM, oldLocalsearchalgorithm, localsearchalgorithm));
			}
		}
		return localsearchalgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchAlgorithm basicGetLocalsearchalgorithm() {
		return localsearchalgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalsearchalgorithm(LocalSearchAlgorithm newLocalsearchalgorithm) {
		LocalSearchAlgorithm oldLocalsearchalgorithm = localsearchalgorithm;
		localsearchalgorithm = newLocalsearchalgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM, oldLocalsearchalgorithm, localsearchalgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLastSolution() {
		return lastSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSolution(boolean newLastSolution) {
		boolean oldLastSolution = lastSolution;
		lastSolution = newLastSolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.LOCAL_SEARCH_APPLICATION__LAST_SOLUTION, oldLastSolution, lastSolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStartAtEvalPerc() {
		return startAtEvalPerc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartAtEvalPerc(double newStartAtEvalPerc) {
		double oldStartAtEvalPerc = startAtEvalPerc;
		startAtEvalPerc = newStartAtEvalPerc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC, oldStartAtEvalPerc, startAtEvalPerc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FitnessComparatorGenerator getUsedGenerator() {
		if (usedGenerator != null && usedGenerator.eIsProxy()) {
			InternalEObject oldUsedGenerator = (InternalEObject)usedGenerator;
			usedGenerator = (FitnessComparatorGenerator)eResolveProxy(oldUsedGenerator);
			if (usedGenerator != oldUsedGenerator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.LOCAL_SEARCH_APPLICATION__USED_GENERATOR, oldUsedGenerator, usedGenerator));
			}
		}
		return usedGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FitnessComparatorGenerator basicGetUsedGenerator() {
		return usedGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedGenerator(FitnessComparatorGenerator newUsedGenerator) {
		FitnessComparatorGenerator oldUsedGenerator = usedGenerator;
		usedGenerator = newUsedGenerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.LOCAL_SEARCH_APPLICATION__USED_GENERATOR, oldUsedGenerator, usedGenerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__PROBABILITY:
				return getProbability();
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE:
				return getTournamentSize();
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM:
				if (resolve) return getLocalsearchalgorithm();
				return basicGetLocalsearchalgorithm();
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LAST_SOLUTION:
				return isLastSolution();
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC:
				return getStartAtEvalPerc();
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__USED_GENERATOR:
				if (resolve) return getUsedGenerator();
				return basicGetUsedGenerator();
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
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__PROBABILITY:
				setProbability((Double)newValue);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE:
				setTournamentSize((Integer)newValue);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM:
				setLocalsearchalgorithm((LocalSearchAlgorithm)newValue);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LAST_SOLUTION:
				setLastSolution((Boolean)newValue);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC:
				setStartAtEvalPerc((Double)newValue);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__USED_GENERATOR:
				setUsedGenerator((FitnessComparatorGenerator)newValue);
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
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__PROBABILITY:
				setProbability(PROBABILITY_EDEFAULT);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE:
				setTournamentSize(TOURNAMENT_SIZE_EDEFAULT);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM:
				setLocalsearchalgorithm((LocalSearchAlgorithm)null);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LAST_SOLUTION:
				setLastSolution(LAST_SOLUTION_EDEFAULT);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC:
				setStartAtEvalPerc(START_AT_EVAL_PERC_EDEFAULT);
				return;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__USED_GENERATOR:
				setUsedGenerator((FitnessComparatorGenerator)null);
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
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__PROBABILITY:
				return probability != PROBABILITY_EDEFAULT;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE:
				return tournamentSize != TOURNAMENT_SIZE_EDEFAULT;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM:
				return localsearchalgorithm != null;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__LAST_SOLUTION:
				return lastSolution != LAST_SOLUTION_EDEFAULT;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC:
				return startAtEvalPerc != START_AT_EVAL_PERC_EDEFAULT;
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION__USED_GENERATOR:
				return usedGenerator != null;
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
		result.append(" (probability: ");
		result.append(probability);
		result.append(", tournamentSize: ");
		result.append(tournamentSize);
		result.append(", lastSolution: ");
		result.append(lastSolution);
		result.append(", startAtEvalPerc: ");
		result.append(startAtEvalPerc);
		result.append(')');
		return result.toString();
	}

} //LocalSearchApplicationImpl
