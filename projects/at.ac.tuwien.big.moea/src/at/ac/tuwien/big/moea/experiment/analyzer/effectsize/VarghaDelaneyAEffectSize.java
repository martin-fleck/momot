package at.ac.tuwien.big.moea.experiment.analyzer.effectsize;

import at.ac.tuwien.big.moea.experiment.analyzer.AlgorithmEffectSize;

public class VarghaDelaneyAEffectSize  extends AlgorithmEffectSize {
	private static final String MEASURE = "VarghaDelaneyA";
	
	public VarghaDelaneyAEffectSize(String algorithm, double effectSize) {
		super(MEASURE, algorithm, effectSize);
	}

	public static VarghaDelaneyAEffectSize calculate(String algorithm, double[] values1, double[] values2) {
		return new VarghaDelaneyAEffectSize(algorithm, calculate(values1, values2));
	}	
	
	public static double calculate(double[] values1, double[] values2) {
		// alternative: (Cliffs Delta) + 1 / 2
		double greaterThan = 0.0;
		double equal = 0.0;
		double m = values1.length;
		double n = values2.length;
		
		for(int i = 0; i < values1.length; i++) {
			for(int j = 0; j < values2.length; j++) {
				if(values1[i] > values2[j])
					greaterThan++;
				if(values1[i] == values2[j])
					equal++;
			}
		}
		
		return Math.abs(greaterThan + 0.5 * equal) / (n * m);
	}
	
}
