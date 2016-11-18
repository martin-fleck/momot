package at.ac.tuwien.big.momot.examples.stack.momot;

import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.print.IPopulationWriter;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.stack.StackModule;
import at.ac.tuwien.big.momot.examples.stack.stack.Stack;
import at.ac.tuwien.big.momot.examples.stack.stack.StackModel;
import at.ac.tuwien.big.momot.examples.stack.stack.StackPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomIntegerValue;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.algorithm.RandomSearch;
import org.moeaframework.core.Population;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.util.progress.ProgressListener;

@SuppressWarnings("all")
public class StackSearchExample {
  protected final static String INITIAL_MODEL = "model/input/model/model_five_stacks.xmi";
  
  protected final static int SOLUTION_LENGTH = 8;
  
  protected final String[] modules = new String[] { "model/stack.henshin" };
  
  protected final String[] unitsToRemove = new String[] { StackModule.CreateStack.NAME, StackModule.ConnectStacks.NAME };
  
  protected final String _parameterValueKey_0 = StackModule.ShiftLeft.Parameter.AMOUNT;
  
  protected final String _parameterValueKey_1 = StackModule.ShiftRight.Parameter.AMOUNT;
  
  protected final String[] nonSolutionParameters = new String[] { StackModule.ShiftLeft.Parameter.FROM_LOAD, StackModule.ShiftLeft.Parameter.TO_LOAD, StackModule.ShiftRight.Parameter.FROM_LOAD, StackModule.ShiftRight.Parameter.TO_LOAD };
  
  protected final ITransformationRepairer solutionRepairer = new TransformationPlaceholderRepairer();
  
  protected final int populationSize = 100;
  
  protected final int maxEvaluations = 2000;
  
  protected final int nrRuns = 5;
  
  protected String baseName;
  
  protected IParameterValue<?> _createParameterValue_0() {
    RandomIntegerValue _randomIntegerValue = new RandomIntegerValue(1, 5);
    return _randomIntegerValue;
  }
  
  protected IParameterValue<?> _createParameterValue_1() {
    RandomIntegerValue _randomIntegerValue = new RandomIntegerValue(1, 5);
    return _randomIntegerValue;
  }
  
  protected double _createObjectiveHelper_0(final TransformationSolution solution, final EGraph graph, final EObject root) {
    EList<Stack> _stacks = ((StackModel) root).getStacks();
    final Function1<Stack, Integer> _function = (Stack it) -> {
      return Integer.valueOf(it.getLoad());
    };
    List<Integer> _map = ListExtensions.<Stack, Integer>map(_stacks, _function);
    return MathUtil.getStandardDeviation(_map);
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_0(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("StandardDeviation", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_0(solution, graph, root);
       }
    };
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjectiveHelper_1() {
    TransformationLengthDimension _transformationLengthDimension = new TransformationLengthDimension();
    return _transformationLengthDimension;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_1(final TransformationSearchOrchestration orchestration) {
    IFitnessDimension<TransformationSolution> dimension = _createObjectiveHelper_1();
    dimension.setName("SolutionLength");
    dimension.setFunctionType(at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum);
    return dimension;
  }
  
  protected ModuleManager createModuleManager() {
    ModuleManager manager = new ModuleManager();
    manager.addModules(modules);
    manager.removeUnits(unitsToRemove);
    manager.addNonSolutionParameters(nonSolutionParameters);
    manager.setParameterValue(_parameterValueKey_0, _createParameterValue_0());
    manager.setParameterValue(_parameterValueKey_1, _createParameterValue_1());
    return manager;
  }
  
  protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction(final TransformationSearchOrchestration orchestration) {
    IEGraphMultiDimensionalFitnessFunction function = new EGraphMultiDimensionalFitnessFunction();
    function.addObjective(_createObjective_0(orchestration));
    function.addObjective(_createObjective_1(orchestration));
    function.setSolutionRepairer(solutionRepairer);
    return function;
  }
  
  protected IRegisteredAlgorithm<RandomSearch> _createRegisteredAlgorithm_0(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    IRegisteredAlgorithm<RandomSearch> _createRandomSearch = moea.createRandomSearch();
    return _createRandomSearch;
  }
  
  protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_1(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    TournamentSelection _tournamentSelection = new TournamentSelection(2);
    OnePointCrossover _onePointCrossover = new OnePointCrossover(1.0);
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.15);
    ModuleManager _moduleManager = orchestration.getModuleManager();
    TransformationParameterMutation _transformationParameterMutation = new TransformationParameterMutation(0.1, _moduleManager);
    IRegisteredAlgorithm<NSGAII> _createNSGAII = moea.createNSGAII(_tournamentSelection, _onePointCrossover, _transformationPlaceholderMutation, _transformationParameterMutation);
    return _createNSGAII;
  }
  
  protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_2(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    TournamentSelection _tournamentSelection = new TournamentSelection(2);
    OnePointCrossover _onePointCrossover = new OnePointCrossover(1.0);
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.15);
    ModuleManager _moduleManager = orchestration.getModuleManager();
    TransformationParameterMutation _transformationParameterMutation = new TransformationParameterMutation(0.1, _moduleManager);
    IRegisteredAlgorithm<NSGAII> _createNSGAIII = moea.createNSGAIII(
      4, _tournamentSelection, _onePointCrossover, _transformationPlaceholderMutation, _transformationParameterMutation);
    return _createNSGAIII;
  }
  
  protected ProgressListener _createListener_0() {
    SeedRuntimePrintListener _seedRuntimePrintListener = new SeedRuntimePrintListener();
    return _seedRuntimePrintListener;
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
    
    EvolutionaryAlgorithmFactory<TransformationSolution> moea = orchestration.createEvolutionaryAlgorithmFactory(populationSize);
    LocalSearchAlgorithmFactory<TransformationSolution> local = orchestration.createLocalSearchAlgorithmFactory();
    orchestration.addAlgorithm("Random", _createRegisteredAlgorithm_0(orchestration, moea, local));
    orchestration.addAlgorithm("NSGA_II", _createRegisteredAlgorithm_1(orchestration, moea, local));
    orchestration.addAlgorithm("NSGA_III", _createRegisteredAlgorithm_2(orchestration, moea, local));
    
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
    analysis.setAdditiveEpsilonIndicator(true);
    analysis.setHypervolume(true);
    analysis.setMaximumParetoFrontError(true);
    analysis.setShowAggregate(true);
    analysis.setShowIndividualValues(true);
    analysis.setShowStatisticalSignificance(true);
    analysis.setSignificanceLevel(significanceLevel);
    SearchAnalyzer searchAnalyzer = analysis.analyze();
    System.out.println("---------------------------");
    System.out.println("Analysis Results");
    System.out.println("---------------------------");
    searchAnalyzer.printAnalysis();
    System.out.println("---------------------------");
    try {
    	System.out.println("- Save Analysis to 'example/output/analysis.txt'");
    	searchAnalyzer.saveAnalysis(new File("example/output/analysis.txt"));
    } catch(IOException e) {
    	e.printStackTrace();
    }
    System.out.println("- Save Indicator BoxPlots to 'example/output/boxplot/'");
    searchAnalyzer.saveIndicatorBoxPlots(
    	"example/output/boxplot/",
    	baseName
    );
    return searchAnalyzer;
  }
  
  protected TransformationResultManager handleResults(final SearchExperiment<TransformationSolution> experiment) {
    ISolutionWriter<TransformationSolution> solutionWriter = experiment.getSearchOrchestration().createSolutionWriter();
    IPopulationWriter<TransformationSolution> populationWriter = experiment.getSearchOrchestration().createPopulationWriter();
    TransformationResultManager resultManager = new TransformationResultManager(experiment);
    Population population;
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("---------------------------");
    System.out.println("Objectives of all algorithms");
    System.out.println("---------------------------");
    System.out.println(TransformationResultManager.printObjectives(
    	population
    ));
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("- Save objectives of all algorithms to 'example/output/overall_objectives.pf'");
    TransformationResultManager.saveObjectives(
    	"example/output/overall_objectives.pf",
    	population
    );
    System.out.println("---------------------------");
    System.out.println("Objectives of all algorithms");
    System.out.println("---------------------------");
    System.out.println(TransformationResultManager.printObjectives(
    	population
    ));
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, "NSGA_III", "NSGA_II");
    System.out.println("- Save objectives of 'NSGA_III', 'NSGA_II' to 'example/output/moea_objectives.pf'");
    TransformationResultManager.saveObjectives(
    	"example/output/moea_objectives.pf",
    	population
    );
    System.out.println("---------------------------");
    System.out.println("Objectives of 'NSGA_III', 'NSGA_II'");
    System.out.println("---------------------------");
    System.out.println(TransformationResultManager.printObjectives(
    	population
    ));
    
    population = 
    	new PopulationAnalyzer(TransformationResultManager.createApproximationSet(experiment))
    		.getKneePointSolutions(
    			TransformationResultManager.createApproximationSet(experiment, "NSGA_III", "NSGA_II"),
    			3,
    			PopulationAnalyzer.FitnessComparison.PROPER_UTILITY);
    System.out.println("- Save Kneepoint Objectives of 'NSGA_III', 'NSGA_II' with 3 neighbors to 'example/output/moea_kneepoints_objectives.pf'");
    TransformationResultManager.saveObjectives(
    	"example/output/moea_kneepoints_objectives.pf",
    	population
    );
    System.out.println("---------------------------");
    System.out.println("Kneepoint Objectives of 'NSGA_III', 'NSGA_II' with 3 neighbors");
    System.out.println("---------------------------");
    System.out.println(TransformationResultManager.printObjectives(
    	population
    ));
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("- Save solutions of all algorithms to 'example/output/overall_solutions.txt'");
    TransformationResultManager.savePopulation(
    	"example/output/overall_solutions.txt",
    	population,
    	populationWriter
    );
    System.out.println("- Save solutions of all algorithms to 'example/output/overall_solutions.txt'");
    TransformationResultManager.saveSolutions(
    	"example/output/solutions/all/",
    	baseName,
    	MomotUtil.asIterables(
    		population,
    		TransformationSolution.class),
    	solutionWriter
    );
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, "NSGA_III", "NSGA_II");
    System.out.println("- Save solutions of 'NSGA_III', 'NSGA_II' to 'example/output/moea_solutions.txt'");
    TransformationResultManager.savePopulation(
    	"example/output/moea_solutions.txt",
    	population,
    	populationWriter
    );
    System.out.println("- Save solutions of 'NSGA_III', 'NSGA_II' to 'example/output/moea_solutions.txt'");
    TransformationResultManager.saveSolutions(
    	"example/output/solutions/moea/",
    	baseName,
    	MomotUtil.asIterables(
    		population,
    		TransformationSolution.class),
    	solutionWriter
    );
    
    population = 
    	new PopulationAnalyzer(TransformationResultManager.createApproximationSet(experiment))
    		.getKneePointSolutions(
    			TransformationResultManager.createApproximationSet(experiment, "NSGA_III", "NSGA_II"),
    			populationSize-1,
    			PopulationAnalyzer.FitnessComparison.PROPER_UTILITY);
    System.out.println("- Save Kneepoint solutions of 'NSGA_III', 'NSGA_II' with maximum neighbors to 'example/output/solutions/moea_kneepoint_solutions.txt'");
    TransformationResultManager.savePopulation(
    	"example/output/solutions/moea_kneepoint_solutions.txt",
    	population,
    	populationWriter
    );
    System.out.println("- Save solutions of 'NSGA_III', 'NSGA_II' to 'example/output/solutions/moea_kneepoint_solutions.txt'");
    TransformationResultManager.saveSolutions(
    	"example/output/solutions/moea/kneepoints/",
    	baseName,
    	MomotUtil.asIterables(
    		population,
    		TransformationSolution.class),
    	solutionWriter
    );
    System.out.println("---------------------------");
    System.out.println("Kneepoint solutions of 'NSGA_III', 'NSGA_II' with maximum neighbors");
    System.out.println("---------------------------");
    TransformationResultManager.printPopulation(
    	population,
    	populationWriter
    );
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("- Save models of all algorithms to 'example/output/models/testing ladida'");
    TransformationResultManager.saveModels(
    	"example/output/models/testing ladida",
    	baseName,
    	population
    );
    System.out.println("---------------------------");
    System.out.println("Models of all algorithms");
    System.out.println("---------------------------");
    System.out.println(TransformationResultManager.printModels(
    	population
    ));
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, "NSGA_III", "NSGA_II");
    System.out.println("- Save models of 'NSGA_III', 'NSGA_II' to 'example/output/models/moea/'");
    TransformationResultManager.saveModels(
    	"example/output/models/moea/",
    	baseName,
    	population
    );
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, "Random");
    System.out.println("- Save models of 'Random' to 'example/output/models/random/'");
    TransformationResultManager.saveModels(
    	"example/output/models/random/",
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
    StackPackage.eINSTANCE.getClass();
  }
  
  public static void main(final String... args) {
    initialization();
    StackSearchExample search = new StackSearchExample();
    search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
  }
}
