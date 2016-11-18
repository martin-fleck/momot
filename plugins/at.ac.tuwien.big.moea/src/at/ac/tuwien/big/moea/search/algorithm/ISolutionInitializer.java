package at.ac.tuwien.big.moea.search.algorithm;

import java.util.Collection;
import java.util.Collections;

import org.moeaframework.core.Solution;

public interface ISolutionInitializer<S extends Solution> {
	
	public S getSolution(S baseSolution);
	
	public int getEvaluationCount();
	
	public void setMaxEvaluationCount(int count);

	public default Iterable<? extends Solution> getParetoFront() {
		return Collections.emptyList();
	}

}
