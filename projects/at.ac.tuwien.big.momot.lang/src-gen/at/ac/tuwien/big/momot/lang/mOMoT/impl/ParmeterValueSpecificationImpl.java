/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.impl;

import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage;
import at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parmeter Value Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ParmeterValueSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.ParmeterValueSpecificationImpl#getCall <em>Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParmeterValueSpecificationImpl extends MinimalEObjectImpl.Container implements ParmeterValueSpecification
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected XExpression name;

  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected XExpression call;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParmeterValueSpecificationImpl()
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
    return MOMoTPackage.Literals.PARMETER_VALUE_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(XExpression newName, NotificationChain msgs)
  {
    XExpression oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(XExpression newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getCall()
  {
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCall(XExpression newCall, NotificationChain msgs)
  {
    XExpression oldCall = call;
    call = newCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL, oldCall, newCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall(XExpression newCall)
  {
    if (newCall != call)
    {
      NotificationChain msgs = null;
      if (call != null)
        msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL, null, msgs);
      if (newCall != null)
        msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL, null, msgs);
      msgs = basicSetCall(newCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL, newCall, newCall));
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
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME:
        return basicSetName(null, msgs);
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL:
        return basicSetCall(null, msgs);
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
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME:
        return getName();
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL:
        return getCall();
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
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME:
        setName((XExpression)newValue);
        return;
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL:
        setCall((XExpression)newValue);
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
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME:
        setName((XExpression)null);
        return;
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL:
        setCall((XExpression)null);
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
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__NAME:
        return name != null;
      case MOMoTPackage.PARMETER_VALUE_SPECIFICATION__CALL:
        return call != null;
    }
    return super.eIsSet(featureID);
  }

} //ParmeterValueSpecificationImpl
