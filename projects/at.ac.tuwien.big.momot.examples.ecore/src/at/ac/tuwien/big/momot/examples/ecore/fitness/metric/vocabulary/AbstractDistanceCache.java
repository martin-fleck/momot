package at.ac.tuwien.big.momot.examples.ecore.fitness.metric.vocabulary;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDistanceCache implements IDistanceCache {
	
	protected Map<String, Map<String, Double>> distances;
	
	public AbstractDistanceCache() {
		distances = new HashMap<>();
	}
	
	public void add(String... newWords) {
		for(String newWord : newWords) 
			add(newWord);
	}
	
	public Map<String, Double> add(String newWord) {
		Map<String, Double> newWordDistances = distances.get(newWord);
		if(newWordDistances != null)
			return newWordDistances;
		
		newWordDistances = new HashMap<String, Double>();
		
		for(String word : distances.keySet()) {
			Double distance = calculateDistance(word, newWord);
			distances.get(word).put(newWord, distance);
			newWordDistances.put(word, distance);
		}
		newWordDistances.put(newWord, 0.0);
		distances.put(newWord, newWordDistances);
		
		return newWordDistances;
	}
	
	protected abstract Double calculateDistance(String left, String right);
	
	@Override
	public Double getDistance(String left, String right) {
		add(left);
		Map<String, Double> wordDistances = add(right);
		return wordDistances.get(left);
	}
}
