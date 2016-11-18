/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.MemeticAlgorithm;
import metasearch.MetasearchFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Memetic Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MemeticAlgorithmTest extends AlgorithmTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MemeticAlgorithmTest.class);
	}

	/**
	 * Constructs a new Memetic Algorithm test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemeticAlgorithmTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Memetic Algorithm test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MemeticAlgorithm getFixture() {
		return (MemeticAlgorithm)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createMemeticAlgorithm());
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

} //MemeticAlgorithmTest
