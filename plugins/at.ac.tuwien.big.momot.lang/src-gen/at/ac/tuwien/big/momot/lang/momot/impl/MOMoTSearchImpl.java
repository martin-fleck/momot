/**
 */
package at.ac.tuwien.big.momot.lang.momot.impl;

import at.ac.tuwien.big.momot.lang.momot.AnalysisOrchestration;
import at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration;
import at.ac.tuwien.big.momot.lang.momot.MOMoTSearch;
import at.ac.tuwien.big.momot.lang.momot.MomotPackage;
import at.ac.tuwien.big.momot.lang.momot.ResultManagement;
import at.ac.tuwien.big.momot.lang.momot.SearchOrchestration;
import at.ac.tuwien.big.momot.lang.momot.VariableDeclaration;

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

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MO Mo TSearch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getInitialization <em>Initialization</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getSearchOrchestration <em>Search Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getExperimentOrchestration <em>Experiment Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getAnalysisOrchestration <em>Analysis Orchestration</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getResultManagement <em>Result Management</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.lang.momot.impl.MOMoTSearchImpl#getFinalization <em>Finalization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MOMoTSearchImpl extends MinimalEObjectImpl.Container implements MOMoTSearch
{
  /**
   * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected String package_ = PACKAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getImportSection() <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportSection()
   * @generated
   * @ordered
   */
  protected XImportSection importSection;

  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<VariableDeclaration> variables;

  /**
   * The cached value of the '{@link #getInitialization() <em>Initialization</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialization()
   * @generated
   * @ordered
   */
  protected XExpression initialization;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getSearchOrchestration() <em>Search Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSearchOrchestration()
   * @generated
   * @ordered
   */
  protected SearchOrchestration searchOrchestration;

  /**
   * The cached value of the '{@link #getExperimentOrchestration() <em>Experiment Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExperimentOrchestration()
   * @generated
   * @ordered
   */
  protected ExperimentOrchestration experimentOrchestration;

  /**
   * The cached value of the '{@link #getAnalysisOrchestration() <em>Analysis Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnalysisOrchestration()
   * @generated
   * @ordered
   */
  protected AnalysisOrchestration analysisOrchestration;

  /**
   * The cached value of the '{@link #getResultManagement() <em>Result Management</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultManagement()
   * @generated
   * @ordered
   */
  protected ResultManagement resultManagement;

  /**
   * The cached value of the '{@link #getFinalization() <em>Finalization</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinalization()
   * @generated
   * @ordered
   */
  protected XExpression finalization;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MOMoTSearchImpl()
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
    return MomotPackage.Literals.MO_MO_TSEARCH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(String newPackage)
  {
    String oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__PACKAGE, oldPackage, package_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XImportSection getImportSection()
  {
    return importSection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImportSection(XImportSection newImportSection, NotificationChain msgs)
  {
    XImportSection oldImportSection = importSection;
    importSection = newImportSection;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION, oldImportSection, newImportSection);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportSection(XImportSection newImportSection)
  {
    if (newImportSection != importSection)
    {
      NotificationChain msgs = null;
      if (importSection != null)
        msgs = ((InternalEObject)importSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION, null, msgs);
      if (newImportSection != null)
        msgs = ((InternalEObject)newImportSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION, null, msgs);
      msgs = basicSetImportSection(newImportSection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION, newImportSection, newImportSection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VariableDeclaration> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, MomotPackage.MO_MO_TSEARCH__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getInitialization()
  {
    return initialization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitialization(XExpression newInitialization, NotificationChain msgs)
  {
    XExpression oldInitialization = initialization;
    initialization = newInitialization;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__INITIALIZATION, oldInitialization, newInitialization);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialization(XExpression newInitialization)
  {
    if (newInitialization != initialization)
    {
      NotificationChain msgs = null;
      if (initialization != null)
        msgs = ((InternalEObject)initialization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__INITIALIZATION, null, msgs);
      if (newInitialization != null)
        msgs = ((InternalEObject)newInitialization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__INITIALIZATION, null, msgs);
      msgs = basicSetInitialization(newInitialization, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__INITIALIZATION, newInitialization, newInitialization));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SearchOrchestration getSearchOrchestration()
  {
    return searchOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSearchOrchestration(SearchOrchestration newSearchOrchestration, NotificationChain msgs)
  {
    SearchOrchestration oldSearchOrchestration = searchOrchestration;
    searchOrchestration = newSearchOrchestration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION, oldSearchOrchestration, newSearchOrchestration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSearchOrchestration(SearchOrchestration newSearchOrchestration)
  {
    if (newSearchOrchestration != searchOrchestration)
    {
      NotificationChain msgs = null;
      if (searchOrchestration != null)
        msgs = ((InternalEObject)searchOrchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION, null, msgs);
      if (newSearchOrchestration != null)
        msgs = ((InternalEObject)newSearchOrchestration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION, null, msgs);
      msgs = basicSetSearchOrchestration(newSearchOrchestration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION, newSearchOrchestration, newSearchOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExperimentOrchestration getExperimentOrchestration()
  {
    return experimentOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExperimentOrchestration(ExperimentOrchestration newExperimentOrchestration, NotificationChain msgs)
  {
    ExperimentOrchestration oldExperimentOrchestration = experimentOrchestration;
    experimentOrchestration = newExperimentOrchestration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION, oldExperimentOrchestration, newExperimentOrchestration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExperimentOrchestration(ExperimentOrchestration newExperimentOrchestration)
  {
    if (newExperimentOrchestration != experimentOrchestration)
    {
      NotificationChain msgs = null;
      if (experimentOrchestration != null)
        msgs = ((InternalEObject)experimentOrchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION, null, msgs);
      if (newExperimentOrchestration != null)
        msgs = ((InternalEObject)newExperimentOrchestration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION, null, msgs);
      msgs = basicSetExperimentOrchestration(newExperimentOrchestration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION, newExperimentOrchestration, newExperimentOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnalysisOrchestration getAnalysisOrchestration()
  {
    return analysisOrchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAnalysisOrchestration(AnalysisOrchestration newAnalysisOrchestration, NotificationChain msgs)
  {
    AnalysisOrchestration oldAnalysisOrchestration = analysisOrchestration;
    analysisOrchestration = newAnalysisOrchestration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION, oldAnalysisOrchestration, newAnalysisOrchestration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnalysisOrchestration(AnalysisOrchestration newAnalysisOrchestration)
  {
    if (newAnalysisOrchestration != analysisOrchestration)
    {
      NotificationChain msgs = null;
      if (analysisOrchestration != null)
        msgs = ((InternalEObject)analysisOrchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION, null, msgs);
      if (newAnalysisOrchestration != null)
        msgs = ((InternalEObject)newAnalysisOrchestration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION, null, msgs);
      msgs = basicSetAnalysisOrchestration(newAnalysisOrchestration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION, newAnalysisOrchestration, newAnalysisOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultManagement getResultManagement()
  {
    return resultManagement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResultManagement(ResultManagement newResultManagement, NotificationChain msgs)
  {
    ResultManagement oldResultManagement = resultManagement;
    resultManagement = newResultManagement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT, oldResultManagement, newResultManagement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultManagement(ResultManagement newResultManagement)
  {
    if (newResultManagement != resultManagement)
    {
      NotificationChain msgs = null;
      if (resultManagement != null)
        msgs = ((InternalEObject)resultManagement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT, null, msgs);
      if (newResultManagement != null)
        msgs = ((InternalEObject)newResultManagement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT, null, msgs);
      msgs = basicSetResultManagement(newResultManagement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT, newResultManagement, newResultManagement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getFinalization()
  {
    return finalization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFinalization(XExpression newFinalization, NotificationChain msgs)
  {
    XExpression oldFinalization = finalization;
    finalization = newFinalization;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__FINALIZATION, oldFinalization, newFinalization);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinalization(XExpression newFinalization)
  {
    if (newFinalization != finalization)
    {
      NotificationChain msgs = null;
      if (finalization != null)
        msgs = ((InternalEObject)finalization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__FINALIZATION, null, msgs);
      if (newFinalization != null)
        msgs = ((InternalEObject)newFinalization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MomotPackage.MO_MO_TSEARCH__FINALIZATION, null, msgs);
      msgs = basicSetFinalization(newFinalization, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MomotPackage.MO_MO_TSEARCH__FINALIZATION, newFinalization, newFinalization));
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
      case MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION:
        return basicSetImportSection(null, msgs);
      case MomotPackage.MO_MO_TSEARCH__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case MomotPackage.MO_MO_TSEARCH__INITIALIZATION:
        return basicSetInitialization(null, msgs);
      case MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION:
        return basicSetSearchOrchestration(null, msgs);
      case MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION:
        return basicSetExperimentOrchestration(null, msgs);
      case MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION:
        return basicSetAnalysisOrchestration(null, msgs);
      case MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT:
        return basicSetResultManagement(null, msgs);
      case MomotPackage.MO_MO_TSEARCH__FINALIZATION:
        return basicSetFinalization(null, msgs);
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
      case MomotPackage.MO_MO_TSEARCH__PACKAGE:
        return getPackage();
      case MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION:
        return getImportSection();
      case MomotPackage.MO_MO_TSEARCH__VARIABLES:
        return getVariables();
      case MomotPackage.MO_MO_TSEARCH__INITIALIZATION:
        return getInitialization();
      case MomotPackage.MO_MO_TSEARCH__NAME:
        return getName();
      case MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION:
        return getSearchOrchestration();
      case MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION:
        return getExperimentOrchestration();
      case MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION:
        return getAnalysisOrchestration();
      case MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT:
        return getResultManagement();
      case MomotPackage.MO_MO_TSEARCH__FINALIZATION:
        return getFinalization();
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
      case MomotPackage.MO_MO_TSEARCH__PACKAGE:
        setPackage((String)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION:
        setImportSection((XImportSection)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends VariableDeclaration>)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__INITIALIZATION:
        setInitialization((XExpression)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__NAME:
        setName((String)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION:
        setSearchOrchestration((SearchOrchestration)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION:
        setExperimentOrchestration((ExperimentOrchestration)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION:
        setAnalysisOrchestration((AnalysisOrchestration)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT:
        setResultManagement((ResultManagement)newValue);
        return;
      case MomotPackage.MO_MO_TSEARCH__FINALIZATION:
        setFinalization((XExpression)newValue);
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
      case MomotPackage.MO_MO_TSEARCH__PACKAGE:
        setPackage(PACKAGE_EDEFAULT);
        return;
      case MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION:
        setImportSection((XImportSection)null);
        return;
      case MomotPackage.MO_MO_TSEARCH__VARIABLES:
        getVariables().clear();
        return;
      case MomotPackage.MO_MO_TSEARCH__INITIALIZATION:
        setInitialization((XExpression)null);
        return;
      case MomotPackage.MO_MO_TSEARCH__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION:
        setSearchOrchestration((SearchOrchestration)null);
        return;
      case MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION:
        setExperimentOrchestration((ExperimentOrchestration)null);
        return;
      case MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION:
        setAnalysisOrchestration((AnalysisOrchestration)null);
        return;
      case MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT:
        setResultManagement((ResultManagement)null);
        return;
      case MomotPackage.MO_MO_TSEARCH__FINALIZATION:
        setFinalization((XExpression)null);
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
      case MomotPackage.MO_MO_TSEARCH__PACKAGE:
        return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
      case MomotPackage.MO_MO_TSEARCH__IMPORT_SECTION:
        return importSection != null;
      case MomotPackage.MO_MO_TSEARCH__VARIABLES:
        return variables != null && !variables.isEmpty();
      case MomotPackage.MO_MO_TSEARCH__INITIALIZATION:
        return initialization != null;
      case MomotPackage.MO_MO_TSEARCH__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MomotPackage.MO_MO_TSEARCH__SEARCH_ORCHESTRATION:
        return searchOrchestration != null;
      case MomotPackage.MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION:
        return experimentOrchestration != null;
      case MomotPackage.MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION:
        return analysisOrchestration != null;
      case MomotPackage.MO_MO_TSEARCH__RESULT_MANAGEMENT:
        return resultManagement != null;
      case MomotPackage.MO_MO_TSEARCH__FINALIZATION:
        return finalization != null;
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
    result.append(" (package: ");
    result.append(package_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //MOMoTSearchImpl
