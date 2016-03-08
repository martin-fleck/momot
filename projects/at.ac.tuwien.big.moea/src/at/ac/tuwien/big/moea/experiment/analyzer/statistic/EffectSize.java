package at.ac.tuwien.big.moea.experiment.analyzer.statistic;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class EffectSize {
	protected static Mean MEAN = new Mean();
	protected static StandardDeviation STDDEV = new StandardDeviation();
	
	public static double cohensD(double[] values1, double[] values2) {
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
