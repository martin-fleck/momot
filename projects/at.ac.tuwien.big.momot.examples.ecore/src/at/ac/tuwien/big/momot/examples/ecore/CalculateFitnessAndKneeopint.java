package at.ac.tuwien.big.momot.examples.ecore;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.examples.ecore.fitness.ModularizationFitnessFunction;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.LanguageMetrics;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.MetricsCalculator;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class CalculateFitnessAndKneeopint {
	protected static ModularizationFitnessFunction function = new ModularizationFitnessFunction();
	
	public static Language getLanguage(Resource resource) {
		EObject root = resource.getAllContents().next();
		return (Language) root;
	}
	
	public static TransformationSolution createSolution(Language language) {
		LanguageMetrics metrics = MetricsCalculator.calculate(language);
		
		TransformationSolution solution = new TransformationSolution(null, 0, function.getObjectives().size());
		solution.setAttribute(ModularizationFitnessFunction.ATTRIBUTE_METRICS, metrics);
		function.evaluate(solution);
		
		return solution;
	}
	
	public static void recalculate(String inputDir, String outputDir) throws IOException {
		ModularizationPackage.eINSTANCE.eClass();
		
		TransformationResultManager resultManager = new TransformationResultManager();
		resultManager.setBaseDirectory(outputDir);
		
		Path inputPath = new File(inputDir).toPath();
		ResourceSet set = new HenshinResourceSet();
		
		List<Solution> solutions = new ArrayList<>();
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(inputPath)) {
			for(Path filePath : stream) {
				if(!filePath.toString().endsWith(".xmi"))
					continue;
				Resource resource = set.getResource(URI.createURI(filePath.toFile().getPath()), true);
				Language language = getLanguage(resource);
				resultManager.setBaseName(language.getName());				
				TransformationSolution solution = createSolution(language);
				solutions.add(solution);
				resultManager.saveModel(solution);
			}
		}
		System.out.println(function.getObjectiveNames());
		System.out.println(TransformationResultManager.printObjectives(solutions));
		TransformationResultManager.saveObjectives(
				new File(outputDir + "objectives.pf"), 
				solutions);
		
		FindKneePoint.kneepoint(new NondominatedPopulation(solutions));
	}
	
	public static void main(String[] args) throws IOException {
		recalculate("output/ocl/", "output/ocl_corrected/");
	}
}
