package at.ac.tuwien.big.moea.experiment.analyzer.effectsize;

import at.ac.tuwien.big.moea.experiment.analyzer.AlgorithmEffectSize;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class CohensDEffectSize extends AlgorithmEffectSize {

   private static final double LIMIT_MEDIUM = 0.8;
   private static final double LIMIT_SMALL = 0.5;
   private static final double LIMIT_NEGLIGIBLE = 0.2;
   private static final String MEASURE = "CohensD";
   private static final Mean MEAN = new Mean();
   private static final StandardDeviation STDDEV = new StandardDeviation();

   public static double calculate(final double[] values1, final double[] values2) {
      final double m1 = MEAN.evaluate(values1);
      final double m2 = MEAN.evaluate(values2);

      final double s1 = STDDEV.evaluate(values1);
      final double s2 = STDDEV.evaluate(values2);

      final Double cohensD = Math.abs(m1 - m2) / Math.sqrt((s1 * s1 + s2 * s2) / 2);
      if(Double.isNaN(cohensD)) {
         return 0.0;
      }
      return cohensD;
   }

   public static CohensDEffectSize calculate(final String algorithm, final double[] values1, final double[] values2) {
      return new CohensDEffectSize(algorithm, calculate(values1, values2));
   }

   public CohensDEffectSize(final String algorithm, final double effectSize) {
      super(MEASURE, algorithm, effectSize);
   }

   /**
    * Use magnitude classification from
    * Cohen, J. (1992). A power primer. Psychological Bulletin, 112, 155-159.
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
