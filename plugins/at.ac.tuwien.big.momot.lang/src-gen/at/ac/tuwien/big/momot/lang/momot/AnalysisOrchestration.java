/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Orchestration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getIndicators <em>Indicators</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSignificance <em>Significance</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getShow <em>Show</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getGrouping <em>Grouping</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSaveCommand <em>Save Command</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getBoxplotCommand <em>Boxplot Command</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getPrintCommand <em>Print Command</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration()
 * @model
 * @generated
 */
public interface AnalysisOrchestration extends EObject
{
  /**
   * Returns the value of the '<em><b>Indicators</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indicators</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indicators</em>' containment reference.
   * @see #setIndicators(IndicatorArray)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration_Indicators()
   * @model containment="true"
   * @generated
   */
  IndicatorArray getIndicators();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getIndicators <em>Indicators</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indicators</em>' containment reference.
   * @see #getIndicators()
   * @generated
   */
  void setIndicators(IndicatorArray value);

  /**
   * Returns the value of the '<em><b>Significance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Significance</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Significance</em>' containment reference.
   * @see #setSignificance(XExpression)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration_Significance()
   * @model containment="true"
   * @generated
   */
  XExpression getSignificance();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSignificance <em>Significance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Significance</em>' containment reference.
   * @see #getSignificance()
   * @generated
   */
  void setSignificance(XExpression value);

  /**
   * Returns the value of the '<em><b>Show</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Show</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Show</em>' containment reference.
   * @see #setShow(ShowArray)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration_Show()
   * @model containment="true"
   * @generated
   */
  ShowArray getShow();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getShow <em>Show</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Show</em>' containment reference.
   * @see #getShow()
   * @generated
   */
  void setShow(ShowArray value);

  /**
   * Returns the value of the '<em><b>Grouping</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Grouping</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Grouping</em>' containment reference.
   * @see #setGrouping(AnalysisGroupList)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration_Grouping()
   * @model containment="true"
   * @generated
   */
  AnalysisGroupList getGrouping();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getGrouping <em>Grouping</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grouping</em>' containment reference.
   * @see #getGrouping()
   * @generated
   */
  void setGrouping(AnalysisGroupList value);

  /**
   * Returns the value of the '<em><b>Save Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Save Command</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Save Command</em>' containment reference.
   * @see #setSaveCommand(SaveAnalysisCommand)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration_SaveCommand()
   * @model containment="true"
   * @generated
   */
  SaveAnalysisCommand getSaveCommand();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getSaveCommand <em>Save Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Save Command</em>' containment reference.
   * @see #getSaveCommand()
   * @generated
   */
  void setSaveCommand(SaveAnalysisCommand value);

  /**
   * Returns the value of the '<em><b>Boxplot Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Boxplot Command</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Boxplot Command</em>' containment reference.
   * @see #setBoxplotCommand(BoxplotCommand)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration_BoxplotCommand()
   * @model containment="true"
   * @generated
   */
  BoxplotCommand getBoxplotCommand();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getBoxplotCommand <em>Boxplot Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Boxplot Command</em>' containment reference.
   * @see #getBoxplotCommand()
   * @generated
   */
  void setBoxplotCommand(BoxplotCommand value);

  /**
   * Returns the value of the '<em><b>Print Command</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Print Command</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Print Command</em>' containment reference.
   * @see #setPrintCommand(PrintAnalysisCommand)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getAnalysisOrchestration_PrintCommand()
   * @model containment="true"
   * @generated
   */
  PrintAnalysisCommand getPrintCommand();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration#getPrintCommand <em>Print Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Print Command</em>' containment reference.
   * @see #getPrintCommand()
   * @generated
   */
  void setPrintCommand(PrintAnalysisCommand value);

} // AnalysisOrchestration
