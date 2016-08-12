/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getProperties
 * <em>Properties</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getEntities
 * <em>Entities</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getTypes
 * <em>Types</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.impl.RefactoringModelImpl#getGeneralizations
 * <em>Generalizations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RefactoringModelImpl extends MinimalEObjectImpl.Container implements RefactoringModel {
   /**
    * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getProperties()
    * @generated
    * @ordered
    */
   protected EList<Property> properties;

   /**
    * The cached value of the '{@link #getEntities() <em>Entities</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getEntities()
    * @generated
    * @ordered
    */
   protected EList<Entity> entities;

   /**
    * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getTypes()
    * @generated
    * @ordered
    */
   protected EList<Type> types;

   /**
    * The cached value of the '{@link #getGeneralizations() <em>Generalizations</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getGeneralizations()
    * @generated
    * @ordered
    */
   protected EList<Generalization> generalizations;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   protected RefactoringModelImpl() {
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
         case RefactoringPackage.REFACTORING_MODEL__PROPERTIES:
            return getProperties();
         case RefactoringPackage.REFACTORING_MODEL__ENTITIES:
            return getEntities();
         case RefactoringPackage.REFACTORING_MODEL__TYPES:
            return getTypes();
         case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
            return getGeneralizations();
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
         case RefactoringPackage.REFACTORING_MODEL__PROPERTIES:
            return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
         case RefactoringPackage.REFACTORING_MODEL__ENTITIES:
            return ((InternalEList<?>) getEntities()).basicRemove(otherEnd, msgs);
         case RefactoringPackage.REFACTORING_MODEL__TYPES:
            return ((InternalEList<?>) getTypes()).basicRemove(otherEnd, msgs);
         case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
            return ((InternalEList<?>) getGeneralizations()).basicRemove(otherEnd, msgs);
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
         case RefactoringPackage.REFACTORING_MODEL__PROPERTIES:
            return properties != null && !properties.isEmpty();
         case RefactoringPackage.REFACTORING_MODEL__ENTITIES:
            return entities != null && !entities.isEmpty();
         case RefactoringPackage.REFACTORING_MODEL__TYPES:
            return types != null && !types.isEmpty();
         case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
            return generalizations != null && !generalizations.isEmpty();
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
         case RefactoringPackage.REFACTORING_MODEL__PROPERTIES:
            getProperties().clear();
            getProperties().addAll((Collection<? extends Property>) newValue);
            return;
         case RefactoringPackage.REFACTORING_MODEL__ENTITIES:
            getEntities().clear();
            getEntities().addAll((Collection<? extends Entity>) newValue);
            return;
         case RefactoringPackage.REFACTORING_MODEL__TYPES:
            getTypes().clear();
            getTypes().addAll((Collection<? extends Type>) newValue);
            return;
         case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
            getGeneralizations().clear();
            getGeneralizations().addAll((Collection<? extends Generalization>) newValue);
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
      return RefactoringPackage.Literals.REFACTORING_MODEL;
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
         case RefactoringPackage.REFACTORING_MODEL__PROPERTIES:
            getProperties().clear();
            return;
         case RefactoringPackage.REFACTORING_MODEL__ENTITIES:
            getEntities().clear();
            return;
         case RefactoringPackage.REFACTORING_MODEL__TYPES:
            getTypes().clear();
            return;
         case RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS:
            getGeneralizations().clear();
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
   public EList<Entity> getEntities() {
      if(entities == null) {
         entities = new EObjectContainmentEList<>(Entity.class, this,
               RefactoringPackage.REFACTORING_MODEL__ENTITIES);
      }
      return entities;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public EList<Generalization> getGeneralizations() {
      if(generalizations == null) {
         generalizations = new EObjectContainmentEList<>(Generalization.class, this,
               RefactoringPackage.REFACTORING_MODEL__GENERALIZATIONS);
      }
      return generalizations;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public EList<Property> getProperties() {
      if(properties == null) {
         properties = new EObjectContainmentEList<>(Property.class, this,
               RefactoringPackage.REFACTORING_MODEL__PROPERTIES);
      }
      return properties;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public EList<Type> getTypes() {
      if(types == null) {
         types = new EObjectContainmentEList<>(Type.class, this, RefactoringPackage.REFACTORING_MODEL__TYPES);
      }
      return types;
   }

} // RefactoringModelImpl
