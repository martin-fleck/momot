package at.ac.tuwien.big.momot.examples.tse.rdg.metric;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import at.ac.tuwien.big.momot.examples.tse.metric.Metrics;
import at.ac.tuwien.big.momot.examples.tse.rdg.RDG;

public class RDGTransformationMetrics extends Metrics {
	private static final long serialVersionUID = 8303451983693562896L;

	private RDG rdg;
	private List<Integer> modules = new ArrayList<>();
	private Map<Integer, RDGModuleMetrics> moduleMetrics = new TreeMap<>();
	
	public RDGTransformationMetrics(RDG rdg) {
		this.rdg = rdg;
	}
	
	public RDG getRDG() {
		return rdg;
	}
	
	public List<Integer> getModules() {
		return modules;
	}
	
	public void addModule(Integer module) {
		this.modules.add(module);
	}
	
	public RDGModuleMetrics setMetrics(int module, RDGModuleMetrics metrics) {
		return moduleMetrics.put(module, metrics);
	}
	
	public RDGModuleMetrics getMetrics(int module) {
		return moduleMetrics.get(module);
	}
	
	public int getNrModules() {
		return getModules().size();
	}
		
	public Map<Integer, RDGModuleMetrics> getModuleMetrics() {
		return moduleMetrics;
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
		for(RDGModuleMetrics metrics : getModuleMetrics().values()) {
			int nrResponsibilities = metrics.getNrResponsibilities();
			if(nrResponsibilities < minResponsibilities)
				minResponsibilities = nrResponsibilities;
		}
		return minResponsibilities;
	}
	
	public int getMaxResponsibilitiesPerModule() {
		int maxResponsibilities = 0;
		for(RDGModuleMetrics metrics : getModuleMetrics().values()) {
			int nrResponsibilities = metrics.getNrResponsibilities();
			if(nrResponsibilities > maxResponsibilities)
				maxResponsibilities = nrResponsibilities;
		}
		return maxResponsibilities;
	}
	
	public int getMinMaxReponsibilityDifference() {
		int maxResponsibilities = 0;
		int minResponsibilities = getNrResponsibilities();
		for(RDGModuleMetrics metrics : getModuleMetrics().values()) {
			int nrResponsibilities = metrics.getNrResponsibilities();
			if(nrResponsibilities < minResponsibilities)
				minResponsibilities = nrResponsibilities;
			if(nrResponsibilities > maxResponsibilities)
				maxResponsibilities = nrResponsibilities;
		}
		return maxResponsibilities - minResponsibilities;
	}
	
	public String toString(boolean printModules) {
		StringBuilder sb = new StringBuilder();
		sb.append("RDG '" + rdg.getName() + "'" + "\n");
		sb.append("-------------------------------" + "\n");
		sb.append("    Modules:                       { ");
		for(Integer module : getModules()) 
			sb.append("'Module_" + module + "'" + " ");
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
		if(!printModules)
			return sb.toString();
		
		for(Integer module : getModules()) { 
			RDGModuleMetrics metrics = getMetrics(module);
			sb.append("  Module 'Module_" + module + "'" + "\n");
			sb.append("  -----------------------------" + "\n");
			sb.append("    Rules:                         { ");
			for(String rule : new TreeSet<>(metrics.getRules()))
				sb.append("'" + rule + "'" + " ");
			sb.append("}" + "\n");
			sb.append("    Helpers:                       { ");
			for(String helper : new TreeSet<>(metrics.getHelpers())) 
				sb.append("'" + helper + "' ");
			sb.append("}" + "\n");
			sb.append(metrics.toString("    "));
			sb.append("  -----------------------------" + "\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return toString(true);
	}
}
