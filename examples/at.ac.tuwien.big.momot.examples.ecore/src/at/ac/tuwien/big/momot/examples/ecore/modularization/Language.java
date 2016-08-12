/**
 */
package at.ac.tuwien.big.momot.examples.ecore.modularization;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.ecore.modularization.Language#getModules <em>Modules</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage#getLanguage()
 * @model
 * @generated
 */
public interface Language extends NamedElement {
   /**
    * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
    * The list contents are of type {@link at.ac.tuwien.big.momot.examples.ecore.modularization.Module}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    *
    * @return the value of the '<em>Modules</em>' containment reference list.
    * @see at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage#getLanguage_Modules()
    * @model containment="true"
    * @generated
    */
   EList<Module> getModules();

} // Language
