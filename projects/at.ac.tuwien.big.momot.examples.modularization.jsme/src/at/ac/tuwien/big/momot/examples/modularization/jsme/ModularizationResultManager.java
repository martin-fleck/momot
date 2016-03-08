package at.ac.tuwien.big.momot.examples.modularization.jsme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModularizationResultManager extends TransformationResultManager {
	public ModularizationResultManager() {
		super();
	}
	
	public ModularizationResultManager(SearchExperiment<TransformationSolution> experiment) {
		super(experiment);
	}
	
	@Override
	public List<File> saveModels(Iterable<Solution> solutions) {
		List<File> files = new ArrayList<>();
		for(Solution s : solutions) {
			TransformationSolution solution = MomotUtil.assertTransformationSolution(s);
			EGraph graph = solution.execute();
			ModularizationModel modularizationModel = MomotUtil.getRoot(graph, ModularizationModel.class);
			List<Module> toRemove = new ArrayList<>();
			for(Module module : modularizationModel.getModules())
				if(module.getClasses().isEmpty())
					toRemove.add(module);
			
			for(Module module : toRemove) {
				modularizationModel.getModules().remove(module);
			}
			
			File file = createModelFile(getBaseName(), solution);
			String uri = file.getAbsolutePath();
			MomotUtil.saveGraph(graph, uri);
			files.add(file);
		}
		return files;
	}
}
