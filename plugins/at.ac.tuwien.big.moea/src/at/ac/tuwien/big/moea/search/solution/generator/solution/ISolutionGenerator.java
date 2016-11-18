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

public interface ISolutionGenerator<S extends Solution> {
	/**
	 * Returns a new solution for a problem. Implementations must initialize 
	 * the variables so that the valid range of values is defined, but may 
	 * leave the actual value at a default or undefined state.
	 * @return newly created solution
	 */
	S createNewSolution();
	
	S createNewSolution(int nrVariables);
	
	S createNewSolution(int nrVariables, int nrObjectives);
	
	S createNewSolution(int nrVariables, int nrObjectives, int nrConstraints);
	
	int getNrConstraints();

	int getNrObjectives();

	int getSolutionLength();
}
