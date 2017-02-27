/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.CollectorArray;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collector Array</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isHypervolume <em>Hypervolume</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isGenerationalDistance <em>Generational Distance</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isInvertedGenerationalDistance <em>Inverted Generational Distance</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isSpacing <em>Spacing</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isAdditiveEpsilonIndicator <em>Additive Epsilon Indicator</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isContribution <em>Contribution</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isR1 <em>R1</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isR2 <em>R2</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isR3 <em>R3</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isAdaptiveMultimethodVariation <em>Adaptive Multimethod Variation</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isAdaptiveTimeContinuation <em>Adaptive Time Continuation</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isApproximationSet <em>Approximation Set</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isEpsilonProgress <em>Epsilon Progress</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isElapsedTime <em>Elapsed Time</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.CollectorArrayImpl#isPopulationSize <em>Population Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectorArrayImpl extends MinimalEObjectImpl.Container implements CollectorArray
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
   * The default value of the '{@link #isAdaptiveMultimethodVariation() <em>Adaptive Multimethod Variation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdaptiveMultimethodVariation()
   * @generated
   * @ordered
   */
  protected static final boolean ADAPTIVE_MULTIMETHOD_VARIATION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAdaptiveMultimethodVariation() <em>Adaptive Multimethod Variation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdaptiveMultimethodVariation()
   * @generated
   * @ordered
   */
  protected boolean adaptiveMultimethodVariation = ADAPTIVE_MULTIMETHOD_VARIATION_EDEFAULT;

  /**
   * The default value of the '{@link #isAdaptiveTimeContinuation() <em>Adaptive Time Continuation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdaptiveTimeContinuation()
   * @generated
   * @ordered
   */
  protected static final boolean ADAPTIVE_TIME_CONTINUATION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAdaptiveTimeContinuation() <em>Adaptive Time Continuation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdaptiveTimeContinuation()
   * @generated
   * @ordered
   */
  protected boolean adaptiveTimeContinuation = ADAPTIVE_TIME_CONTINUATION_EDEFAULT;

  /**
   * The default value of the '{@link #isApproximationSet() <em>Approximation Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isApproximationSet()
   * @generated
   * @ordered
   */
  protected static final boolean APPROXIMATION_SET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isApproximationSet() <em>Approximation Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isApproximationSet()
   * @generated
   * @ordered
   */
  protected boolean approximationSet = APPROXIMATION_SET_EDEFAULT;

  /**
   * The default value of the '{@link #isEpsilonProgress() <em>Epsilon Progress</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEpsilonProgress()
   * @generated
   * @ordered
   */
  protected static final boolean EPSILON_PROGRESS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isEpsilonProgress() <em>Epsilon Progress</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEpsilonProgress()
   * @generated
   * @ordered
   */
  protected boolean epsilonProgress = EPSILON_PROGRESS_EDEFAULT;

  /**
   * The default value of the '{@link #isElapsedTime() <em>Elapsed Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isElapsedTime()
   * @generated
   * @ordered
   */
  protected static final boolean ELAPSED_TIME_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isElapsedTime() <em>Elapsed Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isElapsedTime()
   * @generated
   * @ordered
   */
  protected boolean elapsedTime = ELAPSED_TIME_EDEFAULT;

  /**
   * The default value of the '{@link #isPopulationSize() <em>Population Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPopulationSize()
   * @generated
   * @ordered
   */
  protected static final boolean POPULATION_SIZE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPopulationSize() <em>Population Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPopulationSize()
   * @generated
   * @ordered
   */
  protected boolean populationSize = POPULATION_SIZE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectorArrayImpl()
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
    return MomotPackage.Literals.COLLECTOR_ARRAY;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__HYPERVOLUME, oldHypervolume, hypervolume));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__GENERATIONAL_DISTANCE, oldGenerationalDistance, generationalDistance));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE, oldInvertedGenerationalDistance, invertedGenerationalDistance));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__SPACING, oldSpacing, spacing));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR, oldAdditiveEpsilonIndicator, additiveEpsilonIndicator));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__CONTRIBUTION, oldContribution, contribution));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__R1, oldR1, r1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__R2, oldR2, r2));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__R3, oldR3, r3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAdaptiveMultimethodVariation()
  {
    return adaptiveMultimethodVariation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdaptiveMultimethodVariation(boolean newAdaptiveMultimethodVariation)
  {
    boolean oldAdaptiveMultimethodVariation = adaptiveMultimethodVariation;
    adaptiveMultimethodVariation = newAdaptiveMultimethodVariation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION, oldAdaptiveMultimethodVariation, adaptiveMultimethodVariation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAdaptiveTimeContinuation()
  {
    return adaptiveTimeContinuation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdaptiveTimeContinuation(boolean newAdaptiveTimeContinuation)
  {
    boolean oldAdaptiveTimeContinuation = adaptiveTimeContinuation;
    adaptiveTimeContinuation = newAdaptiveTimeContinuation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION, oldAdaptiveTimeContinuation, adaptiveTimeContinuation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isApproximationSet()
  {
    return approximationSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApproximationSet(boolean newApproximationSet)
  {
    boolean oldApproximationSet = approximationSet;
    approximationSet = newApproximationSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__APPROXIMATION_SET, oldApproximationSet, approximationSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isEpsilonProgress()
  {
    return epsilonProgress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEpsilonProgress(boolean newEpsilonProgress)
  {
    boolean oldEpsilonProgress = epsilonProgress;
    epsilonProgress = newEpsilonProgress;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__EPSILON_PROGRESS, oldEpsilonProgress, epsilonProgress));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isElapsedTime()
  {
    return elapsedTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElapsedTime(boolean newElapsedTime)
  {
    boolean oldElapsedTime = elapsedTime;
    elapsedTime = newElapsedTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__ELAPSED_TIME, oldElapsedTime, elapsedTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPopulationSize()
  {
    return populationSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPopulationSize(boolean newPopulationSize)
  {
    boolean oldPopulationSize = populationSize;
    populationSize = newPopulationSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.COLLECTOR_ARRAY__POPULATION_SIZE, oldPopulationSize, populationSize));
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
      case MomotPackage.COLLECTOR_ARRAY__HYPERVOLUME:
        return isHypervolume();
      case MomotPackage.COLLECTOR_ARRAY__GENERATIONAL_DISTANCE:
        return isGenerationalDistance();
      case MomotPackage.COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        return isInvertedGenerationalDistance();
      case MomotPackage.COLLECTOR_ARRAY__SPACING:
        return isSpacing();
      case MomotPackage.COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        return isAdditiveEpsilonIndicator();
      case MomotPackage.COLLECTOR_ARRAY__CONTRIBUTION:
        return isContribution();
      case MomotPackage.COLLECTOR_ARRAY__R1:
        return isR1();
      case MomotPackage.COLLECTOR_ARRAY__R2:
        return isR2();
      case MomotPackage.COLLECTOR_ARRAY__R3:
        return isR3();
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION:
        return isAdaptiveMultimethodVariation();
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION:
        return isAdaptiveTimeContinuation();
      case MomotPackage.COLLECTOR_ARRAY__APPROXIMATION_SET:
        return isApproximationSet();
      case MomotPackage.COLLECTOR_ARRAY__EPSILON_PROGRESS:
        return isEpsilonProgress();
      case MomotPackage.COLLECTOR_ARRAY__ELAPSED_TIME:
        return isElapsedTime();
      case MomotPackage.COLLECTOR_ARRAY__POPULATION_SIZE:
        return isPopulationSize();
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
      case MomotPackage.COLLECTOR_ARRAY__HYPERVOLUME:
        setHypervolume((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__GENERATIONAL_DISTANCE:
        setGenerationalDistance((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        setInvertedGenerationalDistance((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__SPACING:
        setSpacing((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        setAdditiveEpsilonIndicator((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__CONTRIBUTION:
        setContribution((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__R1:
        setR1((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__R2:
        setR2((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__R3:
        setR3((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION:
        setAdaptiveMultimethodVariation((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION:
        setAdaptiveTimeContinuation((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__APPROXIMATION_SET:
        setApproximationSet((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__EPSILON_PROGRESS:
        setEpsilonProgress((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ELAPSED_TIME:
        setElapsedTime((Boolean)newValue);
        return;
      case MomotPackage.COLLECTOR_ARRAY__POPULATION_SIZE:
        setPopulationSize((Boolean)newValue);
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
      case MomotPackage.COLLECTOR_ARRAY__HYPERVOLUME:
        setHypervolume(HYPERVOLUME_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__GENERATIONAL_DISTANCE:
        setGenerationalDistance(GENERATIONAL_DISTANCE_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        setInvertedGenerationalDistance(INVERTED_GENERATIONAL_DISTANCE_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__SPACING:
        setSpacing(SPACING_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        setAdditiveEpsilonIndicator(ADDITIVE_EPSILON_INDICATOR_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__CONTRIBUTION:
        setContribution(CONTRIBUTION_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__R1:
        setR1(R1_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__R2:
        setR2(R2_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__R3:
        setR3(R3_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION:
        setAdaptiveMultimethodVariation(ADAPTIVE_MULTIMETHOD_VARIATION_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION:
        setAdaptiveTimeContinuation(ADAPTIVE_TIME_CONTINUATION_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__APPROXIMATION_SET:
        setApproximationSet(APPROXIMATION_SET_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__EPSILON_PROGRESS:
        setEpsilonProgress(EPSILON_PROGRESS_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__ELAPSED_TIME:
        setElapsedTime(ELAPSED_TIME_EDEFAULT);
        return;
      case MomotPackage.COLLECTOR_ARRAY__POPULATION_SIZE:
        setPopulationSize(POPULATION_SIZE_EDEFAULT);
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
      case MomotPackage.COLLECTOR_ARRAY__HYPERVOLUME:
        return hypervolume != HYPERVOLUME_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__GENERATIONAL_DISTANCE:
        return generationalDistance != GENERATIONAL_DISTANCE_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE:
        return invertedGenerationalDistance != INVERTED_GENERATIONAL_DISTANCE_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__SPACING:
        return spacing != SPACING_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR:
        return additiveEpsilonIndicator != ADDITIVE_EPSILON_INDICATOR_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__CONTRIBUTION:
        return contribution != CONTRIBUTION_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__R1:
        return r1 != R1_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__R2:
        return r2 != R2_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__R3:
        return r3 != R3_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION:
        return adaptiveMultimethodVariation != ADAPTIVE_MULTIMETHOD_VARIATION_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION:
        return adaptiveTimeContinuation != ADAPTIVE_TIME_CONTINUATION_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__APPROXIMATION_SET:
        return approximationSet != APPROXIMATION_SET_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__EPSILON_PROGRESS:
        return epsilonProgress != EPSILON_PROGRESS_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__ELAPSED_TIME:
        return elapsedTime != ELAPSED_TIME_EDEFAULT;
      case MomotPackage.COLLECTOR_ARRAY__POPULATION_SIZE:
        return populationSize != POPULATION_SIZE_EDEFAULT;
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
    result.append(", adaptiveMultimethodVariation: ");
    result.append(adaptiveMultimethodVariation);
    result.append(", adaptiveTimeContinuation: ");
    result.append(adaptiveTimeContinuation);
    result.append(", approximationSet: ");
    result.append(approximationSet);
    result.append(", epsilonProgress: ");
    result.append(epsilonProgress);
    result.append(", elapsedTime: ");
    result.append(elapsedTime);
    result.append(", populationSize: ");
    result.append(populationSize);
    result.append(')');
    return result.toString();
  }

} //CollectorArrayImpl
