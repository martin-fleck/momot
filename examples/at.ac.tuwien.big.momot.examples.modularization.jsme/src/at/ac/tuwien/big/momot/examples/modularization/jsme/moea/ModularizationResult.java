package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ModularizationResult implements Serializable {
   private static final long serialVersionUID = 5474239941163959024L;

   protected ModularizationInstance instance;
   protected Map<Integer, List<String>> modules = new HashMap<>();
   protected Map<String, Integer> classToModule = new HashMap<>();

   public ModularizationResult(final ModularizationInstance instance, final List<Integer> assignment) {
      this.instance = instance;
      setAssignment(assignment);
   }

   protected void assignClass(final String clazz, final Integer module) {
      List<String> moduleClasses = modules.get(module);
      if(moduleClasses == null) {
         moduleClasses = new ArrayList<>();
      }
      moduleClasses.add(clazz);
      classToModule.put(clazz, module);
      modules.put(module, moduleClasses);
   }

   public boolean dependedOnBy(final String source, final String target) {
      return getInstance().dependedOnBy(source, target);
   }

   public boolean dependsOn(final String source, final String target) {
      return getInstance().dependsOn(source, target);
   }

   public List<String> getClasses() {
      return getInstance().getClasses();
   }

   public List<String> getClasses(final Integer module) {
      return modules.get(module);
   }

   public Map<String, List<String>> getDependencies() {
      return getInstance().getDependencies();
   }

   public List<String> getDependencies(final String clazz) {
      return getInstance().getDependencies(clazz);
   }

   public ModularizationInstance getInstance() {
      return instance;
   }

   public Map<Integer, List<String>> getModuleMap() {
      return modules;
   }

   public Set<Integer> getModules() {
      return modules.keySet();
   }

   public boolean hasModule(final String clazz) {
      return classToModule.containsKey(clazz);
   }

   protected void setAssignment(final List<Integer> assignment) {
      this.modules.clear();

      if(assignment.size() != getClasses().size()) {
         throw new IllegalArgumentException("Not all classes are assigned to a module.");
      }

      for(int i = 0; i < assignment.size(); i++) {
         assignClass(getClasses().get(i), assignment.get(i));
      }
   }

   protected String toDependenciesString(final String clazz) {
      final StringBuilder sb = new StringBuilder();
      sb.append(" [ ");
      final List<String> dependencies = getDependencies(clazz);
      if(dependencies != null) {
         for(final String c : dependencies) {
            sb.append(c + " ");
         }
      }
      sb.append("]");
      return sb.toString();
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder();
      for(final Entry<Integer, List<String>> moduleClasses : getModuleMap().entrySet()) {
         sb.append("  Module 'M" + moduleClasses.getKey() + "':\n");
         for(final String clazz : moduleClasses.getValue()) {
            sb.append("    " + clazz + toDependenciesString(clazz) + "\n");
         }
      }
      sb.append("  Unassigned:\n");
      for(final String clazz : getClasses()) {
         if(!hasModule(clazz)) {
            sb.append("    " + clazz + toDependenciesString(clazz) + "\n");
         }
      }
      sb.append("}");
      return sb.toString();
   }
}
