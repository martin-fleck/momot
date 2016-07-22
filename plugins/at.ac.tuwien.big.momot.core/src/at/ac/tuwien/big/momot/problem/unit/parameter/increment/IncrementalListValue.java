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

import at.ac.tuwien.big.momot.problem.unit.parameter.AbstractListValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

import java.util.List;

public class IncrementalListValue<T extends Object> extends AbstractListValue<T> implements IParameterValue<T> {

   private int index = 0;

   public IncrementalListValue(final IParameterValue<T> value, final int nrValues) {
      super(value, nrValues);
   }

   public IncrementalListValue(final List<T> values) {
      super(values);
   }

   @Override
   protected int nextIndex() {
      final int curIndex = index;
      index = (index + 1) % getValues().size();
      return curIndex;
   }
}
