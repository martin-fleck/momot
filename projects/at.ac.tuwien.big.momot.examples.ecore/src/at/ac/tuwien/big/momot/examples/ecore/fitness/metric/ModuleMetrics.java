package at.ac.tuwien.big.momot.examples.ecore.fitness.metric;

import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;

public class ModuleMetrics extends Metrics {
	private static final long serialVersionUID = 4033689107121093656L;

	private Module module;
	
	public ModuleMetrics() { }
	
	public ModuleMetrics(Module module) {
		this.module = module;
	}
	
	public Module getModule() {
		return module;
	}
	
	@Override
	public String toString(String indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent + "Module:             " + getModule().getName() + "\n");
		sb.append(super.toString(indent));
		return sb.toString();
	}
}
