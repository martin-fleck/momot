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

import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

public abstract class AbstractRandomNumberValue<T extends Number> implements IParameterValue<T> {

	private T lowerBound;
	private T upperBound;
	
	public AbstractRandomNumberValue(T lowerBound, T upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		checkBounds();
	}
	
	public T getLowerBound() {
		return lowerBound;
	}

	public T getUpperBound() {
		return upperBound;
	}
	
	public void checkBounds() {
		if(getLowerBound() == null)
			throw new IllegalArgumentException("Lower bound must not be null.");
		if(getUpperBound() == null)
			throw new IllegalArgumentException("Upper bound must not be null.");
		if(getLowerBound().doubleValue() > getUpperBound().doubleValue())
			throw new IllegalArgumentException("Lower bound must not be greater than upper bound.");
	}

}
