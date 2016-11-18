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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.moeaframework.core.variable.RealVariable;

import at.ac.tuwien.big.moea.problem.solution.variable.RandomIntegerVariable;

public class TextUtil {
	private static final int DEFAULT_MAX_DECIMAL_PLACES = 2;
	
	public static final String JAVA_DELIMITER_ESCAPED = "\\.";
	public static final String JAVA_DELIMITER = ".";
	public static final String UML_DELIMITER = "::";
		
	
	protected static final DecimalFormat decimalFormat = new DecimalFormat("#.#");
    static {
    	decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    	decimalFormat.setMaximumFractionDigits(4);
    }
	
	public static String toRangeString(double lowerBound, double upperBound) {
		return "[" + toString(lowerBound) + ", " + toString(upperBound) + "]";
	}
	
	public static String toRangeString(int lowerBound, int upperBound) {
		return "[" + toString(lowerBound) + ", " + toString(upperBound) + "]";
	}
	
	public static String toRangeString(RandomIntegerVariable range) {
		return "[" + range.getLowerBound() + ", " + range.getUpperBound() + "]";
	}
	
	public static String toRangeString(RealVariable range) {
		return "[" + toString(range.getLowerBound()) + ", " + toString(range.getUpperBound()) + "]";
	}
	
	public static String toString(double value) {
		return toString(value, DEFAULT_MAX_DECIMAL_PLACES);
	}
	
	public static String toString(double value, int maxDecimalPlaces) {
		decimalFormat.setMaximumFractionDigits(maxDecimalPlaces);
		return decimalFormat.format(value);
	}
	
	public static String[] split(String text) {
		return text.split("(" + JAVA_DELIMITER_ESCAPED + "|" + UML_DELIMITER + ")");
	}
	
	public static String[] assertSplit(String text, int length) {
		return assertSplit(text, length, "'" + text + "' must have at least " + length + " parts delimited by '.' or '::'.");
	}
	
	public static String[] assertSplit(String text, int length, String message) {
		String[] parts = split(text);
		if(parts.length != length)
			throw new IllegalArgumentException(message);
		return parts;
	}
	
	public static String increment(String text) {
		   int length = text.length();
		   String allButLast = text.substring(0, length - 1);
		   char last = text.charAt(length - 1);

		   if(Character.toLowerCase(last) == 'z') {
		     String result = length > 1 ? increment(allButLast) + 'a' : text + 'a';
		     return result;
		   }
		   return allButLast + ++last;
	}
	
	public static boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}
}
