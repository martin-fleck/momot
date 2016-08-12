package at.ac.tuwien.big.momot.examples.stack;

import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.search.engine.MomotEngine;

import java.util.Random;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.ProfilingApplicationMonitor;

public class StackCreator {
   public static final String EMPTY_MODEL = "empty_model.xmi";

   public static final StackCreator INSTANCE = new StackCreator();

   private static final int INITIAL_VALUE = 0;

   private static final int STEP_SIZE = 1;

   private static int STACK_INDEX = 0;

   private static final String BASE_NAME = "Stack_";

   private static String currentName() {
      return previousName(0);
   }

   private static String firstName() {
      return BASE_NAME + (INITIAL_VALUE + STEP_SIZE);
   }

   private static String newName() {
      STACK_INDEX += STEP_SIZE;
      return currentName();
   }

   protected static String nextName() {
      return nextName(1);
   }

   private static String nextName(final int steps) {
      return BASE_NAME + (STACK_INDEX + steps * STEP_SIZE);
   }

   private static String previousName() {
      return previousName(1);
   }

   private static String previousName(final int steps) {
      return BASE_NAME + (STACK_INDEX - steps * STEP_SIZE);
   }

   private final ModuleManager henshin = new ModuleManager("model/");

   public StackCreator() {
      henshin.addModule("stack.henshin");
   }

   public EGraph createStacksGraph(final int nrStacks, final Integer[] loads, final String targetResource) {
      if(nrStacks != loads.length) {
         throw new IllegalArgumentException("Must provide load for all stacks.");
      }
      final EGraph graph = new EGraphImpl(henshin.getResourceSet().getResource(EMPTY_MODEL));

      final MomotEngine engine = new MomotEngine(false);
      final RuleApplication createStackApp = henshin.createRuleApplication(engine, "createStack", graph);

      final RuleApplication connectStacksApp = henshin.createRuleApplication(engine, "connectStacks", graph);

      final ProfilingApplicationMonitor monitor = new ProfilingApplicationMonitor();
      for(int i = 0; i < nrStacks; i++) {
         createStackApp.setParameterValue("stackId", newName());
         createStackApp.setParameterValue("stackLoad", loads[i]);
         createStackApp.execute(monitor);

         if(i > 0) {
            connectStacksApp.setParameterValue("left", previousName());
            connectStacksApp.setParameterValue("right", currentName());
            connectStacksApp.execute(monitor);
         }
      }
      connectStacksApp.setParameterValue("left", currentName());
      connectStacksApp.setParameterValue("right", firstName());
      connectStacksApp.execute(monitor);

      // monitor.printStats();

      henshin.saveGraph(graph, targetResource);

      return graph;
   }

   public EGraph createStacksGraph(final int nrStacks, final String targetResource) {
      final Integer[] loads = new Integer[nrStacks];
      for(int i = 0; i < nrStacks; i++) {
         loads[i] = new Random().nextInt(10);
      }
      return createStacksGraph(nrStacks, loads, targetResource);
   }

   public EGraph createStacksGraph(final Integer[] loads, final String targetResource) {
      return createStacksGraph(loads.length, loads, targetResource);
   }
}
