public interface Remove_unused_interface_executeModule {
   static String MODULE = "";
   static String SEPARATOR = "::";

   public static interface MainUnit {
      static String NAME = "mainUnit";
      static interface Parameter {
         String SELECTED_E_OBJECT = NAME + SEPARATOR + "selectedEObject";
      }
   }

}
