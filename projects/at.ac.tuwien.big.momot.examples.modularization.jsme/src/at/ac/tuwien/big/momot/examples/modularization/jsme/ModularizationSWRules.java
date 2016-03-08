package at.ac.tuwien.big.momot.examples.modularization.jsme;

public interface ModularizationSWRules {
	   static String SEPARATOR = "::";
	   static String FILE_NAME = "modularization_sw";
	   static String MODULE_NAME = "ModularizationRules";
	   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;

	   public static interface CreateClass {
	      static String NAME = ModularizationSWRules.MODULE + ModularizationSWRules.SEPARATOR + "createClass";
	      static interface Parameter {
	         String CLASS_NAME = CreateClass.NAME + ModularizationSWRules.SEPARATOR + "className";
	      }
	   }

	   public static interface AssignFeature {
	      static String NAME = ModularizationSWRules.MODULE + ModularizationSWRules.SEPARATOR + "assignFeature";
	      static interface Parameter {
	         String FEATURE = AssignFeature.NAME + ModularizationSWRules.SEPARATOR + "feature";
	         String CLASS = AssignFeature.NAME + ModularizationSWRules.SEPARATOR + "class";
	      }
	   }

	   public static interface ReassignFeature {
	      static String NAME = ModularizationSWRules.MODULE + ModularizationSWRules.SEPARATOR + "reassignFeature";
	      static interface Parameter {
	         String FEATURE = ReassignFeature.NAME + ModularizationSWRules.SEPARATOR + "feature";
	         String CLASS = ReassignFeature.NAME + ModularizationSWRules.SEPARATOR + "class";
	      }
	   }
}
