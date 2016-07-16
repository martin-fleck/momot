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

public abstract class AbstractSolutionGenerator<S extends Solution> implements ISolutionGenerator<S> {
	private int nrConstraints;
	private int nrObjectives;
	private int solutionLength;
	
	public AbstractSolutionGenerator(int solutionLength, int nrObjectives, int nrConstraints) {
		this.solutionLength = solutionLength;
		this.nrObjectives = nrObjectives;
		this.nrConstraints = nrConstraints;
	}

	@Override
	public int getNrConstraints() {
		return nrConstraints;
	}

	@Override
	public int getNrObjectives() {
		return nrObjectives;
	}

	@Override
	public int getSolutionLength() {
		return solutionLength;
	}
	
	@Override
	public S createNewSolution() {
		return createNewSolution(getSolutionLength());
	}
	
	@Override
	public S createNewSolution(int solutionLength, int nrObjectives) {
		return createNewSolution(solutionLength, nrObjectives, getNrConstraints());
	}
	
	@Override
	public S createNewSolution(int solutionLength) {
		return createNewSolution(solutionLength, getNrObjectives(), getNrConstraints());
	}
	
}
