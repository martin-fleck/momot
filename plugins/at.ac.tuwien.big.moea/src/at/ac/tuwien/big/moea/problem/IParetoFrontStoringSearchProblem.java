package at.ac.tuwien.big.moea.problem;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.solution.ParetoFront;
import at.ac.tuwien.big.moea.problem.solution.SearchSolution;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizer;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizerProvider;

public interface IParetoFrontStoringSearchProblem<S extends Solution> extends ISearchProblem<S> {
	
	public ParetoFront<S> getParetoFront();
	
	public SingleObjectivizer getCurrentSingleObjectivizer();

	public ISearchProblem<S> getDelegate();
	
	public SingleObjectivizerProvider getSingleObjectivizerProvider();

}
