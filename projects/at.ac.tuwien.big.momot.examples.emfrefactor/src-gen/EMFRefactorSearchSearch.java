import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.emfrefactor.metric.NSUBEC;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.DefaultEObjectEqualityHelper;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.util.MomotUtil;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.util.progress.ProgressListener;

@SuppressWarnings("all")
public class EMFRefactorSearchSearch {
  protected final static String INITIAL_MODEL = "model/input/metamodel.ecore";
  
  protected final static int SOLUTION_LENGTH = 5;
  
  protected final String[] modules = new String[] { "transformation/refactorings/ecore/remove_empty_sub_eclass_all.henshin" };
  
  protected final String[] unitsToRemove = new String[] { "remove_empty_sub_eclass_all::removeEmptySubEClass::check_subetypes", "remove_empty_sub_eclass_all::removeEmptySubEClass::check_superetypes", "remove_empty_sub_eclass_all::removeEmptySubEClass::check_empty_eclass", "remove_empty_sub_eclass_all::removeEmptySubEClass::initialCheck", "remove_empty_sub_eclass_all::removeEmptySubEClass::check_preconditions", "remove_empty_sub_eclass_all::removeEmptySubEClass::execute", "remove_empty_sub_eclass_all::removeEmptySubEClass::remove" };
  
  protected final int populationSize = 50;
  
  protected final int maxEvaluations = 1000;
  
  protected final int nrRuns = 30;
  
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
  
  protected double _createObjectiveHelper_1(final TransformationSolution solution, final EGraph graph, final EObject root) {
    final NSUBEC subClassCalculator = new NSUBEC();
    EClass _eClass = EcorePackage.Literals.ECLASS.eClass();
    final List<EObject> eClasses = graph.getDomain(_eClass, true);
    double subClasses = 0.0;
    for (final EObject eClass : eClasses) {
      {
        subClassCalculator.setContext(Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(eClass)));
        double _subClasses = subClasses;
        double _calculate = subClassCalculator.calculate();
        subClasses = (_subClasses + _calculate);
      }
    }
    return subClasses;
  }
  
  protected IFitnessDimension<TransformationSolution> _createObjective_1(final TransformationSearchOrchestration orchestration) {
    return new AbstractEGraphFitnessDimension("SubClasses", at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
       @Override
       protected double internalEvaluate(TransformationSolution solution) {
    		EGraph graph = solution.execute();
          EObject root = MomotUtil.getRoot(graph);
          return _createObjectiveHelper_1(solution, graph, root);
       }
    };
  }
  
  protected ModuleManager createModuleManager() {
    ModuleManager manager = new ModuleManager();
    manager.addModules(modules);
    manager.removeUnits(unitsToRemove);
    return manager;
  }
  
  protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction(final TransformationSearchOrchestration orchestration) {
    IEGraphMultiDimensionalFitnessFunction function = new EGraphMultiDimensionalFitnessFunction();
    function.addObjective(_createObjective_0(orchestration));
    function.addObjective(_createObjective_1(orchestration));
    return function;
  }
  
  protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_0(final TransformationSearchOrchestration orchestration, final EvolutionaryAlgorithmFactory<TransformationSolution> moea, final LocalSearchAlgorithmFactory<TransformationSolution> local) {
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
  
  protected boolean _createEqualityHelperHelper_(final EObject left, final EObject right) {
    boolean _and = false;
    if (!(left instanceof ENamedElement)) {
      _and = false;
    } else {
      _and = (right instanceof ENamedElement);
    }
    if (_and) {
      String _name = ((ENamedElement) left).getName();
      String _name_1 = ((ENamedElement) right).getName();
      return _name.equals(_name_1);
    }
    DefaultEObjectEqualityHelper _defaultEObjectEqualityHelper = new DefaultEObjectEqualityHelper();
    return _defaultEObjectEqualityHelper.equals(left, right);
  }
  
  protected IEObjectEqualityHelper _createEqualityHelper_() {
    return new IEObjectEqualityHelper() {
       @Override
       public boolean equals(EObject left, EObject right) {
          return _createEqualityHelperHelper_(left, right);
       }
    };
  }
  
  protected TransformationSearchOrchestration createOrchestration(final String initialGraph, final int solutionLength) {
    TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
    orchestration.setModuleManager(createModuleManager());
    orchestration.setProblemGraph(initialGraph);
    orchestration.setSolutionLength(solutionLength);
    orchestration.setFitnessFunction(createFitnessFunction(orchestration));
    orchestration.setEqualityHelper(_createEqualityHelper_());
    
    EvolutionaryAlgorithmFactory moea = orchestration.createEvolutionaryAlgorithmFactory(populationSize);
    LocalSearchAlgorithmFactory local = orchestration.createLocalSearchAlgorithmFactory();
    orchestration.addAlgorithm("NSGAIII", _createRegisteredAlgorithm_0(orchestration, moea, local));
    
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
    resultManager.saveApproximationSetObjectives("model/output/metamodel/referenceSet.pf");
    resultManager.setBaseDirectory("model/output/metamodel/solutions/");
    resultManager.saveApproximationSetGraphs();
    System.out.println(resultManager.printApproximationSet());
    System.out.println(resultManager.printApproximationSetObjectives());
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
