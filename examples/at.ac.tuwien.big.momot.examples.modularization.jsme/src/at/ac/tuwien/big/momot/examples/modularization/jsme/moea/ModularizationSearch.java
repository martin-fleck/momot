package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;

import java.util.List;

import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

public class ModularizationSearch {

   protected static int NR_RUNS = 30;
   protected static int POPULATION_SIZE = 16384;
   protected static int MAX_EVALUATIONS = 32768;

   protected static NondominatedPopulation createApproximationSet(final List<NondominatedPopulation> results) {
      final NondominatedPopulation approximationSet = new NondominatedPopulation();
      for(final NondominatedPopulation set : results) {
         approximationSet.addAll(set);
      }
      return approximationSet;
   }

   public static void main(final String[] args) {
      final Instrumenter instrumenter = new Instrumenter()
            .withProblemClass(ModularizationProblem.class, ModularizationInstances.createMtunis())
            .withFrequency(POPULATION_SIZE);

      // String operators = "hux"; // Half-uniform crossover (HUX) operator. Half of the non-matching bits are swapped
      // between the two parents.
      String operators = "1x"; // One-Point crossover.
      operators += "+bf"; // Bit flip mutation operator. Each bit is flipped (switched from a {@code 0} to a {@code 1},
                          // or vice versa)

      final Executor executor = new Executor().withSameProblemAs(instrumenter).withAlgorithm("NSGAIII")
            .withProperty("populationSize", POPULATION_SIZE).withProperty("maxEvaluations", MAX_EVALUATIONS)
            .withProperty("divisionsOuter", 6).withProperty("divisionsInner", 0).withProperty("operators", operators)
            .withProperty("1x.rate", 1.0).withProperty("bf.rate", 0.1)
            // .distributeOnAllCores()
            .withProgressListener(new SeedRuntimePrintListener()).withInstrumenter(instrumenter);

      final List<NondominatedPopulation> results = executor.runSeeds(NR_RUNS);

      for(final NondominatedPopulation result : results) {
         printPopulation(result);
      }

      final NondominatedPopulation approximationSet = createApproximationSet(results);

      printObjectives(approximationSet);
   }

   protected static void printObjectives(final NondominatedPopulation result) {
      for(final Solution solution : result) {
         System.out.print(Double.toString(solution.getObjective(0)));
         for(int i = 1; i < solution.getNumberOfObjectives(); i++) {
            System.out.print(" " + Double.toString(solution.getObjective(i)));
         }
         System.out.println();
      }
   }

   protected static void printPopulation(final NondominatedPopulation result) {
      System.out.println("Population with " + result.size() + " solutions:");
      int solutionIndex = 1;
      for(final Solution solution : result) {
         final ModularizationResult modularization = (ModularizationResult) solution
               .getAttribute(ModularizationProblem.ATTRIBUTE_MODULARIZATION);
         final ModelMetrics metrics = (ModelMetrics) solution.getAttribute(ModularizationProblem.ATTRIBUTE_METRICS);
         System.out.println("Solution " + solutionIndex++ + "/" + result.size() + ":");
         System.out.println(modularization);
         System.out.println(metrics);
         System.out.println("-----");
      }
      System.out.println("--------------------------");
   }
}
