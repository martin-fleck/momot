package at.ac.tuwien.big.moea.search.solution.generator;

import at.ac.tuwien.big.moea.search.solution.generator.solution.IRandomSolutionGenerator;

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.core.Solution;

public class InjectedRandomPopulationGenerator<S extends Solution> extends RandomPopulationGenerator<S>
      implements IInjectedPopulationGenerator<S> {
   private List<S> injectedSolutions = new ArrayList<>();
   private boolean generateEmpty;

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

      /*
       * final List<IRandomSolutionGenerator<S>> generators = new ArrayList<>();
       * for(int j = 0; j < Runtime.getRuntime().availableProcessors(); ++j) {
       * generators.add(getSolutionGenerator().clone());
       * }
       * final int[] futureSize = new int[] { i };
       * final List<Thread> threads = new ArrayList<>();
       * for(final IRandomSolutionGenerator<S> gen : generators) {
       * threads.add(new Thread(() -> {
       * final IRandomSolutionGenerator<S> fgen = gen;
       * for(;;) {
       * int myVal;
       * synchronized(futureSize) {
       * if(futureSize[0] >= getPopulationSize()) {
       * return;
       * }
       * myVal = futureSize[0];
       * ++futureSize[0];
       * }
       * population[myVal] = gen.createRandomSolution();
       * }
       * }));
       * }
       * for(final Thread t : threads) {
       * t.start();
       * }
       * for(final Thread t : threads) {
       * try {
       * t.join();
       * } catch(final InterruptedException e) {
       * // TODO Auto-generated catch block
       * e.printStackTrace();
       * }
       * }
       */
      while(i < getPopulationSize()) {
         if(generateEmpty) {
            population[i] = getSolutionGenerator().createRandomSolution(1);
         } else {
            population[i] = getSolutionGenerator().createRandomSolution();
         }
         ++i;
      }

      return population;
   }

   public void setGenerateEmptySolutions(final boolean generateEmpty) {
      this.generateEmpty = generateEmpty;
   }

   @Override
   public void setInjectedSolutions(final List<S> injectedSolutions) {
      this.injectedSolutions = injectedSolutions;
   }

}
