package at.ac.tuwien.big.momot.search.algorithm.local.neighborhood;



import java.util.ArrayList;
import java.util.List;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.IParetoFrontStoringSearchProblem;   
import at.ac.tuwien.big.moea.problem.solution.ParetoFront;
import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimator;
import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparatorGenerator;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearObjectivizerProvider;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearSingleObjectivizer;
import at.ac.tuwien.big.moea.singleobjectivizer.ObjectiveAdder;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizer;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class SingleObjectiveFitnessGenerator implements IDeltaEstimatorGenerator<Double,TransformationSolution> {
	
	public static enum RandomizeType {
		NO_RANDOM, SYSTEMATIC_RANDOM, FULL_RANDOM
	}
	
	private RandomizeType randomizeLocalSearch;
	
	public SingleObjectiveFitnessGenerator(boolean randomizeLocalSearch) {
		this.randomizeLocalSearch = randomizeLocalSearch?RandomizeType.FULL_RANDOM:RandomizeType.SYSTEMATIC_RANDOM;
	}
	
	private int state;
	
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public IDeltaEstimator<Double, TransformationSolution> generateComparator(Problem forProblem,
			TransformationSolution forInitialSolution, NondominatedPopulation curParetoFront) {
		SingleObjectivizer ret;
		LinearObjectivizerProvider provider = new LinearObjectivizerProvider();
		List<Solution> copy = new ArrayList<Solution>();
		for (Solution sol: curParetoFront) {
			copy.add(sol);
		}
		ret = provider.provide(copy);
		if (!(ret instanceof LinearSingleObjectivizer)) {
			double[] ar = new double[forInitialSolution.getNumberOfObjectives()];
			for (int i = 0; i < ar.length; ++i) {
				ar[i] = 1;
			}
			ret = new LinearSingleObjectivizer(ar);
		}
		
		
		if (ret instanceof LinearSingleObjectivizer) {
			switch(randomizeLocalSearch) {
			case FULL_RANDOM:
				ret = ((LinearSingleObjectivizer)ret).randomPreference();
				break;
			case SYSTEMATIC_RANDOM:
				ret = ((LinearSingleObjectivizer)ret).systematicRandomPreference(state);
				++state;
				break;
			case NO_RANDOM:
				ret = ((LinearSingleObjectivizer)ret).systematicRandomPreference(state);
			}
		} 
		final SingleObjectivizer fret = ret;
		return new IDeltaEstimator<Double, TransformationSolution>() {

			@Override 
			public int compare(TransformationSolution arg0, TransformationSolution arg1) {
				int ret = getValue(arg0).compareTo(getValue(arg1));
				if (ret == 0) {
					double[] v = arg0.getObjectives();
					double[] v2 = arg1.getObjectives();
					for (int i = 0; i < v.length; ++i) {
						if (v[i] < v2[i]) {
							return -1;
						} else if (v[i] > v2[i]) {
							return 1;
						}
					}
				}
				return ret;
			}

			@Override
			public Double getValue(TransformationSolution solution) {
				return fret.calculateSingleObjective(solution);
			}
			
			public String toString() {
				return "Comparing according to "+fret;
			}

			@Override
			public double getWorseAmount(TransformationSolution better, TransformationSolution worse) {
				return getValue(worse)-getValue(better);
			}
		};
	}
};