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
package at.ac.tuwien.big.momot.problem.solution;

import at.ac.tuwien.big.moea.problem.solution.SearchSolution;
import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.DefaultEObjectEqualityHelper;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper;
import at.ac.tuwien.big.momot.util.MomotUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.Parameter;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

public class TransformationSolution extends SearchSolution implements Comparable<TransformationSolution> {

   public static final String ATTRIBUTE_EXECUTION_RESULT = "ExecutionResult";
   public static final String ATTRIBUTE_MATCH_EXECUTION_RESULTS = "MatchExecutionResults";

   private static final long serialVersionUID = 3862075867187279004L;

   public static TransformationSolution removePlaceholders(final TransformationSolution solution) {
      final List<ITransformationVariable> nonPlaceholderVariables = new ArrayList<>();
      for(final ITransformationVariable variable : solution.getVariables()) {
         if(variable != null && !(variable instanceof IPlaceholderVariable)) {
            nonPlaceholderVariables.add(variable.copy());
         }
      }

      return new TransformationSolution(solution.getSourceGraph(), nonPlaceholderVariables,
            solution.getNumberOfObjectives(), solution.getNumberOfConstraints());
   }

   protected ITransformationVariable[] variables;
   protected EGraph sourceGraph;

   protected EGraph resultGraph;

   protected IEObjectEqualityHelper equalityHelper;

   public TransformationSolution(final EGraph sourceGraph, final int numberOfVariables, final int numberOfObjectives) {
      this(sourceGraph, numberOfVariables, numberOfObjectives, 0);
   }

   public TransformationSolution(final EGraph sourceGraph, final int numberOfVariables, final int numberOfObjectives,
         final int numberOfConstraints) {
      super(numberOfVariables, numberOfObjectives, numberOfConstraints);
      this.variables = new ITransformationVariable[numberOfVariables];
      this.sourceGraph = sourceGraph;
   }

   public TransformationSolution(final EGraph sourceGraph, final List<? extends ITransformationVariable> variables,
         final int numberOfObjectives) {
      this(sourceGraph, variables, numberOfObjectives, 0);
   }

   public TransformationSolution(final EGraph sourceGraph, final List<? extends ITransformationVariable> variables,
         final int numberOfObjectives, final int numberOfConstraints) {
      this(sourceGraph, variables.size(), numberOfObjectives, numberOfConstraints);
      copyVariables(variables);
   }

   public TransformationSolution(final EGraph sourceGraph, final Solution solution) {
      this(sourceGraph, solution.getNumberOfVariables(), solution.getNumberOfObjectives(),
            solution.getNumberOfConstraints());
      copySolution(solution);
   }

   public TransformationSolution(final TransformationSearchOrchestration searchOrchestration) {
      this(searchOrchestration.getProblemGraph(), searchOrchestration.getSolutionLength(),
            searchOrchestration.getNumberOfObjectives(), searchOrchestration.getNumberOfObjectives());
      setEqualityHelper(searchOrchestration.getEqualityHelper());
   }

   public TransformationSolution(final TransformationSolution solution) {
      this(solution.getSourceGraph(), solution);
      setEqualityHelper(solution.getEqualityHelper());
   }

   protected void adapt(final ITransformationVariable variable, final EGraph newGraph) {
      if(variable instanceof IPlaceholderVariable) {
         return;
      }

      for(final Parameter param : variable.getUnit().getParameters()) {
         final Object paramValue = variable.getParameterValue(param);
         if(paramValue instanceof EObject) {
            final EObject valueInOldGraph = (EObject) paramValue;
            for(final EObject valueInNewGraph : newGraph.getDomain(valueInOldGraph.eClass(), true)) {
               if(equals(valueInNewGraph, valueInOldGraph)) {
                  variable.setParameterValue(param, valueInNewGraph);
                  break;
               }
            }
         }
      }
      variable.setEGraph(newGraph);
   }

   @Override
   public int compareTo(final TransformationSolution other) {
      int compare = 0;

      final Integer matchVariables = getVariables().length;
      final Integer otherMatchVariables = other.getVariables().length;

      compare = matchVariables.compareTo(otherMatchVariables);
      if(compare != 0) {
         return compare;
      }

      for(int i = 0; i < matchVariables; i++) {
         compare = getVariable(i).compareTo(other.getVariable(i));
         if(compare != 0) {
            return compare;
         }
      }
      return 0;
   }

   @Override
   public TransformationSolution copy() {
      return new TransformationSolution(this);
   }

   protected void copyConstraints(final Solution solution) {
      for(int i = 0; i < getNumberOfConstraints(); i++) {
         setConstraint(i, solution.getConstraint(i));
      }
   }

   protected void copyObjectives(final Solution solution) {
      for(int i = 0; i < getNumberOfObjectives(); i++) {
         setObjective(i, solution.getObjective(i));
      }
   }

   protected void copySolution(final Solution solution) {
      copyObjectives(solution);
      copyConstraints(solution);
      copyVariables(solution);
   }

   protected void copyVariables(final List<? extends Variable> variables) {
      for(int i = 0; i < getNumberOfVariables(); i++) {
         final Variable variable = variables.get(i);
         if(variable == null || variable instanceof IPlaceholderVariable) {
            setVariable(i, new TransformationPlaceholderVariable());
         } else if(!(variable instanceof ITransformationVariable)) {
            throw new IllegalArgumentException("Only TransformationVariables allowed.");
         } else {
            setVariable(i, variable.copy());
         }
      }
   }

   protected void copyVariables(final Solution solution) {
      for(int i = 0; i < getNumberOfVariables(); i++) {
         final Variable variable = solution.getVariable(i);
         if(variable == null || variable instanceof IPlaceholderVariable) {
            setVariable(i, new TransformationPlaceholderVariable());
         } else if(!(variable instanceof ITransformationVariable)) {
            throw new IllegalArgumentException("Only TransformationVariables allowed.");
         } else {
            setVariable(i, variable.copy());
         }
      }
   }

   protected boolean equals(final EObject left, final EObject right) {
      IEObjectEqualityHelper helper = getEqualityHelper();
      if(helper == null) {
         helper = new DefaultEObjectEqualityHelper();
      }
      return helper.equals(left, right);
   }

   public EGraph execute() {
      return execute(false);
   }

   public EGraph execute(final boolean forceExecution) {
      if(!isDirty() && !forceExecution) {
         return getResultGraph();
      }

      if(getSourceGraph() == null) {
         throw new IllegalArgumentException("Source graph null.");
      }

      final EGraph searchGraph = MomotUtil.copy(getSourceGraph());
      for(final ITransformationVariable variable : getVariables()) {
         adapt(variable, searchGraph);
         variable.execute(true);
      }
      this.resultGraph = searchGraph;
      return resultGraph;
   }

   public IEObjectEqualityHelper getEqualityHelper() {
      return equalityHelper;
   }

   @Override
   public int getNumberOfVariables() {
      return variables.length;
   }

   public EGraph getResultGraph() {
      return resultGraph;
   }

   public int getSolutionLength() {
      int nr = 0;
      for(final ITransformationVariable var : getVariables()) {
         if(!(var instanceof IPlaceholderVariable)) {
            nr++;
         }
      }
      return nr;
   }

   public EGraph getSourceGraph() {
      return sourceGraph;
   }

   public boolean[] getSuccess() {
      final boolean[] success = new boolean[getNumberOfVariables()];
      for(int i = 0; i < getNumberOfVariables(); i++) {
         success[i] = getVariable(i).isExecuted();
      }
      return success;
   }

   @Override
   public ITransformationVariable getVariable(final int index) {
      return variables[index];
   }

   public ITransformationVariable[] getVariables() {
      return variables;
   }

   protected boolean isDirty() {
      return this.resultGraph == null;
   }

   public void redo() {
      for(final ITransformationVariable variable : getVariables()) {
         variable.redo(null);
      }
   }

   protected ITransformationVariable[] resize(final List<ITransformationVariable> variables) {
      final int expectedSize = getNumberOfVariables();
      List<ITransformationVariable> expectedVariables = new ArrayList<>(expectedSize);
      expectedVariables.addAll(variables);

      if(expectedVariables.size() > expectedSize) {
         expectedVariables = expectedVariables.subList(0, expectedSize);
      }

      // add placeholders if necessary
      while(expectedVariables.size() < expectedSize) {
         final int index = MathUtil.randomInteger(expectedSize);
         final TransformationPlaceholderVariable variable = new TransformationPlaceholderVariable();
         if(index > expectedVariables.size()) {
            expectedVariables.add(variable);
         } else {
            expectedVariables.add(index, variable);
         }
      }

      return expectedVariables.toArray(new ITransformationVariable[expectedSize]);
   }

   public void setDirty() {
      this.resultGraph = null;
   }

   public void setEqualityHelper(final IEObjectEqualityHelper equalityHelper) {
      this.equalityHelper = equalityHelper;
   }

   public void setSourceGraph(final EGraph sourceGraph) {
      this.sourceGraph = sourceGraph;
      setDirty();
   }

   public void setTransformation(final List<ITransformationVariable> variables, final EGraph resultGraph) {
      setVariables(variables);
      this.resultGraph = resultGraph;
   }

   @Override
   public void setVariable(final int index, final Variable variable) {
      if(index >= getNumberOfVariables()) {
         return;
      }
      if(variable != null && variable instanceof ITransformationVariable) {
         variables[index] = (ITransformationVariable) variable;
         setDirty();
      } else if(variable != null && variable instanceof IPlaceholderVariable) {
         variables[index] = new TransformationPlaceholderVariable();
         setDirty();
      } else {
         throw new IllegalArgumentException(
               "TransformationSolution only supports the ITransformationVariable variable type.");
      }
   }

   public void setVariables(final ITransformationVariable... variables) {
      setVariables(Arrays.asList(variables));
   }

   public void setVariables(final List<ITransformationVariable> variables) {
      this.variables = resize(variables);
      setDirty();
   }

   @Override
   public String toString() {
      return Arrays.toString(getVariables());
   }

   public void undo() {
      for(int i = getVariables().length - 1; i >= 0; i--) {
         variables[i].undo(null);
      }
   }

}
