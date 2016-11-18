/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.MetasearchFactory;
import metasearch.RandomSolutionInitializer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Solution Initializer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomSolutionInitializerTest extends SolutionInitializerTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomSolutionInitializerTest.class);
	}

	/**
	 * Constructs a new Random Solution Initializer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomSolutionInitializerTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Random Solution Initializer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RandomSolutionInitializer getFixture() {
		return (RandomSolutionInitializer)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createRandomSolutionInitializer());
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

} //RandomSolutionInitializerTest
