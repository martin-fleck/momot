package at.ac.tuwien.big.momot.examples.refactoring.momot;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import org.eclipse.ocl.ParserException;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.util.progress.ProgressListener;

@SuppressWarnings("all")
public class RefactoringSearch {
  protected final static String INITIAL_MODEL = "model/SeveralRefactorings.xmi";
  
  protected final static int SOLUTION_LENGTH = 10;
  
  protected final String[] modules = new String[] { "model/Refactoring.henshin" };
  
  protected final ITransformationRepairer solutionRepairer = new TransformationPlaceholderRepairer();
  
  protected final int populationSize = 15;
  
  protected final int maxEvaluations = 150;
  
  protected final int nrRuns = 1;
  
  protected IFitnessDimension<TransformationSolution> _createObjectiveHelper_0() {
    TransformationLengthDimension _transformationLengthDimension = new TransformationLengthDimension();
    return _transformationLengthDimension;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_0(final TransformationSearchOrchestration orchestration) {
    IFitnessDimension dimension = _createObjectiveHelper_0();
    dimension.setName("SolutionLength");
    dimension.setFunctionType(at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum);
    return dimension;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_1(final TransformationSearchOrchestration orchestration) {
    try {
       return new OCLQueryDimension("ContentSize", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum, "propertys->size() * 1.1 + entitys->size()", orchestration.createOCLHelper());
    } catch(ParserException e) {
       e.printStackTrace();
    }
    return null;
  }
  
  protected ModuleManager createModuleManager() {
    ModuleManager manager = new ModuleManager();
    manager.addModules(modules);
    return manager;
  }
  
  protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction(final TransformationSearchOrchestration orchestration) {
    IEGraphMultiDimensionalFitnessFunction function = new EGraphMultiDimensionalFitnessFunction();
    function.addObjective(_createObjective_0(orchestration));
    function.addObjective(_createObjective_1(orchestration));
    function.setSolutionRepairer(solutionRepairer);
    return function;
  }
  
  protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_0(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    TournamentSelection _tournamentSelection = new TournamentSelection(2);
    OnePointCrossover _onePointCrossover = new OnePointCrossover(1.0);
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.15);
    IRegisteredAlgorithm<NSGAII> _createNSGAII = moea.createNSGAII(_tournamentSelection, _onePointCrossover, _transformationPlaceholderMutation);
    return _createNSGAII;
  }
  
  protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_1(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    TournamentSelection _tournamentSelection = new TournamentSelection(2);
    OnePointCrossover _onePointCrossover = new OnePointCrossover(1.0);
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.15);
    IRegisteredAlgorithm<NSGAII> _createNSGAIII = moea.createNSGAIII(_tournamentSelection, _onePointCrossover, _transformationPlaceholderMutation);
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
    
    EvolutionaryAlgorithmFactory moea = orchestration.createEvolutionaryAlgorithmFactory(populationSize);
    LocalSearchAlgorithmFactory local = orchestration.createLocalSearchAlgorithmFactory();
    orchestration.addAlgorithm("NSGAII", _createRegisteredAlgorithm_0(orchestration, moea, local));
    orchestration.addAlgorithm("NSGAIII", _createRegisteredAlgorithm_1(orchestration, moea, local));
    
    return orchestration;
  }
  
  protected SearchExperiment createExperiment(final TransformationSearchOrchestration orchestration) {
    SearchExperiment experiment = new SearchExperiment(orchestration, maxEvaluations);
    experiment.setNumberOfRuns(nrRuns);
    experiment.addProgressListener(_createListener_0());
    return experiment;
  }
  
  protected TransformationResultManager handleResults(final SearchExperiment experiment) {
    TransformationResultManager resultManager = new TransformationResultManager(experiment);
    resultManager.saveApproximationSetObjectives("model/output/referenceSet/approximation_set.pf");
    resultManager.setBaseDirectory("model/output/solutions/");
    resultManager.saveApproximationSetGraphs();
    return resultManager;
  }
  
  public void performSearch(final String initialGraph, final int solutionLength) {
    TransformationSearchOrchestration orchestration = createOrchestration(initialGraph, solutionLength);
    SearchExperiment experiment = createExperiment(orchestration);
    experiment.run();
    handleResults(experiment);
  }
  
  public static void init() {
    RefactoringPackage.eINSTANCE.eClass();
  }
  
  public static void main(final String... args) {
    init();
    RefactoringSearch search = new RefactoringSearch();
    search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
  }
}
