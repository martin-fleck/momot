/**
 */
package at.ac.tuwien.big.momot.examples.tse.modularization;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Module#getRules <em>Rules</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Module#getHelpers <em>Helpers</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getModule()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='notEmpty'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot notEmpty='rules->notEmpty() or helpers->notEmpty()'"
 * @generated
 */
public interface Module extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getModule_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Helpers</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.tse.modularization.Helper}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helpers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helpers</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getModule_Helpers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Helper> getHelpers();

} // Module
