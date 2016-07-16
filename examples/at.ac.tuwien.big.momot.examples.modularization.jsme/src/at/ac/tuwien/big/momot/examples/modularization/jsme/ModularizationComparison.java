package at.ac.tuwien.big.momot.examples.modularization.jsme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationFactory;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.increment.IncrementalStringValue;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModularizationComparison {
	protected static final String INPUT_MODEL = "data/input/models/mtunis_module.xmi";
	protected static final String REFERENCE_SET = null;
	protected static final String OUTPUT_DIR = "data/output/comparison/mtunis/";
	
	protected static final String NSGAIII_KEY = "NSGA-III";
	protected static final String NSGAII_KEY = "NSGA-II";
	protected static final String RANDOM_SEARCH_KEY = "RandomSearch";
	
	protected static final int SOLUTION_LENGTH = 20;
	
	protected static final int POPULATION_SIZE = 100;
	protected static final int NR_ITERATIONS = 200;
	protected static final int MAX_EVALUATIONS = POPULATION_SIZE * NR_ITERATIONS;	
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
		
		// eMOEA
		if(eMOEA) {
			manager.setBaseDirectory(outputDir + "/eMOEA/");
			manager.saveModels("eMOEA");
			manager.savePopulation(baseName + "_eMOEA.txt", "eMOEA");
				
			manager.setBaseDirectory(outputDir);
			manager.saveObjectives(baseName + "_eMOEA.pf", "eMOEA");
		}
	}
	
	protected static ModuleManager createModuleManager() {
	    ModuleManager manager = new ModuleManager();
	    manager.addModules("data/modularization_jsep.henshin");
	    manager.setParameterValue(
	    		ModularizationRules.CreateModule.Parameter.MODULE_NAME, 
	    		new IncrementalStringValue("Module", "A"));
	    manager.removeUnit(ModularizationRules.CreateModule.NAME);
	    manager.removeUnit(ModularizationRules.AssignClass.NAME);
	    return manager;
	}
	
	protected static IEGraphMultiDimensionalFitnessFunction createFitnessFunction(final TransformationSearchOrchestration orchestration) {
	    return new ModularizationFitnessFunction();
	  }
		
	 protected static TransformationSearchOrchestration createOrchestration(final String initialGraph, final int solutionLength) {
		 ModuleManager moduleManager = createModuleManager();
		 TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
		 orchestration.setModuleManager(moduleManager);
		 orchestration.setProblemGraph(createProblemGraph(moduleManager, initialGraph, 20));
		 orchestration.setSolutionLength(solutionLength);
		 orchestration.setFitnessFunction(createFitnessFunction(orchestration));
		 return orchestration;
	 }
	 
	 protected static Module createModule(String name) {
			Module module = ModularizationFactory.eINSTANCE.createModule();
			module.setName(name);
			return module;
		}
	 
	 protected static EGraph createProblemGraph(ModuleManager moduleManager, String initialGraphUri, int nrModules) {
			EGraph initialGraph = moduleManager.loadGraph(initialGraphUri);
			EGraph problemGraph = MomotUtil.copy(initialGraph);
			ModularizationModel model = MomotUtil.getRoot(problemGraph, ModularizationModel.class);
			for(int i = model.getModules().size(); i < nrModules; i++)
				model.getModules().add(createModule("Module_" + model.getModules().size()));
			return MomotUtil.createEGraph(model);
		}
		
		protected static EGraph createDistributedProblemGraph(ModuleManager moduleManager, String initialGraphUri, int nrModules) {
			EGraph initialGraph = moduleManager.loadGraph(initialGraphUri);
			EGraph problemGraph = MomotUtil.copy(initialGraph);
			ModularizationModel language = MomotUtil.getRoot(problemGraph, ModularizationModel.class);
			List<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> entities = new ArrayList<>();
			for(Module module : language.getModules()) // should only be one module, but better safe than sorry
				entities.addAll(module.getClasses());
			
			int nrEntities = entities.size();
			int nrEntitiesPerModule = (nrEntities / nrModules);
			int nrRemainingEntities = (nrEntities % nrModules); // if no perfect distribution is possible
			
			Random rand = new Random();
			for(int i = language.getModules().size(); i < nrModules; i++) {
				Module newModule = createModule("Module_" + language.getModules().size());
				language.getModules().add(newModule);
				
				// assign random entity to new module
				for(int j = 0; j < nrEntitiesPerModule; j++)
					newModule.getClasses().add(entities.remove(rand.nextInt(entities.size())));
				
				// check if we need additional entities
				if(i <= nrRemainingEntities)
					newModule.getClasses().add(entities.remove(rand.nextInt(entities.size())));			
			}
			
			return MomotUtil.createEGraph(language);
		}
	 
	protected static TransformationSearchOrchestration createSearch(
			String initialGraph, String referenceFile,
			int populationSize, int solutionLength,
			double mutationProbability,
			boolean spea2, boolean nsgaiii, boolean eMOEA, boolean random, double eMoeaEpsilon, int spea2Offspring) {
		TransformationSearchOrchestration search = createOrchestration(initialGraph, solutionLength);

		EvolutionaryAlgorithmFactory<TransformationSolution> evolutionary = 
				search.createEvolutionaryAlgorithmFactory(populationSize);
		
		evolutionary.addInitialSolution(search.createNewSolution());
		
		if(spea2)
			search.addAlgorithm("SPEA2", evolutionary.createSPEA2(spea2Offspring, new OnePointCrossover(1), new TransformationPlaceholderMutation(mutationProbability)));

		if(eMOEA)
			search.addAlgorithm("eMOEA", evolutionary.createEpsilonMOEA(eMoeaEpsilon, new TournamentSelection(2),
					new OnePointCrossover(1), new TransformationPlaceholderMutation(mutationProbability)));
		
		if(nsgaiii)
			search.addAlgorithm(NSGAIII_KEY, evolutionary.createNSGAIII(
					6,
					new TournamentSelection(2),
					new OnePointCrossover(1), 
					new TransformationPlaceholderMutation(mutationProbability),
					new TransformationVariableMutation(search.getSearchHelper(), 0.1)));

		if(random)
			search.addAlgorithm("RandomSearch", evolutionary.createRandomSearch());
		
		return search;
	}

	public static void executeCaseStudy(
			String model, String referenceFile, int solutionLength, 
			String outputDir,  int populationSize, int nrIterations, int nrRuns,
			double mutationProbability,
			boolean spea2, boolean nsgaiii, boolean eMOEA, boolean random,
			double eMoeaEpsilon, int spea2Offspring,
			double significance) {	
		
		if(!outputDir.endsWith("/"))
			outputDir = outputDir + "/";
		
		System.err.println("Population Size: " + populationSize + ", Nr Iterations: " + nrIterations + ", Nr Runs: " + nrRuns + "\n");
		System.err.flush();		
		
		TransformationSearchOrchestration search = createSearch(
				model, referenceFile, populationSize, 
				solutionLength,  
				mutationProbability, 
				spea2, nsgaiii, eMOEA, random, 
				eMoeaEpsilon, spea2Offspring);
		
		printSearchInfo(search);
		ModularizationModel inputModel = MomotUtil.getRoot(search.getProblemGraph(), ModularizationModel.class);
		ModularizationCalculator calculator = new ModularizationCalculator(inputModel);
		calculator.calculate();
		System.out.println(calculator.getMetrics());
		
		SearchExperiment<TransformationSolution> experiment = new SearchExperiment<>(search);
		experiment.addProgressListener(new SeedRuntimePrintListener());
		if(referenceFile != null) {
			experiment.setReferenceSetFile(referenceFile);
			experiment.setAllIndicators(true);
		}
		experiment.setMaxEvaluations(nrIterations * populationSize);
		experiment.run(nrRuns);
		
		ModularizationResultManager manager = new ModularizationResultManager(experiment);
		saveResults(
				URI.createURI(model).lastSegment().replace(".xmi", ""),
				outputDir,
				manager, spea2, nsgaiii, eMOEA, random);
		
		System.out.println("\n=========================================");
		System.out.println("Objectives.");
		System.out.println("=========================================");		
		
		System.out.println(manager.printObjectives());
		
		if(experiment.getReferenceSetFile() == null) {
			String file = outputDir 
					+ URI.createURI(model).lastSegment().replace(".xmi", "") 
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
			String model, String referenceFile, 
			int solutionLength, String outputDir, 
			int populationSize, int nrIterations, int nrRuns,
			boolean spea2, boolean nsgaiii, boolean eMOEA, boolean random) {
		executeCaseStudy(model, referenceFile, solutionLength, outputDir, populationSize, nrIterations, nrRuns, 0.05,
				spea2, nsgaiii, eMOEA, random,
				0.2, populationSize, SearchAnalysis.SIGNIFICANCE_ONE_PERCENT);
	}
	
	protected static void printSearchInfo(TransformationSearchOrchestration orchestration) {
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
	
	public static void main(String[] args) {
		ModularizationPackage.eINSTANCE.eClass();
		boolean spea2 = false;
		boolean nsgaiii = true;
		boolean eMOEA = true;
		boolean random = true; 
		
		executeCaseStudy(
				INPUT_MODEL, 
				REFERENCE_SET, 
				SOLUTION_LENGTH,
				OUTPUT_DIR, 
				POPULATION_SIZE, 
				NR_ITERATIONS, 
				NR_RUNS, 
				spea2, 
				nsgaiii, 
				eMOEA, 
				random);
	}
	
}
