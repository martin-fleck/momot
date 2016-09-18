package at.ac.tuwien.big.momot.examples.tse.rdg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGModuleMetrics;
import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGTransformationMetrics;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RDG implements Cloneable, Serializable {
	private static final long serialVersionUID = -4097103821258421530L;

	private String name;
	private int nrResponsibilities;
	private boolean[][] dependencies;
	private String[] responsibilityNames;
	private int[] responsibilityModules;
	private boolean[] responsibilityRule; // true if responsibility is rule, false if helper
	private Set<Integer> modules = new TreeSet<>();
	private Map<String, Integer> nameToPosition = new HashMap<>();
	
	public RDG(RDG original) {
		this.name = original.name;
		this.nrResponsibilities = original.nrResponsibilities;
		this.dependencies = original.dependencies;
		this.responsibilityNames = original.responsibilityNames;
		this.responsibilityModules = original.responsibilityModules.clone();
		this.responsibilityRule = original.responsibilityRule;
		this.modules = new TreeSet<>(original.modules);
		this.nameToPosition = original.nameToPosition;
	}
	
	public RDG(String name, Map<String, Boolean> responsibilities) {
		this.name = name;
		this.nrResponsibilities = responsibilities.size();
		this.dependencies = new boolean[nrResponsibilities][nrResponsibilities];
		this.responsibilityNames = new String[nrResponsibilities];
		this.responsibilityModules = new int[nrResponsibilities];
		this.responsibilityRule = new boolean[nrResponsibilities];
		int index = 0;
		for(Entry<String, Boolean> responsibility : responsibilities.entrySet()) {
			this.responsibilityNames[index] = responsibility.getKey();
			this.responsibilityRule[index] = responsibility.getValue();
			this.nameToPosition.put(responsibility.getKey(), index);
			index++;
		}
		this.modules.add(0);
	}
	
	public RDG(Map<String, Boolean> responsibilities) {
		this("RDG", responsibilities);
	}
	
	public int getNrResponsibilities() {
		return nrResponsibilities;
	}
	
	public String getName() {
		return name;
	}
	
	public String getResponsibilityName(int position) {
		return responsibilityNames[position];
	}
	
	public int getPosition(String name) {
		return nameToPosition.get(name);
	}
	
	public boolean hasDependency(int from, int to) {
		return dependencies[from][to];
	}
	
	public boolean hasDependency(String from, String to) {
		return dependencies[getPosition(from)][getPosition(to)];
	}
	
	public void setDependency(String from, String to) {
		this.dependencies[getPosition(from)][getPosition(to)] = true;
	}
	
	public int getModule(int responsibility) {
		return this.responsibilityModules[responsibility];
	}
	
	public int getModule(String responsibility) {
		return getModule(getPosition(responsibility));
	}
	
	public String getModuleName(int responsibility) {
		return "Module_" + getModule(responsibility);
	}
	
	public String getModuleName(String responsibility) {
		return "Module_" + getModule(responsibility);
	}
	
	public void setModule(int responsibility, int module) {
		this.responsibilityModules[responsibility] = module;
		this.modules.add(module);
	}
	
	public void setModule(String responsibility, int module) {
		setModule(getPosition(responsibility), module);
	}
	
	public void clearModules() {
		this.modules.clear();
	}
	
	public boolean isRule(String responsibility) {
		return isRule(getPosition(responsibility));
	}
	
	public boolean isRule(int responsibility) {
		return responsibilityRule[responsibility];
	}
	
	public boolean isHelper(String responsibility) {
		return isHelper(getPosition(responsibility));
	}
	
	public boolean isHelper(int responsibility) {
		return !isRule(responsibility);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/** Eval **/
	
	public Map<String, String> calculateModuleNameAssignment() {
		Map<String, String> assignment = new HashMap<>();
		int index = 0;
		for(String name : responsibilityNames) 
			assignment.put(name, "Module_" + getModule(index++));
		return assignment;
	}
	
	public int getNrModules() {
		return modules.size();
	}
	
	public List<Integer> getModules() {
		return new ArrayList<>(modules);
	}
	
	public RDGTransformationMetrics calculateMetrics() {
		int nrModules = getNrModules();
		
		RDGTransformationMetrics metrics = new RDGTransformationMetrics(this);
				
		Map<Integer, Integer> modulePositions = new TreeMap<>();
		int index = 0;
		for(Integer module : modules) {
			metrics.addModule(module);
			metrics.setMetrics(module, new RDGModuleMetrics());
			modulePositions.put(module, index++);
		}
		
		int[] helpers = new int[nrModules];
		int[] rules = new int[nrModules];
		int[][] rule2helperDependencies = new int[nrModules][nrModules];
		int[][] rule2ruleDependencies = new int[nrModules][nrModules];
		int[][] helper2helperDependencies = new int[nrModules][nrModules];
		
		for(int source = 0; source < dependencies.length; source++) {
			int sourceModule = getModule(source);
			int sourceModulePos = modulePositions.get(sourceModule);
			if(isRule(source)) {
				metrics.getMetrics(sourceModule).addRule(getResponsibilityName(source));
				rules[sourceModulePos]++;
			} else {
				metrics.getMetrics(sourceModule).addHelper(getResponsibilityName(source));
				helpers[sourceModulePos]++;
			}
			
			for(int target = 0; target < dependencies[source].length; target++) {
				int targetModulePos = modulePositions.get(getModule(target));				
				
				if(hasDependency(source, target))
					if(isRule(source)) {
						if(isRule(target))
							rule2ruleDependencies[sourceModulePos][targetModulePos]++;
						else 
							rule2helperDependencies[sourceModulePos][targetModulePos]++;
					} else
						helper2helperDependencies[sourceModulePos][targetModulePos]++;
			}
		}				
				
		for(Integer module : modules) {
			RDGModuleMetrics moduleMetrics = metrics.getMetrics(module);
			int sourceModulePos = modulePositions.get(module);
			for(int targetModulePos = 0; targetModulePos < nrModules; targetModulePos++) {
				int maxRule2HelperDep = rules[sourceModulePos] * helpers[targetModulePos];
				if(maxRule2HelperDep < 0)
					maxRule2HelperDep = 0;
				int rule2helperDep = rule2helperDependencies[sourceModulePos][targetModulePos];
				double rule2helperRatio = maxRule2HelperDep == 0 ? 0.0 : rule2helperDep / ((double)maxRule2HelperDep);
				
				int maxRule2RuleDep = rules[sourceModulePos] * (rules[targetModulePos] - 1);
				if(maxRule2RuleDep < 0)
					maxRule2RuleDep = 0;
				int rule2ruleDep = rule2ruleDependencies[sourceModulePos][targetModulePos];
				double rule2ruleRatio = maxRule2RuleDep == 0 ? 0.0 : rule2ruleDep / ((double)maxRule2RuleDep);
				
				int maxHelper2HelperDep = helpers[sourceModulePos] * (helpers[targetModulePos] - 1);
				if(maxHelper2HelperDep < 0)
					maxHelper2HelperDep = 0;
				int helper2helperDep = helper2helperDependencies[sourceModulePos][targetModulePos];
				double helper2helperRatio = maxHelper2HelperDep == 0 ? 0.0 : helper2helperDep / ((double)maxHelper2HelperDep);
				
				moduleMetrics.addRule2HelperDependencies(rule2helperDep);
				moduleMetrics.addMaxRule2HelperDependencies(maxRule2HelperDep);
				
				moduleMetrics.addRule2RuleDependencies(rule2ruleDep);
				moduleMetrics.addMaxRule2RuleDependencies(maxRule2RuleDep);
				
				moduleMetrics.addHelper2HelperDependencies(helper2helperDep);
				moduleMetrics.addMaxHelper2HelperDependencies(maxHelper2HelperDep);
				
				int dependencies = rule2helperDep + rule2ruleDep + helper2helperDep;
				double ratio = rule2helperRatio + rule2ruleRatio + helper2helperRatio;
				if(sourceModulePos == targetModulePos) {
					moduleMetrics.addCohesionRatio(ratio);
					moduleMetrics.addCohesion(dependencies);
				} else {
					moduleMetrics.addCouplingRatio(ratio);
					moduleMetrics.addCoupling(dependencies);
				}
			}
			metrics.addAll(moduleMetrics);
		}
		
		return metrics;
	}
	
	public double calculateCRAIndex() {
		int nrModules = getNrModules();
		Map<Integer, Integer> modulePositions = new TreeMap<>();
		int index = 0;
		for(Integer module : modules) 
			modulePositions.put(module, index++);
		
		int[] helpers = new int[nrModules];
		int[] rules= new int[nrModules];
		int[][] rule2helperDependencies = new int[nrModules][nrModules];
		int[][] rule2ruleDependencies = new int[nrModules][nrModules];
		int[][] helper2helperDependencies = new int[nrModules][nrModules];
		
		for(int source = 0; source < dependencies.length; source++) {
			int sourceModule = modulePositions.get(getModule(source));
			if(isRule(source))
				rules[sourceModule]++;
			else
				helpers[sourceModule]++;
			
			for(int target = 0; target < dependencies[source].length; target++) {
				int targetModule = modulePositions.get(getModule(target));				
				
				if(hasDependency(source, target))
					if(isRule(source)) {
						if(isRule(target))
							rule2ruleDependencies[sourceModule][targetModule]++;
						else 
							rule2helperDependencies[sourceModule][targetModule]++;
					} else
						helper2helperDependencies[sourceModule][targetModule]++;
			}
		}
		
		double overallCohesionRatio = 0.0;
		double overallCouplingRatio = 0.0;
				
		for(int sourceModule = 0; sourceModule < nrModules; sourceModule++) {
			for(int targetModule = 0; targetModule < nrModules; targetModule++) {
				int maxRule2HelperDep = rules[sourceModule] * helpers[targetModule];
				if(maxRule2HelperDep < 0)
					maxRule2HelperDep = 0;
				int rule2helperDep = rule2helperDependencies[sourceModule][targetModule];
				double rule2helperRatio = maxRule2HelperDep == 0 ? 0.0 : rule2helperDep / ((double)maxRule2HelperDep);
				
				int maxRule2RuleDep = rules[sourceModule] * (rules[targetModule] - 1);
				if(maxRule2RuleDep < 0)
					maxRule2RuleDep = 0;
				int rule2ruleDep = rule2ruleDependencies[sourceModule][targetModule];
				double rule2ruleRatio = maxRule2RuleDep == 0 ? 0.0 : rule2ruleDep / ((double)maxRule2RuleDep);
				
				int maxHelper2HelperDep = helpers[sourceModule] * (helpers[targetModule] - 1);
				if(maxHelper2HelperDep < 0)
					maxHelper2HelperDep = 0;
				int helper2helperDep = helper2helperDependencies[sourceModule][targetModule];
				double helper2helperRatio = maxHelper2HelperDep == 0 ? 0.0 : helper2helperDep / ((double)maxHelper2HelperDep);
								
				double ratio = rule2helperRatio + rule2ruleRatio + helper2helperRatio;
				if(sourceModule == targetModule) 
					overallCohesionRatio += ratio;
				else
					overallCouplingRatio += ratio;
			}
		}
		return overallCohesionRatio - overallCouplingRatio;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append(getName() + "\n");
		sb.append("--------------" + "\n");
		for(int responsibility = 0; responsibility < responsibilityModules.length; responsibility++) {
			sb.append(getResponsibilityName(responsibility) + " -> " + responsibilityModules[responsibility] + "\n");
		}
		sb.append("--------------" + "\n");
		return sb.toString();
	}
}
