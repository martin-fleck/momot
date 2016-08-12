/**
 */
package at.ac.tuwien.big.momot.examples.ecore.modularization.util;

import at.ac.tuwien.big.momot.examples.ecore.modularization.Entity;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;
import at.ac.tuwien.big.momot.examples.ecore.modularization.NamedElement;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage
 * @generated
 */
public class ModularizationSwitch<T> extends Switch<T> {
   /**
    * The cached model package
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected static ModularizationPackage modelPackage;

   /**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public ModularizationSwitch() {
      if(modelPackage == null) {
         modelPackage = ModularizationPackage.eINSTANCE;
      }
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseEntity(final Entity object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Language</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Language</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseLanguage(final Language object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Module</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseModule(final Module object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseNamedElement(final NamedElement object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseRelationship(final Relationship object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch, but this is the last case anyway.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject)
    * @generated
    */
   @Override
   public T defaultCase(final EObject object) {
      return null;
   }

   /**
    * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @return the first non-null result returned by a <code>caseXXX</code> call.
    * @generated
    */
   @Override
   protected T doSwitch(final int classifierID, final EObject theEObject) {
      switch(classifierID) {
         case ModularizationPackage.NAMED_ELEMENT: {
            final NamedElement namedElement = (NamedElement) theEObject;
            T result = caseNamedElement(namedElement);
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ModularizationPackage.LANGUAGE: {
            final Language language = (Language) theEObject;
            T result = caseLanguage(language);
            if(result == null) {
               result = caseNamedElement(language);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ModularizationPackage.MODULE: {
            final Module module = (Module) theEObject;
            T result = caseModule(module);
            if(result == null) {
               result = caseNamedElement(module);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ModularizationPackage.ENTITY: {
            final Entity entity = (Entity) theEObject;
            T result = caseEntity(entity);
            if(result == null) {
               result = caseNamedElement(entity);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ModularizationPackage.RELATIONSHIP: {
            final Relationship relationship = (Relationship) theEObject;
            T result = caseRelationship(relationship);
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         default:
            return defaultCase(theEObject);
      }
   }

   /**
    * Checks whether this is a switch for the given package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @param ePackage
    *           the package in question.
    * @return whether this is a switch for the given package.
    * @generated
    */
   @Override
   protected boolean isSwitchFor(final EPackage ePackage) {
      return ePackage == modelPackage;
   }

} // ModularizationSwitch
