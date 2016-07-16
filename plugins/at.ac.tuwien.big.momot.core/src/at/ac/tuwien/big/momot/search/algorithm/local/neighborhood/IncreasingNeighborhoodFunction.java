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
package at.ac.tuwien.big.momot.search.algorithm.local.neighborhood;

import java.util.Iterator;

import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhood;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.AbstractNeighborhoodFunction;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class IncreasingNeighborhoodFunction extends AbstractNeighborhoodFunction<TransformationSolution> {

	private SearchHelper searchHelper;

	public IncreasingNeighborhoodFunction(SearchHelper searchHelper, int maxNeighbors) {
		super(maxNeighbors);
		this.searchHelper = searchHelper;
	}
	
	public IncreasingNeighborhoodFunction(SearchHelper searchHelper) {
		this(searchHelper, 50);
	}	
	
	public SearchHelper getSearchHelper() {
		return searchHelper;
	}
	
	@Override
	public INeighborhood<TransformationSolution> generateNeighbors(
			TransformationSolution solution, int maxNeighbors) {
		TransformationSolution nonEmptySolution = TransformationSolution.removePlaceholders(solution);
		return new AbstractMatchSolutionNeighborhood(nonEmptySolution, maxNeighbors) {
			
			@Override
			public Iterator<TransformationSolution> iterator() {
				return new AbstractTransformationSolutionStepper(getBaseSolution(), getMaxNeighbors()) {
					@Override
					protected TransformationSolution getNext() {
						return extendSolution(getBaseSolution());
					}

					private TransformationSolution extendSolution(TransformationSolution baseSolution) {
						return getSearchHelper().appendRandomVariables(baseSolution, 1);
					}
				};
			}
		};
	}

}
