package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emfmodeldistance.MoveDistance;

/**
 * This class is automatically generated for the Petrinet metamodel.
 * 
 * @author Eugene Syriani
 *
 */
public class RefactoringMoveDistance extends MoveDistance {
   private static RefactoringMoveDistance INSTANCE;

   public static double calculateFitness(final EObject model) {
      return INSTANCE.calculateDistance(model);
   }

   public static void initWith(final File modelFile) {
      INSTANCE = new RefactoringMoveDistance(modelFile);
   }

   /**
    * Initializes the move distance calculator.
    * 
    * @param targetModel
    *           the target model to compare with
    */
   public RefactoringMoveDistance(final File targetModel) {
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
