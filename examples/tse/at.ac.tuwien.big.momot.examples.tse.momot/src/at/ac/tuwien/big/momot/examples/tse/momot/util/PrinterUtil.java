package at.ac.tuwien.big.momot.examples.tse.momot.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.tse.metric.TransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.metric.calc.MetricCalculator;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class PrinterUtil {
	public static String printMetrics(EGraph graph) {
		return printMetrics(ModularizationUtil.assertTransformationRoot(graph));
	}
	
	public static String printMetrics(Transformation transformation) {
		return MetricCalculator.calculateMetrics(transformation).toString();
	}
	
	public static void printApproximationSet(NondominatedPopulation result) {
		System.out.println("Modules" + "\t" + "MinMaxDiff" + "\t" + "CohesionRatio" + "\t" + "CouplingRatio");
		System.out.println("--------------------------");
		for(Solution s : result) {
			TransformationMetrics metrics = ModularizationUtil.getMetrics(s);				
			System.out.println(
				metrics.getNrModules() + "\t" + 
				metrics.getMinMaxReponsibilityDifference() + "\t" + 
				metrics.getCohesionRatio() + "\t" +
				metrics.getCouplingRatio());
		}
	}
	
	public static void printReferenceSet(TransformationSearchOrchestration orchestration, File referenceFile) {
		System.out.println("------------------------------------");
		System.out.println("ReferenceSet" + orchestration.getFitnessFunction().getObjectiveNames() + "");
		System.out.println("------------------------------------");
		try {
			System.out.println(new String(Files.readAllBytes(Paths.get(referenceFile.getPath()))));
		} catch (IOException e) {
			System.out.println("Error reading reference file: " + e.getMessage());
		}
	}
	
	public static String printTransformation(EGraph graph) {
		return printTransformation(ModularizationUtil.assertTransformationRoot(graph));
	}

	public static String printTransformation(Transformation transformation) {
		return transformation.toString();
	}
}
