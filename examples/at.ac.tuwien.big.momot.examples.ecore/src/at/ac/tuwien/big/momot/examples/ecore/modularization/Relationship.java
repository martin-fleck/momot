/**
 */
package at.ac.tuwien.big.momot.examples.ecore.modularization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getWeight <em>Weight</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getRelationshipEnd <em>Relationship
 * End</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends EObject {
   /**
    * Returns the value of the '<em><b>Relationship End</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Relationship End</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    *
    * @return the value of the '<em>Relationship End</em>' reference.
    * @see #setRelationshipEnd(Entity)
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage#getRelationship_RelationshipEnd()
    * @model required="true"
    * @generated
    */
   Entity getRelationshipEnd();

   /**
    * Returns the value of the '<em><b>Weight</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Weight</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    *
    * @return the value of the '<em>Weight</em>' attribute.
    * @see #setWeight(int)
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage#getRelationship_Weight()
    * @model unique="false" required="true"
    * @generated
    */
   int getWeight();

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getRelationshipEnd
    * <em>Relationship End</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @param value
    *           the new value of the '<em>Relationship End</em>' reference.
    * @see #getRelationshipEnd()
    * @generated
    */
   void setRelationshipEnd(Entity value);

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship#getWeight
    * <em>Weight</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    *
    * @param value
    *           the new value of the '<em>Weight</em>' attribute.
    * @see #getWeight()
    * @generated
    */
   void setWeight(int value);

} // Relationship
