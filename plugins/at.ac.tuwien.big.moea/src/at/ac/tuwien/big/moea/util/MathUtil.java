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

public final class MathUtil {

   private static final String VECTORS_DIFFERENT_LENGTHS = "Vector v1 and v2 have different lengths";

   public static final long MICROSECONDS_TO_NS = 1000L;

   public static final long MILLISECONS_TO_NS = MICROSECONDS_TO_NS * 1000L;
   public static final long SECONDS_TO_NS = MILLISECONS_TO_NS * 1000L;
   public static final long MINUTES_TO_NS = SECONDS_TO_NS * 60L;
   public static final long HOURS_TO_NS = MINUTES_TO_NS * 60L;
   public static final long DAYS_TO_NS = HOURS_TO_NS * 24L;
   public static final RealVariable ZERO_ONE_RANGE = new RealVariable(0.0, 1.0);

   public static double[] add(final double[] v1, final double[] v2) {
      if(v1.length != v2.length) {
         throw new RuntimeException(VECTORS_DIFFERENT_LENGTHS);
      }

      final double[] result = new double[v1.length];
      for(int i = 0; i < result.length; i++) {
         result[i] = v1[i] + v2[i];
      }

      return result;
   }

   public static double average(final double[] vector) {
      return sum(vector) / vector.length;
   }

   public static double[] colMax(final double[][] matrix) {
      final double[] max = matrix[0].clone();

      for(int col = 0; col < max.length; col++) {
         for(final double[] element : matrix) {
            max[col] = Math.max(max[col], element[col]);
         }
      }
      return max;
   }

   public static double[] colMin(final double[][] matrix) {
      final double[] min = matrix[0].clone();
      for(int col = 0; col < min.length; col++) {
         for(final double[] element : matrix) {
            min[col] = Math.min(min[col], element[col]);
         }
      }
      return min;
   }

   public static double[] divide(final double[] v1, final double[] v2) {
      if(v1.length != v2.length) {
         throw new RuntimeException(VECTORS_DIFFERENT_LENGTHS);
      }

      final double[] result = new double[v1.length];
      for(int i = 0; i < result.length; i++) {
         if(v2[i] != 0) {
            result[i] = v1[i] / v2[i];
         } else if(v1[i] < 0) {
            result[i] = Double.NEGATIVE_INFINITY;
         } else {
            result[i] = Double.POSITIVE_INFINITY;
         }
      }
      return result;
   }

   public static double dotProduct(final double[] v1, final double[] v2) {
      if(v1.length != v2.length) {
         throw new RuntimeException("Vector v1 and v2 have different lengths.");
      }
      double dotProduct = 0;

      for(int i = 0; i < v1.length; i++) {
         dotProduct += v1[i] * v2[i];
      }

      return dotProduct;
   }

   public static double getMean(final Integer[] values) {
      return getMean(Arrays.asList(values));
   }

   public static double getMean(final List<Integer> values) {
      double mean = 0.0;
      if(values != null && values.size() > 0) {
         for(final Integer value : values) {
            mean += value;
         }
         mean /= values.size();
      }
      return mean;
   }

   public static double getStandardDeviation(final Integer[] values) {
      return getStandardDeviation(Arrays.asList(values));
   }

   public static double getStandardDeviation(final List<Integer> values) {
      double deviation = 0.0;
      if(values != null && values.size() > 1) {
         final double mean = getMean(values);
         for(final double value : values) {
            final double delta = value - mean;
            deviation += delta * delta;
         }
         deviation = Math.sqrt(deviation / values.size());
      }
      return deviation;
   }

   public static double getSum(final double... values) {
      double sum = 0.0;
      if(values == null) {
         return sum;
      }

      for(final double value : values) {
         sum += value;
      }
      return sum;
   }

   public static double getSum(final double[]... values) {
      double sum = 0.0;
      if(values == null) {
         return sum;
      }

      for(final double[] value : values) {
         sum += getSum(value);
      }
      return sum;
   }

   public static double getSum(final List<Double> values) {
      double sum = 0.0;
      if(values == null) {
         return sum;
      }

      for(final Double value : values) {
         sum += value;
      }
      return sum;
   }

   public static boolean isWithin(final double value, final RealVariable range) {
      return value >= range.getLowerBound() && value <= range.getUpperBound();
   }

   public static double max(final double... vector) {
      if(vector.length == 0) {
         throw new RuntimeException("Input vector is empty.");
      }

      double min = vector[0];
      for(final double value : vector) {
         if(min < value) {
            min = value;
         }
      }
      return min;
   }

   public static double min(final double[] vector) {
      if(vector.length == 0) {
         throw new RuntimeException("Input vector is empty.");
      }

      double min = vector[0];
      for(final double value : vector) {
         if(min > value) {
            min = value;
         }
      }
      return min;
   }

   public static double[] multiply(final double[] v1, final double[] v2) {
      if(v1.length != v2.length) {
         throw new RuntimeException(VECTORS_DIFFERENT_LENGTHS);
      }

      final double[] result = new double[v1.length];
      for(int i = 0; i < result.length; i++) {
         result[i] = v1[i] * v2[i];
      }

      return result;
   }

   public static double[] normalize(final double[] vector, final double[] minima, final double[] maxima) {
      if(minima.length != maxima.length) {
         throw new RuntimeException("Vector minima and maxima have different lengths.");
      }
      if(vector.length != maxima.length) {
         throw new RuntimeException("Vector vector and maxima have different lengths.");
      }

      final double[] result = new double[vector.length];
      for(int i = 0; i < vector.length; i++) {
         result[i] = (vector[i] - minima[i]) / (maxima[i] - minima[i]);
      }
      return result;
   }

   public static double pNorm(final double[] vector, final double p) {
      double norm = 0;
      final double pd = p;

      for(final double element : vector) {
         norm += Math.pow(Math.abs(element), pd);
      }

      return Math.pow(norm, 1 / pd);
   }

   public static boolean randomBoolean() {
      return PRNG.nextBoolean();
   }

   public static double randomDouble() {
      return PRNG.nextDouble();
   }

   public static int randomInteger(final int n) {
      if(n <= 0) {
         return n;
      }
      return PRNG.nextInt(n);
   }

   public static double rescale(final double value, final double oldScaleMin, final double oldScaleMax,
         final double newScaleMin, final double newScaleMax) {
      return (value - oldScaleMin) / (oldScaleMax - oldScaleMin) * (newScaleMax - newScaleMin) + newScaleMin;
   }

   public static double rescale(final double value, final RealVariable oldScale, final RealVariable newScale) {
      final double newValue = rescale(value, oldScale.getLowerBound(), oldScale.getUpperBound(),
            newScale.getLowerBound(), newScale.getUpperBound());
      return newValue;
   }

   public static double rescale(final RealVariable input, final RealVariable output) {
      output.setValue(rescale(input.getValue(), input, output));
      return output.getValue();
   }

   public static double rescaleZeroOne(final double value, final RealVariable oldScale) {
      return rescale(value, oldScale, ZERO_ONE_RANGE);
   }

   public static double[] subtract(final double[] v1, final double[] v2) {
      if(v1.length != v2.length) {
         throw new RuntimeException(VECTORS_DIFFERENT_LENGTHS);
      }

      final double[] result = new double[v1.length];
      for(int i = 0; i < result.length; i++) {
         result[i] = v1[i] - v2[i];
      }

      return result;
   }

   public static double sum(final double[] v) {
      double sum = 0.0;
      for(final double value : v) {
         sum += value;
      }
      return sum;
   }

   public static long toNanoseconds(final int days, final int hours, final int minutes, final int seconds,
         final int milliseconds) {
      long nanoseconds = 0;
      nanoseconds += days * DAYS_TO_NS;
      nanoseconds += hours * HOURS_TO_NS;
      nanoseconds += minutes * MINUTES_TO_NS;
      nanoseconds += seconds * SECONDS_TO_NS;
      nanoseconds += milliseconds * MILLISECONS_TO_NS;
      return nanoseconds;
   }

   private MathUtil() {}
}
