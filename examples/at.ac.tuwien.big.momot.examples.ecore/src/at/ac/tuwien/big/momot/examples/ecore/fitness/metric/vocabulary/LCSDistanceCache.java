package at.ac.tuwien.big.momot.examples.ecore.fitness.metric.vocabulary;

import info.debatty.java.stringsimilarity.MetricLCS;

public class LCSDistanceCache extends AbstractDistanceCache {
	
	protected MetricLCS lcs = new MetricLCS(); // Longest Common Subsequence
	
	@Override
	protected Double calculateDistance(String left, String right) {
		return lcs.distance(left, right);
	}
}
