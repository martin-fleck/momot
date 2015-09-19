package at.ac.tuwien.big.momot.examples.modularization.jsep;

import java.io.Serializable;

import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Attribute;
import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class;
import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Feature;
import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Method;
import at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.SoftwareModel;

public class SWCalculator implements Serializable {

	private static final long serialVersionUID = 1919490021102783151L;

	public static class ModularizationMetrics implements Serializable {
		private static final long serialVersionUID = -8613327746079310311L;
		
		public int nrMethods;
		public int nrAttributes;
		
		public int nrMethodToAttributeDependencies;
		public int nrMaxMethodToAttributeDependencies;
		
		public int nrMethodToMethodDependencies;
		public int nrMaxMethodToMethodDependencies;
		
		public double cohesion;
		public double coupling;
		
		public double cohesionRatio;
		public double couplingRatio;
		
		public ModularizationMetrics() { }
		
		public ModularizationMetrics(ModularizationMetrics metric) {
			this.nrAttributes = metric.nrAttributes;
			this.nrMethods = metric.nrMethods;
			this.nrMethodToAttributeDependencies = metric.nrMethodToAttributeDependencies;
			this.nrMaxMethodToAttributeDependencies = metric.nrMaxMethodToAttributeDependencies;
			this.nrMethodToMethodDependencies = metric.nrMethodToMethodDependencies;
			this.nrMaxMethodToMethodDependencies = metric.nrMaxMethodToMethodDependencies;
			this.cohesion = metric.cohesion;
			this.coupling = metric.coupling;
			this.cohesionRatio = metric.cohesionRatio;
			this.couplingRatio = metric.couplingRatio;
		}
		
		public void add(ModularizationMetrics metric) {
			this.nrAttributes += metric.nrAttributes;
			this.nrMethods += metric.nrMethods;
			this.nrMethodToAttributeDependencies += metric.nrMethodToAttributeDependencies;
			this.nrMaxMethodToAttributeDependencies += metric.nrMaxMethodToAttributeDependencies;
			this.nrMethodToMethodDependencies += metric.nrMethodToMethodDependencies;
			this.nrMaxMethodToMethodDependencies += metric.nrMaxMethodToMethodDependencies;
			this.cohesion += metric.cohesion;
			this.coupling += metric.coupling;
			this.cohesionRatio += metric.cohesionRatio;
			this.couplingRatio += metric.couplingRatio;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("\nMethods:                 " + nrMethods + "\n");
			sb.append("Attributes:              " + nrAttributes + "\n");
			sb.append("MethodToAttributeDep:    " + nrMethodToAttributeDependencies + "\n");
			sb.append("MaxMethodToAttributeDep: " + nrMaxMethodToAttributeDependencies + "\n");
			sb.append("MethodToMethodDep:       " + nrMethodToMethodDependencies + "\n");
			sb.append("MaxMethodToMethodDep:    " + nrMaxMethodToMethodDependencies + "\n");
			sb.append("Coupling:                " + coupling + "\n");
			sb.append("CouplingRatio:           " + couplingRatio + "\n");
			sb.append("Cohesion:                " + cohesion + "\n");
			sb.append("CohesionRatio:           " + cohesionRatio + "\n");
			return sb.toString();
		}
	}
	
	public static class SoftareMetrics extends ModularizationMetrics {
		private static final long serialVersionUID = -1204171931081112125L;
		
		public int nrEmptyClasses;
		public int nrUnassignedFeatures;
		
		public SoftareMetrics() { }
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("EmptyClasses:            " + nrEmptyClasses + "\n");
			sb.append("UnassignedFeatures:      " + nrUnassignedFeatures + "\n");
			return sb.toString();
		}
	}
	
	
	private SoftwareModel model;
	private SoftareMetrics softwareMetrics;

	public SWCalculator(SoftwareModel model) {
		this.model = model;
		calculate();
	}
	
	public SoftwareModel getModel() {
		return model;
	}
	
	public void setModel(SoftwareModel model) {
		this.model = model;
	}
	
	protected void calculate() {
		softwareMetrics = new SoftareMetrics();
		
		for(at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class clazz : model.getClasses()) {
			if(clazz.getFeatures().isEmpty())
				softwareMetrics.nrEmptyClasses += 1;
			else {
				ModularizationMetrics metric = calculate(clazz);
				softwareMetrics.add(metric);
			}
		}
		
		for(Feature feature : model.getFeatures()) {
			if(feature.getContainer() == null)
				softwareMetrics.nrUnassignedFeatures += 1;
		}
	}
	
	protected ModularizationMetrics calculate(at.ac.tuwien.big.momot.examples.modularization.jsep.architecture.Class source) {
		ModularizationMetrics metrics = new ModularizationMetrics();
		for(Class target : model.getClasses()) {
			int sourceAttributes = 0;
			int targetAttributes = 0;
			
			int sourceMethods = 0;
			int targetMethods = 0;
			
			int methodToMethodDependencies = 0;
			int methodToAttributeDependencies = 0;
			
			for(Feature sourceFeature : source.getFeatures()) {
				if(sourceFeature instanceof Attribute) {
					sourceAttributes++;
					continue;
				}
				Method sourceMethod = (Method) sourceFeature;
				sourceMethods++;
				for(Feature targetFeature : target.getFeatures()) {
					if(targetFeature instanceof Attribute && hasDependency(sourceMethod, (Attribute) targetFeature))
						methodToAttributeDependencies++;
					else if(targetFeature instanceof Method && hasDependency(sourceMethod, (Method) targetFeature))
						methodToMethodDependencies++;
				}				
			}
			for(Feature targetFeature : target.getFeatures()) {
				if(targetFeature instanceof Attribute) 
					targetAttributes++;
				else
					targetMethods++;
			}
			
			int maxMethodToMethodDependencies = sourceMethods * (targetMethods - 1);
			if(maxMethodToMethodDependencies < 0)
				maxMethodToMethodDependencies = 0;
			
			double methodToMethodRatio = maxMethodToMethodDependencies > 0 ? 
					((double)methodToMethodDependencies / (double)maxMethodToMethodDependencies) :
					0.0;
			
			int maxMethodToAttributeDependencies = sourceMethods * targetAttributes;
			if(maxMethodToAttributeDependencies < 0)
				maxMethodToAttributeDependencies = 0;
			double methodToAttributeRatio = maxMethodToAttributeDependencies > 0 ?
					(double)methodToAttributeDependencies / (double)maxMethodToAttributeDependencies :
					0.0;
			
			double ratio = methodToMethodRatio + methodToAttributeRatio;
			
			metrics.nrAttributes = sourceAttributes;
			metrics.nrMethods = sourceMethods;
			
			metrics.nrMethodToAttributeDependencies = methodToAttributeDependencies;
			metrics.nrMethodToMethodDependencies = methodToMethodDependencies;
			
			metrics.nrMaxMethodToAttributeDependencies = maxMethodToAttributeDependencies;
			metrics.nrMaxMethodToMethodDependencies = maxMethodToMethodDependencies;
			
			if(source.equals(target)) {
				metrics.cohesion += methodToAttributeDependencies + methodToMethodDependencies;
				metrics.cohesionRatio += ratio;
			} else {
				metrics.coupling += methodToAttributeDependencies + methodToMethodDependencies;
				metrics.couplingRatio += ratio;
			}
		}
		return metrics;
	}
	
	protected boolean hasDependency(Method source, Attribute target) {
		return source.getDataDependency().contains(target);
	}
	
	protected boolean hasDependency(Method source, Method target) {
		return source.getFunctionalDependency().contains(target);
	}

	public SoftareMetrics getMetrics() {
		return softwareMetrics;
	}
	
	@Override
	public String toString() {
		return getMetrics().toString();
	}
}
