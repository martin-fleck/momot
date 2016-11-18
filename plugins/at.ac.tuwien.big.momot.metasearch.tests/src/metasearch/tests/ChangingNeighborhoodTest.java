/**
 */
package metasearch.tests;

import junit.textui.TestRunner;

import metasearch.ChangingNeighborhood;
import metasearch.MetasearchFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Changing Neighborhood</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangingNeighborhoodTest extends NeighborhoodTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ChangingNeighborhoodTest.class);
	}

	/**
	 * Constructs a new Changing Neighborhood test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangingNeighborhoodTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Changing Neighborhood test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ChangingNeighborhood getFixture() {
		return (ChangingNeighborhood)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createChangingNeighborhood());
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

} //ChangingNeighborhoodTest
