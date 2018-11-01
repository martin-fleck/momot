package statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SingleResult {
	
	private double[] vals;
	
	public SingleResult inverted1() {
		SingleResult ret = clone();
		for (int i = 0; i < ret.vals.length; ++i) {
			ret.vals[i] = 1.0-ret.vals[i];
		}
		return ret;
	}
	
	public SingleResult(double... vals) {
		this.vals = vals;
	}
	
	public static enum DominationState {
		DOMINATES, DOMINATED, NONDOMINATED, EQUAL;
	}
	public DominationState doesDominate(SingleResult other) {
		return doesDominate(other, Math.min(vals.length, other.vals.length));
	}
			
	
	public DominationState doesDominate(SingleResult other, int numberOfObjectives) {
		boolean thisSmaller = false;
		boolean otherSmaller = false;
		for (int i = 0; i < numberOfObjectives; ++i) {
			int cmp = Double.compare(vals[i], other.vals[i]);
			if (cmp < 0) {
				thisSmaller = true;
			} else {
				otherSmaller = true;
			}
		}
		if (thisSmaller) {
			if (otherSmaller) {
				return DominationState.NONDOMINATED;
			} else {
				return DominationState.DOMINATED;
			}
		} else {
			if (otherSmaller) {
				return DominationState.DOMINATES;
			} else {
				return DominationState.EQUAL;
			}
		}
	}
	
	public void mergeMin(SingleResult res) {
		for (int i = 0; i < res.vals.length; ++i) {
			vals[i] = Math.min(vals[i], res.vals[i]);
		}
	}
	
	public SingleResult clone() {
		return new SingleResult(Arrays.copyOf(vals, vals.length));
	}
	
	public void normalize(SingleResult min, SingleResult max) {
		for (int i = 0; i < vals.length; ++i) {
			double delta = max.vals[i]-min.vals[i];
			if (delta != 0.0) {
				if (Double.isFinite(vals[i])) {
					vals[i] = (vals[i]-min.vals[i])/(delta);
				} else {
					if (vals[i] > 0.0) {
						vals[i] = 1.0;
					} else {
						vals[i] = 0.0;
					}
				}
			} else {
				vals[i] = 0.5;
			}
		}
		vals[0] = vals[0];
	}
	
	public SingleResult normalized(SingleResult min, SingleResult max) {
		SingleResult ret = clone();
		ret.normalize(min, max);
		return ret;
	}
	
	public static SingleResult getMin(Collection<? extends SingleResult> input) {
		Iterator<? extends SingleResult> iter = input.iterator();
		SingleResult sr = null;
		if (iter.hasNext()) {
			SingleResult ir = iter.next();
			sr = ir.clone();
		}
		while (iter.hasNext()) {
			SingleResult ir = iter.next();
			sr.mergeMin(ir);	
		}
		return sr;
	}
	

	public void mergeMax(SingleResult res) {
		for (int i = 0; i < res.vals.length; ++i) {
			vals[i] = Math.max(vals[i], res.vals[i]);
		}
	}
	
	public static SingleResult getMax(Collection<? extends SingleResult> input) {
		Iterator<? extends SingleResult> iter = input.iterator();
		SingleResult sr = null;
		if (iter.hasNext()) {
			SingleResult ir = iter.next();
			sr = ir.clone();
		}
		while (iter.hasNext()) {
			SingleResult ir = iter.next();
			sr.mergeMax(ir);	
		}
		return sr;
	}
	
	public static List<SingleResult> getParetoSet(Collection<? extends SingleResult> input) {
		List<SingleResult> ret = new ArrayList<>();
		mainLoop: for (SingleResult sr: input) {
			Iterator<SingleResult> iter = ret.iterator();
			while (iter.hasNext()) {
				SingleResult u = iter.next();
				DominationState ds = u.doesDominate(sr);
				if (ds == DominationState.DOMINATES || ds == DominationState.EQUAL) {
					continue mainLoop;
				} else if (ds == DominationState.DOMINATED) {
					iter.remove();
				}
			}
			ret.add(sr);
		}
		return ret;
	}

	public double getObjective(int i) {
		return vals[i];
	}

	public int getObjectiveCount() {
		return vals.length;
	}


	public double getEuclideanDistance(SingleResult act) {
		double ret = 0.0;
		for (int i = 0; i < vals.length; ++i) {
			double diff = vals[i]-act.vals[i];
			ret+= diff*diff;
		}
		return Math.sqrt(ret);
	}
	
	public String toString() {
		return Arrays.toString(vals);
	}

}
