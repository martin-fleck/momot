package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.algorithm.operator.mutation.AbstractMutationVariation;

public class EmptyFlip extends AbstractMutationVariation {

	public EmptyFlip(double probability) {
		super(probability);
	}
	
	@Override
	protected Solution[] doEvolve(Solution[] parents) {
		return new Solution[] { mutate(((Solution)parents[0]).copy()) };
	}

	private Solution mutate(Solution copy) {
		return copy;
	}
}
