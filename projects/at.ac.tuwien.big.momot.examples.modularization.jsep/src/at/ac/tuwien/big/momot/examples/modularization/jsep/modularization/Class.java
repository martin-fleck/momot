/**
 */
package at.ac.tuwien.big.momot.examples.modularization.jsep.modularization;

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
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getModule <em>Module</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependedOnBy <em>Depended On By</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Module#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' reference.
	 * @see #setModule(Module)
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationPackage#getClass_Module()
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Module#getClasses
	 * @model opposite="classes"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getModule <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class}.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependedOnBy <em>Depended On By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationPackage#getClass_DependsOn()
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependedOnBy
	 * @model opposite="dependedOnBy"
	 * @generated
	 */
	EList<Class> getDependsOn();

	/**
	 * Returns the value of the '<em><b>Depended On By</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class}.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depended On By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depended On By</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.ModularizationPackage#getClass_DependedOnBy()
	 * @see at.ac.tuwien.big.momot.examples.modularization.jsep.modularization.Class#getDependsOn
	 * @model opposite="dependsOn"
	 * @generated
	 */
	EList<Class> getDependedOnBy();

} // Class
