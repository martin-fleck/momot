/**
 */
package at.ac.tuwien.big.momot.examples.refactoring.refactoring;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getPropertys <em>Propertys</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getEntitys <em>Entitys</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getTypes <em>Types</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel#getGeneralizations <em>Generalizations</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getRefactoringModel()
 * @model
 * @generated
 */
public interface RefactoringModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Propertys</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propertys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propertys</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getRefactoringModel_Propertys()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getPropertys();

	/**
	 * Returns the value of the '<em><b>Entitys</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entitys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entitys</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getRefactoringModel_Entitys()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getEntitys();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getRefactoringModel_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * Returns the value of the '<em><b>Generalizations</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generalizations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generalizations</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage#getRefactoringModel_Generalizations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Generalization> getGeneralizations();

} // RefactoringModel
