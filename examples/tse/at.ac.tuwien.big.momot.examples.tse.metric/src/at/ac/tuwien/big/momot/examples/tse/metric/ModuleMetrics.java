package at.ac.tuwien.big.momot.examples.tse.metric;

import at.ac.tuwien.big.momot.examples.tse.modularization.Module;

public class ModuleMetrics extends Metrics {
	private static final long serialVersionUID = -6873544300520012490L;

	private Module module;
	
	public ModuleMetrics() { }
	
	public ModuleMetrics(Module module) {
		this.module = module;
	}
	
	public Module getModule() {
		return module;
	}
}
