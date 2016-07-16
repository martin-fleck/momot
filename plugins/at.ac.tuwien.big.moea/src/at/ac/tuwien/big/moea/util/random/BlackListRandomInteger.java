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

import java.util.HashSet;
import java.util.Set;

public class BlackListRandomInteger extends RandomInteger {
	private static final long serialVersionUID = -4132618436861069750L;

	private Set<Integer> blackList = new HashSet<>();

	public BlackListRandomInteger() {
		super();
	}

	public BlackListRandomInteger(int lowerBound, int upperBound) {
		super(lowerBound, upperBound);
	}
	
	public BlackListRandomInteger addToBlackList(int number) {
		if(number < getLowerBound() || number > getUpperBound())
			return this;
		blackList.add(number);
		return this;
	}
	
	public int getRange() {
		return getUpperBound() - getLowerBound() + 1;
	}
	
	@Override
	public Integer nextRandom() {
		return nextRandom(false);
	}
	
	public Integer nextRandom(boolean addToBlackList) {
		if(blackList.size() == getRange())
			return null;
		Integer random = super.nextRandom();
		while(blackList.contains(random))
			random = super.nextRandom();
		if(addToBlackList)
			addToBlackList(random);
		return random;
	}
}
