package icmt.tool.momot.demo;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.SearchResultManager;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.print.IPopulationWriter;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.problem.solution.ParetoFront;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.ISolutionInitializer;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.iterating.IteratingAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.HillClimbing;
import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimator;
import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;
import at.ac.tuwien.big.moea.search.algorithm.local.SimulatedAnnealing;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.MaximumDecreasingFitnessGenerator;
import at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication;
import at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication.USE_SOLUTION_TYPE;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearObjectivizerProvider;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearSingleObjectivizer;
import at.ac.tuwien.big.moea.singleobjectivizer.ObjectiveAdder;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizer;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.init.DiscardingSolutionInitializer;
import at.ac.tuwien.big.momot.search.algorithm.init.RandomSolutionInitializer;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.ChangingNeighborhoodFunction;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.SingleObjectiveFitnessGenerator;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.util.MomotUtil;

import com.google.common.base.Objects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.algorithm.RandomSearch;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Population;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;
import org.moeaframework.core.indicator.Hypervolume;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.util.progress.ProgressListener;

import icmt.tool.momot.demo.architecture.ArchitectureFactory;
import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.ClassModel;
import icmt.tool.momot.demo.architecture.Feature;

@SuppressWarnings("all")
public class ArchitectureSearch3 {
   protected final static String INITIAL_MODEL = "problem/TTC_InputRDG_A.xmi";

   protected final static int SOLUTION_LENGTH = 10;

   final static int HILL_STEPS = 20;

   final static int SA_STEPS = 200;

   final static boolean DO_IMPROVEMENT = true;

   public static void finalization() {
      System.out.println("Search finished.");
   }

   public static void initialization() {
      ArchitecturePackage.eINSTANCE.eClass();
      System.out.println("Search started.");
   }

   public static void main(final String... args) {
      initialization();
      final ArchitectureSearch3 search = new ArchitectureSearch3();
      search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
      finalization();
   }

   protected final String[] modules = new String[] { "transformations/architecture.henshin" };

   protected final int populationSize = 100;

   protected final int maxEvaluations = 10000;

   protected final int nrRuns = 2;

   protected String baseName;

   protected double significanceLevel = 0.01;

   protected ProgressListener _createListener_0() {
      final SeedRuntimePrintListener _seedRuntimePrintListener = new SeedRuntimePrintListener();
      return _seedRuntimePrintListener;
   }

   protected IFitnessDimension<TransformationSolution> _createObjective_0(
         final TransformationSearchOrchestration orchestration) {
      return new AbstractEGraphFitnessDimension("CouplingRatio",
            at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final EGraph graph = solution.execute();
            final EObject root = MomotUtil.getRoot(graph);
            return _createObjectiveHelper_0(solution, graph, root);
         }
      };
   }

   protected IFitnessDimension<TransformationSolution> _createObjective_1(
         final TransformationSearchOrchestration orchestration) {
      return new AbstractEGraphFitnessDimension("CohesionRatio",
            at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Maximum) {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final EGraph graph = solution.execute();
            final EObject root = MomotUtil.getRoot(graph);
            return _createObjectiveHelper_1(solution, graph, root);
         }
      };
   }

   protected IFitnessDimension<TransformationSolution> _createObjective_2(
         final TransformationSearchOrchestration orchestration) {
      final IFitnessDimension<TransformationSolution> dimension = _createObjectiveHelper_2();
      dimension.setName("SolutionLength");
      dimension.setFunctionType(at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum);
      return dimension;
   }

   protected double _createObjectiveHelper_0(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      return FitnessCalculator.calculateCoupling((ClassModel) root);
   }

   protected double _createObjectiveHelper_1(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      return FitnessCalculator.calculateCohesion((ClassModel) root);
   }

   protected IFitnessDimension<TransformationSolution> _createObjectiveHelper_2() {
      final TransformationLengthDimension _transformationLengthDimension = new TransformationLengthDimension();
      return _transformationLengthDimension;
   }

   protected IRegisteredAlgorithm<RandomSearch> _createRegisteredAlgorithm_0(
         final TransformationSearchOrchestration orchestration,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
         final LocalSearchAlgorithmFactory<TransformationSolution> local) {
      final IRegisteredAlgorithm<RandomSearch> _createRandomSearch = moea.createRandomSearch();
      return _createRandomSearch;
   }

   protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_1(
         final TransformationSearchOrchestration orchestration,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
         final LocalSearchAlgorithmFactory<TransformationSolution> local) {
      final IRegisteredAlgorithm<NSGAII> _createNSGAIII = moea.createNSGAIII();
      return _createNSGAIII;
   }

   protected EGraph adaptInputGraph(final ModuleManager moduleManager, final EGraph initialGraph) {
      final EGraph problemGraph = MomotUtil.copy(initialGraph);
      final EObject root = MomotUtil.getRoot(problemGraph);
      return MomotUtil.createEGraph(adaptInputModel(root));
   }

   protected EObject adaptInputModel(final EObject root) {
      final ClassModel cm = (ClassModel) root;
      final EList<Feature> _features = cm.getFeatures();
      final int _size = _features.size();
      final EList<icmt.tool.momot.demo.architecture.Class> _classes = cm.getClasses();
      final int _size_1 = _classes.size();
      final int _minus = _size - _size_1;
      final ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _minus, true);
      for(final Integer i : _doubleDotLessThan) {
         {
            final icmt.tool.momot.demo.architecture.Class newClass = ArchitectureFactory.eINSTANCE.createClass();
            newClass.setName("Class_" + i);
            final EList<icmt.tool.momot.demo.architecture.Class> _classes_1 = cm.getClasses();
            _classes_1.add(newClass);
         }
      }
      final EList<Feature> _features_1 = cm.getFeatures();
      for(final Feature feature : _features_1) {
         final icmt.tool.momot.demo.architecture.Class _isEncapsulatedBy = feature.getIsEncapsulatedBy();
         final boolean _equals = Objects.equal(_isEncapsulatedBy, null);
         if(_equals) {
            final EList<icmt.tool.momot.demo.architecture.Class> _classes_1 = cm.getClasses();
            final EList<icmt.tool.momot.demo.architecture.Class> _classes_2 = cm.getClasses();
            final int _size_2 = _classes_2.size();
            final int _randomInteger = MathUtil.randomInteger(_size_2);
            final icmt.tool.momot.demo.architecture.Class _get = _classes_1.get(_randomInteger);
            final EList<Feature> _encapsulates = _get.getEncapsulates();
            _encapsulates.add(feature);
         }
      }
      return cm;
   }

   protected void adaptResultModel(final EObject root) {
      final ClassModel cm = (ClassModel) root;
      final EList<icmt.tool.momot.demo.architecture.Class> _classes = cm.getClasses();
      final Function1<icmt.tool.momot.demo.architecture.Class, Boolean> _function = (
            final icmt.tool.momot.demo.architecture.Class c) -> {
         final EList<Feature> _encapsulates = c.getEncapsulates();
         final int _size = _encapsulates.size();
         return Boolean.valueOf(_size == 0);
      };
      final Iterable<icmt.tool.momot.demo.architecture.Class> emptyClasses = IterableExtensions.<icmt.tool.momot.demo.architecture.Class> filter(
            _classes, _function);
      final EList<icmt.tool.momot.demo.architecture.Class> _classes_1 = cm.getClasses();
      CollectionExtensions.<icmt.tool.momot.demo.architecture.Class> removeAll(_classes_1, emptyClasses);
   }

   protected void adaptResultModels(final List<File> modelFiles) {
      final HenshinResourceSet set = new HenshinResourceSet();
      for(final File file : modelFiles) {
         final EGraph graph = MomotUtil.loadGraph(file.getPath());
         final EObject root = MomotUtil.getRoot(graph);
         adaptResultModel(root);
         MomotUtil.saveGraph(graph, file.getPath());
      }
   }

   protected SearchExperiment<TransformationSolution> createExperiment(
         final TransformationSearchOrchestration orchestration) {
      final SearchExperiment<TransformationSolution> experiment = new SearchExperiment<TransformationSolution>(
            orchestration, maxEvaluations);
      experiment.setNumberOfRuns(nrRuns);
      experiment.addProgressListener(_createListener_0());
      return experiment;
   }

   protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction(
         final TransformationSearchOrchestration orchestration) {
      final IEGraphMultiDimensionalFitnessFunction function = new EGraphMultiDimensionalFitnessFunction();
      function.addObjective(_createObjective_0(orchestration));
      function.addObjective(_createObjective_1(orchestration));
      function.addObjective(_createObjective_2(orchestration));
      return function;
   }

   protected EGraph createInputGraph(final String initialGraph, final ModuleManager moduleManager) {
      final EGraph graph = moduleManager.loadGraph(initialGraph);
      return adaptInputGraph(moduleManager, graph);
   }

   protected ModuleManager createModuleManager() {
      final ModuleManager manager = new ModuleManager();
      manager.addModules(modules);
      return manager;
   }

   protected IRegisteredAlgorithm<NSGAII> createNSGAIIMem(final TransformationSearchOrchestration search,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
         final LocalSearchAlgorithmFactory<TransformationSolution> local, final boolean randomizeLocalSearch,
         final int tabuSize) {

      final RegisteredAlgorithm<HillClimbing<TransformationSolution>> hillClimbing2 = local
            .createHillClimbing(new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 10), null);
      final IFitnessComparatorGenerator<?, TransformationSolution> randomizedGenerator = new SingleObjectiveFitnessGenerator(
            randomizeLocalSearch);
      final HillClimbing<TransformationSolution> hc = hillClimbing2.createAlgorithm();
      hc.setForbiddenIndices(tabuSize);
      return moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
            new TransformationParameterMutation(0.1, search.getModuleManager()),
            new TransformationPlaceholderMutation(0.15),
            new LocalSearchApplication<>(hc, 0.05, 15, USE_SOLUTION_TYPE.BEST, randomizedGenerator

            ));
   }

   protected IRegisteredAlgorithm<NSGAII> createNSGAIIMemMax(final TransformationSearchOrchestration search,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
         final LocalSearchAlgorithmFactory<TransformationSolution> local, final int tabuSize) {

      final RegisteredAlgorithm<HillClimbing<TransformationSolution>> hillClimbing2 = local
            .createHillClimbing(new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 10), null);
      final IFitnessComparatorGenerator<?, TransformationSolution> randomizedGenerator = new MaximumDecreasingFitnessGenerator<TransformationSolution>();
      final HillClimbing<TransformationSolution> hc = hillClimbing2.createAlgorithm();
      hc.setForbiddenIndices(tabuSize);
      return moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
            new TransformationParameterMutation(0.1, search.getModuleManager()),
            new TransformationPlaceholderMutation(0.15),
            new LocalSearchApplication<>(hc, 0.05, 15, USE_SOLUTION_TYPE.BEST, randomizedGenerator

            ));
   }

   protected IRegisteredAlgorithm<NSGAII> createNSGAIIMemSA(final TransformationSearchOrchestration search,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
         final LocalSearchAlgorithmFactory<TransformationSolution> local, final boolean randomizeLocalSearch,
         final int tabuSize) {
      final RegisteredAlgorithm simulatedAnnealing = local.createSimulatedAnnealing(
            new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 10), null, 0.05, 4 /* 0.2/0.05 */, 30,
            500);
      final IFitnessComparatorGenerator<?, TransformationSolution> randomizedGenerator = new SingleObjectiveFitnessGenerator(
            randomizeLocalSearch);
      final SimulatedAnnealing sa = (SimulatedAnnealing) simulatedAnnealing.createAlgorithm();
      sa.setForbiddenIndices(tabuSize);
      return moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
            new TransformationParameterMutation(0.1, search.getModuleManager()),
            new TransformationPlaceholderMutation(0.01),
            new LocalSearchApplication<>(sa, 0.2, 30, USE_SOLUTION_TYPE.BEST, randomizedGenerator

            ));
   }

   protected IRegisteredAlgorithm<NSGAII> createNSGAIIMemSAMax(final TransformationSearchOrchestration search,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
         final LocalSearchAlgorithmFactory<TransformationSolution> local, final int tabuSize) {
      final RegisteredAlgorithm simulatedAnnealing = local.createSimulatedAnnealing(
            new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 10), null, 0.05, 4 /* 0.2/0.05 */, 50,
            200);
      final IFitnessComparatorGenerator<?, TransformationSolution> randomizedGenerator = new MaximumDecreasingFitnessGenerator<TransformationSolution>();
      final SimulatedAnnealing sa = (SimulatedAnnealing) simulatedAnnealing.createAlgorithm();
      sa.setForbiddenIndices(tabuSize);
      return moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
            new TransformationParameterMutation(0.1, search.getModuleManager()),
            new TransformationPlaceholderMutation(0.01),
            new LocalSearchApplication<>(sa, 0.2, 30, USE_SOLUTION_TYPE.BEST, randomizedGenerator

            ));
   }

   protected TransformationSearchOrchestration createOrchestration(final String initialGraph,
         final int solutionLength) {
      final TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
      final ModuleManager moduleManager = createModuleManager();
      final EGraph graph = createInputGraph(initialGraph, moduleManager);
      orchestration.setModuleManager(moduleManager);
      orchestration.setProblemGraph(graph);
      orchestration.setSolutionLength(solutionLength);
      orchestration.setFitnessFunction(createFitnessFunction(orchestration));
      orchestration.initSingleObjectivizerProvider(new LinearObjectivizerProvider());

      final EvolutionaryAlgorithmFactory<TransformationSolution> moea = orchestration
            .createEvolutionaryAlgorithmFactory(populationSize);
      final LocalSearchAlgorithmFactory<TransformationSolution> local = orchestration
            .createLocalSearchAlgorithmFactory();
      orchestration.addAlgorithm("Random", _createRegisteredAlgorithm_0(orchestration, moea, local));
      orchestration.addAlgorithm("SA", createSA(orchestration, local, true, false));
      orchestration.addAlgorithm("SA-MAX", createSAMax(orchestration, local, false));
      orchestration.addAlgorithm("SARandInit", createSA(orchestration, local, true, true));

      orchestration.addAlgorithm("NSGAIII-SA", createNSGAIIMemSA(orchestration, moea, local, true, 0));
      orchestration.addAlgorithm("NSGAIII-SAMax", createNSGAIIMemSAMax(orchestration, moea, local, 0));
      orchestration.addAlgorithm("NSGAIII-Hill", createNSGAIIMem(orchestration, moea, local, true, 0));
      orchestration.addAlgorithm("NSGAIII-HillMax", createNSGAIIMemMax(orchestration, moea, local, 0));
      orchestration.addAlgorithm("NSGAIII-SA-Tabu5", createNSGAIIMemSA(orchestration, moea, local, true, 5));
      orchestration.addAlgorithm("NSGAIII-Hill-Tabu5", createNSGAIIMem(orchestration, moea, local, true, 5));
      orchestration.addAlgorithm("NSGAIII", _createRegisteredAlgorithm_1(orchestration, moea, local));

      return orchestration;
   }

   protected IRegisteredAlgorithm<IteratingAlgorithm<TransformationSolution>> createSA(
         final TransformationSearchOrchestration search,
         final LocalSearchAlgorithmFactory<TransformationSolution> local, final boolean randomizeLocalSearch,
         final boolean randomInit) {

      final RegisteredAlgorithm simulatedAnnealing = local.createSimulatedAnnealing(
            new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 10), null, 0.007, 30/* 0.2/0.007 */,
            30, 400);
      final IFitnessComparatorGenerator<Double, TransformationSolution> randomizedGenerator = new SingleObjectiveFitnessGenerator(
            randomizeLocalSearch);
      ISolutionInitializer<TransformationSolution> initializer;
      if(randomInit) {
         initializer = new RandomSolutionInitializer<>(search.getSearchHelper());
      } else {
         initializer = new DiscardingSolutionInitializer<>(search.getSearchHelper(), 100, 8, 2, 50, 8, 200, 20,
               search.getFitnessFunction());
      }
      return local.createIterating(simulatedAnnealing, randomizedGenerator, initializer, 400, 60000, 10000);

   }

   protected IRegisteredAlgorithm<IteratingAlgorithm<TransformationSolution>> createSAMax(
         final TransformationSearchOrchestration search,
         final LocalSearchAlgorithmFactory<TransformationSolution> local, final boolean randomInit) {

      final RegisteredAlgorithm simulatedAnnealing = local.createSimulatedAnnealing(
            new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 10), null, 0.007, 30, 30, 400);
      final IFitnessComparatorGenerator<?, TransformationSolution> randomizedGenerator = new MaximumDecreasingFitnessGenerator<TransformationSolution>();
      ISolutionInitializer<TransformationSolution> initializer;
      if(randomInit) {
         initializer = new RandomSolutionInitializer<>(search.getSearchHelper());
      } else {
         initializer = new DiscardingSolutionInitializer<>(search.getSearchHelper(), 100, 8, 2, 50, 8, 200, 20,
               search.getFitnessFunction());
      }
      return local.createIterating(simulatedAnnealing, randomizedGenerator, initializer, 400, 60000, 10000);

   }

   protected void deriveBaseName(final TransformationSearchOrchestration orchestration) {
      final EObject root = MomotUtil.getRoot(orchestration.getProblemGraph());
      if(root == null || root.eResource() == null || root.eResource().getURI() == null) {
         baseName = getClass().getSimpleName();
      } else {
         baseName = root.eResource().getURI().trimFileExtension().lastSegment();
      }
   }

   protected TransformationResultManager handleResults(final SearchExperiment<TransformationSolution> experiment) {
      final ISolutionWriter<TransformationSolution> solutionWriter = experiment.getSearchOrchestration()
            .createSolutionWriter();
      final IPopulationWriter<TransformationSolution> populationWriter = experiment.getSearchOrchestration()
            .createPopulationWriter();
      final TransformationResultManager resultManager = new TransformationResultManager(experiment);
      Population population;
      population = SearchResultManager.createApproximationSet(experiment, (String[]) null);
      System.out.println("- Save objectives of all algorithms to 'output/objectives/objective_values.txt'");
      SearchResultManager.saveObjectives("output/objectives/objective_values.txt", population);
      System.out.println("---------------------------");
      System.out.println("Objectives of all algorithms");
      System.out.println("---------------------------");
      System.out.println(SearchResultManager.printObjectives(population));

      population = SearchResultManager.createApproximationSet(experiment, "Random");
      System.out.println("- Save objectives of 'Random' to 'output/objectives/random_objective_values.txt'");
      SearchResultManager.saveObjectives("output/objectives/random_objective_values.txt", population);

      population = SearchResultManager.createApproximationSet(experiment, (String[]) null);
      System.out.println("- Save solutions of all algorithms to 'output/solutions/all_solutions.txt'");
      SearchResultManager.savePopulation("output/solutions/all_solutions.txt", population, populationWriter);
      System.out.println("- Save solutions of all algorithms to 'output/solutions/all_solutions.txt'");
      SearchResultManager.saveSolutions("output/solutions/", baseName,
            MomotUtil.asIterables(population, TransformationSolution.class), solutionWriter);

      population = SearchResultManager.createApproximationSet(experiment, (String[]) null);
      System.out.println("- Save models of all algorithms to 'output/models/'");
      adaptResultModels(TransformationResultManager.saveModels("output/models/", baseName, population));

      final PopulationAnalyzer analyzer = new PopulationAnalyzer(
            SearchResultManager.createApproximationSet(experiment));

      final Hypervolume hypervolume = new Hypervolume(experiment.getSearchOrchestration().getProblem(),
            analyzer.getReferenceSet());

      final ParetoFront<Solution> par = new ParetoFront<Solution>();
      for(final Solution sol : analyzer.getReferenceSet()) {
         par.tryAdd(sol);
      }

      final int objectiveNum = experiment.getSearchOrchestration().getNumberOfObjectives();

      final LinearObjectivizerProvider provider = new LinearObjectivizerProvider();
      final SingleObjectivizer objectivizer = provider.provide(par);
      LinearSingleObjectivizer lso;
      if(objectivizer instanceof ObjectiveAdder) {
         final double[] dbl = new double[objectiveNum];
         final double[] bestObj = analyzer.getBestObjectives();
         final double[] worstObj = analyzer.getWorstObjectives();
         for(int i = 0; i < bestObj.length; ++i) {
            if(bestObj[i] == worstObj[i]) {
               dbl[i] = 0.1;
            } else {
               dbl[i] = 1.0 / Math.abs(worstObj[i] - bestObj[i]);
            }
         }
         lso = new LinearSingleObjectivizer(dbl);
      } else {
         lso = (LinearSingleObjectivizer) objectivizer;
      }

      final Problem problem = experiment.getSearchOrchestration().getProblem();

      for(final IRegisteredAlgorithm alg : experiment.getSearchOrchestration().getAlgorithms()) {
         final String name = experiment.getSearchOrchestration().getAlgorithmName(alg);
         int index = 1;
         final File file = new File("output/models/" + name + "/");
         if(!file.exists()) {
            file.mkdirs();
         }
         try {
            final FileOutputStream csvList = new FileOutputStream(new File(file, "hypervolume.csv"));
            final FileOutputStream csvListImp = new FileOutputStream(new File(file, "hypervolume_improve.csv"));
            csvListImp.write("Base,Hill,SA\n".getBytes());
            if(DO_IMPROVEMENT) {
               for(final Entry<SearchExecutor, List<NondominatedPopulation>> entry : experiment.getResults()
                     .entrySet()) {
                  for(final NondominatedPopulation pop : entry.getValue()) {

                     final NondominatedPopulation targethill = new NondominatedPopulation();
                     for(int i = 0; i < 1 + objectiveNum; ++i) {
                        for(final org.moeaframework.core.Solution sol : pop) {
                           final SingleObjectiveFitnessGenerator gen = new SingleObjectiveFitnessGenerator(false);
                           gen.setState(i);
                           final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
                                 ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
                                       .getSearchHelper(),
                                 0.1, 0.0, 50);
                           final IFitnessComparator comp = gen.generateComparator(problem,
                                 (TransformationSolution) sol);
                           final HillClimbing<TransformationSolution> hc = new HillClimbing<TransformationSolution>(
                                 problem, (TransformationSolution) sol, func, comp);
                           System.out.println("Initial HC fitness for state " + i + ", comparator: " + comp + ": "
                                 + comp.getValue(sol) + ", objectives: " + Arrays.toString(sol.getObjectives()));
                           for(int k = 0; k < HILL_STEPS / (1 + objectiveNum); ++k) {
                              hc.step();
                              if(hc.isTerminated()) {
                                 break;
                              }
                           }
                           final Solution best = hc.getBestSolution();
                           System.out.println("Best HC fitness for state " + i + ", comparator: " + comp + ": "
                                 + comp.getValue(best) + ", objectives: " + Arrays.toString(best.getObjectives()));
                           targethill.add(hc.getBestSolution());
                        }
                     }

                     final NondominatedPopulation targethillmax = new NondominatedPopulation();
                     for(int i = 0; i < 1 + objectiveNum; ++i) {
                        for(final org.moeaframework.core.Solution sol : pop) {
                           final IDeltaEstimatorGenerator gen = new MaximumDecreasingFitnessGenerator();
                           final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
                                 ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
                                       .getSearchHelper(),
                                 0.1, 0.0, 50);
                           final IFitnessComparator comp = gen.generateComparator(problem, sol);
                           final HillClimbing<TransformationSolution> hc = new HillClimbing<TransformationSolution>(
                                 problem, (TransformationSolution) sol, func, comp);
                           System.out.println("Initial HC-M fitness for state " + i + ", comparator: " + comp + ": "
                                 + comp.getValue(sol) + ", objectives: " + Arrays.toString(sol.getObjectives()));
                           for(int k = 0; k < HILL_STEPS / (1 + objectiveNum); ++k) {
                              hc.step();
                              if(hc.isTerminated()) {
                                 break;
                              }
                           }
                           final Solution best = hc.getBestSolution();
                           System.out.println("Best HC-M fitness for state " + i + ", comparator: " + comp + ": "
                                 + comp.getValue(best) + ", objectives: " + Arrays.toString(best.getObjectives()));
                           targethillmax.add(hc.getBestSolution());
                        }
                     }

                     final NondominatedPopulation targetsa = new NondominatedPopulation();

                     for(int i = 0; i < 1 + objectiveNum; ++i) {
                        for(final org.moeaframework.core.Solution sol : pop) {
                           final SingleObjectiveFitnessGenerator gen = new SingleObjectiveFitnessGenerator(false);
                           gen.setState(i);
                           final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
                                 ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
                                       .getSearchHelper(),
                                 0.1, 0.0, 50);
                           final IDeltaEstimator comp = gen.generateComparator(problem, (TransformationSolution) sol);
                           final SimulatedAnnealing hc = new SimulatedAnnealing(problem, sol, func, comp, 0.005, 30, 30,
                                 800);
                           for(int k = 0; k < SA_STEPS / (1 + objectiveNum); ++k) {
                              hc.step();
                           }
                           final Solution best = hc.getBestSolution();
                           System.out.println("Best SA fitness for state " + i + ", comparator: " + comp + ": "
                                 + comp.getValue(best) + ", objectives: " + Arrays.toString(best.getObjectives()));
                           targetsa.add(best);
                        }
                     }
                     csvListImp.write((hypervolume.evaluate(pop) + "," + hypervolume.evaluate(targethill) + ","
                           + hypervolume.evaluate(targetsa) + "\n").getBytes());

                     final NondominatedPopulation targetsamax = new NondominatedPopulation();

                     for(final org.moeaframework.core.Solution sol : pop) {
                        final MaximumDecreasingFitnessGenerator gen = new MaximumDecreasingFitnessGenerator<Solution>();
                        final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
                              ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
                                    .getSearchHelper(),
                              0.1, 0.0, 50);
                        final IDeltaEstimator comp = gen.generateComparator(problem, sol);
                        final SimulatedAnnealing hc = new SimulatedAnnealing(problem, sol, func, comp, 0.005, 30, 30,
                              800);
                        for(int k = 0; k < SA_STEPS / (1 + objectiveNum); ++k) {
                           hc.step();
                        }
                        final Solution best = hc.getBestSolution();
                        System.out.println("Best SA-M fitness, comparator: " + comp + ": " + comp.getValue(best)
                              + ", objectives: " + Arrays.toString(best.getObjectives()));
                        targetsamax.add(best);
                     }
                     csvListImp.write((hypervolume.evaluate(pop) + "," + hypervolume.evaluate(targethill) + ","
                           + hypervolume.evaluate(targethillmax) + "," + hypervolume.evaluate(targetsa) + ","
                           + hypervolume.evaluate(targetsamax) + "\n").getBytes());
                  }
               }
            }

            for(final Entry<SearchExecutor, List<NondominatedPopulation>> entry : experiment.getResults().entrySet()) {
               if(name.equals(entry.getKey().getName())) {
                  final List<List<NondominatedPopulation>> populationList = entry.getKey().getResultListsPerRun();

                  int maxListSize = 0;
                  for(int i = 0; i < populationList.size(); ++i) {
                     maxListSize = Math.max(maxListSize, populationList.get(i).size());
                  }
                  for(int i = 0; i < maxListSize; ++i) {
                     boolean first = true;
                     for(final List<NondominatedPopulation> pList : populationList) {
                        if(first) {
                           first = false;
                        } else {
                           csvList.write(",".getBytes());
                        }
                        if(pList.size() > i) {
                           final NondominatedPopulation subpopulation = pList.get(i);
                           final double ret = hypervolume.evaluate(subpopulation);
                           csvList.write(String.valueOf(ret).getBytes());
                        }
                     }
                     csvList.write("\n".getBytes());
                  }

                  csvList.write("\n\n\n".getBytes());

                  for(final NondominatedPopulation pop : entry.getValue()) {
                     for(final org.moeaframework.core.Solution sol : pop) {
                        final File solFile = new File(file, "solution_" + index + ".xmi");
                        TransformationResultManager.saveModel(solFile, sol);
                        ++index;
                     }
                  }
               }
            }
            csvList.flush();
            csvList.close();
            csvListImp.flush();
            csvListImp.close();
         } catch(final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

      population = new PopulationAnalyzer(SearchResultManager.createApproximationSet(experiment)).getKneePointSolutions(
            SearchResultManager.createApproximationSet(experiment, (String[]) null), populationSize - 1,
            PopulationAnalyzer.FitnessComparison.PROPER_UTILITY);

      System.out
            .println("- Save Kneepoint models of all algorithms with maximum neighbors to 'output/models/kneepoints/'");
      adaptResultModels(TransformationResultManager.saveModels("output/models/kneepoints/", baseName, population));

      return resultManager;
   }

   protected SearchAnalyzer performAnalysis(final SearchExperiment<TransformationSolution> experiment) {
      final SearchAnalysis analysis = new SearchAnalysis(experiment);
      analysis.setHypervolume(true);
      analysis.setInvertedGenerationalDistance(true);
      analysis.setShowAggregate(true);
      analysis.setShowIndividualValues(true);
      analysis.setShowStatisticalSignificance(true);
      analysis.setSignificanceLevel(significanceLevel);
      final SearchAnalyzer searchAnalyzer = analysis.analyze();
      System.out.println("---------------------------");
      System.out.println("Analysis Results");
      System.out.println("---------------------------");
      searchAnalyzer.printAnalysis();
      System.out.println("---------------------------");
      try {
         System.out.println("- Save Analysis to 'output/analysis/analysis.txt'");
         searchAnalyzer.saveAnalysis(new File("output/analysis/analysis.txt"));
      } catch(final IOException e) {
         e.printStackTrace();
      }
      System.out.println("- Save Indicator BoxPlots to 'output/analysis/'");
      searchAnalyzer.saveIndicatorBoxPlots("output/analysis/", baseName);
      return searchAnalyzer;
   }

   public void performSearch(final String initialGraph, final int solutionLength) {
      final TransformationSearchOrchestration orchestration = createOrchestration(initialGraph, solutionLength);
      deriveBaseName(orchestration);
      printSearchInfo(orchestration);
      final SearchExperiment<TransformationSolution> experiment = createExperiment(orchestration);
      experiment.run();
      System.out.println("-------------------------------------------------------");
      System.out.println("Analysis");
      System.out.println("-------------------------------------------------------");
      performAnalysis(experiment);
      System.out.println("-------------------------------------------------------");
      System.out.println("Results");
      System.out.println("-------------------------------------------------------");
      handleResults(experiment);
   }

   public void printSearchInfo(final TransformationSearchOrchestration orchestration) {
      System.out.println("-------------------------------------------------------");
      System.out.println("Search");
      System.out.println("-------------------------------------------------------");
      System.out.println("InputModel:      " + INITIAL_MODEL);
      System.out.println("Objectives:      " + orchestration.getFitnessFunction().getObjectiveNames());
      System.out.println("NrObjectives:    " + orchestration.getNumberOfObjectives());
      System.out.println("Constraints:     " + orchestration.getFitnessFunction().getConstraintNames());
      System.out.println("NrConstraints:   " + orchestration.getNumberOfConstraints());
      System.out.println("Transformations: " + Arrays.toString(modules));
      System.out.println("Units:           " + orchestration.getModuleManager().getUnits());
      System.out.println("SolutionLength:  " + orchestration.getSolutionLength());
      System.out.println("PopulationSize:  " + populationSize);
      System.out.println("Iterations:      " + maxEvaluations / populationSize);
      System.out.println("MaxEvaluations:  " + maxEvaluations);
      System.out.println("AlgorithmRuns:   " + nrRuns);
      System.out.println("---------------------------");
   }
}
