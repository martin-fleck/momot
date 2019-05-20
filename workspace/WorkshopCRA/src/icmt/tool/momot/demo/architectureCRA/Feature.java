/**
 */
package icmt.tool.momot.demo.architectureCRA;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.Feature#getNext <em>Next</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.Feature#getPrev <em>Prev</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.Feature#getSenselessToken <em>Senseless Token</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.Feature#getFind <em>Find</em>}</li>
 * </ul>
 *
 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Is Encapsulated By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link icmt.tool.momot.demo.architectureCRA.Class#getEncapsulates <em>Encapsulates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Encapsulated By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #setIsEncapsulatedBy(icmt.tool.momot.demo.architectureCRA.Class)
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getFeature_IsEncapsulatedBy()
	 * @see icmt.tool.momot.demo.architectureCRA.Class#getEncapsulates
	 * @model opposite="encapsulates"
	 * @generated
	 */
	icmt.tool.momot.demo.architectureCRA.Class getIsEncapsulatedBy();

	/**
	 * Sets the value of the '{@link icmt.tool.momot.demo.architectureCRA.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #getIsEncapsulatedBy()
	 * @generated
	 */
	void setIsEncapsulatedBy(icmt.tool.momot.demo.architectureCRA.Class value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link icmt.tool.momot.demo.architectureCRA.Feature#getPrev <em>Prev</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' reference.
	 * @see #setNext(Feature)
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getFeature_Next()
	 * @see icmt.tool.momot.demo.architectureCRA.Feature#getPrev
	 * @model opposite="prev"
	 * @generated
	 */
	Feature getNext();

	/**
	 * Sets the value of the '{@link icmt.tool.momot.demo.architectureCRA.Feature#getNext <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(Feature value);

	/**
	 * Returns the value of the '<em><b>Prev</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link icmt.tool.momot.demo.architectureCRA.Feature#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prev</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prev</em>' reference.
	 * @see #setPrev(Feature)
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getFeature_Prev()
	 * @see icmt.tool.momot.demo.architectureCRA.Feature#getNext
	 * @model opposite="next"
	 * @generated
	 */
	Feature getPrev();

	/**
	 * Sets the value of the '{@link icmt.tool.momot.demo.architectureCRA.Feature#getPrev <em>Prev</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prev</em>' reference.
	 * @see #getPrev()
	 * @generated
	 */
	void setPrev(Feature value);

	/**
	 * Returns the value of the '<em><b>Senseless Token</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Senseless Token</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Senseless Token</em>' containment reference.
	 * @see #setSenselessToken(SenselessToken)
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getFeature_SenselessToken()
	 * @model containment="true"
	 * @generated
	 */
	SenselessToken getSenselessToken();

	/**
	 * Sets the value of the '{@link icmt.tool.momot.demo.architectureCRA.Feature#getSenselessToken <em>Senseless Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Senseless Token</em>' containment reference.
	 * @see #getSenselessToken()
	 * @generated
	 */
	void setSenselessToken(SenselessToken value);

	/**
	 * Returns the value of the '<em><b>Find</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Find</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Find</em>' attribute.
	 * @see #setFind(int)
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getFeature_Find()
	 * @model
	 * @generated
	 */
	int getFind();

	/**
	 * Sets the value of the '{@link icmt.tool.momot.demo.architectureCRA.Feature#getFind <em>Find</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Find</em>' attribute.
	 * @see #getFind()
	 * @generated
	 */
	void setFind(int value);

} // Feature
