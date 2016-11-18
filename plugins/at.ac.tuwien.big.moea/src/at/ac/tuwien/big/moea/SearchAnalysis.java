package at.ac.tuwien.big.moea;

import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.moeaframework.core.NondominatedPopulation;

public class SearchAnalysis extends IndicatorConfiguration {
   public static final double SIGNIFICANCE_ONE_PERCENT = 0.01;
   public static final double SIGNIFICANCE_FIVE_PERCENT = 0.05;

   protected SearchExperiment<?> experiment;
   protected Map<String, List<String>> grouping = new HashMap<>();

   protected double significanceLevel = SIGNIFICANCE_FIVE_PERCENT;

   protected boolean showStatisticalSignificance;
   protected boolean showAggregate;
   protected boolean showIndividualValues;

   protected boolean maximumParetoFrontError;

   protected List<UnivariateStatistic> statistics = new ArrayList<>();

   public SearchAnalysis() {}

   public SearchAnalysis(final SearchExperiment<?> experiment) {
      setExperiment(experiment);
   }

   public SearchAnalysis addGrouping(final String groupName, final String... algorithmNames) {
      for(final String algorithmName : algorithmNames) {
         List<String> groups = grouping.get(algorithmName);
         if(groups == null) {
            groups = new ArrayList<>();
         }
         groups.add(groupName);
         grouping.put(algorithmName, groups);
      }
      return this;
   }

   public void addStatistic(final UnivariateStatistic statistic) {
      getStatistics().add(statistic);
   }

   public SearchAnalyzer analyze() {
      final SearchAnalyzer analyzer = createAnalyzer();
      final Map<SearchExecutor, List<NondominatedPopulation>> results = getResults();

      for(final Entry<SearchExecutor, List<NondominatedPopulation>> result : results.entrySet()) {
         for(final String group : getAnalysisGroups(result)) {
            analyzer.addAll(group, result.getValue());
         }
      }
      return analyzer;
   }

   public SearchAnalyzer analyze(final PrintStream ps) {
      final SearchAnalyzer analyzer = createAnalyzer();
      final Map<SearchExecutor, List<NondominatedPopulation>> results = getResults();

      for(final Entry<SearchExecutor, List<NondominatedPopulation>> result : results.entrySet()) {
         for(final String group : getAnalysisGroups(result)) {
            analyzer.addAll(group, result.getValue());
         }
      }

      analyzer.printAnalysis(ps);
      return analyzer;
   }

   protected SearchAnalyzer createAnalyzer() {
      final SearchAnalyzer analyzer = new SearchAnalyzer(getExperiment().getSearchOrchestration().createProblem());
      analyzer.withEpsilon(getExperiment().getEpsilon());
      analyzer.withReferenceSet(getExperiment().getReferenceSetFile());
      analyzer.withSignifianceLevel(getSignificanceLevel());

      if(isAdditiveEpsilonIndicator()) {
         analyzer.includeAdditiveEpsilonIndicator();
      }

      if(isContribution()) {
         analyzer.includeContribution();
      }

      if(isGenerationalDistance()) {
         analyzer.includeGenerationalDistance();
      }

      if(isHypervolume()) {
         analyzer.includeHypervolume();
      }

      if(isInvertedGenerationalDistance()) {
         analyzer.includeInvertedGenerationalDistance();
      }

      if(isR1()) {
         analyzer.includeR1();
      }

      if(isR2()) {
         analyzer.includeR2();
      }

      if(isR3()) {
         analyzer.includeR3();
      }

      if(isSpacing()) {
         analyzer.includeSpacing();
      }

      if(isMaximumParetoFrontError()) {
         analyzer.includeMaximumParetoFrontError();
      }

      if(isShowAggregate()) {
         analyzer.showAggregate();
      }

      if(isShowIndividualValues()) {
         analyzer.showIndividualValues();
      }

      if(isShowStatisticalSignificance()) {
         analyzer.showStatisticalSignificance();
      }

      for(final UnivariateStatistic statistic : getStatistics()) {
         analyzer.showStatistic(statistic);
      }

      return analyzer;
   }

   protected List<String> getAnalysisGroups(final Entry<SearchExecutor, List<NondominatedPopulation>> result) {
      return getAnalysisGroups(result.getKey());
   }

   protected List<String> getAnalysisGroups(final SearchExecutor executor) {
      List<String> groups = grouping.get(executor.getName());
      if(groups == null || groups.isEmpty()) {
         groups = new ArrayList<>();
         groups.add(executor.getName());
      }
      return groups;
   }

   public SearchExperiment<?> getExperiment() {
      return experiment;
   }

   public Map<SearchExecutor, List<NondominatedPopulation>> getResults() {
      if(!getExperiment().hasResults()) {
         getExperiment().run();
      }
      return getExperiment().getResults();
   }

   public double getSignificanceLevel() {
      return significanceLevel;
   }

   public List<UnivariateStatistic> getStatistics() {
      return statistics;
   }

   public boolean isMaximumParetoFrontError() {
      return maximumParetoFrontError;
   }

   public boolean isShowAggregate() {
      return showAggregate;
   }

   public boolean isShowIndividualValues() {
      return showIndividualValues;
   }

   public boolean isShowStatisticalSignificance() {
      return showStatisticalSignificance;
   }

   @Override
   public void setAllIndicators(final boolean allIndicators) {
      super.setAllIndicators(allIndicators);
      setMaximumParetoFrontError(allIndicators);
   }

   public void setExperiment(final SearchExperiment<?> experiment) {
      this.experiment = experiment;
   }

   public void setMaximumParetoFrontError(final boolean maximumParetoFrontError) {
      this.maximumParetoFrontError = maximumParetoFrontError;
   }

   public void setShowAggregate(final boolean showAggregate) {
      this.showAggregate = showAggregate;
   }

   public void setShowAll(final boolean showAll) {
      setShowAggregate(showAll);
      setShowIndividualValues(showAll);
      setShowStatisticalSignificance(showAll);
   }

   public void setShowIndividualValues(final boolean showIndividualValues) {
      this.showIndividualValues = showIndividualValues;
   }

   public void setShowStatisticalSignificance(final boolean showStatisticalSignificance) {
      this.showStatisticalSignificance = showStatisticalSignificance;
   }

   public void setSignificanceLevel(final double significanceLevel) {
      this.significanceLevel = significanceLevel;
   }

   public void setStatistics(final List<UnivariateStatistic> statistics) {
      this.statistics = statistics;
   }

}
