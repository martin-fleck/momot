package at.ac.tuwien.big.momot.examples.ecore.fitness.metric;

import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.vocabulary.IDistanceCache;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.vocabulary.LCSDistanceCache;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Entity;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Relationship;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

public class MetricsCalculator {
   protected static final double FACTOR_ASSOCIATION = 1.0;
   protected static final double FACTOR_INHERTIANCE = 1.0;
   protected static final double FACTOR_CONTAINMENT = 1.0;

   protected static IDistanceCache vocabularyCache = new LCSDistanceCache();
   protected static Map<Entity, Map<Entity, Double>> relationshipValueCache = new HashMap<>();

   public static LanguageMetrics calculate(final Language language) {
      final LanguageMetrics metrics = new LanguageMetrics(language);

      for(final Module module : language.getModules()) {
         if(!module.getEntities().isEmpty()) {
            metrics.considerModule(module);
            final Metrics metric = calculate(module);
            metrics.add(metric);
         }
      }
      return metrics;
   }

   public static Metrics calculate(final Module module) {
      final ModuleMetrics metrics = new ModuleMetrics(module);
      metrics.setNrEntities(module.getEntities().size());
      metrics.setVocabularyDistance(calculateVocabularyDistance(module));
      calculateCouplingCohesion(metrics, module);
      return metrics;
   }

   protected static void calculateCouplingCohesion(final ModuleMetrics metrics, final Module module) {
      final Language language = (Language) module.eContainer();
      for(final Module target : language.getModules()) {
         final Double relationshipValue = calculateRelationshipValues(module, target);
         if(module == target) {
            metrics.addCohesion(relationshipValue);
         } else {
            metrics.addCoupling(relationshipValue);
         }
      }
   }

   public static double calculateRelationshipValue(final Entity source, final Entity target) {
      // an entity might have more than one relationship with another entity, e.g., inheritance and containment in the
      // composite pattern
      double relationshipValue = 0.0;
      for(final Relationship relationship : source.getRelationships()) {
         if(relationship.getRelationshipEnd().equals(target)) {
            relationshipValue += relationship.getWeight() * getRelationshipFactor(relationship);
         }
      }
      return relationshipValue;
   }

   public static Double calculateRelationshipValues(final Module source, final Module target) {
      Double sumRelationshipValues = 0.0;

      for(final Entity sourceEntity : source.getEntities()) {
         for(final Entity targetEntity : target.getEntities()) {
            Map<Entity, Double> cachedRelationshipValues = relationshipValueCache.get(sourceEntity);
            Double relationshipValue = null;
            Double cachedRelationshipValue = null;

            if(cachedRelationshipValues == null) {
               cachedRelationshipValues = new HashMap<>();
            } else {
               cachedRelationshipValue = cachedRelationshipValues.get(targetEntity);
            }

            if(cachedRelationshipValue == null) {
               relationshipValue = calculateRelationshipValue(sourceEntity, targetEntity);
               cachedRelationshipValues.put(targetEntity, relationshipValue);
               relationshipValueCache.put(sourceEntity, cachedRelationshipValues);
            } else {
               relationshipValue = cachedRelationshipValue;
            }
            sumRelationshipValues += relationshipValue;
         }
      }

      return sumRelationshipValues;
   }

   public static double calculateVocabularyDistance(final Module module) {
      final EList<Entity> entities = module.getEntities();

      Double sumModuleDistances = 0.0;
      Integer countModuleDistances = 0;
      for(int i = 0; i < entities.size(); i++) {
         for(int j = 0; j < i; j++) {
            final String leftName = entities.get(i).getName();
            final String rightName = entities.get(j).getName();
            final Double nameDistance = vocabularyCache.getDistance(leftName, rightName);
            if(nameDistance.isNaN()) {
               System.err.println("WHAAT!?");
            }
            sumModuleDistances += nameDistance;
            countModuleDistances++;
         }
      }
      return new BigDecimal(sumModuleDistances).setScale(3, RoundingMode.HALF_UP).doubleValue();
   }

   protected static double getRelationshipFactor(final Relationship relationship) {
      if(isAssociation(relationship)) {
         return FACTOR_ASSOCIATION;
      }
      if(isInheritance(relationship)) {
         return FACTOR_INHERTIANCE;
      }
      if(isContainment(relationship)) {
         return FACTOR_CONTAINMENT;
      }
      return 1.0;
   }

   protected static boolean isAssociation(final Relationship relationship) {
      return relationship.getWeight() == 1;
   }

   protected static boolean isContainment(final Relationship relationship) {
      return relationship.getWeight() == 3;
   }

   protected static boolean isInheritance(final Relationship relationship) {
      return relationship.getWeight() == 2;
   }
}
