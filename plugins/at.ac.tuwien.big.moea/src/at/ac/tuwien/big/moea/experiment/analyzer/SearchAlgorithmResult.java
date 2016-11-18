package at.ac.tuwien.big.moea.experiment.analyzer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.moeaframework.Analyzer.AlgorithmResult;
import org.moeaframework.Analyzer.IndicatorResult;

public class SearchAlgorithmResult {
   protected final String algorithm;
   protected List<SearchIndicatorResult> indicatorResults;

   public SearchAlgorithmResult(final AlgorithmResult result) {
      this(result.getAlgorithm());
      for(final String indicator : result.getIndicators()) {
         final IndicatorResult indicatorResult = result.get(indicator);
         if(indicatorResult != null) {
            indicatorResults.add(new SearchIndicatorResult(indicatorResult));
         }
      }
   }

   public SearchAlgorithmResult(final String algorithm) {
      this.algorithm = algorithm;
      this.indicatorResults = new ArrayList<>();
   }

   void add(final IndicatorResult result) {
      add(new SearchIndicatorResult(result));
   }

   void add(final SearchIndicatorResult result) {
      indicatorResults.add(result);
   }

   public SearchIndicatorResult get(final String indicator) {
      for(final SearchIndicatorResult result : indicatorResults) {
         if(result.getIndicator().equals(indicator)) {
            return result;
         }
      }
      return null;
   }

   public String getAlgorithm() {
      return algorithm;
   }

   public List<SearchIndicatorResult> getIndicatorResults() {
      return indicatorResults;
   }

   public List<String> getIndicators() {
      final List<String> indicators = new ArrayList<>();
      for(final SearchIndicatorResult result : indicatorResults) {
         indicators.add(result.getIndicator());
      }
      return indicators;
   }

   void print(final PrintStream ps, final boolean showAggregate, final boolean showStatisticalSignificance,
         final boolean showIndividualValues, final List<UnivariateStatistic> statistics) {
      ps.print(getAlgorithm());
      ps.println(':');

      for(final SearchIndicatorResult indicatorResult : indicatorResults) {
         indicatorResult.print(ps, showAggregate, showStatisticalSignificance, showIndividualValues, statistics);
      }
   }
}
