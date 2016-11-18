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
package at.ac.tuwien.big.momot.print;

import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;

public class TransformationSolutionWriter extends GenericTransformationSolutionPrinter {
	protected IMultiDimensionalFitnessFunction<?> fitnessFunction;
	
	public TransformationSolutionWriter() { }
	
	public TransformationSolutionWriter(IMultiDimensionalFitnessFunction<?> fitnessFunction) {
		this.fitnessFunction = fitnessFunction;
		setConstraintNames(fitnessFunction.getConstraintNames());
		setObjectiveNames(fitnessFunction.getObjectiveNames());
	}
	
	protected IMultiDimensionalFitnessFunction<?> getFitnessFunction() {
		return fitnessFunction;
	}
}
