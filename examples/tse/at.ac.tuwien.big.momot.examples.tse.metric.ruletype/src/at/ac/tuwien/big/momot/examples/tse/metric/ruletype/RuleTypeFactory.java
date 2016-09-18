/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage
 * @generated
 */
public interface RuleTypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuleTypeFactory eINSTANCE = at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.RuleTypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Rule Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Type</em>'.
	 * @generated
	 */
	RuleType createRuleType();

	/**
	 * Returns a new object of class '<em>Transformation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation Type</em>'.
	 * @generated
	 */
	TransformationType createTransformationType();

	/**
	 * Returns a new object of class '<em>MM Names</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MM Names</em>'.
	 * @generated
	 */
	MMNames createMMNames();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RuleTypePackage getRuleTypePackage();

} //RuleTypeFactory
