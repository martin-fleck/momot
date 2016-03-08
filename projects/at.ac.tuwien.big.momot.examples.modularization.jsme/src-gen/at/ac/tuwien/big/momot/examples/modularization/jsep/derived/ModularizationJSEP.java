package at.ac.tuwien.big.momot.examples.modularization.jsep.derived;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.print.IPopulationWriter;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.modularization.jsme.ModularizationCalculator;
import at.ac.tuwien.big.momot.examples.modularization.jsme.ModularizationRules;
import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper;
import at.ac.tuwien.big.momot.problem.unit.parameter.increment.IncrementalStringValue;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;
import com.google.common.base.Objects;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.ocl.ParserException;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.moeaframework.algorithm.EpsilonMOEA;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.algorithm.RandomSearch;
import org.moeaframework.core.Population;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.util.progress.ProgressListener;

@SuppressWarnings("all")
public class ModularizationJSEP {
  protected static String attribute = "calculation";
  
  protected static int penalty = 1000;
  
  protected final static String INITIAL_MODEL = "data/input/models/mtunis.xmi";
  
  protected final static int SOLUTION_LENGTH = 50;
  
  public class ModularizationJSEPFitnessFunction extends EGraphMultiDimensionalFitnessFunction {
    @Override
    protected void preprocessEvaluation(final TransformationSolution solution) {
      EGraph _execute = solution.execute();
      final ModularizationModel root = MomotUtil.<ModularizationModel>getRoot(_execute, ModularizationModel.class);
      solution.setAttribute("root", root);
      ModularizationCalculator _modularizationCalculator = new ModularizationCalculator(root);
      solution.setAttribute(ModularizationJSEP.attribute, _modularizationCalculator);
    }
  }
  
  protected final String[] modules = new String[] { "data/modularization_jsep.henshin" };
  
  protected final String _parameterValueKey_0 = ModularizationRules.CreateModule.Parameter.MODULE_NAME;
  
  protected final ITransformationRepairer solutionRepairer = new TransformationPlaceholderRepairer();
  
  protected final int populationSize = 300;
  
  protected final int maxEvaluations = 21000;
  
  protected final int nrRuns = 30;
  
  protected String baseName;
  
  protected IParameterValue<?> _createParameterValue_0() {
    IncrementalStringValue _incrementalStringValue = new IncrementalStringValue("Module", "A");
    return _incrementalStringValue;
  }
  
  protected double _createObjectiveHelper_0(final TransformationSolution solution, final EGraph graph, final EObject root) {
    double _xblockexpression = (double) 0;
    {
      final ModularizationCalculator calculator = solution.<ModularizationCalculator>getAttribute(ModularizationJSEP.attribute, ModularizationCalculator.class);
      ModelMetrics _metrics = calculator.getMetrics();
      _xblockexpression = _metrics.coupling;
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
      final ModularizationCalculator calculator = solution.<ModularizationCalculator>getAttribute(ModularizationJSEP.attribute, ModularizationCalculator.class);
      ModelMetrics _metrics = calculator.getMetrics();
      _xblockexpression = _metrics.cohesion;
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
  
  protected IFitnessDimension<TransformationSolution> _createObjective_2(final TransformationSearchOrchestration orchestration) {
    try {
       return new OCLQueryDimension("NrModules", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Maximum, "modules->size()", orchestration.createOCLHelper());
    } catch(ParserException e) {
       e.printStackTrace();
    }
    return null;
  }
  
  protected double _createObjectiveHelper_3(final TransformationSolution solution, final EGraph graph, final EObject root) {
    double _xblockexpression = (double) 0;
    {
      final ModularizationCalculator calculator = solution.<ModularizationCalculator>getAttribute(ModularizationJSEP.attribute, ModularizationCalculator.class);
      ModelMetrics _metrics = calculator.getMetrics();
      _xblockexpression = _metrics.modularizationQuality;
    }
    return _xblockexpression;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_3(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("MQ", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Maximum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_3(solution, graph, root);
       }
    };
  }
  
  protected double _createObjectiveHelper_4(final TransformationSolution solution, final EGraph graph, final EObject root) {
    int _xblockexpression = (int) 0;
    {
      final ModularizationCalculator calculator = solution.<ModularizationCalculator>getAttribute(ModularizationJSEP.attribute, ModularizationCalculator.class);
      ModelMetrics _metrics = calculator.getMetrics();
      _xblockexpression = _metrics.minMaxDiff;
    }
    return _xblockexpression;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_4(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("MinMaxDiff", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_4(solution, graph, root);
       }
    };
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjectiveHelper_5() {
    TransformationLengthDimension _transformationLengthDimension = new TransformationLengthDimension();
    return _transformationLengthDimension;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_5(final TransformationSearchOrchestration orchestration) {
    IFitnessDimension<TransformationSolution> dimension = _createObjectiveHelper_5();
    dimension.setName("SolutionLength");
    dimension.setFunctionType(at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum);
    return dimension;
  }
  
  protected double _createConstraintHelper_0(final TransformationSolution solution, final EGraph graph, final EObject root) {
    EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> _classes = ((ModularizationModel) root).getClasses();
    final Function1<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class, Boolean> _function = (at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class c) -> {
      Module _module = c.getModule();
      return Boolean.valueOf(Objects.equal(_module, null));
    };
    Iterable<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> _filter = IterableExtensions.<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class>filter(_classes, _function);
    int _size = IterableExtensions.size(_filter);
    return (ModularizationJSEP.penalty * _size);
  }
  
  protected IFitnessDimension<TransformationSolution> _createConstraint_0(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("UnassignedClasses", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createConstraintHelper_0(solution, graph, root);
       }
    };
  }
  
  protected double _createConstraintHelper_1(final TransformationSolution solution, final EGraph graph, final EObject root) {
    EList<Module> _modules = ((ModularizationModel) root).getModules();
    final Function1<Module, Boolean> _function = (Module m) -> {
      EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> _classes = m.getClasses();
      return Boolean.valueOf(_classes.isEmpty());
    };
    Iterable<Module> _filter = IterableExtensions.<Module>filter(_modules, _function);
    int _size = IterableExtensions.size(_filter);
    return (ModularizationJSEP.penalty * _size);
  }
  
  protected IFitnessDimension<TransformationSolution> _createConstraint_1(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("EmptyModules", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createConstraintHelper_1(solution, graph, root);
       }
    };
  }
  
  protected ModuleManager createModuleManager() {
    ModuleManager manager = new ModuleManager();
    manager.addModules(modules);
    manager.setParameterValue(_parameterValueKey_0, _createParameterValue_0());
    return manager;
  }
  
  protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction(final TransformationSearchOrchestration orchestration) {
    IEGraphMultiDimensionalFitnessFunction function = new ModularizationJSEP.ModularizationJSEPFitnessFunction();
    function.addObjective(_createObjective_0(orchestration));
    function.addObjective(_createObjective_1(orchestration));
    function.addObjective(_createObjective_2(orchestration));
    function.addObjective(_createObjective_3(orchestration));
    function.addObjective(_createObjective_4(orchestration));
    function.addObjective(_createObjective_5(orchestration));
    function.addConstraint(_createConstraint_0(orchestration));
    function.addConstraint(_createConstraint_1(orchestration));
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
  
  protected RegisteredAlgorithm<EpsilonMOEA> _createRegisteredAlgorithm_1(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    TournamentSelection _tournamentSelection = new TournamentSelection(2);
    OnePointCrossover _onePointCrossover = new OnePointCrossover(1.0);
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.10);
    SearchHelper _searchHelper = orchestration.getSearchHelper();
    TransformationVariableMutation _transformationVariableMutation = new TransformationVariableMutation(_searchHelper, 0.10);
    RegisteredAlgorithm<EpsilonMOEA> _createEpsilonMOEA = moea.createEpsilonMOEA(
      0.02, _tournamentSelection, _onePointCrossover, _transformationPlaceholderMutation, _transformationVariableMutation);
    return _createEpsilonMOEA;
  }
  
  protected IRegisteredAlgorithm<RandomSearch> _createRegisteredAlgorithm_2(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    IRegisteredAlgorithm<RandomSearch> _createRandomSearch = moea.createRandomSearch();
    return _createRandomSearch;
  }
  
  protected ProgressListener _createListener_0() {
    SeedRuntimePrintListener _seedRuntimePrintListener = new SeedRuntimePrintListener();
    return _seedRuntimePrintListener;
  }
  
  protected boolean _createEqualityHelperHelper_(final EObject left, final EObject right) {
    boolean _xblockexpression = false;
    {
      boolean _and = false;
      if (!(left instanceof Module)) {
        _and = false;
      } else {
        _and = (right instanceof Module);
      }
      if (_and) {
        EObject _eContainer = left.eContainer();
        EList<Module> _modules = ((ModularizationModel) _eContainer).getModules();
        final int leftIndex = _modules.indexOf(left);
        EObject _eContainer_1 = right.eContainer();
        EList<Module> _modules_1 = ((ModularizationModel) _eContainer_1).getModules();
        final int rightIndex = _modules_1.indexOf(right);
        return Integer.valueOf(leftIndex).equals(Integer.valueOf(rightIndex));
      }
      _xblockexpression = left.equals(right);
    }
    return _xblockexpression;
  }
  
  protected IEObjectEqualityHelper _createEqualityHelper_() {
    return new IEObjectEqualityHelper() {
       @Override
       public boolean equals(EObject left, EObject right) {
          return _createEqualityHelperHelper_(left, right);
       }
    };
  }
  
  protected EGraph createInputGraph(final String initialGraph, final ModuleManager moduleManager) {
    EGraph graph = moduleManager.loadGraph(initialGraph);
    return graph;
  }
  
  protected TransformationSearchOrchestration createOrchestration(final String initialGraph, final int solutionLength) {
    TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
    ModuleManager moduleManager = createModuleManager();
    EGraph graph = createInputGraph(initialGraph, moduleManager);
    orchestration.setModuleManager(moduleManager);
    orchestration.setProblemGraph(graph);
    orchestration.setSolutionLength(solutionLength);
    orchestration.setFitnessFunction(createFitnessFunction(orchestration));
    orchestration.setEqualityHelper(_createEqualityHelper_());
    
    EvolutionaryAlgorithmFactory<TransformationSolution> moea = orchestration.createEvolutionaryAlgorithmFactory(populationSize);
    LocalSearchAlgorithmFactory<TransformationSolution> local = orchestration.createLocalSearchAlgorithmFactory();
    orchestration.addAlgorithm("NSGAIII", _createRegisteredAlgorithm_0(orchestration, moea, local));
    orchestration.addAlgorithm("eMOEA", _createRegisteredAlgorithm_1(orchestration, moea, local));
    orchestration.addAlgorithm("RS", _createRegisteredAlgorithm_2(orchestration, moea, local));
    
    return orchestration;
  }
  
  protected SearchExperiment<TransformationSolution> createExperiment(final TransformationSearchOrchestration orchestration) {
    SearchExperiment<TransformationSolution> experiment = new SearchExperiment<TransformationSolution>(orchestration, maxEvaluations);
    experiment.setNumberOfRuns(nrRuns);
    experiment.addProgressListener(_createListener_0());
    return experiment;
  }
  
  protected void deriveBaseName(final TransformationSearchOrchestration orchestration) {
    EObject root = MomotUtil.getRoot(orchestration.getProblemGraph());
    if(root == null || root.eResource() == null || root.eResource().getURI() == null)
    	baseName = getClass().getSimpleName();
    else
    	baseName = root.eResource().getURI().trimFileExtension().lastSegment();
  }
  
  protected double significanceLevel = 0.01;
  
  protected SearchAnalyzer performAnalysis(final SearchExperiment<TransformationSolution> experiment) {
    SearchAnalysis analysis = new SearchAnalysis(experiment);
    analysis.setHypervolume(true);
    analysis.setGenerationalDistance(true);
    analysis.setContribution(true);
    analysis.setShowAggregate(true);
    analysis.setShowIndividualValues(true);
    analysis.setShowStatisticalSignificance(true);
    analysis.setSignificanceLevel(significanceLevel);
    SearchAnalyzer searchAnalyzer = analysis.analyze();
    try {
    	System.out.println("- Save Analysis to 'data/output/analysis/mtunis_statistic2.txt'");
    	searchAnalyzer.saveAnalysis(new File("data/output/analysis/mtunis_statistic2.txt"));
    } catch(IOException e) {
    	e.printStackTrace();
    }
    return searchAnalyzer;
  }
  
  protected TransformationResultManager handleResults(final SearchExperiment<TransformationSolution> experiment) {
    ISolutionWriter<TransformationSolution> solutionWriter = experiment.getSearchOrchestration().createSolutionWriter();
    IPopulationWriter<TransformationSolution> populationWriter = experiment.getSearchOrchestration().createPopulationWriter();
    TransformationResultManager resultManager = new TransformationResultManager(experiment);
    Population population;
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("- Save objectives of all algorithms to 'data/output/approximationSet/mtunis_statistic2.pf'");
    TransformationResultManager.saveObjectives(
    	"data/output/approximationSet/mtunis_statistic2.pf",
    	population
    );
    System.out.println("---------------------------");
    System.out.println("Objectives of all algorithms");
    System.out.println("---------------------------");
    System.out.println(TransformationResultManager.printObjectives(
    	population
    ));
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("- Save models of all algorithms to 'data/output/models/mtunis_statistic2/'");
    TransformationResultManager.saveModels(
    	"data/output/models/mtunis_statistic2/",
    	baseName,
    	population
    );
    
    return resultManager;
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
  
  public void performSearch(final String initialGraph, final int solutionLength) {
    TransformationSearchOrchestration orchestration = createOrchestration(initialGraph, solutionLength);
    deriveBaseName(orchestration);
    printSearchInfo(orchestration);
    SearchExperiment<TransformationSolution> experiment = createExperiment(orchestration);
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
  
  public static void initialization() {
    ModularizationPackage.eINSTANCE.getClass();
  }
  
  public static void main(final String... args) {
    initialization();
    ModularizationJSEP search = new ModularizationJSEP();
    search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
  }
}
