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
package at.ac.tuwien.big.moea;

import at.ac.tuwien.big.moea.print.IPopulationWriter;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.search.solution.generator.IInjectedPopulationGenerator;
import at.ac.tuwien.big.moea.search.solution.generator.solution.ISolutionGenerator;

import java.util.List;

import org.moeaframework.core.Algorithm;
import org.moeaframework.core.EpsilonBoxDominanceArchive;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.NondominatedSortingPopulation;
import org.moeaframework.core.Population;
import org.moeaframework.core.Solution;

public interface ISearchOrchestration<S extends Solution> {
   void addAlgorithm(IRegisteredAlgorithm<? extends Algorithm> algorithm);

   void addAlgorithm(String name, IRegisteredAlgorithm<? extends Algorithm> algorithm);

   EpsilonBoxDominanceArchive createEpsilonBoxArchive(double... epsilon);

   EvolutionaryAlgorithmFactory<S> createEvolutionaryAlgorithmFactory(int populationSize);

   LocalSearchAlgorithmFactory<S> createLocalSearchAlgorithmFactory();

   S createNewRandomSolution();

   S createNewRandomSolution(int solutionLength);

   S createNewSolution();

   S createNewSolution(int solutionLength);

   NondominatedPopulation createPopulation(double... epsilon);

   IInjectedPopulationGenerator<S> createPopulationGenerator(int populationSize);

   IPopulationWriter<S> createPopulationWriter();

   ISearchProblem<S> createProblem();

   ISolutionWriter<S> createSolutionWriter();

   NondominatedSortingPopulation createSortingPopulation();

   String getAlgorithmName(IRegisteredAlgorithm<? extends Algorithm> algorithm);

   List<IRegisteredAlgorithm<? extends Algorithm>> getAlgorithms();

   IMultiDimensionalFitnessFunction<S> getFitnessFunction();

   int getNumberOfConstraints();

   int getNumberOfObjectives();

   ISearchProblem<S> getProblem();

   ISolutionGenerator<S> getSolutionGenerator();

   int getSolutionLength();

   String print(Iterable<S> population);

   String print(Population population);

   String print(S solution);

   void setAlgorithms(List<IRegisteredAlgorithm<? extends Algorithm>> algorithms);

}
