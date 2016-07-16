package at.ac.tuwien.big.momot.examples.ecore.fitness.metric.vocabulary;

import info.debatty.java.stringsimilarity.Cosine;

public class CosineDistanceCache extends AbstractDistanceCache {

	protected Cosine cosine = new Cosine(2);
	
	@Override
	protected Double calculateDistance(String left, String right) {
		return cosine.distance(left, right);
	}
}
