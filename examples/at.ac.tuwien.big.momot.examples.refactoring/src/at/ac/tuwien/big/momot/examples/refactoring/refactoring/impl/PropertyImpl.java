/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.PropertyImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyImpl extends NamedElementImpl implements Property {
   /**
    * The cached value of the '{@link #getType() <em>Type</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getType()
    * @generated
    * @ordered
    */
   protected Type type;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   protected PropertyImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public Type basicGetType() {
      return type;
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
         case RefactoringPackage.PROPERTY__TYPE:
            if(resolve) {
               return getType();
            }
            return basicGetType();
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
   public boolean eIsSet(final int featureID) {
      switch(featureID) {
         case RefactoringPackage.PROPERTY__TYPE:
            return type != null;
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
         case RefactoringPackage.PROPERTY__TYPE:
            setType((Type) newValue);
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
      return RefactoringPackage.Literals.PROPERTY;
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
         case RefactoringPackage.PROPERTY__TYPE:
            setType((Type) null);
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
   public Type getType() {
      if(type != null && type.eIsProxy()) {
         final InternalEObject oldType = (InternalEObject) type;
         type = (Type) eResolveProxy(oldType);
         if(type != oldType) {
            if(eNotificationRequired()) {
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringPackage.PROPERTY__TYPE, oldType,
                     type));
            }
         }
      }
      return type;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void setType(final Type newType) {
      final Type oldType = type;
      type = newType;
      if(eNotificationRequired()) {
         eNotify(new ENotificationImpl(this, Notification.SET, RefactoringPackage.PROPERTY__TYPE, oldType, type));
      }
   }

} // PropertyImpl
