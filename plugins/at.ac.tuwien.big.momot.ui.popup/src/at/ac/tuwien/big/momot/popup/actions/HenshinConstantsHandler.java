package at.ac.tuwien.big.momot.popup.actions;

import com.google.common.base.CaseFormat;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;

public class HenshinConstantsHandler extends AbstractHandler {

   protected static String escapeWhitespace(final String text) {
      return text.replace(' ', '_');
   }

   protected static PrintStream getFilePrintStream(final File file) {
      try {
         return new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, "UTF-8");
      } catch(final UnsupportedEncodingException e) {
         return null;
      } catch(final FileNotFoundException e) {
         return null;
      }
   }

   protected static String toFirstUpper(final String text) {
      return text.substring(0, 1).toUpperCase() + text.substring(1);
   }

   @Override
   public Object execute(final ExecutionEvent event) throws ExecutionException {
      final HenshinResourceSet set = new HenshinResourceSet();

      // get workbench window
      final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
      // set selection service
      final ISelectionService service = window.getSelectionService();
      final IStructuredSelection selection = (IStructuredSelection) service.getSelection();

      final MessageConsole console = findConsole("HenshinConstants");
      final MessageConsoleStream stream = console.newMessageStream();

      final String id = IConsoleConstants.ID_CONSOLE_VIEW;
      final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      IConsoleView view = null;
      try {
         view = (IConsoleView) page.showView(id);
      } catch(final PartInitException e) {
      }
      view.display(console);

      for(final Iterator<?> it = selection.iterator(); it.hasNext();) {
         final Object selected = it.next();
         final IFile moduleFile = (IFile) selected;

         final String parent = moduleFile.getParent().getRawLocation().toPortableString();
         final String fileName = toFirstUpper(moduleFile.getName().replace(".henshin", ""));

         final String newFileName = escapeWhitespace(fileName) + "Module";
         final String newFilePath = parent + File.separator + newFileName + ".java";

         File javaFile;
         try {
            javaFile = Paths.get(newFilePath).toFile();
            javaFile.createNewFile();
         } catch(final IOException e) {
            stream.println(e.getMessage());
            continue;
         }
         stream.print("Generating File '" + javaFile + "'...");

         final PrintStream fileStream = getFilePrintStream(javaFile);
         if(fileStream == null) {
            continue;
         }

         final Module module = set.getModule(moduleFile.getRawLocation().toPortableString(), false);
         final String moduleName = module.getName() != null ? module.getName() : "";

         fileStream.println("public interface " + newFileName + " {");
         fileStream.println("   static String SEPARATOR = \"::\";");
         fileStream.println("   static String FILE_NAME = \"" + moduleFile.getName().replace(".henshin", "") + "\";");
         fileStream.println("   static String MODULE_NAME = \"" + moduleName + "\";");
         if(moduleName.isEmpty()) {
            fileStream.println("   static String MODULE = FILE_NAME;");
         } else {
            fileStream.println("   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;");
         }
         fileStream.println("");
         for(final Unit unit : module.getUnits()) {
            final String unitName = escapeWhitespace(toFirstUpper(unit.getName()));
            fileStream.println("   public static interface " + unitName + " {");
            fileStream.println("      static String NAME = " + newFileName + ".MODULE + " + newFileName
                  + ".SEPARATOR + \"" + unit.getName() + "\";");
            fileStream.println("      static interface Parameter {");
            for(final Parameter parameter : unit.getParameters()) {
               fileStream.println("         String "
                     + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, parameter.getName()) + " = " + unitName
                     + ".NAME + " + newFileName + ".SEPARATOR + \"" + parameter.getName() + "\";");
            }
            fileStream.println("      }");
            fileStream.println("   }");
            fileStream.println("");
         }
         fileStream.println("}");
         fileStream.close();

         try {
            moduleFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
         } catch(final CoreException e) {
            stream.println(e.getMessage());
         }

         stream.println("done.");
      }

      if(stream != null) {
         try {
            stream.close();
         } catch(final IOException e) {
            e.printStackTrace();
         }
      }

      return null;
   }

   private MessageConsole findConsole(final String name) {
      final ConsolePlugin plugin = ConsolePlugin.getDefault();
      final IConsoleManager conMan = plugin.getConsoleManager();
      final IConsole[] existing = conMan.getConsoles();
      for(final IConsole element : existing) {
         if(name.equals(element.getName())) {
            return (MessageConsole) element;
         }
      }

      // no console found, so create a new one
      final MessageConsole myConsole = new MessageConsole(name, null);
      conMan.addConsoles(new IConsole[] { myConsole });
      return myConsole;
   }
}
