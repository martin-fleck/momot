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

   public static NondominatedPopulation createApproximationSet(final SearchExperiment<?> experiment) {
      return createApproximationSet(experiment, (double[]) null);
   }

   public static NondominatedPopulation createApproximationSet(final SearchExperiment<?> experiment,
         final double... epsilon) {
      final NondominatedPopulation approximationSet = createArchive(epsilon);

      for(final List<NondominatedPopulation> entry : getResults(experiment).values()) {
         for(final NondominatedPopulation set : entry) {
            approximationSet.addAll(set);
         }
      }

      return approximationSet;
   }

   public static NondominatedPopulation createApproximationSet(final SearchExperiment<?> experiment,
         final String... names) {
      if(names == null || names.length == 0) {
         return createApproximationSet(experiment);
      }

      final NondominatedPopulation referenceSet = createArchive();
      for(final String name : names) {
         for(final NondominatedPopulation population : getResult(experiment, name)) {
            referenceSet.addAll(population);
         }
      }

      return referenceSet;
   }

   protected static NondominatedPopulation createArchive(final double... epsilon) {
      if(epsilon == null || epsilon.length == 0) {
         return new NondominatedPopulation(new ParetoDominanceComparator());
      } else {
         return new EpsilonBoxDominanceArchive(epsilon);
      }
   }

   protected static String createFileName(String baseName, final Solution solution, String fileExtension) {
      String objectives = "";
      if(solution != null) {
         for(int i = 0; i < solution.getNumberOfObjectives(); i++) {
            objectives += "_" + Double.toString(solution.getObjective(i));
         }
      }
      if(baseName == null) {
         baseName = "";
      }
      if(fileExtension == null) {
         fileExtension = "";
      } else if(!fileExtension.startsWith(".")) {
         fileExtension = "." + fileExtension;
      }
      return baseName + objectives + fileExtension;
   }

   protected static File createObjectivesFile(final String baseName, final String... names) {
      return new File(createObjectivesFileName(baseName, names));
   }

   protected static String createObjectivesFileName(String baseName, final String... names) {
      if(baseName == null) {
         baseName = "objectives";
      }
      String concatNames = "";
      for(final String name : names) {
         concatNames += "_" + name;
      }
      return baseName + concatNames + "." + OBJECTIVE_FILE_EXTENSION;
   }

   protected static File createSolutionFile(final String baseName, final Solution solution) {
      return new File(createSolutionFileName(baseName, solution));
   }

   protected static String createSolutionFileName(String baseName, final Solution solution) {
      if(baseName == null) {
         baseName = "solution";
      }
      return createFileName(baseName, solution, SOLUTION_FILE_EXTENSION);
   }

   public static SearchExecutor getExecutor(final SearchExperiment<?> experiment, final String name,
         final double... epsilon) {
      for(final Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults(experiment).entrySet()) {
         if(entry.getKey().getName().equals(name)) {
            return entry.getKey();
         }
      }
      return null;
   }

   protected static PrintStream getFilePrintStream(final File file) {
      FileUtil.checkDirectory(file.getParentFile());
      try {
         return new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, "UTF-8");
      } catch(FileNotFoundException | UnsupportedEncodingException e) {
         System.err.println(e.getMessage());
         return null;
      }
   }

   public static NondominatedPopulation getReferenceSet(final SearchExperiment<?> experiment, final double... epsilon) {
      final NondominatedPopulation referenceSet = createArchive(epsilon);

      final File referenceSetFile = experiment.getReferenceSetFile();
      if(referenceSetFile == null) {
         return referenceSet;
      }

      try {
         referenceSet.addAll(PopulationIO.readObjectives(referenceSetFile));
      } catch(final IOException e) {
         System.err.println("Could not load reference set objectives: " + e.getMessage());
      }
      return referenceSet;
   }

   /**
    * Static Methods
    */

   public static List<NondominatedPopulation> getResult(final SearchExperiment<?> experiment, final String name,
         final double... epsilon) {
      for(final Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults(experiment).entrySet()) {
         if(entry.getKey().getName().equals(name)) {
            return entry.getValue();
         }
      }
      return new ArrayList<>();
   }

   public static Map<SearchExecutor, List<NondominatedPopulation>> getResults(final SearchExperiment<?> experiment) {
      if(experiment == null) {
         System.err.println("No experiment given!");
         return new HashMap<>();
      }
      if(!experiment.hasResults()) {
         experiment.run();
      }
      return experiment.getResults();
   }

   public static String printAttributes(final Iterable<Solution> solutions) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream writer = new PrintStream(baos);
      writeAttributes(writer, solutions);
      if(writer != null) {
         writer.close();
      }
      try {
         return baos.toString("UTF-8");
      } catch(final UnsupportedEncodingException e) {
         System.err.println("Could not print objectives: " + e.getMessage());
         e.printStackTrace();
         return "";
      }
   }

   public static String printObjectives(final Iterable<Solution> solutions) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream writer = new PrintStream(baos);
      writeObjectives(writer, solutions);
      if(writer != null) {
         writer.close();
      }
      try {
         return baos.toString("UTF-8");
      } catch(final UnsupportedEncodingException e) {
         System.err.println("Could not print objectives: " + e.getMessage());
         e.printStackTrace();
         return "";
      }
   }

   public static String printPopulation(final Population population, final IPopulationWriter<?> writer) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream ps = new PrintStream(baos);
      writer.write(ps, population);
      try {
         return baos.toString("UTF-8");
      } catch(final UnsupportedEncodingException e) {
         System.err.println("Could not print population: " + e.getMessage());
         e.printStackTrace();
         return "";
      } finally {
         if(ps != null) {
            ps.close();
         }
      }
   }

   public static <S extends Solution> String printSolution(final S solution, final ISolutionWriter<S> writer) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream ps = new PrintStream(baos);
      writer.write(ps, solution);
      try {
         return baos.toString("UTF-8");
      } catch(final UnsupportedEncodingException e) {
         System.err.println("Could not print objectives: " + e.getMessage());
         e.printStackTrace();
         return "";
      } finally {
         if(ps != null) {
            ps.close();
         }
      }
   }

   public static File saveObjectives(final File file, final Iterable<Solution> solutions) {
      final PrintStream writer = getFilePrintStream(file);
      writeObjectives(writer, solutions);
      if(writer != null) {
         writer.close();
      }
      return file;
   }

   public static File saveObjectives(final String file, final Iterable<Solution> solutions) {
      return saveObjectives(new File(file), solutions);
   }

   public static <S extends Solution> File savePopulation(final File directory, final File file,
         final Iterable<S> population, final IPopulationWriter<S> writer) {
      FileUtil.checkDirectory(directory);
      return savePopulation(FileUtil.createFile(directory, file), population, writer);
   }

   public static File savePopulation(final File directory, final File file, final Population population,
         final IPopulationWriter<?> writer) {
      FileUtil.checkDirectory(directory);
      return savePopulation(FileUtil.createFile(directory, file), population, writer);
   }

   public static <S extends Solution> File savePopulation(final File file, final Iterable<S> population,
         final IPopulationWriter<S> writer) {
      final PrintStream ps = getFilePrintStream(file);
      writer.write(ps, population);
      if(ps != null) {
         ps.close();
      }
      return file;
   }

   public static File savePopulation(final File file, final Population population, final IPopulationWriter<?> writer) {
      final PrintStream ps = getFilePrintStream(file);
      writer.write(ps, population);
      if(ps != null) {
         ps.close();
      }
      return file;
   }

   public static <S extends Solution> File savePopulation(final String file, final Iterable<S> population,
         final IPopulationWriter<S> writer) {
      return savePopulation(new File(file), population, writer);
   }

   public static File savePopulation(final String file, final Population population,
         final IPopulationWriter<?> writer) {
      return savePopulation(new File(file), population, writer);
   }

   public static <S extends Solution> File savePopulation(final String directory, final String file,
         final Iterable<S> population, final IPopulationWriter<S> writer) {
      return savePopulation(new File(directory), new File(file), population, writer);
   }

   public static File savePopulation(final String directory, final String file, final Population population,
         final IPopulationWriter<?> writer) {
      return savePopulation(new File(directory), new File(file), population, writer);
   }

   public static <S extends Solution> File saveSolution(final File file, final S solution,
         final ISolutionWriter<? super S> writer) {
      final PrintStream ps = getFilePrintStream(file);
      writer.write(ps, solution);
      if(ps != null) {
         ps.close();
      }
      return file;
   }

   public static <S extends Solution> File saveSolution(final String file, final S solution,
         final ISolutionWriter<? super S> writer) {
      return saveSolution(new File(file), solution, writer);
   }

   public static <S extends Solution> List<File> saveSolutions(final File directory, final String baseName,
         final Iterable<S> population, final ISolutionWriter<? super S> writer) {
      FileUtil.checkDirectory(directory);
      final List<File> solutionFiles = new ArrayList<>();
      for(final S solution : population) {
         final File solutionFile = saveSolution(FileUtil.createFile(directory, createSolutionFile(baseName, solution)),
               solution, writer);
         solutionFiles.add(solutionFile);
      }
      return solutionFiles;
   }

   public static <S extends Solution> List<File> saveSolutions(final File directory, final String baseName,
         final Population population, final ISolutionWriter<Solution> writer) {
      FileUtil.checkDirectory(directory);
      final List<File> solutionFiles = new ArrayList<>();
      for(final Solution solution : population) {
         final File solutionFile = saveSolution(FileUtil.createFile(directory, createSolutionFile(baseName, solution)),
               solution, writer);
         solutionFiles.add(solutionFile);
      }
      return solutionFiles;
   }

   public static <S extends Solution> List<File> saveSolutions(final String directory, final String baseName,
         final Iterable<S> population, final ISolutionWriter<? super S> writer) {
      return saveSolutions(new File(directory), baseName, population, writer);
   }

   public static <S extends Solution> List<File> saveSolutions(final String directory, final String baseName,
         final Population population, final ISolutionWriter<Solution> writer) {
      return saveSolutions(new File(directory), baseName, population, writer);
   }

   public static void writeAttributes(final PrintStream ps, final Iterable<Solution> solutions) {
      for(final Solution solution : solutions) {
         for(final Entry<String, Serializable> entry : solution.getAttributes().entrySet()) {
            ps.println(
                  SolutionWriter.printObject(entry.getKey()) + ": " + SolutionWriter.printObject(entry.getValue()));
         }
         ps.println();
      }
   }

   public static void writeObjectives(final PrintStream ps, final Iterable<Solution> solutions) {
      for(final Solution solution : solutions) {
         ps.print(Double.toString(solution.getObjective(0)));

         for(int i = 1; i < solution.getNumberOfObjectives(); i++) {
            ps.print(" ");
            ps.print(solution.getObjective(i));
         }
         ps.println();
      }
   }

   protected SearchExperiment<?> experiment;

   protected double[] epsilon;

   protected String baseName;

   protected File baseDirectory;

   protected ISolutionWriter<? extends Solution> solutionWriter;

   protected IPopulationWriter<? extends Solution> populationWriter;

   public SearchResultManager() {}

   public SearchResultManager(final SearchExperiment<?> experiment) {
      this.experiment = experiment;
   }

   public NondominatedPopulation createApproximationSet() {
      return createApproximationSet(getExperiment(), getEpsilon());
   }

   public NondominatedPopulation createApproximationSet(final String... names) {
      return createApproximationSet(getExperiment(), names);
   }

   public File getBaseDirectory() {
      return baseDirectory;
   }

   public String getBaseName() {
      return baseName;
   }

   public double[] getEpsilon() {
      return epsilon;
   }

   public SearchExecutor getExecutor(final String name) {
      return getExecutor(getExperiment(), name, getEpsilon());
   }

   public SearchExperiment<?> getExperiment() {
      return experiment;
   }

   public IPopulationWriter<? extends Solution> getPopulationWriter() {
      if(populationWriter == null) {
         populationWriter = getExperiment().getSearchOrchestration().createPopulationWriter();
      }
      return populationWriter;
   }

   public NondominatedPopulation getReferenceSet() {
      return getReferenceSet(getExperiment(), getEpsilon());
   }

   public List<NondominatedPopulation> getResult(final String name) {
      return getResult(getExperiment(), name, getEpsilon());
   }

   public Map<SearchExecutor, List<NondominatedPopulation>> getResults() {
      return getResults(getExperiment());
   }

   public ISolutionWriter<? extends Solution> getSolutionWriter() {
      if(solutionWriter == null) {
         solutionWriter = getExperiment().getSearchOrchestration().createSolutionWriter();
      }
      return solutionWriter;
   }

   public String printObjectives() {
      return printObjectives(createApproximationSet());
   }

   public String printObjectives(final String... names) {
      return printObjectives(createApproximationSet(names));
   }

   public String printPopulation() {
      return printPopulation(createApproximationSet(), getPopulationWriter());
   }

   public String printPopulation(final Population population) {
      return printPopulation(population, getPopulationWriter());
   }

   public String printPopulation(final String... names) {
      return printPopulation(createApproximationSet(names), getPopulationWriter());
   }

   public String printReferenceSet() {
      return printObjectives(getReferenceSet());
   }

   public File saveObjectives() {
      return saveObjectives(createObjectivesFile(getBaseName()));
   }

   public File saveObjectives(final File file) {
      return saveObjectives(FileUtil.createFile(getBaseDirectory(), file), createApproximationSet());
   }

   public File saveObjectives(final File file, final String... names) {
      return saveObjectives(FileUtil.createFile(getBaseDirectory(), file), createApproximationSet(names));
   }

   public File saveObjectives(final String file) {
      return saveObjectives(new File(file));
   }

   public File saveObjectives(final String file, final String... names) {
      return saveObjectives(new File(file), names);
   }

   public File savePopulation(final File file) {
      return savePopulation(FileUtil.createFile(getBaseDirectory(), file), createApproximationSet(),
            getPopulationWriter());
   }

   public File savePopulation(final File file, final Population population) {
      return savePopulation(getBaseDirectory(), file, population, getPopulationWriter());
   }

   public File savePopulation(final File file, final String... names) {
      return savePopulation(getBaseDirectory(), file, createApproximationSet(names), getPopulationWriter());
   }

   public File savePopulation(final String file) {
      return savePopulation(new File(file));
   }

   public File savePopulation(final String file, final String... names) {
      return savePopulation(new File(file), names);
   }

   public File saveReferenceSet(final File file) {
      return saveObjectives(FileUtil.createFile(getBaseDirectory(), file), getReferenceSet());
   }

   public File saveReferenceSet(final String filePath) {
      return saveReferenceSet(new File(filePath));
   }

   public void setBaseDirectory(final File baseDirectory) {
      FileUtil.checkDirectory(baseDirectory);
      this.baseDirectory = baseDirectory;
   }

   public void setBaseDirectory(final String baseDirectoryPath) {
      setBaseDirectory(new File(baseDirectoryPath));
   }

   public void setBaseName(final String baseName) {
      this.baseName = baseName;
   }

   public void setEpsilon(final double... epsilon) {
      this.epsilon = epsilon;
   }

   public void setExperiment(final SearchExperiment<?> experiment) {
      this.experiment = experiment;
   }

   public void setPopulationWriter(final IPopulationWriter<? extends Solution> populationWriter) {
      this.populationWriter = populationWriter;
   }

   public void setSolutionWriter(final ISolutionWriter<? extends Solution> solutionWriter) {
      this.solutionWriter = solutionWriter;
   }
}
