package at.ac.tuwien.big.moea.experiment.analyzer;

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

import at.ac.tuwien.big.moea.experiment.analyzer.chart.SearchBoxPlot;
import at.ac.tuwien.big.moea.experiment.analyzer.statistic.EffectSize;
import at.ac.tuwien.big.moea.problem.IParetoFrontStoringSearchProblem;
import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.util.FileUtil;

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
			
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, List<NondominatedPopulation>> getData() {
		try {
			return (Map<String, List<NondominatedPopulation>>) dataField.get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UnivariateStatistic> getStatistics() {
		try {
			return (List<UnivariateStatistic>) statisticsField.get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return new ArrayList<>();
		}
	}
	
	public boolean isShowAggregate() {
		try {
			return showAggregateField.getBoolean(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return Boolean.TRUE;
		}
	}
	
	public boolean isShowStatisticalSignificance() {
		try {
			return showStatisticalSignificanceField.getBoolean(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return Boolean.TRUE;
		}
	}
	
	public boolean isShowIndividualValues() {
		try {
			return showIndividualValuesField.getBoolean(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return Boolean.TRUE;
		}
	}
	
	public SearchAnalyzer(ISearchProblem<?> problem) {
		this();
		withProblem(problem);
	}
	
	// methods overrides for this analyzer return type
	
	@Override
	public SearchAnalyzer add(String name,
			NondominatedPopulation result) {
		super.add(name, result);
		return this;
	}
	
	@Override
	public SearchAnalyzer addAll(String name,
			Collection<NondominatedPopulation> results) {
		super.addAll(name, results);
		return this;
	}
	
	@Override
	public SearchAnalyzer clear() {
		super.clear();
		return this;
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
	
	@Override
	public SearchAnalyzer loadAs(String name, File resultFile)
			throws IOException {
		super.loadAs(name, resultFile);
		return this;
	}
	
	@Override
	public SearchAnalyzer loadData(File directory, String prefix,
			String suffix) throws IOException {
		super.loadData(directory, prefix, suffix);
		return this;
	}
	
	@Override
	public SearchAnalyzer printAnalysis() {
		printAnalysis(System.out);
		return this;
	}
	
	@Override
	public SearchAnalyzer printAnalysis(PrintStream ps) {
		getSearchAnalysis().print(
				ps, 
				isShowAggregate(), 
				isShowStatisticalSignificance(), 
				isShowIndividualValues(), 
				getStatistics());
		return this;
	}
	
	public SearchAnalyzer saveIndicatorBoxPlots(String directory, String baseName) {
		FileUtil.checkDirectory(directory);
		SearchAnalyzerResults results = getSearchAnalysis();
		if(baseName != null && !baseName.isEmpty())
			baseName += "_";
		else
			baseName = "";
		for(String indicator : results.getIndicators()) {
			SearchBoxPlot.saveIndicatorChart(indicator, results, 
					FileUtil.createFile(directory, baseName + indicator + ".png"));
		}
		return this;
	}
	
	public SearchAnalyzer saveIndicatorBoxPlots(String directory) {
		return saveIndicatorBoxPlots(directory, null);
	}
	
	@Override
	public SearchAnalyzer saveAnalysis(File file)
			throws IOException {
		file.getParentFile().mkdirs();
		super.saveAnalysis(file);
		return this;
	}
	
	@Override
	public SearchAnalyzer saveAs(String name, File resultFile)
			throws IOException {
		super.saveAs(name, resultFile);
		return this;
	}
	
	@Override
	public SearchAnalyzer saveData(File directory, String prefix,
			String suffix) throws IOException {
		super.saveData(directory, prefix, suffix);
		return this;
	}
	
	@Override
	public SearchAnalyzer saveReferenceSet(File file)
			throws IOException {
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
	public SearchAnalyzer showStatistic(
			UnivariateStatistic statistic) {
		super.showStatistic(statistic);
		return this;
	}
	
	@Override
	public SearchAnalyzer showStatisticalSignificance() {
		super.showStatisticalSignificance();
		return this;
	}
	
	@Override
	public SearchAnalyzer usingProblemFactory(
			ProblemFactory problemFactory) {
		super.usingProblemFactory(problemFactory);
		return this;
	}
	
	@Override
	public SearchAnalyzer withEpsilon(double... epsilon) {
		super.withEpsilon(epsilon);
		return this;
	}
	
	@Override
	public SearchAnalyzer withProblem(String problemName) {
		super.withProblem(problemName);
		return this;
	}
	
	public <S extends Solution> SearchAnalyzer withProblem(ISearchProblem<S> problem) {
		if (problem instanceof IParetoFrontStoringSearchProblem) {
			super.withProblemClass(((IParetoFrontStoringSearchProblem) problem).getDelegate().getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());	
		} else {
			super.withProblemClass(problem.getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());
		}
		return this;
	}
	
	@Override
	public SearchAnalyzer withProblemClass(Class<?> problemClass,
			Object... problemArguments) {
		super.withProblemClass(problemClass, problemArguments);
		return this;
	}
	
	@Override
	public SearchAnalyzer withProblemClass(String problemClassName,
			Object... problemArguments) throws ClassNotFoundException {
		super.withProblemClass(problemClassName, problemArguments);
		return this;
	}
	
	@Override
	public SearchAnalyzer withReferenceSet(File referenceSetFile) {
		super.withReferenceSet(referenceSetFile);
		return this;
	}
	
	@Override
	public SearchAnalyzer withSignifianceLevel(
			double significanceLevel) {
		super.withSignifianceLevel(significanceLevel);
		return this;
	}
	
	@Override
	public AnalyzerResults getAnalysis() {
		try {
			return super.getAnalysis();
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	protected void addCohensDEffectSize(SearchAnalyzerResults results) {
		List<String> algorithms = results.getAlgorithms();
		for(String indicator : results.getIndicators()) {
			for (int i = 0; i < algorithms.size()-1; i++) {
				for (int j = i+1; j < algorithms.size(); j++) {
					String leftAlgorithm = algorithms.get(i);
					String rightAlgorithm = algorithms.get(j);
					SearchAlgorithmResult leftAlgorithmResults = results.get(leftAlgorithm);
					SearchAlgorithmResult rightAlgorithmResults = results.get(rightAlgorithm);
					SearchIndicatorResult leftIndicatorResults = leftAlgorithmResults.get(indicator);
					SearchIndicatorResult rightIndicatorResults = rightAlgorithmResults.get(indicator);
					if(leftIndicatorResults != null && rightIndicatorResults != null) {
						double cohensD = EffectSize.cohensD(leftIndicatorResults.getValues(), rightIndicatorResults.getValues());
						leftIndicatorResults.addAlgorithmEffectSize(
								new AlgorithmEffectSize("CohensD", rightAlgorithm, cohensD));
						rightIndicatorResults.addAlgorithmEffectSize(
								new AlgorithmEffectSize("CohensD", leftAlgorithm, cohensD));
					}
				}
			}
		}
	}
	
	public SearchAnalyzerResults getSearchAnalysis() {
		SearchAnalyzerResults analyzerResults = new SearchAnalyzerResults(getAnalysis());
		if(isShowStatisticalSignificance())
			addCohensDEffectSize(analyzerResults);
		return analyzerResults;
	}
	
	public SearchAnalyzer withSameProblemAs(Executor builder) {
		super.withSameProblemAs(builder);
		return this;
	}
	
	public SearchAnalyzer withSameProblemAs(org.moeaframework.Analyzer builder) {
		super.withSameProblemAs(builder);
		return this;
	}
	
	public SearchAnalyzer withSameProblemAs(Instrumenter builder) {
		super.withSameProblemAs(builder);
		return this;
	}
}
