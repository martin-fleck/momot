package at.ac.tuwien.big.moea.experiment.analyzer;

public class AlgorithmEffectSize {
	protected final String measure;
	protected final String algorithm;
	protected final double effectSize;
	
	public static enum Magnitude {
		UNKNOWN,
		NEGLIGIBLE,
		SMALL,
		MEDIUM,
		LARGE;
		
		public String toString() {
			switch(this) {
			case LARGE:
				return "large";
			case MEDIUM:
				return "medium";	
			case SMALL:
				return "small";
			case NEGLIGIBLE:
				return "negligible";
			default:
				return "unknown";
			}
		};
	}
	
	public AlgorithmEffectSize(String measure, String algorithm, double effectSize) {
		this.measure = measure;
		this.algorithm = algorithm;
		this.effectSize = effectSize;
	}
	
	public String getMeasure() {
		return measure;
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
	
	public double getEffectSize() {
		return effectSize;
	}
	
	public Magnitude getMagnitude() {
		return Magnitude.UNKNOWN;
	}
	
	@Override
	public String toString() {
		return getAlgorithm() + ": " + getMeasure() + " = " + getEffectSize() + " (" + getMagnitude() + ")";
	}

}