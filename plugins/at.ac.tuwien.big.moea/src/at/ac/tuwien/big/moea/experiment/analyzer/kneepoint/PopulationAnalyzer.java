package at.ac.tuwien.big.moea.experiment.analyzer.kneepoint;

import at.ac.tuwien.big.moea.util.MathUtil;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.Pair;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

/**
 * This class is based on a similar class of
 * jMetalPlus: An enhanced version of the jMetal framework by marlonso
 * https://sourceforge.net/projects/jmetalbymarlonso/
 */
public class PopulationAnalyzer {

   public enum FitnessComparison {
      OBJECTIVE_SUM, EGALITARIAN, CHEBY_SHEV, COBB_DOUGLAS, NASH, PROPER_UTILITY, PNORM
   }

   protected static final String KEY_NORMALIZED_OBJECTIVES = "momot_normalizedObjectives";
   protected static final String KEY_EUCLIDEAN_DISTANCE = "momot_euclideanDistance";

   protected static final String KEY_FITNESS = "momot_fitness";

   public static <K extends Comparable<K>> Integer[] indicesInUnsortedArray(final K[] array) {
      final ArrayList<Pair<Integer, K>> pairs = new ArrayList<>();

      for(int i = 0; i < array.length; i++) {
         pairs.add(new Pair<>(i, array[i]));
      }
      Collections.sort(pairs, (pair1, pair2) -> pair1.getValue().compareTo(pair2.getValue()));

      final Integer[] indices = new Integer[array.length];
      for(int i = 0; i < array.length; i++) {
         indices[i] = pairs.get(i).getFirst();
      }

      return indices;
   }

   protected NondominatedPopulation referenceSet;

   protected int numberOfObjectives;

   public PopulationAnalyzer() {}

   public PopulationAnalyzer(final NondominatedPopulation referenceSet) {
      this.referenceSet = referenceSet;
      if(referenceSet != null && !referenceSet.isEmpty()) {
         numberOfObjectives = referenceSet.get(0).getNumberOfObjectives();
      }
   }

   public double calculateEuclideanDistance(final double[] left, final double[] right) {
      double diff; // Auxiliar var
      double distance = 0.0;
      for(int i = 0; i < left.length; i++) {
         diff = left[i] - right[i];
         distance += Math.pow(diff, 2.0);
      }

      return Math.sqrt(distance);
   }

   public double calculateEuclideanDistance(final Solution left, final Solution right) {
      return calculateEuclideanDistance(getNormalizedObjectives(left), getNormalizedObjectives(right));
   }

   public double[] calculateEuclideanDistanceToPopulation(final Solution solution,
         final NondominatedPopulation population) {
      final double[] distance = new double[population.size()];

      for(int i = 0; i < distance.length; i++) {
         distance[i] = calculateEuclideanDistance(solution, population.get(i));
      }

      return distance;
   }

   public double[] calculateNormalizedObjectives(final Solution solution) {
      return MathUtil.normalize(solution.getObjectives(), getBestObjectives(), getWorstObjectives());
   }

   public double[] getBestObjectives() {
      final double[] best = new double[getNumberOfObjectives()];
      for(int i = 0; i < getNumberOfObjectives(); i++) {
         best[i] = Double.POSITIVE_INFINITY;
      }

      for(final Solution solution : referenceSet) {
         for(int i = 0; i < getNumberOfObjectives(); i++) {
            if(solution.getObjective(i) < best[i]) {
               best[i] = solution.getObjective(i);
            }
         }
      }
      return best;
   }

   public Solution getBestSolution(final NondominatedPopulation population, final FitnessComparison comparison) {
      final NondominatedPopulation normalizedPopulation = getNormalizedPopulation(population);

      final Fitness fitness = new Fitness(normalizedPopulation);

      switch(comparison) {
         case CHEBY_SHEV:
            fitness.chebyshevFitness();
            break;
         case COBB_DOUGLAS:
            fitness.cobbDouglasFitness();
            break;
         case EGALITARIAN:
            fitness.egalitarianFitness();
            break;
         case NASH:
            fitness.nashFitness();
            break;
         case OBJECTIVE_SUM:
            fitness.objectiveSumFitness();
            break;
         case PNORM:
            fitness.pNormFitness(2.0);
            break;
         default:
         case PROPER_UTILITY:
            fitness.properUtility();
            break;
      }

      final ArrayList<Solution> sortedPopulation = new ArrayList<>(normalizedPopulation.size());
      for(final Solution solution : normalizedPopulation) {
         sortedPopulation.add(solution);
      }
      Collections.sort(sortedPopulation, (left, right) -> Double.compare(getFitness(left), getFitness(right)));
      return sortedPopulation.get(0);
   }

   public double[] getEuclideanDistanceToPopulation(final Solution solution, final NondominatedPopulation population) {
      final double[] euclideanDistance = (double[]) solution.getAttribute(KEY_EUCLIDEAN_DISTANCE);
      if(euclideanDistance == null) {
         return setEuclideanDistanceToPopulation(solution, population);
      }
      return euclideanDistance;
   }

   public double getFitness(final Solution solution) {
      final Double fitness = (Double) solution.getAttribute(KEY_FITNESS);
      if(fitness == null) {
         throw new IllegalArgumentException("No fitness has been assigned.");
      }
      return fitness;
   }

   public NondominatedPopulation getKneePointSolutions(final NondominatedPopulation population,
         final int neighborhoodSize, final FitnessComparison comparison) {
      final NondominatedPopulation knees = new NondominatedPopulation();
      int size = neighborhoodSize;
      if(size > population.size() - 1) {
         // System.err.println("Warning: There are not enough solutions in the population to fulfill a neighborhood size
         // of " + neighborhoodSize + ".");
         System.out.println(
               "The neighborhood size will be set to the maximum neighborhood (n-1): " + (population.size() - 1));
         size = population.size() - 1;
      }

      final NondominatedPopulation normalizedPopulation = getNormalizedPopulation(population);
      final Fitness fitness = new Fitness(normalizedPopulation);

      switch(comparison) {
         case CHEBY_SHEV:
            fitness.chebyshevFitness();
            break;
         case COBB_DOUGLAS:
            fitness.cobbDouglasFitness();
            break;
         case EGALITARIAN:
            fitness.egalitarianFitness();
            break;
         case NASH:
            fitness.nashFitness();
            break;
         case OBJECTIVE_SUM:
            fitness.objectiveSumFitness();
            break;
         case PNORM:
            fitness.pNormFitness(2.0);
            break;
         default:
         case PROPER_UTILITY:
            fitness.properUtility();
            break;
      }

      for(final Solution solution : normalizedPopulation) {
         final Double[] distances = ArrayUtils
               .toObject(getEuclideanDistanceToPopulation(solution, normalizedPopulation));
         final Integer[] indices = indicesInUnsortedArray(distances);

         boolean isKnee = true;
         for(int i = 1; i < size + 1; i++) { // first solution is the same (distance 0)
            final Solution otherSolution = normalizedPopulation.get(indices[i]);
            if(hasWorseFitness(solution, otherSolution)) {
               isKnee = false;
               break;
            }
         }
         if(isKnee) {
            knees.add(solution);
         }
      }
      return knees;
   }

   public double[] getNormalizedObjectives(final Solution solution) {
      final double[] normalizedObjectives = (double[]) solution.getAttribute(KEY_NORMALIZED_OBJECTIVES);
      if(normalizedObjectives == null) {
         return setNormalizedObjectives(solution);
      }
      return normalizedObjectives;
   }

   public NondominatedPopulation getNormalizedPopulation(final NondominatedPopulation population) {
      final NondominatedPopulation normalizedPopulation = new NondominatedPopulation(getReferenceSet().getComparator());
      for(final Solution solution : population) {
         normalizedPopulation.add(getNormalizedSolution(solution));
      }
      return normalizedPopulation;
   }

   public Solution getNormalizedSolution(final Solution solution) {
      final Solution normalizedSolution = solution.copy();
      normalizedSolution.getAttributes().putAll(solution.getAttributes());
      normalizedSolution.setAttribute("momot_original_objectives", solution.getObjectives());
      normalizedSolution.setObjectives(calculateNormalizedObjectives(solution));
      return normalizedSolution;
   }

   public int getNumberOfObjectives() {
      return numberOfObjectives;
   }

   public NondominatedPopulation getReferenceSet() {
      return referenceSet;
   }

   public double[] getWorstObjectives() {
      final double[] worst = new double[getNumberOfObjectives()];
      for(int i = 0; i < getNumberOfObjectives(); i++) {
         worst[i] = Double.NEGATIVE_INFINITY;
      }

      for(final Solution solution : referenceSet) {
         for(int i = 0; i < getNumberOfObjectives(); i++) {
            if(solution.getObjective(i) > worst[i]) {
               worst[i] = solution.getObjective(i);
            }
         }
      }
      return worst;
   }

   public boolean hasBetterFitness(final Solution left, final Solution right) {
      return getFitness(left) < getFitness(right);
   }

   public boolean hasWorseFitness(final Solution left, final Solution right) {
      return getFitness(left) > getFitness(right);
   }

   public double[] setEuclideanDistanceToPopulation(final Solution solution, final NondominatedPopulation population) {
      final double[] euclideanDistance = calculateEuclideanDistanceToPopulation(solution, population);
      solution.setAttribute(KEY_EUCLIDEAN_DISTANCE, euclideanDistance);
      return euclideanDistance;
   }

   public double[] setNormalizedObjectives(final Solution solution) {
      final double[] normalizedObjectives = calculateNormalizedObjectives(solution);
      solution.setAttribute(KEY_NORMALIZED_OBJECTIVES, normalizedObjectives);
      return normalizedObjectives;
   }
}
