package statistics;

import java.nio.file.attribute.PosixFilePermission;
import java.util.Collection;
import java.util.List;

import statistics.SingleResult.DominationState;

public class MOEAIGD {
	
	private static double POW_FACTOR = 1.0;
	
	public static double evaluate(
			Collection<? extends SingleResult> actualSolutions,
			Collection<? extends SingleResult> bestSolutions) {
		double sum = 0.0;

		for (SingleResult sr: bestSolutions) {
			sum += Math.pow(distanceToNearestSolution(
					sr, actualSolutions), POW_FACTOR);
		}

		return Math.pow(sum, 1.0 / POW_FACTOR) / bestSolutions.size();
	}

	private static double distanceToNearestSolution(SingleResult sr,
			Collection<? extends SingleResult> actualSolutions) {
		double ret = Double.POSITIVE_INFINITY;
		for (SingleResult act: actualSolutions) {
			ret = Math.min(ret, sr.getEuclideanDistance(act));
		}
		return ret;
	}
}
