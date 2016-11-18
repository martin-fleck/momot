package at.ac.tuwien.big.moea;

public class IndicatorConfiguration {
	protected boolean additiveEpsilonIndicator;
	protected boolean contribution;
	protected boolean generationalDistance;
	protected boolean hypervolume;
	protected boolean invertedGenerationalDistance;
	protected boolean R1;
	protected boolean R2;
	protected boolean R3;
	protected boolean spacing;
	
	public IndicatorConfiguration() { }
	
	public IndicatorConfiguration(IndicatorConfiguration configuration) {
		setAdditiveEpsilonIndicator(configuration.isAdditiveEpsilonIndicator());
		setContribution(configuration.isContribution());
		setGenerationalDistance(configuration.isGenerationalDistance());
		setHypervolume(configuration.isHypervolume());
		setInvertedGenerationalDistance(configuration.isInvertedGenerationalDistance());
		setR1(configuration.isR1());
		setR2(configuration.isR2());
		setR3(configuration.isR3());
		setSpacing(configuration.isSpacing());
	}
	
	public void setAdditiveEpsilonIndicator(boolean additiveEpsilonIndicator) {
		this.additiveEpsilonIndicator = additiveEpsilonIndicator;
	}
	
	public boolean isAdditiveEpsilonIndicator() {
		return additiveEpsilonIndicator;
	}

	public void setContribution(boolean contribution) {
		this.contribution = contribution;
	}
	
	public boolean isContribution() {
		return contribution;
	}
	
	public void setGenerationalDistance(boolean generationalDistance) {
		this.generationalDistance = generationalDistance;
	}
	
	public boolean isGenerationalDistance() {
		return generationalDistance;
	}
	
	public void setHypervolume(boolean hypervolume) {
		this.hypervolume = hypervolume;
	}
	
	public boolean isHypervolume() {
		return hypervolume;
	}
	
	public void setInvertedGenerationalDistance(
			boolean invertedGenerationalDistance) {
		this.invertedGenerationalDistance = invertedGenerationalDistance;
	}
	
	public boolean isInvertedGenerationalDistance() {
		return invertedGenerationalDistance;
	}
	
	public void setR1(boolean r1) {
		R1 = r1;
	}
	
	public boolean isR1() {
		return R1;
	}
	
	public void setR2(boolean r2) {
		R2 = r2;
	}
	
	public boolean isR2() {
		return R2;
	}
	
	public void setR3(boolean r3) {
		R3 = r3;
	}
	
	public boolean isR3() {
		return R3;
	}
	
	public void setSpacing(boolean spacing) {
		this.spacing = spacing;
	}
	
	public boolean isSpacing() {
		return spacing;
	}
	
	public void setAllIndicators(boolean allIndicators) {
		setHypervolume(allIndicators);
		setGenerationalDistance(allIndicators);
		setInvertedGenerationalDistance(allIndicators);
		setSpacing(allIndicators);
		setAdditiveEpsilonIndicator(allIndicators);
		setContribution(allIndicators);
		setR1(allIndicators);
		setR2(allIndicators);
		setR3(allIndicators);
	}
}
