/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.moea.experiment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.moeaframework.Executor;
import org.moeaframework.analysis.collector.Collector;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.util.progress.ProgressListener;

import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.listener.AccumulatorProgressListener;
import at.ac.tuwien.big.moea.ui.MetricPlotter;

@Deprecated
public class OldExperiment {
	protected SearchAnalyzer analyzer;
	protected MetricPlotter metricPlotter;
	protected Map<String, Executor> executors = new HashMap<>();
	protected Map<String, String> executorAnalysis = new HashMap<>();
	protected List<ProgressListener> progressListeners = new ArrayList<>();
	protected List<Collector> collectors = new ArrayList<>();
	protected File referenceFile;
	
	protected boolean useAdaptiveMultimethodVariationCollector;
	protected boolean useAdaptiveTimeContinuationCollector;
	protected boolean useAdditiveEpsilonIndicatorCollector;
	protected boolean useApproximationSetCollector;
	protected boolean useContributionCollector;
	protected boolean useElapsedTimeCollector;
	protected boolean useEpsilonProgressCollector;
	protected boolean useGenerationalDistanceCollector;
	protected boolean useHypervolumeCollector;
	protected boolean useInvertedGenerationalDistanceCollector;
	protected boolean usePopulationSizeCollector;
	protected boolean useSpacingCollector;
	
	protected boolean useR1Collector;
	protected boolean useR2Collector;
	protected boolean useR3Collector;
	
	protected boolean printLogging = false;
	
	public OldExperiment useAnalyzer(SearchAnalyzer analyzer) {
		this.analyzer = analyzer;
		return this;
	}
	
	public SearchAnalyzer getAnalyzer() {
		return analyzer;
	}
	
	public OldExperiment useMetricPlotter(MetricPlotter metricPlotter) {
		this.metricPlotter = metricPlotter;
		return this;
	}
	
	public MetricPlotter getMetricPlotter() {
		return metricPlotter;
	}
	
	public OldExperiment addExecutor(String name, String analysisGroup, Executor executor) {
		executorAnalysis.put(name, analysisGroup);
		executors.put(name, executor);
		return this;
	}
	
	public OldExperiment addExecutor(String name, Executor executor) {
		return addExecutor(name, name, executor);
	}
	
	public boolean hasExecutor(String name) {
		return executors.containsKey(name);
	}
	
	public Executor getExecutor(String name) {
		return executors.get(name);
	}
	
	public Collection<Executor> getExecutors() {
		return executors.values();
	}
	
	public String getAnalysisGroup(String executorName) {
		return executorAnalysis.get(executorName);
	}
		
	public OldExperiment useProgressListener(ProgressListener listener) {
		progressListeners.add(listener);
		return this;
	}
	
	public OldExperiment useProgressListener(ProgressListener... listeners) {
		for(ProgressListener listener : listeners)
			this.progressListeners.add(listener);
		return this;
	}
	
	public OldExperiment useProgressListener(Iterable<ProgressListener> listeners) {
		for(ProgressListener listener : listeners)
			this.progressListeners.add(listener);
		return this;
	}
	
	public OldExperiment useCollector(Collector collector) {
		collectors.add(collector);
		return this;
	}
	
	public OldExperiment useCollector(Collector... collectors) {
		for(Collector collector : collectors)
			this.collectors.add(collector);
		return this;
	}
		
	public OldExperiment useAdaptiveMultimethodVariationCollector(boolean useAdaptiveMultimethodVariationCollector) {
		this.useAdaptiveMultimethodVariationCollector = useAdaptiveMultimethodVariationCollector;
		return this;
	}
	
	public boolean usesAdaptiveMultimethodVariationCollector() {
		return useAdaptiveMultimethodVariationCollector;
	}
	
	public OldExperiment useAdaptiveTimeContinuationCollector(boolean useAdaptiveTimeContinuationCollector) {
		this.useAdaptiveTimeContinuationCollector = useAdaptiveTimeContinuationCollector;
		return this;
	}
	
	public boolean usesAdaptiveTimeContinuationCollector() {
		return useAdaptiveTimeContinuationCollector;
	}
	
	public OldExperiment useAdditiveEpsilonIndicatorCollector(boolean useAdditiveEpsilonIndicatorCollector) {
		this.useAdditiveEpsilonIndicatorCollector = useAdditiveEpsilonIndicatorCollector;
		return this;
	}
	
	public boolean usesAdditiveEpsilonIndicatorCollector() {
		return useAdditiveEpsilonIndicatorCollector;
	}
	
	public OldExperiment useApproximationSetCollector(boolean useApproximationSetCollector) {
		this.useApproximationSetCollector = useApproximationSetCollector;
		return this;
	}
	
	public boolean usesApproximationSetCollector() {
		return useApproximationSetCollector;
	}
	
	public OldExperiment useContributionCollector(boolean useContributionCollector) {
		this.useContributionCollector = useContributionCollector;
		return this;
	}
	
	public boolean usesContributionCollector() {
		return useContributionCollector;
	}
	
	public OldExperiment useElapsedTimeCollector(boolean useElapsedTimeCollector) {
		this.useElapsedTimeCollector = useElapsedTimeCollector;
		return this;
	}
	
	public boolean usesElapsedTimeCollector() {
		return useElapsedTimeCollector;
	}
	
	public OldExperiment useEpsilonProgressCollector(boolean useEpsilonProgressCollector) {
		this.useEpsilonProgressCollector = useEpsilonProgressCollector;
		return this;
	}
	
	public boolean usesEpsilonProgressCollector() {
		return useEpsilonProgressCollector;
	}
	
	public OldExperiment useGenerationalDistanceCollector(boolean useGenerationalDistanceCollector) {
		this.useGenerationalDistanceCollector = useGenerationalDistanceCollector;
		return this;
	}
	
	public boolean usesGenerationalDistanceCollector() {
		return useGenerationalDistanceCollector;
	}
	
	public OldExperiment useHypervolumeCollector(boolean useHypervolumeCollector) {
		this.useHypervolumeCollector = useHypervolumeCollector;
		return this;
	}
	
	public boolean usesHypervolumeCollector() {
		return useHypervolumeCollector;
	}
	
	public OldExperiment useInvertedGenerationalDistanceCollector(boolean useInvertedGenerationalDistanceCollector) {
		this.useInvertedGenerationalDistanceCollector = useInvertedGenerationalDistanceCollector;
		return this;
	}
	
	public boolean usesInvertedGenerationalDistanceCollector() {
		return useInvertedGenerationalDistanceCollector;
	}
	
	public OldExperiment usePopulationSizeCollector(boolean usePopulationSizeCollector) {
		this.usePopulationSizeCollector = usePopulationSizeCollector;
		return this;
	}
	
	public boolean usesPopulationSizeCollector() {
		return usePopulationSizeCollector;
	}
	
	public OldExperiment useSpacingCollector(boolean useSpacingCollector) {
		this.useSpacingCollector = useSpacingCollector;
		return this;
	}
	
	public boolean usesSpacingCollector() {
		return useSpacingCollector;
	}
	
	public OldExperiment useR1Collector(boolean useR1Collector) {
		this.useR1Collector = useR1Collector;
		return this;
	}
	
	public boolean usesR1Collector() {
		return useR1Collector;
	}
	
	public OldExperiment useR2Collector(boolean useR2Collector) {
		this.useR2Collector = useR2Collector;
		return this;
	}
	
	public boolean usesR2Collector() {
		return useR2Collector;
	}
	
	public OldExperiment useR3Collector(boolean useR3Collector) {
		this.useR3Collector = useR3Collector;
		return this;
	}
	
	public boolean usesR3Collector() {
		return useR3Collector;
	}
	
	public List<Collector> getCollectors() {
		return collectors;
	}
	
	public List<ProgressListener> getProgressListeners() {
		return progressListeners;
	}
	
	public OldExperiment printLogging(boolean printLogging) {
		this.printLogging = printLogging;
		return this;
	}
	
	public boolean printsLogging() {
		return printLogging;
	}
	
	protected boolean plotMetrics() {
		return getMetricPlotter() != null;
	}
	
	protected Executor attachCollectors(Executor executor) {
		for(Collector collector : Collections.unmodifiableList(getCollectors()))
			executor.getInstrumenter().attach(collector);
		
		if(usesAdaptiveMultimethodVariationCollector())
			executor.getInstrumenter().attachAdaptiveMultimethodVariationCollector();
		
		if(usesAdaptiveTimeContinuationCollector())
			executor.getInstrumenter().attachAdaptiveTimeContinuationCollector();
		
		if(usesAdditiveEpsilonIndicatorCollector())
			executor.getInstrumenter().attachAdditiveEpsilonIndicatorCollector();
		
		if(usesApproximationSetCollector())
			executor.getInstrumenter().attachApproximationSetCollector();
		
		if(usesContributionCollector())
			executor.getInstrumenter().attachContributionCollector();
		
		if(usesElapsedTimeCollector())
			executor.getInstrumenter().attachElapsedTimeCollector();
		
		if(usesEpsilonProgressCollector())
			executor.getInstrumenter().attachEpsilonProgressCollector();
		
		if(usesGenerationalDistanceCollector())
			executor.getInstrumenter().attachEpsilonProgressCollector();
		
		if(usesHypervolumeCollector())
			executor.getInstrumenter().attachHypervolumeCollector();
		
		if(usesInvertedGenerationalDistanceCollector())
			executor.getInstrumenter().attachInvertedGenerationalDistanceCollector();
		
		if(usesPopulationSizeCollector())
			executor.getInstrumenter().attachPopulationSizeCollector();
		
		if(usesSpacingCollector())
			executor.getInstrumenter().attachSpacingCollector();
		
		if(usesR1Collector())
			executor.getInstrumenter().attachR1Collector();
		
		if(usesR2Collector())
			executor.getInstrumenter().attachR2Collector();
		
		if(usesR3Collector())
			executor.getInstrumenter().attachR3Collector();
		
		return executor;
	}
	
	protected Executor attachProgressListeners(Executor executor) {
		for(ProgressListener listener : getProgressListeners())
			executor.withProgressListener(listener);
	
		return executor;
	}
	
	public OldExperiment run(int nrSeeds) {
		AccumulatorProgressListener accumulatorCollector = null;
		if(plotMetrics()) 
			accumulatorCollector = new AccumulatorProgressListener();
		
		SearchAnalyzer analyzer = getAnalyzer();
		
		for(Entry<String, Executor> executorEntry : executors.entrySet()) {
			String name = executorEntry.getKey();
			Executor executor = executorEntry.getValue();
		
			if(analyzer == null) {
				this.analyzer = new SearchAnalyzer().withSameProblemAs(executor);
				analyzer = getAnalyzer();
			}
			
			executor = attachCollectors(executor);
			executor = attachProgressListeners(executor);
			
			if(plotMetrics())
				executor.withProgressListener(accumulatorCollector.reset());
			
			if(printsLogging())
				System.out.println("Executing '" + name + "' " + nrSeeds + " times...");
			
			List<NondominatedPopulation> results = null;
			try {
				results = executor.runSeeds(nrSeeds);
			} catch(Exception e) {
				if(printsLogging())
					System.err.println(e.getMessage());
			}
			if(results != null && printsLogging())
				System.out.println("done.");
			
			if(analyzer != null && results != null)
				analyzer.addAll(getAnalysisGroup(name), results);
			
			if(plotMetrics())
				getMetricPlotter().add(name, accumulatorCollector.getAccumulators());
		}
			
		return this;
	}
	
	public NondominatedPopulation aggregateApproximationSet() {
		if(getAnalyzer() == null)
			return null;
		return getAnalyzer().getApproximationSet();
	}
	
	public NondominatedPopulation getReferenceSet() {
		if(getAnalyzer() == null)
			return null;
		return getAnalyzer().getReferenceSet();
	}
	
	public File saveApproximationSetObjectives(File file) {
		if(getAnalyzer() != null)
			try {
				analyzer.saveApproximationSetObjectives(file);
				if(printsLogging())
					System.out.println("Reference set saved as '" + file + "'.");
			} catch (IOException e) {
				if(printsLogging())
					System.err.println("Problem saving reference file: " + e.getMessage());
			}
		return file;
	}
	
	public File saveApproximationSetObjectives(String fileName) {
		File file = new File(fileName);
		if(getAnalyzer() != null)
			try {
				FileUtils.touch(file);
				analyzer.saveApproximationSetObjectives(file);
				if(printsLogging())
					System.out.println("Reference set saved as '" + file + "'.");
			} catch (IOException e) {
				if(printsLogging())
					System.err.println("Problem saving reference file: " + e.getMessage());
			}
		return file;
	}
	
	public File saveReferenceSet(File file) {
		if(getAnalyzer() != null)
			try {
				analyzer.saveReferenceSet(file);
				if(printsLogging())
					System.out.println("Reference set saved as '" + file + "'.");
			} catch (IOException e) {
				if(printsLogging())
					System.err.println("Problem saving reference file: " + e.getMessage());
			}
		return file;
	}
	
	public File saveReferenceSet(String fileName) {
		File file = new File(fileName);
		try {
			FileUtils.touch(file);
			return saveReferenceSet(file);
		} catch (IOException e) {
			if(printsLogging())
				System.err.println("Problem saving reference file: " + e.getMessage());
			return file;
		}
	}
	
	public void printAnalysis() {
		if(getAnalyzer() == null)
			return;
		try {
			getAnalyzer().printAnalysis();
		} catch (Exception e) {
			if(printsLogging())
				System.err.println("Problem printing analysis: " + e.getMessage());
		}
	}
	
	public void show(boolean showIndividualTraces, String... metrics) {
		if(getMetricPlotter() == null)
			return;
		getMetricPlotter().show(showIndividualTraces, metrics);
	}
}
