package at.ac.tuwien.big.momot.examples.tse.rdg.util;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.PopulationIO;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType;
import at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
import at.ac.tuwien.big.momot.examples.tse.rdg.RDG;
import at.ac.tuwien.big.momot.examples.tse.rdg.RDGConverter;
import at.ac.tuwien.big.momot.examples.tse.rdg.RDGProblem;
import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGTransformationMetrics;

public class ModularizationUtil {
	private static NumberFormat formatter;
	
	private static HenshinResourceSet resourceSet = createResourceSet(); 
	
	public static void initStandalone() {
		ModularizationPackage.eINSTANCE.eClass();
		RuleTypePackage.eINSTANCE.eClass();
	}
	
	public static HenshinResourceSet createResourceSet() {
		return new HenshinResourceSet(CaseStudy.BASE_DIR);
	}
	
	public static RDGProblem createproblem(RDG rdg, int maxModules) {
		return new RDGProblem(rdg, maxModules);
	}
	
	public static TransformationType loadTypes(String resourceString) {
		Resource resource = resourceSet.getResource(resourceString);
		EObject root = resource.getContents().get(0);
		if(!(root instanceof TransformationType)) 
			throw new IllegalArgumentException("Resource is not a types resource.");

		TransformationType types = (TransformationType) root;
		return types;
	}
	
	public static Transformation loadTransformation(String resourceString) {
		Resource resource = resourceSet.getResource(resourceString);
		EObject root = resource.getContents().get(0);
		if(!(root instanceof Transformation)) 
			throw new IllegalArgumentException("Resource is not a transformation.");

		Transformation transformation = (Transformation) root;
		return transformation;
	}
	
	public static RDGTransformationMetrics getMetrics(Solution solution) {
		return getMetrics(solution, true);
	}
	
	public static RDGTransformationMetrics getMetrics(RDG rdg) {
		return rdg.calculateMetrics();
	}
	
	public static RDG getRDG(Solution solution) {
		return (RDG) solution.getAttribute(RDGProblem.ATTRIBUTE_RDG);
	}

	public static RDGTransformationMetrics getMetrics(Solution solution, boolean store) {
		RDGTransformationMetrics metrics = (RDGTransformationMetrics) solution.getAttribute(RDGProblem.ATTRIBUTE_RDG_METRICS);
		if(metrics != null)
			return metrics;
		
		RDG rdg = getRDG(solution);
		
		if(rdg != null) {
			metrics = rdg.calculateMetrics();
			if(store)
				solution.setAttribute(RDGProblem.ATTRIBUTE_RDG_METRICS, metrics);
		}
		return metrics;
	}
	
	public static NumberFormat getFormatter() {
		if(formatter == null) {
			formatter = NumberFormat.getInstance(Locale.US);
			formatter.setMaximumFractionDigits(5);
		}
		return formatter;
	}

	public static String replaceLast(String text, String regex, String replacement) {
		return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
	}
	
	public static double calculateEuclideanDistance(double[] pointA, double[] pointB) {
        double sum = 0.0;
        for(int i=0; i < pointA.length; i++) {
           sum = sum + Math.pow((pointA[i] - pointB[i]), 2.0);
        }
        return Math.sqrt(sum);
    }
	
	public static String assertDirectoryExists(String path) {
		File dir = new File(path);
		boolean exists = dir.exists();
		boolean created = false;
		if(!exists)
			created = dir.mkdirs();
		
		if(!exists && !created)
			System.err.println("Output directory '" + dir + "' can not be created.");
		
		return path;
	}
	
	public static String checkDirectory(String outputDirectory) {
		if(!outputDirectory.endsWith("/"))
			outputDirectory += "/";
		return outputDirectory;
	}
	
	public static void saveResult(Transformation original, String outputDir, String baseName, NondominatedPopulation result) {	
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
	
	public static HenshinResourceSet getResourceSet() {
		return resourceSet;
	}
}
