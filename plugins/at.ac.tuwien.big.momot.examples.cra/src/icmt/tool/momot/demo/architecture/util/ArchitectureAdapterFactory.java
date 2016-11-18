/**
 */
package icmt.tool.momot.demo.architecture.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.Attribute;
import icmt.tool.momot.demo.architecture.ClassModel;
import icmt.tool.momot.demo.architecture.Feature;
import icmt.tool.momot.demo.architecture.Method;
import icmt.tool.momot.demo.architecture.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see icmt.tool.momot.demo.architecture.ArchitecturePackage
 * @generated
 */
public class ArchitectureAdapterFactory extends AdapterFactoryImpl {
   /**
    * The cached model package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected static ArchitecturePackage modelPackage;

   /**
    * The switch that delegates to the <code>createXXX</code> methods.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected ArchitectureSwitch<Adapter> modelSwitch = new ArchitectureSwitch<Adapter>() {
      @Override
      public Adapter caseAttribute(final Attribute object) {
         return createAttributeAdapter();
      }

      @Override
      public Adapter caseClass(final icmt.tool.momot.demo.architecture.Class object) {
         return createClassAdapter();
      }

      @Override
      public Adapter caseClassModel(final ClassModel object) {
         return createClassModelAdapter();
      }

      @Override
      public Adapter caseFeature(final Feature object) {
         return createFeatureAdapter();
      }

      @Override
      public Adapter caseMethod(final Method object) {
         return createMethodAdapter();
      }

      @Override
      public Adapter caseNamedElement(final NamedElement object) {
         return createNamedElementAdapter();
      }

      @Override
      public Adapter defaultCase(final EObject object) {
         return createEObjectAdapter();
      }
   };

   /**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public ArchitectureAdapterFactory() {
      if(modelPackage == null) {
         modelPackage = ArchitecturePackage.eINSTANCE;
      }
   }

   /**
    * Creates an adapter for the <code>target</code>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @param target
    *           the object to adapt.
    * @return the adapter for the <code>target</code>.
    * @generated
    */
   @Override
   public Adapter createAdapter(final Notifier target) {
      return modelSwitch.doSwitch((EObject) target);
   }

   /**
    * Creates a new adapter for an object of class '{@link icmt.tool.momot.demo.architecture.Attribute
    * <em>Attribute</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    *
    * @return the new adapter.
    * @see icmt.tool.momot.demo.architecture.Attribute
    * @generated
    */
   public Adapter createAttributeAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link icmt.tool.momot.demo.architecture.Class <em>Class</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    *
    * @return the new adapter.
    * @see icmt.tool.momot.demo.architecture.Class
    * @generated
    */
   public Adapter createClassAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link icmt.tool.momot.demo.architecture.ClassModel <em>Class
    * Model</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    *
    * @return the new adapter.
    * @see icmt.tool.momot.demo.architecture.ClassModel
    * @generated
    */
   public Adapter createClassModelAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for the default case.
    * <!-- begin-user-doc -->
    * This default implementation returns null.
    * <!-- end-user-doc -->
    *
    * @return the new adapter.
    * @generated
    */
   public Adapter createEObjectAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link icmt.tool.momot.demo.architecture.Feature <em>Feature</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    *
    * @return the new adapter.
    * @see icmt.tool.momot.demo.architecture.Feature
    * @generated
    */
   public Adapter createFeatureAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link icmt.tool.momot.demo.architecture.Method <em>Method</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    *
    * @return the new adapter.
    * @see icmt.tool.momot.demo.architecture.Method
    * @generated
    */
   public Adapter createMethodAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link icmt.tool.momot.demo.architecture.NamedElement <em>Named
    * Element</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    *
    * @return the new adapter.
    * @see icmt.tool.momot.demo.architecture.NamedElement
    * @generated
    */
   public Adapter createNamedElementAdapter() {
      return null;
   }

   /**
    * Returns whether this factory is applicable for the type of the object.
    * <!-- begin-user-doc -->
    * This implementation returns <code>true</code> if the object is either the model's package or is an instance object
    * of the model.
    * <!-- end-user-doc -->
    *
    * @return whether this factory is applicable for the type of the object.
    * @generated
    */
   @Override
   public boolean isFactoryForType(final Object object) {
      if(object == modelPackage) {
         return true;
      }
      if(object instanceof EObject) {
         return ((EObject) object).eClass().getEPackage() == modelPackage;
      }
      return false;
   }

} // ArchitectureAdapterFactory
