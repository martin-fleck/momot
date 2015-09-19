package at.ac.tuwien.big.momot.popup.actions;

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

import com.google.common.base.CaseFormat;

public class HenshinConstantsHandler extends AbstractHandler {

	 private MessageConsole findConsole(String name) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager conMan = plugin.getConsoleManager();
	      IConsole[] existing = conMan.getConsoles();
	      for (int i = 0; i < existing.length; i++)
	         if (name.equals(existing[i].getName()))
	            return (MessageConsole) existing[i];
	      
	      //no console found, so create a new one
	      MessageConsole myConsole = new MessageConsole(name, null);
	      conMan.addConsoles(new IConsole[]{myConsole});
	      return myConsole;
	}	 
	
	protected static String escapeWhitespace(String text) {
		return text.replace(' ', '_');
	}
	 
	protected static String toFirstUpper(String text) {
		return text.substring(0, 1).toUpperCase() + text.substring(1);
	}
	 
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		HenshinResourceSet set = new HenshinResourceSet();
		
		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// set selection service
		ISelectionService service = window.getSelectionService();
		IStructuredSelection selection = (IStructuredSelection) service.getSelection();
		
		MessageConsole console = findConsole("HenshinConstants");
		MessageConsoleStream stream = console.newMessageStream();
		
		String id = IConsoleConstants.ID_CONSOLE_VIEW;
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IConsoleView view = null;
		try {
			view = (IConsoleView) page.showView(id);
		} catch (PartInitException e) {
		}
		view.display(console);
		
		for(Iterator<?> it = selection.iterator(); it.hasNext();) {
			Object selected = it.next();
			IFile moduleFile = (IFile) selected;
			
			String parent = moduleFile.getParent().getRawLocation().toPortableString();
			String fileName = toFirstUpper(moduleFile.getName().replace(".henshin", ""));
			
			String newFileName = escapeWhitespace(fileName) + "Module";
			String newFilePath = parent + File.separator + newFileName + ".java";
			
			File javaFile;
			try {
				javaFile = Paths.get(newFilePath).toFile();
				javaFile.createNewFile();
			} catch (IOException e) {
				stream.println(e.getMessage());
				continue;
			}
			stream.print("Generating File '" + javaFile + "'...");
			
			PrintStream fileStream = getFilePrintStream(javaFile);
			if(fileStream == null)
				continue;
			
			Module module = set.getModule(moduleFile.getRawLocation().toPortableString(), false);
			String moduleName = module.getName() != null ? module.getName() : "";
			
			fileStream.println("public interface " + newFileName + " {");
			fileStream.println("   static String SEPARATOR = \"::\";");
			fileStream.println("   static String FILE_NAME = \"" + moduleFile.getName().replace(".henshin", "") + "\";");
			fileStream.println("   static String MODULE_NAME = \"" + moduleName + "\";");
			if(moduleName == "")
				fileStream.println("   static String MODULE = FILE_NAME;");
			else
				fileStream.println("   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;");
			fileStream.println("");
			for(Unit unit : module.getUnits()) {
				String unitName = escapeWhitespace(toFirstUpper(unit.getName()));
				fileStream.println("   public static interface " + unitName + " {");
				fileStream.println("      static String NAME = " + newFileName + ".MODULE + " + newFileName + ".SEPARATOR + \"" + unit.getName() + "\";");
				fileStream.println("      static interface Parameter {");
				for(Parameter parameter : unit.getParameters()) {
					fileStream.println("         String " + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, parameter.getName()) + " = "
							+ unitName + ".NAME + " + newFileName + ".SEPARATOR + \"" + parameter.getName() + "\";");
				}
				fileStream.println("      }");
				fileStream.println("   }");
				fileStream.println("");
			}
			fileStream.println("}");
			fileStream.close();
			
			
			
			try {
				moduleFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e) {
				stream.println(e.getMessage());
			}
			
			stream.println("done.");
		}		
		
		if(stream != null)
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return null;
	}

	protected static PrintStream getFilePrintStream(File file) {
		try {
			return new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
}
