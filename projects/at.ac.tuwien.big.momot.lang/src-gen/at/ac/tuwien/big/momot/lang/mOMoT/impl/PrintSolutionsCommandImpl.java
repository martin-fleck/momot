/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.impl;

import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences;
import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage;
import at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Print Solutions Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.PrintSolutionsCommandImpl#getAlgorithms <em>Algorithms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrintSolutionsCommandImpl extends MinimalEObjectImpl.Container implements PrintSolutionsCommand
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrintSolutionsCommandImpl()
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
    return MOMoTPackage.Literals.PRINT_SOLUTIONS_COMMAND;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS, oldAlgorithms, newAlgorithms);
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
        msgs = ((InternalEObject)algorithms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS, null, msgs);
      if (newAlgorithms != null)
        msgs = ((InternalEObject)newAlgorithms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS, null, msgs);
      msgs = basicSetAlgorithms(newAlgorithms, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS, newAlgorithms, newAlgorithms));
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
      case MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS:
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
      case MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS:
        return getAlgorithms();
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
      case MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS:
        setAlgorithms((AlgorithmReferences)newValue);
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
      case MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS:
        setAlgorithms((AlgorithmReferences)null);
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
      case MOMoTPackage.PRINT_SOLUTIONS_COMMAND__ALGORITHMS:
        return algorithms != null;
    }
    return super.eIsSet(featureID);
  }

} //PrintSolutionsCommandImpl
