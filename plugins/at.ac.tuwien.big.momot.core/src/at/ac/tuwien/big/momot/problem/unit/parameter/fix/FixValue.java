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
package at.ac.tuwien.big.momot.problem.unit.parameter.fix;

import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

import org.eclipse.emf.henshin.model.Parameter;

public class FixValue<T extends Object> implements IParameterValue<T> {
   private T value;

   public FixValue(final Parameter parameter, final T value) {
      this.value = value;
   }

   public FixValue(final T value) {
      this(null, value);
   }

   @Override
   public T getInitialValue() {
      return value;
   }

   @Override
   public T nextValue() {
      return value;
   }

   protected void setValue(final T value) {
      this.value = value;
   }

}
