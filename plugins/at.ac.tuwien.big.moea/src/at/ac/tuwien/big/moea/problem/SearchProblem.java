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
package at.ac.tuwien.big.moea.problem;

import at.ac.tuwien.big.moea.search.fitness.IFitnessFunction;
import at.ac.tuwien.big.moea.search.solution.generator.solution.ISolutionGenerator;

import org.moeaframework.core.Solution;
import org.moeaframework.problem.AbstractProblem;

public class SearchProblem<S extends Solution> extends AbstractProblem implements ISearchProblem<S> {

   private final ISolutionGenerator<S> solutionGenerator;
   private final IFitnessFunction<S> fitnessFunction;

   public SearchProblem(final IFitnessFunction<S> fitnessFunction, final ISolutionGenerator<S> solutionGenerator) {
      super(solutionGenerator.getSolutionLength(), solutionGenerator.getNrObjectives(),
            solutionGenerator.getNrConstraints());
      this.fitnessFunction = fitnessFunction;
      this.solutionGenerator = solutionGenerator;
   }

   @Override
   public void evaluate(final Solution solution) {
      getFitnessFunction().doEvaluate(solution);
   }

   @Override
   public IFitnessFunction<S> getFitnessFunction() {
      return fitnessFunction;
   }

   @Override
   public ISolutionGenerator<S> getSolutionGenerator() {
      return solutionGenerator;
   }

   @Override
   public Solution newSolution() {
      return getSolutionGenerator().createNewSolution();
   }

}
