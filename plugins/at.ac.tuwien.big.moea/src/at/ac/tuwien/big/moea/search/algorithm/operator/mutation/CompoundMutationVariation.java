/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.moea.search.algorithm.operator.mutation;

import at.ac.tuwien.big.moea.problem.solution.variable.PlaceholderVariable;
import at.ac.tuwien.big.moea.search.algorithm.operator.AbstractProbabilityVariation;
import at.ac.tuwien.big.moea.search.algorithm.operator.IProbabilityVariation;
import at.ac.tuwien.big.moea.util.CollectionUtil;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;

import java.util.List;

import org.moeaframework.core.PRNG;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

public class CompoundMutationVariation extends AbstractMutationVariation {

   {
      System.out.println("Compound mutation variation crated!");
   }

   private final List<IProbabilityVariation> operators;

   private boolean isAlternate = false;

   private final double replaceWithPlaceholderProbability;

   public CompoundMutationVariation(final double probability) {
      this(probability, new IProbabilityVariation[] {});
   }

   public CompoundMutationVariation(final double probability, final double replaceWithPlaceholderProbability,
         final IProbabilityVariation... operators) {
      super(probability);
      this.operators = CollectionUtil.newList(operators);
      this.isAlternate = true;
      this.replaceWithPlaceholderProbability = replaceWithPlaceholderProbability;
   }

   public CompoundMutationVariation(final double probability, final IProbabilityVariation... operators) {
      super(probability);
      this.operators = CollectionUtil.newList(operators);
      this.replaceWithPlaceholderProbability = 0.0;
   }

   public CompoundMutationVariation addOperator(final IProbabilityVariation operator) {
      this.operators.add(operator);
      return this;
   }

   @Override
   public Solution[] doEvolve(final Solution[] parents) {
      if(isAlternate) {
         System.out.println("Alternate solution!");
         for(int k = 0; k < parents.length; ++k) {
            final Solution sol = parents[k];
            final int location = PRNG.nextInt(sol.getNumberOfVariables());
            final Variable variable = sol.getVariable(location);
            final boolean placeholder;
            if(variable instanceof PlaceholderVariable) {
               placeholder = false;
            } else {
               placeholder = PRNG.nextDouble() < replaceWithPlaceholderProbability;
            }
            if(placeholder) {
               sol.setVariable(location, new TransformationPlaceholderVariable());
            } else {
               // randomly choose one
               double sum = 0.0;
               final double[] probs = new double[operators.size()];
               int ind = 0;
               for(final IProbabilityVariation operator : operators) {
                  final double val = operator.getProbability();
                  sum += val;
                  probs[ind] = sum;
                  ++ind;
               }
               final double choose = PRNG.nextDouble(0.0, sum);
               int chosen = 0;
               for(; chosen < probs.length; ++chosen) {
                  if(choose < probs[chosen]) {
                     break;
                  }
               }
               if(chosen >= probs.length) {
                  // Should not be
                  new Exception().printStackTrace();
                  System.err.println("How can that be?");
                  break;
               }
               final IProbabilityVariation amv = operators.get(chosen);
               if(amv instanceof AbstractProbabilityVariation) {
                  parents[k] = ((AbstractProbabilityVariation) amv).doEvolve(parents)[k];
               } else {
                  parents[k] = amv.evolve(parents)[k];
               }
            }
            // parents[k] = sol;
         }
         return parents;
      } else {
         System.out.println("Compound mutation variation executed!");
         Solution[] evolved = parents;
         for(final IProbabilityVariation op : getOperators()) {
            evolved = op.evolve(evolved);
         }
         return evolved;
      }
   }

   public List<IProbabilityVariation> getOperators() {
      return operators;
   }

}
