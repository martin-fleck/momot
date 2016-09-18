package at.ac.tuwien.big.momot.examples.tse.momot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.tse.metric.calc.MetricCalculator;
import at.ac.tuwien.big.momot.examples.tse.momot.util.CaseStudy;
import at.ac.tuwien.big.momot.examples.tse.momot.util.ModularizationUtil;
import at.ac.tuwien.big.momot.examples.tse.momot.util.OrchestrationUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;

public class MOMoTSearch {
	public enum Algorithm {
		NSGAIII,
		NSGAII,
		RANDOM
	}
	
	protected static final int POPULATION_SIZE = 100;
	protected static final int NR_ITERATIONS = 100;
	protected static final int NR_RUNS = 1;
	
	protected static void euclideanDistance(NondominatedPopulation nsgaIII, NondominatedPopulation nsgaII, NondominatedPopulation rs) {
		// Comparison
		System.out.println("\n=========================================");
		System.out.println("Euclidean Cominance.");
		System.out.println("=========================================");				
				
		EuclideanDominanceCalculator dominance = new EuclideanDominanceCalculator(nsgaIII, rs).calculate();
		System.out.println(dominance.toString("NSGA-III", "RandomSearch"));
				
		dominance = new EuclideanDominanceCalculator(nsgaII, nsgaIII).calculate();
		System.out.println(dominance.toString("NSGA-II", "NSGA-III"));
				
		dominance = new EuclideanDominanceCalculator(nsgaII, rs).calculate();
		System.out.println(dominance.toString("NSGA-II", "RandomSearch"));
	}
	
	public static void executeCaseStudy(String model, String referenceFile, String outputDir) {
		executeCaseStudy(model, referenceFile, outputDir, POPULATION_SIZE, NR_ITERATIONS, NR_RUNS);
	}
	
	public static void executeCaseStudy(String model, String referenceFile, String outputDir, int populationSize, int nrIterations, int nrRuns) {
		TransformationSettings settings = new TransformationSettings(model, null);		
		System.out.println(settings);
		
		System.err.println("Search for output with " + settings.getMinModules() + " to " + settings.getMaxModules() + " modules, considering " + settings.getSolutionLength() + " unit applications...");
		System.err.println("Population Size: " + populationSize + ", Nr Iterations: " + nrIterations + ", Nr Runs: " + nrRuns + "\n");
		System.err.flush();
		
		System.out.println(MetricCalculator.calculateMetrics(settings.getTransformation()));
		
		String baseName = settings.getTransformation().eResource().getURI().lastSegment().replace(".xmi", "");
		
		List<String> nsgaIIIruns = new ArrayList<>();
		List<String> nsgaIIruns = new ArrayList<>();
		List<String> randomSearchRuns = new ArrayList<>();
		
		TransformationSearchOrchestration search = 
				OrchestrationUtil.createReassignmentOrchestration(
						settings.getGraph(), settings.getMinModules(), settings.getSolutionLength());
		
		for(int j = settings.getMinModules(); j <= settings.getMaxModules(); j++) {
			TransformationSearchOrchestration moduleSearch = 
					OrchestrationUtil.createReassignmentOrchestration(settings.getGraph(), j, settings.getSolutionLength());
			
			EvolutionaryAlgorithmFactory<TransformationSolution> evolutionary = 
					moduleSearch.createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
				
			search.addAlgorithm("NSGA-III_" + j, evolutionary.createNSGAIII(
					new TournamentSelection(2),
					new OnePointCrossover(1), 
					new TransformationPlaceholderMutation(0.1),
					new TransformationVariableMutation(moduleSearch.getSearchHelper(), 0.2)));
			
			search.addAlgorithm("NSGA-II_" + j, evolutionary.createNSGAII(
					new TournamentSelection(2),
					new OnePointCrossover(1), 
					new TransformationPlaceholderMutation(0.1),
					new TransformationVariableMutation(moduleSearch.getSearchHelper(), 0.2)));
				
			search.addAlgorithm("RandomSearch_" + j, evolutionary.createRandomSearch());
			
			nsgaIIruns.add("NSGA-II_" + j);
			nsgaIIIruns.add("NSGA-III_" + j);
			randomSearchRuns.add("RandomSearch_" + j);			
		}
		
		SearchExperiment<TransformationSolution> experiment = new SearchExperiment<TransformationSolution>(search);
		experiment.addProgressListener(new SeedRuntimePrintListener());
//		experiment.setInvertedGenerationalDistance(true);
//		experiment.setHypervolume(true);
//		experiment.setContribution(true);
		experiment.setReferenceSetFile(settings.getReferenceFile());
		experiment.setMaxEvaluations(nrIterations * populationSize);
		experiment.run(nrRuns);

		System.out.println("\n=========================================");
		System.out.println("Search Over.");
		System.out.println("=========================================");
		
		TransformationResultManager manager = new TransformationResultManager(experiment);
		manager.setBaseName(baseName);
		
		manager.setBaseDirectory(outputDir + "/momot/");
		manager.saveModels();
		manager.savePopulation(baseName + "_momot.txt");
		
		manager.setBaseDirectory(outputDir);
		manager.saveObjectives(baseName + "_momot.pf");
		
		// NSGA-III
		String[] nsgaiiiNames = nsgaIIIruns.toArray(new String[0]);		
		manager.setBaseDirectory(outputDir + "/nsgaiii/");
		manager.saveModels(nsgaiiiNames);
		manager.savePopulation(baseName + "_nsgaiii.txt", nsgaiiiNames);
			
		manager.setBaseDirectory(outputDir);
		manager.saveObjectives(baseName + "_nsgaiii.pf", nsgaiiiNames);
		
		// NSGA-II
		String[] nsgaiiNames = nsgaIIruns.toArray(new String[0]);		
		manager.setBaseDirectory(outputDir + "/nsgaii/");
		manager.saveModels(nsgaiiNames);
		manager.savePopulation(baseName + "_nsgaii.txt", nsgaiiNames);
			
		manager.setBaseDirectory(outputDir);
		manager.saveObjectives(baseName + "_nsgaii.pf", nsgaiiNames);

		// Random Search
		String[] rsNames = randomSearchRuns.toArray(new String[0]);
		manager.setBaseDirectory(outputDir + "/random/");
		manager.saveModels(rsNames);
		manager.savePopulation(baseName + "_random.txt", rsNames);
			
		manager.setBaseDirectory(outputDir);
		manager.saveObjectives(baseName + "_random.pf", rsNames);		
		
		System.out.println("\n=========================================");
		System.out.println("Objectives.");
		System.out.println("=========================================");		
		
		System.out.println(manager.printObjectives());
		
//		euclideanDistance(
//				manager.createApproximationSet(nsgaiiiNames),
//				manager.createApproximationSet(nsgaiiNames),
//				manager.createApproximationSet(rsNames));		
	}
	
	public static void main(String[] args) throws IOException {
		ModularizationUtil.initStandalone();
	
//		OCLDelegateDomain.initialize(null, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
//		OCLDelegateDomain.initialize(null, OCLConstants.OCL_DELEGATE_URI_LPG);
//		OCLDelegateDomain.initialize(null, OCLConstants.OCL_DELEGATE_URI);
		
//		OCL.initialize(null);
//		OCLstdlib.install();
		
//		executeCaseStudy(
//			CaseStudy.OCL2R2ML.MODEL, 
//			CaseStudy.OCL2R2ML.REFERENCE_FILE, 
//			CaseStudy.OCL2R2ML.OUTPUT_DIR);

//		executeCaseStudy(
//			CaseStudy.RDM2R2ML.MODEL, 
//			CaseStudy.RDM2R2ML.REFERENCE_FILE, 
//			CaseStudy.RDM2R2ML.OUTPUT_DIR);		

//		executeCaseStudy(
//			CaseStudy.R2ML2XML.MODEL, 
//			CaseStudy.R2ML2XML.REFERENCE_FILE, 
//			CaseStudy.R2ML2XML.OUTPUT_DIR);
		
//		executeCaseStudy(
//				CaseStudy.XML2KML.MODEL, 
//				CaseStudy.XML2KML.REFERENCE_FILE, 
//				CaseStudy.XML2KML.OUTPUT_DIR);
		
		executeCaseStudy(
				CaseStudy.XML2MySQL.MODEL,
				CaseStudy.XML2MySQL.REFERENCE_FILE, 
				CaseStudy.XML2MySQL.OUTPUT_DIR);
		
//		executeCaseStudy(
//				CaseStudy.XML2Ant.MODEL, 
//				CaseStudy.XML2Ant.REFERENCE_FILE, 
//				CaseStudy.XML2Ant.OUTPUT_DIR);
		
//		executeCaseStudy(
//				CaseStudy.JavaMethods2UMLActivityDiagram.MODEL,
//				CaseStudy.JavaMethods2UMLActivityDiagram.REFERENCE_FILE, 
//				CaseStudy.JavaMethods2UMLActivityDiagram.OUTPUT_DIR);
		
//		executeCaseStudy(
//				CaseStudy.Ecore2Maude.MODEL,
//				CaseStudy.Ecore2Maude.REFERENCE_FILE, 
//				CaseStudy.Ecore2Maude.OUTPUT_DIR);
		
//		executeCaseStudy(
//				CaseStudy.XHTML2XML.MODEL,
//				CaseStudy.XHTML2XML.REFERENCE_FILE, 
//				CaseStudy.XHTML2XML.OUTPUT_DIR);
	}
}
