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
package at.ac.tuwien.big.momot.search.solution.repair;

import java.util.Arrays;
import java.util.List;

import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class TransformationUnitRepairer extends TransformationSolutionRepairer {

	private SearchHelper searchHelper;

	public TransformationUnitRepairer(SearchHelper searchHelper) {
		this.searchHelper = searchHelper;
	}

	public SearchHelper getSearchHelper() {
		return searchHelper;
	}

	@Override
	public TransformationSolution repair(TransformationSolution solution) {
		int firstNotExecuted = 0;
		while(solution.getVariable(firstNotExecuted).isExecuted())
			firstNotExecuted++;
		
		List<ITransformationVariable> variables = Arrays.asList(solution.getVariables());
		List<ITransformationVariable> executed = variables.subList(0, firstNotExecuted);
		int nrToExecute = solution.getNumberOfVariables() - executed.size();
		
		return getSearchHelper().appendRandomVariables(
				getSearchHelper().createTransformationSolution(
						solution.getSourceGraph(),
						executed, 
						solution.getNumberOfObjectives(), 
						solution.getNumberOfConstraints()), nrToExecute);				
	}
	

}
