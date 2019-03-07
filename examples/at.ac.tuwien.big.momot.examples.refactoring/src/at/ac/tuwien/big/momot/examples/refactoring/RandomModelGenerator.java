package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Generalization;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringFactory;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Type;

import com.google.common.base.Supplier;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class RandomModelGenerator {

   public static RefactoringModel generateModel(final int numEntities, final int minAttributes, final int maxAttributes,
         final int attributeNameCount, final int minTypesPerAttr, final int maxTypesPerAttr,
         final double superClassProbability) {
      final RefactoringModel ret = RefactoringFactory.eINSTANCE.createRefactoringModel();
      final List<String> attributeNames = new ArrayList<>();
      final List<String> primitiveTypes = new ArrayList<>(Arrays.asList("int", "string", "boolean", "double"));
      final Map<String, Type> allTypes = new HashMap<>();
      final Map<String, List<Type>> usedTypes = new HashMap<>();

      final List<Type> allTypesList = new ArrayList<>();
      final List<String> allTypeNames = new ArrayList<>(primitiveTypes);
      for(int i = 0; i < numEntities; ++i) {
         allTypeNames.add("Entity" + (i + 1));
      }
      for(final String str : allTypeNames) {
         final Type type = RefactoringFactory.eINSTANCE.createType();
         type.setName(str);
         allTypesList.add(type);
      }
      ret.getTypes().addAll(allTypesList);

      final Random random = new Random();

      for(int i = 0; i < Math.max(attributeNameCount, maxAttributes); ++i) {
         final String an = "attr" + (i + 1);
         attributeNames.add(an);
         final int numAttr = random.nextInt(maxTypesPerAttr - minTypesPerAttr + 1) + minTypesPerAttr;
         final List<Type> usedTypesA = new ArrayList<>();
         final List<Type> types = new ArrayList<>(allTypesList);
         Collections.shuffle(types);
         for(int j = 0; j < numAttr; ++j) {
            usedTypesA.add(types.get(j));
         }
         usedTypes.put(an, types);
      }

      for(int i = 0; i < numEntities; ++i) {
         final Entity entity = RefactoringFactory.eINSTANCE.createEntity();
         entity.setName("Entity" + (i + 1));
         ret.getEntities().add(entity);
         final int numAttributes = minAttributes + (int) (Math.random() * (maxAttributes + 1 - minAttributes));
         final List<String> usedNames = new ArrayList<>(attributeNames);
         while(usedNames.size() > numAttributes) {
            usedNames.remove((int) (Math.random() * usedNames.size()));
         }
         Collections.shuffle(usedNames);
         for(int j = 0; j < numAttributes; ++j) {
            final Property prop = RefactoringFactory.eINSTANCE.createProperty();
            prop.setName(usedNames.get(j));
            final List<Type> typeList = usedTypes.get(prop.getName());
            prop.setType(typeList.get(random.nextInt(typeList.size())));
            entity.getOwnedAttribute().add(prop);
            ret.getProperties().add(prop);
         }

      }

      // Randomly associate superclass
      for(int i = 1; i < ret.getEntities().size(); ++i) {
         if(Math.random() < superClassProbability) {
            final Generalization genera = RefactoringFactory.eINSTANCE.createGeneralization();
            genera.setGeneral(ret.getEntities().get(random.nextInt(ret.getEntities().size())));
            ret.getGeneralizations().add(genera);
            ret.getEntities().get(i).setGeneralization(genera);
         }
      }

      return ret;

   }

   public static void generateNModels(final File outputDir, final int n,
         final Supplier<? extends EObject> modelSupplier) {
      outputDir.mkdirs();
      for(int i = 0; i < n; ++i) {
         final File target = new File(outputDir.getAbsolutePath() + File.separator + "model" + (i + 1) + ".xmi");
         final XMIResourceImpl xmiRes = new XMIResourceImpl(URI.createFileURI(target.getAbsolutePath()));
         final EObject model = modelSupplier.get();
         xmiRes.getContents().add(model);
         try(FileOutputStream fos = new FileOutputStream(target)) {
            xmiRes.save(fos, Collections.emptyMap());
         } catch(final Exception e) {
            e.printStackTrace();
         }
      }
   }

   public static void main(final String[] args) {
      final File parentFile = new File("genmodels");
      final Map<String, Supplier<? extends EObject>> allSuppliers = new HashMap<>();
      allSuppliers.put("medium", () -> generateModel(6, 1, 5, 8, 1, 3, 0.5));
      // allSuppliers.put("manytokens", ()->generateRandomPetriNet(4,8,1,1,1,2,30,50));
      // allSuppliers.put("extratiny", ()->generateRandomPetriNet(7,14,1,2,1,2,1,3));
      /*
       * allSuppliers.put("tiny", ()->generateRandomPetriNet(10,20,1,2,1,2,2,4));
       * allSuppliers.put("small", ()->generateRandomPetriNet(20,40,1,2,1,2,5,10));
       * allSuppliers.put("medium", ()->generateRandomPetriNet(40,80,1,3,1,3,10,20));
       * allSuppliers.put("large", ()->generateRandomPetriNet(80,100,1,4,1,4,20,40));
       */
      allSuppliers.forEach((n, sup) -> {
         generateNModels(new File(parentFile.getAbsolutePath() + File.separator + n), 100, sup);
      });
   }

}
