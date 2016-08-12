package at.ac.tuwien.big.moea;

public class IndicatorConfiguration {
   protected boolean additiveEpsilonIndicator;
   protected boolean contribution;
   protected boolean generationalDistance;
   protected boolean hypervolume;
   protected boolean invertedGenerationalDistance;
   protected boolean R1;
   protected boolean R2;
   protected boolean R3;
   protected boolean spacing;

   public IndicatorConfiguration() {}

   public IndicatorConfiguration(final IndicatorConfiguration configuration) {
      setAdditiveEpsilonIndicator(configuration.isAdditiveEpsilonIndicator());
      setContribution(configuration.isContribution());
      setGenerationalDistance(configuration.isGenerationalDistance());
      setHypervolume(configuration.isHypervolume());
      setInvertedGenerationalDistance(configuration.isInvertedGenerationalDistance());
      setR1(configuration.isR1());
      setR2(configuration.isR2());
      setR3(configuration.isR3());
      setSpacing(configuration.isSpacing());
   }

   public boolean isAdditiveEpsilonIndicator() {
      return additiveEpsilonIndicator;
   }

   public boolean isContribution() {
      return contribution;
   }

   public boolean isGenerationalDistance() {
      return generationalDistance;
   }

   public boolean isHypervolume() {
      return hypervolume;
   }

   public boolean isInvertedGenerationalDistance() {
      return invertedGenerationalDistance;
   }

   public boolean isR1() {
      return R1;
   }

   public boolean isR2() {
      return R2;
   }

   public boolean isR3() {
      return R3;
   }

   public boolean isSpacing() {
      return spacing;
   }

   public void setAdditiveEpsilonIndicator(final boolean additiveEpsilonIndicator) {
      this.additiveEpsilonIndicator = additiveEpsilonIndicator;
   }

   public void setAllIndicators(final boolean allIndicators) {
      setHypervolume(allIndicators);
      setGenerationalDistance(allIndicators);
      setInvertedGenerationalDistance(allIndicators);
      setSpacing(allIndicators);
      setAdditiveEpsilonIndicator(allIndicators);
      setContribution(allIndicators);
      setR1(allIndicators);
      setR2(allIndicators);
      setR3(allIndicators);
   }

   public void setContribution(final boolean contribution) {
      this.contribution = contribution;
   }

   public void setGenerationalDistance(final boolean generationalDistance) {
      this.generationalDistance = generationalDistance;
   }

   public void setHypervolume(final boolean hypervolume) {
      this.hypervolume = hypervolume;
   }

   public void setInvertedGenerationalDistance(final boolean invertedGenerationalDistance) {
      this.invertedGenerationalDistance = invertedGenerationalDistance;
   }

   public void setR1(final boolean r1) {
      R1 = r1;
   }

   public void setR2(final boolean r2) {
      R2 = r2;
   }

   public void setR3(final boolean r3) {
      R3 = r3;
   }

   public void setSpacing(final boolean spacing) {
      this.spacing = spacing;
   }
}
