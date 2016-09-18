/**
 */
package at.ac.tuwien.big.momot.examples.tse.modularization;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getBindingTypes <em>Binding Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getInPattElTypes <em>In Patt El Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getBindingNavigations <em>Binding Navigations</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getRuleDependencies <em>Rule Dependencies</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getInheritsFrom <em>Inherits From</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule#getHelperDependencies <em>Helper Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends ModuleElement {
	/**
	 * Returns the value of the '<em><b>Binding Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Types</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getRule_BindingTypes()
	 * @model
	 * @generated
	 */
	EList<String> getBindingTypes();

	/**
	 * Returns the value of the '<em><b>In Patt El Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Patt El Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Patt El Types</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getRule_InPattElTypes()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getInPattElTypes();

	/**
	 * Returns the value of the '<em><b>Binding Navigations</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Navigations</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Navigations</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getRule_BindingNavigations()
	 * @model
	 * @generated
	 */
	EList<String> getBindingNavigations();

	/**
	 * Returns the value of the '<em><b>Rule Dependencies</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Dependencies</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getRule_RuleDependencies()
	 * @model
	 * @generated
	 */
	EList<Rule> getRuleDependencies();

	/**
	 * Returns the value of the '<em><b>Inherits From</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.tse.modularization.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherits From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherits From</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getRule_InheritsFrom()
	 * @model
	 * @generated
	 */
	EList<Rule> getInheritsFrom();

	/**
	 * Returns the value of the '<em><b>Helper Dependencies</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.tse.modularization.Helper}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper Dependencies</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getRule_HelperDependencies()
	 * @model
	 * @generated
	 */
	EList<Helper> getHelperDependencies();

} // Rule
