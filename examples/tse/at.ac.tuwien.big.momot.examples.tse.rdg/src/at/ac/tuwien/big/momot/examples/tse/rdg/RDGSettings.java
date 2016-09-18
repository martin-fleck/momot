package at.ac.tuwien.big.momot.examples.tse.rdg;

import at.ac.tuwien.big.momot.examples.tse.metric.TransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGTransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.rdg.util.ModularizationUtil;

public class RDGSettings {
	private String transformationURI;
	private Transformation transformation;
	private RDG rdg;
	private Integer maxModules;
	private RDGTransformationMetrics rdgMetrics;
	private TransformationMetrics transformationMetrics;
	private int nrResponsibilities;
	private int solutionLength;

	public RDGSettings(String transformationURI) {
		this(transformationURI, null);
	}
	
	public RDGSettings(String transformationURI, Integer maxModules) {
		this.transformationURI = transformationURI;
		this.transformation = ModularizationUtil.loadTransformation(transformationURI);
		this.rdg = RDGConverter.toRDG(transformation);
		this.rdgMetrics = rdg.calculateMetrics();
		this.maxModules = maxModules == null ? 
				rdgMetrics.getNrResponsibilities() : 
				Math.min(maxModules, rdgMetrics.getNrResponsibilities());
		this.nrResponsibilities = rdgMetrics.getNrResponsibilities();
		this.solutionLength = getNrResponsibilities() - 1;
	}
	
	public String getTransformationURI() {
		return transformationURI;
	}
	
	public Transformation getTransformation() {
		return transformation;
	}
	
	public RDG getRDG() {
		return rdg;
	}
	
	public Integer getMaxModules() {
		return maxModules;
	}
	
	public TransformationMetrics getTransformationMetrics() {
		return transformationMetrics;
	}
	
	public RDGTransformationMetrics getRDGMetrics() {
		return rdgMetrics;
	}
	
	public int getNrResponsibilities() {
		return nrResponsibilities;
	}
	
	public int getSolutionLength() {
		return solutionLength;
	}
}
