package at.ac.tuwien.big.moea.search.algorithm.local;

import java.io.Serializable;

import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

public interface IDeltaEstimatorGenerator<C extends Comparable<C> & Serializable, S extends Solution> extends IFitnessComparatorGenerator<C, S> {
	
	public IDeltaEstimator<C, S> generateComparator(Problem forProblem, S forInitialSolution);


}
