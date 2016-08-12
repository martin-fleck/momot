/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl;

import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl.ClassImpl#getModule
 * <em>Module</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl.ClassImpl#getDependsOn <em>Depends
 * On</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.impl.ClassImpl#getDependedOnBy
 * <em>Depended On By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl
      implements at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class {
   /**
    * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getModule()
    * @generated
    * @ordered
    */
   protected Module module;

   /**
    * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getDependsOn()
    * @generated
    * @ordered
    */
   protected EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> dependsOn;
   /**
    * The cached value of the '{@link #getDependedOnBy() <em>Depended On By</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getDependedOnBy()
    * @generated
    * @ordered
    */
   protected EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> dependedOnBy;

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
   public Module basicGetModule() {
      return module;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain basicSetModule(final Module newModule, NotificationChain msgs) {
      final Module oldModule = module;
      module = newModule;
      if(eNotificationRequired()) {
         final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
               ModularizationPackage.CLASS__MODULE, oldModule, newModule);
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
         case ModularizationPackage.CLASS__MODULE:
            if(resolve) {
               return getModule();
            }
            return basicGetModule();
         case ModularizationPackage.CLASS__DEPENDS_ON:
            return getDependsOn();
         case ModularizationPackage.CLASS__DEPENDED_ON_BY:
            return getDependedOnBy();
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
   public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
      switch(featureID) {
         case ModularizationPackage.CLASS__MODULE:
            if(module != null) {
               msgs = ((InternalEObject) module).eInverseRemove(this, ModularizationPackage.MODULE__CLASSES,
                     Module.class, msgs);
            }
            return basicSetModule((Module) otherEnd, msgs);
         case ModularizationPackage.CLASS__DEPENDS_ON:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependsOn()).basicAdd(otherEnd, msgs);
         case ModularizationPackage.CLASS__DEPENDED_ON_BY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependedOnBy()).basicAdd(otherEnd, msgs);
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
         case ModularizationPackage.CLASS__MODULE:
            return basicSetModule(null, msgs);
         case ModularizationPackage.CLASS__DEPENDS_ON:
            return ((InternalEList<?>) getDependsOn()).basicRemove(otherEnd, msgs);
         case ModularizationPackage.CLASS__DEPENDED_ON_BY:
            return ((InternalEList<?>) getDependedOnBy()).basicRemove(otherEnd, msgs);
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
         case ModularizationPackage.CLASS__MODULE:
            return module != null;
         case ModularizationPackage.CLASS__DEPENDS_ON:
            return dependsOn != null && !dependsOn.isEmpty();
         case ModularizationPackage.CLASS__DEPENDED_ON_BY:
            return dependedOnBy != null && !dependedOnBy.isEmpty();
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
         case ModularizationPackage.CLASS__MODULE:
            setModule((Module) newValue);
            return;
         case ModularizationPackage.CLASS__DEPENDS_ON:
            getDependsOn().clear();
            getDependsOn().addAll(
                  (Collection<? extends at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class>) newValue);
            return;
         case ModularizationPackage.CLASS__DEPENDED_ON_BY:
            getDependedOnBy().clear();
            getDependedOnBy().addAll(
                  (Collection<? extends at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class>) newValue);
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
      return ModularizationPackage.Literals.CLASS;
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
         case ModularizationPackage.CLASS__MODULE:
            setModule((Module) null);
            return;
         case ModularizationPackage.CLASS__DEPENDS_ON:
            getDependsOn().clear();
            return;
         case ModularizationPackage.CLASS__DEPENDED_ON_BY:
            getDependedOnBy().clear();
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
   public EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> getDependedOnBy() {
      if(dependedOnBy == null) {
         dependedOnBy = new EObjectWithInverseResolvingEList.ManyInverse<>(
               at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class.class, this,
               ModularizationPackage.CLASS__DEPENDED_ON_BY, ModularizationPackage.CLASS__DEPENDS_ON);
      }
      return dependedOnBy;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public EList<at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class> getDependsOn() {
      if(dependsOn == null) {
         dependsOn = new EObjectWithInverseResolvingEList.ManyInverse<>(
               at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class.class, this,
               ModularizationPackage.CLASS__DEPENDS_ON, ModularizationPackage.CLASS__DEPENDED_ON_BY);
      }
      return dependsOn;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public Module getModule() {
      if(module != null && module.eIsProxy()) {
         final InternalEObject oldModule = (InternalEObject) module;
         module = (Module) eResolveProxy(oldModule);
         if(module != oldModule) {
            if(eNotificationRequired()) {
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModularizationPackage.CLASS__MODULE, oldModule,
                     module));
            }
         }
      }
      return module;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void setModule(final Module newModule) {
      if(newModule != module) {
         NotificationChain msgs = null;
         if(module != null) {
            msgs = ((InternalEObject) module).eInverseRemove(this, ModularizationPackage.MODULE__CLASSES, Module.class,
                  msgs);
         }
         if(newModule != null) {
            msgs = ((InternalEObject) newModule).eInverseAdd(this, ModularizationPackage.MODULE__CLASSES, Module.class,
                  msgs);
         }
         msgs = basicSetModule(newModule, msgs);
         if(msgs != null) {
            msgs.dispatch();
         }
      } else if(eNotificationRequired()) {
         eNotify(new ENotificationImpl(this, Notification.SET, ModularizationPackage.CLASS__MODULE, newModule,
               newModule));
      }
   }

} // ClassImpl
