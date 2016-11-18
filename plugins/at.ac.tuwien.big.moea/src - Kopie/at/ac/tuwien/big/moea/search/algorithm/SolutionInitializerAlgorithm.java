package at.ac.tuwien.big.moea.search.algorithm;

import org.moeaframework.algorithm.AbstractAlgorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

public class SolutionInitializerAlgorithm<S extends Solution> extends AbstractAlgorithm {
	
	private final ISolutionInitializer<S> initializer;
	private final S baseSolution;
	
	public SolutionInitializerAlgorithm(Problem problem, ISolutionInitializer<S> initializer, S baseSolution) {
		super(problem);
		this.initializer = initializer;
		this.baseSolution = baseSolution;
	}

	private NondominatedPopulation nondominated = new NondominatedPopulation();
	
	private int lastNumberOfEvaluations = 0;

	@Override
	public NondominatedPopulation getResult() {
		NondominatedPopulation ret = new NondominatedPopulation();
		ret.addAll(nondominated);
		return ret;
	}

	@Override
	protected void iterate() {
		int curSubNumber = initializer.getEvaluationCount();
		int evaluationCountDiff = curSubNumber-lastNumberOfEvaluations;
		numberOfEvaluations+= evaluationCountDiff;
		lastNumberOfEvaluations = curSubNumber;
		nondominated.add(initializer.getSolution(baseSolution));
	}

}
