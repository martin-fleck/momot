package at.ac.tuwien.big.momot.examples.ecore.fitness.metric;

import java.io.Serializable;

public class Metrics implements Serializable {
	private static final long serialVersionUID = 6071273127373481780L;
	
	protected int nrEntities;
	protected double cohesion;
	protected double coupling;
	protected double vocabularyDistance;
	
	public void add(Metrics metrics) {
		addNrEntities(metrics.getNrEntities());
		addCohesion(metrics.getCohesion());
		addCoupling(metrics.getCoupling());
		addVocabularyDistance(metrics.getVocabularyDistance());
	}
	
	public int getNrEntities() {
		return nrEntities;
	}

	public void setNrEntities(int nrEntities) {
		this.nrEntities = nrEntities;
	}
	
	public void addNrEntities(int nrEntities) {
		this.nrEntities += nrEntities;
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

	public double getVocabularyDistance() {
		return vocabularyDistance;
	}
	
	public void setVocabularyDistance(double vocabularyDistance) {
		this.vocabularyDistance = vocabularyDistance;
	}
	
	public void addVocabularyDistance(double vocabularyDistance) {
		this.vocabularyDistance += vocabularyDistance;
	}
	
	@Override
	public String toString() {
		return toString(0);
	}
	
	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < indent; i++)
			sb.append(" ");
		return toString(sb.toString());
	}
	
	public String toString(String indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent + "Entities:           " + getNrEntities() + "\n");
		sb.append(indent + "Coupling:           " + getCoupling() + "\n");
		sb.append(indent + "Cohesion:           " + getCohesion() + "\n");
		sb.append(indent + "VocabularyDistance: " + getVocabularyDistance() + "\n");
		return sb.toString();
	}
}
