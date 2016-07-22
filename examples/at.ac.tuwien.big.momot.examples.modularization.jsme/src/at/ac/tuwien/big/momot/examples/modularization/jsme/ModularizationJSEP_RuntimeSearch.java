package at.ac.tuwien.big.momot.examples.modularization.jsme;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper;
import at.ac.tuwien.big.momot.problem.unit.parameter.increment.IncrementalStringValue;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;

import com.google.common.base.Objects;

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
public class ModularizationJSEP_RuntimeSearch {
   public class ModularizationJSEP_RuntimeFitnessFunction extends EGraphMultiDimensionalFitnessFunction {
      @Override
      protected void preprocessEvaluation(final TransformationSolution solution) {
         final EGraph _execute = solution.execute();
         final ModularizationModel root = MomotUtil.<ModularizationModel> getRoot(_execute, ModularizationModel.class);
         solution.setAttribute("root", root);
         final ModularizationCalculator _modularizationCalculator = new ModularizationCalculator(root);
         solution.setAttribute(ModularizationJSEP_RuntimeSearch.attribute, _modularizationCalculator);
      }
   }

   protected final static String INITIAL_MODEL = "data/input/models/mtunis.xmi";

   protected final static int SOLUTION_LENGTH = 30;

   protected static String attribute = "calculation";

   public static void init() {
      ModularizationPackage.eINSTANCE.getClass();
   }

   public static void main(final String... args) {
      init();
      final ModularizationJSEP_RuntimeSearch search = new ModularizationJSEP_RuntimeSearch();
      search.performSearch(INITIAL_MODEL, SOLUTION_LENGTH);
      System.out.println("done.");
   }

   protected final String[] modules = new String[] { "data/modularization_jsep.henshin" };

   protected final String _parameterValueKey_0 = ModularizationRules.CreateModule.Parameter.MODULE_NAME;

   protected final ITransformationRepairer solutionRepairer = new TransformationPlaceholderRepairer();

   protected int populationSize = 16384;

   protected final int maxEvaluations = 32768;

   protected final int nrRuns = 30;

   protected IFitnessDimension<TransformationSolution> _createConstraint_0(
         final TransformationSearchOrchestration orchestration) {
      return new AbstractEGraphFitnessDimension("UnassignedClasses",
            at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final EGraph graph = solution.execute();
            final EObject root = MomotUtil.getRoot(graph);
            return _createConstraintHelper_0(solution, graph, root);
         }
      };
   }

   protected IFitnessDimension<TransformationSolution> _createConstraint_1(
         final TransformationSearchOrchestration orchestration) {
      return new AbstractEGraphFitnessDimension("EmptyModules",
            at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final EGraph graph = solution.execute();
            final EObject root = MomotUtil.getRoot(graph);
            return _createConstraintHelper_1(solution, graph, root);
         }
      };
   }

   protected double _createConstraintHelper_0(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      final EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> _classes = ((ModularizationModel) root)
            .getClasses();
      final Function1<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class, Boolean> _function = (
            final at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class c) -> {
         final Module _module = c.getModule();
         return Boolean.valueOf(Objects.equal(_module, null));
      };
      final Iterable<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> _filter = IterableExtensions.<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> filter(
            _classes, _function);
      return IterableExtensions.size(_filter);
   }

   protected double _createConstraintHelper_1(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      final EList<Module> _modules = ((ModularizationModel) root).getModules();
      final Function1<Module, Boolean> _function = (final Module m) -> {
         final EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> _classes = m
               .getClasses();
         return Boolean.valueOf(_classes.isEmpty());
      };
      final Iterable<Module> _filter = IterableExtensions.<Module> filter(_modules, _function);
      return IterableExtensions.size(_filter);
   }

   protected IEObjectEqualityHelper _createEqualityHelper_() {
      return (left, right) -> _createEqualityHelperHelper_(left, right);
   }

   protected boolean _createEqualityHelperHelper_(final EObject left, final EObject right) {
      boolean _xblockexpression = false;
      {
         boolean _and = false;
         if(!(left instanceof Module)) {
            _and = false;
         } else {
            _and = right instanceof Module;
         }
         if(_and) {
            final EObject _eContainer = left.eContainer();
            final EList<Module> _modules = ((ModularizationModel) _eContainer).getModules();
            final int leftIndex = _modules.indexOf(left);
            final EObject _eContainer_1 = right.eContainer();
            final EList<Module> _modules_1 = ((ModularizationModel) _eContainer_1).getModules();
            final int rightIndex = _modules_1.indexOf(right);
            return Integer.valueOf(leftIndex).equals(Integer.valueOf(rightIndex));
         }
         _xblockexpression = left.equals(right);
      }
      return _xblockexpression;
   }

   protected ProgressListener _createListener_0() {
      final SeedRuntimePrintListener _seedRuntimePrintListener = new SeedRuntimePrintListener();
      return _seedRuntimePrintListener;
   }

   protected IFitnessDimension<TransformationSolution> _createObjective_0(
         final TransformationSearchOrchestration orchestration) {
      return new AbstractEGraphFitnessDimension("Coupling",
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
      return new AbstractEGraphFitnessDimension("Cohesion",
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
      return new AbstractEGraphFitnessDimension("NrModules",
            at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Maximum) {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final EGraph graph = solution.execute();
            final EObject root = MomotUtil.getRoot(graph);
            return _createObjectiveHelper_2(solution, graph, root);
         }
      };
   }

   protected IFitnessDimension<TransformationSolution> _createObjective_3(
         final TransformationSearchOrchestration orchestration) {
      return new AbstractEGraphFitnessDimension("MQ",
            at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Maximum) {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final EGraph graph = solution.execute();
            final EObject root = MomotUtil.getRoot(graph);
            return _createObjectiveHelper_3(solution, graph, root);
         }
      };
   }

   protected IFitnessDimension<TransformationSolution> _createObjective_4(
         final TransformationSearchOrchestration orchestration) {
      return new AbstractEGraphFitnessDimension("MinMaxDiff",
            at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType.Minimum) {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final EGraph graph = solution.execute();
            final EObject root = MomotUtil.getRoot(graph);
            return _createObjectiveHelper_4(solution, graph, root);
         }
      };
   }

   protected double _createObjectiveHelper_0(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      double _xblockexpression = 0;
      {
         final ModularizationCalculator calculator = solution.<ModularizationCalculator> getAttribute(
               ModularizationJSEP_RuntimeSearch.attribute, ModularizationCalculator.class);
         final ModelMetrics _metrics = calculator.getMetrics();
         _xblockexpression = _metrics.coupling;
      }
      return _xblockexpression;
   }

   protected double _createObjectiveHelper_1(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      double _xblockexpression = 0;
      {
         final ModularizationCalculator calculator = solution.<ModularizationCalculator> getAttribute(
               ModularizationJSEP_RuntimeSearch.attribute, ModularizationCalculator.class);
         final ModelMetrics _metrics = calculator.getMetrics();
         _xblockexpression = _metrics.cohesion;
      }
      return _xblockexpression;
   }

   protected double _createObjectiveHelper_2(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      int _xblockexpression = 0;
      {
         final ModularizationCalculator calculator = solution.<ModularizationCalculator> getAttribute(
               ModularizationJSEP_RuntimeSearch.attribute, ModularizationCalculator.class);
         final ModelMetrics _metrics = calculator.getMetrics();
         _xblockexpression = _metrics.nrModules;
      }
      return _xblockexpression;
   }

   protected double _createObjectiveHelper_3(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      double _xblockexpression = 0;
      {
         final ModularizationCalculator calculator = solution.<ModularizationCalculator> getAttribute(
               ModularizationJSEP_RuntimeSearch.attribute, ModularizationCalculator.class);
         final ModelMetrics _metrics = calculator.getMetrics();
         _xblockexpression = _metrics.modularizationQuality;
      }
      return _xblockexpression;
   }

   protected double _createObjectiveHelper_4(final TransformationSolution solution, final EGraph graph,
         final EObject root) {
      int _xblockexpression = 0;
      {
         final ModularizationCalculator calculator = solution.<ModularizationCalculator> getAttribute(
               ModularizationJSEP_RuntimeSearch.attribute, ModularizationCalculator.class);
         final ModelMetrics _metrics = calculator.getMetrics();
         _xblockexpression = _metrics.minMaxDiff;
      }
      return _xblockexpression;
   }

   protected IParameterValue _createParameterValue_0() {
      final IncrementalStringValue _incrementalStringValue = new IncrementalStringValue("Module", "A");
      return _incrementalStringValue;
   }

   protected IRegisteredAlgorithm<NSGAII> _createRegisteredAlgorithm_0(
         final TransformationSearchOrchestration orchestration,
         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
         final LocalSearchAlgorithmFactory<TransformationSolution> local) {
      final TournamentSelection _tournamentSelection = new TournamentSelection(2);
      final OnePointCrossover _onePointCrossover = new OnePointCrossover(1.0);
      final SearchHelper _searchHelper = orchestration.getSearchHelper();
      final TransformationVariableMutation _transformationVariableMutation = new TransformationVariableMutation(
            _searchHelper, 0.10);
      final IRegisteredAlgorithm<NSGAII> _createNSGAIII = moea.createNSGAIII(0, 6, _tournamentSelection,
            _onePointCrossover, _transformationVariableMutation);
      return _createNSGAIII;
   }

   protected SearchExperiment createExperiment(final TransformationSearchOrchestration orchestration) {
      final SearchExperiment experiment = new SearchExperiment(orchestration, maxEvaluations);
      experiment.setNumberOfRuns(nrRuns);
      experiment.addProgressListener(_createListener_0());
      return experiment;
   }

   protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction(
         final TransformationSearchOrchestration orchestration) {
      final IEGraphMultiDimensionalFitnessFunction function = new ModularizationJSEP_RuntimeSearch.ModularizationJSEP_RuntimeFitnessFunction();
      function.addObjective(_createObjective_0(orchestration));
      function.addObjective(_createObjective_1(orchestration));
      function.addObjective(_createObjective_2(orchestration));
      function.addObjective(_createObjective_3(orchestration));
      function.addObjective(_createObjective_4(orchestration));
      function.addConstraint(_createConstraint_0(orchestration));
      function.addConstraint(_createConstraint_1(orchestration));
      function.setSolutionRepairer(solutionRepairer);
      return function;
   }

   protected ModuleManager createModuleManager() {
      final ModuleManager manager = new ModuleManager();
      manager.addModules(modules);
      manager.setParameterValue(_parameterValueKey_0, _createParameterValue_0());
      return manager;
   }

   protected TransformationSearchOrchestration createOrchestration(final String initialGraph,
         final int solutionLength) {
      final TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration();
      orchestration.setModuleManager(createModuleManager());
      orchestration.setProblemGraph(initialGraph);
      orchestration.setSolutionLength(solutionLength);
      orchestration.setFitnessFunction(createFitnessFunction(orchestration));
      orchestration.setEqualityHelper(_createEqualityHelper_());

      final EvolutionaryAlgorithmFactory moea = orchestration.createEvolutionaryAlgorithmFactory(populationSize);
      final LocalSearchAlgorithmFactory local = orchestration.createLocalSearchAlgorithmFactory();
      orchestration.addAlgorithm("NSGAIII", _createRegisteredAlgorithm_0(orchestration, moea, local));

      return orchestration;
   }

   protected TransformationResultManager handleResults(final SearchExperiment experiment) {
      final TransformationResultManager resultManager = new TransformationResultManager(experiment);
      resultManager.saveObjectives("data/output/runtime/approximationSet/momot_" + populationSize + "ps.pf");
      resultManager.setBaseDirectory("data/output/models/runtime/momot_" + populationSize + "ps/");
      resultManager.saveModels();
      System.out.println(resultManager.printPopulation());
      System.out.println(resultManager.printObjectives());
      return resultManager;
   }

   public void performSearch(final String initialGraph, final int solutionLength) {
      final TransformationSearchOrchestration orchestration = createOrchestration(initialGraph, solutionLength);
      final SearchExperiment experiment = createExperiment(orchestration);
      experiment.run();
      // handleResults(experiment);
   }
}
