package at.ac.tuwien.big.momot.lang.preference;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

public final class MOMoTPreferences {
   public static final String PREFERENCE_QUALIFIER = "at.ac.tuwien.big.momot.lang.preference";

   public static final String EVALUATION_ALGORITHM_RUNS = "EVALUATION_ALGORITHM_RUNS";

   public static final String EVALUATION_NR_ITERATIONS = "EVALUATION_NR_ITERATIONS";

   public static final String EVALUATION_POPULATION_SIZE = "EVALUATION_POPULATION_SIZE";

   public static final String EVALUATION_MODULE_EXISTENCE = "EVALUATION_MODULE_EXISTENCE";

   public static final String EVALUATION_MODEL_EXISTENCE = "EVALUATION_MODEL_EXISTENCE";

   public static final String EVALUATION_UNIT_EXISTENCE = "EVALUATION_UNIT_EXISTENCE";

   public static final String EVALUATION_UNIT_APPLICABILITY = "EVALUATION_UNIT_APPLICABILITY";

   public static final String EVALUATION_PARAMETER_EXISTENCE = "EVALUATION_PARAMETER_EXISTENCE";

   public static final String EVALUATION_REFERENCE_SET_EXISTENCE = "EVALUATION_REFERENCE_SET_EXISTENCE";

   public static final String EVALUATION_MANY_OBJECTIVES = "EVALUATION_MANY_OBJECTIVES";

   public static final String EVALUATION_SINGLE_OBJECTIVE = "EVALUATION_SINGLE_OBJECTIVE";

   public static final String EVALUATION_OBJECT_IDENTITY = "EVALUATION_OBJECT_IDENTITY";

   public static final String EVALUATION_OBJECTIVES_FILE_OVERRIDDEN = "EVALUATION_OBJECTIVES_FILE_OVERRIDDEN";

   public static final String EVALUATION_ANALYSIS_FILE_OVERRIDDEN = "EVALUATION_ANALYSIS_FILE_OVERRIDDEN";

   public static final String EVALUATION_SOLUTIONS_FILE_OVERRIDDEN = "EVALUATION_SOLUTIONS_FILE_OVERRIDDEN";

   public static final String EVALUATION_DUPLICATE_ALGORITHM_NAME = "EVALUATION_DUPLICATE_ALGORITHM_NAME";

   public static final String EVALUATION_DUPLICATE_ALGORITHM_REFERENCE = "EVALUATION_DUPLICATE_ALGORITHM_REFERENCE";

   public static final String EVALUATION_DUPLICATE_PARAMETER_KEYS = "EVALUATION_DUPLICATE_PARAMETER_KEYS";

   public static final String EVALUATION_OCL = "EVALUATION_OCL";

   public static boolean flush() {
      try {
         getPreferences().flush();
         return true;
      } catch(final BackingStoreException e) {
      }
      return false;
   }

   public static boolean getEvaluationAlgorithmRuns() {
      return getPreferences().getBoolean(EVALUATION_ALGORITHM_RUNS, getEvaluationAlgorithmRunsDefault());
   }

   public static boolean getEvaluationAlgorithmRunsDefault() {
      return true;
   }

   public static boolean getEvaluationAnalysisFileOverriden() {
      return getPreferences().getBoolean(EVALUATION_ANALYSIS_FILE_OVERRIDDEN,
            getEvaluationAnalysisFileOverridenDefault());
   }

   public static boolean getEvaluationAnalysisFileOverridenDefault() {
      return true;
   }

   public static boolean getEvaluationDuplicateAlgorithmName() {
      return getPreferences().getBoolean(EVALUATION_DUPLICATE_ALGORITHM_NAME,
            getEvaluationDuplicateAlgorithmNameDefault());
   }

   public static boolean getEvaluationDuplicateAlgorithmNameDefault() {
      return true;
   }

   public static boolean getEvaluationDuplicateAlgorithmReference() {
      return getPreferences().getBoolean(EVALUATION_DUPLICATE_ALGORITHM_REFERENCE,
            getEvaluationDuplicateAlgorithmReferenceDefault());
   }

   public static boolean getEvaluationDuplicateAlgorithmReferenceDefault() {
      return true;
   }

   public static boolean getEvaluationDuplicateParameterKeys() {
      return getPreferences().getBoolean(EVALUATION_DUPLICATE_PARAMETER_KEYS,
            getEvaluationDuplicateParameterKeysDefault());
   }

   public static boolean getEvaluationDuplicateParameterKeysDefault() {
      return true;
   }

   public static boolean getEvaluationManyObjectives() {
      return getPreferences().getBoolean(EVALUATION_MANY_OBJECTIVES, getEvaluationManyObjectivesDefault());
   }

   public static boolean getEvaluationManyObjectivesDefault() {
      return true;
   }

   public static boolean getEvaluationModelFileExistence() {
      return getPreferences().getBoolean(EVALUATION_MODEL_EXISTENCE, getEvaluationModelFileExistenceDefault());
   }

   public static boolean getEvaluationModelFileExistenceDefault() {
      return true;
   }

   public static boolean getEvaluationModuleFileExistence() {
      return getPreferences().getBoolean(EVALUATION_MODULE_EXISTENCE, getEvaluationModuleFileExistenceDefault());
   }

   public static boolean getEvaluationModuleFileExistenceDefault() {
      return true;
   }

   public static boolean getEvaluationNrIterations() {
      return getPreferences().getBoolean(EVALUATION_NR_ITERATIONS, getEvaluationNrIterationsDefault());
   }

   public static boolean getEvaluationNrIterationsDefault() {
      return true;
   }

   public static boolean getEvaluationObjectIdentity() {
      return getPreferences().getBoolean(EVALUATION_OBJECT_IDENTITY, getEvaluationObjectIdentityDefault());
   }

   public static boolean getEvaluationObjectIdentityDefault() {
      return true;
   }

   public static boolean getEvaluationObjectivesFileOverriden() {
      return getPreferences().getBoolean(EVALUATION_OBJECTIVES_FILE_OVERRIDDEN,
            getEvaluationObjectivesFileOverridenDefault());
   }

   public static boolean getEvaluationObjectivesFileOverridenDefault() {
      return true;
   }

   public static boolean getEvaluationOCL() {
      return getPreferences().getBoolean(EVALUATION_OCL, getEvaluationOCLDefault());
   }

   public static boolean getEvaluationOCLDefault() {
      return true;
   }

   public static boolean getEvaluationParameterExistence() {
      return getPreferences().getBoolean(EVALUATION_PARAMETER_EXISTENCE, getEvaluationParameterExistenceDefault());
   }

   public static boolean getEvaluationParameterExistenceDefault() {
      return false;
   }

   public static boolean getEvaluationPopulationSize() {
      return getPreferences().getBoolean(EVALUATION_POPULATION_SIZE, getEvaluationPopulationSizeDefault());
   }

   public static boolean getEvaluationPopulationSizeDefault() {
      return true;
   }

   public static boolean getEvaluationReferenceSetExistence() {
      return getPreferences().getBoolean(EVALUATION_REFERENCE_SET_EXISTENCE,
            getEvaluationReferenceSetExistenceDefault());
   }

   public static boolean getEvaluationReferenceSetExistenceDefault() {
      return true;
   }

   public static boolean getEvaluationSingleObjective() {
      return getPreferences().getBoolean(EVALUATION_SINGLE_OBJECTIVE, getEvaluationSingleObjectiveDefault());
   }

   public static boolean getEvaluationSingleObjectiveDefault() {
      return true;
   }

   public static boolean getEvaluationSolutionsFileOverriden() {
      return getPreferences().getBoolean(EVALUATION_SOLUTIONS_FILE_OVERRIDDEN,
            getEvaluationSolutionsFileOverridenDefault());
   }

   public static boolean getEvaluationSolutionsFileOverridenDefault() {
      return true;
   }

   public static boolean getEvaluationUnitApplicability() {
      return getPreferences().getBoolean(EVALUATION_UNIT_APPLICABILITY, getEvaluationUnitApplicabilityDefault());
   }

   public static boolean getEvaluationUnitApplicabilityDefault() {
      return false;
   }

   public static boolean getEvaluationUnitExistence() {
      return getPreferences().getBoolean(EVALUATION_UNIT_EXISTENCE, getEvaluationUnitExistenceDefault());
   }

   public static boolean getEvaluationUnitExistenceDefault() {
      return false;
   }

   public static IEclipsePreferences getPreferences() {
      return InstanceScope.INSTANCE.getNode(PREFERENCE_QUALIFIER);
   }

   public static void setEvaluationAlgorithmRuns(final boolean value) {
      getPreferences().putBoolean(EVALUATION_ALGORITHM_RUNS, value);
   }

   public static void setEvaluationAnalysisFileOverriden(final boolean value) {
      getPreferences().putBoolean(EVALUATION_ANALYSIS_FILE_OVERRIDDEN, value);
   }

   public static void setEvaluationDuplicateAlgorithmName(final boolean value) {
      getPreferences().putBoolean(EVALUATION_DUPLICATE_ALGORITHM_NAME, value);
   }

   public static void setEvaluationDuplicateAlgorithmReference(final boolean value) {
      getPreferences().putBoolean(EVALUATION_DUPLICATE_ALGORITHM_REFERENCE, value);
   }

   public static void setEvaluationDuplicateParameterKeys(final boolean value) {
      getPreferences().putBoolean(EVALUATION_DUPLICATE_PARAMETER_KEYS, value);
   }

   public static void setEvaluationManyObjectives(final boolean value) {
      getPreferences().putBoolean(EVALUATION_MANY_OBJECTIVES, value);
   }

   public static void setEvaluationModelFileExistence(final boolean value) {
      getPreferences().putBoolean(EVALUATION_MODEL_EXISTENCE, value);
   }

   public static void setEvaluationModuleFileExistence(final boolean value) {
      getPreferences().putBoolean(EVALUATION_MODULE_EXISTENCE, value);
   }

   public static void setEvaluationNrIterations(final boolean value) {
      getPreferences().putBoolean(EVALUATION_NR_ITERATIONS, value);
   }

   public static void setEvaluationObjectIdentity(final boolean value) {
      getPreferences().putBoolean(EVALUATION_OBJECT_IDENTITY, value);
   }

   public static void setEvaluationObjectivesFileOverriden(final boolean value) {
      getPreferences().putBoolean(EVALUATION_OBJECTIVES_FILE_OVERRIDDEN, value);
   }

   public static void setEvaluationOCL(final boolean value) {
      getPreferences().putBoolean(EVALUATION_OCL, value);
   }

   public static void setEvaluationParameterExistence(final boolean value) {
      getPreferences().putBoolean(EVALUATION_PARAMETER_EXISTENCE, value);
   }

   public static void setEvaluationPopulationSize(final boolean value) {
      getPreferences().putBoolean(EVALUATION_POPULATION_SIZE, value);
   }

   public static void setEvaluationReferenceSetExistence(final boolean value) {
      getPreferences().putBoolean(EVALUATION_REFERENCE_SET_EXISTENCE, value);
   }

   public static void setEvaluationSingleObjective(final boolean value) {
      getPreferences().putBoolean(EVALUATION_SINGLE_OBJECTIVE, value);
   }

   public static void setEvaluationSolutionsFileOverriden(final boolean value) {
      getPreferences().putBoolean(EVALUATION_SOLUTIONS_FILE_OVERRIDDEN, value);
   }

   public static void setEvaluationUnitApplicability(final boolean value) {
      getPreferences().putBoolean(EVALUATION_UNIT_APPLICABILITY, value);
   }

   public static void setEvaluationUnitExistence(final boolean value) {
      getPreferences().putBoolean(EVALUATION_UNIT_EXISTENCE, value);
   }

   private MOMoTPreferences() {}
}
