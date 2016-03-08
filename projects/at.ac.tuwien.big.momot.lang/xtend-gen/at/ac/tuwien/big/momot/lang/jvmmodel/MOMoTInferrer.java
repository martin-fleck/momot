package at.ac.tuwien.big.momot.lang.jvmmodel;

@SuppressWarnings("all")
public class MOMoTInferrer {
  public interface Name {
    public final static String FIELD_INITIAL_MODEL = "INITIAL_MODEL";
    
    public final static String FIELD_SOLUTION_LENGTH = "SOLUTION_LENGTH";
    
    public final static String FIELD_MODULES = "modules";
    
    public final static String FIELD_UNITS_TO_REMOVE = "unitsToRemove";
    
    public final static String FIELD_NON_SOLUTION_PARAMETERS = "nonSolutionParameters";
    
    public final static String FIELD_SOLUTION_REPAIRER = "solutionRepairer";
    
    public final static String FIELD_FITNESS_FUNCTION = "fitnessFunction";
    
    public final static String FIELD_POPULATION_SIZE = "populationSize";
    
    public final static String FIELD_MAX_EVALUATIONS = "maxEvaluations";
    
    public final static String FIELD_NR_RUNS = "nrRuns";
    
    public final static String FIELD_REFERENCE_SET = "referenceSet";
    
    public final static String FIELD_BASE_NAME = "baseName";
    
    public final static String FIELD_SIGNIFICANCE_LEVEL = "significanceLevel";
    
    public final static String FIELD_CREATE_PARAMETER_VALUE_KEY = "_parameterValueKey_";
    
    public final static String METHOD_CREATE_MODULE_MANAGER = "createModuleManager";
    
    public final static String METHOD_CREATE_FITNESS_FUNCTION = "createFitnessFunction";
    
    public final static String METHOD_CREATE_OBJECTIVE_PREFIX = "_createObjective_";
    
    public final static String METHOD_CREATE_OBJECTIVE_HELPER_PREFIX = "_createObjectiveHelper_";
    
    public final static String METHOD_CREATE_CONSTRAINT_PREFIX = "_createConstraint_";
    
    public final static String METHOD_CREATE_CONSTRAINT_HELPER_PREFIX = "_createConstraintHelper_";
    
    public final static String METHOD_CREATE_LISTENER_PREFIX = "_createListener_";
    
    public final static String METHOD_CREATE_COLLECTOR_PREFIX = "_createCollector_";
    
    public final static String METHOD_CREATE_EQUALITY_HELPER = "_createEqualityHelper_";
    
    public final static String METHOD_CREATE_EQUALITY_HELPER_HELPER = "_createEqualityHelperHelper_";
    
    public final static String METHOD_CREATE_PARAMETER_VALUE_PREFIX = "_createParameterValue_";
    
    public final static String METHOD_CREATE_ALGORITHM_PREFIX = "_createRegisteredAlgorithm_";
    
    public final static String METHOD_CREATE_ALGORITHM_HELPER_PREFIX = "_createAlgorithm_";
    
    public final static String METHOD_MAIN = "main";
    
    public final static String METHOD_INIT = "initialization";
    
    public final static String METHOD_FINAL = "finalization";
    
    public final static String METHOD_PERFORM_SEARCH = "performSearch";
    
    public final static String METHOD_PRINT_SEARCH_INFO = "printSearchInfo";
    
    public final static String METHOD_CREATE_ORCHESTRATION = "createOrchestration";
    
    public final static String METHOD_CREATE_INPUT_GRAPH = "createInputGraph";
    
    public final static String METHOD_ADAPT_INPUT_GRAPH = "adaptInputGraph";
    
    public final static String METHOD_ADAPT_INPUT_MODEL = "adaptInputModel";
    
    public final static String METHOD_CREATE_EXPERIMENT = "createExperiment";
    
    public final static String METHOD_PERFORM_ANALYSIS = "performAnalysis";
    
    public final static String METHOD_HANDLE_RESULTS = "handleResults";
    
    public final static String METHOD_ADAPT_MODELS = "adaptResultModels";
    
    public final static String METHOD_ADAPT_MODEL = "adaptResultModel";
    
    public final static String METHOD_DERIVE_BASE_NAME = "deriveBaseName";
    
    public final static String METHOD_FITNESS_PREPROCESS = "preprocessEvaluation";
    
    public final static String METHOD_FITNESS_POSTPROCESS = "postprocessEvaluation";
    
    public final static String PARAM_INITIAL_GRAPH = "initialGraph";
    
    public final static String PARAM_SOLUTION_LENGTH = "solutionLength";
    
    public final static String PARAM_ORCHESTRATION = "orchestration";
    
    public final static String PARAM_MODULE_MANAGER = "moduleManager";
    
    public final static String PARAM_MOEA_FACTORY = "moea";
    
    public final static String PARAM_LOCAL_FACTORY = "local";
    
    public final static String PARAM_EXPERIMENT = "experiment";
    
    public final static String PARAM_SEARCH_ANALYZER = "searchAnalyzer";
    
    public final static String PARAM_RESULT_MANAGER = "resultManager";
    
    public final static String PARAM_SOLUTION = "solution";
    
    public final static String PARAM_AGGREGATED_FITNESS = "aggregatedFitness";
    
    public final static String PARAM_GRAPH = "graph";
    
    public final static String PARAM_ROOT = "root";
    
    public final static String PARAM_EQUALITY_LEFT = "left";
    
    public final static String PARAM_EQUALITY_RIGHT = "right";
    
    public final static String PARAM_SOLUTION_WRITER = "solutionWriter";
    
    public final static String PARAM_POPULATION_WRITER = "populationWriter";
    
    public final static String PARAM_POPULATION = "population";
    
    public final static String PARAM_MODEL_FILES = "modelFiles";
  }
}
