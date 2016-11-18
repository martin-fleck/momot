/**
 */
package metasearch.impl;

import metasearch.Algorithm;
import metasearch.ChangingNeighborhood;
import metasearch.DecreasingMaximumComparatorGenerator;
import metasearch.DiscardingSolutionInitializer;
import metasearch.FitnessComparatorGenerator;
import metasearch.GeneticAlgorithm;
import metasearch.HillClimbing;
import metasearch.IteratingAlgorithm;
import metasearch.LocalSearchAlgorithm;
import metasearch.LocalSearchApplication;
import metasearch.MemeticAlgorithm;
import metasearch.MetasearchFactory;
import metasearch.MetasearchPackage;
import metasearch.Neighborhood;
import metasearch.RandomSolutionInitializer;
import metasearch.RandomWeightGenerator;
import metasearch.SimulatedAnnealing;
import metasearch.SolutionInitializer;
import metasearch.TabuSupportingLocalSearch;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetasearchPackageImpl extends EPackageImpl implements MetasearchPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geneticAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localSearchAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hillClimbingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nsgaiiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nsgaiiiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulatedAnnealingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memeticAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localSearchApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass algorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fitnessComparatorGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decreasingMaximumComparatorGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomWeightGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tabuSupportingLocalSearchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass neighborhoodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changingNeighborhoodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratingAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomSolutionInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discardingSolutionInitializerEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see metasearch.MetasearchPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetasearchPackageImpl() {
		super(eNS_URI, MetasearchFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MetasearchPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetasearchPackage init() {
		if (isInited) return (MetasearchPackage)EPackage.Registry.INSTANCE.getEPackage(MetasearchPackage.eNS_URI);

		// Obtain or create and register package
		MetasearchPackageImpl theMetasearchPackage = (MetasearchPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetasearchPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetasearchPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMetasearchPackage.createPackageContents();

		// Initialize created meta-data
		theMetasearchPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetasearchPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetasearchPackage.eNS_URI, theMetasearchPackage);
		return theMetasearchPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneticAlgorithm() {
		return geneticAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneticAlgorithm_PopulationSize() {
		return (EAttribute)geneticAlgorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneticAlgorithm_MutateDelete() {
		return (EAttribute)geneticAlgorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneticAlgorithm_MutateModifyRule() {
		return (EAttribute)geneticAlgorithmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneticAlgorithm_MutateReplaceRule() {
		return (EAttribute)geneticAlgorithmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalSearchAlgorithm() {
		return localSearchAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalSearchAlgorithm_Neighborhood() {
		return (EReference)localSearchAlgorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHillClimbing() {
		return hillClimbingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbing_Neighborsize() {
		return (EAttribute)hillClimbingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbing_NextImprovement() {
		return (EAttribute)hillClimbingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHillClimbing_MaxNoImprovement() {
		return (EAttribute)hillClimbingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNSGAII() {
		return nsgaiiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNSGAIII() {
		return nsgaiiiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulatedAnnealing() {
		return simulatedAnnealingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulatedAnnealing_StartTemp() {
		return (EAttribute)simulatedAnnealingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulatedAnnealing_TempIncrease() {
		return (EAttribute)simulatedAnnealingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulatedAnnealing_RestartNoCurrentImp() {
		return (EAttribute)simulatedAnnealingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulatedAnnealing_RestartNoBestImp() {
		return (EAttribute)simulatedAnnealingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemeticAlgorithm() {
		return memeticAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemeticAlgorithm_Localsearchapplication() {
		return (EReference)memeticAlgorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemeticAlgorithm_GlobalSearch() {
		return (EReference)memeticAlgorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalSearchApplication() {
		return localSearchApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalSearchApplication_Probability() {
		return (EAttribute)localSearchApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalSearchApplication_TournamentSize() {
		return (EAttribute)localSearchApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalSearchApplication_Localsearchalgorithm() {
		return (EReference)localSearchApplicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalSearchApplication_LastSolution() {
		return (EAttribute)localSearchApplicationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalSearchApplication_StartAtEvalPerc() {
		return (EAttribute)localSearchApplicationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalSearchApplication_UsedGenerator() {
		return (EReference)localSearchApplicationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_UsedAlgorithm() {
		return (EReference)containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_Algorithm() {
		return (EReference)containerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_Neighborhood() {
		return (EReference)containerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_Solutioninitializer() {
		return (EReference)containerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlgorithm() {
		return algorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlgorithm_NrEvaluations() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgorithm__CreateRegisteredAlgorithm() {
		return algorithmEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFitnessComparatorGenerator() {
		return fitnessComparatorGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFitnessComparatorGenerator_ComparatorContainer() {
		return (EReference)fitnessComparatorGeneratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecreasingMaximumComparatorGenerator() {
		return decreasingMaximumComparatorGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomWeightGenerator() {
		return randomWeightGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTabuSupportingLocalSearch() {
		return tabuSupportingLocalSearchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTabuSupportingLocalSearch_TabuSize() {
		return (EAttribute)tabuSupportingLocalSearchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNeighborhood() {
		return neighborhoodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangingNeighborhood() {
		return changingNeighborhoodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangingNeighborhood_DeleteProbability() {
		return (EAttribute)changingNeighborhoodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangingNeighborhood_AtEndProbability() {
		return (EAttribute)changingNeighborhoodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangingNeighborhood_ModifyRuleProbability() {
		return (EAttribute)changingNeighborhoodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIteratingAlgorithm() {
		return iteratingAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIteratingAlgorithm_Solutioninitializer() {
		return (EReference)iteratingAlgorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIteratingAlgorithm_Algorithm() {
		return (EReference)iteratingAlgorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIteratingAlgorithm_Fitnesscomparatorgenerator() {
		return (EReference)iteratingAlgorithmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIteratingAlgorithm_TournamentSize() {
		return (EAttribute)iteratingAlgorithmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIteratingAlgorithm_TournamentRemain() {
		return (EAttribute)iteratingAlgorithmEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolutionInitializer() {
		return solutionInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomSolutionInitializer() {
		return randomSolutionInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscardingSolutionInitializer() {
		return discardingSolutionInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscardingSolutionInitializer_SolutionConsiderSize() {
		return (EAttribute)discardingSolutionInitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscardingSolutionInitializer_SolutionUseSize() {
		return (EAttribute)discardingSolutionInitializerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscardingSolutionInitializer_SolutionsPerQueue() {
		return (EAttribute)discardingSolutionInitializerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscardingSolutionInitializer_NumQueues() {
		return (EAttribute)discardingSolutionInitializerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscardingSolutionInitializer_NumInitSolutions() {
		return (EAttribute)discardingSolutionInitializerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetasearchFactory getMetasearchFactory() {
		return (MetasearchFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		geneticAlgorithmEClass = createEClass(GENETIC_ALGORITHM);
		createEAttribute(geneticAlgorithmEClass, GENETIC_ALGORITHM__POPULATION_SIZE);
		createEAttribute(geneticAlgorithmEClass, GENETIC_ALGORITHM__MUTATE_DELETE);
		createEAttribute(geneticAlgorithmEClass, GENETIC_ALGORITHM__MUTATE_MODIFY_RULE);
		createEAttribute(geneticAlgorithmEClass, GENETIC_ALGORITHM__MUTATE_REPLACE_RULE);

		localSearchAlgorithmEClass = createEClass(LOCAL_SEARCH_ALGORITHM);
		createEReference(localSearchAlgorithmEClass, LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD);

		hillClimbingEClass = createEClass(HILL_CLIMBING);
		createEAttribute(hillClimbingEClass, HILL_CLIMBING__NEIGHBORSIZE);
		createEAttribute(hillClimbingEClass, HILL_CLIMBING__NEXT_IMPROVEMENT);
		createEAttribute(hillClimbingEClass, HILL_CLIMBING__MAX_NO_IMPROVEMENT);

		nsgaiiEClass = createEClass(NSGAII);

		nsgaiiiEClass = createEClass(NSGAIII);

		simulatedAnnealingEClass = createEClass(SIMULATED_ANNEALING);
		createEAttribute(simulatedAnnealingEClass, SIMULATED_ANNEALING__START_TEMP);
		createEAttribute(simulatedAnnealingEClass, SIMULATED_ANNEALING__TEMP_INCREASE);
		createEAttribute(simulatedAnnealingEClass, SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP);
		createEAttribute(simulatedAnnealingEClass, SIMULATED_ANNEALING__RESTART_NO_BEST_IMP);

		memeticAlgorithmEClass = createEClass(MEMETIC_ALGORITHM);
		createEReference(memeticAlgorithmEClass, MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION);
		createEReference(memeticAlgorithmEClass, MEMETIC_ALGORITHM__GLOBAL_SEARCH);

		localSearchApplicationEClass = createEClass(LOCAL_SEARCH_APPLICATION);
		createEAttribute(localSearchApplicationEClass, LOCAL_SEARCH_APPLICATION__PROBABILITY);
		createEAttribute(localSearchApplicationEClass, LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE);
		createEReference(localSearchApplicationEClass, LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM);
		createEAttribute(localSearchApplicationEClass, LOCAL_SEARCH_APPLICATION__LAST_SOLUTION);
		createEAttribute(localSearchApplicationEClass, LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC);
		createEReference(localSearchApplicationEClass, LOCAL_SEARCH_APPLICATION__USED_GENERATOR);

		containerEClass = createEClass(CONTAINER);
		createEReference(containerEClass, CONTAINER__USED_ALGORITHM);
		createEReference(containerEClass, CONTAINER__ALGORITHM);
		createEReference(containerEClass, CONTAINER__NEIGHBORHOOD);
		createEReference(containerEClass, CONTAINER__SOLUTIONINITIALIZER);

		algorithmEClass = createEClass(ALGORITHM);
		createEAttribute(algorithmEClass, ALGORITHM__NR_EVALUATIONS);
		createEOperation(algorithmEClass, ALGORITHM___CREATE_REGISTERED_ALGORITHM);

		fitnessComparatorGeneratorEClass = createEClass(FITNESS_COMPARATOR_GENERATOR);
		createEReference(fitnessComparatorGeneratorEClass, FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER);

		decreasingMaximumComparatorGeneratorEClass = createEClass(DECREASING_MAXIMUM_COMPARATOR_GENERATOR);

		randomWeightGeneratorEClass = createEClass(RANDOM_WEIGHT_GENERATOR);

		tabuSupportingLocalSearchEClass = createEClass(TABU_SUPPORTING_LOCAL_SEARCH);
		createEAttribute(tabuSupportingLocalSearchEClass, TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE);

		neighborhoodEClass = createEClass(NEIGHBORHOOD);

		changingNeighborhoodEClass = createEClass(CHANGING_NEIGHBORHOOD);
		createEAttribute(changingNeighborhoodEClass, CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY);
		createEAttribute(changingNeighborhoodEClass, CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY);
		createEAttribute(changingNeighborhoodEClass, CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY);

		iteratingAlgorithmEClass = createEClass(ITERATING_ALGORITHM);
		createEReference(iteratingAlgorithmEClass, ITERATING_ALGORITHM__SOLUTIONINITIALIZER);
		createEReference(iteratingAlgorithmEClass, ITERATING_ALGORITHM__ALGORITHM);
		createEReference(iteratingAlgorithmEClass, ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR);
		createEAttribute(iteratingAlgorithmEClass, ITERATING_ALGORITHM__TOURNAMENT_SIZE);
		createEAttribute(iteratingAlgorithmEClass, ITERATING_ALGORITHM__TOURNAMENT_REMAIN);

		solutionInitializerEClass = createEClass(SOLUTION_INITIALIZER);

		randomSolutionInitializerEClass = createEClass(RANDOM_SOLUTION_INITIALIZER);

		discardingSolutionInitializerEClass = createEClass(DISCARDING_SOLUTION_INITIALIZER);
		createEAttribute(discardingSolutionInitializerEClass, DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE);
		createEAttribute(discardingSolutionInitializerEClass, DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE);
		createEAttribute(discardingSolutionInitializerEClass, DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE);
		createEAttribute(discardingSolutionInitializerEClass, DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES);
		createEAttribute(discardingSolutionInitializerEClass, DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		geneticAlgorithmEClass.getESuperTypes().add(this.getAlgorithm());
		localSearchAlgorithmEClass.getESuperTypes().add(this.getAlgorithm());
		hillClimbingEClass.getESuperTypes().add(this.getTabuSupportingLocalSearch());
		nsgaiiEClass.getESuperTypes().add(this.getGeneticAlgorithm());
		nsgaiiiEClass.getESuperTypes().add(this.getGeneticAlgorithm());
		simulatedAnnealingEClass.getESuperTypes().add(this.getTabuSupportingLocalSearch());
		memeticAlgorithmEClass.getESuperTypes().add(this.getAlgorithm());
		decreasingMaximumComparatorGeneratorEClass.getESuperTypes().add(this.getFitnessComparatorGenerator());
		randomWeightGeneratorEClass.getESuperTypes().add(this.getFitnessComparatorGenerator());
		tabuSupportingLocalSearchEClass.getESuperTypes().add(this.getLocalSearchAlgorithm());
		changingNeighborhoodEClass.getESuperTypes().add(this.getNeighborhood());
		iteratingAlgorithmEClass.getESuperTypes().add(this.getAlgorithm());
		randomSolutionInitializerEClass.getESuperTypes().add(this.getSolutionInitializer());
		discardingSolutionInitializerEClass.getESuperTypes().add(this.getSolutionInitializer());

		// Initialize classes, features, and operations; add parameters
		initEClass(geneticAlgorithmEClass, GeneticAlgorithm.class, "GeneticAlgorithm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneticAlgorithm_PopulationSize(), theXMLTypePackage.getInt(), "populationSize", null, 1, 1, GeneticAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneticAlgorithm_MutateDelete(), theXMLTypePackage.getDouble(), "mutateDelete", null, 1, 1, GeneticAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneticAlgorithm_MutateModifyRule(), theXMLTypePackage.getDouble(), "mutateModifyRule", null, 1, 1, GeneticAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneticAlgorithm_MutateReplaceRule(), theXMLTypePackage.getDouble(), "mutateReplaceRule", null, 1, 1, GeneticAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localSearchAlgorithmEClass, LocalSearchAlgorithm.class, "LocalSearchAlgorithm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalSearchAlgorithm_Neighborhood(), this.getNeighborhood(), null, "neighborhood", null, 1, 1, LocalSearchAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hillClimbingEClass, HillClimbing.class, "HillClimbing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHillClimbing_Neighborsize(), theXMLTypePackage.getInt(), "neighborsize", null, 1, 1, HillClimbing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHillClimbing_NextImprovement(), ecorePackage.getEBoolean(), "nextImprovement", null, 1, 1, HillClimbing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHillClimbing_MaxNoImprovement(), theXMLTypePackage.getInt(), "maxNoImprovement", null, 1, 1, HillClimbing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nsgaiiEClass, metasearch.NSGAII.class, "NSGAII", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nsgaiiiEClass, metasearch.NSGAIII.class, "NSGAIII", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simulatedAnnealingEClass, SimulatedAnnealing.class, "SimulatedAnnealing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulatedAnnealing_StartTemp(), theXMLTypePackage.getDouble(), "startTemp", null, 1, 1, SimulatedAnnealing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulatedAnnealing_TempIncrease(), theXMLTypePackage.getDouble(), "tempIncrease", null, 1, 1, SimulatedAnnealing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulatedAnnealing_RestartNoCurrentImp(), theXMLTypePackage.getInt(), "restartNoCurrentImp", null, 1, 1, SimulatedAnnealing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulatedAnnealing_RestartNoBestImp(), theXMLTypePackage.getInt(), "restartNoBestImp", null, 1, 1, SimulatedAnnealing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memeticAlgorithmEClass, MemeticAlgorithm.class, "MemeticAlgorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemeticAlgorithm_Localsearchapplication(), this.getLocalSearchApplication(), null, "localsearchapplication", null, 0, 1, MemeticAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemeticAlgorithm_GlobalSearch(), this.getGeneticAlgorithm(), null, "globalSearch", null, 1, 1, MemeticAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localSearchApplicationEClass, LocalSearchApplication.class, "LocalSearchApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalSearchApplication_Probability(), theXMLTypePackage.getDouble(), "probability", null, 1, 1, LocalSearchApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalSearchApplication_TournamentSize(), theXMLTypePackage.getInt(), "tournamentSize", null, 1, 1, LocalSearchApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalSearchApplication_Localsearchalgorithm(), this.getLocalSearchAlgorithm(), null, "localsearchalgorithm", null, 1, 1, LocalSearchApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalSearchApplication_LastSolution(), ecorePackage.getEBoolean(), "lastSolution", null, 1, 1, LocalSearchApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalSearchApplication_StartAtEvalPerc(), theXMLTypePackage.getDouble(), "startAtEvalPerc", null, 1, 1, LocalSearchApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalSearchApplication_UsedGenerator(), this.getFitnessComparatorGenerator(), null, "usedGenerator", null, 1, 1, LocalSearchApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerEClass, metasearch.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_UsedAlgorithm(), this.getAlgorithm(), null, "usedAlgorithm", null, 1, 1, metasearch.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainer_Algorithm(), this.getAlgorithm(), null, "algorithm", null, 0, -1, metasearch.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainer_Neighborhood(), this.getNeighborhood(), null, "neighborhood", null, 0, -1, metasearch.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainer_Solutioninitializer(), this.getSolutionInitializer(), null, "solutioninitializer", null, 0, -1, metasearch.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(algorithmEClass, Algorithm.class, "Algorithm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAlgorithm_NrEvaluations(), theXMLTypePackage.getInt(), "nrEvaluations", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAlgorithm__CreateRegisteredAlgorithm(), ecorePackage.getEJavaObject(), "createRegisteredAlgorithm", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fitnessComparatorGeneratorEClass, FitnessComparatorGenerator.class, "FitnessComparatorGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFitnessComparatorGenerator_ComparatorContainer(), this.getContainer(), null, "comparatorContainer", null, 0, -1, FitnessComparatorGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decreasingMaximumComparatorGeneratorEClass, DecreasingMaximumComparatorGenerator.class, "DecreasingMaximumComparatorGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomWeightGeneratorEClass, RandomWeightGenerator.class, "RandomWeightGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tabuSupportingLocalSearchEClass, TabuSupportingLocalSearch.class, "TabuSupportingLocalSearch", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTabuSupportingLocalSearch_TabuSize(), theXMLTypePackage.getInt(), "tabuSize", null, 1, 1, TabuSupportingLocalSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(neighborhoodEClass, Neighborhood.class, "Neighborhood", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(changingNeighborhoodEClass, ChangingNeighborhood.class, "ChangingNeighborhood", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChangingNeighborhood_DeleteProbability(), theXMLTypePackage.getDouble(), "deleteProbability", null, 1, 1, ChangingNeighborhood.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangingNeighborhood_AtEndProbability(), theXMLTypePackage.getDouble(), "atEndProbability", null, 1, 1, ChangingNeighborhood.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangingNeighborhood_ModifyRuleProbability(), theXMLTypePackage.getDouble(), "modifyRuleProbability", null, 1, 1, ChangingNeighborhood.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iteratingAlgorithmEClass, IteratingAlgorithm.class, "IteratingAlgorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIteratingAlgorithm_Solutioninitializer(), this.getSolutionInitializer(), null, "solutioninitializer", null, 1, 1, IteratingAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratingAlgorithm_Algorithm(), this.getLocalSearchAlgorithm(), null, "algorithm", null, 1, 1, IteratingAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratingAlgorithm_Fitnesscomparatorgenerator(), this.getFitnessComparatorGenerator(), null, "fitnesscomparatorgenerator", null, 0, 1, IteratingAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIteratingAlgorithm_TournamentSize(), theXMLTypePackage.getInt(), "tournamentSize", null, 1, 1, IteratingAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIteratingAlgorithm_TournamentRemain(), theXMLTypePackage.getInt(), "tournamentRemain", null, 1, 1, IteratingAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solutionInitializerEClass, SolutionInitializer.class, "SolutionInitializer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomSolutionInitializerEClass, RandomSolutionInitializer.class, "RandomSolutionInitializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(discardingSolutionInitializerEClass, DiscardingSolutionInitializer.class, "DiscardingSolutionInitializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscardingSolutionInitializer_SolutionConsiderSize(), theXMLTypePackage.getInt(), "solutionConsiderSize", null, 1, 1, DiscardingSolutionInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiscardingSolutionInitializer_SolutionUseSize(), theXMLTypePackage.getInt(), "solutionUseSize", null, 1, 1, DiscardingSolutionInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiscardingSolutionInitializer_SolutionsPerQueue(), theXMLTypePackage.getInt(), "solutionsPerQueue", null, 1, 1, DiscardingSolutionInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiscardingSolutionInitializer_NumQueues(), theXMLTypePackage.getInt(), "numQueues", null, 1, 1, DiscardingSolutionInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiscardingSolutionInitializer_NumInitSolutions(), theXMLTypePackage.getInt(), "numInitSolutions", null, 1, 1, DiscardingSolutionInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/OCL/Collection
		createCollectionAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			 "ecore.xml.type", "http://www.eclipse.org/emf/2003/XMLType"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Collection</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCollectionAnnotations() {
		String source = "http://www.eclipse.org/OCL/Collection";	
		addAnnotation
		  (getFitnessComparatorGenerator_ComparatorContainer(), 
		   source, 
		   new String[] {
			 "nullFree", "false"
		   });
	}

} //MetasearchPackageImpl
