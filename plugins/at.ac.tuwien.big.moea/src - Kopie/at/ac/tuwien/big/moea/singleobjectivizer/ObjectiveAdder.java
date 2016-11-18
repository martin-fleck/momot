package at.ac.tuwien.big.moea.singleobjectivizer;

public class ObjectiveAdder implements SingleObjectivizer {

	@Override
	public double calculateSingleObjective(double[] vals) {
		double ret = 0.0;
		for (double v: vals) {
			ret+= v;
		}
		return ret;
	}

}
