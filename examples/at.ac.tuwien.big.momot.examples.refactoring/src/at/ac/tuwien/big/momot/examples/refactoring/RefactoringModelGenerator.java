package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringFactory;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class RefactoringModelGenerator {

   static Map<Class<?>, Entity> class2Entity = new HashMap<>();
   static RefactoringModel model = RefactoringFactory.eINSTANCE.createRefactoringModel();
   static Map<String, Type> typesMap = new HashMap<>();

   public static void clear() {
      class2Entity.clear();
      model = RefactoringFactory.eINSTANCE.createRefactoringModel();
      typesMap.clear();
   }

   public static Entity getEntity(final Class<?> forClass, final Set<Class<?>> nextProcess) {
      Entity ret = class2Entity.get(forClass);
      if(ret != null) {
         return ret;
      }
      final Class<?> superClass = forClass.getSuperclass();
      Entity superEntity = null;
      ret = RefactoringFactory.eINSTANCE.createEntity();
      ret.setName(forClass.getSimpleName());
      class2Entity.put(forClass, ret);
      model.getEntities().add(ret);
      if(superClass != null) {
         superEntity = getEntity(superClass, nextProcess);
         final Generalization g = RefactoringFactory.eINSTANCE.createGeneralization();
         g.setGeneral(superEntity);
         g.setSpecific(ret);
         model.getGeneralizations().add(g);
      }
      final Set<String> takenNames = new HashSet<>();
      Class<?> sc = superClass;
      while(sc != null) {
         for(final Field f : sc.getDeclaredFields()) {
            takenNames.add(f.getName());
         }
         sc = sc.getSuperclass();
      }
      for(final Field f : forClass.getDeclaredFields()) {
         if(takenNames.contains(f.getName())) {
            continue;
         }
         final Property prop = RefactoringFactory.eINSTANCE.createProperty();
         prop.setName(f.getName());
         prop.setType(getType(f.getType().getCanonicalName()));
         model.getProperties().add(prop);
         ret.getOwnedAttribute().add(prop);
         Class<?> addType = f.getType();
         while(addType.isArray()) {
            addType = addType.getComponentType();
         }

         nextProcess.add(addType);
      }
      return ret;
   }

   public static Type getType(final String type) {
      return typesMap.computeIfAbsent(type, x -> {
         final Type t = RefactoringFactory.eINSTANCE.createType();
         t.setName(x);
         model.getTypes().add(t);
         return t;
      });
   }

   public static void main(final String[] args) throws IOException {
      final File storeFile = new File("outputModel.xmi");
      System.out.println("Output file: " + storeFile.getCanonicalPath());
      final Resource res = new XMIResourceImpl(URI.createFileURI(storeFile.getCanonicalPath()));
      clear();
      processClasses(40, SearchExecutor.class);
      res.getContents().add(model);
      res.save(Collections.emptyMap());
   }

   public static void processClasses(final int depth, final Class<?>... classes) {
      processClasses(depth, Arrays.asList(classes));
   }

   public static void processClasses(final int depth, final Collection<Class<?>> initCol) {
      final Set<Class<?>> allProcessed = new HashSet<>(initCol);
      Collection<Class<?>> procCol = new HashSet<>(initCol);
      for(int i = 0; i < depth; ++i) {
         final Set<Class<?>> nextClasses = new HashSet<>();
         for(final Class<?> cl : procCol) {
            getEntity(cl, nextClasses);
         }
         procCol = nextClasses;
         procCol.removeAll(allProcessed);
         if(procCol.isEmpty()) {
            break;
         }
      }
   }
}
