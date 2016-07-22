/**
 */
package icmt.tool.momot.demo.architecture;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see icmt.tool.momot.demo.architecture.ArchitecturePackage
 * @generated
 */
public interface ArchitectureFactory extends EFactory {
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   ArchitectureFactory eINSTANCE = icmt.tool.momot.demo.architecture.impl.ArchitectureFactoryImpl.init();

   /**
    * Returns a new object of class '<em>Attribute</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return a new object of class '<em>Attribute</em>'.
    * @generated
    */
   Attribute createAttribute();

   /**
    * Returns a new object of class '<em>Class</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return a new object of class '<em>Class</em>'.
    * @generated
    */
   Class createClass();

   /**
    * Returns a new object of class '<em>Class Model</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return a new object of class '<em>Class Model</em>'.
    * @generated
    */
   ClassModel createClassModel();

   /**
    * Returns a new object of class '<em>Method</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return a new object of class '<em>Method</em>'.
    * @generated
    */
   Method createMethod();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the package supported by this factory.
    * @generated
    */
   ArchitecturePackage getArchitecturePackage();

} // ArchitectureFactory
