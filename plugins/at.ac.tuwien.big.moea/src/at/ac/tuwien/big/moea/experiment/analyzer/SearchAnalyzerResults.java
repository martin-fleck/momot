package at.ac.tuwien.big.moea.experiment.analyzer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.moeaframework.Analyzer;
import org.moeaframework.Analyzer.AlgorithmResult;

public class SearchAnalyzerResults {

   protected final List<SearchAlgorithmResult> algorithmResults;

   public SearchAnalyzerResults() {
      this.algorithmResults = new ArrayList<>();
   }

   public SearchAnalyzerResults(final Analyzer.AnalyzerResults results) {
      this();
      if(results == null) {
         return;
      }

      for(final String algorithm : results.getAlgorithms()) {
         final AlgorithmResult algorithmResult = results.get(algorithm);
         if(algorithmResult != null) {
            algorithmResults.add(new SearchAlgorithmResult(algorithmResult));
         }
      }
   }

   void add(final AlgorithmResult result) {
      add(new SearchAlgorithmResult(result));
   }

   void add(final SearchAlgorithmResult result) {
      algorithmResults.add(result);
   }

   public SearchAlgorithmResult get(final String algorithm) {
      for(final SearchAlgorithmResult result : algorithmResults) {
         if(result.getAlgorithm().equals(algorithm)) {
            return result;
         }
      }

      return null;
   }

   public List<SearchAlgorithmResult> getAlgorithmResults() {
      return algorithmResults;
   }

   public List<String> getAlgorithms() {
      final List<String> algorithms = new ArrayList<>();

      for(final SearchAlgorithmResult result : algorithmResults) {
         algorithms.add(result.getAlgorithm());
      }

      return algorithms;
   }

   public List<String> getIndicators() {
      final Set<String> indicators = new TreeSet<>();
      for(final SearchAlgorithmResult result : algorithmResults) {
         indicators.addAll(result.getIndicators());
      }
      return new ArrayList<>(indicators);
   }

   public void print(final PrintStream ps, final boolean showAggregate, final boolean showStatisticalSignificance,
         final boolean showIndividualValues, final List<UnivariateStatistic> statistics) {
      for(final SearchAlgorithmResult algorithmResult : algorithmResults) {
         algorithmResult.print(ps, showAggregate, showStatisticalSignificance, showIndividualValues, statistics);
      }
   }
}
