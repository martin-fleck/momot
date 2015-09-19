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
package at.ac.tuwien.big.moea.search.fitness.comparator;

import org.moeaframework.core.Solution;

public class ConstraintFitnessComparator<S extends Solution> extends AbstractFitnessComparator<Double, S> {

	private int constraintIndex = 0;
	
	public ConstraintFitnessComparator(int constraintIndex) {
		this.constraintIndex = constraintIndex;
	}
	
	public int getConstraintIndex() {
		return constraintIndex;
	}
	
	@Override
	public Double getValue(S solution) {
		if(getConstraintIndex() >= solution.getNumberOfConstraints())
			throw new IllegalArgumentException("Solution does not have " + getConstraintIndex() + 1 + " constraints.");
		return solution.getConstraint(getConstraintIndex());
	}
}
