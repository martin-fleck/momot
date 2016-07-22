package at.ac.tuwien.big.moea.experiment.analyzer.effectsize;

import at.ac.tuwien.big.moea.experiment.analyzer.AlgorithmEffectSize;

/**
 * http://www.inside-r.org/packages/cran/effsize/docs/cliff.delta
 *
 * The magnitude is assessed using the thresholds provided in (Romano 2006), i.e.,
 * |d|<0.147 "negligible", |d|<0.33 "small", |d|<0.474 "medium", otherwise "large".
 */
public class CliffsDeltaEffectSize extends AlgorithmEffectSize {
   private static final double LIMIT_MEDIUM = 0.474;
   private static final double LIMIT_SMALL = 0.33;
   private static final double LIMIT_NEGLIGIBLE = 0.147;
   private static final String MEASURE = "CliffsDelta";

   public static double calculate(final double[] values1, final double[] values2) {
      double lessThan = 0.0;
      double greaterThan = 0.0;
      final double m = values1.length;
      final double n = values2.length;

      for(final double element : values1) {
         for(final double element2 : values2) {
            if(element > element2) {
               greaterThan++;
            }
            if(element < element2) {
               lessThan++;
            }
         }
      }

      return Math.abs(greaterThan - lessThan) / (n * m);
   }

   public static CliffsDeltaEffectSize calculate(final String algorithm, final double[] values1,
         final double[] values2) {
      return new CliffsDeltaEffectSize(algorithm, calculate(values1, values2));
   }

   public CliffsDeltaEffectSize(final String algorithm, final double effectSize) {
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
      if(getEffectSize() < LIMIT_NEGLIGIBLE) {
         return Magnitude.NEGLIGIBLE;
      }
      if(getEffectSize() < LIMIT_SMALL) {
         return Magnitude.SMALL;
      }
      if(getEffectSize() < LIMIT_MEDIUM) {
         return Magnitude.MEDIUM;
      }
      return Magnitude.LARGE;
   }
}
