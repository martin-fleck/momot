/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.architecture;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class)
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitecturePackage#getFeature_Container()
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class#getFeatures
	 * @model opposite="features"
	 * @generated
	 */
	at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class getContainer();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class value);

} // Feature
