/**
 */
package at.ac.tuwien.big.momot.lang.mOMoT.impl;

import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmList;
import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences;
import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification;
import at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupList;
import at.ac.tuwien.big.momot.lang.mOMoT.AnalysisGroupSpecification;
import at.ac.tuwien.big.momot.lang.mOMoT.AnalysisOrchestration;
import at.ac.tuwien.big.momot.lang.mOMoT.CollectorArray;
import at.ac.tuwien.big.momot.lang.mOMoT.DefExpression;
import at.ac.tuwien.big.momot.lang.mOMoT.EqualityHelper;
import at.ac.tuwien.big.momot.lang.mOMoT.ExperimentOrchestration;
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor;
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL;
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification;
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType;
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase;
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification;
import at.ac.tuwien.big.momot.lang.mOMoT.IndicatorArray;
import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTFactory;
import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage;
import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch;
import at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification;
import at.ac.tuwien.big.momot.lang.mOMoT.PrintObjectivesCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.PrintSolutionsCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.ResultManagement;
import at.ac.tuwien.big.momot.lang.mOMoT.SaveAnalysisCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.SaveSolutionsCommand;
import at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration;
import at.ac.tuwien.big.momot.lang.mOMoT.ShowArray;
import at.ac.tuwien.big.momot.lang.mOMoT.TransformationOrchestration;
import at.ac.tuwien.big.momot.lang.mOMoT.VariableDeclaration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MOMoTPackageImpl extends EPackageImpl implements MOMoTPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moMoTSearchEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transformationOrchestrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parmeterValueSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass searchOrchestrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityHelperEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass algorithmListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fitnessFunctionSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fitnessDimensionSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fitnessDimensionConstructorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fitnessDimensionXBaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fitnessDimensionOCLEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass algorithmSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass experimentOrchestrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectorArrayEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass analysisOrchestrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass analysisGroupListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indicatorArrayEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass showArrayEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass analysisGroupSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass algorithmReferencesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultManagementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass saveAnalysisCommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass saveObjectivesCommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass saveSolutionsCommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass printObjectivesCommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass printSolutionsCommandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum fitnessDimensionTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see at.ac.tuwien.big.momot.lang.mOMoT.MOMoTPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MOMoTPackageImpl()
  {
    super(eNS_URI, MOMoTFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link MOMoTPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MOMoTPackage init()
  {
    if (isInited) return (MOMoTPackage)EPackage.Registry.INSTANCE.getEPackage(MOMoTPackage.eNS_URI);

    // Obtain or create and register package
    MOMoTPackageImpl theMOMoTPackage = (MOMoTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MOMoTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MOMoTPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XbasePackage.eINSTANCE.eClass();
    XtypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theMOMoTPackage.createPackageContents();

    // Initialize created meta-data
    theMOMoTPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMOMoTPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MOMoTPackage.eNS_URI, theMOMoTPackage);
    return theMOMoTPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMOMoTSearch()
  {
    return moMoTSearchEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOMoTSearch_Package()
  {
    return (EAttribute)moMoTSearchEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOMoTSearch_ImportSection()
  {
    return (EReference)moMoTSearchEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOMoTSearch_Variables()
  {
    return (EReference)moMoTSearchEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOMoTSearch_Initialization()
  {
    return (EReference)moMoTSearchEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOMoTSearch_Name()
  {
    return (EAttribute)moMoTSearchEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOMoTSearch_SearchOrchestration()
  {
    return (EReference)moMoTSearchEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOMoTSearch_ExperimentOrchestration()
  {
    return (EReference)moMoTSearchEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOMoTSearch_AnalysisOrchestration()
  {
    return (EReference)moMoTSearchEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOMoTSearch_ResultManagement()
  {
    return (EReference)moMoTSearchEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDeclaration()
  {
    return variableDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclaration_Type()
  {
    return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDeclaration_Name()
  {
    return (EAttribute)variableDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclaration_Init()
  {
    return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformationOrchestration()
  {
    return transformationOrchestrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationOrchestration_Modules()
  {
    return (EReference)transformationOrchestrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationOrchestration_UnitsToRemove()
  {
    return (EReference)transformationOrchestrationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationOrchestration_NonSolutionParameters()
  {
    return (EReference)transformationOrchestrationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationOrchestration_ParameterValues()
  {
    return (EReference)transformationOrchestrationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParmeterValueSpecification()
  {
    return parmeterValueSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParmeterValueSpecification_Name()
  {
    return (EReference)parmeterValueSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParmeterValueSpecification_Call()
  {
    return (EReference)parmeterValueSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSearchOrchestration()
  {
    return searchOrchestrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSearchOrchestration_Model()
  {
    return (EReference)searchOrchestrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSearchOrchestration_SolutionLength()
  {
    return (EReference)searchOrchestrationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSearchOrchestration_TransformationOrchestration()
  {
    return (EReference)searchOrchestrationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSearchOrchestration_FitnessFunction()
  {
    return (EReference)searchOrchestrationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSearchOrchestration_Algorithms()
  {
    return (EReference)searchOrchestrationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSearchOrchestration_EqualityHelper()
  {
    return (EReference)searchOrchestrationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityHelper()
  {
    return equalityHelperEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityHelper_Call()
  {
    return (EReference)equalityHelperEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityHelper_Method()
  {
    return (EReference)equalityHelperEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlgorithmList()
  {
    return algorithmListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlgorithmList_Specifications()
  {
    return (EReference)algorithmListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFitnessFunctionSpecification()
  {
    return fitnessFunctionSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessFunctionSpecification_Constructor()
  {
    return (EReference)fitnessFunctionSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessFunctionSpecification_Preprocess()
  {
    return (EReference)fitnessFunctionSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessFunctionSpecification_Objectives()
  {
    return (EReference)fitnessFunctionSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessFunctionSpecification_Constraints()
  {
    return (EReference)fitnessFunctionSpecificationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessFunctionSpecification_Postprocess()
  {
    return (EReference)fitnessFunctionSpecificationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessFunctionSpecification_SolutionRepairer()
  {
    return (EReference)fitnessFunctionSpecificationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFitnessDimensionSpecification()
  {
    return fitnessDimensionSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFitnessDimensionSpecification_Name()
  {
    return (EAttribute)fitnessDimensionSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFitnessDimensionSpecification_Type()
  {
    return (EAttribute)fitnessDimensionSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFitnessDimensionConstructor()
  {
    return fitnessDimensionConstructorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessDimensionConstructor_Call()
  {
    return (EReference)fitnessDimensionConstructorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFitnessDimensionXBase()
  {
    return fitnessDimensionXBaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessDimensionXBase_Value()
  {
    return (EReference)fitnessDimensionXBaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFitnessDimensionOCL()
  {
    return fitnessDimensionOCLEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessDimensionOCL_Query()
  {
    return (EReference)fitnessDimensionOCLEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFitnessDimensionOCL_DefExpressions()
  {
    return (EReference)fitnessDimensionOCLEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefExpression()
  {
    return defExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefExpression_Expression()
  {
    return (EAttribute)defExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlgorithmSpecification()
  {
    return algorithmSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlgorithmSpecification_Name()
  {
    return (EAttribute)algorithmSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlgorithmSpecification_Call()
  {
    return (EReference)algorithmSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExperimentOrchestration()
  {
    return experimentOrchestrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExperimentOrchestration_PopulationSize()
  {
    return (EReference)experimentOrchestrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExperimentOrchestration_MaxEvaluations()
  {
    return (EReference)experimentOrchestrationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExperimentOrchestration_NrRuns()
  {
    return (EReference)experimentOrchestrationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExperimentOrchestration_ReferenceSet()
  {
    return (EReference)experimentOrchestrationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExperimentOrchestration_ProgressListeners()
  {
    return (EReference)experimentOrchestrationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExperimentOrchestration_Collectors()
  {
    return (EReference)experimentOrchestrationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExperimentOrchestration_CustomCollectors()
  {
    return (EReference)experimentOrchestrationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectorArray()
  {
    return collectorArrayEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_Hypervolume()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_GenerationalDistance()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_InvertedGenerationalDistance()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_Spacing()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_AdditiveEpsilonIndicator()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_Contribution()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_R1()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_R2()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_R3()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_AdaptiveMultimethodVariation()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_AdaptiveTimeContinuation()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_ApproximationSet()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_EpsilonProgress()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_ElapsedTime()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectorArray_PopulationSize()
  {
    return (EAttribute)collectorArrayEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnalysisOrchestration()
  {
    return analysisOrchestrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisOrchestration_Indicators()
  {
    return (EReference)analysisOrchestrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisOrchestration_Significance()
  {
    return (EReference)analysisOrchestrationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisOrchestration_Show()
  {
    return (EReference)analysisOrchestrationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisOrchestration_Grouping()
  {
    return (EReference)analysisOrchestrationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnalysisGroupList()
  {
    return analysisGroupListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisGroupList_Group()
  {
    return (EReference)analysisGroupListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndicatorArray()
  {
    return indicatorArrayEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_Hypervolume()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_GenerationalDistance()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_InvertedGenerationalDistance()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_Spacing()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_AdditiveEpsilonIndicator()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_Contribution()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_R1()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_R2()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_R3()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndicatorArray_MaximumParetoFrontError()
  {
    return (EAttribute)indicatorArrayEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShowArray()
  {
    return showArrayEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShowArray_Individual()
  {
    return (EAttribute)showArrayEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShowArray_Aggregate()
  {
    return (EAttribute)showArrayEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShowArray_StatisticalSignificance()
  {
    return (EAttribute)showArrayEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnalysisGroupSpecification()
  {
    return analysisGroupSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnalysisGroupSpecification_Name()
  {
    return (EAttribute)analysisGroupSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisGroupSpecification_Algorithms()
  {
    return (EReference)analysisGroupSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlgorithmReferences()
  {
    return algorithmReferencesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlgorithmReferences_Elements()
  {
    return (EReference)algorithmReferencesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultManagement()
  {
    return resultManagementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultManagement_SaveAnalysis()
  {
    return (EReference)resultManagementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultManagement_SaveObjectives()
  {
    return (EReference)resultManagementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultManagement_SaveSolutions()
  {
    return (EReference)resultManagementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultManagement_PrintObjectives()
  {
    return (EReference)resultManagementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultManagement_PrintSolutions()
  {
    return (EReference)resultManagementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultManagement_DoCommand()
  {
    return (EReference)resultManagementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSaveAnalysisCommand()
  {
    return saveAnalysisCommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSaveAnalysisCommand_File()
  {
    return (EReference)saveAnalysisCommandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSaveObjectivesCommand()
  {
    return saveObjectivesCommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSaveObjectivesCommand_Algorithms()
  {
    return (EReference)saveObjectivesCommandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSaveObjectivesCommand_File()
  {
    return (EAttribute)saveObjectivesCommandEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSaveSolutionsCommand()
  {
    return saveSolutionsCommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSaveSolutionsCommand_Algorithms()
  {
    return (EReference)saveSolutionsCommandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSaveSolutionsCommand_Directory()
  {
    return (EAttribute)saveSolutionsCommandEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrintObjectivesCommand()
  {
    return printObjectivesCommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrintObjectivesCommand_Algorithms()
  {
    return (EReference)printObjectivesCommandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrintSolutionsCommand()
  {
    return printSolutionsCommandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrintSolutionsCommand_Algorithms()
  {
    return (EReference)printSolutionsCommandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFitnessDimensionType()
  {
    return fitnessDimensionTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOMoTFactory getMOMoTFactory()
  {
    return (MOMoTFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    moMoTSearchEClass = createEClass(MO_MO_TSEARCH);
    createEAttribute(moMoTSearchEClass, MO_MO_TSEARCH__PACKAGE);
    createEReference(moMoTSearchEClass, MO_MO_TSEARCH__IMPORT_SECTION);
    createEReference(moMoTSearchEClass, MO_MO_TSEARCH__VARIABLES);
    createEReference(moMoTSearchEClass, MO_MO_TSEARCH__INITIALIZATION);
    createEAttribute(moMoTSearchEClass, MO_MO_TSEARCH__NAME);
    createEReference(moMoTSearchEClass, MO_MO_TSEARCH__SEARCH_ORCHESTRATION);
    createEReference(moMoTSearchEClass, MO_MO_TSEARCH__EXPERIMENT_ORCHESTRATION);
    createEReference(moMoTSearchEClass, MO_MO_TSEARCH__ANALYSIS_ORCHESTRATION);
    createEReference(moMoTSearchEClass, MO_MO_TSEARCH__RESULT_MANAGEMENT);

    variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
    createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);
    createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__NAME);
    createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__INIT);

    transformationOrchestrationEClass = createEClass(TRANSFORMATION_ORCHESTRATION);
    createEReference(transformationOrchestrationEClass, TRANSFORMATION_ORCHESTRATION__MODULES);
    createEReference(transformationOrchestrationEClass, TRANSFORMATION_ORCHESTRATION__UNITS_TO_REMOVE);
    createEReference(transformationOrchestrationEClass, TRANSFORMATION_ORCHESTRATION__NON_SOLUTION_PARAMETERS);
    createEReference(transformationOrchestrationEClass, TRANSFORMATION_ORCHESTRATION__PARAMETER_VALUES);

    parmeterValueSpecificationEClass = createEClass(PARMETER_VALUE_SPECIFICATION);
    createEReference(parmeterValueSpecificationEClass, PARMETER_VALUE_SPECIFICATION__NAME);
    createEReference(parmeterValueSpecificationEClass, PARMETER_VALUE_SPECIFICATION__CALL);

    searchOrchestrationEClass = createEClass(SEARCH_ORCHESTRATION);
    createEReference(searchOrchestrationEClass, SEARCH_ORCHESTRATION__MODEL);
    createEReference(searchOrchestrationEClass, SEARCH_ORCHESTRATION__SOLUTION_LENGTH);
    createEReference(searchOrchestrationEClass, SEARCH_ORCHESTRATION__TRANSFORMATION_ORCHESTRATION);
    createEReference(searchOrchestrationEClass, SEARCH_ORCHESTRATION__FITNESS_FUNCTION);
    createEReference(searchOrchestrationEClass, SEARCH_ORCHESTRATION__ALGORITHMS);
    createEReference(searchOrchestrationEClass, SEARCH_ORCHESTRATION__EQUALITY_HELPER);

    equalityHelperEClass = createEClass(EQUALITY_HELPER);
    createEReference(equalityHelperEClass, EQUALITY_HELPER__CALL);
    createEReference(equalityHelperEClass, EQUALITY_HELPER__METHOD);

    algorithmListEClass = createEClass(ALGORITHM_LIST);
    createEReference(algorithmListEClass, ALGORITHM_LIST__SPECIFICATIONS);

    fitnessFunctionSpecificationEClass = createEClass(FITNESS_FUNCTION_SPECIFICATION);
    createEReference(fitnessFunctionSpecificationEClass, FITNESS_FUNCTION_SPECIFICATION__CONSTRUCTOR);
    createEReference(fitnessFunctionSpecificationEClass, FITNESS_FUNCTION_SPECIFICATION__PREPROCESS);
    createEReference(fitnessFunctionSpecificationEClass, FITNESS_FUNCTION_SPECIFICATION__OBJECTIVES);
    createEReference(fitnessFunctionSpecificationEClass, FITNESS_FUNCTION_SPECIFICATION__CONSTRAINTS);
    createEReference(fitnessFunctionSpecificationEClass, FITNESS_FUNCTION_SPECIFICATION__POSTPROCESS);
    createEReference(fitnessFunctionSpecificationEClass, FITNESS_FUNCTION_SPECIFICATION__SOLUTION_REPAIRER);

    fitnessDimensionSpecificationEClass = createEClass(FITNESS_DIMENSION_SPECIFICATION);
    createEAttribute(fitnessDimensionSpecificationEClass, FITNESS_DIMENSION_SPECIFICATION__NAME);
    createEAttribute(fitnessDimensionSpecificationEClass, FITNESS_DIMENSION_SPECIFICATION__TYPE);

    fitnessDimensionConstructorEClass = createEClass(FITNESS_DIMENSION_CONSTRUCTOR);
    createEReference(fitnessDimensionConstructorEClass, FITNESS_DIMENSION_CONSTRUCTOR__CALL);

    fitnessDimensionXBaseEClass = createEClass(FITNESS_DIMENSION_XBASE);
    createEReference(fitnessDimensionXBaseEClass, FITNESS_DIMENSION_XBASE__VALUE);

    fitnessDimensionOCLEClass = createEClass(FITNESS_DIMENSION_OCL);
    createEReference(fitnessDimensionOCLEClass, FITNESS_DIMENSION_OCL__QUERY);
    createEReference(fitnessDimensionOCLEClass, FITNESS_DIMENSION_OCL__DEF_EXPRESSIONS);

    defExpressionEClass = createEClass(DEF_EXPRESSION);
    createEAttribute(defExpressionEClass, DEF_EXPRESSION__EXPRESSION);

    algorithmSpecificationEClass = createEClass(ALGORITHM_SPECIFICATION);
    createEAttribute(algorithmSpecificationEClass, ALGORITHM_SPECIFICATION__NAME);
    createEReference(algorithmSpecificationEClass, ALGORITHM_SPECIFICATION__CALL);

    experimentOrchestrationEClass = createEClass(EXPERIMENT_ORCHESTRATION);
    createEReference(experimentOrchestrationEClass, EXPERIMENT_ORCHESTRATION__POPULATION_SIZE);
    createEReference(experimentOrchestrationEClass, EXPERIMENT_ORCHESTRATION__MAX_EVALUATIONS);
    createEReference(experimentOrchestrationEClass, EXPERIMENT_ORCHESTRATION__NR_RUNS);
    createEReference(experimentOrchestrationEClass, EXPERIMENT_ORCHESTRATION__REFERENCE_SET);
    createEReference(experimentOrchestrationEClass, EXPERIMENT_ORCHESTRATION__PROGRESS_LISTENERS);
    createEReference(experimentOrchestrationEClass, EXPERIMENT_ORCHESTRATION__COLLECTORS);
    createEReference(experimentOrchestrationEClass, EXPERIMENT_ORCHESTRATION__CUSTOM_COLLECTORS);

    collectorArrayEClass = createEClass(COLLECTOR_ARRAY);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__HYPERVOLUME);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__GENERATIONAL_DISTANCE);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__SPACING);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__ADDITIVE_EPSILON_INDICATOR);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__CONTRIBUTION);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__R1);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__R2);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__R3);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__ADAPTIVE_MULTIMETHOD_VARIATION);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__ADAPTIVE_TIME_CONTINUATION);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__APPROXIMATION_SET);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__EPSILON_PROGRESS);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__ELAPSED_TIME);
    createEAttribute(collectorArrayEClass, COLLECTOR_ARRAY__POPULATION_SIZE);

    analysisOrchestrationEClass = createEClass(ANALYSIS_ORCHESTRATION);
    createEReference(analysisOrchestrationEClass, ANALYSIS_ORCHESTRATION__INDICATORS);
    createEReference(analysisOrchestrationEClass, ANALYSIS_ORCHESTRATION__SIGNIFICANCE);
    createEReference(analysisOrchestrationEClass, ANALYSIS_ORCHESTRATION__SHOW);
    createEReference(analysisOrchestrationEClass, ANALYSIS_ORCHESTRATION__GROUPING);

    analysisGroupListEClass = createEClass(ANALYSIS_GROUP_LIST);
    createEReference(analysisGroupListEClass, ANALYSIS_GROUP_LIST__GROUP);

    indicatorArrayEClass = createEClass(INDICATOR_ARRAY);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__HYPERVOLUME);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__GENERATIONAL_DISTANCE);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__INVERTED_GENERATIONAL_DISTANCE);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__SPACING);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__ADDITIVE_EPSILON_INDICATOR);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__CONTRIBUTION);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__R1);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__R2);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__R3);
    createEAttribute(indicatorArrayEClass, INDICATOR_ARRAY__MAXIMUM_PARETO_FRONT_ERROR);

    showArrayEClass = createEClass(SHOW_ARRAY);
    createEAttribute(showArrayEClass, SHOW_ARRAY__INDIVIDUAL);
    createEAttribute(showArrayEClass, SHOW_ARRAY__AGGREGATE);
    createEAttribute(showArrayEClass, SHOW_ARRAY__STATISTICAL_SIGNIFICANCE);

    analysisGroupSpecificationEClass = createEClass(ANALYSIS_GROUP_SPECIFICATION);
    createEAttribute(analysisGroupSpecificationEClass, ANALYSIS_GROUP_SPECIFICATION__NAME);
    createEReference(analysisGroupSpecificationEClass, ANALYSIS_GROUP_SPECIFICATION__ALGORITHMS);

    algorithmReferencesEClass = createEClass(ALGORITHM_REFERENCES);
    createEReference(algorithmReferencesEClass, ALGORITHM_REFERENCES__ELEMENTS);

    resultManagementEClass = createEClass(RESULT_MANAGEMENT);
    createEReference(resultManagementEClass, RESULT_MANAGEMENT__SAVE_ANALYSIS);
    createEReference(resultManagementEClass, RESULT_MANAGEMENT__SAVE_OBJECTIVES);
    createEReference(resultManagementEClass, RESULT_MANAGEMENT__SAVE_SOLUTIONS);
    createEReference(resultManagementEClass, RESULT_MANAGEMENT__PRINT_OBJECTIVES);
    createEReference(resultManagementEClass, RESULT_MANAGEMENT__PRINT_SOLUTIONS);
    createEReference(resultManagementEClass, RESULT_MANAGEMENT__DO_COMMAND);

    saveAnalysisCommandEClass = createEClass(SAVE_ANALYSIS_COMMAND);
    createEReference(saveAnalysisCommandEClass, SAVE_ANALYSIS_COMMAND__FILE);

    saveObjectivesCommandEClass = createEClass(SAVE_OBJECTIVES_COMMAND);
    createEReference(saveObjectivesCommandEClass, SAVE_OBJECTIVES_COMMAND__ALGORITHMS);
    createEAttribute(saveObjectivesCommandEClass, SAVE_OBJECTIVES_COMMAND__FILE);

    saveSolutionsCommandEClass = createEClass(SAVE_SOLUTIONS_COMMAND);
    createEReference(saveSolutionsCommandEClass, SAVE_SOLUTIONS_COMMAND__ALGORITHMS);
    createEAttribute(saveSolutionsCommandEClass, SAVE_SOLUTIONS_COMMAND__DIRECTORY);

    printObjectivesCommandEClass = createEClass(PRINT_OBJECTIVES_COMMAND);
    createEReference(printObjectivesCommandEClass, PRINT_OBJECTIVES_COMMAND__ALGORITHMS);

    printSolutionsCommandEClass = createEClass(PRINT_SOLUTIONS_COMMAND);
    createEReference(printSolutionsCommandEClass, PRINT_SOLUTIONS_COMMAND__ALGORITHMS);

    // Create enums
    fitnessDimensionTypeEEnum = createEEnum(FITNESS_DIMENSION_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XtypePackage theXtypePackage = (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    fitnessDimensionConstructorEClass.getESuperTypes().add(this.getFitnessDimensionSpecification());
    fitnessDimensionXBaseEClass.getESuperTypes().add(this.getFitnessDimensionSpecification());
    fitnessDimensionOCLEClass.getESuperTypes().add(this.getFitnessDimensionSpecification());

    // Initialize classes and features; add operations and parameters
    initEClass(moMoTSearchEClass, MOMoTSearch.class, "MOMoTSearch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMOMoTSearch_Package(), ecorePackage.getEString(), "package", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOMoTSearch_ImportSection(), theXtypePackage.getXImportSection(), null, "importSection", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOMoTSearch_Variables(), this.getVariableDeclaration(), null, "variables", null, 0, -1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOMoTSearch_Initialization(), theXbasePackage.getXExpression(), null, "initialization", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOMoTSearch_Name(), ecorePackage.getEString(), "name", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOMoTSearch_SearchOrchestration(), this.getSearchOrchestration(), null, "searchOrchestration", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOMoTSearch_ExperimentOrchestration(), this.getExperimentOrchestration(), null, "experimentOrchestration", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOMoTSearch_AnalysisOrchestration(), this.getAnalysisOrchestration(), null, "analysisOrchestration", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOMoTSearch_ResultManagement(), this.getResultManagement(), null, "resultManagement", null, 0, 1, MOMoTSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableDeclaration_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDeclaration_Init(), theXbasePackage.getXExpression(), null, "init", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationOrchestrationEClass, TransformationOrchestration.class, "TransformationOrchestration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransformationOrchestration_Modules(), theXbasePackage.getXListLiteral(), null, "modules", null, 0, 1, TransformationOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationOrchestration_UnitsToRemove(), theXbasePackage.getXListLiteral(), null, "unitsToRemove", null, 0, 1, TransformationOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationOrchestration_NonSolutionParameters(), theXbasePackage.getXListLiteral(), null, "nonSolutionParameters", null, 0, 1, TransformationOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationOrchestration_ParameterValues(), this.getParmeterValueSpecification(), null, "parameterValues", null, 0, -1, TransformationOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parmeterValueSpecificationEClass, ParmeterValueSpecification.class, "ParmeterValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParmeterValueSpecification_Name(), theXbasePackage.getXExpression(), null, "name", null, 0, 1, ParmeterValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParmeterValueSpecification_Call(), theXbasePackage.getXExpression(), null, "call", null, 0, 1, ParmeterValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchOrchestrationEClass, SearchOrchestration.class, "SearchOrchestration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSearchOrchestration_Model(), theXbasePackage.getXExpression(), null, "model", null, 0, 1, SearchOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchOrchestration_SolutionLength(), theXbasePackage.getXExpression(), null, "solutionLength", null, 0, 1, SearchOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchOrchestration_TransformationOrchestration(), this.getTransformationOrchestration(), null, "transformationOrchestration", null, 0, 1, SearchOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchOrchestration_FitnessFunction(), this.getFitnessFunctionSpecification(), null, "fitnessFunction", null, 0, 1, SearchOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchOrchestration_Algorithms(), this.getAlgorithmList(), null, "algorithms", null, 0, 1, SearchOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchOrchestration_EqualityHelper(), this.getEqualityHelper(), null, "equalityHelper", null, 0, 1, SearchOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityHelperEClass, EqualityHelper.class, "EqualityHelper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEqualityHelper_Call(), theXbasePackage.getXExpression(), null, "call", null, 0, 1, EqualityHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEqualityHelper_Method(), theXbasePackage.getXExpression(), null, "method", null, 0, 1, EqualityHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(algorithmListEClass, AlgorithmList.class, "AlgorithmList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAlgorithmList_Specifications(), this.getAlgorithmSpecification(), null, "specifications", null, 0, -1, AlgorithmList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fitnessFunctionSpecificationEClass, FitnessFunctionSpecification.class, "FitnessFunctionSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFitnessFunctionSpecification_Constructor(), theXbasePackage.getXExpression(), null, "constructor", null, 0, 1, FitnessFunctionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFitnessFunctionSpecification_Preprocess(), theXbasePackage.getXExpression(), null, "preprocess", null, 0, 1, FitnessFunctionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFitnessFunctionSpecification_Objectives(), this.getFitnessDimensionSpecification(), null, "objectives", null, 0, -1, FitnessFunctionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFitnessFunctionSpecification_Constraints(), this.getFitnessDimensionSpecification(), null, "constraints", null, 0, -1, FitnessFunctionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFitnessFunctionSpecification_Postprocess(), theXbasePackage.getXExpression(), null, "postprocess", null, 0, 1, FitnessFunctionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFitnessFunctionSpecification_SolutionRepairer(), theXbasePackage.getXExpression(), null, "solutionRepairer", null, 0, 1, FitnessFunctionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fitnessDimensionSpecificationEClass, FitnessDimensionSpecification.class, "FitnessDimensionSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFitnessDimensionSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, FitnessDimensionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFitnessDimensionSpecification_Type(), this.getFitnessDimensionType(), "type", null, 0, 1, FitnessDimensionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fitnessDimensionConstructorEClass, FitnessDimensionConstructor.class, "FitnessDimensionConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFitnessDimensionConstructor_Call(), theXbasePackage.getXExpression(), null, "call", null, 0, 1, FitnessDimensionConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fitnessDimensionXBaseEClass, FitnessDimensionXBase.class, "FitnessDimensionXBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFitnessDimensionXBase_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, FitnessDimensionXBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fitnessDimensionOCLEClass, FitnessDimensionOCL.class, "FitnessDimensionOCL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFitnessDimensionOCL_Query(), theXbasePackage.getXExpression(), null, "query", null, 0, 1, FitnessDimensionOCL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFitnessDimensionOCL_DefExpressions(), this.getDefExpression(), null, "defExpressions", null, 0, -1, FitnessDimensionOCL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defExpressionEClass, DefExpression.class, "DefExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDefExpression_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, DefExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(algorithmSpecificationEClass, AlgorithmSpecification.class, "AlgorithmSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlgorithmSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, AlgorithmSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAlgorithmSpecification_Call(), theXbasePackage.getXExpression(), null, "call", null, 0, 1, AlgorithmSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(experimentOrchestrationEClass, ExperimentOrchestration.class, "ExperimentOrchestration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExperimentOrchestration_PopulationSize(), theXbasePackage.getXExpression(), null, "populationSize", null, 0, 1, ExperimentOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExperimentOrchestration_MaxEvaluations(), theXbasePackage.getXExpression(), null, "maxEvaluations", null, 0, 1, ExperimentOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExperimentOrchestration_NrRuns(), theXbasePackage.getXExpression(), null, "nrRuns", null, 0, 1, ExperimentOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExperimentOrchestration_ReferenceSet(), theXbasePackage.getXExpression(), null, "referenceSet", null, 0, 1, ExperimentOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExperimentOrchestration_ProgressListeners(), theXbasePackage.getXExpression(), null, "progressListeners", null, 0, -1, ExperimentOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExperimentOrchestration_Collectors(), this.getCollectorArray(), null, "collectors", null, 0, 1, ExperimentOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExperimentOrchestration_CustomCollectors(), theXbasePackage.getXExpression(), null, "customCollectors", null, 0, -1, ExperimentOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectorArrayEClass, CollectorArray.class, "CollectorArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCollectorArray_Hypervolume(), ecorePackage.getEBoolean(), "hypervolume", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_GenerationalDistance(), ecorePackage.getEBoolean(), "generationalDistance", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_InvertedGenerationalDistance(), ecorePackage.getEBoolean(), "invertedGenerationalDistance", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_Spacing(), ecorePackage.getEBoolean(), "spacing", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_AdditiveEpsilonIndicator(), ecorePackage.getEBoolean(), "additiveEpsilonIndicator", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_Contribution(), ecorePackage.getEBoolean(), "contribution", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_R1(), ecorePackage.getEBoolean(), "r1", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_R2(), ecorePackage.getEBoolean(), "r2", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_R3(), ecorePackage.getEBoolean(), "r3", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_AdaptiveMultimethodVariation(), ecorePackage.getEBoolean(), "adaptiveMultimethodVariation", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_AdaptiveTimeContinuation(), ecorePackage.getEBoolean(), "adaptiveTimeContinuation", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_ApproximationSet(), ecorePackage.getEBoolean(), "approximationSet", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_EpsilonProgress(), ecorePackage.getEBoolean(), "epsilonProgress", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_ElapsedTime(), ecorePackage.getEBoolean(), "elapsedTime", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCollectorArray_PopulationSize(), ecorePackage.getEBoolean(), "populationSize", null, 0, 1, CollectorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(analysisOrchestrationEClass, AnalysisOrchestration.class, "AnalysisOrchestration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAnalysisOrchestration_Indicators(), this.getIndicatorArray(), null, "indicators", null, 0, 1, AnalysisOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnalysisOrchestration_Significance(), theXbasePackage.getXExpression(), null, "significance", null, 0, 1, AnalysisOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnalysisOrchestration_Show(), this.getShowArray(), null, "show", null, 0, 1, AnalysisOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnalysisOrchestration_Grouping(), this.getAnalysisGroupList(), null, "grouping", null, 0, 1, AnalysisOrchestration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(analysisGroupListEClass, AnalysisGroupList.class, "AnalysisGroupList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAnalysisGroupList_Group(), this.getAnalysisGroupSpecification(), null, "group", null, 0, -1, AnalysisGroupList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(indicatorArrayEClass, IndicatorArray.class, "IndicatorArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIndicatorArray_Hypervolume(), ecorePackage.getEBoolean(), "hypervolume", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_GenerationalDistance(), ecorePackage.getEBoolean(), "generationalDistance", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_InvertedGenerationalDistance(), ecorePackage.getEBoolean(), "invertedGenerationalDistance", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_Spacing(), ecorePackage.getEBoolean(), "spacing", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_AdditiveEpsilonIndicator(), ecorePackage.getEBoolean(), "additiveEpsilonIndicator", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_Contribution(), ecorePackage.getEBoolean(), "contribution", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_R1(), ecorePackage.getEBoolean(), "r1", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_R2(), ecorePackage.getEBoolean(), "r2", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_R3(), ecorePackage.getEBoolean(), "r3", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndicatorArray_MaximumParetoFrontError(), ecorePackage.getEBoolean(), "maximumParetoFrontError", null, 0, 1, IndicatorArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(showArrayEClass, ShowArray.class, "ShowArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getShowArray_Individual(), ecorePackage.getEBoolean(), "individual", null, 0, 1, ShowArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShowArray_Aggregate(), ecorePackage.getEBoolean(), "aggregate", null, 0, 1, ShowArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShowArray_StatisticalSignificance(), ecorePackage.getEBoolean(), "statisticalSignificance", null, 0, 1, ShowArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(analysisGroupSpecificationEClass, AnalysisGroupSpecification.class, "AnalysisGroupSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAnalysisGroupSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, AnalysisGroupSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnalysisGroupSpecification_Algorithms(), this.getAlgorithmReferences(), null, "algorithms", null, 0, 1, AnalysisGroupSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(algorithmReferencesEClass, AlgorithmReferences.class, "AlgorithmReferences", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAlgorithmReferences_Elements(), this.getAlgorithmSpecification(), null, "elements", null, 0, -1, AlgorithmReferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultManagementEClass, ResultManagement.class, "ResultManagement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResultManagement_SaveAnalysis(), this.getSaveAnalysisCommand(), null, "saveAnalysis", null, 0, 1, ResultManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultManagement_SaveObjectives(), this.getSaveObjectivesCommand(), null, "saveObjectives", null, 0, -1, ResultManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultManagement_SaveSolutions(), this.getSaveSolutionsCommand(), null, "saveSolutions", null, 0, -1, ResultManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultManagement_PrintObjectives(), this.getPrintObjectivesCommand(), null, "printObjectives", null, 0, -1, ResultManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultManagement_PrintSolutions(), this.getPrintSolutionsCommand(), null, "printSolutions", null, 0, -1, ResultManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultManagement_DoCommand(), theXbasePackage.getXExpression(), null, "doCommand", null, 0, 1, ResultManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(saveAnalysisCommandEClass, SaveAnalysisCommand.class, "SaveAnalysisCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSaveAnalysisCommand_File(), theXbasePackage.getXExpression(), null, "file", null, 0, 1, SaveAnalysisCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(saveObjectivesCommandEClass, SaveObjectivesCommand.class, "SaveObjectivesCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSaveObjectivesCommand_Algorithms(), this.getAlgorithmReferences(), null, "algorithms", null, 0, 1, SaveObjectivesCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSaveObjectivesCommand_File(), ecorePackage.getEString(), "file", null, 0, 1, SaveObjectivesCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(saveSolutionsCommandEClass, SaveSolutionsCommand.class, "SaveSolutionsCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSaveSolutionsCommand_Algorithms(), this.getAlgorithmReferences(), null, "algorithms", null, 0, 1, SaveSolutionsCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSaveSolutionsCommand_Directory(), ecorePackage.getEString(), "directory", null, 0, 1, SaveSolutionsCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(printObjectivesCommandEClass, PrintObjectivesCommand.class, "PrintObjectivesCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrintObjectivesCommand_Algorithms(), this.getAlgorithmReferences(), null, "algorithms", null, 0, 1, PrintObjectivesCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(printSolutionsCommandEClass, PrintSolutionsCommand.class, "PrintSolutionsCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrintSolutionsCommand_Algorithms(), this.getAlgorithmReferences(), null, "algorithms", null, 0, 1, PrintSolutionsCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(fitnessDimensionTypeEEnum, FitnessDimensionType.class, "FitnessDimensionType");
    addEEnumLiteral(fitnessDimensionTypeEEnum, FitnessDimensionType.MINIMIZE);
    addEEnumLiteral(fitnessDimensionTypeEEnum, FitnessDimensionType.MAXIMIZE);

    // Create resource
    createResource(eNS_URI);
  }

} //MOMoTPackageImpl
