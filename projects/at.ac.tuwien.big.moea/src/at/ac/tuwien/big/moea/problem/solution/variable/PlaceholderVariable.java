package at.ac.tuwien.big.moea.problem.solution.variable;

import org.moeaframework.core.Variable;

public class PlaceholderVariable implements IPlaceholderVariable {
	private static final long serialVersionUID = -3707613316442716902L;

	@Override
	public Variable copy() {
		return new PlaceholderVariable();
	}
	
	@Override
	public String toString() {
		return "-Placeholder-\n";
	}

	@Override
	public void randomize() {
		; // do nothing
	}

}
