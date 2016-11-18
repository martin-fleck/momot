package at.ac.tuwien.big.moea.search.algorithm;

import org.moeaframework.core.Solution;

public interface ISolutionInitializerProvider<S extends Solution> {

	public ISolutionInitializer<S> provide();
}
 