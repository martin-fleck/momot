package at.ac.tuwien.big.moea.experiment.analyzer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.moeaframework.Analyzer.IndicatorResult;

public class SearchIndicatorResult {
	
	protected final String indicator;
	
	protected final double[] values;

	protected List<String> indifferentAlgorithms;

	protected List<AlgorithmEffectSize> algorithmEffectSizes;
	
	protected Double aggregateValue;
	
	public SearchIndicatorResult(String indicator, double[] values) {
		this.algorithmEffectSizes = new ArrayList<>();
		this.indicator = indicator;
		this.values = values;
	}
	
	public SearchIndicatorResult(IndicatorResult result) {
		this.algorithmEffectSizes = new ArrayList<>();
		this.indicator = result.getIndicator();
		this.values = result.getValues();
		this.indifferentAlgorithms = result.getIndifferentAlgorithms();
		this.aggregateValue = result.getAggregateValue();
	}
	
	public double[] getValues() {
		return values.clone();
	}

	public double getStatistic(UnivariateStatistic statistic) {
		return statistic.evaluate(values);
	}
	
	public int getCount() {
		return values.length;
	}

	public List<String> getIndifferentAlgorithms() {
		return new ArrayList<String>(indifferentAlgorithms);
	}
	
	public void addIndifferentAlgorithm(String algorithm) {
		indifferentAlgorithms.add(algorithm);
	}

	public List<AlgorithmEffectSize> getAlgorithmEffectSizes() {
		return algorithmEffectSizes;
	}
	
	public void addAlgorithmEffectSize(AlgorithmEffectSize effectSize) {
		algorithmEffectSizes.add(effectSize);
	}
	
	public Double getAggregateValue() {
		return aggregateValue;
	}

	public void setAggregateValue(Double aggregateValue) {
		this.aggregateValue = aggregateValue;
	}

	public String getIndicator() {
		return indicator;
	}

	void print(PrintStream ps, 
			boolean showAggregate, 
			boolean showStatisticalSignificance, 
			boolean showIndividualValues, 
			List<UnivariateStatistic> statistics) {
		double[] values = getValues();
		
		ps.print("    ");
		ps.print(getIndicator());
		ps.print(": ");
		
		if (values.length == 0) {
			ps.print("null");
		} else if (values.length == 1) {
			ps.print(values[0]);
		} else {
			ps.println();
			
			if (showAggregate) {
				ps.print("        Aggregate: ");
				ps.println(getAggregateValue());
			}
			
			for (UnivariateStatistic statistic : statistics) {
				ps.print("        ");
				ps.print(statistic.getClass().getSimpleName());
				ps.print(": ");
				ps.println(getStatistic(statistic));
			}
			
			ps.print("        Count: ");
			ps.print(getCount());
			
			if (showStatisticalSignificance) {
				ps.println();
				ps.print("        Indifferent: ");
				ps.print(getIndifferentAlgorithms());
				
				ps.println();
				if(getAlgorithmEffectSizes().isEmpty())
					ps.print("        EffectSize: []");
				else {
					ps.println("        EffectSize: [");
					for(AlgorithmEffectSize effectSize : getAlgorithmEffectSizes()) {
						ps.print("            - { ");
						ps.print("measure: " + effectSize.getMeasure());
						ps.print(", algorithm: " + effectSize.getAlgorithm());
						ps.print(", effectSize: " + effectSize.getEffectSize());
						ps.println(" }");
					}
					ps.print("        ]");
				}
			}
			
			if (showIndividualValues) {
				ps.println();
				ps.print("        Values: ");
				ps.print(Arrays.toString(values));
			}
		}
		
		ps.println();
	}
}
