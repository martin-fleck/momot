/**
 */
package icmt.tool.momot.demo.architecture;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link icmt.tool.momot.demo.architecture.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 * </ul>
 *
 * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends NamedElement {
   /**
    * Returns the value of the '<em><b>Is Encapsulated By</b></em>' reference.
    * It is bidirectional and its opposite is '{@link icmt.tool.momot.demo.architecture.Class#getEncapsulates
    * <em>Encapsulates</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Is Encapsulated By</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    *
    * @return the value of the '<em>Is Encapsulated By</em>' reference.
    * @see #setIsEncapsulatedBy(icmt.tool.momot.demo.architecture.Class)
    * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#getFeature_IsEncapsulatedBy()
    * @see icmt.tool.momot.demo.architecture.Class#getEncapsulates
    * @model opposite="encapsulates"
    * @generated
    */
   icmt.tool.momot.demo.architecture.Class getIsEncapsulatedBy();

   /**
    * Sets the value of the '{@link icmt.tool.momot.demo.architecture.Feature#getIsEncapsulatedBy <em>Is Encapsulated
    * By</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @param value
    *           the new value of the '<em>Is Encapsulated By</em>' reference.
    * @see #getIsEncapsulatedBy()
    * @generated
    */
   void setIsEncapsulatedBy(icmt.tool.momot.demo.architecture.Class value);

} // Feature
