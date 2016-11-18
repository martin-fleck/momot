/**
 */
package metasearch.util;

import metasearch.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see metasearch.MetasearchPackage
 * @generated
 */
public class MetasearchSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetasearchPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetasearchSwitch() {
		if (modelPackage == null) {
			modelPackage = MetasearchPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MetasearchPackage.GENETIC_ALGORITHM: {
				GeneticAlgorithm geneticAlgorithm = (GeneticAlgorithm)theEObject;
				T result = caseGeneticAlgorithm(geneticAlgorithm);
				if (result == null) result = caseAlgorithm(geneticAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.LOCAL_SEARCH_ALGORITHM: {
				LocalSearchAlgorithm localSearchAlgorithm = (LocalSearchAlgorithm)theEObject;
				T result = caseLocalSearchAlgorithm(localSearchAlgorithm);
				if (result == null) result = caseAlgorithm(localSearchAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.HILL_CLIMBING: {
				HillClimbing hillClimbing = (HillClimbing)theEObject;
				T result = caseHillClimbing(hillClimbing);
				if (result == null) result = caseTabuSupportingLocalSearch(hillClimbing);
				if (result == null) result = caseLocalSearchAlgorithm(hillClimbing);
				if (result == null) result = caseAlgorithm(hillClimbing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.NSGAII: {
				NSGAII nsgaii = (NSGAII)theEObject;
				T result = caseNSGAII(nsgaii);
				if (result == null) result = caseGeneticAlgorithm(nsgaii);
				if (result == null) result = caseAlgorithm(nsgaii);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.NSGAIII: {
				NSGAIII nsgaiii = (NSGAIII)theEObject;
				T result = caseNSGAIII(nsgaiii);
				if (result == null) result = caseGeneticAlgorithm(nsgaiii);
				if (result == null) result = caseAlgorithm(nsgaiii);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.SIMULATED_ANNEALING: {
				SimulatedAnnealing simulatedAnnealing = (SimulatedAnnealing)theEObject;
				T result = caseSimulatedAnnealing(simulatedAnnealing);
				if (result == null) result = caseTabuSupportingLocalSearch(simulatedAnnealing);
				if (result == null) result = caseLocalSearchAlgorithm(simulatedAnnealing);
				if (result == null) result = caseAlgorithm(simulatedAnnealing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.MEMETIC_ALGORITHM: {
				MemeticAlgorithm memeticAlgorithm = (MemeticAlgorithm)theEObject;
				T result = caseMemeticAlgorithm(memeticAlgorithm);
				if (result == null) result = caseAlgorithm(memeticAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION: {
				LocalSearchApplication localSearchApplication = (LocalSearchApplication)theEObject;
				T result = caseLocalSearchApplication(localSearchApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.CONTAINER: {
				Container container = (Container)theEObject;
				T result = caseContainer(container);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.ALGORITHM: {
				Algorithm algorithm = (Algorithm)theEObject;
				T result = caseAlgorithm(algorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.FITNESS_COMPARATOR_GENERATOR: {
				FitnessComparatorGenerator fitnessComparatorGenerator = (FitnessComparatorGenerator)theEObject;
				T result = caseFitnessComparatorGenerator(fitnessComparatorGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.DECREASING_MAXIMUM_COMPARATOR_GENERATOR: {
				DecreasingMaximumComparatorGenerator decreasingMaximumComparatorGenerator = (DecreasingMaximumComparatorGenerator)theEObject;
				T result = caseDecreasingMaximumComparatorGenerator(decreasingMaximumComparatorGenerator);
				if (result == null) result = caseFitnessComparatorGenerator(decreasingMaximumComparatorGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.RANDOM_WEIGHT_GENERATOR: {
				RandomWeightGenerator randomWeightGenerator = (RandomWeightGenerator)theEObject;
				T result = caseRandomWeightGenerator(randomWeightGenerator);
				if (result == null) result = caseFitnessComparatorGenerator(randomWeightGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.TABU_SUPPORTING_LOCAL_SEARCH: {
				TabuSupportingLocalSearch tabuSupportingLocalSearch = (TabuSupportingLocalSearch)theEObject;
				T result = caseTabuSupportingLocalSearch(tabuSupportingLocalSearch);
				if (result == null) result = caseLocalSearchAlgorithm(tabuSupportingLocalSearch);
				if (result == null) result = caseAlgorithm(tabuSupportingLocalSearch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.NEIGHBORHOOD: {
				Neighborhood neighborhood = (Neighborhood)theEObject;
				T result = caseNeighborhood(neighborhood);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.CHANGING_NEIGHBORHOOD: {
				ChangingNeighborhood changingNeighborhood = (ChangingNeighborhood)theEObject;
				T result = caseChangingNeighborhood(changingNeighborhood);
				if (result == null) result = caseNeighborhood(changingNeighborhood);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.ITERATING_ALGORITHM: {
				IteratingAlgorithm iteratingAlgorithm = (IteratingAlgorithm)theEObject;
				T result = caseIteratingAlgorithm(iteratingAlgorithm);
				if (result == null) result = caseAlgorithm(iteratingAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.SOLUTION_INITIALIZER: {
				SolutionInitializer solutionInitializer = (SolutionInitializer)theEObject;
				T result = caseSolutionInitializer(solutionInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.RANDOM_SOLUTION_INITIALIZER: {
				RandomSolutionInitializer randomSolutionInitializer = (RandomSolutionInitializer)theEObject;
				T result = caseRandomSolutionInitializer(randomSolutionInitializer);
				if (result == null) result = caseSolutionInitializer(randomSolutionInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER: {
				DiscardingSolutionInitializer discardingSolutionInitializer = (DiscardingSolutionInitializer)theEObject;
				T result = caseDiscardingSolutionInitializer(discardingSolutionInitializer);
				if (result == null) result = caseSolutionInitializer(discardingSolutionInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Genetic Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Genetic Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneticAlgorithm(GeneticAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Search Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Search Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalSearchAlgorithm(LocalSearchAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hill Climbing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hill Climbing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHillClimbing(HillClimbing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NSGAII</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NSGAII</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNSGAII(NSGAII object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NSGAIII</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NSGAIII</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNSGAIII(NSGAIII object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simulated Annealing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simulated Annealing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimulatedAnnealing(SimulatedAnnealing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memetic Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memetic Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemeticAlgorithm(MemeticAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Search Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Search Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalSearchApplication(LocalSearchApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainer(Container object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgorithm(Algorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fitness Comparator Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fitness Comparator Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFitnessComparatorGenerator(FitnessComparatorGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decreasing Maximum Comparator Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decreasing Maximum Comparator Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecreasingMaximumComparatorGenerator(DecreasingMaximumComparatorGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Weight Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Weight Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomWeightGenerator(RandomWeightGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tabu Supporting Local Search</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tabu Supporting Local Search</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTabuSupportingLocalSearch(TabuSupportingLocalSearch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Neighborhood</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Neighborhood</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNeighborhood(Neighborhood object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Changing Neighborhood</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Changing Neighborhood</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangingNeighborhood(ChangingNeighborhood object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterating Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterating Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratingAlgorithm(IteratingAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solution Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solution Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolutionInitializer(SolutionInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Solution Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Solution Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomSolutionInitializer(RandomSolutionInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discarding Solution Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discarding Solution Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscardingSolutionInitializer(DiscardingSolutionInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MetasearchSwitch
