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

import org.eclipse.emf.henshin.interpreter.ApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Unit;

import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.problem.solution.variable.PlaceholderVariable;

public class TransformationPlaceholderVariable extends PlaceholderVariable implements ITransformationVariable, IPlaceholderVariable {

	private static final long serialVersionUID = -3254092590689885677L;

	@Override
	public TransformationPlaceholderVariable copy() {
		return new TransformationPlaceholderVariable();
	}
	
	@Override
	public String toString() {
		return "-Placeholder-\n";
	}

	@Override
	public int compareTo(ITransformationVariable other) {
		if(other instanceof TransformationPlaceholderVariable)
			return 0;
		return -1;
	}

	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public void setUnit(Unit unit) {	
	}

	@Override
	public EGraph getEGraph() {
		return null;
	}

	@Override
	public void setEGraph(EGraph graph) {		
	}

	@Override
	public Assignment getAssignment() {
		return null;
	}

	@Override
	public void setAssignment(Assignment assignment) {		
	}

	@Override
	public void setParameterValue(String paramName, Object value) {		
	}

	@Override
	public Assignment getResultAssignment() {
		return null;
	}

	@Override
	public Object getResultParameterValue(String paramName) {
		return null;
	}

	@Override
	public boolean execute(ApplicationMonitor monitor) {
		return true;
	}

	@Override
	public boolean undo(ApplicationMonitor monitor) {
		return true;
	}

	@Override
	public boolean redo(ApplicationMonitor monitor) {
		return true;
	}

	@Override
	public Engine getEngine() {
		return null;
	}

	@Override
	public boolean execute() {
		return true;
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
	public Object getResultParameterValue(Parameter parameter) {
		return null;
	}

	@Override
	public <T> T getResultParameterValue(Parameter parameter,
			Class<T> valueClass) {
		return null;
	}

	@Override
	public <T> T getResultParameterValue(String parameterName,
			Class<T> resultClass) {
		return null;
	}

	@Override
	public Object getParameterValue(Parameter parameter) {
		return null;
	}

	@Override
	public <T> T getParameterValue(Parameter parameter, Class<T> valueClass) {
		return null;
	}

	@Override
	public Object getParameterValue(String paramName) {
		return null;
	}

	@Override
	public <T> T getParameterValue(String paramName, Class<T> valueClass) {
		return null;
	}
	
	@Override
	public void setParameterValue(Parameter parameter, Object value) {	}

	@Override
	public boolean execute(boolean reexecute) {
		return true;
	}

}
