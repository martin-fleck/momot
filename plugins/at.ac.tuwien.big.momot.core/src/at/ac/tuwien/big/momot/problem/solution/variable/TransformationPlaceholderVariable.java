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
package at.ac.tuwien.big.momot.problem.solution.variable;

import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.problem.solution.variable.PlaceholderVariable;

import org.eclipse.emf.henshin.interpreter.ApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Unit;

public class TransformationPlaceholderVariable extends PlaceholderVariable
      implements ITransformationVariable, IPlaceholderVariable {

   private static final long serialVersionUID = -3254092590689885677L;

   @Override
   public int compareTo(final ITransformationVariable other) {
      if(other instanceof TransformationPlaceholderVariable) {
         return 0;
      }
      return -1;
   }

   @Override
   public TransformationPlaceholderVariable copy() {
      return new TransformationPlaceholderVariable();
   }

   @Override
   public boolean execute() {
      return true;
   }

   @Override
   public boolean execute(final ApplicationMonitor monitor) {
      return true;
   }

   @Override
   public boolean execute(final boolean reexecute) {
      return true;
   }

   @Override
   public Assignment getAssignment() {
      return null;
   }

   @Override
   public EGraph getEGraph() {
      return null;
   }

   @Override
   public Engine getEngine() {
      return null;
   }

   @Override
   public Object getParameterValue(final Parameter parameter) {
      return null;
   }

   @Override
   public <T> T getParameterValue(final Parameter parameter, final Class<T> valueClass) {
      return null;
   }

   @Override
   public Object getParameterValue(final String paramName) {
      return null;
   }

   @Override
   public <T> T getParameterValue(final String paramName, final Class<T> valueClass) {
      return null;
   }

   @Override
   public Assignment getResultAssignment() {
      return null;
   }

   @Override
   public Object getResultParameterValue(final Parameter parameter) {
      return null;
   }

   @Override
   public <T> T getResultParameterValue(final Parameter parameter, final Class<T> valueClass) {
      return null;
   }

   @Override
   public Object getResultParameterValue(final String paramName) {
      return null;
   }

   @Override
   public <T> T getResultParameterValue(final String parameterName, final Class<T> resultClass) {
      return null;
   }

   @Override
   public Unit getUnit() {
      return null;
   }

   @Override
   public boolean isExecuted() {
      return true;
   }

   @Override
   public boolean isUndone() {
      return false;
   }

   @Override
   public boolean redo(final ApplicationMonitor monitor) {
      return true;
   }

   @Override
   public void setAssignment(final Assignment assignment) {}

   @Override
   public void setEGraph(final EGraph graph) {}

   @Override
   public void setParameterValue(final Parameter parameter, final Object value) {}

   @Override
   public void setParameterValue(final String paramName, final Object value) {}

   @Override
   public void setUnit(final Unit unit) {}

   @Override
   public String toString() {
      return "-Placeholder-\n";
   }

   @Override
   public boolean undo(final ApplicationMonitor monitor) {
      return true;
   }

}
