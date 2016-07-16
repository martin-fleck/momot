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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.solution.SearchSolution;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.moea.search.solution.repair.ISolutionRepairer;
import at.ac.tuwien.big.moea.util.MathUtil;

public class MultiDimensionalFitnessFunction<T extends Solution> implements IMultiDimensionalFitnessFunction<T> {

//	protected Map<String, IFitnessDimension<T>> objectives;
//	protected Map<String, IFitnessDimension<T>> constraints;
	
	protected List<IFitnessDimension<T>> objectives;
	protected List<IFitnessDimension<T>> constraints;
	
	protected Class<T> clazz;
	protected ISolutionRepairer<T> repairer;
	
	public MultiDimensionalFitnessFunction(Class<T> clazz) {
		this.objectives = new ArrayList<>();
		this.constraints = new ArrayList<>();
		this.clazz = clazz;
	}
	
	@Override
	public double doEvaluate(Solution solution) {
		if(clazz.isInstance(solution)) 
			preprocessEvaluation(clazz.cast(solution));
				
		double result = delegateEvaluation(solution);
		
		if(clazz.isInstance(solution)) 
			postprocessEvaluation(clazz.cast(solution), result);
					
		return result;
	}
	
	private double evaluate(IFitnessDimension<T> dimension, Solution solution) {
		Double evaluation = dimension.doEvaluate(solution);
		if(dimension.isMaximumFunction())
			return -evaluation;
		
		return evaluation;
	}

	private double delegateEvaluation(Solution solution) {
		int i = 0;
		for(IFitnessDimension<T> dimension : objectives)
			solution.setObjective(i++, evaluate(dimension, solution));

		i = 0;
		for(IFitnessDimension<T> dimension : constraints)
			solution.setConstraint(i++, evaluate(dimension, solution));
		
		return getAggregateFitness(solution);
	}
	
	@Override
	public double evaluate(T solution) {
		return delegateEvaluation(solution);
	}
	
	protected void postprocessEvaluation(T solution, double result) {
		solution.setAttribute(SearchSolution.ATTRIBUTE_AGGREGATED_FITNESS, result);
	}

	protected void preprocessEvaluation(T solution) {
		if(repairsSolutions() && solution != null) 
			solution = getSolutionRepairer().repair(solution);
	}

	@Override
	public int[] evaluatesObjectives() {
		int[] objectiveIndices = new int[constraints.size()];
		for(int i = 0; i < constraints.size(); i++)
			objectiveIndices[i] = i;
		return objectiveIndices;
	}
	
	@Override
	public int evaluatesNrObjectives() {
		return objectives.size();
	}
	
	@Override
	public int[] evaluatesConstraints() {
		int[] constraintIndices = new int[constraints.size()];
		for(int i = 0; i < constraints.size(); i++)
			constraintIndices[i] = i;
		return constraintIndices;
	}
	
	@Override
	public int evaluatesNrConstraints() {
		return constraints.size();
	}
	
	@Override	
	public <D extends IFitnessDimension<T>> IFitnessFunction<T> addConstraint(D constraint) {
		constraints.add(constraint);
		return this;
	}
	
	@Override
	public <D extends IFitnessDimension<T>> IFitnessFunction<T> addObjective(D objective) {
		objectives.add(objective);
		return this;
	}
	
	protected double getAggregateFitness(Solution solution) {
		return MathUtil.getSum(solution.getObjectives(), solution.getConstraints());
	}

	@Override
	public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeObjective(D objective) {
		this.objectives.remove(objective);
		return this;
	}
	
	@Override
	public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeObjective(String objectiveName) {
		this.objectives.remove(getByName(objectiveName, objectives));
		return this;
	}

	@Override
	public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeConstraint(D constraint) {
		if(constraint == null)
			return this;
		this.constraints.remove(constraint.getName());
		return this;
	}
	
	@Override
	public <D extends IFitnessDimension<T>> IFitnessFunction<T> removeConstraint(String constraintName) {
		this.constraints.remove(getByName(constraintName, constraints));
		return this;
	}

	@Override
	public ISolutionRepairer<T> getSolutionRepairer() {
		return repairer;
	}
	
	@Override
	public boolean repairsSolutions() {
		return getSolutionRepairer() != null;
	}
	
	@Override
	public String getObjectiveName(int index) {
		if(index < objectives.size())
			return objectives.get(index).getName();
		return null;
	}

	@Override
	public String getConstraintName(int index) {
		if(index < constraints.size())
			return constraints.get(index).getName();
		return null;
	}
	
	private List<String> getNames(Iterable<IFitnessDimension<T>> list) {
		List<String> names = new ArrayList<>();
		for(IFitnessDimension<?> element : list)
			names.add(element.getName());
		return names;
	}
	
	@Override
	public List<String> getConstraintNames() {
		return getNames(constraints);
	}
	
	@Override
	public List<String> getObjectiveNames() {
		return getNames(objectives);
	}
	
	@Override
	public Collection<IFitnessDimension<T>> getConstraints() {
		return constraints;
	}
	
	@Override
	public Collection<IFitnessDimension<T>> getObjectives() {
		return objectives;
	}
	
	protected IFitnessDimension<T> getByName(String name, Iterable<IFitnessDimension<T>> list) {
		for(IFitnessDimension<T> dimension : list)
			if(dimension.getName().equals(name))
				return dimension;
		return null;
	}
	
	@Override
	public IFitnessDimension<T> getObjective(String name) {
		return getByName(name, objectives);
	}
	
	@Override
	public IFitnessDimension<T> getConstraint(String name) {
		return getByName(name, constraints);
	}
	
	protected int getIndex(String name, Iterable<IFitnessDimension<T>> values) {
		int index = 0;
		for(IFitnessDimension<T> dimension : values) {
			if(dimension.getName().equals(name))
				return index;
			index++;
		}
		return -1;
	}
	
	@Override
	public int getConstraintIndex(String name) {
		return getIndex(name, constraints);
	}
	
	@Override
	public int getObjectiveIndex(String name) {
		return getIndex(name, objectives);
	}
}
