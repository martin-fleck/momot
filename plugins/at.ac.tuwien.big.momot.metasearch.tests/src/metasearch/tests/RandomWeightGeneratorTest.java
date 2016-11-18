/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.MetasearchFactory;
import metasearch.RandomWeightGenerator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Weight Generator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomWeightGeneratorTest extends FitnessComparatorGeneratorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomWeightGeneratorTest.class);
	}

	/**
	 * Constructs a new Random Weight Generator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomWeightGeneratorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Random Weight Generator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RandomWeightGenerator getFixture() {
		return (RandomWeightGenerator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createRandomWeightGenerator());
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

} //RandomWeightGeneratorTest
