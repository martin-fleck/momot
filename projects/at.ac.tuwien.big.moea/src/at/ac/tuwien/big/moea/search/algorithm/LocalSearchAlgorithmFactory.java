package at.ac.tuwien.big.moea.search.algorithm;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.ISearchOrchestration;
import at.ac.tuwien.big.moea.search.algorithm.local.HillClimbing;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;
import at.ac.tuwien.big.moea.search.algorithm.local.RandomDescent;
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
	
	public RegisteredAlgorithm<HillClimbing<S>> createHillClimbing(final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> comparator) {
		return new RegisteredAlgorithm<HillClimbing<S>>() {
			@Override
			public HillClimbing<S> createAlgorithm() {
				return new HillClimbing<S>(createProblem(), 
						getInitialSolution(),
						neighborhoodFunction,
						comparator);
			}
		};
	}
}
