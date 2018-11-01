/**
 */
package nextReleaseProblem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.SoftwareArtifact#getName <em>Name</em>}</li>
 *   <li>{@link nextReleaseProblem.SoftwareArtifact#getRequires <em>Requires</em>}</li>
 *   <li>{@link nextReleaseProblem.SoftwareArtifact#getCosts <em>Costs</em>}</li>
 *   <li>{@link nextReleaseProblem.SoftwareArtifact#getContributesTo <em>Contributes To</em>}</li>
 *   <li>{@link nextReleaseProblem.SoftwareArtifact#getSolutions <em>Solutions</em>}</li>
 * </ul>
 *
 * @see nextReleaseProblem.NextReleaseProblemPackage#getSoftwareArtifact()
 * @model
 * @generated
 */
public interface SoftwareArtifact extends EObject {
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
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getSoftwareArtifact_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.SoftwareArtifact#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.SoftwareArtifact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getSoftwareArtifact_Requires()
	 * @model
	 * @generated
	 */
	EList<SoftwareArtifact> getRequires();

	/**
	 * Returns the value of the '<em><b>Costs</b></em>' containment reference list.
	 * The list contents are of type {@link nextReleaseProblem.Cost}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Costs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Costs</em>' containment reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getSoftwareArtifact_Costs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Cost> getCosts();

	/**
	 * Returns the value of the '<em><b>Contributes To</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.RequirementRealisation}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.RequirementRealisation#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributes To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributes To</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getSoftwareArtifact_ContributesTo()
	 * @see nextReleaseProblem.RequirementRealisation#getDependsOn
	 * @model opposite="dependsOn" required="true"
	 * @generated
	 */
	EList<RequirementRealisation> getContributesTo();

	/**
	 * Returns the value of the '<em><b>Solutions</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.Solution}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.Solution#getSelectedArtifacts <em>Selected Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutions</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getSoftwareArtifact_Solutions()
	 * @see nextReleaseProblem.Solution#getSelectedArtifacts
	 * @model opposite="selectedArtifacts"
	 * @generated
	 */
	EList<Solution> getSolutions();

} // SoftwareArtifact
