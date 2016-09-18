package at.ac.tuwien.big.momot.examples.tse.metric.calc;

import at.ac.tuwien.big.momot.examples.tse.metric.Metrics;
import at.ac.tuwien.big.momot.examples.tse.metric.ModuleMetrics;
import at.ac.tuwien.big.momot.examples.tse.metric.TransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.modularization.Helper;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Rule;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class MetricCalculator {
	public static TransformationMetrics calculateMetrics(Transformation transformation) {
		TransformationMetrics transMetrics = new TransformationMetrics(transformation);
		transMetrics.setNrModules(transformation.getModules().size());

		for(Module module : transformation.getModules())  {
			Metrics metrics = calculateMetrics(module);
			transMetrics.setMetrics(module, metrics);
			transMetrics.addAll(metrics);
		}
		
		return transMetrics;
	}
	
	public static ModuleMetrics calculateMetrics(Module module) {
		ModuleMetrics metrics = new ModuleMetrics(module);
		metrics.setNrRules(module.getRules().size());
		metrics.setNrHelpers(module.getHelpers().size());
		
		Transformation 	transformation = (Transformation) module.eContainer();
		for(Module target : transformation.getModules()) {
			double rule2helperDependencies = calculateRule2HelperDependencies(module, target);
			double maxRule2HelperDependencies = calculateMaxRule2HelperDependencies(module, target);
			double rule2helperRatio = maxRule2HelperDependencies <= 0.0 ? 0.0 : rule2helperDependencies / maxRule2HelperDependencies;
			
			double rule2ruleDependencies = calculateRule2RuleDependencies(module, target);
			double maxRule2RuleDependencies = calculateMaxRule2RuleDependencies(module, target);
			double rule2ruleRatio = maxRule2RuleDependencies <= 0.0 ? 0.0 : rule2ruleDependencies / maxRule2RuleDependencies;
			
			double helper2helperDependencies = calculateHelper2HelperDependencies(module, target);
			double maxHelper2HelperDependencies = calculateMaxHelper2HelperDependencies(module, target);
			double helper2helperRatio = maxHelper2HelperDependencies <= 0.0 ? 0.0 : helper2helperDependencies / maxHelper2HelperDependencies;
			
			double dependencies = rule2helperDependencies + rule2ruleDependencies + helper2helperDependencies;
			double ratio = rule2helperRatio + rule2ruleRatio + helper2helperRatio;
			
			metrics.addRule2HelperDependencies((int) rule2helperDependencies);
			metrics.addMaxRule2HelperDependencies((int) maxRule2HelperDependencies);
			
			metrics.addRule2RuleDependencies((int) rule2ruleDependencies);
			metrics.addMaxRule2RuleDependencies((int) maxRule2RuleDependencies);
			
			metrics.addHelper2HelperDependencies((int) helper2helperDependencies);
			metrics.addMaxHelper2HelperDependencies((int) maxHelper2HelperDependencies);
			
			if(module == target) {
				// cohesion
				metrics.addCohesion(dependencies);
				metrics.addCohesionRatio(ratio);
			} else {
				// coupling
				metrics.addCoupling(dependencies);
				metrics.addCouplingRatio(ratio);
			}
		}
		return metrics;
	}
	
	public static int calculateNrRules(Transformation transformation) {
		int nrRules = 0;
		for(Module module : transformation.getModules()) 
			nrRules += module.getRules().size();
		return nrRules;
	}
	
	public static int calculateNrHelpers(Transformation transformation) {
		int nrHelpers = 0;
		for(Module module : transformation.getModules()) 
			nrHelpers += module.getHelpers().size();
		return nrHelpers;
	}
	
	public static int calculateNrResponsibilities(Transformation transformation) {
		return calculateNrRules(transformation) + calculateNrHelpers(transformation);
	}
	
	public static double calculateCRAIndex(Transformation transformation) {
		double cohesionRatio = calculateCohesionRatio(transformation);
		double couplingRatio = calculateCouplingRatio(transformation);
		return cohesionRatio - couplingRatio;
	}
		
	public static double calculateCohesionRatio(Transformation transformation) {
		double ratio = 0.0;
		for(Module module : transformation.getModules()) 
			ratio += calculateCohesionRatio(module);
		return ratio;
	}
	
	public static double calculateCohesionRatio(Module module) {
		double ratio = 0.0;
		ratio += calculateRule2HelperDependencyRatio(module, module);
		ratio += calculateRule2RuleDependencyRatio(module, module);
		ratio += calculateHelper2HelperDependencyRatio(module, module);
		return ratio;
	}
		
	public static double calculateCohesion(Transformation transformation) {
		double cohesion = 0.0;
		for(Module module : transformation.getModules())
			cohesion += calculateCohesion(module);		
		return cohesion;
	}
	
	public static double calculateCohesion(Module module) {
		double cohesion = 0.0;
		cohesion += calculateRule2HelperDependencies(module, module);
		cohesion += calculateRule2RuleDependencies(module, module);
		cohesion += calculateHelper2HelperDependencies(module, module);
		return cohesion;
	}
		
	public static double calculateCouplingRatio(Transformation transformation) {
		double ratio = 0.0;
		for(Module source : transformation.getModules())
			ratio += calculateCouplingRatio(source);
		return ratio;
	}
	
	public static double calculateCouplingRatio(Module module) {
		double ratio = 0.0;
		Transformation transformation = (Transformation) module.eContainer();
		for(Module target : transformation.getModules())
			if(module != target) {
				ratio += calculateRule2HelperDependencyRatio(module, target);
				ratio += calculateRule2RuleDependencyRatio(module, target);
				ratio += calculateHelper2HelperDependencyRatio(module, target);
			}
		return ratio;
	}
		
	public static double calculateCoupling(Transformation transformation) {
		double coupling = 0.0;
		for(Module source : transformation.getModules())
			coupling += calculateCoupling(source);
		return coupling;
	}
	
	public static double calculateCoupling(Module module) {
		double coupling = 0.0;
		Transformation transformation = (Transformation) module.eContainer();
		for(Module target : transformation.getModules())
			if(module != target) {
				coupling += calculateRule2HelperDependencies(module, target);
				coupling += calculateRule2RuleDependencies(module, target);
				coupling += calculateHelper2HelperDependencies(module, target);
			}
		return coupling;
	}
	
	protected static double calculateRule2RuleDependencyRatio(Module source, Module target) {
		double maxDependency = calculateMaxRule2RuleDependencies(source, target);
		double ruleDependencies = calculateRule2RuleDependencies(source, target);
		return maxDependency <= 0.0 ? 0.0 : ruleDependencies / maxDependency;
	}
	
	protected static double calculateRule2HelperDependencyRatio(Module source, Module target) {
		double maxDependency = calculateMaxRule2HelperDependencies(source, target);
		return maxDependency <= 0.0 ? 0.0 : calculateRule2HelperDependencies(source, target) / maxDependency;
	}
	
	protected static double calculateHelper2HelperDependencyRatio(Module source, Module target) {
		double maxDependency = calculateMaxHelper2HelperDependencies(source, target);
		return maxDependency <= 0.0 ? 0.0 : calculateHelper2HelperDependencies(source, target) / maxDependency;
	}	
	
	protected static double calculateRule2RuleDependencies(Module source, Module target) {
		double sum = 0.0;
		for(Rule sourceRule : source.getRules())
			for(Rule targetRule : target.getRules())
				sum += calculateDependency(sourceRule, targetRule);
		return sum;
	}
	
	protected static double calculateHelper2HelperDependencies(Module source, Module target) {
		double sum = 0.0;
		for(Helper sourceHelper : source.getHelpers())
			for(Helper targetHelper : target.getHelpers())
				sum += calculateDependency(sourceHelper, targetHelper);
		return sum;
	}
	
	protected static double calculateRule2HelperDependencies(Module source, Module target) {
		double sum = 0.0;
		for(Rule sourceRule : source.getRules())
			for(Helper targetHelper : target.getHelpers())
				sum += calculateDependency(sourceRule, targetHelper);
		return sum;
	}
	
	protected static double calculateMaxRule2RuleDependencies(Module source, Module target) {
		return Math.max(source.getRules().size() * (target.getRules().size() - 1), 0.0);
	}
	
	protected static double calculateMaxRule2HelperDependencies(Module source, Module target) {
		return source.getRules().size() * target.getHelpers().size();
	}
	
	protected static double calculateMaxHelper2HelperDependencies(Module source, Module target) {
		return Math.max(source.getHelpers().size() * (target.getHelpers().size() - 1), 0.0);
	}	
	
	protected static double calculateDependency(Helper source, Helper target) {
		return source.getHelperDependencies().contains(target) ? 1.0 : 0.0;
	}
	
	protected static double calculateDependency(Rule source, Rule target) {
		return source.getRuleDependencies().contains(target) ||
			   source.getInheritsFrom().contains(target) ? 1.0 : 0.0;
	}
	
	protected static double calculateDependency(Rule source, Helper target) {
		return source.getHelperDependencies().contains(target) ? 1.0 : 0.0;
	}
}
