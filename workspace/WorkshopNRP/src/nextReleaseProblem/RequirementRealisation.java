/**
 */
package nextReleaseProblem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Realisation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.RequirementRealisation#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link nextReleaseProblem.RequirementRealisation#getPercentage <em>Percentage</em>}</li>
 *   <li>{@link nextReleaseProblem.RequirementRealisation#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link nextReleaseProblem.RequirementRealisation#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirementRealisation()
 * @model
 * @generated
 */
public interface RequirementRealisation extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.Requirement#getRealisations <em>Realisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' container reference.
	 * @see #setRequirement(Requirement)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirementRealisation_Requirement()
	 * @see nextReleaseProblem.Requirement#getRealisations
	 * @model opposite="realisations" required="true" transient="false"
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.RequirementRealisation#getRequirement <em>Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' container reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage</em>' attribute.
	 * @see #setPercentage(double)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirementRealisation_Percentage()
	 * @model default="1.0"
	 * @generated
	 */
	double getPercentage();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.RequirementRealisation#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage</em>' attribute.
	 * @see #getPercentage()
	 * @generated
	 */
	void setPercentage(double value);

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link nextReleaseProblem.SoftwareArtifact}.
	 * It is bidirectional and its opposite is '{@link nextReleaseProblem.SoftwareArtifact#getContributesTo <em>Contributes To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirementRealisation_DependsOn()
	 * @see nextReleaseProblem.SoftwareArtifact#getContributesTo
	 * @model opposite="contributesTo" required="true"
	 * @generated
	 */
	EList<SoftwareArtifact> getDependsOn();

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
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getRequirementRealisation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.RequirementRealisation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // RequirementRealisation
