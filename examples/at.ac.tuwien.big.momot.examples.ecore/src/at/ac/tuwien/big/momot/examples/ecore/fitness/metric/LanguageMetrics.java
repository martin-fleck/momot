package at.ac.tuwien.big.momot.examples.ecore.fitness.metric;

import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;

public class LanguageMetrics extends Metrics {
	private static final long serialVersionUID = -8382677736030566696L;

	protected Language language;
	protected int nrModules;
	protected int minModuleSize = Integer.MAX_VALUE;
	protected int maxModuleSize = Integer.MIN_VALUE;
	
	public LanguageMetrics() { }
	
	public LanguageMetrics(Language language) {
		setLanguage(language);
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public Language getLanguage() {
		return language;
	}
	
	public int getNrModules() {
		return nrModules;
	}
	
	protected void setNrModules(int nrModules) {
		this.nrModules = nrModules;
	}
	
	protected void addNrModules(int nrModules) {
		this.nrModules += nrModules;
	}
	
	public void considerModule(Module module) {
		addNrModules(1);
		int moduleSize = module.getEntities().size();
		if(moduleSize < minModuleSize)
			minModuleSize = moduleSize;
		if(moduleSize > maxModuleSize)
			maxModuleSize = moduleSize;
	}
	
	public int getMinMaxDiff() {
		return maxModuleSize - minModuleSize;
	}
	
	@Override
	public String toString(String indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent + "Language:           " + getLanguage().getName() + "\n");
		sb.append(indent + "Non-Empty Modules:  " + getNrModules() + "\n");
		sb.append(indent + "MinMaxDiff:         " + getMinMaxDiff() + "\n");
		sb.append(super.toString(indent));
		return sb.toString();
	}
}
