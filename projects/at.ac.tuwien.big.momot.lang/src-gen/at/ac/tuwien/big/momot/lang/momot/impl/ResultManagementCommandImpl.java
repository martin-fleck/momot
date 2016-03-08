/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Management Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl#getNeighborhoodSize <em>Neighborhood Size</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl#isMaxNeighborhoodSize <em>Max Neighborhood Size</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ResultManagementCommandImpl#isPrintOutput <em>Print Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultManagementCommandImpl extends MinimalEObjectImpl.Container implements ResultManagementCommand
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
   * The default value of the '{@link #getNeighborhoodSize() <em>Neighborhood Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNeighborhoodSize()
   * @generated
   * @ordered
   */
  protected static final int NEIGHBORHOOD_SIZE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNeighborhoodSize() <em>Neighborhood Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNeighborhoodSize()
   * @generated
   * @ordered
   */
  protected int neighborhoodSize = NEIGHBORHOOD_SIZE_EDEFAULT;

  /**
   * The default value of the '{@link #isMaxNeighborhoodSize() <em>Max Neighborhood Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMaxNeighborhoodSize()
   * @generated
   * @ordered
   */
  protected static final boolean MAX_NEIGHBORHOOD_SIZE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMaxNeighborhoodSize() <em>Max Neighborhood Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMaxNeighborhoodSize()
   * @generated
   * @ordered
   */
  protected boolean maxNeighborhoodSize = MAX_NEIGHBORHOOD_SIZE_EDEFAULT;

  /**
   * The default value of the '{@link #isPrintOutput() <em>Print Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrintOutput()
   * @generated
   * @ordered
   */
  protected static final boolean PRINT_OUTPUT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPrintOutput() <em>Print Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrintOutput()
   * @generated
   * @ordered
   */
  protected boolean printOutput = PRINT_OUTPUT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResultManagementCommandImpl()
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
    return MomotPackage.Literals.RESULT_MANAGEMENT_COMMAND;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS, oldAlgorithms, newAlgorithms);
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
        msgs = ((InternalEObject)algorithms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS, null, msgs);
      if (newAlgorithms != null)
        msgs = ((InternalEObject)newAlgorithms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS, null, msgs);
      msgs = basicSetAlgorithms(newAlgorithms, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS, newAlgorithms, newAlgorithms));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNeighborhoodSize()
  {
    return neighborhoodSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNeighborhoodSize(int newNeighborhoodSize)
  {
    int oldNeighborhoodSize = neighborhoodSize;
    neighborhoodSize = newNeighborhoodSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE, oldNeighborhoodSize, neighborhoodSize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMaxNeighborhoodSize()
  {
    return maxNeighborhoodSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxNeighborhoodSize(boolean newMaxNeighborhoodSize)
  {
    boolean oldMaxNeighborhoodSize = maxNeighborhoodSize;
    maxNeighborhoodSize = newMaxNeighborhoodSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE, oldMaxNeighborhoodSize, maxNeighborhoodSize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPrintOutput()
  {
    return printOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrintOutput(boolean newPrintOutput)
  {
    boolean oldPrintOutput = printOutput;
    printOutput = newPrintOutput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT, oldPrintOutput, printOutput));
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
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS:
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
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS:
        return getAlgorithms();
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE:
        return getNeighborhoodSize();
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE:
        return isMaxNeighborhoodSize();
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT:
        return isPrintOutput();
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
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS:
        setAlgorithms((AlgorithmReferences)newValue);
        return;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE:
        setNeighborhoodSize((Integer)newValue);
        return;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE:
        setMaxNeighborhoodSize((Boolean)newValue);
        return;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT:
        setPrintOutput((Boolean)newValue);
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
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS:
        setAlgorithms((AlgorithmReferences)null);
        return;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE:
        setNeighborhoodSize(NEIGHBORHOOD_SIZE_EDEFAULT);
        return;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE:
        setMaxNeighborhoodSize(MAX_NEIGHBORHOOD_SIZE_EDEFAULT);
        return;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT:
        setPrintOutput(PRINT_OUTPUT_EDEFAULT);
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
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__ALGORITHMS:
        return algorithms != null;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__NEIGHBORHOOD_SIZE:
        return neighborhoodSize != NEIGHBORHOOD_SIZE_EDEFAULT;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__MAX_NEIGHBORHOOD_SIZE:
        return maxNeighborhoodSize != MAX_NEIGHBORHOOD_SIZE_EDEFAULT;
      case MomotPackage.RESULT_MANAGEMENT_COMMAND__PRINT_OUTPUT:
        return printOutput != PRINT_OUTPUT_EDEFAULT;
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
    result.append(" (neighborhoodSize: ");
    result.append(neighborhoodSize);
    result.append(", maxNeighborhoodSize: ");
    result.append(maxNeighborhoodSize);
    result.append(", printOutput: ");
    result.append(printOutput);
    result.append(')');
    return result.toString();
  }

} //ResultManagementCommandImpl
