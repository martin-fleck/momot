package at.ac.tuwien.big.momot.lang.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (momot).
 */

public class MOMoTNewWizardPage extends WizardPage {
   private Text containerText;

   private Text fileText;

   private final ISelection selection;

   /**
    * Constructor for SampleNewWizardPage.
    *
    * @param pageName
    */
   public MOMoTNewWizardPage(final ISelection selection) {
      super("momotPage");
      setTitle("MOMoT Search File");
      setDescription("This wizard creates a new file with *.momot extension.");
      this.selection = selection;
   }

   /**
    * @see IDialogPage#createControl(Composite)
    */
   @Override
   public void createControl(final Composite parent) {
      final Composite container = new Composite(parent, SWT.NULL);
      final GridLayout layout = new GridLayout();
      container.setLayout(layout);
      layout.numColumns = 3;
      layout.verticalSpacing = 9;
      Label label = new Label(container, SWT.NULL);
      label.setText("&Container:");

      containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
      GridData gd = new GridData(GridData.FILL_HORIZONTAL);
      containerText.setLayoutData(gd);
      containerText.addModifyListener(e -> dialogChanged());

      final Button button = new Button(container, SWT.PUSH);
      button.setText("Browse...");
      button.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(final SelectionEvent e) {
            handleBrowse();
         }
      });
      label = new Label(container, SWT.NULL);
      label.setText("&File name:");

      fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
      gd = new GridData(GridData.FILL_HORIZONTAL);
      fileText.setLayoutData(gd);
      fileText.addModifyListener(e -> dialogChanged());
      initialize();
      dialogChanged();
      setControl(container);
   }

   /**
    * Ensures that both text fields are set.
    */

   private void dialogChanged() {
      final IResource container = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getContainerName()));
      final String fileName = getFileName();

      if(getContainerName().length() == 0) {
         updateStatus("File container must be specified");
         return;
      }
      if(container == null || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
         updateStatus("File container must exist");
         return;
      }
      if(!container.isAccessible()) {
         updateStatus("Project must be writable");
         return;
      }
      if(fileName.length() == 0) {
         updateStatus("File name must be specified");
         return;
      }
      if(fileName.replace('\\', '/').indexOf('/', 1) > 0) {
         updateStatus("File name must be valid");
         return;
      }
      final int dotLoc = fileName.lastIndexOf('.');
      if(dotLoc != -1) {
         final String ext = fileName.substring(dotLoc + 1);
         if(!"momot".equalsIgnoreCase(ext)) {
            updateStatus("File extension must be \"momot\"");
            return;
         }
      }
      updateStatus(null);
   }

   public String getContainerName() {
      return containerText.getText();
   }

   public String getFileName() {
      return fileText.getText();
   }

   /**
    * Uses the standard container selection dialog to choose the new value for
    * the container field.
    */

   private void handleBrowse() {
      final ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(),
            ResourcesPlugin.getWorkspace().getRoot(), false, "Select new file container");
      if(dialog.open() == Window.OK) {
         final Object[] result = dialog.getResult();
         if(result.length == 1) {
            containerText.setText(((Path) result[0]).toString());
         }
      }
   }

   /**
    * Tests if the current workbench selection is a suitable container to use.
    */

   private void initialize() {
      if(selection != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
         final IStructuredSelection ssel = (IStructuredSelection) selection;
         if(ssel.size() > 1) {
            return;
         }
         final Object obj = ssel.getFirstElement();
         if(obj instanceof IResource) {
            IContainer container;
            if(obj instanceof IContainer) {
               container = (IContainer) obj;
            } else {
               container = ((IResource) obj).getParent();
            }
            containerText.setText(container.getFullPath().toString());
         }
      }
      fileText.setText("search.momot");
   }

   private void updateStatus(final String message) {
      setErrorMessage(message);
      setPageComplete(message == null);
   }
}
