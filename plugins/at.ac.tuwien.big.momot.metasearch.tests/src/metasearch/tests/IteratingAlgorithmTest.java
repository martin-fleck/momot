/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.IteratingAlgorithm;
import metasearch.MetasearchFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Iterating Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IteratingAlgorithmTest extends AlgorithmTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IteratingAlgorithmTest.class);
	}

	/**
	 * Constructs a new Iterating Algorithm test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratingAlgorithmTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Iterating Algorithm test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IteratingAlgorithm getFixture() {
		return (IteratingAlgorithm)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createIteratingAlgorithm());
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

} //IteratingAlgorithmTest
