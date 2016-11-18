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
package at.ac.tuwien.big.momot.search.algorithm.operator.mutation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.Parameter;

import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.util.CollectionUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;

public class BlacklistMatchParameterMutation extends AbstractTransformationMutation {
	
	private ModuleManager moduleManager;
	private List<Parameter> blackList = new ArrayList<>();
	
	public BlacklistMatchParameterMutation(ModuleManager moduleManager) {
		super();
		this.moduleManager = moduleManager;
	}
	
	public BlacklistMatchParameterMutation(double probability, ModuleManager moduleManager) {
		super(probability);
		this.moduleManager = moduleManager;
	}
	
	public ModuleManager getModuleManager() {
		return moduleManager;
	}
	
	public BlacklistMatchParameterMutation addToBlacklist(String ruleName, String parameterName) {
		Parameter parameter = getModuleManager().getParameter(ruleName, parameterName);
		blackList.add(parameter);
		return this;
	}
	
	public BlacklistMatchParameterMutation addToBlacklist(String qualifiedParameterName) {
		Parameter parameter = getModuleManager().getParameter(qualifiedParameterName);
		blackList.add(parameter);
		return this;
	}

	@Override
	protected TransformationSolution mutate(TransformationSolution mutant) {
		ITransformationVariable randomMatch = CollectionUtil.getRandomElement(mutant.getVariables());
		int nrTries = 0;
		while(randomMatch instanceof IPlaceholderVariable) {
			if(++nrTries == 3)
				return mutant;
			randomMatch = CollectionUtil.getRandomElement(mutant.getVariables());
		}
		
		EList<Parameter> ruleParameters = randomMatch.getUnit().getParameters();
		for(Parameter parameter : ruleParameters) {
			if(blackList.contains(parameter))
				continue;
			
			Object value = randomMatch.getParameterValue(parameter);
			if(value != null) {
				Object paramValue = getModuleManager().nextParameterValue(parameter, randomMatch.getAssignment());
				if(paramValue != null) {
					randomMatch.setParameterValue(parameter.getName(), paramValue);
					break;
				}
			}
				
		}
		return mutant;
	}
}
