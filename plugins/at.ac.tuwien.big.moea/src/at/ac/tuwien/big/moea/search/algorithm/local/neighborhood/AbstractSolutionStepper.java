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
package at.ac.tuwien.big.moea.search.algorithm.local.neighborhood;

import org.moeaframework.core.Solution;

public abstract class AbstractSolutionStepper<S extends Solution> implements ISolutionStepper<S> {

   private final S baseSolution;
   private int maxSolutions = UNLIMITED;

   private int generatedSolutions = 0;

   public AbstractSolutionStepper(final S baseSolution) {
      this.baseSolution = baseSolution;
   }

   public AbstractSolutionStepper(final S baseSolution, final int maxSolutions) {
      this.baseSolution = baseSolution;
      this.maxSolutions = maxSolutions;
   }

   public S getBaseSolution() {
      return baseSolution;
   }

   public int getGeneratedSolutions() {
      return generatedSolutions;
   }

   @Override
   public int getMaxSolutions() {
      return maxSolutions;
   }

   protected abstract S getNext();

   @Override
   public boolean hasNext() {
      return getGeneratedSolutions() < getMaxSolutions();
   }

   @Override
   public S next() {
      final S next = getNext();
      this.generatedSolutions++;
      return next;
   }

   @Override
   public void remove() {
      throw new UnsupportedOperationException("'remove' operation is not supported by this iterator.");
   }

   @Override
   public ISolutionStepper<S> setMaxSolutions(final int maxSolutions) {
      this.maxSolutions = maxSolutions;
      return this;
   }
}
