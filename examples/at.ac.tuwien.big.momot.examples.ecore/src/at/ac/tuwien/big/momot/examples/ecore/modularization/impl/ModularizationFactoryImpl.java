/**
 */
package at.ac.tuwien.big.momot.examples.ecore.modularization.impl;

import at.ac.tuwien.big.momot.examples.ecore.modularization.Entity;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationFactory;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship;

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
public class ModularizationFactoryImpl extends EFactoryImpl implements ModularizationFactory {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @deprecated
    * @generated
    */
   @Deprecated
   public static ModularizationPackage getPackage() {
      return ModularizationPackage.eINSTANCE;
   }

   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public static ModularizationFactory init() {
      try {
         final ModularizationFactory theModularizationFactory = (ModularizationFactory) EPackage.Registry.INSTANCE
               .getEFactory(ModularizationPackage.eNS_URI);
         if(theModularizationFactory != null) {
            return theModularizationFactory;
         }
      } catch(final Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new ModularizationFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public ModularizationFactoryImpl() {
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
         case ModularizationPackage.LANGUAGE:
            return createLanguage();
         case ModularizationPackage.MODULE:
            return createModule();
         case ModularizationPackage.ENTITY:
            return createEntity();
         case ModularizationPackage.RELATIONSHIP:
            return createRelationship();
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
   public Language createLanguage() {
      final LanguageImpl language = new LanguageImpl();
      return language;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public Module createModule() {
      final ModuleImpl module = new ModuleImpl();
      return module;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public Relationship createRelationship() {
      final RelationshipImpl relationship = new RelationshipImpl();
      return relationship;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public ModularizationPackage getModularizationPackage() {
      return (ModularizationPackage) getEPackage();
   }

} // ModularizationFactoryImpl
