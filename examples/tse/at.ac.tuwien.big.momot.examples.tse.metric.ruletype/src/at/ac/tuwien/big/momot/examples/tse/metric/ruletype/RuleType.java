/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInherits <em>Inherits</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInFeatures <em>In Features</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInTypes <em>In Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutTypes <em>Out Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutFeaturesImperative <em>Out Features Imperative</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getAllNavigationPaths <em>All Navigation Paths</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getBindingFeatures <em>Binding Features</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getAllFootPrints <em>All Foot Prints</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getOutFeatures <em>Out Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType()
 * @model
 * @generated
 */
public interface RuleType extends EObject {
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
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Inherits</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherits</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherits</em>' reference.
	 * @see #setInherits(RuleType)
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_Inherits()
	 * @model
	 * @generated
	 */
	RuleType getInherits();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType#getInherits <em>Inherits</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherits</em>' reference.
	 * @see #getInherits()
	 * @generated
	 */
	void setInherits(RuleType value);

	/**
	 * Returns the value of the '<em><b>In Features</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Features</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Features</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_InFeatures()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getInFeatures();

	/**
	 * Returns the value of the '<em><b>In Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Types</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_InTypes()
	 * @model
	 * @generated
	 */
	EList<String> getInTypes();

	/**
	 * Returns the value of the '<em><b>Out Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Types</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_OutTypes()
	 * @model
	 * @generated
	 */
	EList<String> getOutTypes();

	/**
	 * Returns the value of the '<em><b>Out Features Imperative</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Features Imperative</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Features Imperative</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_OutFeaturesImperative()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getOutFeaturesImperative();

	/**
	 * Returns the value of the '<em><b>All Navigation Paths</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Navigation Paths</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Navigation Paths</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_AllNavigationPaths()
	 * @model
	 * @generated
	 */
	EList<String> getAllNavigationPaths();

	/**
	 * Returns the value of the '<em><b>Binding Features</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Features</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Features</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_BindingFeatures()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getBindingFeatures();

	/**
	 * Returns the value of the '<em><b>All Foot Prints</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Foot Prints</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Foot Prints</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_AllFootPrints()
	 * @model
	 * @generated
	 */
	EList<String> getAllFootPrints();

	/**
	 * Returns the value of the '<em><b>Out Features</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Features</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Features</em>' attribute list.
	 * @see at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage#getRuleType_OutFeatures()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getOutFeatures();

} // Rule
