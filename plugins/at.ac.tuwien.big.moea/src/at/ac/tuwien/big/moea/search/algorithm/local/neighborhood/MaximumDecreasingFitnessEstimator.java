package at.ac.tuwien.big.moea.search.algorithm.local.neighborhood;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimator;

public class MaximumDecreasingFitnessEstimator<S extends Solution> implements IDeltaEstimator<StrangeComparable, S>{

		@Override
		public StrangeComparable getValue(S solution) {
			return new StrangeComparable(solution.getObjectives());
		}

		@Override
		public int compare(S o1, S o2) {
			return getValue(o1).compareTo(getValue(o2));
		}

		@Override
		public double getWorseAmount(S better, S worse) {
			double[] o1o = better.getObjectives();
			double[] o2o = worse.getObjectives();
			double ret = 0.0;
			//Maximum 
			for (int i = 0; i < o1o.length; ++i) {
				if (o2o[i] > o1o[i]) {
					ret = Math.max(ret, (o2o[i]-o1o[i])/(0.0001+Math.abs(o2o[i])));
				}
			}
			return ret*100;
		}
}
