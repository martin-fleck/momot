package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.impl.AssignmentImpl;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class TargetStateGenerator {

   public static EPackage epackageInstance = RefactoringPackage.eINSTANCE;

   public static EObject executeRandomly(final EObject on, final List<List<Unit>> units, final int numCount) {
      final Engine engine = new EngineImpl();
      final HenshinResourceSet test = new HenshinResourceSet();
      final EGraph graph = new EGraphImpl(EcoreUtil.copy(on));
      mainLoop: for(int i = 0; i < numCount; ++i) {
         for(int j = 0; j < units.size(); ++j) {
            final List<Unit> unitsRandom = new ArrayList<>(units.get(j));
            Collections.shuffle(unitsRandom);
            for(final Unit unit : unitsRandom) {
               final Assignment assignment = new AssignmentImpl(unit);
               final UnitApplicationImpl uai = new UnitApplicationImpl(engine, graph, unit, assignment);
               if(uai.execute(null)) {
                  System.out.println("Executed: " + unit.getName());
                  continue mainLoop;
               } else {
                  System.out.println("Could not execute: " + unit.getName());
               }
            }
         }
      }
      return graph.getRoots().get(0);
   }

   public static void generateTargets(final File sourceFile, final int targetCount, final int transformationCount,
         final List<List<Unit>> units) {
      final EObject sourceModel = loadModel(sourceFile.getAbsolutePath());
      for(int i = 0; i < targetCount; ++i) {
         final File targetFile = getTargetFileName(sourceFile, i);
         final XMIResourceImpl xmiRes = new XMIResourceImpl(URI.createFileURI(targetFile.getAbsolutePath()));
         final EObject transformed = executeRandomly(sourceModel, units, transformationCount);
         xmiRes.getContents().add(transformed);
         try(FileOutputStream fos = new FileOutputStream(targetFile)) {
            xmiRes.doSave(fos, Collections.emptyMap());
         } catch(final Exception e) {
            e.printStackTrace();
         }
      }
   }

   public static void generateTargets(final File sourceDir, final int targetCount, final int transformationCount,
         final String[]... henshinFilesA) {
      final List<List<Unit>> unitsL = new ArrayList<>();
      for(final String[] henshinFiles : henshinFilesA) {
         final List<Unit> units = new ArrayList<>();
         for(final String henshinFileS : henshinFiles) {
            final File henshinFile = new File(henshinFileS);
            final HenshinResourceSet hrs = new HenshinResourceSet();
            final Resource henshinResource = hrs.getResource(henshinFile.getAbsolutePath());
            final List<Module> allModules = new ArrayList<>();
            henshinResource.getAllContents().forEachRemaining(x -> {
               if(x instanceof Module) {
                  allModules.add((Module) x);
               }
            });
            allModules.forEach(x -> {
               units.addAll(x.getUnits());
            });
         }
         unitsL.add(units);
      }

      for(final File sourceFile : sourceDir.listFiles()) {
         if(sourceFile.getName().contains("_target")) {
            continue;
         }
         generateTargets(sourceFile, targetCount, transformationCount, unitsL);
      }
   }

   public static File getTargetFileName(final File sourceFile, final int i) {
      String fileName = sourceFile.getAbsolutePath();
      final String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
      fileName = fileName.substring(0, fileName.lastIndexOf('.'));
      final File targetFile = new File(fileName + "_target" + (i + 1) + "." + extension);
      return targetFile;
   }

   public static EObject loadModel(final String uri) {
      // register XMI resource factory for .xmi extension
      final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
      final Map<String, Object> m = reg.getExtensionToFactoryMap();
      m.put("xmi", new XMIResourceFactoryImpl());
      // create resource set
      final ResourceSet resourceSet = new ResourceSetImpl();
      // register FSA metamodel
      resourceSet.getPackageRegistry().put(epackageInstance.getNsURI(), epackageInstance);
      // create file URI, always use File.getAbsolutePath()
      final URI fileUri = URI.createFileURI(new File(uri).getAbsolutePath());
      // load resource
      final Resource resource = resourceSet.getResource(fileUri, true);
      // retrieve first EObject in the resource
      return resource.getContents().get(0);
   }

   public static void main(final String[] args) {
      generateTargets(new File("genmodels/medium"), 1, 20, new String[] { "model/Refactoring.henshin" });
   }

   public static void setEPackageInstance(final EPackage epkg) {
      epackageInstance = epkg;
   }
}
