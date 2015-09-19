/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.architecture;

import java.io.Serializable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel#getClasses <em>Classes</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage#getSoftwareModel()
 * @model
 * @generated
 */
public interface SoftwareModel extends NamedElement, Serializable {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage#getSoftwareModel_Classes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage#getSoftwareModel_Features()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Feature> getFeatures();

} // SoftwareModel
