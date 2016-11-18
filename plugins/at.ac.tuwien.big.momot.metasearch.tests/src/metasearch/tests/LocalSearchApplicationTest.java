/**
 */
package metasearch.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import metasearch.LocalSearchApplication;
import metasearch.MetasearchFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Local Search Application</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocalSearchApplicationTest extends TestCase {

	/**
	 * The fixture for this Local Search Application test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalSearchApplication fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LocalSearchApplicationTest.class);
	}

	/**
	 * Constructs a new Local Search Application test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalSearchApplicationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Local Search Application test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LocalSearchApplication fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Local Search Application test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalSearchApplication getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetasearchFactory.eINSTANCE.createLocalSearchApplication());
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

} //LocalSearchApplicationTest
