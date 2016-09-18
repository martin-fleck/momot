package at.ac.tuwien.big.momot.examples.tse.rdg;

import java.io.IOException;
import java.util.Arrays;

import org.moeaframework.core.NondominatedPopulation;

import at.ac.tuwien.big.momot.examples.tse.rdg.util.CaseStudy;
import at.ac.tuwien.big.momot.examples.tse.rdg.util.ModularizationUtil;

public class RDGSearch {
	protected static final int POPULATION_SIZE = 100;
	protected static final int NR_ITERATIONS = 100;
	protected static final int NR_RUNS = 20;
	
	protected static void executeCaseStudy(String model, String referenceDir, String referenceFile, String outputDir) {
		RDGSettings settings = new RDGSettings(
				model
//				,4
				);
		
		RDGExperiment nsgaIIIexperiment = new RDGExperiment(settings, POPULATION_SIZE, NR_ITERATIONS);		
		NondominatedPopulation nsgaIIIresult = nsgaIIIexperiment.runNSGAIII(NR_RUNS);
		
		ResultSaver saver = new ResultSaver(settings);
		saver.savePopulation(nsgaIIIresult, outputDir + "nsgaiii/");
		saver.saveApproximationSetObjectives(nsgaIIIresult, outputDir, "nsgaiii");
		
		System.out.println("\n------------------------------------------------\n");
		
		RDGExperiment rsExperiment = new RDGExperiment(settings, POPULATION_SIZE, NR_ITERATIONS);
		NondominatedPopulation rsResult = rsExperiment.runRandom(NR_RUNS);
				
		saver = new ResultSaver(settings);
		saver.savePopulation(rsResult, outputDir + "random/");
		saver.saveApproximationSetObjectives(rsResult, outputDir, "random");
		
		saver.saveApproximationSetObjectives(Arrays.asList(nsgaIIIresult, rsResult), referenceDir, "rdg");
		
		System.out.println("\n------------------------------------------------\n");
		
		EuclideanDominanceCalculator dominance = new EuclideanDominanceCalculator(nsgaIIIresult, rsResult).calculate();
		System.out.println(dominance.toString("NSGA-III", "RandomSearch"));
	}
	
	public static void main(String[] args) throws IOException {
		ModularizationUtil.initStandalone();
		
//		executeCaseStudy(
//			CaseStudy.OCL2R2ML.MODEL, 
//			CaseStudy.OCL2R2ML.REFERENCE_DIR,
//			CaseStudy.OCL2R2ML.REFERENCE_FILE, 
//			CaseStudy.OCL2R2ML.OUTPUT_DIR);

//		executeCaseStudy(
//			CaseStudy.RDM2R2ML.MODEL, 
//			CaseStudy.RDM2R2ML.REFERENCE_DIR,
//			CaseStudy.RDM2R2ML.REFERENCE_FILE, 
//			CaseStudy.RDM2R2ML.OUTPUT_DIR);		

//		executeCaseStudy(
//			CaseStudy.R2ML2XML.MODEL, 
//			CaseStudy.R2ML2XML.REFERENCE_DIR,
//			CaseStudy.R2ML2XML.REFERENCE_FILE, 
//			CaseStudy.R2ML2XML.OUTPUT_DIR);
		
//		executeCaseStudy(
//				CaseStudy.XML2KML.MODEL, 
//				CaseStudy.XML2KML.REFERENCE_DIR,
//				CaseStudy.XML2KML.REFERENCE_FILE, 
//				CaseStudy.XML2KML.OUTPUT_DIR);
		
		executeCaseStudy(
				CaseStudy.XML2MySQL.MODEL, 
				CaseStudy.XML2MySQL.REFERENCE_DIR,
				CaseStudy.XML2MySQL.REFERENCE_FILE, 
				CaseStudy.XML2MySQL.OUTPUT_DIR);
		
//		executeCaseStudy(
//				CaseStudy.XML2Ant.MODEL, 
//				CaseStudy.XML2Ant.REFERENCE_DIR,
//				CaseStudy.XML2Ant.REFERENCE_FILE, 
//				CaseStudy.XML2Ant.OUTPUT_DIR);
	}
}
