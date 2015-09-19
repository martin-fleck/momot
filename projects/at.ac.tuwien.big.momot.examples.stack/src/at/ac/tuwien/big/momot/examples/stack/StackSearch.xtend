package at.ac.tuwien.big.momot.examples.stack

import java.io.File
import java.io.IOException
import org.moeaframework.core.operator.OnePointCrossover
import org.moeaframework.core.operator.TournamentSelection
import at.ac.tuwien.big.moea.SearchAnalysis
import at.ac.tuwien.big.moea.SearchCollectorHelper
import at.ac.tuwien.big.moea.SearchExperiment
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory
import at.ac.tuwien.big.moea.search.fitness.comparator.ObjectiveFitnessComparator
import at.ac.tuwien.big.momot.TransformationResultManager
import at.ac.tuwien.big.momot.examples.stack.stack.StackPackage
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.IncreasingNeighborhoodFunction
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation

class StackSearchXtend {
	static final int SOLUTION_LENGTH = 8
	static final int POPULATION_SIZE = 50
	static final int MAX_EVALUATIONS = POPULATION_SIZE * 100
	static final String INPUT_MODEL = "input/model/model_five_stacks.xmi"
	static final String REFERENCE_SET = "model/input/referenceSet/model_five_stacks_reference_set.pf"
	static final int NR_RUNS = 2

	def static void main(String[] args) throws IOException {
		StackPackage.eINSTANCE.eClass() // search orchestration
		var StackOrchestration search = new StackOrchestration(INPUT_MODEL, SOLUTION_LENGTH)
		// algorithms
		var EvolutionaryAlgorithmFactory<TransformationSolution> moea = search.
			createEvolutionaryAlgorithmFactory(POPULATION_SIZE)
		search.addAlgorithm("NSGA-II",
			moea.createNSGAII(new TournamentSelection(2), new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)))
		search.addAlgorithm("NSGA-III",
			moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)))
		search.addAlgorithm("EpsilonMOEA",
			moea.createEpsilonMOEA(0.027, new TournamentSelection(2), new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)))
		search.addAlgorithm("RandomSearch", moea.createRandomSearch()) // algorithms
		var LocalSearchAlgorithmFactory<TransformationSolution> local = search.createLocalSearchAlgorithmFactory()
		search.addAlgorithm("HillClimbing",
			local.createHillClimbing(new IncreasingNeighborhoodFunction(search.getSearchHelper(), 100),
				new ObjectiveFitnessComparator<TransformationSolution>(
					search.getFitnessFunction().getObjectiveIndex("Standard Deviation"))))
		search.addAlgorithm("RandomDescent",
			local.createRandomDescent(new IncreasingNeighborhoodFunction(search.getSearchHelper(), 100),
				new ObjectiveFitnessComparator<TransformationSolution>(
					search.getFitnessFunction().getObjectiveIndex("Standard Deviation")))) // experiment
		var SearchExperiment experiment = new SearchExperiment(search, MAX_EVALUATIONS)
		experiment.setReferenceSetFile(REFERENCE_SET)
		experiment.setNumberOfRuns(NR_RUNS)
		experiment.addProgressListener(new SeedRuntimePrintListener())
		experiment.run() // analysis
		var SearchAnalysis analysis = new SearchAnalysis(experiment)
		analysis.setAllIndicators(true)
		analysis.setShowAll(true)
		var SearchAnalyzer analyzer = analysis.analyze()
		// check collected data
		var SearchCollectorHelper helper = new SearchCollectorHelper(experiment)
		System.out.println(helper.getAvailableKeys())
		System.out.println(helper.getCollectedData("R3Indicator"))
		System.out.println(helper.getCollectedData("NSGA-II", "R3Indicator")) // result management
		var TransformationResultManager resultManager = new TransformationResultManager(experiment)
		System.out.println("ReferenceSet:")
		System.out.println(resultManager.printReferenceSet())
		System.out.println("ApproximationSet:")
		System.out.println(resultManager.printApproximationSetObjectives())
		resultManager.setBaseDirectory("model/output/solutions/moea/")
		resultManager.saveApproximationSetGraphs("EpsilonMOEA", "NSGA-III", "NSGA-II", "RandomSearch")
		resultManager.setBaseDirectory("model/output/solutions/local/")
		resultManager.saveApproximationSetGraphs("HillClimbing", "RandomDescent")
		resultManager.setBaseDirectory("model/output/approximationSet/")
		resultManager.saveApproximationSetObjectives("approximation_set_all.pf")
		resultManager.setBaseDirectory("model/output/approximationSet/moea/")
		resultManager.saveApproximationSetObjectives("approximation_set_epsilonmoea.pf", "EpsilonMOEA")
		resultManager.saveApproximationSetObjectives("approximation_set_nsgaiii.pf", "NSGA-III")
		resultManager.saveApproximationSetObjectives("approximation_set_nsgaii.pf", "NSGA-II")
		resultManager.saveApproximationSetObjectives("approximation_set_random.pf", "RandomSearch")
		resultManager.saveApproximationSetObjectives("approximation_set_evolutionary.pf", "EpsilonMOEA", "NSGA-III",
			"NSGA-II", "RandomSearch")
		resultManager.setBaseDirectory("model/output/approximationSet/local/")
		resultManager.saveApproximationSetObjectives("approximation_set_hillclimbing.pf", "HillClimbing")
		resultManager.saveApproximationSetObjectives("approximation_set_randomdescent.pf", "RandomDescent")
		resultManager.saveApproximationSetObjectives("approximation_set_local.pf", "HillClimbing", "RandomDescent")
		analyzer.saveAnalysis(new File("model/output/analysis.txt"))
	}

}
