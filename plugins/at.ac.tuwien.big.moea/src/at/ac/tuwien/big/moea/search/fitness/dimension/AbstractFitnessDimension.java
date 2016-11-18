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

import org.moeaframework.core.Solution;

public abstract class AbstractFitnessDimension<T extends Solution>
      implements IFitnessDimension<T>, Comparable<IFitnessDimension<T>> {

   private Class<T> clazz;
   private String name;
   private FunctionType functionType;
   private double weight = 1.0;

   public AbstractFitnessDimension(final Class<T> solutionClazz, final String name) {
      this(solutionClazz, name, FunctionType.Minimum);
   }

   public AbstractFitnessDimension(final Class<T> solutionClazz, final String name, final FunctionType type) {
      this.clazz = solutionClazz;
      this.name = name;
      this.functionType = type;
   }

   @Override
   public int compareTo(final IFitnessDimension<T> o) {
      return getName().compareTo(o.getName());
   }

   @Override
   public double doEvaluate(final Solution solution) {
      if(clazz.isInstance(solution)) {
         final double result = evaluate(clazz.cast(solution));
         if(Double.isInfinite(result)) {
            return result;
         }
         return getWeight() * result;
      }
      return WORST_FITNESS;
   }

   @Override
   public FunctionType getFunctionType() {
      return functionType;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public double getWeight() {
      return weight;
   }

   @Override
   public boolean isMaximumFunction() {
      return FunctionType.Maximum == getFunctionType();
   }

   @Override
   public boolean isMinimumFunction() {
      return FunctionType.Minimum == getFunctionType();
   }

   @Override
   public void setFunctionType(final FunctionType functionType) {
      this.functionType = functionType;
   }

   @Override
   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public IFitnessDimension<T> setWeight(final double weight) {
      this.weight = weight;
      return this;
   }

   @Override
   public String toString() {
      return getName();
   }
}
