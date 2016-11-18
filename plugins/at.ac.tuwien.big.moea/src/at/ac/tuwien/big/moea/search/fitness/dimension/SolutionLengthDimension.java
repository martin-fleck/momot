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

import java.util.HashSet;
import java.util.Set;

import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

public class SolutionLengthDimension<S extends Solution> extends AbstractFitnessDimension<S> {

	private Set<String> ignored = new HashSet<>();
	
	public SolutionLengthDimension(Class<S> solutionClazz, String name, FunctionType type) {
		super(solutionClazz, name, type);
	}
	
	public SolutionLengthDimension(Class<S> solutionClazz, String name) {
		super(solutionClazz, name);
	}
	
	public SolutionLengthDimension<S> ignoreVariable(Class<? extends Variable> variableClazz) {
		ignored.add(variableClazz.getCanonicalName());
		return this;
	}

	@Override
	public double evaluate(S solution) {
		int vars = 0;
		for(int i = 0; i < solution.getNumberOfVariables(); i++) {
			Variable var = solution.getVariable(i);
			if(!ignored.contains(var.getClass().getCanonicalName()))
				vars++;
		}
		return vars;
	}

}
