/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.AlgorithmList;
import at.ac.tuwien.big.momot.lang.momot.EqualityHelper;
import at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification;
import at.ac.tuwien.big.momot.lang.momot.InputModel;
import at.ac.tuwien.big.momot.lang.momot.ModuleOrchestration;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.SearchOrchestration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Orchestration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl#getModel <em>Model</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl#getSolutionLength <em>Solution Length</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl#getModuleOrchestration <em>Module Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl#getFitnessFunction <em>Fitness Function</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.SearchOrchestrationImpl#getEqualityHelper <em>Equality Helper</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchOrchestrationImpl extends MinimalEObjectImpl.Container implements SearchOrchestration
{
  /**
   * The cached value of the '{@link #getModel() <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
  protected InputModel model;

  /**
   * The cached value of the '{@link #getSolutionLength() <em>Solution Length</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutionLength()
   * @generated
   * @ordered
   */
  protected XExpression solutionLength;

  /**
   * The cached value of the '{@link #getModuleOrchestration() <em>Module Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModuleOrchestration()
   * @generated
   * @ordered
   */
  protected ModuleOrchestration moduleOrchestration;

  /**
   * The cached value of the '{@link #getFitnessFunction() <em>Fitness Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFitnessFunction()
   * @generated
   * @ordered
   */
  protected FitnessFunctionSpecification fitnessFunction;

  /**
   * The cached value of the '{@link #getAlgorithms() <em>Algorithms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlgorithms()
   * @generated
   * @ordered
   */
  protected AlgorithmList algorithms;

  /**
   * The cached value of the '{@link #getEqualityHelper() <em>Equality Helper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualityHelper()
   * @generated
   * @ordered
   */
  protected EqualityHelper equalityHelper;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SearchOrchestrationImpl()
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
    return MomotPackage.Literals.SEARCH_ORCHESTRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputModel getModel()
  {
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModel(InputModel newModel, NotificationChain msgs)
  {
    InputModel oldModel = model;
    model = newModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__MODEL, oldModel, newModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModel(InputModel newModel)
  {
    if (newModel != model)
    {
      NotificationChain msgs = null;
      if (model != null)
        msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__MODEL, null, msgs);
      if (newModel != null)
        msgs = ((InternalEObject)newModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__MODEL, null, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__MODEL, newModel, newModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getSolutionLength()
  {
    return solutionLength;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSolutionLength(XExpression newSolutionLength, NotificationChain msgs)
  {
    XExpression oldSolutionLength = solutionLength;
    solutionLength = newSolutionLength;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, oldSolutionLength, newSolutionLength);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSolutionLength(XExpression newSolutionLength)
  {
    if (newSolutionLength != solutionLength)
    {
      NotificationChain msgs = null;
      if (solutionLength != null)
        msgs = ((InternalEObject)solutionLength).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, null, msgs);
      if (newSolutionLength != null)
        msgs = ((InternalEObject)newSolutionLength).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, null, msgs);
      msgs = basicSetSolutionLength(newSolutionLength, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, newSolutionLength, newSolutionLength));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleOrchestration getModuleOrchestration()
  {
    return moduleOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModuleOrchestration(ModuleOrchestration newModuleOrchestration, NotificationChain msgs)
  {
    ModuleOrchestration oldModuleOrchestration = moduleOrchestration;
    moduleOrchestration = newModuleOrchestration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION, oldModuleOrchestration, newModuleOrchestration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModuleOrchestration(ModuleOrchestration newModuleOrchestration)
  {
    if (newModuleOrchestration != moduleOrchestration)
    {
      NotificationChain msgs = null;
      if (moduleOrchestration != null)
        msgs = ((InternalEObject)moduleOrchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION, null, msgs);
      if (newModuleOrchestration != null)
        msgs = ((InternalEObject)newModuleOrchestration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION, null, msgs);
      msgs = basicSetModuleOrchestration(newModuleOrchestration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION, newModuleOrchestration, newModuleOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FitnessFunctionSpecification getFitnessFunction()
  {
    return fitnessFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFitnessFunction(FitnessFunctionSpecification newFitnessFunction, NotificationChain msgs)
  {
    FitnessFunctionSpecification oldFitnessFunction = fitnessFunction;
    fitnessFunction = newFitnessFunction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, oldFitnessFunction, newFitnessFunction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFitnessFunction(FitnessFunctionSpecification newFitnessFunction)
  {
    if (newFitnessFunction != fitnessFunction)
    {
      NotificationChain msgs = null;
      if (fitnessFunction != null)
        msgs = ((InternalEObject)fitnessFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, null, msgs);
      if (newFitnessFunction != null)
        msgs = ((InternalEObject)newFitnessFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, null, msgs);
      msgs = basicSetFitnessFunction(newFitnessFunction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, newFitnessFunction, newFitnessFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlgorithmList getAlgorithms()
  {
    return algorithms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlgorithms(AlgorithmList newAlgorithms, NotificationChain msgs)
  {
    AlgorithmList oldAlgorithms = algorithms;
    algorithms = newAlgorithms;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS, oldAlgorithms, newAlgorithms);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlgorithms(AlgorithmList newAlgorithms)
  {
    if (newAlgorithms != algorithms)
    {
      NotificationChain msgs = null;
      if (algorithms != null)
        msgs = ((InternalEObject)algorithms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS, null, msgs);
      if (newAlgorithms != null)
        msgs = ((InternalEObject)newAlgorithms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS, null, msgs);
      msgs = basicSetAlgorithms(newAlgorithms, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS, newAlgorithms, newAlgorithms));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityHelper getEqualityHelper()
  {
    return equalityHelper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEqualityHelper(EqualityHelper newEqualityHelper, NotificationChain msgs)
  {
    EqualityHelper oldEqualityHelper = equalityHelper;
    equalityHelper = newEqualityHelper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, oldEqualityHelper, newEqualityHelper);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEqualityHelper(EqualityHelper newEqualityHelper)
  {
    if (newEqualityHelper != equalityHelper)
    {
      NotificationChain msgs = null;
      if (equalityHelper != null)
        msgs = ((InternalEObject)equalityHelper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, null, msgs);
      if (newEqualityHelper != null)
        msgs = ((InternalEObject)newEqualityHelper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, null, msgs);
      msgs = basicSetEqualityHelper(newEqualityHelper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, newEqualityHelper, newEqualityHelper));
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
      case MomotPackage.SEARCH_ORCHESTRATION__MODEL:
        return basicSetModel(null, msgs);
      case MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        return basicSetSolutionLength(null, msgs);
      case MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION:
        return basicSetModuleOrchestration(null, msgs);
      case MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        return basicSetFitnessFunction(null, msgs);
      case MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        return basicSetAlgorithms(null, msgs);
      case MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
        return basicSetEqualityHelper(null, msgs);
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
      case MomotPackage.SEARCH_ORCHESTRATION__MODEL:
        return getModel();
      case MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        return getSolutionLength();
      case MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION:
        return getModuleOrchestration();
      case MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        return getFitnessFunction();
      case MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        return getAlgorithms();
      case MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
        return getEqualityHelper();
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
      case MomotPackage.SEARCH_ORCHESTRATION__MODEL:
        setModel((InputModel)newValue);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        setSolutionLength((XExpression)newValue);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION:
        setModuleOrchestration((ModuleOrchestration)newValue);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        setFitnessFunction((FitnessFunctionSpecification)newValue);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        setAlgorithms((AlgorithmList)newValue);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
        setEqualityHelper((EqualityHelper)newValue);
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
      case MomotPackage.SEARCH_ORCHESTRATION__MODEL:
        setModel((InputModel)null);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        setSolutionLength((XExpression)null);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION:
        setModuleOrchestration((ModuleOrchestration)null);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        setFitnessFunction((FitnessFunctionSpecification)null);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        setAlgorithms((AlgorithmList)null);
        return;
      case MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
        setEqualityHelper((EqualityHelper)null);
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
      case MomotPackage.SEARCH_ORCHESTRATION__MODEL:
        return model != null;
      case MomotPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        return solutionLength != null;
      case MomotPackage.SEARCH_ORCHESTRATION__MODULE_ORCHESTRATION:
        return moduleOrchestration != null;
      case MomotPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        return fitnessFunction != null;
      case MomotPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        return algorithms != null;
      case MomotPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
        return equalityHelper != null;
    }
    return super.eIsSet(featureID);
  }

} //SearchOrchestrationImpl
