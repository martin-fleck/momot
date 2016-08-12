package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.util.EcoreUtil;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;

public class RefactoringSolutionWriter extends TransformationSolutionWriter {

   public RefactoringSolutionWriter(final IMultiDimensionalFitnessFunction<?> fitnessFunction) {
      super(fitnessFunction);
   }

   private String printExecutionResult(final TransformationSolution solution) {
      final EGraph result = solution.execute();
      if(result != null) {
         return write(result);
      }
      return "";
   }

   @SuppressWarnings("unchecked")
   @Override
   public String write(final EGraph graph) {
      String result = "";
      final String delim = "";
      for(final EObject obj : graph) {
         if(obj.eClass().getName().equals("Entity")) {
            result += delim;
            final String name = EcoreUtil.getFeatureValue(obj, "name", String.class);
            result += name;

            final EObject generalization = EcoreUtil.getFeatureValue(obj, "generalization", EObject.class);
            if(generalization != null) {
               final EObject generalizationEntity = EcoreUtil.getFeatureValue(generalization, "general", EObject.class);
               result += " : " + EcoreUtil.getFeatureValue(generalizationEntity, "name", String.class);
            }

            result += " {";

            final EList<EObject> properties = EcoreUtil.getFeatureValue(obj, "ownedAttribute", EList.class);
            if(!properties.isEmpty()) {
               result += "\n";
            }
            String propDelim = "";
            for(final EObject property : properties) {
               final String propertyName = EcoreUtil.getFeatureValue(property, "name", String.class);
               final EObject propertyType = EcoreUtil.getFeatureValue(property, "type", EObject.class);
               final String typeName = EcoreUtil.getFeatureValue(propertyType, "name", String.class);
               result += propDelim + "  " + propertyName + ": " + typeName;
               propDelim = ",\n";
            }
            if(!properties.isEmpty()) {
               result += "\n";
            }
            result += "}\n";
            // delim = "\n";
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
