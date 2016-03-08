package at.ac.tuwien.big.momot.examples.ecore;

import java.io.File;
import java.io.IOException;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Population;
import org.moeaframework.core.PopulationIO;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer;
import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer.FitnessComparison;
import at.ac.tuwien.big.momot.TransformationResultManager;

public class FindKneePoint {
	private static final int NEIGHBORHOOD_SIZE = 150;
	private static final FitnessComparison FITNESS_COMPARISON = FitnessComparison.PROPER_UTILITY;
	
	public static void kneepoint(NondominatedPopulation population) {
		PopulationAnalyzer populationAnalyzer = new PopulationAnalyzer(population);
		NondominatedPopulation kneePointSolutions = populationAnalyzer.getKneePointSolutions(population, 
				NEIGHBORHOOD_SIZE, FITNESS_COMPARISON);
		
		System.out.println("KneePoints: " + kneePointSolutions.size());
		System.out.println("===============");
		
		System.out.println("KneePoint Objectives");
		System.out.println("--------------------");
		System.out.println(TransformationResultManager.printObjectives(kneePointSolutions));;
		
		System.out.println("KneePoint Attributes");
		System.out.println("--------------------");
		System.out.println(TransformationResultManager.printAttributes(kneePointSolutions));
		
		System.out.println("Best Solution");
		System.out.println("=============");
		Solution bestSolution = populationAnalyzer.getBestSolution(population, FITNESS_COMPARISON);
		NondominatedPopulation bestPopulation = new NondominatedPopulation();
		bestPopulation.add(bestSolution);
		System.out.println(TransformationResultManager.printObjectives(bestPopulation));
		System.out.println(TransformationResultManager.printAttributes(bestPopulation));
	}
	
	public static void kneepoint(String file) throws IOException {
		Population population = PopulationIO.readObjectives(new File(file));
		NondominatedPopulation nonDominatedPopulation = new NondominatedPopulation(population);
		
		System.out.println("Solution: " + population.size());
		System.out.println("===============");
		System.out.println(TransformationResultManager.printObjectives(population));
		
		kneepoint(nonDominatedPopulation);
	}
	
	public static void main(String[] args) throws IOException {
		kneepoint("output/PrimitiveTypes/nsgaii/approximation_nsgaii.pf");
	}
}
