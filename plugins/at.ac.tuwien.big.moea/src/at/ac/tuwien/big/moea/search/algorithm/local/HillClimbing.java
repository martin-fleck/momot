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
package at.ac.tuwien.big.moea.search.algorithm.local;

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

public class HillClimbing<S extends Solution> extends AbstractLocalSearchAlgorithm<S> {

   private int noImprovement = 0;

   public HillClimbing(final Problem problem, final S initialSolution,
         final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> fitnessComparator) {
      super(problem, initialSolution, neighborhoodFunction, fitnessComparator);
      if(neighborhoodFunction.getMaxNeighbors() == INeighborhoodFunction.UNLIMITED) {
         System.err.println(
               "Warning: Neighborhood-Function may produce infinite neighbors, Hill-Climbing may get stuck in infinite loop.");
      }
   }

   @Override
   protected void iterate() {
      final List<S> neighbors = new ArrayList<>();
      for(final S neighbor : generateCurrentNeighbors()) {
         evaluate(neighbor);
         neighbors.add(neighbor);
      }
      if(neighbors.isEmpty()) {
         terminate();
         return;
      }
      final S bestNeighbor = getBest(neighbors);
      if(!update(bestNeighbor)) {
         noImprovement++;
         // else
         // System.err.println("improvmeent");
      }
   }
}
