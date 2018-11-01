package statistics;

public class AlgorithmStatistics {
	
	private Algorithm algorithm;
	private StatisticalValue igd = new StatisticalValue();
	private StatisticalValue hypervolume = new StatisticalValue();
	
	public AlgorithmStatistics(Algorithm algorithm) {
		this.algorithm = algorithm;
		
	}

	public double getHypervolumeAvg() {
		return hypervolume.getAvg();
	}
	public double getIGDAvg() {
		return igd.getAvg();
	}

	public void addHypervolume(double hypervolume2) {
		this.hypervolume.add(hypervolume2);
	}
	

	public void addIGD(double igd) {
		this.igd.add(igd);
	}

}
