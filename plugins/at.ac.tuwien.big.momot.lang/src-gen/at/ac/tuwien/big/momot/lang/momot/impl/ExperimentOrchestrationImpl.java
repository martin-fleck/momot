/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.CollectorArray;
import at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Orchestration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl#getPopulationSize <em>Population Size</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl#getMaxEvaluations <em>Max Evaluations</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl#getNrRuns <em>Nr Runs</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl#getReferenceSet <em>Reference Set</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl#getProgressListeners <em>Progress Listeners</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl#getCollectors <em>Collectors</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.ExperimentOrchestrationImpl#getCustomCollectors <em>Custom Collectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExperimentOrchestrationImpl extends MinimalEObjectImpl.Container implements ExperimentOrchestration
{
  /**
   * The cached value of the '{@link #getPopulationSize() <em>Population Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPopulationSize()
   * @generated
   * @ordered
   */
  protected XExpression populationSize;

  /**
   * The cached value of the '{@link #getMaxEvaluations() <em>Max Evaluations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxEvaluations()
   * @generated
   * @ordered
   */
  protected XExpression maxEvaluations;

  /**
   * The cached value of the '{@link #getNrRuns() <em>Nr Runs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNrRuns()
   * @generated
   * @ordered
   */
  protected XExpression nrRuns;

  /**
   * The cached value of the '{@link #getReferenceSet() <em>Reference Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceSet()
   * @generated
   * @ordered
   */
  protected XExpression referenceSet;

  /**
   * The cached value of the '{@link #getProgressListeners() <em>Progress Listeners</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProgressListeners()
   * @generated
   * @ordered
   */
  protected EList<XExpression> progressListeners;

  /**
   * The cached value of the '{@link #getCollectors() <em>Collectors</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollectors()
   * @generated
   * @ordered
   */
  protected CollectorArray collectors;

  /**
   * The cached value of the '{@link #getCustomCollectors() <em>Custom Collectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCustomCollectors()
   * @generated
   * @ordered
   */
  protected EList<XExpression> customCollectors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExperimentOrchestrationImpl()
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
    return MomotPackage.Literals.EXPERIMENT_ORCHESTRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getPopulationSize()
  {
    return populationSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPopulationSize(XExpression newPopulationSize, NotificationChain msgs)
  {
    XExpression oldPopulationSize = populationSize;
    populationSize = newPopulationSize;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE, oldPopulationSize, newPopulationSize);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPopulationSize(XExpression newPopulationSize)
  {
    if (newPopulationSize != populationSize)
    {
      NotificationChain msgs = null;
      if (populationSize != null)
        msgs = ((InternalEObject)populationSize).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE, null, msgs);
      if (newPopulationSize != null)
        msgs = ((InternalEObject)newPopulationSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE, null, msgs);
      msgs = basicSetPopulationSize(newPopulationSize, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE, newPopulationSize, newPopulationSize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getMaxEvaluations()
  {
    return maxEvaluations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMaxEvaluations(XExpression newMaxEvaluations, NotificationChain msgs)
  {
    XExpression oldMaxEvaluations = maxEvaluations;
    maxEvaluations = newMaxEvaluations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS, oldMaxEvaluations, newMaxEvaluations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxEvaluations(XExpression newMaxEvaluations)
  {
    if (newMaxEvaluations != maxEvaluations)
    {
      NotificationChain msgs = null;
      if (maxEvaluations != null)
        msgs = ((InternalEObject)maxEvaluations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS, null, msgs);
      if (newMaxEvaluations != null)
        msgs = ((InternalEObject)newMaxEvaluations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS, null, msgs);
      msgs = basicSetMaxEvaluations(newMaxEvaluations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS, newMaxEvaluations, newMaxEvaluations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getNrRuns()
  {
    return nrRuns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNrRuns(XExpression newNrRuns, NotificationChain msgs)
  {
    XExpression oldNrRuns = nrRuns;
    nrRuns = newNrRuns;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS, oldNrRuns, newNrRuns);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNrRuns(XExpression newNrRuns)
  {
    if (newNrRuns != nrRuns)
    {
      NotificationChain msgs = null;
      if (nrRuns != null)
        msgs = ((InternalEObject)nrRuns).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS, null, msgs);
      if (newNrRuns != null)
        msgs = ((InternalEObject)newNrRuns).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS, null, msgs);
      msgs = basicSetNrRuns(newNrRuns, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS, newNrRuns, newNrRuns));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getReferenceSet()
  {
    return referenceSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReferenceSet(XExpression newReferenceSet, NotificationChain msgs)
  {
    XExpression oldReferenceSet = referenceSet;
    referenceSet = newReferenceSet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET, oldReferenceSet, newReferenceSet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenceSet(XExpression newReferenceSet)
  {
    if (newReferenceSet != referenceSet)
    {
      NotificationChain msgs = null;
      if (referenceSet != null)
        msgs = ((InternalEObject)referenceSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET, null, msgs);
      if (newReferenceSet != null)
        msgs = ((InternalEObject)newReferenceSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET, null, msgs);
      msgs = basicSetReferenceSet(newReferenceSet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET, newReferenceSet, newReferenceSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getProgressListeners()
  {
    if (progressListeners == null)
    {
      progressListeners = new EObjectContainmentEList<XExpression>(XExpression.class, this, MomotPackage.EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS);
    }
    return progressListeners;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectorArray getCollectors()
  {
    return collectors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCollectors(CollectorArray newCollectors, NotificationChain msgs)
  {
    CollectorArray oldCollectors = collectors;
    collectors = newCollectors;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS, oldCollectors, newCollectors);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCollectors(CollectorArray newCollectors)
  {
    if (newCollectors != collectors)
    {
      NotificationChain msgs = null;
      if (collectors != null)
        msgs = ((InternalEObject)collectors).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS, null, msgs);
      if (newCollectors != null)
        msgs = ((InternalEObject)newCollectors).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS, null, msgs);
      msgs = basicSetCollectors(newCollectors, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS, newCollectors, newCollectors));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getCustomCollectors()
  {
    if (customCollectors == null)
    {
      customCollectors = new EObjectContainmentEList<XExpression>(XExpression.class, this, MomotPackage.EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS);
    }
    return customCollectors;
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
      case MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE:
        return basicSetPopulationSize(null, msgs);
      case MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS:
        return basicSetMaxEvaluations(null, msgs);
      case MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS:
        return basicSetNrRuns(null, msgs);
      case MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET:
        return basicSetReferenceSet(null, msgs);
      case MomotPackage.EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS:
        return ((InternalEList<?>)getProgressListeners()).basicRemove(otherEnd, msgs);
      case MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS:
        return basicSetCollectors(null, msgs);
      case MomotPackage.EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS:
        return ((InternalEList<?>)getCustomCollectors()).basicRemove(otherEnd, msgs);
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
      case MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE:
        return getPopulationSize();
      case MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS:
        return getMaxEvaluations();
      case MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS:
        return getNrRuns();
      case MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET:
        return getReferenceSet();
      case MomotPackage.EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS:
        return getProgressListeners();
      case MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS:
        return getCollectors();
      case MomotPackage.EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS:
        return getCustomCollectors();
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
      case MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE:
        setPopulationSize((XExpression)newValue);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS:
        setMaxEvaluations((XExpression)newValue);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS:
        setNrRuns((XExpression)newValue);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET:
        setReferenceSet((XExpression)newValue);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS:
        getProgressListeners().clear();
        getProgressListeners().addAll((Collection<? extends XExpression>)newValue);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS:
        setCollectors((CollectorArray)newValue);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS:
        getCustomCollectors().clear();
        getCustomCollectors().addAll((Collection<? extends XExpression>)newValue);
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
      case MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE:
        setPopulationSize((XExpression)null);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS:
        setMaxEvaluations((XExpression)null);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS:
        setNrRuns((XExpression)null);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET:
        setReferenceSet((XExpression)null);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS:
        getProgressListeners().clear();
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS:
        setCollectors((CollectorArray)null);
        return;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS:
        getCustomCollectors().clear();
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
      case MomotPackage.EXPERIMENT_ORCHESTRATION__POPULATION_SIZE:
        return populationSize != null;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS:
        return maxEvaluations != null;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__NR_RUNS:
        return nrRuns != null;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__REFERENCE_SET:
        return referenceSet != null;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS:
        return progressListeners != null && !progressListeners.isEmpty();
      case MomotPackage.EXPERIMENT_ORCHESTRATION__COLLECTORS:
        return collectors != null;
      case MomotPackage.EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS:
        return customCollectors != null && !customCollectors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExperimentOrchestrationImpl
