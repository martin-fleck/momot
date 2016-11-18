/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.MetasearchFactory;
import metasearch.NSGAIII;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>NSGAIII</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NSGAIIITest extends GeneticAlgorithmTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NSGAIIITest.class);
	}

	/**
	 * Constructs a new NSGAIII test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NSGAIIITest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this NSGAIII test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NSGAIII getFixture() {
		return (NSGAIII)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createNSGAIII());
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

} //NSGAIIITest
