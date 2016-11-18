/**
 */
package metasearch;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see metasearch.MetasearchPackage
 * @generated
 */
public interface MetasearchFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetasearchFactory eINSTANCE = metasearch.impl.MetasearchFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Hill Climbing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hill Climbing</em>'.
	 * @generated
	 */
	HillClimbing createHillClimbing();

	/**
	 * Returns a new object of class '<em>NSGAII</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NSGAII</em>'.
	 * @generated
	 */
	NSGAII createNSGAII();

	/**
	 * Returns a new object of class '<em>NSGAIII</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NSGAIII</em>'.
	 * @generated
	 */
	NSGAIII createNSGAIII();

	/**
	 * Returns a new object of class '<em>Simulated Annealing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated Annealing</em>'.
	 * @generated
	 */
	SimulatedAnnealing createSimulatedAnnealing();

	/**
	 * Returns a new object of class '<em>Memetic Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memetic Algorithm</em>'.
	 * @generated
	 */
	MemeticAlgorithm createMemeticAlgorithm();

	/**
	 * Returns a new object of class '<em>Local Search Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Search Application</em>'.
	 * @generated
	 */
	LocalSearchApplication createLocalSearchApplication();

	/**
	 * Returns a new object of class '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container</em>'.
	 * @generated
	 */
	Container createContainer();

	/**
	 * Returns a new object of class '<em>Decreasing Maximum Comparator Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decreasing Maximum Comparator Generator</em>'.
	 * @generated
	 */
	DecreasingMaximumComparatorGenerator createDecreasingMaximumComparatorGenerator();

	/**
	 * Returns a new object of class '<em>Random Weight Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Weight Generator</em>'.
	 * @generated
	 */
	RandomWeightGenerator createRandomWeightGenerator();

	/**
	 * Returns a new object of class '<em>Changing Neighborhood</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Changing Neighborhood</em>'.
	 * @generated
	 */
	ChangingNeighborhood createChangingNeighborhood();

	/**
	 * Returns a new object of class '<em>Iterating Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterating Algorithm</em>'.
	 * @generated
	 */
	IteratingAlgorithm createIteratingAlgorithm();

	/**
	 * Returns a new object of class '<em>Random Solution Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Solution Initializer</em>'.
	 * @generated
	 */
	RandomSolutionInitializer createRandomSolutionInitializer();

	/**
	 * Returns a new object of class '<em>Discarding Solution Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Discarding Solution Initializer</em>'.
	 * @generated
	 */
	DiscardingSolutionInitializer createDiscardingSolutionInitializer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetasearchPackage getMetasearchPackage();

} //MetasearchFactory
