package at.ac.tuwien.big.moea.search.algorithm.iterating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.moeaframework.algorithm.AbstractAlgorithm;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.ISolutionInitializer;
import at.ac.tuwien.big.moea.search.algorithm.RestartableAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.LocalSearchAlgorithm;

public class IteratingAlgorithm<S extends Solution> extends AbstractAlgorithm {
	
	private int maxSubEvals;
	private static long maxMsPerEvaluation = 10;
	
	private NondominatedPopulation result = new NondominatedPopulation();
	
	private LocalSearchAlgorithm<S> defaultAlgorithm;
	private LocalSearchAlgorithm<S> subAlgorithm;	
	private ISolutionInitializer<S> solutionInitializer;
	private IFitnessComparatorGenerator<?, S> fitnessGenerator;

	public IteratingAlgorithm(ISearchProblem<S> problem, IFitnessComparatorGenerator<?, S> fitnessGenerator, 
			ISolutionInitializer<S> solutionInitializer, LocalSearchAlgorithm<S> subAlgorithm, int maxSubEvals) {
		this(problem,fitnessGenerator,solutionInitializer,subAlgorithm,maxSubEvals,1,1);
	}
	
	public IteratingAlgorithm(ISearchProblem<S> problem, IFitnessComparatorGenerator<?, S> fitnessGenerator, 
			ISolutionInitializer<S> solutionInitializer, LocalSearchAlgorithm<S> subAlgorithm, int maxSubEvals, int tournamentGrab, int tournamentRemain) {
		super(problem);
		this.fitnessGenerator = fitnessGenerator;
		this.maxSubEvals = maxSubEvals;
		this.defaultAlgorithm = subAlgorithm;
		this.solutionInitializer = solutionInitializer;
		this.tournamentGrab = tournamentGrab;
		this.tournamentRemain = tournamentRemain;
	}
	
	private int tournamentGrab;
	private int tournamentRemain;
	
	private List<Solution> lastSolutions = new ArrayList<>();
	
	public void mergeCurResult() {
		if (subAlgorithm == null) {
			return;
		}
		result.addAll(subAlgorithm.getResult());
	}

	@Override
	public NondominatedPopulation getResult() {
		mergeCurResult();
		NondominatedPopulation ret = new NondominatedPopulation();
		ret.addAll(result);
		return ret;
	}

	private int lastNumberOfEvaluations;
	
	private int lastSolCount = 0;
	
	
	private boolean hasEval(Solution sol) {
		boolean hasEval = false;
		double[] v = sol.getObjectives();
		for (int i = 0; i < v.length; ++i) {
			if (v[i] != 0.0) {
				hasEval = true;
				break;
			}
		}
		return hasEval;
	}
	
	@Override
	protected void iterate() {
		if (subAlgorithm == null || subAlgorithm.isTerminated()) {
			mergeCurResult();
			if (subAlgorithm != null && !subAlgorithm.isTerminated()) {
				subAlgorithm.terminate();
			}
			ISearchProblem<S> sp = (ISearchProblem<S>)getProblem();
			
			lastNumberOfEvaluations = numberOfEvaluations;
			int curSolCount = solutionInitializer.getEvaluationCount();
			solutionInitializer.setMaxEvaluationCount(1000+curSolCount);
			while (lastSolutions.size() < Math.max(Math.max(tournamentRemain,tournamentGrab),1)) {
				Solution sol = solutionInitializer.getSolution(result.isEmpty()?(S)sp.newSolution():(S)result.iterator().next());
				if (!hasEval(sol)) {
					evaluate(sol);
				}
				if (sol.getObjectives().length == 0) {
					System.err.println("Strange solution ...");
					sol =solutionInitializer.getSolution((S)sp.newSolution());
					System.err.println("Strange solution 2 ...");
				}
				lastSolutions.add(sol);
			}
			result.addAll(solutionInitializer.getParetoFront());
			long curTime = System.currentTimeMillis();
			S best = (S) lastSolutions.get(0);
			int bestIndex = 0;
			IFitnessComparator<?, S> comp = fitnessGenerator.generateComparator(getProblem(), best, result);
			if (tournamentRemain > 1) {
				for (int i = 1; i < lastSolutions.size(); ++i) {
					if (comp.compare((S)lastSolutions.get(i), best) < 0) {
						bestIndex = i;
						best = (S)lastSolutions.get(i);
					}
				}
			}
			lastSolutions.remove(bestIndex);
			int newSize = Math.max(0, tournamentRemain-tournamentGrab);
			if (lastSolutions.size() > newSize) {
				Collections.shuffle(lastSolutions);
				do {
					lastSolutions.remove(lastSolutions.size()-1);
				} while (lastSolutions.size() > newSize);				
			}
			
			subAlgorithm = defaultAlgorithm.prototypeForF(solutionInitializer.getSolution((S)best), comp);
			long thenTime = System.currentTimeMillis();
			
			curSolCount = solutionInitializer.getEvaluationCount();			
			int solCountDiff = curSolCount-lastSolCount;
			int otherDiff = (int)((thenTime-curTime)/maxMsPerEvaluation);
			solCountDiff = Math.max(otherDiff, solCountDiff);
			numberOfEvaluations+= solCountDiff;
			lastSolCount = curSolCount;
			lastNumberOfEvaluations = numberOfEvaluations;
		} else {
			subAlgorithm.step();
			numberOfEvaluations = lastNumberOfEvaluations+ subAlgorithm.getNumberOfEvaluations();
			if (subAlgorithm.getNumberOfEvaluations() > maxSubEvals) {
				subAlgorithm.terminate();
				subAlgorithm = null;
				lastNumberOfEvaluations = numberOfEvaluations;
			}
			mergeCurResult();
		}
	}
	
	public void terminate() {
		try {
			if (subAlgorithm != null && !subAlgorithm.isTerminated()) {
				subAlgorithm.terminate();
				subAlgorithm = null;
				solutionInitializer = null;
			}
			super.terminate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
