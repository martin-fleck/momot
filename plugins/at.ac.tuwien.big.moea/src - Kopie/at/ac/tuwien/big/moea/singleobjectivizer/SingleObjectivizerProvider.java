package at.ac.tuwien.big.moea.singleobjectivizer;

import at.ac.tuwien.big.moea.problem.solution.ParetoFront;

public interface SingleObjectivizerProvider {
	
	public SingleObjectivizer provide(ParetoFront front);
	

}
