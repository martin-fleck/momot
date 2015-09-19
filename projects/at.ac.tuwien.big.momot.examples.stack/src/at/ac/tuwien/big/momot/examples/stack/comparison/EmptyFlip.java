package at.ac.tuwien.big.momot.examples.stack.comparison;

import java.util.Random;

import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.BinaryVariable;

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
		Variable variable = copy.getVariable(new Random().nextInt(copy.getNumberOfVariables()));
		if(variable instanceof BinaryVariable)
			((BinaryVariable) variable).clear();
		return copy;
	}
}
