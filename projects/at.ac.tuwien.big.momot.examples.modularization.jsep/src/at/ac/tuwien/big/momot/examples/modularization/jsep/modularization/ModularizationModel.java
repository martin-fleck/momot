/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.modularization;

import java.io.Serializable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel#getModules <em>Modules</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationPackage#getModularizationModel()
 * @model
 * @generated
 */
public interface ModularizationModel extends NamedElement, Serializable {
	/**
	 * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Module}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modules</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationPackage#getModularizationModel_Modules()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Module> getModules();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationPackage#getModularizationModel_Classes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class> getClasses();

} // ModularizationModel
