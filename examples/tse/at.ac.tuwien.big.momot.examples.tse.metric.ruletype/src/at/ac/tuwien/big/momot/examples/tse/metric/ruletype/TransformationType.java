/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trafo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getRules <em>Rules</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getMms <em>Mms</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getTransformationType()
 * @model
 * @generated
 */
public interface TransformationType extends EObject {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getTransformationType_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuleType> getRules();

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
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getTransformationType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mms</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames}.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getTrafo <em>Trafo</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mms</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getTransformationType_Mms()
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames#getTrafo
	 * @model opposite="trafo" containment="true"
	 * @generated
	 */
	EList<MMNames> getMms();

} // Trafo
