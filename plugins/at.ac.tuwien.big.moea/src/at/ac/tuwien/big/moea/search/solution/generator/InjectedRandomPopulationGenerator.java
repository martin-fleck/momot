package at.ac.tuwien.big.moea.search.solution.generator;

import at.ac.tuwien.big.moea.search.solution.generator.solution.IRandomSolutionGenerator;

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.core.Solution;

public class InjectedRandomPopulationGenerator<S extends Solution> extends RandomPopulationGenerator<S>
      implements IInjectedPopulationGenerator<S> {
   private List<S> injectedSolutions = new ArrayList<>();

   public InjectedRandomPopulationGenerator(final int populationSize,
         final IRandomSolutionGenerator<S> solutionGenerator) {
      super(populationSize, solutionGenerator);
   }

   public InjectedRandomPopulationGenerator(final int populationSize,
         final IRandomSolutionGenerator<S> solutionGenerator, final List<S> injectedSolutions) {
      super(populationSize, solutionGenerator);
      this.injectedSolutions = injectedSolutions;
   }

   @Override
   public void addInjectedSolution(final S injectedSolution) {
      injectedSolutions.add(injectedSolution);
   }

   @Override
   public void addInjectedSolutions(final Iterable<S> injectedSolutions) {
      for(final S solution : injectedSolutions) {
         this.injectedSolutions.add(solution);
      }
   }

   @Override
   public List<S> getInjectedSolutions() {
      return injectedSolutions;
   }

   @Override
   public S[] initialize() {
      @SuppressWarnings("unchecked")
      final S[] population = (S[]) new Solution[getPopulationSize()];

      int i = 0;
      while(i < getInjectedSolutions().size() && i < getInjectedSolutions().size() && i < getPopulationSize()) {
         population[i] = getInjectedSolutions().get(i++);
      }

      while(i < getPopulationSize()) {
         population[i++] = getSolutionGenerator().createRandomSolution();
      }

      return population;
   }

   @Override
   public void setInjectedSolutions(final List<S> injectedSolutions) {
      this.injectedSolutions = injectedSolutions;
   }

}
