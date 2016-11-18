/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.MetasearchFactory;
import metasearch.SimulatedAnnealing;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Simulated Annealing</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulatedAnnealingTest extends TabuSupportingLocalSearchTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimulatedAnnealingTest.class);
	}

	/**
	 * Constructs a new Simulated Annealing test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedAnnealingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Simulated Annealing test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SimulatedAnnealing getFixture() {
		return (SimulatedAnnealing)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createSimulatedAnnealing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SimulatedAnnealingTest
