package at.ac.tuwien.big.momot.examples.stack;

import java.io.IOException;

import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.fitness.comparator.ObjectiveFitnessComparator;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.examples.stack.stack.StackPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.IncreasingNeighborhoodFunction;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;

public class StackSearch {
	private static final int SOLUTION_LENGTH = 5;
	private static final int POPULATION_SIZE = 100;
	private static final int MAX_EVALUATIONS = POPULATION_SIZE * 100;
	
	private static final String INPUT_MODEL = "input/model/model_five_stacks.xmi";
//	private static final String INPUT_MODEL = "comparison_11-4-2-5-0-19-12-14-7-2.xmi";
	
//	private static final String REFERENCE_SET = "model/input/referenceSet/model_five_stacks_reference_set.pf";
	private static final int NR_RUNS = 2;
	
	public static void main(String[] args) throws IOException {
		StackPackage.eINSTANCE.eClass();
		
		// search orchestration
		StackOrchestration search = new StackOrchestration(INPUT_MODEL, SOLUTION_LENGTH);		
		
		// algorithms
		EvolutionaryAlgorithmFactory<TransformationSolution> moea = search.createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
		search.addAlgorithm("NSGA-II", moea.createNSGAII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)));
		
		search.addAlgorithm("NSGA-III", moea.createNSGAIII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)));
		
		search.addAlgorithm("EpsilonMOEA", moea.createEpsilonMOEA(
				0.027,
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)));
		
		search.addAlgorithm("RandomSearch", moea.createRandomSearch()); 
		
		// algorithms
		LocalSearchAlgorithmFactory<TransformationSolution> local = search.createLocalSearchAlgorithmFactory();
		search.addAlgorithm("HillClimbing", local.createHillClimbing(
				new IncreasingNeighborhoodFunction(search.getSearchHelper(), 100),
				new ObjectiveFitnessComparator<TransformationSolution>(
						search.getFitnessFunction().getObjectiveIndex("Standard Deviation"))));
		
		search.addAlgorithm("RandomDescent", local.createRandomDescent(
				new IncreasingNeighborhoodFunction(search.getSearchHelper(), 100),
				new ObjectiveFitnessComparator<TransformationSolution>(
						search.getFitnessFunction().getObjectiveIndex("Standard Deviation"))));
	
		// experiment
		SearchExperiment<TransformationSolution> experiment = new SearchExperiment<TransformationSolution>(search, MAX_EVALUATIONS);
//		experiment.setReferenceSetFile(REFERENCE_SET);
		experiment.setNumberOfRuns(NR_RUNS);
		experiment.addProgressListener(new SeedRuntimePrintListener());
		
		experiment.run();
		 
		// analysis
		SearchAnalysis analysis = new SearchAnalysis(experiment);
		analysis.setAllIndicators(true);
		analysis.setShowAll(true);
//		SearchAnalyzer analyzer = analysis.analyze();
		
		// check collected data
//		SearchCollectorHelper helper = new SearchCollectorHelper(experiment);
//		System.out.println(helper.getAvailableKeys());
//		System.out.println(helper.getCollectedData("R3Indicator"));
//		System.out.println(helper.getCollectedData("NSGA-II", "R3Indicator"));
		
		// result management
		TransformationResultManager resultManager = new TransformationResultManager(experiment);
		System.out.println("\nReferenceSet:");
		System.out.println(resultManager.printReferenceSet());
		System.out.println("ApproximationSet:");
		System.out.println(resultManager.printObjectives());
		
		resultManager.setBaseDirectory("model/output_test/solutions/moea/");
		resultManager.saveModels("EpsilonMOEA", "NSGA-III", "NSGA-II", "RandomSearch");
		
		resultManager.setBaseDirectory("model/output_test/solutions/local/");
		resultManager.saveModels("HillClimbing", "RandomDescent");
		
		resultManager.setBaseDirectory("model/output_test/approximationSet/");
		resultManager.saveObjectives("approximation_set_all.pf");
		
		resultManager.setBaseDirectory("model/output_test/approximationSet/moea/");
		resultManager.saveObjectives("approximation_set_epsilonmoea.pf", "EpsilonMOEA");
		resultManager.saveObjectives("approximation_set_nsgaiii.pf", "NSGA-III");
		resultManager.saveObjectives("approximation_set_nsgaii.pf", "NSGA-II");
		resultManager.saveObjectives("approximation_set_random.pf", "RandomSearch");
		resultManager.saveObjectives("approximation_set_evolutionary.pf", "EpsilonMOEA", "NSGA-III", "NSGA-II", "RandomSearch");
		
		resultManager.setBaseDirectory("model/output_test/approximationSet/local/");
		resultManager.saveObjectives("approximation_set_hillclimbing.pf", "HillClimbing");
		resultManager.saveObjectives("approximation_set_randomdescent.pf", "RandomDescent");
		resultManager.saveObjectives("approximation_set_local.pf", "HillClimbing", "RandomDescent");
		
		analysis.analyze().printAnalysis();
//		analyzer.saveAnalysis(new File("model/output/analysis.txt"));
	}
}
