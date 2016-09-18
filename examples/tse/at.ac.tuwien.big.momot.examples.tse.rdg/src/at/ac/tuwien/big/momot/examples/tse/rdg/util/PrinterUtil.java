package at.ac.tuwien.big.momot.examples.tse.rdg.util;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGTransformationMetrics;

public class PrinterUtil {
	
	public static void printApproximationSet(NondominatedPopulation result) {
		System.out.println("Modules" + "\t" + "MinMaxDiff" + "\t" + "CohesionRatio" + "\t" + "CouplingRatio");
		System.out.println("--------------------------");
		for(Solution s : result) {
			RDGTransformationMetrics metrics = ModularizationUtil.getMetrics(s);				
			System.out.println(
				metrics.getNrModules() + "\t" + 
				metrics.getMinMaxReponsibilityDifference() + "\t" + 
				metrics.getCohesionRatio() + "\t" +
				metrics.getCouplingRatio());
		}
	}
}
