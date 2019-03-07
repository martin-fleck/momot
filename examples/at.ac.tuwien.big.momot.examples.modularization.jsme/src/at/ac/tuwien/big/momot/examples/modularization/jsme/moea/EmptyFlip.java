package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import at.ac.tuwien.big.moea.search.algorithm.operator.mutation.AbstractMutationVariation;

import org.moeaframework.core.Solution;

public class EmptyFlip extends AbstractMutationVariation {

   public EmptyFlip(final double probability) {
      super(probability);
   }

   @Override
   public Solution[] doEvolve(final Solution[] parents) {
      return new Solution[] { mutate(parents[0].copy()) };
   }

   private Solution mutate(final Solution copy) {
      return copy;
   }
}
