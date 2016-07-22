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
package at.ac.tuwien.big.momot.problem.unit.parameter.random;

import at.ac.tuwien.big.moea.util.random.RandomString;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

public class RandomStringParameterValue implements IParameterValue<String> {

   private final RandomString randomString;
   private String initialValue = null;

   public RandomStringParameterValue() {
      this(1);
   }

   public RandomStringParameterValue(final Integer length) {
      this(length, length);
   }

   public RandomStringParameterValue(final Integer lowerBoundLength, final Integer upperBoundLength) {
      randomString = new RandomString(lowerBoundLength, upperBoundLength);
   }

   @Override
   public String getInitialValue() {
      return initialValue;
   }

   @Override
   public String nextValue() {
      final String value = randomString.nextRandom();
      if(initialValue == null) {
         initialValue = value;
      }
      return value;
   }
}
