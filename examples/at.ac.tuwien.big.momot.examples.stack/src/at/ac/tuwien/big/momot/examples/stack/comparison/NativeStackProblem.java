package at.ac.tuwien.big.momot.examples.stack.comparison;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.BinaryVariable;
import org.moeaframework.problem.AbstractProblem;

public class NativeStackProblem extends AbstractProblem {

   public static final int CONSTRAINT_NO_NEGATIVE_LOAD = 0;
   private static final Double CONSTRAINT_PENALTY = Double.POSITIVE_INFINITY;

   public static final int OBJECTIVE_STANDARD_DEVIATION = 1;
   public static final int OBJECTIVE_SOLUTION_LENGTH = 0;

   public static Integer[] apply(final Solution solution, final Integer[] initialLoad) {
      final Integer[] load = Arrays.copyOf(initialLoad, initialLoad.length);
      for(int i = 0; i < initialLoad.length; i++) {
         final BinaryVariable var = (BinaryVariable) solution.getVariable(i);
         final int moveLoad = toLoad(var);
         load[i] -= moveLoad;

         int neighborIndex = var.get(0) ? (i + 1) % load.length : (i - 1) % load.length;
         while(neighborIndex < 0) {
            neighborIndex += load.length;
         }

         load[neighborIndex] += moveLoad;
      }
      return load;
   }

   public static double getMean(final Integer... values) {
      double mean = 0.0;
      if(values != null && values.length > 0) {
         for(final Integer value : values) {
            mean += value;
         }
         mean /= values.length;
      }
      return mean;
   }

   public static int getNrBits(final int number) {
      return BitSet.valueOf(new long[] { number }).length();
   }

   public static double getStandardDeviation(final Integer... values) {
      double deviation = 0.0;
      if(values != null && values.length > 1) {
         final double mean = getMean(values);
         for(final double value : values) {
            final double delta = value - mean;
            deviation += delta * delta;
         }
         deviation = Math.sqrt(deviation / values.length);
      }
      return deviation;
   }

   public static int toInt(final BitSet bitSet) {
      final long[] longArray = bitSet.toLongArray();
      if(longArray.length > 0) {
         return new Long(longArray[0]).intValue();
      }
      return 0;
   }

   public static int toLoad(final BinaryVariable variable) {
      final BitSet bitSet = variable.getBitSet();
      final BitSet trueValue = bitSet.get(1, bitSet.size());
      return toInt(trueValue);
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

   private int maxLoad;

   private final Integer[] initialLoads;

   public NativeStackProblem(final Integer[] loads) {
      this(Arrays.asList(loads));
   }

   public NativeStackProblem(final List<Integer> loads) {
      super(loads.size(), 2, 1);

      this.initialLoads = (Integer[]) loads.toArray();
      this.maxLoad = Integer.MIN_VALUE;
      for(final Integer load : loads) {
         if(load > maxLoad) {
            maxLoad = load;
         }
      }
   }

   @Override
   public void evaluate(final Solution solution) {
      final Integer[] result = apply(solution, getInitialLoads());
      final double standardDeviation = getStandardDeviation(result);
      solution.setObjective(OBJECTIVE_STANDARD_DEVIATION, standardDeviation);

      int solutionLength = 0;
      for(int i = 0; i < getNumberOfVariables(); i += 1) {
         final int shiftLoad = toLoad((BinaryVariable) solution.getVariable(i));
         if(shiftLoad != 0) {
            solutionLength++;
         }
      }
      solution.setObjective(OBJECTIVE_SOLUTION_LENGTH, solutionLength);

      for(final Integer stack : result) {
         if(stack < 0) {
            solution.setConstraint(CONSTRAINT_NO_NEGATIVE_LOAD, CONSTRAINT_PENALTY);
         }
      }
   }

   public Integer[] getInitialLoads() {
      return initialLoads;
   }

   public int getMaxLoad() {
      return maxLoad;
   }

   @Override
   public Solution newSolution() {
      final Solution solution = new Solution(getNumberOfVariables(), getNumberOfObjectives(), getNumberOfConstraints());
      final int length = getNrBits(getMaxLoad()) + 1;
      for(int i = 0; i < getNumberOfVariables(); i++) {
         solution.setVariable(i, new BinaryVariable(length));
      }
      return solution;
   }
}
