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
package at.ac.tuwien.big.momot.search.algorithm.local.neighborhood;

import java.util.Collection;
import java.util.Iterator;

import org.moeaframework.core.Solution;
import org.moeaframework.core.Variation;

import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhood;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.AbstractNeighborhoodFunction;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class MutationNeighborhoodFunction extends AbstractNeighborhoodFunction<TransformationSolution> {
	
	private Variation mutationOperator;
	
//	public MutationNeighborhoodFunction(Variation mutationOperator) {
//		setMutationOperator(mutationOperator);
//	}
	
	public MutationNeighborhoodFunction(Variation mutationOperator, int maxNeighbors) {
		super(maxNeighbors);
		setMutationOperator(mutationOperator);
	}

	public Variation getMutationOperator() {
		return mutationOperator;
	}
	
	public void setMutationOperator(Variation mutationOperator) {
		if(mutationOperator.getArity() != 1)
			throw new IllegalArgumentException("Mutation operator needs to have an arity of one.");
		this.mutationOperator = mutationOperator;
	}
	
	@Override
	public  INeighborhood<TransformationSolution> generateNeighbors(TransformationSolution solution, final int maxNeighbors, Collection<Integer> forbiddenIndices) {
		return new AbstractMatchSolutionNeighborhood(solution, maxNeighbors) {
			
			@Override
			public Iterator<TransformationSolution> iterator() {
				return new AbstractTransformationSolutionStepper(getBaseSolution(), getMaxNeighbors()) {
					@Override
					protected TransformationSolution getNext() {
						return createMutant(getBaseSolution(), forbiddenIndices);
					}
				};
			}
		};
	}
	
	protected TransformationSolution createMutant(TransformationSolution solution, Collection<Integer> forbiddenIndices) {
		//TODO: Implement me ...
		return (TransformationSolution) getMutationOperator().evolve(new Solution[] { solution.copy() })[0];
	}
}
