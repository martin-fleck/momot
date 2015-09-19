import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.moeaframework.algorithm.RandomSearch;

@SuppressWarnings("all")
public class EMFRefactorSearchSearch {
  protected final static String INITIAL_MODEL = "model/input/simple_example.ecore";
  
  protected final static int SOLUTION_LENGTH = 10;
  
  protected final String[] modules = new String[] { "transformation/refactorings/ecore/remove_empty_sub_eclass.henshin" };
  
  protected final int populationSize = 50;
  
  protected final int maxEvaluations = 500;
  
  protected final int nrRuns = 30;
  
  protected IFitnessDimension<TransformationSolution> _createObjective_0(final TransformationSearchOrchestration orchestration) {
    try {
       return new OCLQueryDimension("NrClasses", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum, "eClassifiers->size()", orchestration.createOCLHelper());
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
    return function;
  }
  
  protected IRegisteredAlgorithm<RandomSearch> _createRegisteredAlgorithm_0(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    IRegisteredAlgorithm<RandomSearch> _createRandomSearch = moea.createRandomSearch();
    return _createRandomSearch;
  }
  
  protected TransformationSearchOrchestration createOrchestration(final String initialGraph, final int solutionLength) {
    TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
    orchestration.setModuleManager(createModuleManager());
    orchestration.setProblemGraph(initialGraph);
    orchestration.setSolutionLength(solutionLength);
    orchestration.setFitnessFunction(createFitnessFunction(orchestration));
    
    EvolutionaryAlgorithmFactory moea = orchestration.createEvolutionaryAlgorithmFactory(populationSize);
    LocalSearchAlgorithmFactory local = orchestration.createLocalSearchAlgorithmFactory();
    orchestration.addAlgorithm("RandomSearch", _createRegisteredAlgorithm_0(orchestration, moea, local));
    
    return orchestration;
  }
  
  protected SearchExperiment createExperiment(final TransformationSearchOrchestration orchestration) {
    SearchExperiment experiment = new SearchExperiment(orchestration, maxEvaluations);
    experiment.setNumberOfRuns(nrRuns);
    return experiment;
  }
  
  protected TransformationResultManager handleResults(final SearchExperiment experiment) {
    TransformationResultManager resultManager = new TransformationResultManager(experiment);
    resultManager.saveApproximationSetObjectives("objectives.pf");
    resultManager.setBaseDirectory("output/");
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
    EcorePackage.eINSTANCE.eClass();
  }
  
  public static void main(final String... args) {
    init();
    EMFRefactorSearchSearch search = new EMFRefactorSearchSearch();
    search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
  }
}
