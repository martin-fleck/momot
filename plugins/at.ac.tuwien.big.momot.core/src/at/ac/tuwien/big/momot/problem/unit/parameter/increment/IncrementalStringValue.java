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
package at.ac.tuwien.big.momot.problem.unit.parameter.increment;

import at.ac.tuwien.big.moea.util.TextUtil;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;

import org.apache.commons.lang.StringUtils;

public class IncrementalStringValue implements IParameterValue<String> {

   public enum StringMode {
      UPPER, LOWER, CAPITALIZED
   }

   private StringMode mode = StringMode.CAPITALIZED;
   private String prefix = "";
   private String suffix = "";
   private final String initialValue;
   private String next;

   public IncrementalStringValue() {
      this(1);
   }

   public IncrementalStringValue(final int startLength) {
      this("", StringUtils.repeat("a", startLength), "", StringMode.LOWER);
   }

   public IncrementalStringValue(final String startString) {
      this("", startString);
   }

   public IncrementalStringValue(final String prefix, final String value) {
      this(prefix, value, "");
   }

   public IncrementalStringValue(final String prefix, final String value, final String suffix) {
      this(prefix, value, suffix, StringMode.LOWER);
   }

   public IncrementalStringValue(final String prefix, final String initialValue, final String suffix,
         final StringMode mode) {
      this.prefix = prefix;
      this.initialValue = initialValue;
      this.next = initialValue;
      this.suffix = suffix;
      this.mode = mode;
   }

   @Override
   public String getInitialValue() {
      return initialValue;
   }

   public StringMode getMode() {
      return mode;
   }

   public String getPrefix() {
      return prefix;
   }

   public String getSuffix() {
      return suffix;
   }

   @Override
   public String nextValue() {
      String toReturn = next;
      next = TextUtil.increment(next);

      switch(mode) {
         case CAPITALIZED:
            toReturn = StringUtils.capitalize(toReturn);
            break;
         case UPPER:
            toReturn = toReturn.toUpperCase();
            break;
         default:
            break;
      }
      return getPrefix() + toReturn + getSuffix();
   }

   public IncrementalStringValue setMode(final StringMode mode) {
      this.mode = mode;
      return this;
   }

   public IncrementalStringValue setPrefix(final String prefix) {
      this.prefix = prefix;
      return this;
   }

   public IncrementalStringValue setSuffix(final String suffix) {
      this.suffix = suffix;
      return this;
   }
}
