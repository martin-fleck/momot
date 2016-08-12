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
package at.ac.tuwien.big.moea.search.fitness.dimension;

import at.ac.tuwien.big.moea.search.fitness.IFitnessEvaluation;

import org.moeaframework.core.Solution;

public interface IFitnessDimension<T extends Solution> extends IFitnessEvaluation<T> {
   enum FunctionType {
      Minimum, Maximum
   }

   double CONSTRAINT_VIOLATED = WORST_FITNESS;

   double CONSTRAINT_OK = 0;

   FunctionType getFunctionType();

   String getName();

   double getWeight();

   boolean isMaximumFunction();

   boolean isMinimumFunction();

   void setFunctionType(FunctionType functionType);

   void setName(String name);

   IFitnessDimension<T> setWeight(double weight);
}
