package at.ac.tuwien.big.momot.examples.ecore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer;
import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer.FitnessComparison;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.ecore.fitness.ModularizationFitnessFunction;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.MetricsCalculator;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Entity;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationFactory;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModularizationSearch {
	private static final int POPULATION_SIZE = 100;
	private static final int MAX_EVALUATIONS = POPULATION_SIZE * 100;	
	private static final int NR_RUNS = 2;
	
	// for knee point analysis
	private static final int NEIGHBORHOOD_SIZE = 5;
	private static final FitnessComparison FITNESS_COMPARISON = FitnessComparison.PROPER_UTILITY;
	
	public TransformationSearchOrchestration createOrchestration(String initialGraphUri, int solutionLength, int nrModules) {
		ModuleManager moduleManager = createModuleManager();
		
		TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
	    orchestration.setModuleManager(moduleManager);
	    orchestration.setProblemGraph(createProblemGraph(moduleManager, initialGraphUri, nrModules));
	    orchestration.setSolutionLength(solutionLength);
	    orchestration.setFitnessFunction(createFitnessFunction());
	    
	    EvolutionaryAlgorithmFactory<TransformationSolution> moea = orchestration.createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
	    orchestration.addAlgorithm("NSGA-II", createNSGAII(orchestration, moea));
	    
	    return orchestration;
	}
	
	protected Module createModule(String name) {
		Module module = ModularizationFactory.eINSTANCE.createModule();
		module.setName(name);
		return module;
	}
	
	protected EGraph createProblemGraph(ModuleManager moduleManager, String initialGraphUri, int nrModules) {
		EGraph initialGraph = moduleManager.loadGraph(initialGraphUri);
		EGraph problemGraph = MomotUtil.copy(initialGraph);
		Language language = MomotUtil.getRoot(problemGraph, Language.class);
		for(int i = language.getModules().size(); i < nrModules; i++)
			language.getModules().add(createModule("Module_" + language.getModules().size()));
		return MomotUtil.createEGraph(language);
	}
	
	protected EGraph createDistributedProblemGraph(ModuleManager moduleManager, String initialGraphUri, int nrModules) {
		EGraph initialGraph = moduleManager.loadGraph(initialGraphUri);
		EGraph problemGraph = MomotUtil.copy(initialGraph);
		Language language = MomotUtil.getRoot(problemGraph, Language.class);
		List<Entity> entities = new ArrayList<>();
		for(Module module : language.getModules()) // should only be one module, but better safe than sorry
			entities.addAll(module.getEntities());
		
		int nrEntities = entities.size();
		int nrEntitiesPerModule = (nrEntities / nrModules);
		int nrRemainingEntities = (nrEntities % nrModules); // if no perfect distribution is possible
		
		Random rand = new Random();
		for(int i = language.getModules().size(); i < nrModules; i++) {
			Module newModule = createModule("Module_" + language.getModules().size());
			language.getModules().add(newModule);
			
			// assign random entity to new module
			for(int j = 0; j < nrEntitiesPerModule; j++)
				newModule.getEntities().add(entities.remove(rand.nextInt(entities.size())));
			
			// check if we need additional entities
			if(i <= nrRemainingEntities)
				newModule.getEntities().add(entities.remove(rand.nextInt(entities.size())));			
		}
		
		return MomotUtil.createEGraph(language);
	}

	protected IRegisteredAlgorithm<NSGAII> createNSGAII(
			TransformationSearchOrchestration search,
			EvolutionaryAlgorithmFactory<TransformationSolution> moea) {
		return moea.createNSGAII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.1, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.15));
	}
	
	protected IRegisteredAlgorithm<NSGAII> createNSGAIII(
			TransformationSearchOrchestration search,
			EvolutionaryAlgorithmFactory<TransformationSolution> moea) {
		return moea.createNSGAIII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.1, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.15));
	}
	
	private IMultiDimensionalFitnessFunction<TransformationSolution> createFitnessFunction() {
		return new ModularizationFitnessFunction();
	}

	private ModuleManager createModuleManager() {
		ModuleManager manager = new ModuleManager();
	    manager.addModules("operations/modularization_rules.henshin");
	    return manager;
	}

	protected SearchExperiment<TransformationSolution> createExperiment(final TransformationSearchOrchestration orchestration) {
	    SearchExperiment<TransformationSolution> experiment = new SearchExperiment<>(orchestration, MAX_EVALUATIONS);
	    experiment.setNumberOfRuns(NR_RUNS);
	    experiment.addProgressListener(new SeedRuntimePrintListener());
	    return experiment;
	}
	
	protected SearchAnalysis createAnalysis(SearchExperiment<TransformationSolution> experiment) {
		SearchAnalysis analysis = new SearchAnalysis(experiment);
		analysis.setAllIndicators(true);
		analysis.setShowAll(true);
		return analysis;
	}
	
	protected void handleResults(SearchExperiment<TransformationSolution> experiment) {
		TransformationResultManager resultManager = new TransformationResultManager(experiment);
		printResults(resultManager);
		saveResults(resultManager);
		
		NondominatedPopulation approximationSet = resultManager.createApproximationSet();
		PopulationAnalyzer populationAnalyzer = new PopulationAnalyzer(approximationSet);
		NondominatedPopulation kneePointSolutions = populationAnalyzer.getKneePointSolutions(approximationSet, 
				NEIGHBORHOOD_SIZE, FITNESS_COMPARISON);
		
		System.out.println("KneePoints: " + kneePointSolutions.size());
		System.out.println("----------------");
		
		System.out.println("KneePoint Objectives:");
		System.out.println(TransformationResultManager.printObjectives(kneePointSolutions));;
		
		System.out.println("KneePoint Attributes:");
		System.out.println(TransformationResultManager.printAttributes(kneePointSolutions));
		
		System.out.println("Best Solution");
		System.out.println("----------------");
		Solution bestSolution = populationAnalyzer.getBestSolution(approximationSet, FITNESS_COMPARISON);
		NondominatedPopulation bestPopulation = new NondominatedPopulation();
		bestPopulation.add(bestSolution);
		System.out.println(TransformationResultManager.printObjectives(bestPopulation));
		System.out.println(TransformationResultManager.printAttributes(bestPopulation));
	}

	protected void saveResults(TransformationResultManager resultManager) {
		TransformationSearchOrchestration search = CastUtil.asClass(
				resultManager.getExperiment().getSearchOrchestration(), 
				TransformationSearchOrchestration.class);
		Language language = MomotUtil.getRoot(search.getProblemGraph(), Language.class);
		resultManager.setBaseName(language.getName());
		
		resultManager.setBaseDirectory("output/" + language.getName() + "/nsgaii/");
		resultManager.saveObjectives("approximation_nsgaii.pf", "NSGA-II");
		resultManager.savePopulation("approximation_nsgaii.txt", "NSGA-II");
		List<File> nsgaiiFiles = resultManager.saveModels("NSGA-II");
		cleanSolutions(nsgaiiFiles);
	}

	protected void cleanSolutions(List<File> solutionFiles) {
		HenshinResourceSet set = new HenshinResourceSet();
		for(File solutionFile : solutionFiles) {
			EGraph graph = MomotUtil.loadGraph(set, solutionFile.getPath());
			Language language = MomotUtil.getRoot(graph, Language.class);
			List<Module> toRemove = new ArrayList<>();
			for(Module module : language.getModules())
				if(module.getEntities().isEmpty())
					toRemove.add(module);
			language.getModules().removeAll(toRemove);
			MomotUtil.saveGraph(graph, solutionFile.getPath());
		}
	}

	protected void printResults(TransformationResultManager resultManager) {
		System.out.println("\nReferenceSet:");
		System.out.println(resultManager.printReferenceSet());
		System.out.println("ApproximationSet:");
		System.out.println(resultManager.printObjectives());
	}
	
	public void performSearch(String initialGraphUri, int solutionLength, int nrModules) {
		TransformationSearchOrchestration orchestration = createOrchestration(initialGraphUri, solutionLength, nrModules);
		printSearchInfo(orchestration);
		printMetrics(orchestration.getProblemGraph());
	    SearchExperiment<TransformationSolution> experiment = createExperiment(orchestration);
	    experiment.run();
	    handleResults(experiment);
	}
	
	protected void printSearchInfo(TransformationSearchOrchestration orchestration) {
		System.out.println("-------------------");
		System.out.println("Search");
		System.out.println("-------------------");
		System.out.println("NrObjectives:   " + orchestration.getNumberOfObjectives());
		System.out.println("Objectives:     " + orchestration.getFitnessFunction().getObjectiveNames());
		System.out.println("NrConstraints:  " + orchestration.getNumberOfObjectives());
		System.out.println("Constraints:    " + orchestration.getFitnessFunction().getConstraintNames());
		System.out.println("SolutionLength: " + orchestration.getSolutionLength());
		System.out.println("PopulationSize: " + POPULATION_SIZE);
		System.out.println("Iterations:     " + MAX_EVALUATIONS / POPULATION_SIZE);
		System.out.println("MaxEvaluations: " + MAX_EVALUATIONS);
		System.out.println("AlgorithmRuns:  " + NR_RUNS);
	}
	
	protected void printMetrics(EGraph graph) {
		printMetrics(MomotUtil.getRoot(graph, Language.class));
	}

	protected void printMetrics(Language language) {
		System.out.println("-------------------");
		System.out.println("Input");
		System.out.println("-------------------");
		System.out.println(MetricsCalculator.calculate(language));
	}

	public void performSearch(CaseStudy caseStudy) {
		performSearch(caseStudy.getInputModel(), caseStudy.getSolutionLength(), caseStudy.getNrModules());
	}
	
	public static void init() {
		ModularizationPackage.eINSTANCE.eClass();
	}
	
	public static void main(String[] args) throws IOException {
		init();
		ModularizationSearch search = new ModularizationSearch();
		search.performSearch(CaseStudy.QVT);
	}
}
