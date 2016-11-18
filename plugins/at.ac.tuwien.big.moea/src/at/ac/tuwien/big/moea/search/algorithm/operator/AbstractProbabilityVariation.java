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
package at.ac.tuwien.big.moea.search.algorithm.operator;

import org.moeaframework.core.PRNG;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

import at.ac.tuwien.big.moea.util.MathUtil;

public abstract class AbstractProbabilityVariation implements IProbabilityVariation {
	
	private double probability;
	
	public AbstractProbabilityVariation() {
		this(ALWAYS_EVOLVE);
	}
	
	public AbstractProbabilityVariation(double probability) {
		this.probability = probability;
	}
	
	public double getProbability() {
		return probability;
	}
	
	public AbstractProbabilityVariation setProbability(double probability) {
		this.probability = probability;
		return this;
	}
	
	public boolean shouldEvolve() {
		return shouldEvolve(getProbability());
	}
	
	protected void checkArity(Solution[] parents) {
		if(parents == null || parents.length != getArity())
			throw new IllegalArgumentException(getArity() + " solutions must be supplied to this variation.");
	}
	
	@Override
	public Solution[] evolve(Solution[] parents) {
		checkArity(parents);	
		if(!shouldEvolve())
			return parents;
		return doEvolve(parents);
	}
	
	protected abstract Solution[] doEvolve(Solution[] parents);
	
	public static boolean shouldEvolve(double probability) {
		if(probability == 0.0)
			return false;
		if(probability == 1.0)
			return true;
		return PRNG.nextDouble() <= probability;
	}
	
	public static Variable getRandomVariable(Solution solution) {
		if(solution == null || solution.getNumberOfVariables() == 0)
			return null;
		
		return solution.getVariable(MathUtil.randomInteger(solution.getNumberOfVariables()));
	}
}
