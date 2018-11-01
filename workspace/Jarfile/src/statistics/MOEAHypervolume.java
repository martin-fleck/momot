package statistics;

import java.nio.file.attribute.PosixFilePermission;
import java.util.List;

import statistics.SingleResult.DominationState;

public class MOEAHypervolume {

	
	public static double calculateHypervolume(List<SingleResult> population) {
		return calculateHypervolume(population,population.size(),population.get(0).getObjectiveCount());
	}
	
	/**
	 * The internal, unnormalized hypervolume calculation.  While this method
	 * is public, we do not encourage its use since incorrect arguments can
	 * cause unexpected behavior.  Instead, use the
	 * {@link #Hypervolume(Problem, NondominatedPopulation)} constructor
	 * to create a normalizing version of the hypervolume calculation.
	 * 
	 * @param population the population
	 * @param numberOfSolutions the number of solutions
	 * @param numberOfObjectives the number of objectives
	 * @return the hypervolume metric
	 */
	public static double calculateHypervolume(List<SingleResult> population,
			int numberOfSolutions, int numberOfObjectives) {
		double volume = 0.0;
		double distance = 0.0;
		int n = numberOfSolutions;

		while (n > 0) {
			int numberOfNondominatedPoints = filterNondominatedSet(population,
					n, numberOfObjectives - 1);
			
			double tempVolume = 0.0;
			if (numberOfObjectives < 3) {
				tempVolume = population.get(0).getObjective(0);
			} else {
				tempVolume = calculateHypervolume(population,
						numberOfNondominatedPoints, numberOfObjectives - 1);
			}

			double tempDistance = surfaceUnchangedTo(population, n,
					numberOfObjectives - 1);
			volume += tempVolume * (tempDistance - distance);
			distance = tempDistance;
			n = reduceNondominatedSet(population, n, numberOfObjectives - 1,
					distance);
		}

		return volume;
	}
	

	/*
	 * calculate next value regarding dimension 'objective'; consider points
	 * 0..no_points-1 in 'front'
	 */
	private static double surfaceUnchangedTo(List<SingleResult> population,
			int numberOfSolutions, int objective) {
		double min = population.get(0).getObjective(objective);

		for (int i = 1; i < numberOfSolutions; i++) {
			min = Math.min(min, population.get(i).getObjective(objective));
		}

		return min;
	}
	

	/*
	 * remove all points which have a value <= 'threshold' regarding the
	 * dimension 'objective'; the points [0..no_points-1] in 'front' are
	 * considered; 'front' is resorted, such that points [0..n-1] represent the
	 * remaining points; 'n' is returned
	 */
	private static int reduceNondominatedSet(List<SingleResult> population,
			int numberOfSolutions, int objective, double threshold) {
		int n = numberOfSolutions;

		for (int i = 0; i < n; i++) {
			if (population.get(i).getObjective(objective) <= threshold) {
				n--;
				swap(population, i, n);
			}
		}

		return n;
	}
	
	/**
	 * Swaps the {@code i}th and {@code j}th indices in the population.
	 * 
	 * @param population the population
	 * @param i the first index to be swapped
	 * @param j the second index to be swapped
	 */
	private static void swap(List<SingleResult> population, int i, int j) {
		SingleResult temp = population.get(i);
		population.set(i, population.get(j));
		population.set(j, temp);
	}
	
	/*
	 * all nondominated points regarding the first 'no_objectives' dimensions
	 * are collected; the points 0..no_points-1 in 'front' are considered; the
	 * points in 'front' are resorted, such that points [0..n-1] represent the
	 * nondominated points; n is returned
	 */
	private static int filterNondominatedSet(List<SingleResult> population,
			int numberOfSolutions, int numberOfObjectives) {
		int i = 0;
		int n = numberOfSolutions;

		while (i < n) {
			int j = i + 1;
			while (j < n) {
				DominationState state = population.get(i).doesDominate(population.get(j), numberOfObjectives);
				if (state == DominationState.DOMINATES) {
					/* remove point j */
					n--;
					swap(population, j, n);
				} else if (state == DominationState.DOMINATED) {
					/*
					 * remove point i; ensure that the point copied to index i
					 * is considered in the next outer loop (thus, decrement i)
					 */
					n--;
					swap(population, i, n);
					i--;
					break;
				} else {
					j++;
				}
			}

			i++;
		}

		return n;
	}

}
