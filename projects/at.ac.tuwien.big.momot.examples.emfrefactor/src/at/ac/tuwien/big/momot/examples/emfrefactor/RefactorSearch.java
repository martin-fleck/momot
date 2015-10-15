package at.ac.tuwien.big.momot.examples.emfrefactor;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.DefaultEObjectEqualityHelper;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class RefactorSearch {
protected static final String OBJECTIVE_SUM = "Sum";
	
	protected static final int MAX_EVALUTIONS = 10000;
	protected static final int POPULATION_SIZE = 200;
	protected static final int NR_RUNS = 5;
	
	protected static void executeSearch(String initialGraph, String referenceSetFile, int solutionLength) {
		TransformationSearchOrchestration search = new TransformationSearchOrchestration(
				new ModuleManager(), initialGraph, solutionLength);
		UMLUtil.init(search.getModuleManager().getResourceSet());
		
//		search.getModuleManager().addModule("transformation/refactorings/ecore/remove_empty_sub_eclass_initialcheck.henshin");
//		search.getModuleManager().addModule("transformation/refactorings/ecore/remove_empty_sub_eclass_execute.henshin");
		search.getModuleManager().addModule("transformation/refactorings/ecore/remove_empty_sub_eclass_all.henshin");
		EcoreUtil.resolveAll(search.getModuleManager().getResourceSet());
		search.getModuleManager().removeUnit("remove_empty_sub_eclass_all::removeEmptySubEClass::check_subetypes");
		search.getModuleManager().removeUnit("remove_empty_sub_eclass_all::removeEmptySubEClass::check_superetypes");
		search.getModuleManager().removeUnit("remove_empty_sub_eclass_all::removeEmptySubEClass::check_empty_eclass");
		search.getModuleManager().removeUnit("remove_empty_sub_eclass_all::removeEmptySubEClass::initialCheck");
		search.getModuleManager().removeUnit("remove_empty_sub_eclass_all::removeEmptySubEClass::check_preconditions");
		search.getModuleManager().removeUnit("remove_empty_sub_eclass_all::removeEmptySubEClass::execute");
		search.getModuleManager().removeUnit("remove_empty_sub_eclass_all::removeEmptySubEClass::remove");
//		search.getModuleManager().removeModule("remove_empty_sub_eclass_execute::transformation system");
//		search.getModuleManager().removeModule("remove_empty_sub_eclass_initialcheck::transformation system");
		TransformationLengthDimension lengthDimension = new TransformationLengthDimension();
//		lengthDimension.setFunctionType(FunctionType.Maximum);
		search.getFitnessFunction().addObjective(lengthDimension);
		search.getFitnessFunction().addObjective(new AbstractEGraphFitnessDimension(OBJECTIVE_SUM) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				EPackage root = MomotUtil.getRoot(solution.execute(), EPackage.class);
				int size = root.eContents().size();
				return size;
			}
		});
		search.getFitnessFunction().setSolutionRepairer(new TransformationPlaceholderRepairer());
		
		EvolutionaryAlgorithmFactory<TransformationSolution> factory = search.createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
		
		search.addAlgorithm(factory.createNSGAII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),  
				new TransformationPlaceholderMutation(0.15)));
		
		search.setEqualityHelper(new DefaultEObjectEqualityHelper() {
			
			@Override
			public boolean equals(EObject left, EObject right) {
				if(left instanceof ENamedElement && right instanceof ENamedElement) 
					return ((ENamedElement)left).getName().equals(((ENamedElement)right).getName());
				return super.equals(left, right);
			}
		});
		
//		LocalSearchAlgorithmFactory<TransformationSolution> local = search.createLocalSearchAlgorithmFactory();
//		local.setInitialSolution(search.createNewRandomSolution(1));
//		
//		search.addAlgorithm(local.createHillClimbing(
//				new IncreasingNeighborhoodFunction(
//						search.getSearchHelper(),
//						20),
//				new ObjectiveFitnessComparator<TransformationSolution>(
//						search.getFitnessFunction().getObjectiveIndex(OBJECTIVE_SUM))));
		
		SearchExperiment experiment = new SearchExperiment(search, MAX_EVALUTIONS);
		experiment.addProgressListener(new SeedRuntimePrintListener());
		experiment.setReferenceSetFile(referenceSetFile);
		experiment.setNumberOfRuns(NR_RUNS);
		
		String baseName = initialGraph.replace(".xmi", "").replace(".ecore", "");
		
		TransformationResultManager manager = new TransformationResultManager(experiment);
		
		NondominatedPopulation solutions = manager.createApproximationSet();
		
		manager.setBaseDirectory("model/output/referenceSet/");
		manager.saveApproximationSet(baseName + "_approximation_result.txt");
		manager.saveApproximationSetObjectives(baseName + "_approximation_set.pf");
		
		manager.setBaseDirectory("model/output/solutions/");
		manager.saveApproximationSetGraphs();

		for(Solution solution : manager.createApproximationSet())  {
			TransformationSolution transformationSolution = CastUtil.asClass(solution, TransformationSolution.class);
//			System.out.println(Arrays.toString(transformationSolution.getSuccess()));
			transformationSolution.execute(true);
//			System.out.println(Arrays.toString(transformationSolution.getSuccess()));
		}

		System.out.println(manager.printApproximationSet());		
		System.out.println(manager.printApproximationSetObjectives());
	}
	
	public static void main(String[] args) {
		UMLFactory.eINSTANCE.eClass();
		EcoreFactory.eINSTANCE.eClass();
		executeSearch("model/input/simple_example.ecore", null, 6);
	}
}
