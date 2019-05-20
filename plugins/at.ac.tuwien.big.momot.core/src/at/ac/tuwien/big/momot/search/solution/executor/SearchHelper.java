/*******************************************************************************
 * s * Copyright (c) 2015 Vienna University of Technology.
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
package at.ac.tuwien.big.momot.search.solution.executor;

import at.ac.tuwien.big.moea.util.CollectionUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.RuleApplicationVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.UnitApplicationVariable;
import at.ac.tuwien.big.momot.util.MomotUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.henshin.interpreter.ApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.InterpreterFactory;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

public class SearchHelper {

   public static class ProfileValues {
      public long applicationTime = 0;
      public long applicationTimeStart = 0;
      public long applicationCount = 0;
      public long findMatchTime = 0;
      public long findMatchTimeStart = 0;
      public long findMatchCount = 0;
      public long fitnessCount = 0;

      public long executionTime = 0;

      public long executionTimeStart = 0;

      public long executionCount = 0;

      public long startTime = System.currentTimeMillis();
      public long endTime = System.currentTimeMillis();

      public String toCsv() {
         return endTime - startTime + "," + fitnessCount + "," + applicationCount + "," + applicationTime + ","
               + findMatchCount + "," + findMatchTime + "," + executionCount + "," + executionTime;
      }
   }

   public static boolean INITIALIZE_SOLUTIONS = true;

   public static final int UNLIMITED = -1;

   public static final int DEFAULT_NR_TRIES_PER_RULE = 5;

   private static ProfileValues profile = new ProfileValues();

   static Map<String, Integer> fitnessCounts = new HashMap<>();

   private static synchronized void addCompleteApplicationTime(final long time) {
      profile.applicationTime += time;
      ++profile.applicationCount;
   }

   private static synchronized void addExecutionTime(final long time) {
      profile.executionCount++;
      profile.executionTime += time;
   }

   private static synchronized void addFindMatchTime(final long time) {
      profile.findMatchCount++;
      profile.findMatchTime += time;
   }

   public static synchronized void addFitnessCount() {

      /*
       * {
       * final StackTraceElement[] stackTrace = new Exception().getStackTrace();
       * final StringBuilder builder = new StringBuilder();
       * for(final StackTraceElement ste : stackTrace) {
       * builder.append(ste.toString());
       * builder.append("\n");
       * }
       * fitnessCounts.merge(builder.toString(), 1, (x, y) -> x + y);
       * }
       */
      profile.fitnessCount++;
   }

   public static synchronized void endCompleteApplicationTime() {
      if(profile.applicationTimeStart != 0) {
         addCompleteApplicationTime(System.currentTimeMillis() - profile.applicationTimeStart);
         profile.applicationTimeStart = 0;
      }
   }

   public static synchronized void endExecutionTime() {
      if(profile.executionTimeStart != 0) {
         addExecutionTime(System.currentTimeMillis() - profile.executionTimeStart);
         profile.executionTimeStart = 0;
      }
   }

   public static synchronized void endFindMatchTime() {
      if(profile.findMatchTimeStart != 0) {
         addFindMatchTime(System.currentTimeMillis() - profile.findMatchTimeStart);
         profile.findMatchTimeStart = 0;
      }
   }

   public static ProfileValues peekProfile() {
      return profile;
   }

   public static ProfileValues pollProfile() {
      try {
         profile.endTime = System.currentTimeMillis();
         return profile;
      } finally {
         profile = new ProfileValues();
      }
   }

   public static synchronized void startCompleteApplicationTime() {
      profile.applicationTimeStart = System.currentTimeMillis();
   }

   public static synchronized void startExecutionTime() {
      profile.executionTimeStart = System.currentTimeMillis();
   }

   public static synchronized void startFindMatchTime() {
      profile.findMatchTimeStart = System.currentTimeMillis();
   }

   protected TransformationSearchOrchestration searchOrchestration;

   protected Engine engine;

   protected int maxTriesPerUnit = DEFAULT_NR_TRIES_PER_RULE;

   protected ApplicationMonitor monitor = null;

   public SearchHelper() {
   }

   public SearchHelper(final Engine engine, final TransformationSearchOrchestration searchOrchestration) {
      this.engine = engine;
      this.searchOrchestration = searchOrchestration;
   }

   public SearchHelper(final TransformationSearchOrchestration searchOrchestration) {
      this(searchOrchestration.getEngine(), searchOrchestration);
   }

   public TransformationSolution appendRandomVariables(final TransformationSolution solution, final int nrVariables) {
      final int newSolutionLength = solution.getNumberOfVariables() + nrVariables;
      final TransformationSolution extendedSolution = new TransformationSolution(solution.getSourceGraph(),
            newSolutionLength, solution.getNumberOfObjectives(), solution.getNumberOfConstraints());
      solution.setEqualityHelper(getSearchOrchestration().getEqualityHelper());

      final EGraph searchGraph = solution.execute();

      final List<ITransformationVariable> variables = new ArrayList<>(Arrays.asList(solution.getVariables()));
      if(nrVariables >= 1) {
         ITransformationVariable var = findUnitApplication(searchGraph);
         while(var != null) {
            var.execute(false);
            if(var.isExecuted()) {
               variables.add(var);
            }
            if(variables.size() >= nrVariables) {
               break;
            }
            var = findUnitApplication(searchGraph);
         }
      }

      extendedSolution.setTransformation(variables, searchGraph);

      return extendedSolution;
   }

   private ITransformationVariable clean(final ITransformationVariable variable) {
      getModuleManager().clearNonSolutionParameters(variable);
      return variable;
   }

   @Override
   public SearchHelper clone() {
      final TransformationSearchOrchestration tso = searchOrchestration.clone();
      final SearchHelper ret = new SearchHelper(tso);
      ret.engine.getOptions().putAll(engine.getOptions());
      return ret;
   }

   public UnitApplicationVariable createApplication(final EGraph graph, final Assignment assignment) {
      return new UnitApplicationVariable(getEngine(), graph, assignment.getUnit(), assignment);
   }

   public RuleApplicationVariable createApplication(final EGraph graph, final Match match) {
      return new RuleApplicationVariable(getEngine(), graph, match.getRule(), match);
   }

   public TransformationSolution createEmptyTransformationSolution() {
      final TransformationSolution solution = new TransformationSolution(getSearchOrchestration());
      solution.setEqualityHelper(getSearchOrchestration().getEqualityHelper());
      return solution;
   }

   public TransformationSolution createEmptyTransformationSolution(final int solutionLength, final int nrObjectives,
         final int nrConstraints) {
      final TransformationSolution solution = new TransformationSolution(getSearchOrchestration().getProblemGraph(),
            solutionLength, nrObjectives, nrConstraints);
      for(int i = 0; i < solutionLength; i++) {
         solution.setVariable(i, new TransformationPlaceholderVariable());
      }
      solution.setEqualityHelper(getSearchOrchestration().getEqualityHelper());
      return solution;
   }

   protected Match createPartialAssignment(final Rule rule) {
      return getModuleManager().assignParameterValues(InterpreterFactory.INSTANCE.createMatch(rule, false));
   }

   protected Assignment createPartialAssignment(final Unit unit) {
      if(unit instanceof Rule) {
         return createPartialAssignment((Rule) unit);
      }
      return getModuleManager().assignParameterValues(InterpreterFactory.INSTANCE.createAssignment(unit, false));
   }

   public TransformationSolution createRandomTransformationSolution() {
      return createRandomTransformationSolution(getSearchOrchestration().getSolutionLength(),
            getSearchOrchestration().getNumberOfObjectives(), getSearchOrchestration().getNumberOfConstraints());
   }

   public TransformationSolution createRandomTransformationSolution(final int solutionLength, final int nrObjectives,
         final int nrConstraints) {

      final EGraph searchGraph = MomotUtil.copy(getSearchOrchestration().getProblemGraph());
      final TransformationSolution solution = createEmptyTransformationSolution(solutionLength, nrObjectives,
            nrConstraints);

      final List<ITransformationVariable> variables = new ArrayList<>();

      if(solutionLength >= 1) {
         ITransformationVariable variable = findUnitApplication(searchGraph);
         while(variable != null) {
            variable.execute(false);
            if(variable.isExecuted()) {
               variables.add(variable);
            }
            if(variables.size() >= solutionLength || !INITIALIZE_SOLUTIONS) {
               break;
            }
            variable = findUnitApplication(searchGraph);
         }
      }
      solution.setTransformation(variables, searchGraph);
      // System.out.println(variables);
      return solution;
   }

   public TransformationSolution createTransformationSolution(final EGraph sourceGraph,
         final List<? extends ITransformationVariable> variables, final int numberOfObjectives) {
      final TransformationSolution solution = new TransformationSolution(sourceGraph, variables, numberOfObjectives);
      solution.setEqualityHelper(getSearchOrchestration().getEqualityHelper());
      return solution;
   }

   public TransformationSolution createTransformationSolution(final EGraph sourceGraph,
         final List<? extends ITransformationVariable> variables, final int numberOfObjectives,
         final int numberOfConstraints) {
      final TransformationSolution solution = new TransformationSolution(sourceGraph, variables, numberOfObjectives,
            numberOfConstraints);
      solution.setEqualityHelper(getSearchOrchestration().getEqualityHelper());
      return solution;
   }

   public ITransformationVariable findUnitApplication(final EGraph graph) {
      return findUnitApplication(graph, getMaxTriesPerUnit());
   }

   public ITransformationVariable findUnitApplication(final EGraph graph, final int maxTries) {
      startCompleteApplicationTime();
      try {
         // choose a unit randomly
         final List<? extends Unit> units = new ArrayList<>(getUnits());
         Unit chosenUnit = CollectionUtil.getRandomElement(units);

         // try to apply rule until match is found or maxRuleTries is reached
         int nrUnitTries = maxTries;

         while(chosenUnit != null) {
            // create assignment with user-defined parameter values
            final Assignment partialMatch = createPartialAssignment(chosenUnit);

            if(chosenUnit instanceof Rule) {
               // find matches
               /*
                * final Iterator<Match> foundMatches = getEngine().findMatches((Rule) chosenUnit, graph, (Match)
                * partialMatch)
                * .iterator();
                * if(foundMatches != null && foundMatches.hasNext()) {
                */
               // match found - break loop, return match
               // final Match match = foundMatches.next();
               startFindMatchTime();
               final UnitApplicationVariable application = createApplication(graph, partialMatch);
               endFindMatchTime();
               startExecutionTime();
               if(application.execute(getMonitor())) {
                  for(final Parameter param : chosenUnit.getParameters()) {
                     application.setParameterValue(param, application.getResultParameterValue(param));
                  }
                  endExecutionTime();
                  return clean(application);
               } else {
                  application.undo(getMonitor());
                  endExecutionTime();
               }
               // }
            } else {
               final UnitApplicationVariable application = createApplication(graph, partialMatch);
               if(application.execute(getMonitor())) {
                  application.setAssignment(application.getResultAssignment());
                  return clean(application);
               } else {
                  application.undo(getMonitor());
               }
            }

            if(partialMatch.isEmpty()) {
               // no match found and no user-defined parameter values
               // -> further tries of this unit will yield same result
               nrUnitTries = 0; // skip further tries for this unit
            }

            if(--nrUnitTries <= 0) {
               // try other rule
               units.remove(chosenUnit); // don't try this rule again
               chosenUnit = CollectionUtil.getRandomElement(units);
               nrUnitTries = maxTries;
            }
         }

      } finally {
         endCompleteApplicationTime();
      }
      return null; // no match found with the number of tries
   }

   public List<ITransformationVariable> findUnitApplications(final EGraph graph) {
      return findUnitApplications(graph, getMaxTriesPerUnit());
   }

   private List<ITransformationVariable> findUnitApplications(final EGraph graph, final int maxTries) {
      final List<ITransformationVariable> variables = new ArrayList<>();
      startCompleteApplicationTime();
      try {
         // choose a unit randomly
         final List<Unit> units = new ArrayList<>(getUnits());
         Unit chosenUnit = CollectionUtil.getRandomElement(units);

         // try to apply rule until match is found or maxRuleTries is reached
         int nrUnitTries = maxTries;

         while(chosenUnit != null) {
            // create assignment with user-defined parameter values
            final Assignment partialMatch = createPartialAssignment(chosenUnit);

            if(chosenUnit instanceof Rule) {
               // find matches

               startFindMatchTime();
               final Iterator<Match> foundMatches = getEngine()
                     .findMatches((Rule) chosenUnit, graph, (Match) partialMatch).iterator();

               if(foundMatches != null && foundMatches.hasNext()) {
                  // match found - break loop, return match
                  final Match match = getModuleManager().clearNonSolutionParameters(foundMatches.next());
                  variables.add(createApplication(graph, match));
               }
               endFindMatchTime();
            } else {

               startCompleteApplicationTime();
               final UnitApplicationVariable application = createApplication(graph, partialMatch);
               endFindMatchTime();
               startExecutionTime();
               if(application.execute(getMonitor())) {
                  variables.add(application);
               }
               final long subEnd = System.currentTimeMillis();
               endExecutionTime();
            }

            if(partialMatch.isEmpty()) {
               // no match found and no user-defined parameter values
               // -> further tries of this unit will yield same result
               nrUnitTries = 0; // skip further tries for this unit
            }

            if(--nrUnitTries <= 0) {
               // try other rule
               units.remove(chosenUnit); // don't try this rule again
               chosenUnit = CollectionUtil.getRandomElement(units);
               nrUnitTries = maxTries;
            }
         }
      } finally {
         endCompleteApplicationTime();
      }
      return variables;
   }

   public Engine getEngine() {
      return engine;
   }

   public int getMaxTriesPerUnit() {
      return maxTriesPerUnit;
   }

   public ModuleManager getModuleManager() {
      return getSearchOrchestration().getModuleManager();
   }

   public ApplicationMonitor getMonitor() {
      return monitor;
   }

   protected List<Rule> getRules() {
      return getModuleManager().getRules();
   }

   public TransformationSearchOrchestration getSearchOrchestration() {
      return searchOrchestration;
   }

   protected List<? extends Unit> getUnits() {
      return getModuleManager().getUnits();
   }

   public void setEngine(final Engine engine) {
      this.engine = engine;
   }

   public void setMaxTriesPerUnit(final int maxTriesPerUnit) {
      this.maxTriesPerUnit = maxTriesPerUnit;
   }

   public void setMonitor(final ApplicationMonitor monitor) {
      this.monitor = monitor;
   }

   public void setSearchOrchestration(final TransformationSearchOrchestration searchOrchestration) {
      this.searchOrchestration = searchOrchestration;
   }
}
