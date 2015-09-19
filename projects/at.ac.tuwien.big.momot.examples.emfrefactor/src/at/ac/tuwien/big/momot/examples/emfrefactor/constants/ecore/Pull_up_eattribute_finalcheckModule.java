package at.ac.tuwien.big.momot.examples.emfrefactor.constants.ecore;

public interface Pull_up_eattribute_finalcheckModule {
   static String SEPARATOR = "::";
   static String FILE_NAME = "pull_up_eattribute_finalcheck";
   static String MODULE_NAME = "transformation system";
   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;

   public static interface Check_input {
      static String NAME = Pull_up_eattribute_finalcheckModule.MODULE + Pull_up_eattribute_finalcheckModule.SEPARATOR + "check_input";
      static interface Parameter {
         String SELECTED_E_ATTRIBUTE = Check_input.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "selectedEAttribute";
         String SUPER_E_CLASS = Check_input.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "superEClass";
      }
   }

   public static interface Check_equivalents {
      static String NAME = Pull_up_eattribute_finalcheckModule.MODULE + Pull_up_eattribute_finalcheckModule.SEPARATOR + "check_equivalents";
      static interface Parameter {
         String SELECTED_E_ATTRIBUTE = Check_equivalents.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "selectedEAttribute";
         String E_ATTRIBUTE_NAME = Check_equivalents.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "eAttributeName";
         String E_ATTRIBUTE_ID = Check_equivalents.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "eAttributeId";
         String SUPER_E_CLASS = Check_equivalents.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "superEClass";
      }
   }

   public static interface MainUnit {
      static String NAME = Pull_up_eattribute_finalcheckModule.MODULE + Pull_up_eattribute_finalcheckModule.SEPARATOR + "mainUnit";
      static interface Parameter {
         String SELECTED_E_OBJECT = MainUnit.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "selectedEObject";
         String E_CLASS_NAME = MainUnit.NAME + Pull_up_eattribute_finalcheckModule.SEPARATOR + "eClassName";
      }
   }

}
