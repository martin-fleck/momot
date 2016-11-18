/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.DiscardingSolutionInitializer;
import metasearch.MetasearchFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Discarding Solution Initializer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiscardingSolutionInitializerTest extends SolutionInitializerTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DiscardingSolutionInitializerTest.class);
	}

	/**
	 * Constructs a new Discarding Solution Initializer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiscardingSolutionInitializerTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Discarding Solution Initializer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DiscardingSolutionInitializer getFixture() {
		return (DiscardingSolutionInitializer)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createDiscardingSolutionInitializer());
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

} //DiscardingSolutionInitializerTest
