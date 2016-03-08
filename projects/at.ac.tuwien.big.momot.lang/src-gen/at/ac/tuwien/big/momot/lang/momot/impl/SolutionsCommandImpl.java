/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.SolutionsCommand;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solutions Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SolutionsCommandImpl#getFile <em>File</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SolutionsCommandImpl#getDirectory <em>Directory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionsCommandImpl extends ResultManagementCommandImpl implements SolutionsCommand
{
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
  protected SolutionsCommandImpl()
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
    return MomotPackage.Literals.SOLUTIONS_COMMAND;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SOLUTIONS_COMMAND__FILE, oldFile, file));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SOLUTIONS_COMMAND__DIRECTORY, oldDirectory, directory));
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
      case MomotPackage.SOLUTIONS_COMMAND__FILE:
        return getFile();
      case MomotPackage.SOLUTIONS_COMMAND__DIRECTORY:
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
      case MomotPackage.SOLUTIONS_COMMAND__FILE:
        setFile((String)newValue);
        return;
      case MomotPackage.SOLUTIONS_COMMAND__DIRECTORY:
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
      case MomotPackage.SOLUTIONS_COMMAND__FILE:
        setFile(FILE_EDEFAULT);
        return;
      case MomotPackage.SOLUTIONS_COMMAND__DIRECTORY:
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
      case MomotPackage.SOLUTIONS_COMMAND__FILE:
        return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
      case MomotPackage.SOLUTIONS_COMMAND__DIRECTORY:
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
    result.append(" (file: ");
    result.append(file);
    result.append(", directory: ");
    result.append(directory);
    result.append(')');
    return result.toString();
  }

} //SolutionsCommandImpl
