/**
 */
package metasearch.util;

import metasearch.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see metasearch.MetasearchPackage
 * @generated
 */
public class MetasearchAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetasearchPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetasearchAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetasearchPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetasearchSwitch<Adapter> modelSwitch =
		new MetasearchSwitch<Adapter>() {
			@Override
			public Adapter caseGeneticAlgorithm(GeneticAlgorithm object) {
				return createGeneticAlgorithmAdapter();
			}
			@Override
			public Adapter caseLocalSearchAlgorithm(LocalSearchAlgorithm object) {
				return createLocalSearchAlgorithmAdapter();
			}
			@Override
			public Adapter caseHillClimbing(HillClimbing object) {
				return createHillClimbingAdapter();
			}
			@Override
			public Adapter caseNSGAII(NSGAII object) {
				return createNSGAIIAdapter();
			}
			@Override
			public Adapter caseNSGAIII(NSGAIII object) {
				return createNSGAIIIAdapter();
			}
			@Override
			public Adapter caseSimulatedAnnealing(SimulatedAnnealing object) {
				return createSimulatedAnnealingAdapter();
			}
			@Override
			public Adapter caseMemeticAlgorithm(MemeticAlgorithm object) {
				return createMemeticAlgorithmAdapter();
			}
			@Override
			public Adapter caseLocalSearchApplication(LocalSearchApplication object) {
				return createLocalSearchApplicationAdapter();
			}
			@Override
			public Adapter caseContainer(Container object) {
				return createContainerAdapter();
			}
			@Override
			public Adapter caseAlgorithm(Algorithm object) {
				return createAlgorithmAdapter();
			}
			@Override
			public Adapter caseFitnessComparatorGenerator(FitnessComparatorGenerator object) {
				return createFitnessComparatorGeneratorAdapter();
			}
			@Override
			public Adapter caseDecreasingMaximumComparatorGenerator(DecreasingMaximumComparatorGenerator object) {
				return createDecreasingMaximumComparatorGeneratorAdapter();
			}
			@Override
			public Adapter caseRandomWeightGenerator(RandomWeightGenerator object) {
				return createRandomWeightGeneratorAdapter();
			}
			@Override
			public Adapter caseTabuSupportingLocalSearch(TabuSupportingLocalSearch object) {
				return createTabuSupportingLocalSearchAdapter();
			}
			@Override
			public Adapter caseNeighborhood(Neighborhood object) {
				return createNeighborhoodAdapter();
			}
			@Override
			public Adapter caseChangingNeighborhood(ChangingNeighborhood object) {
				return createChangingNeighborhoodAdapter();
			}
			@Override
			public Adapter caseIteratingAlgorithm(IteratingAlgorithm object) {
				return createIteratingAlgorithmAdapter();
			}
			@Override
			public Adapter caseSolutionInitializer(SolutionInitializer object) {
				return createSolutionInitializerAdapter();
			}
			@Override
			public Adapter caseRandomSolutionInitializer(RandomSolutionInitializer object) {
				return createRandomSolutionInitializerAdapter();
			}
			@Override
			public Adapter caseDiscardingSolutionInitializer(DiscardingSolutionInitializer object) {
				return createDiscardingSolutionInitializerAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link metasearch.GeneticAlgorithm <em>Genetic Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.GeneticAlgorithm
	 * @generated
	 */
	public Adapter createGeneticAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.LocalSearchAlgorithm <em>Local Search Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.LocalSearchAlgorithm
	 * @generated
	 */
	public Adapter createLocalSearchAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.HillClimbing <em>Hill Climbing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.HillClimbing
	 * @generated
	 */
	public Adapter createHillClimbingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.NSGAII <em>NSGAII</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.NSGAII
	 * @generated
	 */
	public Adapter createNSGAIIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.NSGAIII <em>NSGAIII</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.NSGAIII
	 * @generated
	 */
	public Adapter createNSGAIIIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.SimulatedAnnealing <em>Simulated Annealing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.SimulatedAnnealing
	 * @generated
	 */
	public Adapter createSimulatedAnnealingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.MemeticAlgorithm <em>Memetic Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.MemeticAlgorithm
	 * @generated
	 */
	public Adapter createMemeticAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.LocalSearchApplication <em>Local Search Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.LocalSearchApplication
	 * @generated
	 */
	public Adapter createLocalSearchApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.Container
	 * @generated
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.Algorithm
	 * @generated
	 */
	public Adapter createAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.FitnessComparatorGenerator <em>Fitness Comparator Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.FitnessComparatorGenerator
	 * @generated
	 */
	public Adapter createFitnessComparatorGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.DecreasingMaximumComparatorGenerator <em>Decreasing Maximum Comparator Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.DecreasingMaximumComparatorGenerator
	 * @generated
	 */
	public Adapter createDecreasingMaximumComparatorGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.RandomWeightGenerator <em>Random Weight Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.RandomWeightGenerator
	 * @generated
	 */
	public Adapter createRandomWeightGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.TabuSupportingLocalSearch <em>Tabu Supporting Local Search</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.TabuSupportingLocalSearch
	 * @generated
	 */
	public Adapter createTabuSupportingLocalSearchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.Neighborhood <em>Neighborhood</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.Neighborhood
	 * @generated
	 */
	public Adapter createNeighborhoodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.ChangingNeighborhood <em>Changing Neighborhood</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.ChangingNeighborhood
	 * @generated
	 */
	public Adapter createChangingNeighborhoodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.IteratingAlgorithm <em>Iterating Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.IteratingAlgorithm
	 * @generated
	 */
	public Adapter createIteratingAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.SolutionInitializer <em>Solution Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.SolutionInitializer
	 * @generated
	 */
	public Adapter createSolutionInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.RandomSolutionInitializer <em>Random Solution Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.RandomSolutionInitializer
	 * @generated
	 */
	public Adapter createRandomSolutionInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metasearch.DiscardingSolutionInitializer <em>Discarding Solution Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metasearch.DiscardingSolutionInitializer
	 * @generated
	 */
	public Adapter createDiscardingSolutionInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MetasearchAdapterFactory
