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

public class ObjectiveFitnessComparator<S extends Solution> extends AbstractFitnessComparator<Double, S> {

	private int objectiveIndex = 0;
	
	public ObjectiveFitnessComparator(int objectiveIndex) {
		this.objectiveIndex = objectiveIndex;
	}
	
	public int getObjectiveIndex() {
		return objectiveIndex;
	}
	
	@Override
	public Double getValue(S solution) {
		if(getObjectiveIndex() >= solution.getNumberOfObjectives())
			throw new IllegalArgumentException("Solution does not have " + getObjectiveIndex() + 1 + " objectives.");
		return solution.getObjective(getObjectiveIndex());
	}

}
