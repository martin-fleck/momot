/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.HillClimbing;
import metasearch.MetasearchFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hill Climbing</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HillClimbingTest extends TabuSupportingLocalSearchTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HillClimbingTest.class);
	}

	/**
	 * Constructs a new Hill Climbing test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HillClimbingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Hill Climbing test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected HillClimbing getFixture() {
		return (HillClimbing)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createHillClimbing());
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

} //HillClimbingTest
