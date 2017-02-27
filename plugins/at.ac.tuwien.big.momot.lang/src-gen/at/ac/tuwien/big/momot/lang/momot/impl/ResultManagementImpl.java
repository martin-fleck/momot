/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.ResultManagement;
import at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand;

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
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementImpl#getAdaptModels <em>Adapt Models</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultManagementImpl extends MinimalEObjectImpl.Container implements ResultManagement
{
  /**
   * The cached value of the '{@link #getAdaptModels() <em>Adapt Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdaptModels()
   * @generated
   * @ordered
   */
  protected XExpression adaptModels;

  /**
   * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommands()
   * @generated
   * @ordered
   */
  protected EList<ResultManagementCommand> commands;

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
    return MomotPackage.Literals.RESULT_MANAGEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getAdaptModels()
  {
    return adaptModels;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAdaptModels(XExpression newAdaptModels, NotificationChain msgs)
  {
    XExpression oldAdaptModels = adaptModels;
    adaptModels = newAdaptModels;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS, oldAdaptModels, newAdaptModels);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdaptModels(XExpression newAdaptModels)
  {
    if (newAdaptModels != adaptModels)
    {
      NotificationChain msgs = null;
      if (adaptModels != null)
        msgs = ((InternalEObject)adaptModels).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS, null, msgs);
      if (newAdaptModels != null)
        msgs = ((InternalEObject)newAdaptModels).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS, null, msgs);
      msgs = basicSetAdaptModels(newAdaptModels, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS, newAdaptModels, newAdaptModels));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultManagementCommand> getCommands()
  {
    if (commands == null)
    {
      commands = new EObjectContainmentEList<ResultManagementCommand>(ResultManagementCommand.class, this, MomotPackage.RESULT_MANAGEMENT__COMMANDS);
    }
    return commands;
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
      case MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS:
        return basicSetAdaptModels(null, msgs);
      case MomotPackage.RESULT_MANAGEMENT__COMMANDS:
        return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
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
      case MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS:
        return getAdaptModels();
      case MomotPackage.RESULT_MANAGEMENT__COMMANDS:
        return getCommands();
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
      case MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS:
        setAdaptModels((XExpression)newValue);
        return;
      case MomotPackage.RESULT_MANAGEMENT__COMMANDS:
        getCommands().clear();
        getCommands().addAll((Collection<? extends ResultManagementCommand>)newValue);
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
      case MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS:
        setAdaptModels((XExpression)null);
        return;
      case MomotPackage.RESULT_MANAGEMENT__COMMANDS:
        getCommands().clear();
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
      case MomotPackage.RESULT_MANAGEMENT__ADAPT_MODELS:
        return adaptModels != null;
      case MomotPackage.RESULT_MANAGEMENT__COMMANDS:
        return commands != null && !commands.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ResultManagementImpl
