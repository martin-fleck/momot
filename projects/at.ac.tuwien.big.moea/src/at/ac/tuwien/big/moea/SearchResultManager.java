package at.ac.tuwien.big.moea;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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


public class SearchResultManager {
	protected SearchExperiment experiment;
	protected double[] epsilon;
	protected File baseDirectory;
	
	protected ISolutionWriter<? extends Solution> solutionWriter;
	protected IPopulationWriter<? extends Solution> populationWriter;
	
	public SearchResultManager() { }
	
	public SearchResultManager(SearchExperiment experiment) {
		this.experiment = experiment;
	}
	
	public SearchExperiment getExperiment() {
		return experiment;
	}
	
	public void setExperiment(SearchExperiment experiment) {
		this.experiment = experiment;
	}
	
	public double[] getEpsilon() {
		return epsilon;
	}
	
	public void setEpsilon(double... epsilon) {
		this.epsilon = epsilon;
	}
	
	public File getBaseDirectory() {
		return baseDirectory;
	}
	
	public void setBaseDirectory(File baseDirectory) {
		if(baseDirectory != null) {
			if(!baseDirectory.exists()) {
				System.out.println("Directory '" + baseDirectory + "' does not exist, it will be created.");
				if(!baseDirectory.mkdirs())
					System.err.println("Could not create directory '" + baseDirectory + "'.");
			}
			if(!baseDirectory.isDirectory())
				throw new IllegalArgumentException("File '" + baseDirectory + "' is not a directory.");
		}
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
	
	protected NondominatedPopulation createArchive() {
		if (epsilon == null) {
			return new NondominatedPopulation(new ParetoDominanceComparator());
		} else {
			return new EpsilonBoxDominanceArchive(epsilon);
		}
	}
	
	public Map<SearchExecutor, List<NondominatedPopulation>> getResults() {
		if(getExperiment() == null) {
			System.err.println("No experiment given!");
			return new HashMap<>();
		}
		if(!getExperiment().hasResults())
			getExperiment().run();
		return getExperiment().getResults();
	}
	
	public List<NondominatedPopulation> getResult(String name) {
		for(Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults().entrySet())
			if(entry.getKey().getName().equals(name))
				return entry.getValue();
		return new ArrayList<>();
	}
	
	public SearchExecutor getExecutor(String name) {
		for(Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults().entrySet())
			if(entry.getKey().getName().equals(name))
				return entry.getKey();
		return null;
	}
	
	public NondominatedPopulation createApproximationSet() {
		NondominatedPopulation approximationSet = createArchive();
		
		for (List<NondominatedPopulation> entry : getResults().values()) 
			for (NondominatedPopulation set : entry) 
				approximationSet.addAll(set);
		
		return approximationSet;
	}
	
	public NondominatedPopulation createApproximationSet(String... names) {
		NondominatedPopulation referenceSet = createArchive();
		
		if(names == null || names.length == 0)
			return referenceSet;
		
		for(String name : names) {
			for(NondominatedPopulation population :  getResult(name))
				referenceSet.addAll(population);
		}
		
		return referenceSet;
	}
	
	protected File getFile(String fileName) {
		return getFile(new File(fileName));
	}
	
	protected File getFile(File file) {
		File newFile = file;
		if(getBaseDirectory() != null)
			newFile = new File(getBaseDirectory().getPath() + File.separator + file.getPath());
		newFile.getParentFile().mkdirs();
		try {
			newFile.createNewFile();				
		} catch (IOException e) {
			System.err.println("Could not create file '" + newFile + "'.");
		}
		return newFile;
	}
	
	protected String getFileName(Solution solution) {
		return "";
	}
	
	public String printApproximationSetObjectives() {
		return printObjectives(createApproximationSet());
	}
	
	public String printApproximationSetObjectives(String... names) {
		return printObjectives(createApproximationSet(names));
	}
	
	public File saveApproximationSetObjectives(String filePath) {
		return saveApproximationSetObjectives(new File(filePath));
	}
	
	public File saveApproximationSetObjectives(File file) {
		return saveObjectives(getFile(file), createApproximationSet());
	}
	
	public File saveApproximationSetObjectives(String filePath, String... names) {
		return saveApproximationSetObjectives(new File(filePath), names);
	}
	
	public File saveApproximationSetObjectives(File file, String... names) {
		return saveObjectives(getFile(file), createApproximationSet(names));
	}
	
	public String printApproximationSet() {
		return printPopulation(createApproximationSet(), getPopulationWriter());
	}
	
	public String printApproximationSet(String... names) {
		return printPopulation(createApproximationSet(names), getPopulationWriter());
	}
	
	public File saveApproximationSet(String filePath) {
		return saveApproximationSet(new File(filePath));
	}
	
	public File saveApproximationSet(File file) {
		return savePopulation(getFile(file), createApproximationSet(), getPopulationWriter());
	}
	
	public File saveApproximationSet(String filePath, String... names) {
		return saveApproximationSet(new File(filePath), names);
	}
	
	public File saveApproximationSet(File file, String... names) {
		return savePopulation(getFile(file), createApproximationSet(names), getPopulationWriter());
	}
	
	public NondominatedPopulation getReferenceSet() {
		NondominatedPopulation referenceSet = createArchive();
		
		File referenceSetFile = getExperiment().getReferenceSetFile();
		if(referenceSetFile == null)
			return referenceSet;
		
		try {
			referenceSet.addAll(PopulationIO.readObjectives(
					referenceSetFile));
		} catch (IOException e) {
			System.err.println("Could not load reference set objectives: " + e.getMessage());
		}
		return referenceSet;
	}
	
	public File saveReferenceSet(String filePath) {
		return saveReferenceSet(new File(filePath));
	}
	
	public File saveReferenceSet(File file) {
		return saveObjectives(getFile(file), getReferenceSet());
	}
	
	public String printReferenceSet() {
		return printObjectives(getReferenceSet());
	}
	
	protected static PrintStream getFilePrintStream(File file) {
		try {
			return new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.err.println(e.getMessage());
			return null;
		}
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
	
	public static File saveObjectives(File file, Iterable<Solution> solutions) {
		PrintStream writer = getFilePrintStream(file);
		writeObjectives(writer, solutions);
		if(writer != null)
			writer.close();
		return file;
	}
	
	public static void writeObjectives(PrintStream writer, Iterable<Solution> solutions) {
		for (Solution solution : solutions) {
			writer.print(Double.toString(solution.getObjective(0)));

			for (int i = 1; i < solution.getNumberOfObjectives(); i++) {
				writer.print(" ");
				writer.print(solution.getObjective(i));
			}
			writer.println();
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
	
	public static <S extends Solution> File saveSolution(File file, S solution, ISolutionWriter<S> writer) {
		PrintStream ps = getFilePrintStream(file);
		writer.write(ps, solution);
		if(ps != null)
			ps.close();
		return file;
	}
	
	public static String printPopulation(Population population, IPopulationWriter<?> writer) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		writer.write(ps, population);
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
	
	public static File savePopulation(File file, Population population, IPopulationWriter<?> writer) {
		PrintStream ps = getFilePrintStream(file);
		writer.write(ps, population);
		if(ps != null)
			ps.close();
		return file;
	}
}
