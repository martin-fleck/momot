package statistics;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AlgorithmSolutions {
	
	private Algorithm algorithm;
	private List<SingleSolution> solutions = new ArrayList<>();
	
	public AlgorithmSolutions(Algorithm alg) {
		this.algorithm = alg; 
	}
	
	
	
	public void addSolution(SingleSolution sol) {
		solutions.add(sol);
	}
	
	public List<SingleSolution> getSolutions() {
		return solutions;
	}
	
	public Collection<? extends SingleResult> getAllSolutions() {
		List<SingleResult> ret = new ArrayList<>();
		for (SingleSolution ss: solutions) {
			ret.addAll(ss.getSolutions());
		}
		return ret;
	}

	public Algorithm getAlgorithm() {
		return algorithm;
	}



	public void setAlgorithm(Algorithm algorithm2) {
		this.algorithm = algorithm2;
	}

}
