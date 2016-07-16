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
	
	private int maxLoad;
	private Integer[] initialLoads;
			
	public NativeStackProblem(Integer[] loads) {
		this(Arrays.asList(loads));
	}
	
	public NativeStackProblem(List<Integer> loads) {
		super(loads.size(), 2, 1);
		
		this.initialLoads = (Integer[]) loads.toArray();
		this.maxLoad = Integer.MIN_VALUE;
		for(Integer load : loads)
			if(load > maxLoad)
				maxLoad = load;
	}

	public Integer[] getInitialLoads() {
		return initialLoads;
	}
	
	public int getMaxLoad() {
		return maxLoad;
	}
	
	public static double getMean(Integer... values) {
        double mean = 0.0;
        if ((values != null) && (values.length > 0)) {
            for (Integer value : values) {
                mean += value;
            }
            mean /= values.length;
        }
        return mean;
    }
	
	public static double getStandardDeviation(Integer... values) {
        double deviation = 0.0;
        if ((values != null) && (values.length > 1)) {
            double mean = getMean(values);
            for (double value : values) {
                double delta = value-mean;
                deviation += delta*delta;
            }
            deviation = Math.sqrt(deviation/values.length);
        }
        return deviation;
    }
	
	@Override
	public void evaluate(Solution solution) {	
		Integer[] result = apply(solution, getInitialLoads());
		double standardDeviation = getStandardDeviation(result);
		solution.setObjective(OBJECTIVE_STANDARD_DEVIATION, standardDeviation);
		
		int solutionLength = 0;
		for(int i = 0; i < getNumberOfVariables(); i += 1) {
			int shiftLoad = toLoad((BinaryVariable) solution.getVariable(i));
			if(shiftLoad != 0)
				solutionLength++;
		}
		solution.setObjective(OBJECTIVE_SOLUTION_LENGTH, solutionLength);
		
		for(Integer stack : result) 
			if(stack < 0)
				solution.setConstraint(CONSTRAINT_NO_NEGATIVE_LOAD, CONSTRAINT_PENALTY);		
	}

	public static int getNrBits(int number) {
		return BitSet.valueOf(new long[] { number }).length();
	}
	
	@Override
	public Solution newSolution() {
		Solution solution = new Solution(getNumberOfVariables(), getNumberOfObjectives(), getNumberOfConstraints());
		int length = getNrBits(getMaxLoad()) + 1;
		for(int i = 0; i < getNumberOfVariables(); i++)
			solution.setVariable(i, new BinaryVariable(length));
		return solution;
	}
	
	public static int toInt(BitSet bitSet) {
		long[] longArray = bitSet.toLongArray();
		if(longArray.length > 0)
			return new Long(longArray[0]).intValue();
		return 0;
	}
	
	public static int toLoad(BinaryVariable variable) {
		BitSet bitSet = variable.getBitSet();
		BitSet trueValue = bitSet.get(1, bitSet.size());
		return toInt(trueValue);
	}
	
	public static String toString(BitSet set) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < set.length(); i++) {
			sb.append(set.get(i) ? "1" : "0");
		}
		return sb.reverse().toString();
	}
	
	public static String toString(BinaryVariable variable) {
		return toString(variable.getBitSet().get(1, variable.getBitSet().size()));
	}

	public static Integer[] apply(Solution solution, Integer[] initialLoad) {
		Integer[] load = Arrays.copyOf(initialLoad, initialLoad.length);
		for(int i = 0; i < initialLoad.length; i++) {
			BinaryVariable var = (BinaryVariable) solution.getVariable(i);
			int moveLoad = toLoad(var);
			load[i] -= moveLoad;
			
			int neighborIndex = var.get(0) ? (i + 1) % load.length : (i - 1) % load.length;
			while(neighborIndex < 0)
				neighborIndex += load.length;
			
			load[neighborIndex] += moveLoad;
		}
		return load;
	}
}
