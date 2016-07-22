package at.ac.tuwien.big.momot.examples.ecore.fitness.metric;

import java.io.Serializable;

public class Metrics implements Serializable {
   private static final long serialVersionUID = 6071273127373481780L;

   protected int nrEntities;
   protected double cohesion;
   protected double coupling;
   protected double vocabularyDistance;

   public void add(final Metrics metrics) {
      addNrEntities(metrics.getNrEntities());
      addCohesion(metrics.getCohesion());
      addCoupling(metrics.getCoupling());
      addVocabularyDistance(metrics.getVocabularyDistance());
   }

   public void addCohesion(final double cohesion) {
      this.cohesion += cohesion;
   }

   public void addCoupling(final double coupling) {
      this.coupling += coupling;
   }

   public void addNrEntities(final int nrEntities) {
      this.nrEntities += nrEntities;
   }

   public void addVocabularyDistance(final double vocabularyDistance) {
      this.vocabularyDistance += vocabularyDistance;
   }

   public double getCohesion() {
      return cohesion;
   }

   public double getCoupling() {
      return coupling;
   }

   public int getNrEntities() {
      return nrEntities;
   }

   public double getVocabularyDistance() {
      return vocabularyDistance;
   }

   public void setCohesion(final double cohesion) {
      this.cohesion = cohesion;
   }

   public void setCoupling(final double coupling) {
      this.coupling = coupling;
   }

   public void setNrEntities(final int nrEntities) {
      this.nrEntities = nrEntities;
   }

   public void setVocabularyDistance(final double vocabularyDistance) {
      this.vocabularyDistance = vocabularyDistance;
   }

   @Override
   public String toString() {
      return toString(0);
   }

   public String toString(final int indent) {
      final StringBuilder sb = new StringBuilder();
      for(int i = 0; i < indent; i++) {
         sb.append(" ");
      }
      return toString(sb.toString());
   }

   public String toString(final String indent) {
      final StringBuilder sb = new StringBuilder();
      sb.append(indent + "Entities:           " + getNrEntities() + "\n");
      sb.append(indent + "Coupling:           " + getCoupling() + "\n");
      sb.append(indent + "Cohesion:           " + getCohesion() + "\n");
      sb.append(indent + "VocabularyDistance: " + getVocabularyDistance() + "\n");
      return sb.toString();
   }
}
