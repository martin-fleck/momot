package at.ac.tuwien.big.moea.search.algorithm.local;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.solution.ParetoFront;

public class SimulatedAnnealing<C extends Comparable<C> & Serializable, S extends Solution> extends AbstractLocalSearchAlgorithm<S> {

	private int noImprovement = 0;
	private int numSol;
	private int noImprovementBest = 0;
	private int totalSteps = 0;

	private int restartNoImprovment;
	private int restartNoImprovmentBest;
	private double tempFactor;
	private double startTemp;
	
	public static Random random = new Random();
	
	public double getTemperature() {
		return 1.0/(startTemp+numSol*tempFactor);
	}
	
	protected SimulatedAnnealing(Problem problem) {
		super(problem);
	}
	
	public SimulatedAnnealing(Problem problem, S initialSolution,
			INeighborhoodFunction<S> neighborhoodFunction,
			IDeltaEstimator<C, S> comparator, double tempFactor, double startTemp, int restartNoImprovement, int restartNoImprovementBest) {
		super(problem, initialSolution, neighborhoodFunction, comparator);		
		this.tempFactor = tempFactor;
		this.startTemp = startTemp;;
		this.restartNoImprovment = restartNoImprovement;
		this.restartNoImprovmentBest = restartNoImprovementBest;
	}
	
	public SimulatedAnnealing(Problem problem, S initialSolution,
			INeighborhoodFunction<S> neighborhoodFunction,
			IDeltaEstimator<C, S> comparator, double tempFactor, int numSolOffset, int restartNoImprovement, int restartNoImprovementBest) {
		super(problem, initialSolution, neighborhoodFunction, comparator);		
		this.tempFactor = tempFactor;
		this.startTemp = numSolOffset*tempFactor;
		this.restartNoImprovment = restartNoImprovement;
		this.restartNoImprovmentBest = restartNoImprovementBest;
	}
	
	public IDeltaEstimator<C, S> getFitnessComparator() {
		return (IDeltaEstimator<C, S>)super.getFitnessComparator();
	}

	private boolean isAcceptable(S next) {
		++noImprovement;
		double temperature = getTemperature();
		double worseAmount = getFitnessComparator().getWorseAmount(getCurrentSolution(), next);
		double border = Math.exp(-worseAmount/temperature);
		if (random.nextDouble() < border) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void iterate() {
		S next = null;
		
		for(S neighbor : generateCurrentNeighbors(1)) {
			next = neighbor;
		}
		
		if (next == null) {
			terminate();
			return;
		}
		
		evaluate(next);
		
		++numSol;
		++totalSteps;
		
		double worseAmount = 0.0;
		
		if ((isBetter(next, getCurrentSolution()) && (noImprovement = 0) == 0) || isAcceptable(next)) {
			if (isImprovementToBest(next)) {
				setBestSolution(next);
				//System.out.println("Simulated Annealing improved from "+getValue(getCurrentSolution())+" to "+getValue(getBestSolution())+"!");
				noImprovementBest = 0;
			} else {
				++noImprovementBest;
			}
			setCurrentSolution(next);
		}  else {
			++noImprovementBest;
		}
		
		if (noImprovementBest >= restartNoImprovmentBest || noImprovement > restartNoImprovment) {
			setCurrentSolution(getBestSolution());
			noImprovementBest = 0;
			noImprovement = 0;
			numSol = 0;
		}
		
		
		
//		else
//			System.err.println("improvmeent");
	}

	@Override
	public SimulatedAnnealing<C,S> newInstance(Problem problem) {
		return new SimulatedAnnealing<C,S>(problem);
	}
	
	@Override
	public void copyFor(AbstractLocalSearchAlgorithm<S> algorithm, S initialSolution) {
		super.copyFor(algorithm, initialSolution);
		this.tempFactor = ((SimulatedAnnealing)algorithm).tempFactor;
		this.startTemp = ((SimulatedAnnealing)algorithm).startTemp;
		this.restartNoImprovment = ((SimulatedAnnealing)algorithm).restartNoImprovment;
		this.restartNoImprovmentBest = ((SimulatedAnnealing)algorithm).restartNoImprovmentBest;
	}

	@Override
	public int getStepNum() {
		return totalSteps;
	}
}
