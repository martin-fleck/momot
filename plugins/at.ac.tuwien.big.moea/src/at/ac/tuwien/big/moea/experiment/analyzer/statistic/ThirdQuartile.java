package at.ac.tuwien.big.moea.experiment.analyzer.statistic;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public class ThirdQuartile extends Percentile {
	private static final long serialVersionUID = -2233937392471220972L;
	
	public ThirdQuartile() {
		super(75);
	}
}
