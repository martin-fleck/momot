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
package at.ac.tuwien.big.momot.search.algorithm.operator.mutation;

import at.ac.tuwien.big.moea.search.algorithm.operator.mutation.AbstractMutationVariation;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

import org.moeaframework.core.Solution;

public abstract class AbstractTransformationMutation extends AbstractMutationVariation {

   public AbstractTransformationMutation() {
      super();
   }

   public AbstractTransformationMutation(final double probability) {
      super(probability);
   }

   @Override
   public Solution[] doEvolve(final Solution[] parents) {
      if(!(parents[0] instanceof TransformationSolution)) {
         return new Solution[] { parents[0] };
      }

      final TransformationSolution copy = ((TransformationSolution) parents[0]).copy();
      final TransformationSolution mutant = mutate(copy);
      return new Solution[] { mutant };
   }

   protected abstract TransformationSolution mutate(TransformationSolution mutant);

}
