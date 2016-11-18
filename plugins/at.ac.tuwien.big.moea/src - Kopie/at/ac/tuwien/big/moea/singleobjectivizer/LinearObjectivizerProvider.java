package at.ac.tuwien.big.moea.singleobjectivizer;

import java.util.Arrays;
import java.util.List;

import Jama.Matrix;
import Jama.QRDecomposition;
import at.ac.tuwien.big.moea.problem.solution.ParetoFront;
import at.ac.tuwien.big.moea.problem.solution.SearchSolution;

public class LinearObjectivizerProvider implements SingleObjectivizerProvider {

	@Override
	public SingleObjectivizer provide(ParetoFront front) {
		if (true) {
			List<SearchSolution> sols = front.getParetoFront();
			int numObjectives = 0;
			if (sols.isEmpty() || sols.size() < (numObjectives = sols.get(0).getNumberOfObjectives())) {
				//You can't calculate something sensible here ...
				if (sols.isEmpty()) {
					return new ObjectiveAdder();
				}
				double[] ar = new double[numObjectives];
				for (int i = 0; i < ar.length; ++i) {
					ar[i] = 1.0;
				}
				return new LinearSingleObjectivizer(ar);
			}

			double[] min = new double[numObjectives];
			double[] max = new double[numObjectives];
			double[][] x = new double[sols.size()][];
			for (int i = 0; i < sols.size(); ++i) {
				x[i] = sols.get(i).getObjectives();
				x[i] = Arrays.copyOf(x[i], x[i].length);
				if (i == 0) {
					min = Arrays.copyOf(x[i], x[i].length);
					max = Arrays.copyOf(x[i], x[i].length);
				} else {
					for (int j = 0; j < x[i].length; ++j) {
						min[j] = Math.min(x[i][j], min[j]);
						max[j] = Math.max(x[i][j], max[j]);
					}
				}
			}
			double[] diff = new double[numObjectives];
			for (int i = 0; i < diff.length; ++i) {
				diff[i] = 1.0/Math.max(0.1, max[i]-min[i]);
			}
			return new LinearSingleObjectivizer(diff);
		}
		
		//Geht so nicht
		//Solve the linear equation to linearily regress f(x_1,...,x_n) = 0 for the pareto front
		//From http://introcs.cs.princeton.edu/java/97data/MultipleLinearRegression.java.html, adapted
		double[][] x;
		int numObjectives;
		synchronized(front) {
			List<SearchSolution> sols = front.getParetoFront();
			if (sols.isEmpty() || sols.size() < (numObjectives = sols.get(0).getNumberOfObjectives())) {
				//You can't calculate something sensible here ...
				return new ObjectiveAdder();
			}
			x = new double[sols.size()][];
			for (int i = 0; i < sols.size(); ++i) {
				x[i] = sols.get(i).getObjectives();
				x[i] = Arrays.copyOf(x[i], x[i].length);
			}
		}
		double[] retAr = new double[numObjectives+1];
		try {

	        Matrix values = new Matrix(x);
	        double[] target = new double[x.length];
	        for (int i = 0; i < target.length; ++i) {
	        	target[i] = 1.0;
	        }
	        QRDecomposition qr = new QRDecomposition(values);
	        Matrix result = qr.solve(new Matrix(target,target.length));
	        double retArSum = 0.0;
	        for (int i = 0; i < numObjectives+1; ++i) {
	        	//Looks like we have a minimization, not a maximization problem
	        	retAr[i] = Math.min(0.0, result.get(i, 0));
	        	retArSum+= retAr[i];
	        }
	        if (retArSum == 0.0) {
	        	return new ObjectiveAdder();
	        }
		} catch (RuntimeException e) {
			return new ObjectiveAdder();
		}
      
		return new LinearSingleObjectivizer(retAr);
	}

}
