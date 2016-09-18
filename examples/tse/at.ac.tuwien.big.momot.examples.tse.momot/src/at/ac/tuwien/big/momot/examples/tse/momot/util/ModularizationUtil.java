package at.ac.tuwien.big.momot.examples.tse.momot.util;

import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.momot.examples.tse.metric.TransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.metric.calc.MetricCalculator;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType;
import at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
import at.ac.tuwien.big.momot.examples.tse.momot.orchestration.ModularizationFitnessFunction;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModularizationUtil {
	private static NumberFormat formatter;
	
	public static void initStandalone() {
		ModularizationPackage.eINSTANCE.eClass();
		RuleTypePackage.eINSTANCE.eClass();
	}
	
	public static TransformationSolution assertTransformationSolution(Solution solution) {
		if(solution instanceof TransformationSolution)
			return (TransformationSolution) solution;
		throw new IllegalArgumentException("Not a transformation solution!");
	}
	
	public static Transformation assertTransformationRoot(EGraph graph) {
		if(graph == null || graph.getRoots() == null || graph.getRoots().isEmpty())
			throw new IllegalArgumentException("Empty graph not allowed.");
		EObject root = MomotUtil.getRoot(graph);
		
		if(!(root instanceof Transformation))
			throw new IllegalArgumentException("Not a Transformation graph. Make sure the package is registered and initialized.");
		
		Transformation tranformation = (Transformation) root;
		if(tranformation.getModules().isEmpty())
			throw new IllegalArgumentException("No modules in transformation.");
		
		return tranformation;
	}
	
	public static TransformationType loadTypes(String resourceString) {
		Resource resource = OrchestrationUtil.FACTORY.getResourceSet().getResource(resourceString);
		EObject root = resource.getContents().get(0);
		if(!(root instanceof TransformationType)) 
			throw new IllegalArgumentException("Resource is not a types resource.");

		TransformationType types = (TransformationType) root;
		return types;
	}
	
	public static EGraph loadGraph(String resourceString) {
		return OrchestrationUtil.FACTORY.loadGraph(resourceString);
	}
	
	public static TransformationMetrics getMetrics(Solution solution) {
		return getMetrics(assertTransformationSolution(solution), true);
	}
	
	public static TransformationMetrics getMetrics(TransformationSolution solution) {
		return getMetrics(solution, true);
	}
	
	public static TransformationMetrics getMetrics(Solution solution, boolean store) {
		return getMetrics(assertTransformationSolution(solution), store);
	}

	public static TransformationMetrics getMetrics(TransformationSolution solution, boolean store) {
		TransformationMetrics metrics = (TransformationMetrics) solution.getAttribute(ModularizationFitnessFunction.ATTRIBUTE_METRICS);
		if(metrics != null)
			return metrics;
		
		if(solution != null) {
			EGraph resultGraph = solution.execute();
			Transformation transformation = assertTransformationRoot(resultGraph);
			metrics = MetricCalculator.calculateMetrics(transformation);
			if(store)
				solution.setAttribute(ModularizationFitnessFunction.ATTRIBUTE_METRICS, metrics);
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
		if(pointA == null || pointB == null)
			return 0.0;
		
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
}
