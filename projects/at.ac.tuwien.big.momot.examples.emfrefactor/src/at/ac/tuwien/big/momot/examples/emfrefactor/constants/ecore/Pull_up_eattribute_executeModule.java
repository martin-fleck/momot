package at.ac.tuwien.big.momot.examples.emfrefactor.constants.ecore;

public interface Pull_up_eattribute_executeModule {
   static String SEPARATOR = "::";
   static String FILE_NAME = "pull_up_eattribute_execute";
   static String MODULE_NAME = "transformation system";
   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;

   public static interface Remove_equivalent {
      static String NAME = Pull_up_eattribute_executeModule.MODULE + Pull_up_eattribute_executeModule.SEPARATOR + "remove_equivalent";
      static interface Parameter {
         String SELECTED_E_ATTRIBUTE = Remove_equivalent.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "selectedEAttribute";
         String SUPER_E_CLASS = Remove_equivalent.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "superEClass";
         String E_ATTRIBUTE_NAME = Remove_equivalent.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "eAttributeName";
      }
   }

   public static interface Pull_up {
      static String NAME = Pull_up_eattribute_executeModule.MODULE + Pull_up_eattribute_executeModule.SEPARATOR + "pull_up";
      static interface Parameter {
         String SELECTED_E_ATTRIBUTE = Pull_up.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "selectedEAttribute";
         String SUPER_E_CLASS = Pull_up.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "superEClass";
      }
   }

   public static interface MainUnit {
      static String NAME = Pull_up_eattribute_executeModule.MODULE + Pull_up_eattribute_executeModule.SEPARATOR + "mainUnit";
      static interface Parameter {
         String SELECTED_E_OBJECT = MainUnit.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "selectedEObject";
         String E_CLASS_NAME = MainUnit.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "eClassName";
      }
   }

   public static interface Remove_equivalents {
      static String NAME = Pull_up_eattribute_executeModule.MODULE + Pull_up_eattribute_executeModule.SEPARATOR + "remove_equivalents";
      static interface Parameter {
         String SELECTED_E_ATTRIBUTE = Remove_equivalents.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "selectedEAttribute";
         String SUPER_E_CLASS = Remove_equivalents.NAME + Pull_up_eattribute_executeModule.SEPARATOR + "superEClass";
      }
   }

}
