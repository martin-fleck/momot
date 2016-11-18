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

import at.ac.tuwien.big.moea.search.fitness.dimension.SolutionLengthDimension;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;

public class TransformationLengthDimension extends SolutionLengthDimension<TransformationSolution> {

	public static final String DEFAULT_NAME = "SolutionLength";
	
	public TransformationLengthDimension() {
		this(DEFAULT_NAME);
	}
	
	public TransformationLengthDimension(String name) {
		super(TransformationSolution.class, name, FunctionType.Minimum);
		ignoreVariable(TransformationPlaceholderVariable.class);
	}

}
