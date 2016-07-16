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
package at.ac.tuwien.big.moea.search.fitness.dimension;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.fitness.IFitnessEvaluation;

public interface IFitnessDimension<T extends Solution> extends IFitnessEvaluation<T> {
	static final double CONSTRAINT_VIOLATED = WORST_FITNESS;
	static final double CONSTRAINT_OK = 0;
	
	public enum FunctionType {
		Minimum,
		Maximum
	}
	
	String getName();
	void setName(String name);
	
	FunctionType getFunctionType();
	void setFunctionType(FunctionType functionType);
	boolean isMaximumFunction();
	boolean isMinimumFunction();
	
	IFitnessDimension<T> setWeight(double weight);
	double getWeight();
}
