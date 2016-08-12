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

import at.ac.tuwien.big.moea.search.algorithm.operator.IProbabilityVariation;
import at.ac.tuwien.big.moea.util.CollectionUtil;

import java.util.List;

import org.moeaframework.core.Solution;

public class CompoundMutationVariation extends AbstractMutationVariation {

   private final List<IProbabilityVariation> operators;

   public CompoundMutationVariation(final double probability) {
      this(probability, new IProbabilityVariation[] {});
   }

   public CompoundMutationVariation(final double probability, final IProbabilityVariation... operators) {
      super(probability);
      this.operators = CollectionUtil.newList(operators);
   }

   public CompoundMutationVariation addOperator(final IProbabilityVariation operator) {
      this.operators.add(operator);
      return this;
   }

   @Override
   public Solution[] doEvolve(final Solution[] parents) {
      Solution[] evolved = parents;
      for(final IProbabilityVariation op : getOperators()) {
         evolved = op.evolve(evolved);
      }
      return evolved;
   }

   public List<IProbabilityVariation> getOperators() {
      return operators;
   }

}
