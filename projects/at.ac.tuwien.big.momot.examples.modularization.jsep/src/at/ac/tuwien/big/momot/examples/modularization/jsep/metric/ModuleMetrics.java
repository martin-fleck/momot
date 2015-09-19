package at.ac.tuwien.big.momot.examples.modularization.jsep.metric;

import java.io.Serializable;

public class ModuleMetrics implements Serializable {
	private static final long serialVersionUID = -8613327746079310311L;
	
	public int nrClasses = 0;
	
	public int nrIncomingDependencies = 0;
	public int nrOutgoingDependencies = 0;
	
	public double cohesion = 0.0;
	public double coupling = 0.0;
	
	public double modularizationQuality = 0.0;
	
	public ModuleMetrics() { }
	
	public ModuleMetrics(ModuleMetrics metric) {
		this.nrClasses = metric.nrClasses;
		this.nrIncomingDependencies = metric.nrIncomingDependencies;
		this.nrOutgoingDependencies = metric.nrOutgoingDependencies;
		this.cohesion = metric.cohesion;
		this.coupling = metric.coupling;
		this.modularizationQuality = metric.modularizationQuality;
	}
	
	public void add(ModuleMetrics metric) {
		this.nrClasses += metric.nrClasses;
		this.nrIncomingDependencies += metric.nrIncomingDependencies;
		this.nrOutgoingDependencies += metric.nrOutgoingDependencies;
		this.cohesion += metric.cohesion;
		this.coupling += metric.coupling;
		this.modularizationQuality += metric.modularizationQuality;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nClasses:               " + nrClasses + "\n");
		sb.append("IncomingDependencies:  " + nrIncomingDependencies + "\n");
		sb.append("OutgoingDependencies:  " + nrOutgoingDependencies + "\n");
		sb.append("Coupling:              " + coupling + "\n");
		sb.append("Cohesion:              " + cohesion + "\n");
		sb.append("ModularizationQuality: " + modularizationQuality + "\n");
		return sb.toString();
	}

}
