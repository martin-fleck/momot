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
package at.ac.tuwien.big.moea.problem.solution;

import at.ac.tuwien.big.moea.util.CastUtil;

import java.io.Serializable;

import org.moeaframework.core.Solution;

public class SearchSolution extends Solution {
   private static final long serialVersionUID = 1489801128861913870L;

   /**
    * The aggregated fitness of a solution is the sum of all objective values
    * plus the sum of all constraint values.
    */
   public static final String ATTRIBUTE_AGGREGATED_FITNESS = "AggregatedFitness";

   public SearchSolution(final double[] objectives) {
      super(objectives);
   }

   public SearchSolution(final int numberOfVariables, final int numberOfObjectives) {
      super(numberOfVariables, numberOfObjectives);
   }

   public SearchSolution(final int numberOfVariables, final int numberOfObjectives, final int numberOfConstraints) {
      super(numberOfVariables, numberOfObjectives, numberOfConstraints);
   }

   public SearchSolution(final Solution solution) {
      super(solution);
   }

   public <A extends Serializable> A getAttribute(final String key, final Class<A> resultClass) {
      return CastUtil.asClass(getAttribute(key), resultClass);
   }

   public Double getStoredAggregatedFitness() {
      return getAttribute(ATTRIBUTE_AGGREGATED_FITNESS, Double.class);
   }

   public void removeStoredAggregatedFitness() {
      removeAttribute(ATTRIBUTE_AGGREGATED_FITNESS);
   }

   public void storeAggregatedFitness(final double fitness) {
      setAttribute(ATTRIBUTE_AGGREGATED_FITNESS, fitness);
   }
}
