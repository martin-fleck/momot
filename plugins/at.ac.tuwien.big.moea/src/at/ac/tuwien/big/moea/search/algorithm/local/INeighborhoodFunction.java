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
package at.ac.tuwien.big.moea.search.algorithm.local;

import java.util.Collection;

import org.moeaframework.core.Solution;

public interface INeighborhoodFunction<S extends Solution> {
	public static final int UNLIMITED = Integer.MAX_VALUE;
	
	int getMaxNeighbors();
	INeighborhoodFunction<S> setMaxNeighbors(int maxNeighbors);
	INeighborhood<S> generateNeighbors(S solution, Collection<Integer> forbiddenIndices);
	INeighborhood<S> generateNeighbors(S solution, int maxNeighbors, Collection<Integer> forbiddenIndices);
	INeighborhood<S> createEmptyNeighborhood();
}