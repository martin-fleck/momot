/**
 */
package nextReleaseProblem;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see nextReleaseProblem.NextReleaseProblemPackage
 * @generated
 */
public interface NextReleaseProblemFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NextReleaseProblemFactory eINSTANCE = nextReleaseProblem.impl.NextReleaseProblemFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>NRP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NRP</em>'.
	 * @generated
	 */
	NRP createNRP();

	/**
	 * Returns a new object of class '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer</em>'.
	 * @generated
	 */
	Customer createCustomer();

	/**
	 * Returns a new object of class '<em>Cost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cost</em>'.
	 * @generated
	 */
	Cost createCost();

	/**
	 * Returns a new object of class '<em>Software Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Artifact</em>'.
	 * @generated
	 */
	SoftwareArtifact createSoftwareArtifact();

	/**
	 * Returns a new object of class '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement</em>'.
	 * @generated
	 */
	Requirement createRequirement();

	/**
	 * Returns a new object of class '<em>Requirement Realisation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement Realisation</em>'.
	 * @generated
	 */
	RequirementRealisation createRequirementRealisation();

	/**
	 * Returns a new object of class '<em>Solution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution</em>'.
	 * @generated
	 */
	Solution createSolution();

	/**
	 * Returns a new object of class '<em>Valuation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Valuation</em>'.
	 * @generated
	 */
	Valuation createValuation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NextReleaseProblemPackage getNextReleaseProblemPackage();

} //NextReleaseProblemFactory
