package at.ac.tuwien.big.moea.search.solution.generator;

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.solution.generator.solution.IRandomSolutionGenerator;

public class InjectedRandomPopulationGenerator<S extends Solution> extends RandomPopulationGenerator<S> implements IInjectedPopulationGenerator<S> {
	public List<S> injectedSolutions = new ArrayList<>();
	
	public InjectedRandomPopulationGenerator(int populationSize,
			IRandomSolutionGenerator<S> solutionGenerator) {
		super(populationSize, solutionGenerator);
	}
	
	public InjectedRandomPopulationGenerator(int populationSize,
			IRandomSolutionGenerator<S> solutionGenerator, List<S> injectedSolutions) {
		super(populationSize, solutionGenerator);
		this.injectedSolutions = injectedSolutions;
	}
	
	@Override
	public List<S> getInjectedSolutions() {
		return injectedSolutions;
	}
	
	@Override
	public void setInjectedSolutions(List<S> injectedSolutions) {
		this.injectedSolutions = injectedSolutions;
	}
	
	@Override
	public void addInjectedSolution(S injectedSolution) {
		injectedSolutions.add(injectedSolution);
	}
	
	@Override
	public void addInjectedSolutions(Iterable<S> injectedSolutions) {
		for(S solution : injectedSolutions)
			this.injectedSolutions.add(solution);
	}
	
	@Override
	public S[] initialize() {
		@SuppressWarnings("unchecked")
		S[] population = (S[]) new Solution[getPopulationSize()];
		
		int i = 0;
		while(i < getInjectedSolutions().size() && i < getInjectedSolutions().size() && i < getPopulationSize())
			population[i] = getInjectedSolutions().get(i++);
		
		while(i < getPopulationSize())
			population[i++] = getSolutionGenerator().createRandomSolution();

		return population;
	}

	
}
