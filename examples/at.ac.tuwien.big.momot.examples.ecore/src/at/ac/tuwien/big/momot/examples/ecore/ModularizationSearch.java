package at.ac.tuwien.big.momot.examples.ecore;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.SearchResultManager;
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

public class ModularizationSearch {
   private static final int POPULATION_SIZE = 100;
   private static final int MAX_EVALUATIONS = POPULATION_SIZE * 100;
   private static final int NR_RUNS = 2;

   // for knee point analysis
   private static final int NEIGHBORHOOD_SIZE = 5;
   private static final FitnessComparison FITNESS_COMPARISON = FitnessComparison.PROPER_UTILITY;

   public static void init() {
      ModularizationPackage.eINSTANCE.eClass();
   }

   public static void main(final String[] args) throws IOException {
      init();
      final ModularizationSearch search = new ModularizationSearch();
      search.performSearch(CaseStudy.QVT);
   }

   protected void cleanSolutions(final List<File> solutionFiles) {
      final HenshinResourceSet set = new HenshinResourceSet();
      for(final File solutionFile : solutionFiles) {
         final EGraph graph = MomotUtil.loadGraph(set, solutionFile.getPath());
         final Language language = MomotUtil.getRoot(graph, Language.class);
         final List<Module> toRemove = new ArrayList<>();
         for(final Module module : language.getModules()) {
            if(module.getEntities().isEmpty()) {
               toRemove.add(module);
            }
         }
         language.getModules().removeAll(toRemove);
         MomotUtil.saveGraph(graph, solutionFile.getPath());
      }
   }

   protected SearchAnalysis createAnalysis(final SearchExperiment<TransformationSolution> experiment) {
      final SearchAnalysis analysis = new SearchAnalysis(experiment);
      analysis.setAllIndicators(true);
      analysis.setShowAll(true);
      return analysis;
   }

   protected EGraph createDistributedProblemGraph(final ModuleManager moduleManager, final String initialGraphUri,
         final int nrModules) {
      final EGraph initialGraph = moduleManager.loadGraph(initialGraphUri);
      final EGraph problemGraph = MomotUtil.copy(initialGraph);
      final Language language = MomotUtil.getRoot(problemGraph, Language.class);
      final List<Entity> entities = new ArrayList<>();
      for(final Module module : language.getModules()) {
         entities.addAll(module.getEntities());
      }

      final int nrEntities = entities.size();
      final int nrEntitiesPerModule = nrEntities / nrModules;
      final int nrRemainingEntities = nrEntities % nrModules; // if no perfect distribution is possible

      final Random rand = new Random();
      for(int i = language.getModules().size(); i < nrModules; i++) {
         final Module newModule = createModule("Module_" + language.getModules().size());
         language.getModules().add(newModule);

         // assign random entity to new module
         for(int j = 0; j < nrEntitiesPerModule; j++) {
            newModule.getEntities().add(entities.remove(rand.nextInt(entities.size())));
         }

         // check if we need additional entities
         if(i <= nrRemainingEntities) {
            newModule.getEntities().add(entities.remove(rand.nextInt(entities.size())));
         }
      }

      return MomotUtil.createEGraph(language);
   }

   protected SearchExperiment<TransformationSolution> createExperiment(
         final TransformationSearchOrchestration orchestration) {
      final SearchExperiment<TransformationSolution> experiment = new SearchExperiment<>(orchestration,
            MAX_EVALUATIONS);
      experiment.setNumberOfRuns(NR_RUNS);
      experiment.addProgressListener(new SeedRuntimePrintListener());
      return experiment;
   }

   private IMultiDimensionalFitnessFunction<TransformationSolution> createFitnessFunction() {
      return new ModularizationFitnessFunction();
   }

   protected Module createModule(final String name) {
      final Module module = ModularizationFactory.eINSTANCE.createModule();
      module.setName(name);
      return module;
   }

   private ModuleManager createModuleManager() {
      final ModuleManager manager = new ModuleManager();
      manager.addModules("operations/modularization_rules.henshin");
      return manager;
   }

   protected IRegisteredAlgorithm<NSGAII> createNSGAII(final TransformationSearchOrchestration search,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea) {
      return moea.createNSGAII(new TournamentSelection(2), new OnePointCrossover(1.0),
            new TransformationParameterMutation(0.1, search.getModuleManager()),
            new TransformationPlaceholderMutation(0.15));
   }

   protected IRegisteredAlgorithm<NSGAII> createNSGAIII(final TransformationSearchOrchestration search,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea) {
      return moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
            new TransformationParameterMutation(0.1, search.getModuleManager()),
            new TransformationPlaceholderMutation(0.15));
   }

   public TransformationSearchOrchestration createOrchestration(final String initialGraphUri, final int solutionLength,
         final int nrModules) {
      final ModuleManager moduleManager = createModuleManager();

      final TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
      orchestration.setModuleManager(moduleManager);
      orchestration.setProblemGraph(createProblemGraph(moduleManager, initialGraphUri, nrModules));
      orchestration.setSolutionLength(solutionLength);
      orchestration.setFitnessFunction(createFitnessFunction());

      final EvolutionaryAlgorithmFactory<TransformationSolution> moea = orchestration
            .createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
      orchestration.addAlgorithm("NSGA-II", createNSGAII(orchestration, moea));

      return orchestration;
   }

   protected EGraph createProblemGraph(final ModuleManager moduleManager, final String initialGraphUri,
         final int nrModules) {
      final EGraph initialGraph = moduleManager.loadGraph(initialGraphUri);
      final EGraph problemGraph = MomotUtil.copy(initialGraph);
      final Language language = MomotUtil.getRoot(problemGraph, Language.class);
      for(int i = language.getModules().size(); i < nrModules; i++) {
         language.getModules().add(createModule("Module_" + language.getModules().size()));
      }
      return MomotUtil.createEGraph(language);
   }

   protected void handleResults(final SearchExperiment<TransformationSolution> experiment) {
      final TransformationResultManager resultManager = new TransformationResultManager(experiment);
      printResults(resultManager);
      saveResults(resultManager);

      final NondominatedPopulation approximationSet = resultManager.createApproximationSet();
      final PopulationAnalyzer populationAnalyzer = new PopulationAnalyzer(approximationSet);
      final NondominatedPopulation kneePointSolutions = populationAnalyzer.getKneePointSolutions(approximationSet,
            NEIGHBORHOOD_SIZE, FITNESS_COMPARISON);

      System.out.println("KneePoints: " + kneePointSolutions.size());
      System.out.println("----------------");

      System.out.println("KneePoint Objectives:");
      System.out.println(SearchResultManager.printObjectives(kneePointSolutions));
      ;

      System.out.println("KneePoint Attributes:");
      System.out.println(SearchResultManager.printAttributes(kneePointSolutions));

      System.out.println("Best Solution");
      System.out.println("----------------");
      final Solution bestSolution = populationAnalyzer.getBestSolution(approximationSet, FITNESS_COMPARISON);
      final NondominatedPopulation bestPopulation = new NondominatedPopulation();
      bestPopulation.add(bestSolution);
      System.out.println(SearchResultManager.printObjectives(bestPopulation));
      System.out.println(SearchResultManager.printAttributes(bestPopulation));
   }

   public void performSearch(final CaseStudy caseStudy) {
      performSearch(caseStudy.getInputModel(), caseStudy.getSolutionLength(), caseStudy.getNrModules());
   }

   public void performSearch(final String initialGraphUri, final int solutionLength, final int nrModules) {
      final TransformationSearchOrchestration orchestration = createOrchestration(initialGraphUri, solutionLength,
            nrModules);
      printSearchInfo(orchestration);
      printMetrics(orchestration.getProblemGraph());
      final SearchExperiment<TransformationSolution> experiment = createExperiment(orchestration);
      experiment.run();
      handleResults(experiment);
   }

   protected void printMetrics(final EGraph graph) {
      printMetrics(MomotUtil.getRoot(graph, Language.class));
   }

   protected void printMetrics(final Language language) {
      System.out.println("-------------------");
      System.out.println("Input");
      System.out.println("-------------------");
      System.out.println(MetricsCalculator.calculate(language));
   }

   protected void printResults(final TransformationResultManager resultManager) {
      System.out.println("\nReferenceSet:");
      System.out.println(resultManager.printReferenceSet());
      System.out.println("ApproximationSet:");
      System.out.println(resultManager.printObjectives());
   }

   protected void printSearchInfo(final TransformationSearchOrchestration orchestration) {
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

   protected void saveResults(final TransformationResultManager resultManager) {
      final TransformationSearchOrchestration search = CastUtil
            .asClass(resultManager.getExperiment().getSearchOrchestration(), TransformationSearchOrchestration.class);
      final Language language = MomotUtil.getRoot(search.getProblemGraph(), Language.class);
      resultManager.setBaseName(language.getName());

      resultManager.setBaseDirectory("output/" + language.getName() + "/nsgaii/");
      resultManager.saveObjectives("approximation_nsgaii.pf", "NSGA-II");
      resultManager.savePopulation("approximation_nsgaii.txt", "NSGA-II");
      final List<File> nsgaiiFiles = resultManager.saveModels("NSGA-II");
      cleanSolutions(nsgaiiFiles);
   }
}
