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
package at.ac.tuwien.big.moea.search.algorithm.operator.mutation;

import org.moeaframework.core.PRNG;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.util.random.IRandomizable;

public class RandomizableMutation extends AbstractMutationVariation {

	public RandomizableMutation() { }
	
	public RandomizableMutation(double probability) {
		super(probability);
	}
	
	@Override
	protected Solution[] doEvolve(Solution[] parents) {
		Solution copy = parents[0].copy();
		int nrVariables = copy.getNumberOfVariables();
		int randomVar = PRNG.nextInt(nrVariables);
		if(copy.getVariable(randomVar) instanceof IRandomizable<?>) 
			((IRandomizable<?>)copy.getVariable(randomVar)).randomize();
		return new Solution[] { copy };
	}

}
