/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.InputModel;
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
 * An implementation of the model object '<em><b>Input Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.InputModelImpl#getPath <em>Path</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.InputModelImpl#getAdaptation <em>Adaptation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputModelImpl extends MinimalEObjectImpl.Container implements InputModel
{
  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected XExpression path;

  /**
   * The cached value of the '{@link #getAdaptation() <em>Adaptation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdaptation()
   * @generated
   * @ordered
   */
  protected XExpression adaptation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InputModelImpl()
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
    return MomotPackage.Literals.INPUT_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getPath()
  {
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPath(XExpression newPath, NotificationChain msgs)
  {
    XExpression oldPath = path;
    path = newPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.INPUT_MODEL__PATH, oldPath, newPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPath(XExpression newPath)
  {
    if (newPath != path)
    {
      NotificationChain msgs = null;
      if (path != null)
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.INPUT_MODEL__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.INPUT_MODEL__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INPUT_MODEL__PATH, newPath, newPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getAdaptation()
  {
    return adaptation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAdaptation(XExpression newAdaptation, NotificationChain msgs)
  {
    XExpression oldAdaptation = adaptation;
    adaptation = newAdaptation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.INPUT_MODEL__ADAPTATION, oldAdaptation, newAdaptation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdaptation(XExpression newAdaptation)
  {
    if (newAdaptation != adaptation)
    {
      NotificationChain msgs = null;
      if (adaptation != null)
        msgs = ((InternalEObject)adaptation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.INPUT_MODEL__ADAPTATION, null, msgs);
      if (newAdaptation != null)
        msgs = ((InternalEObject)newAdaptation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.INPUT_MODEL__ADAPTATION, null, msgs);
      msgs = basicSetAdaptation(newAdaptation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INPUT_MODEL__ADAPTATION, newAdaptation, newAdaptation));
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
      case MomotPackage.INPUT_MODEL__PATH:
        return basicSetPath(null, msgs);
      case MomotPackage.INPUT_MODEL__ADAPTATION:
        return basicSetAdaptation(null, msgs);
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
      case MomotPackage.INPUT_MODEL__PATH:
        return getPath();
      case MomotPackage.INPUT_MODEL__ADAPTATION:
        return getAdaptation();
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
      case MomotPackage.INPUT_MODEL__PATH:
        setPath((XExpression)newValue);
        return;
      case MomotPackage.INPUT_MODEL__ADAPTATION:
        setAdaptation((XExpression)newValue);
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
      case MomotPackage.INPUT_MODEL__PATH:
        setPath((XExpression)null);
        return;
      case MomotPackage.INPUT_MODEL__ADAPTATION:
        setAdaptation((XExpression)null);
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
      case MomotPackage.INPUT_MODEL__PATH:
        return path != null;
      case MomotPackage.INPUT_MODEL__ADAPTATION:
        return adaptation != null;
    }
    return super.eIsSet(featureID);
  }

} //InputModelImpl
