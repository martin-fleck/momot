/**
 */
package icmt.tool.momot.demo.architecture.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link icmt.tool.momot.demo.architecture.impl.FeatureImpl#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FeatureImpl extends NamedElementImpl implements Feature {
   /**
    * The cached value of the '{@link #getIsEncapsulatedBy() <em>Is Encapsulated By</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #getIsEncapsulatedBy()
    * @generated
    * @ordered
    */
   protected icmt.tool.momot.demo.architecture.Class isEncapsulatedBy;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected FeatureImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public icmt.tool.momot.demo.architecture.Class basicGetIsEncapsulatedBy() {
      return isEncapsulatedBy;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public NotificationChain basicSetIsEncapsulatedBy(final icmt.tool.momot.demo.architecture.Class newIsEncapsulatedBy,
         NotificationChain msgs) {
      final icmt.tool.momot.demo.architecture.Class oldIsEncapsulatedBy = isEncapsulatedBy;
      isEncapsulatedBy = newIsEncapsulatedBy;
      if(eNotificationRequired()) {
         final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
               ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, newIsEncapsulatedBy);
         if(msgs == null) {
            msgs = notification;
         } else {
            msgs.add(notification);
         }
      }
      return msgs;
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
         case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
            if(resolve) {
               return getIsEncapsulatedBy();
            }
            return basicGetIsEncapsulatedBy();
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
   public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
      switch(featureID) {
         case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
            if(isEncapsulatedBy != null) {
               msgs = ((InternalEObject) isEncapsulatedBy).eInverseRemove(this, ArchitecturePackage.CLASS__ENCAPSULATES,
                     icmt.tool.momot.demo.architecture.Class.class, msgs);
            }
            return basicSetIsEncapsulatedBy((icmt.tool.momot.demo.architecture.Class) otherEnd, msgs);
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
         case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
            return basicSetIsEncapsulatedBy(null, msgs);
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
         case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
            return isEncapsulatedBy != null;
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public void eSet(final int featureID, final Object newValue) {
      switch(featureID) {
         case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
            setIsEncapsulatedBy((icmt.tool.momot.demo.architecture.Class) newValue);
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
      return ArchitecturePackage.Literals.FEATURE;
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
         case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
            setIsEncapsulatedBy((icmt.tool.momot.demo.architecture.Class) null);
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
   public icmt.tool.momot.demo.architecture.Class getIsEncapsulatedBy() {
      if(isEncapsulatedBy != null && isEncapsulatedBy.eIsProxy()) {
         final InternalEObject oldIsEncapsulatedBy = (InternalEObject) isEncapsulatedBy;
         isEncapsulatedBy = (icmt.tool.momot.demo.architecture.Class) eResolveProxy(oldIsEncapsulatedBy);
         if(isEncapsulatedBy != oldIsEncapsulatedBy) {
            if(eNotificationRequired()) {
               eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                     ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, isEncapsulatedBy));
            }
         }
      }
      return isEncapsulatedBy;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public void setIsEncapsulatedBy(final icmt.tool.momot.demo.architecture.Class newIsEncapsulatedBy) {
      if(newIsEncapsulatedBy != isEncapsulatedBy) {
         NotificationChain msgs = null;
         if(isEncapsulatedBy != null) {
            msgs = ((InternalEObject) isEncapsulatedBy).eInverseRemove(this, ArchitecturePackage.CLASS__ENCAPSULATES,
                  icmt.tool.momot.demo.architecture.Class.class, msgs);
         }
         if(newIsEncapsulatedBy != null) {
            msgs = ((InternalEObject) newIsEncapsulatedBy).eInverseAdd(this, ArchitecturePackage.CLASS__ENCAPSULATES,
                  icmt.tool.momot.demo.architecture.Class.class, msgs);
         }
         msgs = basicSetIsEncapsulatedBy(newIsEncapsulatedBy, msgs);
         if(msgs != null) {
            msgs.dispatch();
         }
      } else if(eNotificationRequired()) {
         eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY,
               newIsEncapsulatedBy, newIsEncapsulatedBy));
      }
   }

} // FeatureImpl
