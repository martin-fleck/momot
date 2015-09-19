package at.ac.tuwien.big.momot.examples.modularization.jsep.moea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ModularizationResult implements Serializable {
	private static final long serialVersionUID = 5474239941163959024L;

	protected ModularizationInstance instance;
	protected Map<Integer, List<String>> modules = new HashMap<>();
	protected Map<String, Integer> classToModule = new HashMap<>();
	
	public ModularizationResult(ModularizationInstance instance, List<Integer> assignment) {
		this.instance = instance;
		setAssignment(assignment);
	}
	
	public ModularizationInstance getInstance() {
		return instance;
	}
	
	public List<String> getClasses() {
		return getInstance().getClasses();
	}
	
	public Map<String, List<String>> getDependencies() {
		return getInstance().getDependencies();
	}
	
	public List<String> getDependencies(String clazz) {
		return getInstance().getDependencies(clazz);
	}
	
	public boolean dependsOn(String source, String target) {
		return getInstance().dependsOn(source, target);
	}
	
	public boolean dependedOnBy(String source, String target) {
		return getInstance().dependedOnBy(source, target);
	}
	
	public Set<Integer> getModules() {
		return modules.keySet();
	}
	
	public Map<Integer, List<String>> getModuleMap() {
		return modules;
	}
	
	public List<String> getClasses(Integer module) {
		return modules.get(module);
	}
	
	public boolean hasModule(String clazz) {
		return classToModule.containsKey(clazz);
	}
	
	protected void setAssignment(List<Integer> assignment) {
		this.modules.clear();
		
		if(assignment.size() != getClasses().size())
			throw new IllegalArgumentException("Not all classes are assigned to a module.");
		
		for(int i = 0; i < assignment.size(); i++) 
			assignClass(getClasses().get(i), assignment.get(i));
	}
	
	protected void assignClass(String clazz, Integer module) {
		List<String> moduleClasses = modules.get(module);
		if(moduleClasses == null) 
			moduleClasses = new ArrayList<>();
		moduleClasses.add(clazz);
		classToModule.put(clazz, module);
		modules.put(module, moduleClasses);
	}
	
	protected String toDependenciesString(String clazz) {
		StringBuilder sb = new StringBuilder();
		sb.append(" [ ");
		List<String> dependencies = getDependencies(clazz);
		if(dependencies != null)
			for(String c : dependencies)
				sb.append(c + " ");
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Integer, List<String>> moduleClasses : getModuleMap().entrySet()) {
			sb.append("  Module 'M" + moduleClasses.getKey() + "':\n");
			for(String clazz : moduleClasses.getValue()) {
				sb.append("    " + clazz + toDependenciesString(clazz) + "\n");
			}
		}
		sb.append("  Unassigned:\n");
		for(String clazz : getClasses()) {
			if(!hasModule(clazz))
				sb.append("    " + clazz + toDependenciesString(clazz) + "\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
