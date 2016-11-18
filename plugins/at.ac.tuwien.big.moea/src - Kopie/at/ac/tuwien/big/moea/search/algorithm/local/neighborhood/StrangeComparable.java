package at.ac.tuwien.big.moea.search.algorithm.local.neighborhood;

import java.io.Serializable;
import java.util.Arrays;


/**Not a valid comparable ... it is not total*/
public class StrangeComparable implements Comparable<StrangeComparable>, Serializable {
		private static final long serialVersionUID = -6222177481819319781L;
		private double[] vals;
		
		public StrangeComparable(double[] vals) {
			this.vals = vals; 
		}
		
		@Override
		public int compareTo(StrangeComparable other) {
			double[] o1o = this.vals;
			double[] o2o = other.vals;
			boolean o1Dominating = true;
			boolean o2Dominating = true;
			for (int i = 0; i < o1o.length; ++i) {
				if (o1o[i] < o2o[i]) {
					o2Dominating = false;
				} else if (o1o[i] > o2o[i]) {
					o1Dominating = false;
				}
			}
			if (o1Dominating) {
				return o2Dominating?0:-1;
			}
			return o2Dominating?1:0;
		}
		
		public String toString() {
			return "Objectives: "+Arrays.toString(vals);
		}

	}