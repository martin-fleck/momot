package at.ac.tuwien.big.momot.examples.stack;

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.algorithm.EpsilonMOEA;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.algorithm.ReferencePointNondominatedSortingPopulation;
import org.moeaframework.core.operator.CompoundVariation;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.stack.stack.Stack;
import at.ac.tuwien.big.momot.examples.stack.stack.StackModel;
import at.ac.tuwien.big.momot.examples.stack.stack.StackPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomIntegerValue;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class StackEvalSearch {
	private static final int SOLUTION_LENGTH = 8;
	private static final int POPULATION_SIZE = 100;
	private static final int MAX_EVALUATIONS = POPULATION_SIZE * 100;
	
	private static final String INPUT_MODEL = "model_five_stacks.xmi";
	private static final String REFERENCE_SET = "output/evolutionary_reference_set.csv";
	private static final int NR_RUNS = 5;
	
	public static void main(String[] args) {
		StackPackage.eINSTANCE.eClass();
		
		final ModuleManager manager = new ModuleManager("model/", "stack.henshin");
		manager.removeUnits(
				StackModule.CreateStack.NAME, 
				StackModule.ConnectStacks.NAME);	// defined in same file, but not applicable
		manager.setParameterValue(
				StackModule.ShiftLeft.Parameter.AMOUNT, new RandomIntegerValue(1, 5));
		manager.setParameterValue(
				StackModule.ShiftLeft.Parameter.AMOUNT, new RandomIntegerValue(1, 5));
		manager.addNonSolutionParameters(
				StackModule.ShiftLeft.Parameter.FROM_LOAD,
				StackModule.ShiftLeft.Parameter.TO_LOAD,
				StackModule.ShiftRight.Parameter.TO_LOAD,
				StackModule.ShiftRight.Parameter.TO_LOAD);
				
		final TransformationSearchOrchestration search = new TransformationSearchOrchestration(manager, SOLUTION_LENGTH);
		search.setProblemGraph(INPUT_MODEL);
		search.getFitnessFunction().setSolutionRepairer(new TransformationPlaceholderRepairer());
		
		search.getFitnessFunction().addObjective(new AbstractEGraphFitnessDimension("Standard Deviation") {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				StackModel root = MomotUtil.getRoot(solution.execute(), StackModel.class);
				
				List<Integer> loads = new ArrayList<Integer>();
				for(Stack stack : root.getStacks())
					loads.add(stack.getLoad());
				
				return MathUtil.getStandardDeviation(loads);
			}
		});		
		search.getFitnessFunction().addObjective(new TransformationLengthDimension());
		
		search.addAlgorithm("NSGA-II", new RegisteredAlgorithm<NSGAII>() {
			@Override
			public NSGAII createAlgorithm() {
				return new NSGAII(search.createProblem(), 
						search.createSortingPopulation(), 
						search.createEpsilonBoxArchive(), 
						new TournamentSelection(2), 
						new CompoundVariation(
								new OnePointCrossover(1.0),
								new TransformationParameterMutation(0.25, manager),
								new TransformationPlaceholderMutation(0.1)),
						search.createPopulationGenerator(POPULATION_SIZE));
			}
		});
		
		search.addAlgorithm("NSGA-III", new RegisteredAlgorithm<NSGAII>() {
			@Override
			public NSGAII createAlgorithm() {
				return new NSGAII(search.createProblem(), 
						new ReferencePointNondominatedSortingPopulation(
								search.getProblem().getNumberOfObjectives(), 0, 4),
						search.createEpsilonBoxArchive(), 
						new TournamentSelection(2), 
						new CompoundVariation(
								new OnePointCrossover(1.0),
								new TransformationParameterMutation(0.25, manager),
								new TransformationPlaceholderMutation(0.1)),
						search.createPopulationGenerator(POPULATION_SIZE));
			}
		});
		
		search.addAlgorithm("EpsilonMOEA", new RegisteredAlgorithm<EpsilonMOEA>() {
			@Override
			public EpsilonMOEA createAlgorithm() {
				return new EpsilonMOEA(
						search.createProblem(), 
						search.createPopulation(),
						search.createEpsilonBoxArchive(0.02), 
						new TournamentSelection(2), 
						new CompoundVariation(
								new OnePointCrossover(1.0),
								new TransformationParameterMutation(0.25, manager),
								new TransformationPlaceholderMutation(0.1)),
						search.createPopulationGenerator(POPULATION_SIZE));
			}
		}); 
		
//		search.addAlgorithm("RandomSearch", new RegisteredAlgorithm<RandomSearch>() {
//			@Override
//			public RandomSearch createAlgorithm() {
//				return new RandomSearch(
//						search.createProblem(), 
//						search.createPopulationGenerator(POPULATION_SIZE), 
//						search.createArchive());
//			}
//		});
		
		
		SearchExperiment<TransformationSolution> experiment = new SearchExperiment<TransformationSolution>(search, MAX_EVALUATIONS);
		experiment.setReferenceSetFile(REFERENCE_SET);
		experiment.setNumberOfRuns(NR_RUNS);
//		experiment.setAllIndicators(true);
		experiment.addProgressListener(new SeedRuntimePrintListener());
		
		experiment.run();
		
		SearchAnalysis analysis = new SearchAnalysis(experiment);
		analysis.setAllIndicators(true);
		analysis.setShowAll(true);		
		System.out.println(TransformationResultManager.printObjectives(TransformationResultManager.createApproximationSet(experiment)));;
	}
}
