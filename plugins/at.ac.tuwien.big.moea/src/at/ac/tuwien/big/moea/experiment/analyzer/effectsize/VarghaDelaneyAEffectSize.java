package at.ac.tuwien.big.moea.experiment.analyzer.effectsize;

import at.ac.tuwien.big.moea.experiment.analyzer.AlgorithmEffectSize;

public class VarghaDelaneyAEffectSize extends AlgorithmEffectSize {
   private static final String MEASURE = "VarghaDelaneyA";

   public static double calculate(final double[] values1, final double[] values2) {
      // alternative: (Cliffs Delta) + 1 / 2
      double greaterThan = 0.0;
      double equal = 0.0;
      final double m = values1.length;
      final double n = values2.length;

      for(final double element : values1) {
         for(final double element2 : values2) {
            if(element > element2) {
               greaterThan++;
            }
            if(element == element2) {
               equal++;
            }
         }
      }
      return Math.abs(greaterThan + 0.5 * equal) / (n * m);
   }

   public static VarghaDelaneyAEffectSize calculate(final String algorithm, final double[] values1,
         final double[] values2) {
      return new VarghaDelaneyAEffectSize(algorithm, calculate(values1, values2));
   }

   public VarghaDelaneyAEffectSize(final String algorithm, final double effectSize) {
      super(MEASURE, algorithm, effectSize);
   }

}
