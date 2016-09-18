package at.ac.tuwien.big.momot.examples.tse.momot.henshin;
public interface ModularizationModule {
   static String SEPARATOR = "::";
   static String FILE_NAME = "modularization_rules";
   static String MODULE_NAME = "";
   static String MODULE = FILE_NAME;

   public static interface CreateModule {
      static String NAME = ModularizationModule.MODULE + ModularizationModule.SEPARATOR + "createModule";
      static interface Parameter {
         String NAME = CreateModule.NAME + ModularizationModule.SEPARATOR + "name";
      }
   }

   public static interface ReassignRule {
      static String NAME = ModularizationModule.MODULE + ModularizationModule.SEPARATOR + "reassignRule";
      static interface Parameter {
         String SOURCE = ReassignRule.NAME + ModularizationModule.SEPARATOR + "source";
         String TARGET = ReassignRule.NAME + ModularizationModule.SEPARATOR + "target";
         String RULE = ReassignRule.NAME + ModularizationModule.SEPARATOR + "rule";
      }
   }

   public static interface AssignRule {
      static String NAME = ModularizationModule.MODULE + ModularizationModule.SEPARATOR + "assignRule";
      static interface Parameter {
         String MODULE = AssignRule.NAME + ModularizationModule.SEPARATOR + "module";
         String RULE = AssignRule.NAME + ModularizationModule.SEPARATOR + "rule";
      }
   }

   public static interface ReassignHelper {
      static String NAME = ModularizationModule.MODULE + ModularizationModule.SEPARATOR + "reassignHelper";
      static interface Parameter {
         String SOURCE = ReassignHelper.NAME + ModularizationModule.SEPARATOR + "source";
         String TARGET = ReassignHelper.NAME + ModularizationModule.SEPARATOR + "target";
         String HELPER = ReassignHelper.NAME + ModularizationModule.SEPARATOR + "helper";
      }
   }

   public static interface AssignHelper {
      static String NAME = ModularizationModule.MODULE + ModularizationModule.SEPARATOR + "assignHelper";
      static interface Parameter {
         String MODULE = AssignHelper.NAME + ModularizationModule.SEPARATOR + "module";
         String HELPER = AssignHelper.NAME + ModularizationModule.SEPARATOR + "helper";
      }
   }

   public static interface DistributeRule {
      static String NAME = ModularizationModule.MODULE + ModularizationModule.SEPARATOR + "distributeRule";
      static interface Parameter {
         String SOURCE = DistributeRule.NAME + ModularizationModule.SEPARATOR + "source";
         String RULE = DistributeRule.NAME + ModularizationModule.SEPARATOR + "rule";
         String TARGET = DistributeRule.NAME + ModularizationModule.SEPARATOR + "target";
      }
   }

   public static interface DistributeHelper {
      static String NAME = ModularizationModule.MODULE + ModularizationModule.SEPARATOR + "distributeHelper";
      static interface Parameter {
         String SOURCE = DistributeHelper.NAME + ModularizationModule.SEPARATOR + "source";
         String HELPER = DistributeHelper.NAME + ModularizationModule.SEPARATOR + "helper";
         String TARGET = DistributeHelper.NAME + ModularizationModule.SEPARATOR + "target";
      }
   }

}
