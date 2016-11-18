/**
 */
package metasearch.impl;

import metasearch.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetasearchFactoryImpl extends EFactoryImpl implements MetasearchFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetasearchFactory init() {
		try {
			MetasearchFactory theMetasearchFactory = (MetasearchFactory)EPackage.Registry.INSTANCE.getEFactory(MetasearchPackage.eNS_URI);
			if (theMetasearchFactory != null) {
				return theMetasearchFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetasearchFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetasearchFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetasearchPackage.HILL_CLIMBING: return createHillClimbing();
			case MetasearchPackage.NSGAII: return createNSGAII();
			case MetasearchPackage.NSGAIII: return createNSGAIII();
			case MetasearchPackage.SIMULATED_ANNEALING: return createSimulatedAnnealing();
			case MetasearchPackage.MEMETIC_ALGORITHM: return createMemeticAlgorithm();
			case MetasearchPackage.LOCAL_SEARCH_APPLICATION: return createLocalSearchApplication();
			case MetasearchPackage.CONTAINER: return createContainer();
			case MetasearchPackage.DECREASING_MAXIMUM_COMPARATOR_GENERATOR: return createDecreasingMaximumComparatorGenerator();
			case MetasearchPackage.RANDOM_WEIGHT_GENERATOR: return createRandomWeightGenerator();
			case MetasearchPackage.CHANGING_NEIGHBORHOOD: return createChangingNeighborhood();
			case MetasearchPackage.ITERATING_ALGORITHM: return createIteratingAlgorithm();
			case MetasearchPackage.RANDOM_SOLUTION_INITIALIZER: return createRandomSolutionInitializer();
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER: return createDiscardingSolutionInitializer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HillClimbing createHillClimbing() {
		HillClimbingImpl hillClimbing = new HillClimbingImpl();
		return hillClimbing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NSGAII createNSGAII() {
		NSGAIIImpl nsgaii = new NSGAIIImpl();
		return nsgaii;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NSGAIII createNSGAIII() {
		NSGAIIIImpl nsgaiii = new NSGAIIIImpl();
		return nsgaiii;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedAnnealing createSimulatedAnnealing() {
		SimulatedAnnealingImpl simulatedAnnealing = new SimulatedAnnealingImpl();
		return simulatedAnnealing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemeticAlgorithm createMemeticAlgorithm() {
		MemeticAlgorithmImpl memeticAlgorithm = new MemeticAlgorithmImpl();
		return memeticAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchApplication createLocalSearchApplication() {
		LocalSearchApplicationImpl localSearchApplication = new LocalSearchApplicationImpl();
		return localSearchApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public metasearch.Container createContainer() {
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecreasingMaximumComparatorGenerator createDecreasingMaximumComparatorGenerator() {
		DecreasingMaximumComparatorGeneratorImpl decreasingMaximumComparatorGenerator = new DecreasingMaximumComparatorGeneratorImpl();
		return decreasingMaximumComparatorGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomWeightGenerator createRandomWeightGenerator() {
		RandomWeightGeneratorImpl randomWeightGenerator = new RandomWeightGeneratorImpl();
		return randomWeightGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangingNeighborhood createChangingNeighborhood() {
		ChangingNeighborhoodImpl changingNeighborhood = new ChangingNeighborhoodImpl();
		return changingNeighborhood;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratingAlgorithm createIteratingAlgorithm() {
		IteratingAlgorithmImpl iteratingAlgorithm = new IteratingAlgorithmImpl();
		return iteratingAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomSolutionInitializer createRandomSolutionInitializer() {
		RandomSolutionInitializerImpl randomSolutionInitializer = new RandomSolutionInitializerImpl();
		return randomSolutionInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiscardingSolutionInitializer createDiscardingSolutionInitializer() {
		DiscardingSolutionInitializerImpl discardingSolutionInitializer = new DiscardingSolutionInitializerImpl();
		return discardingSolutionInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetasearchPackage getMetasearchPackage() {
		return (MetasearchPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetasearchPackage getPackage() {
		return MetasearchPackage.eINSTANCE;
	}

} //MetasearchFactoryImpl
