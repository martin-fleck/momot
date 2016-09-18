package at.ac.tuwien.big.momot.examples.tse.rdg;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.StopWatch;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.algorithm.RandomSearch;
import org.moeaframework.algorithm.ReferencePointNondominatedSortingPopulation;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.NondominatedSortingPopulation;
import org.moeaframework.core.PopulationIO;
import org.moeaframework.core.Solution;
import org.moeaframework.core.operator.CompoundVariation;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.search.algorithm.operator.mutation.RandomizableMutation;
import at.ac.tuwien.big.moea.search.solution.generator.ExtendedRandomInitialization;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGTransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.rdg.util.ModularizationUtil;

public class RDGExample {	
	
	protected static HenshinResourceSet resourceSet = ModularizationUtil.createResourceSet();
	
	public static NondominatedPopulation runAlgorithm(Algorithm algorithm, RDGProblem problem, int populationSize, int maxIterations) {
		System.out.flush();
		String algorithmName = algorithm instanceof RandomSearch ? "RandomSearch" : "NSGA-III";
		System.err.println("Search[" + algorithmName + "] between 1 and " + problem.getMaxModules() + " modules.");
		System.err.println("PopulationSize: " + populationSize);
		System.err.println("MaxIterations:  " + maxIterations);
		System.err.println("MaxModules:     " + problem.getMaxModules());
		System.err.println();
		System.err.flush();
		
		int iterations = 0;
		NondominatedPopulation result = new NondominatedPopulation();
				
		while (!algorithm.isTerminated() && ++iterations <= maxIterations) 
			algorithm.step();		
		result.addAll(algorithm.getResult());
		if(!algorithm.isTerminated())
			algorithm.terminate();

		return result;		
		
	}

	public static NondominatedPopulation runNSGAIII(RDGProblem problem, int populationSize, int maxIterations, int divisionsInner, int divisionsOuter) {
		return runAlgorithm(new NSGAII(
				problem, 
				new ReferencePointNondominatedSortingPopulation(problem.getNumberOfObjectives(), divisionsOuter, divisionsInner), 
				null,
				new TournamentSelection(2),	
				new CompoundVariation(new OnePointCrossover(1.0), new RandomizableMutation(0.2)), 
				new ExtendedRandomInitialization(problem, populationSize)), problem, populationSize, maxIterations);
	}
	
	public static NondominatedPopulation runNSGAIII(RDGProblem problem, int populationSize, int maxIterations, int nrDivisions) {
		return runNSGAIII(problem, populationSize, maxIterations, 0, nrDivisions);
	}
	
	public static NondominatedPopulation runRandom(RDGProblem problem, int populationSize, int maxIterations) {
		return runAlgorithm(new RandomSearch(
				problem, 
				new ExtendedRandomInitialization(problem, populationSize),
				new NondominatedPopulation()), 
				problem, populationSize, maxIterations);
	}
	
	public static NondominatedPopulation runNSGAII(RDGProblem problem, int populationSize, int maxIterations) {				
		return runAlgorithm(new NSGAII(
				problem, 
				new NondominatedSortingPopulation(), 
				null,
				new TournamentSelection(2),	
				new CompoundVariation(new OnePointCrossover(1.0), new RandomizableMutation(0.2)), 
				new ExtendedRandomInitialization(problem, populationSize)), problem, populationSize, maxIterations);
	}
	
	protected static void printResult(NondominatedPopulation result) {
		int solutionNr = 1;
		for(Solution solution : result) {
			RDG solutionRDG = (RDG) solution.getAttribute(RDGProblem.ATTRIBUTE_RDG);			
			System.out.print("Solution " + solutionNr++ + " of " + result.size() + ": ");
			System.out.println(solutionRDG);
			System.out.println("--------------");
			System.out.println("Modules:   " + solutionRDG.getNrModules());
			System.out.println("CRA-Index: " + solutionRDG.calculateCRAIndex());
//			System.out.println(solutionRDG.calculateMetrics().toString(false));
		}		
	}
	
	protected static void printResultObjectives(NondominatedPopulation result) {
//		double[] optimalPoint = new double[] { 1.0, 0.0, getMaxCohesion(result), 0.0 };
		
		System.out.println("Modules" + "\t" + "MinMaxDiff" + "\t" + "CohesionRatio" + "\t" + "CouplingRatio" + "\t" + "MetamodelFootprint");
		System.out.println("--------------------------");
		for(Solution s : result) {
			RDGTransformationMetrics solutionRDG = (RDGTransformationMetrics) s.getAttribute(RDGProblem.ATTRIBUTE_RDG_METRICS);
//			double[] solutionPoint = new double[] {
//					solutionRDG.getNrModules(),
//					solutionRDG.getMinMaxReponsibilityDifference(),
//					solutionRDG.getCohesionRatio(),
//					solutionRDG.getCouplingRatio()
//				};
//			double distance = calculateEuclideanDistance(optimalPoint, solutionPoint);
			System.out.println(
					solutionRDG.getNrModules() + "\t" + 
					solutionRDG.getMinMaxReponsibilityDifference() + "\t" + 
					solutionRDG.getCohesionRatio() + "\t" +
					solutionRDG.getCouplingRatio()
//					getFormatter().format(distance)
					);
		}
	}
	
	private static NumberFormat formatter;
	
	public static NumberFormat getFormatter() {
		if(formatter == null) {
			formatter = NumberFormat.getInstance(Locale.US);
			formatter.setMaximumFractionDigits(5);
		}
		return formatter;
	}
	
	protected static void saveResult(Transformation original, NondominatedPopulation result) {	
		for(Solution solution : result) {
			RDG solutionRDG = (RDG) solution.getAttribute(RDGProblem.ATTRIBUTE_RDG);		
			RDGTransformationMetrics metrics = solutionRDG.calculateMetrics();
			
			String model = original.eResource().getURI().toString().replaceFirst(".xmi", "_" + 
					metrics.getNrModules() + "_" + 
					metrics.getMinMaxReponsibilityDifference() + "_" + 
					getFormatter().format(metrics.getCohesionRatio()) + "_" + 
					getFormatter().format(metrics.getCouplingRatio()) + ".xmi");
			resourceSet.saveEObject(
					RDGConverter.assignModules(original, solutionRDG, true), model);
		}
	}
	
	protected static void saveResult(Transformation original, String outputDir, String baseName, NondominatedPopulation result) {	
		for(Solution solution : result) {
			RDG solutionRDG = (RDG) solution.getAttribute(RDGProblem.ATTRIBUTE_RDG);		
			RDGTransformationMetrics metrics = solutionRDG.calculateMetrics();
			
			String model = outputDir + baseName + "_" + 
					metrics.getNrModules() + "_" + 
					metrics.getMinMaxReponsibilityDifference() + "_" + 
					getFormatter().format(metrics.getCohesionRatio()) + "_" + 
					getFormatter().format(metrics.getCouplingRatio()) + ".xmi";
			resourceSet.saveEObject(
					RDGConverter.assignModules(original, solutionRDG, true), model);
		}
	}
	
	protected static void saveResultObjectives(Transformation original, NondominatedPopulation result) {
		try {
			File file = new File(
					resourceSet.getBaseDir().toFileString() + 
					original.eResource().getURI().trimFileExtension().toFileString() + ".csv");
			FileUtils.touch(file);
			PopulationIO.writeObjectives(file, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static RDGProblem createProblem(RDG rdg, int maxModules) {
		return new RDGProblem(rdg, maxModules);
	}
	
	protected static double getMaxCohesion(NondominatedPopulation result) {
		double cohesionRatio = 0.0;
		for(Solution s : result) {
			RDGTransformationMetrics solutionRDG = (RDGTransformationMetrics) s.getAttribute(RDGProblem.ATTRIBUTE_RDG_METRICS);			
			if(solutionRDG.getCohesionRatio() > cohesionRatio)
				cohesionRatio = solutionRDG.getCohesionRatio();
		}
		return cohesionRatio;
	}
	
	public static double calculateEuclideanDistance(double[] pointA, double[] pointB) {
        double sum = 0.0;
        for(int i=0; i < pointA.length; i++) {
           sum = sum + Math.pow((pointA[i] - pointB[i]), 2.0);
        }
        return Math.sqrt(sum);
    }
	
	public static void main(String[] args) throws IOException {
		String file = null;
//		file = "R2ML2RDM/R2ML2RDM_Dependencies.xmi";
//		file = "XML2KML/XML2KML_Dependencies.xmi";
//		file = "OCL2R2ML/OCL2R2ML_Dependencies.xmi";
//		file = "XML2Ant/XML2Ant_Dependencies.xmi";
//		file = "XML2MySQL/XML2MySQL_Dependencies.xmi";
//		file = "OCL2R2ML_Manual_Modularization.xmi";
		file = "OCL2R2ML/transformations/OCL2R2ML/OCL2R2ML_Modularization.xmi";
		
		Transformation transformation = ModularizationUtil.loadTransformation(file);
		RDG rdg = RDGConverter.toRDG(transformation);
		
		System.out.println(rdg.calculateMetrics());
		
		int runs = 20;
		for(int alg = 0; alg < 2; alg++) {
			StopWatch allRuns = new StopWatch();
			allRuns.start();
			int[] sizes = new int[20];
			for(int i = 0; i < runs; i++) {
				RDGProblem problem = createProblem(rdg, 10);
				StopWatch watch = new StopWatch();
				watch.start();
				
				NondominatedPopulation result = alg == 0 ? runRandom(problem, 50, 100) : runNSGAIII(problem, 50, 10, 4);
				
				watch.stop();
				sizes[i] = result.size();
				
//				printResult(result);
				printResultObjectives(result);
				saveResult(transformation, "OCL2R2ML/output/rdg/", transformation.getName(), result);
//				saveResultObjectives(transformation, result);
				
				System.err.println("Search[" + i + "] finished after " + watch.toString() + ": " + result.size() + " solutions found.");
				System.err.flush();
				
				System.out.println("");
			}
			System.err.println("Search finished after " + allRuns.toString() + ".");
			System.err.flush();
			
			System.out.println("");
			
			for(int size : sizes)
				System.out.println(size);
		}
		System.out.println("=========================================");
		System.out.println("=========================================");
	}
}
