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
package at.ac.tuwien.big.moea.search.fitness.dimension;

import org.moeaframework.core.Solution;

public class MinimumSolutionLengthDimension<S extends Solution> extends SolutionLengthDimension<S> {

	private int minimum;

	public MinimumSolutionLengthDimension(Class<S> solutionClazz, String name, int minimum) {
		super(solutionClazz, name);
		this.setMinimum(minimum);
	}	

	@Override
	public double evaluate(S solution) {
		double nrSolutions = super.evaluate(solution);
		if(nrSolutions < getMinimum())
			return getMinimum() - nrSolutions;
		return CONSTRAINT_OK;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
}
