package at.ac.tuwien.big.moea.search.solution.generator;

import java.util.List;

import org.moeaframework.core.Solution;

public interface IInjectedPopulationGenerator<T extends Solution> extends IPopulationGenerator<T> {
	List<T> getInjectedSolutions();
	void setInjectedSolutions(List<T> injectedSolutions);
	public void addInjectedSolution(T injectedSolution);
	public void addInjectedSolutions(Iterable<T> injectedSolutions);
}
