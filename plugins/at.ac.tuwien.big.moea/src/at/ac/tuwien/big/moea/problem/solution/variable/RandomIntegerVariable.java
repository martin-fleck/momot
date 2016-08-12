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
package at.ac.tuwien.big.moea.problem.solution.variable;

import at.ac.tuwien.big.moea.util.TextUtil;
import at.ac.tuwien.big.moea.util.random.RandomInteger;

import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.RealVariable;

public class RandomIntegerVariable implements Variable {

   private static final long serialVersionUID = -8144298676316291939L;

   private final RandomInteger randomInteger;
   private Integer value;

   public RandomIntegerVariable(final int lowerBound, final int upperBound) {
      randomInteger = new RandomInteger(lowerBound, upperBound);
      randomize();
   }

   public RandomIntegerVariable(final int value, final int lowerBound, final int upperBound) {
      randomInteger = new RandomInteger(lowerBound, upperBound);
      setValue(value);
   }

   @Override
   public RandomIntegerVariable copy() {
      return new RandomIntegerVariable(getValue(), randomInteger.getLowerBound(), randomInteger.getUpperBound());
   }

   @Override
   public boolean equals(final Object obj) {
      if(this == obj) {
         return true;
      }
      if(obj == null) {
         return false;
      }
      if(getClass() != obj.getClass()) {
         return false;
      }
      final RandomIntegerVariable other = (RandomIntegerVariable) obj;
      if(value == null) {
         if(other.value != null) {
            return false;
         }
      } else if(!value.equals(other.value)) {
         return false;
      }
      return true;
   }

   public int getLowerBound() {
      return randomInteger.getLowerBound();
   }

   public int getUpperBound() {
      return randomInteger.getUpperBound();
   }

   public int getValue() {
      return value;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + (value == null ? 0 : value.hashCode());
      return result;
   }

   @Override
   public void randomize() {
      this.value = randomInteger.nextRandom();
   }

   public void setValue(final int value) {
      if(value < getLowerBound() || value > getUpperBound()) {
         throw new IllegalArgumentException("Value must be between lower and upper bound.");
      }
      this.value = value;
   }

   public String toRangeString() {
      return TextUtil.toRangeString(this);
   }

   public RealVariable toRealVariable() {
      final RealVariable var = EncodingUtils.newInt(randomInteger.getLowerBound(), randomInteger.getUpperBound() - 1);
      EncodingUtils.setInt(var, getValue());
      return var;
   }

   @Override
   public String toString() {
      return "" + getValue();
   }
}
