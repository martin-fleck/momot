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

import at.ac.tuwien.big.moea.problem.solution.variable.RandomIntegerVariable;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.moeaframework.core.variable.RealVariable;

public final class TextUtil {

   private static final String RANGE_START = "[";

   private static final String RANGE_END = "]";

   private static final String RANGE_DELIMITER = ", ";

   private static final int MAX_FRACTION_DIGITS = 4;

   private static final int DEFAULT_MAX_DECIMAL_PLACES = 2;

   public static final String JAVA_DELIMITER_ESCAPED = "\\.";

   public static final String JAVA_DELIMITER = ".";
   public static final String UML_DELIMITER = "::";
   protected static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");

   static {
      DECIMAL_FORMAT.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
      DECIMAL_FORMAT.setMaximumFractionDigits(MAX_FRACTION_DIGITS);
   }

   public static String[] assertSplit(final String text, final int length) {
      return assertSplit(text, length,
            "'" + text + "' must have at least " + length + " parts delimited by '.' or '::'.");
   }

   public static String[] assertSplit(final String text, final int length, final String message) {
      final String[] parts = split(text);
      if(parts.length != length) {
         throw new IllegalArgumentException(message);
      }
      return parts;
   }

   public static String increment(final String text) {
      final int length = text.length();
      final String allButLast = text.substring(0, length - 1);
      char last = text.charAt(length - 1);

      if(Character.toLowerCase(last) == 'z') {
         final String result = length > 1 ? increment(allButLast) + 'a' : text + 'a';
         return result;
      }
      return allButLast + ++last;
   }

   public static boolean isEmpty(final String value) {
      return value == null || value.isEmpty();
   }

   public static String[] split(final String text) {
      return text.split("(" + JAVA_DELIMITER_ESCAPED + "|" + UML_DELIMITER + ")");
   }

   public static String toRangeString(final double lowerBound, final double upperBound) {
      return RANGE_START + toString(lowerBound) + RANGE_DELIMITER + toString(upperBound) + RANGE_END;
   }

   public static String toRangeString(final int lowerBound, final int upperBound) {
      return RANGE_START + toString(lowerBound) + RANGE_DELIMITER + toString(upperBound) + RANGE_END;
   }

   public static String toRangeString(final RandomIntegerVariable range) {
      return RANGE_START + range.getLowerBound() + RANGE_DELIMITER + range.getUpperBound() + RANGE_END;
   }

   public static String toRangeString(final RealVariable range) {
      return RANGE_START + toString(range.getLowerBound()) + RANGE_DELIMITER + toString(range.getUpperBound())
            + RANGE_END;
   }

   public static String toString(final double value) {
      return toString(value, DEFAULT_MAX_DECIMAL_PLACES);
   }

   public static String toString(final double value, final int maxDecimalPlaces) {
      DECIMAL_FORMAT.setMaximumFractionDigits(maxDecimalPlaces);
      return DECIMAL_FORMAT.format(value);
   }

   private TextUtil() {}
}
