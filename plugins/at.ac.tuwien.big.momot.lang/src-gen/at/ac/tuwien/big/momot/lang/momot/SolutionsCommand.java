/**
 */
package at.ac.tuwien.big.momot.lang.momot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solutions Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getFile <em>File</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getDirectory <em>Directory</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getSolutionsCommand()
 * @model
 * @generated
 */
public interface SolutionsCommand extends ResultManagementCommand
{
  /**
   * Returns the value of the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' attribute.
   * @see #setFile(String)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getSolutionsCommand_File()
   * @model
   * @generated
   */
  String getFile();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(String value);

  /**
   * Returns the value of the '<em><b>Directory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Directory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directory</em>' attribute.
   * @see #setDirectory(String)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getSolutionsCommand_Directory()
   * @model
   * @generated
   */
  String getDirectory();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.SolutionsCommand#getDirectory <em>Directory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directory</em>' attribute.
   * @see #getDirectory()
   * @generated
   */
  void setDirectory(String value);

} // SolutionsCommand
