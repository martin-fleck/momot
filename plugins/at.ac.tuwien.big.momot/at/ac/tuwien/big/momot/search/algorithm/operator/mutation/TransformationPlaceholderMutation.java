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
package at.ac.tuwien.big.momot.search.algorithm.operator.mutation;

import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;

public class TransformationPlaceholderMutation extends AbstractTransformationMutation {
	
	public TransformationPlaceholderMutation(double probability) {
		super(probability);
	}
	
	@Override
	protected TransformationSolution mutate(TransformationSolution mutant) {
		int randomVariable = MathUtil.randomInteger(mutant.getNumberOfVariables());
		mutant.setVariable(randomVariable, new TransformationPlaceholderVariable());
		return mutant;
	}

}
