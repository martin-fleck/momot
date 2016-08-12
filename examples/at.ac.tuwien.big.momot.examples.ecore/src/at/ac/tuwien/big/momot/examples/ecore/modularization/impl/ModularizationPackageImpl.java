/**
 */
package at.ac.tuwien.big.momot.examples.ecore.modularization.impl;

import at.ac.tuwien.big.momot.examples.ecore.modularization.Entity;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationFactory;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;
import at.ac.tuwien.big.momot.examples.ecore.modularization.NamedElement;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ModularizationPackageImpl extends EPackageImpl implements ModularizationPackage {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private static boolean isInited = false;

   /**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    *
    * <p>
    * This method is used to initialize {@link ModularizationPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static ModularizationPackage init() {
      if(isInited) {
         return (ModularizationPackage) EPackage.Registry.INSTANCE.getEPackage(ModularizationPackage.eNS_URI);
      }

      // Obtain or create and register package
      final ModularizationPackageImpl theModularizationPackage = (ModularizationPackageImpl) (EPackage.Registry.INSTANCE
            .get(eNS_URI) instanceof ModularizationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                  : new ModularizationPackageImpl());

      isInited = true;

      // Create package meta-data objects
      theModularizationPackage.createPackageContents();

      // Initialize created meta-data
      theModularizationPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theModularizationPackage.freeze();

      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(ModularizationPackage.eNS_URI, theModularizationPackage);
      return theModularizationPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass namedElementEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass languageEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass moduleEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass entityEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass relationshipEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private boolean isCreated = false;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private boolean isInitialized = false;

   /**
    * Creates an instance of the model <b>Package</b>, registered with
    * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
    * package URI value.
    * <p>
    * Note: the correct way to create the package is via the static
    * factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package,
    * if one already exists.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private ModularizationPackageImpl() {
      super(eNS_URI, ModularizationFactory.eINSTANCE);
   }

   /**
    * Creates the meta-model objects for the package. This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public void createPackageContents() {
      if(isCreated) {
         return;
      }
      isCreated = true;

      // Create classes and their features
      namedElementEClass = createEClass(NAMED_ELEMENT);
      createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

      languageEClass = createEClass(LANGUAGE);
      createEReference(languageEClass, LANGUAGE__MODULES);

      moduleEClass = createEClass(MODULE);
      createEReference(moduleEClass, MODULE__ENTITIES);

      entityEClass = createEClass(ENTITY);
      createEReference(entityEClass, ENTITY__RELATIONSHIPS);

      relationshipEClass = createEClass(RELATIONSHIP);
      createEAttribute(relationshipEClass, RELATIONSHIP__WEIGHT);
      createEReference(relationshipEClass, RELATIONSHIP__RELATIONSHIP_END);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getEntity() {
      return entityEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getEntity_Relationships() {
      return (EReference) entityEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getLanguage() {
      return languageEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getLanguage_Modules() {
      return (EReference) languageEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public ModularizationFactory getModularizationFactory() {
      return (ModularizationFactory) getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getModule() {
      return moduleEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getModule_Entities() {
      return (EReference) moduleEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getNamedElement() {
      return namedElementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EAttribute getNamedElement_Name() {
      return (EAttribute) namedElementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getRelationship() {
      return relationshipEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getRelationship_RelationshipEnd() {
      return (EReference) relationshipEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EAttribute getRelationship_Weight() {
      return (EAttribute) relationshipEClass.getEStructuralFeatures().get(0);
   }

   /**
    * Complete the initialization of the package and its meta-model. This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public void initializePackageContents() {
      if(isInitialized) {
         return;
      }
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes
      languageEClass.getESuperTypes().add(this.getNamedElement());
      moduleEClass.getESuperTypes().add(this.getNamedElement());
      entityEClass.getESuperTypes().add(this.getNamedElement());

      // Initialize classes, features, and operations; add parameters
      initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(languageEClass, Language.class, "Language", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getLanguage_Modules(), this.getModule(), null, "modules", null, 0, -1, Language.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);

      initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getModule_Entities(), this.getEntity(), null, "entities", null, 0, -1, Module.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
            IS_ORDERED);

      initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getEntity_Relationships(), this.getRelationship(), null, "relationships", null, 0, -1,
            Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getRelationship_Weight(), ecorePackage.getEInt(), "weight", null, 1, 1, Relationship.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRelationship_RelationshipEnd(), this.getEntity(), null, "relationshipEnd", null, 1, 1,
            Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
            !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} // ModularizationPackageImpl
