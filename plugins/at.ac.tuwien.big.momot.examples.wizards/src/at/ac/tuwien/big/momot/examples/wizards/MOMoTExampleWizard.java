package at.ac.tuwien.big.momot.examples.wizards;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.wizard.AbstractExampleInstallerWizard;
import org.eclipse.emf.common.ui.wizard.ExampleInstallerWizard;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class MOMoTExampleWizard extends ExampleInstallerWizard {
   /**
    * The project page for the MakeItHappenWizard.
    */
   public class MOMoTExamplePage extends AbstractExampleInstallerWizard.ProjectPage {

      private final MOMoTExampleWizard wizard;

      /**
       * Creates a make it happen example wizard page.
       *
       * @param makeItHappenWizard
       *           the wizard
       * @param pageName
       *           the name of the page
       * @param title
       *           the displayed title of the page
       * @param titleImage
       *           the displayed image of the page
       */
      public MOMoTExamplePage(final MOMoTExampleWizard makeItHappenWizard, final String pageName, final String title,
            final ImageDescriptor titleImage) {
         super(pageName, title, titleImage);
         wizard = makeItHappenWizard;
      }

      @Override
      public void createControl(final Composite parent) {
         final SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
         sashForm.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_VERTICAL));

         projectList = new org.eclipse.swt.widgets.List(sashForm, SWT.SINGLE | SWT.BORDER);
         projectList.setLayoutData(new GridData(GridData.FILL_BOTH));
         projectList.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
               itemSelected();
            }
         });
         projectList.setFocus();

         final int margin = -5;
         final int spacing = 3;

         final Composite composite = new Composite(sashForm, SWT.NONE);
         final GridLayout compositeLayout = new GridLayout(2, false);

         compositeLayout.marginTop = margin;
         compositeLayout.marginLeft = margin;
         compositeLayout.marginRight = margin;
         compositeLayout.marginBottom = margin;
         compositeLayout.horizontalSpacing = spacing;
         compositeLayout.verticalSpacing = spacing;
         composite.setLayout(compositeLayout);

         descriptionText = new Text(composite, SWT.READ_ONLY | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
         final GridData descriptionTextData = new GridData(GridData.FILL_BOTH);
         descriptionTextData.heightHint = convertHeightInCharsToPixels(2);
         descriptionTextData.grabExcessVerticalSpace = true;
         descriptionText.setLayoutData(descriptionTextData);

         final Composite buttonComposite = new Composite(composite, SWT.NONE);
         buttonComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_END));
         buttonComposite.setLayout(new GridLayout());
         final GridLayout buttonLayout = new GridLayout();
         buttonLayout.marginTop = margin;
         buttonLayout.marginLeft = margin;
         buttonLayout.marginRight = margin;
         buttonLayout.marginBottom = margin;
         buttonLayout.horizontalSpacing = spacing;
         buttonLayout.verticalSpacing = spacing;
         buttonComposite.setLayout(buttonLayout);

         refresh();
         sashForm.setWeights(new int[] { 70, 30 });
         setControl(sashForm);
      }

      @Override
      protected ProjectDescriptor getSelectedProjectDescriptor() {
         return projectList.getSelectionCount() == 0 ? null
               : (ProjectDescriptor) projectList.getData(projectList.getSelection()[0]);
      }

      @Override
      protected void itemSelected() {
         final ProjectDescriptor projectDescriptor = getSelectedProjectDescriptor();
         if(projectDescriptor != null) {
            final boolean exists = projectDescriptor.getProject().exists();

            String description = projectDescriptor.getDescription() != null ? projectDescriptor.getDescription() : ""; //$NON-NLS-1$
            if(exists) {
               final String existsMessage = MOMoTExampleWizardPlugin.INSTANCE
                     .getString("_UI_ProjectExistsAlready_message"); //$NON-NLS-1$
               description = description.isEmpty() ? // $NON-NLS-1$
                     existsMessage
                     : MOMoTExampleWizardPlugin.INSTANCE.getString("_UI_ProjectDescriptionAndExists_message", //$NON-NLS-1$
                           new String[] { description, existsMessage });
            }
            descriptionText.setText(description);
         }
      }

      @Override
      public void refresh() {
         if(wizard.getProjectDescriptors().isEmpty()) {
            setErrorMessage(MOMoTExampleWizardPlugin.INSTANCE.getString("_UI_NoProjectError_message")); //$NON-NLS-1$
            setPageComplete(false);
         } else {
            setErrorMessage(null);

            int selectionIndex = projectList.getSelectionIndex();
            if(selectionIndex < 0) {
               selectionIndex = 0;
            }

            projectList.removeAll();
            for(final ProjectDescriptor projectDescriptor : wizard.getProjectDescriptors()) {
               final String name = projectDescriptor.getName();
               final boolean exists = projectDescriptor.getProject().exists();
               final String item = exists
                     ? MOMoTExampleWizardPlugin.INSTANCE.getString("_UI_ExistingProjectName_message", //$NON-NLS-1$
                           new String[] { name })
                     : name;
               projectList.add(item);

               projectList.setData(item, projectDescriptor);
            }

            if(getControl() != null) {
               projectList.setSelection(selectionIndex);
               itemSelected();
            }

            setPageComplete(true);
         }
      }

      @Override
      public void setVisible(final boolean visible) {
         if(visible && projectList.getItemCount() > 0 && projectList != null && projectList.getSelectionCount() == 0) {
            int index = 0;
            int count = 0;
            for(final ProjectDescriptor projectDescriptor : wizard.getProjectDescriptors()) {
               if(projectDescriptor.getProject().exists()) {
                  index = count;
                  break;
               }
               count++;
            }
            projectList.select(index);
            refresh();
         }
         super.setVisible(visible);
      }

   }

   private MOMoTExamplePage projectPage;

   /**
    * {@inheritDoc}
    *
    * @see org.eclipse.emf.common.ui.wizard.AbstractExampleInstallerWizard#addPages()
    */
   @Override
   public void addPages() {
      projectPage = new MOMoTExamplePage(this, "projectPage", //$NON-NLS-1$
            MOMoTExampleWizardPlugin.INSTANCE.getString("_UI_ProjectPage_title"), null); //$NON-NLS-1$
      projectPage.setDescription(MOMoTExampleWizardPlugin.INSTANCE.getString("_UI_ProjectPage_description")); //$NON-NLS-1$
      addPage(projectPage);
   }

   /**
    * The MakeItHappenWizard doesn't delete any projects.
    *
    * @param monitor
    *           progress monitor
    * @return OK
    */
   @Override
   protected Diagnostic deleteExistingProjects(final IProgressMonitor monitor) {
      return Diagnostic.OK_INSTANCE;
   }

   @Override
   public void dispose() {
      projectPage = null;
      super.dispose();
   }

   /**
    * In contrast to the {@link AbstractExampleInstallerWizard} the MakeItHappenWizard only installs projects if they
    * don't already exist in the workspace.
    *
    * @param progressMonitor
    *           the progress monitor
    * @throws ExecutionException
    *            if something goes wrong while installing the example.
    * @see org.eclipse.emf.common.ui.wizard.AbstractExampleInstallerWizard#installExample(org.eclipse.core.runtime.IProgressMonitor)
    */
   @Override
   protected void installExample(final IProgressMonitor progressMonitor) throws ExecutionException {
      final List<ProjectDescriptor> projectDescriptors = getProjectDescriptors();
      progressMonitor.beginTask(MOMoTExampleWizardPlugin.INSTANCE.getString("_UI_CreatingProjects_message"), //$NON-NLS-1$
            2 * projectDescriptors.size());
      for(final ProjectDescriptor projectDescriptor : projectDescriptors) {
         if(!projectDescriptor.getProject().exists()) {
            try {
               installProject(projectDescriptor, progressMonitor);
            } catch(final Exception ex) {
               throw new ExecutionException("The project '" + projectDescriptor.getName() //$NON-NLS-1$
                     + "' could not be installed.", ex); //$NON-NLS-1$
            }
            // END SUPRESS CATCH EXCEPTION
         }
      }
      progressMonitor.done();
   }
}
