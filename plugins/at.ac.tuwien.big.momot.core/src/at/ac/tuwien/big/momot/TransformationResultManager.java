package at.ac.tuwien.big.momot;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.SearchResultManager;
import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.moea.util.FileUtil;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.util.MomotUtil;

import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;

public class TransformationResultManager extends SearchResultManager {
   protected static final String MODEL_FILE_EXTENSION = "xmi";

   protected static File createModelFile(final String baseName, final Solution solution) {
      return new File(createModelFileName(baseName, solution));
   }

   protected static String createModelFileName(final String baseName, final Solution solution) {
      String fileName = baseName;
      if(fileName == null) {
         fileName = "model";
      }
      return createFileName(fileName, solution, MODEL_FILE_EXTENSION);
   }

   public static String deriveBaseName(final SearchExperiment<TransformationSolution> experiment) {
      final TransformationSearchOrchestration orchestration = CastUtil.assertClass(experiment.getSearchOrchestration(),
            TransformationSearchOrchestration.class);
      return getBaseUri(MomotUtil.getRoot(orchestration.getProblemGraph()));
   }

   public static String getBaseUri(final EObject eObject) {
      if(eObject == null || eObject.eResource() == null || eObject.eResource().getURI() == null) {
         return null;
      } else {
         return eObject.eResource().getURI().trimFileExtension().lastSegment();
      }
   }

   public static String printModel(final Solution solution) {
      final TransformationSolution transformationSolution = MomotUtil.assertTransformationSolution(solution);
      final EGraph graph = transformationSolution.execute();
      return MomotUtil.getRoot(graph).toString();
   }

   public static String printModels(final Iterable<Solution> population) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream writer = new PrintStream(baos);
      for(final Solution s : population) {
         final TransformationSolution solution = MomotUtil.assertTransformationSolution(s);
         final EGraph graph = solution.execute();
         writer.println(MomotUtil.getRoot(graph));
      }
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

   public static File saveModel(final File file, final Solution solution) {
      final TransformationSolution transformationSolution = MomotUtil.assertTransformationSolution(solution);
      final EGraph graph = transformationSolution.execute();
      final String uri = file.getAbsolutePath();
      MomotUtil.saveGraph(graph, uri);
      return file;
   }

   public static File saveModel(final String file, final Solution solution) {
      return saveModel(new File(file), solution);
   }

   public static List<File> saveModels(final File directory, final String baseName,
         final Iterable<? extends Solution> population) {
      FileUtil.checkDirectory(directory);
      final List<File> files = new ArrayList<>();
      for(final Solution solution : population) {
         final File file = saveModel(FileUtil.createFile(directory, createModelFile(baseName, solution)), solution);
         files.add(file);
      }
      return files;
   }

   public static List<File> saveModels(final String directory, final String baseName,
         final Iterable<? extends Solution> population) {
      return saveModels(new File(directory), baseName, population);
   }

   public TransformationResultManager() {
      setSolutionWriter(new TransformationSolutionWriter());
   }

   public TransformationResultManager(final SearchExperiment<TransformationSolution> experiment) {
      super(experiment);
      setSolutionWriter(new TransformationSolutionWriter());
   }

   @Override
   public String getBaseName() {
      if(baseName == null) {
         return deriveBaseName(getExperiment());
      }
      return baseName;
   }

   @SuppressWarnings("unchecked")
   @Override
   public SearchExperiment<TransformationSolution> getExperiment() {
      return (SearchExperiment<TransformationSolution>) super.getExperiment();
   }

   protected TransformationSearchOrchestration getOrchestration() {
      return CastUtil.assertClass(getExperiment().getSearchOrchestration(), TransformationSearchOrchestration.class);
   }

   public File saveModel(final Solution solution) {
      return saveModel(FileUtil.createFile(getBaseDirectory(), createModelFile(getBaseName(), solution)), solution);
   }

   public List<File> saveModels() {
      return saveModels(getBaseDirectory(), getBaseName(), createApproximationSet());
   }

   public List<File> saveModels(final File directory) {
      return saveModels(FileUtil.createFile(getBaseDirectory(), directory), getBaseName(), createApproximationSet());
   }

   public List<File> saveModels(final File directory, final String... names) {
      return saveModels(FileUtil.createFile(getBaseDirectory(), directory), getBaseName(),
            createApproximationSet(names));
   }

   public List<File> saveModels(final Iterable<Solution> population) {
      return saveModels(getBaseDirectory(), getBaseName(), population);
   }

   public List<File> saveModels(final String... names) {
      return saveModels(getBaseDirectory(), getBaseName(), createApproximationSet(names));
   }
}
