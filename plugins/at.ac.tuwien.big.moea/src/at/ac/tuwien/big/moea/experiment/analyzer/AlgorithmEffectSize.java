package at.ac.tuwien.big.moea.experiment.analyzer;

public class AlgorithmEffectSize {
   public enum Magnitude {
      UNKNOWN, NEGLIGIBLE, SMALL, MEDIUM, LARGE;

      @Override
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

   protected final String measure;
   protected final String algorithm;

   protected final double effectSize;

   public AlgorithmEffectSize(final String measure, final String algorithm, final double effectSize) {
      this.measure = measure;
      this.algorithm = algorithm;
      this.effectSize = effectSize;
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

   public String getMeasure() {
      return measure;
   }

   @Override
   public String toString() {
      return getAlgorithm() + ": " + getMeasure() + " = " + getEffectSize() + " (" + getMagnitude() + ")";
   }
}
