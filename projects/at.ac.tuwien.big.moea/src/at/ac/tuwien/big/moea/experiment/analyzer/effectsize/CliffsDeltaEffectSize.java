package at.ac.tuwien.big.moea.experiment.analyzer.effectsize;

import at.ac.tuwien.big.moea.experiment.analyzer.AlgorithmEffectSize;

/**
 * http://www.inside-r.org/packages/cran/effsize/docs/cliff.delta
 * 
 * The magnitude is assessed using the thresholds provided in (Romano 2006), i.e.,
 * |d|<0.147 "negligible", |d|<0.33 "small", |d|<0.474 "medium", otherwise "large".
 */
public class CliffsDeltaEffectSize extends AlgorithmEffectSize {
	private static final String MEASURE = "CliffsDelta";
	
	public CliffsDeltaEffectSize(String algorithm, double effectSize) {
		super(MEASURE, algorithm, effectSize);
	}
	
	/**
	 * Use magnitude classification of:
	 * J. Romano, J. D. Kromrey, J. Coraggio, J. Skowronek, 
	 * Appropriate statistics for ordinal level data: Should we really be 
	 * using t-test and cohen's d for evaluating group differences on the 
	 * NSSE and other surveys?, in: 
	 * Annual meeting of the Florida Association of Institutional 
	 * Research, 2006. 
	 */
	@Override
	public Magnitude getMagnitude() {
		if(getEffectSize() < 0.147)
			return Magnitude.NEGLIGIBLE;
		if(getEffectSize() < 0.33)
			return Magnitude.SMALL;
		if(getEffectSize() < 0.474)
			return Magnitude.MEDIUM;
		return Magnitude.LARGE;
	}

	public static CliffsDeltaEffectSize calculate(String algorithm, double[] values1, double[] values2) {
		return new CliffsDeltaEffectSize(algorithm, calculate(values1, values2));
	}	
	
	public static double calculate(double[] values1, double[] values2) {
		double lessThan = 0.0;
		double greaterThan = 0.0;
		double m = values1.length;
		double n = values2.length;
		
		for(int i = 0; i < values1.length; i++) {
			for(int j = 0; j < values2.length; j++) {
				if(values1[i] > values2[j])
					greaterThan++;
				if(values1[i] < values2[j])
					lessThan++;				
			}
		}
		
		return Math.abs(greaterThan - lessThan) / (n * m);
	}
}
