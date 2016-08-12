package at.ac.tuwien.big.momot.examples.modularization.jsme;

public interface ModularizationSWRules {
   public static interface AssignFeature {
      static interface Parameter {
         String FEATURE = AssignFeature.NAME + ModularizationSWRules.SEPARATOR + "feature";
         String CLASS = AssignFeature.NAME + ModularizationSWRules.SEPARATOR + "class";
      }

      static String NAME = ModularizationSWRules.MODULE + ModularizationSWRules.SEPARATOR + "assignFeature";
   }

   public static interface CreateClass {
      static interface Parameter {
         String CLASS_NAME = CreateClass.NAME + ModularizationSWRules.SEPARATOR + "className";
      }

      static String NAME = ModularizationSWRules.MODULE + ModularizationSWRules.SEPARATOR + "createClass";
   }

   public static interface ReassignFeature {
      static interface Parameter {
         String FEATURE = ReassignFeature.NAME + ModularizationSWRules.SEPARATOR + "feature";
         String CLASS = ReassignFeature.NAME + ModularizationSWRules.SEPARATOR + "class";
      }

      static String NAME = ModularizationSWRules.MODULE + ModularizationSWRules.SEPARATOR + "reassignFeature";
   }

   static String SEPARATOR = "::";

   static String FILE_NAME = "modularization_sw";

   static String MODULE_NAME = "ModularizationRules";

   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;
}
