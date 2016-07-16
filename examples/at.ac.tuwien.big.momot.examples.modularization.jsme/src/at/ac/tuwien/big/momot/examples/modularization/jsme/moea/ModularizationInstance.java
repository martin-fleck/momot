package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModularizationInstance {
	List<String> classes;
	Map<String, List<String>> dependencies;
	
	public ModularizationInstance(List<String> classes, Map<String, List<String>> dependencies) {
		this.classes = classes;
		this.dependencies = dependencies;
	}	
	
	public ModularizationInstance() {
		this(new ArrayList<>(), new HashMap<>());
	}
	
	public void addClasses(String... classes) {
		for(String clazz : classes)
			addClass(clazz);
	}
	
	public void addClass(String clazz) {
		if(!classes.contains(clazz))
			classes.add(clazz);
	}
	
	
	public void addDependencies(String source, String... targets) {
		for(String target : targets)
			addDependency(source, target);
	}
	
	public void addDependency(String source, String target) {
		if(!classes.contains(source))
			throw new IllegalArgumentException("Source class '" + source + "' does not exist.");
		if(!classes.contains(target))
			throw new IllegalArgumentException("Target class '" + target + "' does not exist.");
		List<String> targets = dependencies.get(source);
		if(targets == null)
			targets = new ArrayList<>();
		if(!targets.contains(targets))
			targets.add(target);
		dependencies.put(source, targets);
	}
	
	public List<String> getClasses() {
		return classes;
	}
	
	public Map<String, List<String>> getDependencies() {
		return dependencies;
	}
	
	public List<String> getDependencies(String clazz) {
		return dependencies.get(clazz);
	}
	
	public boolean dependsOn(String source, String target) {
		List<String> dependOns = dependencies.get(source);
		return dependOns != null && dependOns.contains(target);
	}
	
	public boolean dependedOnBy(String source, String target) {
		List<String> dependOns = dependencies.get(target);
		return dependOns != null && dependOns.contains(source);
	}
}
