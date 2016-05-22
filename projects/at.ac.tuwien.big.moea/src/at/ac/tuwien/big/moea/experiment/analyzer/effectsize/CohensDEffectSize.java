package at.ac.tuwien.big.moea.experiment.analyzer.effectsize;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import at.ac.tuwien.big.moea.experiment.analyzer.AlgorithmEffectSize;

public class CohensDEffectSize extends AlgorithmEffectSize {

	private static final String MEASURE = "CohensD";
	private static final Mean MEAN = new Mean();
	private static final StandardDeviation STDDEV = new StandardDeviation();
	
	public CohensDEffectSize(String algorithm, double effectSize) {
		super(MEASURE, algorithm, effectSize);
	}
	
	/**
	 * Use magnitude classification from 
	 * Cohen, J. (1992). A power primer. Psychological Bulletin, 112, 155-159. 
	 */
	@Override
	public Magnitude getMagnitude() {
		if(getEffectSize() < 0.2)
			return Magnitude.NEGLIGIBLE;
		if(getEffectSize() < 0.5)
			return Magnitude.SMALL;
		if(getEffectSize() < 0.8)
			return Magnitude.MEDIUM;
		return Magnitude.LARGE;
	}
	
	public static CohensDEffectSize calculate(String algorithm, double[] values1, double[] values2) {
		return new CohensDEffectSize(algorithm, calculate(values1, values2));
	}
	
	public static double calculate(double[] values1, double[] values2) {
		double m1 = MEAN.evaluate(values1);
		double m2 = MEAN.evaluate(values2);
		
		double s1 = STDDEV.evaluate(values1);
		double s2 = STDDEV.evaluate(values2);
		
		Double cohensD = Math.abs(m1 - m2)/Math.sqrt((s1 * s1 + s2 * s2)/2);
		if(Double.isNaN(cohensD))
			return 0.0;
		return cohensD;
	}
}
