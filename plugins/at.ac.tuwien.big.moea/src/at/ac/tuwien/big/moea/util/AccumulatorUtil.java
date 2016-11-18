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
package at.ac.tuwien.big.moea.util;

import java.io.Serializable;
import java.util.List;

import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.analysis.collector.AdaptiveTimeContinuationCollector;
import org.moeaframework.analysis.collector.ApproximationSetCollector;
import org.moeaframework.analysis.collector.ElapsedTimeCollector;
import org.moeaframework.analysis.collector.EpsilonProgressCollector;
import org.moeaframework.analysis.collector.IndicatorCollector;
import org.moeaframework.analysis.collector.InstrumentedAlgorithm;
import org.moeaframework.analysis.collector.PopulationSizeCollector;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.experiment.instrumenter.collector.LocalBestFitnessCollector;
import at.ac.tuwien.big.moea.experiment.instrumenter.collector.SimpleBestSolutionCollector;

public class AccumulatorUtil {
	
	public static Serializable getAccumulatorData(Accumulator accumulator, String key, int index) {
		if(accumulator == null)
			return null;
		try {
			return accumulator.get(key, index);
		} catch(IllegalArgumentException | IndexOutOfBoundsException e) {
			/**
			 * IllegalArgumentException - if the key was not contained in this accumulator
			 * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size(key))
			 */
			return null;
		}
	}
	
	public static <T extends Object> T getAccumulatorData(Accumulator accumulator, String key, int index, Class<T> clazz) {
		return CastUtil.asClass(getAccumulatorData(accumulator, key, index), clazz);
	}
	
	public static Serializable getLatestAccumulatorData(Accumulator accumulator, String key) {
		try {
			return getAccumulatorData(accumulator, key, accumulator.size(key) - 1);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	public static <T extends Object> T getLatestAccumulatorData(Accumulator accumulator, String key, Class<T> clazz) {
		return CastUtil.asClass(getLatestAccumulatorData(accumulator, key), clazz);
	}	
	
	public static <T extends Serializable> T getLatestAccumulatorData(Instrumenter instrumenter, String key, Class<T> clazz) {
		return CastUtil.asClass(getLatestAccumulatorData(instrumenter, key), clazz);
	}
	
	public static <T extends Serializable> T getLatestAccumulatorData(Executor executor, String key, Class<T> clazz) {
		return CastUtil.asClass(getLatestAccumulatorData(executor, key), clazz);
	}
	
	public static Serializable getLatestAccumulatorData(Instrumenter instrumenter, String key) {
		if(instrumenter == null)
			return null;
		return getLatestAccumulatorData(instrumenter.getLastAccumulator(), key);
	}	
	
	public static Serializable getLatestAccumulatorData(Executor executor, String key) {
		if(executor == null)
			return null;
		return getLatestAccumulatorData(executor.getInstrumenter(), key);
	}
	
	public static boolean hasAccumulatorData(Executor executor, String key) {
		if(executor == null)
			return false;
		return hasAccumulatorData(executor.getInstrumenter(), key);
	}
	
	public static boolean hasAccumulatorData(Instrumenter instrumenter, String key) {
		if(instrumenter == null)
			return false;
		return hasAccumulatorData(instrumenter.getLastAccumulator(), key);
	}
	
	public static boolean hasAccumulatorData(Accumulator accumulator, String key) {
		if(accumulator == null)
			return false;
		try {
			return accumulator.keySet().contains(key);
		} catch(Exception e) {
			return false;
		}
	}
	
	public static Integer getNumberOfEvaluations(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.NUMBER_OF_EVALUATIONS, index, Integer.class);
	}
	
	public static Integer getLatestNumberOfEvaluations(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.NUMBER_OF_EVALUATIONS, Integer.class);
	}
	
	public static Integer getPopulationSize(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.POPULATION_SIZE, index, Integer.class);
	}
	
	public static Integer getLatestPopulationSize(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.POPULATION_SIZE, Integer.class);
	}
	
	public static Integer getArchiveSize(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.ARCHIVE_SIZE, index, Integer.class);
	}
	
	public static Integer getLatestArchiveSize(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.ARCHIVE_SIZE, Integer.class);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Solution> getApproximationSet(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.APPROXIMATION_SET, index, List.class);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Solution> getLatestApproximationSet(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.APPROXIMATION_SET, List.class);
	}
	
	public static Double getElapsedTime(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.ELAPSED_TIME, index, Double.class);
	}
	
	public static Double getLatestElapsedTime(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.ELAPSED_TIME, Double.class);
	}
	
	public static Integer getNumberOfRestarts(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.NUMBER_OF_RESTARTS, index, Integer.class);
	}
	
	public static Integer getLatestNumberOfRestarts(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.NUMBER_OF_RESTARTS, Integer.class);
	}
	
	public static Integer getNumberOfImprovements(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.NUMBER_OF_IMPROVEMENTS, index, Integer.class);
	}
	
	public static Integer getLatestNumberOfImprovements(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.NUMBER_OF_IMPROVEMENTS, Integer.class);
	}
	
	public static Integer getNumberOfDominatingImprovements(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.NUMBER_OF_DOMINATING_IMPROVEMENTS, index, Integer.class);
	}
	
	public static Integer getLatestNumberOfDominatingImprovements(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.NUMBER_OF_DOMINATING_IMPROVEMENTS, Integer.class);
	}
	
	public static Double getAdditiveEpsilon(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.INDICATOR_ADDITIVE_EPSILON, index, Double.class);
	}
	
	public static Double getLatestAdditiveEpsilon(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.INDICATOR_ADDITIVE_EPSILON, Double.class);
	}
	
	public static Double getContribution(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.INDICATOR_CONTRIBUTION, index, Double.class);
	}
	
	public static Double getLatestContribution(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.INDICATOR_CONTRIBUTION, Double.class);
	}
	
	public static Double getGenerationalDistance(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.INDICATOR_GENERATIONAL_DISTANCE, index, Double.class);
	}
	
	public static Double getLatestGenerationalDistance(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.INDICATOR_GENERATIONAL_DISTANCE, Double.class);
	}
	
	public static Double getHypervolume(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.INDICATOR_HYPERVOLUME, index, Double.class);
	}
	
	public static Double getLatestHypervolume(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.INDICATOR_HYPERVOLUME, Double.class);
	}
	
	public static Double getInvertedGenerationalDistance(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.INDICATOR_INVERTED_GENERATIONAL_DISTANCE, index, Double.class);
	}
	
	public static Double getLatestInvertedGenerationalDistance(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.INDICATOR_INVERTED_GENERATIONAL_DISTANCE, Double.class);
	}
	
	public static Double getSpacing(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.INDICATOR_SPACING, index, Double.class);
	}
	
	public static Double getLatestSpacing(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.INDICATOR_SPACING, Double.class);
	}
	
	public static Solution getBestSolution(Accumulator accumulator, int index) {
		return getAccumulatorData(accumulator, Keys.SIMPLE_BEST_SOLUTION, index, Solution.class);
	}
	
	public static Solution getLatestBestSolution(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.SIMPLE_BEST_SOLUTION, Solution.class);
	}
	
	public static Solution getLatestBestSolution(Executor executor) {
		return getLatestAccumulatorData(executor, Keys.SIMPLE_BEST_SOLUTION, Solution.class);
	}
	
	public static Solution getLatestAlgorithm(Accumulator accumulator) {
		return getLatestAccumulatorData(accumulator, Keys.ALGORITHM, Solution.class);
	}
	
	public static Solution getLatestAlgorithm(Executor executor) {
		return getLatestAccumulatorData(executor, Keys.ALGORITHM, Solution.class);
	}
	
	public class Keys {
	
		/**
		 * from {@link InstrumentedAlgorithm#doAction()} 
		 * 
		 * @see InstrumentedAlgorithm#doAction()
		 */
		public static final String NUMBER_OF_EVALUATIONS = "NFE";
		
		/**
		 * from {@link PopulationSizeCollector#collect(Accumulator)}
		 */
		public static final String POPULATION_SIZE = "Population Size";
		
		/**
		 * from {@link PopulationSizeCollector#collect(Accumulator)}
		 */
		public static final String ARCHIVE_SIZE = "Archive Size";
		
		/**
		 * from {@link ApproximationSetCollector#collect(Accumulator)}
		 */
		public static final String APPROXIMATION_SET = "Approximation Set";
		
		/**
		 * from {@link ElapsedTimeCollector#collect(Accumulator)}
		 */
		public static final String ELAPSED_TIME = "Elapsed Time";
		
		/**
		 * from {@link AdaptiveTimeContinuationCollector#collect(Accumulator)}
		 */
		public static final String NUMBER_OF_RESTARTS = "Number of Restarts";
		
		/**
		 * from {@link EpsilonProgressCollector#collect(Accumulator)}
		 */
		public static final String NUMBER_OF_IMPROVEMENTS = "Number of Improvements";
		
		/**
		 * from {@link EpsilonProgressCollector#collect(Accumulator)}
		 */
		public static final String NUMBER_OF_DOMINATING_IMPROVEMENTS = "Number of Dominating Improvements";
		
		/**
		 * from {@link IndicatorCollector#collect(Accumulator)}
		 * as defined by {@link Instrumenter#instrument(org.moeaframework.core.Algorithm)}
		 */
		public static final String INDICATOR_CONTRIBUTION = "Contribution";
		
		/**
		 * from {@link IndicatorCollector#collect(Accumulator)}
		 * as defined by {@link Instrumenter#instrument(org.moeaframework.core.Algorithm)}
		 */
		public static final String INDICATOR_ADDITIVE_EPSILON = "AdditiveEpsilonIndicator";
		
		/**
		 * from {@link IndicatorCollector#collect(Accumulator)}
		 * as defined by {@link Instrumenter#instrument(org.moeaframework.core.Algorithm)}
		 */
		public static final String INDICATOR_SPACING = "Spacing";
		
		/**
		 * from {@link IndicatorCollector#collect(Accumulator)}
		 * as defined by {@link Instrumenter#instrument(org.moeaframework.core.Algorithm)}
		 */
		public static final String INDICATOR_INVERTED_GENERATIONAL_DISTANCE = "InvertedGenerationalDistance";
		
		/**
		 * from {@link IndicatorCollector#collect(Accumulator)}
		 * as defined by {@link Instrumenter#instrument(org.moeaframework.core.Algorithm)}
		 */
		public static final String INDICATOR_GENERATIONAL_DISTANCE = "GenerationalDistance";
		
		/**
		 * from {@link IndicatorCollector#collect(Accumulator)}
		 * as defined by {@link Instrumenter#instrument(org.moeaframework.core.Algorithm)}
		 */
		public static final String INDICATOR_HYPERVOLUME = "Hypervolume";
		
		/**
		 * from {@link SimpleBestSolutionCollector#collect(Accumulator)}
		 */
		public static final String SIMPLE_BEST_SOLUTION = "SimpleBestSolution";
		
		/**
		 * from {@link LocalBestFitnessCollector#collect(Accumulator)}
		 */
		public static final String LOCAL_BEST_FITNESS = "LocalBestFitness";
		
		/**
		 * from {@link AlgorithmCollector#collect(Accumulator)}
		 */
		public static final String ALGORITHM = "Algorithm";
	}
}
