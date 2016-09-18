package at.ac.tuwien.big.momot.examples.tse.rdg;

import org.moeaframework.core.Solution;
import org.moeaframework.problem.AbstractProblem;

import at.ac.tuwien.big.moea.problem.solution.variable.RandomIntegerVariable;
import at.ac.tuwien.big.momot.examples.tse.rdg.metric.RDGTransformationMetrics;

public class RDGProblem extends AbstractProblem {
	
	public static final int OBJECTIVE_MIN_MAX_RESP_DIFF = 3;
	public static final int OBJECTIVE_NR_MODULES = 0;
	public static final int OBJECTIVE_COHESION = 2;
	public static final int OBJECTIVE_COUPLING = 1;
	
	public static final String ATTRIBUTE_RDG = "RDG";
	public static final String ATTRIBUTE_RDG_METRICS = "RDGMetrics";
	
	private int maxModules;
	private RDG rdg;

	public RDGProblem(RDG rdg, int maxModules) {
		super(rdg.getNrResponsibilities(), 4);
		this.rdg = rdg;
		this.maxModules = Math.min(maxModules, rdg.getNrResponsibilities());
	}
	
	public RDG getRDG() {
		return rdg;
	}
	
	public int getMaxModules() {
		return maxModules;
	}
	
	@Override
	public void evaluate(Solution solution) {
		RDG solutionRDG = new RDG(getRDG());
		solutionRDG.clearModules();
		for(int i = 0; i < getNumberOfVariables(); i++) {
			RandomIntegerVariable var = (RandomIntegerVariable) solution.getVariable(i);
			solutionRDG.setModule(i, var.getValue());
		}

		RDGTransformationMetrics metrics = solutionRDG.calculateMetrics();
		solution.setObjective(OBJECTIVE_MIN_MAX_RESP_DIFF, metrics.getMinMaxReponsibilityDifference());
		solution.setObjective(OBJECTIVE_NR_MODULES, solutionRDG.getNrModules());
		solution.setObjective(OBJECTIVE_COHESION, -metrics.getCohesionRatio()); // - because maximize
		solution.setObjective(OBJECTIVE_COUPLING, metrics.getCouplingRatio());
		solution.setAttribute(ATTRIBUTE_RDG, solutionRDG);
		solution.setAttribute(ATTRIBUTE_RDG_METRICS, metrics);
	}

	@Override
	public Solution newSolution() {
		Solution solution = new Solution(getNumberOfVariables(), getNumberOfObjectives(), getNumberOfConstraints());
		for(int i = 0; i < getNumberOfVariables(); i++)
			solution.setVariable(i, new RandomIntegerVariable(0, getMaxModules() - 1));
		return solution;
	}

}
