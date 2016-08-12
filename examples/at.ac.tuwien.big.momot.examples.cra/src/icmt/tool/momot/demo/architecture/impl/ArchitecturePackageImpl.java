/**
 */
package icmt.tool.momot.demo.architecture.impl;

import static icmt.tool.momot.demo.architecture.ArchitecturePackage.CLASS;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import icmt.tool.momot.demo.architecture.ArchitectureFactory;
import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.Attribute;
import icmt.tool.momot.demo.architecture.ClassModel;
import icmt.tool.momot.demo.architecture.Feature;
import icmt.tool.momot.demo.architecture.Method;
import icmt.tool.momot.demo.architecture.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ArchitecturePackageImpl extends EPackageImpl implements ArchitecturePackage {
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
    * This method is used to initialize {@link ArchitecturePackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static ArchitecturePackage init() {
      if(isInited) {
         return (ArchitecturePackage) EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);
      }

      // Obtain or create and register package
      final ArchitecturePackageImpl theArchitecturePackage = (ArchitecturePackageImpl) (EPackage.Registry.INSTANCE
            .get(eNS_URI) instanceof ArchitecturePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                  : new ArchitecturePackageImpl());

      isInited = true;

      // Create package meta-data objects
      theArchitecturePackage.createPackageContents();

      // Initialize created meta-data
      theArchitecturePackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theArchitecturePackage.freeze();

      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(ArchitecturePackage.eNS_URI, theArchitecturePackage);
      return theArchitecturePackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass classModelEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass classEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass attributeEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass methodEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   private EClass featureEClass = null;

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
    * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#eNS_URI
    * @see #init()
    * @generated
    */
   private ArchitecturePackageImpl() {
      super(eNS_URI, ArchitectureFactory.eINSTANCE);
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
      classModelEClass = createEClass(CLASS_MODEL);
      createEReference(classModelEClass, CLASS_MODEL__CLASSES);
      createEReference(classModelEClass, CLASS_MODEL__FEATURES);

      classEClass = createEClass(CLASS);
      createEReference(classEClass, CLASS__ENCAPSULATES);

      attributeEClass = createEClass(ATTRIBUTE);

      methodEClass = createEClass(METHOD);
      createEReference(methodEClass, METHOD__DATA_DEPENDENCY);
      createEReference(methodEClass, METHOD__FUNCTIONAL_DEPENDENCY);

      featureEClass = createEClass(FEATURE);
      createEReference(featureEClass, FEATURE__IS_ENCAPSULATED_BY);

      namedElementEClass = createEClass(NAMED_ELEMENT);
      createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public ArchitectureFactory getArchitectureFactory() {
      return (ArchitectureFactory) getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getAttribute() {
      return attributeEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getClass_() {
      return classEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getClass_Encapsulates() {
      return (EReference) classEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getClassModel() {
      return classModelEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getClassModel_Classes() {
      return (EReference) classModelEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getClassModel_Features() {
      return (EReference) classModelEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getFeature() {
      return featureEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getFeature_IsEncapsulatedBy() {
      return (EReference) featureEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EClass getMethod() {
      return methodEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getMethod_DataDependency() {
      return (EReference) methodEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EReference getMethod_FunctionalDependency() {
      return (EReference) methodEClass.getEStructuralFeatures().get(1);
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
      classModelEClass.getESuperTypes().add(this.getNamedElement());
      classEClass.getESuperTypes().add(this.getNamedElement());
      attributeEClass.getESuperTypes().add(this.getFeature());
      methodEClass.getESuperTypes().add(this.getFeature());
      featureEClass.getESuperTypes().add(this.getNamedElement());

      // Initialize classes, features, and operations; add parameters
      initEClass(classModelEClass, ClassModel.class, "ClassModel", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEReference(getClassModel_Classes(), this.getClass_(), null, "classes", null, 0, -1, ClassModel.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, !IS_ORDERED);
      initEReference(getClassModel_Features(), this.getFeature(), null, "features", null, 0, -1, ClassModel.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, !IS_ORDERED);

      initEClass(classEClass, icmt.tool.momot.demo.architecture.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEReference(getClass_Encapsulates(), this.getFeature(), this.getFeature_IsEncapsulatedBy(), "encapsulates",
            null, 1, -1, icmt.tool.momot.demo.architecture.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
            !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);

      initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getMethod_DataDependency(), this.getAttribute(), null, "dataDependency", null, 0, -1, Method.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);
      initEReference(getMethod_FunctionalDependency(), this.getMethod(), null, "functionalDependency", null, 0, -1,
            Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(featureEClass, Feature.class, "Feature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getFeature_IsEncapsulatedBy(), this.getClass_(), this.getClass_Encapsulates(), "isEncapsulatedBy",
            null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
            !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} // ArchitecturePackageImpl
