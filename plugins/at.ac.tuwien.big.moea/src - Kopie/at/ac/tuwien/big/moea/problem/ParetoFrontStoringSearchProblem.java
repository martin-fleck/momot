package at.ac.tuwien.big.moea.problem;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.solution.ParetoFront;
import at.ac.tuwien.big.moea.problem.solution.SearchSolution;
import at.ac.tuwien.big.moea.search.fitness.IFitnessFunction;
import at.ac.tuwien.big.moea.search.solution.generator.solution.ISolutionGenerator;
import at.ac.tuwien.big.moea.singleobjectivizer.ObjectiveAdder;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizer;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizerProvider;

public class ParetoFrontStoringSearchProblem<S extends Solution, P extends ISearchProblem<S>> implements IParetoFrontStoringSearchProblem<S> {
	
	private P delegate;
	private ParetoFront<S> paretoFront = new ParetoFront<S>();
	private SingleObjectivizer curSingleObjective = new ObjectiveAdder();
	private SingleObjectivizerProvider singleObjectiveProvider;

	public ParetoFrontStoringSearchProblem(P delegate, SingleObjectivizerProvider provider) {
		this.delegate = delegate;
		this.singleObjectiveProvider = provider;
	}
	
	public P getDelegate() {
		return delegate;
	}

	@Override
	public IFitnessFunction<S> getFitnessFunction() {
		return delegate.getFitnessFunction();
	}

	@Override
	public ISolutionGenerator<S> getSolutionGenerator() {
		return delegate.getSolutionGenerator();
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public int getNumberOfVariables() {
		return delegate.getNumberOfVariables();
	}

	@Override
	public int getNumberOfObjectives() {
		return delegate.getNumberOfObjectives();
	}

	@Override
	public int getNumberOfConstraints() {
		return delegate.getNumberOfConstraints();
	}

	@Override
	public void evaluate(Solution solution) {
		delegate.evaluate(solution);
		if (paretoFront.tryAdd((S)solution)) {
			curSingleObjective = singleObjectiveProvider.provide(getParetoFront());
		}
	}

	@Override
	public Solution newSolution() {
		return delegate.newSolution();
	}

	@Override
	public void close() {
		delegate.close();
	}

	@Override
	public ParetoFront<S> getParetoFront() {
		return paretoFront;
	}

	@Override
	public SingleObjectivizer getCurrentSingleObjectivizer() {
		return curSingleObjective;
	}

	@Override
	public SingleObjectivizerProvider getSingleObjectivizerProvider() {
		return singleObjectiveProvider;
	}
}
