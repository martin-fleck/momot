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
		this.algorithmResults = new ArrayList<SearchAlgorithmResult>();
	}
	
	public SearchAnalyzerResults(Analyzer.AnalyzerResults results) {
		this();	
		if(results == null)
			return;
		
		for(String algorithm : results.getAlgorithms()) {
			AlgorithmResult algorithmResult = results.get(algorithm);
			if(algorithmResult != null)
				algorithmResults.add(new SearchAlgorithmResult(algorithmResult));
		}			
	}
	
	public List<String> getAlgorithms() {
		List<String> algorithms = new ArrayList<String>();
		
		for (SearchAlgorithmResult result : algorithmResults) {
			algorithms.add(result.getAlgorithm());
		}
		
		return algorithms;
	}

	public List<String> getIndicators() {
		Set<String> indicators = new TreeSet<>();
		for (SearchAlgorithmResult result : algorithmResults) {
			indicators.addAll(result.getIndicators());
		}
		return new ArrayList<>(indicators);
	}
	
	public SearchAlgorithmResult get(String algorithm) {
		for (SearchAlgorithmResult result : algorithmResults) {
			if (result.getAlgorithm().equals(algorithm)) {
				return result;
			}
		}
		
		return null;
	}
	
	public List<SearchAlgorithmResult> getAlgorithmResults() {
		return algorithmResults;
	}
	
	void add(SearchAlgorithmResult result) {
		algorithmResults.add(result);
	}
	
	void add(AlgorithmResult result) {
		add(new SearchAlgorithmResult(result));
	}
	
	public void print(PrintStream ps, boolean showAggregate, 
			boolean showStatisticalSignificance, 
			boolean showIndividualValues, 
			List<UnivariateStatistic> statistics) {
		for (SearchAlgorithmResult algorithmResult : algorithmResults) {
			algorithmResult.print(ps, showAggregate, showStatisticalSignificance, showIndividualValues, statistics);
		}
	}
}
