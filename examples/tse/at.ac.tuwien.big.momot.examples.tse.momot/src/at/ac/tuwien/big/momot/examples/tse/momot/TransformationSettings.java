package at.ac.tuwien.big.momot.examples.tse.momot;

import java.io.File;

import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.momot.examples.tse.metric.TransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.metric.calc.MetricCalculator;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
import at.ac.tuwien.big.momot.examples.tse.momot.util.ModularizationUtil;
import at.ac.tuwien.big.momot.examples.tse.momot.util.OrchestrationUtil;

public class TransformationSettings {

	protected EGraph graph;
	protected Transformation transformation;
	protected TransformationMetrics transformationMetrics;
	protected String transformationURI;
	protected int minModules;
	protected int maxModules;
	protected int nrExecutions;
	protected int solutionLength;
	private String referenceFileURI;
		
	public TransformationSettings(String transformationURI) {
		this(transformationURI, null, 1, null);
	}
	
	public TransformationSettings(String transformationURI, String referenceFileURI) {
		this(transformationURI, referenceFileURI, 1, null);
	}
	
	public TransformationSettings(String transformationURI, String referenceFileURI, int minModules) {
		this(transformationURI, referenceFileURI, minModules, null);
	}
	
	public TransformationSettings(String transformationURI, int minModules) {
		this(transformationURI, null, minModules, null);
	}
	
	public TransformationSettings(String transformationURI, int minModules, Integer maxModules) {
		this(transformationURI, null, minModules, maxModules);
	}
	
	public TransformationSettings(String transformationURI, String referenceFileURI, int minModules, Integer maxModules) {
		this.transformationURI = transformationURI;
		this.minModules = minModules;
		this.graph = ModularizationUtil.loadGraph(transformationURI);
		this.transformation = ModularizationUtil.assertTransformationRoot(graph);
		this.transformationMetrics = MetricCalculator.calculateMetrics(transformation);
		this.maxModules = maxModules == null ? 
				getTransformationMetrics().getNrResponsibilities() : 
				Math.min(maxModules, getTransformationMetrics().getNrResponsibilities());
		this.solutionLength = getNrResponsibilities() - 1;
		this.referenceFileURI = referenceFileURI != null && !referenceFileURI.isEmpty() ? 
				referenceFileURI :
				OrchestrationUtil.getReferenceFileURI(transformationURI);
	}
	
	public EGraph getGraph() {
		return graph;
	}
	
	public Transformation getTransformation() {
		return transformation;
	}
	
	public TransformationMetrics getTransformationMetrics() {
		return transformationMetrics;
	}
	
	public int getNrResponsibilities() {
		return getTransformationMetrics().getNrResponsibilities();
	}
	
	public int getSolutionLength() {
		return solutionLength;
	}
	
	public int getMinModules() {
		return minModules;
	}
	
	public int getMaxModules() {
		return maxModules;
	}
	
	protected int calculateMaxModules() {
		return maxModules;
	}
	
	public String getReferenceFileURI() {
		return referenceFileURI;
	}
	
	public void setReferenceFileURI(String referenceFileURI) {
		this.referenceFileURI = referenceFileURI;
	}
	
	public File getReferenceFile() {
		return new File(getReferenceFileURI());
	}
	
	public String getTransformationURI() {
		return transformationURI;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Transformation: " + getTransformationURI() + "\n");
		sb.append("MinModules:     " + getMinModules() + "\n");
		sb.append("MaxModules:     " + getMaxModules() + "\n");
		sb.append("SolutionLength: " + getSolutionLength() + "\n");
		if(getReferenceFileURI() != null)
			sb.append("ReferenceFile:  " + getReferenceFile() + "\n");
		else
			sb.append("ReferenceFile:  ---\n");
		return sb.toString();
	}
}
