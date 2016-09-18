package at.ac.tuwien.big.momot.examples.tse.rdg;

import org.apache.commons.lang.time.StopWatch;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.algorithm.RandomSearch;
import org.moeaframework.algorithm.ReferencePointNondominatedSortingPopulation;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.NondominatedSortingPopulation;
import org.moeaframework.core.operator.CompoundVariation;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.search.algorithm.operator.mutation.RandomizableMutation;
import at.ac.tuwien.big.moea.search.solution.generator.ExtendedRandomInitialization;

public class RDGExperiment {
	private RDGSettings settings;
	private int nrIterations;
	private int populationSize;

	public RDGExperiment(RDGSettings settings, int populationSize, int nrIterations) {
		this.settings = settings;
		this.populationSize = populationSize;
		this.nrIterations = nrIterations;
	}
	
	public RDGSettings getSettings() {
		return settings;
	}
	
	public int getPopulationSize() {
		return populationSize;
	}
	
	public int getNrIterations() {
		return nrIterations;
	}
	
	public RDGProblem createProblem() {
		return new RDGProblem(settings.getRDG(), settings.getMaxModules());
	}
	
	public NondominatedPopulation runNSGAIII() {
		return runNSGAIII(5, 1);
	}
	
	public NondominatedPopulation runNSGAIII(int nrRuns) {
		return runNSGAIII(5, nrRuns);
	}
	
	public NondominatedPopulation runNSGAIII(int nrDivisions, int nrRuns) {
		System.out.println("Search[NSGA-III] modularizes " + getSettings().getTransformation().getName() + ".");
		System.out.println("Search[NSGA-III] uses " + getSettings().getSolutionLength() + " as solution length, i.e., number of applied rules per solution.");
		System.out.println("Search[NSGA-III] starts searching for 1 to " + getSettings().getMaxModules() + " modules.");
		System.out.println("Search settings: population size = " + getPopulationSize() + ", number of iterations = " + getNrIterations() + ", number of runs = " + nrRuns + ".");
		StopWatch watch = new StopWatch();
		watch.start();
		
		NondominatedPopulation result = new NondominatedPopulation();
		for(int i = 0; i < nrRuns; i++) {
			StopWatch runWatch = new StopWatch();
			runWatch.start();
			result.addAll(runNSGAIII(createProblem(), getPopulationSize(), getNrIterations(), nrDivisions));
			System.out.println("Run " + (i+1) + " of " + nrRuns + " terminated after " + runWatch + ".");
		}
		
		watch.stop();
		System.out.println("Search[NSGA-III] stopped after " + watch + " with " + result.size() + " solutions.");
		return result;
	}
	
	public NondominatedPopulation runRandom() {
		return runRandom(1);
	}
	
	public NondominatedPopulation runRandom(int nrRuns) {
		System.out.println("Search[RandomSearch] modularizes " + getSettings().getTransformation().getName() + ".");
		System.out.println("Search[RandomSearch] uses " + getSettings().getSolutionLength() + " as solution length, i.e., number of applied rules per solution.");
		System.out.println("Search[RandomSearch] starts searching for 1 to " + getSettings().getMaxModules() + " modules.");
		System.out.println("Search settings: population size = " + getPopulationSize() + ", number of iterations = " + getNrIterations() + ", number of runs = " + nrRuns + ".");
		StopWatch watch = new StopWatch();
		watch.start();
		
		NondominatedPopulation result = new NondominatedPopulation();
		for(int i = 0; i < nrRuns; i++) {
			StopWatch runWatch = new StopWatch();
			runWatch.start();
			result.addAll(runRandom(createProblem(), getPopulationSize(), getNrIterations()));
			System.out.println("Run " + (i+1) + " of " + nrRuns + " terminated after " + runWatch + ".");
		}
		
		watch.stop();
		System.out.println("Search[RandomSearch] stopped after " + watch + " with " + result.size() + " solutions.");
		return result;
	}
	
	public NondominatedPopulation runNSGAII() {
		return runNSGAII(1);
	}
	
	public NondominatedPopulation runNSGAII(int nrRuns) {
		System.out.println("Search[NSGA-II] modularizes " + getSettings().getTransformation().getName() + ".");
		System.out.println("Search[NSGA-II] uses " + getSettings().getSolutionLength() + " as solution length, i.e., number of applied rules per solution.");
		System.out.println("Search[NSGA-II] starts searching for 1 to " + getSettings().getMaxModules() + " modules.");
		System.out.println("Search settings: population size = " + getPopulationSize() + ", number of iterations = " + getNrIterations() + ", number of runs = " + nrRuns + ".");
		StopWatch watch = new StopWatch();
		watch.start();
		
		NondominatedPopulation result = new NondominatedPopulation();
		for(int i = 0; i < nrRuns; i++) {
			StopWatch runWatch = new StopWatch();
			runWatch.start();
			result.addAll(runNSGAII(createProblem(), getPopulationSize(), getNrIterations()));
			System.out.println("Run " + (i+1) + " of " + nrRuns + " terminated after " + runWatch + ".");
		}
		
		watch.stop();
		System.out.println("Search[NSGA-II] stopped after " + watch + " with " + result.size() + " solutions.");
		return result;
	}	
	
	public static NondominatedPopulation runAlgorithm(Algorithm algorithm, RDGProblem problem, int populationSize, int maxIterations) {
		int iterations = 0;
		NondominatedPopulation result = new NondominatedPopulation();
				
		while (!algorithm.isTerminated() && ++iterations <= maxIterations) 
			algorithm.step();		
		result.addAll(algorithm.getResult());
		if(!algorithm.isTerminated())
			algorithm.terminate();
		
		return result;
	}

	public static NondominatedPopulation runNSGAIII(RDGProblem problem, int populationSize, int maxIterations, int divisionsInner, int divisionsOuter) {
		return runAlgorithm(new NSGAII(
				problem, 
				new ReferencePointNondominatedSortingPopulation(problem.getNumberOfObjectives(), divisionsOuter, divisionsInner), 
				null,
				new TournamentSelection(2),	
				new CompoundVariation(new OnePointCrossover(1.0), new RandomizableMutation(0.2)), 
				new ExtendedRandomInitialization(problem, populationSize)), problem, populationSize, maxIterations);
	}
	
	public static NondominatedPopulation runNSGAIII(RDGProblem problem, int populationSize, int maxIterations, int nrDivisions) {
		return runNSGAIII(problem, populationSize, maxIterations, 0, nrDivisions);
	}
	
	public static NondominatedPopulation runRandom(RDGProblem problem, int populationSize, int maxIterations) {
		return runAlgorithm(new RandomSearch(
				problem, 
				new ExtendedRandomInitialization(problem, populationSize),
				new NondominatedPopulation()), 
				problem, populationSize, maxIterations);
	}
	
	public static NondominatedPopulation runNSGAII(RDGProblem problem, int populationSize, int maxIterations) {				
		return runAlgorithm(new NSGAII(
				problem, 
				new NondominatedSortingPopulation(), 
				null,
				new TournamentSelection(2),	
				new CompoundVariation(new OnePointCrossover(1.0), new RandomizableMutation(0.2)), 
				new ExtendedRandomInitialization(problem, populationSize)), problem, populationSize, maxIterations);
	}
}
