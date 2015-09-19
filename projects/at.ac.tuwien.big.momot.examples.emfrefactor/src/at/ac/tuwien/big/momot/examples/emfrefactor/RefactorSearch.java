package at.ac.tuwien.big.momot.examples.emfrefactor;

import java.util.Arrays;

import org.eclipse.uml2.uml.UMLFactory;
import org.moeaframework.core.Solution;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;

public class RefactorSearch {
protected static final String OBJECTIVE_SUM = "Sum";
	
	protected static final int MAX_EVALUTIONS = 10000;
	protected static final int POPULATION_SIZE = 200;
	protected static final int NR_RUNS = 5;
	
	protected static void executeSearch(String initialGraph, String referenceSetFile, int solutionLength) {
		TransformationSearchOrchestration search = new TransformationSearchOrchestration(
				new ModuleManager("model/", "calculate_objects.henshin"), "input/" + initialGraph, solutionLength);
		
		search.getFitnessFunction().addObjective(new TransformationLengthDimension());
		search.getFitnessFunction().addObjective(new AbstractEGraphFitnessDimension(OBJECTIVE_SUM) {
			
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return 0.0;
			}
		});
		search.getFitnessFunction().setSolutionRepairer(new TransformationPlaceholderRepairer());
		
		EvolutionaryAlgorithmFactory<TransformationSolution> factory = search.createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
		
		search.addAlgorithm(factory.createNSGAII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),  
				new TransformationPlaceholderMutation(0.15)));
		
//		LocalSearchAlgorithmFactory<TransformationSolution> local = search.createLocalSearchAlgorithmFactory();
//		local.setInitialSolution(search.createNewRandomSolution(1));
//		
//		search.addAlgorithm(local.createHillClimbing(
//				new IncreasingNeighborhoodFunction(
//						search.getSearchHelper(),
//						20),
//				new ObjectiveFitnessComparator<TransformationSolution>(
//						search.getFitnessFunction().getObjectiveIndex(OBJECTIVE_SUM))));
		
		SearchExperiment experiment = new SearchExperiment(search, MAX_EVALUTIONS);
		experiment.addProgressListener(new SeedRuntimePrintListener());
		experiment.setReferenceSetFile(referenceSetFile);
		experiment.setNumberOfRuns(NR_RUNS);
		
		String baseName = initialGraph.replace(".xmi", "");
		
		TransformationResultManager manager = new TransformationResultManager(experiment);
		manager.setBaseDirectory("model/output/referenceSet/");
		manager.saveApproximationSet(baseName + "_approximation_result.txt");
		manager.saveApproximationSetObjectives(baseName + "_approximation_set.pf");
		
		manager.setBaseDirectory("model/output/solutions/");
		manager.saveApproximationSetGraphs();

		for(Solution solution : manager.createApproximationSet())  {
			TransformationSolution transformationSolution = CastUtil.asClass(solution, TransformationSolution.class);
			System.out.println(Arrays.toString(transformationSolution.getSuccess()));
			transformationSolution.execute(true);
			System.out.println(Arrays.toString(transformationSolution.getSuccess()));
		}

		System.out.println(manager.printApproximationSet());		
		System.out.println(manager.printApproximationSetObjectives());
	}
	
	public static void main(String[] args) {
		UMLFactory.eINSTANCE.eClass();
		executeSearch("math.xmi", null, 6);
	}
}
