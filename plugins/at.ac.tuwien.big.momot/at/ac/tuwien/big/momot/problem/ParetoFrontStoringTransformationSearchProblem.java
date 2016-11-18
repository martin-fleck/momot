package at.ac.tuwien.big.momot.problem;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.ParetoFrontStoringSearchProblem;
import at.ac.tuwien.big.moea.problem.solution.SearchSolution;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizerProvider;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class ParetoFrontStoringTransformationSearchProblem<P extends ITransformationProblem> extends ParetoFrontStoringSearchProblem<TransformationSolution,P> 
	implements ITransformationProblem {
 
	public ParetoFrontStoringTransformationSearchProblem(P delegate,
			SingleObjectivizerProvider provider) {
		super(delegate, provider);
	}

}
