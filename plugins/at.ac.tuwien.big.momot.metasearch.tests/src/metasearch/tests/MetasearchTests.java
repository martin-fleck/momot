/**
 */
package metasearch.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>metasearch</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetasearchTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new MetasearchTests("metasearch Tests");
		suite.addTestSuite(HillClimbingTest.class);
		suite.addTestSuite(NSGAIITest.class);
		suite.addTestSuite(NSGAIIITest.class);
		suite.addTestSuite(SimulatedAnnealingTest.class);
		suite.addTestSuite(MemeticAlgorithmTest.class);
		suite.addTestSuite(IteratingAlgorithmTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetasearchTests(String name) {
		super(name);
	}

} //MetasearchTests
