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

import at.ac.tuwien.big.moea.problem.solution.SearchSolution;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.moea.search.solution.repair.ISolutionRepairer;
import at.ac.tuwien.big.moea.util.MathUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.moeaframework.core.Solution;

public class MultiDimensionalFitnessFunction<T extends Solution> implements IMultiDimensionalFitnessFunction<T> {

   // protected Map<String, IFitnessDimension<T>> objectives;
   // protected Map<String, IFitnessDimension<T>> constraints;

   protected List<IFitnessDimension<T>> objectives;
   protected List<IFitnessDimension<T>> constraints;

   protected Class<T> clazz;
   protected ISolutionRepairer<T> repairer;

   public MultiDimensionalFitnessFunction(final Class<T> clazz) {
      this.objectives = new ArrayList<>();
      this.constraints = new ArrayList<>();
      this.clazz = clazz;
   }

   @Override
   public <D extends IFitnessDimension<T>> IFitnessFunction<T> addConstraint(final D constraint) {
      constraints.add(constraint);
      return this;
   }

   @Override
   public <D extends IFitnessDimension<T>> IFitnessFunction<T> addObjective(final D objective) {
      objectives.add(objective);
      return this;
   }

   private double delegateEvaluation(final Solution solution) {
      boolean failedConstraint = false;

      int i = 0;
      for(final IFitnessDimension<T> dimension : constraints) {
         if(!failedConstraint) {
            final double constraintEvaluation = evaluate(dimension, solution);
            solution.setConstraint(i++, constraintEvaluation);
            failedConstraint = IFitnessDimension.CONSTRAINT_OK != constraintEvaluation;
         } else {
            solution.setConstraint(i++, IFitnessDimension.CONSTRAINT_VIOLATED);
         }
      }

      i = 0;
      for(final IFitnessDimension<T> dimension : objectives) {
         if(!failedConstraint) {
            solution.setObjective(i++, evaluate(dimension, solution));
         } else {
            solution.setObjective(i++, IFitnessDimension.CONSTRAINT_VIOLATED);
         }
      }

      return getAggregateFitness(solution);
   }

   @Override
   public double doEvaluate(final Solution solution) {
      if(clazz.isInstance(solution)) {
         preprocessEvaluation(clazz.cast(solution));
      }

      final double result = delegateEvaluation(solution);
      // new Exception().printStackTrace();

      if(clazz.isInstance(solution)) {
         postprocessEvaluation(clazz.cast(solution), result);
      }

      return result;
   }

   private double evaluate(final IFitnessDimension<T> dimension, final Solution solution) {
      final Double evaluation = dimension.doEvaluate(solution);
      if(dimension.isMaximumFunction()) {
         return -evaluation;
      }

      return evaluation;
   }

   @Override
   public double evaluate(final T solution) {
      // new Exception().printStackTrace();
      return delegateEvaluation(solution);
   }

   @Override
   public int[] evaluatesConstraints() {
      final int[] constraintIndices = new int[constraints.size()];
      for(int i = 0; i < constraints.size(); i++) {
         constraintIndices[i] = i;
      }
      return constraintIndices;
   }

   @Override
   public int evaluatesNrConstraints() {
      return constraints.size();
   }

   @Override
   public int evaluatesNrObjectives() {
      return objectives.size();
   }

   @Override
   public int[] evaluatesObjectives() {
      final int[] objectiveIndices = new int[constraints.size()];
      for(int i = 0; i < constraints.size(); i++) {
         objectiveIndices[i] = i;
      }
      return objectiveIndices;
   }

   protected double getAggregateFitness(final Solution solution) {
      return MathUtil.getSum(solution.getObjectives(), solution.getConstraints());
   }

   protected IFitnessDimension<T> getByName(final String name, final Iterable<IFitnessDimension<T>> list) {
      for(final IFitnessDimension<T> dimension : list) {
         if(dimension.getName().equals(name)) {
            return dimension;
         }
      }
      return null;
   }

   @Override
   public IFitnessDimension<T> getConstraint(final String name) {
      return getByName(name, constraints);
   }

   @Override
   public int getConstraintIndex(final String name) {
      return getIndex(name, constraints);
   }

   @Override
   public String getConstraintName(final int index) {
      if(index < constraints.size()) {
         return constraints.get(index).getName();
      }
      return null;
   }

   @Override
   public List<String> getConstraintNames() {
      return getNames(constraints);
   }

   @Override
   public Collection<IFitnessDimension<T>> getConstraints() {
      return constraints;
   }

   protected int getIndex(final String name, final Iterable<IFitnessDimension<T>> values) {
      int index = 0;
      for(final IFitnessDimension<T> dimension : values) {
         if(dimension.getName().equals(name)) {
            return index;
         }
         index++;
      }
      return -1;
   }

   private List<String> getNames(final Iterable<IFitnessDimension<T>> list) {
      final List<String> names = new ArrayList<>();
      for(final IFitnessDimension<?> element : list) {
         names.add(element.getName());
      }
      return names;
   }

   @Override
   public IFitnessDimension<T> getObjective(final String name) {
      return getByName(name, objectives);
   }

   @Override
   public int getObjectiveIndex(final String name) {
      return getIndex(name, objectives);
   }

   @Override
   public String getObjectiveName(final int index) {
      if(index < objectives.size()) {
         return objectives.get(index).getName();
      }
      return null;
   }

   @Override
   public List<String> getObjectiveNames() {
      return getNames(objectives);
   }

   @Override
   public Collection<IFitnessDimension<T>> getObjectives() {
      return objectives;
   }

   @Override
   public ISolutionRepairer<T> getSolutionRepairer() {
      return repairer;
   }

   protected void postprocessEvaluation(final T solution, final double result) {
      solution.setAttribute(SearchSolution.ATTRIBUTE_AGGREGATED_FITNESS, result);
   }

   protected void preprocessEvaluation(T solution) {
      if(repairsSolutions() && solution != null) {
         solution = getSolutionRepairer().repair(solution);
      }
   }

   @Override
   public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeConstraint(final D constraint) {
      if(constraint == null) {
         return this;
      }
      this.constraints.remove(constraint.getName());
      return this;
   }

   @Override
   public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeConstraint(final String constraintName) {
      this.constraints.remove(getByName(constraintName, constraints));
      return this;
   }

   @Override
   public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeObjective(final D objective) {
      this.objectives.remove(objective);
      return this;
   }

   @Override
   public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeObjective(final String objectiveName) {
      this.objectives.remove(getByName(objectiveName, objectives));
      return this;
   }

   @Override
   public boolean repairsSolutions() {
      return getSolutionRepairer() != null;
   }
}
