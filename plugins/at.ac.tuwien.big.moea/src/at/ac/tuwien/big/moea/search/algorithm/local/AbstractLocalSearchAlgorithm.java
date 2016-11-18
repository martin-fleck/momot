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
package at.ac.tuwien.big.moea.search.algorithm.local;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.moeaframework.algorithm.AbstractAlgorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.algorithm.RestartableAlgorithm;

public abstract class AbstractLocalSearchAlgorithm<S extends Solution> extends AbstractAlgorithm implements LocalSearchAlgorithm<S>, RestartableAlgorithm<S> {
	
	protected S initialSolution;
	
	protected S currentSolution;
	protected Comparable<?> currentFitness;
	
	protected S bestSolution;
	protected Comparable<?> bestFitness;
	
	protected INeighborhoodFunction<S> neighborhoodFunction;
	protected IFitnessComparator<?, S> fitnessComparator;
	
	protected NondominatedPopulation bestValues = new NondominatedPopulation();
	
	protected AbstractLocalSearchAlgorithm(Problem problem){
		super(problem);
	}
	

	private int forbiddenIndices = 0;
	

	public void setForbiddenIndices(int forbidden) {
		this.forbiddenIndices = forbidden;
	}
	
	private Queue<Integer> forbidden = new LinkedList<Integer>();
	
	public boolean isForbidden(int index) {
		return forbidden.contains(index);
	}
	
	public void addForbiddenIndex(int index) {
		if (forbiddenIndices == 0) {return;}
		forbidden.add(index);
		while (forbidden.size()>forbiddenIndices) {
			forbidden.poll();
		}
	}
	
	public AbstractLocalSearchAlgorithm(Problem problem, 
			S initialSolution,
			INeighborhoodFunction<S> neighborhoodFunction,
			IFitnessComparator<?, S> fitnessComparator) {
		super(problem);
		this.initialSolution = initialSolution;
		this.neighborhoodFunction = neighborhoodFunction;
		this.fitnessComparator = fitnessComparator;
	}

	protected NondominatedPopulation createPopulation(S solution) {
		return bestValues;
	}
	
	@Override
	public IFitnessComparator<?, S> getFitnessComparator() {
		return fitnessComparator;
	}
	
	
	@Override
	public NondominatedPopulation getResult() {
		pop.add(getCurrentSolution());
		pop.add(getBestSolution());
		return pop;
	}
	
	@Override
	public S getInitialSolution() {
		return initialSolution;
	}
	
	@Override
	public S getCurrentSolution() {
		return currentSolution;
	}
	
	protected void setCurrentSolution(S solution) {
		solution = (S)solution.copy();
		this.currentSolution = solution;
		this.currentFitness = getValue(solution);
		bestValues.add(solution);
	}
	
	@Override
	public Comparable<?> getCurrentFitness() {
		return currentFitness;
	}
	
	protected void setBestSolution(S bestSolution) {
		bestSolution = (S)bestSolution.copy();
		this.bestSolution = bestSolution;
		this.bestFitness = getValue(bestSolution);
		bestValues.add(bestSolution);
	}
	
	@Override
	public S getBestSolution() {
		return bestSolution;
	}
	
	@Override
	public Comparable<?> getBestFitness() {
		return bestFitness;
	}

	protected boolean update(S solutionCandidate) {
		if(solutionCandidate == null)
			return false;
		boolean isImprovement = false;
		if(isImprovementToCurrent(solutionCandidate)) {
			setCurrentSolution(solutionCandidate);
			isImprovement = true;
		}
		if(isImprovementToBest(solutionCandidate)) {
			setBestSolution(solutionCandidate);
			isImprovement = true;
		}
		return isImprovement;
	}
	
	protected void evaluateAll(Set<S> solutions) {
		for(S solution : solutions)
			evaluate(solution);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialize() {
		super.initialize();
		problem.evaluate(getInitialSolution());		
		setCurrentSolution((S) getInitialSolution().copy());	
		problem.evaluate(getCurrentSolution());
		setBestSolution(getCurrentSolution());
	}
	
	protected boolean isBetter(S solution, S otherSolution) {
		return compare(solution, otherSolution) < 0;
	}
	
	protected Comparable<?> getValue(S solution) {
		return getFitnessComparator().getValue(solution);
	}
	
	protected boolean isImprovementToCurrent(S solution) {
		return isBetter(solution, getCurrentSolution());
	}
	
	protected boolean isImprovementToBest(S solution) {
		return isBetter(solution, getBestSolution());
	}
	
	protected final S getBest(List<S> solutions) {
		if(solutions == null || solutions.isEmpty())
			return null;
		return sortSolutions(solutions).get(0);
	}
	
	@SafeVarargs
	protected final S getBest(S... solutions) {
		if(solutions.length == 0)
			return null;
		return sortSolutions(solutions)[0];	
	}
	
	@SafeVarargs
	protected final S[] sortSolutions(S... solutions) {
		Arrays.sort(solutions, getFitnessComparator());
		return solutions;
	}
	
	protected final List<S> sortSolutions(List<S> solutions) {
		Collections.sort(solutions, getFitnessComparator());
		return solutions;
	}
	
	protected int compare(S solution, S otherSolution) {
		if(getFitnessComparator() == null)
			throw new IllegalArgumentException("Local Search needs FitnessComparator to compare solutions.");
		return getFitnessComparator().compare(solution, otherSolution);
	}
	
	@Override
	public INeighborhoodFunction<S> getNeighborhoodFunction() {
		return neighborhoodFunction;
	}
	
	protected INeighborhood<S> generateCurrentNeighbors() {
		//Not sensible in all cases
		/*if(getCurrentSolution().getNumberOfVariables() >= getProblem().getNumberOfVariables())
			return getNeighborhoodFunction().createEmptyNeighborhood();*/
		return getNeighborhoodFunction().generateNeighbors(getCurrentSolution(),forbidden);
	}
	
	protected INeighborhood<S> generateCurrentNeighbors(int maxNeighbors) {
		//Not sensible in all cases
		/*if(getCurrentSolution().getNumberOfVariables() >= getProblem().getNumberOfVariables())
			return getNeighborhoodFunction().createEmptyNeighborhood();*/
		return getNeighborhoodFunction().generateNeighbors(getCurrentSolution(), maxNeighbors, forbidden);
	}
	
	@Override
	public void terminate() {
		if(!isTerminated()) // terminate without exception
			super.terminate();
	}
	

	public void copyFor(AbstractLocalSearchAlgorithm<S> algorithm, S initialSolution) {
		this.initialSolution = initialSolution;
		this.neighborhoodFunction = algorithm.neighborhoodFunction;
		this.fitnessComparator = algorithm.fitnessComparator;
		this.forbiddenIndices = algorithm.forbiddenIndices;
	}	
	
	public abstract AbstractLocalSearchAlgorithm<S> newInstance(Problem problem);
	
	public AbstractLocalSearchAlgorithm<S> prototypeFor(S s, IFitnessComparatorGenerator<?, S> comparatorGenerator, NondominatedPopulation ndp) {
		AbstractLocalSearchAlgorithm<S> ret = newInstance(getProblem());
		ret.copyFor(this,s);
		if (comparatorGenerator != null) {
			ret.fitnessComparator = comparatorGenerator.generateComparator(getProblem(), s, ndp);
		}
		ret.initialize();
		return ret;
	}
	
	
	
	public AbstractLocalSearchAlgorithm<S> prototypeForF(S s, IFitnessComparator<?, S> comparator) {
		AbstractLocalSearchAlgorithm<S> ret = newInstance(getProblem());
		ret.copyFor(this,s);
		if (comparator != null) {
			ret.fitnessComparator = comparator;
		}
		ret.initialize();
		return ret;
	}
	

	protected NondominatedPopulation pop = new NondominatedPopulation();

	public void reset() {
		pop = new NondominatedPopulation();
	}
}
