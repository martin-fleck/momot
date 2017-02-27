/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.ModelsCommand;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Models Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ModelsCommandImpl#getDirectory <em>Directory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelsCommandImpl extends ResultManagementCommandImpl implements ModelsCommand
{
  /**
   * The default value of the '{@link #getDirectory() <em>Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirectory()
   * @generated
   * @ordered
   */
  protected static final String DIRECTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDirectory() <em>Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirectory()
   * @generated
   * @ordered
   */
  protected String directory = DIRECTORY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelsCommandImpl()
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
    return MomotPackage.Literals.MODELS_COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDirectory()
  {
    return directory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirectory(String newDirectory)
  {
    String oldDirectory = directory;
    directory = newDirectory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MODELS_COMMAND__DIRECTORY, oldDirectory, directory));
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
      case MomotPackage.MODELS_COMMAND__DIRECTORY:
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
      case MomotPackage.MODELS_COMMAND__DIRECTORY:
        setDirectory((String)newValue);
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
      case MomotPackage.MODELS_COMMAND__DIRECTORY:
        setDirectory(DIRECTORY_EDEFAULT);
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
      case MomotPackage.MODELS_COMMAND__DIRECTORY:
        return DIRECTORY_EDEFAULT == null ? directory != null : !DIRECTORY_EDEFAULT.equals(directory);
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
    result.append(" (directory: ");
    result.append(directory);
    result.append(')');
    return result.toString();
  }

} //ModelsCommandImpl
