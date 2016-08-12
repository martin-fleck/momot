package at.ac.tuwien.big.momot.examples.ecore.fitness.metric;

import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Module;

public class LanguageMetrics extends Metrics {
   private static final long serialVersionUID = -8382677736030566696L;

   protected Language language;
   protected int nrModules;
   protected int minModuleSize = Integer.MAX_VALUE;
   protected int maxModuleSize = Integer.MIN_VALUE;

   public LanguageMetrics() {}

   public LanguageMetrics(final Language language) {
      setLanguage(language);
   }

   protected void addNrModules(final int nrModules) {
      this.nrModules += nrModules;
   }

   public void considerModule(final Module module) {
      addNrModules(1);
      final int moduleSize = module.getEntities().size();
      if(moduleSize < minModuleSize) {
         minModuleSize = moduleSize;
      }
      if(moduleSize > maxModuleSize) {
         maxModuleSize = moduleSize;
      }
   }

   public Language getLanguage() {
      return language;
   }

   public int getMinMaxDiff() {
      return maxModuleSize - minModuleSize;
   }

   public int getNrModules() {
      return nrModules;
   }

   public void setLanguage(final Language language) {
      this.language = language;
   }

   protected void setNrModules(final int nrModules) {
      this.nrModules = nrModules;
   }

   @Override
   public String toString(final String indent) {
      final StringBuilder sb = new StringBuilder();
      sb.append(indent + "Language:           " + getLanguage().getName() + "\n");
      sb.append(indent + "Non-Empty Modules:  " + getNrModules() + "\n");
      sb.append(indent + "MinMaxDiff:         " + getMinMaxDiff() + "\n");
      sb.append(super.toString(indent));
      return sb.toString();
   }
}
