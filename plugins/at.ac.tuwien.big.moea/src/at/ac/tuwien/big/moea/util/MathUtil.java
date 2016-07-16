/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.moea.util;

import java.util.Arrays;
import java.util.List;

import org.moeaframework.core.PRNG;
import org.moeaframework.core.variable.RealVariable;

public class MathUtil {

	public static final long MICROSECONDS_TO_NS = 1000L;
	public static final long MILLISECONS_TO_NS = MICROSECONDS_TO_NS * 1000L;
	public static final long SECONDS_TO_NS = MILLISECONS_TO_NS * 1000L;
	public static final long MINUTES_TO_NS = SECONDS_TO_NS * 60L;
	public static final long HOURS_TO_NS = MINUTES_TO_NS * 60L;
	public static final long DAYS_TO_NS = HOURS_TO_NS * 24L;
	
	public static final RealVariable ZERO_ONE_RANGE = new RealVariable(0.0, 1.0);	
	
	public static long toNanoseconds(int days, int hours, int minutes, int seconds, int milliseconds) {
		long nanoseconds = 0;
		nanoseconds += days * DAYS_TO_NS;
		nanoseconds += hours * HOURS_TO_NS;
		nanoseconds += minutes * MINUTES_TO_NS;
		nanoseconds += seconds * SECONDS_TO_NS;
		nanoseconds += milliseconds * MILLISECONS_TO_NS;
		return nanoseconds;
	}
	
	public static double getMean(Integer[] values) {
		return getMean(Arrays.asList(values));
	}
	
	public static double getMean(List<Integer> values) {
        double mean = 0.0;
        if ((values != null) && (values.size() > 0)) {
            for (Integer value : values) {
                mean += value;
            }
            mean /= values.size();
        }
        return mean;
    }
	
	public static double getSum(double... values) {
        double sum = 0.0;
        if(values == null)
        	return sum;
        
        for(double value : values) {
         	sum += value;
        }
        return sum;
    }
	
	public static double getSum(double[]... values) {
        double sum = 0.0;
        if(values == null)
        	return sum;
        
        for(double[] value : values) {
         	sum += getSum(value);
        }
        return sum;
    }
	
	public static double getSum(List<Double> values) {
        double sum = 0.0;
        if(values == null)
        	return sum;
        
        for(Double value : values) {
         	sum += value;
        }
        return sum;
    }

	public static double getStandardDeviation(Integer[] values) {
		return getStandardDeviation(Arrays.asList(values));
	}
	
    public static double getStandardDeviation(List<Integer> values) {
        double deviation = 0.0;
        if ((values != null) && (values.size() > 1)) {
            double mean = getMean(values);
            for (double value : values) {
                double delta = value-mean;
                deviation += delta*delta;
            }
            deviation = Math.sqrt(deviation/values.size());
        }
        return deviation;
    }
    
    public static double rescale(double value, double oldScaleMin, double oldScaleMax, double newScaleMin, double newScaleMax) {
		return ((value - oldScaleMin) / (oldScaleMax - oldScaleMin)) * (newScaleMax - newScaleMin) + newScaleMin;
	}
	
	public static double rescale(double value, RealVariable oldScale, RealVariable newScale) {
		double newValue = rescale(value, oldScale.getLowerBound(), oldScale.getUpperBound(), newScale.getLowerBound(), newScale.getUpperBound());
		return newValue;
	}
	
	public static double rescaleZeroOne(double value, RealVariable oldScale) {
		return rescale(value, oldScale, ZERO_ONE_RANGE);
	}
	
	public static double rescale(RealVariable input, RealVariable output) {
		output.setValue(rescale(input.getValue(), input, output));
		return output.getValue();
	}
	
	public static int randomInteger(int n) {
		if(n <= 0)
			return n;
		return PRNG.nextInt(n);
	}
	
	public static double randomDouble() {
		return PRNG.nextDouble();
	}
	
	public static boolean randomBoolean() {
		return PRNG.nextBoolean();
	}
	
	public static boolean isWithin(double value, RealVariable range) {
		return value >= range.getLowerBound() && value <= range.getUpperBound();
	}
	
	public static double average(double[] vector) {
		return sum(vector) / vector.length;
	}
	
	public static double min(double[] vector) {
		if(vector.length == 0) 
		    throw new RuntimeException("Input vector is empty.");

		double min = vector[0];
		for(double value : vector) {
		    if(min > value)
		    	min = value;
		}
		return min;
    }
	
	public static double max(double... vector) {
		if(vector.length == 0) 
		    throw new RuntimeException("Input vector is empty.");

		double min = vector[0];
		for(double value : vector) {
		    if(min < value)
		    	min = value;
		}
		return min;
    }
	
	public static double sum(double[] v) {
		double sum = 0.0;
		for(double value : v) 
		    sum += value;
		return sum;
	}
	
	public static double[] add(double[] v1, double[] v2) {
		if(v1.length != v2.length) 
		    throw new RuntimeException("Vector v1 and v2 have different lengths");

		double[] result = new double[v1.length];
		for(int i = 0; i < result.length; i++)
		    result[i] = v1[i] + v2[i];

		return result;
	}
	
	public static double[] subtract(double[] v1, double[] v2) {
		if(v1.length != v2.length) 
		    throw new RuntimeException("Vector v1 and v2 have different lengths");

		double[] result = new double[v1.length];
		for(int i = 0; i < result.length; i++)
		    result[i] = v1[i] - v2[i];

		return result;
	}
	
	public static double[] multiply(double[] v1, double[] v2) {
		if(v1.length != v2.length) 
		    throw new RuntimeException("Vector v1 and v2 have different lengths");

		double[] result = new double[v1.length];
		for(int i = 0; i < result.length; i++)
		    result[i] = v1[i] * v2[i];

		return result;
	}
	
	public static double[] divide(double[] v1, double[] v2) {
		if(v1.length != v2.length) 
		    throw new RuntimeException("Vector v1 and v2 have different lengths");

		double[] result = new double[v1.length];
		for(int i = 0; i < result.length; i++) {
		    if(v2[i] != 0)
		    	result[i] = v1[i] / v2[i];
		    else if(v1[i] < 0) 
			    result[i] = Double.NEGATIVE_INFINITY;
			else
			    result[i] = Double.POSITIVE_INFINITY;
		}
		return result;
    }
	
    public static double[] colMin(double[][] matrix) {
    	double[] min = matrix[0].clone();
    	for(int col = 0; col < min.length; col++) {
    		for(int row = 0; row < matrix.length; row++) {
    			min[col] = Math.min(min[col], matrix[row][col]);
    		}
    	}
    	return min;
    }

    public static double[] colMax(double[][] matrix) {
    	double[] max = matrix[0].clone();

    	for(int col = 0; col < max.length; col++) {
    		for(int row = 0; row < matrix.length; row++) {
    			max[col] = Math.max(max[col], matrix[row][col]);
    		}
    	}
    	return max;
    }

    public static double dotProduct(double[] v1, double[] v2) {
    	if(v1.length != v2.length) 
    		throw new RuntimeException("Vector v1 and v2 have different lengths.");
    	double dotProduct = 0;
    	
    	for(int i = 0; i < v1.length; i++)
    		dotProduct += v1[i] * v2[i];

    	return dotProduct;
    }
    
    public static double pNorm(double[] vector, double p) {
    	double norm = 0;
    	double pd = p;

    	for(int i = 0; i < vector.length; i++) 
    	    norm += Math.pow(Math.abs(vector[i]), pd);

    	return Math.pow(norm, 1 / pd);
    }
    
    public static double[] normalize(double[] vector, double[] minima, double[] maxima) {
    	if(minima.length != maxima.length) 
    		throw new RuntimeException("Vector minima and maxima have different lengths.");
    	if(vector.length != maxima.length) 
    		throw new RuntimeException("Vector vector and maxima have different lengths.");
    	
    	double[] result = new double[vector.length];
    	for(int i = 0; i < vector.length; i++) 
    	    result[i] = (vector[i] - minima[i]) / (maxima[i] - minima[i]);
    	return result;
    }    	
}
