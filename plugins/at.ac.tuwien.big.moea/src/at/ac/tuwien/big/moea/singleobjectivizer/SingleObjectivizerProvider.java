package at.ac.tuwien.big.moea.singleobjectivizer;

import java.util.Collection;
import java.util.List;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.problem.solution.ParetoFront;

public interface SingleObjectivizerProvider {
	
	public SingleObjectivizer provide(Collection<Solution> front);
	

}
