package at.ac.tuwien.big.momot.examples.tse.metric;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.momot.examples.tse.modularization.Helper;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Rule;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class TransformationMetrics extends Metrics {
	private static final long serialVersionUID = -4368576345756711733L;

	private Transformation transformation;
	private int nrModules;
	private int minResponsibilities = 0;
	private int maxResponsibilities = 0;
	private Map<Module, Metrics> moduleMetrics = new HashMap<>();
	
	public TransformationMetrics() { }
	
	public TransformationMetrics(Transformation transformation) {
		this.transformation = transformation;
	}
	
	public Transformation getTransformation() {
		return transformation;
	}
	
	public int getNrModules() {
		return nrModules;
	}
	
	public void setNrModules(int nrModules) {
		this.nrModules = nrModules;
	}
	
	public void addNrModules(int nrModules) {
		this.nrModules += nrModules;
	}
	
	public Map<Module, Metrics> getModuleMetrics() {
		return moduleMetrics;
	}
	
	public Metrics setMetrics(Module module, Metrics metrics) {
		int nrResponsibilities = metrics.getNrResponsibilities();
		if(nrResponsibilities < minResponsibilities)
			minResponsibilities = nrResponsibilities;
		if(nrResponsibilities > maxResponsibilities)
			maxResponsibilities = nrResponsibilities;
		return moduleMetrics.put(module, metrics);
	}
	
	public Metrics getMetrics(Module module, boolean create) {
		Metrics metrics = moduleMetrics.get(module);
		if(create && metrics == null) {
			metrics = new ModuleMetrics(module);
			moduleMetrics.put(module, metrics);
		}
		return metrics;
	}
	
	public Metrics getMetrics(Module module) {
		return getMetrics(module, false);
	}
	
	public double getAvgHelpersPerModule() {
		return getNrHelpers() / ((double)getNrModules());
	}
	
	public double getAvgRulesPerModule() {
		return getNrRules() / ((double)getNrModules());
	}
	
	public double getAvgResponsibilitiesPerModule() {
		return getNrResponsibilities() / ((double)getNrModules());
	}
	
	public int getMinResponsibilitiesPerModule() {
		int minResponsibilities = getNrResponsibilities();
		for(Metrics metrics : getModuleMetrics().values()) {
			int nrResponsibilities = metrics.getNrResponsibilities();
			if(nrResponsibilities < minResponsibilities)
				minResponsibilities = nrResponsibilities;
		}
		return minResponsibilities;
	}
	
	public int getMaxResponsibilitiesPerModule() {
		int maxResponsibilities = 0;
		for(Metrics metrics : getModuleMetrics().values()) {
			int nrResponsibilities = metrics.getNrResponsibilities();
			if(nrResponsibilities > maxResponsibilities)
				maxResponsibilities = nrResponsibilities;
		}
		return maxResponsibilities;
	}
	
	public int getMinMaxReponsibilityDifference() {
		int maxResponsibilities = 0;
		int minResponsibilities = getNrResponsibilities();
		for(Metrics metrics : getModuleMetrics().values()) {
			int nrResponsibilities = metrics.getNrResponsibilities();
			if(nrResponsibilities < minResponsibilities)
				minResponsibilities = nrResponsibilities;
			if(nrResponsibilities > maxResponsibilities)
				maxResponsibilities = nrResponsibilities;
		}
		return maxResponsibilities - minResponsibilities;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Transformation '" + transformation.getName() + "'" + "\n");
		sb.append("-------------------------------" + "\n");
		sb.append("    Modules:                       { ");
		for(Module module : transformation.getModules()) 
			sb.append("'" + module.getName() + "'" + " ");
		sb.append("}" + "\n");
		sb.append("    Modules:                       " + getNrModules() + "\n");
		sb.append("    AvgRulesPerModule:             " + getAvgRulesPerModule() + "\n");
		sb.append("    AvgHelpersPerModule:           " + getAvgHelpersPerModule() + "\n");
		sb.append("    MinResponsibilitiesPerModule:  " + getMinResponsibilitiesPerModule() + "\n");
		sb.append("    MaxResponsibilitiesPerModule:  " + getMaxResponsibilitiesPerModule() + "\n");
		sb.append("    AvgResponsibilitiesPerModule:  " + getAvgResponsibilitiesPerModule() + "\n");
		sb.append("    MinMaxReponsibilityDifference: " + getMinMaxReponsibilityDifference() + "\n");
		sb.append(super.toString("    "));
		sb.append("-------------------------------" + "\n");
		for(Module module : transformation.getModules()) { 
			sb.append("  Module '" + module.getName() + "'" + "\n");
			sb.append("  -----------------------------" + "\n");
			sb.append("    Rules:                         { ");
			for(Rule rule : module.getRules()) 
				sb.append("'" + rule.getName() + "'" + " ");
			sb.append("}" + "\n");
			sb.append("    Helpers:                       { ");
			for(Helper helper : module.getHelpers()) 
				sb.append("'" + helper.getName() + "' ");
			sb.append("}" + "\n");
			sb.append(getMetrics(module).toString("    "));
			sb.append("  -----------------------------" + "\n");
		}
		return sb.toString();
	}
}