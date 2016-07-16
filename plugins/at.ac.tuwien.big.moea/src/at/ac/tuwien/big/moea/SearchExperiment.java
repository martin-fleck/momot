package at.ac.tuwien.big.moea;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.analysis.collector.Collector;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.util.progress.ProgressListener;

import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.moea.experiment.instrumenter.SearchInstrumenter;
import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.util.CastUtil;

public class SearchExperiment<S extends Solution> extends IndicatorConfiguration {

   protected ISearchOrchestration<S> searchOrchestration;

   // instrumentation
   protected File referenceSetFile = null;
   protected int frequency = 100;

   protected List<Collector> customCollectors = new ArrayList<>();
   protected boolean adaptiveMultimethodVariation;
   protected boolean adaptiveTimeContinuation;
   protected boolean approximationSet;
   protected boolean epsilonProgress;
   protected boolean elapsedTime;
   protected boolean populationSize;

   // execution
   protected int maxEvaluations;
   protected double[] epsilon;
   protected List<ProgressListener> progressListeners = new ArrayList<>();

   // run
   protected int numberOfRuns = 1;

   // result
   protected Map<SearchExecutor, List<NondominatedPopulation>> results = new HashMap<>();

   public SearchExperiment() {}

   public SearchExperiment(final ISearchOrchestration<S> searchOrchestration) {
      setSearchOrchestration(searchOrchestration);
   }

   public SearchExperiment(final ISearchOrchestration<S> searchOrchestration, final int maxEvaluations) {
      setSearchOrchestration(searchOrchestration);
      setMaxEvaluations(maxEvaluations);
   }

   public void addCustomCollector(final Collector collector) {
      getCustomCollectors().add(collector);
   }

   public void addProgressListener(final ProgressListener progressListener) {
      this.progressListeners.add(progressListener);
   }

   protected <T extends Executor> T attachProgressListeners(final T executor) {
      for(final ProgressListener listener : getProgressListeners()) {
         executor.withProgressListener(listener);
      }
      return executor;
   }

   protected List<SearchExecutor> createExecutors() {
      final List<SearchExecutor> executors = new ArrayList<>();
      for(final IRegisteredAlgorithm<? extends Algorithm> algorithm : getSearchOrchestration().getAlgorithms()) {
         final SearchExecutor executor = new SearchExecutor(createProblem()).setName(getAlgorithmName(algorithm))
               .withMaxEvaluations(getMaxEvaluations()).withInstrumenter(createInstrumenter())
               .withAlgorithm(algorithm.getRegisteredName()).withEpsilon(getEpsilon()).distributeOnAllCores();
         attachProgressListeners(executor);
         executors.add(executor);
      }
      return executors;
   }

   protected Instrumenter createInstrumenter() {
      final SearchInstrumenter instrumenter = new SearchInstrumenter(createProblem());

      final File referenceFile = getReferenceSetFile();
      if(referenceFile != null) {
         instrumenter.withReferenceSet(referenceFile);
      }

      instrumenter.withFrequency(getFrequency());
      instrumenter.withEpsilon(getEpsilon());

      if(isAdaptiveMultimethodVariation()) {
         instrumenter.attachAdaptiveMultimethodVariationCollector();
      }

      if(isAdaptiveTimeContinuation()) {
         instrumenter.attachAdaptiveTimeContinuationCollector();
      }

      if(isAdditiveEpsilonIndicator()) {
         instrumenter.attachAdditiveEpsilonIndicatorCollector();
      }

      if(isApproximationSet()) {
         instrumenter.attachApproximationSetCollector();
      }

      if(isContribution()) {
         instrumenter.attachContributionCollector();
      }

      if(isElapsedTime()) {
         instrumenter.attachElapsedTimeCollector();
      }

      if(isEpsilonProgress()) {
         instrumenter.attachEpsilonProgressCollector();
      }

      if(isGenerationalDistance()) {
         instrumenter.attachGenerationalDistanceCollector();
      }

      if(isHypervolume()) {
         instrumenter.attachHypervolumeCollector();
      }

      if(isInvertedGenerationalDistance()) {
         instrumenter.attachInvertedGenerationalDistanceCollector();
      }

      if(isPopulationSize()) {
         instrumenter.attachPopulationSizeCollector();
      }

      if(isR1()) {
         instrumenter.attachR1Collector();
      }

      if(isR2()) {
         instrumenter.attachR2Collector();
      }

      if(isR3()) {
         instrumenter.attachR3Collector();
      }

      if(isSpacing()) {
         instrumenter.attachSpacingCollector();
      }

      for(final Collector collector : customCollectors) {
         instrumenter.attach(collector);
      }

      return instrumenter;
   }

   protected ISearchProblem<?> createProblem() {
      return getSearchOrchestration().createProblem();
   }

   protected String getAlgorithmName(final IRegisteredAlgorithm<? extends Algorithm> algorithm) {
      return getSearchOrchestration().getAlgorithmName(algorithm);
   }

   public List<Collector> getCustomCollectors() {
      return customCollectors;
   }

   public double[] getEpsilon() {
      return epsilon;
   }

   public int getFrequency() {
      return frequency;
   }

   public int getMaxEvaluations() {
      return maxEvaluations;
   }

   public int getNumberOfRuns() {
      return numberOfRuns;
   }

   public List<ProgressListener> getProgressListeners() {
      return progressListeners;
   }

   public File getReferenceSetFile() {
      return referenceSetFile;
   }

   public Map<SearchExecutor, List<NondominatedPopulation>> getResults() {
      return results;
   }

   public ISearchOrchestration<S> getSearchOrchestration() {
      return searchOrchestration;
   }

   public boolean hasResults() {
      return !results.isEmpty();
   }

   public boolean isAdaptiveMultimethodVariation() {
      return adaptiveMultimethodVariation;
   }

   public boolean isAdaptiveTimeContinuation() {
      return adaptiveTimeContinuation;
   }

   public boolean isApproximationSet() {
      return approximationSet;
   }

   public boolean isElapsedTime() {
      return elapsedTime;
   }

   public boolean isEpsilonProgress() {
      return epsilonProgress;
   }

   public boolean isPopulationSize() {
      return populationSize;
   }

   public Map<SearchExecutor, List<NondominatedPopulation>> run() {
      return run(getNumberOfRuns());
   }

   public Map<SearchExecutor, List<NondominatedPopulation>> run(final int nrRuns) {
      if(getMaxEvaluations() == 0) {
         System.err
               .println("Warning: Missing maximum number of evaluations in experiment. No search will be executed.");
      }

      final List<SearchExecutor> executors = createExecutors();

      for(final SearchExecutor executor : executors) {
         System.out.println("Run '" + executor.getName() + "' " + nrRuns + " times...");
         results.put(executor, executor.runSeeds(nrRuns));
      }
      return results;
   }

   public void setAdaptiveMultimethodVariation(final boolean adaptiveMultimethodVariation) {
      this.adaptiveMultimethodVariation = adaptiveMultimethodVariation;
   }

   public void setAdaptiveTimeContinuation(final boolean adaptiveTimeContinuation) {
      this.adaptiveTimeContinuation = adaptiveTimeContinuation;
   }

   public void setAllCollectors(final boolean all) {
      setAllIndicators(all);
      setAdaptiveMultimethodVariation(all);
      setAdaptiveTimeContinuation(all);
      setApproximationSet(all);
      setEpsilonProgress(all);
      setElapsedTime(all);
      setPopulationSize(all);
   }

   public void setApproximationSet(final boolean approximationSet) {
      this.approximationSet = approximationSet;
   }

   public void setCustomCollectors(final List<Collector> customCollectors) {
      this.customCollectors = customCollectors;
   }

   public void setElapsedTime(final boolean elapsedTime) {
      this.elapsedTime = elapsedTime;
   }

   public void setEpsilon(final double... epsilon) {
      this.epsilon = epsilon;
   }

   public void setEpsilonProgress(final boolean epsilonProgress) {
      this.epsilonProgress = epsilonProgress;
   }

   public void setFrequency(final int frequency) {
      this.frequency = frequency;
   }

   public void setMaxEvaluations(final int maxEvaluations) {
      this.maxEvaluations = maxEvaluations;
   }

   public void setNumberOfRuns(final int numberOfRuns) {
      this.numberOfRuns = numberOfRuns;
   }

   public void setPopulationSize(final boolean populationSize) {
      this.populationSize = populationSize;
   }

   public void setProgressListeners(final List<ProgressListener> progressListeners) {
      this.progressListeners = progressListeners;
   }

   public void setReferenceSetFile(final File referenceSetFile) {
      this.referenceSetFile = referenceSetFile;
   }

   public void setReferenceSetFile(final String referenceSetFileUri) {
      this.referenceSetFile = CastUtil.asFile(referenceSetFileUri);
   }

   public void setSearchOrchestration(final ISearchOrchestration<S> searchOrchestration) {
      this.searchOrchestration = searchOrchestration;
   }
}
