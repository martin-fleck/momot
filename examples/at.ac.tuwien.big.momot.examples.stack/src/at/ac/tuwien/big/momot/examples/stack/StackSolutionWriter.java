package at.ac.tuwien.big.momot.examples.stack;

import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.util.EcoreUtil;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;

public class StackSolutionWriter extends TransformationSolutionWriter {

   public StackSolutionWriter(final IMultiDimensionalFitnessFunction<?> fitnessFunction) {
      super(fitnessFunction);
   }

   public String printExecutionResult(final TransformationSolution solution) {
      final EGraph result = solution.execute();
      if(result != null) {
         return write(result);
      }
      return "-no result-";
   }

   @Override
   public String write(final EGraph graph) {
      String result = "";
      String delim = "";
      for(final EObject obj : graph) {
         if(EcoreUtil.isEClass(obj, "Stack")) {
            final String id = EcoreUtil.getFeatureValue(obj, "id", String.class);
            final Integer load = EcoreUtil.getFeatureValue(obj, "load", Integer.class);
            result += delim + id + ": " + load;
            delim = "\n";
         }
      }
      return result;
   }

   @Override
   public String write(final TransformationSolution solution) {
      String txt = super.write(solution);
      txt += "------------\n";
      txt += printExecutionResult(solution);
      return txt;
   }
}
