/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getOwnedAttribute <em>Owned Attribute</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getSpecialization <em>Specialization</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getGeneralization <em>Generalization</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends NamedElement {
   /**
    * Returns the value of the '<em><b>Generalization</b></em>' reference.
    * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getSpecific <em>Specific</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Generalization</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Generalization</em>' reference.
    * @see #setGeneralization(Generalization)
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getEntity_Generalization()
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getSpecific
    * @model opposite="specific"
    * @generated
    */
   Generalization getGeneralization();

   /**
    * Returns the value of the '<em><b>Owned Attribute</b></em>' reference list.
    * The list contents are of type {@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Owned Attribute</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Owned Attribute</em>' reference list.
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getEntity_OwnedAttribute()
    * @model
    * @generated
    */
   EList<Property> getOwnedAttribute();

   /**
    * Returns the value of the '<em><b>Specialization</b></em>' reference list.
    * The list contents are of type {@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization}.
    * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getGeneral <em>General</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Specialization</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Specialization</em>' reference list.
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getEntity_Specialization()
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getGeneral
    * @model opposite="general"
    * @generated
    */
   EList<Generalization> getSpecialization();

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getGeneralization <em>Generalization</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Generalization</em>' reference.
    * @see #getGeneralization()
    * @generated
    */
   void setGeneralization(Generalization value);

} // Entity
