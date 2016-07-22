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
package at.ac.tuwien.big.moea.search.fitness;

import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.moea.search.solution.repair.ISolutionRepairer;

import java.util.Collection;
import java.util.List;

import org.moeaframework.core.Solution;

public interface IMultiDimensionalFitnessFunction<T extends Solution> extends IFitnessFunction<T> {
   <D extends IFitnessDimension<T>> IFitnessFunction<T> addConstraint(D constraint);

   <D extends IFitnessDimension<T>> IFitnessFunction<T> addObjective(D objective);

   IFitnessDimension<T> getConstraint(String name);

   int getConstraintIndex(String name);

   String getConstraintName(int index);

   List<String> getConstraintNames();

   Collection<IFitnessDimension<T>> getConstraints();

   IFitnessDimension<T> getObjective(String name);

   int getObjectiveIndex(String name);

   String getObjectiveName(int index);

   List<String> getObjectiveNames();

   Collection<IFitnessDimension<T>> getObjectives();

   ISolutionRepairer<T> getSolutionRepairer();

   <D extends IFitnessDimension<T>> IFitnessFunction<T> removeConstraint(D constraint);

   <D extends IFitnessDimension<T>> IFitnessFunction<T> removeConstraint(String constraintName);

   <D extends IFitnessDimension<T>> IFitnessFunction<T> removeObjective(D objective);

   <D extends IFitnessDimension<T>> IFitnessFunction<T> removeObjective(String objectiveName);

   boolean repairsSolutions();
}
