/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.EqualityHelper;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equality Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.EqualityHelperImpl#getCall <em>Call</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.EqualityHelperImpl#getMethod <em>Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EqualityHelperImpl extends MinimalEObjectImpl.Container implements EqualityHelper
{
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
   * The cached value of the '{@link #getMethod() <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected XExpression method;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EqualityHelperImpl()
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
    return MomotPackage.Literals.EQUALITY_HELPER;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.EQUALITY_HELPER__CALL, oldCall, newCall);
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
        msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EQUALITY_HELPER__CALL, null, msgs);
      if (newCall != null)
        msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EQUALITY_HELPER__CALL, null, msgs);
      msgs = basicSetCall(newCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.EQUALITY_HELPER__CALL, newCall, newCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMethod(XExpression newMethod, NotificationChain msgs)
  {
    XExpression oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.EQUALITY_HELPER__METHOD, oldMethod, newMethod);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethod(XExpression newMethod)
  {
    if (newMethod != method)
    {
      NotificationChain msgs = null;
      if (method != null)
        msgs = ((InternalEObject)method).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EQUALITY_HELPER__METHOD, null, msgs);
      if (newMethod != null)
        msgs = ((InternalEObject)newMethod).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EQUALITY_HELPER__METHOD, null, msgs);
      msgs = basicSetMethod(newMethod, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.EQUALITY_HELPER__METHOD, newMethod, newMethod));
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
      case MomotPackage.EQUALITY_HELPER__CALL:
        return basicSetCall(null, msgs);
      case MomotPackage.EQUALITY_HELPER__METHOD:
        return basicSetMethod(null, msgs);
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
      case MomotPackage.EQUALITY_HELPER__CALL:
        return getCall();
      case MomotPackage.EQUALITY_HELPER__METHOD:
        return getMethod();
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
      case MomotPackage.EQUALITY_HELPER__CALL:
        setCall((XExpression)newValue);
        return;
      case MomotPackage.EQUALITY_HELPER__METHOD:
        setMethod((XExpression)newValue);
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
      case MomotPackage.EQUALITY_HELPER__CALL:
        setCall((XExpression)null);
        return;
      case MomotPackage.EQUALITY_HELPER__METHOD:
        setMethod((XExpression)null);
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
      case MomotPackage.EQUALITY_HELPER__CALL:
        return call != null;
      case MomotPackage.EQUALITY_HELPER__METHOD:
        return method != null;
    }
    return super.eIsSet(featureID);
  }

} //EqualityHelperImpl
