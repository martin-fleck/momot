package at.ac.tuwien.big.moea;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.moeaframework.core.EpsilonBoxDominanceArchive;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Population;
import org.moeaframework.core.PopulationIO;
import org.moeaframework.core.Solution;
import org.moeaframework.core.comparator.ParetoDominanceComparator;

import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.moea.print.IPopulationWriter;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.print.SolutionWriter;
import at.ac.tuwien.big.moea.util.FileUtil;


public class SearchResultManager {

	protected static final String SOLUTION_FILE_EXTENSION = "txt";
	protected static final String OBJECTIVE_FILE_EXTENSION = "pf";
	
	protected SearchExperiment<?> experiment;
	protected double[] epsilon;
	protected String baseName;
	protected File baseDirectory;
	
	protected ISolutionWriter<? extends Solution> solutionWriter;
	protected IPopulationWriter<? extends Solution> populationWriter;
	
	public SearchResultManager() { }
	
	public SearchResultManager(SearchExperiment<?> experiment) {
		this.experiment = experiment;
	}
	
	public SearchExperiment<?> getExperiment() {
		return experiment;
	}
	
	public void setExperiment(SearchExperiment<?> experiment) {
		this.experiment = experiment;
	}
	
	public double[] getEpsilon() {
		return epsilon;
	}
	
	public void setEpsilon(double... epsilon) {
		this.epsilon = epsilon;
	}
	
	public String getBaseName() {
		return baseName;
	}
	
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	
	public File getBaseDirectory() {
		return baseDirectory;
	}
	
	public void setBaseDirectory(File baseDirectory) {
		FileUtil.checkDirectory(baseDirectory);
		this.baseDirectory = baseDirectory;
	}
	
	public void setBaseDirectory(String baseDirectoryPath) {
		setBaseDirectory(new File(baseDirectoryPath));
	}
	
	public IPopulationWriter<? extends Solution> getPopulationWriter() {
		if(populationWriter == null)
			populationWriter = getExperiment().getSearchOrchestration().createPopulationWriter();
		return populationWriter;
	}
	
	public void setPopulationWriter(IPopulationWriter<? extends Solution> populationWriter) {
		this.populationWriter = populationWriter;
	}
	
	public ISolutionWriter<? extends Solution> getSolutionWriter() {
		if(solutionWriter == null)
			solutionWriter = getExperiment().getSearchOrchestration().createSolutionWriter();
		return solutionWriter;
	}
	
	public void setSolutionWriter(ISolutionWriter<? extends Solution> solutionWriter) {
		this.solutionWriter = solutionWriter;
	}
	
	public Map<SearchExecutor, List<NondominatedPopulation>> getResults() {
		return getResults(getExperiment());
	}
	
	public List<NondominatedPopulation> getResult(String name) {
		return getResult(getExperiment(), name, getEpsilon());
	}
	
	public SearchExecutor getExecutor(String name) {
		return getExecutor(getExperiment(), name, getEpsilon());
	}
	
	public NondominatedPopulation createApproximationSet() {
		return createApproximationSet(getExperiment(), getEpsilon());
	}
	
	public NondominatedPopulation createApproximationSet(String... names) {		
		return createApproximationSet(getExperiment(), names);
	}
	
	public String printObjectives() {
		return printObjectives(createApproximationSet());
	}
	
	public String printObjectives(String... names) {
		return printObjectives(createApproximationSet(names));
	}
	
	public File saveObjectives() {
		return saveObjectives(createObjectivesFile(getBaseName()));
	}
	
	public File saveObjectives(String file) {
		return saveObjectives(new File(file));
	}
		
	public File saveObjectives(File file) {
		return saveObjectives(FileUtil.createFile(getBaseDirectory(), file), createApproximationSet());
	}
	
	public File saveObjectives(String file, String... names) {
		return saveObjectives(new File(file), names);
	}
	
	public File saveObjectives(File file, String... names) {
		return saveObjectives(FileUtil.createFile(getBaseDirectory(), file), createApproximationSet(names));
	}
	
	public String printPopulation() {
		return printPopulation(createApproximationSet(), getPopulationWriter());
	}
	
	public String printPopulation(String... names) {
		return printPopulation(createApproximationSet(names), getPopulationWriter());
	}
	
	public String printPopulation(Population population) {
		return printPopulation(population, getPopulationWriter());
	}
	
	public File savePopulation(String file) {
		return savePopulation(new File(file));
	}
	
	public File savePopulation(File file) {
		return savePopulation(FileUtil.createFile(getBaseDirectory(), file), createApproximationSet(), getPopulationWriter());
	}
	
	public File savePopulation(String file, String... names) {
		return savePopulation(new File(file), names);
	}
	
	public File savePopulation(File file, String... names) {
		return savePopulation(getBaseDirectory(), file, createApproximationSet(names), getPopulationWriter());
	}
	
	public File savePopulation(File file, Population population) {
		return savePopulation(getBaseDirectory(), file, population, getPopulationWriter());
	}
	
	public NondominatedPopulation getReferenceSet() {
		return getReferenceSet(getExperiment(), getEpsilon());
	}
	
	public File saveReferenceSet(String filePath) {
		return saveReferenceSet(new File(filePath));
	}
	
	public File saveReferenceSet(File file) {
		return saveObjectives(FileUtil.createFile(getBaseDirectory(), file), getReferenceSet());
	}
	
	public String printReferenceSet() {
		return printObjectives(getReferenceSet());
	}
	
	/**
	 * Static Methods
	 */
	
	public static List<NondominatedPopulation> getResult(SearchExperiment<?> experiment, String name, double... epsilon) {
		for(Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults(experiment).entrySet())
			if(entry.getKey().getName().equals(name))
				return entry.getValue();
		return new ArrayList<>();
	}
	
	public static SearchExecutor getExecutor(SearchExperiment<?> experiment, String name, double... epsilon) {
		for(Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults(experiment).entrySet())
			if(entry.getKey().getName().equals(name))
				return entry.getKey();
		return null;
	}
	
	public static NondominatedPopulation createApproximationSet(SearchExperiment<?> experiment) {
		return createApproximationSet(experiment, (double[])null);
	}
	
	public static NondominatedPopulation createApproximationSet(SearchExperiment<?> experiment, double... epsilon) {
		NondominatedPopulation approximationSet = createArchive(epsilon);
		
		for (List<NondominatedPopulation> entry : getResults(experiment).values()) 
			for (NondominatedPopulation set : entry) 
				approximationSet.addAll(set);
		
		return approximationSet;
	}
	
	public static NondominatedPopulation createApproximationSet(SearchExperiment<?> experiment, String... names) {		
		if(names == null || names.length == 0)
			return createApproximationSet(experiment);
		
		NondominatedPopulation referenceSet = createArchive();
		for(String name : names) {
			for(NondominatedPopulation population : getResult(experiment, name))
				referenceSet.addAll(population);
		}
		
		return referenceSet;
	}
	
	public static Map<SearchExecutor, List<NondominatedPopulation>> getResults(SearchExperiment<?> experiment) {
		if(experiment == null) {
			System.err.println("No experiment given!");
			return new HashMap<>();
		}
		if(!experiment.hasResults())
			experiment.run();
		return experiment.getResults();
	}
	
	public static NondominatedPopulation getReferenceSet(SearchExperiment<?> experiment, double... epsilon) {
		NondominatedPopulation referenceSet = createArchive(epsilon);
		
		File referenceSetFile = experiment.getReferenceSetFile();
		if(referenceSetFile == null)
			return referenceSet;
		
		try {
			referenceSet.addAll(PopulationIO.readObjectives(referenceSetFile));
		} catch (IOException e) {
			System.err.println("Could not load reference set objectives: " + e.getMessage());
		}
		return referenceSet;
	}
	
	public static String printObjectives(Iterable<Solution> solutions) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream writer = new PrintStream(baos);
		writeObjectives(writer, solutions);
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

	public static void writeObjectives(PrintStream ps, Iterable<Solution> solutions) {
		for (Solution solution : solutions) {
			ps.print(Double.toString(solution.getObjective(0)));

			for (int i = 1; i < solution.getNumberOfObjectives(); i++) {
				ps.print(" ");
				ps.print(solution.getObjective(i));
			}
			ps.println();
		}
	}
	
	public static String printAttributes(Iterable<Solution> solutions) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream writer = new PrintStream(baos);
		writeAttributes(writer, solutions);
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
	
	public static void writeAttributes(PrintStream ps, Iterable<Solution> solutions) {
		for (Solution solution : solutions) {
			for(Entry<String, Serializable> entry : solution.getAttributes().entrySet())
				ps.println(SolutionWriter.printObject(entry.getKey()) + ": " + SolutionWriter.printObject(entry.getValue()));
			ps.println();
		}
	}
	
	public static <S extends Solution> String printSolution(S solution, ISolutionWriter<S> writer) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		writer.write(ps, solution);	
		try {
			return baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not print objectives: " + e.getMessage());
			e.printStackTrace();
			return "";
		} finally {
			if(ps != null)
				ps.close();
		}
	}
	
	public static String printPopulation(Population population, IPopulationWriter<?> writer) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		writer.write(ps, population);
		try {
			return baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not print population: " + e.getMessage());
			e.printStackTrace();
			return "";
		} finally {
			if(ps != null)
				ps.close();
		}
	}
	
	public static File saveObjectives(String file, Iterable<Solution> solutions) {
		return saveObjectives(new File(file), solutions);
	}

	public static File saveObjectives(File file, Iterable<Solution> solutions) {
		PrintStream writer = getFilePrintStream(file);
		writeObjectives(writer, solutions);
		if(writer != null)
			writer.close();
		return file;
	}
	
	public static <S extends Solution> File saveSolution(String file, S solution, ISolutionWriter<? super S> writer) {
		return saveSolution(new File(file), solution, writer);
	}
	
	public static <S extends Solution> File saveSolution(File file, S solution, ISolutionWriter<? super S> writer) {
		PrintStream ps = getFilePrintStream(file);
		writer.write(ps, solution);
		if(ps != null)
			ps.close();
		return file;
	}	
	
	public static File savePopulation(String directory, String file, Population population, IPopulationWriter<?> writer) {
		return savePopulation(new File(directory), new File(file), population, writer);
	}

	public static File savePopulation(File directory, File file, Population population, IPopulationWriter<?> writer) {
		FileUtil.checkDirectory(directory);
		return savePopulation(FileUtil.createFile(directory, file), population, writer);
	}
	
	public static File savePopulation(String file, Population population, IPopulationWriter<?> writer) {
		return savePopulation(new File(file), population, writer);
	}
	
	public static File savePopulation(File file, Population population, IPopulationWriter<?> writer) {
		PrintStream ps = getFilePrintStream(file);
		writer.write(ps, population);
		if(ps != null)
			ps.close();
		return file;
	}
	
	public static <S extends Solution> File savePopulation(String directory, String file, Iterable<S> population, IPopulationWriter<S> writer) {
		return savePopulation(new File(directory), new File(file), population, writer);
	}

	public static <S extends Solution> File savePopulation(File directory, File file, Iterable<S> population, IPopulationWriter<S> writer) {
		FileUtil.checkDirectory(directory);
		return savePopulation(FileUtil.createFile(directory, file), population, writer);
	}
	
	public static <S extends Solution> File savePopulation(String file, Iterable<S> population, IPopulationWriter<S> writer) {
		return savePopulation(new File(file), population, writer);
	}
	
	public static <S extends Solution> File savePopulation(File file, Iterable<S> population, IPopulationWriter<S> writer) {
		PrintStream ps = getFilePrintStream(file);
		writer.write(ps, population);
		if(ps != null)
			ps.close();
		return file;
	}
	
	public static <S extends Solution> List<File> saveSolutions(String directory, String baseName, Iterable<S> population, ISolutionWriter<? super S> writer) {
		return saveSolutions(new File(directory), baseName, population, writer);
	}	
	
	public static <S extends Solution> List<File> saveSolutions(String directory, String baseName, Population population, ISolutionWriter<Solution> writer) {
		return saveSolutions(new File(directory), baseName, population, writer);
	}
	
	public static <S extends Solution> List<File> saveSolutions(File directory, String baseName, Population population, ISolutionWriter<Solution> writer) {
		FileUtil.checkDirectory(directory);
		List<File> solutionFiles = new ArrayList<>();
		for(Solution solution : population) {
			File solutionFile = saveSolution(
					FileUtil.createFile(directory, createSolutionFile(baseName, solution)), solution, writer);
			solutionFiles.add(solutionFile);
		}
		return solutionFiles;
	}
	
	public static <S extends Solution> List<File> saveSolutions(File directory, String baseName, Iterable<S> population, ISolutionWriter<? super S> writer) {
		FileUtil.checkDirectory(directory);
		List<File> solutionFiles = new ArrayList<>();
		for(S solution : population) {
			File solutionFile = saveSolution(FileUtil.createFile(directory, createSolutionFile(baseName, solution)), solution, writer);
			solutionFiles.add(solutionFile);
		}
		return solutionFiles;
	}
	
	protected static String createFileName(String baseName, Solution solution, String fileExtension) {
		String objectives = "";
		if(solution != null)
			for(int i = 0; i < solution.getNumberOfObjectives(); i++) 
				objectives += "_" + Double.toString(solution.getObjective(i));
		if(baseName == null)
			baseName = "";
		if(fileExtension == null)
			fileExtension = "";
		else if(!fileExtension.startsWith("."))
			fileExtension = "." + fileExtension;
		return baseName + objectives + fileExtension;
	}	
	
	protected static String createSolutionFileName(String baseName, Solution solution) {
		if(baseName == null)
			baseName = "solution";
		return createFileName(baseName, solution, SOLUTION_FILE_EXTENSION);
	}	
	
	protected static File createSolutionFile(String baseName, Solution solution) {
		return new File(createSolutionFileName(baseName, solution));
	}
	
	protected static String createObjectivesFileName(String baseName, String...names) {
		if(baseName == null)
			baseName = "objectives";
		String concatNames = "";
		for(String name : names)
			concatNames += "_" + name;
		return baseName + concatNames + "." + OBJECTIVE_FILE_EXTENSION;
	}
	
	protected static File createObjectivesFile(String baseName, String...names) {
		return new File(createObjectivesFileName(baseName, names));
	}
	
	
	
	protected static PrintStream getFilePrintStream(File file) {
		FileUtil.checkDirectory(file.getParentFile());
		try {
			return new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	protected static NondominatedPopulation createArchive(double...epsilon) {
		if (epsilon == null || epsilon.length == 0) {
			return new NondominatedPopulation(new ParetoDominanceComparator());
		} else {
			return new EpsilonBoxDominanceArchive(epsilon);
		}
	}
}
