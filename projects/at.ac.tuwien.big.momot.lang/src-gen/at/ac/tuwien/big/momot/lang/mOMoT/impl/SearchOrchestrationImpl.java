/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.impl;

import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList;
import at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper;
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification;
import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage;
import at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration;
import at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration;

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
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl#getModel <em>Model</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl#getSolutionLength <em>Solution Length</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl#getTransformationOrchestration <em>Transformation Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl#getFitnessFunction <em>Fitness Function</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.mOMoT.impl.SearchOrchestrationImpl#getEqualityHelper <em>Equality Helper</em>}</li>
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
  protected XExpression model;

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
   * The cached value of the '{@link #getTransformationOrchestration() <em>Transformation Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransformationOrchestration()
   * @generated
   * @ordered
   */
  protected TransformationOrchestration transformationOrchestration;

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
    return MOMoTPackage.Literals.SEARCH_ORCHESTRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getModel()
  {
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModel(XExpression newModel, NotificationChain msgs)
  {
    XExpression oldModel = model;
    model = newModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__MODEL, oldModel, newModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModel(XExpression newModel)
  {
    if (newModel != model)
    {
      NotificationChain msgs = null;
      if (model != null)
        msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__MODEL, null, msgs);
      if (newModel != null)
        msgs = ((InternalEObject)newModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__MODEL, null, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__MODEL, newModel, newModel));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, oldSolutionLength, newSolutionLength);
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
        msgs = ((InternalEObject)solutionLength).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, null, msgs);
      if (newSolutionLength != null)
        msgs = ((InternalEObject)newSolutionLength).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, null, msgs);
      msgs = basicSetSolutionLength(newSolutionLength, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH, newSolutionLength, newSolutionLength));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationOrchestration getTransformationOrchestration()
  {
    return transformationOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTransformationOrchestration(TransformationOrchestration newTransformationOrchestration, NotificationChain msgs)
  {
    TransformationOrchestration oldTransformationOrchestration = transformationOrchestration;
    transformationOrchestration = newTransformationOrchestration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION, oldTransformationOrchestration, newTransformationOrchestration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransformationOrchestration(TransformationOrchestration newTransformationOrchestration)
  {
    if (newTransformationOrchestration != transformationOrchestration)
    {
      NotificationChain msgs = null;
      if (transformationOrchestration != null)
        msgs = ((InternalEObject)transformationOrchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION, null, msgs);
      if (newTransformationOrchestration != null)
        msgs = ((InternalEObject)newTransformationOrchestration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION, null, msgs);
      msgs = basicSetTransformationOrchestration(newTransformationOrchestration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION, newTransformationOrchestration, newTransformationOrchestration));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, oldFitnessFunction, newFitnessFunction);
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
        msgs = ((InternalEObject)fitnessFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, null, msgs);
      if (newFitnessFunction != null)
        msgs = ((InternalEObject)newFitnessFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, null, msgs);
      msgs = basicSetFitnessFunction(newFitnessFunction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION, newFitnessFunction, newFitnessFunction));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS, oldAlgorithms, newAlgorithms);
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
        msgs = ((InternalEObject)algorithms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS, null, msgs);
      if (newAlgorithms != null)
        msgs = ((InternalEObject)newAlgorithms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS, null, msgs);
      msgs = basicSetAlgorithms(newAlgorithms, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS, newAlgorithms, newAlgorithms));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, oldEqualityHelper, newEqualityHelper);
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
        msgs = ((InternalEObject)equalityHelper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, null, msgs);
      if (newEqualityHelper != null)
        msgs = ((InternalEObject)newEqualityHelper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, null, msgs);
      msgs = basicSetEqualityHelper(newEqualityHelper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER, newEqualityHelper, newEqualityHelper));
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
      case MOMoTPackage.SEARCH_ORCHESTRATION__MODEL:
        return basicSetModel(null, msgs);
      case MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        return basicSetSolutionLength(null, msgs);
      case MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION:
        return basicSetTransformationOrchestration(null, msgs);
      case MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        return basicSetFitnessFunction(null, msgs);
      case MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        return basicSetAlgorithms(null, msgs);
      case MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
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
      case MOMoTPackage.SEARCH_ORCHESTRATION__MODEL:
        return getModel();
      case MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        return getSolutionLength();
      case MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION:
        return getTransformationOrchestration();
      case MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        return getFitnessFunction();
      case MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        return getAlgorithms();
      case MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
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
      case MOMoTPackage.SEARCH_ORCHESTRATION__MODEL:
        setModel((XExpression)newValue);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        setSolutionLength((XExpression)newValue);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION:
        setTransformationOrchestration((TransformationOrchestration)newValue);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        setFitnessFunction((FitnessFunctionSpecification)newValue);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        setAlgorithms((AlgorithmList)newValue);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
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
      case MOMoTPackage.SEARCH_ORCHESTRATION__MODEL:
        setModel((XExpression)null);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        setSolutionLength((XExpression)null);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION:
        setTransformationOrchestration((TransformationOrchestration)null);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        setFitnessFunction((FitnessFunctionSpecification)null);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        setAlgorithms((AlgorithmList)null);
        return;
      case MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
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
      case MOMoTPackage.SEARCH_ORCHESTRATION__MODEL:
        return model != null;
      case MOMoTPackage.SEARCH_ORCHESTRATION__SOLUTION_LENGTH:
        return solutionLength != null;
      case MOMoTPackage.SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION:
        return transformationOrchestration != null;
      case MOMoTPackage.SEARCH_ORCHESTRATION__FITNESS_FUNCTION:
        return fitnessFunction != null;
      case MOMoTPackage.SEARCH_ORCHESTRATION__ALGORITHMS:
        return algorithms != null;
      case MOMoTPackage.SEARCH_ORCHESTRATION__EQUALITY_HELPER:
        return equalityHelper != null;
    }
    return super.eIsSet(featureID);
  }

} //SearchOrchestrationImpl
