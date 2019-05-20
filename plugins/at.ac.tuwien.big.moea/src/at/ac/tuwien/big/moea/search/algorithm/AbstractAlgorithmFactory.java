package at.ac.tuwien.big.moea.search.algorithm;

import at.ac.tuwien.big.moea.ISearchOrchestration;
import at.ac.tuwien.big.moea.problem.ISearchProblem;

import org.moeaframework.core.EpsilonBoxDominanceArchive;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.NondominatedSortingPopulation;
import org.moeaframework.core.Solution;

public abstract class AbstractAlgorithmFactory<S extends Solution> {
   protected ISearchOrchestration<S> searchOrchestration;
   protected double[] epsilon;

   protected EpsilonBoxDominanceArchive createEpsilonBoxArchive() {
      return getSearchOrchestration().createEpsilonBoxArchive(getEpsilon());
   }

   protected EpsilonBoxDominanceArchive createEpsilonBoxArchive(final double... epsilon) {
      return getSearchOrchestration().createEpsilonBoxArchive(epsilon);
   }

   public NondominatedPopulation createPopulation() {
      return getSearchOrchestration().createPopulation(getEpsilon());
   }

   public ISearchProblem<S> createProblem() {
      return getSearchOrchestration().createProblem();
   }

   protected NondominatedSortingPopulation createSortingPopulation() {
      return getSearchOrchestration().createSortingPopulation();
   }

   public double[] getEpsilon() {
      return epsilon;
   }

   public ISearchOrchestration<S> getSearchOrchestration() {
      return searchOrchestration;
   }

   public void setEpsilon(final double... epsilon) {
      this.epsilon = epsilon;
   }

   public void setSearchOrchestration(final ISearchOrchestration<S> searchOrchestration) {
      this.searchOrchestration = searchOrchestration;
   }
}
