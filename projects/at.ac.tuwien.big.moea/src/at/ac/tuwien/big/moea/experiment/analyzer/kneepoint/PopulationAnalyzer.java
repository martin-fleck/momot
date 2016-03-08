package at.ac.tuwien.big.moea.experiment.analyzer.kneepoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.Pair;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.util.MathUtil;

/**
 * This class is based on a similar class of  
 * jMetalPlus: An enhanced version of the jMetal framework by marlonso
 * https://sourceforge.net/projects/jmetalbymarlonso/
 */
public class PopulationAnalyzer {
	
	protected static final String KEY_NORMALIZED_OBJECTIVES = "momot_normalizedObjectives";
	protected static final String KEY_EUCLIDEAN_DISTANCE = "momot_euclideanDistance";
	protected static final String KEY_FITNESS = "momot_fitness";
	
	protected NondominatedPopulation referenceSet;
	protected int numberOfObjectives;

	public PopulationAnalyzer() { }
	
	public PopulationAnalyzer(NondominatedPopulation referenceSet) {
		this.referenceSet = referenceSet;
		if(referenceSet != null && !referenceSet.isEmpty())
			numberOfObjectives = referenceSet.get(0).getNumberOfObjectives();
	}
	
	public int getNumberOfObjectives() {
		return numberOfObjectives;
	}
	
	public NondominatedPopulation getReferenceSet() {
		return referenceSet;
	}
	
	public double[] getBestObjectives() {
		double[] best = new double[getNumberOfObjectives()];
		for(int i = 0; i < getNumberOfObjectives(); i++)
			best[i] = Double.POSITIVE_INFINITY;
		
		for(Solution solution : referenceSet) {
			for(int i = 0; i < getNumberOfObjectives(); i++)
				if(solution.getObjective(i) < best[i])
					best[i] = solution.getObjective(i);
		}
		return best;
	}
	
	public double[] getWorstObjectives() {
		double[] worst = new double[getNumberOfObjectives()];
		for(int i = 0; i < getNumberOfObjectives(); i++)
			worst[i] = Double.NEGATIVE_INFINITY;
		
		for(Solution solution : referenceSet) {
			for(int i = 0; i < getNumberOfObjectives(); i++)
				if(solution.getObjective(i) > worst[i])
					worst[i] = solution.getObjective(i);
		}
		return worst;
	}	
	
	public Solution getNormalizedSolution(Solution solution) {
		Solution normalizedSolution = solution.copy();
		normalizedSolution.getAttributes().putAll(solution.getAttributes());
		normalizedSolution.setAttribute("momot_original_objectives", solution.getObjectives());
		normalizedSolution.setObjectives(calculateNormalizedObjectives(solution));
		return normalizedSolution;
	}
	
	public NondominatedPopulation getNormalizedPopulation(NondominatedPopulation population) {
		NondominatedPopulation normalizedPopulation = new NondominatedPopulation(getReferenceSet().getComparator());
		for(Solution solution : population) 
			normalizedPopulation.add(getNormalizedSolution(solution));
		return normalizedPopulation;
	}
	
	
	public double[] calculateNormalizedObjectives(Solution solution) {
		return MathUtil.normalize(solution.getObjectives(), getBestObjectives(), getWorstObjectives());
	}
	
	public double[] getNormalizedObjectives(Solution solution) {
		double[] normalizedObjectives = (double[]) solution.getAttribute(KEY_NORMALIZED_OBJECTIVES);
		if(normalizedObjectives == null)
			return setNormalizedObjectives(solution);
		return normalizedObjectives;
	}
	
	public double[] setNormalizedObjectives(Solution solution) {
		double[] normalizedObjectives = calculateNormalizedObjectives(solution);
		solution.setAttribute(KEY_NORMALIZED_OBJECTIVES, normalizedObjectives);
		return normalizedObjectives;
	}	
	
	public double[] calculateEuclideanDistanceToPopulation(Solution solution, NondominatedPopulation population) {
		double[] distance = new double[population.size()];

		for (int i = 0; i < distance.length; i++) 
		    distance[i] = calculateEuclideanDistance(solution, population.get(i));
		
		return distance;
	}
	
	public double[] getEuclideanDistanceToPopulation(Solution solution, NondominatedPopulation population) {
		double[] euclideanDistance = (double[]) solution.getAttribute(KEY_EUCLIDEAN_DISTANCE);
		if(euclideanDistance == null)
			return setEuclideanDistanceToPopulation(solution, population);
		return euclideanDistance;
	}
	
	public double[] setEuclideanDistanceToPopulation(Solution solution, NondominatedPopulation population) {
		double[] euclideanDistance = calculateEuclideanDistanceToPopulation(solution, population);
		solution.setAttribute(KEY_EUCLIDEAN_DISTANCE, euclideanDistance);
		return euclideanDistance;
	}
	
	public double calculateEuclideanDistance(Solution left, Solution right) {
		return calculateEuclideanDistance(
				getNormalizedObjectives(left), 
				getNormalizedObjectives(right));
	}
	
	public double calculateEuclideanDistance(double[] left, double[] right) {
		double diff; // Auxiliar var
		double distance = 0.0;
		for (int i = 0; i < left.length; i++) {
			diff = left[i] - right[i];
			distance += Math.pow(diff, 2.0);
		} 

		return Math.sqrt(distance);
	}
	
	public double getFitness(Solution solution) {
		Double fitness = (Double) solution.getAttribute(KEY_FITNESS);
		if(fitness == null)
			throw new IllegalArgumentException("No fitness has been assigned.");
		return fitness;
	}
	
	public boolean hasBetterFitness(Solution left, Solution right) {
		return getFitness(left) < getFitness(right);
	}
	
	public boolean hasWorseFitness(Solution left, Solution right) {
		return getFitness(left) > getFitness(right);
	}
	
	public enum FitnessComparison {
		OBJECTIVE_SUM,
		EGALITARIAN,
		CHEBY_SHEV,
		COBB_DOUGLAS,
		NASH,
		PROPER_UTILITY,
		PNORM
	}
	
	public NondominatedPopulation getKneePointSolutions(NondominatedPopulation population, int neighborhoodSize, FitnessComparison comparison) {
		NondominatedPopulation knees = new NondominatedPopulation();
		if(neighborhoodSize > population.size() - 1) {
//			System.err.println("Warning: There are not enough solutions in the population to fulfill a neighborhood size of " + neighborhoodSize + ".");
			System.out.println("The neighborhood size will be set to the maximum neighborhood (n-1): " + (population.size() - 1));
			neighborhoodSize = population.size() - 1;
		}
			
		NondominatedPopulation normalizedPopulation = getNormalizedPopulation(population);
		Fitness fitness = new Fitness(normalizedPopulation);
		
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
		case PROPER_UTILITY:
			fitness.properUtility();
			break;
		}
		
		for(Solution solution : normalizedPopulation) {
			Double[] distances = ArrayUtils.toObject(getEuclideanDistanceToPopulation(solution, normalizedPopulation));
			Integer[] indices = indicesInUnsortedArray(distances);
			
			boolean isKnee = true;
			for(int i = 1; i < neighborhoodSize + 1; i++) { // first solution is the same (distance 0)
				Solution otherSolution = normalizedPopulation.get(indices[i]);
				if(hasWorseFitness(solution, otherSolution)) {
					isKnee = false;
					break;
				}
			}
			if(isKnee)
				knees.add(solution);
		}
		return knees;
	}
	
	public Solution getBestSolution(NondominatedPopulation population, FitnessComparison comparison) {				
		NondominatedPopulation normalizedPopulation = getNormalizedPopulation(population);
		
		Fitness fitness = new Fitness(normalizedPopulation);
		
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
			case PROPER_UTILITY:
				fitness.properUtility();
				break;
		}
		
		ArrayList<Solution> sortedPopulation = new ArrayList<Solution>(normalizedPopulation.size());
		for(Solution solution : normalizedPopulation)
			sortedPopulation.add(solution);
		Collections.sort(sortedPopulation, new Comparator<Solution>() {
			@Override
			public int compare(Solution left, Solution right) {
				return Double.compare(getFitness(left), getFitness(right));
			}
		});
		return sortedPopulation.get(0);
	}
	
	public static <K extends Comparable<K>> Integer[] indicesInUnsortedArray(K[] array) {
		ArrayList<Pair<Integer,K>> pairs = new ArrayList<Pair<Integer, K>>();
		
		for(int i = 0 ; i < array.length ; i++) {
		    pairs.add(new Pair<Integer, K>(i, array[i]));
		}
		Collections.sort(pairs, new Comparator<Pair<Integer, K>>() {
			@Override
			public int compare(Pair<Integer, K> pair1, Pair<Integer, K> pair2) {
				return pair1.getValue().compareTo(pair2.getValue());
			}
		});
		
		Integer[] indices = new Integer[array.length];
		for(int i = 0 ; i < array.length ; i++) 
		    indices[i] = pairs.get(i).getFirst();
		
		return indices;
    }
}
