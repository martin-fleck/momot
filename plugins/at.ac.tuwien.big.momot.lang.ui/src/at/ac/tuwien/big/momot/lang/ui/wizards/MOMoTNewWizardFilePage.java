package at.ac.tuwien.big.momot.lang.ui.wizards;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (momot).
 */

public class MOMoTNewWizardFilePage extends WizardNewFileCreationPage {
   /**
    * Constructor for SampleNewWizardPage.
    *
    * @param pageName
    */
   public MOMoTNewWizardFilePage(final ISelection selection) {
      super("momotPage", (IStructuredSelection) selection);
      setTitle("MOMoT Search File");
      setDescription("This wizard creates a new file with *.momot extension.");
      setFileExtension("momot");
      setFileName("search.momot");
   }

   @Override
   public void createControl(final Composite parent) {
      super.createControl(parent);
      validatePage();
   }
}
