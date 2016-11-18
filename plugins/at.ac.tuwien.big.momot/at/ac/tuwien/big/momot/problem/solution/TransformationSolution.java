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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.Parameter;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

import at.ac.tuwien.big.moea.problem.solution.SearchSolution;
import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.DefaultEObjectEqualityHelper;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class TransformationSolution extends SearchSolution implements Comparable<TransformationSolution> {
	
	public static final String ATTRIBUTE_EXECUTION_RESULT = "ExecutionResult";
	public static final String ATTRIBUTE_MATCH_EXECUTION_RESULTS = "MatchExecutionResults";
	
	private static final long serialVersionUID = 3862075867187279004L;
	
	protected ITransformationVariable[] variables;
	protected EGraph sourceGraph;
	protected EGraph resultGraph;
	
	protected IEObjectEqualityHelper equalityHelper;
	
	public TransformationSolution(TransformationSearchOrchestration searchOrchestration) {
		this(searchOrchestration.getProblemGraph(),
			searchOrchestration.getSolutionLength(), 
			searchOrchestration.getNumberOfObjectives(),
			searchOrchestration.getNumberOfObjectives());
		setEqualityHelper(searchOrchestration.getEqualityHelper());
	}
	
	public TransformationSolution(EGraph sourceGraph, int numberOfVariables, int numberOfObjectives,
			int numberOfConstraints) {
		super(numberOfVariables, numberOfObjectives, numberOfConstraints);
		this.variables = new ITransformationVariable[numberOfVariables];
		this.sourceGraph = sourceGraph;
	}

	public TransformationSolution(EGraph sourceGraph, int numberOfVariables, int numberOfObjectives) {
		this(sourceGraph, numberOfVariables, numberOfObjectives, 0);
	}

	public TransformationSolution(EGraph sourceGraph, Solution solution) {
		this(sourceGraph, solution.getNumberOfVariables(), solution.getNumberOfObjectives(),
				solution.getNumberOfConstraints());
		copySolution(solution);	
	}
	
	public TransformationSolution(TransformationSolution solution) {
		this(solution.getSourceGraph(), solution);
		setEqualityHelper(solution.getEqualityHelper());
	}
	
	public TransformationSolution(EGraph sourceGraph, List<? extends ITransformationVariable> variables, int numberOfObjectives,
			int numberOfConstraints) {
		this(sourceGraph, variables.size(), numberOfObjectives, numberOfConstraints);
		copyVariables(variables);
	}
	
	public TransformationSolution(EGraph sourceGraph, List<? extends ITransformationVariable> variables, int numberOfObjectives) {
		this(sourceGraph, variables, numberOfObjectives, 0);
	}
	
	protected void copySolution(Solution solution) {
		copyObjectives(solution);
		copyConstraints(solution);
		copyVariables(solution);
	}
	
	protected void copyObjectives(Solution solution) {
		for (int i = 0; i < getNumberOfObjectives(); i++)
			setObjective(i, solution.getObjective(i));
	}
	
	protected void copyConstraints(Solution solution) {
		for (int i = 0; i < getNumberOfConstraints(); i++)
			setConstraint(i, solution.getConstraint(i));
	}
	
	protected void copyVariables(Solution solution) {
		for(int i = 0; i < getNumberOfVariables(); i++) {
			Variable variable = solution.getVariable(i);
			if(variable == null || variable instanceof IPlaceholderVariable)
				setVariable(i, new TransformationPlaceholderVariable());
			else if(!(variable instanceof ITransformationVariable))
				throw new IllegalArgumentException("Only TransformationVariables allowed.");
			else 
				setVariable(i, variable.copy());
		}
	}
	
	protected void copyVariables(List<? extends Variable> variables) {
		for(int i = 0; i < getNumberOfVariables(); i++) {
			Variable variable = variables.get(i);
			if(variable == null || variable instanceof IPlaceholderVariable)
				setVariable(i, new TransformationPlaceholderVariable());
			else if(!(variable instanceof ITransformationVariable))
				throw new IllegalArgumentException("Only TransformationVariables allowed.");
			else 
				setVariable(i, variable.copy());
		}
	}
	
	public void setDirty() {
		this.resultGraph = null;
	}
	
	protected boolean isDirty() {
		return this.resultGraph == null;
	}
	
	public void setVariables(ITransformationVariable... variables) {
		setVariables(Arrays.asList(variables));
	}
	
	public void setVariables(List<ITransformationVariable> variables) {
		this.variables = resize(variables);
		setDirty();
	}
	
	public IEObjectEqualityHelper getEqualityHelper() {
		return equalityHelper;
	}
	
	public void setEqualityHelper(IEObjectEqualityHelper equalityHelper) {
		this.equalityHelper = equalityHelper;
	}
	
	protected ITransformationVariable[] resize(List<ITransformationVariable> variables) {
		int expectedSize = getNumberOfVariables();
		List<ITransformationVariable> expectedVariables = new ArrayList<>(expectedSize);
		expectedVariables.addAll(variables);
		
		if(expectedVariables.size() > expectedSize)
			expectedVariables = expectedVariables.subList(0, expectedSize);
		
		// add placeholders if necessary
		while(expectedVariables.size() < expectedSize) {
			int index = MathUtil.randomInteger(expectedSize);
			TransformationPlaceholderVariable variable = new TransformationPlaceholderVariable();
			if(index > expectedVariables.size())
				expectedVariables.add(variable);
			else
				expectedVariables.add(index, variable);
		}			
		
		return expectedVariables.toArray(new ITransformationVariable[expectedSize]);
	}
		
	@Override
	public void setVariable(int index, Variable variable) {
		if(index >= getNumberOfVariables())
			return;
		if(variable != null && variable instanceof ITransformationVariable) {
			variables[index] = (ITransformationVariable)variable;
			setDirty();
		}
		else if(variable != null && variable instanceof IPlaceholderVariable) {
			variables[index] = new TransformationPlaceholderVariable();
			setDirty();
		} else
			throw new IllegalArgumentException("TransformationSolution only supports the ITransformationVariable variable type.");
	}
	
	
	@Override
	public int getNumberOfVariables() {
		return variables.length;
	}
		
	public int getSolutionLength() {
		int nr = 0;
		for(ITransformationVariable var : getVariables())
			if(!(var instanceof IPlaceholderVariable))
				nr++;
		return nr;
	}
	
	@Override
	public ITransformationVariable getVariable(int index) {
		return variables[index];
	}
	
	public ITransformationVariable[] getVariables() {
		return variables;
	}
		
	public EGraph getResultGraph() {
		return resultGraph;
	}

	public EGraph getSourceGraph() {
		return sourceGraph;
	}
	
	public void setSourceGraph(EGraph sourceGraph) {
		this.sourceGraph = sourceGraph;
		setDirty();
	}
	
	protected boolean equals(EObject left, EObject right) {
		IEObjectEqualityHelper helper = getEqualityHelper();
		if(helper == null)
			helper = new DefaultEObjectEqualityHelper();
		return helper.equals(left, right);
	}
	
	protected ITransformationVariable adapt(ITransformationVariable variable, EGraph newGraph) {
		if(variable instanceof IPlaceholderVariable)
			return variable;
		ITransformationVariable ret = variable;

		for(Parameter param : ret.getUnit().getParameters()) {
			Object paramValue = ret.getParameterValue(param);
			if(paramValue instanceof EObject) {
				EObject valueInOldGraph = (EObject) paramValue;
				for(EObject valueInNewGraph : newGraph.getDomain(valueInOldGraph.eClass(), true)) {
					if(equals(valueInNewGraph, valueInOldGraph)) {
						ret.setParameterValue(param, valueInNewGraph);
						break;
					}
				}
			}
		}
		ret.setEGraph(newGraph);
		return ret.copy();
	}
	


	public void setForeignVariable(int j, ITransformationVariable var) {
		if (!(var instanceof IPlaceholderVariable) && !(getVariable(j) instanceof IPlaceholderVariable)) {
			try {
				int lastInd = -1;
				for (int i = j-1; i >= 0; --i) {
					if (getVariable(i) == null || getVariable(i) instanceof IPlaceholderVariable) {
						lastInd = i;
						break;
					}
				}
				if (j == getNumberOfVariables()-1 && lastInd == -1) { //Last index and cannot do anything --> delete some random previous
					lastInd = MathUtil.randomInteger(getNumberOfVariables());
				}
				
				//Try to clear
				
				int nextInd = -1;
				for (int i = j+1; i < getSolutionLength(); ++i) {
					if (getVariable(i) == null || getVariable(i) instanceof IPlaceholderVariable) {
						nextInd = i;
						break;
					}
				}
				boolean preferNext = (nextInd-j)<(j-lastInd);
				if (lastInd == -1 && nextInd == -1) {
					//Swap to end
					for (int k = getSolutionLength()-1; k > j; --k) {
						setVariable(k, getVariable(k-1));
					}
				} else if (lastInd == -1 || (nextInd != -1 && preferNext)) { //nextInd != -1
					for (int k = nextInd; k > j; --k) {
						setVariable(k, getVariable(k-1));
					}
				} else if (nextInd == -1) {
					//Swap to begin
					for (int k = lastInd; k < Math.min(j,getNumberOfVariables()-1); ++k) {
						setVariable(k, getVariable(k+1));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setVariable(j, var);
		setDirty();
		//Probably adaption will be done later anyway
	}
	
	public void continueExecute(EGraph searchGraph, int index, boolean forceExecution) {
		ITransformationVariable variable = getVariable(index);
		variable = adapt(variable, searchGraph);
		variable.execute(true);
	}
	
	public EGraph initExecute() {
		EGraph searchGraph = MomotUtil.copy(getSourceGraph());
		return searchGraph;
	}
	
	public EGraph executeUntilExclusive(int index, boolean forceExecution) {
		EGraph searchGraph = MomotUtil.copy(getSourceGraph());
		int curIndex = 0;
		for(ITransformationVariable variable : getVariables()) {
			if (++curIndex > index) {
				break;
			}
			variable = adapt(variable, searchGraph);
			variable.execute(true);
		}
		return searchGraph;
	}
	
	private static long executed = 0;
	private static long sndexecuted = 0;
	private static long notexecuted = 0;
	
	public EGraph execute(boolean forceExecution) {
		if(!isDirty() && !forceExecution)
			return getResultGraph();
		
		if(getSourceGraph() == null)
			throw new IllegalArgumentException("Source graph null.");
		
		EGraph searchGraph = MomotUtil.copy(getSourceGraph());
		int idx = -1;
		for(ITransformationVariable variable : getVariables()) {
			++idx;
			if (variable instanceof IPlaceholderVariable) {
				continue;
			}
			ITransformationVariable var2 = adapt(variable, searchGraph);
			boolean ret = variable.execute(true);
			if (!ret) {
				variable.undo(null);
				ret = var2.execute(true);
				setVariable(idx, var2);
				if (!ret) {
					++notexecuted;
				} else {
					++sndexecuted;
				}
			} else {
				++executed;
			}
			/*if (((notexecuted+sndexecuted+executed) % 10000) == 0) {
				System.out.println("Executed "+executed+"/"+sndexecuted+"/"+notexecuted);
			}*/
		}
		this.resultGraph = searchGraph;
		return resultGraph;
	}
	
	public EGraph execute() {
		return execute(false);
	}
	

	public boolean[] getSuccess() {
		boolean[] success = new boolean[getNumberOfVariables()];
		for(int i = 0; i < getNumberOfVariables(); i++)
			success[i] = getVariable(i).isExecuted();
		return success;
	}
	
	public void undo() {
		for(int i = getVariables().length - 1; i >= 0; i--)
			variables[i].undo(null);
	}
	
	public void redo() {
		for(ITransformationVariable variable : getVariables())
			variable.redo(null);
	}
	
	public void setTransformation(List<ITransformationVariable> variables, EGraph resultGraph) {
		setVariables(variables);
		this.resultGraph = resultGraph;
	}
	
	@Override
	public int compareTo(TransformationSolution other) {
		int compare = 0;
		
		Integer matchVariables = getVariables().length;
		Integer otherMatchVariables = other.getVariables().length;
		
		compare = matchVariables.compareTo(otherMatchVariables);
		if(compare != 0)
			return compare;
		
		for(int i = 0; i < matchVariables; i++) {
			compare = getVariable(i).compareTo(other.getVariable(i));
			if(compare != 0)
				return compare;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(getVariables());
	}
	
	@Override
	public TransformationSolution copy() {
		return new TransformationSolution(this);
	}
	
	
	public static TransformationSolution removePlaceholders(TransformationSolution solution) {
		List<ITransformationVariable> nonPlaceholderVariables = new ArrayList<>();
		for(ITransformationVariable variable : solution.getVariables())
			if(variable != null && !(variable instanceof IPlaceholderVariable))
				nonPlaceholderVariables.add(variable.copy());
		
		return new TransformationSolution(
				solution.getSourceGraph(), 
				nonPlaceholderVariables, 
				solution.getNumberOfObjectives(), 
				solution.getNumberOfConstraints());
	}

}
