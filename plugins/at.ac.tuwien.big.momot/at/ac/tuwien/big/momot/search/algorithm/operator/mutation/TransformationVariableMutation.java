package at.ac.tuwien.big.momot.search.algorithm.operator.mutation;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class TransformationVariableMutation extends AbstractTransformationMutation {
	private SearchHelper searchHelper;

	public TransformationVariableMutation(SearchHelper searchHelper, double probability) {
		super(probability);
		this.searchHelper = searchHelper;
	}
	
	public TransformationVariableMutation(SearchHelper searchHelper) {
		this.searchHelper = searchHelper;
	}
		
	protected SearchHelper getSearchHelper() {
		return searchHelper;
	}
		
	@Override
	protected TransformationSolution mutate(TransformationSolution mutant) {
		int randomPosition = MathUtil.randomInteger(mutant.getNumberOfVariables());
		int randomReplace = randomPosition;
		List<ITransformationVariable> subMatches = Arrays.asList(mutant.getVariables()).subList(0, randomReplace);
		TransformationSolution subMutant = getSearchHelper().createTransformationSolution(
				mutant.getSourceGraph(),
				subMatches, 
				mutant.getNumberOfObjectives(), 
				mutant.getNumberOfConstraints());
		EGraph result = subMutant.execute();
		ITransformationVariable variable = getSearchHelper().findUnitApplication(result);
		if(variable != null)
			mutant.setVariable(randomReplace, variable);
		return mutant;
	}
}
