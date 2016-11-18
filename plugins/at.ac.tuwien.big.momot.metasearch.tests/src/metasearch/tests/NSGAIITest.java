/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.MetasearchFactory;
import metasearch.NSGAII;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>NSGAII</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NSGAIITest extends GeneticAlgorithmTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NSGAIITest.class);
	}

	/**
	 * Constructs a new NSGAII test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NSGAIITest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this NSGAII test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NSGAII getFixture() {
		return (NSGAII)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createNSGAII());
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

} //NSGAIITest
