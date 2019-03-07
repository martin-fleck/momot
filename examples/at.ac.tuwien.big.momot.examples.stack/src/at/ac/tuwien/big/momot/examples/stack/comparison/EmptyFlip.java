package at.ac.tuwien.big.momot.examples.stack.comparison;

import at.ac.tuwien.big.moea.search.algorithm.operator.mutation.AbstractMutationVariation;

import java.util.Random;

import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.BinaryVariable;

public class EmptyFlip extends AbstractMutationVariation {

   public EmptyFlip(final double probability) {
      super(probability);
   }

   @Override
   public Solution[] doEvolve(final Solution[] parents) {
      return new Solution[] { mutate(parents[0].copy()) };
   }

   private Solution mutate(final Solution copy) {
      final Variable variable = copy.getVariable(new Random().nextInt(copy.getNumberOfVariables()));
      if(variable instanceof BinaryVariable) {
         ((BinaryVariable) variable).clear();
      }
      return copy;
   }
}
