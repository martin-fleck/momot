/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.GeneralizationImpl#getSpecific
 * <em>Specific</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.GeneralizationImpl#getGeneral
 * <em>General</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeneralizationImpl extends MinimalEObjectImpl.Container implements Generalization {
   /**
    * The cached value of the '{@link #getSpecific() <em>Specific</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getSpecific()
    * @generated
    * @ordered
    */
   protected Entity specific;

   /**
    * The cached value of the '{@link #getGeneral() <em>General</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getGeneral()
    * @generated
    * @ordered
    */
   protected Entity general;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   protected GeneralizationImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public Entity basicGetGeneral() {
      return general;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public Entity basicGetSpecific() {
      return specific;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain basicSetGeneral(final Entity newGeneral, NotificationChain msgs) {
      final Entity oldGeneral = general;
      general = newGeneral;
      if(eNotificationRequired()) {
         final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
               RefactoringPackage.GENERALIZATION__GENERAL, oldGeneral, newGeneral);
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
   public NotificationChain basicSetSpecific(final Entity newSpecific, NotificationChain msgs) {
      final Entity oldSpecific = specific;
      specific = newSpecific;
      if(eNotificationRequired()) {
         final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
               RefactoringPackage.GENERALIZATION__SPECIFIC, oldSpecific, newSpecific);
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
         case RefactoringPackage.GENERALIZATION__SPECIFIC:
            if(resolve) {
               return getSpecific();
            }
            return basicGetSpecific();
         case RefactoringPackage.GENERALIZATION__GENERAL:
            if(resolve) {
               return getGeneral();
            }
            return basicGetGeneral();
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
         case RefactoringPackage.GENERALIZATION__SPECIFIC:
            if(specific != null) {
               msgs = ((InternalEObject) specific).eInverseRemove(this, RefactoringPackage.ENTITY__GENERALIZATION,
                     Entity.class, msgs);
            }
            return basicSetSpecific((Entity) otherEnd, msgs);
         case RefactoringPackage.GENERALIZATION__GENERAL:
            if(general != null) {
               msgs = ((InternalEObject) general).eInverseRemove(this, RefactoringPackage.ENTITY__SPECIALIZATION,
                     Entity.class, msgs);
            }
            return basicSetGeneral((Entity) otherEnd, msgs);
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
         case RefactoringPackage.GENERALIZATION__SPECIFIC:
            return basicSetSpecific(null, msgs);
         case RefactoringPackage.GENERALIZATION__GENERAL:
            return basicSetGeneral(null, msgs);
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
         case RefactoringPackage.GENERALIZATION__SPECIFIC:
            return specific != null;
         case RefactoringPackage.GENERALIZATION__GENERAL:
            return general != null;
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
         case RefactoringPackage.GENERALIZATION__SPECIFIC:
            setSpecific((Entity) newValue);
            return;
         case RefactoringPackage.GENERALIZATION__GENERAL:
            setGeneral((Entity) newValue);
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
      return RefactoringPackage.Literals.GENERALIZATION;
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
         case RefactoringPackage.GENERALIZATION__SPECIFIC:
            setSpecific((Entity) null);
            return;
         case RefactoringPackage.GENERALIZATION__GENERAL:
            setGeneral((Entity) null);
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
   public Entity getGeneral() {
      if(general != null && general.eIsProxy()) {
         final InternalEObject oldGeneral = (InternalEObject) general;
         general = (Entity) eResolveProxy(oldGeneral);
         if(general != oldGeneral) {
            if(eNotificationRequired()) {
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringPackage.GENERALIZATION__GENERAL,
                     oldGeneral, general));
            }
         }
      }
      return general;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public Entity getSpecific() {
      if(specific != null && specific.eIsProxy()) {
         final InternalEObject oldSpecific = (InternalEObject) specific;
         specific = (Entity) eResolveProxy(oldSpecific);
         if(specific != oldSpecific) {
            if(eNotificationRequired()) {
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringPackage.GENERALIZATION__SPECIFIC,
                     oldSpecific, specific));
            }
         }
      }
      return specific;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void setGeneral(final Entity newGeneral) {
      if(newGeneral != general) {
         NotificationChain msgs = null;
         if(general != null) {
            msgs = ((InternalEObject) general).eInverseRemove(this, RefactoringPackage.ENTITY__SPECIALIZATION,
                  Entity.class, msgs);
         }
         if(newGeneral != null) {
            msgs = ((InternalEObject) newGeneral).eInverseAdd(this, RefactoringPackage.ENTITY__SPECIALIZATION,
                  Entity.class, msgs);
         }
         msgs = basicSetGeneral(newGeneral, msgs);
         if(msgs != null) {
            msgs.dispatch();
         }
      } else if(eNotificationRequired()) {
         eNotify(new ENotificationImpl(this, Notification.SET, RefactoringPackage.GENERALIZATION__GENERAL, newGeneral,
               newGeneral));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void setSpecific(final Entity newSpecific) {
      if(newSpecific != specific) {
         NotificationChain msgs = null;
         if(specific != null) {
            msgs = ((InternalEObject) specific).eInverseRemove(this, RefactoringPackage.ENTITY__GENERALIZATION,
                  Entity.class, msgs);
         }
         if(newSpecific != null) {
            msgs = ((InternalEObject) newSpecific).eInverseAdd(this, RefactoringPackage.ENTITY__GENERALIZATION,
                  Entity.class, msgs);
         }
         msgs = basicSetSpecific(newSpecific, msgs);
         if(msgs != null) {
            msgs.dispatch();
         }
      } else if(eNotificationRequired()) {
         eNotify(new ENotificationImpl(this, Notification.SET, RefactoringPackage.GENERALIZATION__SPECIFIC, newSpecific,
               newSpecific));
      }
   }

} // GeneralizationImpl
