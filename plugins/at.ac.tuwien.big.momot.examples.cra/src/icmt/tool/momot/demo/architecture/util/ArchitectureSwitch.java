/**
 */
package icmt.tool.momot.demo.architecture.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import icmt.tool.momot.demo.architecture.ArchitecturePackage;
import icmt.tool.momot.demo.architecture.Attribute;
import icmt.tool.momot.demo.architecture.ClassModel;
import icmt.tool.momot.demo.architecture.Feature;
import icmt.tool.momot.demo.architecture.Method;
import icmt.tool.momot.demo.architecture.NamedElement;

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
 * @see icmt.tool.momot.demo.architecture.ArchitecturePackage
 * @generated
 */
public class ArchitectureSwitch<T> extends Switch<T> {
   /**
    * The cached model package
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   protected static ArchitecturePackage modelPackage;

   /**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @generated
    */
   public ArchitectureSwitch() {
      if(modelPackage == null) {
         modelPackage = ArchitecturePackage.eINSTANCE;
      }
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseAttribute(final Attribute object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Class</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseClass(final icmt.tool.momot.demo.architecture.Class object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Class Model</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Class Model</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseClassModel(final ClassModel object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseFeature(final Feature object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    *
    * @param object
    *           the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Method</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseMethod(final Method object) {
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
         case ArchitecturePackage.CLASS_MODEL: {
            final ClassModel classModel = (ClassModel) theEObject;
            T result = caseClassModel(classModel);
            if(result == null) {
               result = caseNamedElement(classModel);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ArchitecturePackage.CLASS: {
            final icmt.tool.momot.demo.architecture.Class class_ = (icmt.tool.momot.demo.architecture.Class) theEObject;
            T result = caseClass(class_);
            if(result == null) {
               result = caseNamedElement(class_);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ArchitecturePackage.ATTRIBUTE: {
            final Attribute attribute = (Attribute) theEObject;
            T result = caseAttribute(attribute);
            if(result == null) {
               result = caseFeature(attribute);
            }
            if(result == null) {
               result = caseNamedElement(attribute);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ArchitecturePackage.METHOD: {
            final Method method = (Method) theEObject;
            T result = caseMethod(method);
            if(result == null) {
               result = caseFeature(method);
            }
            if(result == null) {
               result = caseNamedElement(method);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ArchitecturePackage.FEATURE: {
            final Feature feature = (Feature) theEObject;
            T result = caseFeature(feature);
            if(result == null) {
               result = caseNamedElement(feature);
            }
            if(result == null) {
               result = defaultCase(theEObject);
            }
            return result;
         }
         case ArchitecturePackage.NAMED_ELEMENT: {
            final NamedElement namedElement = (NamedElement) theEObject;
            T result = caseNamedElement(namedElement);
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

} // ArchitectureSwitch
