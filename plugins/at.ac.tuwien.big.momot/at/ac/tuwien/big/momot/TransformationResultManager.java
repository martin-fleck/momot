package at.ac.tuwien.big.momot;

import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.SearchResultManager;
import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.moea.util.FileUtil;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class TransformationResultManager extends SearchResultManager {
	protected static final String MODEL_FILE_EXTENSION = "xmi";
	
	public TransformationResultManager() {
		setSolutionWriter(new TransformationSolutionWriter());
	}
	
	public TransformationResultManager(SearchExperiment<TransformationSolution> experiment) {
		super(experiment);
		setSolutionWriter(new TransformationSolutionWriter());
	}
	
	public String getBaseName() {
		if(baseName == null)
			return deriveBaseName(getExperiment());
		return baseName;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SearchExperiment<TransformationSolution> getExperiment() {
		return (SearchExperiment<TransformationSolution>) super.getExperiment();
	}
	
	protected TransformationSearchOrchestration getOrchestration() {
		return CastUtil.assertClass(getExperiment().getSearchOrchestration(), 
				TransformationSearchOrchestration.class);
	}
	
	public List<File> saveModels(Iterable<Solution> population) {
		return saveModels(getBaseDirectory(), getBaseName(), population);
	}
	
	public List<File> saveModels() {
		return saveModels(getBaseDirectory(), getBaseName(), createApproximationSet());
	}
	
	public List<File> saveModels(String... names) {
		return saveModels(getBaseDirectory(), getBaseName(), createApproximationSet(names));
	}
	
	public List<File> saveModels(File directory) {
		return saveModels(FileUtil.createFile(getBaseDirectory(), directory), getBaseName(), createApproximationSet());
	}
	
	public List<File> saveModels(File directory, String... names) {
		return saveModels(FileUtil.createFile(getBaseDirectory(), directory), getBaseName(), createApproximationSet(names));
	}
	
	public File saveModel(Solution solution) {
		return saveModel(FileUtil.createFile(getBaseDirectory(), createModelFile(getBaseName(), solution)), solution);
	}
	
	public static File saveModel(String file, Solution solution) {
		return saveModel(new File(file), solution);
	}
	
	public static File saveModel(File file, Solution solution) {
		TransformationSolution transformationSolution = MomotUtil.assertTransformationSolution(solution);
		EGraph graph = transformationSolution.execute();
		String uri = file.getAbsolutePath();
		MomotUtil.saveGraph(graph, uri);
		return file;
	}
	
	public static List<File> saveModels(String directory, String baseName, Iterable<? extends Solution> population) {
		return saveModels(new File(directory), baseName, population);
	}

	public static List<File> saveModels(File directory, String baseName, Iterable<? extends Solution> population) {
		FileUtil.checkDirectory(directory);
		List<File> files = new ArrayList<>();
		for(Solution solution : population) {
			File file = saveModel(FileUtil.createFile(directory, createModelFile(baseName, solution)), solution);
			files.add(file);
		}
		return files;
	}
	
	public static String printModel(Solution solution) {
		TransformationSolution transformationSolution = MomotUtil.assertTransformationSolution(solution);
		EGraph graph = transformationSolution.execute();
		return MomotUtil.getRoot(graph).toString();
	}		
	
	public static String printModels(Iterable<Solution> population) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream writer = new PrintStream(baos);
		for(Solution s : population) {
			TransformationSolution solution = MomotUtil.assertTransformationSolution(s);
			EGraph graph = solution.execute();
			writer.println(MomotUtil.getRoot(graph));
		}
		if(writer != null)
			writer.close();
		try {
			return baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not print objectives: " + e.getMessage());
			e.printStackTrace();
			return "";
		}
	}
	
	protected static String createModelFileName(String baseName, Solution solution) {
		if(baseName == null)
			baseName = "model";
		return createFileName(baseName, solution, MODEL_FILE_EXTENSION);
	}	
	
	protected static File createModelFile(String baseName, Solution solution) {
		return new File(createModelFileName(baseName, solution));
	}
	
	public static String deriveBaseName(SearchExperiment<TransformationSolution> experiment) {
		TransformationSearchOrchestration orchestration = CastUtil.assertClass(
				experiment.getSearchOrchestration(), 
				TransformationSearchOrchestration.class);
		return getBaseUri(MomotUtil.getRoot(orchestration.getProblemGraph()));
	}
	
	public static String getBaseUri(EObject eObject) {
		if(eObject == null || eObject.eResource() == null || eObject.eResource().getURI() == null)
			return null;
		else
			return eObject.eResource().getURI().trimFileExtension().lastSegment();
	}
}