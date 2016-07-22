/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.NamedElement;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringFactory;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class RefactoringFactoryImpl extends EFactoryImpl implements RefactoringFactory {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @deprecated
    * @generated
    */
   @Deprecated
   public static RefactoringPackage getPackage() {
      return RefactoringPackage.eINSTANCE;
   }

   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public static RefactoringFactory init() {
      try {
         final RefactoringFactory theRefactoringFactory = (RefactoringFactory) EPackage.Registry.INSTANCE
               .getEFactory(RefactoringPackage.eNS_URI);
         if(theRefactoringFactory != null) {
            return theRefactoringFactory;
         }
      } catch(final Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new RefactoringFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public RefactoringFactoryImpl() {
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
         case RefactoringPackage.PROPERTY:
            return createProperty();
         case RefactoringPackage.ENTITY:
            return createEntity();
         case RefactoringPackage.GENERALIZATION:
            return createGeneralization();
         case RefactoringPackage.NAMED_ELEMENT:
            return createNamedElement();
         case RefactoringPackage.TYPE:
            return createType();
         case RefactoringPackage.REFACTORING_MODEL:
            return createRefactoringModel();
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
   public Entity createEntity() {
      final EntityImpl entity = new EntityImpl();
      return entity;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public Generalization createGeneralization() {
      final GeneralizationImpl generalization = new GeneralizationImpl();
      return generalization;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public NamedElement createNamedElement() {
      final NamedElementImpl namedElement = new NamedElementImpl();
      return namedElement;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public Property createProperty() {
      final PropertyImpl property = new PropertyImpl();
      return property;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public RefactoringModel createRefactoringModel() {
      final RefactoringModelImpl refactoringModel = new RefactoringModelImpl();
      return refactoringModel;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public Type createType() {
      final TypeImpl type = new TypeImpl();
      return type;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public RefactoringPackage getRefactoringPackage() {
      return (RefactoringPackage) getEPackage();
   }

} // RefactoringFactoryImpl
