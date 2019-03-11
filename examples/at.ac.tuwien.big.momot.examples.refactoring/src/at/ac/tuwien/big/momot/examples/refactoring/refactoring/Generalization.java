/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generalization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getSpecific <em>Specific</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getGeneral <em>General</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getGeneralization()
 * @model
 * @generated
 */
public interface Generalization extends EObject {
   /**
    * Returns the value of the '<em><b>General</b></em>' reference.
    * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getSpecialization <em>Specialization</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>General</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>General</em>' reference.
    * @see #setGeneral(Entity)
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getGeneralization_General()
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getSpecialization
    * @model opposite="specialization" required="true"
    * @generated
    */
   Entity getGeneral();

   /**
    * Returns the value of the '<em><b>Specific</b></em>' reference.
    * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getGeneralization <em>Generalization</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Specific</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Specific</em>' reference.
    * @see #setSpecific(Entity)
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getGeneralization_Specific()
    * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getGeneralization
    * @model opposite="generalization" required="true"
    * @generated
    */
   Entity getSpecific();

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getGeneral <em>General</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>General</em>' reference.
    * @see #getGeneral()
    * @generated
    */
   void setGeneral(Entity value);

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getSpecific <em>Specific</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Specific</em>' reference.
    * @see #getSpecific()
    * @generated
    */
   void setSpecific(Entity value);

} // Generalization
