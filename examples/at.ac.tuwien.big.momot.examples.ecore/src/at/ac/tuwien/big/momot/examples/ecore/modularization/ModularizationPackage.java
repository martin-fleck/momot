/**
 */
package at.ac.tuwien.big.momot.examples.ecore.modularization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationFactory
 * @model kind="package"
 * @generated
 */
public interface ModularizationPackage extends EPackage {
   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    * <li>each class,</li>
    * <li>each feature of each class,</li>
    * <li>each operation of each class,</li>
    * <li>each enum,</li>
    * <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    *
    * @generated
    */
   interface Literals {
      /**
       * The meta object literal for the
       * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.NamedElementImpl <em>Named Element</em>}'
       * class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.NamedElementImpl
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getNamedElement()
       * @generated
       */
      EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

      /**
       * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @generated
       */
      EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

      /**
       * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.LanguageImpl
       * <em>Language</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.LanguageImpl
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getLanguage()
       * @generated
       */
      EClass LANGUAGE = eINSTANCE.getLanguage();

      /**
       * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @generated
       */
      EReference LANGUAGE__MODULES = eINSTANCE.getLanguage_Modules();

      /**
       * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModuleImpl
       * <em>Module</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModuleImpl
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getModule()
       * @generated
       */
      EClass MODULE = eINSTANCE.getModule();

      /**
       * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @generated
       */
      EReference MODULE__ENTITIES = eINSTANCE.getModule_Entities();

      /**
       * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.EntityImpl
       * <em>Entity</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.EntityImpl
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getEntity()
       * @generated
       */
      EClass ENTITY = eINSTANCE.getEntity();

      /**
       * The meta object literal for the '<em><b>Relationships</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @generated
       */
      EReference ENTITY__RELATIONSHIPS = eINSTANCE.getEntity_Relationships();

      /**
       * The meta object literal for the
       * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.RelationshipImpl <em>Relationship</em>}'
       * class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.RelationshipImpl
       * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getRelationship()
       * @generated
       */
      EClass RELATIONSHIP = eINSTANCE.getRelationship();

      /**
       * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @generated
       */
      EAttribute RELATIONSHIP__WEIGHT = eINSTANCE.getRelationship_Weight();

      /**
       * The meta object literal for the '<em><b>Relationship End</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       *
       * @generated
       */
      EReference RELATIONSHIP__RELATIONSHIP_END = eINSTANCE.getRelationship_RelationshipEnd();

   }

   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   String eNAME = "modularization";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   String eNS_URI = "http://big.tuwien.ac.at/momo/modularization";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   String eNS_PREFIX = "Modularization";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   ModularizationPackage eINSTANCE = at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl
         .init();

   /**
    * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.NamedElementImpl
    * <em>Named Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.NamedElementImpl
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getNamedElement()
    * @generated
    */
   int NAMED_ELEMENT = 0;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int NAMED_ELEMENT__NAME = 0;

   /**
    * The number of structural features of the '<em>Named Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int NAMED_ELEMENT_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>Named Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int NAMED_ELEMENT_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.LanguageImpl
    * <em>Language</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.LanguageImpl
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getLanguage()
    * @generated
    */
   int LANGUAGE = 1;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int LANGUAGE__NAME = NAMED_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Modules</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int LANGUAGE__MODULES = NAMED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Language</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int LANGUAGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>Language</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int LANGUAGE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModuleImpl
    * <em>Module</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModuleImpl
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getModule()
    * @generated
    */
   int MODULE = 2;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int MODULE__NAME = NAMED_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Entities</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int MODULE__ENTITIES = NAMED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Module</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int MODULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>Module</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int MODULE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.EntityImpl
    * <em>Entity</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.EntityImpl
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getEntity()
    * @generated
    */
   int ENTITY = 3;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int ENTITY__NAME = NAMED_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Relationships</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int ENTITY__RELATIONSHIPS = NAMED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Entity</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int ENTITY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>Entity</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int ENTITY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.RelationshipImpl
    * <em>Relationship</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.RelationshipImpl
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.impl.ModularizationPackageImpl#getRelationship()
    * @generated
    */
   int RELATIONSHIP = 4;

   /**
    * The feature id for the '<em><b>Weight</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int RELATIONSHIP__WEIGHT = 0;

   /**
    * The feature id for the '<em><b>Relationship End</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int RELATIONSHIP__RELATIONSHIP_END = 1;

   /**
    * The number of structural features of the '<em>Relationship</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int RELATIONSHIP_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>Relationship</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    * @ordered
    */
   int RELATIONSHIP_OPERATION_COUNT = 0;

   /**
    * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Entity
    * <em>Entity</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for class '<em>Entity</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Entity
    * @generated
    */
   EClass getEntity();

   /**
    * Returns the meta object for the containment reference list
    * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Entity#getRelationships <em>Relationships</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for the containment reference list '<em>Relationships</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Entity#getRelationships()
    * @see #getEntity()
    * @generated
    */
   EReference getEntity_Relationships();

   /**
    * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Language
    * <em>Language</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for class '<em>Language</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Language
    * @generated
    */
   EClass getLanguage();

   /**
    * Returns the meta object for the containment reference list
    * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Language#getModules <em>Modules</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for the containment reference list '<em>Modules</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Language#getModules()
    * @see #getLanguage()
    * @generated
    */
   EReference getLanguage_Modules();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the factory that creates the instances of the model.
    * @generated
    */
   ModularizationFactory getModularizationFactory();

   /**
    * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Module
    * <em>Module</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for class '<em>Module</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Module
    * @generated
    */
   EClass getModule();

   /**
    * Returns the meta object for the containment reference list
    * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Module#getEntities <em>Entities</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for the containment reference list '<em>Entities</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Module#getEntities()
    * @see #getModule()
    * @generated
    */
   EReference getModule_Entities();

   /**
    * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.NamedElement
    * <em>Named Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for class '<em>Named Element</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.NamedElement
    * @generated
    */
   EClass getNamedElement();

   /**
    * Returns the meta object for the attribute
    * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.NamedElement#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.NamedElement#getName()
    * @see #getNamedElement()
    * @generated
    */
   EAttribute getNamedElement_Name();

   /**
    * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship
    * <em>Relationship</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for class '<em>Relationship</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship
    * @generated
    */
   EClass getRelationship();

   /**
    * Returns the meta object for the reference
    * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getRelationshipEnd <em>Relationship
    * End</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for the reference '<em>Relationship End</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getRelationshipEnd()
    * @see #getRelationship()
    * @generated
    */
   EReference getRelationship_RelationshipEnd();

   /**
    * Returns the meta object for the attribute
    * '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getWeight <em>Weight</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the meta object for the attribute '<em>Weight</em>'.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getWeight()
    * @see #getRelationship()
    * @generated
    */
   EAttribute getRelationship_Weight();

} // ModularizationPackage
