/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.impl;

import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage;
import at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement;
import at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Management</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl#getSaveAnalysis <em>Save Analysis</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl#getSaveObjectives <em>Save Objectives</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl#getSaveSolutions <em>Save Solutions</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl#getPrintObjectives <em>Print Objectives</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl#getPrintSolutions <em>Print Solutions</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ResultManagementImpl#getDoCommand <em>Do Command</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultManagementImpl extends MinimalEObjectImpl.Container implements ResultManagement
{
  /**
   * The cached value of the '{@link #getSaveAnalysis() <em>Save Analysis</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSaveAnalysis()
   * @generated
   * @ordered
   */
  protected SaveAnalysisCommand saveAnalysis;

  /**
   * The cached value of the '{@link #getSaveObjectives() <em>Save Objectives</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSaveObjectives()
   * @generated
   * @ordered
   */
  protected EList<SaveObjectivesCommand> saveObjectives;

  /**
   * The cached value of the '{@link #getSaveSolutions() <em>Save Solutions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSaveSolutions()
   * @generated
   * @ordered
   */
  protected EList<SaveSolutionsCommand> saveSolutions;

  /**
   * The cached value of the '{@link #getPrintObjectives() <em>Print Objectives</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrintObjectives()
   * @generated
   * @ordered
   */
  protected EList<PrintObjectivesCommand> printObjectives;

  /**
   * The cached value of the '{@link #getPrintSolutions() <em>Print Solutions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrintSolutions()
   * @generated
   * @ordered
   */
  protected EList<PrintSolutionsCommand> printSolutions;

  /**
   * The cached value of the '{@link #getDoCommand() <em>Do Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDoCommand()
   * @generated
   * @ordered
   */
  protected XExpression doCommand;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResultManagementImpl()
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
    return MOMoTPackage.Literals.RESULT_MANAGEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SaveAnalysisCommand getSaveAnalysis()
  {
    return saveAnalysis;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSaveAnalysis(SaveAnalysisCommand newSaveAnalysis, NotificationChain msgs)
  {
    SaveAnalysisCommand oldSaveAnalysis = saveAnalysis;
    saveAnalysis = newSaveAnalysis;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS, oldSaveAnalysis, newSaveAnalysis);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaveAnalysis(SaveAnalysisCommand newSaveAnalysis)
  {
    if (newSaveAnalysis != saveAnalysis)
    {
      NotificationChain msgs = null;
      if (saveAnalysis != null)
        msgs = ((InternalEObject)saveAnalysis).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS, null, msgs);
      if (newSaveAnalysis != null)
        msgs = ((InternalEObject)newSaveAnalysis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS, null, msgs);
      msgs = basicSetSaveAnalysis(newSaveAnalysis, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS, newSaveAnalysis, newSaveAnalysis));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SaveObjectivesCommand> getSaveObjectives()
  {
    if (saveObjectives == null)
    {
      saveObjectives = new EObjectContainmentEList<SaveObjectivesCommand>(SaveObjectivesCommand.class, this, MOMoTPackage.RESULT_MANAGEMENT__SAVE_OBJECTIVES);
    }
    return saveObjectives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SaveSolutionsCommand> getSaveSolutions()
  {
    if (saveSolutions == null)
    {
      saveSolutions = new EObjectContainmentEList<SaveSolutionsCommand>(SaveSolutionsCommand.class, this, MOMoTPackage.RESULT_MANAGEMENT__SAVE_SOLUTIONS);
    }
    return saveSolutions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PrintObjectivesCommand> getPrintObjectives()
  {
    if (printObjectives == null)
    {
      printObjectives = new EObjectContainmentEList<PrintObjectivesCommand>(PrintObjectivesCommand.class, this, MOMoTPackage.RESULT_MANAGEMENT__PRINT_OBJECTIVES);
    }
    return printObjectives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PrintSolutionsCommand> getPrintSolutions()
  {
    if (printSolutions == null)
    {
      printSolutions = new EObjectContainmentEList<PrintSolutionsCommand>(PrintSolutionsCommand.class, this, MOMoTPackage.RESULT_MANAGEMENT__PRINT_SOLUTIONS);
    }
    return printSolutions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getDoCommand()
  {
    return doCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDoCommand(XExpression newDoCommand, NotificationChain msgs)
  {
    XExpression oldDoCommand = doCommand;
    doCommand = newDoCommand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND, oldDoCommand, newDoCommand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDoCommand(XExpression newDoCommand)
  {
    if (newDoCommand != doCommand)
    {
      NotificationChain msgs = null;
      if (doCommand != null)
        msgs = ((InternalEObject)doCommand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND, null, msgs);
      if (newDoCommand != null)
        msgs = ((InternalEObject)newDoCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND, null, msgs);
      msgs = basicSetDoCommand(newDoCommand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND, newDoCommand, newDoCommand));
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
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS:
        return basicSetSaveAnalysis(null, msgs);
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_OBJECTIVES:
        return ((InternalEList<?>)getSaveObjectives()).basicRemove(otherEnd, msgs);
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_SOLUTIONS:
        return ((InternalEList<?>)getSaveSolutions()).basicRemove(otherEnd, msgs);
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_OBJECTIVES:
        return ((InternalEList<?>)getPrintObjectives()).basicRemove(otherEnd, msgs);
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_SOLUTIONS:
        return ((InternalEList<?>)getPrintSolutions()).basicRemove(otherEnd, msgs);
      case MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND:
        return basicSetDoCommand(null, msgs);
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
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS:
        return getSaveAnalysis();
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_OBJECTIVES:
        return getSaveObjectives();
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_SOLUTIONS:
        return getSaveSolutions();
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_OBJECTIVES:
        return getPrintObjectives();
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_SOLUTIONS:
        return getPrintSolutions();
      case MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND:
        return getDoCommand();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS:
        setSaveAnalysis((SaveAnalysisCommand)newValue);
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_OBJECTIVES:
        getSaveObjectives().clear();
        getSaveObjectives().addAll((Collection<? extends SaveObjectivesCommand>)newValue);
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_SOLUTIONS:
        getSaveSolutions().clear();
        getSaveSolutions().addAll((Collection<? extends SaveSolutionsCommand>)newValue);
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_OBJECTIVES:
        getPrintObjectives().clear();
        getPrintObjectives().addAll((Collection<? extends PrintObjectivesCommand>)newValue);
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_SOLUTIONS:
        getPrintSolutions().clear();
        getPrintSolutions().addAll((Collection<? extends PrintSolutionsCommand>)newValue);
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND:
        setDoCommand((XExpression)newValue);
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
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS:
        setSaveAnalysis((SaveAnalysisCommand)null);
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_OBJECTIVES:
        getSaveObjectives().clear();
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_SOLUTIONS:
        getSaveSolutions().clear();
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_OBJECTIVES:
        getPrintObjectives().clear();
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_SOLUTIONS:
        getPrintSolutions().clear();
        return;
      case MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND:
        setDoCommand((XExpression)null);
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
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_ANALYSIS:
        return saveAnalysis != null;
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_OBJECTIVES:
        return saveObjectives != null && !saveObjectives.isEmpty();
      case MOMoTPackage.RESULT_MANAGEMENT__SAVE_SOLUTIONS:
        return saveSolutions != null && !saveSolutions.isEmpty();
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_OBJECTIVES:
        return printObjectives != null && !printObjectives.isEmpty();
      case MOMoTPackage.RESULT_MANAGEMENT__PRINT_SOLUTIONS:
        return printSolutions != null && !printSolutions.isEmpty();
      case MOMoTPackage.RESULT_MANAGEMENT__DO_COMMAND:
        return doCommand != null;
    }
    return super.eIsSet(featureID);
  }

} //ResultManagementImpl
