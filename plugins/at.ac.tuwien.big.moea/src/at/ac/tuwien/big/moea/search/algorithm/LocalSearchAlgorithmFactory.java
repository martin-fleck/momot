package at.ac.tuwien.big.moea.search.algorithm;

import at.ac.tuwien.big.moea.ISearchOrchestration;
import at.ac.tuwien.big.moea.search.algorithm.local.HillClimbing;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;
import at.ac.tuwien.big.moea.search.algorithm.local.RandomDescent;
import at.ac.tuwien.big.moea.search.algorithm.provider.AbstractRegisteredAlgorithm;

import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

public class LocalSearchAlgorithmFactory<S extends Solution> extends AbstractAlgorithmFactory<S> {
   protected S initialSolution;

   public LocalSearchAlgorithmFactory() {}

   public LocalSearchAlgorithmFactory(final ISearchOrchestration<S> searchOrchestration) {
      setSearchOrchestration(searchOrchestration);
   }

   public AbstractRegisteredAlgorithm<HillClimbing<S>> createHillClimbing(
         final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> comparator) {
      return new AbstractRegisteredAlgorithm<HillClimbing<S>>() {
         @Override
         public HillClimbing<S> createAlgorithm(Problem problem) {
            if(problem == null) {
               problem = createProblem();
            }

            return new HillClimbing<>(problem, getInitialSolution(), neighborhoodFunction, comparator);
         }
      };
   }

   public AbstractRegisteredAlgorithm<RandomDescent<S>> createRandomDescent(
         final INeighborhoodFunction<S> neighborhoodFunction, final IFitnessComparator<?, S> comparator) {
      return new AbstractRegisteredAlgorithm<RandomDescent<S>>() {
         @Override
         public RandomDescent<S> createAlgorithm(Problem problem) {
            if(problem == null) {
               problem = createProblem();
            }

            return new RandomDescent<>(problem, getInitialSolution(), neighborhoodFunction, comparator);
         }
      };
   }

   public S getInitialSolution() {
      if(initialSolution == null) {
         return getSearchOrchestration().createNewSolution(0);
      }
      return initialSolution;
   }

   public void setInitialSolution(final S initialSolution) {
      this.initialSolution = initialSolution;
   }
}
