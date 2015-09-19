/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.architecture;

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
 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://momot.big.tuwien.ac.at/modularization/sw/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturePackage eINSTANCE = at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.NamedElementImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getNamedElement()
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
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.SoftwareModelImpl <em>Software Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.SoftwareModelImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getSoftwareModel()
	 * @generated
	 */
	int SOFTWARE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_MODEL__CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_MODEL__FEATURES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Software Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Software Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_MODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ClassImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__FEATURES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.FeatureImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONTAINER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.AttributeImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__CONTAINER = FEATURE__CONTAINER;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.MethodImpl
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CONTAINER = FEATURE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Data Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DATA_DEPENDENCY = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Functional Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__FUNCTIONAL_DEPENDENCY = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel <em>Software Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Model</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel
	 * @generated
	 */
	EClass getSoftwareModel();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel#getClasses()
	 * @see #getSoftwareModel()
	 * @generated
	 */
	EReference getSoftwareModel_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel#getFeatures()
	 * @see #getSoftwareModel()
	 * @generated
	 */
	EReference getSoftwareModel_Features();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class#getFeatures()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Features();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature#getContainer()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Container();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Method#getDataDependency <em>Data Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Dependency</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Method#getDataDependency()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_DataDependency();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Method#getFunctionalDependency <em>Functional Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Functional Dependency</em>'.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Method#getFunctionalDependency()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_FunctionalDependency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitectureFactory getArchitectureFactory();

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
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.NamedElementImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.SoftwareModelImpl <em>Software Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.SoftwareModelImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getSoftwareModel()
		 * @generated
		 */
		EClass SOFTWARE_MODEL = eINSTANCE.getSoftwareModel();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_MODEL__CLASSES = eINSTANCE.getSoftwareModel_Classes();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_MODEL__FEATURES = eINSTANCE.getSoftwareModel_Features();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ClassImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__FEATURES = eINSTANCE.getClass_Features();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.FeatureImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CONTAINER = eINSTANCE.getFeature_Container();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.AttributeImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.MethodImpl
		 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.impl.ArchitecturePackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Data Dependency</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__DATA_DEPENDENCY = eINSTANCE.getMethod_DataDependency();

		/**
		 * The meta object literal for the '<em><b>Functional Dependency</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__FUNCTIONAL_DEPENDENCY = eINSTANCE.getMethod_FunctionalDependency();

	}

} //ArchitecturePackage
