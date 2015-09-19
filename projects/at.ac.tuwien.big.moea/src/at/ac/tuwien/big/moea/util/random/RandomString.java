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

import org.apache.commons.lang.RandomStringUtils;

public class RandomString implements IRandomGenerator<String> {

	RandomInteger randomInteger;
	
	public RandomString(int lowerBoundLength, int upperBoundLength) {
		randomInteger = new RandomInteger(lowerBoundLength, upperBoundLength);
	}
	
	public RandomString(int length) {
		this(length, length);
	}

	@Override
	public String nextRandom() {
		return RandomStringUtils.random(randomInteger.nextRandom());
	}
}
