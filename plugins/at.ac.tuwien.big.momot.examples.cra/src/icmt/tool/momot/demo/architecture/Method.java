/**
 */
package icmt.tool.momot.demo.architecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link icmt.tool.momot.demo.architecture.Method#getDataDependency <em>Data Dependency</em>}</li>
 * <li>{@link icmt.tool.momot.demo.architecture.Method#getFunctionalDependency <em>Functional Dependency</em>}</li>
 * </ul>
 *
 * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Feature {
   /**
    * Returns the value of the '<em><b>Data Dependency</b></em>' reference list.
    * The list contents are of type {@link icmt.tool.momot.demo.architecture.Attribute}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Data Dependency</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    *
    * @return the value of the '<em>Data Dependency</em>' reference list.
    * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#getMethod_DataDependency()
    * @model
    * @generated
    */
   EList<Attribute> getDataDependency();

   /**
    * Returns the value of the '<em><b>Functional Dependency</b></em>' reference list.
    * The list contents are of type {@link icmt.tool.momot.demo.architecture.Method}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Functional Dependency</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    *
    * @return the value of the '<em>Functional Dependency</em>' reference list.
    * @see icmt.tool.momot.demo.architecture.ArchitecturePackage#getMethod_FunctionalDependency()
    * @model
    * @generated
    */
   EList<Method> getFunctionalDependency();

} // Method
