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

import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.RealVariable;

import at.ac.tuwien.big.moea.util.TextUtil;
import at.ac.tuwien.big.moea.util.random.RandomInteger;

public class RandomIntegerVariable implements Variable {

	private static final long serialVersionUID = -8144298676316291939L;
	
	private RandomInteger randomInteger;
	private Integer value;
	
	public RandomIntegerVariable(int lowerBound, int upperBound) {
		randomInteger = new RandomInteger(lowerBound, upperBound);
		randomize();
	}
	
	public RandomIntegerVariable(int value, int lowerBound, int upperBound) {
		randomInteger = new RandomInteger(lowerBound, upperBound);
		setValue(value);
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
	
	public void setValue(int value) {
		if(value < getLowerBound() || value > getUpperBound())
			throw new IllegalArgumentException("Value must be between lower and upper bound.");
		this.value = value;
	}
	
	@Override
	public void randomize() {
		this.value = randomInteger.nextRandom();
	}
	
	@Override
	public RandomIntegerVariable copy() {
		return new RandomIntegerVariable(getValue(), randomInteger.getLowerBound(), randomInteger.getUpperBound());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != getClass())
			return false;
		
		RandomIntegerVariable other = (RandomIntegerVariable) obj;
		return Integer.compare(getValue(), other.getValue()) == 0;
	}
	
	@Override
	public String toString() {
		return "" + getValue();
	}
	
	public RealVariable toRealVariable() {
		RealVariable var = EncodingUtils.newInt(randomInteger.getLowerBound(), randomInteger.getUpperBound() - 1);
		EncodingUtils.setInt(var, getValue());
		return var;
	}
	
	public String toRangeString() {
		return TextUtil.toRangeString(this);
	}
}
