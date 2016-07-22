/**
 */
package icmt.tool.momot.demo.architecture.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.ClassModel;
import icmt.tool.momot.demo.architecture.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link icmt.tool.momot.demo.architecture.impl.ClassModelImpl#getClasses <em>Classes</em>}</li>
 * <li>{@link icmt.tool.momot.demo.architecture.impl.ClassModelImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassModelImpl extends NamedElementImpl implements ClassModel {
   /**
    * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #getClasses()
    * @generated
    * @ordered
    */
   protected EList<icmt.tool.momot.demo.architecture.Class> classes;

   /**
    * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #getFeatures()
    * @generated
    * @ordered
    */
   protected EList<Feature> features;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected ClassModelImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
      switch(featureID) {
         case ArchitecturePackage.CLASS_MODEL__CLASSES:
            return getClasses();
         case ArchitecturePackage.CLASS_MODEL__FEATURES:
            return getFeatures();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
         final NotificationChain msgs) {
      switch(featureID) {
         case ArchitecturePackage.CLASS_MODEL__CLASSES:
            return ((InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
         case ArchitecturePackage.CLASS_MODEL__FEATURES:
            return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public boolean eIsSet(final int featureID) {
      switch(featureID) {
         case ArchitecturePackage.CLASS_MODEL__CLASSES:
            return classes != null && !classes.isEmpty();
         case ArchitecturePackage.CLASS_MODEL__FEATURES:
            return features != null && !features.isEmpty();
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(final int featureID, final Object newValue) {
      switch(featureID) {
         case ArchitecturePackage.CLASS_MODEL__CLASSES:
            getClasses().clear();
            getClasses().addAll((Collection<? extends icmt.tool.momot.demo.architecture.Class>) newValue);
            return;
         case ArchitecturePackage.CLASS_MODEL__FEATURES:
            getFeatures().clear();
            getFeatures().addAll((Collection<? extends Feature>) newValue);
            return;
      }
      super.eSet(featureID, newValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return ArchitecturePackage.Literals.CLASS_MODEL;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public void eUnset(final int featureID) {
      switch(featureID) {
         case ArchitecturePackage.CLASS_MODEL__CLASSES:
            getClasses().clear();
            return;
         case ArchitecturePackage.CLASS_MODEL__FEATURES:
            getFeatures().clear();
            return;
      }
      super.eUnset(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EList<icmt.tool.momot.demo.architecture.Class> getClasses() {
      if(classes == null) {
         classes = new EObjectContainmentEList<>(icmt.tool.momot.demo.architecture.Class.class, this,
               ArchitecturePackage.CLASS_MODEL__CLASSES);
      }
      return classes;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public EList<Feature> getFeatures() {
      if(features == null) {
         features = new EObjectContainmentEList<>(Feature.class, this, ArchitecturePackage.CLASS_MODEL__FEATURES);
      }
      return features;
   }

} // ClassModelImpl
