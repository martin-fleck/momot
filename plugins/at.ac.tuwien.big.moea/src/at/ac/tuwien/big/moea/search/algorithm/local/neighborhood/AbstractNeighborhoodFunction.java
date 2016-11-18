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

import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhood;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;

import java.util.Iterator;

import org.moeaframework.core.Solution;

public abstract class AbstractNeighborhoodFunction<S extends Solution> implements INeighborhoodFunction<S> {

   private int maxNeighbors = UNLIMITED;

   public AbstractNeighborhoodFunction() {}

   public AbstractNeighborhoodFunction(final int maxNeighbors) {
      setMaxNeighbors(maxNeighbors);
   }

   @Override
   public INeighborhood<S> createEmptyNeighborhood() {
      return new INeighborhood<S>() {

         @Override
         public int getMaxNeighbors() {
            return 0;
         }

         @Override
         public Iterator<S> iterator() {
            return new Iterator<S>() {

               @Override
               public boolean hasNext() {
                  return false;
               }

               @Override
               public S next() {
                  return null;
               }

               @Override
               public void remove() {}
            };
         }
      };
   }

   @Override
   public INeighborhood<S> generateNeighbors(final S solution) {
      return generateNeighbors(solution, getMaxNeighbors());
   }

   @Override
   public int getMaxNeighbors() {
      return maxNeighbors;
   }

   @Override
   public INeighborhoodFunction<S> setMaxNeighbors(final int maxNeighbors) {
      this.maxNeighbors = maxNeighbors;
      return this;
   }
}
