package at.ac.tuwien.big.momot.examples.modularization.jsep.metric;

public class ModelMetrics extends ModuleMetrics {
	private static final long serialVersionUID = -1204171931081112125L;
	
	public int nrModules = 0;
	public int nrEmptyModules = 0;
	public int nrUnassignedClasses = 0;
	public int minMaxDiff = 0;
	
	public ModelMetrics() { }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("NrModules:             " + nrModules + "\n");
		sb.append("MinMaxDiff:            " + minMaxDiff + "\n");
		sb.append("UnassignedClasses:     " + nrUnassignedClasses + "\n");
		sb.append("EmptyModules:          " + nrEmptyModules + "\n");
		return sb.toString();
	}

}
