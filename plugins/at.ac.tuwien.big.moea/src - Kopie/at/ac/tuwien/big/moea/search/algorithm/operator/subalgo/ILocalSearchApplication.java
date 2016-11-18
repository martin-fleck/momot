package at.ac.tuwien.big.moea.search.algorithm.operator.subalgo;

import at.ac.tuwien.big.moea.search.algorithm.operator.IProbabilityVariation;

public interface ILocalSearchApplication extends IProbabilityVariation {

	public void init();
	
	public int pollNumberOfEvaluations();
	
}
