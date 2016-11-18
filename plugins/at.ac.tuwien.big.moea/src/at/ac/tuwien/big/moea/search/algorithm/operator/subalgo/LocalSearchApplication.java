package at.ac.tuwien.big.moea.search.algorithm.operator.subalgo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.util.MathUtils;
import org.moeaframework.algorithm.AbstractAlgorithm;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.search.algorithm.local.AbstractLocalSearchAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.operator.AbstractProbabilityVariation;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;

public class LocalSearchApplication<S extends Solution> extends AbstractProbabilityVariation implements ILocalSearchApplication {
	
	private AbstractLocalSearchAlgorithm<S> algorithm;
	private int maxEval = 100;
	private USE_SOLUTION_TYPE solutionType;
	private IFitnessComparatorGenerator<?, S> fitnessGenerator;
	private int tournamentSize = 1;
	private double probability;
	private int minStep;
	
	public enum USE_SOLUTION_TYPE {
		LAST, BEST;
	}
	
	public LocalSearchApplication(AbstractLocalSearchAlgorithm<S> baseAlgorithm, double probability, int maxEval, USE_SOLUTION_TYPE solutionType,
			IFitnessComparatorGenerator<?, S> generator, int tournamentSize, int minStep) {
		this.algorithm = baseAlgorithm;
		this.probability = probability;
		this.maxEval = maxEval;
		this.solutionType = solutionType;
		this.fitnessGenerator = generator;
		this.tournamentSize = tournamentSize;
		this.minStep = minStep;
	}
	
	
	public boolean continueSearch(AbstractLocalSearchAlgorithm<S> algorithmState, Solution curSolution, int curStep) {
		return curStep < maxEval && !algorithmState.isTerminated();
	}

	@Override
	public int getArity() {
		return 1;
	}
	
	private int numberOfEvaluations = 0;
	
	private int stepCount = 0;
	
	private List<Solution> recordedSolutions = new ArrayList<>();
	NondominatedPopulation paretoFront = new NondominatedPopulation();
	private double curProbability;
	private Set<Solution> evaluated = new HashSet<>();
	
	public void init() {
		numberOfEvaluations = 0;
		stepCount = 0;
		recordedSolutions.clear();
		paretoFront = new NondominatedPopulation();
		evaluated.clear();
		algorithm.reset();
		curProbability = 0.0;
	}
	
	public int pollNumberOfEvaluations() {
		int ret = numberOfEvaluations;
		numberOfEvaluations = 0;
		++stepCount;
		recordedSolutions.clear();
		evaluated.clear();
		curProbability = 0.0;
		return ret;
	}
	
	public List<Solution> selectRandomN(List<Solution> from, int n) {
		Collections.shuffle(from);
		List<Solution> ret = new ArrayList<Solution>();
		for (int i = 0; i < n; ++i) {
			ret.add(from.get(i));
		}
		return ret;
	}

	
	public void mergeInto(Solution into, Solution from) {
		into.setConstraints(from.getConstraints());
		for (int i = 0; i < Math.min(into.getNumberOfVariables(), from.getNumberOfVariables()); ++i) {			
			into.setVariable(i, from.getVariable(i));
		}
	}
	
	@Override
	protected Solution[] doEvolve(Solution[] parents) {
		if (stepCount < minStep) {
			return parents;
		}
		if (tournamentSize != 1) {
			recordedSolutions.add(parents[0]);
		}
		paretoFront.add(parents[0]);
		curProbability+= probability;
		
		if (recordedSolutions.size() >= tournamentSize && MathUtil.randomDouble() < curProbability) {
			curProbability-= 1.0;
		} else {
			return parents;
		}
		
		List<Solution> sol = selectRandomN(recordedSolutions, tournamentSize);
		
		Solution take;
		if (tournamentSize == 1) {
			take = parents[0];
		} else {
			take = sol.get(0);
		}
		int takeIndex = 0;
		IFitnessComparator<?, S> comparator = fitnessGenerator.generateComparator(algorithm.getProblem(), (S)parents[0], paretoFront);
		if (tournamentSize > 1) {
			
			if (evaluated.add(take)) {
				algorithm.evaluate(take);
				++numberOfEvaluations;
			}
			
			for (int i = 0; i < sol.size(); ++i) {
				if (evaluated.add(sol.get(i))) {
					algorithm.evaluate(sol.get(i));
					++numberOfEvaluations;
				}
				if (comparator.compare((S)sol.get(i), (S)take) < 0) {
					take = sol.get(i);
					takeIndex = i;
				}
			}
		}
		
		
		
		AbstractLocalSearchAlgorithm<S> curAlgorithm = algorithm.prototypeForF((S)take,comparator);
		
		
		while (continueSearch(curAlgorithm, parents[0], curAlgorithm.getNumberOfEvaluations())) {
			curAlgorithm.step();
		}
		if (!curAlgorithm.isTerminated()) {
			curAlgorithm.terminate();
		}
		
		numberOfEvaluations += curAlgorithm.getNumberOfEvaluations();
		if (tournamentSize == 1) {
			switch(solutionType) {
			case LAST:
				parents[takeIndex] = curAlgorithm.getCurrentSolution();
			case BEST:
				parents[takeIndex] = curAlgorithm.getBestSolution();
			}		
		} else {
			evaluated.remove(take);
			
			switch(solutionType) {
			case LAST:
				mergeInto(take, curAlgorithm.getCurrentSolution());
			case BEST:
				mergeInto(take, curAlgorithm.getBestSolution());
			}
			//Don't count since it is not a "real" evaluation, just an artificial one
			algorithm.evaluate(take);
		}
		return parents;
	}

}
