package at.ac.tuwien.big.momot.search.algorithm.local.neighborhood;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhood;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.AbstractNeighborhoodFunction;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class ChangingNeighborhoodFunction  extends AbstractNeighborhoodFunction<TransformationSolution> {

	private SearchHelper searchHelper;
	private double deleteProbability;
	private double modifyRuleProbability;
	private double modifyAtEndProbability;

	public ChangingNeighborhoodFunction(SearchHelper searchHelper, double deleteProbability, double modifyRuleProbability, int maxNeighbors, double modifyAtEndProbability) {
		super(maxNeighbors);
		this.searchHelper = searchHelper;
		this.deleteProbability = deleteProbability;
		this.modifyRuleProbability = modifyRuleProbability;
		this.modifyAtEndProbability = modifyAtEndProbability;
	}
	
	public ChangingNeighborhoodFunction(SearchHelper searchHelper) {
		this(searchHelper, 0.1, 0.0, 50,0.7); //Modifying rules NYI
	}	
	
	public SearchHelper getSearchHelper() {
		return searchHelper;
	}
	
	@Override
	public INeighborhood<TransformationSolution> generateNeighbors(
			TransformationSolution solution, int maxNeighbors, Collection<Integer> forbiddenIndices) {
		return new AbstractMatchSolutionNeighborhood(solution, maxNeighbors) {
			
			@Override
			public Iterator<TransformationSolution> iterator() {
				return new AbstractTransformationSolutionStepper(getBaseSolution(), getMaxNeighbors()) {
					
					private Iterator<TransformationSolution> iterator;
					
					@Override
					protected TransformationSolution getNext() {
						if (iterator == null || !iterator.hasNext()) {
							iterator = modifySolution(getBaseSolution()).iterator();
						}
						if (iterator.hasNext()) {
							return iterator.next();	
						}
						return null;
						
					}

					private List<TransformationSolution> modifySolution(TransformationSolution baseSolution) {
						return getSearchHelper().changeRandomVariables(baseSolution, getMaxNeighbors(), deleteProbability, modifyRuleProbability,  false, forbiddenIndices, modifyAtEndProbability);
					}
				};
			}
		};
	}

}
