/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.EntityImpl#getOwnedAttribute <em>Owned Attribute</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.EntityImpl#getSpecialization <em>Specialization</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.EntityImpl#getGeneralization <em>Generalization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityImpl extends NamedElementImpl implements Entity {
   /**
    * The cached value of the '{@link #getOwnedAttribute() <em>Owned Attribute</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getOwnedAttribute()
    * @generated
    * @ordered
    */
   protected EList<Property> ownedAttribute;

   /**
    * The cached value of the '{@link #getSpecialization() <em>Specialization</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getSpecialization()
    * @generated
    * @ordered
    */
   protected EList<Generalization> specialization;

   /**
    * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getGeneralization()
    * @generated
    * @ordered
    */
   protected Generalization generalization;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected EntityImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Generalization basicGetGeneralization() {
      return generalization;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetGeneralization(Generalization newGeneralization, NotificationChain msgs) {
      Generalization oldGeneralization = generalization;
      generalization = newGeneralization;
      if (eNotificationRequired()) {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringPackage.ENTITY__GENERALIZATION, oldGeneralization, newGeneralization);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case RefactoringPackage.ENTITY__OWNED_ATTRIBUTE:
            return getOwnedAttribute();
         case RefactoringPackage.ENTITY__SPECIALIZATION:
            return getSpecialization();
         case RefactoringPackage.ENTITY__GENERALIZATION:
            if (resolve) return getGeneralization();
            return basicGetGeneralization();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case RefactoringPackage.ENTITY__SPECIALIZATION:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecialization()).basicAdd(otherEnd, msgs);
         case RefactoringPackage.ENTITY__GENERALIZATION:
            if (generalization != null)
               msgs = ((InternalEObject)generalization).eInverseRemove(this, RefactoringPackage.GENERALIZATION__SPECIFIC, Generalization.class, msgs);
            return basicSetGeneralization((Generalization)otherEnd, msgs);
      }
      return super.eInverseAdd(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case RefactoringPackage.ENTITY__SPECIALIZATION:
            return ((InternalEList<?>)getSpecialization()).basicRemove(otherEnd, msgs);
         case RefactoringPackage.ENTITY__GENERALIZATION:
            return basicSetGeneralization(null, msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean eIsSet(int featureID) {
      switch (featureID) {
         case RefactoringPackage.ENTITY__OWNED_ATTRIBUTE:
            return ownedAttribute != null && !ownedAttribute.isEmpty();
         case RefactoringPackage.ENTITY__SPECIALIZATION:
            return specialization != null && !specialization.isEmpty();
         case RefactoringPackage.ENTITY__GENERALIZATION:
            return generalization != null;
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(int featureID, Object newValue) {
      switch (featureID) {
         case RefactoringPackage.ENTITY__OWNED_ATTRIBUTE:
            getOwnedAttribute().clear();
            getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
            return;
         case RefactoringPackage.ENTITY__SPECIALIZATION:
            getSpecialization().clear();
            getSpecialization().addAll((Collection<? extends Generalization>)newValue);
            return;
         case RefactoringPackage.ENTITY__GENERALIZATION:
            setGeneralization((Generalization)newValue);
            return;
      }
      super.eSet(featureID, newValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return RefactoringPackage.Literals.ENTITY;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void eUnset(int featureID) {
      switch (featureID) {
         case RefactoringPackage.ENTITY__OWNED_ATTRIBUTE:
            getOwnedAttribute().clear();
            return;
         case RefactoringPackage.ENTITY__SPECIALIZATION:
            getSpecialization().clear();
            return;
         case RefactoringPackage.ENTITY__GENERALIZATION:
            setGeneralization((Generalization)null);
            return;
      }
      super.eUnset(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Generalization getGeneralization() {
      if (generalization != null && generalization.eIsProxy()) {
         InternalEObject oldGeneralization = (InternalEObject)generalization;
         generalization = (Generalization)eResolveProxy(oldGeneralization);
         if (generalization != oldGeneralization) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringPackage.ENTITY__GENERALIZATION, oldGeneralization, generalization));
         }
      }
      return generalization;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public EList<Property> getOwnedAttribute() {
      if (ownedAttribute == null) {
         ownedAttribute = new EObjectResolvingEList<Property>(Property.class, this, RefactoringPackage.ENTITY__OWNED_ATTRIBUTE);
      }
      return ownedAttribute;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public EList<Generalization> getSpecialization() {
      if (specialization == null) {
         specialization = new EObjectWithInverseResolvingEList<Generalization>(Generalization.class, this, RefactoringPackage.ENTITY__SPECIALIZATION, RefactoringPackage.GENERALIZATION__GENERAL);
      }
      return specialization;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void setGeneralization(Generalization newGeneralization) {
      if (newGeneralization != generalization) {
         NotificationChain msgs = null;
         if (generalization != null)
            msgs = ((InternalEObject)generalization).eInverseRemove(this, RefactoringPackage.GENERALIZATION__SPECIFIC, Generalization.class, msgs);
         if (newGeneralization != null)
            msgs = ((InternalEObject)newGeneralization).eInverseAdd(this, RefactoringPackage.GENERALIZATION__SPECIFIC, Generalization.class, msgs);
         msgs = basicSetGeneralization(newGeneralization, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RefactoringPackage.ENTITY__GENERALIZATION, newGeneralization, newGeneralization));
   }

} // EntityImpl
