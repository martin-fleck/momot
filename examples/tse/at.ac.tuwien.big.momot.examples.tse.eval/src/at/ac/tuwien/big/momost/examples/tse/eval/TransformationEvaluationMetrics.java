package at.ac.tuwien.big.momost.examples.tse.eval;

import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class TransformationEvaluationMetrics extends EvaluationMetrics {
	private Transformation transformation;
	private String algorithm;
	
	public Transformation getTransformation() {
		return transformation;
	}
	
	public void setTransformation(Transformation transformation) {
		this.transformation = transformation;
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
	
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	
	@Override
	public String toString() {
		String transformation = "";
		if(getTransformation() != null)
			transformation = getTransformation().eResource().getURI().lastSegment() + ": ";
		return transformation + super.toString();
	}
}
