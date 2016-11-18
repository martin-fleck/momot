package at.ac.tuwien.big.momot.search.solution.generator;

import java.util.List;

import at.ac.tuwien.big.moea.search.solution.generator.InjectedRandomPopulationGenerator;
import at.ac.tuwien.big.moea.search.solution.generator.solution.IRandomSolutionGenerator;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class InjectedTransformationPopulationGenerator extends InjectedRandomPopulationGenerator<TransformationSolution> {

	public InjectedTransformationPopulationGenerator(int populationSize,
			IRandomSolutionGenerator<TransformationSolution> solutionGenerator) {
		super(populationSize, solutionGenerator);
	}
	
	public InjectedTransformationPopulationGenerator(int populationSize,
			IRandomSolutionGenerator<TransformationSolution> solutionGenerator, List<TransformationSolution> injectedSolutions) {
		super(populationSize, solutionGenerator, injectedSolutions);
	}

}
