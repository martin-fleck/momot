/**
 */
package icmt.tool.momot.demo.architectureCRA;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.ClassModel#getClasses <em>Classes</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.ClassModel#getFeatures <em>Features</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.ClassModel#getCounter <em>Counter</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.ClassModel#getClasscounter <em>Classcounter</em>}</li>
 * </ul>
 *
 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getClassModel()
 * @model
 * @generated
 */
public interface ClassModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link icmt.tool.momot.demo.architectureCRA.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getClassModel_Classes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<icmt.tool.momot.demo.architectureCRA.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link icmt.tool.momot.demo.architectureCRA.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getClassModel_Features()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Counter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Counter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Counter</em>' attribute.
	 * @see #setCounter(int)
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getClassModel_Counter()
	 * @model
	 * @generated
	 */
	int getCounter();

	/**
	 * Sets the value of the '{@link icmt.tool.momot.demo.architectureCRA.ClassModel#getCounter <em>Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Counter</em>' attribute.
	 * @see #getCounter()
	 * @generated
	 */
	void setCounter(int value);

	/**
	 * Returns the value of the '<em><b>Classcounter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classcounter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classcounter</em>' attribute.
	 * @see #setClasscounter(int)
	 * @see icmt.tool.momot.demo.architectureCRA.ArchitecturePackage#getClassModel_Classcounter()
	 * @model
	 * @generated
	 */
	int getClasscounter();

	/**
	 * Sets the value of the '{@link icmt.tool.momot.demo.architectureCRA.ClassModel#getClasscounter <em>Classcounter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classcounter</em>' attribute.
	 * @see #getClasscounter()
	 * @generated
	 */
	void setClasscounter(int value);

} // ClassModel
