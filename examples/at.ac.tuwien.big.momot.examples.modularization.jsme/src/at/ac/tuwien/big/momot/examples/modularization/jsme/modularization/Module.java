/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsme.modularization;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class}.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage#getModule_Classes()
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class#getModule
	 * @model opposite="module"
	 * @generated
	 */
	EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> getClasses();

} // Module
