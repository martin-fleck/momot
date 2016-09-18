package at.ac.tuwien.big.momot.examples.tse.momot;

import java.io.File;
import java.io.IOException;

import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.tse.metric.calc.MetricCalculator;
import at.ac.tuwien.big.momot.examples.tse.momot.util.CaseStudyAll;
import at.ac.tuwien.big.momot.examples.tse.momot.util.ModularizationUtil;
import at.ac.tuwien.big.momot.examples.tse.momot.util.OrchestrationUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;

public class MOMoTSearchAll {
	protected static final String NSGAIII_KEY = "NSGA-III";
	protected static final String NSGAII_KEY = "NSGA-II";
	protected static final String RANDOM_SEARCH_KEY = "RandomSearch";
	
	protected static final int POPULATION_SIZE = 100;
	protected static final int NR_ITERATIONS = 30;
	protected static final int NR_RUNS = 30;
	
	protected static void saveResults(String baseName, String outputDir, ModularizationResultManager manager,
			boolean spea2, boolean nsgaiii, boolean eMOEA, boolean random) {
		manager.setBaseName(baseName);
		
		manager.setBaseDirectory(outputDir + "/momot/");
		manager.saveModels();
		manager.savePopulation(baseName + "_momot.txt");
		
		manager.setBaseDirectory(outputDir);
		manager.saveObjectives(baseName + "_momot.pf");
		
		// NSGA-III	
		if(nsgaiii) {
			manager.setBaseDirectory(outputDir + "/nsgaiii/");
			manager.saveModels(NSGAIII_KEY);
			manager.savePopulation(baseName + "_nsgaiii.txt", NSGAIII_KEY);
				
			manager.setBaseDirectory(outputDir);
			manager.saveObjectives(baseName + "_nsgaiii.pf", NSGAIII_KEY);
		}
		
		// NSGA-II
//		manager.setBaseDirectory(outputDir + "/nsgaii/");
//		manager.saveApproximationSetGraphs(NSGAII_KEY);
//		manager.saveApproximationSet(baseName + "_nsgaii.txt", NSGAII_KEY);
//			
//		manager.setBaseDirectory(outputDir);
//		manager.saveApproximationSetObjectives(baseName + "_nsgaii.pf", NSGAII_KEY);

		// Random Search
		if(random) {
			manager.setBaseDirectory(outputDir + "/random/");
			manager.saveModels(RANDOM_SEARCH_KEY);
			manager.savePopulation(baseName + "_random.txt", RANDOM_SEARCH_KEY);
			
			manager.setBaseDirectory(outputDir);
			manager.saveObjectives(baseName + "_random.pf", RANDOM_SEARCH_KEY);
		}
		
		// SPEA2
		if(spea2) {
			manager.setBaseDirectory(outputDir + "/spea2/");
			manager.saveModels("SPEA2");
			manager.savePopulation(baseName + "_spea2.txt", "SPEA2");
			
			manager.setBaseDirectory(outputDir);
			manager.saveObjectives(baseName + "_spea2.pf", "SPEA2");
		}
//		
//		manager.setBaseDirectory(outputDir + "/pesa2/");
//		manager.saveApproximationSetGraphs("PESA2");
//		manager.saveApproximationSet(baseName + "_pesa2.txt", "PESA2");
//			
//		manager.setBaseDirectory(outputDir);
//		manager.saveApproximationSetObjectives(baseName + "_pesa2.pf", "PESA2");
//		
		// eMOEA
		if(eMOEA) {
			manager.setBaseDirectory(outputDir + "/eMOEA/");
			manager.saveModels("eMOEA");
			manager.savePopulation(baseName + "_eMOEA.txt", "eMOEA");
				
			manager.setBaseDirectory(outputDir);
			manager.saveObjectives(baseName + "_eMOEA.pf", "eMOEA");
		}
	}
	
	protected static TransformationSearchOrchestration createSearch(TransformationSettings settings,
			double mutationProbability,
			boolean spea2, boolean nsgaiii, boolean eMOEA, boolean random, double eMoeaEpsilon, int spea2Offspring) {
		TransformationSearchOrchestration search = 
				OrchestrationUtil.createReassignmentOrchestration(
						settings.getGraph(), settings.getMaxModules(), settings.getSolutionLength());
		
		search.getFitnessFunction().removeConstraint("NoEmptyModule");
		
		EvolutionaryAlgorithmFactory<TransformationSolution> evolutionary = 
				search.createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
		
		evolutionary.addInitialSolution(search.createNewSolution());
		
		if(spea2)
			search.addAlgorithm("SPEA2", evolutionary.createSPEA2(spea2Offspring, new OnePointCrossover(1), new TransformationPlaceholderMutation(mutationProbability)));
//		search.addAlgorithm("PESA2", evolutionary.createPESA2(5, 20, new OnePointCrossover(1), new TransformationPlaceholderMutation(0.05)));
		if(eMOEA)
			search.addAlgorithm("eMOEA", evolutionary.createEpsilonMOEA(eMoeaEpsilon, new TournamentSelection(2),
					new OnePointCrossover(1), new TransformationPlaceholderMutation(mutationProbability)));
		
		if(nsgaiii)
			search.addAlgorithm(NSGAIII_KEY, evolutionary.createNSGAIII(
					new TournamentSelection(2),
					new OnePointCrossover(1), 
					new TransformationPlaceholderMutation(mutationProbability),
					new TransformationVariableMutation(search.getSearchHelper(), 0.1)));
//			
//		search.addAlgorithm(NSGAII_KEY, evolutionary.createNSGAII(
//			new TournamentSelection(2),
//			new OnePointCrossover(1), 
//			new TransformationPlaceholderMutation(0.05),
//			new TransformationVariableMutation(search.getSearchHelper(), 0.1)));
//				
		if(random)
			search.addAlgorithm("RandomSearch", evolutionary.createRandomSearch());
		return search;
	}

	public static void executeCaseStudy(
			String model, String referenceFile, String outputDir, 
			int populationSize, int nrIterations, int nrRuns,
			double mutationProbability,
			boolean spea2, boolean nsgaiii, boolean eMOEA, boolean random,
			double eMoeaEpsilon, int spea2Offspring,
			double significance) {	
		
		if(!outputDir.endsWith("/"))
			outputDir = outputDir + "/";
		
		TransformationSettings settings = new TransformationSettings(model, referenceFile);
		if(referenceFile == null)
			settings.setReferenceFileURI(referenceFile);
		System.out.println(settings);
		
		System.err.println("Search for output with " + settings.getMinModules() + " to " + settings.getMaxModules() + " modules, considering " + settings.getSolutionLength() + " unit applications...");
		System.err.println("Population Size: " + populationSize + ", Nr Iterations: " + nrIterations + ", Nr Runs: " + nrRuns + "\n");
		System.err.flush();
		
		System.out.println(MetricCalculator.calculateMetrics(settings.getTransformation()));
		
		TransformationSearchOrchestration search = createSearch(settings, mutationProbability, spea2, nsgaiii, eMOEA, random, eMoeaEpsilon, spea2Offspring);
		
		SearchExperiment<TransformationSolution> experiment = new SearchExperiment<>(search);
		experiment.addProgressListener(new SeedRuntimePrintListener());
		if(settings.getReferenceFileURI() != null)
			experiment.setReferenceSetFile(settings.getReferenceFile());
		experiment.setMaxEvaluations(nrIterations * populationSize);
		experiment.run(nrRuns);

		ModularizationResultManager manager = new ModularizationResultManager(experiment);
		
		saveResults(
				settings.getTransformation().eResource().getURI().lastSegment().replace(".xmi", ""),
				outputDir,
				manager, spea2, nsgaiii, eMOEA, random);
		
		System.out.println("\n=========================================");
		System.out.println("Objectives.");
		System.out.println("=========================================");		
		
		System.out.println(manager.printObjectives());
		
		if(experiment.getReferenceSetFile() == null) {
			String file = outputDir 
					+ settings.getTransformation().eResource().getURI().lastSegment().replace(".xmi", "") 
					+ "_momot.pf";
			System.out.println("No reference file given, use: " + file);
			experiment.setReferenceSetFile(file);
		}
		if(experiment.getReferenceSetFile() != null) {
			SearchAnalysis analysis = new SearchAnalysis(experiment);
			analysis.setAllIndicators(true);
			analysis.setShowAll(true);
			analysis.setSignificanceLevel(significance);
			SearchAnalyzer analyzer = analysis.analyze();
			try {
				analyzer.saveAnalysis(new File(outputDir + "analysis.txt"));
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public static void executeCaseStudy(
			String model, String referenceFile, String outputDir, 
			int populationSize, int nrIterations, int nrRuns,
			boolean spea2, boolean nsgaiii, boolean eMOEA, boolean random) {
		executeCaseStudy(model, referenceFile, outputDir, populationSize, nrIterations, nrRuns, 0.05,
				spea2, nsgaiii, eMOEA, random,
				0.01, 5, SearchAnalysis.SIGNIFICANCE_ONE_PERCENT);
	}
	
	public static void executeCaseStudy(String model, String referenceFile, String outputDir) {		
		executeCaseStudy(model, referenceFile, outputDir, POPULATION_SIZE, NR_ITERATIONS, NR_RUNS, true, true, true, true);
	}
	
	
	public static void main(String[] args) throws IOException {
		ModularizationUtil.initStandalone();
	
//		OCLDelegateDomain.initialize(null, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
//		OCLDelegateDomain.initialize(null, OCLConstants.OCL_DELEGATE_URI_LPG);
//		OCLDelegateDomain.initialize(null, OCLConstants.OCL_DELEGATE_URI);
		
//		OCL.initialize(null);
//		OCLstdlib.install();
		
//		executeCaseStudy(
//			CaseStudyAll.OCL2R2ML.MODEL, 
//			CaseStudyAll.OCL2R2ML.REFERENCE_FILE, 
//			CaseStudyAll.OCL2R2ML.OUTPUT_DIR);

//		executeCaseStudy(
//			CaseStudyAll.RDM2R2ML.MODEL, 
//			CaseStudyAll.RDM2R2ML.REFERENCE_FILE, 
//			CaseStudyAll.RDM2R2ML.OUTPUT_DIR);		

//		executeCaseStudy(
//			CaseStudyAll.R2ML2XML.MODEL, 
//			CaseStudyAll.R2ML2XML.REFERENCE_FILE, 
//			CaseStudyAll.R2ML2XML.OUTPUT_DIR);
		
//		executeCaseStudy(
//			CaseStudyAll.XML2KML.MODEL, 
//			CaseStudyAll.XML2KML.REFERENCE_FILE, 
//			CaseStudyAll.XML2KML.OUTPUT_DIR);
		
//		executeCaseStudy(
//			CaseStudyAll.XML2MySQL.MODEL,
//			CaseStudyAll.XML2MySQL.REFERENCE_FILE, 
//			CaseStudyAll.XML2MySQL.OUTPUT_DIR);
		
//		executeCaseStudy(
//			CaseStudyAll.XML2Ant.MODEL, 
//			CaseStudyAll.XML2Ant.REFERENCE_FILE, 
//			CaseStudyAll.XML2Ant.OUTPUT_DIR);
		
//		executeCaseStudy(
//			CaseStudyAll.JavaMethods2UMLActivityDiagram.MODEL,
//			CaseStudyAll.JavaMethods2UMLActivityDiagram.REFERENCE_FILE, 
//			CaseStudyAll.JavaMethods2UMLActivityDiagram.OUTPUT_DIR);
		
//		executeCaseStudy(
//			CaseStudyAll.Ecore2Maude.MODEL,
//			CaseStudyAll.Ecore2Maude.REFERENCE_FILE, 
//			CaseStudyAll.Ecore2Maude.OUTPUT_DIR);
		
		executeCaseStudy(
			CaseStudyAll.XHTML2XML.MODEL, null,
//			CaseStudyAll.XHTML2XML.REFERENCE_FILE, 
			CaseStudyAll.XHTML2XML.OUTPUT_DIR + "newNewA/");
	}
}
