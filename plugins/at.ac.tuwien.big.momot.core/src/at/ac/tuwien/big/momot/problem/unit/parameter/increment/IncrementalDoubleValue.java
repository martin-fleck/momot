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
package at.ac.tuwien.big.momot.problem.unit.parameter.increment;

import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

public class IncrementalDoubleValue implements IParameterValue<Double> {

   private final double initialValue;
   private double curValue;
   private final double step;

   public IncrementalDoubleValue() {
      this(0.0, 1.0);
   }

   public IncrementalDoubleValue(final double initialValue) {
      this(initialValue, 1.0);
   }

   public IncrementalDoubleValue(final double initialValue, final double step) {
      this.initialValue = initialValue;
      this.curValue = initialValue;
      this.step = step;
   }

   public double getCurrentValue() {
      return curValue;
   }

   @Override
   public Double getInitialValue() {
      return initialValue;
   }

   public double getStep() {
      return step;
   }

   @Override
   public Double nextValue() {
      final double returnValue = curValue;
      curValue += step;
      return returnValue;
   }
}
