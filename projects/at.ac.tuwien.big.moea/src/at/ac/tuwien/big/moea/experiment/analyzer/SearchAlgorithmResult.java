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

	public SearchAlgorithmResult(String algorithm) {
		this.algorithm = algorithm;
		this.indicatorResults = new ArrayList<SearchIndicatorResult>();
	}

	public SearchAlgorithmResult(AlgorithmResult result) {
		this(result.getAlgorithm());
		for(String indicator : result.getIndicators()) {
			IndicatorResult indicatorResult = result.get(indicator);
			if(indicatorResult != null)
				indicatorResults.add(new SearchIndicatorResult(indicatorResult));
		}
	}
	
	public String getAlgorithm() {
		return algorithm;
	}

	public List<String> getIndicators() {
		List<String> indicators = new ArrayList<String>();
		for (SearchIndicatorResult result : indicatorResults) 
			indicators.add(result.getIndicator());
		return indicators;
	}
	
	public SearchIndicatorResult get(String indicator) {
		for (SearchIndicatorResult result : indicatorResults) 
			if (result.getIndicator().equals(indicator)) 
				return result;
		return null;
	}

	public List<SearchIndicatorResult> getIndicatorResults() {
		return indicatorResults;
	}
	
	void add(IndicatorResult result) {
		add(new SearchIndicatorResult(result));
	}
	
	void add(SearchIndicatorResult result) {
		indicatorResults.add(result);
	}
	
	void print(PrintStream ps, boolean showAggregate, 
			boolean showStatisticalSignificance, 
			boolean showIndividualValues, 
			List<UnivariateStatistic> statistics) {
		ps.print(getAlgorithm());
		ps.println(':');
		
		for (SearchIndicatorResult indicatorResult : indicatorResults) 
			indicatorResult.print(ps, showAggregate, showStatisticalSignificance, showIndividualValues, statistics);
	}
}
