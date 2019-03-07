/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and
 * implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.moea;

import at.ac.tuwien.big.moea.print.IPopulationWriter;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.print.PopulationWriter;
import at.ac.tuwien.big.moea.print.SolutionWriter;
import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.problem.SearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.search.solution.generator.IInjectedPopulationGenerator;
import at.ac.tuwien.big.moea.search.solution.generator.IPopulationGenerator;
import at.ac.tuwien.big.moea.search.solution.generator.InjectedRandomPopulationGenerator;
import at.ac.tuwien.big.moea.search.solution.generator.solution.IRandomSolutionGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.moeaframework.core.Algorithm;
import org.moeaframework.core.EpsilonBoxDominanceArchive;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.NondominatedSortingPopulation;
import org.moeaframework.core.Population;
import org.moeaframework.core.Solution;
import org.moeaframework.core.comparator.ParetoDominanceComparator;

public abstract class AbstractSearchOrchestration<S extends Solution> implements ISearchOrchestration<S> {
   protected Class<S> solutionClass;

   protected ISearchProblem<S> problem;
   protected IRandomSolutionGenerator<S> solutionGenerator;
   protected IPopulationGenerator<S> populationGenerator;
   protected IMultiDimensionalFitnessFunction<S> fitnessFunction;
   protected ISolutionWriter<S> solutionWriter;
   protected IPopulationWriter<S> populationWriter;
   protected boolean generateEmptySolutions = false;

   protected List<IRegisteredAlgorithm<? extends Algorithm>> algorithms = new ArrayList<>();
   protected Map<IRegisteredAlgorithm<? extends Algorithm>, String> algorithmNames = new HashMap<>();

   private int solutionLength;

   public AbstractSearchOrchestration() {}

   public AbstractSearchOrchestration(final Class<S> solutionClass) {
      this.solutionClass = solutionClass;
   }

   public AbstractSearchOrchestration(final Class<S> solutionClass, final int solutionLength) {
      this.solutionClass = solutionClass;
      this.solutionLength = solutionLength;
   }

   @Override
   public void addAlgorithm(final IRegisteredAlgorithm<? extends Algorithm> algorithm) {
      addAlgorithm(algorithm.createAlgorithm().getClass().getSimpleName(), algorithm);
   }

   @Override
   public void addAlgorithm(final String name, final IRegisteredAlgorithm<? extends Algorithm> algorithm) {
      this.algorithms.add(algorithm);
      this.algorithmNames.put(algorithm, name);
   }

   @Override
   public EpsilonBoxDominanceArchive createEpsilonBoxArchive(final double... epsilon) {
      if(epsilon == null || epsilon.length == 0) {
         return null;
      }
      return new EpsilonBoxDominanceArchive(epsilon);
   }

   @Override
   public EvolutionaryAlgorithmFactory<S> createEvolutionaryAlgorithmFactory(final int populationSize) {
      final EvolutionaryAlgorithmFactory<S> factory = new EvolutionaryAlgorithmFactory<>(this);
      factory.setPopulationSize(populationSize);
      return factory;
   }

   protected abstract IMultiDimensionalFitnessFunction<S> createFitnessFunction();

   @Override
   public LocalSearchAlgorithmFactory<S> createLocalSearchAlgorithmFactory() {
      return new LocalSearchAlgorithmFactory<>(this);
   }

   @Override
   public S createNewRandomSolution() {
      return getSolutionGenerator().createRandomSolution(getSolutionLength());
   }

   @Override
   public S createNewRandomSolution(final int solutionLength) {
      return getSolutionGenerator().createRandomSolution(solutionLength);
   }

   @Override
   public S createNewSolution() {
      return createNewSolution(getSolutionLength());
   }

   @Override
   public S createNewSolution(final int solutionLength) {
      return getSolutionGenerator().createNewSolution(solutionLength);
   }

   @Override
   public NondominatedPopulation createPopulation(final double... epsilon) {
      if(epsilon == null || epsilon.length == 0) {
         return new NondominatedPopulation(new ParetoDominanceComparator());
      }
      return new EpsilonBoxDominanceArchive(epsilon);
   }

   @Override
   public IInjectedPopulationGenerator<S> createPopulationGenerator(final int populationSize) {
      final InjectedRandomPopulationGenerator<S> ret = new InjectedRandomPopulationGenerator<>(populationSize,
            getSolutionGenerator());
      ret.setGenerateEmptySolutions(generateEmptySolutions);
      return ret;
   }

   @Override
   public IPopulationWriter<S> createPopulationWriter() {
      return new PopulationWriter<>(getSolutionClass(), getSolutionPrinter());
   }

   @Override
   public ISearchProblem<S> createProblem() {
      return new SearchProblem<>(createFitnessFunction(), createSolutionGenerator());
   }

   protected abstract IRandomSolutionGenerator<S> createSolutionGenerator();

   @Override
   public ISolutionWriter<S> createSolutionWriter() {
      return new SolutionWriter<S>().setObjectiveNames(getFitnessFunction().getObjectiveNames())
            .setConstraintNames(getFitnessFunction().getConstraintNames());
   }

   @Override
   public NondominatedSortingPopulation createSortingPopulation() {
      return new NondominatedSortingPopulation(new ParetoDominanceComparator());
   }

   @Override
   public String getAlgorithmName(final IRegisteredAlgorithm<? extends Algorithm> algorithm) {
      return algorithmNames.get(algorithm);
   }

   @Override
   public List<IRegisteredAlgorithm<? extends Algorithm>> getAlgorithms() {
      return algorithms;
   }

   @Override
   public IMultiDimensionalFitnessFunction<S> getFitnessFunction() {
      if(fitnessFunction == null) {
         fitnessFunction = createFitnessFunction();
      }
      return fitnessFunction;
   }

   @Override
   public int getNumberOfConstraints() {
      if(fitnessFunction == null) {
         return 0;
      }
      return fitnessFunction.getConstraints().size();
   }

   @Override
   public int getNumberOfObjectives() {
      if(fitnessFunction == null) {
         return 0;
      }
      return fitnessFunction.getObjectives().size();
   }

   public IPopulationWriter<S> getPopulationWriter() {
      if(populationWriter == null) {
         populationWriter = createPopulationWriter();
      }
      return populationWriter;
   }

   @Override
   public ISearchProblem<S> getProblem() {
      if(problem == null) {
         problem = createProblem();
      }
      return problem;
   }

   protected Class<S> getSolutionClass() {
      return solutionClass;
   }

   @Override
   public IRandomSolutionGenerator<S> getSolutionGenerator() {
      if(solutionGenerator == null) {
         solutionGenerator = createSolutionGenerator();
      }
      return solutionGenerator;
   }

   @Override
   public int getSolutionLength() {
      return solutionLength;
   }

   public ISolutionWriter<S> getSolutionPrinter() {
      if(solutionWriter == null) {
         solutionWriter = createSolutionWriter();
      }
      return solutionWriter;
   }

   @Override
   public String print(final Iterable<S> population) {
      return getPopulationWriter().write(population);
   }

   @Override
   public String print(final Population population) {
      return getPopulationWriter().write(population);
   }

   @Override
   public String print(final S solution) {
      return getSolutionPrinter().write(solution);
   }

   @Override
   public void setAlgorithms(final List<IRegisteredAlgorithm<? extends Algorithm>> algorithms) {
      this.algorithms = algorithms;
   }

   public AbstractSearchOrchestration<S> setFitnessFunction(final IMultiDimensionalFitnessFunction<S> fitnessFunction) {
      this.fitnessFunction = fitnessFunction;
      return this;
   }

   protected void setSolutionClass(final Class<S> solutionClass) {
      this.solutionClass = solutionClass;
   }

   public void setSolutionLength(final int solutionLength) {
      this.solutionLength = solutionLength;
   }

   public AbstractSearchOrchestration<S> setSolutionWriter(final ISolutionWriter<S> solutionWriter) {
      this.solutionWriter = solutionWriter;
      return this;
   }
}
