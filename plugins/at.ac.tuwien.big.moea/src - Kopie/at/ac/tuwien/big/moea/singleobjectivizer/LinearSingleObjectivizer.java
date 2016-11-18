package at.ac.tuwien.big.moea.singleobjectivizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LinearSingleObjectivizer implements SingleObjectivizer {
	
	private double[] values;
	private double baseVal;
	
	public LinearSingleObjectivizer(double... multiplicateWith) {
		this.values = multiplicateWith;
		this.baseVal = 0.0;
	}
	

	@Override
	public double calculateSingleObjective(double[] vals) {
		double ret = baseVal;
		for (int i = 0; i < vals.length; ++i) {
			ret+= vals[i]*values[i];
		}
		return ret;
	}
	
	public static Random random = new Random();


	public LinearSingleObjectivizer randomPreference() {
		double[] ret = Arrays.copyOf(values, values.length);
		for (int i = 0; i < ret.length-1; ++i) {
			ret[i] = random.nextDouble()*ret[i];
		}
		return new LinearSingleObjectivizer(ret);
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < values.length; ++i) {
			if (i > 0) {ret.append(" + ");}
			ret.append(values[i]+" x"+(i+1));
		}
		return ret.toString();
	}
	
	private static Map<Integer,List<double[]>> multiplicators = new HashMap<>();
	private static Map<Integer,Integer> stepCount = new HashMap<>();
	
	public static void generateBinaryMultiplicators(double[] ar, int curIndex, int distributeBytes, List<double[]> newList, int maxVal) {
		if (distributeBytes < 0) {
			return;
		}
		if (distributeBytes == 0) {
			//everything non-filled
			double[] newAr = Arrays.copyOf(ar, ar.length);
			for (int i = curIndex; i < newAr.length; ++i) {
				newAr[i] = 0.0;
			}
			newList.add(newAr);
			return;
		}
		if ((ar.length-curIndex)*maxVal >= distributeBytes) {
			//everything filled
			double[] newAr = Arrays.copyOf(ar, ar.length);
			for (int i = curIndex; i < newAr.length; ++i) {
				newAr[i] = maxVal;
			}
			newList.add(newAr);
			return;
		}
		
		if (curIndex%2 == 0) {
			for (int val = 0; val <= maxVal; ++val) {
				ar[curIndex] = val;
				generateBinaryMultiplicators(ar, curIndex+1, distributeBytes-val, newList, maxVal);
			}
		} else {
			//First 1, then 0
			for (int val = maxVal; val >= 0; --val) {
				ar[curIndex] = val;
				generateBinaryMultiplicators(ar, curIndex+1, distributeBytes-val, newList, maxVal);
			}
		}
	}
	
	public static List<double[]> generateMultiplicators(int length, int step) {
		synchronized(LinearSingleObjectivizer.class) {
			List<double[]> ret = multiplicators.get(length);
			if (ret == null) {
				multiplicators.put(length, ret = new ArrayList<double[]>());
			}
			if (stepCount.getOrDefault(length, 0) >= step) {
				return ret;
			}
			List<double[]> newList = new ArrayList<double[]>();
			multiplicators.put(length, newList);
			double[] ar = new double[length];
			for (int i = 0; i < ar.length; ++i) {
				ar[i] = 1.0;
			}
			newList.add(ar);
			for (int curStep = 1; curStep <= step; ++curStep) {
				for (int numBytes = 1; numBytes < length*curStep; ++numBytes) {
					generateBinaryMultiplicators(ar,0,numBytes,newList, curStep);
				}
			}			
			return newList;
		}
		
	}
	
	private static double[] getMultiplicator(int state, int length) {
		List<double[]> list = generateMultiplicators(length,2);
		int curStep = 3;
		while (list.size() <= state) {
			list = generateMultiplicators(length,curStep);
			++curStep;
		}
		return list.get(state);
	}

	public LinearSingleObjectivizer systematicRandomPreference(int state) {
		double[] ret = Arrays.copyOf(values, values.length);
		double[] mult = getMultiplicator(state, ret.length);
		for (int i = 0; i < ret.length-1; ++i) {
			ret[i] = mult[i]*ret[i];
		}
		return new LinearSingleObjectivizer(ret);
	}
}
