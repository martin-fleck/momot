package at.ac.tuwien.big.momost.examples.tse.eval;

import java.util.ArrayList;
import java.util.List;

public class EvaluationMetricsAnalysis {
	private List<TransformationEvaluationMetrics> metrics = new ArrayList<>();
	private TransformationEvaluationMetrics maxF1;
	private TransformationEvaluationMetrics maxPrecision;
	private TransformationEvaluationMetrics maxRecall;
	private TransformationEvaluationMetrics minF1;
	private TransformationEvaluationMetrics minPrecision;
	private TransformationEvaluationMetrics minRecall;	
	
	public EvaluationMetricsAnalysis() {
		extract();
	}
	
	public EvaluationMetricsAnalysis(List<TransformationEvaluationMetrics> metrics) {
		addMetrics(metrics);
		extract();
	}
	
	public void addMetrics(List<TransformationEvaluationMetrics> metrics) {
		getMetrics().addAll(metrics);
	}
	
	public void setMetrics(List<TransformationEvaluationMetrics> metrics) {
		this.metrics = metrics;
	}
	
	protected void extract() {
		if(metrics.isEmpty())
			return;
		
		maxF1 = metrics.get(0);
		maxPrecision = metrics.get(0);
		maxRecall = metrics.get(0);
		
		minF1 = metrics.get(0);
		minPrecision = metrics.get(0);
		minRecall = metrics.get(0);
		
		for(TransformationEvaluationMetrics metric : metrics) {
			if(metric.getF1() > maxF1.getF1()) 
				maxF1 = metric;
			if(metric.getPrecision() > maxPrecision.getPrecision()) 
				maxPrecision = metric;
			if(metric.getRecall() > maxRecall.getRecall()) 
				maxRecall = metric;
			
			if(metric.getF1() < minF1.getF1()) 
				minF1 = metric;
			if(metric.getPrecision() < minPrecision.getPrecision()) 
				minPrecision = metric;
			if(metric.getRecall() < minRecall.getRecall()) 
				minRecall = metric;
		}
	}
	
	public List<TransformationEvaluationMetrics> getMetrics() {
		return metrics;
	}
	
	public TransformationEvaluationMetrics getMaxF1() {
		return maxF1;
	}
	
	public TransformationEvaluationMetrics getMaxPrecision() {
		return maxPrecision;
	}
	
	public TransformationEvaluationMetrics getMaxRecall() {
		return maxRecall;
	}
	
	public TransformationEvaluationMetrics getMinF1() {
		return minF1;
	}
	
	public TransformationEvaluationMetrics getMinPrecision() {
		return minPrecision;
	}
	
	public TransformationEvaluationMetrics getMinRecall() {
		return minRecall;
	}
}
