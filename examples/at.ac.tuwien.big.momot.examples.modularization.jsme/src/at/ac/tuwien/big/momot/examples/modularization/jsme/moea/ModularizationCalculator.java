package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import java.util.List;
import java.util.Map.Entry;

import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;
import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModuleMetrics;

public class ModularizationCalculator {
		
	public ModelMetrics calculate(ModularizationResult modularization) {
		ModelMetrics modelMetrics = new ModelMetrics();
		modelMetrics.nrModules = modularization.getModules().size();
				
		int min = modularization.getModules().size();
		int max = 0;
		for(Entry<Integer, List<String>> moduleClasses : modularization.getModuleMap().entrySet()) {
			if(moduleClasses.getValue().isEmpty())
				modelMetrics.nrEmptyModules += 1;
			else {
				ModuleMetrics metric = calculate(modularization, moduleClasses.getKey(), moduleClasses.getValue());
				if(metric.nrClasses < min)
					min = metric.nrClasses;
				if(metric.nrClasses > max)
					max = metric.nrClasses;
				modelMetrics.add(metric);
			}
		}
		modelMetrics.minMaxDiff = max - min;
		
		for(String clazz : modularization.getClasses()) {
			if(!modularization.hasModule(clazz))
				modelMetrics.nrUnassignedClasses += 1;
		}
		return modelMetrics;
	}
	
	protected ModuleMetrics calculate(ModularizationResult modularization, Integer module, List<String> classes) {
		ModuleMetrics metrics = new ModuleMetrics();
		metrics.nrClasses = classes.size();
		
		for(Entry<Integer, List<String>> moduleClasses : modularization.getModuleMap().entrySet()) {
			int outgoingDependencies = 0;
			int incomingDependencies = 0;
			
			for(String sourceClass : classes) {
				for(String targetClass : moduleClasses.getValue()) {
					if(modularization.dependsOn(sourceClass, targetClass))
						outgoingDependencies++;
					if(modularization.dependedOnBy(sourceClass, targetClass))
						incomingDependencies++;
				}
			}
			
			if(module.equals(moduleClasses.getKey())) {
				metrics.cohesion += outgoingDependencies;
			} else {
				metrics.coupling += outgoingDependencies;
				metrics.nrIncomingDependencies += incomingDependencies;
				metrics.nrOutgoingDependencies += outgoingDependencies;
			}
		}
		metrics.coupling = metrics.coupling * 2; // count each edge twice
		if(metrics.cohesion == 0)
			metrics.modularizationQuality = 0.0;
		else
			metrics.modularizationQuality = 
				metrics.cohesion / 
				(metrics.cohesion + 0.5 * (metrics.nrIncomingDependencies + metrics.nrOutgoingDependencies));
		if(Double.isNaN(metrics.modularizationQuality))
			System.err.println("Why :(");
		return metrics;
	}
}
