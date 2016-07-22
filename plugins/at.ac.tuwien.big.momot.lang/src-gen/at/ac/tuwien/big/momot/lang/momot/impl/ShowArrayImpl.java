/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.ShowArray;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Show Array</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ShowArrayImpl#isIndividual <em>Individual</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ShowArrayImpl#isAggregate <em>Aggregate</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ShowArrayImpl#isStatisticalSignificance <em>Statistical Significance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShowArrayImpl extends MinimalEObjectImpl.Container implements ShowArray
{
  /**
   * The default value of the '{@link #isIndividual() <em>Individual</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIndividual()
   * @generated
   * @ordered
   */
  protected static final boolean INDIVIDUAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIndividual() <em>Individual</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIndividual()
   * @generated
   * @ordered
   */
  protected boolean individual = INDIVIDUAL_EDEFAULT;

  /**
   * The default value of the '{@link #isAggregate() <em>Aggregate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAggregate()
   * @generated
   * @ordered
   */
  protected static final boolean AGGREGATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAggregate() <em>Aggregate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAggregate()
   * @generated
   * @ordered
   */
  protected boolean aggregate = AGGREGATE_EDEFAULT;

  /**
   * The default value of the '{@link #isStatisticalSignificance() <em>Statistical Significance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatisticalSignificance()
   * @generated
   * @ordered
   */
  protected static final boolean STATISTICAL_SIGNIFICANCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStatisticalSignificance() <em>Statistical Significance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatisticalSignificance()
   * @generated
   * @ordered
   */
  protected boolean statisticalSignificance = STATISTICAL_SIGNIFICANCE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ShowArrayImpl()
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
    return MomotPackage.Literals.SHOW_ARRAY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIndividual()
  {
    return individual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndividual(boolean newIndividual)
  {
    boolean oldIndividual = individual;
    individual = newIndividual;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SHOW_ARRAY__INDIVIDUAL, oldIndividual, individual));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAggregate()
  {
    return aggregate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAggregate(boolean newAggregate)
  {
    boolean oldAggregate = aggregate;
    aggregate = newAggregate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SHOW_ARRAY__AGGREGATE, oldAggregate, aggregate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStatisticalSignificance()
  {
    return statisticalSignificance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatisticalSignificance(boolean newStatisticalSignificance)
  {
    boolean oldStatisticalSignificance = statisticalSignificance;
    statisticalSignificance = newStatisticalSignificance;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SHOW_ARRAY__STATISTICAL_SIGNIFICANCE, oldStatisticalSignificance, statisticalSignificance));
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
      case MomotPackage.SHOW_ARRAY__INDIVIDUAL:
        return isIndividual();
      case MomotPackage.SHOW_ARRAY__AGGREGATE:
        return isAggregate();
      case MomotPackage.SHOW_ARRAY__STATISTICAL_SIGNIFICANCE:
        return isStatisticalSignificance();
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
      case MomotPackage.SHOW_ARRAY__INDIVIDUAL:
        setIndividual((Boolean)newValue);
        return;
      case MomotPackage.SHOW_ARRAY__AGGREGATE:
        setAggregate((Boolean)newValue);
        return;
      case MomotPackage.SHOW_ARRAY__STATISTICAL_SIGNIFICANCE:
        setStatisticalSignificance((Boolean)newValue);
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
      case MomotPackage.SHOW_ARRAY__INDIVIDUAL:
        setIndividual(INDIVIDUAL_EDEFAULT);
        return;
      case MomotPackage.SHOW_ARRAY__AGGREGATE:
        setAggregate(AGGREGATE_EDEFAULT);
        return;
      case MomotPackage.SHOW_ARRAY__STATISTICAL_SIGNIFICANCE:
        setStatisticalSignificance(STATISTICAL_SIGNIFICANCE_EDEFAULT);
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
      case MomotPackage.SHOW_ARRAY__INDIVIDUAL:
        return individual != INDIVIDUAL_EDEFAULT;
      case MomotPackage.SHOW_ARRAY__AGGREGATE:
        return aggregate != AGGREGATE_EDEFAULT;
      case MomotPackage.SHOW_ARRAY__STATISTICAL_SIGNIFICANCE:
        return statisticalSignificance != STATISTICAL_SIGNIFICANCE_EDEFAULT;
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
    result.append(" (individual: ");
    result.append(individual);
    result.append(", aggregate: ");
    result.append(aggregate);
    result.append(", statisticalSignificance: ");
    result.append(statisticalSignificance);
    result.append(')');
    return result.toString();
  }

} //ShowArrayImpl
