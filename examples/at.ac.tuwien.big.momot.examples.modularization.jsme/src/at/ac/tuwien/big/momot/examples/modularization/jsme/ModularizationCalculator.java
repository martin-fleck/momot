package at.ac.tuwien.big.momot.examples.modularization.jsme;

import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;
import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModuleMetrics;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Module;

import java.io.Serializable;

public class ModularizationCalculator implements Serializable {

   private static final long serialVersionUID = 6093448208856307554L;

   private ModularizationModel model;
   private ModelMetrics modelMetrics;

   public ModularizationCalculator(final ModularizationModel model) {
      this.model = model;
      calculate();
   }

   protected void calculate() {
      modelMetrics = new ModelMetrics();
      modelMetrics.nrModules = model.getModules().size();

      int min = model.getModules().size();
      int max = 0;
      for(final Module module : model.getModules()) {
         if(module.getClasses().isEmpty()) {
            modelMetrics.nrEmptyModules += 1;
         } else {
            final ModuleMetrics metric = calculate(module);
            if(metric.nrClasses < min) {
               min = metric.nrClasses;
            }
            if(metric.nrClasses > max) {
               max = metric.nrClasses;
            }
            modelMetrics.add(metric);
         }
      }
      modelMetrics.minMaxDiff = max - min;

      for(final at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class clazz : model.getClasses()) {
         if(clazz.getModule() == null) {
            modelMetrics.nrUnassignedClasses += 1;
         }
      }
   }

   protected ModuleMetrics calculate(final Module source) {
      final ModuleMetrics metrics = new ModuleMetrics();
      metrics.nrClasses = source.getClasses().size();

      for(final Module target : model.getModules()) {
         int outgoingDependencies = 0;
         int incomingDependencies = 0;

         for(final at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class sourceClazz : source
               .getClasses()) {
            for(final at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.Class targetClazz : target
                  .getClasses()) {
               if(sourceClazz.getDependsOn().contains(targetClazz)) {
                  outgoingDependencies++;
               }
               if(sourceClazz.getDependedOnBy().contains(targetClazz)) {
                  incomingDependencies++;
               }
            }
         }

         if(source.equals(target)) {
            metrics.cohesion += outgoingDependencies;
         } else {
            metrics.coupling += outgoingDependencies;
            metrics.nrIncomingDependencies += incomingDependencies;
            metrics.nrOutgoingDependencies += outgoingDependencies;
         }
      }
      metrics.coupling = metrics.coupling * 2; // count each edge twice
      if(metrics.cohesion == 0) {
         metrics.modularizationQuality = 0.0;
      } else {
         metrics.modularizationQuality = metrics.cohesion
               / (metrics.cohesion + 0.5 * (metrics.nrIncomingDependencies + metrics.nrOutgoingDependencies));
      }
      if(Double.isNaN(metrics.modularizationQuality)) {
         System.err.println("Why :(");
      }
      return metrics;
   }

   public ModelMetrics getMetrics() {
      return modelMetrics;
   }

   public ModularizationModel getModel() {
      return model;
   }

   public void setModel(final ModularizationModel model) {
      this.model = model;
   }

   @Override
   public String toString() {
      return getMetrics().toString();
   }
}
