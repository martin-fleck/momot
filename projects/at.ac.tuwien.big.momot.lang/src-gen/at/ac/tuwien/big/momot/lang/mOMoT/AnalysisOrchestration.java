/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT;

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
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getIndicators <em>Indicators</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getSignificance <em>Significance</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getShow <em>Show</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getGrouping <em>Grouping</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getAnalysisOrchestration()
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
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getAnalysisOrchestration_Indicators()
   * @model containment="true"
   * @generated
   */
  IndicatorArray getIndicators();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getIndicators <em>Indicators</em>}' containment reference.
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
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getAnalysisOrchestration_Significance()
   * @model containment="true"
   * @generated
   */
  XExpression getSignificance();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getSignificance <em>Significance</em>}' containment reference.
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
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getAnalysisOrchestration_Show()
   * @model containment="true"
   * @generated
   */
  ShowArray getShow();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getShow <em>Show</em>}' containment reference.
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
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#getAnalysisOrchestration_Grouping()
   * @model containment="true"
   * @generated
   */
  AnalysisGroupList getGrouping();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration#getGrouping <em>Grouping</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grouping</em>' containment reference.
   * @see #getGrouping()
   * @generated
   */
  void setGrouping(AnalysisGroupList value);

} // AnalysisOrchestration
