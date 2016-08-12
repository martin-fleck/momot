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
package at.ac.tuwien.big.moea.search.fitness;

import at.ac.tuwien.big.moea.util.MathUtil;

import org.moeaframework.core.Solution;

public abstract class AbstractFitnessFunction<T extends Solution> implements IFitnessFunction<T> {

   private final Class<T> clazz;

   public AbstractFitnessFunction(final Class<T> clazz) {
      this.clazz = clazz;
   }

   @Override
   public double doEvaluate(final Solution solution) {
      if(!clazz.isInstance(solution)) {
         for(final int i : evaluatesObjectives()) {
            solution.setObjective(i, WORST_FITNESS);
         }
         for(final int i : evaluatesConstraints()) {
            solution.setConstraint(i, WORST_FITNESS);
         }
      } else {
         return evaluate(clazz.cast(solution));
      }

      return getAggregateFitness(solution);
   }

   @Override
   public abstract double evaluate(T solution);

   @Override
   public abstract int[] evaluatesConstraints();

   @Override
   public int evaluatesNrConstraints() {
      return evaluatesConstraints().length;
   }

   @Override
   public int evaluatesNrObjectives() {
      return evaluatesObjectives().length;
   }

   @Override
   public abstract int[] evaluatesObjectives();

   protected double getAggregateFitness(final Solution solution) {
      return MathUtil.getSum(solution.getConstraints(), solution.getObjectives());
   }
}
