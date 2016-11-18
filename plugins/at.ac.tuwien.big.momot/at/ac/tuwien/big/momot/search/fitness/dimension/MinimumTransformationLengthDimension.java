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
package at.ac.tuwien.big.momot.search.fitness.dimension;

import at.ac.tuwien.big.moea.problem.solution.variable.PlaceholderVariable;
import at.ac.tuwien.big.moea.search.fitness.dimension.MinimumSolutionLengthDimension;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;

public class MinimumTransformationLengthDimension extends MinimumSolutionLengthDimension<TransformationSolution> {

	public MinimumTransformationLengthDimension(String name, int minimum) {
		super(TransformationSolution.class, name, minimum);
		ignoreVariable(PlaceholderVariable.class);
		ignoreVariable(TransformationPlaceholderVariable.class);
	}
	
	public MinimumTransformationLengthDimension(int minimum) {
		this("MinimumSolutionLength", minimum);
	}

}
