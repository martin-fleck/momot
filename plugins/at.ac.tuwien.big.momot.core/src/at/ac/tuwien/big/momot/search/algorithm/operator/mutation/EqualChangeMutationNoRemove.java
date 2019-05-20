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

import at.ac.tuwien.big.moea.problem.solution.variable.PlaceholderVariable;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.Parameter;
import org.moeaframework.core.PRNG;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

public class EqualChangeMutationNoRemove extends AbstractTransformationMutation {

   private static class Changer {
      private final BiFunction<Solution, Integer, Variable> modifyer;
      private final BiFunction<Solution, Integer, Boolean> checker;

      private final double probability;

      public Changer(final double probability, final BiFunction<Solution, Integer, Boolean> checker,
            final BiFunction<Solution, Integer, Variable> modifyer) {
         this.checker = checker;
         this.probability = probability;
         this.modifyer = modifyer;
      }

      public Changer(final double probability, final BiFunction<Solution, Integer, Boolean> checker,
            final Function<Variable, Variable> modifyer) {
         this(probability, checker, (s, v) -> modifyer.apply(s.getVariable(v)));
      }

      public Variable getModified(final Solution sol, final Integer index) {
         return modifyer.apply(sol, index);
      }

      public double getProbability() {
         return probability;
      }
   }

   private static BiFunction<Solution, Integer, Boolean> OK_TEST = (sol, v) -> true;

   private static BiFunction<Solution, Integer, Boolean> NON_EMPTY_TEST = (sol,
         var) -> (sol.getVariable(var) instanceof ITransformationVariable
               && !(sol.getVariable(var) instanceof PlaceholderVariable));

   private static BiFunction<Solution, Integer, Boolean> PARAMETER_HAVER_TEST = (sol, v) -> {
      final Variable var = sol.getVariable(v);
      if(var instanceof ITransformationVariable && !(var instanceof PlaceholderVariable)) {
         final ITransformationVariable itv = (ITransformationVariable) var;
         boolean hasNonNullParameter = false;
         if(itv.getUnit() != null) {
            for(final Parameter par : itv.getUnit().getParameters()) {
               if(itv.getParameterValue(par) != null) {
                  hasNonNullParameter = true;
                  break;
               }
            }
         } else {
            System.err.println("Variable " + var + " has no rule!");
         }

         return hasNonNullParameter;
      }
      return false;
   };

   final static int MAX_TRIES = 3;

   private static final int MAX_SUBTRIES = 3;
   private final Map<BiFunction<Solution, Integer, Boolean>, List<Changer>> changers = new HashMap<>();

   {
      // addChanger(new Changer(1.0 / 3, NON_EMPTY_TEST, (x) -> new TransformationPlaceholderVariable()));
      addChanger(new Changer(1.0 / 3, PARAMETER_HAVER_TEST, (x) -> {
         // Copied from TransformationParameterMutation
         if(x instanceof ITransformationVariable && !(x instanceof PlaceholderVariable)) {
            final ITransformationVariable randomVariable = (ITransformationVariable) x;
            final EList<Parameter> ruleParameters = randomVariable.getUnit().getParameters();
            boolean done = false;
            for(final Parameter parameter : ruleParameters) {
               final Object value = randomVariable.getParameterValue(parameter);
               // Hmm ... bin mir nicht sicher, ob das sinnvoll ist - aber
               // vermutlich schon
               if(value != null) {
                  final Object paramValue = getModuleManager().nextParameterValue(parameter);
                  if(paramValue != null) {
                     randomVariable.setParameterValue(parameter, paramValue);
                     done = true;
                  }
               }
            }
            if(done) {
               return randomVariable;
            } else {
               return null;
            }
         } else {
            System.err.println("This should not happen!");
            new Exception().printStackTrace();
            return null;
         }

      }));
      addChanger(new Changer(1.0 / 3, OK_TEST, (sol, randomReplace) -> {
         if(sol instanceof TransformationSolution) {
            final TransformationSolution mutant = (TransformationSolution) sol;

            final List<ITransformationVariable> subMatches = Arrays.asList(mutant.getVariables()).subList(0,
                  randomReplace);
            final TransformationSolution subMutant = getSearchHelper().createTransformationSolution(
                  mutant.getSourceGraph(), subMatches, mutant.getNumberOfObjectives(), mutant.getNumberOfConstraints());
            final EGraph result = subMutant.execute();
            final ITransformationVariable variable = getSearchHelper().findUnitApplication(result);
            return variable;
         } else {
            System.err.println("This should not happen: " + sol);
            new Exception().printStackTrace();
            return null;
         }
      }));
   }

   private final ModuleManager moduleManager;
   private final SearchHelper searchHelper;

   public EqualChangeMutationNoRemove(final double probability, final SearchHelper searchHelper,
         final ModuleManager moduleManager) {
      super(probability);
      this.moduleManager = moduleManager;
      this.searchHelper = searchHelper;
   }

   public void addChanger(final Changer... changers) {
      for(final Changer c : changers) {
         this.changers.computeIfAbsent(c.checker, x -> new ArrayList<>()).add(c);
      }
   }

   public void clearChangers() {
      changers.clear();
   }

   private ModuleManager getModuleManager() {
      return moduleManager;
   }

   private SearchHelper getSearchHelper() {
      return searchHelper;
   }

   @Override
   protected TransformationSolution mutate(final TransformationSolution mutant) {

      boolean done = false;

      final Map<BiFunction<Solution, Integer, Boolean>, List<Integer>> applicableIndices = new HashMap<>();
      final List<Changer> applicableChangers = new ArrayList<>();
      for(final Entry<BiFunction<Solution, Integer, Boolean>, List<Changer>> entry : changers.entrySet()) {
         final BiFunction<Solution, Integer, Boolean> checker = entry.getKey();
         final List<Integer> okIndices = new ArrayList<>();
         for(int j = 0; j < mutant.getNumberOfVariables(); ++j) {
            if(checker.apply(mutant, j)) {
               okIndices.add(j);

            }
         }
         applicableIndices.put(checker, okIndices);
         if(!okIndices.isEmpty()) {
            applicableChangers.addAll(entry.getValue());
         }
      }
      for(int cntTry = 0; !done && !applicableChangers.isEmpty() /* && cntTry < MAX_TRIES */; ++cntTry) {

         double sum = 0.0;
         final double[] probs = new double[applicableChangers.size()];
         int ind = 0;

         for(final Changer operator : applicableChangers) {
            final double val = operator.getProbability();
            sum += val;
            probs[ind] = sum;
            ++ind;
         }
         final double choose = PRNG.nextDouble(0.0, sum);
         int chosen = 0;
         for(; chosen < probs.length; ++chosen) {
            if(choose < probs[chosen]) {
               break;
            }
         }
         if(chosen >= probs.length) {
            // Should not be
            new Exception().printStackTrace();
            System.err.println("How can that be?");
            break;
         }
         final Changer changer = applicableChangers.get(chosen);
         final List<Integer> applicableIndicesList = applicableIndices.get(changer.checker);
         Collections.shuffle(applicableIndicesList);
         for(int vn = 0; vn < Math.min(applicableIndicesList.size(), MAX_SUBTRIES); ++vn) {
            final int location = applicableIndicesList.get(vn);
            final Variable newVar = changer.getModified(mutant, location);
            if(newVar != null) {
               done = true;
               mutant.setVariable(location, newVar);
               break;
            }
         }
         if(!done) {
            applicableChangers.remove(changer);
         }
      }
      return mutant;
   }

}
