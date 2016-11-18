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
package at.ac.tuwien.big.moea.problem;

import org.moeaframework.core.Solution;
import org.moeaframework.problem.AbstractProblem;

import at.ac.tuwien.big.moea.search.fitness.IFitnessFunction;
import at.ac.tuwien.big.moea.search.solution.generator.solution.ISolutionGenerator;

public class SearchProblem<S extends Solution> extends AbstractProblem implements ISearchProblem<S> {
	
	private ISolutionGenerator<S> solutionGenerator;
	private IFitnessFunction<S> fitnessFunction;

	public SearchProblem(IFitnessFunction<S> fitnessFunction, ISolutionGenerator<S> solutionGenerator) {
		super(solutionGenerator.getSolutionLength(), solutionGenerator.getNrObjectives(), solutionGenerator.getNrConstraints());
		this.fitnessFunction = fitnessFunction;
		this.solutionGenerator = solutionGenerator;
	}

	public ISolutionGenerator<S> getSolutionGenerator() {
		return solutionGenerator;
	}

	public IFitnessFunction<S> getFitnessFunction() {
		return fitnessFunction;
	}

	@Override
	public void evaluate(Solution solution) {
		getFitnessFunction().doEvaluate(solution);
	}

	@Override
	public Solution newSolution() {
		return getSolutionGenerator().createNewSolution();
	}

}
