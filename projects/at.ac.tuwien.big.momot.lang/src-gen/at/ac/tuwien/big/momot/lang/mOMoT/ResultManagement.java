/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Management</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveAnalysis <em>Save Analysis</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveObjectives <em>Save Objectives</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveSolutions <em>Save Solutions</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getPrintObjectives <em>Print Objectives</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getPrintSolutions <em>Print Solutions</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getDoCommand <em>Do Command</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getResultManagement()
 * @model
 * @generated
 */
public interface ResultManagement extends EObject
{
  /**
   * Returns the value of the '<em><b>Save Analysis</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Save Analysis</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Save Analysis</em>' containment reference.
   * @see #setSaveAnalysis(SaveAnalysisCommand)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getResultManagement_SaveAnalysis()
   * @model containment="true"
   * @generated
   */
  SaveAnalysisCommand getSaveAnalysis();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getSaveAnalysis <em>Save Analysis</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Save Analysis</em>' containment reference.
   * @see #getSaveAnalysis()
   * @generated
   */
  void setSaveAnalysis(SaveAnalysisCommand value);

  /**
   * Returns the value of the '<em><b>Save Objectives</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Save Objectives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Save Objectives</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getResultManagement_SaveObjectives()
   * @model containment="true"
   * @generated
   */
  EList<SaveObjectivesCommand> getSaveObjectives();

  /**
   * Returns the value of the '<em><b>Save Solutions</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Save Solutions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Save Solutions</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getResultManagement_SaveSolutions()
   * @model containment="true"
   * @generated
   */
  EList<SaveSolutionsCommand> getSaveSolutions();

  /**
   * Returns the value of the '<em><b>Print Objectives</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Print Objectives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Print Objectives</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getResultManagement_PrintObjectives()
   * @model containment="true"
   * @generated
   */
  EList<PrintObjectivesCommand> getPrintObjectives();

  /**
   * Returns the value of the '<em><b>Print Solutions</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Print Solutions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Print Solutions</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getResultManagement_PrintSolutions()
   * @model containment="true"
   * @generated
   */
  EList<PrintSolutionsCommand> getPrintSolutions();

  /**
   * Returns the value of the '<em><b>Do Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Do Command</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Do Command</em>' containment reference.
   * @see #setDoCommand(XExpression)
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getResultManagement_DoCommand()
   * @model containment="true"
   * @generated
   */
  XExpression getDoCommand();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement#getDoCommand <em>Do Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Do Command</em>' containment reference.
   * @see #getDoCommand()
   * @generated
   */
  void setDoCommand(XExpression value);

} // ResultManagement
