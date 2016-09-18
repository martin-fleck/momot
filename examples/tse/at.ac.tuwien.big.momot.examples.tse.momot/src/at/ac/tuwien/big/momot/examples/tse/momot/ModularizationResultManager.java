package at.ac.tuwien.big.momot.examples.tse.momot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
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
			Transformation transformation = MomotUtil.getRoot(graph, Transformation.class);
			List<Module> toRemove = new ArrayList<>();
			for(Module module : transformation.getModules())
				if(module.getHelpers().isEmpty() && module.getRules().isEmpty())
					toRemove.add(module);
			
			for(Module module : toRemove) 
				transformation.getModules().remove(module);
			
			File file = createModelFile(getBaseName(), solution);
			String uri = file.getAbsolutePath();
			MomotUtil.saveGraph(graph, uri);
			files.add(file);
		}
		return files;
	}
}
