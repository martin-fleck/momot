/**
 */
package icmt.tool.momot.demo.architecture.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link icmt.tool.momot.demo.architecture.impl.ClassImpl#getEncapsulates <em>Encapsulates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements icmt.tool.momot.demo.architecture.Class {
   /**
    * The cached value of the '{@link #getEncapsulates() <em>Encapsulates</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #getEncapsulates()
    * @generated
    * @ordered
    */
   protected EList<Feature> encapsulates;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected ClassImpl() {
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
         case ArchitecturePackage.CLASS__ENCAPSULATES:
            return getEncapsulates();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
         final NotificationChain msgs) {
      switch(featureID) {
         case ArchitecturePackage.CLASS__ENCAPSULATES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getEncapsulates()).basicAdd(otherEnd, msgs);
      }
      return super.eInverseAdd(otherEnd, featureID, msgs);
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
         case ArchitecturePackage.CLASS__ENCAPSULATES:
            return ((InternalEList<?>) getEncapsulates()).basicRemove(otherEnd, msgs);
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
         case ArchitecturePackage.CLASS__ENCAPSULATES:
            return encapsulates != null && !encapsulates.isEmpty();
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
         case ArchitecturePackage.CLASS__ENCAPSULATES:
            getEncapsulates().clear();
            getEncapsulates().addAll((Collection<? extends Feature>) newValue);
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
      return ArchitecturePackage.Literals.CLASS;
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
         case ArchitecturePackage.CLASS__ENCAPSULATES:
            getEncapsulates().clear();
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
   public EList<Feature> getEncapsulates() {
      if(encapsulates == null) {
         encapsulates = new EObjectWithInverseResolvingEList<>(Feature.class, this,
               ArchitecturePackage.CLASS__ENCAPSULATES, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY);
      }
      return encapsulates;
   }

} // ClassImpl
