package at.ac.tuwien.big.momot.lang.ui.preference;

import at.ac.tuwien.big.momot.lang.preference.MOMoTPreferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class EvaluationPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

   private Button algorithmRuns;
   private Button nrIterations;
   private Button populationSize;
   private Button modelFileExistence;
   private Button moduleFileExistence;
   private Button unitExistence;
   private Button unitApplicability;
   private Button parameterExistence;
   private Button referenceSetExistence;
   private Button manyObjectives;
   private Button singleObjective;
   private Button objectIdentity;
   private Button objectivesFileOverriden;
   private Button analysisFileOverriden;
   private Button solutionsFileOverriden;
   private Button duplicateAlgorithmName;
   private Button duplicateParameterKeys;
   private Button duplicateAlgorithmReferences;
   private Button ocl;

   public EvaluationPreferencePage() {}

   public EvaluationPreferencePage(final String title) {
      super("Evaluation");
   }

   protected void createAlgorithmRuns(final Composite composite) {
      algorithmRuns = new Button(composite, SWT.CHECK);
      algorithmRuns.setText("Check Algorithm Runs");
      algorithmRuns.setSelection(MOMoTPreferences.getEvaluationAlgorithmRuns());
      setButtonLayoutData(algorithmRuns);
   }

   protected void createAnalysisFileOverriden(final Composite composite) {
      analysisFileOverriden = new Button(composite, SWT.CHECK);
      analysisFileOverriden.setText("Check Analysis File Overriden");
      analysisFileOverriden.setSelection(MOMoTPreferences.getEvaluationAnalysisFileOverriden());
      setButtonLayoutData(analysisFileOverriden);
   }

   protected Composite createComposite(final Composite parent) {
      final Composite composite = new Composite(parent, SWT.NULL);
      final GridLayout layout = new GridLayout();
      layout.marginWidth = 0;
      layout.marginHeight = 0;
      composite.setLayout(layout);
      composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
      return composite;
   }

   @Override
   protected Control createContents(final Composite parent) {
      final Composite composite = createComposite(parent);
      createAlgorithmRuns(composite);
      createNrIterations(composite);
      createPopulationSize(composite);
      createModelFileExistence(composite);
      createModuleFileExistence(composite);
      createUnitExistence(composite);
      createUnitApplicability(composite);
      createParameterExistence(composite);
      createReferenceSetExistence(composite);
      createSingleObjective(composite);
      createManyObjectives(composite);
      createObjectIdentity(composite);
      createObjectivesFileOverriden(composite);
      createAnalysisFileOverriden(composite);
      createSolutionsFileOverriden(composite);
      createDuplicateAlgorithmName(composite);
      createDuplicateAlgorithmReferences(composite);
      createDuplicateParameterKeys(composite);
      createOCL(composite);
      return composite;
   }

   protected void createDuplicateAlgorithmName(final Composite composite) {
      duplicateAlgorithmName = new Button(composite, SWT.CHECK);
      duplicateAlgorithmName.setText("Check Duplicate Algorithm Names");
      duplicateAlgorithmName.setSelection(MOMoTPreferences.getEvaluationDuplicateAlgorithmName());
      setButtonLayoutData(duplicateAlgorithmName);
   }

   protected void createDuplicateAlgorithmReferences(final Composite composite) {
      duplicateAlgorithmReferences = new Button(composite, SWT.CHECK);
      duplicateAlgorithmReferences.setText("Check Duplicate Algorithm References");
      duplicateAlgorithmReferences.setSelection(MOMoTPreferences.getEvaluationDuplicateAlgorithmReference());
      setButtonLayoutData(duplicateAlgorithmReferences);
   }

   protected void createDuplicateParameterKeys(final Composite composite) {
      duplicateParameterKeys = new Button(composite, SWT.CHECK);
      duplicateParameterKeys.setText("Check Duplicate Parameter Keys");
      duplicateParameterKeys.setSelection(MOMoTPreferences.getEvaluationDuplicateParameterKeys());
      setButtonLayoutData(duplicateParameterKeys);
   }

   protected void createManyObjectives(final Composite composite) {
      manyObjectives = new Button(composite, SWT.CHECK);
      manyObjectives.setText("Check for Many Objective Algorithm Applicability");
      manyObjectives.setSelection(MOMoTPreferences.getEvaluationManyObjectives());
      setButtonLayoutData(manyObjectives);
   }

   protected void createModelFileExistence(final Composite composite) {
      modelFileExistence = new Button(composite, SWT.CHECK);
      modelFileExistence.setText("Check Model File Existence");
      modelFileExistence.setSelection(MOMoTPreferences.getEvaluationModelFileExistence());
      setButtonLayoutData(modelFileExistence);
   }

   protected void createModuleFileExistence(final Composite composite) {
      moduleFileExistence = new Button(composite, SWT.CHECK);
      moduleFileExistence.setText("Check Module File Existence");
      moduleFileExistence.setSelection(MOMoTPreferences.getEvaluationModuleFileExistence());
      setButtonLayoutData(moduleFileExistence);
   }

   protected void createNrIterations(final Composite composite) {
      nrIterations = new Button(composite, SWT.CHECK);
      nrIterations.setText("Check Number of Iterations");
      nrIterations.setSelection(MOMoTPreferences.getEvaluationNrIterations());
      setButtonLayoutData(nrIterations);
   }

   protected void createObjectIdentity(final Composite composite) {
      objectIdentity = new Button(composite, SWT.CHECK);
      objectIdentity.setText("Check Object Identity");
      objectIdentity.setSelection(MOMoTPreferences.getEvaluationObjectIdentity());
      setButtonLayoutData(objectIdentity);
   }

   protected void createObjectivesFileOverriden(final Composite composite) {
      objectivesFileOverriden = new Button(composite, SWT.CHECK);
      objectivesFileOverriden.setText("Check Objectives File Overriden");
      objectivesFileOverriden.setSelection(MOMoTPreferences.getEvaluationObjectivesFileOverriden());
      setButtonLayoutData(objectivesFileOverriden);
   }

   protected void createOCL(final Composite composite) {
      ocl = new Button(composite, SWT.CHECK);
      ocl.setText("Check OCL Statements");
      ocl.setSelection(MOMoTPreferences.getEvaluationOCL());
      setButtonLayoutData(ocl);
   }

   protected void createParameterExistence(final Composite composite) {
      parameterExistence = new Button(composite, SWT.CHECK);
      parameterExistence.setText("Check Parameter Existence");
      parameterExistence.setSelection(MOMoTPreferences.getEvaluationParameterExistence());
      setButtonLayoutData(parameterExistence);
   }

   protected void createPopulationSize(final Composite composite) {
      populationSize = new Button(composite, SWT.CHECK);
      populationSize.setText("Check Population Size");
      populationSize.setSelection(MOMoTPreferences.getEvaluationPopulationSize());
      setButtonLayoutData(populationSize);
   }

   protected void createReferenceSetExistence(final Composite composite) {
      referenceSetExistence = new Button(composite, SWT.CHECK);
      referenceSetExistence.setText("Check Reference Set Existence");
      referenceSetExistence.setSelection(MOMoTPreferences.getEvaluationReferenceSetExistence());
      setButtonLayoutData(referenceSetExistence);
   }

   protected void createSingleObjective(final Composite composite) {
      singleObjective = new Button(composite, SWT.CHECK);
      singleObjective.setText("Check for Single Objective Algorithm Applicability");
      singleObjective.setSelection(MOMoTPreferences.getEvaluationSingleObjective());
      setButtonLayoutData(singleObjective);
   }

   protected void createSolutionsFileOverriden(final Composite composite) {
      solutionsFileOverriden = new Button(composite, SWT.CHECK);
      solutionsFileOverriden.setText("Check Solutions File Overriden");
      solutionsFileOverriden.setSelection(MOMoTPreferences.getEvaluationSolutionsFileOverriden());
      setButtonLayoutData(solutionsFileOverriden);
   }

   protected void createUnitApplicability(final Composite composite) {
      unitApplicability = new Button(composite, SWT.CHECK);
      unitApplicability.setText("Check Unit Applicability");
      unitApplicability.setSelection(MOMoTPreferences.getEvaluationUnitApplicability());
      setButtonLayoutData(unitApplicability);
   }

   protected void createUnitExistence(final Composite composite) {
      unitExistence = new Button(composite, SWT.CHECK);
      unitExistence.setText("Check Unit Existence");
      unitExistence.setSelection(MOMoTPreferences.getEvaluationUnitExistence());
      setButtonLayoutData(unitExistence);
   }

   @Override
   public void init(final IWorkbench workbench) {
      // do nothing
   }

   @Override
   protected void performDefaults() {
      algorithmRuns.setSelection(MOMoTPreferences.getEvaluationAlgorithmRunsDefault());
      nrIterations.setSelection(MOMoTPreferences.getEvaluationNrIterationsDefault());
      populationSize.setSelection(MOMoTPreferences.getEvaluationPopulationSizeDefault());
      modelFileExistence.setSelection(MOMoTPreferences.getEvaluationModelFileExistenceDefault());
      moduleFileExistence.setSelection(MOMoTPreferences.getEvaluationModuleFileExistenceDefault());
      unitExistence.setSelection(MOMoTPreferences.getEvaluationUnitExistenceDefault());
      unitApplicability.setSelection(MOMoTPreferences.getEvaluationUnitApplicabilityDefault());
      parameterExistence.setSelection(MOMoTPreferences.getEvaluationParameterExistenceDefault());
      referenceSetExistence.setSelection(MOMoTPreferences.getEvaluationReferenceSetExistenceDefault());
      singleObjective.setSelection(MOMoTPreferences.getEvaluationSingleObjectiveDefault());
      manyObjectives.setSelection(MOMoTPreferences.getEvaluationManyObjectivesDefault());
      objectIdentity.setSelection(MOMoTPreferences.getEvaluationObjectIdentityDefault());
      objectivesFileOverriden.setSelection(MOMoTPreferences.getEvaluationObjectivesFileOverridenDefault());
      analysisFileOverriden.setSelection(MOMoTPreferences.getEvaluationAnalysisFileOverridenDefault());
      solutionsFileOverriden.setSelection(MOMoTPreferences.getEvaluationSolutionsFileOverridenDefault());
      duplicateAlgorithmName.setSelection(MOMoTPreferences.getEvaluationDuplicateAlgorithmNameDefault());
      duplicateAlgorithmReferences.setSelection(MOMoTPreferences.getEvaluationDuplicateAlgorithmReferenceDefault());
      duplicateParameterKeys.setSelection(MOMoTPreferences.getEvaluationDuplicateParameterKeysDefault());
      ocl.setSelection(MOMoTPreferences.getEvaluationOCLDefault());
      super.performDefaults();
   }

   @Override
   public boolean performOk() {
      MOMoTPreferences.setEvaluationAlgorithmRuns(algorithmRuns.getSelection());
      MOMoTPreferences.setEvaluationNrIterations(nrIterations.getSelection());
      MOMoTPreferences.setEvaluationPopulationSize(populationSize.getSelection());
      MOMoTPreferences.setEvaluationModelFileExistence(modelFileExistence.getSelection());
      MOMoTPreferences.setEvaluationModuleFileExistence(moduleFileExistence.getSelection());
      MOMoTPreferences.setEvaluationUnitExistence(unitExistence.getSelection());
      MOMoTPreferences.setEvaluationUnitApplicability(unitApplicability.getSelection());
      MOMoTPreferences.setEvaluationParameterExistence(parameterExistence.getSelection());
      MOMoTPreferences.setEvaluationReferenceSetExistence(referenceSetExistence.getSelection());
      MOMoTPreferences.setEvaluationSingleObjective(singleObjective.getSelection());
      MOMoTPreferences.setEvaluationManyObjectives(manyObjectives.getSelection());
      MOMoTPreferences.setEvaluationObjectIdentity(objectIdentity.getSelection());
      MOMoTPreferences.setEvaluationObjectivesFileOverriden(objectivesFileOverriden.getSelection());
      MOMoTPreferences.setEvaluationAnalysisFileOverriden(analysisFileOverriden.getSelection());
      MOMoTPreferences.setEvaluationSolutionsFileOverriden(solutionsFileOverriden.getSelection());
      MOMoTPreferences.setEvaluationDuplicateAlgorithmName(duplicateAlgorithmName.getSelection());
      MOMoTPreferences.setEvaluationDuplicateAlgorithmReference(duplicateAlgorithmReferences.getSelection());
      MOMoTPreferences.setEvaluationDuplicateParameterKeys(duplicateParameterKeys.getSelection());
      MOMoTPreferences.setEvaluationOCL(ocl.getSelection());
      MOMoTPreferences.flush();
      return super.performOk();
   }

}
