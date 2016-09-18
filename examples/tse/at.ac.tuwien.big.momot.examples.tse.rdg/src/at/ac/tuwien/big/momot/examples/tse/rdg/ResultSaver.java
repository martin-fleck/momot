package at.ac.tuwien.big.momot.examples.tse.rdg;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.PopulationIO;
import org.moeaframework.core.Solution;
import org.moeaframework.core.comparator.ParetoDominanceComparator;

import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGTransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.rdg.util.CaseStudy;
import at.ac.tuwien.big.momot.examples.tse.rdg.util.ModularizationUtil;

public class ResultSaver {
	protected RDGSettings settings;

	public ResultSaver(RDGSettings settings) {
		this.settings = settings;
	}
	
	public RDGSettings getSettings() {
		return settings;
	}
	
	protected String getBaseName() {
		return settings.getTransformation().eResource().getURI().lastSegment();
	}
	
	public void savePopulation(NondominatedPopulation solutions, String outputSubDirectory) {
		if(solutions == null)
			return;
		
		outputSubDirectory = ModularizationUtil.checkDirectory(outputSubDirectory);
			
		ModularizationUtil.assertDirectoryExists(CaseStudy.BASE_DIR + outputSubDirectory);
		String fullName = outputSubDirectory + getBaseName();
		
		for(Solution solution : solutions) {
			RDGTransformationMetrics metrics = ModularizationUtil.getMetrics(solution);

			String model = fullName.replaceFirst(".xmi", 
					"_" + metrics.getNrModules() + 
					"_" + metrics.getMinMaxReponsibilityDifference() + 
					"_" + ModularizationUtil.getFormatter().format(metrics.getCohesionRatio()) + 
					"_" + ModularizationUtil.getFormatter().format(metrics.getCouplingRatio()) + 
					".xmi");
					
			ModularizationUtil.getResourceSet().saveEObject(
					RDGConverter.assignModules(settings.getTransformation(), ModularizationUtil.getRDG(solution), true), model);
		}
	}
	
	public File saveApproximationSetObjectives(NondominatedPopulation population, String outputSubDirectory) {
		return saveApproximationSetObjectives(population, outputSubDirectory, null);
	}
	
	public File saveApproximationSetObjectives(NondominatedPopulation population, String outputSubDirectory, String suffix) {
		return saveApproximationSetObjectives(Arrays.asList(population), outputSubDirectory, suffix);
	}
	
	public File saveApproximationSetObjectives(List<NondominatedPopulation> populations, String outputSubDirectory) {
		return saveApproximationSetObjectives(populations, outputSubDirectory, null);
	}
	
	public File saveApproximationSetObjectives(List<NondominatedPopulation> populations, String outputSubDirectory, String suffix) {
		outputSubDirectory = ModularizationUtil.checkDirectory(outputSubDirectory);
		ModularizationUtil.assertDirectoryExists(CaseStudy.BASE_DIR + outputSubDirectory);
		
		File setObjectives = new File(CaseStudy.BASE_DIR + outputSubDirectory + 
				getBaseName().replace(".xmi", 
						(suffix != null && !suffix.isEmpty() ? "_" + suffix : "") + ".csv"));
		
		NondominatedPopulation approximationSet = new NondominatedPopulation(
				new ParetoDominanceComparator());
		
		if(populations.size() > 1) {
			approximationSet = new NondominatedPopulation(
					new ParetoDominanceComparator());
			
			for(NondominatedPopulation population : populations)
				approximationSet.addAll(population);
		} else if(populations.size() == 1)
			approximationSet = populations.get(0);
		
		try {
			PopulationIO.writeObjectives(setObjectives, approximationSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return setObjectives;
	}
}
