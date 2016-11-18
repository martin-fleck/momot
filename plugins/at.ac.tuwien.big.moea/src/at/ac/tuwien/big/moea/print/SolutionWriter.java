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
package at.ac.tuwien.big.moea.print;

import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;

import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

public class SolutionWriter<S extends Solution> implements ISolutionWriter<S> {
   private static final String NEWLINE = "\n";

   private static final String SEPARATOR = ": ";

   public static String printObject(final Object value) {
      if(value == null) {
         return "<null>";
      }
      if(value instanceof Serializable) {
         return printSerializable((Serializable) value);
      }
      return value.toString();
   }

   public static String printSerializable(final Serializable value) {
      if(value instanceof boolean[]) {
         return Arrays.toString((boolean[]) value);
      }
      if(value instanceof byte[]) {
         return Arrays.toString((byte[]) value);
      }
      if(value instanceof char[]) {
         return Arrays.toString((char[]) value);
      }
      if(value instanceof double[]) {
         return Arrays.toString((double[]) value);
      }
      if(value instanceof float[]) {
         return Arrays.toString((float[]) value);
      }
      if(value instanceof int[]) {
         return Arrays.toString((int[]) value);
      }
      if(value instanceof long[]) {
         return Arrays.toString((long[]) value);
      }
      if(value instanceof Object[]) {
         return Arrays.toString((Object[]) value);
      }
      if(value instanceof Map.Entry<?, ?>) {
         return printObject(((Map.Entry<?, ?>) value).getKey()) + " = "
               + printObject(((Map.Entry<?, ?>) value).getValue());
      }
      return value + "";
   }

   private final Map<Integer, String> objectiveNames = new HashMap<>();

   private final Map<Integer, String> variableNames = new HashMap<>();

   private final Map<Integer, String> constraintNames = new HashMap<>();
   private String indent = "";
   private boolean writeVariables = true;
   private boolean writeObjectives = true;

   private boolean writeConstraints = true;
   private boolean writeAttributes = true;

   private boolean writeSummaries = true;

   private boolean writePlaceholders = true;

   @Override
   public ISolutionWriter<S> addConstraintName(final int index, final String name) {
      constraintNames.put(index, name);
      return this;
   }

   @Override
   public ISolutionWriter<S> addObjectiveName(final int index, final String name) {
      objectiveNames.put(index, name);
      return this;
   }

   @Override
   public ISolutionWriter<S> addVariableName(final int index, final String name) {
      variableNames.put(index, name);
      return this;
   }

   protected SolutionWriter<S> decreaseIndent(final int spaces) {
      return setIndent(StringUtils.repeat(' ', getIndent().length() - spaces));
   }

   public String getConstraintData(final double constraint) {
      return "" + constraint;
   }

   @Override
   public String getConstraintData(final S solution, final int index) {
      return getConstraintData(solution.getConstraint(index));
   }

   @Override
   public String getConstraintName(final int index) {
      return getNameOrIndex(index, constraintNames, "Constraint");
   }

   protected String getIndent() {
      return indent;
   }

   protected String getNameOrIndex(final int index, final Map<Integer, String> map, final String topic) {
      final String name = map.get(index);
      if(name == null) {
         return topic + "[" + String.valueOf(index) + "]";
      }
      return name;
   }

   public String getObjectiveData(final double objective) {
      return "" + objective;
   }

   @Override
   public String getObjectiveData(final S solution, final int index) {
      return getObjectiveData(solution.getObjective(index));
   }

   @Override
   public String getObjectiveName(final int index) {
      return getNameOrIndex(index, objectiveNames, "Objective");
   }

   @Override
   public String getVariableData(final S solution, final int index) {
      return getVariableData(solution.getVariable(index));
   }

   public String getVariableData(final Variable variable) {
      return variable.toString();
   }

   @Override
   public String getVariableName(final int index) {
      return getNameOrIndex(index, variableNames, "Variable");
   }

   protected SolutionWriter<S> increaseIndent(final int spaces) {
      return setIndent(StringUtils.repeat(' ', spaces + getIndent().length()));
   }

   protected String printAttribute(final String key, final Serializable value) {
      return getIndent() + printObject(key) + SEPARATOR + printObject(value) + NEWLINE;
   }

   protected String printAttributes(final S solution) {
      String txt = "";
      for(final Entry<String, Serializable> entry : solution.getAttributes().entrySet()) {
         txt += printAttribute(entry.getKey(), entry.getValue());
      }
      return txt;
   }

   protected String printAttributeSummary(final S solution) {
      return getIndent() + "Number of attributes: " + solution.getAttributes().size() + NEWLINE;
   }

   protected String printConstraint(final int index, final double constraint) {
      return getIndent() + getConstraintName(index) + SEPARATOR + getConstraintData(constraint) + NEWLINE;
   }

   protected String printConstraints(final S solution) {
      String txt = "";
      for(int i = 0; i < solution.getNumberOfConstraints(); i++) {
         txt += printConstraint(i, solution.getConstraint(i));
      }
      return txt;
   }

   protected String printConstraintSummary(final S solution) {
      return getIndent() + "Number of constraints: " + solution.getNumberOfConstraints() + NEWLINE;
   }

   protected String printObjective(final int index, final double objective) {
      return getIndent() + getObjectiveName(index) + SEPARATOR + getObjectiveData(objective) + NEWLINE;
   }

   protected String printObjectives(final S solution) {
      String txt = "";
      for(int i = 0; i < solution.getNumberOfObjectives(); i++) {
         txt += printObjective(i, solution.getObjective(i));
      }
      return txt;
   }

   protected String printObjectiveSummary(final S solution) {
      return getIndent() + "Number of objectives: " + solution.getNumberOfObjectives() + NEWLINE;
   }

   protected String printVariable(final int index, final Variable variable) {
      if(!writePlaceholders() && variable instanceof IPlaceholderVariable) {
         return "";
      }
      return getIndent() + getVariableName(index) + SEPARATOR + getVariableData(variable) + NEWLINE;
   }

   protected String printVariables(final S solution) {
      String txt = "";
      for(int i = 0; i < solution.getNumberOfVariables(); i++) {
         txt += printVariable(i, solution.getVariable(i));
      }
      return txt;
   }

   protected String printVariableSummary(final S solution) {
      final String info = writePlaceholders() ? "" : " (placeholders are skipped)";
      return getIndent() + "Number of variables: " + solution.getNumberOfVariables() + info + NEWLINE;
   }

   protected SolutionWriter<S> resetIndent() {
      return setIndent("");
   }

   @Override
   public ISolutionWriter<S> setConstraintNames(final Iterable<String> names) {
      int i = 0;
      for(final String name : names) {
         addConstraintName(i++, name);
      }
      return this;
   }

   protected SolutionWriter<S> setIndent(final int spaces) {
      return setIndent(StringUtils.repeat(' ', spaces));
   }

   protected SolutionWriter<S> setIndent(final String indent) {
      this.indent = indent;
      return this;
   }

   @Override
   public ISolutionWriter<S> setObjectiveNames(final Iterable<String> names) {
      int i = 0;
      for(final String name : names) {
         addObjectiveName(i++, name);
      }
      return this;
   }

   public ISolutionWriter<S> setPrintAttributes(final boolean printAttributes) {
      this.writeAttributes = printAttributes;
      return this;
   }

   public ISolutionWriter<S> setPrintConstraints(final boolean printConstraints) {
      this.writeConstraints = printConstraints;
      return this;
   }

   public ISolutionWriter<S> setPrintObjectives(final boolean printObjectives) {
      this.writeObjectives = printObjectives;
      return this;
   }

   @Override
   public ISolutionWriter<S> setPrintPlaceholders(final boolean printPlaceholders) {
      this.writePlaceholders = printPlaceholders;
      return this;
   }

   public ISolutionWriter<S> setPrintSummaries(final boolean printSummaries) {
      this.writeSummaries = printSummaries;
      return this;
   }

   public ISolutionWriter<S> setPrintVariables(final boolean printVariables) {
      this.writeVariables = printVariables;
      return this;
   }

   @Override
   public ISolutionWriter<S> setVariableNames(final Iterable<String> names) {
      int i = 0;
      for(final String name : names) {
         addVariableName(i++, name);
      }
      return this;
   }

   @Override
   public void write(final PrintStream ps, final S solution) {
      if(solution == null) {
         ps.println("empty-solution");
      }

      resetIndent();

      if(writeSummaries()) {
         setIndent(0);
         ps.print(printVariableSummary(solution));
         setIndent(2);
      }
      if(writeVariables()) {
         ps.print(printVariables(solution));
      }

      if(writeSummaries()) {
         setIndent(0);
         ps.print(printAttributeSummary(solution));
         setIndent(2);
      }
      if(writeAttributes()) {
         ps.print(printAttributes(solution));
      }

      if(writeSummaries()) {
         setIndent(0);
         ps.print(printObjectiveSummary(solution));
         setIndent(2);
      }
      if(writeObjectives()) {
         ps.print(printObjectives(solution));
      }

      if(writeSummaries()) {
         setIndent(0);
         ps.print(printConstraintSummary(solution));
         setIndent(2);
      }
      if(writeConstraints()) {
         ps.print(printConstraints(solution));
      }
   }

   @Override
   public String write(final S solution) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream ps = new PrintStream(baos);
      write(ps, solution);
      ps.close();
      try {
         return baos.toString("UTF-8");
      } catch(final UnsupportedEncodingException e) {
         return e.getMessage();
      }
   }

   @Override
   public boolean writeAttributes() {
      return writeAttributes;
   }

   @Override
   public boolean writeConstraints() {
      return writeConstraints;
   }

   @Override
   public boolean writeObjectives() {
      return writeObjectives;
   }

   @Override
   public boolean writePlaceholders() {
      return this.writePlaceholders;
   }

   @Override
   public boolean writeSummaries() {
      return writeSummaries;
   }

   @Override
   public boolean writeVariables() {
      return writeVariables;
   }
}
