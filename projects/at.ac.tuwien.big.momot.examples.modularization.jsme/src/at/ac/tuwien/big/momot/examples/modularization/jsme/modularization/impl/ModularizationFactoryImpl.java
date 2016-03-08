/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationFactory;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModularizationFactoryImpl extends EFactoryImpl implements ModularizationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModularizationFactory init() {
		try {
			ModularizationFactory theModularizationFactory = (ModularizationFactory)EPackage.Registry.INSTANCE.getEFactory(ModularizationPackage.eNS_URI);
			if (theModularizationFactory != null) {
				return theModularizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModularizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModularizationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModularizationPackage.NAMED_ELEMENT: return createNamedElement();
			case ModularizationPackage.MODULARIZATION_MODEL: return createModularizationModel();
			case ModularizationPackage.MODULE: return createModule();
			case ModularizationPackage.CLASS: return createClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModularizationModel createModularizationModel() {
		ModularizationModelImpl modularizationModel = new ModularizationModelImpl();
		return modularizationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModularizationPackage getModularizationPackage() {
		return (ModularizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModularizationPackage getPackage() {
		return ModularizationPackage.eINSTANCE;
	}

} //ModularizationFactoryImpl
