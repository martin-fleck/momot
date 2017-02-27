/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.BoxplotCommand;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boxplot Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.BoxplotCommandImpl#getDirectory <em>Directory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoxplotCommandImpl extends AnalysisCommandImpl implements BoxplotCommand
{
  /**
   * The cached value of the '{@link #getDirectory() <em>Directory</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirectory()
   * @generated
   * @ordered
   */
  protected XExpression directory;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BoxplotCommandImpl()
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
    return MomotPackage.Literals.BOXPLOT_COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getDirectory()
  {
    return directory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDirectory(XExpression newDirectory, NotificationChain msgs)
  {
    XExpression oldDirectory = directory;
    directory = newDirectory;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.BOXPLOT_COMMAND__DIRECTORY, oldDirectory, newDirectory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirectory(XExpression newDirectory)
  {
    if (newDirectory != directory)
    {
      NotificationChain msgs = null;
      if (directory != null)
        msgs = ((InternalEObject)directory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.BOXPLOT_COMMAND__DIRECTORY, null, msgs);
      if (newDirectory != null)
        msgs = ((InternalEObject)newDirectory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.BOXPLOT_COMMAND__DIRECTORY, null, msgs);
      msgs = basicSetDirectory(newDirectory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.BOXPLOT_COMMAND__DIRECTORY, newDirectory, newDirectory));
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
      case MomotPackage.BOXPLOT_COMMAND__DIRECTORY:
        return basicSetDirectory(null, msgs);
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
      case MomotPackage.BOXPLOT_COMMAND__DIRECTORY:
        return getDirectory();
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
      case MomotPackage.BOXPLOT_COMMAND__DIRECTORY:
        setDirectory((XExpression)newValue);
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
      case MomotPackage.BOXPLOT_COMMAND__DIRECTORY:
        setDirectory((XExpression)null);
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
      case MomotPackage.BOXPLOT_COMMAND__DIRECTORY:
        return directory != null;
    }
    return super.eIsSet(featureID);
  }

} //BoxplotCommandImpl
