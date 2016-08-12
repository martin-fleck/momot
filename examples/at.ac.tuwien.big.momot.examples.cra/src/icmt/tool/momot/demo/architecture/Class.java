/**
 */
package icmt.tool.momot.demo.architecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link icmt.tool.momot.demo.architecture.Class#getEncapsulates <em>Encapsulates</em>}</li>
 * </ul>
 *
 * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement {
   /**
    * Returns the value of the '<em><b>Encapsulates</b></em>' reference list.
    * The list contents are of type {@link icmt.tool.momot.demo.architecture.Feature}.
    * It is bidirectional and its opposite is '{@link icmt.tool.momot.demo.architecture.Feature#getIsEncapsulatedBy
    * <em>Is Encapsulated By</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Encapsulates</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    *
    * @return the value of the '<em>Encapsulates</em>' reference list.
    * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#getClass_Encapsulates()
    * @see icmt.tool.momot.demo.architecture.Feature#getIsEncapsulatedBy
    * @model opposite="isEncapsulatedBy" required="true"
    * @generated
    */
   EList<Feature> getEncapsulates();

} // Class
