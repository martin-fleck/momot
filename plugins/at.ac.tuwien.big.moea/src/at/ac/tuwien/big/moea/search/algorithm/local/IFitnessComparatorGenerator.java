package at.ac.tuwien.big.moea.search.algorithm.local;

import java.io.Serializable;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

public interface IFitnessComparatorGenerator<C extends Comparable<C> & Serializable, S extends Solution> {
	
	public IFitnessComparator<C, S> generateComparator(Problem forProblem, S forInitialSolution, NondominatedPopulation curParetoFront);

}
