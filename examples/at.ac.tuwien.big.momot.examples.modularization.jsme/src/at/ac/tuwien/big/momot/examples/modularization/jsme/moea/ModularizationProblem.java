package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.BinaryVariable;
import org.moeaframework.problem.AbstractProblem;

public class ModularizationProblem extends AbstractProblem {

   public static final String ATTRIBUTE_MODULARIZATION = "modularization";
   public static final String ATTRIBUTE_METRICS = "metrics";

   public static final int CONSTRAINT_EMPTY_MODULES = 0;
   public static final int CONSTRAINT_UNASSIGNED_CLASSES = 1;

   public static final int OBJECTIVE_COUPLING = 0;
   public static final int OBJECTIVE_COHESION = 1;
   public static final int OBJECTIVE_NRMODULES = 2;
   public static final int OBJECTIVE_MQ = 3;
   public static final int OBJECTIVE_MINMAXDIFF = 4;

   public static int getNrBits(final int number) {
      return BitSet.valueOf(new long[] { number }).length();
   }

   public static int toInt(final BinaryVariable variable) {
      return toInt(variable.getBitSet());
   }

   public static int toInt(final BitSet bitSet) {
      final long[] longArray = bitSet.toLongArray();
      if(longArray.length > 0) {
         return new Long(longArray[0]).intValue();
      }
      return 0;
   }

   public static String toString(final BinaryVariable variable) {
      return toString(variable.getBitSet().get(1, variable.getBitSet().size()));
   }

   public static String toString(final BitSet set) {
      final StringBuilder sb = new StringBuilder();
      for(int i = 0; i < set.length(); i++) {
         sb.append(set.get(i) ? "1" : "0");
      }
      return sb.reverse().toString();
   }

   protected ModularizationInstance instance;

   protected ModularizationCalculator calculator;

   public ModularizationProblem(final List<String> classes, final Map<String, List<String>> dependencies) {
      this(new ModularizationInstance(classes, dependencies));
   }

   public ModularizationProblem(final ModularizationInstance instance) {
      super(instance.getClasses().size(), 5, 2);
      this.instance = instance;
      this.calculator = new ModularizationCalculator();
   }

   public ModularizationProblem(final String[] classes, final Map<String, List<String>> dependencies) {
      this(Arrays.asList(classes), dependencies);
   }

   @Override
   public void evaluate(final Solution solution) {
      final List<Integer> assignment = new ArrayList<>();
      for(int i = 0; i < solution.getNumberOfVariables(); i++) {
         assignment.add(toInt((BinaryVariable) solution.getVariable(i)));
      }

      final ModularizationResult modularization = new ModularizationResult(instance, assignment);

      final ModelMetrics metrics = this.calculator.calculate(modularization);

      solution.setObjective(OBJECTIVE_COUPLING, metrics.coupling);
      solution.setObjective(OBJECTIVE_COHESION, metrics.cohesion * -1);
      solution.setObjective(OBJECTIVE_NRMODULES, metrics.nrModules * -1);
      solution.setObjective(OBJECTIVE_MQ, metrics.modularizationQuality * -1);
      solution.setObjective(OBJECTIVE_MINMAXDIFF, metrics.minMaxDiff);

      solution.setConstraint(CONSTRAINT_EMPTY_MODULES, metrics.nrEmptyModules);
      solution.setConstraint(CONSTRAINT_UNASSIGNED_CLASSES, metrics.nrUnassignedClasses);

      solution.setAttribute(ATTRIBUTE_MODULARIZATION, modularization);
      solution.setAttribute(ATTRIBUTE_METRICS, metrics);
   }

   @Override
   public Solution newSolution() {
      final Solution solution = new Solution(getNumberOfVariables(), getNumberOfObjectives(), getNumberOfConstraints());
      final int length = getNrBits(getNumberOfVariables()); // at most n modules for n classes
      for(int i = 0; i < getNumberOfVariables(); i++) {
         solution.setVariable(i, new BinaryVariable(length));
      }
      return solution;
   }
}
