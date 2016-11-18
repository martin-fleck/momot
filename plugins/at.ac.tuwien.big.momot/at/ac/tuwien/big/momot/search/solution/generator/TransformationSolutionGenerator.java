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
package at.ac.tuwien.big.momot.search.solution.generator;

import at.ac.tuwien.big.moea.search.solution.generator.solution.AbstractRandomSolutionGenerator;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class TransformationSolutionGenerator extends AbstractRandomSolutionGenerator<TransformationSolution> {

	private SearchHelper searchHelper;

	public TransformationSolutionGenerator(SearchHelper searchHelper) {
		super(searchHelper.getSearchOrchestration().getSolutionLength(),
				searchHelper.getSearchOrchestration().getNumberOfObjectives(),
				searchHelper.getSearchOrchestration().getNumberOfConstraints());
		this.searchHelper = searchHelper;
	}	
	
	public SearchHelper getSearchHelper() {
		return searchHelper;
	}

	@Override
	public TransformationSolution createNewSolution(int solutionLength, int nrObjectives, int nrConstraints) {
		return getSearchHelper().createEmptyTransformationSolution(solutionLength, nrObjectives, nrConstraints);
	}

	@Override
	public TransformationSolution createRandomSolution(int solutionLength, int nrObjectives, int nrConstraints) {
		return getSearchHelper().createRandomTransformationSolution(solutionLength, nrObjectives, nrConstraints);
	}
}
