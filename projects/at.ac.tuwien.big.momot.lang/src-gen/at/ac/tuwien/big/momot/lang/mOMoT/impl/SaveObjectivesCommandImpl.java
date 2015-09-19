/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.impl;

import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences;
import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage;
import at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Save Objectives Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveObjectivesCommandImpl#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SaveObjectivesCommandImpl#getFile <em>File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SaveObjectivesCommandImpl extends MinimalEObjectImpl.Container implements SaveObjectivesCommand
{
  /**
   * The cached value of the '{@link #getAlgorithms() <em>Algorithms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlgorithms()
   * @generated
   * @ordered
   */
  protected AlgorithmReferences algorithms;

  /**
   * The default value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected static final String FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected String file = FILE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SaveObjectivesCommandImpl()
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
    return MOMoTPackage.Literals.SAVE_OBJECTIVES_COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlgorithmReferences getAlgorithms()
  {
    return algorithms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlgorithms(AlgorithmReferences newAlgorithms, NotificationChain msgs)
  {
    AlgorithmReferences oldAlgorithms = algorithms;
    algorithms = newAlgorithms;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS, oldAlgorithms, newAlgorithms);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlgorithms(AlgorithmReferences newAlgorithms)
  {
    if (newAlgorithms != algorithms)
    {
      NotificationChain msgs = null;
      if (algorithms != null)
        msgs = ((InternalEObject)algorithms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS, null, msgs);
      if (newAlgorithms != null)
        msgs = ((InternalEObject)newAlgorithms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS, null, msgs);
      msgs = basicSetAlgorithms(newAlgorithms, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS, newAlgorithms, newAlgorithms));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFile()
  {
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFile(String newFile)
  {
    String oldFile = file;
    file = newFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SAVE_OBJECTIVES_COMMAND__FILE, oldFile, file));
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
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS:
        return basicSetAlgorithms(null, msgs);
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
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS:
        return getAlgorithms();
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__FILE:
        return getFile();
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
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS:
        setAlgorithms((AlgorithmReferences)newValue);
        return;
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__FILE:
        setFile((String)newValue);
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
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS:
        setAlgorithms((AlgorithmReferences)null);
        return;
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__FILE:
        setFile(FILE_EDEFAULT);
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
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__ALGORITHMS:
        return algorithms != null;
      case MOMoTPackage.SAVE_OBJECTIVES_COMMAND__FILE:
        return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (file: ");
    result.append(file);
    result.append(')');
    return result.toString();
  }

} //SaveObjectivesCommandImpl
