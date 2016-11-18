package at.ac.tuwien.big.momot.search.algorithm.init;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.WeakHashMap;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.solution.ParetoFront;
import at.ac.tuwien.big.moea.search.algorithm.ISolutionInitializer;
import at.ac.tuwien.big.moea.search.fitness.IFitnessFunction;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearObjectivizerProvider;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearSingleObjectivizer;
import at.ac.tuwien.big.moea.singleobjectivizer.ObjectiveAdder;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizer;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class DiscardingSolutionInitializer<S extends TransformationSolution> implements ISolutionInitializer<S>{
	
	public static final int COLLECTION_SIZE_DELTA = 10;
	
	private int generateSolutions;
	private int solutionConsiderSize;
	private int solutionUseSize;
	private int maxQueueSize;
	private int solutionsPerQueue;
	private PriorityQueue<S>[] queues;
	private LinearQualityComparator[] comparators;
	private int[] takenCount;
	
	private int evaluationCount;
	
	private NondominatedPopulation curFront = new NondominatedPopulation();
	
	private int curQueue = 0;
	
	public static class LinearQualityComparator implements Comparator<Solution> {
		
		private SingleObjectivizer singleObjective;
		
		public LinearQualityComparator(SingleObjectivizer singleObjective) {
			this.singleObjective = singleObjective;
		}
		
		//private WeakHashMap<Solution, Double> calcValues = new WeakHashMap<>();
		
		public Double getValue(Solution sol) {
			return singleObjective.calculateSingleObjective(sol);
		}

		@Override
		public int compare(Solution o1, Solution o2) {
			return getValue(o1).compareTo(getValue(o2));
		}
		
	}
	
	
	private SearchHelper helper;
	private int sortEveryX;
	private int numInitSolutions;
	private IFitnessFunction<S> fitnessFunction;
	private int maxEvaluations = Integer.MAX_VALUE;
	
	public void setMaxEvaluationCount(int maxEval) {
		this.maxEvaluations = maxEval;
	}
	
	public DiscardingSolutionInitializer(SearchHelper searchHelper, int generateSolutions, int solutionConsiderSize, int solutionUseSize,
			int solutionsPerQueue, int numQueues, int numInitSolutions, int sortEveryX, IFitnessFunction<S> fitnessFunction) {
		this.fitnessFunction = fitnessFunction;
		this.helper = searchHelper;
		this.sortEveryX = sortEveryX; 
			
		
		this.generateSolutions = generateSolutions;
		this.solutionConsiderSize = solutionConsiderSize;
		this.solutionUseSize = solutionUseSize;
		this.queues = new PriorityQueue[numQueues];
		this.comparators = new LinearQualityComparator[numQueues];
		this.takenCount  =new int[numQueues];
		this.numInitSolutions = numInitSolutions;
		this.solutionsPerQueue = solutionsPerQueue;
		
		
	}
	
	private boolean isInit = false;
	
	public void initWith(S baseSolution) {
		//First equally initialize them
		comparators[0] = new LinearQualityComparator(new ObjectiveAdder());
		//then use each objective				
		for (int i = 0; i < Math.min(queues.length-1, baseSolution.getNumberOfObjectives()) ; ++i) {
			double[] ar = new double[baseSolution.getNumberOfObjectives()];
			ar[i] = 1.0;
			comparators[i+1] = new LinearQualityComparator(new LinearSingleObjectivizer(ar));
		}
		//Then use random values
		for (int i = baseSolution.getNumberOfObjectives()+1; i < queues.length; ++i) {

			comparators[i] = new LinearQualityComparator(randomObjectivizer(baseSolution.getNumberOfObjectives()));
		}
		//Add the initial solution to all queues
		for (int i = 0; i < queues.length; ++i) {
			queues[i] = new PriorityQueue<S>(comparators[i]);
			queues[i].add(baseSolution);
		}
		curFront.add(baseSolution);
		this.maxQueueSize = Math.max(generateSolutions*2,solutionsPerQueue*10);
		generateSolutions(baseSolution,numInitSolutions*10);
		isInit = true;
	}
	
	public LinearSingleObjectivizer randomObjectivizer(int length) {
		double[] ar = new double[length];
		for (int j = 0; j < ar.length; ++j) {
			ar[j] = MathUtil.randomDouble();
		}
		return new LinearSingleObjectivizer(ar);
	}
	
	public void switchQueue() {
		++curQueue;
		if (curQueue >= queues.length) {
			curQueue = 0;
		}
	}
	
	private LinearObjectivizerProvider provider = new LinearObjectivizerProvider();
	
	public PriorityQueue<S> createQueue(S baseSolution) {
		List<Solution> curFrontL = new ArrayList<Solution>();
		for (Solution sol: curFront) {
			curFrontL.add(sol);
		}
		SingleObjectivizer objectivizer = provider.provide(curFrontL);
		if (objectivizer instanceof LinearSingleObjectivizer) {
			objectivizer = ((LinearSingleObjectivizer) objectivizer).randomPreference();
		} else {
			objectivizer = randomObjectivizer(baseSolution.getNumberOfObjectives());
		}
		PriorityQueue<S> ret = new PriorityQueue<S>();
		ret.add(baseSolution);
		return ret;
	}
	
	public void distributeSolutions(List<S> sol) {
		for (int i = 0; i < queues.length; ++i) {
			Collections.sort(sol, comparators[i]);
			for (int j = 0; j < Math.min(solutionUseSize, sol.size()); ++j) {
				queues[i].add(sol.get(j));
			}
			if (queues[i].size() > maxQueueSize) {
				PriorityQueue<S> newQueue = new PriorityQueue<S>(comparators[i]);
				for (int j = 0; j < generateSolutions; ++j) {
					newQueue.add(queues[i].poll());
				}
				queues[i] = newQueue;
			}
		}
	}
	
	private ParetoFront<S> allSolutions = new ParetoFront<S>();
	
	private List<S> returnSolutions = new ArrayList<S>();
	
	public double nondominatingValue(Solution dominating, Solution weak) {
		double ret = 0.0;
		for (int i = 0; i < dominating.getNumberOfObjectives(); ++i) {
			//Dominating hat lauter kleinere Werte
			double diff = dominating.getObjective(i)-weak.getObjective(i);
			//Wenn weak doch nicht so weak ist, hat es einen kleineren Wert --> Diff ist positiv!
			diff = Math.max(0.0, diff);
			if (diff > 0.0) {
				ret+= 1.0-1.0/(diff+1.0); //Squash
			}
		}
		return -ret;
	}
	Map<S,Double> nonDominating = new WeakHashMap<>();
	
	private int curAdd = 0;
	
	public void addSolution(S sol) {
		returnSolutions.add(sol);
		if (allSolutions.tryAdd(sol)) {
			nonDominating.clear();
			if (allSolutions.getParetoFront().size() < sol.getNumberOfObjectives()+1) {
				ObjectiveAdder adder = new ObjectiveAdder();
				returnSolutions.forEach((x)->nonDominating.put(x, adder.calculateSingleObjective(x)));
			} else {
				for (S curSol: returnSolutions) {
					double ret = 0.0;
					for (S pf: allSolutions.getParetoFront()) {
						ret+= nondominatingValue(pf, curSol);
					}
					nonDominating.put(curSol, ret);
				}
			}
		} else {
			if (allSolutions.getParetoFront().size() < sol.getNumberOfObjectives()+1) {
				ObjectiveAdder adder = new ObjectiveAdder();
				nonDominating.put(sol, adder.calculateSingleObjective(sol));
			} else {
				double ret = 0.0;
				for (S pf: allSolutions.getParetoFront()) {
					ret+= nondominatingValue(pf, sol);
				}
				nonDominating.put(sol, ret);
			}
		}
		if (++curAdd > sortEveryX) {
			Collections.sort(returnSolutions, new Comparator<S>() {

				@Override
				public int compare(S o1, S o2) {
					return Double.compare(nonDominating.get(o1), nonDominating.get(o2));
				}
			});
			while (returnSolutions.size() > generateSolutions) {
				returnSolutions.remove(returnSolutions.size()-1);
			}
		}
	}
	
	WeakHashMap<S, Double> calculatedFitness = new WeakHashMap<S, Double>();
		
	public void generateSolutions(S baseSolution, int solutionCount) {
		if (evaluationCount >= maxEvaluations) {
			return;
		}
		for (int i = 0; i < solutionCount; ++i) {
			PriorityQueue<S> curQueue = queues[this.curQueue];
			if (curQueue.isEmpty() || takenCount[this.curQueue] >= solutionsPerQueue) {
				curQueue = queues[this.curQueue] = createQueue(baseSolution);
				takenCount[this.curQueue] = 0;
			}
			++takenCount[this.curQueue];
			
			S curSolution = curQueue.poll();
			
			if (!calculatedFitness.containsKey(curSolution)) {
				double fitness = fitnessFunction.doEvaluate(curSolution);
				++evaluationCount;
				calculatedFitness.put(curSolution, fitness);
			}
			

			curSolution.setDirty();
			
			addSolution(curSolution);
			
			//Randomly change this solution
			List<S> newSol =  helper.changeRandomVariables(curSolution, solutionConsiderSize, 0.1, 0.3, true, Collections.emptyList(), 0.9);
			for (S sol: newSol) {
				if (!calculatedFitness.containsKey(sol)) {
					double fitness = fitnessFunction.doEvaluate(sol);
					++evaluationCount;
					calculatedFitness.put(sol, fitness);
					sol.setDirty();
				}
			}
			distributeSolutions(newSol);
			
			//Always switch current queue
			switchQueue();
			if (evaluationCount >= maxEvaluations) {
				return;
			}
		}
	}

	S last = null;

	@Override
	public S getSolution(S baseSolution) {
		if (!isInit) {
			initWith(baseSolution);
		}
		if (returnSolutions.size() < generateSolutions) {
			generateSolutions(baseSolution,generateSolutions-returnSolutions.size());
		}
		if (returnSolutions.isEmpty()) {
			return last;
		}
		return last = returnSolutions.remove(0);
	}

	public int getEvaluationCount() {
		return evaluationCount;
	}

	@Override
	public Iterable<? extends Solution> getParetoFront() {
		return curFront;
	}
}
