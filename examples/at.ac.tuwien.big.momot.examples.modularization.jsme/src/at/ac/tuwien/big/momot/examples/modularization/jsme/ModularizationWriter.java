package at.ac.tuwien.big.momot.examples.modularization.jsme;

import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.util.MomotUtil;

import org.eclipse.emf.henshin.interpreter.EGraph;

public class ModularizationWriter extends TransformationSolutionWriter {

   public ModularizationWriter() {}

   public ModularizationWriter(final IMultiDimensionalFitnessFunction<?> fitnessFunction) {
      super(fitnessFunction);
   }

   @Override
   public String write(final EGraph graph) {
      String superWrite = super.write(graph);
      superWrite += MomotUtil.getRoot(graph).toString();
      return superWrite;
   }

}
