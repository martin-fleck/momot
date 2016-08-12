package at.ac.tuwien.big.momot.examples.ecore.fitness.metric.vocabulary;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDistanceCache implements IDistanceCache {

   protected Map<String, Map<String, Double>> distances;

   public AbstractDistanceCache() {
      distances = new HashMap<>();
   }

   public void add(final String... newWords) {
      for(final String newWord : newWords) {
         add(newWord);
      }
   }

   public Map<String, Double> add(final String newWord) {
      Map<String, Double> newWordDistances = distances.get(newWord);
      if(newWordDistances != null) {
         return newWordDistances;
      }

      newWordDistances = new HashMap<>();

      for(final String word : distances.keySet()) {
         final Double distance = calculateDistance(word, newWord);
         distances.get(word).put(newWord, distance);
         newWordDistances.put(word, distance);
      }
      newWordDistances.put(newWord, 0.0);
      distances.put(newWord, newWordDistances);

      return newWordDistances;
   }

   protected abstract Double calculateDistance(String left, String right);

   @Override
   public Double getDistance(final String left, final String right) {
      add(left);
      final Map<String, Double> wordDistances = add(right);
      return wordDistances.get(left);
   }
}
