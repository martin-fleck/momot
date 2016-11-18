/**
 */
package metasearch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.Algorithm#getNrEvaluations <em>Nr Evaluations</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getAlgorithm()
 * @model abstract="true"
 * @generated
 */
public interface Algorithm extends EObject {
	/**
	 * Returns the value of the '<em><b>Nr Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Evaluations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Evaluations</em>' attribute.
	 * @see #setNrEvaluations(int)
	 * @see metasearch.MetasearchPackage#getAlgorithm_NrEvaluations()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNrEvaluations();

	/**
	 * Sets the value of the '{@link metasearch.Algorithm#getNrEvaluations <em>Nr Evaluations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Evaluations</em>' attribute.
	 * @see #getNrEvaluations()
	 * @generated
	 */
	void setNrEvaluations(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object createRegisteredAlgorithm();

} // Algorithm
