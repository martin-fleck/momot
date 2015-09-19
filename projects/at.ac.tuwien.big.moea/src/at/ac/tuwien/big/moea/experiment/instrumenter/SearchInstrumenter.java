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
package at.ac.tuwien.big.moea.experiment.instrumenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.moeaframework.Instrumenter;
import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.analysis.collector.Collector;
import org.moeaframework.analysis.collector.InstrumentedAlgorithm;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.ISearchProblem;

public class SearchInstrumenter extends Instrumenter {
	protected List<Accumulator> accumulators = new ArrayList<>();
	
	public SearchInstrumenter() {
		super.addAllowedPackage("at.ac.tuwien.big.moea");
		super.addAllowedPackage("at.ac.tuwien.big.momot");
	}
	
	public SearchInstrumenter(ISearchProblem<? extends Solution> problem) {
		this();
		withProblem(problem);
	}
	
	public List<Accumulator> getAccumulators() {
		return accumulators;
	}
	
	@Override
	public SearchInstrumenter withProblemClass(Class<?> problemClass,
			Object... problemArguments) {
		return (SearchInstrumenter) super.withProblemClass(problemClass, problemArguments);
	}
	
	public SearchInstrumenter withProblem(ISearchProblem<? extends Solution> problem) {
		return withProblemClass(problem.getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());
	}
	
	protected void addAccumulator(Accumulator accumulator) {
		if(!accumulators.contains(accumulator))
			accumulators.add(accumulator);
	}
	
	@Override
	protected void instrument(InstrumentedAlgorithm algorithm, List<Collector> collectors, Set<Object> visited,
			Stack<Object> parents, Object object, Class<?> type) {
		super.instrument(algorithm, collectors, visited, parents, object, type);
		addAccumulator(getLastAccumulator());
	}
}
