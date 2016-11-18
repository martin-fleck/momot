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

import org.moeaframework.core.PRNG;

public class RandomDoubleValue extends AbstractRandomNumberValue<Double> {

	private Double initialValue = null;
	
	public RandomDoubleValue() {
		this(0, 1);
	}
	
	public RandomDoubleValue(double lowerBound, double upperBound) {
		super(lowerBound, upperBound);
	}

	@Override
	public Double nextValue() {
		Double toReturn = PRNG.nextDouble(getLowerBound(), getUpperBound());
		if(initialValue == null)
			initialValue = new Double(toReturn);
		return toReturn;
	}
	
	@Override
	public String toString() {
		return super.toString() + "[" + getLowerBound() + "," + getUpperBound() + "]";
	}

	@Override
	public Double getInitialValue() {
		return initialValue;
	}
}
