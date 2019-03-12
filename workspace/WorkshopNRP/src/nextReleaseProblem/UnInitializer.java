package nextReleaseProblem;

import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class UnInitializer {
	static {
		SearchHelper.INITIALIZE_SOLUTIONS = false;
	}

}
