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
package at.ac.tuwien.big.moea.search.solution.generator;

import at.ac.tuwien.big.moea.search.solution.generator.solution.IRandomSolutionGenerator;

import org.moeaframework.core.Solution;

public class RandomPopulationGenerator<S extends Solution> implements IPopulationGenerator<S> {

   private final IRandomSolutionGenerator<S> solutionGenerator;
   private int populationSize;

   public RandomPopulationGenerator(final int populationSize, final IRandomSolutionGenerator<S> solutionGenerator) {
      this.populationSize = populationSize;
      this.solutionGenerator = solutionGenerator;
   }

   @Override
   public int getPopulationSize() {
      return populationSize;
   }

   public IRandomSolutionGenerator<S> getSolutionGenerator() {
      return solutionGenerator;
   }

   @Override
   public S[] initialize() {
      @SuppressWarnings("unchecked")
      final S[] population = (S[]) new Solution[getPopulationSize()];

      for(int i = 0; i < getPopulationSize(); i++) {
         population[i] = solutionGenerator.createRandomSolution();
      }

      return population;
   }

   @Override
   public IPopulationGenerator<S> setPopulationSize(final int populationSize) {
      this.populationSize = populationSize;
      return this;
   }
}
