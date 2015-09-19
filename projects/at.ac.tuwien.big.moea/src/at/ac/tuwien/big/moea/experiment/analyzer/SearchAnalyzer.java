package at.ac.tuwien.big.moea.experiment.analyzer;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.PopulationIO;
import org.moeaframework.core.Solution;
import org.moeaframework.core.spi.ProblemFactory;

import at.ac.tuwien.big.moea.problem.ISearchProblem;

public class SearchAnalyzer extends org.moeaframework.Analyzer {
	protected Map<String, List<NondominatedPopulation>> data;
	
	@SuppressWarnings("unchecked")
	public SearchAnalyzer() {
		try {	
			Field dataField = getClass().getSuperclass().getDeclaredField("data");
			dataField.setAccessible(true);
			data = (Map<String, List<NondominatedPopulation>>) dataField.get(this);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public SearchAnalyzer(ISearchProblem<?> problem) {
		this();
		withProblem(problem);
	}
	
	public NondominatedPopulation createNewArchive() {
		try {	
			Method newArchiveMethod = getClass().getSuperclass().getSuperclass().getDeclaredMethod("newArchive");
			newArchiveMethod.setAccessible(true);
			return (NondominatedPopulation) newArchiveMethod.invoke(this);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException | 
				InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public NondominatedPopulation getApproximationSet() {
		NondominatedPopulation referenceSet = createNewArchive();
		
		for (List<NondominatedPopulation> entry : data.values()) 
			for (NondominatedPopulation set : entry) 
				referenceSet.addAll(set);
		
		return referenceSet;
	}
	
	public NondominatedPopulation getApproximationSet(String name) {
		NondominatedPopulation referenceSet = createNewArchive();
		
		for(NondominatedPopulation data : this.data.get(name))
			referenceSet.addAll(data);
		
		return referenceSet;
	}
	
	public Map<String, NondominatedPopulation> getApproximationSets() {
		Map<String, NondominatedPopulation> approximationSets = new HashMap<>();
		for(String name : data.keySet())
			approximationSets.put(name, getApproximationSet(name));
		return approximationSets;
	}
		
	public SearchAnalyzer saveApproximationSetObjectives(String fileName) throws IOException {
		File file = new File(fileName);
		FileUtils.touch(file);
		return saveApproximationSetObjectives(file);
	}
	
	public SearchAnalyzer saveApproximationSetObjectives(File file) throws IOException {
		PopulationIO.writeObjectives(file, getApproximationSet());
		return this;
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
	public SearchAnalyzer printAnalysis() throws IOException {
		super.printAnalysis();
		return this;
	}
	
	@Override
	public SearchAnalyzer printAnalysis(PrintStream ps)
			throws IOException {
		super.printAnalysis(ps);
		return this;
	}
	
	@Override
	public SearchAnalyzer saveAnalysis(File file)
			throws IOException {
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
		super.withProblemClass(problem.getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());
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
