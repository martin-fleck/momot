/**
 */
package icmt.tool.momot.demo.architecture.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import icmt.tool.momot.demo.architecture.ArchitectureFactory;
import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.Attribute;
import icmt.tool.momot.demo.architecture.ClassModel;
import icmt.tool.momot.demo.architecture.Method;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ArchitectureFactoryImpl extends EFactoryImpl implements ArchitectureFactory {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @deprecated
    * @generated
    */
   @Deprecated
   public static ArchitecturePackage getPackage() {
      return ArchitecturePackage.eINSTANCE;
   }

   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public static ArchitectureFactory init() {
      try {
         final ArchitectureFactory theArchitectureFactory = (ArchitectureFactory) EPackage.Registry.INSTANCE
               .getEFactory(ArchitecturePackage.eNS_URI);
         if(theArchitectureFactory != null) {
            return theArchitectureFactory;
         }
      } catch(final Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new ArchitectureFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public ArchitectureFactoryImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EObject create(final EClass eClass) {
      switch(eClass.getClassifierID()) {
         case ArchitecturePackage.CLASS_MODEL:
            return createClassModel();
         case ArchitecturePackage.CLASS:
            return createClass();
         case ArchitecturePackage.ATTRIBUTE:
            return createAttribute();
         case ArchitecturePackage.METHOD:
            return createMethod();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public Attribute createAttribute() {
      final AttributeImpl attribute = new AttributeImpl();
      return attribute;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public icmt.tool.momot.demo.architecture.Class createClass() {
      final ClassImpl class_ = new ClassImpl();
      return class_;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public ClassModel createClassModel() {
      final ClassModelImpl classModel = new ClassModelImpl();
      return classModel;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public Method createMethod() {
      final MethodImpl method = new MethodImpl();
      return method;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public ArchitecturePackage getArchitecturePackage() {
      return (ArchitecturePackage) getEPackage();
   }

} // ArchitectureFactoryImpl
