package at.ac.tuwien.big.momot.examples.modularization.jsme;

public interface ModularizationRules {
   public static interface AssignClass {
      static interface Parameter {
         String MODULE = AssignClass.NAME + ModularizationRules.SEPARATOR + "module";
         String CLASS = AssignClass.NAME + ModularizationRules.SEPARATOR + "class";
      }

      static String NAME = ModularizationRules.MODULE + ModularizationRules.SEPARATOR + "assignClass";
   }

   public static interface CreateModule {
      static interface Parameter {
         String MODULE_NAME = CreateModule.NAME + ModularizationRules.SEPARATOR + "moduleName";
      }

      static String NAME = ModularizationRules.MODULE + ModularizationRules.SEPARATOR + "createModule";
   }

   static String SEPARATOR = "::";
   static String FILE_NAME = "modularization_jsep";

   static String MODULE_NAME = "";

   static String MODULE = FILE_NAME;

}
