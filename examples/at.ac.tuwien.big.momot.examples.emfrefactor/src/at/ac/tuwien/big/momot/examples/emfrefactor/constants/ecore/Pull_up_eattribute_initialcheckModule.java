package at.ac.tuwien.big.momot.examples.emfrefactor.constants.ecore;

public interface Pull_up_eattribute_initialcheckModule {
   public static interface Check_superEClass {
      static interface Parameter {
         String SELECTED_E_ATTRIBUTE = Check_superEClass.NAME + Pull_up_eattribute_initialcheckModule.SEPARATOR
               + "selectedEAttribute";
      }

      static String NAME = Pull_up_eattribute_initialcheckModule.MODULE
            + Pull_up_eattribute_initialcheckModule.SEPARATOR + "check_superEClass";
   }

   public static interface MainUnit {
      static interface Parameter {
         String SELECTED_E_OBJECT = MainUnit.NAME + Pull_up_eattribute_initialcheckModule.SEPARATOR + "selectedEObject";
         String E_CLASS_NAME = MainUnit.NAME + Pull_up_eattribute_initialcheckModule.SEPARATOR + "eClassName";
      }

      static String NAME = Pull_up_eattribute_initialcheckModule.MODULE
            + Pull_up_eattribute_initialcheckModule.SEPARATOR + "mainUnit";
   }

   static String SEPARATOR = "::";
   static String FILE_NAME = "pull_up_eattribute_initialcheck";

   static String MODULE_NAME = "transformation system";

   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;

}
