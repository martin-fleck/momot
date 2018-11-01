package at.ac.tuwien.big.momot.examples.refactoring.momot;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.print.IPopulationWriter;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;
import java.io.File;
import java.util.Arrays;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.ocl.ParserException;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.core.Population;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.util.progress.ProgressListener;

@SuppressWarnings("all")
public class Refactoring {
  protected final static String INITIAL_MODEL = "model/SeveralRefactorings.xmi";
  
  protected final static int SOLUTION_LENGTH = 10;
  
  protected final String[] modules = new String[] { "model/Refactoring.henshin" };
  
  protected final ITransformationRepairer solutionRepairer = new TransformationPlaceholderRepairer();
  
  protected final int populationSize = 100;
  
  protected final int maxEvaluations = 1500;
  
  protected final int nrRuns = 30;
  
  protected int maxSeconds;
  
  protected String baseName;
  
  protected IFitnessDimension<TransformationSolution> _createObjectiveHelper_0() {
    TransformationLengthDimension _transformationLengthDimension = new TransformationLengthDimension();
    return _transformationLengthDimension;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_0(final TransformationSearchOrchestration orchestration) {
    IFitnessDimension<TransformationSolution> dimension = _createObjectiveHelper_0();
    dimension.setName("SolutionLength");
    dimension.setFunctionType(at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum);
    return dimension;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_1(final TransformationSearchOrchestration orchestration) {
    try {
       return new OCLQueryDimension("ContentSize", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum, "properties->size() * 1.1 + entities->size()", orchestration.createOCLHelper());
    } catch(ParserException e) {
       e.printStackTrace();
    }
    return null;
  }
  
  protected ModuleManager createModuleManager() {
    ModuleManager manager = new ModuleManager();
    for(String module : modules) {
       manager.addModule(URI.createFileURI(new File(module).getPath().toString()).toString());
    }
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
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.05);
    ModuleManager _moduleManager = orchestration.getModuleManager();
    TransformationParameterMutation _transformationParameterMutation = new TransformationParameterMutation(0.05, _moduleManager);
    SearchHelper _searchHelper = orchestration.getSearchHelper();
    TransformationVariableMutation _transformationVariableMutation = new TransformationVariableMutation(_searchHelper, 0.05);
    IRegisteredAlgorithm<NSGAII> _createNSGAII = moea.createNSGAII(_tournamentSelection, _onePointCrossover, _transformationPlaceholderMutation, _transformationParameterMutation, _transformationVariableMutation);
    return _createNSGAII;
  }
  
  protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_1(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
    TournamentSelection _tournamentSelection = new TournamentSelection(2);
    TransformationPlaceholderMutation _transformationPlaceholderMutation = new TransformationPlaceholderMutation(0.4);
    ModuleManager _moduleManager = orchestration.getModuleManager();
    TransformationParameterMutation _transformationParameterMutation = new TransformationParameterMutation(0.4, _moduleManager);
    SearchHelper _searchHelper = orchestration.getSearchHelper();
    TransformationVariableMutation _transformationVariableMutation = new TransformationVariableMutation(_searchHelper, 0.4);
    IRegisteredAlgorithm<NSGAII> _createNSGAII = moea.createNSGAII(_tournamentSelection, _transformationPlaceholderMutation, _transformationParameterMutation, _transformationVariableMutation);
    return _createNSGAII;
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
    orchestration.addAlgorithm("NSGAII", _createRegisteredAlgorithm_0(orchestration, moea, local));
    orchestration.addAlgorithm("NSGAII_OM", _createRegisteredAlgorithm_1(orchestration, moea, local));
    
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
  
  protected TransformationResultManager handleResults(final SearchExperiment<TransformationSolution> experiment) {
    ISolutionWriter<TransformationSolution> solutionWriter = experiment.getSearchOrchestration().createSolutionWriter();
    IPopulationWriter<TransformationSolution> populationWriter = experiment.getSearchOrchestration().createPopulationWriter();
    TransformationResultManager resultManager = new TransformationResultManager(experiment);
    Population population;
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("- Save objectives of all algorithms to 'model/output/referenceSet/approximation_set.pf'");
    TransformationResultManager.saveObjectives(
    	"model/output/referenceSet/approximation_set.pf",
    	population
    );
    
    population = 
    	TransformationResultManager.createApproximationSet(experiment, (String[])null);
    System.out.println("- Save models of all algorithms to 'model/output/solutions/'");
    TransformationResultManager.saveModels(
    	"model/output/solutions/",
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
    System.out.println("Results");
    System.out.println("-------------------------------------------------------");
    handleResults(experiment);
  }
  
  public static void initialization() {
    RefactoringPackage.eINSTANCE.eClass();
  }
  
  public static void main(final String... args) {
    initialization();
    Refactoring search = new Refactoring();
    search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
  }
}
