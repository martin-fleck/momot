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
package at.ac.tuwien.big.moea.util.random;

import org.moeaframework.core.PRNG;

public class RandomInteger extends Number implements IRandomGenerator<Integer> {

	private static final long serialVersionUID = 1L;
	
	private int lowerBound;
	private int upperBound;
	
	public RandomInteger() {
		this(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public RandomInteger(int lowerBound, int upperBound) {
		this.setLowerBound(lowerBound);
		this.setUpperBound(upperBound);
		checkBounds();
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	@Override
	public Integer nextRandom() {
		return PRNG.nextInt(getLowerBound(), getUpperBound());
	}
	
	public void checkBounds() {
		if(getLowerBound() > getUpperBound())
			throw new IllegalArgumentException("Lower bound must not be greater than upper bound.");
	}

	@Override
	public double doubleValue() {
		return nextRandom();
	}

	@Override
	public float floatValue() {
		return nextRandom();
	}

	@Override
	public int intValue() {
		return nextRandom();
	}

	@Override
	public long longValue() {
		return nextRandom();
	}
}
