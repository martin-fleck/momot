/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.IndicatorArray;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indicator Array</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isHypervolume <em>Hypervolume</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isGenerationalDistance <em>Generational Distance</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isInvertedGenerationalDistance <em>Inverted Generational Distance</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isSpacing <em>Spacing</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isAdditiveEpsilonIndicator <em>Additive Epsilon Indicator</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isContribution <em>Contribution</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isR1 <em>R1</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isR2 <em>R2</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isR3 <em>R3</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.IndicatorArrayImpl#isMaximumParetoFrontError <em>Maximum Pareto Front Error</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndicatorArrayImpl extends MinimalEObjectImpl.Container implements IndicatorArray
{
  /**
   * The default value of the '{@link #isHypervolume() <em>Hypervolume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHypervolume()
   * @generated
   * @ordered
   */
  protected static final boolean HYPERVOLUME_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHypervolume() <em>Hypervolume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHypervolume()
   * @generated
   * @ordered
   */
  protected boolean hypervolume = HYPERVOLUME_EDEFAULT;

  /**
   * The default value of the '{@link #isGenerationalDistance() <em>Generational Distance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGenerationalDistance()
   * @generated
   * @ordered
   */
  protected static final boolean GENERATIONAL_DISTANCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isGenerationalDistance() <em>Generational Distance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGenerationalDistance()
   * @generated
   * @ordered
   */
  protected boolean generationalDistance = GENERATIONAL_DISTANCE_EDEFAULT;

  /**
   * The default value of the '{@link #isInvertedGenerationalDistance() <em>Inverted Generational Distance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInvertedGenerationalDistance()
   * @generated
   * @ordered
   */
  protected static final boolean INVERTED_GENERATIONAL_DISTANCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInvertedGenerationalDistance() <em>Inverted Generational Distance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInvertedGenerationalDistance()
   * @generated
   * @ordered
   */
  protected boolean invertedGenerationalDistance = INVERTED_GENERATIONAL_DISTANCE_EDEFAULT;

  /**
   * The default value of the '{@link #isSpacing() <em>Spacing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSpacing()
   * @generated
   * @ordered
   */
  protected static final boolean SPACING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSpacing() <em>Spacing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSpacing()
   * @generated
   * @ordered
   */
  protected boolean spacing = SPACING_EDEFAULT;

  /**
   * The default value of the '{@link #isAdditiveEpsilonIndicator() <em>Additive Epsilon Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdditiveEpsilonIndicator()
   * @generated
   * @ordered
   */
  protected static final boolean ADDITIVE_EPSILON_INDICATOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAdditiveEpsilonIndicator() <em>Additive Epsilon Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdditiveEpsilonIndicator()
   * @generated
   * @ordered
   */
  protected boolean additiveEpsilonIndicator = ADDITIVE_EPSILON_INDICATOR_EDEFAULT;

  /**
   * The default value of the '{@link #isContribution() <em>Contribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContribution()
   * @generated
   * @ordered
   */
  protected static final boolean CONTRIBUTION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isContribution() <em>Contribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContribution()
   * @generated
   * @ordered
   */
  protected boolean contribution = CONTRIBUTION_EDEFAULT;

  /**
   * The default value of the '{@link #isR1() <em>R1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isR1()
   * @generated
   * @ordered
   */
  protected static final boolean R1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isR1() <em>R1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isR1()
   * @generated
   * @ordered
   */
  protected boolean r1 = R1_EDEFAULT;

  /**
   * The default value of the '{@link #isR2() <em>R2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isR2()
   * @generated
   * @ordered
   */
  protected static final boolean R2_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isR2() <em>R2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isR2()
   * @generated
   * @ordered
   */
  protected boolean r2 = R2_EDEFAULT;

  /**
   * The default value of the '{@link #isR3() <em>R3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isR3()
   * @generated
   * @ordered
   */
  protected static final boolean R3_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isR3() <em>R3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isR3()
   * @generated
   * @ordered
   */
  protected boolean r3 = R3_EDEFAULT;

  /**
   * The default value of the '{@link #isMaximumParetoFrontError() <em>Maximum Pareto Front Error</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMaximumParetoFrontError()
   * @generated
   * @ordered
   */
  protected static final boolean MAXIMUM_PARETO_FRONT_ERROR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMaximumParetoFrontError() <em>Maximum Pareto Front Error</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMaximumParetoFrontError()
   * @generated
   * @ordered
   */
  protected boolean maximumParetoFrontError = MAXIMUM_PARETO_FRONT_ERROR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndicatorArrayImpl()
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
    return MomotPackage.Literals.INDICATOR_ARRAY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHypervolume()
  {
    return hypervolume;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHypervolume(boolean newHypervolume)
  {
    boolean oldHypervolume = hypervolume;
    hypervolume = newHypervolume;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__HYPERVOLUME, oldHypervolume, hypervolume));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isGenerationalDistance()
  {
    return generationalDistance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenerationalDistance(boolean newGenerationalDistance)
  {
    boolean oldGenerationalDistance = generationalDistance;
    generationalDistance = newGenerationalDistance;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__GENERATIONAL_DISTANCE, oldGenerationalDistance, generationalDistance));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInvertedGenerationalDistance()
  {
    return invertedGenerationalDistance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvertedGenerationalDistance(boolean newInvertedGenerationalDistance)
  {
    boolean oldInvertedGenerationalDistance = invertedGenerationalDistance;
    invertedGenerationalDistance = newInvertedGenerationalDistance;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE, oldInvertedGenerationalDistance, invertedGenerationalDistance));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSpacing()
  {
    return spacing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpacing(boolean newSpacing)
  {
    boolean oldSpacing = spacing;
    spacing = newSpacing;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__SPACING, oldSpacing, spacing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAdditiveEpsilonIndicator()
  {
    return additiveEpsilonIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdditiveEpsilonIndicator(boolean newAdditiveEpsilonIndicator)
  {
    boolean oldAdditiveEpsilonIndicator = additiveEpsilonIndicator;
    additiveEpsilonIndicator = newAdditiveEpsilonIndicator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR, oldAdditiveEpsilonIndicator, additiveEpsilonIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isContribution()
  {
    return contribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContribution(boolean newContribution)
  {
    boolean oldContribution = contribution;
    contribution = newContribution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__CONTRIBUTION, oldContribution, contribution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isR1()
  {
    return r1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setR1(boolean newR1)
  {
    boolean oldR1 = r1;
    r1 = newR1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__R1, oldR1, r1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isR2()
  {
    return r2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setR2(boolean newR2)
  {
    boolean oldR2 = r2;
    r2 = newR2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__R2, oldR2, r2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isR3()
  {
    return r3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setR3(boolean newR3)
  {
    boolean oldR3 = r3;
    r3 = newR3;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__R3, oldR3, r3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMaximumParetoFrontError()
  {
    return maximumParetoFrontError;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaximumParetoFrontError(boolean newMaximumParetoFrontError)
  {
    boolean oldMaximumParetoFrontError = maximumParetoFrontError;
    maximumParetoFrontError = newMaximumParetoFrontError;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR, oldMaximumParetoFrontError, maximumParetoFrontError));
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
      case MomotPackage.INDICATOR_ARRAY__HYPERVOLUME:
        return isHypervolume();
      case MomotPackage.INDICATOR_ARRAY__GENERATIONAL_DISTANCE:
        return isGenerationalDistance();
      case MomotPackage.INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        return isInvertedGenerationalDistance();
      case MomotPackage.INDICATOR_ARRAY__SPACING:
        return isSpacing();
      case MomotPackage.INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        return isAdditiveEpsilonIndicator();
      case MomotPackage.INDICATOR_ARRAY__CONTRIBUTION:
        return isContribution();
      case MomotPackage.INDICATOR_ARRAY__R1:
        return isR1();
      case MomotPackage.INDICATOR_ARRAY__R2:
        return isR2();
      case MomotPackage.INDICATOR_ARRAY__R3:
        return isR3();
      case MomotPackage.INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR:
        return isMaximumParetoFrontError();
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
      case MomotPackage.INDICATOR_ARRAY__HYPERVOLUME:
        setHypervolume((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__GENERATIONAL_DISTANCE:
        setGenerationalDistance((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        setInvertedGenerationalDistance((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__SPACING:
        setSpacing((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        setAdditiveEpsilonIndicator((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__CONTRIBUTION:
        setContribution((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__R1:
        setR1((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__R2:
        setR2((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__R3:
        setR3((Boolean)newValue);
        return;
      case MomotPackage.INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR:
        setMaximumParetoFrontError((Boolean)newValue);
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
      case MomotPackage.INDICATOR_ARRAY__HYPERVOLUME:
        setHypervolume(HYPERVOLUME_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__GENERATIONAL_DISTANCE:
        setGenerationalDistance(GENERATIONAL_DISTANCE_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        setInvertedGenerationalDistance(INVERTED_GENERATIONAL_DISTANCE_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__SPACING:
        setSpacing(SPACING_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        setAdditiveEpsilonIndicator(ADDITIVE_EPSILON_INDICATOR_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__CONTRIBUTION:
        setContribution(CONTRIBUTION_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__R1:
        setR1(R1_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__R2:
        setR2(R2_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__R3:
        setR3(R3_EDEFAULT);
        return;
      case MomotPackage.INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR:
        setMaximumParetoFrontError(MAXIMUM_PARETO_FRONT_ERROR_EDEFAULT);
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
      case MomotPackage.INDICATOR_ARRAY__HYPERVOLUME:
        return hypervolume != HYPERVOLUME_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__GENERATIONAL_DISTANCE:
        return generationalDistance != GENERATIONAL_DISTANCE_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        return invertedGenerationalDistance != INVERTED_GENERATIONAL_DISTANCE_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__SPACING:
        return spacing != SPACING_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        return additiveEpsilonIndicator != ADDITIVE_EPSILON_INDICATOR_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__CONTRIBUTION:
        return contribution != CONTRIBUTION_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__R1:
        return r1 != R1_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__R2:
        return r2 != R2_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__R3:
        return r3 != R3_EDEFAULT;
      case MomotPackage.INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR:
        return maximumParetoFrontError != MAXIMUM_PARETO_FRONT_ERROR_EDEFAULT;
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
    result.append(" (hypervolume: ");
    result.append(hypervolume);
    result.append(", generationalDistance: ");
    result.append(generationalDistance);
    result.append(", invertedGenerationalDistance: ");
    result.append(invertedGenerationalDistance);
    result.append(", spacing: ");
    result.append(spacing);
    result.append(", additiveEpsilonIndicator: ");
    result.append(additiveEpsilonIndicator);
    result.append(", contribution: ");
    result.append(contribution);
    result.append(", r1: ");
    result.append(r1);
    result.append(", r2: ");
    result.append(r2);
    result.append(", r3: ");
    result.append(r3);
    result.append(", maximumParetoFrontError: ");
    result.append(maximumParetoFrontError);
    result.append(')');
    return result.toString();
  }

} //IndicatorArrayImpl
