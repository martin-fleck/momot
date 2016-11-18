package at.ac.tuwien.big.moea.problem.solution;

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.core.Solution;

public class ParetoFront<S extends Solution>  {
	
	private List<S> solution = new ArrayList<S>();
	

	/**Calculates whether this solution dominates another solution and returns true if this solution truely dominates 
	 * the other solution, i.e. has at least one smaller  objective and otherwise objectives at least as small
	 * as for the other solution
	 */
	public static boolean dominates(Solution This, Solution other) {
		boolean haveSmaller = false;
		double[] myObjectives = This.getObjectives();
		double[] otherObjectives = other.getObjectives();
		int minLength = Math.min(myObjectives.length, otherObjectives.length);
		for (int i = 0; i <  minLength; ++i) {
			if (myObjectives[i] > otherObjectives[i]) {
				return false;
			} else if (myObjectives[i] < otherObjectives[i]) {
				haveSmaller = true;
			}
		}
		return haveSmaller;
	}
	
	public static boolean weakdominates(Solution This, Solution other) {
		double[] myObjectives = This.getObjectives();
		double[] otherObjectives = other.getObjectives();
		int minLength = Math.min(myObjectives.length, otherObjectives.length);
		for (int i = 0; i <  minLength; ++i) {
			if (myObjectives[i] > otherObjectives[i]) {
				return false;
			} 
		}
		return true;
	}
	
	public synchronized boolean tryAdd(S newSolution) {
		for (S sol: solution) {
			if (weakdominates(sol,newSolution)) {
				return false;
			}
		}
		solution.removeIf((x)->dominates(newSolution,x));
		solution.add(newSolution);
		return true;
	}
	 
	public List<S> getParetoFront() {
		return solution;
	}

}
