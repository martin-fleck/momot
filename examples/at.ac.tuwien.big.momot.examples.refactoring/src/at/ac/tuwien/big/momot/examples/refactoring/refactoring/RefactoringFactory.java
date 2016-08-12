/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage
 * @generated
 */
public interface RefactoringFactory extends EFactory {
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   RefactoringFactory eINSTANCE = at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringFactoryImpl
         .init();

   /**
    * Returns a new object of class '<em>Entity</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Entity</em>'.
    * @generated
    */
   Entity createEntity();

   /**
    * Returns a new object of class '<em>Generalization</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Generalization</em>'.
    * @generated
    */
   Generalization createGeneralization();

   /**
    * Returns a new object of class '<em>Named Element</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Named Element</em>'.
    * @generated
    */
   NamedElement createNamedElement();

   /**
    * Returns a new object of class '<em>Property</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Property</em>'.
    * @generated
    */
   Property createProperty();

   /**
    * Returns a new object of class '<em>Model</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Model</em>'.
    * @generated
    */
   RefactoringModel createRefactoringModel();

   /**
    * Returns a new object of class '<em>Type</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Type</em>'.
    * @generated
    */
   Type createType();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the package supported by this factory.
    * @generated
    */
   RefactoringPackage getRefactoringPackage();

} // RefactoringFactory
