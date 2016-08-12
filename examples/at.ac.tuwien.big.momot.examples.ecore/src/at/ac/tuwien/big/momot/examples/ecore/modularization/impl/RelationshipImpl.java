/**
 */
package at.ac.tuwien.big.momot.examples.ecore.modularization.impl;

import at.ac.tuwien.big.momot.examples.ecore.modularization.Entity;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.RelationshipImpl#getWeight <em>Weight</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.ecore.modularization.impl.RelationshipImpl#getRelationshipEnd
 * <em>Relationship End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationshipImpl extends MinimalEObjectImpl.Container implements Relationship {
   /**
    * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #getWeight()
    * @generated
    * @ordered
    */
   protected static final int WEIGHT_EDEFAULT = 0;

   /**
    * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #getWeight()
    * @generated
    * @ordered
    */
   protected int weight = WEIGHT_EDEFAULT;

   /**
    * The cached value of the '{@link #getRelationshipEnd() <em>Relationship End</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @see #getRelationshipEnd()
    * @generated
    * @ordered
    */
   protected Entity relationshipEnd;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected RelationshipImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public Entity basicGetRelationshipEnd() {
      return relationshipEnd;
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
         case ModularizationPackage.RELATIONSHIP__WEIGHT:
            return getWeight();
         case ModularizationPackage.RELATIONSHIP__RELATIONSHIP_END:
            if(resolve) {
               return getRelationshipEnd();
            }
            return basicGetRelationshipEnd();
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
         case ModularizationPackage.RELATIONSHIP__WEIGHT:
            return weight != WEIGHT_EDEFAULT;
         case ModularizationPackage.RELATIONSHIP__RELATIONSHIP_END:
            return relationshipEnd != null;
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
         case ModularizationPackage.RELATIONSHIP__WEIGHT:
            setWeight((Integer) newValue);
            return;
         case ModularizationPackage.RELATIONSHIP__RELATIONSHIP_END:
            setRelationshipEnd((Entity) newValue);
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
      return ModularizationPackage.Literals.RELATIONSHIP;
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
         case ModularizationPackage.RELATIONSHIP__WEIGHT:
            setWeight(WEIGHT_EDEFAULT);
            return;
         case ModularizationPackage.RELATIONSHIP__RELATIONSHIP_END:
            setRelationshipEnd((Entity) null);
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
   public Entity getRelationshipEnd() {
      if(relationshipEnd != null && relationshipEnd.eIsProxy()) {
         final InternalEObject oldRelationshipEnd = (InternalEObject) relationshipEnd;
         relationshipEnd = (Entity) eResolveProxy(oldRelationshipEnd);
         if(relationshipEnd != oldRelationshipEnd) {
            if(eNotificationRequired()) {
               eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                     ModularizationPackage.RELATIONSHIP__RELATIONSHIP_END, oldRelationshipEnd, relationshipEnd));
            }
         }
      }
      return relationshipEnd;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public int getWeight() {
      return weight;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public void setRelationshipEnd(final Entity newRelationshipEnd) {
      final Entity oldRelationshipEnd = relationshipEnd;
      relationshipEnd = newRelationshipEnd;
      if(eNotificationRequired()) {
         eNotify(new ENotificationImpl(this, Notification.SET, ModularizationPackage.RELATIONSHIP__RELATIONSHIP_END,
               oldRelationshipEnd, relationshipEnd));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public void setWeight(final int newWeight) {
      final int oldWeight = weight;
      weight = newWeight;
      if(eNotificationRequired()) {
         eNotify(new ENotificationImpl(this, Notification.SET, ModularizationPackage.RELATIONSHIP__WEIGHT, oldWeight,
               weight));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   @Override
   public String toString() {
      if(eIsProxy()) {
         return super.toString();
      }

      final StringBuffer result = new StringBuffer(super.toString());
      result.append(" (weight: ");
      result.append(weight);
      result.append(')');
      return result.toString();
   }

} // RelationshipImpl
