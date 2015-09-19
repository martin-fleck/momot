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
}
