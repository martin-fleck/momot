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

import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

public class IncrementalIntegerValue implements IParameterValue<Integer> {

	private int initialValue;
	private int curValue;
	private int step;
	
	public IncrementalIntegerValue() {
		this(0, 1);
	}
	
	public IncrementalIntegerValue(int initialValue) {
		this(initialValue, 1);
	}
	
	public IncrementalIntegerValue(int initialValue, int step) {
		this.initialValue = initialValue;
		this.curValue = initialValue;
		this.step = step;
	}
	
	public int getStartValue() {
		return initialValue;
	}
	
	public int getStep() {
		return step;
	}
	
	public int getCurrentValue() {
		return curValue;
	}
	
	@Override
	public Integer nextValue() {
		int returnValue = curValue;
		curValue += step;
		return returnValue;
	}

	@Override
	public Integer getInitialValue() {
		return initialValue;
	}	

}
