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

import at.ac.tuwien.big.moea.search.fitness.dimension.AbstractFitnessDimension;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public abstract class AbstractEGraphFitnessDimension extends AbstractFitnessDimension<TransformationSolution> implements IEGraphFitnessDimension {
	public AbstractEGraphFitnessDimension(String name) {
		super(TransformationSolution.class, name);
	}

	public AbstractEGraphFitnessDimension(String name, FunctionType type) {
		super(TransformationSolution.class, name, type);
	}
	
	@Override
	public double evaluate(TransformationSolution solution) {
		if( solution == null)
			return WORST_FITNESS;
		return internalEvaluate(solution);
	}

	protected abstract double internalEvaluate(TransformationSolution solution);
}