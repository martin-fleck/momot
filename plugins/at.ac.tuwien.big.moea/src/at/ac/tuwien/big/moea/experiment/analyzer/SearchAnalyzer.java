package at.ac.tuwien.big.moea.experiment.analyzer;

import at.ac.tuwien.big.moea.experiment.analyzer.chart.SearchBoxPlot;
import at.ac.tuwien.big.moea.experiment.analyzer.effectsize.CliffsDeltaEffectSize;
import at.ac.tuwien.big.moea.experiment.analyzer.effectsize.CohensDEffectSize;
import at.ac.tuwien.big.moea.experiment.analyzer.effectsize.VarghaDelaneyAEffectSize;
import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.spi.ProblemFactory;

public class SearchAnalyzer extends org.moeaframework.Analyzer {
   protected Field dataField;
   protected Field statisticsField;
   protected Field showAggregateField;
   protected Field showStatisticalSignificanceField;
   protected Field showIndividualValuesField;

   public SearchAnalyzer() {
      getPrivateFields();

      showStatistic(new Min());
      showStatistic(new Median());
      showStatistic(new Max());
      showStatistic(new Mean());
      showStatistic(new StandardDeviation());
      showStatistic(new Variance());
   }

   public SearchAnalyzer(final ISearchProblem<?> problem) {
      this();
      withProblem(problem);
   }

   @Override
   public SearchAnalyzer add(final String name, final NondominatedPopulation result) {
      super.add(name, result);
      return this;
   }

   @Override
   public SearchAnalyzer addAll(final String name, final Collection<NondominatedPopulation> results) {
      super.addAll(name, results);
      return this;
   }

   protected void addEffectSizes(final SearchAnalyzerResults results) {
      final List<String> algorithms = results.getAlgorithms();
      for(final String indicator : results.getIndicators()) {
         for(int i = 0; i < algorithms.size() - 1; i++) {
            for(int j = i + 1; j < algorithms.size(); j++) {
               final String leftAlgorithm = algorithms.get(i);
               final String rightAlgorithm = algorithms.get(j);
               final SearchAlgorithmResult leftAlgorithmResults = results.get(leftAlgorithm);
               final SearchAlgorithmResult rightAlgorithmResults = results.get(rightAlgorithm);
               final SearchIndicatorResult leftIndicatorResults = leftAlgorithmResults.get(indicator);
               final SearchIndicatorResult rightIndicatorResults = rightAlgorithmResults.get(indicator);
               if(leftIndicatorResults != null) {
                  leftIndicatorResults.addAlgorithmEffectSize(CohensDEffectSize.calculate(rightAlgorithm,
                        leftIndicatorResults.getValues(), rightIndicatorResults.getValues()));
                  leftIndicatorResults.addAlgorithmEffectSize(CliffsDeltaEffectSize.calculate(rightAlgorithm,
                        leftIndicatorResults.getValues(), rightIndicatorResults.getValues()));
                  leftIndicatorResults.addAlgorithmEffectSize(VarghaDelaneyAEffectSize.calculate(rightAlgorithm,
                        leftIndicatorResults.getValues(), rightIndicatorResults.getValues()));
               }
               if(rightIndicatorResults != null) {
                  rightIndicatorResults.addAlgorithmEffectSize(CohensDEffectSize.calculate(leftAlgorithm,
                        rightIndicatorResults.getValues(), leftIndicatorResults.getValues()));
                  rightIndicatorResults.addAlgorithmEffectSize(CliffsDeltaEffectSize.calculate(leftAlgorithm,
                        rightIndicatorResults.getValues(), leftIndicatorResults.getValues()));
                  rightIndicatorResults.addAlgorithmEffectSize(VarghaDelaneyAEffectSize.calculate(leftAlgorithm,
                        rightIndicatorResults.getValues(), leftIndicatorResults.getValues()));
               }
            }
         }
      }
   }

   @Override
   public SearchAnalyzer clear() {
      super.clear();
      return this;
   }

   @Override
   public AnalyzerResults getAnalysis() {
      try {
         return super.getAnalysis();
      } catch(final IllegalArgumentException e) {
         return null;
      }
   }

   @SuppressWarnings("unchecked")
   public Map<String, List<NondominatedPopulation>> getData() {
      try {
         return (Map<String, List<NondominatedPopulation>>) dataField.get(this);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         return null;
      }
   }

   // methods overrides for this analyzer return type

   protected void getPrivateFields() {
      try {
         dataField = getClass().getSuperclass().getDeclaredField("data");
         dataField.setAccessible(true);

         statisticsField = getClass().getSuperclass().getDeclaredField("statistics");
         statisticsField.setAccessible(true);

         showAggregateField = getClass().getSuperclass().getDeclaredField("showAggregate");
         showAggregateField.setAccessible(true);

         showStatisticalSignificanceField = getClass().getSuperclass().getDeclaredField("showStatisticalSignificance");
         showStatisticalSignificanceField.setAccessible(true);

         showIndividualValuesField = getClass().getSuperclass().getDeclaredField("showIndividualValues");
         showIndividualValuesField.setAccessible(true);

      } catch(NoSuchFieldException | SecurityException | IllegalArgumentException e) {
         e.printStackTrace();
      }
   }

   public SearchAnalyzerResults getSearchAnalysis() {
      final SearchAnalyzerResults analyzerResults = new SearchAnalyzerResults(getAnalysis());
      if(isShowStatisticalSignificance()) {
         addEffectSizes(analyzerResults);
      }
      return analyzerResults;
   }

   @SuppressWarnings("unchecked")
   public List<UnivariateStatistic> getStatistics() {
      try {
         return (List<UnivariateStatistic>) statisticsField.get(this);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         return new ArrayList<>();
      }
   }

   @Override
   public SearchAnalyzer includeAdditiveEpsilonIndicator() {
      super.includeAdditiveEpsilonIndicator();
      return this;
   }

   @Override
   public SearchAnalyzer includeAllMetrics() {
      super.includeAllMetrics();
      return this;
   }

   @Override
   public SearchAnalyzer includeContribution() {
      super.includeContribution();
      return this;
   }

   @Override
   public SearchAnalyzer includeGenerationalDistance() {
      super.includeGenerationalDistance();
      return this;
   }

   @Override
   public SearchAnalyzer includeHypervolume() {
      super.includeHypervolume();
      return this;
   }

   @Override
   public SearchAnalyzer includeInvertedGenerationalDistance() {
      super.includeInvertedGenerationalDistance();
      return this;
   }

   @Override
   public SearchAnalyzer includeMaximumParetoFrontError() {
      super.includeMaximumParetoFrontError();
      return this;
   }

   @Override
   public SearchAnalyzer includeSpacing() {
      super.includeSpacing();
      return this;
   }

   public boolean isShowAggregate() {
      try {
         return showAggregateField.getBoolean(this);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         return Boolean.TRUE;
      }
   }

   public boolean isShowIndividualValues() {
      try {
         return showIndividualValuesField.getBoolean(this);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         return Boolean.TRUE;
      }
   }

   public boolean isShowStatisticalSignificance() {
      try {
         return showStatisticalSignificanceField.getBoolean(this);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         return Boolean.TRUE;
      }
   }

   @Override
   public SearchAnalyzer loadAs(final String name, final File resultFile) throws IOException {
      super.loadAs(name, resultFile);
      return this;
   }

   @Override
   public SearchAnalyzer loadData(final File directory, final String prefix, final String suffix) throws IOException {
      super.loadData(directory, prefix, suffix);
      return this;
   }

   @Override
   public SearchAnalyzer printAnalysis() {
      printAnalysis(System.out);
      return this;
   }

   @Override
   public SearchAnalyzer printAnalysis(final PrintStream ps) {
      getSearchAnalysis().print(ps, isShowAggregate(), isShowStatisticalSignificance(), isShowIndividualValues(),
            getStatistics());
      return this;
   }

   @Override
   public SearchAnalyzer saveAnalysis(final File file) throws IOException {
      file.getParentFile().mkdirs();
      super.saveAnalysis(file);
      return this;
   }

   @Override
   public SearchAnalyzer saveAs(final String name, final File resultFile) throws IOException {
      super.saveAs(name, resultFile);
      return this;
   }

   @Override
   public SearchAnalyzer saveData(final File directory, final String prefix, final String suffix) throws IOException {
      super.saveData(directory, prefix, suffix);
      return this;
   }

   public SearchAnalyzer saveIndicatorBoxPlots(final String directory) {
      return saveIndicatorBoxPlots(directory, null);
   }

   public SearchAnalyzer saveIndicatorBoxPlots(final String directory, final String baseName) {
      FileUtil.checkDirectory(directory);
      final SearchAnalyzerResults results = getSearchAnalysis();
      String fileName = baseName;
      if(fileName != null && !fileName.isEmpty()) {
         fileName += "_";
      } else {
         fileName = "";
      }
      for(final String indicator : results.getIndicators()) {
         SearchBoxPlot.saveIndicatorChart(indicator, results,
               FileUtil.createFile(directory, fileName + indicator + ".png"));
      }
      return this;
   }

   @Override
   public SearchAnalyzer saveReferenceSet(final File file) throws IOException {
      super.saveReferenceSet(file);
      return this;
   }

   @Override
   public SearchAnalyzer showAggregate() {
      super.showAggregate();
      return this;
   }

   @Override
   public SearchAnalyzer showAll() {
      super.showAll();
      return this;
   }

   @Override
   public SearchAnalyzer showIndividualValues() {
      super.showIndividualValues();
      return this;
   }

   @Override
   public SearchAnalyzer showStatistic(final UnivariateStatistic statistic) {
      super.showStatistic(statistic);
      return this;
   }

   @Override
   public SearchAnalyzer showStatisticalSignificance() {
      super.showStatisticalSignificance();
      return this;
   }

   @Override
   public SearchAnalyzer usingProblemFactory(final ProblemFactory problemFactory) {
      super.usingProblemFactory(problemFactory);
      return this;
   }

   @Override
   public SearchAnalyzer withEpsilon(final double... epsilon) {
      super.withEpsilon(epsilon);
      return this;
   }

   public <S extends Solution> SearchAnalyzer withProblem(final ISearchProblem<S> problem) {
      super.withProblemClass(problem.getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());
      return this;
   }

   @Override
   public SearchAnalyzer withProblem(final String problemName) {
      super.withProblem(problemName);
      return this;
   }

   @Override
   public SearchAnalyzer withProblemClass(final Class<?> problemClass, final Object... problemArguments) {
      super.withProblemClass(problemClass, problemArguments);
      return this;
   }

   @Override
   public SearchAnalyzer withProblemClass(final String problemClassName, final Object... problemArguments)
         throws ClassNotFoundException {
      super.withProblemClass(problemClassName, problemArguments);
      return this;
   }

   @Override
   public SearchAnalyzer withReferenceSet(final File referenceSetFile) {
      super.withReferenceSet(referenceSetFile);
      return this;
   }

   public SearchAnalyzer withSameProblemAs(final Executor builder) {
      super.withSameProblemAs(builder);
      return this;
   }

   public SearchAnalyzer withSameProblemAs(final Instrumenter builder) {
      super.withSameProblemAs(builder);
      return this;
   }

   public SearchAnalyzer withSameProblemAs(final org.moeaframework.Analyzer builder) {
      super.withSameProblemAs(builder);
      return this;
   }

   @Override
   public SearchAnalyzer withSignifianceLevel(final double significanceLevel) {
      super.withSignifianceLevel(significanceLevel);
      return this;
   }
}
