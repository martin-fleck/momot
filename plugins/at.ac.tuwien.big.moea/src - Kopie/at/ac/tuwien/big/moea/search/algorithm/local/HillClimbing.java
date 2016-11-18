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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.MaximumDecreasingFitnessEstimator;



public class HillClimbing<S extends Solution> extends AbstractLocalSearchAlgorithm<S> {

	private int noImprovement = 0;
	private int maxNoImprovements = 100;
	
	private boolean nextImprovement;
	
	protected HillClimbing(Problem problem) {
		super(problem);
	}
	

	public HillClimbing(Problem problem, S initialSolution,
			INeighborhoodFunction<S> neighborhoodFunction,
			IFitnessComparator<?, S> fitnessComparator, int maxNoImprovements) {
		this(problem,initialSolution,neighborhoodFunction,fitnessComparator,false, maxNoImprovements);
	}
	
	public HillClimbing(Problem problem, S initialSolution,
			INeighborhoodFunction<S> neighborhoodFunction,
			IFitnessComparator<?, S> fitnessComparator, boolean nextImprovement, int maxNoImprovements) {
		super(problem, initialSolution, neighborhoodFunction, fitnessComparator);
		this.nextImprovement = nextImprovement;
		this.maxNoImprovements = maxNoImprovements;
		if(neighborhoodFunction.getMaxNeighbors() == INeighborhoodFunction.UNLIMITED)
			System.err.println("Warning: Neighborhood-Function may produce infinite neighbors, Hill-Climbing may get stuck in infinite loop.");
	}
	
	private int curStep = 0;

	
	
	@Override
	protected void iterate() {
		++curStep;
		Object oldFitness = currentFitness;
		List<S> neighbors = new ArrayList<>();	
		long curTime = new Date().getTime();
		List<S> consideredNeighbors = new ArrayList<S>();
		S cur2 = getCurrentSolution();
		evaluate(cur2);
		for(S neighbor : generateCurrentNeighbors()) {
			if (neighbor == null){
				continue;
			}
			evaluate(neighbor);
			neighbors.add(neighbor);
			if (isBetter(neighbor, getCurrentSolution())) {
				if (nextImprovement) {
					update(neighbor);
					return;
				} else {
					consideredNeighbors.add(neighbor);
				}
			}
		}
		evaluate(cur2);
		if(neighbors.isEmpty()) {
			terminate();
			return;
		}
		if (!consideredNeighbors.isEmpty()) {
			//Select the one dominathing the most
			
			S cur = getCurrentSolution();
			
			IDeltaEstimator est;
			boolean firstUseComp;
			if (getFitnessComparator() instanceof IDeltaEstimator) {
				est = (IDeltaEstimator) getFitnessComparator();
				firstUseComp = false;
			} else {
				est = new MaximumDecreasingFitnessEstimator();
				firstUseComp = true;
			}
					 
			
			
			double bestSolVal = 0.0;
			S bestSol = null;
			
			S curBest = getBestSolution();
			for (S consider: consideredNeighbors) {
				if (bestSol == null) {
					bestSol = consider;
					bestSolVal = est.getWorseAmount(consider, curBest);
				} else {
					int compare = 0;
					if (firstUseComp) {
						compare = getFitnessComparator().compare(consider,bestSol);
					}
					if (compare == 0) {
						double curWorseAmount = est.getWorseAmount(consider, curBest); 
						if (curWorseAmount > bestSolVal) {
							bestSol = consider;
							bestSolVal = curWorseAmount;
						}
					} else if (compare == -1) {
						bestSol = consider;
						bestSolVal = est.getWorseAmount(consider, curBest);
					}
				}
			}
			
			
			if(bestSol == null || !update(bestSol)) {
				if (++noImprovement > maxNoImprovements) {
					terminate();
				}
			} else {
				noImprovement = 0;
			}
		} else {
			if (++noImprovement > maxNoImprovements) {
				terminate();
			}
		}
		
//		else
//			System.err.println("improvmeent");
		//System.out.println("Single Hill-Climing iteration took " + (new Date().getTime()-curTime)+" ms, "+bestFitness+ " VS "+oldFitness);
	}

	@Override
	public HillClimbing<S> newInstance(Problem problem) {
		return new HillClimbing<S>(problem);
	}	
	
	@Override
	public void copyFor(AbstractLocalSearchAlgorithm<S> other, S initial) {
		super.copyFor(other, initial);
		this.nextImprovement = ((HillClimbing)other).nextImprovement;
		this.maxNoImprovements = ((HillClimbing)other).maxNoImprovements;
	}
	
	public int getStepNum() {
		return curStep;
	}
}
