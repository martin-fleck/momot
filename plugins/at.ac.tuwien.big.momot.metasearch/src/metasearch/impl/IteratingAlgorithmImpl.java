/**
 */
package metasearch.impl;

import metasearch.FitnessComparatorGenerator;
import metasearch.IteratingAlgorithm;
import metasearch.LocalSearchAlgorithm;
import metasearch.MetasearchPackage;
import metasearch.SolutionInitializer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterating Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metasearch.impl.IteratingAlgorithmImpl#getSolutioninitializer <em>Solutioninitializer</em>}</li>
 *   <li>{@link metasearch.impl.IteratingAlgorithmImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link metasearch.impl.IteratingAlgorithmImpl#getFitnesscomparatorgenerator <em>Fitnesscomparatorgenerator</em>}</li>
 *   <li>{@link metasearch.impl.IteratingAlgorithmImpl#getTournamentSize <em>Tournament Size</em>}</li>
 *   <li>{@link metasearch.impl.IteratingAlgorithmImpl#getTournamentRemain <em>Tournament Remain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IteratingAlgorithmImpl extends AlgorithmImpl implements IteratingAlgorithm {
	/**
	 * The cached value of the '{@link #getSolutioninitializer() <em>Solutioninitializer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutioninitializer()
	 * @generated
	 * @ordered
	 */
	protected SolutionInitializer solutioninitializer;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected LocalSearchAlgorithm algorithm;

	/**
	 * The cached value of the '{@link #getFitnesscomparatorgenerator() <em>Fitnesscomparatorgenerator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFitnesscomparatorgenerator()
	 * @generated
	 * @ordered
	 */
	protected FitnessComparatorGenerator fitnesscomparatorgenerator;

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
	 * The default value of the '{@link #getTournamentRemain() <em>Tournament Remain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTournamentRemain()
	 * @generated
	 * @ordered
	 */
	protected static final int TOURNAMENT_REMAIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTournamentRemain() <em>Tournament Remain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTournamentRemain()
	 * @generated
	 * @ordered
	 */
	protected int tournamentRemain = TOURNAMENT_REMAIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratingAlgorithmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetasearchPackage.Literals.ITERATING_ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionInitializer getSolutioninitializer() {
		if (solutioninitializer != null && solutioninitializer.eIsProxy()) {
			InternalEObject oldSolutioninitializer = (InternalEObject)solutioninitializer;
			solutioninitializer = (SolutionInitializer)eResolveProxy(oldSolutioninitializer);
			if (solutioninitializer != oldSolutioninitializer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.ITERATING_ALGORITHM__SOLUTIONINITIALIZER, oldSolutioninitializer, solutioninitializer));
			}
		}
		return solutioninitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionInitializer basicGetSolutioninitializer() {
		return solutioninitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolutioninitializer(SolutionInitializer newSolutioninitializer) {
		SolutionInitializer oldSolutioninitializer = solutioninitializer;
		solutioninitializer = newSolutioninitializer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.ITERATING_ALGORITHM__SOLUTIONINITIALIZER, oldSolutioninitializer, solutioninitializer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchAlgorithm getAlgorithm() {
		if (algorithm != null && algorithm.eIsProxy()) {
			InternalEObject oldAlgorithm = (InternalEObject)algorithm;
			algorithm = (LocalSearchAlgorithm)eResolveProxy(oldAlgorithm);
			if (algorithm != oldAlgorithm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.ITERATING_ALGORITHM__ALGORITHM, oldAlgorithm, algorithm));
			}
		}
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchAlgorithm basicGetAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(LocalSearchAlgorithm newAlgorithm) {
		LocalSearchAlgorithm oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.ITERATING_ALGORITHM__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FitnessComparatorGenerator getFitnesscomparatorgenerator() {
		if (fitnesscomparatorgenerator != null && fitnesscomparatorgenerator.eIsProxy()) {
			InternalEObject oldFitnesscomparatorgenerator = (InternalEObject)fitnesscomparatorgenerator;
			fitnesscomparatorgenerator = (FitnessComparatorGenerator)eResolveProxy(oldFitnesscomparatorgenerator);
			if (fitnesscomparatorgenerator != oldFitnesscomparatorgenerator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetasearchPackage.ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR, oldFitnesscomparatorgenerator, fitnesscomparatorgenerator));
			}
		}
		return fitnesscomparatorgenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FitnessComparatorGenerator basicGetFitnesscomparatorgenerator() {
		return fitnesscomparatorgenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFitnesscomparatorgenerator(FitnessComparatorGenerator newFitnesscomparatorgenerator) {
		FitnessComparatorGenerator oldFitnesscomparatorgenerator = fitnesscomparatorgenerator;
		fitnesscomparatorgenerator = newFitnesscomparatorgenerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR, oldFitnesscomparatorgenerator, fitnesscomparatorgenerator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_SIZE, oldTournamentSize, tournamentSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTournamentRemain() {
		return tournamentRemain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTournamentRemain(int newTournamentRemain) {
		int oldTournamentRemain = tournamentRemain;
		tournamentRemain = newTournamentRemain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_REMAIN, oldTournamentRemain, tournamentRemain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetasearchPackage.ITERATING_ALGORITHM__SOLUTIONINITIALIZER:
				if (resolve) return getSolutioninitializer();
				return basicGetSolutioninitializer();
			case MetasearchPackage.ITERATING_ALGORITHM__ALGORITHM:
				if (resolve) return getAlgorithm();
				return basicGetAlgorithm();
			case MetasearchPackage.ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR:
				if (resolve) return getFitnesscomparatorgenerator();
				return basicGetFitnesscomparatorgenerator();
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_SIZE:
				return getTournamentSize();
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_REMAIN:
				return getTournamentRemain();
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
			case MetasearchPackage.ITERATING_ALGORITHM__SOLUTIONINITIALIZER:
				setSolutioninitializer((SolutionInitializer)newValue);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__ALGORITHM:
				setAlgorithm((LocalSearchAlgorithm)newValue);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR:
				setFitnesscomparatorgenerator((FitnessComparatorGenerator)newValue);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_SIZE:
				setTournamentSize((Integer)newValue);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_REMAIN:
				setTournamentRemain((Integer)newValue);
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
			case MetasearchPackage.ITERATING_ALGORITHM__SOLUTIONINITIALIZER:
				setSolutioninitializer((SolutionInitializer)null);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__ALGORITHM:
				setAlgorithm((LocalSearchAlgorithm)null);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR:
				setFitnesscomparatorgenerator((FitnessComparatorGenerator)null);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_SIZE:
				setTournamentSize(TOURNAMENT_SIZE_EDEFAULT);
				return;
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_REMAIN:
				setTournamentRemain(TOURNAMENT_REMAIN_EDEFAULT);
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
			case MetasearchPackage.ITERATING_ALGORITHM__SOLUTIONINITIALIZER:
				return solutioninitializer != null;
			case MetasearchPackage.ITERATING_ALGORITHM__ALGORITHM:
				return algorithm != null;
			case MetasearchPackage.ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR:
				return fitnesscomparatorgenerator != null;
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_SIZE:
				return tournamentSize != TOURNAMENT_SIZE_EDEFAULT;
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_REMAIN:
				return tournamentRemain != TOURNAMENT_REMAIN_EDEFAULT;
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
		result.append(" (tournamentSize: ");
		result.append(tournamentSize);
		result.append(", tournamentRemain: ");
		result.append(tournamentRemain);
		result.append(')');
		return result.toString();
	}

} //IteratingAlgorithmImpl
