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
package at.ac.tuwien.big.moea.search.algorithm.local.neighborhood;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhood;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;

public abstract class AbstractNeighborhood<S extends Solution> implements INeighborhood<S> {

	protected S baseSolution;
	protected int maxNeighbors = INeighborhoodFunction.UNLIMITED;
	
	public AbstractNeighborhood(S baseSolution, int maxNeighbors) {
		this.baseSolution = baseSolution;
		this.maxNeighbors = maxNeighbors;
	}
	
	public AbstractNeighborhood(S baseSolution) {
		this.baseSolution = baseSolution;
	}
	
	public S getBaseSolution() {
		return baseSolution;
	}
	
	@Override
	public int getMaxNeighbors() {
		return maxNeighbors;
	}
	
	public INeighborhood<S> setMaxNeighbors(int maxNeighbors) {
		this.maxNeighbors = maxNeighbors;
		return this;
	}
	
}
