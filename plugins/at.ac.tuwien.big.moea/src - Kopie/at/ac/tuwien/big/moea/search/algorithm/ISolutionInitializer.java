package at.ac.tuwien.big.moea.search.algorithm;

import org.moeaframework.core.Solution;

public interface ISolutionInitializer<S extends Solution> {
	
	public S getSolution(S baseSolution);
	
	public int getEvaluationCount();
	
	public void setMaxEvaluationCount(int count);

}
