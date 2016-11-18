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
package at.ac.tuwien.big.momot.search.fitness;

import at.ac.tuwien.big.moea.search.fitness.MultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer;

public class EGraphMultiDimensionalFitnessFunction extends MultiDimensionalFitnessFunction<TransformationSolution> implements IEGraphMultiDimensionalFitnessFunction {
	public EGraphMultiDimensionalFitnessFunction() {
		super(TransformationSolution.class);
	}	
	
	@Override
	protected void preprocessEvaluation(TransformationSolution solution) {
		solution.execute();
		super.preprocessEvaluation(solution);
	}
	
	@Override
	public IEGraphMultiDimensionalFitnessFunction setSolutionRepairer(ITransformationRepairer repairer) {
		this.repairer = repairer;
		return this;
	}
}
