/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringFactory
 * @model kind="package"
 * @generated
 */
public interface RefactoringPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "refactoring";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://momot.big.tuwien.ac.at/examples/refactoring/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "refactoring";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RefactoringPackage eINSTANCE = at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.NamedElementImpl
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.PropertyImpl
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.EntityImpl
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_ATTRIBUTE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specialization</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__SPECIALIZATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__GENERALIZATION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.GeneralizationImpl <em>Generalization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.GeneralizationImpl
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getGeneralization()
	 * @generated
	 */
	int GENERALIZATION = 2;

	/**
	 * The feature id for the '<em><b>Specific</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION__SPECIFIC = 0;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION__GENERAL = 1;

	/**
	 * The number of structural features of the '<em>Generalization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Generalization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.TypeImpl
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getRefactoringModel()
	 * @generated
	 */
	int REFACTORING_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Propertys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_MODEL__PROPERTYS = 0;

	/**
	 * The feature id for the '<em><b>Entitys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_MODEL__ENTITYS = 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_MODEL__TYPES = 2;

	/**
	 * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_MODEL__GENERALIZATIONS = 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_MODEL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Type();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getOwnedAttribute <em>Owned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Attribute</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getOwnedAttribute()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_OwnedAttribute();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getSpecialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specialization</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getSpecialization()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Specialization();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getGeneralization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generalization</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity#getGeneralization()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Generalization();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generalization</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization
	 * @generated
	 */
	EClass getGeneralization();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getSpecific <em>Specific</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specific</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getSpecific()
	 * @see #getGeneralization()
	 * @generated
	 */
	EReference getGeneralization_Specific();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>General</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization#getGeneral()
	 * @see #getGeneralization()
	 * @generated
	 */
	EReference getGeneralization_General();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel
	 * @generated
	 */
	EClass getRefactoringModel();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getPropertys <em>Propertys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propertys</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getPropertys()
	 * @see #getRefactoringModel()
	 * @generated
	 */
	EReference getRefactoringModel_Propertys();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getEntitys <em>Entitys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entitys</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getEntitys()
	 * @see #getRefactoringModel()
	 * @generated
	 */
	EReference getRefactoringModel_Entitys();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getTypes()
	 * @see #getRefactoringModel()
	 * @generated
	 */
	EReference getRefactoringModel_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getGeneralizations <em>Generalizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generalizations</em>'.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getGeneralizations()
	 * @see #getRefactoringModel()
	 * @generated
	 */
	EReference getRefactoringModel_Generalizations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RefactoringFactory getRefactoringFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.PropertyImpl
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.EntityImpl
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Owned Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__OWNED_ATTRIBUTE = eINSTANCE.getEntity_OwnedAttribute();

		/**
		 * The meta object literal for the '<em><b>Specialization</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__SPECIALIZATION = eINSTANCE.getEntity_Specialization();

		/**
		 * The meta object literal for the '<em><b>Generalization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__GENERALIZATION = eINSTANCE.getEntity_Generalization();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.GeneralizationImpl <em>Generalization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.GeneralizationImpl
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getGeneralization()
		 * @generated
		 */
		EClass GENERALIZATION = eINSTANCE.getGeneralization();

		/**
		 * The meta object literal for the '<em><b>Specific</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION__SPECIFIC = eINSTANCE.getGeneralization_Specific();

		/**
		 * The meta object literal for the '<em><b>General</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION__GENERAL = eINSTANCE.getGeneralization_General();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.NamedElementImpl
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.TypeImpl
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl
		 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringPackageImpl#getRefactoringModel()
		 * @generated
		 */
		EClass REFACTORING_MODEL = eINSTANCE.getRefactoringModel();

		/**
		 * The meta object literal for the '<em><b>Propertys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFACTORING_MODEL__PROPERTYS = eINSTANCE.getRefactoringModel_Propertys();

		/**
		 * The meta object literal for the '<em><b>Entitys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFACTORING_MODEL__ENTITYS = eINSTANCE.getRefactoringModel_Entitys();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFACTORING_MODEL__TYPES = eINSTANCE.getRefactoringModel_Types();

		/**
		 * The meta object literal for the '<em><b>Generalizations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFACTORING_MODEL__GENERALIZATIONS = eINSTANCE.getRefactoringModel_Generalizations();

	}

} //RefactoringPackage
