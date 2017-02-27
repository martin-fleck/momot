/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.AnalysisGroupList;
import at.ac.tuwien.big.momot.lang.momot.AnalysisGroupSpecification;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Group List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.AnalysisGroupListImpl#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalysisGroupListImpl extends MinimalEObjectImpl.Container implements AnalysisGroupList
{
  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected EList<AnalysisGroupSpecification> group;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnalysisGroupListImpl()
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
    return MomotPackage.Literals.ANALYSIS_GROUP_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AnalysisGroupSpecification> getGroup()
  {
    if (group == null)
    {
      group = new EObjectContainmentEList<AnalysisGroupSpecification>(AnalysisGroupSpecification.class, this, MomotPackage.ANALYSIS_GROUP_LIST__GROUP);
    }
    return group;
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
      case MomotPackage.ANALYSIS_GROUP_LIST__GROUP:
        return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
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
      case MomotPackage.ANALYSIS_GROUP_LIST__GROUP:
        return getGroup();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MomotPackage.ANALYSIS_GROUP_LIST__GROUP:
        getGroup().clear();
        getGroup().addAll((Collection<? extends AnalysisGroupSpecification>)newValue);
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
      case MomotPackage.ANALYSIS_GROUP_LIST__GROUP:
        getGroup().clear();
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
      case MomotPackage.ANALYSIS_GROUP_LIST__GROUP:
        return group != null && !group.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AnalysisGroupListImpl
