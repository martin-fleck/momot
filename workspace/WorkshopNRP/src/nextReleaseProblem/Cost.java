/**
 */
package nextReleaseProblem;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nextReleaseProblem.Cost#getType <em>Type</em>}</li>
 *   <li>{@link nextReleaseProblem.Cost#getAmount <em>Amount</em>}</li>
 * </ul>
 *
 * @see nextReleaseProblem.NextReleaseProblemPackage#getCost()
 * @model
 * @generated
 */
public interface Cost extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link nextReleaseProblem.CostType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see nextReleaseProblem.CostType
	 * @see #setType(CostType)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getCost_Type()
	 * @model
	 * @generated
	 */
	CostType getType();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.Cost#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see nextReleaseProblem.CostType
	 * @see #getType()
	 * @generated
	 */
	void setType(CostType value);

	/**
	 * Returns the value of the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount</em>' attribute.
	 * @see #setAmount(double)
	 * @see nextReleaseProblem.NextReleaseProblemPackage#getCost_Amount()
	 * @model
	 * @generated
	 */
	double getAmount();

	/**
	 * Sets the value of the '{@link nextReleaseProblem.Cost#getAmount <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount</em>' attribute.
	 * @see #getAmount()
	 * @generated
	 */
	void setAmount(double value);

} // Cost
