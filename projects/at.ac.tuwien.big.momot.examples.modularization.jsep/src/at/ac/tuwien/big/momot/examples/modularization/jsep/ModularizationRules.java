package at.ac.tuwien.big.momot.examples.modularization.jsep;

public interface ModularizationRules {
   static String SEPARATOR = "::";
   static String FILE_NAME = "modularization_jsep";
   static String MODULE_NAME = "";
   static String MODULE = FILE_NAME;

   public static interface CreateModule {
      static String NAME = ModularizationRules.MODULE + ModularizationRules.SEPARATOR + "createModule";
      static interface Parameter {
         String MODULE_NAME = CreateModule.NAME + ModularizationRules.SEPARATOR + "moduleName";
      }
   }

   public static interface AssignClass {
      static String NAME = ModularizationRules.MODULE + ModularizationRules.SEPARATOR + "assignClass";
      static interface Parameter {
         String MODULE = AssignClass.NAME + ModularizationRules.SEPARATOR + "module";
         String CLASS = AssignClass.NAME + ModularizationRules.SEPARATOR + "class";
      }
   }

}
