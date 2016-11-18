/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.DecreasingMaximumComparatorGenerator;
import metasearch.MetasearchFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Decreasing Maximum Comparator Generator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DecreasingMaximumComparatorGeneratorTest extends FitnessComparatorGeneratorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DecreasingMaximumComparatorGeneratorTest.class);
	}

	/**
	 * Constructs a new Decreasing Maximum Comparator Generator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecreasingMaximumComparatorGeneratorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Decreasing Maximum Comparator Generator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DecreasingMaximumComparatorGenerator getFixture() {
		return (DecreasingMaximumComparatorGenerator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createDecreasingMaximumComparatorGenerator());
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

} //DecreasingMaximumComparatorGeneratorTest
