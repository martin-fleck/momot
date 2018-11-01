package statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticalValue {
	
	private List<Double> vals = new ArrayList<>();
	private double sum;
	private double sum2;
	private double min = Double.POSITIVE_INFINITY;
	private double max = Double.NEGATIVE_INFINITY;
	
	public double getAvg() {
		return vals.isEmpty()?0.0:sum/vals.size();
	}
	
	public double getMin() {
		return min;
	}
	
	public double getMax() {
		return max;
	}
	
	public void add(double d) {
		vals.add(d);
		sum+= d;
		sum2+= d*d;
		min = Math.min(min, d);
		max = Math.max(max, d);
	}
	

}
