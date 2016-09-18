package at.ac.tuwien.big.momost.examples.tse.eval;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.ac.tuwien.big.momot.examples.tse.modularization.Helper;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class PairwiseCalculator {
	
	public static class Pair<T> {
		private T left;
		private T right;
		
		public Pair(T left, T right) {
			if(left == null || right == null)
				throw new IllegalArgumentException("Both sides of a pair must be set.");
			
			this.left = left;
			this.right = right;
		}
		
		public T getLeft() {
			return left;
		}
		
		public T getRight() {
			return right;
		}
		
		@Override
		public int hashCode() {
			return left.hashCode() ^ right.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Pair))
				return false;
			
			// do symmetric comparison
			@SuppressWarnings("unchecked")
			Pair<T> other = (Pair<T>) obj;
			return this.left.equals(other.getLeft()) &&
			       this.right.equals(other.getRight()) ||
			       this.left.equals(other.getRight()) &&
			       this.right.equals(other.getLeft());
		}
		
		@Override
		public String toString(){
			return "[" + getLeft() + "," + getRight() + "]";
		}
	}
	
	private ResourceSet resourceSet = new ResourceSetImpl();
	private String expectedTransformationUri;
	private Transformation expectedTransformation;
	private Set<Pair<String>> expectedPairs;
	
	public PairwiseCalculator(String expectedTransformationUri) {
		this.expectedTransformationUri = expectedTransformationUri;
		Resource resource = loadModel(expectedTransformationUri);
		this.expectedTransformation = EvaluationUtil.assertTransformation(resource);
		this.expectedPairs = extractPairs(expectedTransformation);
	}
	
	protected Resource loadModel(String uri) {
		return new ResourceSetImpl().getResource(URI.createURI(uri), true);
	}
	
	protected ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public String getExpectedTransformationUri() {
		return expectedTransformationUri;
	}
	
	public Transformation getExpectedTransformation() {
		return expectedTransformation;
	}
	
	public Set<Pair<String>> getExpectedPairs() {
		return expectedPairs;
	}
	
	public List<TransformationEvaluationMetrics> calculateDirectory(String directory, String algorithm) {
		List<TransformationEvaluationMetrics> results = new ArrayList<>();
		File dir = new File(directory);
		
	    for(String file : dir.list()) {
	    	try {
		    	if(!file.endsWith(".xmi")) // only consider models
		    		continue;

		    	results.add(calculate(directory + file, algorithm));		    	
	    	} catch(Exception e) {
		    	System.err.println(file + ": " + e.getMessage());
		    }
	    }
		return results;
	}
	
	public List<TransformationEvaluationMetrics> calculateDirectory(String directory) {
		return calculateDirectory(directory, null);
	}
	
	public TransformationEvaluationMetrics calculate(String transformationUri, String algorithm) {
		Transformation transformation = EvaluationUtil.assertTransformation(loadModel(transformationUri));
		
		Set<Pair<String>> pairs = extractPairs(transformation);
		
		Set<Pair<String>> truePositives = new HashSet<>(pairs);
		Set<Pair<String>> falseNegatives = new HashSet<>(getExpectedPairs()); // expected \ pairs
		Set<Pair<String>> falsePositives = new HashSet<>(pairs); // pairs \ expected
		
		truePositives.retainAll(getExpectedPairs());
		falseNegatives.removeAll(pairs);
		falsePositives.removeAll(getExpectedPairs());
				
		TransformationEvaluationMetrics metrics = new TransformationEvaluationMetrics();
		metrics.setAlgorithm(algorithm);
		metrics.setTransformation(transformation);
		
		metrics.setTruePositives(truePositives.size());
		metrics.setFalseNegatives(falseNegatives.size());
		metrics.setFalsePositives(falsePositives.size());
		
		
		return metrics;
	}
	
	public TransformationEvaluationMetrics calculate(String transformationUri) {
		return calculate(transformationUri, null);
	}
	
	public static Set<Pair<String>> extractPairs(Transformation transformation) {
		Set<Pair<String>> pairs = new HashSet<>();
		for(Module module : transformation.getModules()) {
			for(int source = 0; source < module.getRules().size(); source++) {
				for(int target = 0; target < module.getRules().size(); target++) {
					// avoid duplicate pairs and 'self'-pairs
					// assumption: rule and helper names are unique
					if(source < target)
						pairs.add(new Pair<String>(
								module.getRules().get(source).getName(), 
								module.getRules().get(target).getName()));
				}
				for(Helper target : module.getHelpers()) {
					// assumption: rule and helper names are unique
					pairs.add(new Pair<String>(
						module.getRules().get(source).getName(), 
						target.getName()));
				}
			}
			for(int source = 0; source < module.getHelpers().size(); source++) {
				for(int target = 0; target < module.getHelpers().size(); target++) {
					// avoid duplicate pairs and 'self'-pairs
					// assumption: rule and helper names are unique
					if(source < target)
						pairs.add(new Pair<String>(
								module.getHelpers().get(source).getName(), 
								module.getHelpers().get(target).getName()));
				}
			}
		}
			
		return pairs;
	}
}
