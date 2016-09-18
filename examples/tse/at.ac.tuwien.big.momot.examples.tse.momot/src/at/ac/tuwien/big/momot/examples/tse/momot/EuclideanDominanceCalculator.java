package at.ac.tuwien.big.momot.examples.tse.momot;

import java.util.Arrays;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.comparator.ParetoDominanceComparator;

import at.ac.tuwien.big.momot.examples.tse.metric.TransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.momot.util.ModularizationUtil;

public class EuclideanDominanceCalculator {
	
	private NondominatedPopulation firstPopulation;
	private NondominatedPopulation secondPopulation;
	private double[] firstBestPoint;
	private double[] secondBestPoint;
	private double[] idealPoint;
	private double firstBestDistance;
	private double secondBestDistance;

	public EuclideanDominanceCalculator(NondominatedPopulation firstPopulation, NondominatedPopulation secondPopulation) {
		this.firstPopulation = firstPopulation;
		this.secondPopulation = secondPopulation;
		calculate();
	}
	
	public NondominatedPopulation getFirstPopulation() {
		return firstPopulation;
	}
	
	public NondominatedPopulation getSecondPopulation() {
		return secondPopulation;
	}
	
	public double[] getFirstBestPoint() {
		return firstBestPoint;
	}
	
	public double[] getSecondBestPoint() {
		return secondBestPoint;
	}
	
	public double[] getIdealPoint() {
		return idealPoint;
	}
	
	public double getFirstBestDistance() {
		return firstBestDistance;
	}
	
	public double getSecondBestDistance() {
		return secondBestDistance;
	}
	
	public boolean firstDominatesSecond() {
		return firstBestDistance < secondBestDistance;
	}
	
	public boolean secondDominatesFirst() {
		return secondBestDistance < firstBestDistance;
	}
	
	public boolean isTie() {
		return firstBestDistance == secondBestDistance;
	}
	
	protected EuclideanDominanceCalculator calculate() {
		NondominatedPopulation allResults = new NondominatedPopulation(
				new ParetoDominanceComparator());
		allResults.addAll(getFirstPopulation());
		allResults.addAll(getSecondPopulation());
		
		this.idealPoint = getIdealPoint(allResults);
		this.firstBestPoint = getBestPoint(getFirstPopulation(), idealPoint);
		this.secondBestPoint = getBestPoint(getSecondPopulation(), idealPoint);
		
		this.firstBestDistance = ModularizationUtil.calculateEuclideanDistance(firstBestPoint, idealPoint);
		this.secondBestDistance = ModularizationUtil.calculateEuclideanDistance(secondBestPoint, idealPoint);
		
		return this;
	}
	
	protected double[] getIdealPoint(NondominatedPopulation population) {
		double maxCohesionRatio = 0.0;
		for(Solution solution : population) {
			TransformationMetrics metrics = ModularizationUtil.getMetrics(solution);
			if(metrics.getCohesionRatio() > maxCohesionRatio)
				maxCohesionRatio = metrics.getCohesionRatio();
		}
		return new double[] {
				1.0,
				0.0,
				maxCohesionRatio,
				0.0};
	}
	
	protected double[] getBestPoint(NondominatedPopulation results, double[] idealPoint) {
		double bestDistance = Double.MAX_VALUE;
		double[] bestPoint = null;
		for(Solution solution : results) {
			double[] solutionPoint = getSolutionPoint(solution);
			double distance = ModularizationUtil.calculateEuclideanDistance(solutionPoint, idealPoint);
			if(distance < bestDistance) {
				bestDistance = distance;
				bestPoint = solutionPoint;
			}
		}
		return bestPoint;
	}

	protected double[] getSolutionPoint(Solution solution) {
		TransformationMetrics metrics = ModularizationUtil.getMetrics(solution);
		return new double[] {
			metrics.getNrModules(),
			metrics.getMinMaxReponsibilityDifference(),
			metrics.getCohesionRatio(),
			metrics.getCouplingRatio()
		};
	}
	
	@Override
	public String toString() {
		return toString("FirstPopulation", "SecondPopulation");
	}
	
	public String toString(String firstName, String secondName) {
		StringBuilder sb = new StringBuilder();
		sb.append("Ideal Point: " + Arrays.toString(getIdealPoint()) + "\n");
		if(firstDominatesSecond())
			sb.append(firstName + " dominates " + secondName + ": (" + 
					Arrays.toString(firstBestPoint) + " = " + firstBestDistance + ") < (" + 
					Arrays.toString(secondBestPoint) + " = " + secondBestDistance + ")");
		else if(secondDominatesFirst())
			sb.append(secondName + " dominates " + firstName + ": (" + 
					Arrays.toString(secondBestPoint) + " = " + secondBestDistance + ") < (" + 
					Arrays.toString(firstBestPoint) + " = " + firstBestDistance + ")");
		else
			sb.append("Tie between " + firstName + " and " + secondName + ": (" + 
					Arrays.toString(firstBestPoint) + " = " + firstBestDistance + ") == (" + 
					Arrays.toString(secondBestPoint) + " = " + secondBestDistance + ")");
		return sb.toString();
	}
}
