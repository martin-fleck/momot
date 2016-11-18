package at.ac.tuwien.big.moea.singleobjectivizer;

import org.moeaframework.core.Solution;

public interface SingleObjectivizer {
	
	public default double calculateSingleObjective(Solution sol) {
		return calculateSingleObjective(sol.getObjectives());
	}
	
	public double calculateSingleObjective(double[] vals);

}
