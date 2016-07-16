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
package at.ac.tuwien.big.moea.search.algorithm.operator.mutation;

import java.util.List;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.algorithm.operator.IProbabilityVariation;
import at.ac.tuwien.big.moea.util.CollectionUtil;

public class CompoundMutationVariation extends AbstractMutationVariation {
	
	private List<IProbabilityVariation> operators;

	public CompoundMutationVariation(double probability) {
		this(probability, new IProbabilityVariation[] { });
	}
	
	public CompoundMutationVariation(double probability, IProbabilityVariation... operators) {
		super(probability);
		this.operators = CollectionUtil.newList(operators);
	}
	
	public CompoundMutationVariation addOperator(IProbabilityVariation operator) {
		this.operators.add(operator);
		return this;
	}

	public List<IProbabilityVariation> getOperators() {
		return operators;
	}
	
	@Override
	public Solution[] doEvolve(Solution[] parents) {
		Solution[] evolved = parents;
		for(IProbabilityVariation op : getOperators())
			evolved = op.evolve(evolved);
		return evolved;
	}

}
