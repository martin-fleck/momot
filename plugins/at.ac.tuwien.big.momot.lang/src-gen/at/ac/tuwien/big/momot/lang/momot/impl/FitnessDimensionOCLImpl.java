/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.DefExpression;
import at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fitness Dimension OCL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionOCLImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessDimensionOCLImpl#getDefExpressions <em>Def Expressions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FitnessDimensionOCLImpl extends FitnessDimensionSpecificationImpl implements FitnessDimensionOCL
{
  /**
   * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuery()
   * @generated
   * @ordered
   */
  protected XExpression query;

  /**
   * The cached value of the '{@link #getDefExpressions() <em>Def Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefExpressions()
   * @generated
   * @ordered
   */
  protected EList<DefExpression> defExpressions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FitnessDimensionOCLImpl()
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
    return MomotPackage.Literals.FITNESS_DIMENSION_OCL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getQuery()
  {
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuery(XExpression newQuery, NotificationChain msgs)
  {
    XExpression oldQuery = query;
    query = newQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_DIMENSION_OCL__QUERY, oldQuery, newQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuery(XExpression newQuery)
  {
    if (newQuery != query)
    {
      NotificationChain msgs = null;
      if (query != null)
        msgs = ((InternalEObject)query).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_DIMENSION_OCL__QUERY, null, msgs);
      if (newQuery != null)
        msgs = ((InternalEObject)newQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_DIMENSION_OCL__QUERY, null, msgs);
      msgs = basicSetQuery(newQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_DIMENSION_OCL__QUERY, newQuery, newQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefExpression> getDefExpressions()
  {
    if (defExpressions == null)
    {
      defExpressions = new EObjectContainmentEList<DefExpression>(DefExpression.class, this, MomotPackage.FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS);
    }
    return defExpressions;
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
      case MomotPackage.FITNESS_DIMENSION_OCL__QUERY:
        return basicSetQuery(null, msgs);
      case MomotPackage.FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS:
        return ((InternalEList<?>)getDefExpressions()).basicRemove(otherEnd, msgs);
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
      case MomotPackage.FITNESS_DIMENSION_OCL__QUERY:
        return getQuery();
      case MomotPackage.FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS:
        return getDefExpressions();
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
      case MomotPackage.FITNESS_DIMENSION_OCL__QUERY:
        setQuery((XExpression)newValue);
        return;
      case MomotPackage.FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS:
        getDefExpressions().clear();
        getDefExpressions().addAll((Collection<? extends DefExpression>)newValue);
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
      case MomotPackage.FITNESS_DIMENSION_OCL__QUERY:
        setQuery((XExpression)null);
        return;
      case MomotPackage.FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS:
        getDefExpressions().clear();
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
      case MomotPackage.FITNESS_DIMENSION_OCL__QUERY:
        return query != null;
      case MomotPackage.FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS:
        return defExpressions != null && !defExpressions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FitnessDimensionOCLImpl
