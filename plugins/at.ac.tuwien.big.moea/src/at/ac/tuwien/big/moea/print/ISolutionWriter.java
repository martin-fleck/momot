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

import java.io.PrintStream;

import org.moeaframework.core.Solution;

public interface ISolutionWriter<S extends Solution> {
   ISolutionWriter<S> addConstraintName(int index, String name);

   ISolutionWriter<S> addObjectiveName(int index, String name);

   ISolutionWriter<S> addVariableName(int index, String name);

   String getConstraintData(S solution, int index);

   String getConstraintName(int index);

   String getObjectiveData(S solution, int index);

   String getObjectiveName(int index);

   String getVariableData(S solution, int index);

   String getVariableName(int index);

   ISolutionWriter<S> setConstraintNames(Iterable<String> names);

   ISolutionWriter<S> setObjectiveNames(Iterable<String> names);

   ISolutionWriter<S> setPrintPlaceholders(boolean printPlaceholders);

   ISolutionWriter<S> setVariableNames(Iterable<String> names);

   void write(PrintStream ps, S solution);

   String write(S solution);

   boolean writeAttributes();

   boolean writeConstraints();

   boolean writeObjectives();

   boolean writePlaceholders();

   boolean writeSummaries();

   boolean writeVariables();
}
