package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emfmodeldistance.ValueDistance;

/**
 * This class is automatically generated for the Petrinet metamodel.
 * 
 * @author Eugene Syriani
 *
 */
public class RefactoringValueDistance extends ValueDistance {
   private static RefactoringValueDistance INSTANCE;

   public static double calculateFitness(final EObject model) {
      final double ret = INSTANCE.calculateDistance(model);
      if(!Double.isFinite(ret)) {
         System.err.println("Infinite petrinetvaluedistance!");
      }
      return ret;
   }

   public static void initWith(final File modelFile) {
      INSTANCE = new RefactoringValueDistance(modelFile);
   }

   /**
    * Initializes the value distance calculator.
    * 
    * @param targetModel
    *           the target model to compare with
    */
   public RefactoringValueDistance(final File targetModel) {
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
