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

import java.util.List;

import at.ac.tuwien.big.moea.util.random.RandomInteger;
import at.ac.tuwien.big.momot.problem.unit.parameter.AbstractListValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

public class RandomListValue<T extends Object> extends AbstractListValue<T> implements IParameterValue<T> {

	private RandomInteger index;
	
	public RandomListValue(IParameterValue<T> value, int nrValues) {
		this(generateList(value, nrValues));
	}
	
	public RandomListValue(List<T> values) {
		super(values);
		this.index = new RandomInteger(0, values.size() - 1);
	}

	@Override
	protected int nextIndex() {
		return index.nextRandom();
	}
}
