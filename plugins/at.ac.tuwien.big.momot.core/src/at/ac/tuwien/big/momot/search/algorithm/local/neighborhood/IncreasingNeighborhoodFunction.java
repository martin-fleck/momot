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
package at.ac.tuwien.big.momot.search.algorithm.local.neighborhood;

import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhood;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.AbstractNeighborhoodFunction;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

import java.util.Iterator;

public class IncreasingNeighborhoodFunction extends AbstractNeighborhoodFunction<TransformationSolution> {

   private static final int DEFAULT_MAX_NEIGHBORS = 50;
   private final SearchHelper searchHelper;

   public IncreasingNeighborhoodFunction(final SearchHelper searchHelper) {
      this(searchHelper, DEFAULT_MAX_NEIGHBORS);
   }

   public IncreasingNeighborhoodFunction(final SearchHelper searchHelper, final int maxNeighbors) {
      super(maxNeighbors);
      this.searchHelper = searchHelper;
   }

   @Override
   public INeighborhood<TransformationSolution> generateNeighbors(final TransformationSolution solution,
         final int maxNeighbors) {
      final TransformationSolution nonEmptySolution = TransformationSolution.removePlaceholders(solution);
      return new AbstractMatchSolutionNeighborhood(nonEmptySolution, maxNeighbors) {

         @Override
         public Iterator<TransformationSolution> iterator() {
            return new AbstractTransformationSolutionStepper(getBaseSolution(), getMaxNeighbors()) {
               private TransformationSolution extendSolution(final TransformationSolution baseSolution) {
                  return getSearchHelper().appendRandomVariables(baseSolution, 1);
               }

               @Override
               protected TransformationSolution getNext() {
                  return extendSolution(getBaseSolution());
               }
            };
         }
      };
   }

   public SearchHelper getSearchHelper() {
      return searchHelper;
   }

}
