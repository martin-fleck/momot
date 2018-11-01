/**
 */
package nextReleaseProblem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.Solution#getName <em>Name</em>}</li>
 *   <li>{@link nextReleaseProblem.Solution#getSelectedArtifacts <em>Selected Artifacts</em>}</li>
 * </ul>
 *
 * @see nextReleaseProblem.NextReleaseProblemPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getSolution_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.Solution#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Selected Artifacts</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.SoftwareArtifact}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.SoftwareArtifact#getSolutions <em>Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Artifacts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Artifacts</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getSolution_SelectedArtifacts()
	 * @see nextReleaseProblem.SoftwareArtifact#getSolutions
	 * @model opposite="solutions"
	 * @generated
	 */
	EList<SoftwareArtifact> getSelectedArtifacts();

} // Solution
