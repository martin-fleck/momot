/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.architecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature}.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage#getClass_Features()
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature#getContainer
	 * @model opposite="container" required="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

} // Class
