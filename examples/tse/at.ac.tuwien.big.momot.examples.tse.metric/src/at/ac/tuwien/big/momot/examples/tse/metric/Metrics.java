package at.ac.tuwien.big.momot.examples.tse.metric;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class Metrics implements Serializable {
	private static final long serialVersionUID = 5269574577539403748L;

	private int nrRules;
	private int nrHelpers;
	
	private int nrRule2RuleDependencies;
	private int nrMaxRule2RuleDependencies;
	
	private int nrRule2HelperDependencies;
	private int nrMaxRule2HelperDependencies;
	
	private int nrHelper2HelperDependencies;
	private int nrMaxHelper2HelperDependencies;
	
	private double cohesion;
	private double coupling;
	
	private double cohesionRatio;
	private double couplingRatio;
	
	public Metrics() { }
	
	public Metrics(Metrics metrics) {
		setNrRules(metrics.getNrRules());
		setNrHelpers(metrics.getNrHelpers());
		
		setNrRule2RuleDependencies(metrics.getNrRule2RuleDependencies());
		setNrMaxRule2RuleDependencies(metrics.getNrMaxRule2RuleDependencies());
				
		setNrRule2HelperDependencies(metrics.getNrRule2HelperDependencies());
		setNrMaxRule2HelperDependencies(metrics.getNrMaxRule2HelperDependencies());
		
		setNrHelper2HelperDependencies(metrics.getNrHelper2HelperDependencies());
		setNrMaxHelper2HelperDependencies(metrics.getNrMaxHelper2HelperDependencies());	
		
		setCohesion(metrics.getCohesion());
		setCoupling(metrics.getCoupling());

		setCohesionRatio(metrics.getCohesionRatio());
		setCouplingRatio(metrics.getCouplingRatio());
	}
	
	public void addAll(Metrics metrics) {
		addRules(metrics.getNrRules());
		addHelpers(metrics.getNrHelpers());
		
		addRule2RuleDependencies(metrics.getNrRule2RuleDependencies());
		addMaxRule2RuleDependencies(metrics.getNrMaxRule2RuleDependencies());
		
		addRule2HelperDependencies(metrics.getNrRule2HelperDependencies());
		addMaxRule2HelperDependencies(metrics.getNrMaxRule2HelperDependencies());	
		
		addHelper2HelperDependencies(metrics.getNrHelper2HelperDependencies());
		addMaxHelper2HelperDependencies(metrics.getNrMaxHelper2HelperDependencies());	
		
		addCohesion(metrics.getCohesion());
		addCoupling(metrics.getCoupling());

		addCohesionRatio(metrics.getCohesionRatio());
		addCouplingRatio(metrics.getCouplingRatio());
	}
	
	public int getNrRules() {
		return nrRules;
	}
	
	public void setNrRules(int nrRules) {
		this.nrRules = nrRules;
	}
	
	public void addRules(int nrRules) {
		this.nrRules += nrRules;
	}
	
	public int getNrHelpers() {
		return nrHelpers;
	}
	
	public void setNrHelpers(int nrHelpers) {
		this.nrHelpers = nrHelpers;
	}
	
	public void addHelpers(int nrHelpers) {
		this.nrHelpers += nrHelpers;
	}
	
	public int getNrResponsibilities() {
		return getNrHelpers() + getNrRules();
	}
	
	public int getNrRule2RuleDependencies() {
		return nrRule2RuleDependencies;
	}
	
	public void setNrRule2RuleDependencies(int nrRule2RuleDependencies) {
		this.nrRule2RuleDependencies = nrRule2RuleDependencies;
	}
	
	public void addRule2RuleDependencies(int nrRuleDependencies) {
		this.nrRule2RuleDependencies += nrRuleDependencies;
	}
	
	public int getNrMaxRule2RuleDependencies() {
		return nrMaxRule2RuleDependencies;
	}
	
	public void setNrMaxRule2RuleDependencies(int nrMaxRuleDependencies) {
		this.nrMaxRule2RuleDependencies = nrMaxRuleDependencies;
	}
	
	public void addMaxRule2RuleDependencies(int nrMaxRuleDependencies) {
		this.nrMaxRule2RuleDependencies += nrMaxRuleDependencies;
	}	
		
	public int getNrRule2HelperDependencies() {
		return nrRule2HelperDependencies;
	}
	
	public void setNrRule2HelperDependencies(int nrHelperDependencies) {
		this.nrRule2HelperDependencies = nrHelperDependencies;
	}
	
	public void addRule2HelperDependencies(int nrHelperDependencies) {
		this.nrRule2HelperDependencies += nrHelperDependencies;
	}
	
	public int getNrMaxRule2HelperDependencies() {
		return nrMaxRule2HelperDependencies;
	}
	
	public void setNrMaxRule2HelperDependencies(int nrMaxHelperDependencies) {
		this.nrMaxRule2HelperDependencies = nrMaxHelperDependencies;
	}
	
	public void addMaxRule2HelperDependencies(int nrMaxHelperDependencies) {
		this.nrMaxRule2HelperDependencies += nrMaxHelperDependencies;
	}
	
	public int getNrHelper2HelperDependencies() {
		return nrHelper2HelperDependencies;
	}
	
	public void setNrHelper2HelperDependencies(int nrHelperDependencies) {
		this.nrHelper2HelperDependencies = nrHelperDependencies;
	}
	
	public void addHelper2HelperDependencies(int nrHelperDependencies) {
		this.nrHelper2HelperDependencies += nrHelperDependencies;
	}
	
	public int getNrMaxHelper2HelperDependencies() {
		return nrMaxHelper2HelperDependencies;
	}
	
	public void setNrMaxHelper2HelperDependencies(int nrMaxHelperDependencies) {
		this.nrMaxHelper2HelperDependencies = nrMaxHelperDependencies;
	}
	
	public void addMaxHelper2HelperDependencies(int nrMaxHelperDependencies) {
		this.nrMaxHelper2HelperDependencies += nrMaxHelperDependencies;
	}
	
	public double getCohesion() {
		return cohesion;
	}
	
	public void setCohesion(double cohesion) {
		this.cohesion = cohesion;
	}
	
	public void addCohesion(double cohesion) {
		this.cohesion += cohesion;
	}
	
	public double getCoupling() {
		return coupling;
	}
	
	public void setCoupling(double coupling) {
		this.coupling = coupling;
	}
	
	public void addCoupling(double coupling) {
		this.coupling += coupling;
	}
	
	public double getCohesionRatio() {
		return cohesionRatio;
	}
	
	public void setCohesionRatio(double cohesionRatio) {
		this.cohesionRatio = cohesionRatio;
	}
	
	public void addCohesionRatio(double cohesionRatio) {
		this.cohesionRatio += cohesionRatio;
	}
	
	public double getCouplingRatio() {
		return couplingRatio;
	}
	
	public void setCouplingRatio(double couplingRatio) {
		this.couplingRatio = couplingRatio;
	}
	
	public void addCouplingRatio(double couplingRatio) {
		this.couplingRatio += couplingRatio;
	}
	
	public double getCRAIndex() {
		return getCohesionRatio() - getCouplingRatio();
	}
	
	@Override
	public String toString() {
		return toString("");
	}
	
	public String toString(int indent) {
		return toString(StringUtils.repeat(" ", indent));
	}
	
	public String toString(String indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent + "Rules:                         " + getNrRules() + "\n");
		sb.append(indent + "Helpers:                       " + getNrHelpers() + "\n");
		sb.append(indent + "Responsibilities:              " + getNrResponsibilities() + "\n");
		sb.append(indent + "Rule2Rule-Dependencies:        " + getNrRule2RuleDependencies() + "\n");
		sb.append(indent + "MaxRule2Rule-Dependencies:     " + getNrMaxRule2RuleDependencies() + "\n");
		sb.append(indent + "Rule2Helper-Dependencies:      " + getNrRule2HelperDependencies() + "\n");
		sb.append(indent + "MaxRule2Helper-Dependencies:   " + getNrMaxRule2HelperDependencies() + "\n");
		sb.append(indent + "Helper2Helper-Dependencies:    " + getNrHelper2HelperDependencies() + "\n");
		sb.append(indent + "MaxHelper2Helper-Dependencies: " + getNrMaxHelper2HelperDependencies() + "\n");
		sb.append(indent + "Coupling:                      " + getCoupling() + "\n");
		sb.append(indent + "Cohesion:                      " + getCohesion() + "\n");
		sb.append(indent + "Coupling-Ratio:                " + getCouplingRatio() + "\n");
		sb.append(indent + "Cohesion-Ratio:                " + getCohesionRatio() + "\n");
		sb.append(indent + "CRA-Index:                     " + getCRAIndex() + "\n");
		return sb.toString();
	}
}