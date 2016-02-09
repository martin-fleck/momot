package at.ac.tuwien.big.momot.examples.ecore.derived;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.LanguageMetrics;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.MetricsCalculator;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Entity;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;
import java.io.File;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.util.progress.ProgressListener;

@SuppressWarnings("all")
public class ModularizationQVTSearch {
  protected final static String INITIAL_MODEL = "input/QVT_module.xmi";
  
  protected final static int SOLUTION_LENGTH = 10;
  
  protected static String attribute = "metrics";
  
  public class ModularizationQVTFitnessFunction extends EGraphMultiDimensionalFitnessFunction {
    @Override
    protected void preprocessEvaluation(final TransformationSolution solution) {
      EGraph _execute = solution.execute();
      final Language root = MomotUtil.<Language>getRoot(_execute, Language.class);
      LanguageMetrics _calculate = MetricsCalculator.calculate(root);
      solution.setAttribute(ModularizationQVTSearch.attribute, _calculate);
    }
  }
  
  protected final String[] modules = new String[] { "operations/modularization_rules.henshin" };
  
  protected final ITransformationRepairer solutionRepairer = new TransformationPlaceholderRepairer();
  
  protected final int populationSize = 300;
  
  protected final int maxEvaluations = 21000;
  
  protected final int nrRuns = 30;
  
  protected double _createObjectiveHelper_0(final TransformationSolution solution, final EGraph graph, final EObject root) {
    double _xblockexpression = (double) 0;
    {
      final LanguageMetrics metrics = solution.<LanguageMetrics>getAttribute(ModularizationQVTSearch.attribute, LanguageMetrics.class);
      _xblockexpression = metrics.getCoupling();
    }
    return _xblockexpression;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_0(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("Coupling", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_0(solution, graph, root);
       }
    };
  }
  
  protected double _createObjectiveHelper_1(final TransformationSolution solution, final EGraph graph, final EObject root) {
    double _xblockexpression = (double) 0;
    {
      final LanguageMetrics metrics = solution.<LanguageMetrics>getAttribute(ModularizationQVTSearch.attribute, LanguageMetrics.class);
      _xblockexpression = metrics.getCohesion();
    }
    return _xblockexpression;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_1(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("Cohesion", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Maximum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_1(solution, graph, root);
       }
    };
  }
  
  protected double _createObjectiveHelper_2(final TransformationSolution solution, final EGraph graph, final EObject root) {
    EList<Module> _modules = ((Language) root).getModules();
    final Function1<Module, Boolean> _function = (Module m) -> {
      EList<Entity> _entities = m.getEntities();
      boolean _isEmpty = _entities.isEmpty();
      return Boolean.valueOf((!_isEmpty));
    };
    Iterable<Module> _filter = IterableExtensions.<Module>filter(_modules, _function);
    return IterableExtensions.size(_filter);
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_2(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("NrModules", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Maximum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_2(solution, graph, root);
       }
    };
  }
  
  protected double _createObjectiveHelper_3(final TransformationSolution solution, final EGraph graph, final EObject root) {
    int _xblockexpression = (int) 0;
    {
      EList<Module> _modules = ((Language) root).getModules();
      final Function1<Module, Boolean> _function = (Module m) -> {
        EList<Entity> _entities = m.getEntities();
        boolean _isEmpty = _entities.isEmpty();
        return Boolean.valueOf((!_isEmpty));
      };
      Iterable<Module> _filter = IterableExtensions.<Module>filter(_modules, _function);
      final Function1<Module, Integer> _function_1 = (Module m) -> {
        EList<Entity> _entities = m.getEntities();
        return Integer.valueOf(_entities.size());
      };
      final Iterable<Integer> sizes = IterableExtensions.<Module, Integer>map(_filter, _function_1);
      Integer _max = IterableExtensions.<Integer>max(sizes);
      Integer _min = IterableExtensions.<Integer>min(sizes);
      _xblockexpression = ((_max).intValue() - (_min).intValue());
    }
    return _xblockexpression;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_3(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("MinMaxDiffTest", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_3(solution, graph, root);
       }
    };
  }
  
  protected ModuleManager createModuleManager() {
    ModuleManager manager = new ModuleManager();
    manager.addModules(modules);
    return manager;
  }
  
  protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction(final TransformationSearchOrchestration orchestration) {
    IEGraphMultiDimensionalFitnessFunction function = new ModularizationQVTSearch.ModularizationQVTFitnessFunction();
    function.addObjective(_createObjective_0(orchestration));
    function.addObjective(_createObjective_1(orchestration));
    function.addObjective(_createObjective_2(orchestration));
    function.addObjective(_createObjective_3(orchestration));
    function.setSolutionRepairer(solutionRepairer);
    return function;
  }
  
  protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_0(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    TournamentSelection _tournamentSelection = new TournamentSelection(2);
    OnePointCrossover _onePointCrossover = new OnePointCrossover(1.0);
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.10);
    SearchHelper _searchHelper = orchestration.getSearchHelper();
    TransformationVariableMutation _transformationVariableMutation = new TransformationVariableMutation(_searchHelper, 0.10);
    IRegisteredAlgorithm<NSGAII> _createNSGAIII = moea.createNSGAIII(
      0, 6, _tournamentSelection, _onePointCrossover, _transformationPlaceholderMutation, _transformationVariableMutation);
    return _createNSGAIII;
  }
  
  protected ProgressListener _createListener_0() {
    SeedRuntimePrintListener _seedRuntimePrintListener = new SeedRuntimePrintListener();
    return _seedRuntimePrintListener;
  }
  
  protected TransformationSearchOrchestration createOrchestration(final String initialGraph, final int solutionLength) {
    TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
    orchestration.setModuleManager(createModuleManager());
    orchestration.setProblemGraph(initialGraph);
    orchestration.setSolutionLength(solutionLength);
    orchestration.setFitnessFunction(createFitnessFunction(orchestration));
    
    EvolutionaryAlgorithmFactory<TransformationSolution> moea = orchestration.createEvolutionaryAlgorithmFactory(populationSize);
    LocalSearchAlgorithmFactory<TransformationSolution> local = orchestration.createLocalSearchAlgorithmFactory();
    orchestration.addAlgorithm("NSGAIII", _createRegisteredAlgorithm_0(orchestration, moea, local));
    
    return orchestration;
  }
  
  protected SearchExperiment createExperiment(final TransformationSearchOrchestration orchestration) {
    SearchExperiment experiment = new SearchExperiment(orchestration, maxEvaluations);
    experiment.setNumberOfRuns(nrRuns);
    experiment.addProgressListener(_createListener_0());
    return experiment;
  }
  
  protected double significanceLevel = 0.01;
  
  protected SearchAnalyzer performAnalysis(final SearchExperiment experiment) {
    SearchAnalysis analysis = new SearchAnalysis(experiment);
    analysis.setHypervolume(true);
    analysis.setGenerationalDistance(true);
    analysis.setContribution(true);
    analysis.setShowAggregate(true);
    analysis.setShowIndividualValues(true);
    analysis.setShowStatisticalSignificance(true);
    analysis.setSignificanceLevel(significanceLevel);
    return analysis.analyze();
  }
  
  protected TransformationResultManager handleResults(final SearchExperiment experiment) {
    TransformationResultManager resultManager = new TransformationResultManager(experiment);
    resultManager.saveApproximationSetObjectives("data/_test/approximationSet/QVT.pf");
    resultManager.setBaseDirectory("data/_test/models/QVT/");
    resultManager.saveApproximationSetGraphs();
    System.out.println(resultManager.printApproximationSet());
    System.out.println(resultManager.printApproximationSetObjectives());
    return resultManager;
  }
  
  public void performSearch(final String initialGraph, final int solutionLength) {
    TransformationSearchOrchestration orchestration = createOrchestration(initialGraph, solutionLength);
    SearchExperiment experiment = createExperiment(orchestration);
    experiment.run();
    SearchAnalyzer analyzer = performAnalysis(experiment);
    try {
       analyzer.saveAnalysis(new File("output/_test/QVT.txt"));
    } catch(IOException e) {
       e.printStackTrace();
    }
    handleResults(experiment);
  }
  
  public static void init() {
    ModularizationPackage.eINSTANCE.getClass();
  }
  
  public static void main(final String... args) {
    init();
    ModularizationQVTSearch search = new ModularizationQVTSearch();
    search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
  }
}
