/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification;

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

import org.eclipse.xtext.xbase.XListLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module Orchestration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl#getUnitsToRemove <em>Units To Remove</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl#getNonSolutionParameters <em>Non Solution Parameters</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ModuleOrchestrationImpl#getParameterValues <em>Parameter Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleOrchestrationImpl extends MinimalEObjectImpl.Container implements ModuleOrchestration
{
  /**
   * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModules()
   * @generated
   * @ordered
   */
  protected XListLiteral modules;

  /**
   * The cached value of the '{@link #getUnitsToRemove() <em>Units To Remove</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnitsToRemove()
   * @generated
   * @ordered
   */
  protected XListLiteral unitsToRemove;

  /**
   * The cached value of the '{@link #getNonSolutionParameters() <em>Non Solution Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonSolutionParameters()
   * @generated
   * @ordered
   */
  protected XListLiteral nonSolutionParameters;

  /**
   * The cached value of the '{@link #getParameterValues() <em>Parameter Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterValues()
   * @generated
   * @ordered
   */
  protected EList<ParmeterValueSpecification> parameterValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModuleOrchestrationImpl()
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
    return MomotPackage.Literals.MODULE_ORCHESTRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XListLiteral getModules()
  {
    return modules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModules(XListLiteral newModules, NotificationChain msgs)
  {
    XListLiteral oldModules = modules;
    modules = newModules;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MODULE_ORCHESTRATION__MODULES, oldModules, newModules);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModules(XListLiteral newModules)
  {
    if (newModules != modules)
    {
      NotificationChain msgs = null;
      if (modules != null)
        msgs = ((InternalEObject)modules).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MODULE_ORCHESTRATION__MODULES, null, msgs);
      if (newModules != null)
        msgs = ((InternalEObject)newModules).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MODULE_ORCHESTRATION__MODULES, null, msgs);
      msgs = basicSetModules(newModules, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MODULE_ORCHESTRATION__MODULES, newModules, newModules));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XListLiteral getUnitsToRemove()
  {
    return unitsToRemove;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnitsToRemove(XListLiteral newUnitsToRemove, NotificationChain msgs)
  {
    XListLiteral oldUnitsToRemove = unitsToRemove;
    unitsToRemove = newUnitsToRemove;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE, oldUnitsToRemove, newUnitsToRemove);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnitsToRemove(XListLiteral newUnitsToRemove)
  {
    if (newUnitsToRemove != unitsToRemove)
    {
      NotificationChain msgs = null;
      if (unitsToRemove != null)
        msgs = ((InternalEObject)unitsToRemove).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE, null, msgs);
      if (newUnitsToRemove != null)
        msgs = ((InternalEObject)newUnitsToRemove).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE, null, msgs);
      msgs = basicSetUnitsToRemove(newUnitsToRemove, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE, newUnitsToRemove, newUnitsToRemove));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XListLiteral getNonSolutionParameters()
  {
    return nonSolutionParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNonSolutionParameters(XListLiteral newNonSolutionParameters, NotificationChain msgs)
  {
    XListLiteral oldNonSolutionParameters = nonSolutionParameters;
    nonSolutionParameters = newNonSolutionParameters;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS, oldNonSolutionParameters, newNonSolutionParameters);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonSolutionParameters(XListLiteral newNonSolutionParameters)
  {
    if (newNonSolutionParameters != nonSolutionParameters)
    {
      NotificationChain msgs = null;
      if (nonSolutionParameters != null)
        msgs = ((InternalEObject)nonSolutionParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS, null, msgs);
      if (newNonSolutionParameters != null)
        msgs = ((InternalEObject)newNonSolutionParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS, null, msgs);
      msgs = basicSetNonSolutionParameters(newNonSolutionParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS, newNonSolutionParameters, newNonSolutionParameters));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParmeterValueSpecification> getParameterValues()
  {
    if (parameterValues == null)
    {
      parameterValues = new EObjectContainmentEList<ParmeterValueSpecification>(ParmeterValueSpecification.class, this, MomotPackage.MODULE_ORCHESTRATION__PARAMETER_VALUES);
    }
    return parameterValues;
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
      case MomotPackage.MODULE_ORCHESTRATION__MODULES:
        return basicSetModules(null, msgs);
      case MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE:
        return basicSetUnitsToRemove(null, msgs);
      case MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS:
        return basicSetNonSolutionParameters(null, msgs);
      case MomotPackage.MODULE_ORCHESTRATION__PARAMETER_VALUES:
        return ((InternalEList<?>)getParameterValues()).basicRemove(otherEnd, msgs);
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
      case MomotPackage.MODULE_ORCHESTRATION__MODULES:
        return getModules();
      case MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE:
        return getUnitsToRemove();
      case MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS:
        return getNonSolutionParameters();
      case MomotPackage.MODULE_ORCHESTRATION__PARAMETER_VALUES:
        return getParameterValues();
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
      case MomotPackage.MODULE_ORCHESTRATION__MODULES:
        setModules((XListLiteral)newValue);
        return;
      case MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE:
        setUnitsToRemove((XListLiteral)newValue);
        return;
      case MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS:
        setNonSolutionParameters((XListLiteral)newValue);
        return;
      case MomotPackage.MODULE_ORCHESTRATION__PARAMETER_VALUES:
        getParameterValues().clear();
        getParameterValues().addAll((Collection<? extends ParmeterValueSpecification>)newValue);
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
      case MomotPackage.MODULE_ORCHESTRATION__MODULES:
        setModules((XListLiteral)null);
        return;
      case MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE:
        setUnitsToRemove((XListLiteral)null);
        return;
      case MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS:
        setNonSolutionParameters((XListLiteral)null);
        return;
      case MomotPackage.MODULE_ORCHESTRATION__PARAMETER_VALUES:
        getParameterValues().clear();
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
      case MomotPackage.MODULE_ORCHESTRATION__MODULES:
        return modules != null;
      case MomotPackage.MODULE_ORCHESTRATION__UNITS_TO_REMOVE:
        return unitsToRemove != null;
      case MomotPackage.MODULE_ORCHESTRATION__NON_SOLUTION_PARAMETERS:
        return nonSolutionParameters != null;
      case MomotPackage.MODULE_ORCHESTRATION__PARAMETER_VALUES:
        return parameterValues != null && !parameterValues.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModuleOrchestrationImpl
