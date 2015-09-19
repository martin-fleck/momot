/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.modularization;

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
 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationFactory
 * @model kind="package"
 * @generated
 */
public interface ModularizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modularization";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://momot.big.tuwien.ac.at/modularization/jsep/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modularization";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModularizationPackage eINSTANCE = at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.NamedElementImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

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
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationModelImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getModularizationModel()
	 * @generated
	 */
	int MODULARIZATION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULARIZATION_MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULARIZATION_MODEL__MODULES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULARIZATION_MODEL__CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULARIZATION_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULARIZATION_MODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModuleImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ClassImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MODULE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DEPENDS_ON = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Depended On By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DEPENDED_ON_BY = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel
	 * @generated
	 */
	EClass getModularizationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel#getModules()
	 * @see #getModularizationModel()
	 * @generated
	 */
	EReference getModularizationModel_Modules();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationModel#getClasses()
	 * @see #getModularizationModel()
	 * @generated
	 */
	EReference getModularizationModel_Classes();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Module#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Classes</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Module#getClasses()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Classes();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Module</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getModule()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Module();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependsOn()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DependsOn();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependedOnBy <em>Depended On By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depended On By</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependedOnBy()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DependedOnBy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModularizationFactory getModularizationFactory();

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
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.NamedElementImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationModelImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getModularizationModel()
		 * @generated
		 */
		EClass MODULARIZATION_MODEL = eINSTANCE.getModularizationModel();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULARIZATION_MODEL__MODULES = eINSTANCE.getModularizationModel_Modules();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULARIZATION_MODEL__CLASSES = eINSTANCE.getModularizationModel_Classes();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModuleImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__CLASSES = eINSTANCE.getModule_Classes();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ClassImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.impl.ModularizationPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__MODULE = eINSTANCE.getClass_Module();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__DEPENDS_ON = eINSTANCE.getClass_DependsOn();

		/**
		 * The meta object literal for the '<em><b>Depended On By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__DEPENDED_ON_BY = eINSTANCE.getClass_DependedOnBy();

	}

} //ModularizationPackage
