/**
 */
package at.ac.tuwien.big.momot.examples.tse.modularization;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Helper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Helper#getHelperDependencies <em>Helper Dependencies</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.modularization.Helper#getHelperDepNames <em>Helper Dep Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getHelper()
 * @model
 * @generated
 */
public interface Helper extends ModuleElement {
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
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getHelper_HelperDependencies()
	 * @model
	 * @generated
	 */
	EList<Helper> getHelperDependencies();

	/**
	 * Returns the value of the '<em><b>Helper Dep Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper Dep Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper Dep Names</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage#getHelper_HelperDepNames()
	 * @model
	 * @generated
	 */
	EList<String> getHelperDepNames();

} // Helper
