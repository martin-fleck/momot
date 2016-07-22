package at.ac.tuwien.big.momot.examples.modularization.jsme;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.util.MomotUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;

public class ModularizationResultManager extends TransformationResultManager {
   public ModularizationResultManager() {
      super();
   }

   public ModularizationResultManager(final SearchExperiment<TransformationSolution> experiment) {
      super(experiment);
   }

   @Override
   public List<File> saveModels(final Iterable<Solution> solutions) {
      final List<File> files = new ArrayList<>();
      for(final Solution s : solutions) {
         final TransformationSolution solution = MomotUtil.assertTransformationSolution(s);
         final EGraph graph = solution.execute();
         final ModularizationModel modularizationModel = MomotUtil.getRoot(graph, ModularizationModel.class);
         final List<Module> toRemove = new ArrayList<>();
         for(final Module module : modularizationModel.getModules()) {
            if(module.getClasses().isEmpty()) {
               toRemove.add(module);
            }
         }

         for(final Module module : toRemove) {
            modularizationModel.getModules().remove(module);
         }

         final File file = createModelFile(getBaseName(), solution);
         final String uri = file.getAbsolutePath();
         MomotUtil.saveGraph(graph, uri);
         files.add(file);
      }
      return files;
   }
}
