/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XListLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Orchestration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getModules <em>Modules</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getUnitsToRemove <em>Units To Remove</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getNonSolutionParameters <em>Non Solution Parameters</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getParameterValues <em>Parameter Values</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getModuleOrchestration()
 * @model
 * @generated
 */
public interface ModuleOrchestration extends EObject
{
  /**
   * Returns the value of the '<em><b>Modules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' containment reference.
   * @see #setModules(XListLiteral)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getModuleOrchestration_Modules()
   * @model containment="true"
   * @generated
   */
  XListLiteral getModules();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getModules <em>Modules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modules</em>' containment reference.
   * @see #getModules()
   * @generated
   */
  void setModules(XListLiteral value);

  /**
   * Returns the value of the '<em><b>Units To Remove</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Units To Remove</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Units To Remove</em>' containment reference.
   * @see #setUnitsToRemove(XListLiteral)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getModuleOrchestration_UnitsToRemove()
   * @model containment="true"
   * @generated
   */
  XListLiteral getUnitsToRemove();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getUnitsToRemove <em>Units To Remove</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Units To Remove</em>' containment reference.
   * @see #getUnitsToRemove()
   * @generated
   */
  void setUnitsToRemove(XListLiteral value);

  /**
   * Returns the value of the '<em><b>Non Solution Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Non Solution Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Non Solution Parameters</em>' containment reference.
   * @see #setNonSolutionParameters(XListLiteral)
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getModuleOrchestration_NonSolutionParameters()
   * @model containment="true"
   * @generated
   */
  XListLiteral getNonSolutionParameters();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration#getNonSolutionParameters <em>Non Solution Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Non Solution Parameters</em>' containment reference.
   * @see #getNonSolutionParameters()
   * @generated
   */
  void setNonSolutionParameters(XListLiteral value);

  /**
   * Returns the value of the '<em><b>Parameter Values</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Values</em>' containment reference list.
   * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getModuleOrchestration_ParameterValues()
   * @model containment="true"
   * @generated
   */
  EList<ParmeterValueSpecification> getParameterValues();

} // ModuleOrchestration
