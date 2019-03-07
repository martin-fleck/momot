package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emfmodeldistance.ElementDistance;

/**
 * This class is automatically generated for the Petrinet metamodel.
 * 
 * @author Eugene Syriani
 *
 */
public class RefactoringElementDistance extends ElementDistance {
   private static RefactoringElementDistance INSTANCE;

   public static double calculateFitness(final EObject model) {
      return INSTANCE.calculateDistance(model);
   }

   public static void initWith(final File modelFile) {
      INSTANCE = new RefactoringElementDistance(modelFile);
   }

   /**
    * Initializes the element distance calculator.
    * 
    * @param targetModel
    *           the target model to compare with
    */
   public RefactoringElementDistance(final File targetModel) {
      super(targetModel);
      // Generated from metamodel
      util = RefactoringDistanceUtilFactory.getInstance();
   }

   @Override
   protected EPackage getEPackageInstance() {
      // Generated from metamodel
      return RefactoringPackage.eINSTANCE;
   }
}
