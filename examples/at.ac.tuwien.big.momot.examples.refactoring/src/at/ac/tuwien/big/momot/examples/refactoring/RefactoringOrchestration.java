package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;

import org.eclipse.ocl.ParserException;

public class RefactoringOrchestration extends TransformationSearchOrchestration {
   public RefactoringOrchestration(final String initialGraph, final int solutionLength) {
      super(new ModuleManager("model/", "Refactoring.henshin"), initialGraph, solutionLength);

      getFitnessFunction().addObjective(new TransformationLengthDimension());
      try {
         getFitnessFunction().addObjective(
               new OCLQueryDimension("ContentSize", "propertys->size() * 1.1 + entitys->size()", createOCLHelper()));
      } catch(final ParserException e) {
         e.printStackTrace();
      }

      getFitnessFunction().setSolutionRepairer(new TransformationPlaceholderRepairer());
      setSolutionWriter(new RefactoringSolutionWriter(getFitnessFunction()));
   }
}
