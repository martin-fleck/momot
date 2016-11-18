/**
 */
package metasearch;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see metasearch.MetasearchFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' ecore.xml.type='http://www.eclipse.org/emf/2003/XMLType'"
 * @generated
 */
public interface MetasearchPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metasearch";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/metasearch";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metasearch";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetasearchPackage eINSTANCE = metasearch.impl.MetasearchPackageImpl.init();

	/**
	 * The meta object id for the '{@link metasearch.impl.AlgorithmImpl <em>Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.AlgorithmImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getAlgorithm()
	 * @generated
	 */
	int ALGORITHM = 9;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__NR_EVALUATIONS = 0;

	/**
	 * The number of structural features of the '<em>Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM___CREATE_REGISTERED_ALGORITHM = 0;

	/**
	 * The number of operations of the '<em>Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link metasearch.impl.GeneticAlgorithmImpl <em>Genetic Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.GeneticAlgorithmImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getGeneticAlgorithm()
	 * @generated
	 */
	int GENETIC_ALGORITHM = 0;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM__NR_EVALUATIONS = ALGORITHM__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Population Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM__POPULATION_SIZE = ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mutate Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM__MUTATE_DELETE = ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mutate Modify Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM__MUTATE_MODIFY_RULE = ALGORITHM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mutate Replace Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM__MUTATE_REPLACE_RULE = ALGORITHM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Genetic Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM_FEATURE_COUNT = ALGORITHM_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM___CREATE_REGISTERED_ALGORITHM = ALGORITHM___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>Genetic Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENETIC_ALGORITHM_OPERATION_COUNT = ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.LocalSearchAlgorithmImpl <em>Local Search Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.LocalSearchAlgorithmImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getLocalSearchAlgorithm()
	 * @generated
	 */
	int LOCAL_SEARCH_ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_ALGORITHM__NR_EVALUATIONS = ALGORITHM__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Neighborhood</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD = ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Search Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_ALGORITHM_FEATURE_COUNT = ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_ALGORITHM___CREATE_REGISTERED_ALGORITHM = ALGORITHM___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>Local Search Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_ALGORITHM_OPERATION_COUNT = ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.TabuSupportingLocalSearchImpl <em>Tabu Supporting Local Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.TabuSupportingLocalSearchImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getTabuSupportingLocalSearch()
	 * @generated
	 */
	int TABU_SUPPORTING_LOCAL_SEARCH = 13;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABU_SUPPORTING_LOCAL_SEARCH__NR_EVALUATIONS = LOCAL_SEARCH_ALGORITHM__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Neighborhood</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABU_SUPPORTING_LOCAL_SEARCH__NEIGHBORHOOD = LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD;

	/**
	 * The feature id for the '<em><b>Tabu Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE = LOCAL_SEARCH_ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tabu Supporting Local Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT = LOCAL_SEARCH_ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABU_SUPPORTING_LOCAL_SEARCH___CREATE_REGISTERED_ALGORITHM = LOCAL_SEARCH_ALGORITHM___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>Tabu Supporting Local Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABU_SUPPORTING_LOCAL_SEARCH_OPERATION_COUNT = LOCAL_SEARCH_ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.HillClimbingImpl <em>Hill Climbing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.HillClimbingImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getHillClimbing()
	 * @generated
	 */
	int HILL_CLIMBING = 2;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING__NR_EVALUATIONS = TABU_SUPPORTING_LOCAL_SEARCH__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Neighborhood</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING__NEIGHBORHOOD = TABU_SUPPORTING_LOCAL_SEARCH__NEIGHBORHOOD;

	/**
	 * The feature id for the '<em><b>Tabu Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING__TABU_SIZE = TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE;

	/**
	 * The feature id for the '<em><b>Neighborsize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING__NEIGHBORSIZE = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Next Improvement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING__NEXT_IMPROVEMENT = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max No Improvement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING__MAX_NO_IMPROVEMENT = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Hill Climbing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_FEATURE_COUNT = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING___CREATE_REGISTERED_ALGORITHM = TABU_SUPPORTING_LOCAL_SEARCH___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>Hill Climbing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HILL_CLIMBING_OPERATION_COUNT = TABU_SUPPORTING_LOCAL_SEARCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.NSGAIIImpl <em>NSGAII</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.NSGAIIImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getNSGAII()
	 * @generated
	 */
	int NSGAII = 3;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII__NR_EVALUATIONS = GENETIC_ALGORITHM__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Population Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII__POPULATION_SIZE = GENETIC_ALGORITHM__POPULATION_SIZE;

	/**
	 * The feature id for the '<em><b>Mutate Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII__MUTATE_DELETE = GENETIC_ALGORITHM__MUTATE_DELETE;

	/**
	 * The feature id for the '<em><b>Mutate Modify Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII__MUTATE_MODIFY_RULE = GENETIC_ALGORITHM__MUTATE_MODIFY_RULE;

	/**
	 * The feature id for the '<em><b>Mutate Replace Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII__MUTATE_REPLACE_RULE = GENETIC_ALGORITHM__MUTATE_REPLACE_RULE;

	/**
	 * The number of structural features of the '<em>NSGAII</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII_FEATURE_COUNT = GENETIC_ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII___CREATE_REGISTERED_ALGORITHM = GENETIC_ALGORITHM___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>NSGAII</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAII_OPERATION_COUNT = GENETIC_ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.NSGAIIIImpl <em>NSGAIII</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.NSGAIIIImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getNSGAIII()
	 * @generated
	 */
	int NSGAIII = 4;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII__NR_EVALUATIONS = GENETIC_ALGORITHM__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Population Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII__POPULATION_SIZE = GENETIC_ALGORITHM__POPULATION_SIZE;

	/**
	 * The feature id for the '<em><b>Mutate Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII__MUTATE_DELETE = GENETIC_ALGORITHM__MUTATE_DELETE;

	/**
	 * The feature id for the '<em><b>Mutate Modify Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII__MUTATE_MODIFY_RULE = GENETIC_ALGORITHM__MUTATE_MODIFY_RULE;

	/**
	 * The feature id for the '<em><b>Mutate Replace Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII__MUTATE_REPLACE_RULE = GENETIC_ALGORITHM__MUTATE_REPLACE_RULE;

	/**
	 * The number of structural features of the '<em>NSGAIII</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII_FEATURE_COUNT = GENETIC_ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII___CREATE_REGISTERED_ALGORITHM = GENETIC_ALGORITHM___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>NSGAIII</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGAIII_OPERATION_COUNT = GENETIC_ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.SimulatedAnnealingImpl <em>Simulated Annealing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.SimulatedAnnealingImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getSimulatedAnnealing()
	 * @generated
	 */
	int SIMULATED_ANNEALING = 5;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING__NR_EVALUATIONS = TABU_SUPPORTING_LOCAL_SEARCH__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Neighborhood</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING__NEIGHBORHOOD = TABU_SUPPORTING_LOCAL_SEARCH__NEIGHBORHOOD;

	/**
	 * The feature id for the '<em><b>Tabu Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING__TABU_SIZE = TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE;

	/**
	 * The feature id for the '<em><b>Start Temp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING__START_TEMP = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Temp Increase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING__TEMP_INCREASE = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Restart No Current Imp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Restart No Best Imp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING__RESTART_NO_BEST_IMP = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Simulated Annealing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING_FEATURE_COUNT = TABU_SUPPORTING_LOCAL_SEARCH_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING___CREATE_REGISTERED_ALGORITHM = TABU_SUPPORTING_LOCAL_SEARCH___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>Simulated Annealing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ANNEALING_OPERATION_COUNT = TABU_SUPPORTING_LOCAL_SEARCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.MemeticAlgorithmImpl <em>Memetic Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.MemeticAlgorithmImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getMemeticAlgorithm()
	 * @generated
	 */
	int MEMETIC_ALGORITHM = 6;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMETIC_ALGORITHM__NR_EVALUATIONS = ALGORITHM__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Localsearchapplication</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION = ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Search</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMETIC_ALGORITHM__GLOBAL_SEARCH = ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Memetic Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMETIC_ALGORITHM_FEATURE_COUNT = ALGORITHM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMETIC_ALGORITHM___CREATE_REGISTERED_ALGORITHM = ALGORITHM___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>Memetic Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMETIC_ALGORITHM_OPERATION_COUNT = ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.LocalSearchApplicationImpl <em>Local Search Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.LocalSearchApplicationImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getLocalSearchApplication()
	 * @generated
	 */
	int LOCAL_SEARCH_APPLICATION = 7;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION__PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Tournament Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE = 1;

	/**
	 * The feature id for the '<em><b>Localsearchalgorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM = 2;

	/**
	 * The feature id for the '<em><b>Last Solution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION__LAST_SOLUTION = 3;

	/**
	 * The feature id for the '<em><b>Start At Eval Perc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC = 4;

	/**
	 * The feature id for the '<em><b>Used Generator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION__USED_GENERATOR = 5;

	/**
	 * The number of structural features of the '<em>Local Search Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Local Search Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_APPLICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.ContainerImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 8;

	/**
	 * The feature id for the '<em><b>Used Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__USED_ALGORITHM = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Neighborhood</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__NEIGHBORHOOD = 2;

	/**
	 * The feature id for the '<em><b>Solutioninitializer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__SOLUTIONINITIALIZER = 3;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.FitnessComparatorGeneratorImpl <em>Fitness Comparator Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.FitnessComparatorGeneratorImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getFitnessComparatorGenerator()
	 * @generated
	 */
	int FITNESS_COMPARATOR_GENERATOR = 10;

	/**
	 * The feature id for the '<em><b>Comparator Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER = 0;

	/**
	 * The number of structural features of the '<em>Fitness Comparator Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FITNESS_COMPARATOR_GENERATOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Fitness Comparator Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FITNESS_COMPARATOR_GENERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.DecreasingMaximumComparatorGeneratorImpl <em>Decreasing Maximum Comparator Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.DecreasingMaximumComparatorGeneratorImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getDecreasingMaximumComparatorGenerator()
	 * @generated
	 */
	int DECREASING_MAXIMUM_COMPARATOR_GENERATOR = 11;

	/**
	 * The feature id for the '<em><b>Comparator Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECREASING_MAXIMUM_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER = FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER;

	/**
	 * The number of structural features of the '<em>Decreasing Maximum Comparator Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECREASING_MAXIMUM_COMPARATOR_GENERATOR_FEATURE_COUNT = FITNESS_COMPARATOR_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Decreasing Maximum Comparator Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECREASING_MAXIMUM_COMPARATOR_GENERATOR_OPERATION_COUNT = FITNESS_COMPARATOR_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.RandomWeightGeneratorImpl <em>Random Weight Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.RandomWeightGeneratorImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getRandomWeightGenerator()
	 * @generated
	 */
	int RANDOM_WEIGHT_GENERATOR = 12;

	/**
	 * The feature id for the '<em><b>Comparator Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_WEIGHT_GENERATOR__COMPARATOR_CONTAINER = FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER;

	/**
	 * The number of structural features of the '<em>Random Weight Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_WEIGHT_GENERATOR_FEATURE_COUNT = FITNESS_COMPARATOR_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Random Weight Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_WEIGHT_GENERATOR_OPERATION_COUNT = FITNESS_COMPARATOR_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.NeighborhoodImpl <em>Neighborhood</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.NeighborhoodImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getNeighborhood()
	 * @generated
	 */
	int NEIGHBORHOOD = 14;

	/**
	 * The number of structural features of the '<em>Neighborhood</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEIGHBORHOOD_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Neighborhood</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEIGHBORHOOD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.ChangingNeighborhoodImpl <em>Changing Neighborhood</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.ChangingNeighborhoodImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getChangingNeighborhood()
	 * @generated
	 */
	int CHANGING_NEIGHBORHOOD = 15;

	/**
	 * The feature id for the '<em><b>Delete Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY = NEIGHBORHOOD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>At End Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY = NEIGHBORHOOD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modify Rule Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY = NEIGHBORHOOD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Changing Neighborhood</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGING_NEIGHBORHOOD_FEATURE_COUNT = NEIGHBORHOOD_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Changing Neighborhood</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGING_NEIGHBORHOOD_OPERATION_COUNT = NEIGHBORHOOD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.IteratingAlgorithmImpl <em>Iterating Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.IteratingAlgorithmImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getIteratingAlgorithm()
	 * @generated
	 */
	int ITERATING_ALGORITHM = 16;

	/**
	 * The feature id for the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM__NR_EVALUATIONS = ALGORITHM__NR_EVALUATIONS;

	/**
	 * The feature id for the '<em><b>Solutioninitializer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM__SOLUTIONINITIALIZER = ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM__ALGORITHM = ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fitnesscomparatorgenerator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR = ALGORITHM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tournament Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM__TOURNAMENT_SIZE = ALGORITHM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tournament Remain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM__TOURNAMENT_REMAIN = ALGORITHM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Iterating Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM_FEATURE_COUNT = ALGORITHM_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Registered Algorithm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM___CREATE_REGISTERED_ALGORITHM = ALGORITHM___CREATE_REGISTERED_ALGORITHM;

	/**
	 * The number of operations of the '<em>Iterating Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATING_ALGORITHM_OPERATION_COUNT = ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.SolutionInitializerImpl <em>Solution Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.SolutionInitializerImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getSolutionInitializer()
	 * @generated
	 */
	int SOLUTION_INITIALIZER = 17;

	/**
	 * The number of structural features of the '<em>Solution Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_INITIALIZER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Solution Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_INITIALIZER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.RandomSolutionInitializerImpl <em>Random Solution Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.RandomSolutionInitializerImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getRandomSolutionInitializer()
	 * @generated
	 */
	int RANDOM_SOLUTION_INITIALIZER = 18;

	/**
	 * The number of structural features of the '<em>Random Solution Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SOLUTION_INITIALIZER_FEATURE_COUNT = SOLUTION_INITIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Random Solution Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SOLUTION_INITIALIZER_OPERATION_COUNT = SOLUTION_INITIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metasearch.impl.DiscardingSolutionInitializerImpl <em>Discarding Solution Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metasearch.impl.DiscardingSolutionInitializerImpl
	 * @see metasearch.impl.MetasearchPackageImpl#getDiscardingSolutionInitializer()
	 * @generated
	 */
	int DISCARDING_SOLUTION_INITIALIZER = 19;

	/**
	 * The feature id for the '<em><b>Solution Consider Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE = SOLUTION_INITIALIZER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Solution Use Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE = SOLUTION_INITIALIZER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Solutions Per Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE = SOLUTION_INITIALIZER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Num Queues</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES = SOLUTION_INITIALIZER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Num Init Solutions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS = SOLUTION_INITIALIZER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Discarding Solution Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCARDING_SOLUTION_INITIALIZER_FEATURE_COUNT = SOLUTION_INITIALIZER_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Discarding Solution Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCARDING_SOLUTION_INITIALIZER_OPERATION_COUNT = SOLUTION_INITIALIZER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link metasearch.GeneticAlgorithm <em>Genetic Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Genetic Algorithm</em>'.
	 * @see metasearch.GeneticAlgorithm
	 * @generated
	 */
	EClass getGeneticAlgorithm();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.GeneticAlgorithm#getPopulationSize <em>Population Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Size</em>'.
	 * @see metasearch.GeneticAlgorithm#getPopulationSize()
	 * @see #getGeneticAlgorithm()
	 * @generated
	 */
	EAttribute getGeneticAlgorithm_PopulationSize();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.GeneticAlgorithm#getMutateDelete <em>Mutate Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutate Delete</em>'.
	 * @see metasearch.GeneticAlgorithm#getMutateDelete()
	 * @see #getGeneticAlgorithm()
	 * @generated
	 */
	EAttribute getGeneticAlgorithm_MutateDelete();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.GeneticAlgorithm#getMutateModifyRule <em>Mutate Modify Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutate Modify Rule</em>'.
	 * @see metasearch.GeneticAlgorithm#getMutateModifyRule()
	 * @see #getGeneticAlgorithm()
	 * @generated
	 */
	EAttribute getGeneticAlgorithm_MutateModifyRule();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.GeneticAlgorithm#getMutateReplaceRule <em>Mutate Replace Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutate Replace Rule</em>'.
	 * @see metasearch.GeneticAlgorithm#getMutateReplaceRule()
	 * @see #getGeneticAlgorithm()
	 * @generated
	 */
	EAttribute getGeneticAlgorithm_MutateReplaceRule();

	/**
	 * Returns the meta object for class '{@link metasearch.LocalSearchAlgorithm <em>Local Search Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Search Algorithm</em>'.
	 * @see metasearch.LocalSearchAlgorithm
	 * @generated
	 */
	EClass getLocalSearchAlgorithm();

	/**
	 * Returns the meta object for the reference '{@link metasearch.LocalSearchAlgorithm#getNeighborhood <em>Neighborhood</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Neighborhood</em>'.
	 * @see metasearch.LocalSearchAlgorithm#getNeighborhood()
	 * @see #getLocalSearchAlgorithm()
	 * @generated
	 */
	EReference getLocalSearchAlgorithm_Neighborhood();

	/**
	 * Returns the meta object for class '{@link metasearch.HillClimbing <em>Hill Climbing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hill Climbing</em>'.
	 * @see metasearch.HillClimbing
	 * @generated
	 */
	EClass getHillClimbing();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.HillClimbing#getNeighborsize <em>Neighborsize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Neighborsize</em>'.
	 * @see metasearch.HillClimbing#getNeighborsize()
	 * @see #getHillClimbing()
	 * @generated
	 */
	EAttribute getHillClimbing_Neighborsize();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.HillClimbing#isNextImprovement <em>Next Improvement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Improvement</em>'.
	 * @see metasearch.HillClimbing#isNextImprovement()
	 * @see #getHillClimbing()
	 * @generated
	 */
	EAttribute getHillClimbing_NextImprovement();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.HillClimbing#getMaxNoImprovement <em>Max No Improvement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max No Improvement</em>'.
	 * @see metasearch.HillClimbing#getMaxNoImprovement()
	 * @see #getHillClimbing()
	 * @generated
	 */
	EAttribute getHillClimbing_MaxNoImprovement();

	/**
	 * Returns the meta object for class '{@link metasearch.NSGAII <em>NSGAII</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NSGAII</em>'.
	 * @see metasearch.NSGAII
	 * @generated
	 */
	EClass getNSGAII();

	/**
	 * Returns the meta object for class '{@link metasearch.NSGAIII <em>NSGAIII</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NSGAIII</em>'.
	 * @see metasearch.NSGAIII
	 * @generated
	 */
	EClass getNSGAIII();

	/**
	 * Returns the meta object for class '{@link metasearch.SimulatedAnnealing <em>Simulated Annealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulated Annealing</em>'.
	 * @see metasearch.SimulatedAnnealing
	 * @generated
	 */
	EClass getSimulatedAnnealing();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.SimulatedAnnealing#getStartTemp <em>Start Temp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Temp</em>'.
	 * @see metasearch.SimulatedAnnealing#getStartTemp()
	 * @see #getSimulatedAnnealing()
	 * @generated
	 */
	EAttribute getSimulatedAnnealing_StartTemp();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.SimulatedAnnealing#getTempIncrease <em>Temp Increase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temp Increase</em>'.
	 * @see metasearch.SimulatedAnnealing#getTempIncrease()
	 * @see #getSimulatedAnnealing()
	 * @generated
	 */
	EAttribute getSimulatedAnnealing_TempIncrease();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.SimulatedAnnealing#getRestartNoCurrentImp <em>Restart No Current Imp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restart No Current Imp</em>'.
	 * @see metasearch.SimulatedAnnealing#getRestartNoCurrentImp()
	 * @see #getSimulatedAnnealing()
	 * @generated
	 */
	EAttribute getSimulatedAnnealing_RestartNoCurrentImp();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.SimulatedAnnealing#getRestartNoBestImp <em>Restart No Best Imp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restart No Best Imp</em>'.
	 * @see metasearch.SimulatedAnnealing#getRestartNoBestImp()
	 * @see #getSimulatedAnnealing()
	 * @generated
	 */
	EAttribute getSimulatedAnnealing_RestartNoBestImp();

	/**
	 * Returns the meta object for class '{@link metasearch.MemeticAlgorithm <em>Memetic Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memetic Algorithm</em>'.
	 * @see metasearch.MemeticAlgorithm
	 * @generated
	 */
	EClass getMemeticAlgorithm();

	/**
	 * Returns the meta object for the containment reference '{@link metasearch.MemeticAlgorithm#getLocalsearchapplication <em>Localsearchapplication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Localsearchapplication</em>'.
	 * @see metasearch.MemeticAlgorithm#getLocalsearchapplication()
	 * @see #getMemeticAlgorithm()
	 * @generated
	 */
	EReference getMemeticAlgorithm_Localsearchapplication();

	/**
	 * Returns the meta object for the reference '{@link metasearch.MemeticAlgorithm#getGlobalSearch <em>Global Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Search</em>'.
	 * @see metasearch.MemeticAlgorithm#getGlobalSearch()
	 * @see #getMemeticAlgorithm()
	 * @generated
	 */
	EReference getMemeticAlgorithm_GlobalSearch();

	/**
	 * Returns the meta object for class '{@link metasearch.LocalSearchApplication <em>Local Search Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Search Application</em>'.
	 * @see metasearch.LocalSearchApplication
	 * @generated
	 */
	EClass getLocalSearchApplication();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.LocalSearchApplication#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see metasearch.LocalSearchApplication#getProbability()
	 * @see #getLocalSearchApplication()
	 * @generated
	 */
	EAttribute getLocalSearchApplication_Probability();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.LocalSearchApplication#getTournamentSize <em>Tournament Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tournament Size</em>'.
	 * @see metasearch.LocalSearchApplication#getTournamentSize()
	 * @see #getLocalSearchApplication()
	 * @generated
	 */
	EAttribute getLocalSearchApplication_TournamentSize();

	/**
	 * Returns the meta object for the reference '{@link metasearch.LocalSearchApplication#getLocalsearchalgorithm <em>Localsearchalgorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Localsearchalgorithm</em>'.
	 * @see metasearch.LocalSearchApplication#getLocalsearchalgorithm()
	 * @see #getLocalSearchApplication()
	 * @generated
	 */
	EReference getLocalSearchApplication_Localsearchalgorithm();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.LocalSearchApplication#isLastSolution <em>Last Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Solution</em>'.
	 * @see metasearch.LocalSearchApplication#isLastSolution()
	 * @see #getLocalSearchApplication()
	 * @generated
	 */
	EAttribute getLocalSearchApplication_LastSolution();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.LocalSearchApplication#getStartAtEvalPerc <em>Start At Eval Perc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start At Eval Perc</em>'.
	 * @see metasearch.LocalSearchApplication#getStartAtEvalPerc()
	 * @see #getLocalSearchApplication()
	 * @generated
	 */
	EAttribute getLocalSearchApplication_StartAtEvalPerc();

	/**
	 * Returns the meta object for the reference '{@link metasearch.LocalSearchApplication#getUsedGenerator <em>Used Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used Generator</em>'.
	 * @see metasearch.LocalSearchApplication#getUsedGenerator()
	 * @see #getLocalSearchApplication()
	 * @generated
	 */
	EReference getLocalSearchApplication_UsedGenerator();

	/**
	 * Returns the meta object for class '{@link metasearch.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see metasearch.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the reference '{@link metasearch.Container#getUsedAlgorithm <em>Used Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used Algorithm</em>'.
	 * @see metasearch.Container#getUsedAlgorithm()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_UsedAlgorithm();

	/**
	 * Returns the meta object for the containment reference list '{@link metasearch.Container#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Algorithm</em>'.
	 * @see metasearch.Container#getAlgorithm()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Algorithm();

	/**
	 * Returns the meta object for the containment reference list '{@link metasearch.Container#getNeighborhood <em>Neighborhood</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Neighborhood</em>'.
	 * @see metasearch.Container#getNeighborhood()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Neighborhood();

	/**
	 * Returns the meta object for the containment reference list '{@link metasearch.Container#getSolutioninitializer <em>Solutioninitializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solutioninitializer</em>'.
	 * @see metasearch.Container#getSolutioninitializer()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Solutioninitializer();

	/**
	 * Returns the meta object for class '{@link metasearch.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithm</em>'.
	 * @see metasearch.Algorithm
	 * @generated
	 */
	EClass getAlgorithm();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.Algorithm#getNrEvaluations <em>Nr Evaluations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nr Evaluations</em>'.
	 * @see metasearch.Algorithm#getNrEvaluations()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_NrEvaluations();

	/**
	 * Returns the meta object for the '{@link metasearch.Algorithm#createRegisteredAlgorithm() <em>Create Registered Algorithm</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Registered Algorithm</em>' operation.
	 * @see metasearch.Algorithm#createRegisteredAlgorithm()
	 * @generated
	 */
	EOperation getAlgorithm__CreateRegisteredAlgorithm();

	/**
	 * Returns the meta object for class '{@link metasearch.FitnessComparatorGenerator <em>Fitness Comparator Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fitness Comparator Generator</em>'.
	 * @see metasearch.FitnessComparatorGenerator
	 * @generated
	 */
	EClass getFitnessComparatorGenerator();

	/**
	 * Returns the meta object for the containment reference list '{@link metasearch.FitnessComparatorGenerator#getComparatorContainer <em>Comparator Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comparator Container</em>'.
	 * @see metasearch.FitnessComparatorGenerator#getComparatorContainer()
	 * @see #getFitnessComparatorGenerator()
	 * @generated
	 */
	EReference getFitnessComparatorGenerator_ComparatorContainer();

	/**
	 * Returns the meta object for class '{@link metasearch.DecreasingMaximumComparatorGenerator <em>Decreasing Maximum Comparator Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decreasing Maximum Comparator Generator</em>'.
	 * @see metasearch.DecreasingMaximumComparatorGenerator
	 * @generated
	 */
	EClass getDecreasingMaximumComparatorGenerator();

	/**
	 * Returns the meta object for class '{@link metasearch.RandomWeightGenerator <em>Random Weight Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Weight Generator</em>'.
	 * @see metasearch.RandomWeightGenerator
	 * @generated
	 */
	EClass getRandomWeightGenerator();

	/**
	 * Returns the meta object for class '{@link metasearch.TabuSupportingLocalSearch <em>Tabu Supporting Local Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tabu Supporting Local Search</em>'.
	 * @see metasearch.TabuSupportingLocalSearch
	 * @generated
	 */
	EClass getTabuSupportingLocalSearch();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.TabuSupportingLocalSearch#getTabuSize <em>Tabu Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tabu Size</em>'.
	 * @see metasearch.TabuSupportingLocalSearch#getTabuSize()
	 * @see #getTabuSupportingLocalSearch()
	 * @generated
	 */
	EAttribute getTabuSupportingLocalSearch_TabuSize();

	/**
	 * Returns the meta object for class '{@link metasearch.Neighborhood <em>Neighborhood</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Neighborhood</em>'.
	 * @see metasearch.Neighborhood
	 * @generated
	 */
	EClass getNeighborhood();

	/**
	 * Returns the meta object for class '{@link metasearch.ChangingNeighborhood <em>Changing Neighborhood</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Changing Neighborhood</em>'.
	 * @see metasearch.ChangingNeighborhood
	 * @generated
	 */
	EClass getChangingNeighborhood();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.ChangingNeighborhood#getDeleteProbability <em>Delete Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delete Probability</em>'.
	 * @see metasearch.ChangingNeighborhood#getDeleteProbability()
	 * @see #getChangingNeighborhood()
	 * @generated
	 */
	EAttribute getChangingNeighborhood_DeleteProbability();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.ChangingNeighborhood#getAtEndProbability <em>At End Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At End Probability</em>'.
	 * @see metasearch.ChangingNeighborhood#getAtEndProbability()
	 * @see #getChangingNeighborhood()
	 * @generated
	 */
	EAttribute getChangingNeighborhood_AtEndProbability();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.ChangingNeighborhood#getModifyRuleProbability <em>Modify Rule Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modify Rule Probability</em>'.
	 * @see metasearch.ChangingNeighborhood#getModifyRuleProbability()
	 * @see #getChangingNeighborhood()
	 * @generated
	 */
	EAttribute getChangingNeighborhood_ModifyRuleProbability();

	/**
	 * Returns the meta object for class '{@link metasearch.IteratingAlgorithm <em>Iterating Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterating Algorithm</em>'.
	 * @see metasearch.IteratingAlgorithm
	 * @generated
	 */
	EClass getIteratingAlgorithm();

	/**
	 * Returns the meta object for the reference '{@link metasearch.IteratingAlgorithm#getSolutioninitializer <em>Solutioninitializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Solutioninitializer</em>'.
	 * @see metasearch.IteratingAlgorithm#getSolutioninitializer()
	 * @see #getIteratingAlgorithm()
	 * @generated
	 */
	EReference getIteratingAlgorithm_Solutioninitializer();

	/**
	 * Returns the meta object for the reference '{@link metasearch.IteratingAlgorithm#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Algorithm</em>'.
	 * @see metasearch.IteratingAlgorithm#getAlgorithm()
	 * @see #getIteratingAlgorithm()
	 * @generated
	 */
	EReference getIteratingAlgorithm_Algorithm();

	/**
	 * Returns the meta object for the reference '{@link metasearch.IteratingAlgorithm#getFitnesscomparatorgenerator <em>Fitnesscomparatorgenerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fitnesscomparatorgenerator</em>'.
	 * @see metasearch.IteratingAlgorithm#getFitnesscomparatorgenerator()
	 * @see #getIteratingAlgorithm()
	 * @generated
	 */
	EReference getIteratingAlgorithm_Fitnesscomparatorgenerator();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.IteratingAlgorithm#getTournamentSize <em>Tournament Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tournament Size</em>'.
	 * @see metasearch.IteratingAlgorithm#getTournamentSize()
	 * @see #getIteratingAlgorithm()
	 * @generated
	 */
	EAttribute getIteratingAlgorithm_TournamentSize();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.IteratingAlgorithm#getTournamentRemain <em>Tournament Remain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tournament Remain</em>'.
	 * @see metasearch.IteratingAlgorithm#getTournamentRemain()
	 * @see #getIteratingAlgorithm()
	 * @generated
	 */
	EAttribute getIteratingAlgorithm_TournamentRemain();

	/**
	 * Returns the meta object for class '{@link metasearch.SolutionInitializer <em>Solution Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution Initializer</em>'.
	 * @see metasearch.SolutionInitializer
	 * @generated
	 */
	EClass getSolutionInitializer();

	/**
	 * Returns the meta object for class '{@link metasearch.RandomSolutionInitializer <em>Random Solution Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Solution Initializer</em>'.
	 * @see metasearch.RandomSolutionInitializer
	 * @generated
	 */
	EClass getRandomSolutionInitializer();

	/**
	 * Returns the meta object for class '{@link metasearch.DiscardingSolutionInitializer <em>Discarding Solution Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discarding Solution Initializer</em>'.
	 * @see metasearch.DiscardingSolutionInitializer
	 * @generated
	 */
	EClass getDiscardingSolutionInitializer();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.DiscardingSolutionInitializer#getSolutionConsiderSize <em>Solution Consider Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solution Consider Size</em>'.
	 * @see metasearch.DiscardingSolutionInitializer#getSolutionConsiderSize()
	 * @see #getDiscardingSolutionInitializer()
	 * @generated
	 */
	EAttribute getDiscardingSolutionInitializer_SolutionConsiderSize();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.DiscardingSolutionInitializer#getSolutionUseSize <em>Solution Use Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solution Use Size</em>'.
	 * @see metasearch.DiscardingSolutionInitializer#getSolutionUseSize()
	 * @see #getDiscardingSolutionInitializer()
	 * @generated
	 */
	EAttribute getDiscardingSolutionInitializer_SolutionUseSize();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.DiscardingSolutionInitializer#getSolutionsPerQueue <em>Solutions Per Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solutions Per Queue</em>'.
	 * @see metasearch.DiscardingSolutionInitializer#getSolutionsPerQueue()
	 * @see #getDiscardingSolutionInitializer()
	 * @generated
	 */
	EAttribute getDiscardingSolutionInitializer_SolutionsPerQueue();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.DiscardingSolutionInitializer#getNumQueues <em>Num Queues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Queues</em>'.
	 * @see metasearch.DiscardingSolutionInitializer#getNumQueues()
	 * @see #getDiscardingSolutionInitializer()
	 * @generated
	 */
	EAttribute getDiscardingSolutionInitializer_NumQueues();

	/**
	 * Returns the meta object for the attribute '{@link metasearch.DiscardingSolutionInitializer#getNumInitSolutions <em>Num Init Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Init Solutions</em>'.
	 * @see metasearch.DiscardingSolutionInitializer#getNumInitSolutions()
	 * @see #getDiscardingSolutionInitializer()
	 * @generated
	 */
	EAttribute getDiscardingSolutionInitializer_NumInitSolutions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetasearchFactory getMetasearchFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link metasearch.impl.GeneticAlgorithmImpl <em>Genetic Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.GeneticAlgorithmImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getGeneticAlgorithm()
		 * @generated
		 */
		EClass GENETIC_ALGORITHM = eINSTANCE.getGeneticAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Population Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENETIC_ALGORITHM__POPULATION_SIZE = eINSTANCE.getGeneticAlgorithm_PopulationSize();

		/**
		 * The meta object literal for the '<em><b>Mutate Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENETIC_ALGORITHM__MUTATE_DELETE = eINSTANCE.getGeneticAlgorithm_MutateDelete();

		/**
		 * The meta object literal for the '<em><b>Mutate Modify Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENETIC_ALGORITHM__MUTATE_MODIFY_RULE = eINSTANCE.getGeneticAlgorithm_MutateModifyRule();

		/**
		 * The meta object literal for the '<em><b>Mutate Replace Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENETIC_ALGORITHM__MUTATE_REPLACE_RULE = eINSTANCE.getGeneticAlgorithm_MutateReplaceRule();

		/**
		 * The meta object literal for the '{@link metasearch.impl.LocalSearchAlgorithmImpl <em>Local Search Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.LocalSearchAlgorithmImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getLocalSearchAlgorithm()
		 * @generated
		 */
		EClass LOCAL_SEARCH_ALGORITHM = eINSTANCE.getLocalSearchAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Neighborhood</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_SEARCH_ALGORITHM__NEIGHBORHOOD = eINSTANCE.getLocalSearchAlgorithm_Neighborhood();

		/**
		 * The meta object literal for the '{@link metasearch.impl.HillClimbingImpl <em>Hill Climbing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.HillClimbingImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getHillClimbing()
		 * @generated
		 */
		EClass HILL_CLIMBING = eINSTANCE.getHillClimbing();

		/**
		 * The meta object literal for the '<em><b>Neighborsize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING__NEIGHBORSIZE = eINSTANCE.getHillClimbing_Neighborsize();

		/**
		 * The meta object literal for the '<em><b>Next Improvement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING__NEXT_IMPROVEMENT = eINSTANCE.getHillClimbing_NextImprovement();

		/**
		 * The meta object literal for the '<em><b>Max No Improvement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HILL_CLIMBING__MAX_NO_IMPROVEMENT = eINSTANCE.getHillClimbing_MaxNoImprovement();

		/**
		 * The meta object literal for the '{@link metasearch.impl.NSGAIIImpl <em>NSGAII</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.NSGAIIImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getNSGAII()
		 * @generated
		 */
		EClass NSGAII = eINSTANCE.getNSGAII();

		/**
		 * The meta object literal for the '{@link metasearch.impl.NSGAIIIImpl <em>NSGAIII</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.NSGAIIIImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getNSGAIII()
		 * @generated
		 */
		EClass NSGAIII = eINSTANCE.getNSGAIII();

		/**
		 * The meta object literal for the '{@link metasearch.impl.SimulatedAnnealingImpl <em>Simulated Annealing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.SimulatedAnnealingImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getSimulatedAnnealing()
		 * @generated
		 */
		EClass SIMULATED_ANNEALING = eINSTANCE.getSimulatedAnnealing();

		/**
		 * The meta object literal for the '<em><b>Start Temp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATED_ANNEALING__START_TEMP = eINSTANCE.getSimulatedAnnealing_StartTemp();

		/**
		 * The meta object literal for the '<em><b>Temp Increase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATED_ANNEALING__TEMP_INCREASE = eINSTANCE.getSimulatedAnnealing_TempIncrease();

		/**
		 * The meta object literal for the '<em><b>Restart No Current Imp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP = eINSTANCE.getSimulatedAnnealing_RestartNoCurrentImp();

		/**
		 * The meta object literal for the '<em><b>Restart No Best Imp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATED_ANNEALING__RESTART_NO_BEST_IMP = eINSTANCE.getSimulatedAnnealing_RestartNoBestImp();

		/**
		 * The meta object literal for the '{@link metasearch.impl.MemeticAlgorithmImpl <em>Memetic Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.MemeticAlgorithmImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getMemeticAlgorithm()
		 * @generated
		 */
		EClass MEMETIC_ALGORITHM = eINSTANCE.getMemeticAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Localsearchapplication</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMETIC_ALGORITHM__LOCALSEARCHAPPLICATION = eINSTANCE.getMemeticAlgorithm_Localsearchapplication();

		/**
		 * The meta object literal for the '<em><b>Global Search</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMETIC_ALGORITHM__GLOBAL_SEARCH = eINSTANCE.getMemeticAlgorithm_GlobalSearch();

		/**
		 * The meta object literal for the '{@link metasearch.impl.LocalSearchApplicationImpl <em>Local Search Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.LocalSearchApplicationImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getLocalSearchApplication()
		 * @generated
		 */
		EClass LOCAL_SEARCH_APPLICATION = eINSTANCE.getLocalSearchApplication();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH_APPLICATION__PROBABILITY = eINSTANCE.getLocalSearchApplication_Probability();

		/**
		 * The meta object literal for the '<em><b>Tournament Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH_APPLICATION__TOURNAMENT_SIZE = eINSTANCE.getLocalSearchApplication_TournamentSize();

		/**
		 * The meta object literal for the '<em><b>Localsearchalgorithm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_SEARCH_APPLICATION__LOCALSEARCHALGORITHM = eINSTANCE.getLocalSearchApplication_Localsearchalgorithm();

		/**
		 * The meta object literal for the '<em><b>Last Solution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH_APPLICATION__LAST_SOLUTION = eINSTANCE.getLocalSearchApplication_LastSolution();

		/**
		 * The meta object literal for the '<em><b>Start At Eval Perc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH_APPLICATION__START_AT_EVAL_PERC = eINSTANCE.getLocalSearchApplication_StartAtEvalPerc();

		/**
		 * The meta object literal for the '<em><b>Used Generator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_SEARCH_APPLICATION__USED_GENERATOR = eINSTANCE.getLocalSearchApplication_UsedGenerator();

		/**
		 * The meta object literal for the '{@link metasearch.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.ContainerImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Used Algorithm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__USED_ALGORITHM = eINSTANCE.getContainer_UsedAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__ALGORITHM = eINSTANCE.getContainer_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Neighborhood</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__NEIGHBORHOOD = eINSTANCE.getContainer_Neighborhood();

		/**
		 * The meta object literal for the '<em><b>Solutioninitializer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__SOLUTIONINITIALIZER = eINSTANCE.getContainer_Solutioninitializer();

		/**
		 * The meta object literal for the '{@link metasearch.impl.AlgorithmImpl <em>Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.AlgorithmImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getAlgorithm()
		 * @generated
		 */
		EClass ALGORITHM = eINSTANCE.getAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Nr Evaluations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__NR_EVALUATIONS = eINSTANCE.getAlgorithm_NrEvaluations();

		/**
		 * The meta object literal for the '<em><b>Create Registered Algorithm</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALGORITHM___CREATE_REGISTERED_ALGORITHM = eINSTANCE.getAlgorithm__CreateRegisteredAlgorithm();

		/**
		 * The meta object literal for the '{@link metasearch.impl.FitnessComparatorGeneratorImpl <em>Fitness Comparator Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.FitnessComparatorGeneratorImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getFitnessComparatorGenerator()
		 * @generated
		 */
		EClass FITNESS_COMPARATOR_GENERATOR = eINSTANCE.getFitnessComparatorGenerator();

		/**
		 * The meta object literal for the '<em><b>Comparator Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FITNESS_COMPARATOR_GENERATOR__COMPARATOR_CONTAINER = eINSTANCE.getFitnessComparatorGenerator_ComparatorContainer();

		/**
		 * The meta object literal for the '{@link metasearch.impl.DecreasingMaximumComparatorGeneratorImpl <em>Decreasing Maximum Comparator Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.DecreasingMaximumComparatorGeneratorImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getDecreasingMaximumComparatorGenerator()
		 * @generated
		 */
		EClass DECREASING_MAXIMUM_COMPARATOR_GENERATOR = eINSTANCE.getDecreasingMaximumComparatorGenerator();

		/**
		 * The meta object literal for the '{@link metasearch.impl.RandomWeightGeneratorImpl <em>Random Weight Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.RandomWeightGeneratorImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getRandomWeightGenerator()
		 * @generated
		 */
		EClass RANDOM_WEIGHT_GENERATOR = eINSTANCE.getRandomWeightGenerator();

		/**
		 * The meta object literal for the '{@link metasearch.impl.TabuSupportingLocalSearchImpl <em>Tabu Supporting Local Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.TabuSupportingLocalSearchImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getTabuSupportingLocalSearch()
		 * @generated
		 */
		EClass TABU_SUPPORTING_LOCAL_SEARCH = eINSTANCE.getTabuSupportingLocalSearch();

		/**
		 * The meta object literal for the '<em><b>Tabu Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABU_SUPPORTING_LOCAL_SEARCH__TABU_SIZE = eINSTANCE.getTabuSupportingLocalSearch_TabuSize();

		/**
		 * The meta object literal for the '{@link metasearch.impl.NeighborhoodImpl <em>Neighborhood</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.NeighborhoodImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getNeighborhood()
		 * @generated
		 */
		EClass NEIGHBORHOOD = eINSTANCE.getNeighborhood();

		/**
		 * The meta object literal for the '{@link metasearch.impl.ChangingNeighborhoodImpl <em>Changing Neighborhood</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.ChangingNeighborhoodImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getChangingNeighborhood()
		 * @generated
		 */
		EClass CHANGING_NEIGHBORHOOD = eINSTANCE.getChangingNeighborhood();

		/**
		 * The meta object literal for the '<em><b>Delete Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGING_NEIGHBORHOOD__DELETE_PROBABILITY = eINSTANCE.getChangingNeighborhood_DeleteProbability();

		/**
		 * The meta object literal for the '<em><b>At End Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGING_NEIGHBORHOOD__AT_END_PROBABILITY = eINSTANCE.getChangingNeighborhood_AtEndProbability();

		/**
		 * The meta object literal for the '<em><b>Modify Rule Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGING_NEIGHBORHOOD__MODIFY_RULE_PROBABILITY = eINSTANCE.getChangingNeighborhood_ModifyRuleProbability();

		/**
		 * The meta object literal for the '{@link metasearch.impl.IteratingAlgorithmImpl <em>Iterating Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.IteratingAlgorithmImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getIteratingAlgorithm()
		 * @generated
		 */
		EClass ITERATING_ALGORITHM = eINSTANCE.getIteratingAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Solutioninitializer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATING_ALGORITHM__SOLUTIONINITIALIZER = eINSTANCE.getIteratingAlgorithm_Solutioninitializer();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATING_ALGORITHM__ALGORITHM = eINSTANCE.getIteratingAlgorithm_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Fitnesscomparatorgenerator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR = eINSTANCE.getIteratingAlgorithm_Fitnesscomparatorgenerator();

		/**
		 * The meta object literal for the '<em><b>Tournament Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATING_ALGORITHM__TOURNAMENT_SIZE = eINSTANCE.getIteratingAlgorithm_TournamentSize();

		/**
		 * The meta object literal for the '<em><b>Tournament Remain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATING_ALGORITHM__TOURNAMENT_REMAIN = eINSTANCE.getIteratingAlgorithm_TournamentRemain();

		/**
		 * The meta object literal for the '{@link metasearch.impl.SolutionInitializerImpl <em>Solution Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.SolutionInitializerImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getSolutionInitializer()
		 * @generated
		 */
		EClass SOLUTION_INITIALIZER = eINSTANCE.getSolutionInitializer();

		/**
		 * The meta object literal for the '{@link metasearch.impl.RandomSolutionInitializerImpl <em>Random Solution Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.RandomSolutionInitializerImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getRandomSolutionInitializer()
		 * @generated
		 */
		EClass RANDOM_SOLUTION_INITIALIZER = eINSTANCE.getRandomSolutionInitializer();

		/**
		 * The meta object literal for the '{@link metasearch.impl.DiscardingSolutionInitializerImpl <em>Discarding Solution Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metasearch.impl.DiscardingSolutionInitializerImpl
		 * @see metasearch.impl.MetasearchPackageImpl#getDiscardingSolutionInitializer()
		 * @generated
		 */
		EClass DISCARDING_SOLUTION_INITIALIZER = eINSTANCE.getDiscardingSolutionInitializer();

		/**
		 * The meta object literal for the '<em><b>Solution Consider Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE = eINSTANCE.getDiscardingSolutionInitializer_SolutionConsiderSize();

		/**
		 * The meta object literal for the '<em><b>Solution Use Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE = eINSTANCE.getDiscardingSolutionInitializer_SolutionUseSize();

		/**
		 * The meta object literal for the '<em><b>Solutions Per Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE = eINSTANCE.getDiscardingSolutionInitializer_SolutionsPerQueue();

		/**
		 * The meta object literal for the '<em><b>Num Queues</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES = eINSTANCE.getDiscardingSolutionInitializer_NumQueues();

		/**
		 * The meta object literal for the '<em><b>Num Init Solutions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS = eINSTANCE.getDiscardingSolutionInitializer_NumInitSolutions();

	}

} //MetasearchPackage
