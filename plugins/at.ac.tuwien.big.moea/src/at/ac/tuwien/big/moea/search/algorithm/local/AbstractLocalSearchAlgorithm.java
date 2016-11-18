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
import java.util.List;
import java.util.Set;

import org.moeaframework.algorithm.AbstractAlgorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

public abstract class AbstractLocalSearchAlgorithm<S extends Solution> extends AbstractAlgorithm
      implements LocalSearchAlgorithm<S> {

   protected S initialSolution;

   protected S currentSolution;
   protected Comparable<?> currentFitness;

   protected S bestSolution;
   protected Comparable<?> bestFitness;

   protected INeighborhoodFunction<S> neighborhoodFunction;
   protected IFitnessComparator<?, S> fitnessComparator;

   public AbstractLocalSearchAlgorithm(final Problem problem, final S initialSolution,
         final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> fitnessComparator) {
      super(problem);
      this.initialSolution = initialSolution;
      this.neighborhoodFunction = neighborhoodFunction;
      this.fitnessComparator = fitnessComparator;
   }

   protected int compare(final S solution, final S otherSolution) {
      if(getFitnessComparator() == null) {
         throw new IllegalArgumentException("Local Search needs FitnessComparator to compare solutions.");
      }
      return getFitnessComparator().compare(solution, otherSolution);
   }

   protected NondominatedPopulation createPopulation(final S solution) {
      final NondominatedPopulation population = new NondominatedPopulation();
      population.add(solution);
      return population;
   }

   protected void evaluateAll(final Set<S> solutions) {
      for(final S solution : solutions) {
         evaluate(solution);
      }
   }

   protected INeighborhood<S> generateCurrentNeighbors() {
      if(getCurrentSolution().getNumberOfVariables() >= getProblem().getNumberOfVariables()) {
         return getNeighborhoodFunction().createEmptyNeighborhood();
      }
      return getNeighborhoodFunction().generateNeighbors(getCurrentSolution());
   }

   protected INeighborhood<S> generateCurrentNeighbors(final int maxNeighbors) {
      if(getCurrentSolution().getNumberOfVariables() >= getProblem().getNumberOfVariables()) {
         return getNeighborhoodFunction().createEmptyNeighborhood();
      }
      return getNeighborhoodFunction().generateNeighbors(getCurrentSolution(), maxNeighbors);
   }

   protected final S getBest(final List<S> solutions) {
      if(solutions == null || solutions.isEmpty()) {
         return null;
      }
      return sortSolutions(solutions).get(0);
   }

   @SafeVarargs
   protected final S getBest(final S... solutions) {
      if(solutions.length == 0) {
         return null;
      }
      return sortSolutions(solutions)[0];
   }

   @Override
   public Comparable<?> getBestFitness() {
      return bestFitness;
   }

   @Override
   public S getBestSolution() {
      return bestSolution;
   }

   @Override
   public Comparable<?> getCurrentFitness() {
      return currentFitness;
   }

   @Override
   public S getCurrentSolution() {
      return currentSolution;
   }

   @Override
   public IFitnessComparator<?, S> getFitnessComparator() {
      return fitnessComparator;
   }

   @Override
   public S getInitialSolution() {
      return initialSolution;
   }

   @Override
   public INeighborhoodFunction<S> getNeighborhoodFunction() {
      return neighborhoodFunction;
   }

   @Override
   public NondominatedPopulation getResult() {
      return createPopulation(getBestSolution());
   }

   protected Comparable<?> getValue(final S solution) {
      return getFitnessComparator().getValue(solution);
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

   protected boolean isBetter(final S solution, final S otherSolution) {
      return compare(solution, otherSolution) < 0;
   }

   protected boolean isImprovementToBest(final S solution) {
      return isBetter(solution, getBestSolution());
   }

   protected boolean isImprovementToCurrent(final S solution) {
      return isBetter(solution, getCurrentSolution());
   }

   protected void setBestSolution(final S bestSolution) {
      this.bestSolution = bestSolution;
      this.bestFitness = getValue(bestSolution);
   }

   protected void setCurrentSolution(final S solution) {
      this.currentSolution = solution;
      this.currentFitness = getValue(solution);
   }

   protected final List<S> sortSolutions(final List<S> solutions) {
      Collections.sort(solutions, getFitnessComparator());
      return solutions;
   }

   @SafeVarargs
   protected final S[] sortSolutions(final S... solutions) {
      Arrays.sort(solutions, getFitnessComparator());
      return solutions;
   }

   @Override
   public void terminate() {
      if(!isTerminated()) {
         super.terminate();
      }
   }

   protected boolean update(final S solutionCandidate) {
      if(solutionCandidate == null) {
         return false;
      }
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
}
