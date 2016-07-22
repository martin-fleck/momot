/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification;
import at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification;
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
 * An implementation of the model object '<em><b>Fitness Function Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl#getPreprocess <em>Preprocess</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl#getObjectives <em>Objectives</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl#getPostprocess <em>Postprocess</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.FitnessFunctionSpecificationImpl#getSolutionRepairer <em>Solution Repairer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FitnessFunctionSpecificationImpl extends MinimalEObjectImpl.Container implements FitnessFunctionSpecification
{
  /**
   * The cached value of the '{@link #getConstructor() <em>Constructor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstructor()
   * @generated
   * @ordered
   */
  protected XExpression constructor;

  /**
   * The cached value of the '{@link #getPreprocess() <em>Preprocess</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreprocess()
   * @generated
   * @ordered
   */
  protected XExpression preprocess;

  /**
   * The cached value of the '{@link #getObjectives() <em>Objectives</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectives()
   * @generated
   * @ordered
   */
  protected EList<FitnessDimensionSpecification> objectives;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected EList<FitnessDimensionSpecification> constraints;

  /**
   * The cached value of the '{@link #getPostprocess() <em>Postprocess</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostprocess()
   * @generated
   * @ordered
   */
  protected XExpression postprocess;

  /**
   * The cached value of the '{@link #getSolutionRepairer() <em>Solution Repairer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutionRepairer()
   * @generated
   * @ordered
   */
  protected XExpression solutionRepairer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FitnessFunctionSpecificationImpl()
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
    return MomotPackage.Literals.FITNESS_FUNCTION_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getConstructor()
  {
    return constructor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstructor(XExpression newConstructor, NotificationChain msgs)
  {
    XExpression oldConstructor = constructor;
    constructor = newConstructor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR, oldConstructor, newConstructor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstructor(XExpression newConstructor)
  {
    if (newConstructor != constructor)
    {
      NotificationChain msgs = null;
      if (constructor != null)
        msgs = ((InternalEObject)constructor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR, null, msgs);
      if (newConstructor != null)
        msgs = ((InternalEObject)newConstructor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR, null, msgs);
      msgs = basicSetConstructor(newConstructor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR, newConstructor, newConstructor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getPreprocess()
  {
    return preprocess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPreprocess(XExpression newPreprocess, NotificationChain msgs)
  {
    XExpression oldPreprocess = preprocess;
    preprocess = newPreprocess;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS, oldPreprocess, newPreprocess);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreprocess(XExpression newPreprocess)
  {
    if (newPreprocess != preprocess)
    {
      NotificationChain msgs = null;
      if (preprocess != null)
        msgs = ((InternalEObject)preprocess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS, null, msgs);
      if (newPreprocess != null)
        msgs = ((InternalEObject)newPreprocess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS, null, msgs);
      msgs = basicSetPreprocess(newPreprocess, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS, newPreprocess, newPreprocess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FitnessDimensionSpecification> getObjectives()
  {
    if (objectives == null)
    {
      objectives = new EObjectContainmentEList<FitnessDimensionSpecification>(FitnessDimensionSpecification.class, this, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES);
    }
    return objectives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FitnessDimensionSpecification> getConstraints()
  {
    if (constraints == null)
    {
      constraints = new EObjectContainmentEList<FitnessDimensionSpecification>(FitnessDimensionSpecification.class, this, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS);
    }
    return constraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getPostprocess()
  {
    return postprocess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPostprocess(XExpression newPostprocess, NotificationChain msgs)
  {
    XExpression oldPostprocess = postprocess;
    postprocess = newPostprocess;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS, oldPostprocess, newPostprocess);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostprocess(XExpression newPostprocess)
  {
    if (newPostprocess != postprocess)
    {
      NotificationChain msgs = null;
      if (postprocess != null)
        msgs = ((InternalEObject)postprocess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS, null, msgs);
      if (newPostprocess != null)
        msgs = ((InternalEObject)newPostprocess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS, null, msgs);
      msgs = basicSetPostprocess(newPostprocess, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS, newPostprocess, newPostprocess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getSolutionRepairer()
  {
    return solutionRepairer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSolutionRepairer(XExpression newSolutionRepairer, NotificationChain msgs)
  {
    XExpression oldSolutionRepairer = solutionRepairer;
    solutionRepairer = newSolutionRepairer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER, oldSolutionRepairer, newSolutionRepairer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSolutionRepairer(XExpression newSolutionRepairer)
  {
    if (newSolutionRepairer != solutionRepairer)
    {
      NotificationChain msgs = null;
      if (solutionRepairer != null)
        msgs = ((InternalEObject)solutionRepairer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER, null, msgs);
      if (newSolutionRepairer != null)
        msgs = ((InternalEObject)newSolutionRepairer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER, null, msgs);
      msgs = basicSetSolutionRepairer(newSolutionRepairer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER, newSolutionRepairer, newSolutionRepairer));
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
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR:
        return basicSetConstructor(null, msgs);
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS:
        return basicSetPreprocess(null, msgs);
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES:
        return ((InternalEList<?>)getObjectives()).basicRemove(otherEnd, msgs);
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS:
        return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS:
        return basicSetPostprocess(null, msgs);
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER:
        return basicSetSolutionRepairer(null, msgs);
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
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR:
        return getConstructor();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS:
        return getPreprocess();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES:
        return getObjectives();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS:
        return getConstraints();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS:
        return getPostprocess();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER:
        return getSolutionRepairer();
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
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR:
        setConstructor((XExpression)newValue);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS:
        setPreprocess((XExpression)newValue);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES:
        getObjectives().clear();
        getObjectives().addAll((Collection<? extends FitnessDimensionSpecification>)newValue);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS:
        getConstraints().clear();
        getConstraints().addAll((Collection<? extends FitnessDimensionSpecification>)newValue);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS:
        setPostprocess((XExpression)newValue);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER:
        setSolutionRepairer((XExpression)newValue);
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
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR:
        setConstructor((XExpression)null);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS:
        setPreprocess((XExpression)null);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES:
        getObjectives().clear();
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS:
        getConstraints().clear();
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS:
        setPostprocess((XExpression)null);
        return;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER:
        setSolutionRepairer((XExpression)null);
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
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR:
        return constructor != null;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__PREPROCESS:
        return preprocess != null;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES:
        return objectives != null && !objectives.isEmpty();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS:
        return constraints != null && !constraints.isEmpty();
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS:
        return postprocess != null;
      case MomotPackage.FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER:
        return solutionRepairer != null;
    }
    return super.eIsSet(featureID);
  }

} //FitnessFunctionSpecificationImpl
