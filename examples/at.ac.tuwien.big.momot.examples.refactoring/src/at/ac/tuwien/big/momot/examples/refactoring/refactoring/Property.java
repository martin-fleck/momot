/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends NamedElement {
   /**
    * Returns the value of the '<em><b>Type</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Type</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Type</em>' reference.
    * @see #setType(Type)
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getProperty_Type()
    * @model required="true"
    * @generated
    */
   Type getType();

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property#getType <em>Type</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Type</em>' reference.
    * @see #getType()
    * @generated
    */
   void setType(Type value);

} // Property
