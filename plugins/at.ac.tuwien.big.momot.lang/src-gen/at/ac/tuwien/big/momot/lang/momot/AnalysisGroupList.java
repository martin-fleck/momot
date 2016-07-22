/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Group List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisGroupList()
 * @model
 * @generated
 */
public interface AnalysisGroupList extends EObject
{
  /**
   * Returns the value of the '<em><b>Group</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisGroupList_Group()
   * @model containment="true"
   * @generated
   */
  EList<AnalysisGroupSpecification> getGroup();

} // AnalysisGroupList
