package at.ac.tuwien.big.momot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.SearchResultManager;
import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class TransformationResultManager extends SearchResultManager {
	protected String baseName;
	
	public TransformationResultManager() {
		setSolutionWriter(new TransformationSolutionWriter());
	}
	
	public TransformationResultManager(SearchExperiment experiment) {
		super(experiment);
		setSolutionWriter(new TransformationSolutionWriter());
	}
	
	public String getBaseName() {
		if(baseName == null) {
			EObject root = MomotUtil.getRoot(getOrchestration().getProblemGraph());
			if(root == null || root.eResource() == null || root.eResource().getURI() == null)
				baseName = "solution";
			else
				baseName = root.eResource().getURI().trimFileExtension().lastSegment();
		}
		return baseName;
	}
	
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	
	protected TransformationSearchOrchestration getOrchestration() {
		return CastUtil.assertClass(getExperiment().getSearchOrchestration(), 
				TransformationSearchOrchestration.class);
	}
	
	protected String getFileName(TransformationSolution solution) {		
		String objectives = "";
		for(int i = 0; i < solution.getNumberOfObjectives(); i++) 
			objectives += "_" + Double.toString(solution.getObjective(i));
		
		return getBaseName() + objectives + ".xmi";
	}
	
	protected List<File> saveGraphs(Iterable<Solution> solutions) {
		List<File> files = new ArrayList<>();
		for(Solution s : solutions) {
			TransformationSolution solution = MomotUtil.assertTransformationSolution(s);
			EGraph graph = solution.execute();
			File file = getFile(getFileName(solution));
			String uri = file.getAbsolutePath();
			MomotUtil.saveGraph(graph, uri);
			files.add(file);
		}
		return files;
	}
	
	public List<File> saveApproximationSetGraphs() {
		return saveGraphs(createApproximationSet());
	}
	
	public List<File> saveApproximationSetGraphs(String... names) {
		return saveGraphs(createApproximationSet(names));
	}
}
