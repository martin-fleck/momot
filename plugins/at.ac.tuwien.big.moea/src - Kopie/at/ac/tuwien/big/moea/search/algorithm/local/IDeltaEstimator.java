package at.ac.tuwien.big.moea.search.algorithm.local;

import java.io.Serializable;

import org.moeaframework.core.Solution;

public interface IDeltaEstimator<C extends Comparable<C> & Serializable, S extends Solution> extends IFitnessComparator<C, S>{
	
	/**The amount the worse is worse than the better*/
	public double getWorseAmount(S better, S worse);

}
