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
package at.ac.tuwien.big.momot.search.solution.repair;

import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

import java.util.Arrays;
import java.util.List;

public class TransformationUnitRepairer extends AbstractTransformationSolutionRepairer {

   private final SearchHelper searchHelper;

   public TransformationUnitRepairer(final SearchHelper searchHelper) {
      this.searchHelper = searchHelper;
   }

   public SearchHelper getSearchHelper() {
      return searchHelper;
   }

   @Override
   public TransformationSolution repair(final TransformationSolution solution) {
      int firstNotExecuted = 0;
      while(solution.getVariable(firstNotExecuted).isExecuted()) {
         firstNotExecuted++;
      }

      final List<ITransformationVariable> variables = Arrays.asList(solution.getVariables());
      final List<ITransformationVariable> executed = variables.subList(0, firstNotExecuted);
      final int nrToExecute = solution.getNumberOfVariables() - executed.size();

      return getSearchHelper()
            .appendRandomVariables(getSearchHelper().createTransformationSolution(solution.getSourceGraph(), executed,
                  solution.getNumberOfObjectives(), solution.getNumberOfConstraints()), nrToExecute);
   }

}
