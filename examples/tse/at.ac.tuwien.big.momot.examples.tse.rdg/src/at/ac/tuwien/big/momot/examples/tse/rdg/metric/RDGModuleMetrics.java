package at.ac.tuwien.big.momot.examples.tse.rdg.metric;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.momot.examples.tse.metric.Metrics;


public class RDGModuleMetrics extends Metrics {
	
	private static final long serialVersionUID = -146236830090897951L;

	private List<String> rules = new ArrayList<>();
	private List<String> helpers = new ArrayList<>();

	public List<String> getRules() {
		return rules;
	}
	
	public void addRule(String rule) {
		this.rules.add(rule);
	}
	
	public List<String> getHelpers() {
		return helpers;
	}

	public void addHelper(String helper) {
		this.helpers.add(helper);
	}
	
	@Override
	public int getNrHelpers() {
		return helpers.size();
	}
	
	@Override
	public int getNrRules() {
		return rules.size();
	}
}
