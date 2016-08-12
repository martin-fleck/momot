package at.ac.tuwien.big.moea.experiment.analyzer;

import at.ac.tuwien.big.moea.experiment.analyzer.AlgorithmEffectSize.Magnitude;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.moeaframework.Analyzer.IndicatorResult;

public class SearchIndicatorResult {

   protected final String indicator;

   protected final double[] values;

   protected List<String> indifferentAlgorithms;

   protected List<AlgorithmEffectSize> algorithmEffectSizes;

   protected Double aggregateValue;

   public SearchIndicatorResult(final IndicatorResult result) {
      this.algorithmEffectSizes = new ArrayList<>();
      this.indicator = result.getIndicator();
      this.values = result.getValues();
      this.indifferentAlgorithms = result.getIndifferentAlgorithms();
      this.aggregateValue = result.getAggregateValue();
   }

   public SearchIndicatorResult(final String indicator, final double[] values) {
      this.algorithmEffectSizes = new ArrayList<>();
      this.indicator = indicator;
      this.values = values;
   }

   public void addAlgorithmEffectSize(final AlgorithmEffectSize effectSize) {
      algorithmEffectSizes.add(effectSize);
   }

   public void addIndifferentAlgorithm(final String algorithm) {
      indifferentAlgorithms.add(algorithm);
   }

   public Double getAggregateValue() {
      return aggregateValue;
   }

   public List<AlgorithmEffectSize> getAlgorithmEffectSizes() {
      return algorithmEffectSizes;
   }

   public int getCount() {
      return values.length;
   }

   public String getIndicator() {
      return indicator;
   }

   public List<String> getIndifferentAlgorithms() {
      return new ArrayList<>(indifferentAlgorithms);
   }

   public double getStatistic(final UnivariateStatistic statistic) {
      return statistic.evaluate(values);
   }

   public double[] getValues() {
      return values.clone();
   }

   void print(final PrintStream ps, final boolean showAggregate, final boolean showStatisticalSignificance,
         final boolean showIndividualValues, final List<UnivariateStatistic> statistics) {
      final double[] values = getValues();

      ps.print("    ");
      ps.print(getIndicator());
      ps.print(": ");

      if(values.length == 0) {
         ps.print("null");
      } else if(values.length == 1) {
         ps.print(values[0]);
      } else {
         ps.println();

         if(showAggregate) {
            ps.print("        Aggregate: ");
            ps.println(getAggregateValue());
         }

         for(final UnivariateStatistic statistic : statistics) {
            ps.print("        ");
            ps.print(statistic.getClass().getSimpleName());
            ps.print(": ");
            ps.println(getStatistic(statistic));
         }

         ps.print("        Count: ");
         ps.print(getCount());

         if(showStatisticalSignificance) {
            ps.println();
            ps.print("        Indifferent: ");
            ps.print(getIndifferentAlgorithms());

            ps.println();
            if(getAlgorithmEffectSizes().isEmpty()) {
               ps.print("        EffectSize: []");
            } else {
               ps.println("        EffectSize: [");
               for(final AlgorithmEffectSize effectSize : getAlgorithmEffectSizes()) {
                  ps.print("            - { ");
                  ps.print("measure: " + effectSize.getMeasure());
                  ps.print(", algorithm: " + effectSize.getAlgorithm());
                  ps.print(", effectSize: " + effectSize.getEffectSize());
                  if(!Magnitude.UNKNOWN.equals(effectSize.getMagnitude())) {
                     ps.print(", magnitude: " + effectSize.getMagnitude().toString());
                  }
                  ps.println(" }");
               }
               ps.print("        ]");
            }
         }

         if(showIndividualValues) {
            ps.println();
            ps.print("        Values: ");
            ps.print(Arrays.toString(values));
         }
      }

      ps.println();
   }

   public void setAggregateValue(final Double aggregateValue) {
      this.aggregateValue = aggregateValue;
   }
}
