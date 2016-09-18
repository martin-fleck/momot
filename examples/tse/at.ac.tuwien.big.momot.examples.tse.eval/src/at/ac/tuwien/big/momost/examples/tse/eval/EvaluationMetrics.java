package at.ac.tuwien.big.momost.examples.tse.eval;

/**
 * Formulas based on:
 *  - Christopher D. Manning, Prabhakar Raghavan, and Hinrich Schütze. 2008. 
 *    Introduction to Information Retrieval. Cambridge University Press.
 *    
 * @author Martin Fleck
 *
 */
public class EvaluationMetrics {
	private int truePositives;
	private int falsePositives;
	private int falseNegatives;
	
	public int getFalseNegatives() {
		return falseNegatives;
	}
	
	public void setFalseNegatives(int falseNegatives) {
		this.falseNegatives = falseNegatives;
	}
	
	public int getFalsePositives() {
		return falsePositives;
	}
	
	public void setFalsePositives(int falsePositives) {
		this.falsePositives = falsePositives;
	}
	
	public int getTruePositives() {
		return truePositives;
	}
	
	public void setTruePositives(int truePositives) {
		this.truePositives = truePositives;
	}
	
	public double getPrecision() {
		return getTruePositives() / (double)(getTruePositives() + getFalsePositives());
	}
	
	public double getRecall() {
		return getTruePositives() / (double)(getTruePositives() + getFalseNegatives());
	}
	
	/**
	 * Balanced F-Measure: Balanced Weighted harmonic mean of precision and recall
	 * @return F-measure with b = 1
	 */
	public double getF1() {
		return (2 * getPrecision() * getRecall()) / (getPrecision() + getRecall());
	}
	
	/**
	 * F-Measure: Weighted harmonic mean of precision and recall
	 * @param b weight-parameter, b = 1 results in a balanced F-measure, b < 1 emphasize precision, b > 1 emphasize recall
	 * @return F-measure
	 */
	public double getFMeasure(int b) {
		return (((b*b)+1) * getPrecision() * getRecall()) / ((b*b) * getPrecision() + getRecall());
	}
	
	@Override
	public String toString() {
		return "Precision = " + getPrecision() + ", Recall = " + getRecall() + ", F1 = " + getF1();
	}
}
