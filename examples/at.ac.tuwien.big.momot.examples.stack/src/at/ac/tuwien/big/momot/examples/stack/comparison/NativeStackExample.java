package at.ac.tuwien.big.momot.examples.stack.comparison;

import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.experiment.instrumenter.SearchInstrumenter;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.moeaframework.Analyzer;
import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.BinaryVariable;

public class NativeStackExample {

   public static Executor createExecutor(final Integer[] initialLoads, final int populationSize,
         final int maxEvaluations, final String algorithm) {
      final Instrumenter instrumenter = new SearchInstrumenter()
            .withProblemClass(NativeStackProblem.class, Arrays.asList(initialLoads))
            // .attachAll()
            .withFrequency(populationSize).withReferenceSet(new File("output/evolutionary_reference_set.csv"));

      final Executor executor = new Executor().withSameProblemAs(instrumenter).withAlgorithm("NSGAII")
            .withProperty("populationSize", populationSize).withProperty("maxEvaluations", maxEvaluations)
            .distributeOnAllCores()
            // .withProgressListener(new RuntimePrintListener())
            .withProgressListener(new SeedRuntimePrintListener()).withInstrumenter(instrumenter);

      return executor;
   }

   public static Analyzer doAnalysis(final String name, final Integer[] initialLoads, final Executor executor,
         final int runs) {
      final Analyzer analyzer = new Analyzer().withSameProblemAs(executor).withReferenceSet(null);

      final List<NondominatedPopulation> result = executor.runSeeds(runs);
      analyzer.addAll("NSGAII", result);
      final NondominatedPopulation referenceSet = analyzer.getReferenceSet();
      printPopulation(referenceSet, initialLoads);
      analyzer.printAnalysis();
      return analyzer;
   }

   public static void main(final String[] args) {

      final Integer[] initialLoads = new Integer[] { 1, 7, 3, 9, 5 };

      final Executor executor = createExecutor(initialLoads, 100, 1000, "NSGAII");
      doAnalysis("NSGAII", initialLoads, executor, 5);
   }

   public static void printPopulation(final NondominatedPopulation population, final Integer[] initialLoads) {
      int solutionNr = 1;
      for(final Solution s : population) {
         System.out.println("Solution " + solutionNr++ + " of " + population.size() + ":");
         for(int i = 0; i < s.getNumberOfVariables(); i++) {
            final BinaryVariable var = (BinaryVariable) s.getVariable(i);
            final String ruleName = var.get(0) ? "shiftRight" : "shiftLeft";
            System.out.println("variable[" + i + "]: " + ruleName + ": " + NativeStackProblem.toString(var) + " = "
                  + NativeStackProblem.toLoad(var));
         }
         System.out.println("--");
         for(int i = 0; i < s.getNumberOfConstraints(); i++) {
            System.out.println("constraint[" + i + "]: " + s.getConstraint(i));
         }
         System.out.println("--");
         for(int i = 0; i < s.getNumberOfObjectives(); i++) {
            System.out.println("objective[" + i + "]: " + s.getObjective(i));
         }
         System.out.println("---");
         System.out.println(Arrays.toString(NativeStackProblem.apply(s, initialLoads)));
         System.out.println();
      }
   }
}
