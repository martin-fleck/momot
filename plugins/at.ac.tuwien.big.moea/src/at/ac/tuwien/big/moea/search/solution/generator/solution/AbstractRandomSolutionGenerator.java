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
package at.ac.tuwien.big.moea.search.solution.generator.solution;

import org.moeaframework.core.Solution;

public abstract class AbstractRandomSolutionGenerator<S extends Solution> extends AbstractSolutionGenerator<S> implements IRandomSolutionGenerator<S> {
	
	public AbstractRandomSolutionGenerator(int solutionLength, int nrObjectives,
			int nrConstraints) {
		super(solutionLength, nrObjectives, nrConstraints);
	}
	
	public AbstractRandomSolutionGenerator(int solutionLength, int nrObjectives) {
		super(solutionLength, nrObjectives, 0);
	}
	
	public S createRandomSolution() {
		return createRandomSolution(getSolutionLength());
	}
	
	public S createRandomSolution(int solutionLength) {
		return createRandomSolution(solutionLength, getNrObjectives());
	}
	
	public S createRandomSolution(int solutionLength, int nrObjectives) {
		return createRandomSolution(solutionLength, nrObjectives, getNrConstraints());
	}
}
