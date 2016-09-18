/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MM Names</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getInputMM <em>Input MM</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getOutputMM <em>Output MM</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getTrafo <em>Trafo</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getMMNames()
 * @model
 * @generated
 */
public interface MMNames extends EObject {
	/**
	 * Returns the value of the '<em><b>Input MM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input MM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input MM</em>' attribute.
	 * @see #setInputMM(String)
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getMMNames_InputMM()
	 * @model required="true"
	 * @generated
	 */
	String getInputMM();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getInputMM <em>Input MM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input MM</em>' attribute.
	 * @see #getInputMM()
	 * @generated
	 */
	void setInputMM(String value);

	/**
	 * Returns the value of the '<em><b>Output MM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output MM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output MM</em>' attribute.
	 * @see #setOutputMM(String)
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getMMNames_OutputMM()
	 * @model required="true"
	 * @generated
	 */
	String getOutputMM();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getOutputMM <em>Output MM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output MM</em>' attribute.
	 * @see #getOutputMM()
	 * @generated
	 */
	void setOutputMM(String value);

	/**
	 * Returns the value of the '<em><b>Trafo</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getMms <em>Mms</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trafo</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trafo</em>' container reference.
	 * @see #setTrafo(TransformationType)
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getMMNames_Trafo()
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getMms
	 * @model opposite="mms" required="true" transient="false"
	 * @generated
	 */
	TransformationType getTrafo();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getTrafo <em>Trafo</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trafo</em>' container reference.
	 * @see #getTrafo()
	 * @generated
	 */
	void setTrafo(TransformationType value);

} // MMNames
