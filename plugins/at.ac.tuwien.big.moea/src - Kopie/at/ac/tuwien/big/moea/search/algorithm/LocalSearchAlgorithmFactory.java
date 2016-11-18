package at.ac.tuwien.big.moea.search.algorithm;

import java.io.Serializable;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.ISearchOrchestration;
import at.ac.tuwien.big.moea.search.algorithm.iterating.IteratingAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.AbstractLocalSearchAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.HillClimbing;
import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;
import at.ac.tuwien.big.moea.search.algorithm.local.RandomDescent;
import at.ac.tuwien.big.moea.search.algorithm.local.SimulatedAnnealing;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;

public class LocalSearchAlgorithmFactory<S extends Solution> extends AbstractAlgorithmFactory<S> {
	protected S initialSolution;
	
	public LocalSearchAlgorithmFactory() { }
	
	public LocalSearchAlgorithmFactory(ISearchOrchestration<S> searchOrchestration) {
		setSearchOrchestration(searchOrchestration);
	}
	
	public S getInitialSolution() {
		if(initialSolution == null)
			return getSearchOrchestration().createNewSolution(0);
		return initialSolution;
	}
	
	public void setInitialSolution(S initialSolution) {
		this.initialSolution = initialSolution;
	}
	
	public RegisteredAlgorithm<RandomDescent<S>> createRandomDescent(final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> comparator) {
		return new RegisteredAlgorithm<RandomDescent<S>>() {
			@Override
			public RandomDescent<S> createAlgorithm() {
				return new RandomDescent<S>(createProblem(), 
						getInitialSolution(),
						neighborhoodFunction,
						comparator);
			}
		};
	}
	
	public RegisteredAlgorithm<HillClimbing<S>> createHillClimbingD(final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> comparator) {
		return createHillClimbing(neighborhoodFunction,comparator,Integer.MAX_VALUE);	
	}
	
	public RegisteredAlgorithm<HillClimbing<S>> createHillClimbing(final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> comparator,
			int maxNoImprovements) {
		return new RegisteredAlgorithm<HillClimbing<S>>() {
			@Override
			public HillClimbing<S> createAlgorithm() {
				return new HillClimbing<S>(createProblem(), 
						getInitialSolution(),
						neighborhoodFunction,
						comparator, maxNoImprovements);
			}
		};
	}

	
	public RegisteredAlgorithm<IteratingAlgorithm<S>> createIterating(final RegisteredAlgorithm<? extends AbstractLocalSearchAlgorithm<S>> algorithm,
			IFitnessComparatorGenerator<?, S> fitnessGenerator,
			ISolutionInitializerProvider<S> solutionInitializer, int maxSubEval) {
		return new RegisteredAlgorithm<IteratingAlgorithm<S>>() {
			@Override
			public IteratingAlgorithm<S> createAlgorithm() {
				return new IteratingAlgorithm<>(createProblem(), fitnessGenerator, solutionInitializer.provide(), algorithm.createAlgorithm(), maxSubEval);
			}
		};
	}
	
	public<K extends Comparable<K> & Serializable> RegisteredAlgorithm<SimulatedAnnealing<K,S>> createSimulatedAnnealing(final INeighborhoodFunction<S> neighborhoodFunction, final IDeltaEstimator<K, S> comparator, double temperatureFactor,
			double startTemperature,
			int restartNoImprovment, int restartNoImprovementBest) {
		return new RegisteredAlgorithm<SimulatedAnnealing<K,S>>() {
			@Override
			public SimulatedAnnealing<K,S> createAlgorithm() {
				return new SimulatedAnnealing<K,S>(createProblem(), 
						getInitialSolution(),
						neighborhoodFunction,
						comparator,
						temperatureFactor, startTemperature, restartNoImprovment, restartNoImprovementBest);
			}
		};
	}
}
