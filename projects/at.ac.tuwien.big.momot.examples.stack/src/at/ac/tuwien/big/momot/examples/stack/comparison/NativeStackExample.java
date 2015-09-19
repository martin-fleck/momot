package at.ac.tuwien.big.momot.examples.stack.comparison;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.moeaframework.Analyzer;
import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.BinaryVariable;

import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.experiment.instrumenter.SearchInstrumenter;

public class NativeStackExample {
	
	public static void printPopulation(NondominatedPopulation population, Integer[] initialLoads) {
		int solutionNr = 1;
		for(Solution s : population) {
			System.out.println("Solution " + solutionNr++ + " of " + population.size() + ":");
			for(int i = 0; i < s.getNumberOfVariables(); i++) {
				BinaryVariable var = (BinaryVariable)s.getVariable(i);
				String ruleName = var.get(0) ? "shiftRight" : "shiftLeft";
				System.out.println("variable[" + i + "]: " + ruleName + ": " + NativeStackProblem.toString(var) + " = " + NativeStackProblem.toLoad(var));
			}
			System.out.println("--");
			for(int i = 0; i < s.getNumberOfConstraints(); i++)
				System.out.println("constraint[" + i + "]: " + s.getConstraint(i));
			System.out.println("--");
			for(int i = 0; i < s.getNumberOfObjectives(); i++)
				System.out.println("objective[" + i + "]: " + s.getObjective(i));
			System.out.println("---");
			System.out.println(Arrays.toString(NativeStackProblem.apply(s, initialLoads)));
			System.out.println();
		}		
	}
	
	public static Executor createExecutor(Integer[] initialLoads, int populationSize, int maxEvaluations, String algorithm) {
		Instrumenter instrumenter = new SearchInstrumenter()
			.withProblemClass(NativeStackProblem.class, Arrays.asList(initialLoads))
//			.attachAll()
			.withFrequency(populationSize)
			.withReferenceSet(new File("output/evolutionary_reference_set.csv"));
	
		Executor executor = new Executor()
			.withSameProblemAs(instrumenter)
			.withAlgorithm("NSGAII")
			.withProperty("populationSize", populationSize)
			.withProperty("maxEvaluations", maxEvaluations)
			.distributeOnAllCores()
//			.withProgressListener(new RuntimePrintListener())
			.withProgressListener(new SeedRuntimePrintListener())
			.withInstrumenter(instrumenter);
	
		return executor;
	}
	
	public static Analyzer doAnalysis(String name, Integer[] initialLoads, Executor executor, int runs) {
		Analyzer analyzer = new Analyzer()
			.withSameProblemAs(executor)
			.withReferenceSet(null)
			;
	
		List<NondominatedPopulation> result = executor.runSeeds(runs);
		analyzer.addAll("NSGAII", result);
		NondominatedPopulation referenceSet = analyzer.getReferenceSet();
		printPopulation(referenceSet, initialLoads);
		try {
			analyzer.printAnalysis();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return analyzer;
	}
	
	public static void main(String[] args) {
		
		Integer[] initialLoads = new Integer[] { 1, 7, 3, 9, 5 };
	
		Executor executor = createExecutor(initialLoads, 100, 1000, "NSGAII");		
		doAnalysis("NSGAII", initialLoads, executor, 5);
	}
}
