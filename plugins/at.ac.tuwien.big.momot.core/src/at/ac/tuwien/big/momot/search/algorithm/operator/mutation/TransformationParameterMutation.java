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

import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.util.CollectionUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.Parameter;

public class TransformationParameterMutation extends AbstractTransformationMutation {

   private ModuleManager moduleManager;

   public TransformationParameterMutation() {
      super();
   }

   public TransformationParameterMutation(final double probability, final ModuleManager moduleManager) {
      super(probability);
      this.moduleManager = moduleManager;
   }

   public TransformationParameterMutation(final ModuleManager moduleManager) {
      super();
      this.moduleManager = moduleManager;
   }

   public ModuleManager getModuleManager() {
      return moduleManager;
   }

   @Override
   protected TransformationSolution mutate(final TransformationSolution mutant) {
      ITransformationVariable randomVariable = CollectionUtil.getRandomElement(mutant.getVariables());
      int nrTries = 0;
      while(randomVariable instanceof IPlaceholderVariable) {
         if(++nrTries == 3) {
            return mutant;
         }
         randomVariable = CollectionUtil.getRandomElement(mutant.getVariables());
      }

      final EList<Parameter> ruleParameters = randomVariable.getUnit().getParameters();
      for(final Parameter parameter : ruleParameters) {
         final Object value = randomVariable.getParameterValue(parameter);
         if(value != null) {
            final Object paramValue = getModuleManager().nextParameterValue(parameter);
            if(paramValue != null) {
               randomVariable.setParameterValue(parameter, paramValue);
               break;
            }
         }
      }
      return mutant;
   }

   public void setModuleManager(final ModuleManager moduleManager) {
      this.moduleManager = moduleManager;
   }
}
