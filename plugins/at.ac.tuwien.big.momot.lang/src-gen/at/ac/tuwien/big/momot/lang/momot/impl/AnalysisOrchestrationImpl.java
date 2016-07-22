/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList;
import at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration;
import at.ac.tuwien.big.momot.lang.momot.BoxplotCommand;
import at.ac.tuwien.big.momot.lang.momot.IndicatorArray;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.PrintAnalysisCommand;
import at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand;
import at.ac.tuwien.big.momot.lang.momot.ShowArray;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Orchestration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl#getIndicators <em>Indicators</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl#getSignificance <em>Significance</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl#getShow <em>Show</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl#getGrouping <em>Grouping</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl#getSaveCommand <em>Save Command</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl#getBoxplotCommand <em>Boxplot Command</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisOrchestrationImpl#getPrintCommand <em>Print Command</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalysisOrchestrationImpl extends MinimalEObjectImpl.Container implements AnalysisOrchestration
{
  /**
   * The cached value of the '{@link #getIndicators() <em>Indicators</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndicators()
   * @generated
   * @ordered
   */
  protected IndicatorArray indicators;

  /**
   * The cached value of the '{@link #getSignificance() <em>Significance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignificance()
   * @generated
   * @ordered
   */
  protected XExpression significance;

  /**
   * The cached value of the '{@link #getShow() <em>Show</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShow()
   * @generated
   * @ordered
   */
  protected ShowArray show;

  /**
   * The cached value of the '{@link #getGrouping() <em>Grouping</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrouping()
   * @generated
   * @ordered
   */
  protected AnalysisGroupList grouping;

  /**
   * The cached value of the '{@link #getSaveCommand() <em>Save Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSaveCommand()
   * @generated
   * @ordered
   */
  protected SaveAnalysisCommand saveCommand;

  /**
   * The cached value of the '{@link #getBoxplotCommand() <em>Boxplot Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoxplotCommand()
   * @generated
   * @ordered
   */
  protected BoxplotCommand boxplotCommand;

  /**
   * The cached value of the '{@link #getPrintCommand() <em>Print Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrintCommand()
   * @generated
   * @ordered
   */
  protected PrintAnalysisCommand printCommand;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnalysisOrchestrationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MomotPackage.Literals.ANALYSIS_ORCHESTRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndicatorArray getIndicators()
  {
    return indicators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndicators(IndicatorArray newIndicators, NotificationChain msgs)
  {
    IndicatorArray oldIndicators = indicators;
    indicators = newIndicators;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS, oldIndicators, newIndicators);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndicators(IndicatorArray newIndicators)
  {
    if (newIndicators != indicators)
    {
      NotificationChain msgs = null;
      if (indicators != null)
        msgs = ((InternalEObject)indicators).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS, null, msgs);
      if (newIndicators != null)
        msgs = ((InternalEObject)newIndicators).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS, null, msgs);
      msgs = basicSetIndicators(newIndicators, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS, newIndicators, newIndicators));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getSignificance()
  {
    return significance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSignificance(XExpression newSignificance, NotificationChain msgs)
  {
    XExpression oldSignificance = significance;
    significance = newSignificance;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE, oldSignificance, newSignificance);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignificance(XExpression newSignificance)
  {
    if (newSignificance != significance)
    {
      NotificationChain msgs = null;
      if (significance != null)
        msgs = ((InternalEObject)significance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE, null, msgs);
      if (newSignificance != null)
        msgs = ((InternalEObject)newSignificance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE, null, msgs);
      msgs = basicSetSignificance(newSignificance, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE, newSignificance, newSignificance));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShowArray getShow()
  {
    return show;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShow(ShowArray newShow, NotificationChain msgs)
  {
    ShowArray oldShow = show;
    show = newShow;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__SHOW, oldShow, newShow);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShow(ShowArray newShow)
  {
    if (newShow != show)
    {
      NotificationChain msgs = null;
      if (show != null)
        msgs = ((InternalEObject)show).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__SHOW, null, msgs);
      if (newShow != null)
        msgs = ((InternalEObject)newShow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__SHOW, null, msgs);
      msgs = basicSetShow(newShow, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__SHOW, newShow, newShow));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisGroupList getGrouping()
  {
    return grouping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGrouping(AnalysisGroupList newGrouping, NotificationChain msgs)
  {
    AnalysisGroupList oldGrouping = grouping;
    grouping = newGrouping;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING, oldGrouping, newGrouping);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGrouping(AnalysisGroupList newGrouping)
  {
    if (newGrouping != grouping)
    {
      NotificationChain msgs = null;
      if (grouping != null)
        msgs = ((InternalEObject)grouping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING, null, msgs);
      if (newGrouping != null)
        msgs = ((InternalEObject)newGrouping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING, null, msgs);
      msgs = basicSetGrouping(newGrouping, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING, newGrouping, newGrouping));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SaveAnalysisCommand getSaveCommand()
  {
    return saveCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSaveCommand(SaveAnalysisCommand newSaveCommand, NotificationChain msgs)
  {
    SaveAnalysisCommand oldSaveCommand = saveCommand;
    saveCommand = newSaveCommand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND, oldSaveCommand, newSaveCommand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaveCommand(SaveAnalysisCommand newSaveCommand)
  {
    if (newSaveCommand != saveCommand)
    {
      NotificationChain msgs = null;
      if (saveCommand != null)
        msgs = ((InternalEObject)saveCommand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND, null, msgs);
      if (newSaveCommand != null)
        msgs = ((InternalEObject)newSaveCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND, null, msgs);
      msgs = basicSetSaveCommand(newSaveCommand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND, newSaveCommand, newSaveCommand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoxplotCommand getBoxplotCommand()
  {
    return boxplotCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBoxplotCommand(BoxplotCommand newBoxplotCommand, NotificationChain msgs)
  {
    BoxplotCommand oldBoxplotCommand = boxplotCommand;
    boxplotCommand = newBoxplotCommand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND, oldBoxplotCommand, newBoxplotCommand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoxplotCommand(BoxplotCommand newBoxplotCommand)
  {
    if (newBoxplotCommand != boxplotCommand)
    {
      NotificationChain msgs = null;
      if (boxplotCommand != null)
        msgs = ((InternalEObject)boxplotCommand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND, null, msgs);
      if (newBoxplotCommand != null)
        msgs = ((InternalEObject)newBoxplotCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND, null, msgs);
      msgs = basicSetBoxplotCommand(newBoxplotCommand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND, newBoxplotCommand, newBoxplotCommand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrintAnalysisCommand getPrintCommand()
  {
    return printCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrintCommand(PrintAnalysisCommand newPrintCommand, NotificationChain msgs)
  {
    PrintAnalysisCommand oldPrintCommand = printCommand;
    printCommand = newPrintCommand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND, oldPrintCommand, newPrintCommand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrintCommand(PrintAnalysisCommand newPrintCommand)
  {
    if (newPrintCommand != printCommand)
    {
      NotificationChain msgs = null;
      if (printCommand != null)
        msgs = ((InternalEObject)printCommand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND, null, msgs);
      if (newPrintCommand != null)
        msgs = ((InternalEObject)newPrintCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND, null, msgs);
      msgs = basicSetPrintCommand(newPrintCommand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND, newPrintCommand, newPrintCommand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS:
        return basicSetIndicators(null, msgs);
      case MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE:
        return basicSetSignificance(null, msgs);
      case MomotPackage.ANALYSIS_ORCHESTRATION__SHOW:
        return basicSetShow(null, msgs);
      case MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING:
        return basicSetGrouping(null, msgs);
      case MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND:
        return basicSetSaveCommand(null, msgs);
      case MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND:
        return basicSetBoxplotCommand(null, msgs);
      case MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND:
        return basicSetPrintCommand(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS:
        return getIndicators();
      case MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE:
        return getSignificance();
      case MomotPackage.ANALYSIS_ORCHESTRATION__SHOW:
        return getShow();
      case MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING:
        return getGrouping();
      case MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND:
        return getSaveCommand();
      case MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND:
        return getBoxplotCommand();
      case MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND:
        return getPrintCommand();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS:
        setIndicators((IndicatorArray)newValue);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE:
        setSignificance((XExpression)newValue);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SHOW:
        setShow((ShowArray)newValue);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING:
        setGrouping((AnalysisGroupList)newValue);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND:
        setSaveCommand((SaveAnalysisCommand)newValue);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND:
        setBoxplotCommand((BoxplotCommand)newValue);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND:
        setPrintCommand((PrintAnalysisCommand)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS:
        setIndicators((IndicatorArray)null);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE:
        setSignificance((XExpression)null);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SHOW:
        setShow((ShowArray)null);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING:
        setGrouping((AnalysisGroupList)null);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND:
        setSaveCommand((SaveAnalysisCommand)null);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND:
        setBoxplotCommand((BoxplotCommand)null);
        return;
      case MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND:
        setPrintCommand((PrintAnalysisCommand)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MomotPackage.ANALYSIS_ORCHESTRATION__INDICATORS:
        return indicators != null;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SIGNIFICANCE:
        return significance != null;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SHOW:
        return show != null;
      case MomotPackage.ANALYSIS_ORCHESTRATION__GROUPING:
        return grouping != null;
      case MomotPackage.ANALYSIS_ORCHESTRATION__SAVE_COMMAND:
        return saveCommand != null;
      case MomotPackage.ANALYSIS_ORCHESTRATION__BOXPLOT_COMMAND:
        return boxplotCommand != null;
      case MomotPackage.ANALYSIS_ORCHESTRATION__PRINT_COMMAND:
        return printCommand != null;
    }
    return super.eIsSet(featureID);
  }

} //AnalysisOrchestrationImpl
