package at.ac.tuwien.big.moea.search.algorithm;

import org.moeaframework.core.EpsilonBoxDominanceArchive;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.NondominatedSortingPopulation;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.ISearchOrchestration;
import at.ac.tuwien.big.moea.problem.ISearchProblem;

public class AbstractAlgorithmFactory<S extends Solution> {
	protected ISearchOrchestration<S> searchOrchestration;
	protected double[] epsilon;
	
	public ISearchOrchestration<S> getSearchOrchestration() {
		return searchOrchestration;
	}
	
	public void setSearchOrchestration(ISearchOrchestration<S> searchOrchestration) {
		this.searchOrchestration = searchOrchestration;
	}
	
	public double[] getEpsilon() {
		return epsilon;
	}
	
	public void setEpsilon(double... epsilon) {
		this.epsilon = epsilon;
	}
	
	protected ISearchProblem<S> createProblem() {
		return getSearchOrchestration().createProblem();
	}
	
	protected NondominatedSortingPopulation createSortingPopulation() {
		return getSearchOrchestration().createSortingPopulation();
	}
	
	protected NondominatedPopulation createPopulation() {
		return getSearchOrchestration().createPopulation(getEpsilon());
	}
	
	protected EpsilonBoxDominanceArchive createEpsilonBoxArchive() {
		return getSearchOrchestration().createEpsilonBoxArchive(getEpsilon());
	}
	
	protected EpsilonBoxDominanceArchive createEpsilonBoxArchive(double... epsilon) {
		return getSearchOrchestration().createEpsilonBoxArchive(epsilon);
	}
}
